package com.google.android.gms.internal;

import android.support.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzgg extends zzgp.zza {
    private final Object zzail = new Object();
    private zzgi.zza zzboe;
    private zzgf zzbof;

    @Override // com.google.android.gms.internal.zzgp
    public void onAdClicked() {
        synchronized (this.zzail) {
            if (this.zzbof != null) {
                this.zzbof.zzea();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgp
    public void onAdClosed() {
        synchronized (this.zzail) {
            if (this.zzbof != null) {
                this.zzbof.zzeb();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgp
    public void onAdFailedToLoad(int i) {
        synchronized (this.zzail) {
            if (this.zzboe != null) {
                this.zzboe.zzy(i == 3 ? 1 : 2);
                this.zzboe = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgp
    public void onAdImpression() {
        synchronized (this.zzail) {
            if (this.zzbof != null) {
                this.zzbof.zzef();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgp
    public void onAdLeftApplication() {
        synchronized (this.zzail) {
            if (this.zzbof != null) {
                this.zzbof.zzec();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgp
    public void onAdLoaded() {
        synchronized (this.zzail) {
            if (this.zzboe != null) {
                this.zzboe.zzy(0);
                this.zzboe = null;
            } else {
                if (this.zzbof != null) {
                    this.zzbof.zzee();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgp
    public void onAdOpened() {
        synchronized (this.zzail) {
            if (this.zzbof != null) {
                this.zzbof.zzed();
            }
        }
    }

    public void zza(@Nullable zzgf zzgfVar) {
        synchronized (this.zzail) {
            this.zzbof = zzgfVar;
        }
    }

    public void zza(zzgi.zza zzaVar) {
        synchronized (this.zzail) {
            this.zzboe = zzaVar;
        }
    }

    @Override // com.google.android.gms.internal.zzgp
    public void zza(zzgq zzgqVar) {
        synchronized (this.zzail) {
            if (this.zzboe != null) {
                this.zzboe.zza(0, zzgqVar);
                this.zzboe = null;
            } else {
                if (this.zzbof != null) {
                    this.zzbof.zzee();
                }
            }
        }
    }
}
