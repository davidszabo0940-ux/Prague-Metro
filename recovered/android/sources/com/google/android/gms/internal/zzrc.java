package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class zzrc<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {

    /* JADX INFO: renamed from: sL */
    private final WeakReference<GoogleApiClient> f782sL;

    /* JADX INFO: renamed from: vp */
    private final zza f788vp;

    /* JADX INFO: renamed from: vk */
    private ResultTransform<? super R, ? extends Result> f783vk = null;

    /* JADX INFO: renamed from: vl */
    private zzrc<? extends Result> f784vl = null;

    /* JADX INFO: renamed from: vm */
    private volatile ResultCallbacks<? super R> f785vm = null;

    /* JADX INFO: renamed from: vn */
    private PendingResult<R> f786vn = null;

    /* JADX INFO: renamed from: sJ */
    private final Object f781sJ = new Object();

    /* JADX INFO: renamed from: vo */
    private Status f787vo = null;

    /* JADX INFO: renamed from: vq */
    private boolean f789vq = false;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    PendingResult<?> pendingResult = (PendingResult) message.obj;
                    synchronized (zzrc.this.f781sJ) {
                        try {
                            if (pendingResult == null) {
                                zzrc.this.f784vl.zzac(new Status(13, "Transform returned null"));
                            } else if (pendingResult instanceof zzqx) {
                                zzrc.this.f784vl.zzac(((zzqx) pendingResult).getStatus());
                            } else {
                                zzrc.this.f784vl.zza(pendingResult);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String strValueOf = String.valueOf(runtimeException.getMessage());
                    Log.e("TransformedResultImpl", strValueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(strValueOf) : new String("Runtime exception on the transformation worker thread: "));
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", new StringBuilder(70).append("TransformationResultHandler received unknown message type: ").append(message.what).toString());
                    return;
            }
        }
    }

    public zzrc(WeakReference<GoogleApiClient> weakReference) {
        com.google.android.gms.common.internal.zzab.zzb(weakReference, "GoogleApiClient reference must not be null");
        this.f782sL = weakReference;
        GoogleApiClient googleApiClient = this.f782sL.get();
        this.f788vp = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzac(Status status) {
        synchronized (this.f781sJ) {
            this.f787vo = status;
            zzad(this.f787vo);
        }
    }

    private void zzad(Status status) {
        synchronized (this.f781sJ) {
            if (this.f783vk != null) {
                Status statusOnFailure = this.f783vk.onFailure(status);
                com.google.android.gms.common.internal.zzab.zzb(statusOnFailure, "onFailure must not return null");
                this.f784vl.zzac(statusOnFailure);
            } else if (zzaqu()) {
                this.f785vm.onFailure(status);
            }
        }
    }

    private void zzaqs() {
        if (this.f783vk == null && this.f785vm == null) {
            return;
        }
        GoogleApiClient googleApiClient = this.f782sL.get();
        if (!this.f789vq && this.f783vk != null && googleApiClient != null) {
            googleApiClient.zza(this);
            this.f789vq = true;
        }
        if (this.f787vo != null) {
            zzad(this.f787vo);
        } else if (this.f786vn != null) {
            this.f786vn.setResultCallback(this);
        }
    }

    private boolean zzaqu() {
        return (this.f785vm == null || this.f782sL.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zze(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String strValueOf = String.valueOf(result);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(strValueOf).length() + 18).append("Unable to release ").append(strValueOf).toString(), e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.f781sJ) {
            com.google.android.gms.common.internal.zzab.zza(this.f785vm == null, "Cannot call andFinally() twice.");
            com.google.android.gms.common.internal.zzab.zza(this.f783vk == null, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f785vm = resultCallbacks;
            zzaqs();
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(final R r) {
        synchronized (this.f781sJ) {
            if (!r.getStatus().isSuccess()) {
                zzac(r.getStatus());
                zze(r);
            } else if (this.f783vk != null) {
                zzqw.zzapz().submit(new Runnable() { // from class: com.google.android.gms.internal.zzrc.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    @WorkerThread
                    public void run() {
                        try {
                            zzpt.f590sI.set(true);
                            zzrc.this.f788vp.sendMessage(zzrc.this.f788vp.obtainMessage(0, zzrc.this.f783vk.onSuccess(r)));
                        } catch (RuntimeException e) {
                            zzrc.this.f788vp.sendMessage(zzrc.this.f788vp.obtainMessage(1, e));
                        } finally {
                            zzpt.f590sI.set(false);
                            zzrc.this.zze(r);
                            GoogleApiClient googleApiClient = (GoogleApiClient) zzrc.this.f782sL.get();
                            if (googleApiClient != null) {
                                googleApiClient.zzb(zzrc.this);
                            }
                        }
                    }
                });
            } else if (zzaqu()) {
                this.f785vm.onSuccess(r);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        zzrc<? extends Result> zzrcVar;
        synchronized (this.f781sJ) {
            com.google.android.gms.common.internal.zzab.zza(this.f783vk == null, "Cannot call then() twice.");
            com.google.android.gms.common.internal.zzab.zza(this.f785vm == null, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f783vk = resultTransform;
            zzrcVar = new zzrc<>(this.f782sL);
            this.f784vl = zzrcVar;
            zzaqs();
        }
        return zzrcVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.f781sJ) {
            this.f786vn = pendingResult;
            zzaqs();
        }
    }

    void zzaqt() {
        this.f785vm = null;
    }
}
