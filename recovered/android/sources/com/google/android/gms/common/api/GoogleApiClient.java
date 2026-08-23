package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzqd;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.internal.zzqs;
import com.google.android.gms.internal.zzqy;
import com.google.android.gms.internal.zzrc;
import com.google.android.gms.internal.zzvw;
import com.google.android.gms.internal.zzvx;
import com.google.android.gms.internal.zzvy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;

    /* JADX INFO: renamed from: rM */
    private static final Set<GoogleApiClient> f130rM = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {

        /* JADX INFO: renamed from: aP */
        private Account f131aP;

        /* JADX INFO: renamed from: cb */
        private String f132cb;
        private final Context mContext;

        /* JADX INFO: renamed from: rN */
        private final Set<Scope> f133rN;

        /* JADX INFO: renamed from: rO */
        private final Set<Scope> f134rO;

        /* JADX INFO: renamed from: rP */
        private int f135rP;

        /* JADX INFO: renamed from: rQ */
        private View f136rQ;

        /* JADX INFO: renamed from: rR */
        private String f137rR;

        /* JADX INFO: renamed from: rS */
        private final Map<Api<?>, zzg.zza> f138rS;

        /* JADX INFO: renamed from: rT */
        private final Map<Api<?>, Api.ApiOptions> f139rT;

        /* JADX INFO: renamed from: rU */
        private zzqn f140rU;

        /* JADX INFO: renamed from: rV */
        private int f141rV;

        /* JADX INFO: renamed from: rW */
        private OnConnectionFailedListener f142rW;

        /* JADX INFO: renamed from: rX */
        private GoogleApiAvailability f143rX;

        /* JADX INFO: renamed from: rY */
        private Api.zza<? extends zzvx, zzvy> f144rY;

        /* JADX INFO: renamed from: rZ */
        private final ArrayList<ConnectionCallbacks> f145rZ;

        /* JADX INFO: renamed from: sa */
        private final ArrayList<OnConnectionFailedListener> f146sa;
        private Looper zzahv;

        public Builder(@NonNull Context context) {
            this.f133rN = new HashSet();
            this.f134rO = new HashSet();
            this.f138rS = new ArrayMap();
            this.f139rT = new ArrayMap();
            this.f141rV = -1;
            this.f143rX = GoogleApiAvailability.getInstance();
            this.f144rY = zzvw.f857bO;
            this.f145rZ = new ArrayList<>();
            this.f146sa = new ArrayList<>();
            this.mContext = context;
            this.zzahv = context.getMainLooper();
            this.f132cb = context.getPackageName();
            this.f137rR = context.getClass().getName();
        }

        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzab.zzb(connectionCallbacks, "Must provide a connected listener");
            this.f145rZ.add(connectionCallbacks);
            zzab.zzb(onConnectionFailedListener, "Must provide a connection failed listener");
            this.f146sa.add(onConnectionFailedListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <C extends Api.zze, O> C zza(Api.zza<C, O> zzaVar, Object obj, Context context, Looper looper, zzg zzgVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return (C) zzaVar.zza(context, looper, zzgVar, obj, connectionCallbacks, onConnectionFailedListener);
        }

        private Builder zza(@NonNull zzqn zzqnVar, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            zzab.zzb(i >= 0, "clientId must be non-negative");
            this.f141rV = i;
            this.f142rW = onConnectionFailedListener;
            this.f140rU = zzqnVar;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <C extends Api.zzg, O> zzah zza(Api.zzh<C, O> zzhVar, Object obj, Context context, Looper looper, zzg zzgVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzah(context, looper, zzhVar.zzant(), connectionCallbacks, onConnectionFailedListener, zzgVar, zzhVar.zzs(obj));
        }

        private <O extends Api.ApiOptions> void zza(Api<O> api, O o, int i, Scope... scopeArr) {
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalArgumentException(new StringBuilder(90).append("Invalid resolution mode: '").append(i).append("', use a constant from GoogleApiClient.ResolutionMode").toString());
                }
                z = false;
            }
            HashSet hashSet = new HashSet(api.zzanm().zzq(o));
            for (Scope scope : scopeArr) {
                hashSet.add(scope);
            }
            this.f138rS.put(api, new zzg.zza(hashSet, z));
        }

        private GoogleApiClient zzaof() {
            Api.zze zzeVarZza;
            Api<?> api;
            zzg zzgVarZzaoe = zzaoe();
            Api<?> api2 = null;
            Map<Api<?>, zzg.zza> mapZzash = zzgVarZzaoe.zzash();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api<?> api3 = null;
            for (Api<?> api4 : this.f139rT.keySet()) {
                Api.ApiOptions apiOptions = this.f139rT.get(api4);
                int i = mapZzash.get(api4) != null ? mapZzash.get(api4).f338yc ? 1 : 2 : 0;
                arrayMap.put(api4, Integer.valueOf(i));
                zzpu zzpuVar = new zzpu(api4, i);
                arrayList.add(zzpuVar);
                if (api4.zzanq()) {
                    Api.zzh<?, O> zzhVarZzano = api4.zzano();
                    Api<?> api5 = zzhVarZzano.getPriority() == 1 ? api4 : api3;
                    zzeVarZza = zza(zzhVarZzano, apiOptions, this.mContext, this.zzahv, zzgVarZzaoe, zzpuVar, zzpuVar);
                    api = api5;
                } else {
                    Api.zza<?, O> zzaVarZzann = api4.zzann();
                    Api<?> api6 = zzaVarZzann.getPriority() == 1 ? api4 : api3;
                    zzeVarZza = zza((Api.zza<Api.zze, O>) zzaVarZzann, (Object) apiOptions, this.mContext, this.zzahv, zzgVarZzaoe, (ConnectionCallbacks) zzpuVar, (OnConnectionFailedListener) zzpuVar);
                    api = api6;
                }
                arrayMap2.put(api4.zzanp(), zzeVarZza);
                if (!zzeVarZza.zzafz()) {
                    api4 = api2;
                } else if (api2 != null) {
                    String strValueOf = String.valueOf(api4.getName());
                    String strValueOf2 = String.valueOf(api2.getName());
                    throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 21 + String.valueOf(strValueOf2).length()).append(strValueOf).append(" cannot be used with ").append(strValueOf2).toString());
                }
                api3 = api;
                api2 = api4;
            }
            if (api2 != null) {
                if (api3 != null) {
                    String strValueOf3 = String.valueOf(api2.getName());
                    String strValueOf4 = String.valueOf(api3.getName());
                    throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf3).length() + 21 + String.valueOf(strValueOf4).length()).append(strValueOf3).append(" cannot be used with ").append(strValueOf4).toString());
                }
                zzab.zza(this.f131aP == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api2.getName());
                zzab.zza(this.f133rN.equals(this.f134rO), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api2.getName());
            }
            return new zzqd(this.mContext, new ReentrantLock(), this.zzahv, zzgVarZzaoe, this.f143rX, this.f144rY, arrayMap, this.f145rZ, this.f146sa, arrayMap2, this.f141rV, zzqd.zza(arrayMap2.values(), true), arrayList);
        }

        private void zzf(GoogleApiClient googleApiClient) {
            zzpp.zza(this.f140rU).zza(this.f141rV, googleApiClient, this.f142rW);
        }

        public Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzab.zzb(api, "Api must not be null");
            this.f139rT.put(api, null);
            List<Scope> listZzq = api.zzanm().zzq(null);
            this.f134rO.addAll(listZzq);
            this.f133rN.addAll(listZzq);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> api, @NonNull O o) {
            zzab.zzb(api, "Api must not be null");
            zzab.zzb(o, "Null options are not permitted for this Api");
            this.f139rT.put(api, o);
            List<Scope> listZzq = api.zzanm().zzq(o);
            this.f134rO.addAll(listZzq);
            this.f133rN.addAll(listZzq);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> api, @NonNull O o, Scope... scopeArr) {
            zzab.zzb(api, "Api must not be null");
            zzab.zzb(o, "Null options are not permitted for this Api");
            this.f139rT.put(api, o);
            zza(api, o, 1, scopeArr);
            return this;
        }

        public Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            zzab.zzb(api, "Api must not be null");
            this.f139rT.put(api, null);
            zza(api, null, 1, scopeArr);
            return this;
        }

        public Builder addConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
            zzab.zzb(connectionCallbacks, "Listener must not be null");
            this.f145rZ.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
            zzab.zzb(onConnectionFailedListener, "Listener must not be null");
            this.f146sa.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(@NonNull Scope scope) {
            zzab.zzb(scope, "Scope must not be null");
            this.f133rN.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzab.zzb(!this.f139rT.isEmpty(), "must call addApi() to add at least one API");
            GoogleApiClient googleApiClientZzaof = zzaof();
            synchronized (GoogleApiClient.f130rM) {
                GoogleApiClient.f130rM.add(googleApiClientZzaof);
            }
            if (this.f141rV >= 0) {
                zzf(googleApiClientZzaof);
            }
            return googleApiClientZzaof;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            return zza(new zzqn(fragmentActivity), i, onConnectionFailedListener);
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        }

        public Builder setAccountName(String str) {
            this.f131aP = str == null ? null : new Account(str, "com.google");
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.f135rP = i;
            return this;
        }

        public Builder setHandler(@NonNull Handler handler) {
            zzab.zzb(handler, "Handler must not be null");
            this.zzahv = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(@NonNull View view) {
            zzab.zzb(view, "View must not be null");
            this.f136rQ = view;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzg zzaoe() {
            zzvy zzvyVar = zzvy.aul;
            if (this.f139rT.containsKey(zzvw.API)) {
                zzvyVar = (zzvy) this.f139rT.get(zzvw.API);
            }
            return new zzg(this.f131aP, this.f133rN, this.f138rS, this.f135rP, this.f136rQ, this.f132cb, this.f137rR, zzvyVar);
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (f130rM) {
            String strConcat = String.valueOf(str).concat("  ");
            int i = 0;
            for (GoogleApiClient googleApiClient : f130rM) {
                printWriter.append((CharSequence) str).append("GoogleApiClient#").println(i);
                googleApiClient.dump(strConcat, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public static Set<GoogleApiClient> zzaob() {
        Set<GoogleApiClient> set;
        synchronized (f130rM) {
            set = f130rM;
        }
        return set;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @NonNull
    public abstract ConnectionResult getConnectionResult(@NonNull Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(@NonNull Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(@NonNull FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @NonNull
    public <C extends Api.zze> C zza(@NonNull Api.zzc<C> zzcVar) {
        throw new UnsupportedOperationException();
    }

    public void zza(zzrc zzrcVar) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(@NonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzqy zzqyVar) {
        throw new UnsupportedOperationException();
    }

    public void zzaoc() {
        throw new UnsupportedOperationException();
    }

    public void zzb(zzrc zzrcVar) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <L> zzqs<L> zzt(@NonNull L l) {
        throw new UnsupportedOperationException();
    }
}
