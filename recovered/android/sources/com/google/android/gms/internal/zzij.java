package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzij extends zzif {
    private final zzdk zzajn;
    private zzgn zzajz;
    private final zzll zzbgj;
    private zzge zzboi;
    zzgc zzbyq;
    protected zzgi zzbyr;
    private boolean zzbys;

    zzij(Context context, zzjy.zza zzaVar, zzgn zzgnVar, zzig.zza zzaVar2, zzdk zzdkVar, zzll zzllVar) {
        super(context, zzaVar, zzaVar2);
        this.zzajz = zzgnVar;
        this.zzboi = zzaVar.zzcik;
        this.zzajn = zzdkVar;
        this.zzbgj = zzllVar;
    }

    private static String zza(zzgi zzgiVar) {
        String str = zzgiVar.zzbor.zzbnb;
        int iZzal = zzal(zzgiVar.zzboq);
        return new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(iZzal).append(".").append(zzgiVar.zzbow).toString();
    }

    private static int zzal(int i) {
        switch (i) {
            case -1:
                return 4;
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
            default:
                return 6;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
        }
    }

    private static String zzg(List<zzgi> list) {
        if (list == null) {
            return "".toString();
        }
        String string = "";
        for (zzgi zzgiVar : list) {
            if (zzgiVar != null && zzgiVar.zzbor != null && !TextUtils.isEmpty(zzgiVar.zzbor.zzbnb)) {
                String strValueOf = String.valueOf(string);
                String strValueOf2 = String.valueOf(zza(zzgiVar));
                string = new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length()).append(strValueOf).append(strValueOf2).append("_").toString();
            }
        }
        return string.substring(0, Math.max(0, string.length() - 1));
    }

    private void zzqg() throws zzif.zza {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzij.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (zzij.this.zzbxy) {
                    zzij.this.zzbys = com.google.android.gms.ads.internal.zzn.zza(zzij.this.zzbgj, zzij.this.zzbyr, countDownLatch);
                }
            }
        });
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
            synchronized (this.zzbxy) {
                if (!this.zzbys) {
                    throw new zzif.zza("View could not be prepared", 0);
                }
                if (this.zzbgj.isDestroyed()) {
                    throw new zzif.zza("Assets not loaded, web view is destroyed", 0);
                }
            }
        } catch (InterruptedException e) {
            String strValueOf = String.valueOf(e);
            throw new zzif.zza(new StringBuilder(String.valueOf(strValueOf).length() + 38).append("Interrupted while waiting for latch : ").append(strValueOf).toString(), 0);
        }
    }

    @Override // com.google.android.gms.internal.zzif, com.google.android.gms.internal.zzkg
    public void onStop() {
        synchronized (this.zzbxy) {
            super.onStop();
            if (this.zzbyq != null) {
                this.zzbyq.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzif
    protected zzjy zzak(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzbxv.zzcit;
        return new zzjy(adRequestInfoParcel.zzcav, this.zzbgj, this.zzbxw.zzbnq, i, this.zzbxw.zzbnr, this.zzbxw.zzcce, this.zzbxw.orientation, this.zzbxw.zzbnw, adRequestInfoParcel.zzcay, this.zzbxw.zzccc, this.zzbyr != null ? this.zzbyr.zzbor : null, this.zzbyr != null ? this.zzbyr.zzbos : null, this.zzbyr != null ? this.zzbyr.zzbot : AdMobAdapter.class.getName(), this.zzboi, this.zzbyr != null ? this.zzbyr.zzbou : null, this.zzbxw.zzccd, this.zzbxv.zzaoy, this.zzbxw.zzccb, this.zzbxv.zzcio, this.zzbxw.zzccg, this.zzbxw.zzcch, this.zzbxv.zzcii, null, this.zzbxw.zzccr, this.zzbxw.zzccs, this.zzbxw.zzcct, this.zzboi != null ? this.zzboi.zzbob : false, this.zzbxw.zzccv, this.zzbyq != null ? zzg(this.zzbyq.zzmi()) : null, this.zzbxw.zzbnt);
    }

    @Override // com.google.android.gms.internal.zzif
    protected void zzh(long j) throws zzif.zza {
        Bundle bundle;
        synchronized (this.zzbxy) {
            this.zzbyq = zzi(j);
        }
        ArrayList arrayList = new ArrayList(this.zzboi.zzbno);
        Bundle bundle2 = this.zzbxv.zzcit.zzcav.zzatu;
        if ((bundle2 == null || (bundle = bundle2.getBundle("com.google.ads.mediation.admob.AdMobAdapter")) == null) ? false : bundle.getBoolean("_skipMediation")) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((zzgd) listIterator.next()).zzbna.contains("com.google.ads.mediation.admob.AdMobAdapter")) {
                    listIterator.remove();
                }
            }
        }
        this.zzbyr = this.zzbyq.zzd(arrayList);
        switch (this.zzbyr.zzboq) {
            case 0:
                if (this.zzbyr.zzbor == null || this.zzbyr.zzbor.zzbnj == null) {
                    return;
                }
                zzqg();
                return;
            case 1:
                throw new zzif.zza("No fill from any mediation ad networks.", 3);
            default:
                throw new zzif.zza(new StringBuilder(40).append("Unexpected mediation result: ").append(this.zzbyr.zzboq).toString(), 0);
        }
    }

    zzgc zzi(long j) {
        return this.zzboi.zzbnz != -1 ? new zzgk(this.mContext, this.zzbxv.zzcit, this.zzajz, this.zzboi, this.zzbxw.zzaus, this.zzbxw.zzauu, j, zzdc.zzbbf.get().longValue(), 2) : new zzgl(this.mContext, this.zzbxv.zzcit, this.zzajz, this.zzboi, this.zzbxw.zzaus, this.zzbxw.zzauu, j, zzdc.zzbbf.get().longValue(), this.zzajn);
    }
}
