package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzla<T> implements zzlc<T> {
    private final T zzcnr;
    private final zzld zzcnt = new zzld();

    public zzla(T t) {
        this.zzcnr = t;
        this.zzcnt.zzua();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        return this.zzcnr;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        return this.zzcnr;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzlc
    public void zzb(Runnable runnable) {
        this.zzcnt.zzb(runnable);
    }
}
