package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzk<T extends IInterface> extends zzd<T> implements Api.zze, zzl.zza {

    /* JADX INFO: renamed from: aP */
    private final Account f340aP;

    /* JADX INFO: renamed from: dY */
    private final Set<Scope> f341dY;

    /* JADX INFO: renamed from: tD */
    private final zzg f342tD;

    protected zzk(Context context, Looper looper, int i, zzg zzgVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzm.zzce(context), GoogleApiAvailability.getInstance(), i, zzgVar, (GoogleApiClient.ConnectionCallbacks) zzab.zzaa(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) zzab.zzaa(onConnectionFailedListener));
    }

    protected zzk(Context context, Looper looper, zzm zzmVar, GoogleApiAvailability googleApiAvailability, int i, zzg zzgVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, zzmVar, googleApiAvailability, i, zza(connectionCallbacks), zza(onConnectionFailedListener), zzgVar.zzasj());
        this.f342tD = zzgVar;
        this.f340aP = zzgVar.getAccount();
        this.f341dY = zzb(zzgVar.zzasg());
    }

    @Nullable
    private static zzd.zzb zza(final GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        if (connectionCallbacks == null) {
            return null;
        }
        return new zzd.zzb() { // from class: com.google.android.gms.common.internal.zzk.1
            @Override // com.google.android.gms.common.internal.zzd.zzb
            public void onConnected(@Nullable Bundle bundle) {
                connectionCallbacks.onConnected(bundle);
            }

            @Override // com.google.android.gms.common.internal.zzd.zzb
            public void onConnectionSuspended(int i) {
                connectionCallbacks.onConnectionSuspended(i);
            }
        };
    }

    @Nullable
    private static zzd.zzc zza(final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (onConnectionFailedListener == null) {
            return null;
        }
        return new zzd.zzc() { // from class: com.google.android.gms.common.internal.zzk.2
            @Override // com.google.android.gms.common.internal.zzd.zzc
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        };
    }

    private Set<Scope> zzb(@NonNull Set<Scope> set) {
        Set<Scope> setZzc = zzc(set);
        Iterator<Scope> it = setZzc.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return setZzc;
    }

    @Override // com.google.android.gms.common.internal.zzd
    public final Account getAccount() {
        return this.f340aP;
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected final Set<Scope> zzary() {
        return this.f341dY;
    }

    protected final zzg zzasr() {
        return this.f342tD;
    }

    @NonNull
    protected Set<Scope> zzc(@NonNull Set<Scope> set) {
        return set;
    }
}
