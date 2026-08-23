package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzhr;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzd extends zzhr.zza {
    private Context mContext;
    private String zzarh;
    private String zzbxc;
    private ArrayList<String> zzbxd;

    public zzd(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.zzbxc = str;
        this.zzbxd = arrayList;
        this.zzarh = str2;
        this.mContext = context;
    }

    @Override // com.google.android.gms.internal.zzhr
    public String getProductId() {
        return this.zzbxc;
    }

    @Override // com.google.android.gms.internal.zzhr
    public void recordPlayBillingResolution(int i) {
        if (i == 0) {
            zzpt();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("google_play_status", String.valueOf(i));
        map.put("sku", this.zzbxc);
        map.put("status", String.valueOf(zzai(i)));
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.zzbxd.iterator();
        while (it.hasNext()) {
            linkedList.add(zza(it.next(), map));
        }
        zzu.zzfq().zza(this.mContext, this.zzarh, linkedList);
    }

    @Override // com.google.android.gms.internal.zzhr
    public void recordResolution(int i) {
        if (i == 1) {
            zzpt();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("status", String.valueOf(i));
        map.put("sku", this.zzbxc);
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.zzbxd.iterator();
        while (it.hasNext()) {
            linkedList.add(zza(it.next(), map));
        }
        zzu.zzfq().zza(this.mContext, this.zzarh, linkedList);
    }

    protected String zza(String str, HashMap<String, String> map) {
        String str2;
        String packageName = this.mContext.getPackageName();
        try {
            str2 = this.mContext.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            zzkh.zzd("Error to retrieve app version", e);
            str2 = "";
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - zzu.zzft().zzsl().zzsy();
        for (String str3 : map.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", str3), String.format("$1%s$2", map.get(str3)));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "sessionid"), String.format("$1%s$2", Uri.encode(zzu.zzft().getSessionId()))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "appid"), String.format("$1%s$2", Uri.encode(packageName))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "osversion"), String.format("$1%s$2", Uri.encode(String.valueOf(Build.VERSION.SDK_INT)))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "sdkversion"), String.format("$1%s$2", Uri.encode(this.zzarh))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "appversion"), String.format("$1%s$2", Uri.encode(str2))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "timestamp"), String.format("$1%s$2", Uri.encode(String.valueOf(jElapsedRealtime)))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "[^@]+"), String.format("$1%s$2", "")).replaceAll("@@", "@");
    }

    protected int zzai(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        return i == 4 ? 3 : 0;
    }

    void zzpt() {
        try {
            this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", Context.class, String.class, String.class, Boolean.TYPE).invoke(null, this.mContext, this.zzbxc, "", true);
        } catch (ClassNotFoundException e) {
            zzkh.zzcy("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            zzkh.zzcy("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Exception e3) {
            zzkh.zzd("Fail to report a conversion.", e3);
        }
    }
}
