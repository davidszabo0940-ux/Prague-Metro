package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements Parcelable.Creator<LogEventParcelable> {
    static void zza(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int iZzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, logEventParcelable.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) logEventParcelable.f62qk, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, logEventParcelable.f63ql, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, logEventParcelable.f64qm, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, logEventParcelable.f65qn, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, logEventParcelable.f66qo, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, logEventParcelable.f67qp, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, logEventParcelable.f68qq);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, iZzcm);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbw, reason: merged with bridge method [inline-methods] */
    public LogEventParcelable createFromParcel(Parcel parcel) {
        byte[][] bArrZzu = null;
        int iZzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
        int iZzg = 0;
        boolean zZzc = true;
        int[] iArrZzw = null;
        String[] strArrZzac = null;
        int[] iArrZzw2 = null;
        byte[] bArrZzt = null;
        PlayLoggerContext playLoggerContext = null;
        while (parcel.dataPosition() < iZzcl) {
            int iZzck = com.google.android.gms.common.internal.safeparcel.zza.zzck(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(iZzck)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 2:
                    playLoggerContext = (PlayLoggerContext) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, PlayLoggerContext.CREATOR);
                    break;
                case 3:
                    bArrZzt = com.google.android.gms.common.internal.safeparcel.zza.zzt(parcel, iZzck);
                    break;
                case 4:
                    iArrZzw2 = com.google.android.gms.common.internal.safeparcel.zza.zzw(parcel, iZzck);
                    break;
                case 5:
                    strArrZzac = com.google.android.gms.common.internal.safeparcel.zza.zzac(parcel, iZzck);
                    break;
                case 6:
                    iArrZzw = com.google.android.gms.common.internal.safeparcel.zza.zzw(parcel, iZzck);
                    break;
                case 7:
                    bArrZzu = com.google.android.gms.common.internal.safeparcel.zza.zzu(parcel, iZzck);
                    break;
                case 8:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzck);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzcl) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0743zza(new StringBuilder(37).append("Overread allowed size end=").append(iZzcl).toString(), parcel);
        }
        return new LogEventParcelable(iZzg, playLoggerContext, bArrZzt, iArrZzw2, strArrZzac, iArrZzw, bArrZzu, zZzc);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzey, reason: merged with bridge method [inline-methods] */
    public LogEventParcelable[] newArray(int i) {
        return new LogEventParcelable[i];
    }
}
