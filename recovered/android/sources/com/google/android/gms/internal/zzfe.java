package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzfe implements zzet {
    zzfe() {
    }

    private int zzg(Map<String, String> map) throws NumberFormatException, NullPointerException {
        int i = Integer.parseInt(map.get("playbackState"));
        if (i < 0 || 3 < i) {
            return 0;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        zzlq zzlqVar;
        if (zzdc.zzbaz.get().booleanValue()) {
            zzlq zzlqVarZzuu = zzllVar.zzuu();
            if (zzlqVarZzuu == null) {
                try {
                    zzlq zzlqVar2 = new zzlq(zzllVar, Float.parseFloat(map.get("duration")));
                    zzllVar.zza(zzlqVar2);
                    zzlqVar = zzlqVar2;
                } catch (NullPointerException | NumberFormatException e) {
                    zzkh.zzb("Unable to parse videoMeta message.", e);
                    com.google.android.gms.ads.internal.zzu.zzft().zzb(e, true);
                    return;
                }
            } else {
                zzlqVar = zzlqVarZzuu;
            }
            zzlqVar.zza(Float.parseFloat(map.get("currentTime")), zzg(map), "1".equals(map.get("muted")));
        }
    }
}
