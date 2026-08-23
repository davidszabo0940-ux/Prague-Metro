package com.google.android.gms.internal;

import android.content.Context;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzja {
    private WeakHashMap<Context, zza> zzche = new WeakHashMap<>();

    private class zza {
        public final long zzchf = com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis();
        public final zziz zzchg;

        public zza(zziz zzizVar) {
            this.zzchg = zzizVar;
        }

        public boolean hasExpired() {
            return zzdc.zzbar.get().longValue() + this.zzchf < com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis();
        }
    }

    public zziz zzy(Context context) {
        zza zzaVar = this.zzche.get(context);
        zziz zzizVarZzro = (zzaVar == null || zzaVar.hasExpired() || !zzdc.zzbaq.get().booleanValue()) ? new zziz.zza(context).zzro() : new zziz.zza(context, zzaVar.zzchg).zzro();
        this.zzche.put(context, new zza(zzizVarZzro));
        return zzizVarZzro;
    }
}
