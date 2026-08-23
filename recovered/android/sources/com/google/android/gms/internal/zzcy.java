package com.google.android.gms.internal;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzcy<T> {
    private final int zzaxm;
    private final String zzaxn;
    private final T zzaxo;

    private zzcy(int i, String str, T t) {
        this.zzaxm = i;
        this.zzaxn = str;
        this.zzaxo = t;
        com.google.android.gms.ads.internal.zzu.zzfy().zza(this);
    }

    public static zzcy<String> zza(int i, String str) {
        zzcy<String> zzcyVarZza = zza(i, str, (String) null);
        com.google.android.gms.ads.internal.zzu.zzfy().zzb(zzcyVarZza);
        return zzcyVarZza;
    }

    public static zzcy<Integer> zza(int i, String str, int i2) {
        return new zzcy<Integer>(i, str, Integer.valueOf(i2)) { // from class: com.google.android.gms.internal.zzcy.2
            @Override // com.google.android.gms.internal.zzcy
            /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
            public Integer zza(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(getKey(), zzjw().intValue()));
            }
        };
    }

    public static zzcy<Long> zza(int i, String str, long j) {
        return new zzcy<Long>(i, str, Long.valueOf(j)) { // from class: com.google.android.gms.internal.zzcy.3
            @Override // com.google.android.gms.internal.zzcy
            /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
            public Long zza(SharedPreferences sharedPreferences) {
                return Long.valueOf(sharedPreferences.getLong(getKey(), zzjw().longValue()));
            }
        };
    }

    public static zzcy<Boolean> zza(int i, String str, Boolean bool) {
        return new zzcy<Boolean>(i, str, bool) { // from class: com.google.android.gms.internal.zzcy.1
            @Override // com.google.android.gms.internal.zzcy
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Boolean zza(SharedPreferences sharedPreferences) {
                return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), zzjw().booleanValue()));
            }
        };
    }

    public static zzcy<String> zza(int i, String str, String str2) {
        return new zzcy<String>(i, str, str2) { // from class: com.google.android.gms.internal.zzcy.4
            @Override // com.google.android.gms.internal.zzcy
            /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
            public String zza(SharedPreferences sharedPreferences) {
                return sharedPreferences.getString(getKey(), zzjw());
            }
        };
    }

    public static zzcy<String> zzb(int i, String str) {
        zzcy<String> zzcyVarZza = zza(i, str, (String) null);
        com.google.android.gms.ads.internal.zzu.zzfy().zzc(zzcyVarZza);
        return zzcyVarZza;
    }

    public T get() {
        return (T) com.google.android.gms.ads.internal.zzu.zzfz().zzd(this);
    }

    public String getKey() {
        return this.zzaxn;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public T zzjw() {
        return this.zzaxo;
    }
}
