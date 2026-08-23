package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzfr extends com.google.android.gms.ads.internal.client.zzu.zza {
    private String zzall;
    private zzfl zzbku;
    private com.google.android.gms.ads.internal.zzl zzbkz;
    private zzfn zzblg;
    private zzhw zzblh;
    private String zzbli;

    public zzfr(Context context, String str, zzgn zzgnVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zzd zzdVar) {
        this(str, new zzfl(context, zzgnVar, versionInfoParcel, zzdVar));
    }

    zzfr(String str, zzfl zzflVar) {
        this.zzall = str;
        this.zzbku = zzflVar;
        this.zzblg = new zzfn();
        com.google.android.gms.ads.internal.zzu.zzgb().zza(zzflVar);
    }

    private void zzly() {
        if (this.zzbkz == null || this.zzblh == null) {
            return;
        }
        this.zzbkz.zza(this.zzblh, this.zzbli);
    }

    static boolean zzn(AdRequestParcel adRequestParcel) {
        Bundle bundleZzi = zzfo.zzi(adRequestParcel);
        return bundleZzi != null && bundleZzi.containsKey("gw");
    }

    static boolean zzo(AdRequestParcel adRequestParcel) {
        Bundle bundleZzi = zzfo.zzi(adRequestParcel);
        return bundleZzi != null && bundleZzi.containsKey("_ad");
    }

    void abort() {
        if (this.zzbkz != null) {
            return;
        }
        this.zzbkz = this.zzbku.zzbd(this.zzall);
        this.zzblg.zzc(this.zzbkz);
        zzly();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void destroy() throws RemoteException {
        if (this.zzbkz != null) {
            this.zzbkz.destroy();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public String getMediationAdapterClassName() throws RemoteException {
        if (this.zzbkz != null) {
            return this.zzbkz.getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean isLoading() throws RemoteException {
        return this.zzbkz != null && this.zzbkz.isLoading();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean isReady() throws RemoteException {
        return this.zzbkz != null && this.zzbkz.isReady();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void pause() throws RemoteException {
        if (this.zzbkz != null) {
            this.zzbkz.pause();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void resume() throws RemoteException {
        if (this.zzbkz != null) {
            this.zzbkz.resume();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void setManualImpressionsEnabled(boolean z) throws RemoteException {
        abort();
        if (this.zzbkz != null) {
            this.zzbkz.setManualImpressionsEnabled(z);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void setUserId(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void showInterstitial() throws RemoteException {
        if (this.zzbkz != null) {
            this.zzbkz.showInterstitial();
        } else {
            zzkh.zzcy("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void stopLoading() throws RemoteException {
        if (this.zzbkz != null) {
            this.zzbkz.stopLoading();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(AdSizeParcel adSizeParcel) throws RemoteException {
        if (this.zzbkz != null) {
            this.zzbkz.zza(adSizeParcel);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(VideoOptionsParcel videoOptionsParcel) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzp zzpVar) throws RemoteException {
        this.zzblg.zzbko = zzpVar;
        if (this.zzbkz != null) {
            this.zzblg.zzc(this.zzbkz);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        this.zzblg.zzald = zzqVar;
        if (this.zzbkz != null) {
            this.zzblg.zzc(this.zzbkz);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzw zzwVar) throws RemoteException {
        this.zzblg.zzbkl = zzwVar;
        if (this.zzbkz != null) {
            this.zzblg.zzc(this.zzbkz);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzy zzyVar) throws RemoteException {
        abort();
        if (this.zzbkz != null) {
            this.zzbkz.zza(zzyVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzdVar) {
        this.zzblg.zzbkp = zzdVar;
        if (this.zzbkz != null) {
            this.zzblg.zzc(this.zzbkz);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzdo zzdoVar) throws RemoteException {
        this.zzblg.zzbkn = zzdoVar;
        if (this.zzbkz != null) {
            this.zzblg.zzc(this.zzbkz);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzhs zzhsVar) throws RemoteException {
        this.zzblg.zzbkm = zzhsVar;
        if (this.zzbkz != null) {
            this.zzblg.zzc(this.zzbkz);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzhw zzhwVar, String str) throws RemoteException {
        this.zzblh = zzhwVar;
        this.zzbli = str;
        zzly();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException {
        if (!zzn(adRequestParcel)) {
            abort();
        }
        if (zzfo.zzk(adRequestParcel)) {
            abort();
        }
        if (adRequestParcel.zzatr != null) {
            abort();
        }
        if (this.zzbkz != null) {
            return this.zzbkz.zzb(adRequestParcel);
        }
        zzfo zzfoVarZzgb = com.google.android.gms.ads.internal.zzu.zzgb();
        if (zzo(adRequestParcel)) {
            zzfoVarZzgb.zzb(adRequestParcel, this.zzall);
        }
        zzfq.zza zzaVarZza = zzfoVarZzgb.zza(adRequestParcel, this.zzall);
        if (zzaVarZza == null) {
            abort();
            return this.zzbkz.zzb(adRequestParcel);
        }
        if (!zzaVarZza.zzbld) {
            zzaVarZza.zzlx();
        }
        this.zzbkz = zzaVarZza.zzbkz;
        zzaVarZza.zzblb.zza(this.zzblg);
        this.zzblg.zzc(this.zzbkz);
        zzly();
        return zzaVarZza.zzble;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public com.google.android.gms.dynamic.zzd zzdn() throws RemoteException {
        if (this.zzbkz != null) {
            return this.zzbkz.zzdn();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public AdSizeParcel zzdo() throws RemoteException {
        if (this.zzbkz != null) {
            return this.zzbkz.zzdo();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zzdq() throws RemoteException {
        if (this.zzbkz != null) {
            this.zzbkz.zzdq();
        } else {
            zzkh.zzcy("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public com.google.android.gms.ads.internal.client.zzab zzdr() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }
}
