package com.google.unity.ads;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

/* JADX INFO: loaded from: classes.dex */
public class Interstitial {
    private Activity activity;
    private UnityInterstitialAdListener adListener;
    private InterstitialAd interstitial;
    private boolean isLoaded = false;

    public Interstitial(Activity activity, UnityInterstitialAdListener adListener) {
        this.activity = activity;
        this.adListener = adListener;
    }

    public void create(final String adUnitId) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Interstitial.1
            @Override // java.lang.Runnable
            public void run() {
                Interstitial.this.interstitial = new InterstitialAd(Interstitial.this.activity);
                Interstitial.this.interstitial.setAdUnitId(adUnitId);
                Interstitial.this.interstitial.setAdListener(new AdListener() { // from class: com.google.unity.ads.Interstitial.1.1
                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdLoaded() {
                        Interstitial.this.isLoaded = true;
                        Interstitial.this.adListener.onAdLoaded();
                    }

                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdFailedToLoad(int errorCode) {
                        Interstitial.this.adListener.onAdFailedToLoad(PluginUtils.getErrorReason(errorCode));
                    }

                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdOpened() {
                        Interstitial.this.adListener.onAdOpened();
                    }

                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdClosed() {
                        Interstitial.this.adListener.onAdClosed();
                    }

                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdLeftApplication() {
                        Interstitial.this.adListener.onAdLeftApplication();
                    }
                });
            }
        });
    }

    public void loadAd(final AdRequest request) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Interstitial.2
            @Override // java.lang.Runnable
            public void run() {
                Interstitial.this.interstitial.loadAd(request);
            }
        });
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public void show() {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Interstitial.3
            @Override // java.lang.Runnable
            public void run() {
                if (Interstitial.this.interstitial.isLoaded()) {
                    Interstitial.this.isLoaded = false;
                    Interstitial.this.interstitial.show();
                } else {
                    Log.d(PluginUtils.LOGTAG, "Interstitial was not ready to be shown.");
                }
            }
        });
    }

    public void setPlayStorePurchaseParams(final PlayStorePurchaseListener purchaseListener, final String publicKey) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Interstitial.4
            @Override // java.lang.Runnable
            public void run() {
                Interstitial.this.interstitial.setPlayStorePurchaseParams(purchaseListener, publicKey);
            }
        });
    }

    public void setInAppPurchaseListener(final InAppPurchaseListener purchaseListener) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Interstitial.5
            @Override // java.lang.Runnable
            public void run() {
                Interstitial.this.interstitial.setInAppPurchaseListener(purchaseListener);
            }
        });
    }

    public void destroy() {
    }
}
