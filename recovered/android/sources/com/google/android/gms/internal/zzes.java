package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzes implements zzet {
    public static void zzd(zzll zzllVar) {
        zzllVar.zza("/install", new zzes());
    }

    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        String str = map.get("action");
        if (!"is_updated".equals(str)) {
            if ("install_apk".equals(str)) {
                zzdt.zzkq().zza(zzllVar.zzuf(), map);
            }
        } else {
            String strZzb = zzdt.zzkq().zzb(zzllVar.zzuf(), map);
            HashMap map2 = new HashMap();
            map2.put("status", strZzb);
            zzllVar.zza("installStatus", map2);
        }
    }
}
