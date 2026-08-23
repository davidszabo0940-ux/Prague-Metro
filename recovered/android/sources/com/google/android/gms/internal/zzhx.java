package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzhx extends zzhs.zza {
    private final InAppPurchaseListener zzawf;

    public zzhx(InAppPurchaseListener inAppPurchaseListener) {
        this.zzawf = inAppPurchaseListener;
    }

    @Override // com.google.android.gms.internal.zzhs
    public void zza(zzhr zzhrVar) {
        this.zzawf.onInAppPurchaseRequested(new zzia(zzhrVar));
    }
}
