package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzjn extends com.google.android.gms.ads.internal.reward.mediation.client.zza.AbstractBinderC0738zza {
    private zzjo zzchr;
    private zzjl zzchy;
    private zzjm zzchz;

    public zzjn(zzjm zzjmVar) {
        this.zzchz = zzjmVar;
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, RewardItemParcel rewardItemParcel) {
        if (this.zzchz != null) {
            this.zzchz.zzc(rewardItemParcel);
        }
    }

    public void zza(zzjl zzjlVar) {
        this.zzchy = zzjlVar;
    }

    public void zza(zzjo zzjoVar) {
        this.zzchr = zzjoVar;
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzb(com.google.android.gms.dynamic.zzd zzdVar, int i) {
        if (this.zzchy != null) {
            this.zzchy.zzaw(i);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzc(com.google.android.gms.dynamic.zzd zzdVar, int i) {
        if (this.zzchr != null) {
            this.zzchr.zza(com.google.android.gms.dynamic.zze.zzad(zzdVar).getClass().getName(), i);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzp(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzchy != null) {
            this.zzchy.zzrt();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzq(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzchr != null) {
            this.zzchr.zzch(com.google.android.gms.dynamic.zze.zzad(zzdVar).getClass().getName());
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzr(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzchz != null) {
            this.zzchz.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzs(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzchz != null) {
            this.zzchz.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzt(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzchz != null) {
            this.zzchz.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzu(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzchz != null) {
            this.zzchz.zzrs();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzv(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzchz != null) {
            this.zzchz.onRewardedVideoAdLeftApplication();
        }
    }
}
