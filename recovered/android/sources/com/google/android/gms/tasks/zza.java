package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class zza<TResult, TContinuationResult> implements zzf<TResult> {
    private final Continuation<TResult, TContinuationResult> aDA;
    private final zzh<TContinuationResult> aDB;
    private final Executor avP;

    public zza(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull zzh<TContinuationResult> zzhVar) {
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
        this.avP.execute(new Runnable() { // from class: com.google.android.gms.tasks.zza.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zza.this.aDB.setResult(zza.this.aDA.then(task));
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        zza.this.aDB.setException((Exception) e.getCause());
                    } else {
                        zza.this.aDB.setException(e);
                    }
                } catch (Exception e2) {
                    zza.this.aDB.setException(e2);
                }
            }
        });
    }
}
