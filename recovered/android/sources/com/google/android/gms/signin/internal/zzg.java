package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zzvx;
import com.google.android.gms.internal.zzvy;

/* JADX INFO: loaded from: classes.dex */
public class zzg extends zzk<zze> implements zzvx {
    private final boolean auv;
    private final Bundle auw;

    /* JADX INFO: renamed from: tD */
    private final com.google.android.gms.common.internal.zzg f870tD;

    /* JADX INFO: renamed from: yb */
    private Integer f871yb;

    public zzg(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzg zzgVar, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, zzgVar, connectionCallbacks, onConnectionFailedListener);
        this.auv = z;
        this.f870tD = zzgVar;
        this.auw = bundle;
        this.f871yb = zzgVar.zzasm();
    }

    public zzg(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzg zzgVar, zzvy zzvyVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, zzgVar, zza(zzgVar), connectionCallbacks, onConnectionFailedListener);
    }

    public static Bundle zza(com.google.android.gms.common.internal.zzg zzgVar) {
        zzvy zzvyVarZzasl = zzgVar.zzasl();
        Integer numZzasm = zzgVar.zzasm();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", zzgVar.getAccount());
        if (numZzasm != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numZzasm.intValue());
        }
        if (zzvyVarZzasl != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzvyVarZzasl.zzbzl());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzvyVarZzasl.zzafr());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzvyVarZzasl.zzafu());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzvyVarZzasl.zzaft());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzvyVarZzasl.zzafv());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzvyVarZzasl.zzbzm());
            if (zzvyVarZzasl.zzbzn() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", zzvyVarZzasl.zzbzn().longValue());
            }
            if (zzvyVarZzasl.zzbzo() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", zzvyVarZzasl.zzbzo().longValue());
            }
        }
        return bundle;
    }

    private ResolveAccountRequest zzbzt() {
        Account accountZzaru = this.f870tD.zzaru();
        return new ResolveAccountRequest(accountZzaru, this.f871yb.intValue(), "<<default account>>".equals(accountZzaru.name) ? com.google.android.gms.auth.api.signin.internal.zzk.zzbc(getContext()).zzagj() : null);
    }

    @Override // com.google.android.gms.internal.zzvx
    public void connect() {
        zza(new com.google.android.gms.common.internal.zzd.zzi());
    }

    @Override // com.google.android.gms.internal.zzvx
    public void zza(zzq zzqVar, boolean z) {
        try {
            ((zze) zzarw()).zza(zzqVar, this.f871yb.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.internal.zzvx
    public void zza(zzd zzdVar) {
        zzab.zzb(zzdVar, "Expecting a valid ISignInCallbacks");
        try {
            ((zze) zzarw()).zza(new SignInRequest(zzbzt()), zzdVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zzdVar.zzb(new SignInResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected Bundle zzaeu() {
        if (!getContext().getPackageName().equals(this.f870tD.zzasi())) {
            this.auw.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f870tD.zzasi());
        }
        return this.auw;
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.api.Api.zze
    public boolean zzafk() {
        return this.auv;
    }

    @Override // com.google.android.gms.internal.zzvx
    public void zzbzk() {
        try {
            ((zze) zzarw()).zzxs(this.f871yb.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: zzkj, reason: merged with bridge method [inline-methods] */
    public zze zzbb(IBinder iBinder) {
        return zze.zza.zzki(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected String zzra() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected String zzrb() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }
}
