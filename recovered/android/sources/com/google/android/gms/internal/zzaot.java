package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public class zzaot {
    private final byte[] bhO = new byte[256];
    private int bhP;
    private int bhQ;

    public zzaot(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.bhO[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = (i2 + this.bhO[i3] + bArr[i3 % bArr.length]) & 255;
            byte b = this.bhO[i3];
            this.bhO[i3] = this.bhO[i2];
            this.bhO[i2] = b;
        }
        this.bhP = 0;
        this.bhQ = 0;
    }

    public void zzay(byte[] bArr) {
        int i = this.bhP;
        int i2 = this.bhQ;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.bhO[i]) & 255;
            byte b = this.bhO[i];
            this.bhO[i] = this.bhO[i2];
            this.bhO[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.bhO[(this.bhO[i] + this.bhO[i2]) & 255]);
        }
        this.bhP = i;
        this.bhQ = i2;
    }
}
