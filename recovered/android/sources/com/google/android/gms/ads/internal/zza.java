package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.Debug;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzco;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjh;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkh;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zza extends com.google.android.gms.ads.internal.client.zzu.zza implements com.google.android.gms.ads.internal.client.zza, com.google.android.gms.ads.internal.overlay.zzp, com.google.android.gms.ads.internal.request.zza.InterfaceC0730zza, zzeo, zzig.zza, zzkd {
    protected zzdk zzajn;
    protected zzdi zzajo;
    protected zzdi zzajp;
    protected boolean zzajq = false;
    protected final zzr zzajr;
    protected final zzv zzajs;

    @Nullable
    protected transient AdRequestParcel zzajt;
    protected final zzcg zzaju;
    protected final zzd zzajv;

    zza(zzv zzvVar, @Nullable zzr zzrVar, zzd zzdVar) {
        this.zzajs = zzvVar;
        this.zzajr = zzrVar == null ? new zzr(this) : zzrVar;
        this.zzajv = zzdVar;
        zzu.zzfq().zzad(this.zzajs.zzagf);
        zzu.zzft().zzb(this.zzajs.zzagf, this.zzajs.zzaou);
        this.zzaju = zzu.zzft().zzsv();
        zzdl();
    }

    private AdRequestParcel zza(AdRequestParcel adRequestParcel) {
        return (!com.google.android.gms.common.util.zzi.zzcl(this.zzajs.zzagf) || adRequestParcel.zzats == null) ? adRequestParcel : new com.google.android.gms.ads.internal.client.zzf(adRequestParcel).zza(null).zzig();
    }

    private TimerTask zza(final Timer timer, final CountDownLatch countDownLatch) {
        return new TimerTask() { // from class: com.google.android.gms.ads.internal.zza.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (zzdc.zzbcj.get().intValue() != countDownLatch.getCount()) {
                    zzkh.zzcw("Stopping method tracing");
                    Debug.stopMethodTracing();
                    if (countDownLatch.getCount() == 0) {
                        timer.cancel();
                        return;
                    }
                }
                String strConcat = String.valueOf(zza.this.zzajs.zzagf.getPackageName()).concat("_adsTrace_");
                try {
                    zzkh.zzcw("Starting method tracing");
                    countDownLatch.countDown();
                    Debug.startMethodTracing(new StringBuilder(String.valueOf(strConcat).length() + 20).append(strConcat).append(zzu.zzfu().currentTimeMillis()).toString(), zzdc.zzbck.get().intValue());
                } catch (Exception e) {
                    zzkh.zzd("Exception occurred while starting method tracing.", e);
                }
            }
        };
    }

    private void zzdl() {
        if (zzdc.zzbch.get().booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(zza(timer, new CountDownLatch(zzdc.zzbcj.get().intValue())), 0L, zzdc.zzbci.get().longValue());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void destroy() {
        zzab.zzhj("destroy must be called on the main UI thread.");
        this.zzajr.cancel();
        this.zzaju.zzj(this.zzajs.zzaoz);
        this.zzajs.destroy();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean isLoading() {
        return this.zzajq;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean isReady() {
        zzab.zzhj("isLoaded must be called on the main UI thread.");
        return this.zzajs.zzaow == null && this.zzajs.zzaox == null && this.zzajs.zzaoz != null;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public void onAdClicked() {
        if (this.zzajs.zzaoz == null) {
            zzkh.zzcy("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzkh.zzcw("Pinging click URLs.");
        this.zzajs.zzapb.zzsa();
        if (this.zzajs.zzaoz.zzbnq != null) {
            zzu.zzfq().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, this.zzajs.zzaoz.zzbnq);
        }
        if (this.zzajs.zzapc != null) {
            try {
                this.zzajs.zzapc.onAdClicked();
            } catch (RemoteException e) {
                zzkh.zzd("Could not notify onAdClicked event.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzeo
    public void onAppEvent(String str, @Nullable String str2) {
        if (this.zzajs.zzape != null) {
            try {
                this.zzajs.zzape.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzkh.zzd("Could not call the AppEventListener.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void pause() {
        zzab.zzhj("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void resume() {
        zzab.zzhj("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void setManualImpressionsEnabled(boolean z) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void setUserId(String str) {
        zzkh.zzcy("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void stopLoading() {
        zzab.zzhj("stopLoading must be called on the main UI thread.");
        this.zzajq = false;
        this.zzajs.zzi(true);
    }

    Bundle zza(@Nullable zzco zzcoVar) {
        String strZzhs;
        String strZzsq;
        if (zzcoVar == null) {
            return null;
        }
        if (zzcoVar.zzid()) {
            zzcoVar.wakeup();
        }
        zzcl zzclVarZzib = zzcoVar.zzib();
        if (zzclVarZzib != null) {
            strZzsq = zzclVarZzib.zzhr();
            strZzhs = zzclVarZzib.zzhs();
            String strValueOf = String.valueOf(zzclVarZzib.toString());
            zzkh.zzcw(strValueOf.length() != 0 ? "In AdManager: loadAd, ".concat(strValueOf) : new String("In AdManager: loadAd, "));
            if (strZzsq != null) {
                zzu.zzft().zzcn(strZzsq);
            }
        } else {
            strZzhs = null;
            strZzsq = zzu.zzft().zzsq();
        }
        if (strZzsq == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", strZzsq);
        if (strZzsq.equals(strZzhs)) {
            return bundle;
        }
        bundle.putString("v_fp", strZzhs);
        return bundle;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(AdSizeParcel adSizeParcel) {
        zzab.zzhj("setAdSize must be called on the main UI thread.");
        this.zzajs.zzaoy = adSizeParcel;
        if (this.zzajs.zzaoz != null && this.zzajs.zzaoz.zzbtq != null && this.zzajs.zzapu == 0) {
            this.zzajs.zzaoz.zzbtq.zza(adSizeParcel);
        }
        if (this.zzajs.zzaov == null) {
            return;
        }
        if (this.zzajs.zzaov.getChildCount() > 1) {
            this.zzajs.zzaov.removeView(this.zzajs.zzaov.getNextView());
        }
        this.zzajs.zzaov.setMinimumWidth(adSizeParcel.widthPixels);
        this.zzajs.zzaov.setMinimumHeight(adSizeParcel.heightPixels);
        this.zzajs.zzaov.requestLayout();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(@Nullable VideoOptionsParcel videoOptionsParcel) {
        zzab.zzhj("setVideoOptions must be called on the main UI thread.");
        this.zzajs.zzapn = videoOptionsParcel;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzp zzpVar) {
        zzab.zzhj("setAdListener must be called on the main UI thread.");
        this.zzajs.zzapc = zzpVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        zzab.zzhj("setAdListener must be called on the main UI thread.");
        this.zzajs.zzapd = zzqVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzw zzwVar) {
        zzab.zzhj("setAppEventListener must be called on the main UI thread.");
        this.zzajs.zzape = zzwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzy zzyVar) {
        zzab.zzhj("setCorrelationIdProvider must be called on the main UI thread");
        this.zzajs.zzapf = zzyVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzdVar) {
        zzab.zzhj("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzajs.zzapp = zzdVar;
    }

    protected void zza(@Nullable RewardItemParcel rewardItemParcel) {
        if (this.zzajs.zzapp == null) {
            return;
        }
        String str = "";
        int i = 0;
        if (rewardItemParcel != null) {
            try {
                str = rewardItemParcel.type;
                i = rewardItemParcel.zzcih;
            } catch (RemoteException e) {
                zzkh.zzd("Could not call RewardedVideoAdListener.onRewarded().", e);
                return;
            }
        }
        this.zzajs.zzapp.zza(new zzjh(str, i));
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzdo zzdoVar) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzhs zzhsVar) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzhw zzhwVar, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.request.zza.InterfaceC0730zza
    public void zza(zzjy.zza zzaVar) {
        if (zzaVar.zzciu.zzccg != -1 && !TextUtils.isEmpty(zzaVar.zzciu.zzccp)) {
            long jZzs = zzs(zzaVar.zzciu.zzccp);
            if (jZzs != -1) {
                this.zzajn.zza(this.zzajn.zzc(jZzs + zzaVar.zzciu.zzccg), "stc");
            }
        }
        this.zzajn.zzas(zzaVar.zzciu.zzccp);
        this.zzajn.zza(this.zzajo, "arf");
        this.zzajp = this.zzajn.zzkg();
        this.zzajn.zzh("gqi", zzaVar.zzciu.zzccq);
        this.zzajs.zzaow = null;
        this.zzajs.zzapa = zzaVar;
        zza(zzaVar, this.zzajn);
    }

    protected abstract void zza(zzjy.zza zzaVar, zzdk zzdkVar);

    @Override // com.google.android.gms.internal.zzkd
    public void zza(HashSet<zzjz> hashSet) {
        this.zzajs.zza(hashSet);
    }

    protected abstract boolean zza(AdRequestParcel adRequestParcel, zzdk zzdkVar);

    boolean zza(zzjy zzjyVar) {
        return false;
    }

    protected abstract boolean zza(@Nullable zzjy zzjyVar, zzjy zzjyVar2);

    protected void zzb(View view) {
        this.zzajs.zzaov.addView(view, zzu.zzfs().zztn());
    }

    @Override // com.google.android.gms.internal.zzig.zza
    public void zzb(zzjy zzjyVar) {
        this.zzajn.zza(this.zzajp, "awr");
        this.zzajs.zzaox = null;
        if (zzjyVar.errorCode != -2 && zzjyVar.errorCode != 3) {
            zzu.zzft().zzb(this.zzajs.zzgl());
        }
        if (zzjyVar.errorCode == -1) {
            this.zzajq = false;
            return;
        }
        if (zza(zzjyVar)) {
            zzkh.zzcw("Ad refresh scheduled.");
        }
        if (zzjyVar.errorCode != -2) {
            zzh(zzjyVar.errorCode);
            return;
        }
        if (this.zzajs.zzaps == null) {
            this.zzajs.zzaps = new zzke(this.zzajs.zzaos);
        }
        this.zzaju.zzi(this.zzajs.zzaoz);
        if (zza(this.zzajs.zzaoz, zzjyVar)) {
            this.zzajs.zzaoz = zzjyVar;
            this.zzajs.zzgu();
            this.zzajn.zzh("is_mraid", this.zzajs.zzaoz.zzho() ? "1" : "0");
            this.zzajn.zzh("is_mediation", this.zzajs.zzaoz.zzccc ? "1" : "0");
            if (this.zzajs.zzaoz.zzbtq != null && this.zzajs.zzaoz.zzbtq.zzuk() != null) {
                this.zzajn.zzh("is_delay_pl", this.zzajs.zzaoz.zzbtq.zzuk().zzuz() ? "1" : "0");
            }
            this.zzajn.zza(this.zzajo, "ttc");
            if (zzu.zzft().zzsm() != null) {
                zzu.zzft().zzsm().zza(this.zzajn);
            }
            if (this.zzajs.zzgp()) {
                zzdv();
            }
        }
        if (zzjyVar.zzbnt != null) {
            zzu.zzfq().zza(this.zzajs.zzagf, zzjyVar.zzbnt);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean zzb(AdRequestParcel adRequestParcel) {
        zzab.zzhj("loadAd must be called on the main UI thread.");
        AdRequestParcel adRequestParcelZza = zza(adRequestParcel);
        if (this.zzajs.zzaow != null || this.zzajs.zzaox != null) {
            if (this.zzajt != null) {
                zzkh.zzcy("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            } else {
                zzkh.zzcy("Loading already in progress, saving this object for future refreshes.");
            }
            this.zzajt = adRequestParcelZza;
            return false;
        }
        zzkh.zzcx("Starting ad request.");
        zzdm();
        this.zzajo = this.zzajn.zzkg();
        if (!adRequestParcelZza.zzatn) {
            String strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzm.zziw().zzaq(this.zzajs.zzagf));
            zzkh.zzcx(new StringBuilder(String.valueOf(strValueOf).length() + 71).append("Use AdRequest.Builder.addTestDevice(\"").append(strValueOf).append("\") to get test ads on this device.").toString());
        }
        this.zzajq = zza(adRequestParcelZza, this.zzajn);
        return this.zzajq;
    }

    protected void zzc(@Nullable zzjy zzjyVar) {
        if (zzjyVar == null) {
            zzkh.zzcy("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzkh.zzcw("Pinging Impression URLs.");
        this.zzajs.zzapb.zzrz();
        if (zzjyVar.zzbnr == null || zzjyVar.zzcir) {
            return;
        }
        zzu.zzfq().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, zzjyVar.zzbnr);
        zzjyVar.zzcir = true;
    }

    protected boolean zzc(AdRequestParcel adRequestParcel) {
        if (this.zzajs.zzaov == null) {
            return false;
        }
        Object parent = this.zzajs.zzaov.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return zzu.zzfq().zza(view, view.getContext());
    }

    public void zzd(AdRequestParcel adRequestParcel) {
        if (zzc(adRequestParcel)) {
            zzb(adRequestParcel);
        } else {
            zzkh.zzcx("Ad is not visible. Not refreshing ad.");
            this.zzajr.zzg(adRequestParcel);
        }
    }

    public void zzdm() {
        this.zzajn = new zzdk(zzdc.zzazc.get().booleanValue(), "load_ad", this.zzajs.zzaoy.zzaup);
        this.zzajo = new zzdi(-1L, null, null);
        this.zzajp = new zzdi(-1L, null, null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public com.google.android.gms.dynamic.zzd zzdn() {
        zzab.zzhj("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.zze.zzae(this.zzajs.zzaov);
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    @Nullable
    public AdSizeParcel zzdo() {
        zzab.zzhj("getAdSize must be called on the main UI thread.");
        if (this.zzajs.zzaoy == null) {
            return null;
        }
        return new ThinAdSizeParcel(this.zzajs.zzaoy);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public void zzdp() {
        zzdt();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zzdq() {
        zzab.zzhj("recordManualImpression must be called on the main UI thread.");
        if (this.zzajs.zzaoz == null) {
            zzkh.zzcy("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzkh.zzcw("Pinging manual tracking URLs.");
        if (this.zzajs.zzaoz.zzcce == null || this.zzajs.zzaoz.zzcis) {
            return;
        }
        zzu.zzfq().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, this.zzajs.zzaoz.zzcce);
        this.zzajs.zzaoz.zzcis = true;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public com.google.android.gms.ads.internal.client.zzab zzdr() {
        return null;
    }

    protected void zzds() {
        zzkh.zzcx("Ad closing.");
        if (this.zzajs.zzapd != null) {
            try {
                this.zzajs.zzapd.onAdClosed();
            } catch (RemoteException e) {
                zzkh.zzd("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.zzajs.zzapp != null) {
            try {
                this.zzajs.zzapp.onRewardedVideoAdClosed();
            } catch (RemoteException e2) {
                zzkh.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    protected void zzdt() {
        zzkh.zzcx("Ad leaving application.");
        if (this.zzajs.zzapd != null) {
            try {
                this.zzajs.zzapd.onAdLeftApplication();
            } catch (RemoteException e) {
                zzkh.zzd("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.zzajs.zzapp != null) {
            try {
                this.zzajs.zzapp.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e2) {
                zzkh.zzd("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    protected void zzdu() {
        zzkh.zzcx("Ad opening.");
        if (this.zzajs.zzapd != null) {
            try {
                this.zzajs.zzapd.onAdOpened();
            } catch (RemoteException e) {
                zzkh.zzd("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.zzajs.zzapp != null) {
            try {
                this.zzajs.zzapp.onRewardedVideoAdOpened();
            } catch (RemoteException e2) {
                zzkh.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    protected void zzdv() {
        zzkh.zzcx("Ad finished loading.");
        this.zzajq = false;
        if (this.zzajs.zzapd != null) {
            try {
                this.zzajs.zzapd.onAdLoaded();
            } catch (RemoteException e) {
                zzkh.zzd("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.zzajs.zzapp != null) {
            try {
                this.zzajs.zzapp.onRewardedVideoAdLoaded();
            } catch (RemoteException e2) {
                zzkh.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    protected void zzdw() {
        if (this.zzajs.zzapp == null) {
            return;
        }
        try {
            this.zzajs.zzapp.onRewardedVideoStarted();
        } catch (RemoteException e) {
            zzkh.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", e);
        }
    }

    protected void zzh(int i) {
        zzkh.zzcy(new StringBuilder(30).append("Failed to load ad: ").append(i).toString());
        this.zzajq = false;
        if (this.zzajs.zzapd != null) {
            try {
                this.zzajs.zzapd.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzkh.zzd("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.zzajs.zzapp != null) {
            try {
                this.zzajs.zzapp.onRewardedVideoAdFailedToLoad(i);
            } catch (RemoteException e2) {
                zzkh.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    long zzs(String str) {
        int iIndexOf = str.indexOf("ufe");
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(iIndexOf + 4, iIndexOf2));
        } catch (IndexOutOfBoundsException e) {
            zzkh.zzcy("Invalid index for Url fetch time in CSI latency info.");
            return -1L;
        } catch (NumberFormatException e2) {
            zzkh.zzcy("Cannot find valid format of Url fetch time in CSI latency info.");
            return -1L;
        }
    }
}
