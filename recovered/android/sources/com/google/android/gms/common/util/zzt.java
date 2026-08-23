package com.google.android.gms.common.util;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class zzt {

    /* JADX INFO: renamed from: AY */
    private static String f474AY = null;

    public static String zzavu() {
        return zzgy(Binder.getCallingPid());
    }

    public static String zzavv() {
        if (f474AY == null) {
            f474AY = zzgy(Process.myPid());
        }
        return f474AY;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static String zzgy(int i) throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String strTrim = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new StringBuilder(25).append("/proc/").append(i).append("/cmdline").toString()));
            try {
                try {
                    strTrim = bufferedReader.readLine().trim();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e) {
                            Log.w("ProcessUtils", e.getMessage(), e);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    Log.e("ProcessUtils", e.getMessage(), e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            Log.w("ProcessUtils", e3.getMessage(), e3);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                        Log.w("ProcessUtils", e4.getMessage(), e4);
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return strTrim;
    }
}
