package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class zzd<TResult> implements zzf<TResult> {
    private OnFailureListener aDH;
    private final Executor avP;
    private final Object zzail = new Object();

    public zzd(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.avP = executor;
        this.aDH = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.zzf
    public void cancel() {
        synchronized (this.zzail) {
            this.aDH = null;
        }
    }

    @Override // com.google.android.gms.tasks.zzf
    public void onComplete(@NonNull final Task<TResult> task) {
        if (task.isSuccessful()) {
            return;
        }
        synchronized (this.zzail) {
            if (this.aDH != null) {
                this.avP.execute(new Runnable() { // from class: com.google.android.gms.tasks.zzd.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (zzd.this.zzail) {
                            if (zzd.this.aDH != null) {
                                zzd.this.aDH.onFailure(task.getException());
                            }
                        }
                    }
                });
            }
        }
    }
}
