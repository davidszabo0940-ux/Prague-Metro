package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzb implements Parcelable.Creator<Flag> {
    static void zza(Flag flag, Parcel parcel, int i) {
        int iZzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, flag.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, flag.name, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, flag.asc);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, flag.abu);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, flag.abw);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, flag.f866zr, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, flag.asd, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, flag.ase);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 9, flag.asf);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, iZzcm);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzpv, reason: merged with bridge method [inline-methods] */
    public Flag createFromParcel(Parcel parcel) {
        byte[] bArrZzt = null;
        int iZzg = 0;
        int iZzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
        long jZzi = 0;
        double dZzn = 0.0d;
        int iZzg2 = 0;
        String strZzq = null;
        boolean zZzc = false;
        String strZzq2 = null;
        int iZzg3 = 0;
        while (parcel.dataPosition() < iZzcl) {
            int iZzck = com.google.android.gms.common.internal.safeparcel.zza.zzck(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(iZzck)) {
                case 1:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 2:
                    strZzq2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 3:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzck);
                    break;
                case 4:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 5:
                    dZzn = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, iZzck);
                    break;
                case 6:
                    strZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 7:
                    bArrZzt = com.google.android.gms.common.internal.safeparcel.zza.zzt(parcel, iZzck);
                    break;
                case 8:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 9:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzck);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzcl) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0743zza(new StringBuilder(37).append("Overread allowed size end=").append(iZzcl).toString(), parcel);
        }
        return new Flag(iZzg3, strZzq2, jZzi, zZzc, dZzn, strZzq, bArrZzt, iZzg2, iZzg);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzwy, reason: merged with bridge method [inline-methods] */
    public Flag[] newArray(int i) {
        return new Flag[i];
    }
}
