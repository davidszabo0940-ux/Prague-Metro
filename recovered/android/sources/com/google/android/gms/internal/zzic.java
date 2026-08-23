package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzic implements zzkn<Void>, zzlm.zza {
    protected final Context mContext;
    protected final zzll zzbgj;
    protected final zzig.zza zzbxu;
    protected final zzjy.zza zzbxv;
    protected AdResponseParcel zzbxw;
    private Runnable zzbxx;
    protected final Object zzbxy = new Object();
    private AtomicBoolean zzbxz = new AtomicBoolean(true);

    protected zzic(Context context, zzjy.zza zzaVar, zzll zzllVar, zzig.zza zzaVar2) {
        this.mContext = context;
        this.zzbxv = zzaVar;
        this.zzbxw = this.zzbxv.zzciu;
        this.zzbgj = zzllVar;
        this.zzbxu = zzaVar2;
    }

    private zzjy zzak(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzbxv.zzcit;
        return new zzjy(adRequestInfoParcel.zzcav, this.zzbgj, this.zzbxw.zzbnq, i, this.zzbxw.zzbnr, this.zzbxw.zzcce, this.zzbxw.orientation, this.zzbxw.zzbnw, adRequestInfoParcel.zzcay, this.zzbxw.zzccc, null, null, null, null, null, this.zzbxw.zzccd, this.zzbxv.zzaoy, this.zzbxw.zzccb, this.zzbxv.zzcio, this.zzbxw.zzccg, this.zzbxw.zzcch, this.zzbxv.zzcii, null, this.zzbxw.zzccr, this.zzbxw.zzccs, this.zzbxw.zzcct, this.zzbxw.zzccu, this.zzbxw.zzccv, null, this.zzbxw.zzbnt);
    }

    @Override // com.google.android.gms.internal.zzkn
    public void cancel() {
        if (this.zzbxz.getAndSet(false)) {
            this.zzbgj.stopLoading();
            com.google.android.gms.ads.internal.zzu.zzfs().zzj(this.zzbgj);
            zzaj(-1);
            zzkl.zzclg.removeCallbacks(this.zzbxx);
        }
    }

    @Override // com.google.android.gms.internal.zzlm.zza
    public void zza(zzll zzllVar, boolean z) {
        zzkh.zzcw("WebView finished loading.");
        if (this.zzbxz.getAndSet(false)) {
            zzaj(z ? zzpy() : 0);
            zzkl.zzclg.removeCallbacks(this.zzbxx);
        }
    }

    protected void zzaj(int i) {
        if (i != -2) {
            this.zzbxw = new AdResponseParcel(i, this.zzbxw.zzbnw);
        }
        this.zzbgj.zzue();
        this.zzbxu.zzb(zzak(i));
    }

    @Override // com.google.android.gms.internal.zzkn
    /* JADX INFO: renamed from: zzpw, reason: merged with bridge method [inline-methods] */
    public final Void zzpz() {
        com.google.android.gms.common.internal.zzab.zzhj("Webview render task needs to be called on UI thread.");
        this.zzbxx = new Runnable() { // from class: com.google.android.gms.internal.zzic.1
            @Override // java.lang.Runnable
            public void run() {
                if (zzic.this.zzbxz.get()) {
                    zzkh.m14e("Timed out waiting for WebView to finish loading.");
                    zzic.this.cancel();
                }
            }
        };
        zzkl.zzclg.postDelayed(this.zzbxx, zzdc.zzbbf.get().longValue());
        zzpx();
        return null;
    }

    protected abstract void zzpx();

    protected int zzpy() {
        return -2;
    }
}
