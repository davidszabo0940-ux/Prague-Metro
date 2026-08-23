package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzar;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkk;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzi implements zzan, Runnable {
    private zzv zzajs;
    private final List<Object[]> zzala = new Vector();
    private final AtomicReference<zzan> zzalb = new AtomicReference<>();
    CountDownLatch zzalc = new CountDownLatch(1);

    public zzi(zzv zzvVar) {
        this.zzajs = zzvVar;
        if (com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            zzkk.zza(this);
        } else {
            run();
        }
    }

    private void zzep() {
        if (this.zzala.isEmpty()) {
            return;
        }
        for (Object[] objArr : this.zzala) {
            if (objArr.length == 1) {
                this.zzalb.get().zza((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                this.zzalb.get().zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.zzala.clear();
    }

    private Context zzi(Context context) {
        Context applicationContext;
        return (zzdc.zzayi.get().booleanValue() && (applicationContext = context.getApplicationContext()) != null) ? applicationContext : context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            zza(zzd(this.zzajs.zzaou.zzcs, zzi(this.zzajs.zzagf), !zzdc.zzayu.get().booleanValue() || this.zzajs.zzaou.zzcnq));
        } finally {
            this.zzalc.countDown();
            this.zzajs = null;
        }
    }

    @Override // com.google.android.gms.internal.zzan
    public void zza(int i, int i2, int i3) {
        zzan zzanVar = this.zzalb.get();
        if (zzanVar == null) {
            this.zzala.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else {
            zzep();
            zzanVar.zza(i, i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.zzan
    public void zza(MotionEvent motionEvent) {
        zzan zzanVar = this.zzalb.get();
        if (zzanVar == null) {
            this.zzala.add(new Object[]{motionEvent});
        } else {
            zzep();
            zzanVar.zza(motionEvent);
        }
    }

    protected void zza(zzan zzanVar) {
        this.zzalb.set(zzanVar);
    }

    @Override // com.google.android.gms.internal.zzan
    public String zzb(Context context) {
        zzan zzanVar;
        if (!zzeo() || (zzanVar = this.zzalb.get()) == null) {
            return "";
        }
        zzep();
        return zzanVar.zzb(zzi(context));
    }

    @Override // com.google.android.gms.internal.zzan
    public String zzb(Context context, String str) {
        zzan zzanVar;
        if (!zzeo() || (zzanVar = this.zzalb.get()) == null) {
            return "";
        }
        zzep();
        return zzanVar.zzb(zzi(context), str);
    }

    protected zzan zzd(String str, Context context, boolean z) {
        return zzar.zza(str, context, z);
    }

    protected boolean zzeo() {
        try {
            this.zzalc.await();
            return true;
        } catch (InterruptedException e) {
            zzkh.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }
}
