package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzqw {

    /* JADX INFO: renamed from: uu */
    private static final ExecutorService f774uu = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzrr("GAC_Transform"));

    public static ExecutorService zzapz() {
        return f774uu;
    }
}
