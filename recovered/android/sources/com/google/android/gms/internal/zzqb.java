package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public class zzqb implements zzqe {
    private final Context mContext;

    /* JADX INFO: renamed from: rY */
    private final Api.zza<? extends zzvx, zzvy> f630rY;

    /* JADX INFO: renamed from: tA */
    private com.google.android.gms.common.internal.zzq f631tA;

    /* JADX INFO: renamed from: tB */
    private boolean f632tB;

    /* JADX INFO: renamed from: tC */
    private boolean f633tC;

    /* JADX INFO: renamed from: tD */
    private final com.google.android.gms.common.internal.zzg f634tD;

    /* JADX INFO: renamed from: tE */
    private final Map<Api<?>, Integer> f635tE;

    /* JADX INFO: renamed from: th */
    private final Lock f637th;

    /* JADX INFO: renamed from: tm */
    private final zzqf f638tm;

    /* JADX INFO: renamed from: tp */
    private final com.google.android.gms.common.zzc f639tp;

    /* JADX INFO: renamed from: tq */
    private ConnectionResult f640tq;

    /* JADX INFO: renamed from: tr */
    private int f641tr;

    /* JADX INFO: renamed from: tt */
    private int f643tt;

    /* JADX INFO: renamed from: tw */
    private zzvx f646tw;

    /* JADX INFO: renamed from: tx */
    private int f647tx;

    /* JADX INFO: renamed from: ty */
    private boolean f648ty;

    /* JADX INFO: renamed from: tz */
    private boolean f649tz;

    /* JADX INFO: renamed from: ts */
    private int f642ts = 0;

    /* JADX INFO: renamed from: tu */
    private final Bundle f644tu = new Bundle();

    /* JADX INFO: renamed from: tv */
    private final Set<Api.zzc> f645tv = new HashSet();

    /* JADX INFO: renamed from: tF */
    private ArrayList<Future<?>> f636tF = new ArrayList<>();

    private static class zza implements com.google.android.gms.common.internal.zzd.zzf {

        /* JADX INFO: renamed from: pD */
        private final Api<?> f651pD;

        /* JADX INFO: renamed from: sV */
        private final int f652sV;

        /* JADX INFO: renamed from: tH */
        private final WeakReference<zzqb> f653tH;

        public zza(zzqb zzqbVar, Api<?> api, int i) {
            this.f653tH = new WeakReference<>(zzqbVar);
            this.f651pD = api;
            this.f652sV = i;
        }

        @Override // com.google.android.gms.common.internal.zzd.zzf
        public void zzh(@NonNull ConnectionResult connectionResult) {
            zzqb zzqbVar = this.f653tH.get();
            if (zzqbVar == null) {
                return;
            }
            com.google.android.gms.common.internal.zzab.zza(Looper.myLooper() == zzqbVar.f638tm.f704sX.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zzqbVar.f637th.lock();
            try {
                if (zzqbVar.zzfg(0)) {
                    if (!connectionResult.isSuccess()) {
                        zzqbVar.zzb(connectionResult, this.f651pD, this.f652sV);
                    }
                    if (zzqbVar.zzapj()) {
                        zzqbVar.zzapk();
                    }
                }
            } finally {
                zzqbVar.f637th.unlock();
            }
        }
    }

    private class zzb extends zzf {

        /* JADX INFO: renamed from: tI */
        private final Map<Api.zze, zza> f655tI;

        public zzb(Map<Api.zze, zza> map) {
            super();
            this.f655tI = map;
        }

        @Override // com.google.android.gms.internal.zzqb.zzf
        @WorkerThread
        public void zzapi() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4 = true;
            Iterator<Api.zze> it = this.f655tI.keySet().iterator();
            boolean z5 = true;
            boolean z6 = false;
            while (true) {
                if (!it.hasNext()) {
                    z4 = z6;
                    z = false;
                    break;
                }
                Api.zze next = it.next();
                if (!next.zzanr()) {
                    z2 = false;
                    z3 = z6;
                } else if (this.f655tI.get(next).f652sV == 0) {
                    z = true;
                    break;
                } else {
                    z2 = z5;
                    z3 = true;
                }
                z6 = z3;
                z5 = z2;
            }
            int iIsGooglePlayServicesAvailable = z4 ? zzqb.this.f639tp.isGooglePlayServicesAvailable(zzqb.this.mContext) : 0;
            if (iIsGooglePlayServicesAvailable != 0 && (z || z5)) {
                final ConnectionResult connectionResult = new ConnectionResult(iIsGooglePlayServicesAvailable, null);
                zzqb.this.f638tm.zza(new zzqf.zza(zzqb.this) { // from class: com.google.android.gms.internal.zzqb.zzb.1
                    @Override // com.google.android.gms.internal.zzqf.zza
                    public void zzapi() {
                        zzqb.this.zzg(connectionResult);
                    }
                });
                return;
            }
            if (zzqb.this.f648ty) {
                zzqb.this.f646tw.connect();
            }
            for (Api.zze zzeVar : this.f655tI.keySet()) {
                final zza zzaVar = this.f655tI.get(zzeVar);
                if (!zzeVar.zzanr() || iIsGooglePlayServicesAvailable == 0) {
                    zzeVar.zza(zzaVar);
                } else {
                    zzqb.this.f638tm.zza(new zzqf.zza(zzqb.this) { // from class: com.google.android.gms.internal.zzqb.zzb.2
                        @Override // com.google.android.gms.internal.zzqf.zza
                        public void zzapi() {
                            zzaVar.zzh(new ConnectionResult(16, null));
                        }
                    });
                }
            }
        }
    }

    private class zzc extends zzf {

        /* JADX INFO: renamed from: tM */
        private final ArrayList<Api.zze> f661tM;

        public zzc(ArrayList<Api.zze> arrayList) {
            super();
            this.f661tM = arrayList;
        }

        @Override // com.google.android.gms.internal.zzqb.zzf
        @WorkerThread
        public void zzapi() {
            zzqb.this.f638tm.f704sX.f683tZ = zzqb.this.zzapp();
            Iterator<Api.zze> it = this.f661tM.iterator();
            while (it.hasNext()) {
                it.next().zza(zzqb.this.f631tA, zzqb.this.f638tm.f704sX.f683tZ);
            }
        }
    }

    private static class zzd extends com.google.android.gms.signin.internal.zzb {

        /* JADX INFO: renamed from: tH */
        private final WeakReference<zzqb> f662tH;

        zzd(zzqb zzqbVar) {
            this.f662tH = new WeakReference<>(zzqbVar);
        }

        @Override // com.google.android.gms.signin.internal.zzb, com.google.android.gms.signin.internal.zzd
        @BinderThread
        public void zzb(final SignInResponse signInResponse) {
            final zzqb zzqbVar = this.f662tH.get();
            if (zzqbVar == null) {
                return;
            }
            zzqbVar.f638tm.zza(new zzqf.zza(zzqbVar) { // from class: com.google.android.gms.internal.zzqb.zzd.1
                @Override // com.google.android.gms.internal.zzqf.zza
                public void zzapi() {
                    zzqbVar.zza(signInResponse);
                }
            });
        }
    }

    private class zze implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private zze() {
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnected(Bundle bundle) {
            zzqb.this.f646tw.zza(new zzd(zzqb.this));
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzqb.this.f637th.lock();
            try {
                if (zzqb.this.zzf(connectionResult)) {
                    zzqb.this.zzapn();
                    zzqb.this.zzapk();
                } else {
                    zzqb.this.zzg(connectionResult);
                }
            } finally {
                zzqb.this.f637th.unlock();
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
        }
    }

    private abstract class zzf implements Runnable {
        private zzf() {
        }

        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            zzqb.this.f637th.lock();
            try {
                if (Thread.interrupted()) {
                    return;
                }
                zzapi();
                return;
            } catch (RuntimeException e) {
                zzqb.this.f638tm.zza(e);
                return;
            } finally {
                zzqb.this.f637th.unlock();
            }
            zzqb.this.f637th.unlock();
        }

        @WorkerThread
        protected abstract void zzapi();
    }

    public zzqb(zzqf zzqfVar, com.google.android.gms.common.internal.zzg zzgVar, Map<Api<?>, Integer> map, com.google.android.gms.common.zzc zzcVar, Api.zza<? extends zzvx, zzvy> zzaVar, Lock lock, Context context) {
        this.f638tm = zzqfVar;
        this.f634tD = zzgVar;
        this.f635tE = map;
        this.f639tp = zzcVar;
        this.f630rY = zzaVar;
        this.f637th = lock;
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(SignInResponse signInResponse) {
        if (zzfg(0)) {
            ConnectionResult connectionResultZzatd = signInResponse.zzatd();
            if (!connectionResultZzatd.isSuccess()) {
                if (!zzf(connectionResultZzatd)) {
                    zzg(connectionResultZzatd);
                    return;
                } else {
                    zzapn();
                    zzapk();
                    return;
                }
            }
            ResolveAccountResponse resolveAccountResponseZzbzv = signInResponse.zzbzv();
            ConnectionResult connectionResultZzatd2 = resolveAccountResponseZzbzv.zzatd();
            if (!connectionResultZzatd2.isSuccess()) {
                String strValueOf = String.valueOf(connectionResultZzatd2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(strValueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(strValueOf).toString(), new Exception());
                zzg(connectionResultZzatd2);
            } else {
                this.f649tz = true;
                this.f631tA = resolveAccountResponseZzbzv.zzatc();
                this.f632tB = resolveAccountResponseZzbzv.zzate();
                this.f633tC = resolveAccountResponseZzbzv.zzatf();
                zzapk();
            }
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        if (i2 != 1 || zze(connectionResult)) {
            return this.f640tq == null || i < this.f641tr;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzapj() {
        this.f643tt--;
        if (this.f643tt > 0) {
            return false;
        }
        if (this.f643tt < 0) {
            Log.i("GoogleApiClientConnecting", this.f638tm.f704sX.zzapv());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zzg(new ConnectionResult(8, null));
            return false;
        }
        if (this.f640tq == null) {
            return true;
        }
        this.f638tm.f715uq = this.f641tr;
        zzg(this.f640tq);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzapk() {
        if (this.f643tt != 0) {
            return;
        }
        if (!this.f648ty || this.f649tz) {
            zzapl();
        }
    }

    private void zzapl() {
        ArrayList arrayList = new ArrayList();
        this.f642ts = 1;
        this.f643tt = this.f638tm.f707tY.size();
        for (Api.zzc<?> zzcVar : this.f638tm.f707tY.keySet()) {
            if (!this.f638tm.f712un.containsKey(zzcVar)) {
                arrayList.add(this.f638tm.f707tY.get(zzcVar));
            } else if (zzapj()) {
                zzapm();
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f636tF.add(zzqg.zzapz().submit(new zzc(arrayList)));
    }

    private void zzapm() {
        this.f638tm.zzapx();
        zzqg.zzapz().execute(new Runnable() { // from class: com.google.android.gms.internal.zzqb.1
            @Override // java.lang.Runnable
            public void run() {
                zzqb.this.f639tp.zzbp(zzqb.this.mContext);
            }
        });
        if (this.f646tw != null) {
            if (this.f632tB) {
                this.f646tw.zza(this.f631tA, this.f633tC);
            }
            zzbl(false);
        }
        Iterator<Api.zzc<?>> it = this.f638tm.f712un.keySet().iterator();
        while (it.hasNext()) {
            this.f638tm.f707tY.get(it.next()).disconnect();
        }
        this.f638tm.f716ur.zzm(this.f644tu.isEmpty() ? null : this.f644tu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzapn() {
        this.f648ty = false;
        this.f638tm.f704sX.f683tZ = Collections.emptySet();
        for (Api.zzc<?> zzcVar : this.f645tv) {
            if (!this.f638tm.f712un.containsKey(zzcVar)) {
                this.f638tm.f712un.put(zzcVar, new ConnectionResult(17, null));
            }
        }
    }

    private void zzapo() {
        Iterator<Future<?>> it = this.f636tF.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.f636tF.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<Scope> zzapp() {
        if (this.f634tD == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.f634tD.zzasf());
        Map<Api<?>, com.google.android.gms.common.internal.zzg.zza> mapZzash = this.f634tD.zzash();
        for (Api<?> api : mapZzash.keySet()) {
            if (!this.f638tm.f712un.containsKey(api.zzanp())) {
                hashSet.addAll(mapZzash.get(api).f337dY);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zzanm().getPriority();
            if (zza(priority, i, connectionResult)) {
                this.f640tq = connectionResult;
                this.f641tr = priority;
            }
        }
        this.f638tm.f712un.put(api.zzanp(), connectionResult);
    }

    private void zzbl(boolean z) {
        if (this.f646tw != null) {
            if (this.f646tw.isConnected() && z) {
                this.f646tw.zzbzk();
            }
            this.f646tw.disconnect();
            this.f631tA = null;
        }
    }

    private boolean zze(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.f639tp.zzfa(connectionResult.getErrorCode()) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzf(ConnectionResult connectionResult) {
        if (this.f647tx != 2) {
            return this.f647tx == 1 && !connectionResult.hasResolution();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzfg(int i) {
        if (this.f642ts == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.f638tm.f704sX.zzapv());
        String strValueOf = String.valueOf(this);
        Log.i("GoogleApiClientConnecting", new StringBuilder(String.valueOf(strValueOf).length() + 23).append("Unexpected callback in ").append(strValueOf).toString());
        Log.i("GoogleApiClientConnecting", new StringBuilder(33).append("mRemainingConnections=").append(this.f643tt).toString());
        String strValueOf2 = String.valueOf(zzfh(this.f642ts));
        String strValueOf3 = String.valueOf(zzfh(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(strValueOf2).length() + 70 + String.valueOf(strValueOf3).length()).append("GoogleApiClient connecting is in step ").append(strValueOf2).append(" but received callback for step ").append(strValueOf3).toString(), new Exception());
        zzg(new ConnectionResult(8, null));
        return false;
    }

    private String zzfh(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzg(ConnectionResult connectionResult) {
        zzapo();
        zzbl(!connectionResult.hasResolution());
        this.f638tm.zzi(connectionResult);
        this.f638tm.f716ur.zzd(connectionResult);
    }

    @Override // com.google.android.gms.internal.zzqe
    public void begin() {
        this.f638tm.f712un.clear();
        this.f648ty = false;
        this.f640tq = null;
        this.f642ts = 0;
        this.f647tx = 2;
        this.f649tz = false;
        this.f632tB = false;
        HashMap map = new HashMap();
        boolean z = false;
        for (Api<?> api : this.f635tE.keySet()) {
            Api.zze zzeVar = this.f638tm.f707tY.get(api.zzanp());
            int iIntValue = this.f635tE.get(api).intValue();
            boolean z2 = (api.zzanm().getPriority() == 1) | z;
            if (zzeVar.zzafk()) {
                this.f648ty = true;
                if (iIntValue < this.f647tx) {
                    this.f647tx = iIntValue;
                }
                if (iIntValue != 0) {
                    this.f645tv.add(api.zzanp());
                }
            }
            map.put(zzeVar, new zza(this, api, iIntValue));
            z = z2;
        }
        if (z) {
            this.f648ty = false;
        }
        if (this.f648ty) {
            this.f634tD.zzc(Integer.valueOf(this.f638tm.f704sX.getSessionId()));
            zze zzeVar2 = new zze();
            this.f646tw = (zzvx) this.f630rY.zza(this.mContext, this.f638tm.f704sX.getLooper(), this.f634tD, this.f634tD.zzasl(), zzeVar2, zzeVar2);
        }
        this.f643tt = this.f638tm.f707tY.size();
        this.f636tF.add(zzqg.zzapz().submit(new zzb(map)));
    }

    @Override // com.google.android.gms.internal.zzqe
    public void connect() {
    }

    @Override // com.google.android.gms.internal.zzqe
    public boolean disconnect() {
        zzapo();
        zzbl(true);
        this.f638tm.zzi(null);
        return true;
    }

    @Override // com.google.android.gms.internal.zzqe
    public void onConnected(Bundle bundle) {
        if (zzfg(1)) {
            if (bundle != null) {
                this.f644tu.putAll(bundle);
            }
            if (zzapj()) {
                zzapm();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzqe
    public void onConnectionSuspended(int i) {
        zzg(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.internal.zzqe
    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (zzfg(1)) {
            zzb(connectionResult, api, i);
            if (zzapj()) {
                zzapm();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzqe
    public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(T t) {
        this.f638tm.f704sX.f676tS.add(t);
        return t;
    }

    @Override // com.google.android.gms.internal.zzqe
    public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
