package com.google.android.gms.internal;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzkg implements zzkn<Future> {
    private volatile Thread zzcko;
    private boolean zzckp;
    private final Runnable zzw;

    public zzkg() {
        this.zzw = new Runnable() { // from class: com.google.android.gms.internal.zzkg.1
            @Override // java.lang.Runnable
            public final void run() {
                zzkg.this.zzcko = Thread.currentThread();
                zzkg.this.zzew();
            }
        };
        this.zzckp = false;
    }

    public zzkg(boolean z) {
        this.zzw = new Runnable() { // from class: com.google.android.gms.internal.zzkg.1
            @Override // java.lang.Runnable
            public final void run() {
                zzkg.this.zzcko = Thread.currentThread();
                zzkg.this.zzew();
            }
        };
        this.zzckp = z;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void cancel() {
        onStop();
        if (this.zzcko != null) {
            this.zzcko.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzew();

    @Override // com.google.android.gms.internal.zzkn
    /* JADX INFO: renamed from: zzta, reason: merged with bridge method [inline-methods] */
    public final Future zzpz() {
        return this.zzckp ? zzkk.zza(1, this.zzw) : zzkk.zza(this.zzw);
    }
}
