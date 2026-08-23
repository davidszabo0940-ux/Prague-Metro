package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzif extends zzkg {
    protected final Context mContext;
    protected final Object zzail;
    protected final zzig.zza zzbxu;
    protected final zzjy.zza zzbxv;
    protected AdResponseParcel zzbxw;
    protected final Object zzbxy;

    protected static final class zza extends Exception {
        private final int zzbym;

        public zza(String str, int i) {
            super(str);
            this.zzbym = i;
        }

        public int getErrorCode() {
            return this.zzbym;
        }
    }

    protected zzif(Context context, zzjy.zza zzaVar, zzig.zza zzaVar2) {
        super(true);
        this.zzail = new Object();
        this.zzbxy = new Object();
        this.mContext = context;
        this.zzbxv = zzaVar;
        this.zzbxw = zzaVar.zzciu;
        this.zzbxu = zzaVar2;
    }

    @Override // com.google.android.gms.internal.zzkg
    public void onStop() {
    }

    protected abstract zzjy zzak(int i);

    @Override // com.google.android.gms.internal.zzkg
    public void zzew() {
        synchronized (this.zzail) {
            zzkh.zzcw("AdRendererBackgroundTask started.");
            int i = this.zzbxv.errorCode;
            try {
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                int errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzkh.zzcx(e.getMessage());
                } else {
                    zzkh.zzcy(e.getMessage());
                }
                if (this.zzbxw == null) {
                    this.zzbxw = new AdResponseParcel(errorCode);
                } else {
                    this.zzbxw = new AdResponseParcel(errorCode, this.zzbxw.zzbnw);
                }
                zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzif.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zzif.this.onStop();
                    }
                });
                i = errorCode;
            }
            final zzjy zzjyVarZzak = zzak(i);
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzif.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzif.this.zzail) {
                        zzif.this.zzm(zzjyVarZzak);
                    }
                }
            });
        }
    }

    protected abstract void zzh(long j) throws zza;

    protected void zzm(zzjy zzjyVar) {
        this.zzbxu.zzb(zzjyVar);
    }
}
