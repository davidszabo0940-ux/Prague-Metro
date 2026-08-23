package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzhc implements MediationInterstitialAdapter {
    private Uri mUri;
    private Activity zzbpy;
    private zzdq zzbpz;
    private MediationInterstitialListener zzbqa;

    public static boolean zzp(Context context) {
        return zzdq.zzo(context);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Destroying AdMobCustomTabsAdapter adapter.");
        try {
            this.zzbpz.zzd(this.zzbpy);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Exception while unbinding from CustomTabsService.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Resuming AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzbqa = mediationInterstitialListener;
        if (this.zzbqa == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("Listener not set for mediation. Returning.");
            return;
        }
        if (!(context instanceof Activity)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzbqa.onAdFailedToLoad(this, 0);
            return;
        }
        if (!zzp(context)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("Default browser does not support custom tabs. Bailing out.");
            this.zzbqa.onAdFailedToLoad(this, 0);
            return;
        }
        String string = bundle.getString("tab_url");
        if (TextUtils.isEmpty(string)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("The tab_url retrieved from mediation metadata is empty. Bailing out.");
            this.zzbqa.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzbpy = (Activity) context;
        this.mUri = Uri.parse(string);
        this.zzbpz = new zzdq();
        this.zzbpz.zza(new zzdq.zza() { // from class: com.google.android.gms.internal.zzhc.1
            @Override // com.google.android.gms.internal.zzdq.zza
            public void zzkn() {
                com.google.android.gms.ads.internal.util.client.zzb.zzcw("Hinting CustomTabsService for the load of the new url.");
            }

            @Override // com.google.android.gms.internal.zzdq.zza
            public void zzko() {
                com.google.android.gms.ads.internal.util.client.zzb.zzcw("Disconnecting from CustomTabs service.");
            }
        });
        this.zzbpz.zze(this.zzbpy);
        this.zzbqa.onAdLoaded(this);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder(this.zzbpz.zzkl()).build();
        customTabsIntentBuild.intent.setData(this.mUri);
        final AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(new AdLauncherIntentInfoParcel(customTabsIntentBuild.intent), null, new com.google.android.gms.ads.internal.overlay.zzg() { // from class: com.google.android.gms.internal.zzhc.2
            @Override // com.google.android.gms.ads.internal.overlay.zzg
            public void onPause() {
                com.google.android.gms.ads.internal.util.client.zzb.zzcw("AdMobCustomTabsAdapter overlay is paused.");
            }

            @Override // com.google.android.gms.ads.internal.overlay.zzg
            public void onResume() {
                com.google.android.gms.ads.internal.util.client.zzb.zzcw("AdMobCustomTabsAdapter overlay is resumed.");
            }

            @Override // com.google.android.gms.ads.internal.overlay.zzg
            public void zzdy() {
                com.google.android.gms.ads.internal.util.client.zzb.zzcw("AdMobCustomTabsAdapter overlay is closed.");
                zzhc.this.zzbqa.onAdClosed(zzhc.this);
                zzhc.this.zzbpz.zzd(zzhc.this.zzbpy);
            }

            @Override // com.google.android.gms.ads.internal.overlay.zzg
            public void zzdz() {
                com.google.android.gms.ads.internal.util.client.zzb.zzcw("Opening AdMobCustomTabsAdapter overlay.");
                zzhc.this.zzbqa.onAdOpened(zzhc.this);
            }
        }, null, new VersionInfoParcel(0, 0, false));
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzhc.3
            @Override // java.lang.Runnable
            public void run() {
                com.google.android.gms.ads.internal.zzu.zzfo().zza(zzhc.this.zzbpy, adOverlayInfoParcel);
            }
        });
        com.google.android.gms.ads.internal.zzu.zzft().zzaf(false);
    }
}
