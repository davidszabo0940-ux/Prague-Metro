package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public class zzph extends com.google.android.gms.common.internal.zzk<zzpk> {
    public zzph(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzgVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 40, zzgVar, connectionCallbacks, onConnectionFailedListener);
    }

    public void zza(zzpj zzpjVar, LogEventParcelable logEventParcelable) throws RemoteException {
        ((zzpk) zzarw()).zza(zzpjVar, logEventParcelable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: zzdk, reason: merged with bridge method [inline-methods] */
    public zzpk zzbb(IBinder iBinder) {
        return zzpk.zza.zzdm(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected String zzra() {
        return "com.google.android.gms.clearcut.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected String zzrb() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}
