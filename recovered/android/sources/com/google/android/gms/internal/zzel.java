package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzel extends zzeg.zza {
    private final NativeCustomTemplateAd.OnCustomClickListener zzbho;

    public zzel(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzbho = onCustomClickListener;
    }

    @Override // com.google.android.gms.internal.zzeg
    public void zza(zzec zzecVar, String str) {
        this.zzbho.onCustomClick(new zzed(zzecVar), str);
    }
}
