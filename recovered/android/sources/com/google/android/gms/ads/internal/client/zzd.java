package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzd extends com.google.android.gms.dynamic.zzg<zzt> {
    public zzd() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public zzs zza(Context context, String str, zzgn zzgnVar) {
        try {
            return zzs.zza.zzl(zzcr(context).zza(com.google.android.gms.dynamic.zze.zzae(context), str, zzgnVar, 9256000));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (com.google.android.gms.dynamic.zzg.zza e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public zzt zzc(IBinder iBinder) {
        return zzt.zza.zzm(iBinder);
    }
}
