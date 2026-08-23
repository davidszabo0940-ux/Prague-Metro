package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzdd {
    private Context mContext;
    private String zzarh;
    private boolean zzbdm = zzdc.zzazc.get().booleanValue();
    private String zzbdn = zzdc.zzazd.get();
    private Map<String, String> zzbdo = new LinkedHashMap();

    public zzdd(Context context, String str) {
        this.mContext = null;
        this.zzarh = null;
        this.mContext = context;
        this.zzarh = str;
        this.zzbdo.put("s", "gmob_sdk");
        this.zzbdo.put("v", "3");
        this.zzbdo.put("os", Build.VERSION.RELEASE);
        this.zzbdo.put("sdk", Build.VERSION.SDK);
        this.zzbdo.put("device", com.google.android.gms.ads.internal.zzu.zzfq().zzth());
        this.zzbdo.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        this.zzbdo.put("is_lite_sdk", com.google.android.gms.ads.internal.zzu.zzfq().zzan(context) ? "1" : "0");
        zziz zzizVarZzy = com.google.android.gms.ads.internal.zzu.zzfw().zzy(this.mContext);
        this.zzbdo.put("network_coarse", Integer.toString(zzizVarZzy.zzcgt));
        this.zzbdo.put("network_fine", Integer.toString(zzizVarZzy.zzcgu));
    }

    Context getContext() {
        return this.mContext;
    }

    String zzhl() {
        return this.zzarh;
    }

    boolean zzjz() {
        return this.zzbdm;
    }

    String zzka() {
        return this.zzbdn;
    }

    Map<String, String> zzkb() {
        return this.zzbdo;
    }
}
