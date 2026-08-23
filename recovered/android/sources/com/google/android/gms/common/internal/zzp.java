package com.google.android.gms.common.internal;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class zzp {

    /* JADX INFO: renamed from: yO */
    public static final int f369yO = 23 - " PII_LOG".length();

    /* JADX INFO: renamed from: yP */
    private static final String f370yP = null;

    /* JADX INFO: renamed from: yQ */
    private final String f371yQ;

    /* JADX INFO: renamed from: yR */
    private final String f372yR;

    public zzp(String str) {
        this(str, null);
    }

    public zzp(String str, String str2) {
        zzab.zzb(str, "log tag cannot be null");
        zzab.zzb(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f371yQ = str;
        if (str2 == null || str2.length() <= 0) {
            this.f372yR = null;
        } else {
            this.f372yR = str2;
        }
    }

    private String zzhq(String str) {
        return this.f372yR == null ? str : this.f372yR.concat(str);
    }

    public void zzae(String str, String str2) {
        if (zzgc(3)) {
            Log.d(str, zzhq(str2));
        }
    }

    public void zzaf(String str, String str2) {
        if (zzgc(5)) {
            Log.w(str, zzhq(str2));
        }
    }

    public void zzag(String str, String str2) {
        if (zzgc(6)) {
            Log.e(str, zzhq(str2));
        }
    }

    public void zzb(String str, String str2, Throwable th) {
        if (zzgc(4)) {
            Log.i(str, zzhq(str2), th);
        }
    }

    public void zzc(String str, String str2, Throwable th) {
        if (zzgc(5)) {
            Log.w(str, zzhq(str2), th);
        }
    }

    public void zzd(String str, String str2, Throwable th) {
        if (zzgc(6)) {
            Log.e(str, zzhq(str2), th);
        }
    }

    public void zze(String str, String str2, Throwable th) {
        if (zzgc(7)) {
            Log.e(str, zzhq(str2), th);
            Log.wtf(str, zzhq(str2), th);
        }
    }

    public boolean zzgc(int i) {
        return Log.isLoggable(this.f371yQ, i);
    }
}
