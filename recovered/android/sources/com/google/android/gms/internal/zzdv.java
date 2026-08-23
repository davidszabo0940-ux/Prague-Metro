package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzdv extends NativeAd.Image {
    private final Drawable mDrawable;
    private final Uri mUri;
    private final double zzbfj;
    private final zzdu zzbhf;

    public zzdv(zzdu zzduVar) {
        Drawable drawable;
        Uri uri = null;
        this.zzbhf = zzduVar;
        try {
            com.google.android.gms.dynamic.zzd zzdVarZzkv = this.zzbhf.zzkv();
            drawable = zzdVarZzkv != null ? (Drawable) com.google.android.gms.dynamic.zze.zzad(zzdVarZzkv) : null;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get drawable.", e);
        }
        this.mDrawable = drawable;
        try {
            uri = this.zzbhf.getUri();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get uri.", e2);
        }
        this.mUri = uri;
        double scale = 1.0d;
        try {
            scale = this.zzbhf.getScale();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get scale.", e3);
        }
        this.zzbfj = scale;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public double getScale() {
        return this.zzbfj;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public Uri getUri() {
        return this.mUri;
    }
}
