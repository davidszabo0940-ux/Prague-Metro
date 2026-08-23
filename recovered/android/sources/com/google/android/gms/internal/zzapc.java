package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzapc {
    protected volatile int bik = -1;

    public static final <T extends zzapc> T zza(T t, byte[] bArr) throws zzapb {
        return (T) zzb(t, bArr, 0, bArr.length);
    }

    public static final void zza(zzapc zzapcVar, byte[] bArr, int i, int i2) {
        try {
            zzaov zzaovVarZzc = zzaov.zzc(bArr, i, i2);
            zzapcVar.zza(zzaovVarZzc);
            zzaovVarZzc.m68ab();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends zzapc> T zzb(T t, byte[] bArr, int i, int i2) throws zzapb {
        try {
            zzaou zzaouVarZzb = zzaou.zzb(bArr, i, i2);
            t.zzb(zzaouVarZzb);
            zzaouVarZzb.zzaef(0);
            return t;
        } catch (zzapb e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] zzf(zzapc zzapcVar) {
        byte[] bArr = new byte[zzapcVar.m81ao()];
        zza(zzapcVar, bArr, 0, bArr.length);
        return bArr;
    }

    @Override // 
    /* JADX INFO: renamed from: ad, reason: merged with bridge method [inline-methods] */
    public zzapc clone() throws CloneNotSupportedException {
        return (zzapc) super.clone();
    }

    /* JADX INFO: renamed from: an */
    public int m80an() {
        if (this.bik < 0) {
            m81ao();
        }
        return this.bik;
    }

    /* JADX INFO: renamed from: ao */
    public int m81ao() {
        int iZzy = zzy();
        this.bik = iZzy;
        return iZzy;
    }

    public String toString() {
        return zzapd.zzg(this);
    }

    public void zza(zzaov zzaovVar) throws IOException {
    }

    public abstract zzapc zzb(zzaou zzaouVar) throws IOException;

    protected int zzy() {
        return 0;
    }
}
