package com.google.unity.ads;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/* JADX INFO: loaded from: classes.dex */
public class Banner {
    private static final int POSITION_BOTTOM = 1;
    private static final int POSITION_BOTTOM_LEFT = 4;
    private static final int POSITION_BOTTOM_RIGHT = 5;
    private static final int POSITION_TOP = 0;
    private static final int POSITION_TOP_LEFT = 2;
    private static final int POSITION_TOP_RIGHT = 3;
    private Activity activity;
    private AdView adView;
    private UnityBannerAdListener listener;

    public Banner(Activity activity, UnityBannerAdListener listener) {
        this.activity = activity;
        this.listener = listener;
    }

    public void create(final String publisherId, final AdSize adSize, final int positionCode) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Banner.1
            @Override // java.lang.Runnable
            public void run() {
                Banner.this.adView = new AdView(Banner.this.activity);
                Banner.this.adView.setBackgroundColor(0);
                Banner.this.adView.setAdUnitId(publisherId);
                Banner.this.adView.setAdSize(adSize);
                Banner.this.adView.setAdListener(new AdListener() { // from class: com.google.unity.ads.Banner.1.1
                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdLoaded() {
                        if (Banner.this.listener != null) {
                            Banner.this.listener.onAdLoaded();
                        }
                    }

                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdFailedToLoad(int errorCode) {
                        if (Banner.this.listener != null) {
                            Banner.this.listener.onAdFailedToLoad(PluginUtils.getErrorReason(errorCode));
                        }
                    }

                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdOpened() {
                        if (Banner.this.listener != null) {
                            Banner.this.listener.onAdOpened();
                        }
                    }

                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdClosed() {
                        if (Banner.this.listener != null) {
                            Banner.this.listener.onAdClosed();
                        }
                    }

                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdLeftApplication() {
                        if (Banner.this.listener != null) {
                            Banner.this.listener.onAdLeftApplication();
                        }
                    }
                });
                FrameLayout.LayoutParams adParams = new FrameLayout.LayoutParams(-2, -2);
                switch (positionCode) {
                    case 0:
                        adParams.gravity = 49;
                        break;
                    case 1:
                        adParams.gravity = 81;
                        break;
                    case 2:
                        adParams.gravity = 51;
                        break;
                    case 3:
                        adParams.gravity = 53;
                        break;
                    case 4:
                        adParams.gravity = 83;
                        break;
                    case 5:
                        adParams.gravity = 85;
                        break;
                }
                Banner.this.activity.addContentView(Banner.this.adView, adParams);
            }
        });
    }

    public void setAdListener(UnityBannerAdListener listener) {
        this.listener = listener;
    }

    public void loadAd(final AdRequest request) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Banner.2
            @Override // java.lang.Runnable
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling loadAd() on Android");
                Banner.this.adView.loadAd(request);
            }
        });
    }

    public void show() {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Banner.3
            @Override // java.lang.Runnable
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling show() on Android");
                Banner.this.adView.setVisibility(0);
                Banner.this.adView.resume();
            }
        });
    }

    public void hide() {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Banner.4
            @Override // java.lang.Runnable
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling hide() on Android");
                Banner.this.adView.setVisibility(8);
                Banner.this.adView.pause();
            }
        });
    }

    public void destroy() {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Banner.5
            @Override // java.lang.Runnable
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling destroy() on Android");
                Banner.this.adView.destroy();
                ViewParent parentView = Banner.this.adView.getParent();
                if (parentView != null && (parentView instanceof ViewGroup)) {
                    ((ViewGroup) parentView).removeView(Banner.this.adView);
                }
            }
        });
    }
}
