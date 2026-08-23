package com.google.android.gms.ads.internal;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzr {
    private final zza zzamz;

    @Nullable
    private AdRequestParcel zzana;
    private boolean zzanb;
    private boolean zzanc;
    private long zzand;
    private final Runnable zzw;

    public static class zza {
        private final Handler mHandler;

        public zza(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long j) {
            return this.mHandler.postDelayed(runnable, j);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public zzr(com.google.android.gms.ads.internal.zza zzaVar) {
        this(zzaVar, new zza(zzkl.zzclg));
    }

    zzr(com.google.android.gms.ads.internal.zza zzaVar, zza zzaVar2) {
        this.zzanb = false;
        this.zzanc = false;
        this.zzand = 0L;
        this.zzamz = zzaVar2;
        final WeakReference weakReference = new WeakReference(zzaVar);
        this.zzw = new Runnable() { // from class: com.google.android.gms.ads.internal.zzr.1
            @Override // java.lang.Runnable
            public void run() {
                zzr.this.zzanb = false;
                com.google.android.gms.ads.internal.zza zzaVar3 = (com.google.android.gms.ads.internal.zza) weakReference.get();
                if (zzaVar3 != null) {
                    zzaVar3.zzd(zzr.this.zzana);
                }
            }
        };
    }

    public void cancel() {
        this.zzanb = false;
        this.zzamz.removeCallbacks(this.zzw);
    }

    public void pause() {
        this.zzanc = true;
        if (this.zzanb) {
            this.zzamz.removeCallbacks(this.zzw);
        }
    }

    public void resume() {
        this.zzanc = false;
        if (this.zzanb) {
            this.zzanb = false;
            zza(this.zzana, this.zzand);
        }
    }

    public void zza(AdRequestParcel adRequestParcel, long j) {
        if (this.zzanb) {
            zzkh.zzcy("An ad refresh is already scheduled.");
            return;
        }
        this.zzana = adRequestParcel;
        this.zzanb = true;
        this.zzand = j;
        if (this.zzanc) {
            return;
        }
        zzkh.zzcx(new StringBuilder(65).append("Scheduling ad refresh ").append(j).append(" milliseconds from now.").toString());
        this.zzamz.postDelayed(this.zzw, j);
    }

    public boolean zzfc() {
        return this.zzanb;
    }

    public void zzg(AdRequestParcel adRequestParcel) {
        zza(adRequestParcel, 60000L);
    }
}
