package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzb extends zzp.zza {
    private final zza zzati;

    public zzb(zza zzaVar) {
        this.zzati = zzaVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzp
    public void onAdClicked() {
        this.zzati.onAdClicked();
    }
}
