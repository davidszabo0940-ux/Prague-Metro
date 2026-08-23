package com.google.android.gms.internal;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzaou {
    private int bhR;
    private int bhS;
    private int bhT;
    private int bhU;
    private int bhV;
    private int bhX;
    private final byte[] buffer;
    private int bhW = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int bhY = 64;
    private int bhZ = 67108864;

    private zzaou(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.bhR = i;
        this.bhS = i + i2;
        this.bhU = i;
    }

    /* JADX INFO: renamed from: W */
    private void m50W() {
        this.bhS += this.bhT;
        int i = this.bhS;
        if (i <= this.bhW) {
            this.bhT = 0;
        } else {
            this.bhT = i - this.bhW;
            this.bhS -= this.bhT;
        }
    }

    public static int zzaeh(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static zzaou zzaz(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static zzaou zzb(byte[] bArr, int i, int i2) {
        return new zzaou(bArr, i, i2);
    }

    public static long zzcq(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    /* JADX INFO: renamed from: J */
    public int m51J() throws IOException {
        if (m65Y()) {
            this.bhV = 0;
            return 0;
        }
        this.bhV = m60S();
        if (this.bhV == 0) {
            throw zzapb.m76aj();
        }
        return this.bhV;
    }

    /* JADX INFO: renamed from: K */
    public void m52K() throws IOException {
        int iM51J;
        do {
            iM51J = m51J();
            if (iM51J == 0) {
                return;
            }
        } while (zzaeg(iM51J));
    }

    /* JADX INFO: renamed from: L */
    public long m53L() throws IOException {
        return m61T();
    }

    /* JADX INFO: renamed from: M */
    public long m54M() throws IOException {
        return m61T();
    }

    /* JADX INFO: renamed from: N */
    public int m55N() throws IOException {
        return m60S();
    }

    /* JADX INFO: renamed from: O */
    public long m56O() throws IOException {
        return m63V();
    }

    /* JADX INFO: renamed from: P */
    public boolean m57P() throws IOException {
        return m60S() != 0;
    }

    /* JADX INFO: renamed from: Q */
    public int m58Q() throws IOException {
        return zzaeh(m60S());
    }

    /* JADX INFO: renamed from: R */
    public long m59R() throws IOException {
        return zzcq(m61T());
    }

    /* JADX INFO: renamed from: S */
    public int m60S() throws IOException {
        byte bM66Z = m66Z();
        if (bM66Z >= 0) {
            return bM66Z;
        }
        int i = bM66Z & 127;
        byte bM66Z2 = m66Z();
        if (bM66Z2 >= 0) {
            return i | (bM66Z2 << 7);
        }
        int i2 = i | ((bM66Z2 & 127) << 7);
        byte bM66Z3 = m66Z();
        if (bM66Z3 >= 0) {
            return i2 | (bM66Z3 << 14);
        }
        int i3 = i2 | ((bM66Z3 & 127) << 14);
        byte bM66Z4 = m66Z();
        if (bM66Z4 >= 0) {
            return i3 | (bM66Z4 << 21);
        }
        int i4 = i3 | ((bM66Z4 & 127) << 21);
        byte bM66Z5 = m66Z();
        int i5 = i4 | (bM66Z5 << 28);
        if (bM66Z5 >= 0) {
            return i5;
        }
        for (int i6 = 0; i6 < 5; i6++) {
            if (m66Z() >= 0) {
                return i5;
            }
        }
        throw zzapb.m75ai();
    }

    /* JADX INFO: renamed from: T */
    public long m61T() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bM66Z = m66Z();
            j |= ((long) (bM66Z & 127)) << i;
            if ((bM66Z & 128) == 0) {
                return j;
            }
        }
        throw zzapb.m75ai();
    }

    /* JADX INFO: renamed from: U */
    public int m62U() throws IOException {
        return (m66Z() & 255) | ((m66Z() & 255) << 8) | ((m66Z() & 255) << 16) | ((m66Z() & 255) << 24);
    }

    /* JADX INFO: renamed from: V */
    public long m63V() throws IOException {
        byte bM66Z = m66Z();
        return ((((long) m66Z()) & 255) << 8) | (((long) bM66Z) & 255) | ((((long) m66Z()) & 255) << 16) | ((((long) m66Z()) & 255) << 24) | ((((long) m66Z()) & 255) << 32) | ((((long) m66Z()) & 255) << 40) | ((((long) m66Z()) & 255) << 48) | ((((long) m66Z()) & 255) << 56);
    }

    /* JADX INFO: renamed from: X */
    public int m64X() {
        if (this.bhW == Integer.MAX_VALUE) {
            return -1;
        }
        return this.bhW - this.bhU;
    }

    /* JADX INFO: renamed from: Y */
    public boolean m65Y() {
        return this.bhU == this.bhS;
    }

    /* JADX INFO: renamed from: Z */
    public byte m66Z() throws IOException {
        if (this.bhU == this.bhS) {
            throw zzapb.m73ag();
        }
        byte[] bArr = this.buffer;
        int i = this.bhU;
        this.bhU = i + 1;
        return bArr[i];
    }

    public int getPosition() {
        return this.bhU - this.bhR;
    }

    public byte[] readBytes() throws IOException {
        int iM60S = m60S();
        if (iM60S < 0) {
            throw zzapb.m74ah();
        }
        if (iM60S == 0) {
            return zzapf.bit;
        }
        if (iM60S > this.bhS - this.bhU) {
            throw zzapb.m73ag();
        }
        byte[] bArr = new byte[iM60S];
        System.arraycopy(this.buffer, this.bhU, bArr, 0, iM60S);
        this.bhU = iM60S + this.bhU;
        return bArr;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(m63V());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(m62U());
    }

    public String readString() throws IOException {
        int iM60S = m60S();
        if (iM60S < 0) {
            throw zzapb.m74ah();
        }
        if (iM60S > this.bhS - this.bhU) {
            throw zzapb.m73ag();
        }
        String str = new String(this.buffer, this.bhU, iM60S, zzapa.UTF_8);
        this.bhU = iM60S + this.bhU;
        return str;
    }

    public void zza(zzapc zzapcVar) throws IOException {
        int iM60S = m60S();
        if (this.bhX >= this.bhY) {
            throw zzapb.m79am();
        }
        int iZzaei = zzaei(iM60S);
        this.bhX++;
        zzapcVar.zzb(this);
        zzaef(0);
        this.bhX--;
        zzaej(iZzaei);
    }

    public void zza(zzapc zzapcVar, int i) throws IOException {
        if (this.bhX >= this.bhY) {
            throw zzapb.m79am();
        }
        this.bhX++;
        zzapcVar.zzb(this);
        zzaef(zzapf.zzaj(i, 4));
        this.bhX--;
    }

    public byte[] zzad(int i, int i2) {
        if (i2 == 0) {
            return zzapf.bit;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.bhR + i, bArr, 0, i2);
        return bArr;
    }

    public void zzaef(int i) throws zzapb {
        if (this.bhV != i) {
            throw zzapb.m77ak();
        }
    }

    public boolean zzaeg(int i) throws IOException {
        switch (zzapf.zzaez(i)) {
            case 0:
                m55N();
                return true;
            case 1:
                m63V();
                return true;
            case 2:
                zzael(m60S());
                return true;
            case 3:
                m52K();
                zzaef(zzapf.zzaj(zzapf.zzafa(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                m62U();
                return true;
            default:
                throw zzapb.m78al();
        }
    }

    public int zzaei(int i) throws zzapb {
        if (i < 0) {
            throw zzapb.m74ah();
        }
        int i2 = this.bhU + i;
        int i3 = this.bhW;
        if (i2 > i3) {
            throw zzapb.m73ag();
        }
        this.bhW = i2;
        m50W();
        return i3;
    }

    public void zzaej(int i) {
        this.bhW = i;
        m50W();
    }

    public void zzaek(int i) {
        if (i > this.bhU - this.bhR) {
            throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(i).append(" is beyond current ").append(this.bhU - this.bhR).toString());
        }
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(i).toString());
        }
        this.bhU = this.bhR + i;
    }

    public void zzael(int i) throws IOException {
        if (i < 0) {
            throw zzapb.m74ah();
        }
        if (this.bhU + i > this.bhW) {
            zzael(this.bhW - this.bhU);
            throw zzapb.m73ag();
        }
        if (i > this.bhS - this.bhU) {
            throw zzapb.m73ag();
        }
        this.bhU += i;
    }
}
