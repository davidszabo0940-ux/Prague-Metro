package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzamv extends zzamy implements Iterable<zzamy> {
    private final List<zzamy> aFD = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzamv) && ((zzamv) obj).aFD.equals(this.aFD));
    }

    public int hashCode() {
        return this.aFD.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<zzamy> iterator() {
        return this.aFD.iterator();
    }

    public void zzc(zzamy zzamyVar) {
        if (zzamyVar == null) {
            zzamyVar = zzana.bes;
        }
        this.aFD.add(zzamyVar);
    }

    @Override // com.google.android.gms.internal.zzamy
    public Number zzczg() {
        if (this.aFD.size() == 1) {
            return this.aFD.get(0).zzczg();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.zzamy
    public String zzczh() {
        if (this.aFD.size() == 1) {
            return this.aFD.get(0).zzczh();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.zzamy
    public double zzczi() {
        if (this.aFD.size() == 1) {
            return this.aFD.get(0).zzczi();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.zzamy
    public long zzczj() {
        if (this.aFD.size() == 1) {
            return this.aFD.get(0).zzczj();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.zzamy
    public int zzczk() {
        if (this.aFD.size() == 1) {
            return this.aFD.get(0).zzczk();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.zzamy
    public boolean zzczl() {
        if (this.aFD.size() == 1) {
            return this.aFD.get(0).zzczl();
        }
        throw new IllegalStateException();
    }
}
