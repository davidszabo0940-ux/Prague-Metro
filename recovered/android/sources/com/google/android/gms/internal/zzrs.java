package com.google.android.gms.internal;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
class zzrs implements Runnable {
    private final int mPriority;
    private final Runnable zzw;

    public zzrs(Runnable runnable, int i) {
        this.zzw = runnable;
        this.mPriority = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(this.mPriority);
        this.zzw.run();
    }
}
