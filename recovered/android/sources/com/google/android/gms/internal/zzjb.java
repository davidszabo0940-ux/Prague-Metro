package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzjb {
    public abstract void zza(Context context, zziv zzivVar, VersionInfoParcel versionInfoParcel);

    protected void zze(zziv zzivVar) {
        zzivVar.zzrj();
        if (zzivVar.zzrh() != null) {
            zzivVar.zzrh().release();
        }
    }
}
