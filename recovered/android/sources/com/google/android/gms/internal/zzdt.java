package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzdt {
    private static final Object zzamp = new Object();
    private static AtomicInteger zzbeu = new AtomicInteger();
    private static zzdt zzbev;

    protected zzdt() {
    }

    public static zzdt zzkq() {
        zzdt zzdtVar;
        synchronized (zzamp) {
            if (zzbev == null) {
                zzbev = new zzdt();
            }
            zzdtVar = zzbev;
        }
        return zzdtVar;
    }

    protected DownloadManager.Request zza(Context context, DownloadManager.Request request, String str) {
        String strValueOf = String.valueOf(Environment.getExternalStorageDirectory().toString());
        String strValueOf2 = String.valueOf("/directappinstall/");
        request.setDestinationInExternalFilesDir(context, strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf), str).setVisibleInDownloadsUi(true).setAllowedNetworkTypes(3);
        return com.google.android.gms.common.util.zzs.zzavj() ? request.setNotificationVisibility(1) : request.setShowRunningNotification(true);
    }

    public void zza(Context context, Map<String, String> map) {
        String str = map.get("url");
        String str2 = map.get("package_name");
        if (TextUtils.isEmpty(str)) {
            zzkh.m14e("Download URL provided by creative is null or empty.");
            return;
        }
        try {
            DownloadManager.Request requestZza = zza(context, new DownloadManager.Request(Uri.parse(str)), str2);
            String str3 = map.get("tracking_url");
            zzkh.zzcw(new StringBuilder(String.valueOf(str2).length() + 32 + String.valueOf(str).length()).append("Start downloading package ").append(str2).append(" from ").append(str).toString());
            zzds.zza(context, com.google.android.gms.common.util.zzh.zzavi()).zza(((DownloadManager) context.getSystemService("download")).enqueue(requestZza), str2, str3);
        } catch (IllegalArgumentException e) {
            zzkh.zzb("Download URL is not a valid HTTP/HTTPS URI. Abort downloading task.", e);
        }
    }

    public String zzb(Context context, Map<String, String> map) {
        String str = map.get("package_name");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 1);
            String str2 = map.get("app_version");
            if (TextUtils.isEmpty(str2)) {
                zzkh.m14e("No app version provided by creative.");
                str = "installed_unknown_version";
            } else {
                try {
                    if (Integer.parseInt(str2) > packageInfo.versionCode) {
                        zzkh.zzcw(new StringBuilder(String.valueOf(str).length() + 34).append("App ").append(str).append(" installed but need an update.").toString());
                        str = "installed_older_version";
                    } else {
                        zzkh.zzcw(new StringBuilder(String.valueOf(str).length() + 52).append("App ").append(str).append(" already installed with current / newer version.").toString());
                        str = "installed_given_version";
                    }
                } catch (NumberFormatException e) {
                    zzkh.m14e("Malformated app version is provided by creative.");
                    str = "installed_unknown_version";
                }
            }
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            zzkh.zzcw(new StringBuilder(String.valueOf(str).length() + 19).append("App ").append(str).append(" not installed.").toString());
            return "not_installed";
        }
    }

    public void zzd(Context context, @NonNull String str) {
        String strValueOf = String.valueOf(str);
        zzkh.zzcw(strValueOf.length() != 0 ? "Deleting downloaded file: ".concat(strValueOf) : new String("Deleting downloaded file: "));
        File file = new File(str);
        if (file.exists()) {
            file.delete();
            if (file.exists()) {
                String strValueOf2 = String.valueOf(str);
                zzkh.zzcw(strValueOf2.length() != 0 ? "Error deleting file: ".concat(strValueOf2) : new String("Error deleting file: "));
            } else {
                String strValueOf3 = String.valueOf(str);
                zzkh.zzcw(strValueOf3.length() != 0 ? "File deleted successfully from path: ".concat(strValueOf3) : new String("File deleted successfully from path: "));
            }
        } else {
            zzkh.zzcw(new StringBuilder(String.valueOf(str).length() + 21).append("File: ").append(str).append(" doesn't exist!").toString());
        }
        zzds.zza(context, com.google.android.gms.common.util.zzh.zzavi()).zzat(str);
    }
}
