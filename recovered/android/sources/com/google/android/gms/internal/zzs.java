package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class zzs {
    public static String TAG = "Volley";
    public static boolean DEBUG = Log.isLoggable(TAG, 2);

    static class zza {
        public static final boolean zzbj = zzs.DEBUG;
        private final List<C0800zza> zzbk = new ArrayList();
        private boolean zzbl = false;

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzs$zza$zza, reason: collision with other inner class name */
        private static class C0800zza {
            public final String name;
            public final long time;
            public final long zzbm;

            public C0800zza(String str, long j, long j2) {
                this.name = str;
                this.zzbm = j;
                this.time = j2;
            }
        }

        zza() {
        }

        private long zzw() {
            if (this.zzbk.size() == 0) {
                return 0L;
            }
            return this.zzbk.get(this.zzbk.size() - 1).time - this.zzbk.get(0).time;
        }

        protected void finalize() throws Throwable {
            if (this.zzbl) {
                return;
            }
            zzd("Request on the loose");
            zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void zza(String str, long j) {
            if (this.zzbl) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.zzbk.add(new C0800zza(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void zzd(String str) {
            this.zzbl = true;
            long jZzw = zzw();
            if (jZzw > 0) {
                long j = this.zzbk.get(0).time;
                zzs.zzb("(%-4d ms) %s", Long.valueOf(jZzw), str);
                long j2 = j;
                for (C0800zza c0800zza : this.zzbk) {
                    long j3 = c0800zza.time;
                    zzs.zzb("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c0800zza.zzbm), c0800zza.name);
                    j2 = j3;
                }
            }
        }
    }

    public static void zza(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, zzd(str, objArr));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr), th);
    }

    public static void zzb(String str, Object... objArr) {
        Log.d(TAG, zzd(str, objArr));
    }

    public static void zzc(String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr));
    }

    private static String zzd(String str, Object... objArr) {
        String string;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(zzs.class)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1);
                String strValueOf = String.valueOf(stackTrace[i].getMethodName());
                string = new StringBuilder(String.valueOf(strSubstring2).length() + 1 + String.valueOf(strValueOf).length()).append(strSubstring2).append(".").append(strValueOf).toString();
                return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), string, str);
            }
        }
        string = "<unknown>";
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), string, str);
    }
}
