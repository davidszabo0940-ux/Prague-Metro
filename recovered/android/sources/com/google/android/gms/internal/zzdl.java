package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzdl extends zzdn.zza {
    private final com.google.android.gms.ads.internal.zzh zzbei;

    @Nullable
    private final String zzbej;
    private final String zzbek;

    public zzdl(com.google.android.gms.ads.internal.zzh zzhVar, @Nullable String str, String str2) {
        this.zzbei = zzhVar;
        this.zzbej = str;
        this.zzbek = str2;
    }

    @Override // com.google.android.gms.internal.zzdn
    public String getContent() {
        return this.zzbek;
    }

    @Override // com.google.android.gms.internal.zzdn
    public void recordClick() {
        this.zzbei.zzei();
    }

    @Override // com.google.android.gms.internal.zzdn
    public void recordImpression() {
        this.zzbei.zzej();
    }

    @Override // com.google.android.gms.internal.zzdn
    public void zzi(com.google.android.gms.dynamic.zzd zzdVar) {
        if (zzdVar == null) {
            return;
        }
        this.zzbei.zzc((View) com.google.android.gms.dynamic.zze.zzad(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzdn
    public String zzkk() {
        return this.zzbej;
    }
}
