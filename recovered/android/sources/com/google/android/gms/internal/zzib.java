package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzib extends zzhw.zza {
    private final PlayStorePurchaseListener zzawh;

    public zzib(PlayStorePurchaseListener playStorePurchaseListener) {
        this.zzawh = playStorePurchaseListener;
    }

    @Override // com.google.android.gms.internal.zzhw
    public boolean isValidPurchase(String str) {
        return this.zzawh.isValidPurchase(str);
    }

    @Override // com.google.android.gms.internal.zzhw
    public void zza(zzhv zzhvVar) {
        this.zzawh.onInAppPurchaseFinished(new zzhz(zzhvVar));
    }
}
