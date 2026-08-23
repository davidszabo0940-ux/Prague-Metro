package com.google.unity.ads;

/* JADX INFO: loaded from: classes.dex */
public interface UnityCustomNativeAdListener {
    void onAdFailedToLoad(String str);

    void onCustomClick(CustomNativeAd customNativeAd, String str);

    void onCustomTemplateAdLoaded(CustomNativeAd customNativeAd);
}
