package com.google.unity.ads;

/* JADX INFO: loaded from: classes.dex */
public interface UnityInterstitialAdListener {
    void onAdClosed();

    void onAdFailedToLoad(String str);

    void onAdLeftApplication();

    void onAdLoaded();

    void onAdOpened();
}
