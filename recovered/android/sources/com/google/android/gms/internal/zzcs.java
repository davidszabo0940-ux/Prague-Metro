package com.google.android.gms.internal;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzcs extends zzcp {
    private MessageDigest zzatf;

    byte[] zza(String[] strArr) {
        if (strArr.length == 1) {
            return zzcr.zzn(zzcr.zzac(strArr[0]));
        }
        if (strArr.length >= 5) {
            byte[] bArr = new byte[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                bArr[i] = zzp(zzcr.zzac(strArr[i]));
            }
            return bArr;
        }
        byte[] bArr2 = new byte[strArr.length * 2];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            byte[] bArrZzq = zzq(zzcr.zzac(strArr[i2]));
            bArr2[i2 * 2] = bArrZzq[0];
            bArr2[(i2 * 2) + 1] = bArrZzq[1];
        }
        return bArr2;
    }

    @Override // com.google.android.gms.internal.zzcp
    public byte[] zzaa(String str) {
        byte[] bArr;
        byte[] bArrZza = zza(str.split(" "));
        this.zzatf = zzie();
        synchronized (this.zzail) {
            if (this.zzatf == null) {
                bArr = new byte[0];
            } else {
                this.zzatf.reset();
                this.zzatf.update(bArrZza);
                byte[] bArrDigest = this.zzatf.digest();
                bArr = new byte[bArrDigest.length <= 4 ? bArrDigest.length : 4];
                System.arraycopy(bArrDigest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }

    byte zzp(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ (((-16777216) & i) >> 24));
    }

    byte[] zzq(int i) {
        int i2 = (65535 & i) ^ (((-65536) & i) >> 16);
        return new byte[]{(byte) i2, (byte) (i2 >> 8)};
    }
}
