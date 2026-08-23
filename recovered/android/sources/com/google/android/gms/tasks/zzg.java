package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
class zzg<TResult> {
    private Queue<zzf<TResult>> aDL;
    private boolean aDM;
    private final Object zzail = new Object();

    zzg() {
    }

    public void zza(@NonNull Task<TResult> task) {
        zzf<TResult> zzfVarPoll;
        synchronized (this.zzail) {
            if (this.aDL == null || this.aDM) {
                return;
            }
            this.aDM = true;
            while (true) {
                synchronized (this.zzail) {
                    zzfVarPoll = this.aDL.poll();
                    if (zzfVarPoll == null) {
                        this.aDM = false;
                        return;
                    }
                }
                zzfVarPoll.onComplete(task);
            }
        }
    }

    public void zza(@NonNull zzf<TResult> zzfVar) {
        synchronized (this.zzail) {
            if (this.aDL == null) {
                this.aDL = new ArrayDeque();
            }
            this.aDL.add(zzfVar);
        }
    }
}
