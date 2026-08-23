package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzdk {
    boolean zzbdm;
    private String zzbef;
    private zzdi zzbeg;
    private zzdk zzbeh;
    private final List<zzdi> zzbed = new LinkedList();
    private final Map<String, String> zzbee = new LinkedHashMap();
    private final Object zzail = new Object();

    public zzdk(boolean z, String str, String str2) {
        this.zzbdm = z;
        this.zzbee.put("action", str);
        this.zzbee.put("ad_format", str2);
    }

    public boolean zza(zzdi zzdiVar, long j, String... strArr) {
        synchronized (this.zzail) {
            for (String str : strArr) {
                this.zzbed.add(new zzdi(j, str, zzdiVar));
            }
        }
        return true;
    }

    public boolean zza(@Nullable zzdi zzdiVar, String... strArr) {
        if (!this.zzbdm || zzdiVar == null) {
            return false;
        }
        return zza(zzdiVar, com.google.android.gms.ads.internal.zzu.zzfu().elapsedRealtime(), strArr);
    }

    public void zzas(String str) {
        if (this.zzbdm) {
            synchronized (this.zzail) {
                this.zzbef = str;
            }
        }
    }

    @Nullable
    public zzdi zzc(long j) {
        if (this.zzbdm) {
            return new zzdi(j, null, null);
        }
        return null;
    }

    public void zzc(zzdk zzdkVar) {
        synchronized (this.zzail) {
            this.zzbeh = zzdkVar;
        }
    }

    public void zzh(String str, String str2) {
        zzde zzdeVarZzsm;
        if (!this.zzbdm || TextUtils.isEmpty(str2) || (zzdeVarZzsm = com.google.android.gms.ads.internal.zzu.zzft().zzsm()) == null) {
            return;
        }
        synchronized (this.zzail) {
            zzdeVarZzsm.zzaq(str).zza(this.zzbee, str, str2);
        }
    }

    public zzdi zzkg() {
        return zzc(com.google.android.gms.ads.internal.zzu.zzfu().elapsedRealtime());
    }

    public void zzkh() {
        synchronized (this.zzail) {
            this.zzbeg = zzkg();
        }
    }

    public String zzki() {
        String string;
        StringBuilder sb = new StringBuilder();
        synchronized (this.zzail) {
            for (zzdi zzdiVar : this.zzbed) {
                long time = zzdiVar.getTime();
                String strZzkd = zzdiVar.zzkd();
                zzdi zzdiVarZzke = zzdiVar.zzke();
                if (zzdiVarZzke != null && time > 0) {
                    sb.append(strZzkd).append('.').append(time - zzdiVarZzke.getTime()).append(',');
                }
            }
            this.zzbed.clear();
            if (!TextUtils.isEmpty(this.zzbef)) {
                sb.append(this.zzbef);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            string = sb.toString();
        }
        return string;
    }

    public zzdi zzkj() {
        zzdi zzdiVar;
        synchronized (this.zzail) {
            zzdiVar = this.zzbeg;
        }
        return zzdiVar;
    }

    Map<String, String> zzm() {
        Map<String, String> mapZza;
        synchronized (this.zzail) {
            zzde zzdeVarZzsm = com.google.android.gms.ads.internal.zzu.zzft().zzsm();
            mapZza = (zzdeVarZzsm == null || this.zzbeh == null) ? this.zzbee : zzdeVarZzsm.zza(this.zzbee, this.zzbeh.zzm());
        }
        return mapZza;
    }
}
