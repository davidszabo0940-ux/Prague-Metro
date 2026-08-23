package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public final class zzbw {
    private final zzca zzaip;

    public zzbw(String str, Context context, boolean z) {
        this.zzaip = zzbz.zzb(str, context, z);
    }

    public void zza(MotionEvent motionEvent) throws RemoteException {
        this.zzaip.zzd(com.google.android.gms.dynamic.zze.zzae(motionEvent));
    }

    public Uri zzc(Uri uri, Context context) throws zzbx, RemoteException {
        com.google.android.gms.dynamic.zzd zzdVarZza = this.zzaip.zza(com.google.android.gms.dynamic.zze.zzae(uri), com.google.android.gms.dynamic.zze.zzae(context));
        if (zzdVarZza == null) {
            throw new zzbx();
        }
        return (Uri) com.google.android.gms.dynamic.zze.zzad(zzdVarZza);
    }

    public Uri zzd(Uri uri, Context context) throws zzbx, RemoteException {
        com.google.android.gms.dynamic.zzd zzdVarZzb = this.zzaip.zzb(com.google.android.gms.dynamic.zze.zzae(uri), com.google.android.gms.dynamic.zze.zzae(context));
        if (zzdVarZzb == null) {
            throw new zzbx();
        }
        return (Uri) com.google.android.gms.dynamic.zze.zzad(zzdVarZzb);
    }
}
