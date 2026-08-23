package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzew implements zzet {
    private final zzex zzbiv;

    public zzew(zzex zzexVar) {
        this.zzbiv = zzexVar;
    }

    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        float f;
        boolean zEquals = "1".equals(map.get("transparentBackground"));
        boolean zEquals2 = "1".equals(map.get("blur"));
        try {
            f = map.get("blurRadius") != null ? Float.parseFloat(map.get("blurRadius")) : 0.0f;
        } catch (NumberFormatException e) {
            zzkh.zzb("Fail to parse float", e);
        }
        this.zzbiv.zzg(zEquals);
        this.zzbiv.zza(zEquals2, f);
    }
}
