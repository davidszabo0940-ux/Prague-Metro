package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzape {
    final byte[] bil;
    final int tag;

    zzape(int i, byte[] bArr) {
        this.tag = i;
        this.bil = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzape)) {
            return false;
        }
        zzape zzapeVar = (zzape) obj;
        return this.tag == zzapeVar.tag && Arrays.equals(this.bil, zzapeVar.bil);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.bil);
    }

    void zza(zzaov zzaovVar) throws IOException {
        zzaovVar.zzaes(this.tag);
        zzaovVar.zzbd(this.bil);
    }

    int zzy() {
        return zzaov.zzaet(this.tag) + 0 + this.bil.length;
    }
}
