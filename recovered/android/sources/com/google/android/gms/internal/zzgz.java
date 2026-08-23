package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzgz<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzgo.zza {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzbps;
    private final NETWORK_EXTRAS zzbpt;

    public zzgz(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzbps = mediationAdapter;
        this.zzbpt = network_extras;
    }

    private SERVER_PARAMETERS zzb(String str, int i, String str2) throws RemoteException {
        HashMap map;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                map = new HashMap(jSONObject.length());
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            } else {
                map = new HashMap(0);
            }
            Class<SERVER_PARAMETERS> serverParametersType = this.zzbps.getServerParametersType();
            if (serverParametersType == null) {
                return null;
            }
            SERVER_PARAMETERS server_parametersNewInstance = serverParametersType.newInstance();
            server_parametersNewInstance.load(map);
            return server_parametersNewInstance;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get MediationServerParameters.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void destroy() throws RemoteException {
        try {
            this.zzbps.destroy();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzgo
    public com.google.android.gms.dynamic.zzd getView() throws RemoteException {
        if (!(this.zzbps instanceof MediationBannerAdapter)) {
            String strValueOf = String.valueOf(this.zzbps.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return com.google.android.gms.dynamic.zze.zzae(((MediationBannerAdapter) this.zzbps).getBannerView());
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzgo
    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzgo
    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzgo
    public void showInterstitial() throws RemoteException {
        if (!(this.zzbps instanceof MediationInterstitialAdapter)) {
            String strValueOf = String.valueOf(this.zzbps.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzbps).showInterstitial();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void showVideo() {
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zza(AdRequestParcel adRequestParcel, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zzaVar, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, zzgp zzgpVar) throws RemoteException {
        zza(zzdVar, adRequestParcel, str, (String) null, zzgpVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzgo
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzgp zzgpVar) throws RemoteException {
        if (!(this.zzbps instanceof MediationInterstitialAdapter)) {
            String strValueOf = String.valueOf(this.zzbps.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzbps).requestInterstitialAd(new zzha(zzgpVar), (Activity) com.google.android.gms.dynamic.zze.zzad(zzdVar), zzb(str, adRequestParcel.zzato, str2), zzhb.zzp(adRequestParcel), this.zzbpt);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzgp zzgpVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzgp zzgpVar) throws RemoteException {
        zza(zzdVar, adSizeParcel, adRequestParcel, str, null, zzgpVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzgo
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzgp zzgpVar) throws RemoteException {
        if (!(this.zzbps instanceof MediationBannerAdapter)) {
            String strValueOf = String.valueOf(this.zzbps.getClass().getCanonicalName());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(strValueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(strValueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.zzbps).requestBannerAd(new zzha(zzgpVar), (Activity) com.google.android.gms.dynamic.zze.zzad(zzdVar), zzb(str, adRequestParcel.zzato, str2), zzhb.zzc(adSizeParcel), zzhb.zzp(adRequestParcel), this.zzbpt);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zzc(AdRequestParcel adRequestParcel, String str) {
    }

    @Override // com.google.android.gms.internal.zzgo
    public void zzj(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzgo
    public zzgr zzmq() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzgo
    public zzgs zzmr() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzgo
    public Bundle zzms() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzgo
    public Bundle zzmt() {
        return new Bundle();
    }
}
