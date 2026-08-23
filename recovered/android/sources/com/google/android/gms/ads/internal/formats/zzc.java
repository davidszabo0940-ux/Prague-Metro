package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzc extends zzdu.zza {
    private final Uri mUri;
    private final Drawable zzbfi;
    private final double zzbfj;

    public zzc(Drawable drawable, Uri uri, double d) {
        this.zzbfi = drawable;
        this.mUri = uri;
        this.zzbfj = d;
    }

    @Override // com.google.android.gms.internal.zzdu
    public double getScale() {
        return this.zzbfj;
    }

    @Override // com.google.android.gms.internal.zzdu
    public Uri getUri() throws RemoteException {
        return this.mUri;
    }

    @Override // com.google.android.gms.internal.zzdu
    public com.google.android.gms.dynamic.zzd zzkv() throws RemoteException {
        return com.google.android.gms.dynamic.zze.zzae(this.zzbfi);
    }
}
