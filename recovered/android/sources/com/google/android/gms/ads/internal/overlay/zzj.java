package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzll;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzj {
    @Nullable
    public abstract zzi zza(Context context, zzll zzllVar, int i, boolean z, zzdk zzdkVar, zzdi zzdiVar);

    protected boolean zzh(zzll zzllVar) {
        return zzllVar.zzdo().zzauq;
    }

    protected boolean zzq(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return com.google.android.gms.common.util.zzs.zzavm() && (applicationInfo == null || applicationInfo.targetSdkVersion >= 11);
    }
}
