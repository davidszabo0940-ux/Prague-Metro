package com.google.android.gms.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzak {
    static boolean zzxe = false;
    private static MessageDigest zzxf = null;
    private static final Object zzxg = new Object();
    private static final Object zzxh = new Object();
    static CountDownLatch zzxi = new CountDownLatch(1);

    private static final class zza implements Runnable {
        private zza() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MessageDigest unused = zzak.zzxf = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            } finally {
                zzak.zzxi.countDown();
            }
        }
    }

    private static int zza(boolean z) {
        return z ? 239 : 255;
    }

    static String zza(zzae.zza zzaVar, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return zza(zzapc.zzf(zzaVar), str, z);
    }

    static String zza(String str, String str2, boolean z) {
        byte[] bArrZzb = zzb(str, str2, z);
        return bArrZzb != null ? zzaj.zza(bArrZzb, true) : Integer.toString(7);
    }

    static String zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return zzaj.zza(z ? zzb(bArr, str) : zza(bArr, str), true);
    }

    static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + i) - 1) / i;
        Vector<byte[]> vector = new Vector<>();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * i;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > i ? i3 + i : bArr.length));
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    static void zza(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new zzaot(str.getBytes("UTF-8")).zzay(bArr);
    }

    static byte[] zza(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Vector<byte[]> vectorZza = zza(bArr, 255);
        if (vectorZza == null || vectorZza.size() == 0) {
            return zzb(zzapc.zzf(zzb(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)), str);
        }
        zzae.zzf zzfVar = new zzae.zzf();
        zzfVar.zzey = new byte[vectorZza.size()][];
        Iterator<byte[]> it = vectorZza.iterator();
        int i = 0;
        while (it.hasNext()) {
            zzfVar.zzey[i] = zzb(it.next(), str, false);
            i++;
        }
        zzfVar.zzet = zzg(bArr);
        return zzapc.zzf(zzfVar);
    }

    static void zzas() {
        synchronized (zzxh) {
            if (!zzxe) {
                zzxe = true;
                new Thread(new zza()).start();
            }
        }
    }

    static MessageDigest zzat() {
        zzas();
        boolean zAwait = false;
        try {
            zAwait = zzxi.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        if (zAwait && zzxf != null) {
            return zzxf;
        }
        return null;
    }

    static zzae.zza zzb(long j) {
        zzae.zza zzaVar = new zzae.zza();
        zzaVar.zzdl = Long.valueOf(j);
        return zzaVar;
    }

    static byte[] zzb(String str, String str2, boolean z) {
        byte[] bytes;
        zzae.zzc zzcVar = new zzae.zzc();
        try {
            zzcVar.zzer = str.length() < 3 ? str.getBytes("ISO-8859-1") : zzaj.zza(str, true);
            if (z) {
                bytes = str2.length() < 3 ? str2.getBytes("ISO-8859-1") : zzaj.zza(str2, true);
            } else {
                bytes = (str2 == null || str2.length() == 0) ? Integer.toString(5).getBytes("ISO-8859-1") : zzaj.zza(zza(str2.getBytes("ISO-8859-1"), (String) null, true), true);
            }
            zzcVar.zzes = bytes;
            return zzapc.zzf(zzcVar);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            return null;
        }
    }

    static byte[] zzb(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return zzb(bArr, str, true);
    }

    private static byte[] zzb(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArrArray;
        int iZza = zza(z);
        if (bArr.length > iZza) {
            bArr = zzapc.zzf(zzb(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        }
        if (bArr.length < iZza) {
            byte[] bArr2 = new byte[iZza - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            bArrArray = ByteBuffer.allocate(iZza + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArrArray = ByteBuffer.allocate(iZza + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            bArrArray = ByteBuffer.allocate(256).put(zzg(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        new zzal().zzb(bArrArray, bArr3);
        if (str != null && str.length() > 0) {
            zza(str, bArr3);
        }
        return bArr3;
    }

    public static byte[] zzg(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] bArrDigest;
        synchronized (zzxg) {
            MessageDigest messageDigestZzat = zzat();
            if (messageDigestZzat == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            messageDigestZzat.reset();
            messageDigestZzat.update(bArr);
            bArrDigest = zzxf.digest();
        }
        return bArrDigest;
    }
}
