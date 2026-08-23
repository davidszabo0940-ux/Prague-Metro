package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzgm;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzib;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzaf {
    private final Context mContext;
    private final zzh zzahz;
    private String zzall;
    private zza zzati;
    private AdListener zzatj;
    private AppEventListener zzauv;
    private final zzgm zzavz;
    private Correlator zzawd;
    private zzu zzawe;
    private InAppPurchaseListener zzawf;
    private OnCustomRenderedAdLoadedListener zzawg;
    private PlayStorePurchaseListener zzawh;
    private String zzawj;
    private PublisherInterstitialAd zzawn;
    private boolean zzawo;
    private RewardedVideoAdListener zzfh;

    public zzaf(Context context) {
        this(context, zzh.zzih(), null);
    }

    public zzaf(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzh.zzih(), publisherInterstitialAd);
    }

    public zzaf(Context context, zzh zzhVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzavz = new zzgm();
        this.mContext = context;
        this.zzahz = zzhVar;
        this.zzawn = publisherInterstitialAd;
    }

    private void zzam(String str) throws RemoteException {
        if (this.zzall == null) {
            zzan(str);
        }
        this.zzawe = zzm.zzix().zzb(this.mContext, this.zzawo ? AdSizeParcel.zzii() : new AdSizeParcel(), this.zzall, this.zzavz);
        if (this.zzatj != null) {
            this.zzawe.zza(new zzc(this.zzatj));
        }
        if (this.zzati != null) {
            this.zzawe.zza(new zzb(this.zzati));
        }
        if (this.zzauv != null) {
            this.zzawe.zza(new zzj(this.zzauv));
        }
        if (this.zzawf != null) {
            this.zzawe.zza(new zzhx(this.zzawf));
        }
        if (this.zzawh != null) {
            this.zzawe.zza(new zzib(this.zzawh), this.zzawj);
        }
        if (this.zzawg != null) {
            this.zzawe.zza(new zzdp(this.zzawg));
        }
        if (this.zzawd != null) {
            this.zzawe.zza(this.zzawd.zzde());
        }
        if (this.zzfh != null) {
            this.zzawe.zza(new com.google.android.gms.ads.internal.reward.client.zzg(this.zzfh));
        }
    }

    private void zzan(String str) {
        if (this.zzawe == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 63).append("The ad unit ID must be set on InterstitialAd before ").append(str).append(" is called.").toString());
        }
    }

    public AdListener getAdListener() {
        return this.zzatj;
    }

    public String getAdUnitId() {
        return this.zzall;
    }

    public AppEventListener getAppEventListener() {
        return this.zzauv;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzawf;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.zzawe != null) {
                return this.zzawe.getMediationAdapterClassName();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzawg;
    }

    public boolean isLoaded() {
        try {
            if (this.zzawe == null) {
                return false;
            }
            return this.zzawe.isReady();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to check if ad is ready.", e);
            return false;
        }
    }

    public boolean isLoading() {
        try {
            if (this.zzawe == null) {
                return false;
            }
            return this.zzawe.isLoading();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.zzatj = adListener;
            if (this.zzawe != null) {
                this.zzawe.zza(adListener != null ? new zzc(adListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String str) {
        if (this.zzall != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzall = str;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzauv = appEventListener;
            if (this.zzawe != null) {
                this.zzawe.zza(appEventListener != null ? new zzj(appEventListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AppEventListener.", e);
        }
    }

    public void setCorrelator(Correlator correlator) {
        this.zzawd = correlator;
        try {
            if (this.zzawe != null) {
                this.zzawe.zza(this.zzawd == null ? null : this.zzawd.zzde());
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set correlator.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.zzawh != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.zzawf = inAppPurchaseListener;
            if (this.zzawe != null) {
                this.zzawe.zza(inAppPurchaseListener != null ? new zzhx(inAppPurchaseListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzawg = onCustomRenderedAdLoadedListener;
            if (this.zzawe != null) {
                this.zzawe.zza(onCustomRenderedAdLoadedListener != null ? new zzdp(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.zzawf != null) {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        try {
            this.zzawh = playStorePurchaseListener;
            this.zzawj = str;
            if (this.zzawe != null) {
                this.zzawe.zza(playStorePurchaseListener != null ? new zzib(playStorePurchaseListener) : null, str);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the play store purchase parameter.", e);
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzfh = rewardedVideoAdListener;
            if (this.zzawe != null) {
                this.zzawe.zza(rewardedVideoAdListener != null ? new com.google.android.gms.ads.internal.reward.client.zzg(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdListener.", e);
        }
    }

    public void show() {
        try {
            zzan("show");
            this.zzawe.showInterstitial();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to show interstitial.", e);
        }
    }

    public void zza(zza zzaVar) {
        try {
            this.zzati = zzaVar;
            if (this.zzawe != null) {
                this.zzawe.zza(zzaVar != null ? new zzb(zzaVar) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdClickListener.", e);
        }
    }

    public void zza(zzad zzadVar) {
        try {
            if (this.zzawe == null) {
                zzam("loadAd");
            }
            if (this.zzawe.zzb(this.zzahz.zza(this.mContext, zzadVar))) {
                this.zzavz.zzh(zzadVar.zzjg());
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to load ad.", e);
        }
    }

    public void zzd(boolean z) {
        this.zzawo = z;
    }
}
