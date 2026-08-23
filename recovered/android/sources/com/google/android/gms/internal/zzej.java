package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzej extends zzee.zza {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzbhm;

    public zzej(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzbhm = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzee
    public void zza(zzdy zzdyVar) {
        this.zzbhm.onAppInstallAdLoaded(zzb(zzdyVar));
    }

    zzdz zzb(zzdy zzdyVar) {
        return new zzdz(zzdyVar);
    }
}
