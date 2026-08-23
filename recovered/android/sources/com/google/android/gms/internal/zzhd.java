package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.C0228R;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzhd extends zzhj {
    private final Context mContext;
    private final Map<String, String> zzbee;
    private String zzbqc;
    private long zzbqd;
    private long zzbqe;
    private String zzbqf;
    private String zzbqg;

    public zzhd(zzll zzllVar, Map<String, String> map) {
        super(zzllVar, "createCalendarEvent");
        this.zzbee = map;
        this.mContext = zzllVar.zzuf();
        zzmv();
    }

    private String zzbr(String str) {
        return TextUtils.isEmpty(this.zzbee.get(str)) ? "" : this.zzbee.get(str);
    }

    private long zzbs(String str) {
        String str2 = this.zzbee.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    private void zzmv() {
        this.zzbqc = zzbr("description");
        this.zzbqf = zzbr("summary");
        this.zzbqd = zzbs("start_ticks");
        this.zzbqe = zzbs("end_ticks");
        this.zzbqg = zzbr("location");
    }

    @TargetApi(14)
    Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzbqc);
        data.putExtra("eventLocation", this.zzbqg);
        data.putExtra("description", this.zzbqf);
        if (this.zzbqd > -1) {
            data.putExtra("beginTime", this.zzbqd);
        }
        if (this.zzbqe > -1) {
            data.putExtra("endTime", this.zzbqe);
        }
        data.setFlags(268435456);
        return data;
    }

    public void execute() {
        if (this.mContext == null) {
            zzbu("Activity context is not available.");
            return;
        }
        if (!com.google.android.gms.ads.internal.zzu.zzfq().zzag(this.mContext).zzju()) {
            zzbu("This feature is not available on the device.");
            return;
        }
        AlertDialog.Builder builderZzaf = com.google.android.gms.ads.internal.zzu.zzfq().zzaf(this.mContext);
        Resources resources = com.google.android.gms.ads.internal.zzu.zzft().getResources();
        builderZzaf.setTitle(resources != null ? resources.getString(C0228R.string.create_calendar_title) : "Create calendar event");
        builderZzaf.setMessage(resources != null ? resources.getString(C0228R.string.create_calendar_message) : "Allow Ad to create a calendar event?");
        builderZzaf.setPositiveButton(resources != null ? resources.getString(C0228R.string.accept) : "Accept", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.zzhd.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.google.android.gms.ads.internal.zzu.zzfq().zzb(zzhd.this.mContext, zzhd.this.createIntent());
            }
        });
        builderZzaf.setNegativeButton(resources != null ? resources.getString(C0228R.string.decline) : "Decline", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.zzhd.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                zzhd.this.zzbu("Operation denied by user.");
            }
        });
        builderZzaf.create().show();
    }
}
