package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public class zzqf implements zzqm {
    private final Context mContext;

    /* JADX INFO: renamed from: rY */
    final Api.zza<? extends zzvx, zzvy> f703rY;

    /* JADX INFO: renamed from: sX */
    final zzqd f704sX;

    /* JADX INFO: renamed from: tD */
    final com.google.android.gms.common.internal.zzg f705tD;

    /* JADX INFO: renamed from: tE */
    final Map<Api<?>, Integer> f706tE;

    /* JADX INFO: renamed from: tY */
    final Map<Api.zzc<?>, Api.zze> f707tY;

    /* JADX INFO: renamed from: th */
    private final Lock f708th;

    /* JADX INFO: renamed from: tp */
    private final com.google.android.gms.common.zzc f709tp;

    /* JADX INFO: renamed from: ul */
    private final Condition f710ul;

    /* JADX INFO: renamed from: um */
    private final zzb f711um;

    /* JADX INFO: renamed from: uo */
    private volatile zzqe f713uo;

    /* JADX INFO: renamed from: uq */
    int f715uq;

    /* JADX INFO: renamed from: ur */
    final zzqm.zza f716ur;

    /* JADX INFO: renamed from: un */
    final Map<Api.zzc<?>, ConnectionResult> f712un = new HashMap();

    /* JADX INFO: renamed from: up */
    private ConnectionResult f714up = null;

    static abstract class zza {

        /* JADX INFO: renamed from: us */
        private final zzqe f717us;

        protected zza(zzqe zzqeVar) {
            this.f717us = zzqeVar;
        }

        protected abstract void zzapi();

        public final void zzd(zzqf zzqfVar) {
            zzqfVar.f708th.lock();
            try {
                if (zzqfVar.f713uo != this.f717us) {
                    return;
                }
                zzapi();
            } finally {
                zzqfVar.f708th.unlock();
            }
        }
    }

    final class zzb extends Handler {
        zzb(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((zza) message.obj).zzd(zzqf.this);
                    return;
                case 2:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GACStateManager", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                    return;
            }
        }
    }

    public zzqf(Context context, zzqd zzqdVar, Lock lock, Looper looper, com.google.android.gms.common.zzc zzcVar, Map<Api.zzc<?>, Api.zze> map, com.google.android.gms.common.internal.zzg zzgVar, Map<Api<?>, Integer> map2, Api.zza<? extends zzvx, zzvy> zzaVar, ArrayList<zzpu> arrayList, zzqm.zza zzaVar2) {
        this.mContext = context;
        this.f708th = lock;
        this.f709tp = zzcVar;
        this.f707tY = map;
        this.f705tD = zzgVar;
        this.f706tE = map2;
        this.f703rY = zzaVar;
        this.f704sX = zzqdVar;
        this.f716ur = zzaVar2;
        Iterator<zzpu> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().zza(this);
        }
        this.f711um = new zzb(looper);
        this.f710ul = lock.newCondition();
        this.f713uo = new zzqc(this);
    }

    @Override // com.google.android.gms.internal.zzqm
    public ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.f710ul.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.f104qR;
        }
        return this.f714up != null ? this.f714up : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.internal.zzqm
    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                disconnect();
                return new ConnectionResult(14, null);
            }
            try {
                nanos = this.f710ul.awaitNanos(nanos);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (isConnected()) {
            return ConnectionResult.f104qR;
        }
        return this.f714up != null ? this.f714up : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.internal.zzqm
    public void connect() {
        this.f713uo.connect();
    }

    @Override // com.google.android.gms.internal.zzqm
    public void disconnect() {
        if (this.f713uo.disconnect()) {
            this.f712un.clear();
        }
    }

    @Override // com.google.android.gms.internal.zzqm
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String strConcat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.f713uo);
        for (Api<?> api : this.f706tE.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.getName()).println(":");
            this.f707tY.get(api.zzanp()).dump(strConcat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.internal.zzqm
    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        Api.zzc<?> zzcVarZzanp = api.zzanp();
        if (this.f707tY.containsKey(zzcVarZzanp)) {
            if (this.f707tY.get(zzcVarZzanp).isConnected()) {
                return ConnectionResult.f104qR;
            }
            if (this.f712un.containsKey(zzcVarZzanp)) {
                return this.f712un.get(zzcVarZzanp);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzqm
    public boolean isConnected() {
        return this.f713uo instanceof zzqa;
    }

    @Override // com.google.android.gms.internal.zzqm
    public boolean isConnecting() {
        return this.f713uo instanceof zzqb;
    }

    public void onConnected(@Nullable Bundle bundle) {
        this.f708th.lock();
        try {
            this.f713uo.onConnected(bundle);
        } finally {
            this.f708th.unlock();
        }
    }

    public void onConnectionSuspended(int i) {
        this.f708th.lock();
        try {
            this.f713uo.onConnectionSuspended(i);
        } finally {
            this.f708th.unlock();
        }
    }

    public void zza(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, int i) {
        this.f708th.lock();
        try {
            this.f713uo.zza(connectionResult, api, i);
        } finally {
            this.f708th.unlock();
        }
    }

    void zza(zza zzaVar) {
        this.f711um.sendMessage(this.f711um.obtainMessage(1, zzaVar));
    }

    void zza(RuntimeException runtimeException) {
        this.f711um.sendMessage(this.f711um.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.internal.zzqm
    public boolean zza(zzqy zzqyVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zzaoc() {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zzaoy() {
        if (isConnected()) {
            ((zzqa) this.f713uo).zzaph();
        }
    }

    void zzapw() {
        this.f708th.lock();
        try {
            this.f713uo = new zzqb(this, this.f705tD, this.f706tE, this.f709tp, this.f703rY, this.f708th, this.mContext);
            this.f713uo.begin();
            this.f710ul.signalAll();
        } finally {
            this.f708th.unlock();
        }
    }

    void zzapx() {
        this.f708th.lock();
        try {
            this.f704sX.zzapt();
            this.f713uo = new zzqa(this);
            this.f713uo.begin();
            this.f710ul.signalAll();
        } finally {
            this.f708th.unlock();
        }
    }

    void zzapy() {
        Iterator<Api.zze> it = this.f707tY.values().iterator();
        while (it.hasNext()) {
            it.next().disconnect();
        }
    }

    @Override // com.google.android.gms.internal.zzqm
    public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(@NonNull T t) {
        t.zzaot();
        return (T) this.f713uo.zzc(t);
    }

    @Override // com.google.android.gms.internal.zzqm
    public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(@NonNull T t) {
        t.zzaot();
        return (T) this.f713uo.zzd(t);
    }

    void zzi(ConnectionResult connectionResult) {
        this.f708th.lock();
        try {
            this.f714up = connectionResult;
            this.f713uo = new zzqc(this);
            this.f713uo.begin();
            this.f710ul.signalAll();
        } finally {
            this.f708th.unlock();
        }
    }
}
