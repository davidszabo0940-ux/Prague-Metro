package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzha<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzgp zzbpo;

    public zzha(zzgp zzgpVar) {
        this.zzbpo = zzgpVar;
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Adapter called onClick.");
        if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("onClick must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzha.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzha.this.zzbpo.onAdClicked();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClicked.", e);
                    }
                }
            });
        } else {
            try {
                this.zzbpo.onAdClicked();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClicked.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Adapter called onDismissScreen.");
        if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("onDismissScreen must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzha.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzha.this.zzbpo.onAdClosed();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", e);
                    }
                }
            });
        } else {
            try {
                this.zzbpo.onAdClosed();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Adapter called onDismissScreen.");
        if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("onDismissScreen must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzha.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzha.this.zzbpo.onAdClosed();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", e);
                    }
                }
            });
        } else {
            try {
                this.zzbpo.onAdClosed();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final AdRequest.ErrorCode errorCode) {
        String strValueOf = String.valueOf(errorCode);
        com.google.android.gms.ads.internal.util.client.zzb.zzcw(new StringBuilder(String.valueOf(strValueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(strValueOf).toString());
        if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("onFailedToReceiveAd must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzha.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzha.this.zzbpo.onAdFailedToLoad(zzhb.zza(errorCode));
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
        } else {
            try {
                this.zzbpo.onAdFailedToLoad(zzhb.zza(errorCode));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final AdRequest.ErrorCode errorCode) {
        String strValueOf = String.valueOf(errorCode);
        com.google.android.gms.ads.internal.util.client.zzb.zzcw(new StringBuilder(String.valueOf(strValueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(strValueOf).append(".").toString());
        if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("onFailedToReceiveAd must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzha.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzha.this.zzbpo.onAdFailedToLoad(zzhb.zza(errorCode));
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
        } else {
            try {
                this.zzbpo.onAdFailedToLoad(zzhb.zza(errorCode));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Adapter called onLeaveApplication.");
        if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("onLeaveApplication must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzha.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzha.this.zzbpo.onAdLeftApplication();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", e);
                    }
                }
            });
        } else {
            try {
                this.zzbpo.onAdLeftApplication();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Adapter called onLeaveApplication.");
        if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("onLeaveApplication must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzha.11
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzha.this.zzbpo.onAdLeftApplication();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", e);
                    }
                }
            });
        } else {
            try {
                this.zzbpo.onAdLeftApplication();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Adapter called onPresentScreen.");
        if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("onPresentScreen must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzha.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzha.this.zzbpo.onAdOpened();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", e);
                    }
                }
            });
        } else {
            try {
                this.zzbpo.onAdOpened();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Adapter called onPresentScreen.");
        if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("onPresentScreen must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzha.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzha.this.zzbpo.onAdOpened();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", e);
                    }
                }
            });
        } else {
            try {
                this.zzbpo.onAdOpened();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Adapter called onReceivedAd.");
        if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("onReceivedAd must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzha.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzha.this.zzbpo.onAdLoaded();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", e);
                    }
                }
            });
        } else {
            try {
                this.zzbpo.onAdLoaded();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        com.google.android.gms.ads.internal.util.client.zzb.zzcw("Adapter called onReceivedAd.");
        if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy("onReceivedAd must be called on the main UI thread.");
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzha.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzha.this.zzbpo.onAdLoaded();
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", e);
                    }
                }
            });
        } else {
            try {
                this.zzbpo.onAdLoaded();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }
}
