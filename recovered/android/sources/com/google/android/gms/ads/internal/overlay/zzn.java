package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzll;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzn extends zzj {
    @Override // com.google.android.gms.ads.internal.overlay.zzj
    @Nullable
    public zzi zza(Context context, zzll zzllVar, int i, boolean z, zzdk zzdkVar, zzdi zzdiVar) {
        if (zzq(context)) {
            return new zzc(context, z, zzh(zzllVar), new zzx(context, zzllVar.zzun(), zzllVar.getRequestId(), zzdkVar, zzdiVar));
        }
        return null;
    }
}
