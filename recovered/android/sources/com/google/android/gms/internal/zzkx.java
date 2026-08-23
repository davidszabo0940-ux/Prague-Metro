package com.google.android.gms.internal;

import android.os.StrictMode;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzkx {
    public static <T> T zzb(Callable<T> callable) {
        T tCall;
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            try {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
                tCall = callable.call();
                StrictMode.setThreadPolicy(threadPolicy);
            } catch (Throwable th) {
                zzkh.zzb("Unexpected exception.", th);
                com.google.android.gms.ads.internal.zzu.zzft().zzb(th, true);
                StrictMode.setThreadPolicy(threadPolicy);
                tCall = null;
            }
            return tCall;
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(threadPolicy);
            throw th2;
        }
    }
}
