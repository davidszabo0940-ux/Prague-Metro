package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes.dex */
public class zzam {
    protected static volatile com.google.android.gms.clearcut.zzb zzaez = null;
    private static volatile Random zzafb = null;
    private static final Object zzafc = new Object();
    private zzax zzaey;
    protected boolean zzafa;

    public zzam(zzax zzaxVar) {
        this.zzafa = false;
        this.zzaey = zzaxVar;
        zzdc.initialize(zzaxVar.getContext());
        this.zzafa = zzdc.zzbbg.get().booleanValue();
        if (this.zzafa && zzaez == null) {
            synchronized (zzafc) {
                if (zzaez == null) {
                    zzaez = new com.google.android.gms.clearcut.zzb(zzaxVar.getContext(), "ADSHIELD", null);
                }
            }
        }
    }

    private static Random zzav() {
        if (zzafb == null) {
            synchronized (zzafc) {
                if (zzafb == null) {
                    zzafb = new Random();
                }
            }
        }
        return zzafb;
    }

    public void zza(int i, int i2, long j) throws IOException {
        try {
            if (this.zzafa && zzaez != null && this.zzaey.zzck()) {
                zzad.zza zzaVar = new zzad.zza();
                zzaVar.zzck = this.zzaey.getContext().getPackageName();
                zzaVar.zzcl = Long.valueOf(j);
                com.google.android.gms.clearcut.zzb.zza zzaVarZzl = zzaez.zzl(zzapc.zzf(zzaVar));
                zzaVarZzl.zzex(i2);
                zzaVarZzl.zzew(i);
                zzaVarZzl.zze(this.zzaey.zzci());
            }
        } catch (Exception e) {
        }
    }

    public int zzau() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (NoClassDefFoundError e) {
            return zzav().nextInt();
        } catch (RuntimeException e2) {
            return zzav().nextInt();
        }
    }
}
