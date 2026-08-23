package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzji extends com.google.android.gms.ads.internal.reward.client.zzb.zza {
    private final Context mContext;
    private final Object zzail = new Object();
    private final VersionInfoParcel zzalm;
    private final zzjj zzchj;

    public zzji(Context context, com.google.android.gms.ads.internal.zzd zzdVar, zzgn zzgnVar, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzalm = versionInfoParcel;
        this.zzchj = new zzjj(context, zzdVar, AdSizeParcel.zzii(), zzgnVar, versionInfoParcel);
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void destroy() {
        zzh(null);
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public boolean isLoaded() {
        boolean zIsLoaded;
        synchronized (this.zzail) {
            zIsLoaded = this.zzchj.isLoaded();
        }
        return zIsLoaded;
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void pause() {
        zzf(null);
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void resume() {
        zzg(null);
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void setUserId(String str) {
        zzkh.zzcy("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void show() {
        synchronized (this.zzail) {
            this.zzchj.zzrr();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        synchronized (this.zzail) {
            this.zzchj.zza(rewardedVideoAdRequestParcel);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzdVar) {
        synchronized (this.zzail) {
            this.zzchj.zza(zzdVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void zzf(com.google.android.gms.dynamic.zzd zzdVar) {
        synchronized (this.zzail) {
            this.zzchj.pause();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void zzg(com.google.android.gms.dynamic.zzd zzdVar) {
        Context context;
        synchronized (this.zzail) {
            if (zzdVar == null) {
                context = null;
            } else {
                try {
                    context = (Context) com.google.android.gms.dynamic.zze.zzad(zzdVar);
                } catch (Exception e) {
                    zzkh.zzd("Unable to extract updated context.", e);
                }
            }
            if (context != null) {
                this.zzchj.onContextChanged(context);
            }
            this.zzchj.resume();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void zzh(com.google.android.gms.dynamic.zzd zzdVar) {
        synchronized (this.zzail) {
            this.zzchj.destroy();
        }
    }
}
