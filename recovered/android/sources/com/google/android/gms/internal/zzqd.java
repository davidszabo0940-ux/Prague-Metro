package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class zzqd extends GoogleApiClient implements zzqm.zza {
    private final Context mContext;

    /* JADX INFO: renamed from: rV */
    private final int f669rV;

    /* JADX INFO: renamed from: rX */
    private final GoogleApiAvailability f670rX;

    /* JADX INFO: renamed from: rY */
    final Api.zza<? extends zzvx, zzvy> f671rY;

    /* JADX INFO: renamed from: tD */
    final com.google.android.gms.common.internal.zzg f672tD;

    /* JADX INFO: renamed from: tE */
    final Map<Api<?>, Integer> f673tE;

    /* JADX INFO: renamed from: tQ */
    private final com.google.android.gms.common.internal.zzl f674tQ;

    /* JADX INFO: renamed from: tT */
    private volatile boolean f677tT;

    /* JADX INFO: renamed from: tW */
    private final zza f680tW;

    /* JADX INFO: renamed from: tX */
    zzqj f681tX;

    /* JADX INFO: renamed from: tY */
    final Map<Api.zzc<?>, Api.zze> f682tY;

    /* JADX INFO: renamed from: th */
    private final Lock f684th;

    /* JADX INFO: renamed from: ub */
    private final ArrayList<zzpu> f686ub;

    /* JADX INFO: renamed from: uc */
    private Integer f687uc;

    /* JADX INFO: renamed from: ue */
    final zzrd f689ue;
    private final Looper zzahv;

    /* JADX INFO: renamed from: tR */
    private zzqm f675tR = null;

    /* JADX INFO: renamed from: tS */
    final Queue<zzpr.zza<?, ?>> f676tS = new LinkedList();

    /* JADX INFO: renamed from: tU */
    private long f678tU = 120000;

    /* JADX INFO: renamed from: tV */
    private long f679tV = 5000;

    /* JADX INFO: renamed from: tZ */
    Set<Scope> f683tZ = new HashSet();

    /* JADX INFO: renamed from: ua */
    private final zzqt f685ua = new zzqt();

    /* JADX INFO: renamed from: ud */
    Set<zzrc> f688ud = null;

    /* JADX INFO: renamed from: uf */
    private final com.google.android.gms.common.internal.zzl.zza f690uf = new com.google.android.gms.common.internal.zzl.zza() { // from class: com.google.android.gms.internal.zzqd.1
        @Override // com.google.android.gms.common.internal.zzl.zza
        public boolean isConnected() {
            return zzqd.this.isConnected();
        }

        @Override // com.google.android.gms.common.internal.zzl.zza
        public Bundle zzamc() {
            return null;
        }
    };

    final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    zzqd.this.zzapr();
                    break;
                case 2:
                    zzqd.this.resume();
                    break;
                default:
                    Log.w("GoogleApiClientImpl", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                    break;
            }
        }
    }

    static class zzb extends zzqj.zza {

        /* JADX INFO: renamed from: uk */
        private WeakReference<zzqd> f702uk;

        zzb(zzqd zzqdVar) {
            this.f702uk = new WeakReference<>(zzqdVar);
        }

        @Override // com.google.android.gms.internal.zzqj.zza
        public void zzaor() {
            zzqd zzqdVar = this.f702uk.get();
            if (zzqdVar == null) {
                return;
            }
            zzqdVar.resume();
        }
    }

    public zzqd(Context context, Lock lock, Looper looper, com.google.android.gms.common.internal.zzg zzgVar, GoogleApiAvailability googleApiAvailability, Api.zza<? extends zzvx, zzvy> zzaVar, Map<Api<?>, Integer> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.zzc<?>, Api.zze> map2, int i, int i2, ArrayList<zzpu> arrayList) {
        this.f687uc = null;
        this.mContext = context;
        this.f684th = lock;
        this.f674tQ = new com.google.android.gms.common.internal.zzl(looper, this.f690uf);
        this.zzahv = looper;
        this.f680tW = new zza(looper);
        this.f670rX = googleApiAvailability;
        this.f669rV = i;
        if (this.f669rV >= 0) {
            this.f687uc = Integer.valueOf(i2);
        }
        this.f673tE = map;
        this.f682tY = map2;
        this.f686ub = arrayList;
        this.f689ue = new zzrd(this.f682tY);
        Iterator<GoogleApiClient.ConnectionCallbacks> it = list.iterator();
        while (it.hasNext()) {
            this.f674tQ.registerConnectionCallbacks(it.next());
        }
        Iterator<GoogleApiClient.OnConnectionFailedListener> it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f674tQ.registerConnectionFailedListener(it2.next());
        }
        this.f672tD = zzgVar;
        this.f671rY = zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resume() {
        this.f684th.lock();
        try {
            if (isResuming()) {
                zzapq();
            }
        } finally {
            this.f684th.unlock();
        }
    }

    public static int zza(Iterable<Api.zze> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.zze zzeVar : iterable) {
            if (zzeVar.zzafk()) {
                z3 = true;
            }
            z2 = zzeVar.zzafz() ? true : z2;
        }
        if (z3) {
            return (z2 && z) ? 2 : 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(final GoogleApiClient googleApiClient, final zzqz zzqzVar, final boolean z) {
        zzrj.f827zh.zzg(googleApiClient).setResultCallback(new ResultCallback<Status>() { // from class: com.google.android.gms.internal.zzqd.4
            @Override // com.google.android.gms.common.api.ResultCallback
            /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
            public void onResult(@NonNull Status status) {
                com.google.android.gms.auth.api.signin.internal.zzk.zzbc(zzqd.this.mContext).zzagl();
                if (status.isSuccess() && zzqd.this.isConnected()) {
                    zzqd.this.reconnect();
                }
                zzqzVar.zzc(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private void zzapq() {
        this.f674tQ.zzast();
        this.f675tR.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzapr() {
        this.f684th.lock();
        try {
            if (zzapt()) {
                zzapq();
            }
        } finally {
            this.f684th.unlock();
        }
    }

    private void zzb(@NonNull zzqn zzqnVar) {
        if (this.f669rV < 0) {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
        zzpp.zza(zzqnVar).zzff(this.f669rV);
    }

    private void zzfi(int i) {
        if (this.f687uc == null) {
            this.f687uc = Integer.valueOf(i);
        } else if (this.f687uc.intValue() != i) {
            String strValueOf = String.valueOf(zzfj(i));
            String strValueOf2 = String.valueOf(zzfj(this.f687uc.intValue()));
            throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 51 + String.valueOf(strValueOf2).length()).append("Cannot use sign-in mode: ").append(strValueOf).append(". Mode was already set to ").append(strValueOf2).toString());
        }
        if (this.f675tR != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (Api.zze zzeVar : this.f682tY.values()) {
            if (zzeVar.zzafk()) {
                z2 = true;
            }
            z = zzeVar.zzafz() ? true : z;
        }
        switch (this.f687uc.intValue()) {
            case 1:
                if (!z2) {
                    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                }
                if (z) {
                    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
                break;
            case 2:
                if (z2) {
                    this.f675tR = zzpv.zza(this.mContext, this, this.f684th, this.zzahv, this.f670rX, this.f682tY, this.f672tD, this.f673tE, this.f671rY, this.f686ub);
                    return;
                }
                break;
        }
        this.f675tR = new zzqf(this.mContext, this, this.f684th, this.zzahv, this.f670rX, this.f682tY, this.f672tD, this.f673tE, this.f671rY, this.f686ub, this);
    }

    static String zzfj(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect() {
        com.google.android.gms.common.internal.zzab.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f684th.lock();
        try {
            if (this.f669rV >= 0) {
                com.google.android.gms.common.internal.zzab.zza(this.f687uc != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f687uc == null) {
                this.f687uc = Integer.valueOf(zza(this.f682tY.values(), false));
            } else if (this.f687uc.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzfi(this.f687uc.intValue());
            this.f674tQ.zzast();
            ConnectionResult connectionResultBlockingConnect = this.f675tR.blockingConnect();
            this.f684th.unlock();
            return connectionResultBlockingConnect;
        } catch (Throwable th) {
            this.f684th.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        com.google.android.gms.common.internal.zzab.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        com.google.android.gms.common.internal.zzab.zzb(timeUnit, "TimeUnit must not be null");
        this.f684th.lock();
        try {
            if (this.f687uc == null) {
                this.f687uc = Integer.valueOf(zza(this.f682tY.values(), false));
            } else if (this.f687uc.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzfi(this.f687uc.intValue());
            this.f674tQ.zzast();
            ConnectionResult connectionResultBlockingConnect = this.f675tR.blockingConnect(j, timeUnit);
            this.f684th.unlock();
            return connectionResultBlockingConnect;
        } catch (Throwable th) {
            this.f684th.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        com.google.android.gms.common.internal.zzab.zza(isConnected(), "GoogleApiClient is not connected yet.");
        com.google.android.gms.common.internal.zzab.zza(this.f687uc.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final zzqz zzqzVar = new zzqz(this);
        if (this.f682tY.containsKey(zzrj.f825bN)) {
            zza(this, zzqzVar, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient googleApiClientBuild = new GoogleApiClient.Builder(this.mContext).addApi(zzrj.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() { // from class: com.google.android.gms.internal.zzqd.2
                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnected(Bundle bundle) {
                    zzqd.this.zza((GoogleApiClient) atomicReference.get(), zzqzVar, true);
                }

                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnectionSuspended(int i) {
                }
            }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() { // from class: com.google.android.gms.internal.zzqd.3
                @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
                public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                    zzqzVar.zzc(new Status(8));
                }
            }).setHandler(this.f680tW).build();
            atomicReference.set(googleApiClientBuild);
            googleApiClientBuild.connect();
        }
        return zzqzVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect() {
        this.f684th.lock();
        try {
            if (this.f669rV >= 0) {
                com.google.android.gms.common.internal.zzab.zza(this.f687uc != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f687uc == null) {
                this.f687uc = Integer.valueOf(zza(this.f682tY.values(), false));
            } else if (this.f687uc.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.f687uc.intValue());
            this.f684th.unlock();
        } catch (Throwable th) {
            this.f684th.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect(int i) {
        boolean z = true;
        this.f684th.lock();
        if (i != 3 && i != 1 && i != 2) {
            z = false;
        }
        try {
            com.google.android.gms.common.internal.zzab.zzb(z, new StringBuilder(33).append("Illegal sign-in mode: ").append(i).toString());
            zzfi(i);
            zzapq();
        } finally {
            this.f684th.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void disconnect() {
        this.f684th.lock();
        try {
            this.f689ue.release();
            if (this.f675tR != null) {
                this.f675tR.disconnect();
            }
            this.f685ua.release();
            for (zzpr.zza<?, ?> zzaVar : this.f676tS) {
                zzaVar.zza((zzrd.zzb) null);
                zzaVar.cancel();
            }
            this.f676tS.clear();
            if (this.f675tR == null) {
                return;
            }
            zzapt();
            this.f674tQ.zzass();
        } finally {
            this.f684th.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.mContext);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f677tT);
        printWriter.append(" mWorkQueue.size()=").print(this.f676tS.size());
        this.f689ue.dump(printWriter);
        if (this.f675tR != null) {
            this.f675tR.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        this.f684th.lock();
        try {
            if (!isConnected() && !isResuming()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (!this.f682tY.containsKey(api.zzanp())) {
                throw new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
            }
            ConnectionResult connectionResult = this.f675tR.getConnectionResult(api);
            if (connectionResult != null) {
                this.f684th.unlock();
            } else if (isResuming()) {
                connectionResult = ConnectionResult.f104qR;
                this.f684th.unlock();
            } else {
                Log.i("GoogleApiClientImpl", zzapv());
                Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                connectionResult = new ConnectionResult(8, null);
                this.f684th.unlock();
            }
            return connectionResult;
        } catch (Throwable th) {
            this.f684th.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Looper getLooper() {
        return this.zzahv;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean hasConnectedApi(@NonNull Api<?> api) {
        Api.zze zzeVar = this.f682tY.get(api.zzanp());
        return zzeVar != null && zzeVar.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnected() {
        return this.f675tR != null && this.f675tR.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnecting() {
        return this.f675tR != null && this.f675tR.isConnecting();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.f674tQ.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.f674tQ.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    boolean isResuming() {
        return this.f677tT;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f674tQ.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f674tQ.registerConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        zzb(new zzqn(fragmentActivity));
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f674tQ.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f674tQ.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public <C extends Api.zze> C zza(@NonNull Api.zzc<C> zzcVar) {
        C c = (C) this.f682tY.get(zzcVar);
        com.google.android.gms.common.internal.zzab.zzb(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zza(zzrc zzrcVar) {
        this.f684th.lock();
        try {
            if (this.f688ud == null) {
                this.f688ud = new HashSet();
            }
            this.f688ud.add(zzrcVar);
        } finally {
            this.f684th.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(@NonNull Api<?> api) {
        return this.f682tY.containsKey(api.zzanp());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(zzqy zzqyVar) {
        return this.f675tR != null && this.f675tR.zza(zzqyVar);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zzaoc() {
        if (this.f675tR != null) {
            this.f675tR.zzaoc();
        }
    }

    void zzaps() {
        if (isResuming()) {
            return;
        }
        this.f677tT = true;
        if (this.f681tX == null) {
            this.f681tX = this.f670rX.zza(this.mContext.getApplicationContext(), new zzb(this));
        }
        this.f680tW.sendMessageDelayed(this.f680tW.obtainMessage(1), this.f678tU);
        this.f680tW.sendMessageDelayed(this.f680tW.obtainMessage(2), this.f679tV);
    }

    boolean zzapt() {
        if (!isResuming()) {
            return false;
        }
        this.f677tT = false;
        this.f680tW.removeMessages(2);
        this.f680tW.removeMessages(1);
        if (this.f681tX != null) {
            this.f681tX.unregister();
            this.f681tX = null;
        }
        return true;
    }

    boolean zzapu() {
        boolean z = false;
        this.f684th.lock();
        try {
            if (this.f688ud != null) {
                z = this.f688ud.isEmpty() ? false : true;
            }
            return z;
        } finally {
            this.f684th.unlock();
        }
    }

    String zzapv() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    <C extends Api.zze> C zzb(Api.zzc<?> zzcVar) {
        C c = (C) this.f682tY.get(zzcVar);
        com.google.android.gms.common.internal.zzab.zzb(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zzb(zzrc zzrcVar) {
        this.f684th.lock();
        try {
            if (this.f688ud == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f688ud.remove(zzrcVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zzapu()) {
                this.f675tR.zzaoy();
            }
        } finally {
            this.f684th.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(@NonNull T t) {
        com.google.android.gms.common.internal.zzab.zzb(t.zzanp() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean zContainsKey = this.f682tY.containsKey(t.zzanp());
        String name = t.zzanw() != null ? t.zzanw().getName() : "the API";
        com.google.android.gms.common.internal.zzab.zzb(zContainsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.f684th.lock();
        try {
            if (this.f675tR == null) {
                this.f676tS.add(t);
            } else {
                t = (T) this.f675tR.zzc(t);
            }
            return t;
        } finally {
            this.f684th.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzqm.zza
    public void zzc(int i, boolean z) {
        if (i == 1 && !z) {
            zzaps();
        }
        this.f689ue.zzaqv();
        this.f674tQ.zzgb(i);
        this.f674tQ.zzass();
        if (i == 2) {
            zzapq();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(@NonNull T t) {
        com.google.android.gms.common.internal.zzab.zzb(t.zzanp() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean zContainsKey = this.f682tY.containsKey(t.zzanp());
        String name = t.zzanw() != null ? t.zzanw().getName() : "the API";
        com.google.android.gms.common.internal.zzab.zzb(zContainsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.f684th.lock();
        try {
            if (this.f675tR == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (isResuming()) {
                this.f676tS.add(t);
                while (!this.f676tS.isEmpty()) {
                    zzpr.zza<?, ?> zzaVarRemove = this.f676tS.remove();
                    this.f689ue.zzg(zzaVarRemove);
                    zzaVarRemove.zzz(Status.f153si);
                }
                this.f684th.unlock();
            } else {
                t = (T) this.f675tR.zzd(t);
                this.f684th.unlock();
            }
            return t;
        } catch (Throwable th) {
            this.f684th.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.zzqm.zza
    public void zzd(ConnectionResult connectionResult) {
        if (!this.f670rX.zzc(this.mContext, connectionResult.getErrorCode())) {
            zzapt();
        }
        if (isResuming()) {
            return;
        }
        this.f674tQ.zzm(connectionResult);
        this.f674tQ.zzass();
    }

    @Override // com.google.android.gms.internal.zzqm.zza
    public void zzm(Bundle bundle) {
        while (!this.f676tS.isEmpty()) {
            zzd(this.f676tS.remove());
        }
        this.f674tQ.zzo(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <L> zzqs<L> zzt(@NonNull L l) {
        this.f684th.lock();
        try {
            return this.f685ua.zzb(l, this.zzahv);
        } finally {
            this.f684th.unlock();
        }
    }
}
