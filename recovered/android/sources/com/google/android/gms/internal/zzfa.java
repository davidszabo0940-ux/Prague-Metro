package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzfa implements zzet {
    private final com.google.android.gms.ads.internal.zze zzbix;
    private final zzhe zzbiy;
    private final zzev zzbja;

    public static class zza {
        private final zzll zzbgj;

        public zza(zzll zzllVar) {
            this.zzbgj = zzllVar;
        }

        public Intent zza(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public ResolveInfo zza(Context context, Intent intent) {
            return zza(context, intent, new ArrayList<>());
        }

        public ResolveInfo zza(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            ResolveInfo resolveInfo;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
            if (listQueryIntentActivities == null || resolveInfoResolveActivity == null) {
                resolveInfo = null;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= listQueryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo2 = listQueryIntentActivities.get(i2);
                    if (resolveInfoResolveActivity == null || !resolveInfoResolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        i = i2 + 1;
                    } else {
                        resolveInfo = resolveInfoResolveActivity;
                    }
                }
                resolveInfo = null;
            }
            arrayList.addAll(listQueryIntentActivities);
            return resolveInfo;
        }

        public Intent zzc(Context context, Map<String, String> map) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
            ResolveInfo resolveInfoZza;
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String strZza = map.get("u");
            if (TextUtils.isEmpty(strZza)) {
                return null;
            }
            if (this.zzbgj != null) {
                strZza = com.google.android.gms.ads.internal.zzu.zzfq().zza(this.zzbgj, strZza);
            }
            Uri uri = Uri.parse(strZza);
            boolean z = Boolean.parseBoolean(map.get("use_first_package"));
            boolean z2 = Boolean.parseBoolean(map.get("use_running_process"));
            Uri uriBuild = "http".equalsIgnoreCase(uri.getScheme()) ? uri.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(uri.getScheme()) ? uri.buildUpon().scheme("http").build() : null;
            ArrayList<ResolveInfo> arrayList = new ArrayList<>();
            Intent intentZze = zze(uri);
            Intent intentZze2 = zze(uriBuild);
            ResolveInfo resolveInfoZza2 = zza(context, intentZze, arrayList);
            if (resolveInfoZza2 != null) {
                return zza(intentZze, resolveInfoZza2);
            }
            if (intentZze2 != null && (resolveInfoZza = zza(context, intentZze2)) != null) {
                Intent intentZza = zza(intentZze, resolveInfoZza);
                if (zza(context, intentZza) != null) {
                    return intentZza;
                }
            }
            if (arrayList.size() == 0) {
                return intentZze;
            }
            if (z2 && activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                for (ResolveInfo resolveInfo : arrayList) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (it.hasNext()) {
                        if (it.next().processName.equals(resolveInfo.activityInfo.packageName)) {
                            return zza(intentZze, resolveInfo);
                        }
                    }
                }
            }
            return z ? zza(intentZze, arrayList.get(0)) : intentZze;
        }

        public Intent zze(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }
    }

    public zzfa(zzev zzevVar, com.google.android.gms.ads.internal.zze zzeVar, zzhe zzheVar) {
        this.zzbja = zzevVar;
        this.zzbix = zzeVar;
        this.zzbiy = zzheVar;
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzu.zzfs().zztl();
            }
            if ("l".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzu.zzfs().zztk();
            }
            if ("c".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzu.zzfs().zztm();
            }
        }
        return -1;
    }

    private static void zze(zzll zzllVar, Map<String, String> map) {
        Context context = zzllVar.getContext();
        if (TextUtils.isEmpty(map.get("u"))) {
            zzkh.zzcy("Destination url cannot be empty.");
            return;
        }
        try {
            zzllVar.zzuk().zza(new AdLauncherIntentInfoParcel(new zza(zzllVar).zzc(context, map)));
        } catch (ActivityNotFoundException e) {
            zzkh.zzcy(e.getMessage());
        }
    }

    private void zzr(boolean z) {
        if (this.zzbiy != null) {
            this.zzbiy.zzs(z);
        }
    }

    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        String str = map.get("a");
        if (str == null) {
            zzkh.zzcy("Action missing from an open GMSG.");
            return;
        }
        if (this.zzbix != null && !this.zzbix.zzem()) {
            this.zzbix.zzt(map.get("u"));
            return;
        }
        zzlm zzlmVarZzuk = zzllVar.zzuk();
        if ("expand".equalsIgnoreCase(str)) {
            if (zzllVar.zzuo()) {
                zzkh.zzcy("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzr(false);
                zzlmVarZzuk.zza(zzc(map), zzd(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str)) {
            String str2 = map.get("u");
            zzr(false);
            if (str2 != null) {
                zzlmVarZzuk.zza(zzc(map), zzd(map), str2);
                return;
            } else {
                zzlmVarZzuk.zza(zzc(map), zzd(map), map.get("html"), map.get("baseurl"));
                return;
            }
        }
        if (!"in_app_purchase".equalsIgnoreCase(str)) {
            if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase(map.get("system_browser"))) {
                zzr(true);
                zze(zzllVar, map);
                return;
            } else {
                zzr(true);
                String str3 = map.get("u");
                zzlmVarZzuk.zza(new AdLauncherIntentInfoParcel(map.get("i"), !TextUtils.isEmpty(str3) ? com.google.android.gms.ads.internal.zzu.zzfq().zza(zzllVar, str3) : str3, map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
                return;
            }
        }
        String str4 = map.get("product_id");
        String str5 = map.get("report_urls");
        if (this.zzbja != null) {
            if (str5 == null || str5.isEmpty()) {
                this.zzbja.zza(str4, new ArrayList<>());
            } else {
                this.zzbja.zza(str4, new ArrayList<>(Arrays.asList(str5.split(" "))));
            }
        }
    }
}
