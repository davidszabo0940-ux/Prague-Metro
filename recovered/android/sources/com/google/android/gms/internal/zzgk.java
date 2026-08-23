package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzgk implements zzgc {
    private final Context mContext;
    private final zzgn zzajz;
    private final boolean zzarj;
    private final boolean zzawl;
    private final zzge zzboi;
    private final AdRequestInfoParcel zzbox;
    private final long zzboy;
    private final long zzboz;
    private final int zzbpa;
    private final Object zzail = new Object();
    private boolean zzbpb = false;
    private final Map<zzlc<zzgi>, zzgh> zzbpc = new HashMap();
    private List<zzgi> zzbpd = new ArrayList();

    public zzgk(Context context, AdRequestInfoParcel adRequestInfoParcel, zzgn zzgnVar, zzge zzgeVar, boolean z, boolean z2, long j, long j2, int i) {
        this.mContext = context;
        this.zzbox = adRequestInfoParcel;
        this.zzajz = zzgnVar;
        this.zzboi = zzgeVar;
        this.zzarj = z;
        this.zzawl = z2;
        this.zzboy = j;
        this.zzboz = j2;
        this.zzbpa = i;
    }

    private void zza(final zzlc<zzgi> zzlcVar) {
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzgk.2
            @Override // java.lang.Runnable
            public void run() {
                for (zzlc zzlcVar2 : zzgk.this.zzbpc.keySet()) {
                    if (zzlcVar2 != zzlcVar) {
                        ((zzgh) zzgk.this.zzbpc.get(zzlcVar2)).cancel();
                    }
                }
            }
        });
    }

    private zzgi zze(List<zzlc<zzgi>> list) {
        synchronized (this.zzail) {
            if (this.zzbpb) {
                return new zzgi(-1);
            }
            for (zzlc<zzgi> zzlcVar : list) {
                try {
                    zzgi zzgiVar = zzlcVar.get();
                    this.zzbpd.add(zzgiVar);
                    if (zzgiVar != null && zzgiVar.zzboq == 0) {
                        zza(zzlcVar);
                        return zzgiVar;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    zzkh.zzd("Exception while processing an adapter; continuing with other adapters", e);
                }
            }
            zza((zzlc<zzgi>) null);
            return new zzgi(1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0086 A[Catch: RemoteException -> 0x008f, all -> 0x00a7, InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException | InterruptedException | ExecutionException | TimeoutException -> 0x00ca, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x00a7, blocks: (B:18:0x0040, B:20:0x0046, B:21:0x004c, B:23:0x0053, B:25:0x0057, B:27:0x005b, B:29:0x0061, B:37:0x0086, B:40:0x0090), top: B:56:0x0040 }] */
    private zzgi zzf(List<zzlc<zzgi>> list) {
        zzgi zzgiVar;
        zzgi zzgiVar2;
        zzlc<zzgi> zzlcVar;
        int iZzmo;
        zzgq zzgqVar;
        synchronized (this.zzail) {
            if (this.zzbpb) {
                return new zzgi(-1);
            }
            int i = -1;
            zzlc<zzgi> zzlcVar2 = null;
            zzgi zzgiVar3 = null;
            long jMax = this.zzboi.zzboa != -1 ? this.zzboi.zzboa : 10000L;
            Iterator<zzlc<zzgi>> it = list.iterator();
            while (true) {
                long j = jMax;
                if (!it.hasNext()) {
                    break;
                }
                zzlc<zzgi> next = it.next();
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis();
                if (j == 0) {
                    try {
                        try {
                            if (next.isDone()) {
                                zzgiVar = next.get();
                            } else {
                                zzgiVar = next.get(j, TimeUnit.MILLISECONDS);
                            }
                        } catch (Throwable th) {
                            Math.max(j - (com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis() - jCurrentTimeMillis), 0L);
                            throw th;
                        }
                    } catch (RemoteException | InterruptedException | ExecutionException | TimeoutException e) {
                        zzkh.zzd("Exception while processing an adapter; continuing with other adapters", e);
                        jMax = Math.max(j - (com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis() - jCurrentTimeMillis), 0L);
                    }
                } else {
                    zzgiVar = next.get(j, TimeUnit.MILLISECONDS);
                }
                this.zzbpd.add(zzgiVar);
                if (zzgiVar == null || zzgiVar.zzboq != 0 || (zzgqVar = zzgiVar.zzbov) == null || zzgqVar.zzmo() <= i) {
                    zzgiVar2 = zzgiVar3;
                    zzlcVar = zzlcVar2;
                    iZzmo = i;
                } else {
                    iZzmo = zzgqVar.zzmo();
                    zzgi zzgiVar4 = zzgiVar;
                    zzlcVar = next;
                    zzgiVar2 = zzgiVar4;
                }
                zzlcVar2 = zzlcVar;
                zzgi zzgiVar5 = zzgiVar2;
                jMax = Math.max(j - (com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis() - jCurrentTimeMillis), 0L);
                i = iZzmo;
                zzgiVar3 = zzgiVar5;
            }
            zza(zzlcVar2);
            return zzgiVar3 == null ? new zzgi(1) : zzgiVar3;
        }
    }

    @Override // com.google.android.gms.internal.zzgc
    public void cancel() {
        synchronized (this.zzail) {
            this.zzbpb = true;
            Iterator<zzgh> it = this.zzbpc.values().iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgc
    public zzgi zzd(List<zzgd> list) {
        zzkh.zzcw("Starting mediation.");
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        for (zzgd zzgdVar : list) {
            String strValueOf = String.valueOf(zzgdVar.zzbmz);
            zzkh.zzcx(strValueOf.length() != 0 ? "Trying mediation network: ".concat(strValueOf) : new String("Trying mediation network: "));
            Iterator<String> it = zzgdVar.zzbna.iterator();
            while (it.hasNext()) {
                final zzgh zzghVar = new zzgh(this.mContext, it.next(), this.zzajz, this.zzboi, zzgdVar, this.zzbox.zzcav, this.zzbox.zzaoy, this.zzbox.zzaou, this.zzarj, this.zzawl, this.zzbox.zzapm, this.zzbox.zzapq);
                zzlc<zzgi> zzlcVarZza = zzkk.zza(executorServiceNewCachedThreadPool, new Callable<zzgi>() { // from class: com.google.android.gms.internal.zzgk.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: zzmp, reason: merged with bridge method [inline-methods] */
                    public zzgi call() throws Exception {
                        synchronized (zzgk.this.zzail) {
                            if (zzgk.this.zzbpb) {
                                return null;
                            }
                            return zzghVar.zza(zzgk.this.zzboy, zzgk.this.zzboz);
                        }
                    }
                });
                this.zzbpc.put(zzlcVarZza, zzghVar);
                arrayList.add(zzlcVarZza);
            }
        }
        switch (this.zzbpa) {
            case 2:
                return zzf(arrayList);
            default:
                return zze(arrayList);
        }
    }

    @Override // com.google.android.gms.internal.zzgc
    public List<zzgi> zzmi() {
        return this.zzbpd;
    }
}
