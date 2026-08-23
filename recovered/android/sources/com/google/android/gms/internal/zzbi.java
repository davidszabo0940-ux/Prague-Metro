package com.google.android.gms.internal;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class zzbi implements Callable {
    private final zzax zzaey;
    private final zzae.zza zzaha;

    public zzbi(zzax zzaxVar, zzae.zza zzaVar) {
        this.zzaey = zzaxVar;
        this.zzaha = zzaVar;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: zzcy, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        if (this.zzaey.zzcn() != null) {
            this.zzaey.zzcn().get();
        }
        zzae.zza zzaVarZzcm = this.zzaey.zzcm();
        if (zzaVarZzcm == null) {
            return null;
        }
        try {
            synchronized (this.zzaha) {
                zzapc.zza(this.zzaha, zzapc.zzf(zzaVarZzcm));
            }
            return null;
        } catch (zzapb e) {
            return null;
        }
    }
}
