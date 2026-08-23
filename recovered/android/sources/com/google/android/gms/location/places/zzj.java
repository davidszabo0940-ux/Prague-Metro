package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class zzj implements Parcelable.Creator<PlaceReport> {
    static void zza(PlaceReport placeReport, Parcel parcel, int i) {
        int iZzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, placeReport.mVersionCode);
        zzb.zza(parcel, 2, placeReport.getPlaceId(), false);
        zzb.zza(parcel, 3, placeReport.getTag(), false);
        zzb.zza(parcel, 4, placeReport.getSource(), false);
        zzb.zzaj(parcel, iZzcm);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zznh, reason: merged with bridge method [inline-methods] */
    public PlaceReport createFromParcel(Parcel parcel) {
        String strZzq = null;
        int iZzcl = zza.zzcl(parcel);
        int iZzg = 0;
        String strZzq2 = null;
        String strZzq3 = null;
        while (parcel.dataPosition() < iZzcl) {
            int iZzck = zza.zzck(parcel);
            switch (zza.zzgi(iZzck)) {
                case 1:
                    iZzg = zza.zzg(parcel, iZzck);
                    break;
                case 2:
                    strZzq3 = zza.zzq(parcel, iZzck);
                    break;
                case 3:
                    strZzq2 = zza.zzq(parcel, iZzck);
                    break;
                case 4:
                    strZzq = zza.zzq(parcel, iZzck);
                    break;
                default:
                    zza.zzb(parcel, iZzck);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzcl) {
            throw new zza.C0743zza(new StringBuilder(37).append("Overread allowed size end=").append(iZzcl).toString(), parcel);
        }
        return new PlaceReport(iZzg, strZzq3, strZzq2, strZzq);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zztw, reason: merged with bridge method [inline-methods] */
    public PlaceReport[] newArray(int i) {
        return new PlaceReport[i];
    }
}
