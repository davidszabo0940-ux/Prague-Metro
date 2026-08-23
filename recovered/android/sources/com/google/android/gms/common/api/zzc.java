package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzrb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzc<O extends Api.ApiOptions> {
    private final Context mContext;
    private final int mId;

    /* JADX INFO: renamed from: pD */
    private final Api<O> f163pD;

    /* JADX INFO: renamed from: rE */
    private final zzqt f164rE;

    /* JADX INFO: renamed from: rF */
    private final O f165rF;

    /* JADX INFO: renamed from: rG */
    private final zzpo<O> f166rG;

    /* JADX INFO: renamed from: rH */
    private final zzqh f167rH;

    /* JADX INFO: renamed from: rI */
    private final GoogleApiClient f168rI;

    /* JADX INFO: renamed from: rJ */
    private final AtomicBoolean f169rJ;

    /* JADX INFO: renamed from: rK */
    private final AtomicInteger f170rK;
    private final Looper zzahv;

    public zzc(@NonNull Context context, Api<O> api, O o) {
        this(context, api, o, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
    }

    public zzc(@NonNull Context context, Api<O> api, O o, Looper looper) {
        this.f169rJ = new AtomicBoolean(false);
        this.f170rK = new AtomicInteger(0);
        zzab.zzb(context, "Null context is not permitted.");
        zzab.zzb(api, "Api must not be null.");
        zzab.zzb(looper, "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.f163pD = api;
        this.f165rF = o;
        this.zzahv = looper;
        this.f164rE = new zzqt();
        this.f166rG = new zzpo<>(this.f163pD, this.f165rF);
        this.f168rI = new zzqi(this);
        Pair<zzqh, Integer> pairZza = zzqh.zza(this.mContext, (zzc<?>) this);
        this.f167rH = (zzqh) pairZza.first;
        this.mId = ((Integer) pairZza.second).intValue();
    }

    private <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zza(int i, @NonNull T t) {
        t.zzaot();
        this.f167rH.zza(this, i, t);
        return t;
    }

    private <TResult, A extends Api.zzb> Task<TResult> zza(int i, @NonNull zzrb<A, TResult> zzrbVar) {
        TaskCompletionSource<TResult> taskCompletionSource = new TaskCompletionSource<>();
        this.f167rH.zza(this, i, zzrbVar, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public int getInstanceId() {
        return this.mId;
    }

    public Looper getLooper() {
        return this.zzahv;
    }

    public void release() {
        if (this.f169rJ.getAndSet(true)) {
            return;
        }
        this.f164rE.release();
        this.f167rH.zzd(this.mId, this.f170rK.get() > 0);
    }

    public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zza(@NonNull T t) {
        return (T) zza(0, t);
    }

    public <TResult, A extends Api.zzb> Task<TResult> zza(zzrb<A, TResult> zzrbVar) {
        return zza(0, zzrbVar);
    }

    public void zzanu() {
        this.f170rK.incrementAndGet();
    }

    public void zzanv() {
        if (this.f170rK.decrementAndGet() == 0 && this.f169rJ.get()) {
            this.f167rH.zzd(this.mId, false);
        }
    }

    public Api<O> zzanw() {
        return this.f163pD;
    }

    public O zzanx() {
        return this.f165rF;
    }

    public zzpo<O> zzany() {
        return this.f166rG;
    }

    public GoogleApiClient zzanz() {
        return this.f168rI;
    }

    public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzb(@NonNull T t) {
        return (T) zza(1, t);
    }

    public <TResult, A extends Api.zzb> Task<TResult> zzb(zzrb<A, TResult> zzrbVar) {
        return zza(1, zzrbVar);
    }
}
