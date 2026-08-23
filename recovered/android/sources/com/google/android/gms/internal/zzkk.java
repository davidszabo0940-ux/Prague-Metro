package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzkk {
    private static final ExecutorService zzcky = Executors.newFixedThreadPool(10, zzco("Default"));
    private static final ExecutorService zzckz = Executors.newFixedThreadPool(5, zzco("Loader"));

    public static zzlc<Void> zza(int i, final Runnable runnable) {
        return i == 1 ? zza(zzckz, new Callable<Void>() { // from class: com.google.android.gms.internal.zzkk.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: zzcy, reason: merged with bridge method [inline-methods] */
            public Void call() {
                runnable.run();
                return null;
            }
        }) : zza(zzcky, new Callable<Void>() { // from class: com.google.android.gms.internal.zzkk.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: zzcy, reason: merged with bridge method [inline-methods] */
            public Void call() {
                runnable.run();
                return null;
            }
        });
    }

    public static zzlc<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zzlc<T> zza(Callable<T> callable) {
        return zza(zzcky, callable);
    }

    public static <T> zzlc<T> zza(ExecutorService executorService, final Callable<T> callable) {
        final zzkz zzkzVar = new zzkz();
        try {
            final Future<?> futureSubmit = executorService.submit(new Runnable() { // from class: com.google.android.gms.internal.zzkk.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Process.setThreadPriority(10);
                        zzkzVar.zzi(callable.call());
                    } catch (Exception e) {
                        com.google.android.gms.ads.internal.zzu.zzft().zzb((Throwable) e, true);
                        zzkzVar.cancel(true);
                    }
                }
            });
            zzkzVar.zzc(new Runnable() { // from class: com.google.android.gms.internal.zzkk.4
                @Override // java.lang.Runnable
                public void run() {
                    if (zzkzVar.isCancelled()) {
                        futureSubmit.cancel(true);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            zzkh.zzd("Thread execution is rejected.", e);
            zzkzVar.cancel(true);
        }
        return zzkzVar;
    }

    private static ThreadFactory zzco(final String str) {
        return new ThreadFactory() { // from class: com.google.android.gms.internal.zzkk.5
            private final AtomicInteger zzcle = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                String str2 = str;
                return new Thread(runnable, new StringBuilder(String.valueOf(str2).length() + 23).append("AdWorker(").append(str2).append(") #").append(this.zzcle.getAndIncrement()).toString());
            }
        };
    }
}
