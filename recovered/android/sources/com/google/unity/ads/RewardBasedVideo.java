package com.google.unity.ads;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* JADX INFO: loaded from: classes.dex */
public class RewardBasedVideo {
    private Activity activity;
    private UnityRewardBasedVideoAdListener adListener;
    private RewardedVideoAd rewardBasedVideo;
    private final Object mLock = new Object();
    private boolean isLoaded = false;

    public RewardBasedVideo(Activity activity, UnityRewardBasedVideoAdListener adListener) {
        this.activity = activity;
        this.adListener = adListener;
    }

    public void create() {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.RewardBasedVideo.1
            @Override // java.lang.Runnable
            public void run() {
                RewardBasedVideo.this.rewardBasedVideo = MobileAds.getRewardedVideoAdInstance(RewardBasedVideo.this.activity);
                RewardBasedVideo.this.rewardBasedVideo.setRewardedVideoAdListener(new RewardedVideoAdListener() { // from class: com.google.unity.ads.RewardBasedVideo.1.1
                    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
                    public void onRewardedVideoAdLoaded() {
                        RewardBasedVideo.this.isLoaded = true;
                        RewardBasedVideo.this.adListener.onAdLoaded();
                    }

                    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
                    public void onRewardedVideoAdFailedToLoad(int errorCode) {
                        RewardBasedVideo.this.adListener.onAdFailedToLoad(PluginUtils.getErrorReason(errorCode));
                    }

                    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
                    public void onRewardedVideoAdOpened() {
                        RewardBasedVideo.this.adListener.onAdOpened();
                    }

                    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
                    public void onRewardedVideoStarted() {
                        RewardBasedVideo.this.adListener.onAdStarted();
                    }

                    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
                    public void onRewardedVideoAdClosed() {
                        RewardBasedVideo.this.adListener.onAdClosed();
                    }

                    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
                    public void onRewarded(RewardItem reward) {
                        RewardBasedVideo.this.adListener.onAdRewarded(reward.getType(), reward.getAmount());
                    }

                    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
                    public void onRewardedVideoAdLeftApplication() {
                        RewardBasedVideo.this.adListener.onAdLeftApplication();
                    }
                });
            }
        });
    }

    public void loadAd(final AdRequest request, final String adUnitId) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.RewardBasedVideo.2
            @Override // java.lang.Runnable
            public void run() {
                RewardBasedVideo.this.rewardBasedVideo.loadAd(adUnitId, request);
            }
        });
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public void show() {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.RewardBasedVideo.3
            @Override // java.lang.Runnable
            public void run() {
                if (RewardBasedVideo.this.rewardBasedVideo.isLoaded()) {
                    RewardBasedVideo.this.isLoaded = false;
                    RewardBasedVideo.this.rewardBasedVideo.show();
                } else {
                    Log.w(PluginUtils.LOGTAG, "Reward based video ad is not ready to be shown.");
                }
            }
        });
    }

    public void destroy() {
        this.rewardBasedVideo.destroy();
    }
}
