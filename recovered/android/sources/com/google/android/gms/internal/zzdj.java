package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzdj {

    @Nullable
    private final zzdk zzajn;
    private final Map<String, zzdi> zzbec = new HashMap();

    public zzdj(@Nullable zzdk zzdkVar) {
        this.zzajn = zzdkVar;
    }

    public void zza(String str, zzdi zzdiVar) {
        this.zzbec.put(str, zzdiVar);
    }

    public void zza(String str, String str2, long j) {
        zzdg.zza(this.zzajn, this.zzbec.get(str2), j, str);
        this.zzbec.put(str, zzdg.zza(this.zzajn, j));
    }

    @Nullable
    public zzdk zzkf() {
        return this.zzajn;
    }
}
