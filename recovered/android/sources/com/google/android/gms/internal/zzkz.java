package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzkz<T> implements zzlc<T> {
    private boolean zzbpb;
    private T zzcnr;
    private boolean zzcns;
    private final Object zzail = new Object();
    private final zzld zzcnt = new zzld();

    private boolean zztz() {
        return 0 != 0 || this.zzcns;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean z2 = false;
        if (z) {
            synchronized (this.zzail) {
                if (!zztz()) {
                    this.zzbpb = true;
                    this.zzcns = true;
                    this.zzail.notifyAll();
                    this.zzcnt.zzua();
                    z2 = true;
                }
            }
        }
        return z2;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, CancellationException, InterruptedException {
        T t;
        synchronized (this.zzail) {
            if (!zztz()) {
                try {
                    this.zzail.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.zzbpb) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.zzcnr;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, CancellationException, InterruptedException, TimeoutException {
        T t;
        synchronized (this.zzail) {
            if (!zztz()) {
                try {
                    long millis = timeUnit.toMillis(j);
                    if (millis != 0) {
                        this.zzail.wait(millis);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (!this.zzcns) {
                throw new TimeoutException("CallbackFuture timed out.");
            }
            if (this.zzbpb) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.zzcnr;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzbpb;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean zZztz;
        synchronized (this.zzail) {
            zZztz = zztz();
        }
        return zZztz;
    }

    @Override // com.google.android.gms.internal.zzlc
    public void zzb(Runnable runnable) {
        this.zzcnt.zzb(runnable);
    }

    public void zzc(Runnable runnable) {
        this.zzcnt.zzc(runnable);
    }

    public void zzi(T t) {
        synchronized (this.zzail) {
            if (this.zzbpb) {
                return;
            }
            if (zztz()) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            }
            this.zzcns = true;
            this.zzcnr = t;
            this.zzail.notifyAll();
            this.zzcnt.zzua();
        }
    }
}
