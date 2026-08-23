package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class zzl {
    private AtomicInteger zzax;
    private final Map<String, Queue<zzk<?>>> zzay;
    private final Set<zzk<?>> zzaz;
    private final PriorityBlockingQueue<zzk<?>> zzba;
    private final PriorityBlockingQueue<zzk<?>> zzbb;
    private zzg[] zzbc;
    private zzc zzbd;
    private List<zza> zzbe;
    private final zzb zzi;
    private final zzn zzj;
    private final zzf zzy;

    public interface zza<T> {
        void zzg(zzk<T> zzkVar);
    }

    public zzl(zzb zzbVar, zzf zzfVar) {
        this(zzbVar, zzfVar, 4);
    }

    public zzl(zzb zzbVar, zzf zzfVar, int i) {
        this(zzbVar, zzfVar, i, new zze(new Handler(Looper.getMainLooper())));
    }

    public zzl(zzb zzbVar, zzf zzfVar, int i, zzn zznVar) {
        this.zzax = new AtomicInteger();
        this.zzay = new HashMap();
        this.zzaz = new HashSet();
        this.zzba = new PriorityBlockingQueue<>();
        this.zzbb = new PriorityBlockingQueue<>();
        this.zzbe = new ArrayList();
        this.zzi = zzbVar;
        this.zzy = zzfVar;
        this.zzbc = new zzg[i];
        this.zzj = zznVar;
    }

    public int getSequenceNumber() {
        return this.zzax.incrementAndGet();
    }

    public void start() {
        stop();
        this.zzbd = new zzc(this.zzba, this.zzbb, this.zzi, this.zzj);
        this.zzbd.start();
        for (int i = 0; i < this.zzbc.length; i++) {
            zzg zzgVar = new zzg(this.zzbb, this.zzy, this.zzi, this.zzj);
            this.zzbc[i] = zzgVar;
            zzgVar.start();
        }
    }

    public void stop() {
        if (this.zzbd != null) {
            this.zzbd.quit();
        }
        for (int i = 0; i < this.zzbc.length; i++) {
            if (this.zzbc[i] != null) {
                this.zzbc[i].quit();
            }
        }
    }

    public <T> zzk<T> zze(zzk<T> zzkVar) {
        zzkVar.zza(this);
        synchronized (this.zzaz) {
            this.zzaz.add(zzkVar);
        }
        zzkVar.zza(getSequenceNumber());
        zzkVar.zzc("add-to-queue");
        if (zzkVar.zzq()) {
            synchronized (this.zzay) {
                String strZzg = zzkVar.zzg();
                if (this.zzay.containsKey(strZzg)) {
                    Queue<zzk<?>> linkedList = this.zzay.get(strZzg);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                    }
                    linkedList.add(zzkVar);
                    this.zzay.put(strZzg, linkedList);
                    if (zzs.DEBUG) {
                        zzs.zza("Request for cacheKey=%s is in flight, putting on hold.", strZzg);
                    }
                } else {
                    this.zzay.put(strZzg, null);
                    this.zzba.add(zzkVar);
                }
            }
        } else {
            this.zzbb.add(zzkVar);
        }
        return zzkVar;
    }

    <T> void zzf(zzk<T> zzkVar) {
        synchronized (this.zzaz) {
            this.zzaz.remove(zzkVar);
        }
        synchronized (this.zzbe) {
            Iterator<zza> it = this.zzbe.iterator();
            while (it.hasNext()) {
                it.next().zzg(zzkVar);
            }
        }
        if (zzkVar.zzq()) {
            synchronized (this.zzay) {
                String strZzg = zzkVar.zzg();
                Queue<zzk<?>> queueRemove = this.zzay.remove(strZzg);
                if (queueRemove != null) {
                    if (zzs.DEBUG) {
                        zzs.zza("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queueRemove.size()), strZzg);
                    }
                    this.zzba.addAll(queueRemove);
                }
            }
        }
    }
}
