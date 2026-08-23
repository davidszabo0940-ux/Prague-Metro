package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzaoy implements Cloneable {
    private static final zzaoz bid = new zzaoz();
    private boolean bie;
    private int[] bif;
    private zzaoz[] big;
    private int mSize;

    zzaoy() {
        this(10);
    }

    zzaoy(int i) {
        this.bie = false;
        int iIdealIntArraySize = idealIntArraySize(i);
        this.bif = new int[iIdealIntArraySize];
        this.big = new zzaoz[iIdealIntArraySize];
        this.mSize = 0;
    }

    private int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzaoz[] zzaozVarArr, zzaoz[] zzaozVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzaozVarArr[i2].equals(zzaozVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzaey(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.bif[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else {
                if (i5 <= i) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return i2 ^ (-1);
    }

    /* JADX INFO: renamed from: ae, reason: merged with bridge method [inline-methods] */
    public final zzaoy clone() {
        int size = size();
        zzaoy zzaoyVar = new zzaoy(size);
        System.arraycopy(this.bif, 0, zzaoyVar.bif, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.big[i] != null) {
                zzaoyVar.big[i] = (zzaoz) this.big[i].clone();
            }
        }
        zzaoyVar.mSize = size;
        return zzaoyVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaoy)) {
            return false;
        }
        zzaoy zzaoyVar = (zzaoy) obj;
        if (size() != zzaoyVar.size()) {
            return false;
        }
        return zza(this.bif, zzaoyVar.bif, this.mSize) && zza(this.big, zzaoyVar.big, this.mSize);
    }

    public int hashCode() {
        int iHashCode = 17;
        for (int i = 0; i < this.mSize; i++) {
            iHashCode = (((iHashCode * 31) + this.bif[i]) * 31) + this.big[i].hashCode();
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    int size() {
        return this.mSize;
    }

    void zza(int i, zzaoz zzaozVar) {
        int iZzaey = zzaey(i);
        if (iZzaey >= 0) {
            this.big[iZzaey] = zzaozVar;
            return;
        }
        int i2 = iZzaey ^ (-1);
        if (i2 < this.mSize && this.big[i2] == bid) {
            this.bif[i2] = i;
            this.big[i2] = zzaozVar;
            return;
        }
        if (this.mSize >= this.bif.length) {
            int iIdealIntArraySize = idealIntArraySize(this.mSize + 1);
            int[] iArr = new int[iIdealIntArraySize];
            zzaoz[] zzaozVarArr = new zzaoz[iIdealIntArraySize];
            System.arraycopy(this.bif, 0, iArr, 0, this.bif.length);
            System.arraycopy(this.big, 0, zzaozVarArr, 0, this.big.length);
            this.bif = iArr;
            this.big = zzaozVarArr;
        }
        if (this.mSize - i2 != 0) {
            System.arraycopy(this.bif, i2, this.bif, i2 + 1, this.mSize - i2);
            System.arraycopy(this.big, i2, this.big, i2 + 1, this.mSize - i2);
        }
        this.bif[i2] = i;
        this.big[i2] = zzaozVar;
        this.mSize++;
    }

    zzaoz zzaew(int i) {
        int iZzaey = zzaey(i);
        if (iZzaey < 0 || this.big[iZzaey] == bid) {
            return null;
        }
        return this.big[iZzaey];
    }

    zzaoz zzaex(int i) {
        return this.big[i];
    }
}
