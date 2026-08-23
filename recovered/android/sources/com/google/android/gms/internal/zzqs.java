package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class zzqs<L> {
    private volatile L mListener;

    /* JADX INFO: renamed from: vg */
    private final zza f769vg;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.google.android.gms.common.internal.zzab.zzbn(message.what == 1);
            zzqs.this.zzb((zzb) message.obj);
        }
    }

    public interface zzb<L> {
        void zzapg();

        void zzu(L l);
    }

    zzqs(Looper looper, L l) {
        this.f769vg = new zza(looper);
        this.mListener = (L) com.google.android.gms.common.internal.zzab.zzb(l, "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> zzbVar) {
        com.google.android.gms.common.internal.zzab.zzb(zzbVar, "Notifier must not be null");
        this.f769vg.sendMessage(this.f769vg.obtainMessage(1, zzbVar));
    }

    void zzb(zzb<? super L> zzbVar) {
        L l = this.mListener;
        if (l == null) {
            zzbVar.zzapg();
            return;
        }
        try {
            zzbVar.zzu(l);
        } catch (RuntimeException e) {
            zzbVar.zzapg();
            throw e;
        }
    }
}
