package com.google.android.gms.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class zzru {

    /* JADX INFO: renamed from: Bj */
    private static zzru f835Bj = new zzru();

    /* JADX INFO: renamed from: Bi */
    private zzrt f836Bi = null;

    public static zzrt zzcq(Context context) {
        return f835Bj.zzcp(context);
    }

    public synchronized zzrt zzcp(Context context) {
        if (this.f836Bi == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f836Bi = new zzrt(context);
        }
        return this.f836Bi;
    }
}
