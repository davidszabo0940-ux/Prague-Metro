package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<Configuration> {
    static void zza(Configuration configuration, Parcel parcel, int i) {
        int iZzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, configuration.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, configuration.arY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable[]) configuration.arZ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, configuration.asa, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, iZzcm);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzpu, reason: merged with bridge method [inline-methods] */
    public Configuration createFromParcel(Parcel parcel) {
        String[] strArrZzac;
        Flag[] flagArr;
        int iZzg;
        int iZzg2;
        String[] strArr = null;
        int i = 0;
        int iZzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
        Flag[] flagArr2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < iZzcl) {
            int iZzck = com.google.android.gms.common.internal.safeparcel.zza.zzck(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(iZzck)) {
                case 1:
                    String[] strArr2 = strArr;
                    flagArr = flagArr2;
                    iZzg = i;
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    strArrZzac = strArr2;
                    break;
                case 2:
                    iZzg2 = i2;
                    Flag[] flagArr3 = flagArr2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    strArrZzac = strArr;
                    flagArr = flagArr3;
                    break;
                case 3:
                    iZzg = i;
                    iZzg2 = i2;
                    String[] strArr3 = strArr;
                    flagArr = (Flag[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzck, Flag.CREATOR);
                    strArrZzac = strArr3;
                    break;
                case 4:
                    strArrZzac = com.google.android.gms.common.internal.safeparcel.zza.zzac(parcel, iZzck);
                    flagArr = flagArr2;
                    iZzg = i;
                    iZzg2 = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzck);
                    strArrZzac = strArr;
                    flagArr = flagArr2;
                    iZzg = i;
                    iZzg2 = i2;
                    break;
            }
            i2 = iZzg2;
            i = iZzg;
            flagArr2 = flagArr;
            strArr = strArrZzac;
        }
        if (parcel.dataPosition() != iZzcl) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0743zza(new StringBuilder(37).append("Overread allowed size end=").append(iZzcl).toString(), parcel);
        }
        return new Configuration(i2, i, flagArr2, strArr);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzwx, reason: merged with bridge method [inline-methods] */
    public Configuration[] newArray(int i) {
        return new Configuration[i];
    }
}
