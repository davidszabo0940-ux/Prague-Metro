package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzhy extends com.google.android.gms.dynamic.zzg<zzhu> {
    public zzhy() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzaz, reason: merged with bridge method [inline-methods] */
    public zzhu zzc(IBinder iBinder) {
        return zzhu.zza.zzaw(iBinder);
    }

    public zzht zzg(Activity activity) {
        try {
            return zzht.zza.zzav(zzcr(activity).zzo(com.google.android.gms.dynamic.zze.zzae(activity)));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (com.google.android.gms.dynamic.zzg.zza e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }
}
