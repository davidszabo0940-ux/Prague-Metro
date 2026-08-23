package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class zzc<TResult> implements zzf<TResult> {
    private OnCompleteListener<TResult> aDF;
    private final Executor avP;
    private final Object zzail = new Object();

    public zzc(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.avP = executor;
        this.aDF = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.zzf
    public void cancel() {
        synchronized (this.zzail) {
            this.aDF = null;
        }
    }

    @Override // com.google.android.gms.tasks.zzf
    public void onComplete(@NonNull final Task<TResult> task) {
        synchronized (this.zzail) {
            if (this.aDF == null) {
                return;
            }
            this.avP.execute(new Runnable() { // from class: com.google.android.gms.tasks.zzc.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzc.this.zzail) {
                        if (zzc.this.aDF != null) {
                            zzc.this.aDF.onComplete(task);
                        }
                    }
                }
            });
        }
    }
}
