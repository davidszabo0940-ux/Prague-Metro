package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes.dex */
public class zzqi<O extends Api.ApiOptions> extends zzpz {

    /* JADX INFO: renamed from: uP */
    private final com.google.android.gms.common.api.zzc<O> f752uP;

    public zzqi(com.google.android.gms.common.api.zzc<O> zzcVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f752uP = zzcVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Looper getLooper() {
        return this.f752uP.getLooper();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zza(zzrc zzrcVar) {
        this.f752uP.zzanu();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zzb(zzrc zzrcVar) {
        this.f752uP.zzanv();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(@NonNull T t) {
        return (T) this.f752uP.zza(t);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(@NonNull T t) {
        return (T) this.f752uP.zzb(t);
    }
}
