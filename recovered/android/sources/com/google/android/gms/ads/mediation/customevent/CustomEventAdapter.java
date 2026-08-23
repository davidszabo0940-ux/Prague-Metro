package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepName;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    CustomEventBanner zzcqu;
    CustomEventInterstitial zzcqv;
    CustomEventNative zzcqw;
    private View zzfu;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzcqx;
        private final MediationBannerListener zzfm;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzcqx = customEventAdapter;
            this.zzfm = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdClicked.");
            this.zzfm.onAdClicked(this.zzcqx);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdClosed.");
            this.zzfm.onAdClosed(this.zzcqx);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdFailedToLoad(int i) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdFailedToLoad.");
            this.zzfm.onAdFailedToLoad(this.zzcqx, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdLeftApplication.");
            this.zzfm.onAdLeftApplication(this.zzcqx);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
        public void onAdLoaded(View view) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdLoaded.");
            this.zzcqx.zza(view);
            this.zzfm.onAdLoaded(this.zzcqx);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdOpened.");
            this.zzfm.onAdOpened(this.zzcqx);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzcqx;
        private final MediationInterstitialListener zzfn;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzcqx = customEventAdapter;
            this.zzfn = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdClicked.");
            this.zzfn.onAdClicked(this.zzcqx);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdClosed.");
            this.zzfn.onAdClosed(this.zzcqx);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdFailedToLoad(int i) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onFailedToReceiveAd.");
            this.zzfn.onAdFailedToLoad(this.zzcqx, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdLeftApplication.");
            this.zzfn.onAdLeftApplication(this.zzcqx);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
        public void onAdLoaded() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onReceivedAd.");
            this.zzfn.onAdLoaded(CustomEventAdapter.this);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdOpened.");
            this.zzfn.onAdOpened(this.zzcqx);
        }
    }

    static class zzc implements CustomEventNativeListener {
        private final CustomEventAdapter zzcqx;
        private final MediationNativeListener zzfo;

        public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzcqx = customEventAdapter;
            this.zzfo = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdClicked.");
            this.zzfo.onAdClicked(this.zzcqx);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdClosed.");
            this.zzfo.onAdClosed(this.zzcqx);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdFailedToLoad(int i) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdFailedToLoad.");
            this.zzfo.onAdFailedToLoad(this.zzcqx, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public void onAdImpression() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdImpression.");
            this.zzfo.onAdImpression(this.zzcqx);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdLeftApplication.");
            this.zzfo.onAdLeftApplication(this.zzcqx);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public void onAdLoaded(NativeAdMapper nativeAdMapper) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdLoaded.");
            this.zzfo.onAdLoaded(this.zzcqx, nativeAdMapper);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Custom event adapter called onAdOpened.");
            this.zzfo.onAdOpened(this.zzcqx);
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

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.zzfu;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        if (this.zzcqu != null) {
            this.zzcqu.onDestroy();
        }
        if (this.zzcqv != null) {
            this.zzcqv.onDestroy();
        }
        if (this.zzcqw != null) {
            this.zzcqw.onDestroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
        if (this.zzcqu != null) {
            this.zzcqu.onPause();
        }
        if (this.zzcqv != null) {
            this.zzcqv.onPause();
        }
        if (this.zzcqw != null) {
            this.zzcqw.onPause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
        if (this.zzcqu != null) {
            this.zzcqu.onResume();
        }
        if (this.zzcqv != null) {
            this.zzcqv.onResume();
        }
        if (this.zzcqw != null) {
            this.zzcqw.onResume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzcqu = (CustomEventBanner) zzj(bundle.getString("class_name"));
        if (this.zzcqu == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzcqu.requestBannerAd(context, new zza(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzcqv = (CustomEventInterstitial) zzj(bundle.getString("class_name"));
        if (this.zzcqv == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzcqv.requestInterstitialAd(context, zza(mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.zzcqw = (CustomEventNative) zzj(bundle.getString("class_name"));
        if (this.zzcqw == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzcqw.requestNativeAd(context, new zzc(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.zzcqv.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, mediationInterstitialListener);
    }
}
