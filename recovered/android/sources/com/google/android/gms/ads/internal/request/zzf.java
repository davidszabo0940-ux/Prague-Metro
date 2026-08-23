package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzf implements Parcelable.Creator<AdRequestInfoParcel> {
    static void zza(AdRequestInfoParcel adRequestInfoParcel, Parcel parcel, int i) {
        int iZzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, adRequestInfoParcel.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, adRequestInfoParcel.zzcau, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) adRequestInfoParcel.zzcav, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) adRequestInfoParcel.zzaoy, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, adRequestInfoParcel.zzaos, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) adRequestInfoParcel.applicationInfo, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable) adRequestInfoParcel.zzcaw, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, adRequestInfoParcel.zzcax, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, adRequestInfoParcel.zzcay, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, adRequestInfoParcel.zzcaz, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, (Parcelable) adRequestInfoParcel.zzaou, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, adRequestInfoParcel.zzcba, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 13, adRequestInfoParcel.zzcbb);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 14, adRequestInfoParcel.zzapq, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, adRequestInfoParcel.zzcbc, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, adRequestInfoParcel.zzcbd);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 17, (Parcelable) adRequestInfoParcel.zzcbe, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 18, adRequestInfoParcel.zzcbf);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 19, adRequestInfoParcel.zzcbg);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 20, adRequestInfoParcel.zzcbh);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 21, adRequestInfoParcel.zzcbi, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 25, adRequestInfoParcel.zzcbj);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 26, adRequestInfoParcel.zzcbk, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 27, adRequestInfoParcel.zzcbl, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 28, adRequestInfoParcel.zzaor, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 29, (Parcelable) adRequestInfoParcel.zzapm, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 30, adRequestInfoParcel.zzcbm, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 31, adRequestInfoParcel.zzcbn);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 32, (Parcelable) adRequestInfoParcel.zzcbo, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 33, adRequestInfoParcel.zzcbp, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 34, adRequestInfoParcel.zzcbq);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 35, adRequestInfoParcel.zzcbr);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 36, adRequestInfoParcel.zzcbs);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 37, adRequestInfoParcel.zzcbt);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 38, adRequestInfoParcel.zzcbu);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 39, adRequestInfoParcel.zzcbv, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 40, adRequestInfoParcel.zzcbw);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 41, adRequestInfoParcel.zzcbx, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 42, adRequestInfoParcel.zzbnu);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 43, adRequestInfoParcel.zzcby);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 44, adRequestInfoParcel.zzcbz, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, iZzcm);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzao, reason: merged with bridge method [inline-methods] */
    public AdRequestInfoParcel[] newArray(int i) {
        return new AdRequestInfoParcel[i];
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] */
    public AdRequestInfoParcel createFromParcel(Parcel parcel) {
        int iZzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
        int iZzg = 0;
        Bundle bundleZzs = null;
        AdRequestParcel adRequestParcel = null;
        AdSizeParcel adSizeParcel = null;
        String strZzq = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String strZzq2 = null;
        String strZzq3 = null;
        String strZzq4 = null;
        VersionInfoParcel versionInfoParcel = null;
        Bundle bundleZzs2 = null;
        int iZzg2 = 0;
        ArrayList<String> arrayListZzae = null;
        Bundle bundleZzs3 = null;
        boolean zZzc = false;
        Messenger messenger = null;
        int iZzg3 = 0;
        int iZzg4 = 0;
        float fZzl = 0.0f;
        String strZzq5 = null;
        long jZzi = 0;
        String strZzq6 = null;
        ArrayList<String> arrayListZzae2 = null;
        String strZzq7 = null;
        NativeAdOptionsParcel nativeAdOptionsParcel = null;
        ArrayList<String> arrayListZzae3 = null;
        long jZzi2 = 0;
        CapabilityParcel capabilityParcel = null;
        String strZzq8 = null;
        float fZzl2 = 0.0f;
        boolean zZzc2 = false;
        int iZzg5 = 0;
        int iZzg6 = 0;
        boolean zZzc3 = false;
        boolean zZzc4 = false;
        String strZzq9 = null;
        String strZzq10 = null;
        boolean zZzc5 = false;
        int iZzg7 = 0;
        Bundle bundleZzs4 = null;
        while (parcel.dataPosition() < iZzcl) {
            int iZzck = com.google.android.gms.common.internal.safeparcel.zza.zzck(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(iZzck)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 2:
                    bundleZzs = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, iZzck);
                    break;
                case 3:
                    adRequestParcel = (AdRequestParcel) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, AdRequestParcel.CREATOR);
                    break;
                case 4:
                    adSizeParcel = (AdSizeParcel) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, AdSizeParcel.CREATOR);
                    break;
                case 5:
                    strZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, PackageInfo.CREATOR);
                    break;
                case 8:
                    strZzq2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 9:
                    strZzq3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 10:
                    strZzq4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 11:
                    versionInfoParcel = (VersionInfoParcel) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, VersionInfoParcel.CREATOR);
                    break;
                case 12:
                    bundleZzs2 = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, iZzck);
                    break;
                case 13:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 14:
                    arrayListZzae = com.google.android.gms.common.internal.safeparcel.zza.zzae(parcel, iZzck);
                    break;
                case 15:
                    bundleZzs3 = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, iZzck);
                    break;
                case 16:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 17:
                    messenger = (Messenger) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, Messenger.CREATOR);
                    break;
                case 18:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 19:
                    iZzg4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 20:
                    fZzl = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzck);
                    break;
                case 21:
                    strZzq5 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 22:
                case 23:
                case 24:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzck);
                    break;
                case 25:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzck);
                    break;
                case 26:
                    strZzq6 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 27:
                    arrayListZzae2 = com.google.android.gms.common.internal.safeparcel.zza.zzae(parcel, iZzck);
                    break;
                case 28:
                    strZzq7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 29:
                    nativeAdOptionsParcel = (NativeAdOptionsParcel) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, NativeAdOptionsParcel.CREATOR);
                    break;
                case 30:
                    arrayListZzae3 = com.google.android.gms.common.internal.safeparcel.zza.zzae(parcel, iZzck);
                    break;
                case 31:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzck);
                    break;
                case 32:
                    capabilityParcel = (CapabilityParcel) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, CapabilityParcel.CREATOR);
                    break;
                case 33:
                    strZzq8 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 34:
                    fZzl2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzck);
                    break;
                case 35:
                    iZzg5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 36:
                    iZzg6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 37:
                    zZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 38:
                    zZzc4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 39:
                    strZzq9 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 40:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 41:
                    strZzq10 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzck);
                    break;
                case 42:
                    zZzc5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzck);
                    break;
                case 43:
                    iZzg7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    break;
                case 44:
                    bundleZzs4 = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, iZzck);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzcl) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0743zza(new StringBuilder(37).append("Overread allowed size end=").append(iZzcl).toString(), parcel);
        }
        return new AdRequestInfoParcel(iZzg, bundleZzs, adRequestParcel, adSizeParcel, strZzq, applicationInfo, packageInfo, strZzq2, strZzq3, strZzq4, versionInfoParcel, bundleZzs2, iZzg2, arrayListZzae, bundleZzs3, zZzc, messenger, iZzg3, iZzg4, fZzl, strZzq5, jZzi, strZzq6, arrayListZzae2, strZzq7, nativeAdOptionsParcel, arrayListZzae3, jZzi2, capabilityParcel, strZzq8, fZzl2, zZzc2, iZzg5, iZzg6, zZzc3, zZzc4, strZzq9, strZzq10, zZzc5, iZzg7, bundleZzs4);
    }
}
