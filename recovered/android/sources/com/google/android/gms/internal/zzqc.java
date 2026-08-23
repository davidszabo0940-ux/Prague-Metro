package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class zzqc implements zzqe {

    /* JADX INFO: renamed from: tm */
    private final zzqf f668tm;

    public zzqc(zzqf zzqfVar) {
        this.f668tm = zzqfVar;
    }

    @Override // com.google.android.gms.internal.zzqe
    public void begin() {
        this.f668tm.zzapy();
        this.f668tm.f704sX.f683tZ = Collections.emptySet();
    }

    @Override // com.google.android.gms.internal.zzqe
    public void connect() {
        this.f668tm.zzapw();
    }

    @Override // com.google.android.gms.internal.zzqe
    public boolean disconnect() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzqe
    public void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.zzqe
    public void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.internal.zzqe
    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    @Override // com.google.android.gms.internal.zzqe
    public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(T t) {
        this.f668tm.f704sX.f676tS.add(t);
        return t;
    }

    @Override // com.google.android.gms.internal.zzqe
    public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
