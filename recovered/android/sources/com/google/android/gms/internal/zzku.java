package com.google.android.gms.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzku extends zzkg {
    private final String zzae;
    private final com.google.android.gms.ads.internal.util.client.zzc zzcmv;

    public zzku(Context context, String str, String str2) {
        this(str2, com.google.android.gms.ads.internal.zzu.zzfq().zzh(context, str));
    }

    public zzku(String str, String str2) {
        this.zzcmv = new com.google.android.gms.ads.internal.util.client.zzc(str2);
        this.zzae = str;
    }

    @Override // com.google.android.gms.internal.zzkg
    public void onStop() {
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zzew() {
        this.zzcmv.zzcs(this.zzae);
    }
}
