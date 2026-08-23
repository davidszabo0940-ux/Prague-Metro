package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class zzqh implements Handler.Callback {

    /* JADX INFO: renamed from: uw */
    private static zzqh f720uw;
    private static final Object zzamp = new Object();
    private final Context mContext;
    private final Handler mHandler;

    /* JADX INFO: renamed from: rX */
    private final GoogleApiAvailability f721rX;

    /* JADX INFO: renamed from: tU */
    private long f722tU;

    /* JADX INFO: renamed from: tV */
    private long f723tV;

    /* JADX INFO: renamed from: uA */
    private final Map<zzpo<?>, zzc<?>> f724uA;

    /* JADX INFO: renamed from: uB */
    private zzpw f725uB;

    /* JADX INFO: renamed from: uC */
    private final Set<zzpo<?>> f726uC;

    /* JADX INFO: renamed from: uD */
    private final ReferenceQueue<com.google.android.gms.common.api.zzc<?>> f727uD;

    /* JADX INFO: renamed from: uE */
    private final SparseArray<zza> f728uE;

    /* JADX INFO: renamed from: uF */
    private zzb f729uF;

    /* JADX INFO: renamed from: uv */
    private long f730uv;

    /* JADX INFO: renamed from: ux */
    private int f731ux;

    /* JADX INFO: renamed from: uy */
    private final AtomicInteger f732uy;

    /* JADX INFO: renamed from: uz */
    private final SparseArray<zzc<?>> f733uz;

    private final class zza extends PhantomReference<com.google.android.gms.common.api.zzc<?>> {

        /* JADX INFO: renamed from: sn */
        private final int f734sn;

        public zza(com.google.android.gms.common.api.zzc zzcVar, int i, ReferenceQueue<com.google.android.gms.common.api.zzc<?>> referenceQueue) {
            super(zzcVar, referenceQueue);
            this.f734sn = i;
        }

        public void zzaqd() {
            zzqh.this.mHandler.sendMessage(zzqh.this.mHandler.obtainMessage(2, this.f734sn, 2));
        }
    }

    private static final class zzb extends Thread {

        /* JADX INFO: renamed from: uD */
        private final ReferenceQueue<com.google.android.gms.common.api.zzc<?>> f736uD;

        /* JADX INFO: renamed from: uE */
        private final SparseArray<zza> f737uE;

        /* JADX INFO: renamed from: uH */
        private final AtomicBoolean f738uH;

        public zzb(ReferenceQueue<com.google.android.gms.common.api.zzc<?>> referenceQueue, SparseArray<zza> sparseArray) {
            super("GoogleApiCleanup");
            this.f738uH = new AtomicBoolean();
            this.f736uD = referenceQueue;
            this.f737uE = sparseArray;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f738uH.set(true);
            Process.setThreadPriority(10);
            while (this.f738uH.get()) {
                try {
                    zza zzaVar = (zza) this.f736uD.remove();
                    this.f737uE.remove(zzaVar.f734sn);
                    zzaVar.zzaqd();
                } catch (InterruptedException e) {
                    this.f738uH.set(false);
                    return;
                } catch (Throwable th) {
                    this.f738uH.set(false);
                    throw th;
                }
            }
            this.f738uH.set(false);
        }
    }

    private class zzc<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

        /* JADX INFO: renamed from: rG */
        private final zzpo<O> f739rG;

        /* JADX INFO: renamed from: tT */
        private boolean f740tT;

        /* JADX INFO: renamed from: uJ */
        private final Api.zze f743uJ;

        /* JADX INFO: renamed from: uK */
        private final Api.zzb f744uK;

        /* JADX INFO: renamed from: uI */
        private final Queue<zzpn> f742uI = new LinkedList();

        /* JADX INFO: renamed from: uL */
        private final SparseArray<zzrd> f745uL = new SparseArray<>();

        /* JADX INFO: renamed from: uM */
        private final Set<zzpq> f746uM = new HashSet();

        /* JADX INFO: renamed from: uN */
        private final SparseArray<Map<Object, zzpr.zza>> f747uN = new SparseArray<>();

        /* JADX INFO: renamed from: uO */
        private ConnectionResult f748uO = null;

        @WorkerThread
        public zzc(com.google.android.gms.common.api.zzc<O> zzcVar) {
            this.f743uJ = zzb(zzcVar);
            if (this.f743uJ instanceof com.google.android.gms.common.internal.zzah) {
                this.f744uK = ((com.google.android.gms.common.internal.zzah) this.f743uJ).zzatj();
            } else {
                this.f744uK = this.f743uJ;
            }
            this.f739rG = zzcVar.zzany();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void connect() {
            if (this.f743uJ.isConnected() || this.f743uJ.isConnecting()) {
                return;
            }
            if (this.f743uJ.zzanr() && zzqh.this.f731ux != 0) {
                zzqh.this.f731ux = zzqh.this.f721rX.isGooglePlayServicesAvailable(zzqh.this.mContext);
                if (zzqh.this.f731ux != 0) {
                    onConnectionFailed(new ConnectionResult(zzqh.this.f731ux, null));
                    return;
                }
            }
            this.f743uJ.zza(zzqh.this.new zzd(this.f743uJ, this.f739rG));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void resume() {
            if (this.f740tT) {
                connect();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void zzab(Status status) {
            Iterator<zzpn> it = this.f742uI.iterator();
            while (it.hasNext()) {
                it.next().zzx(status);
            }
            this.f742uI.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void zzapr() {
            if (this.f740tT) {
                zzaqh();
                zzab(zzqh.this.f721rX.isGooglePlayServicesAvailable(zzqh.this.mContext) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.f743uJ.disconnect();
            }
        }

        @WorkerThread
        private void zzaqh() {
            if (this.f740tT) {
                zzqh.this.mHandler.removeMessages(9, this.f739rG);
                zzqh.this.mHandler.removeMessages(8, this.f739rG);
                this.f740tT = false;
            }
        }

        private void zzaqi() {
            zzqh.this.mHandler.removeMessages(10, this.f739rG);
            zzqh.this.mHandler.sendMessageDelayed(zzqh.this.mHandler.obtainMessage(10, this.f739rG), zzqh.this.f730uv);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void zzaqj() {
            if (!this.f743uJ.isConnected() || this.f747uN.size() != 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f745uL.size()) {
                    this.f743uJ.disconnect();
                    return;
                } else {
                    if (this.f745uL.get(this.f745uL.keyAt(i2)).zzaqw()) {
                        zzaqi();
                        return;
                    }
                    i = i2 + 1;
                }
            }
        }

        @WorkerThread
        private Api.zze zzb(com.google.android.gms.common.api.zzc zzcVar) {
            Api<O> apiZzanw = zzcVar.zzanw();
            if (!apiZzanw.zzanq()) {
                return zzcVar.zzanw().zzann().zza(zzcVar.getApplicationContext(), zzqh.this.mHandler.getLooper(), com.google.android.gms.common.internal.zzg.zzcd(zzcVar.getApplicationContext()), zzcVar.zzanx(), this, this);
            }
            Api.zzh<?, O> zzhVarZzano = apiZzanw.zzano();
            return new com.google.android.gms.common.internal.zzah(zzcVar.getApplicationContext(), zzqh.this.mHandler.getLooper(), zzhVarZzano.zzant(), this, this, com.google.android.gms.common.internal.zzg.zzcd(zzcVar.getApplicationContext()), zzhVarZzano.zzs(zzcVar.zzanx()));
        }

        @WorkerThread
        private void zzc(zzpn zzpnVar) {
            Map map;
            zzpnVar.zza(this.f745uL);
            if (zzpnVar.f564it == 3) {
                try {
                    Map<Object, zzpr.zza> map2 = this.f747uN.get(zzpnVar.f565sn);
                    if (map2 == null) {
                        ArrayMap arrayMap = new ArrayMap(1);
                        this.f747uN.put(zzpnVar.f565sn, arrayMap);
                        map = arrayMap;
                    } else {
                        map = map2;
                    }
                    Object obj = ((zzpn.zza) zzpnVar).f566so;
                    map.put(((zzqr) obj).zzaqq(), obj);
                } catch (ClassCastException e) {
                    throw new IllegalStateException("Listener registration methods must implement ListenerApiMethod");
                }
            } else if (zzpnVar.f564it == 4) {
                try {
                    Map<Object, zzpr.zza> map3 = this.f747uN.get(zzpnVar.f565sn);
                    zzqr zzqrVar = (zzqr) ((zzpn.zza) zzpnVar).f566so;
                    if (map3 != null) {
                        map3.remove(zzqrVar.zzaqq());
                    } else {
                        Log.w("GoogleApiManager", "Received call to unregister a listener without a matching registration call.");
                    }
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Listener unregistration methods must implement ListenerApiMethod");
                }
            }
            try {
                zzpnVar.zzb(this.f744uK);
            } catch (DeadObjectException e3) {
                this.f743uJ.disconnect();
                onConnectionSuspended(1);
            }
        }

        @WorkerThread
        private void zzj(ConnectionResult connectionResult) {
            Iterator<zzpq> it = this.f746uM.iterator();
            while (it.hasNext()) {
                it.next().zza(this.f739rG, connectionResult);
            }
            this.f746uM.clear();
        }

        boolean isConnected() {
            return this.f743uJ.isConnected();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        @WorkerThread
        public void onConnected(@Nullable Bundle bundle) {
            zzaqf();
            zzj(ConnectionResult.f104qR);
            zzaqh();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f747uN.size()) {
                    zzaqe();
                    zzaqi();
                    return;
                }
                Iterator<zzpr.zza> it = this.f747uN.get(this.f747uN.keyAt(i2)).values().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().zzb(this.f744uK);
                    } catch (DeadObjectException e) {
                        this.f743uJ.disconnect();
                        onConnectionSuspended(1);
                    }
                }
                i = i2 + 1;
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        @WorkerThread
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzaqf();
            zzqh.this.f731ux = -1;
            zzj(connectionResult);
            int iKeyAt = this.f745uL.keyAt(0);
            if (this.f742uI.isEmpty()) {
                this.f748uO = connectionResult;
                return;
            }
            synchronized (zzqh.zzamp) {
                if (zzqh.zzd(zzqh.this) != null && zzqh.this.f726uC.contains(this.f739rG)) {
                    zzqh.zzd(zzqh.this).zzb(connectionResult, iKeyAt);
                } else if (!zzqh.this.zzc(connectionResult, iKeyAt)) {
                    if (connectionResult.getErrorCode() == 18) {
                        this.f740tT = true;
                    }
                    if (this.f740tT) {
                        zzqh.this.mHandler.sendMessageDelayed(Message.obtain(zzqh.this.mHandler, 8, this.f739rG), zzqh.this.f723tV);
                    } else {
                        String strValueOf = String.valueOf(this.f739rG.zzaok());
                        zzab(new Status(17, new StringBuilder(String.valueOf(strValueOf).length() + 38).append("API: ").append(strValueOf).append(" is not available on this device.").toString()));
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        @WorkerThread
        public void onConnectionSuspended(int i) {
            zzaqf();
            this.f740tT = true;
            zzqh.this.mHandler.sendMessageDelayed(Message.obtain(zzqh.this.mHandler, 8, this.f739rG), zzqh.this.f723tV);
            zzqh.this.mHandler.sendMessageDelayed(Message.obtain(zzqh.this.mHandler, 9, this.f739rG), zzqh.this.f722tU);
            zzqh.this.f731ux = -1;
        }

        @WorkerThread
        public void zzaqe() {
            while (this.f743uJ.isConnected() && !this.f742uI.isEmpty()) {
                zzc(this.f742uI.remove());
            }
        }

        @WorkerThread
        public void zzaqf() {
            this.f748uO = null;
        }

        ConnectionResult zzaqg() {
            return this.f748uO;
        }

        @WorkerThread
        public void zzb(zzpn zzpnVar) {
            if (this.f743uJ.isConnected()) {
                zzc(zzpnVar);
                zzaqi();
                return;
            }
            this.f742uI.add(zzpnVar);
            if (this.f748uO == null || !this.f748uO.hasResolution()) {
                connect();
            } else {
                onConnectionFailed(this.f748uO);
            }
        }

        @WorkerThread
        public void zzb(zzpq zzpqVar) {
            this.f746uM.add(zzpqVar);
        }

        @WorkerThread
        public void zzf(int i, boolean z) {
            Iterator<zzpn> it = this.f742uI.iterator();
            while (it.hasNext()) {
                zzpn next = it.next();
                if (next.f565sn == i && next.f564it != 1 && next.cancel()) {
                    it.remove();
                }
            }
            this.f745uL.get(i).release();
            this.f747uN.delete(i);
            if (z) {
                return;
            }
            this.f745uL.remove(i);
            zzqh.this.f728uE.remove(i);
            if (this.f745uL.size() == 0 && this.f742uI.isEmpty()) {
                zzaqh();
                this.f743uJ.disconnect();
                zzqh.this.f724uA.remove(this.f739rG);
                synchronized (zzqh.zzamp) {
                    zzqh.this.f726uC.remove(this.f739rG);
                }
            }
        }

        @WorkerThread
        public void zzfk(int i) {
            this.f745uL.put(i, new zzrd(this.f739rG.zzanp(), this.f743uJ));
        }
    }

    private class zzd implements com.google.android.gms.common.internal.zzd.zzf {

        /* JADX INFO: renamed from: rG */
        private final zzpo<?> f749rG;

        /* JADX INFO: renamed from: uJ */
        private final Api.zze f751uJ;

        public zzd(Api.zze zzeVar, zzpo<?> zzpoVar) {
            this.f751uJ = zzeVar;
            this.f749rG = zzpoVar;
        }

        @Override // com.google.android.gms.common.internal.zzd.zzf
        @WorkerThread
        public void zzh(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                this.f751uJ.zza(null, Collections.emptySet());
            } else {
                ((zzc) zzqh.this.f724uA.get(this.f749rG)).onConnectionFailed(connectionResult);
            }
        }
    }

    private zzqh(Context context) {
        this(context, GoogleApiAvailability.getInstance());
    }

    private zzqh(Context context, GoogleApiAvailability googleApiAvailability) {
        this.f723tV = 5000L;
        this.f722tU = 120000L;
        this.f730uv = 10000L;
        this.f731ux = -1;
        this.f732uy = new AtomicInteger(1);
        this.f733uz = new SparseArray<>();
        this.f724uA = new ConcurrentHashMap(5, 0.75f, 1);
        this.f725uB = null;
        this.f726uC = new com.google.android.gms.common.util.zza();
        this.f727uD = new ReferenceQueue<>();
        this.f728uE = new SparseArray<>();
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        this.f721rX = googleApiAvailability;
    }

    private int zza(com.google.android.gms.common.api.zzc<?> zzcVar) {
        int andIncrement = this.f732uy.getAndIncrement();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, andIncrement, 0, zzcVar));
        return andIncrement;
    }

    public static Pair<zzqh, Integer> zza(Context context, com.google.android.gms.common.api.zzc<?> zzcVar) {
        Pair<zzqh, Integer> pairCreate;
        synchronized (zzamp) {
            if (f720uw == null) {
                f720uw = new zzqh(context.getApplicationContext());
            }
            pairCreate = Pair.create(f720uw, Integer.valueOf(f720uw.zza(zzcVar)));
        }
        return pairCreate;
    }

    @WorkerThread
    private void zza(com.google.android.gms.common.api.zzc<?> zzcVar, int i) {
        Object objZzany = zzcVar.zzany();
        if (!this.f724uA.containsKey(objZzany)) {
            this.f724uA.put((zzpo<?>) objZzany, new zzc<>(zzcVar));
        }
        zzc<?> zzcVar2 = this.f724uA.get(objZzany);
        zzcVar2.zzfk(i);
        this.f733uz.put(i, zzcVar2);
        zzcVar2.connect();
        this.f728uE.put(i, new zza(zzcVar, i, this.f727uD));
        if (this.f729uF == null || !this.f729uF.f738uH.get()) {
            this.f729uF = new zzb(this.f727uD, this.f728uE);
            this.f729uF.start();
        }
    }

    @WorkerThread
    private void zza(zzpn zzpnVar) {
        this.f733uz.get(zzpnVar.f565sn).zzb(zzpnVar);
    }

    public static zzqh zzaqa() {
        zzqh zzqhVar;
        synchronized (zzamp) {
            zzqhVar = f720uw;
        }
        return zzqhVar;
    }

    @WorkerThread
    private void zzaqb() {
        for (zzc<?> zzcVar : this.f724uA.values()) {
            zzcVar.zzaqf();
            zzcVar.connect();
        }
    }

    static /* synthetic */ zzpw zzd(zzqh zzqhVar) {
        return null;
    }

    @WorkerThread
    private void zze(int i, boolean z) {
        zzc<?> zzcVar = this.f733uz.get(i);
        if (zzcVar == null) {
            Log.wtf("GoogleApiManager", new StringBuilder(52).append("onRelease received for unknown instance: ").append(i).toString(), new Exception());
            return;
        }
        if (!z) {
            this.f733uz.delete(i);
        }
        zzcVar.zzf(i, z);
    }

    @Override // android.os.Handler.Callback
    @WorkerThread
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                zza((zzpq) message.obj);
                break;
            case 2:
            case 7:
                zze(message.arg1, message.arg2 == 1);
                break;
            case 3:
                zzaqb();
                break;
            case 4:
                zza((zzpn) message.obj);
                break;
            case 5:
                if (this.f733uz.get(message.arg1) != null) {
                    this.f733uz.get(message.arg1).zzab(new Status(17, "Error resolution was canceled by the user."));
                }
                break;
            case 6:
                zza((com.google.android.gms.common.api.zzc<?>) message.obj, message.arg1);
                break;
            case 8:
                if (this.f724uA.containsKey(message.obj)) {
                    this.f724uA.get(message.obj).resume();
                }
                break;
            case 9:
                if (this.f724uA.containsKey(message.obj)) {
                    this.f724uA.get(message.obj).zzapr();
                }
                break;
            case 10:
                if (this.f724uA.containsKey(message.obj)) {
                    this.f724uA.get(message.obj).zzaqj();
                }
                break;
            default:
                Log.w("GoogleApiManager", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                return false;
        }
        return true;
    }

    public void zza(ConnectionResult connectionResult, int i) {
        if (zzc(connectionResult, i)) {
            return;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i, 0));
    }

    public <O extends Api.ApiOptions> void zza(com.google.android.gms.common.api.zzc<O> zzcVar, int i, zzpr.zza<? extends Result, Api.zzb> zzaVar) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzpn.zza(zzcVar.getInstanceId(), i, zzaVar)));
    }

    public <O extends Api.ApiOptions, TResult> void zza(com.google.android.gms.common.api.zzc<O> zzcVar, int i, zzrb<Api.zzb, TResult> zzrbVar, TaskCompletionSource<TResult> taskCompletionSource) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzpn.zzb(zzcVar.getInstanceId(), i, zzrbVar, taskCompletionSource)));
    }

    @WorkerThread
    public void zza(zzpq zzpqVar) {
        for (zzpo<?> zzpoVar : zzpqVar.zzaon()) {
            zzc<?> zzcVar = this.f724uA.get(zzpoVar);
            if (zzcVar == null) {
                zzpqVar.cancel();
                return;
            } else if (zzcVar.isConnected()) {
                zzpqVar.zza(zzpoVar, ConnectionResult.f104qR);
            } else if (zzcVar.zzaqg() != null) {
                zzpqVar.zza(zzpoVar, zzcVar.zzaqg());
            } else {
                zzcVar.zzb(zzpqVar);
            }
        }
    }

    public void zza(zzpw zzpwVar) {
        synchronized (zzamp) {
            if (zzpwVar == null) {
                this.f725uB = null;
                this.f726uC.clear();
            }
        }
    }

    public void zzaol() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    boolean zzc(ConnectionResult connectionResult, int i) {
        if (!connectionResult.hasResolution() && !this.f721rX.isUserResolvableError(connectionResult.getErrorCode())) {
            return false;
        }
        this.f721rX.zza(this.mContext, connectionResult, i);
        return true;
    }

    public void zzd(int i, boolean z) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, i, z ? 1 : 2));
    }
}
