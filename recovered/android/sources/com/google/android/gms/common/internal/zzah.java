package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public class zzah<T extends IInterface> extends zzk<T> {

    /* JADX INFO: renamed from: zb */
    private final Api.zzg<T> f268zb;

    public zzah(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zzg zzgVar, Api.zzg<T> zzgVar2) {
        super(context, looper, i, zzgVar, connectionCallbacks, onConnectionFailedListener);
        this.f268zb = zzgVar2;
    }

    public Api.zzg<T> zzatj() {
        return this.f268zb;
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected T zzbb(IBinder iBinder) {
        return (T) this.f268zb.zzbb(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected void zzc(int i, T t) {
        this.f268zb.zza(i, t);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected String zzra() {
        return this.f268zb.zzra();
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected String zzrb() {
        return this.f268zb.zzrb();
    }
}
