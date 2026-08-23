package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class zze<TResult> implements zzf<TResult> {
    private OnSuccessListener<? super TResult> aDJ;
    private final Executor avP;
    private final Object zzail = new Object();

    public zze(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.avP = executor;
        this.aDJ = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.zzf
    public void cancel() {
        synchronized (this.zzail) {
            this.aDJ = null;
        }
    }

    @Override // com.google.android.gms.tasks.zzf
    public void onComplete(@NonNull final Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.zzail) {
                if (this.aDJ != null) {
                    this.avP.execute(new Runnable() { // from class: com.google.android.gms.tasks.zze.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (zze.this.zzail) {
                                if (zze.this.aDJ != null) {
                                    zze.this.aDJ.onSuccess(task.getResult());
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}
