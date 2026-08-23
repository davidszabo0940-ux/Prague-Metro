package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdw;
import com.google.android.gms.internal.zzfr;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzhm;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzji;

/* JADX INFO: loaded from: classes.dex */
@Keep
@DynamiteApi
@zzir
public class ClientApi extends zzx.zza {
    @Override // com.google.android.gms.ads.internal.client.zzx
    public com.google.android.gms.ads.internal.client.zzs createAdLoaderBuilder(com.google.android.gms.dynamic.zzd zzdVar, String str, zzgn zzgnVar, int i) {
        Context context = (Context) com.google.android.gms.dynamic.zze.zzad(zzdVar);
        return new zzk(context, str, zzgnVar, new VersionInfoParcel(9256000, i, context.getClassLoader() == ClientApi.class.getClassLoader()), zzd.zzel());
    }

    @Override // com.google.android.gms.ads.internal.client.zzx
    public zzhm createAdOverlay(com.google.android.gms.dynamic.zzd zzdVar) {
        return new com.google.android.gms.ads.internal.overlay.zzd((Activity) com.google.android.gms.dynamic.zze.zzad(zzdVar));
    }

    @Override // com.google.android.gms.ads.internal.client.zzx
    public com.google.android.gms.ads.internal.client.zzu createBannerAdManager(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, String str, zzgn zzgnVar, int i) throws RemoteException {
        Context context = (Context) com.google.android.gms.dynamic.zze.zzad(zzdVar);
        return new zzf(context, adSizeParcel, str, zzgnVar, new VersionInfoParcel(9256000, i, context.getClassLoader() == ClientApi.class.getClassLoader()), zzd.zzel());
    }

    @Override // com.google.android.gms.ads.internal.client.zzx
    public zzht createInAppPurchaseManager(com.google.android.gms.dynamic.zzd zzdVar) {
        return new com.google.android.gms.ads.internal.purchase.zze((Activity) com.google.android.gms.dynamic.zze.zzad(zzdVar));
    }

    @Override // com.google.android.gms.ads.internal.client.zzx
    public com.google.android.gms.ads.internal.client.zzu createInterstitialAdManager(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, String str, zzgn zzgnVar, int i) throws RemoteException {
        Context context = (Context) com.google.android.gms.dynamic.zze.zzad(zzdVar);
        zzdc.initialize(context);
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(9256000, i, context.getClassLoader() == ClientApi.class.getClassLoader());
        boolean zEquals = "reward_mb".equals(adSizeParcel.zzaup);
        return (!zEquals && zzdc.zzbac.get().booleanValue()) || (zEquals && zzdc.zzbad.get().booleanValue()) ? new zzfr(context, str, zzgnVar, versionInfoParcel, zzd.zzel()) : new zzl(context, adSizeParcel, str, zzgnVar, versionInfoParcel, zzd.zzel());
    }

    @Override // com.google.android.gms.ads.internal.client.zzx
    public zzdw createNativeAdViewDelegate(com.google.android.gms.dynamic.zzd zzdVar, com.google.android.gms.dynamic.zzd zzdVar2) {
        return new com.google.android.gms.ads.internal.formats.zzk((FrameLayout) com.google.android.gms.dynamic.zze.zzad(zzdVar), (FrameLayout) com.google.android.gms.dynamic.zze.zzad(zzdVar2));
    }

    @Override // com.google.android.gms.ads.internal.client.zzx
    public com.google.android.gms.ads.internal.reward.client.zzb createRewardedVideoAd(com.google.android.gms.dynamic.zzd zzdVar, zzgn zzgnVar, int i) {
        Context context = (Context) com.google.android.gms.dynamic.zze.zzad(zzdVar);
        return new zzji(context, zzd.zzel(), zzgnVar, new VersionInfoParcel(9256000, i, context.getClassLoader() == ClientApi.class.getClassLoader()));
    }

    @Override // com.google.android.gms.ads.internal.client.zzx
    public com.google.android.gms.ads.internal.client.zzu createSearchAdManager(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, String str, int i) throws RemoteException {
        Context context = (Context) com.google.android.gms.dynamic.zze.zzad(zzdVar);
        return new zzt(context, adSizeParcel, str, new VersionInfoParcel(9256000, i, context.getClassLoader() == ClientApi.class.getClassLoader()));
    }

    @Override // com.google.android.gms.ads.internal.client.zzx
    public zzz getMobileAdsSettingsManager(com.google.android.gms.dynamic.zzd zzdVar) {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzx
    public zzz getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.dynamic.zzd zzdVar, int i) {
        Context context = (Context) com.google.android.gms.dynamic.zze.zzad(zzdVar);
        return zzo.zza(context, new VersionInfoParcel(9256000, i, context.getClassLoader() == ClientApi.class.getClassLoader()));
    }
}
