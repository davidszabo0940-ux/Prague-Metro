package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzjh extends com.google.android.gms.ads.internal.reward.client.zza.AbstractBinderC0733zza {
    private final String zzcgd;
    private final int zzchi;

    public zzjh(String str, int i) {
        this.zzcgd = str;
        this.zzchi = i;
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zza
    public int getAmount() {
        return this.zzchi;
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zza
    public String getType() {
        return this.zzcgd;
    }
}
