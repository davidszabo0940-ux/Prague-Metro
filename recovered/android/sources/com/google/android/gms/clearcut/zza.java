package com.google.android.gms.clearcut;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class zza {

    /* JADX INFO: renamed from: pN */
    private static int f73pN = -1;

    /* JADX INFO: renamed from: pO */
    public static final zza f74pO = new zza();

    protected zza() {
    }

    public int zzbk(Context context) {
        if (f73pN < 0) {
            f73pN = context.getSharedPreferences("bootCount", 0).getInt("bootCount", 1);
        }
        return f73pN;
    }
}
