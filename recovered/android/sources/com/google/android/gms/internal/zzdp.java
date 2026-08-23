package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzdp extends zzdo.zza {
    private final OnCustomRenderedAdLoadedListener zzawg;

    public zzdp(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzawg = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzdo
    public void zza(zzdn zzdnVar) {
        this.zzawg.onCustomRenderedAdLoaded(new zzdm(zzdnVar));
    }
}
