package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzab;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class Tasks {

    private static final class zza implements zzb {
        private final CountDownLatch zzalc;

        private zza() {
            this.zzalc = new CountDownLatch(1);
        }

        public void await() throws InterruptedException {
            this.zzalc.await();
        }

        public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.zzalc.await(j, timeUnit);
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            this.zzalc.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(Object obj) {
            this.zzalc.countDown();
        }
    }

    interface zzb extends OnFailureListener, OnSuccessListener<Object> {
    }

    private static final class zzc implements zzb {
        private final zzh<Void> aDN;
        private Exception aDS;
        private final int aDU;
        private int aDV;
        private int aDW;
        private final Object zzail = new Object();

        public zzc(int i, zzh<Void> zzhVar) {
            this.aDU = i;
            this.aDN = zzhVar;
        }

        private void zzchl() {
            if (this.aDV + this.aDW == this.aDU) {
                if (this.aDS == null) {
                    this.aDN.setResult(null);
                    return;
                }
                zzh<Void> zzhVar = this.aDN;
                int i = this.aDW;
                zzhVar.setException(new ExecutionException(new StringBuilder(54).append(i).append(" out of ").append(this.aDU).append(" underlying tasks failed").toString(), this.aDS));
            }
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            synchronized (this.zzail) {
                this.aDW++;
                this.aDS = exc;
                zzchl();
            }
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(Object obj) {
            synchronized (this.zzail) {
                this.aDV++;
                zzchl();
            }
        }
    }

    private Tasks() {
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        zzab.zzata();
        zzab.zzb(task, "Task must not be null");
        if (task.isComplete()) {
            return (TResult) zzb(task);
        }
        zza zzaVar = new zza();
        zza(task, zzaVar);
        zzaVar.await();
        return (TResult) zzb(task);
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task, long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        zzab.zzata();
        zzab.zzb(task, "Task must not be null");
        zzab.zzb(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return (TResult) zzb(task);
        }
        zza zzaVar = new zza();
        zza(task, zzaVar);
        if (zzaVar.await(j, timeUnit)) {
            return (TResult) zzb(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static <TResult> Task<TResult> call(@NonNull Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static <TResult> Task<TResult> call(@NonNull Executor executor, @NonNull final Callable<TResult> callable) {
        zzab.zzb(executor, "Executor must not be null");
        zzab.zzb(callable, "Callback must not be null");
        final zzh zzhVar = new zzh();
        executor.execute(new Runnable() { // from class: com.google.android.gms.tasks.Tasks.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zzhVar.setResult(callable.call());
                } catch (Exception e) {
                    zzhVar.setException(e);
                }
            }
        });
        return zzhVar;
    }

    public static <TResult> Task<TResult> forException(@NonNull Exception exc) {
        zzh zzhVar = new zzh();
        zzhVar.setException(exc);
        return zzhVar;
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        zzh zzhVar = new zzh();
        zzhVar.setResult(tresult);
        return zzhVar;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return forResult(null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzh zzhVar = new zzh();
        zzc zzcVar = new zzc(collection.size(), zzhVar);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            zza(it2.next(), zzcVar);
        }
        return zzhVar;
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        return taskArr.length == 0 ? forResult(null) : whenAll(Arrays.asList(taskArr));
    }

    private static void zza(Task<?> task, zzb zzbVar) {
        task.addOnSuccessListener(TaskExecutors.aDO, zzbVar);
        task.addOnFailureListener(TaskExecutors.aDO, zzbVar);
    }

    private static <TResult> TResult zzb(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }
}
