package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzkh extends com.google.android.gms.ads.internal.util.client.zzb {
    /* JADX INFO: renamed from: v */
    public static void m95v(String str) {
        if (zztc()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean zztb() {
        return zzdc.zzban.get().booleanValue();
    }

    private static boolean zztc() {
        return zzaz(2) && zztb();
    }
}
