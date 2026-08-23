package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzgm;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzag {
    private static final Object zzamp = new Object();
    private static zzag zzawp;
    private zzz zzawq;
    private RewardedVideoAd zzawr;

    private zzag() {
    }

    public static zzag zzjo() {
        zzag zzagVar;
        synchronized (zzamp) {
            if (zzawp == null) {
                zzawp = new zzag();
            }
            zzagVar = zzawp;
        }
        return zzagVar;
    }

    public RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (zzamp) {
            if (this.zzawr != null) {
                rewardedVideoAd = this.zzawr;
            } else {
                this.zzawr = new com.google.android.gms.ads.internal.reward.client.zzi(context, zzm.zzix().zza(context, new zzgm()));
                rewardedVideoAd = this.zzawr;
            }
        }
        return rewardedVideoAd;
    }

    public void setAppMuted(boolean z) {
        com.google.android.gms.common.internal.zzab.zza(this.zzawq != null, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzawq.setAppMuted(z);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to set app mute state.", e);
        }
    }

    public void setAppVolume(float f) {
        com.google.android.gms.common.internal.zzab.zzb(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        com.google.android.gms.common.internal.zzab.zza(this.zzawq != null, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzawq.setAppVolume(f);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to set app volume.", e);
        }
    }

    public void zza(Context context, String str, zzah zzahVar) {
        synchronized (zzamp) {
            if (this.zzawq != null) {
                return;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            try {
                this.zzawq = zzm.zzix().zzl(context);
                this.zzawq.initialize();
                if (str != null) {
                    this.zzawq.zzu(str);
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to initialize or set applicationCode on mobile ads setting manager", e);
            }
        }
    }
}
