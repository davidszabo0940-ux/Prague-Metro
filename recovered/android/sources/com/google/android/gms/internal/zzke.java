package com.google.android.gms.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzke {
    private final Object zzail;
    private final zzkb zzanz;
    private final String zzcix;
    private int zzckl;
    private int zzckm;

    zzke(zzkb zzkbVar, String str) {
        this.zzail = new Object();
        this.zzanz = zzkbVar;
        this.zzcix = str;
    }

    public zzke(String str) {
        this(com.google.android.gms.ads.internal.zzu.zzft(), str);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.zzail) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.zzckl);
            bundle.putInt("pmnll", this.zzckm);
        }
        return bundle;
    }

    public void zzh(int i, int i2) {
        synchronized (this.zzail) {
            this.zzckl = i;
            this.zzckm = i2;
            this.zzanz.zza(this.zzcix, this);
        }
    }
}
