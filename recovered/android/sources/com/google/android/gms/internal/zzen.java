package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzen implements zzet {
    private final zzeo zzbhq;

    public zzen(zzeo zzeoVar) {
        this.zzbhq = zzeoVar;
    }

    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzkh.zzcy("App event with no name parameter.");
        } else {
            this.zzbhq.onAppEvent(str, map.get("info"));
        }
    }
}
