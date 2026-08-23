package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzir;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzg extends zzl.zza {
    private final WeakReference<zzc.zza> zzcca;

    public zzg(zzc.zza zzaVar) {
        this.zzcca = new WeakReference<>(zzaVar);
    }

    @Override // com.google.android.gms.ads.internal.request.zzl
    public void zzb(AdResponseParcel adResponseParcel) {
        zzc.zza zzaVar = this.zzcca.get();
        if (zzaVar != null) {
            zzaVar.zzb(adResponseParcel);
        }
    }
}
