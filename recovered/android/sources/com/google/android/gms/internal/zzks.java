package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzks {
    private HandlerThread zzcmq = null;
    private Handler mHandler = null;
    private int zzcmr = 0;
    private final Object zzail = new Object();

    public Looper zztr() {
        Looper looper;
        synchronized (this.zzail) {
            if (this.zzcmr != 0) {
                com.google.android.gms.common.internal.zzab.zzb(this.zzcmq, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzcmq == null) {
                zzkh.m95v("Starting the looper thread.");
                this.zzcmq = new HandlerThread("LooperProvider");
                this.zzcmq.start();
                this.mHandler = new Handler(this.zzcmq.getLooper());
                zzkh.m95v("Looper thread started.");
            } else {
                zzkh.m95v("Resuming the looper thread");
                this.zzail.notifyAll();
            }
            this.zzcmr++;
            looper = this.zzcmq.getLooper();
        }
        return looper;
    }

    public void zzts() {
        synchronized (this.zzail) {
            com.google.android.gms.common.internal.zzab.zzb(this.zzcmr > 0, "Invalid state: release() called more times than expected.");
            int i = this.zzcmr - 1;
            this.zzcmr = i;
            if (i == 0) {
                this.mHandler.post(new Runnable() { // from class: com.google.android.gms.internal.zzks.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (zzks.this.zzail) {
                            zzkh.m95v("Suspending the looper thread");
                            while (zzks.this.zzcmr == 0) {
                                try {
                                    zzks.this.zzail.wait();
                                    zzkh.m95v("Looper thread resumed");
                                } catch (InterruptedException e) {
                                    zzkh.m95v("Looper thread interrupted.");
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
