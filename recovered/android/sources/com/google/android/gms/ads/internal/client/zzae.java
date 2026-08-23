package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzgm;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzib;
import com.google.android.gms.internal.zzir;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzae {
    private final zzh zzahz;
    private boolean zzakp;
    private String zzall;
    private zza zzati;
    private AdListener zzatj;
    private AppEventListener zzauv;
    private AdSize[] zzauw;
    private final zzgm zzavz;
    private final AtomicBoolean zzawa;
    private final VideoController zzawb;
    final zzo zzawc;
    private Correlator zzawd;
    private zzu zzawe;
    private InAppPurchaseListener zzawf;
    private OnCustomRenderedAdLoadedListener zzawg;
    private PlayStorePurchaseListener zzawh;
    private VideoOptions zzawi;
    private String zzawj;
    private ViewGroup zzawk;
    private boolean zzawl;

    public zzae(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzh.zzih(), false);
    }

    public zzae(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzh.zzih(), false);
    }

    zzae(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzh zzhVar, zzu zzuVar, boolean z2) {
        this.zzavz = new zzgm();
        this.zzawb = new VideoController();
        this.zzawc = new zzo() { // from class: com.google.android.gms.ads.internal.client.zzae.1
            @Override // com.google.android.gms.ads.internal.client.zzo, com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                zzae.this.zzawb.zza(zzae.this.zzjk());
                super.onAdFailedToLoad(i);
            }

            @Override // com.google.android.gms.ads.internal.client.zzo, com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                zzae.this.zzawb.zza(zzae.this.zzjk());
                super.onAdLoaded();
            }
        };
        this.zzawk = viewGroup;
        this.zzahz = zzhVar;
        this.zzawe = zzuVar;
        this.zzawa = new AtomicBoolean(false);
        this.zzawl = z2;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzk zzkVar = new zzk(context, attributeSet);
                this.zzauw = zzkVar.zzl(z);
                this.zzall = zzkVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzm.zziw().zza(viewGroup, zza(context, this.zzauw[0], this.zzawl), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzm.zziw().zza(viewGroup, new AdSizeParcel(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    zzae(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzh zzhVar, boolean z2) {
        this(viewGroup, attributeSet, z, zzhVar, null, z2);
    }

    public zzae(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, boolean z2) {
        this(viewGroup, attributeSet, z, zzh.zzih(), z2);
    }

    public zzae(ViewGroup viewGroup, boolean z) {
        this(viewGroup, null, false, zzh.zzih(), z);
    }

    private static AdSizeParcel zza(Context context, AdSize adSize, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, adSize);
        adSizeParcel.zzk(z);
        return adSizeParcel;
    }

    private static AdSizeParcel zza(Context context, AdSize[] adSizeArr, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, adSizeArr);
        adSizeParcel.zzk(z);
        return adSizeParcel;
    }

    private void zzjl() {
        try {
            com.google.android.gms.dynamic.zzd zzdVarZzdn = this.zzawe.zzdn();
            if (zzdVarZzdn == null) {
                return;
            }
            this.zzawk.addView((View) com.google.android.gms.dynamic.zze.zzad(zzdVarZzdn));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get an ad frame.", e);
        }
    }

    public void destroy() {
        try {
            if (this.zzawe != null) {
                this.zzawe.destroy();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.zzatj;
    }

    public AdSize getAdSize() {
        AdSizeParcel adSizeParcelZzdo;
        try {
            if (this.zzawe != null && (adSizeParcelZzdo = this.zzawe.zzdo()) != null) {
                return adSizeParcelZzdo.zzij();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the current AdSize.", e);
        }
        if (this.zzauw != null) {
            return this.zzauw[0];
        }
        return null;
    }

    public AdSize[] getAdSizes() {
        return this.zzauw;
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

    public VideoController getVideoController() {
        return this.zzawb;
    }

    public VideoOptions getVideoOptions() {
        return this.zzawi;
    }

    public boolean isLoading() {
        try {
            if (this.zzawe != null) {
                return this.zzawe.isLoading();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to check if ad is loading.", e);
        }
        return false;
    }

    public void pause() {
        try {
            if (this.zzawe != null) {
                this.zzawe.pause();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        if (this.zzawa.getAndSet(true)) {
            return;
        }
        try {
            if (this.zzawe != null) {
                this.zzawe.zzdq();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to record impression.", e);
        }
    }

    public void resume() {
        try {
            if (this.zzawe != null) {
                this.zzawe.resume();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call resume.", e);
        }
    }

    public void setAdListener(AdListener adListener) {
        this.zzatj = adListener;
        this.zzawc.zza(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (this.zzauw != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizeArr);
    }

    public void setAdUnitId(String str) {
        if (this.zzall != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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

    public void setManualImpressionsEnabled(boolean z) {
        this.zzakp = z;
        try {
            if (this.zzawe != null) {
                this.zzawe.setManualImpressionsEnabled(this.zzakp);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set manual impressions.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzawg = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzawe != null) {
                this.zzawe.zza(onCustomRenderedAdLoadedListener != null ? new zzdp(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.zzawf != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
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

    public void setVideoOptions(VideoOptions videoOptions) {
        this.zzawi = videoOptions;
        try {
            if (this.zzawe != null) {
                this.zzawe.zza(videoOptions == null ? null : new VideoOptionsParcel(videoOptions));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set video options.", e);
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
                zzjm();
            }
            if (this.zzawe.zzb(this.zzahz.zza(this.zzawk.getContext(), zzadVar))) {
                this.zzavz.zzh(zzadVar.zzjg());
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to load ad.", e);
        }
    }

    public void zza(AdSize... adSizeArr) {
        this.zzauw = adSizeArr;
        try {
            if (this.zzawe != null) {
                this.zzawe.zza(zza(this.zzawk.getContext(), this.zzauw, this.zzawl));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the ad size.", e);
        }
        this.zzawk.requestLayout();
    }

    public boolean zzb(AdSizeParcel adSizeParcel) {
        return "search_v2".equals(adSizeParcel.zzaup);
    }

    public zzab zzjk() {
        if (this.zzawe == null) {
            return null;
        }
        try {
            return this.zzawe.zzdr();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to retrieve VideoController.", e);
            return null;
        }
    }

    void zzjm() throws RemoteException {
        if ((this.zzauw == null || this.zzall == null) && this.zzawe == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.zzawe = zzjn();
        this.zzawe.zza(new zzc(this.zzawc));
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
        if (this.zzawi != null) {
            this.zzawe.zza(new VideoOptionsParcel(this.zzawi));
        }
        this.zzawe.setManualImpressionsEnabled(this.zzakp);
        zzjl();
    }

    protected zzu zzjn() throws RemoteException {
        Context context = this.zzawk.getContext();
        AdSizeParcel adSizeParcelZza = zza(context, this.zzauw, this.zzawl);
        return zzb(adSizeParcelZza) ? zzm.zzix().zza(context, adSizeParcelZza, this.zzall) : zzm.zzix().zza(context, adSizeParcelZza, this.zzall, this.zzavz);
    }
}
