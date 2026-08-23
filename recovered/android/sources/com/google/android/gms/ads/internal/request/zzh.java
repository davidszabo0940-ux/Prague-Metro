package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzh implements Parcelable.Creator<AdResponseParcel> {
    static void zza(AdResponseParcel adResponseParcel, Parcel parcel, int i) {
        int iZzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, adResponseParcel.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, adResponseParcel.zzbts, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, adResponseParcel.body, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 4, adResponseParcel.zzbnq, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, adResponseParcel.errorCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 6, adResponseParcel.zzbnr, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, adResponseParcel.zzccb);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, adResponseParcel.zzccc);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, adResponseParcel.zzccd);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 10, adResponseParcel.zzcce, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, adResponseParcel.zzbnw);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 12, adResponseParcel.orientation);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, adResponseParcel.zzccf, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, adResponseParcel.zzccg);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, adResponseParcel.zzcch, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 18, adResponseParcel.zzcci);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 19, adResponseParcel.zzccj, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 21, adResponseParcel.zzcck, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 22, adResponseParcel.zzccl);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 23, adResponseParcel.zzaus);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 24, adResponseParcel.zzcbd);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 25, adResponseParcel.zzccm);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 26, adResponseParcel.zzccn);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 28, (Parcelable) adResponseParcel.zzcco, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 29, adResponseParcel.zzccp, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 30, adResponseParcel.zzccq, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 31, adResponseParcel.zzaut);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 32, adResponseParcel.zzauu);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 33, (Parcelable) adResponseParcel.zzccr, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 34, adResponseParcel.zzccs, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 35, adResponseParcel.zzcct, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 36, adResponseParcel.zzccu);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 37, (Parcelable) adResponseParcel.zzccv, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 38, adResponseParcel.zzcbu);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 39, adResponseParcel.zzcbv, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 40, adResponseParcel.zzbnt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 41, adResponseParcel.zzccw, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 42, adResponseParcel.zzbnu);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 43, adResponseParcel.zzccx, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, iZzcm);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzap, reason: merged with bridge method [inline-methods] */
    public AdResponseParcel[] newArray(int i) {
        return new AdResponseParcel[i];
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public AdResponseParcel createFromParcel(Parcel parcel) {
        int iZzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
        int iZzg = 0;
        String strZzq = null;
        String strZzq2 = null;
        ArrayList<String> arrayListZzae = null;
        int iZzg2 = 0;
        ArrayList<String> arrayListZzae2 = null;
        long jZzi = 0;
        boolean zZzc = false;
        long jZzi2 = 0;
        ArrayList<String> arrayListZzae3 = null;
        long jZzi3 = 0;
        int iZzg3 = 0;
        String strZzq3 = null;
        long jZzi4 = 0;
        String strZzq4 = null;
        boolean zZzc2 = false;
        String strZzq5 = null;
        String strZzq6 = null;
        boolean zZzc3 = false;
        boolean zZzc4 = false;
        boolean zZzc5 = false;
        boolean zZzc6 = false;
        boolean zZzc7 = false;
        LargeParcelTeleporter largeParcelTeleporter = null;
        String strZzq7 = null;
        String strZzq8 = null;
        boolean zZzc8 = false;
        boolean zZzc9 = false;
        RewardItemParcel rewardItemParcel = null;
        ArrayList<String> arrayListZzae4 = null;
        ArrayList<String> arrayListZzae5 = null;
        boolean zZzc10 = false;
        AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel = null;
        boolean zZzc11 = false;
        String strZzq9 = null;
        ArrayList<String> arrayListZzae6 = null;
        String strZzq10 = null;
        boolean zZzc12 = false;
        String strZzq11 = null;
        while (parcel.dataPosition() < iZzcl) {
            int iZzck = com.google.android.gms.common.internal.safeparcel.zza.zzck(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(iZzck)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 2:
                    strZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 3:
                    strZzq2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 4:
                    arrayListZzae = com.google.android.gms.common.internal.safeparcel.zza.zzae(parcel, iZzck);
                    break;
                case 5:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 6:
                    arrayListZzae2 = com.google.android.gms.common.internal.safeparcel.zza.zzae(parcel, iZzck);
                    break;
                case 7:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzck);
                    break;
                case 8:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 9:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzck);
                    break;
                case 10:
                    arrayListZzae3 = com.google.android.gms.common.internal.safeparcel.zza.zzae(parcel, iZzck);
                    break;
                case 11:
                    jZzi3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzck);
                    break;
                case 12:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 13:
                    strZzq3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 14:
                    jZzi4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzck);
                    break;
                case 15:
                    strZzq4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 16:
                case 17:
                case 20:
                case 27:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzck);
                    break;
                case 18:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 19:
                    strZzq5 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 21:
                    strZzq6 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 22:
                    zZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 23:
                    zZzc4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 24:
                    zZzc5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 25:
                    zZzc6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 26:
                    zZzc7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 28:
                    largeParcelTeleporter = (LargeParcelTeleporter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, LargeParcelTeleporter.CREATOR);
                    break;
                case 29:
                    strZzq7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 30:
                    strZzq8 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 31:
                    zZzc8 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 32:
                    zZzc9 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 33:
                    rewardItemParcel = (RewardItemParcel) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, RewardItemParcel.CREATOR);
                    break;
                case 34:
                    arrayListZzae4 = com.google.android.gms.common.internal.safeparcel.zza.zzae(parcel, iZzck);
                    break;
                case 35:
                    arrayListZzae5 = com.google.android.gms.common.internal.safeparcel.zza.zzae(parcel, iZzck);
                    break;
                case 36:
                    zZzc10 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 37:
                    autoClickProtectionConfigurationParcel = (AutoClickProtectionConfigurationParcel) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, AutoClickProtectionConfigurationParcel.CREATOR);
                    break;
                case 38:
                    zZzc11 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 39:
                    strZzq9 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 40:
                    arrayListZzae6 = com.google.android.gms.common.internal.safeparcel.zza.zzae(parcel, iZzck);
                    break;
                case 41:
                    strZzq10 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 42:
                    zZzc12 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 43:
                    strZzq11 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzcl) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0743zza(new StringBuilder(37).append("Overread allowed size end=").append(iZzcl).toString(), parcel);
        }
        return new AdResponseParcel(iZzg, strZzq, strZzq2, arrayListZzae, iZzg2, arrayListZzae2, jZzi, zZzc, jZzi2, arrayListZzae3, jZzi3, iZzg3, strZzq3, jZzi4, strZzq4, zZzc2, strZzq5, strZzq6, zZzc3, zZzc4, zZzc5, zZzc6, zZzc7, largeParcelTeleporter, strZzq7, strZzq8, zZzc8, zZzc9, rewardItemParcel, arrayListZzae4, arrayListZzae5, zZzc10, autoClickProtectionConfigurationParcel, zZzc11, strZzq9, arrayListZzae6, strZzq10, zZzc12, strZzq11);
    }
}
