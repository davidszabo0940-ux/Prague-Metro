package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzpt<R extends Result> extends PendingResult<R> {

    /* JADX INFO: renamed from: sI */
    static final ThreadLocal<Boolean> f590sI = new ThreadLocal<Boolean>() { // from class: com.google.android.gms.internal.zzpt.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: zzaov, reason: merged with bridge method [inline-methods] */
        public Boolean initialValue() {
            return false;
        }
    };

    /* JADX INFO: renamed from: sJ */
    private final Object f591sJ;

    /* JADX INFO: renamed from: sK */
    protected final zza<R> f592sK;

    /* JADX INFO: renamed from: sL */
    protected final WeakReference<GoogleApiClient> f593sL;

    /* JADX INFO: renamed from: sM */
    private final ArrayList<PendingResult.zza> f594sM;

    /* JADX INFO: renamed from: sN */
    private ResultCallback<? super R> f595sN;

    /* JADX INFO: renamed from: sO */
    private zzb f596sO;

    /* JADX INFO: renamed from: sP */
    private volatile boolean f597sP;

    /* JADX INFO: renamed from: sQ */
    private boolean f598sQ;

    /* JADX INFO: renamed from: sR */
    private com.google.android.gms.common.internal.zzr f599sR;

    /* JADX INFO: renamed from: sS */
    private volatile zzrc<R> f600sS;

    /* JADX INFO: renamed from: sT */
    private boolean f601sT;

    /* JADX INFO: renamed from: sc */
    private R f602sc;
    private boolean zzak;
    private final CountDownLatch zzalc;

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    break;
                case 2:
                    ((zzpt) message.obj).zzaa(Status.f154sj);
                    break;
                default:
                    Log.wtf("BasePendingResult", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
                    break;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzpt<R> zzptVar, long j) {
            sendMessageDelayed(obtainMessage(2, zzptVar), j);
        }

        public void zzaow() {
            removeMessages(2);
        }

        protected void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzpt.zze(r);
                throw e;
            }
        }
    }

    private final class zzb {
        private zzb() {
        }

        protected void finalize() throws Throwable {
            zzpt.zze(zzpt.this.f602sc);
            super.finalize();
        }
    }

    @Deprecated
    zzpt() {
        this.f591sJ = new Object();
        this.zzalc = new CountDownLatch(1);
        this.f594sM = new ArrayList<>();
        this.f601sT = false;
        this.f592sK = new zza<>(Looper.getMainLooper());
        this.f593sL = new WeakReference<>(null);
    }

    @Deprecated
    protected zzpt(Looper looper) {
        this.f591sJ = new Object();
        this.zzalc = new CountDownLatch(1);
        this.f594sM = new ArrayList<>();
        this.f601sT = false;
        this.f592sK = new zza<>(looper);
        this.f593sL = new WeakReference<>(null);
    }

    protected zzpt(GoogleApiClient googleApiClient) {
        this.f591sJ = new Object();
        this.zzalc = new CountDownLatch(1);
        this.f594sM = new ArrayList<>();
        this.f601sT = false;
        this.f592sK = new zza<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.f593sL = new WeakReference<>(googleApiClient);
    }

    private R get() {
        R r;
        synchronized (this.f591sJ) {
            com.google.android.gms.common.internal.zzab.zza(this.f597sP ? false : true, "Result has already been consumed.");
            com.google.android.gms.common.internal.zzab.zza(isReady(), "Result is not ready.");
            r = this.f602sc;
            this.f602sc = null;
            this.f595sN = null;
            this.f597sP = true;
        }
        zzaop();
        return r;
    }

    private void zzd(R r) {
        this.f602sc = r;
        this.f599sR = null;
        this.zzalc.countDown();
        Status status = this.f602sc.getStatus();
        if (this.zzak) {
            this.f595sN = null;
        } else if (this.f595sN != null) {
            this.f592sK.zzaow();
            this.f592sK.zza(this.f595sN, get());
        } else if (this.f602sc instanceof Releasable) {
            this.f596sO = new zzb();
        }
        Iterator<PendingResult.zza> it = this.f594sM.iterator();
        while (it.hasNext()) {
            it.next().zzv(status);
        }
        this.f594sM.clear();
    }

    public static void zze(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String strValueOf = String.valueOf(result);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(strValueOf).length() + 18).append("Unable to release ").append(strValueOf).toString(), e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() {
        com.google.android.gms.common.internal.zzab.zza(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        com.google.android.gms.common.internal.zzab.zza(!this.f597sP, "Result has already been consumed");
        com.google.android.gms.common.internal.zzab.zza(this.f600sS == null, "Cannot await if then() has been called.");
        try {
            this.zzalc.await();
        } catch (InterruptedException e) {
            zzaa(Status.f152sh);
        }
        com.google.android.gms.common.internal.zzab.zza(isReady(), "Result is not ready.");
        return (R) get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long j, TimeUnit timeUnit) {
        com.google.android.gms.common.internal.zzab.zza(j <= 0 || Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread when time is greater than zero.");
        com.google.android.gms.common.internal.zzab.zza(!this.f597sP, "Result has already been consumed.");
        com.google.android.gms.common.internal.zzab.zza(this.f600sS == null, "Cannot await if then() has been called.");
        try {
            if (!this.zzalc.await(j, timeUnit)) {
                zzaa(Status.f154sj);
            }
        } catch (InterruptedException e) {
            zzaa(Status.f152sh);
        }
        com.google.android.gms.common.internal.zzab.zza(isReady(), "Result is not ready.");
        return (R) get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        synchronized (this.f591sJ) {
            if (this.zzak || this.f597sP) {
                return;
            }
            if (this.f599sR != null) {
                try {
                    this.f599sR.cancel();
                } catch (RemoteException e) {
                }
            }
            zze(this.f602sc);
            this.zzak = true;
            zzd(zzc(Status.f155sk));
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        boolean z;
        synchronized (this.f591sJ) {
            z = this.zzak;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzalc.getCount() == 0;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        synchronized (this.f591sJ) {
            try {
                if (resultCallback == null) {
                    this.f595sN = null;
                    return;
                }
                com.google.android.gms.common.internal.zzab.zza(!this.f597sP, "Result has already been consumed.");
                com.google.android.gms.common.internal.zzab.zza(this.f600sS == null, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.f592sK.zza(resultCallback, get());
                } else {
                    this.f595sN = resultCallback;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        synchronized (this.f591sJ) {
            try {
                if (resultCallback == null) {
                    this.f595sN = null;
                    return;
                }
                com.google.android.gms.common.internal.zzab.zza(!this.f597sP, "Result has already been consumed.");
                com.google.android.gms.common.internal.zzab.zza(this.f600sS == null, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.f592sK.zza(resultCallback, get());
                } else {
                    this.f595sN = resultCallback;
                    this.f592sK.zza(this, timeUnit.toMillis(j));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> transformedResultThen;
        com.google.android.gms.common.internal.zzab.zza(!this.f597sP, "Result has already been consumed.");
        synchronized (this.f591sJ) {
            com.google.android.gms.common.internal.zzab.zza(this.f600sS == null, "Cannot call then() twice.");
            com.google.android.gms.common.internal.zzab.zza(this.f595sN == null, "Cannot call then() if callbacks are set.");
            this.f601sT = true;
            this.f600sS = new zzrc<>(this.f593sL);
            transformedResultThen = this.f600sS.then(resultTransform);
            if (isReady()) {
                this.f592sK.zza(this.f600sS, get());
            } else {
                this.f595sN = this.f600sS;
            }
        }
        return transformedResultThen;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void zza(PendingResult.zza zzaVar) {
        com.google.android.gms.common.internal.zzab.zza(!this.f597sP, "Result has already been consumed.");
        com.google.android.gms.common.internal.zzab.zzb(zzaVar != null, "Callback cannot be null.");
        synchronized (this.f591sJ) {
            if (isReady()) {
                zzaVar.zzv(this.f602sc.getStatus());
            } else {
                this.f594sM.add(zzaVar);
            }
        }
    }

    protected final void zza(com.google.android.gms.common.internal.zzr zzrVar) {
        synchronized (this.f591sJ) {
            this.f599sR = zzrVar;
        }
    }

    public final void zzaa(Status status) {
        synchronized (this.f591sJ) {
            if (!isReady()) {
                zzc(zzc(status));
                this.f598sQ = true;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public Integer zzaog() {
        return null;
    }

    protected void zzaop() {
    }

    public boolean zzaos() {
        boolean zIsCanceled;
        synchronized (this.f591sJ) {
            if (this.f593sL.get() == null || !this.f601sT) {
                cancel();
            }
            zIsCanceled = isCanceled();
        }
        return zIsCanceled;
    }

    public void zzaot() {
        this.f601sT = this.f601sT || f590sI.get().booleanValue();
    }

    boolean zzaou() {
        return false;
    }

    protected abstract R zzc(Status status);

    public final void zzc(R r) {
        synchronized (this.f591sJ) {
            if (this.f598sQ || this.zzak || (isReady() && zzaou())) {
                zze(r);
                return;
            }
            com.google.android.gms.common.internal.zzab.zza(!isReady(), "Results have already been set");
            com.google.android.gms.common.internal.zzab.zza(this.f597sP ? false : true, "Result has already been consumed");
            zzd(r);
        }
    }
}
