package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzc extends zzq.zza {
    private final AdListener zzatj;

    public zzc(AdListener adListener) {
        this.zzatj = adListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void onAdClosed() {
        this.zzatj.onAdClosed();
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void onAdFailedToLoad(int i) {
        this.zzatj.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void onAdLeftApplication() {
        this.zzatj.onAdLeftApplication();
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void onAdLoaded() {
        this.zzatj.onAdLoaded();
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void onAdOpened() {
        this.zzatj.onAdOpened();
    }
}
