package com.google.android.gms.common.util;

/* JADX INFO: loaded from: classes.dex */
public final class zzu {
    private static int zza(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        int i = 0;
        int length = stackTraceElementArr2.length;
        int length2 = stackTraceElementArr.length;
        while (true) {
            length2--;
            if (length2 < 0 || (length = length - 1) < 0 || !stackTraceElementArr2[length].equals(stackTraceElementArr[length2])) {
                break;
            }
            i++;
        }
        return i;
    }

    public static String zzavw() {
        StringBuilder sb = new StringBuilder();
        Throwable th = new Throwable();
        StackTraceElement[] stackTrace = th.getStackTrace();
        sb.append("Async stack trace:");
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\n\tat ").append(stackTraceElement);
        }
        StackTraceElement[] stackTraceElementArr = stackTrace;
        Throwable cause = th.getCause();
        while (cause != null) {
            sb.append("\nCaused by: ");
            sb.append(cause);
            StackTraceElement[] stackTrace2 = cause.getStackTrace();
            int iZza = zza(stackTrace2, stackTraceElementArr);
            for (int i = 0; i < stackTrace2.length - iZza; i++) {
                String strValueOf = String.valueOf(stackTrace2[i]);
                sb.append(new StringBuilder(String.valueOf(strValueOf).length() + 5).append("\n\tat ").append(strValueOf).toString());
            }
            if (iZza > 0) {
                sb.append(new StringBuilder(22).append("\n\t... ").append(iZza).append(" more").toString());
            }
            cause = cause.getCause();
            stackTraceElementArr = stackTrace2;
        }
        return sb.toString();
    }
}
