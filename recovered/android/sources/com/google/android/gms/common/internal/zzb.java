package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class zzb {
    public static void zza(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void zzbm(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void zzhj(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            String strValueOf = String.valueOf(Thread.currentThread());
            String strValueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            Log.e("Asserts", new StringBuilder(String.valueOf(strValueOf).length() + 57 + String.valueOf(strValueOf2).length()).append("checkMainThread: current thread ").append(strValueOf).append(" IS NOT the main thread ").append(strValueOf2).append("!").toString());
            throw new IllegalStateException(str);
        }
    }

    public static void zzhk(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            String strValueOf = String.valueOf(Thread.currentThread());
            String strValueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            Log.e("Asserts", new StringBuilder(String.valueOf(strValueOf).length() + 56 + String.valueOf(strValueOf2).length()).append("checkNotMainThread: current thread ").append(strValueOf).append(" IS the main thread ").append(strValueOf2).append("!").toString());
            throw new IllegalStateException(str);
        }
    }

    public static void zzw(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }
}
