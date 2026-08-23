package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzfi implements zzet {
    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        int i;
        zzfg zzfgVarZzgj = com.google.android.gms.ads.internal.zzu.zzgj();
        if (map.containsKey("abort")) {
            if (zzfgVarZzgj.zze(zzllVar)) {
                return;
            }
            zzkh.zzcy("Precache abort but no preload task running.");
            return;
        }
        String str = map.get("src");
        if (str == null) {
            zzkh.zzcy("Precache video action is missing the src parameter.");
            return;
        }
        try {
            i = Integer.parseInt(map.get("player"));
        } catch (NumberFormatException e) {
            i = 0;
        }
        String str2 = map.containsKey("mimetype") ? map.get("mimetype") : "";
        if (zzfgVarZzgj.zzf(zzllVar)) {
            zzkh.zzcy("Precache task already running.");
        } else {
            com.google.android.gms.common.internal.zzb.zzw(zzllVar.zzuh());
        }
    }
}
