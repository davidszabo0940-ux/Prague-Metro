package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class zzau {
    private static Cipher zzagb = null;
    private static final Object zzagc = new Object();
    private static final Object zzagd = new Object();
    private final SecureRandom zzaga;

    public class zza extends Exception {
        public zza() {
        }

        public zza(Throwable th) {
            super(th);
        }
    }

    public zzau(SecureRandom secureRandom) {
        this.zzaga = secureRandom;
    }

    private Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher;
        synchronized (zzagd) {
            if (zzagb == null) {
                zzagb = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = zzagb;
        }
        return cipher;
    }

    static void zzh(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] zzc(byte[] bArr, String str) throws zza {
        byte[] bArrDoFinal;
        if (bArr.length != 16) {
            throw new zza();
        }
        try {
            byte[] bArrZza = zzaj.zza(str, false);
            if (bArrZza.length <= 16) {
                throw new zza();
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrZza.length);
            byteBufferAllocate.put(bArrZza);
            byteBufferAllocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArrZza.length - 16];
            byteBufferAllocate.get(bArr2);
            byteBufferAllocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzagc) {
                getCipher().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                bArrDoFinal = getCipher().doFinal(bArr3);
            }
            return bArrDoFinal;
        } catch (IllegalArgumentException e) {
            throw new zza(e);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new zza(e2);
        } catch (InvalidKeyException e3) {
            throw new zza(e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new zza(e4);
        } catch (BadPaddingException e5) {
            throw new zza(e5);
        } catch (IllegalBlockSizeException e6) {
            throw new zza(e6);
        } catch (NoSuchPaddingException e7) {
            throw new zza(e7);
        }
    }

    public String zzd(byte[] bArr, byte[] bArr2) throws zza {
        byte[] bArrDoFinal;
        byte[] iv;
        if (bArr.length != 16) {
            throw new zza();
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzagc) {
                getCipher().init(1, secretKeySpec, this.zzaga);
                bArrDoFinal = getCipher().doFinal(bArr2);
                iv = getCipher().getIV();
            }
            int length = bArrDoFinal.length + iv.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
            byteBufferAllocate.put(iv).put(bArrDoFinal);
            byteBufferAllocate.flip();
            byte[] bArr3 = new byte[length];
            byteBufferAllocate.get(bArr3);
            return zzaj.zza(bArr3, false);
        } catch (InvalidKeyException e) {
            throw new zza(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new zza(e2);
        } catch (BadPaddingException e3) {
            throw new zza(e3);
        } catch (IllegalBlockSizeException e4) {
            throw new zza(e4);
        } catch (NoSuchPaddingException e5) {
            throw new zza(e5);
        }
    }

    public byte[] zzl(String str) throws zza {
        try {
            byte[] bArrZza = zzaj.zza(str, false);
            if (bArrZza.length != 32) {
                throw new zza();
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(bArrZza, 4, 16).get(bArr);
            zzh(bArr);
            return bArr;
        } catch (IllegalArgumentException e) {
            throw new zza(e);
        }
    }
}
