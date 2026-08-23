package com.google.android.gms.internal;

import android.support.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzdi {
    private final long zzbdz;

    @Nullable
    private final String zzbea;

    @Nullable
    private final zzdi zzbeb;

    public zzdi(long j, @Nullable String str, @Nullable zzdi zzdiVar) {
        this.zzbdz = j;
        this.zzbea = str;
        this.zzbeb = zzdiVar;
    }

    long getTime() {
        return this.zzbdz;
    }

    String zzkd() {
        return this.zzbea;
    }

    zzdi zzke() {
        return this.zzbeb;
    }
}
