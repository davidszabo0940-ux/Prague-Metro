package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public final class zzvw {

    /* JADX INFO: renamed from: bN */
    public static final Api.zzf<com.google.android.gms.signin.internal.zzg> f856bN = new Api.zzf<>();
    public static final Api.zzf<com.google.android.gms.signin.internal.zzg> auj = new Api.zzf<>();

    /* JADX INFO: renamed from: bO */
    public static final Api.zza<com.google.android.gms.signin.internal.zzg, zzvy> f857bO = new Api.zza<com.google.android.gms.signin.internal.zzg, zzvy>() { // from class: com.google.android.gms.internal.zzvw.1
        @Override // com.google.android.gms.common.api.Api.zza
        public com.google.android.gms.signin.internal.zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzgVar, zzvy zzvyVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new com.google.android.gms.signin.internal.zzg(context, looper, true, zzgVar, zzvyVar == null ? zzvy.aul : zzvyVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    static final Api.zza<com.google.android.gms.signin.internal.zzg, zza> auk = new Api.zza<com.google.android.gms.signin.internal.zzg, zza>() { // from class: com.google.android.gms.internal.zzvw.2
        @Override // com.google.android.gms.common.api.Api.zza
        public com.google.android.gms.signin.internal.zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzgVar, zza zzaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new com.google.android.gms.signin.internal.zzg(context, looper, false, zzgVar, zzaVar.zzbzj(), connectionCallbacks, onConnectionFailedListener);
        }
    };

    /* JADX INFO: renamed from: dP */
    public static final Scope f858dP = new Scope(Scopes.PROFILE);

    /* JADX INFO: renamed from: dQ */
    public static final Scope f859dQ = new Scope("email");
    public static final Api<zzvy> API = new Api<>("SignIn.API", f857bO, f856bN);

    /* JADX INFO: renamed from: EX */
    public static final Api<zza> f855EX = new Api<>("SignIn.INTERNAL_API", auk, auj);

    public static class zza implements Api.ApiOptions.HasOptions {
        public Bundle zzbzj() {
            return null;
        }
    }
}
