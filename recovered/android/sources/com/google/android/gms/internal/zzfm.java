package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzfm {
    private final List<zza> zzala = new LinkedList();

    interface zza {
        void zzb(zzfn zzfnVar) throws RemoteException;
    }

    zzfm() {
    }

    void zza(final zzfn zzfnVar) {
        Handler handler = zzkl.zzclg;
        for (final zza zzaVar : this.zzala) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.zzfm.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        zzaVar.zzb(zzfnVar);
                    } catch (RemoteException e) {
                        zzkh.zzd("Could not propagate interstitial ad event.", e);
                    }
                }
            });
        }
    }

    void zzc(com.google.android.gms.ads.internal.zzl zzlVar) {
        zzlVar.zza(new com.google.android.gms.ads.internal.client.zzq.zza() { // from class: com.google.android.gms.internal.zzfm.1
            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdClosed() throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.1.1
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzald != null) {
                            zzfnVar.zzald.onAdClosed();
                        }
                        com.google.android.gms.ads.internal.zzu.zzgb().zzlq();
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdFailedToLoad(final int i) throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.1.2
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzald != null) {
                            zzfnVar.zzald.onAdFailedToLoad(i);
                        }
                    }
                });
                zzkh.m95v("Pooled interstitial failed to load.");
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdLeftApplication() throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.1.3
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzald != null) {
                            zzfnVar.zzald.onAdLeftApplication();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdLoaded() throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.1.4
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzald != null) {
                            zzfnVar.zzald.onAdLoaded();
                        }
                    }
                });
                zzkh.m95v("Pooled interstitial loaded.");
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public void onAdOpened() throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.1.5
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzald != null) {
                            zzfnVar.zzald.onAdOpened();
                        }
                    }
                });
            }
        });
        zzlVar.zza(new com.google.android.gms.ads.internal.client.zzw.zza() { // from class: com.google.android.gms.internal.zzfm.2
            @Override // com.google.android.gms.ads.internal.client.zzw
            public void onAppEvent(final String str, final String str2) throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.2.1
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzbkl != null) {
                            zzfnVar.zzbkl.onAppEvent(str, str2);
                        }
                    }
                });
            }
        });
        zzlVar.zza(new zzhs.zza() { // from class: com.google.android.gms.internal.zzfm.3
            @Override // com.google.android.gms.internal.zzhs
            public void zza(final zzhr zzhrVar) throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.3.1
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzbkm != null) {
                            zzfnVar.zzbkm.zza(zzhrVar);
                        }
                    }
                });
            }
        });
        zzlVar.zza(new zzdo.zza() { // from class: com.google.android.gms.internal.zzfm.4
            @Override // com.google.android.gms.internal.zzdo
            public void zza(final zzdn zzdnVar) throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.4.1
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzbkn != null) {
                            zzfnVar.zzbkn.zza(zzdnVar);
                        }
                    }
                });
            }
        });
        zzlVar.zza(new com.google.android.gms.ads.internal.client.zzp.zza() { // from class: com.google.android.gms.internal.zzfm.5
            @Override // com.google.android.gms.ads.internal.client.zzp
            public void onAdClicked() throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.5.1
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzbko != null) {
                            zzfnVar.zzbko.onAdClicked();
                        }
                    }
                });
            }
        });
        zzlVar.zza(new com.google.android.gms.ads.internal.reward.client.zzd.zza() { // from class: com.google.android.gms.internal.zzfm.6
            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdClosed() throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.6.4
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzbkp != null) {
                            zzfnVar.zzbkp.onRewardedVideoAdClosed();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdFailedToLoad(final int i) throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.6.7
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzbkp != null) {
                            zzfnVar.zzbkp.onRewardedVideoAdFailedToLoad(i);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdLeftApplication() throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.6.6
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzbkp != null) {
                            zzfnVar.zzbkp.onRewardedVideoAdLeftApplication();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdLoaded() throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.6.1
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzbkp != null) {
                            zzfnVar.zzbkp.onRewardedVideoAdLoaded();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoAdOpened() throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.6.2
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzbkp != null) {
                            zzfnVar.zzbkp.onRewardedVideoAdOpened();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void onRewardedVideoStarted() throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.6.3
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzbkp != null) {
                            zzfnVar.zzbkp.onRewardedVideoStarted();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzd
            public void zza(final com.google.android.gms.ads.internal.reward.client.zza zzaVar) throws RemoteException {
                zzfm.this.zzala.add(new zza() { // from class: com.google.android.gms.internal.zzfm.6.5
                    @Override // com.google.android.gms.internal.zzfm.zza
                    public void zzb(zzfn zzfnVar) throws RemoteException {
                        if (zzfnVar.zzbkp != null) {
                            zzfnVar.zzbkp.zza(zzaVar);
                        }
                    }
                });
            }
        });
    }
}
