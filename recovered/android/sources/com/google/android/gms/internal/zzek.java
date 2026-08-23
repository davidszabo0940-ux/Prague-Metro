package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzek extends zzef.zza {
    private final NativeContentAd.OnContentAdLoadedListener zzbhn;

    public zzek(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzbhn = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzef
    public void zza(zzea zzeaVar) {
        this.zzbhn.onContentAdLoaded(zzb(zzeaVar));
    }

    zzeb zzb(zzea zzeaVar) {
        return new zzeb(zzeaVar);
    }
}
