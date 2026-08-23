package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public interface zzle<T> {

    public interface zza {
        void run();
    }

    public static class zzb implements zza {
        @Override // com.google.android.gms.internal.zzle.zza
        public void run() {
        }
    }

    public interface zzc<T> {
        void zzd(T t);
    }

    void zza(zzc<T> zzcVar, zza zzaVar);

    void zzg(T t);
}
