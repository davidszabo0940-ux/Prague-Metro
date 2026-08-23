package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzln {
    public zzll zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzas zzasVar, VersionInfoParcel versionInfoParcel) {
        return zza(context, adSizeParcel, z, z2, zzasVar, versionInfoParcel, null, null, null);
    }

    public zzll zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzas zzasVar, VersionInfoParcel versionInfoParcel, zzdk zzdkVar, com.google.android.gms.ads.internal.zzs zzsVar, com.google.android.gms.ads.internal.zzd zzdVar) {
        zzlo zzloVar = new zzlo(zzlp.zzb(context, adSizeParcel, z, z2, zzasVar, versionInfoParcel, zzdkVar, zzsVar, zzdVar));
        zzloVar.setWebViewClient(com.google.android.gms.ads.internal.zzu.zzfs().zzb(zzloVar, z2));
        zzloVar.setWebChromeClient(com.google.android.gms.ads.internal.zzu.zzfs().zzl(zzloVar));
        return zzloVar;
    }
}
