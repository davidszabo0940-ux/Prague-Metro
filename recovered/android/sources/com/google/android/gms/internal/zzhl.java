package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzhl extends com.google.android.gms.dynamic.zzg<zzhn> {
    public zzhl() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzap, reason: merged with bridge method [inline-methods] */
    public zzhn zzc(IBinder iBinder) {
        return zzhn.zza.zzar(iBinder);
    }

    public zzhm zzf(Activity activity) {
        try {
            return zzhm.zza.zzaq(zzcr(activity).zzn(com.google.android.gms.dynamic.zze.zzae(activity)));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote AdOverlay.", e);
            return null;
        } catch (com.google.android.gms.dynamic.zzg.zza e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote AdOverlay.", e2);
            return null;
        }
    }
}
