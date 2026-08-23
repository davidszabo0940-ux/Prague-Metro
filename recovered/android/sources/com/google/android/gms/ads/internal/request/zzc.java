package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzle;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzc {

    public interface zza {
        void zzb(AdResponseParcel adResponseParcel);
    }

    interface zzb {
        boolean zza(VersionInfoParcel versionInfoParcel);
    }

    public static zzkn zza(final Context context, VersionInfoParcel versionInfoParcel, zzle<AdRequestInfoParcel> zzleVar, zza zzaVar) {
        return zza(context, versionInfoParcel, zzleVar, zzaVar, new zzb() { // from class: com.google.android.gms.ads.internal.request.zzc.1
            @Override // com.google.android.gms.ads.internal.request.zzc.zzb
            public boolean zza(VersionInfoParcel versionInfoParcel2) {
                return versionInfoParcel2.zzcnq || (com.google.android.gms.common.util.zzi.zzcl(context) && !zzdc.zzayx.get().booleanValue());
            }
        });
    }

    static zzkn zza(Context context, VersionInfoParcel versionInfoParcel, zzle<AdRequestInfoParcel> zzleVar, zza zzaVar, zzb zzbVar) {
        return zzbVar.zza(versionInfoParcel) ? zza(context, zzleVar, zzaVar) : zzb(context, versionInfoParcel, zzleVar, zzaVar);
    }

    private static zzkn zza(Context context, zzle<AdRequestInfoParcel> zzleVar, zza zzaVar) {
        zzkh.zzcw("Fetching ad response from local ad request service.");
        zzd.zza zzaVar2 = new zzd.zza(context, zzleVar, zzaVar);
        return zzaVar2;
    }

    private static zzkn zzb(Context context, VersionInfoParcel versionInfoParcel, zzle<AdRequestInfoParcel> zzleVar, zza zzaVar) {
        zzkh.zzcw("Fetching ad response from remote ad request service.");
        if (com.google.android.gms.ads.internal.client.zzm.zziw().zzar(context)) {
            return new zzd.zzb(context, versionInfoParcel, zzleVar, zzaVar);
        }
        zzkh.zzcy("Failed to connect to remote ad request service.");
        return null;
    }
}
