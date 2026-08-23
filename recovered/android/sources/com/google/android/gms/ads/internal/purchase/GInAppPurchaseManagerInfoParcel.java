package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzhr;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class GInAppPurchaseManagerInfoParcel extends AbstractSafeParcelable {
    public static final zza CREATOR = new zza();
    public final int versionCode;
    public final zzk zzapr;
    public final zzhr zzbwq;
    public final Context zzbwr;
    public final zzj zzbws;

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.zzapr = (zzk) com.google.android.gms.dynamic.zze.zzad(com.google.android.gms.dynamic.zzd.zza.zzfc(iBinder));
        this.zzbwq = (zzhr) com.google.android.gms.dynamic.zze.zzad(com.google.android.gms.dynamic.zzd.zza.zzfc(iBinder2));
        this.zzbwr = (Context) com.google.android.gms.dynamic.zze.zzad(com.google.android.gms.dynamic.zzd.zza.zzfc(iBinder3));
        this.zzbws = (zzj) com.google.android.gms.dynamic.zze.zzad(com.google.android.gms.dynamic.zzd.zza.zzfc(iBinder4));
    }

    public GInAppPurchaseManagerInfoParcel(Context context, zzk zzkVar, zzhr zzhrVar, zzj zzjVar) {
        this.versionCode = 2;
        this.zzbwr = context;
        this.zzapr = zzkVar;
        this.zzbwq = zzhrVar;
        this.zzbws = zzjVar;
    }

    public static void zza(Intent intent, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", gInAppPurchaseManagerInfoParcel);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static GInAppPurchaseManagerInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    IBinder zzpo() {
        return com.google.android.gms.dynamic.zze.zzae(this.zzbws).asBinder();
    }

    IBinder zzpp() {
        return com.google.android.gms.dynamic.zze.zzae(this.zzapr).asBinder();
    }

    IBinder zzpq() {
        return com.google.android.gms.dynamic.zze.zzae(this.zzbwq).asBinder();
    }

    IBinder zzpr() {
        return com.google.android.gms.dynamic.zze.zzae(this.zzbwr).asBinder();
    }
}
