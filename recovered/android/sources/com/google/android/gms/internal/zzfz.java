package com.google.android.gms.internal;

import java.util.AbstractMap;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzfz implements zzfy {
    private final zzfx zzbmw;
    private final HashSet<AbstractMap.SimpleEntry<String, zzet>> zzbmx = new HashSet<>();

    public zzfz(zzfx zzfxVar) {
        this.zzbmw = zzfxVar;
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zza(String str, zzet zzetVar) {
        this.zzbmw.zza(str, zzetVar);
        this.zzbmx.add(new AbstractMap.SimpleEntry<>(str, zzetVar));
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zza(String str, JSONObject jSONObject) {
        this.zzbmw.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zzb(String str, zzet zzetVar) {
        this.zzbmw.zzb(str, zzetVar);
        this.zzbmx.remove(new AbstractMap.SimpleEntry(str, zzetVar));
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zzb(String str, JSONObject jSONObject) {
        this.zzbmw.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zzj(String str, String str2) {
        this.zzbmw.zzj(str, str2);
    }

    @Override // com.google.android.gms.internal.zzfy
    public void zzmh() {
        for (AbstractMap.SimpleEntry<String, zzet> simpleEntry : this.zzbmx) {
            String strValueOf = String.valueOf(simpleEntry.getValue().toString());
            zzkh.m95v(strValueOf.length() != 0 ? "Unregistering eventhandler: ".concat(strValueOf) : new String("Unregistering eventhandler: "));
            this.zzbmw.zzb(simpleEntry.getKey(), simpleEntry.getValue());
        }
        this.zzbmx.clear();
    }
}
