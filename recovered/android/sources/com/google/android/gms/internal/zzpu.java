package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public class zzpu implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: pD */
    public final Api<?> f604pD;

    /* JADX INFO: renamed from: sV */
    private final int f605sV;

    /* JADX INFO: renamed from: sW */
    private zzqf f606sW;

    public zzpu(Api<?> api, int i) {
        this.f604pD = api;
        this.f605sV = i;
    }

    private void zzaox() {
        com.google.android.gms.common.internal.zzab.zzb(this.f606sW, "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(@Nullable Bundle bundle) {
        zzaox();
        this.f606sW.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzaox();
        this.f606sW.zza(connectionResult, this.f604pD, this.f605sV);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        zzaox();
        this.f606sW.onConnectionSuspended(i);
    }

    public void zza(zzqf zzqfVar) {
        this.f606sW = zzqfVar;
    }
}
