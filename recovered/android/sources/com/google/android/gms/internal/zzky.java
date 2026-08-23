package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzky {
    private final View mView;
    private Activity zzcmz;
    private boolean zzcna;
    private boolean zzcnb;
    private boolean zzcnc;
    private ViewTreeObserver.OnGlobalLayoutListener zzcnd;
    private ViewTreeObserver.OnScrollChangedListener zzcne;

    public zzky(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzcmz = activity;
        this.mView = view;
        this.zzcnd = onGlobalLayoutListener;
        this.zzcne = onScrollChangedListener;
    }

    private void zztv() {
        if (this.zzcna) {
            return;
        }
        if (this.zzcnd != null) {
            if (this.zzcmz != null) {
                com.google.android.gms.ads.internal.zzu.zzfq().zza(this.zzcmz, this.zzcnd);
            }
            com.google.android.gms.ads.internal.zzu.zzgk().zza(this.mView, this.zzcnd);
        }
        if (this.zzcne != null) {
            if (this.zzcmz != null) {
                com.google.android.gms.ads.internal.zzu.zzfq().zza(this.zzcmz, this.zzcne);
            }
            com.google.android.gms.ads.internal.zzu.zzgk().zza(this.mView, this.zzcne);
        }
        this.zzcna = true;
    }

    private void zztw() {
        if (this.zzcmz != null && this.zzcna) {
            if (this.zzcnd != null && this.zzcmz != null) {
                com.google.android.gms.ads.internal.zzu.zzfs().zzb(this.zzcmz, this.zzcnd);
            }
            if (this.zzcne != null && this.zzcmz != null) {
                com.google.android.gms.ads.internal.zzu.zzfq().zzb(this.zzcmz, this.zzcne);
            }
            this.zzcna = false;
        }
    }

    public void onAttachedToWindow() {
        this.zzcnb = true;
        if (this.zzcnc) {
            zztv();
        }
    }

    public void onDetachedFromWindow() {
        this.zzcnb = false;
        zztw();
    }

    public void zzl(Activity activity) {
        this.zzcmz = activity;
    }

    public void zztt() {
        this.zzcnc = true;
        if (this.zzcnb) {
            zztv();
        }
    }

    public void zztu() {
        this.zzcnc = false;
        zztw();
    }
}
