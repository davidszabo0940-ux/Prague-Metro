package com.google.unity.ads;

import android.app.Activity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* JADX INFO: loaded from: classes.dex */
public class NativeAdLoader {
    private Activity mActivity;
    private AdLoader mAdLoader;
    private AdLoader.Builder mAdLoaderBuilder;
    private UnityCustomNativeAdListener mListener;

    public NativeAdLoader(final Activity activity, final String adUnitId, UnityCustomNativeAdListener listener) {
        this.mActivity = activity;
        this.mListener = listener;
        activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.NativeAdLoader.1
            @Override // java.lang.Runnable
            public void run() {
                NativeAdLoader.this.mAdLoaderBuilder = new AdLoader.Builder(activity, adUnitId);
            }
        });
    }

    public void create() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.NativeAdLoader.2
            @Override // java.lang.Runnable
            public void run() {
                NativeAdLoader.this.mAdLoader = NativeAdLoader.this.mAdLoaderBuilder.build();
            }
        });
    }

    public void configureCustomNativeTemplateAd(final String templateID, final boolean useClickListener) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.NativeAdLoader.3
            @Override // java.lang.Runnable
            public void run() {
                NativeCustomTemplateAd.OnCustomClickListener clickListener = null;
                if (useClickListener) {
                    clickListener = new NativeCustomTemplateAd.OnCustomClickListener() { // from class: com.google.unity.ads.NativeAdLoader.3.1
                        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener
                        public void onCustomClick(NativeCustomTemplateAd ad, String assetName) {
                            NativeAdLoader.this.mListener.onCustomClick(new CustomNativeAd(NativeAdLoader.this.mActivity, ad), assetName);
                        }
                    };
                }
                NativeAdLoader.this.mAdLoaderBuilder = NativeAdLoader.this.mAdLoaderBuilder.forCustomTemplateAd(templateID, new NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener() { // from class: com.google.unity.ads.NativeAdLoader.3.3
                    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener
                    public void onCustomTemplateAdLoaded(NativeCustomTemplateAd ad) {
                        NativeAdLoader.this.mListener.onCustomTemplateAdLoaded(new CustomNativeAd(NativeAdLoader.this.mActivity, ad));
                    }
                }, clickListener).withAdListener(new AdListener() { // from class: com.google.unity.ads.NativeAdLoader.3.2
                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdFailedToLoad(int errorCode) {
                        NativeAdLoader.this.mListener.onAdFailedToLoad(PluginUtils.getErrorReason(errorCode));
                    }
                });
            }
        });
    }

    public void loadAd(final AdRequest request) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.NativeAdLoader.4
            @Override // java.lang.Runnable
            public void run() {
                NativeAdLoader.this.mAdLoader.loadAd(request);
            }
        });
    }
}
