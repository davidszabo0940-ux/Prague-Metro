package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes.dex */
public final class zzvy implements Api.ApiOptions.Optional {
    public static final zzvy aul = new zza().zzbzp();
    private final boolean aum;
    private final boolean aun;
    private final Long auo;
    private final Long aup;

    /* JADX INFO: renamed from: dT */
    private final boolean f860dT;

    /* JADX INFO: renamed from: dV */
    private final boolean f861dV;

    /* JADX INFO: renamed from: dW */
    private final String f862dW;

    /* JADX INFO: renamed from: dX */
    private final String f863dX;

    public static final class zza {
        /* JADX WARN: Multi-variable type inference failed */
        public zzvy zzbzp() {
            boolean z = false;
            return new zzvy(z, z, null, z, 0 == true ? 1 : 0, z, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
        }
    }

    private zzvy(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2) {
        this.aum = z;
        this.f860dT = z2;
        this.f862dW = str;
        this.f861dV = z3;
        this.aun = z4;
        this.f863dX = str2;
        this.auo = l;
        this.aup = l2;
    }

    public boolean zzafr() {
        return this.f860dT;
    }

    public boolean zzaft() {
        return this.f861dV;
    }

    public String zzafu() {
        return this.f862dW;
    }

    @Nullable
    public String zzafv() {
        return this.f863dX;
    }

    public boolean zzbzl() {
        return this.aum;
    }

    public boolean zzbzm() {
        return this.aun;
    }

    @Nullable
    public Long zzbzn() {
        return this.auo;
    }

    @Nullable
    public Long zzbzo() {
        return this.aup;
    }
}
