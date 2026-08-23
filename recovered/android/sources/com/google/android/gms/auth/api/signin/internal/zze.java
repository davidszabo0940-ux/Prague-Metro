package com.google.android.gms.auth.api.signin.internal;

/* JADX INFO: loaded from: classes.dex */
public class zze {

    /* JADX INFO: renamed from: ek */
    static int f55ek = 31;

    /* JADX INFO: renamed from: el */
    private int f56el = 1;

    public int zzagc() {
        return this.f56el;
    }

    public zze zzba(boolean z) {
        this.f56el = (z ? 1 : 0) + (this.f56el * f55ek);
        return this;
    }

    public zze zzr(Object obj) {
        this.f56el = (obj == null ? 0 : obj.hashCode()) + (this.f56el * f55ek);
        return this;
    }
}
