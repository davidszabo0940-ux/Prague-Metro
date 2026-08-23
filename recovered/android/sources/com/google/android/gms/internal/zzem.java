package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzem extends zzeh.zza {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzbhp;

    public zzem(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzbhp = onCustomTemplateAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zza(zzec zzecVar) {
        this.zzbhp.onCustomTemplateAdLoaded(new zzed(zzecVar));
    }
}
