package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class zzpi {
    private static long zza(byte[] bArr, int i, int i2) {
        long j = 0;
        int iMin = Math.min(i2, 8);
        for (int i3 = 0; i3 < iMin; i3++) {
            j |= (((long) bArr[i + i3]) & 255) << (i3 * 8);
        }
        return j;
    }

    private static long zza(byte[] bArr, long j) {
        int length = bArr.length & (-8);
        int length2 = bArr.length & 7;
        long length3 = j ^ (((long) bArr.length) * (-4132994306676758123L));
        int i = 0;
        while (i < length) {
            long jZzaf = (length3 ^ (zzaf(zzb(bArr, i) * (-4132994306676758123L)) * (-4132994306676758123L))) * (-4132994306676758123L);
            i += 8;
            length3 = jZzaf;
        }
        if (length2 != 0) {
            length3 = (length3 ^ zza(bArr, length, length2)) * (-4132994306676758123L);
        }
        return zzaf(zzaf(length3) * (-4132994306676758123L));
    }

    private static void zza(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long jZzb = zzb(bArr, i);
        long jZzb2 = zzb(bArr, i + 8);
        long jZzb3 = zzb(bArr, i + 16);
        long jZzb4 = zzb(bArr, i + 24);
        long j3 = jZzb + j;
        long j4 = jZzb2 + j3 + jZzb3;
        long jRotateRight = Long.rotateRight(j4, 23) + Long.rotateRight(j2 + j3 + jZzb4, 51);
        jArr[0] = j4 + jZzb4;
        jArr[1] = j3 + jRotateRight;
    }

    private static long zzaf(long j) {
        return (j >>> 47) ^ j;
    }

    private static long zzb(byte[] bArr, int i) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, 8);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        return byteBufferWrap.getLong();
    }

    private static long zzc(long j, long j2) {
        long j3 = (j2 ^ j) * (-4132994306676758123L);
        long j4 = ((j3 ^ (j3 >>> 47)) ^ j) * (-4132994306676758123L);
        return (j4 ^ (j4 >>> 47)) * (-4132994306676758123L);
    }

    public static long zzm(byte[] bArr) {
        long jZzn;
        if (bArr.length <= 32) {
            jZzn = zza(bArr, -1397348546323613475L);
        } else {
            jZzn = bArr.length <= 64 ? zzn(bArr) : zzo(bArr);
        }
        long jZzc = zzc(jZzn + (bArr.length >= 9 ? zzb(bArr, bArr.length - 8) : -6505348102511208375L), bArr.length >= 8 ? zzb(bArr, 0) : -6505348102511208375L);
        return (jZzc == 0 || jZzc == 1) ? jZzc - 2 : jZzc;
    }

    private static long zzn(byte[] bArr) {
        int length = bArr.length;
        long jZzb = zzb(bArr, 24);
        long jZzb2 = zzb(bArr, 0) + ((((long) length) + zzb(bArr, length - 16)) * (-6505348102511208375L));
        long jRotateRight = Long.rotateRight(jZzb2 + jZzb, 52);
        long jRotateRight2 = Long.rotateRight(jZzb2, 37);
        long jZzb3 = jZzb2 + zzb(bArr, 8);
        long jRotateRight3 = jRotateRight2 + Long.rotateRight(jZzb3, 7);
        long jZzb4 = jZzb3 + zzb(bArr, 16);
        long j = jZzb + jZzb4;
        long jRotateRight4 = Long.rotateRight(jZzb4, 31) + jRotateRight + jRotateRight3;
        long jZzb5 = zzb(bArr, 16) + zzb(bArr, length - 32);
        long jZzb6 = zzb(bArr, length - 8);
        long jRotateRight5 = Long.rotateRight(jZzb5 + jZzb6, 52);
        long jRotateRight6 = Long.rotateRight(jZzb5, 37);
        long jZzb7 = jZzb5 + zzb(bArr, length - 24);
        long jRotateRight7 = jRotateRight6 + Long.rotateRight(jZzb7, 7);
        long jZzb8 = zzb(bArr, length - 16) + jZzb7;
        return zzaf((zzaf(((Long.rotateRight(jZzb8, 31) + jRotateRight5 + jRotateRight7 + j) * (-4288712594273399085L)) + ((jZzb8 + jZzb6 + jRotateRight4) * (-6505348102511208375L))) * (-6505348102511208375L)) + jRotateRight4) * (-4288712594273399085L);
    }

    private static long zzo(byte[] bArr) {
        int length = bArr.length;
        long jZzb = zzb(bArr, 0);
        long jZzb2 = zzb(bArr, length - 16) ^ (-8261664234251669945L);
        long jZzb3 = zzb(bArr, length - 56) ^ (-6505348102511208375L);
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        zza(bArr, length - 64, length, jZzb2, jArr);
        zza(bArr, length - 32, ((long) length) * (-8261664234251669945L), -6505348102511208375L, jArr2);
        long jZzaf = jZzb3 + (zzaf(jArr[1]) * (-8261664234251669945L));
        long jRotateRight = (-8261664234251669945L) * Long.rotateRight(jZzaf + jZzb, 39);
        long jRotateRight2 = Long.rotateRight(jZzb2, 33) * (-8261664234251669945L);
        int i = (length - 1) & (-64);
        int i2 = 0;
        long j = jRotateRight;
        while (true) {
            long jRotateRight3 = Long.rotateRight(j + jRotateRight2 + jArr[0] + zzb(bArr, i2 + 16), 37) * (-8261664234251669945L);
            long jRotateRight4 = Long.rotateRight(jArr[1] + jRotateRight2 + zzb(bArr, i2 + 48), 42) * (-8261664234251669945L);
            long j2 = jRotateRight3 ^ jArr2[1];
            jRotateRight2 = jRotateRight4 ^ jArr[0];
            long jRotateRight5 = Long.rotateRight(jZzaf ^ jArr2[0], 33);
            zza(bArr, i2, jArr[1] * (-8261664234251669945L), jArr2[0] + j2, jArr);
            zza(bArr, i2 + 32, jRotateRight5 + jArr2[1], jRotateRight2, jArr2);
            i2 += 64;
            i -= 64;
            if (i == 0) {
                return zzc(zzc(jArr[0], jArr2[0]) + (zzaf(jRotateRight2) * (-8261664234251669945L)) + j2, zzc(jArr[1], jArr2[1]) + jRotateRight5);
            }
            jZzaf = j2;
            j = jRotateRight5;
        }
    }
}
