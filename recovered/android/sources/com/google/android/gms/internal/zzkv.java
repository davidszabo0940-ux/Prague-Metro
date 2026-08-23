package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzkv {
    private long zzcmw;
    private long zzcmx = Long.MIN_VALUE;
    private Object zzail = new Object();

    public zzkv(long j) {
        this.zzcmw = j;
    }

    public boolean tryAcquire() {
        boolean z;
        synchronized (this.zzail) {
            long jElapsedRealtime = com.google.android.gms.ads.internal.zzu.zzfu().elapsedRealtime();
            if (this.zzcmx + this.zzcmw > jElapsedRealtime) {
                z = false;
            } else {
                this.zzcmx = jElapsedRealtime;
                z = true;
            }
        }
        return z;
    }
}
