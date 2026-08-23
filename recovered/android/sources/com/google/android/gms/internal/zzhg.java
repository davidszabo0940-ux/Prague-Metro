package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0228R;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzhg extends zzhj {
    private final Context mContext;
    private final Map<String, String> zzbee;

    public zzhg(zzll zzllVar, Map<String, String> map) {
        super(zzllVar, "storePicture");
        this.zzbee = map;
        this.mContext = zzllVar.zzuf();
    }

    public void execute() {
        if (this.mContext == null) {
            zzbu("Activity context is not available");
            return;
        }
        if (!com.google.android.gms.ads.internal.zzu.zzfq().zzag(this.mContext).zzjr()) {
            zzbu("Feature is not supported by the device.");
            return;
        }
        final String str = this.zzbee.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzbu("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            String strValueOf = String.valueOf(str);
            zzbu(strValueOf.length() != 0 ? "Invalid image url: ".concat(strValueOf) : new String("Invalid image url: "));
            return;
        }
        final String strZzbt = zzbt(str);
        if (!com.google.android.gms.ads.internal.zzu.zzfq().zzcr(strZzbt)) {
            String strValueOf2 = String.valueOf(strZzbt);
            zzbu(strValueOf2.length() != 0 ? "Image type not recognized: ".concat(strValueOf2) : new String("Image type not recognized: "));
            return;
        }
        Resources resources = com.google.android.gms.ads.internal.zzu.zzft().getResources();
        AlertDialog.Builder builderZzaf = com.google.android.gms.ads.internal.zzu.zzfq().zzaf(this.mContext);
        builderZzaf.setTitle(resources != null ? resources.getString(C0228R.string.store_picture_title) : "Save image");
        builderZzaf.setMessage(resources != null ? resources.getString(C0228R.string.store_picture_message) : "Allow Ad to store image in Picture gallery?");
        builderZzaf.setPositiveButton(resources != null ? resources.getString(C0228R.string.accept) : "Accept", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.zzhg.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    ((DownloadManager) zzhg.this.mContext.getSystemService("download")).enqueue(zzhg.this.zzk(str, strZzbt));
                } catch (IllegalStateException e) {
                    zzhg.this.zzbu("Could not store picture.");
                }
            }
        });
        builderZzaf.setNegativeButton(resources != null ? resources.getString(C0228R.string.decline) : "Decline", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.zzhg.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                zzhg.this.zzbu("User canceled the download.");
            }
        });
        builderZzaf.create().show();
    }

    String zzbt(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    DownloadManager.Request zzk(String str, String str2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        com.google.android.gms.ads.internal.zzu.zzfs().zza(request);
        return request;
    }
}
