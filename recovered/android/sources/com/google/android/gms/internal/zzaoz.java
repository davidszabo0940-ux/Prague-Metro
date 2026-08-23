package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class zzaoz implements Cloneable {
    private Object aQx;
    private zzaox<?, ?> bih;
    private List<zzape> bii = new ArrayList();

    zzaoz() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzy()];
        zza(zzaov.zzba(bArr));
        return bArr;
    }

    /* JADX INFO: renamed from: af, reason: merged with bridge method [inline-methods] */
    public final zzaoz clone() {
        int i = 0;
        zzaoz zzaozVar = new zzaoz();
        try {
            zzaozVar.bih = this.bih;
            if (this.bii == null) {
                zzaozVar.bii = null;
            } else {
                zzaozVar.bii.addAll(this.bii);
            }
            if (this.aQx != null) {
                if (this.aQx instanceof zzapc) {
                    zzaozVar.aQx = (zzapc) ((zzapc) this.aQx).clone();
                } else if (this.aQx instanceof byte[]) {
                    zzaozVar.aQx = ((byte[]) this.aQx).clone();
                } else if (this.aQx instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.aQx;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzaozVar.aQx = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.aQx instanceof boolean[]) {
                    zzaozVar.aQx = ((boolean[]) this.aQx).clone();
                } else if (this.aQx instanceof int[]) {
                    zzaozVar.aQx = ((int[]) this.aQx).clone();
                } else if (this.aQx instanceof long[]) {
                    zzaozVar.aQx = ((long[]) this.aQx).clone();
                } else if (this.aQx instanceof float[]) {
                    zzaozVar.aQx = ((float[]) this.aQx).clone();
                } else if (this.aQx instanceof double[]) {
                    zzaozVar.aQx = ((double[]) this.aQx).clone();
                } else if (this.aQx instanceof zzapc[]) {
                    zzapc[] zzapcVarArr = (zzapc[]) this.aQx;
                    zzapc[] zzapcVarArr2 = new zzapc[zzapcVarArr.length];
                    zzaozVar.aQx = zzapcVarArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzapcVarArr.length) {
                            break;
                        }
                        zzapcVarArr2[i3] = (zzapc) zzapcVarArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return zzaozVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaoz)) {
            return false;
        }
        zzaoz zzaozVar = (zzaoz) obj;
        if (this.aQx == null || zzaozVar.aQx == null) {
            if (this.bii != null && zzaozVar.bii != null) {
                return this.bii.equals(zzaozVar.bii);
            }
            try {
                return Arrays.equals(toByteArray(), zzaozVar.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        if (this.bih != zzaozVar.bih) {
            return false;
        }
        if (!this.bih.bau.isArray()) {
            return this.aQx.equals(zzaozVar.aQx);
        }
        if (this.aQx instanceof byte[]) {
            return Arrays.equals((byte[]) this.aQx, (byte[]) zzaozVar.aQx);
        }
        if (this.aQx instanceof int[]) {
            return Arrays.equals((int[]) this.aQx, (int[]) zzaozVar.aQx);
        }
        if (this.aQx instanceof long[]) {
            return Arrays.equals((long[]) this.aQx, (long[]) zzaozVar.aQx);
        }
        if (this.aQx instanceof float[]) {
            return Arrays.equals((float[]) this.aQx, (float[]) zzaozVar.aQx);
        }
        if (this.aQx instanceof double[]) {
            return Arrays.equals((double[]) this.aQx, (double[]) zzaozVar.aQx);
        }
        return this.aQx instanceof boolean[] ? Arrays.equals((boolean[]) this.aQx, (boolean[]) zzaozVar.aQx) : Arrays.deepEquals((Object[]) this.aQx, (Object[]) zzaozVar.aQx);
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    void zza(zzaov zzaovVar) throws IOException {
        if (this.aQx != null) {
            this.bih.zza(this.aQx, zzaovVar);
            return;
        }
        Iterator<zzape> it = this.bii.iterator();
        while (it.hasNext()) {
            it.next().zza(zzaovVar);
        }
    }

    void zza(zzape zzapeVar) {
        this.bii.add(zzapeVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> T zzb(zzaox<?, T> zzaoxVar) {
        if (this.aQx == null) {
            this.bih = zzaoxVar;
            this.aQx = zzaoxVar.zzav(this.bii);
            this.bii = null;
        } else if (!this.bih.equals(zzaoxVar)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return (T) this.aQx;
    }

    int zzy() {
        int iZzy = 0;
        if (this.aQx != null) {
            return this.bih.zzcr(this.aQx);
        }
        Iterator<zzape> it = this.bii.iterator();
        while (true) {
            int i = iZzy;
            if (!it.hasNext()) {
                return i;
            }
            iZzy = it.next().zzy() + i;
        }
    }
}
