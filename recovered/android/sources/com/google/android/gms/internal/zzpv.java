package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class zzpv implements zzqm {
    private final Context mContext;

    /* JADX INFO: renamed from: sX */
    private final zzqd f607sX;

    /* JADX INFO: renamed from: sY */
    private final zzqf f608sY;

    /* JADX INFO: renamed from: sZ */
    private final zzqf f609sZ;

    /* JADX INFO: renamed from: ta */
    private final Map<Api.zzc<?>, zzqf> f610ta;

    /* JADX INFO: renamed from: tc */
    private final Api.zze f612tc;

    /* JADX INFO: renamed from: td */
    private Bundle f613td;

    /* JADX INFO: renamed from: th */
    private final Lock f617th;
    private final Looper zzahv;

    /* JADX INFO: renamed from: tb */
    private final Set<zzqy> f611tb = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: te */
    private ConnectionResult f614te = null;

    /* JADX INFO: renamed from: tf */
    private ConnectionResult f615tf = null;

    /* JADX INFO: renamed from: tg */
    private boolean f616tg = false;

    /* JADX INFO: renamed from: ti */
    private int f618ti = 0;

    private class zza implements zzqm.zza {
        private zza() {
        }

        @Override // com.google.android.gms.internal.zzqm.zza
        public void zzc(int i, boolean z) {
            zzpv.this.f617th.lock();
            try {
                if (zzpv.this.f616tg || zzpv.this.f615tf == null || !zzpv.this.f615tf.isSuccess()) {
                    zzpv.this.f616tg = false;
                    zzpv.this.zzb(i, z);
                } else {
                    zzpv.this.f616tg = true;
                    zzpv.this.f609sZ.onConnectionSuspended(i);
                }
            } finally {
                zzpv.this.f617th.unlock();
            }
        }

        @Override // com.google.android.gms.internal.zzqm.zza
        public void zzd(@NonNull ConnectionResult connectionResult) {
            zzpv.this.f617th.lock();
            try {
                zzpv.this.f614te = connectionResult;
                zzpv.this.zzapb();
            } finally {
                zzpv.this.f617th.unlock();
            }
        }

        @Override // com.google.android.gms.internal.zzqm.zza
        public void zzm(@Nullable Bundle bundle) {
            zzpv.this.f617th.lock();
            try {
                zzpv.this.zzl(bundle);
                zzpv.this.f614te = ConnectionResult.f104qR;
                zzpv.this.zzapb();
            } finally {
                zzpv.this.f617th.unlock();
            }
        }
    }

    private class zzb implements zzqm.zza {
        private zzb() {
        }

        @Override // com.google.android.gms.internal.zzqm.zza
        public void zzc(int i, boolean z) {
            zzpv.this.f617th.lock();
            try {
                if (zzpv.this.f616tg) {
                    zzpv.this.f616tg = false;
                    zzpv.this.zzb(i, z);
                } else {
                    zzpv.this.f616tg = true;
                    zzpv.this.f608sY.onConnectionSuspended(i);
                }
            } finally {
                zzpv.this.f617th.unlock();
            }
        }

        @Override // com.google.android.gms.internal.zzqm.zza
        public void zzd(@NonNull ConnectionResult connectionResult) {
            zzpv.this.f617th.lock();
            try {
                zzpv.this.f615tf = connectionResult;
                zzpv.this.zzapb();
            } finally {
                zzpv.this.f617th.unlock();
            }
        }

        @Override // com.google.android.gms.internal.zzqm.zza
        public void zzm(@Nullable Bundle bundle) {
            zzpv.this.f617th.lock();
            try {
                zzpv.this.f615tf = ConnectionResult.f104qR;
                zzpv.this.zzapb();
            } finally {
                zzpv.this.f617th.unlock();
            }
        }
    }

    private zzpv(Context context, zzqd zzqdVar, Lock lock, Looper looper, com.google.android.gms.common.zzc zzcVar, Map<Api.zzc<?>, Api.zze> map, Map<Api.zzc<?>, Api.zze> map2, com.google.android.gms.common.internal.zzg zzgVar, Api.zza<? extends zzvx, zzvy> zzaVar, Api.zze zzeVar, ArrayList<zzpu> arrayList, ArrayList<zzpu> arrayList2, Map<Api<?>, Integer> map3, Map<Api<?>, Integer> map4) {
        this.mContext = context;
        this.f607sX = zzqdVar;
        this.f617th = lock;
        this.zzahv = looper;
        this.f612tc = zzeVar;
        this.f608sY = new zzqf(context, this.f607sX, lock, looper, zzcVar, map2, null, map4, null, arrayList2, new zza());
        this.f609sZ = new zzqf(context, this.f607sX, lock, looper, zzcVar, map, zzgVar, map3, zzaVar, arrayList, new zzb());
        ArrayMap arrayMap = new ArrayMap();
        Iterator<Api.zzc<?>> it = map2.keySet().iterator();
        while (it.hasNext()) {
            arrayMap.put(it.next(), this.f608sY);
        }
        Iterator<Api.zzc<?>> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            arrayMap.put(it2.next(), this.f609sZ);
        }
        this.f610ta = Collections.unmodifiableMap(arrayMap);
    }

    public static zzpv zza(Context context, zzqd zzqdVar, Lock lock, Looper looper, com.google.android.gms.common.zzc zzcVar, Map<Api.zzc<?>, Api.zze> map, com.google.android.gms.common.internal.zzg zzgVar, Map<Api<?>, Integer> map2, Api.zza<? extends zzvx, zzvy> zzaVar, ArrayList<zzpu> arrayList) {
        Api.zze zzeVar = null;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        for (Map.Entry<Api.zzc<?>, Api.zze> entry : map.entrySet()) {
            Api.zze value = entry.getValue();
            if (value.zzafz()) {
                zzeVar = value;
            }
            if (value.zzafk()) {
                arrayMap.put(entry.getKey(), value);
            } else {
                arrayMap2.put(entry.getKey(), value);
            }
        }
        com.google.android.gms.common.internal.zzab.zza(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api<?> api : map2.keySet()) {
            Api.zzc<?> zzcVarZzanp = api.zzanp();
            if (arrayMap.containsKey(zzcVarZzanp)) {
                arrayMap3.put(api, map2.get(api));
            } else {
                if (!arrayMap2.containsKey(zzcVarZzanp)) {
                    throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
                }
                arrayMap4.put(api, map2.get(api));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (zzpu zzpuVar : arrayList) {
            if (arrayMap3.containsKey(zzpuVar.f604pD)) {
                arrayList2.add(zzpuVar);
            } else {
                if (!arrayMap4.containsKey(zzpuVar.f604pD)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
                }
                arrayList3.add(zzpuVar);
            }
        }
        return new zzpv(context, zzqdVar, lock, looper, zzcVar, arrayMap, arrayMap2, zzgVar, zzaVar, zzeVar, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private void zzapa() {
        this.f615tf = null;
        this.f614te = null;
        this.f608sY.connect();
        this.f609sZ.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzapb() {
        if (zzc(this.f614te)) {
            if (zzc(this.f615tf) || zzape()) {
                zzapc();
                return;
            }
            if (this.f615tf != null) {
                if (this.f618ti == 1) {
                    zzapd();
                    return;
                } else {
                    zzb(this.f615tf);
                    this.f608sY.disconnect();
                    return;
                }
            }
            return;
        }
        if (this.f614te != null && zzc(this.f615tf)) {
            this.f609sZ.disconnect();
            zzb(this.f614te);
        } else {
            if (this.f614te == null || this.f615tf == null) {
                return;
            }
            ConnectionResult connectionResult = this.f614te;
            if (this.f609sZ.f715uq < this.f608sY.f715uq) {
                connectionResult = this.f615tf;
            }
            zzb(connectionResult);
        }
    }

    private void zzapc() {
        switch (this.f618ti) {
            case 2:
                this.f607sX.zzm(this.f613td);
            case 1:
                zzapd();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                break;
        }
        this.f618ti = 0;
    }

    private void zzapd() {
        Iterator<zzqy> it = this.f611tb.iterator();
        while (it.hasNext()) {
            it.next().zzafy();
        }
        this.f611tb.clear();
    }

    private boolean zzape() {
        return this.f615tf != null && this.f615tf.getErrorCode() == 4;
    }

    @Nullable
    private PendingIntent zzapf() {
        if (this.f612tc == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, this.f607sX.getSessionId(), this.f612tc.zzaga(), 134217728);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(int i, boolean z) {
        this.f607sX.zzc(i, z);
        this.f615tf = null;
        this.f614te = null;
    }

    private void zzb(ConnectionResult connectionResult) {
        switch (this.f618ti) {
            case 2:
                this.f607sX.zzd(connectionResult);
            case 1:
                zzapd();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        this.f618ti = 0;
    }

    private static boolean zzc(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private boolean zze(zzpr.zza<? extends Result, ? extends Api.zzb> zzaVar) {
        Object objZzanp = zzaVar.zzanp();
        com.google.android.gms.common.internal.zzab.zzb(this.f610ta.containsKey(objZzanp), "GoogleApiClient is not configured to use the API required for this call.");
        return this.f610ta.get(objZzanp).equals(this.f609sZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzl(Bundle bundle) {
        if (this.f613td == null) {
            this.f613td = bundle;
        } else if (bundle != null) {
            this.f613td.putAll(bundle);
        }
    }

    @Override // com.google.android.gms.internal.zzqm
    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.zzqm
    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.zzqm
    public void connect() {
        this.f618ti = 2;
        this.f616tg = false;
        zzapa();
    }

    @Override // com.google.android.gms.internal.zzqm
    public void disconnect() {
        this.f615tf = null;
        this.f614te = null;
        this.f618ti = 0;
        this.f608sY.disconnect();
        this.f609sZ.disconnect();
        zzapd();
    }

    @Override // com.google.android.gms.internal.zzqm
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.f609sZ.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f608sY.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.internal.zzqm
    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        if (this.f610ta.get(api.zzanp()).equals(this.f609sZ)) {
            return zzape() ? new ConnectionResult(4, zzapf()) : this.f609sZ.getConnectionResult(api);
        }
        return this.f608sY.getConnectionResult(api);
    }

    @Override // com.google.android.gms.internal.zzqm
    public boolean isConnected() {
        boolean z = true;
        this.f617th.lock();
        try {
            if (!this.f608sY.isConnected() || (!zzaoz() && !zzape() && this.f618ti != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.f617th.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzqm
    public boolean isConnecting() {
        this.f617th.lock();
        try {
            return this.f618ti == 2;
        } finally {
            this.f617th.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzqm
    public boolean zza(zzqy zzqyVar) {
        this.f617th.lock();
        try {
            if ((!isConnecting() && !isConnected()) || zzaoz()) {
                return false;
            }
            this.f611tb.add(zzqyVar);
            if (this.f618ti == 0) {
                this.f618ti = 1;
            }
            this.f615tf = null;
            this.f609sZ.connect();
            return true;
        } finally {
            this.f617th.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zzaoc() {
        this.f617th.lock();
        try {
            boolean zIsConnecting = isConnecting();
            this.f609sZ.disconnect();
            this.f615tf = new ConnectionResult(4);
            if (zIsConnecting) {
                new Handler(this.zzahv).post(new Runnable() { // from class: com.google.android.gms.internal.zzpv.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zzpv.this.f617th.lock();
                        try {
                            zzpv.this.zzapb();
                        } finally {
                            zzpv.this.f617th.unlock();
                        }
                    }
                });
            } else {
                zzapd();
            }
        } finally {
            this.f617th.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zzaoy() {
        this.f608sY.zzaoy();
        this.f609sZ.zzaoy();
    }

    public boolean zzaoz() {
        return this.f609sZ.isConnected();
    }

    @Override // com.google.android.gms.internal.zzqm
    public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(@NonNull T t) {
        if (!zze((zzpr.zza<? extends Result, ? extends Api.zzb>) t)) {
            return (T) this.f608sY.zzc(t);
        }
        if (!zzape()) {
            return (T) this.f609sZ.zzc(t);
        }
        t.zzz(new Status(4, null, zzapf()));
        return t;
    }

    @Override // com.google.android.gms.internal.zzqm
    public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(@NonNull T t) {
        if (!zze((zzpr.zza<? extends Result, ? extends Api.zzb>) t)) {
            return (T) this.f608sY.zzd(t);
        }
        if (!zzape()) {
            return (T) this.f609sZ.zzd(t);
        }
        t.zzz(new Status(4, null, zzapf()));
        return t;
    }
}
