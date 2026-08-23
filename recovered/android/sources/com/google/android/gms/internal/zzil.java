package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzil {
    private final Context mContext;
    private final com.google.android.gms.ads.internal.zzq zzbgb;
    private final zzas zzbgh;
    private final zzjy.zza zzbxv;
    private zzfu zzbza;
    private zzfw.zze zzbzb;
    private zzft zzbzc;
    private boolean zzbzd;
    private static final long zzbyx = TimeUnit.SECONDS.toMillis(60);
    private static final Object zzamp = new Object();
    private static boolean zzbyy = false;
    private static zzfw zzbyz = null;

    public static abstract class zza {
        public abstract void zze(zzfx zzfxVar);

        public void zzqr() {
        }
    }

    public zzil(Context context, zzjy.zza zzaVar, com.google.android.gms.ads.internal.zzq zzqVar, zzas zzasVar) {
        this.zzbzd = false;
        this.mContext = context;
        this.zzbxv = zzaVar;
        this.zzbgb = zzqVar;
        this.zzbgh = zzasVar;
        this.zzbzd = zzdc.zzbcd.get().booleanValue();
    }

    private String zzd(zzjy.zza zzaVar) {
        String str = zzdc.zzbaa.get();
        String strValueOf = String.valueOf(zzaVar.zzciu.zzbts.indexOf("https") == 0 ? "https:" : "http:");
        String strValueOf2 = String.valueOf(str);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    private void zzqj() {
        synchronized (zzamp) {
            if (!zzbyy) {
                zzbyz = new zzfw(this.mContext.getApplicationContext() != null ? this.mContext.getApplicationContext() : this.mContext, this.zzbxv.zzcit.zzaou, zzd(this.zzbxv), new zzkp<zzft>() { // from class: com.google.android.gms.internal.zzil.3
                    @Override // com.google.android.gms.internal.zzkp
                    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                    public void zzd(zzft zzftVar) {
                        zzftVar.zza(zzil.this.zzbgb, zzil.this.zzbgb, zzil.this.zzbgb, zzil.this.zzbgb, false, null, null, null, null);
                    }
                }, new zzfw.zzb());
                zzbyy = true;
            }
        }
    }

    private void zzqk() {
        this.zzbzb = new zzfw.zze(zzqp().zzc(this.zzbgh));
    }

    private void zzql() {
        this.zzbza = new zzfu();
    }

    private void zzqm() throws ExecutionException, CancellationException, InterruptedException, TimeoutException {
        this.zzbzc = zzqn().zza(this.mContext, this.zzbxv.zzcit.zzaou, zzd(this.zzbxv), this.zzbgh).get(zzbyx, TimeUnit.MILLISECONDS);
        this.zzbzc.zza(this.zzbgb, this.zzbgb, this.zzbgb, this.zzbgb, false, null, null, null, null);
    }

    public void zza(final zza zzaVar) {
        if (this.zzbzd) {
            zzfw.zze zzeVarZzqq = zzqq();
            if (zzeVarZzqq == null) {
                zzkh.zzcy("SharedJavascriptEngine not initialized");
                return;
            } else {
                zzeVarZzqq.zza(new zzle.zzc<zzfx>() { // from class: com.google.android.gms.internal.zzil.1
                    @Override // com.google.android.gms.internal.zzle.zzc
                    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
                    public void zzd(zzfx zzfxVar) {
                        zzaVar.zze(zzfxVar);
                    }
                }, new zzle.zza() { // from class: com.google.android.gms.internal.zzil.2
                    @Override // com.google.android.gms.internal.zzle.zza
                    public void run() {
                        zzaVar.zzqr();
                    }
                });
                return;
            }
        }
        zzft zzftVarZzqo = zzqo();
        if (zzftVarZzqo == null) {
            zzkh.zzcy("JavascriptEngine not initialized");
        } else {
            zzaVar.zze(zzftVarZzqo);
        }
    }

    public void zzqh() {
        if (this.zzbzd) {
            zzqj();
        } else {
            zzql();
        }
    }

    public void zzqi() throws ExecutionException, InterruptedException, CancellationException, TimeoutException {
        if (this.zzbzd) {
            zzqk();
        } else {
            zzqm();
        }
    }

    protected zzfu zzqn() {
        return this.zzbza;
    }

    protected zzft zzqo() {
        return this.zzbzc;
    }

    protected zzfw zzqp() {
        return zzbyz;
    }

    protected zzfw.zze zzqq() {
        return this.zzbzb;
    }
}
