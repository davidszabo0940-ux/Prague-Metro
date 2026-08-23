package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzei extends com.google.android.gms.dynamic.zzg<zzdx> {
    public zzei() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzai, reason: merged with bridge method [inline-methods] */
    public zzdx zzc(IBinder iBinder) {
        return zzdx.zza.zzaa(iBinder);
    }

    public zzdw zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            return zzdw.zza.zzz(zzcr(context).zza(com.google.android.gms.dynamic.zze.zzae(context), com.google.android.gms.dynamic.zze.zzae(frameLayout), com.google.android.gms.dynamic.zze.zzae(frameLayout2), 9256000));
        } catch (RemoteException | com.google.android.gms.dynamic.zzg.zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }
}
