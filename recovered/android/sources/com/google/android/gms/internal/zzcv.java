package com.google.android.gms.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzcv {
    private String zzaxl;

    public zzcv() {
        this(zzdc.zzaxw.zzjw());
    }

    public zzcv(String str) {
        this.zzaxl = TextUtils.isEmpty(str) ? zzdc.zzaxw.zzjw() : str;
    }

    public String zzjv() {
        return this.zzaxl;
    }
}
