package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class zzb<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzf<TResult> {
    private final Continuation<TResult, Task<TContinuationResult>> aDA;
    private final zzh<TContinuationResult> aDB;
    private final Executor avP;

    public zzb(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation, @NonNull zzh<TContinuationResult> zzhVar) {
        this.avP = executor;
        this.aDA = continuation;
        this.aDB = zzhVar;
    }

    @Override // com.google.android.gms.tasks.zzf
    public void cancel() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.tasks.zzf
    public void onComplete(@NonNull final Task<TResult> task) {
        this.avP.execute(new Runnable() { // from class: com.google.android.gms.tasks.zzb.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Task task2 = (Task) zzb.this.aDA.then(task);
                    if (task2 == null) {
                        zzb.this.onFailure(new NullPointerException("Continuation returned null"));
                    } else {
                        task2.addOnSuccessListener(TaskExecutors.aDO, zzb.this);
                        task2.addOnFailureListener(TaskExecutors.aDO, zzb.this);
                    }
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        zzb.this.aDB.setException((Exception) e.getCause());
                    } else {
                        zzb.this.aDB.setException(e);
                    }
                } catch (Exception e2) {
                    zzb.this.aDB.setException(e2);
                }
            }
        });
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(@NonNull Exception exc) {
        this.aDB.setException(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(TContinuationResult tcontinuationresult) {
        this.aDB.setResult(tcontinuationresult);
    }
}
