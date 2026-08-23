package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zza {

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.safeparcel.zza$zza, reason: collision with other inner class name */
    public static class C0743zza extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        public C0743zza(String str, Parcel parcel) {
            int iDataPosition = parcel.dataPosition();
            super(new StringBuilder(String.valueOf(str).length() + 41).append(str).append(" Parcel: pos=").append(iDataPosition).append(" size=").append(parcel.dataSize()).toString());
        }
    }

    public static int zza(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != -65536 ? (i >> 16) & SupportMenu.USER_MASK : parcel.readInt();
    }

    public static <T extends Parcelable> T zza(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iZza + iDataPosition);
        return tCreateFromParcel;
    }

    private static void zza(Parcel parcel, int i, int i2) {
        int iZza = zza(parcel, i);
        if (iZza != i2) {
            String strValueOf = String.valueOf(Integer.toHexString(iZza));
            throw new C0743zza(new StringBuilder(String.valueOf(strValueOf).length() + 46).append("Expected size ").append(i2).append(" got ").append(iZza).append(" (0x").append(strValueOf).append(")").toString(), parcel);
        }
    }

    private static void zza(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String strValueOf = String.valueOf(Integer.toHexString(i2));
            throw new C0743zza(new StringBuilder(String.valueOf(strValueOf).length() + 46).append("Expected size ").append(i3).append(" got ").append(i2).append(" (0x").append(strValueOf).append(")").toString(), parcel);
        }
    }

    public static void zza(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(iZza + iDataPosition);
    }

    public static double[] zzaa(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        double[] dArrCreateDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(iZza + iDataPosition);
        return dArrCreateDoubleArray;
    }

    public static BigDecimal[] zzab(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        int i2 = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            bigDecimalArr[i3] = new BigDecimal(new BigInteger(bArrCreateByteArray), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + iZza);
        return bigDecimalArr;
    }

    public static String[] zzac(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iZza + iDataPosition);
        return strArrCreateStringArray;
    }

    public static ArrayList<Integer> zzad(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i2 = parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(iDataPosition + iZza);
        return arrayList;
    }

    public static ArrayList<String> zzae(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iZza + iDataPosition);
        return arrayListCreateStringArrayList;
    }

    public static Parcel zzaf(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(parcel, iDataPosition, iZza);
        parcel.setDataPosition(iZza + iDataPosition);
        return parcelObtain;
    }

    public static Parcel[] zzag(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        int i2 = parcel.readInt();
        Parcel[] parcelArr = new Parcel[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = parcel.readInt();
            if (i4 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i4);
                parcelArr[i3] = parcelObtain;
                parcel.setDataPosition(i4 + iDataPosition2);
            } else {
                parcelArr[i3] = null;
            }
        }
        parcel.setDataPosition(iDataPosition + iZza);
        return parcelArr;
    }

    public static void zzb(Parcel parcel, int i) {
        parcel.setDataPosition(zza(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] zzb(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iZza + iDataPosition);
        return tArr;
    }

    public static <T> ArrayList<T> zzc(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iZza + iDataPosition);
        return arrayListCreateTypedArrayList;
    }

    public static boolean zzc(Parcel parcel, int i) {
        zza(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int zzck(Parcel parcel) {
        return parcel.readInt();
    }

    public static int zzcl(Parcel parcel) {
        int iZzck = zzck(parcel);
        int iZza = zza(parcel, iZzck);
        int iDataPosition = parcel.dataPosition();
        if (zzgi(iZzck) != 20293) {
            String strValueOf = String.valueOf(Integer.toHexString(iZzck));
            throw new C0743zza(strValueOf.length() != 0 ? "Expected object header. Got 0x".concat(strValueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i = iDataPosition + iZza;
        if (i < iDataPosition || i > parcel.dataSize()) {
            throw new C0743zza(new StringBuilder(54).append("Size read is invalid start=").append(iDataPosition).append(" end=").append(i).toString(), parcel);
        }
        return i;
    }

    public static Boolean zzd(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        if (iZza == 0) {
            return null;
        }
        zza(parcel, i, iZza, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte zze(Parcel parcel, int i) {
        zza(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static short zzf(Parcel parcel, int i) {
        zza(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int zzg(Parcel parcel, int i) {
        zza(parcel, i, 4);
        return parcel.readInt();
    }

    public static int zzgi(int i) {
        return 65535 & i;
    }

    public static Integer zzh(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        if (iZza == 0) {
            return null;
        }
        zza(parcel, i, iZza, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long zzi(Parcel parcel, int i) {
        zza(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long zzj(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        if (iZza == 0) {
            return null;
        }
        zza(parcel, i, iZza, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static BigInteger zzk(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iZza + iDataPosition);
        return new BigInteger(bArrCreateByteArray);
    }

    public static float zzl(Parcel parcel, int i) {
        zza(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float zzm(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        if (iZza == 0) {
            return null;
        }
        zza(parcel, i, iZza, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static double zzn(Parcel parcel, int i) {
        zza(parcel, i, 8);
        return parcel.readDouble();
    }

    public static Double zzo(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        if (iZza == 0) {
            return null;
        }
        zza(parcel, i, iZza, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static BigDecimal zzp(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i2 = parcel.readInt();
        parcel.setDataPosition(iZza + iDataPosition);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i2);
    }

    public static String zzq(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iZza + iDataPosition);
        return string;
    }

    public static IBinder zzr(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iZza + iDataPosition);
        return strongBinder;
    }

    public static Bundle zzs(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iZza + iDataPosition);
        return bundle;
    }

    public static byte[] zzt(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iZza + iDataPosition);
        return bArrCreateByteArray;
    }

    public static byte[][] zzu(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        int i2 = parcel.readInt();
        byte[][] bArr = new byte[i2][];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = parcel.createByteArray();
        }
        parcel.setDataPosition(iDataPosition + iZza);
        return bArr;
    }

    public static boolean[] zzv(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(iZza + iDataPosition);
        return zArrCreateBooleanArray;
    }

    public static int[] zzw(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iZza + iDataPosition);
        return iArrCreateIntArray;
    }

    public static long[] zzx(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iZza + iDataPosition);
        return jArrCreateLongArray;
    }

    public static BigInteger[] zzy(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        int i2 = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bigIntegerArr[i3] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(iDataPosition + iZza);
        return bigIntegerArr;
    }

    public static float[] zzz(Parcel parcel, int i) {
        int iZza = zza(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZza == 0) {
            return null;
        }
        float[] fArrCreateFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(iZza + iDataPosition);
        return fArrCreateFloatArray;
    }
}
