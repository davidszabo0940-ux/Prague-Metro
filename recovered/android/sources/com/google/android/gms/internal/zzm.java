package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public class zzm<T> {
    public final T result;
    public final com.google.android.gms.internal.zzb.zza zzbf;
    public final zzr zzbg;
    public boolean zzbh;

    public interface zza {
        void zze(zzr zzrVar);
    }

    public interface zzb<T> {
        void zzb(T t);
    }

    private zzm(zzr zzrVar) {
        this.zzbh = false;
        this.result = null;
        this.zzbf = null;
        this.zzbg = zzrVar;
    }

    private zzm(T t, com.google.android.gms.internal.zzb.zza zzaVar) {
        this.zzbh = false;
        this.result = t;
        this.zzbf = zzaVar;
        this.zzbg = null;
    }

    public static <T> zzm<T> zza(T t, com.google.android.gms.internal.zzb.zza zzaVar) {
        return new zzm<>(t, zzaVar);
    }

    public static <T> zzm<T> zzd(zzr zzrVar) {
        return new zzm<>(zzrVar);
    }

    public boolean isSuccess() {
        return this.zzbg == null;
    }
}
