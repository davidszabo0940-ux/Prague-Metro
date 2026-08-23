package com.google.android.gms.common.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzh implements zze {

    /* JADX INFO: renamed from: AK */
    private static zzh f460AK;

    public static synchronized zze zzavi() {
        if (f460AK == null) {
            f460AK = new zzh();
        }
        return f460AK;
    }

    @Override // com.google.android.gms.common.util.zze
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.zze
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.zze
    public long nanoTime() {
        return System.nanoTime();
    }
}
