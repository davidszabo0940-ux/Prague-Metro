package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;

/* JADX INFO: loaded from: classes.dex */
public final class zzpo<O extends Api.ApiOptions> {

    /* JADX INFO: renamed from: pD */
    private final Api<O> f570pD;

    /* JADX INFO: renamed from: rF */
    private final O f571rF;

    public zzpo(Api<O> api, O o) {
        this.f570pD = api;
        this.f571rF = o;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzpo)) {
            return false;
        }
        zzpo zzpoVar = (zzpo) obj;
        return com.google.android.gms.common.internal.zzaa.equal(this.f570pD, zzpoVar.f570pD) && com.google.android.gms.common.internal.zzaa.equal(this.f571rF, zzpoVar.f571rF);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzaa.hashCode(this.f570pD, this.f571rF);
    }

    public Api.zzc<?> zzanp() {
        return this.f570pD.zzanp();
    }

    public String zzaok() {
        return this.f570pD.getName();
    }
}
