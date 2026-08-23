package com.unity3d.player;

import android.os.Build;

/* JADX INFO: renamed from: com.unity3d.player.u */
/* JADX INFO: loaded from: classes.dex */
final class C0709u implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a */
    private volatile Thread.UncaughtExceptionHandler f1070a;

    C0709u() {
    }

    /* JADX INFO: renamed from: a */
    final synchronized boolean m225a() {
        boolean z;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            z = false;
        } else {
            this.f1070a = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
            z = true;
        }
        return z;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        try {
            Error error = new Error(String.format("FATAL EXCEPTION [%s]\n", thread.getName()) + String.format("Unity version     : %s\n", "5.3.5f1") + String.format("Device model      : %s %s\n", Build.MANUFACTURER, Build.MODEL) + String.format("Device fingerprint: %s\n", Build.FINGERPRINT));
            error.setStackTrace(new StackTraceElement[0]);
            error.initCause(th);
            this.f1070a.uncaughtException(thread, error);
        } catch (Throwable th2) {
            this.f1070a.uncaughtException(thread, th);
        }
    }
}
