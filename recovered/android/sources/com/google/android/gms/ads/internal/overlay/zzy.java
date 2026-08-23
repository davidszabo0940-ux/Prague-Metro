package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkl;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzy implements Runnable {
    private boolean mCancelled = false;
    private zzk zzbwj;

    zzy(zzk zzkVar) {
        this.zzbwj = zzkVar;
    }

    public void cancel() {
        this.mCancelled = true;
        zzkl.zzclg.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mCancelled) {
            return;
        }
        this.zzbwj.zzoq();
        zzpm();
    }

    public void zzpm() {
        zzkl.zzclg.postDelayed(this, 250L);
    }
}
