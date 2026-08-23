package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzik extends zzkg {
    private final Object zzail;
    private final zzig.zza zzbxu;
    private final zzjy.zza zzbxv;
    private final AdResponseParcel zzbxw;
    private final zzim zzbyu;
    private Future<zzjy> zzbyv;

    public zzik(Context context, com.google.android.gms.ads.internal.zzq zzqVar, zzjy.zza zzaVar, zzas zzasVar, zzig.zza zzaVar2) {
        this(zzaVar, zzaVar2, new zzim(context, zzqVar, new zzkr(context), zzasVar, zzaVar));
    }

    zzik(zzjy.zza zzaVar, zzig.zza zzaVar2, zzim zzimVar) {
        this.zzail = new Object();
        this.zzbxv = zzaVar;
        this.zzbxw = zzaVar.zzciu;
        this.zzbxu = zzaVar2;
        this.zzbyu = zzimVar;
    }

    private zzjy zzam(int i) {
        return new zzjy(this.zzbxv.zzcit.zzcav, null, null, i, null, null, this.zzbxw.orientation, this.zzbxw.zzbnw, this.zzbxv.zzcit.zzcay, false, null, null, null, null, null, this.zzbxw.zzccd, this.zzbxv.zzaoy, this.zzbxw.zzccb, this.zzbxv.zzcio, this.zzbxw.zzccg, this.zzbxw.zzcch, this.zzbxv.zzcii, null, null, null, null, this.zzbxv.zzciu.zzccu, this.zzbxv.zzciu.zzccv, null, null);
    }

    @Override // com.google.android.gms.internal.zzkg
    public void onStop() {
        synchronized (this.zzail) {
            if (this.zzbyv != null) {
                this.zzbyv.cancel(true);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zzew() {
        int i;
        final zzjy zzjyVarZzam;
        try {
            synchronized (this.zzail) {
                this.zzbyv = zzkk.zza(this.zzbyu);
            }
            zzjyVarZzam = this.zzbyv.get(60000L, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (InterruptedException e) {
            zzjyVarZzam = null;
            i = 0;
        } catch (CancellationException e2) {
            zzjyVarZzam = null;
            i = 0;
        } catch (ExecutionException e3) {
            zzjyVarZzam = null;
            i = 0;
        } catch (TimeoutException e4) {
            zzkh.zzcy("Timed out waiting for native ad.");
            this.zzbyv.cancel(true);
            i = 2;
            zzjyVarZzam = null;
        }
        if (zzjyVarZzam == null) {
            zzjyVarZzam = zzam(i);
        }
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzik.1
            @Override // java.lang.Runnable
            public void run() {
                zzik.this.zzbxu.zzb(zzjyVarZzam);
            }
        });
    }
}
