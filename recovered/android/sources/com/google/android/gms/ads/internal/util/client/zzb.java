package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzb {
    /* JADX INFO: renamed from: e */
    public static void m14e(String str) {
        if (zzaz(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void zza(String str, Throwable th) {
        if (zzaz(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean zzaz(int i) {
        return i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i);
    }

    public static void zzb(String str, Throwable th) {
        if (zzaz(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzc(String str, Throwable th) {
        if (zzaz(4)) {
            Log.i(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzcw(String str) {
        if (zzaz(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void zzcx(String str) {
        if (zzaz(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void zzcy(String str) {
        if (zzaz(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }

    public static void zzd(String str, Throwable th) {
        if (zzaz(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }
}
