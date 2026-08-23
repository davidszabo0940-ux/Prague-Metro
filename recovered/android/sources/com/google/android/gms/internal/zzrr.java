package com.google.android.gms.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class zzrr implements ThreadFactory {

    /* JADX INFO: renamed from: Bf */
    private final String f832Bf;

    /* JADX INFO: renamed from: Bg */
    private final AtomicInteger f833Bg;

    /* JADX INFO: renamed from: Bh */
    private final ThreadFactory f834Bh;
    private final int mPriority;

    public zzrr(String str) {
        this(str, 0);
    }

    public zzrr(String str, int i) {
        this.f833Bg = new AtomicInteger();
        this.f834Bh = Executors.defaultThreadFactory();
        this.f832Bf = (String) com.google.android.gms.common.internal.zzab.zzb(str, "Name must not be null");
        this.mPriority = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f834Bh.newThread(new zzrs(runnable, this.mPriority));
        String str = this.f832Bf;
        threadNewThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.f833Bg.getAndIncrement()).append("]").toString());
        return threadNewThread;
    }
}
