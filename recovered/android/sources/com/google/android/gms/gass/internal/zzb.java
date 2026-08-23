package com.google.android.gms.gass.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class zzb extends com.google.android.gms.common.internal.zzd<zze> {
    public zzb(Context context, Looper looper, com.google.android.gms.common.internal.zzd.zzb zzbVar, com.google.android.gms.common.internal.zzd.zzc zzcVar) {
        super(context, looper, 116, zzbVar, zzcVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: zzgk, reason: merged with bridge method [inline-methods] */
    public zze zzbb(IBinder iBinder) {
        return zze.zza.zzgl(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected String zzra() {
        return "com.google.android.gms.gass.START";
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected String zzrb() {
        return "com.google.android.gms.gass.internal.IGassService";
    }
}
