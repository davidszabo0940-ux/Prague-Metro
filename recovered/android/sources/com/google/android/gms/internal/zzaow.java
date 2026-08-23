package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaow;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzaow<M extends zzaow<M>> extends zzapc {
    protected zzaoy bib;

    @Override // com.google.android.gms.internal.zzapc
    /* JADX INFO: renamed from: ac, reason: merged with bridge method [inline-methods] */
    public M clone() throws CloneNotSupportedException {
        M m = (M) super.clone();
        zzapa.zza(this, m);
        return m;
    }

    @Override // com.google.android.gms.internal.zzapc
    /* JADX INFO: renamed from: ad */
    public /* synthetic */ zzapc clone() throws CloneNotSupportedException {
        return (zzaow) clone();
    }

    public final <T> T zza(zzaox<M, T> zzaoxVar) {
        zzaoz zzaozVarZzaew;
        if (this.bib == null || (zzaozVarZzaew = this.bib.zzaew(zzapf.zzafa(zzaoxVar.tag))) == null) {
            return null;
        }
        return (T) zzaozVarZzaew.zzb(zzaoxVar);
    }

    @Override // com.google.android.gms.internal.zzapc
    public void zza(zzaov zzaovVar) throws IOException {
        if (this.bib == null) {
            return;
        }
        for (int i = 0; i < this.bib.size(); i++) {
            this.bib.zzaex(i).zza(zzaovVar);
        }
    }

    protected final boolean zza(zzaou zzaouVar, int i) throws IOException {
        int position = zzaouVar.getPosition();
        if (!zzaouVar.zzaeg(i)) {
            return false;
        }
        int iZzafa = zzapf.zzafa(i);
        zzape zzapeVar = new zzape(i, zzaouVar.zzad(position, zzaouVar.getPosition() - position));
        zzaoz zzaozVarZzaew = null;
        if (this.bib == null) {
            this.bib = new zzaoy();
        } else {
            zzaozVarZzaew = this.bib.zzaew(iZzafa);
        }
        if (zzaozVarZzaew == null) {
            zzaozVarZzaew = new zzaoz();
            this.bib.zza(iZzafa, zzaozVarZzaew);
        }
        zzaozVarZzaew.zza(zzapeVar);
        return true;
    }

    @Override // com.google.android.gms.internal.zzapc
    protected int zzy() {
        if (this.bib == null) {
            return 0;
        }
        int iZzy = 0;
        for (int i = 0; i < this.bib.size(); i++) {
            iZzy += this.bib.zzaex(i).zzy();
        }
        return iZzy;
    }
}
