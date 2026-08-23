package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkg;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zza {

    /* JADX INFO: renamed from: com.google.android.gms.ads.internal.request.zza$zza, reason: collision with other inner class name */
    public interface InterfaceC0730zza {
        void zza(zzjy.zza zzaVar);
    }

    public zzkg zza(Context context, AdRequestInfoParcel.zza zzaVar, zzas zzasVar, InterfaceC0730zza interfaceC0730zza) {
        zzkg zznVar = zzaVar.zzcav.extras.getBundle("sdk_less_server_data") != null ? new zzn(context, zzaVar, interfaceC0730zza) : new zzb(context, zzaVar, zzasVar, interfaceC0730zza);
        return zznVar;
    }
}
