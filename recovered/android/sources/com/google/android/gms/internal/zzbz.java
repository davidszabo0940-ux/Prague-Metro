package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class zzbz extends com.google.android.gms.dynamic.zzg<zzcb> {
    private static final zzbz zzaiu = new zzbz();

    private zzbz() {
        super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
    }

    public static zzca zzb(String str, Context context, boolean z) {
        zzca zzcaVarZzc;
        return (com.google.android.gms.common.zzc.zzand().isGooglePlayServicesAvailable(context) != 0 || (zzcaVarZzc = zzaiu.zzc(str, context, z)) == null) ? new zzby(str, context, z) : zzcaVarZzc;
    }

    private zzca zzc(String str, Context context, boolean z) {
        com.google.android.gms.dynamic.zzd zzdVarZzae = com.google.android.gms.dynamic.zze.zzae(context);
        try {
            return zzca.zza.zzd(z ? zzcr(context).zza(str, zzdVarZzae) : zzcr(context).zzb(str, zzdVarZzae));
        } catch (RemoteException | com.google.android.gms.dynamic.zzg.zza e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public zzcb zzc(IBinder iBinder) {
        return zzcb.zza.zze(iBinder);
    }
}
