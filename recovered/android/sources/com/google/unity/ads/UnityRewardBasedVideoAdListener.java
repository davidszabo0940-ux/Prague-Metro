package com.google.unity.ads;

/* JADX INFO: loaded from: classes.dex */
public interface UnityRewardBasedVideoAdListener {
    void onAdClosed();

    void onAdFailedToLoad(String str);

    void onAdLeftApplication();

    void onAdLoaded();

    void onAdOpened();

    void onAdRewarded(String str, float f);

    void onAdStarted();
}
