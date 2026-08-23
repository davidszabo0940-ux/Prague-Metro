package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzqo;
import com.google.android.gms.internal.zzqp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzh<TResult> extends Task<TResult> {
    private boolean aDQ;
    private TResult aDR;
    private Exception aDS;
    private final Object zzail = new Object();
    private final zzg<TResult> aDP = new zzg<>();

    private static class zza extends zzqo {
        private final List<WeakReference<zzf<?>>> mListeners;

        private zza(zzqp zzqpVar) {
            super(zzqpVar);
            this.mListeners = new ArrayList();
            this.f763va.zza("TaskOnStopCallback", this);
        }

        public static zza zzv(Activity activity) {
            zzqp zzqpVarZzs = zzs(activity);
            zza zzaVar = (zza) zzqpVarZzs.zza("TaskOnStopCallback", zza.class);
            return zzaVar == null ? new zza(zzqpVarZzs) : zzaVar;
        }

        @Override // com.google.android.gms.internal.zzqo
        @MainThread
        public void onStop() {
            synchronized (this.mListeners) {
                Iterator<WeakReference<zzf<?>>> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    zzf<?> zzfVar = it.next().get();
                    if (zzfVar != null) {
                        zzfVar.cancel();
                    }
                }
                this.mListeners.clear();
            }
        }

        public <T> void zzb(zzf<T> zzfVar) {
            synchronized (this.mListeners) {
                this.mListeners.add(new WeakReference<>(zzfVar));
            }
        }
    }

    zzh() {
    }

    private void zzchi() {
        zzab.zza(this.aDQ, "Task is not yet complete");
    }

    private void zzchj() {
        zzab.zza(!this.aDQ, "Task is already complete");
    }

    private void zzchk() {
        synchronized (this.zzail) {
            if (this.aDQ) {
                this.aDP.zza(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zzc zzcVar = new zzc(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.aDP.zza(zzcVar);
        zza.zzv(activity).zzb(zzcVar);
        zzchk();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.aDP.zza(new zzc(executor, onCompleteListener));
        zzchk();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzd zzdVar = new zzd(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.aDP.zza(zzdVar);
        zza.zzv(activity).zzb(zzdVar);
        zzchk();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.aDP.zza(new zzd(executor, onFailureListener));
        zzchk();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zze zzeVar = new zze(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.aDP.zza(zzeVar);
        zza.zzv(activity).zzb(zzeVar);
        zzchk();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.aDP.zza(new zze(executor, onSuccessListener));
        zzchk();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        zzh zzhVar = new zzh();
        this.aDP.zza(new com.google.android.gms.tasks.zza(executor, continuation, zzhVar));
        zzchk();
        return zzhVar;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzh zzhVar = new zzh();
        this.aDP.zza(new zzb(executor, continuation, zzhVar));
        zzchk();
        return zzhVar;
    }

    @Override // com.google.android.gms.tasks.Task
    @Nullable
    public Exception getException() {
        Exception exc;
        synchronized (this.zzail) {
            exc = this.aDS;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public TResult getResult() {
        TResult tresult;
        synchronized (this.zzail) {
            zzchi();
            if (this.aDS != null) {
                throw new RuntimeExecutionException(this.aDS);
            }
            tresult = this.aDR;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.zzail) {
            zzchi();
            if (cls.isInstance(this.aDS)) {
                throw cls.cast(this.aDS);
            }
            if (this.aDS != null) {
                throw new RuntimeExecutionException(this.aDS);
            }
            tresult = this.aDR;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isComplete() {
        boolean z;
        synchronized (this.zzail) {
            z = this.aDQ;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isSuccessful() {
        boolean z;
        synchronized (this.zzail) {
            z = this.aDQ && this.aDS == null;
        }
        return z;
    }

    public void setException(@NonNull Exception exc) {
        zzab.zzb(exc, "Exception must not be null");
        synchronized (this.zzail) {
            zzchj();
            this.aDQ = true;
            this.aDS = exc;
        }
        this.aDP.zza(this);
    }

    public void setResult(TResult tresult) {
        synchronized (this.zzail) {
            zzchj();
            this.aDQ = true;
            this.aDR = tresult;
        }
        this.aDP.zza(this);
    }
}
