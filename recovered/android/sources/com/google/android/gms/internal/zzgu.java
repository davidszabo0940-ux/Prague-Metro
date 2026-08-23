package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzgu extends zzgo.zza {
    private final MediationAdapter zzbpm;
    private zzgv zzbpn;

    public zzgu(MediationAdapter mediationAdapter) {
        this.zzbpm = mediationAdapter;
    }

    private Bundle zza(String str, int i, String str2) throws RemoteException {
        String strValueOf = String.valueOf(str);
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "Server parameters: ".concat(strValueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zzbpm instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get Server Parameters Bundle.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void destroy() throws RemoteException {
        try {
            this.zzbpm.onDestroy();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public Bundle getInterstitialAdapterInfo() {
        if (this.zzbpm instanceof zzlx) {
            return ((zzlx) this.zzbpm).getInterstitialAdapterInfo();
        }
        String strValueOf = String.valueOf(this.zzbpm.getClass().getCanonicalName());
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a v2 MediationInterstitialAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a v2 MediationInterstitialAdapter: "));
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzgo
    public com.google.android.gms.dynamic.zzd getView() throws RemoteException {
        if (!(this.zzbpm instanceof MediationBannerAdapter)) {
            String strValueOf = String.valueOf(this.zzbpm.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return com.google.android.gms.dynamic.zze.zzae(((MediationBannerAdapter) this.zzbpm).getBannerView());
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public boolean isInitialized() throws RemoteException {
        if (!(this.zzbpm instanceof MediationRewardedVideoAdAdapter)) {
            String strValueOf = String.valueOf(this.zzbpm.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Check if adapter is initialized.");
        try {
            return ((MediationRewardedVideoAdAdapter) this.zzbpm).isInitialized();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not check if adapter is initialized.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void pause() throws RemoteException {
        try {
            this.zzbpm.onPause();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not pause adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void resume() throws RemoteException {
        try {
            this.zzbpm.onResume();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not resume adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void showInterstitial() throws RemoteException {
        if (!(this.zzbpm instanceof MediationInterstitialAdapter)) {
            String strValueOf = String.valueOf(this.zzbpm.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzbpm).showInterstitial();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void showVideo() throws RemoteException {
        if (!(this.zzbpm instanceof MediationRewardedVideoAdAdapter)) {
            String strValueOf = String.valueOf(this.zzbpm.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Show rewarded video ad from adapter.");
        try {
            ((MediationRewardedVideoAdAdapter) this.zzbpm).showVideo();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zza(AdRequestParcel adRequestParcel, String str, String str2) throws RemoteException {
        if (!(this.zzbpm instanceof MediationRewardedVideoAdAdapter)) {
            String strValueOf = String.valueOf(this.zzbpm.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Requesting rewarded video ad from adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzbpm;
            mediationRewardedVideoAdAdapter.loadAd(new zzgt(adRequestParcel.zzatk == -1 ? null : new Date(adRequestParcel.zzatk), adRequestParcel.zzatl, adRequestParcel.zzatm != null ? new HashSet(adRequestParcel.zzatm) : null, adRequestParcel.zzats, adRequestParcel.zzatn, adRequestParcel.zzato, adRequestParcel.zzatz), zza(str, adRequestParcel.zzato, str2), adRequestParcel.zzatu != null ? adRequestParcel.zzatu.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not load rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zzaVar, String str2) throws RemoteException {
        if (!(this.zzbpm instanceof MediationRewardedVideoAdAdapter)) {
            String strValueOf = String.valueOf(this.zzbpm.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Initialize rewarded video adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzbpm;
            mediationRewardedVideoAdAdapter.initialize((Context) com.google.android.gms.dynamic.zze.zzad(zzdVar), new zzgt(adRequestParcel.zzatk == -1 ? null : new Date(adRequestParcel.zzatk), adRequestParcel.zzatl, adRequestParcel.zzatm != null ? new HashSet(adRequestParcel.zzatm) : null, adRequestParcel.zzats, adRequestParcel.zzatn, adRequestParcel.zzato, adRequestParcel.zzatz), str, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(zzaVar), zza(str2, adRequestParcel.zzato, (String) null), adRequestParcel.zzatu != null ? adRequestParcel.zzatu.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, zzgp zzgpVar) throws RemoteException {
        zza(zzdVar, adRequestParcel, str, (String) null, zzgpVar);
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzgp zzgpVar) throws RemoteException {
        if (!(this.zzbpm instanceof MediationInterstitialAdapter)) {
            String strValueOf = String.valueOf(this.zzbpm.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzbpm;
            mediationInterstitialAdapter.requestInterstitialAd((Context) com.google.android.gms.dynamic.zze.zzad(zzdVar), new zzgv(zzgpVar), zza(str, adRequestParcel.zzato, str2), new zzgt(adRequestParcel.zzatk == -1 ? null : new Date(adRequestParcel.zzatk), adRequestParcel.zzatl, adRequestParcel.zzatm != null ? new HashSet(adRequestParcel.zzatm) : null, adRequestParcel.zzats, adRequestParcel.zzatn, adRequestParcel.zzato, adRequestParcel.zzatz), adRequestParcel.zzatu != null ? adRequestParcel.zzatu.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzgp zzgpVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException {
        if (!(this.zzbpm instanceof MediationNativeAdapter)) {
            String strValueOf = String.valueOf(this.zzbpm.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationNativeAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationNativeAdapter: "));
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.zzbpm;
            zzgy zzgyVar = new zzgy(adRequestParcel.zzatk == -1 ? null : new Date(adRequestParcel.zzatk), adRequestParcel.zzatl, adRequestParcel.zzatm != null ? new HashSet(adRequestParcel.zzatm) : null, adRequestParcel.zzats, adRequestParcel.zzatn, adRequestParcel.zzato, nativeAdOptionsParcel, list, adRequestParcel.zzatz);
            Bundle bundle = adRequestParcel.zzatu != null ? adRequestParcel.zzatu.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.zzbpn = new zzgv(zzgpVar);
            mediationNativeAdapter.requestNativeAd((Context) com.google.android.gms.dynamic.zze.zzad(zzdVar), this.zzbpn, zza(str, adRequestParcel.zzato, str2), zzgyVar, bundle);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request native ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzgp zzgpVar) throws RemoteException {
        zza(zzdVar, adSizeParcel, adRequestParcel, str, null, zzgpVar);
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzgp zzgpVar) throws RemoteException {
        if (!(this.zzbpm instanceof MediationBannerAdapter)) {
            String strValueOf = String.valueOf(this.zzbpm.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzbpm;
            mediationBannerAdapter.requestBannerAd((Context) com.google.android.gms.dynamic.zze.zzad(zzdVar), new zzgv(zzgpVar), zza(str, adRequestParcel.zzato, str2), com.google.android.gms.ads.zza.zza(adSizeParcel.width, adSizeParcel.height, adSizeParcel.zzaup), new zzgt(adRequestParcel.zzatk == -1 ? null : new Date(adRequestParcel.zzatk), adRequestParcel.zzatl, adRequestParcel.zzatm != null ? new HashSet(adRequestParcel.zzatm) : null, adRequestParcel.zzats, adRequestParcel.zzatn, adRequestParcel.zzato, adRequestParcel.zzatz), adRequestParcel.zzatu != null ? adRequestParcel.zzatu.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zzc(AdRequestParcel adRequestParcel, String str) throws RemoteException {
        zza(adRequestParcel, str, (String) null);
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zzj(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
        try {
            ((OnContextChangedListener) this.zzbpm).onContextChanged((Context) com.google.android.gms.dynamic.zze.zzad(zzdVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zza("Could not inform adapter of changed context", th);
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public zzgr zzmq() {
        NativeAdMapper nativeAdMapperZzmu = this.zzbpn.zzmu();
        if (nativeAdMapperZzmu instanceof NativeAppInstallAdMapper) {
            return new zzgw((NativeAppInstallAdMapper) nativeAdMapperZzmu);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzgo
    public zzgs zzmr() {
        NativeAdMapper nativeAdMapperZzmu = this.zzbpn.zzmu();
        if (nativeAdMapperZzmu instanceof NativeContentAdMapper) {
            return new zzgx((NativeContentAdMapper) nativeAdMapperZzmu);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzgo
    public Bundle zzms() {
        if (this.zzbpm instanceof zzlw) {
            return ((zzlw) this.zzbpm).zzms();
        }
        String strValueOf = String.valueOf(this.zzbpm.getClass().getCanonicalName());
        com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a v2 MediationBannerAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a v2 MediationBannerAdapter: "));
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzgo
    public Bundle zzmt() {
        return new Bundle();
    }
}
