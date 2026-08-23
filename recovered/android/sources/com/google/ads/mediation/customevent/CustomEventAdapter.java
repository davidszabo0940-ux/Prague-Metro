package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zzfu;
    CustomEventBanner zzfv;
    CustomEventInterstitial zzfw;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzfx;
        private final MediationBannerListener zzfy;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzfx = customEventAdapter;
            this.zzfy = mediationBannerListener;
        }

        @Override // com.google.ads.mediation.customevent.CustomEventBannerListener
        public void onClick() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onFailedToReceiveAd.");
            this.zzfy.onClick(this.zzfx);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onDismissScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onFailedToReceiveAd.");
            this.zzfy.onDismissScreen(this.zzfx);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onFailedToReceiveAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onFailedToReceiveAd.");
            this.zzfy.onFailedToReceiveAd(this.zzfx, AdRequest.ErrorCode.NO_FILL);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onLeaveApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onFailedToReceiveAd.");
            this.zzfy.onLeaveApplication(this.zzfx);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onPresentScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onFailedToReceiveAd.");
            this.zzfy.onPresentScreen(this.zzfx);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventBannerListener
        public void onReceivedAd(View view) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onReceivedAd.");
            this.zzfx.zza(view);
            this.zzfy.onReceivedAd(this.zzfx);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzfx;
        private final MediationInterstitialListener zzfz;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzfx = customEventAdapter;
            this.zzfz = mediationInterstitialListener;
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onDismissScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onDismissScreen.");
            this.zzfz.onDismissScreen(this.zzfx);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onFailedToReceiveAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onFailedToReceiveAd.");
            this.zzfz.onFailedToReceiveAd(this.zzfx, AdRequest.ErrorCode.NO_FILL);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onLeaveApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onLeaveApplication.");
            this.zzfz.onLeaveApplication(this.zzfx);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onPresentScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onPresentScreen.");
            this.zzfz.onPresentScreen(this.zzfx);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventInterstitialListener
        public void onReceivedAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onReceivedAd.");
            this.zzfz.onReceivedAd(CustomEventAdapter.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(View view) {
        this.zzfu = view;
    }

    private static <T> T zzj(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String strValueOf = String.valueOf(th.getMessage());
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(strValueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(strValueOf).toString());
            return null;
        }
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public void destroy() {
        if (this.zzfv != null) {
            this.zzfv.destroy();
        }
        if (this.zzfw != null) {
            this.zzfw.destroy();
        }
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.zzfu;
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzfv = (CustomEventBanner) zzj(customEventServerParameters.className);
        if (this.zzfv == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzfv.requestBannerAd(new zza(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzfw = (CustomEventInterstitial) zzj(customEventServerParameters.className);
        if (this.zzfw == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzfw.requestInterstitialAd(zza(mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.zzfw.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, mediationInterstitialListener);
    }
}
