package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public final class zzrj {

    /* JADX INFO: renamed from: bN */
    public static final Api.zzf<zzrn> f825bN = new Api.zzf<>();

    /* JADX INFO: renamed from: bO */
    private static final Api.zza<zzrn, Api.ApiOptions.NoOptions> f826bO = new Api.zza<zzrn, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.internal.zzrj.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public zzrn zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzgVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzrn(context, looper, zzgVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Common.API", f826bO, f825bN);

    /* JADX INFO: renamed from: zh */
    public static final zzrk f827zh = new zzrl();
}
