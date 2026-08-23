package com.google.android.gms.internal;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class zzrq {
    private final String mTag;

    /* JADX INFO: renamed from: yR */
    private final String f830yR;

    /* JADX INFO: renamed from: zk */
    private final com.google.android.gms.common.internal.zzp f831zk;
    private final int zzczi;

    private zzrq(String str, String str2) {
        this.f830yR = str2;
        this.mTag = str;
        this.f831zk = new com.google.android.gms.common.internal.zzp(str);
        this.zzczi = getLogLevel();
    }

    public zzrq(String str, String... strArr) {
        this(str, zzc(strArr));
    }

    private int getLogLevel() {
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        return i;
    }

    private static String zzc(String... strArr) {
        if (strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (String str : strArr) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(str);
        }
        sb.append(']').append(' ');
        return sb.toString();
    }

    protected String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return this.f830yR.concat(str);
    }

    public void zza(String str, Object... objArr) {
        if (zzaz(2)) {
            Log.v(this.mTag, format(str, objArr));
        }
    }

    public boolean zzaz(int i) {
        return this.zzczi <= i;
    }
}
