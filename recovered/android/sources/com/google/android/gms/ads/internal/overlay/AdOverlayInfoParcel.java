package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzll;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class AdOverlayInfoParcel extends AbstractSafeParcelable {
    public static final zzf CREATOR = new zzf();
    public final int orientation;
    public final String url;
    public final int versionCode;
    public final VersionInfoParcel zzaou;
    public final AdLauncherIntentInfoParcel zzbtn;
    public final com.google.android.gms.ads.internal.client.zza zzbto;
    public final zzg zzbtp;
    public final zzll zzbtq;
    public final zzeo zzbtr;
    public final String zzbts;
    public final boolean zzbtt;
    public final String zzbtu;
    public final zzp zzbtv;
    public final int zzbtw;
    public final zzev zzbtx;
    public final String zzbty;
    public final InterstitialAdParameterParcel zzbtz;

    AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, VersionInfoParcel versionInfoParcel, IBinder iBinder6, String str4, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.versionCode = i;
        this.zzbtn = adLauncherIntentInfoParcel;
        this.zzbto = (com.google.android.gms.ads.internal.client.zza) com.google.android.gms.dynamic.zze.zzad(com.google.android.gms.dynamic.zzd.zza.zzfc(iBinder));
        this.zzbtp = (zzg) com.google.android.gms.dynamic.zze.zzad(com.google.android.gms.dynamic.zzd.zza.zzfc(iBinder2));
        this.zzbtq = (zzll) com.google.android.gms.dynamic.zze.zzad(com.google.android.gms.dynamic.zzd.zza.zzfc(iBinder3));
        this.zzbtr = (zzeo) com.google.android.gms.dynamic.zze.zzad(com.google.android.gms.dynamic.zzd.zza.zzfc(iBinder4));
        this.zzbts = str;
        this.zzbtt = z;
        this.zzbtu = str2;
        this.zzbtv = (zzp) com.google.android.gms.dynamic.zze.zzad(com.google.android.gms.dynamic.zzd.zza.zzfc(iBinder5));
        this.orientation = i2;
        this.zzbtw = i3;
        this.url = str3;
        this.zzaou = versionInfoParcel;
        this.zzbtx = (zzev) com.google.android.gms.dynamic.zze.zzad(com.google.android.gms.dynamic.zzd.zza.zzfc(iBinder6));
        this.zzbty = str4;
        this.zzbtz = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzp zzpVar, zzll zzllVar, int i, VersionInfoParcel versionInfoParcel, String str, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.versionCode = 4;
        this.zzbtn = null;
        this.zzbto = zzaVar;
        this.zzbtp = zzgVar;
        this.zzbtq = zzllVar;
        this.zzbtr = null;
        this.zzbts = null;
        this.zzbtt = false;
        this.zzbtu = null;
        this.zzbtv = zzpVar;
        this.orientation = i;
        this.zzbtw = 1;
        this.url = null;
        this.zzaou = versionInfoParcel;
        this.zzbtx = null;
        this.zzbty = str;
        this.zzbtz = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzp zzpVar, zzll zzllVar, boolean z, int i, VersionInfoParcel versionInfoParcel) {
        this.versionCode = 4;
        this.zzbtn = null;
        this.zzbto = zzaVar;
        this.zzbtp = zzgVar;
        this.zzbtq = zzllVar;
        this.zzbtr = null;
        this.zzbts = null;
        this.zzbtt = z;
        this.zzbtu = null;
        this.zzbtv = zzpVar;
        this.orientation = i;
        this.zzbtw = 2;
        this.url = null;
        this.zzaou = versionInfoParcel;
        this.zzbtx = null;
        this.zzbty = null;
        this.zzbtz = null;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzeo zzeoVar, zzp zzpVar, zzll zzllVar, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, zzev zzevVar) {
        this.versionCode = 4;
        this.zzbtn = null;
        this.zzbto = zzaVar;
        this.zzbtp = zzgVar;
        this.zzbtq = zzllVar;
        this.zzbtr = zzeoVar;
        this.zzbts = null;
        this.zzbtt = z;
        this.zzbtu = null;
        this.zzbtv = zzpVar;
        this.orientation = i;
        this.zzbtw = 3;
        this.url = str;
        this.zzaou = versionInfoParcel;
        this.zzbtx = zzevVar;
        this.zzbty = null;
        this.zzbtz = null;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzeo zzeoVar, zzp zzpVar, zzll zzllVar, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, zzev zzevVar) {
        this.versionCode = 4;
        this.zzbtn = null;
        this.zzbto = zzaVar;
        this.zzbtp = zzgVar;
        this.zzbtq = zzllVar;
        this.zzbtr = zzeoVar;
        this.zzbts = str2;
        this.zzbtt = z;
        this.zzbtu = str;
        this.zzbtv = zzpVar;
        this.orientation = i;
        this.zzbtw = 3;
        this.url = null;
        this.zzaou = versionInfoParcel;
        this.zzbtx = zzevVar;
        this.zzbty = null;
        this.zzbtz = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzp zzpVar, VersionInfoParcel versionInfoParcel) {
        this.versionCode = 4;
        this.zzbtn = adLauncherIntentInfoParcel;
        this.zzbto = zzaVar;
        this.zzbtp = zzgVar;
        this.zzbtq = null;
        this.zzbtr = null;
        this.zzbts = null;
        this.zzbtt = false;
        this.zzbtu = null;
        this.zzbtv = zzpVar;
        this.orientation = -1;
        this.zzbtw = 4;
        this.url = null;
        this.zzaou = versionInfoParcel;
        this.zzbtx = null;
        this.zzbty = null;
        this.zzbtz = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzb(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    IBinder zzoe() {
        return com.google.android.gms.dynamic.zze.zzae(this.zzbto).asBinder();
    }

    IBinder zzof() {
        return com.google.android.gms.dynamic.zze.zzae(this.zzbtp).asBinder();
    }

    IBinder zzog() {
        return com.google.android.gms.dynamic.zze.zzae(this.zzbtq).asBinder();
    }

    IBinder zzoh() {
        return com.google.android.gms.dynamic.zze.zzae(this.zzbtr).asBinder();
    }

    IBinder zzoi() {
        return com.google.android.gms.dynamic.zze.zzae(this.zzbtx).asBinder();
    }

    IBinder zzoj() {
        return com.google.android.gms.dynamic.zze.zzae(this.zzbtv).asBinder();
    }
}
