package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzlf<T> implements zzle<T> {
    private final Object zzail = new Object();
    protected int zzblz = 0;
    protected final BlockingQueue<zza> zzcof = new LinkedBlockingQueue();
    protected T zzcog;

    class zza {
        public final zzle.zzc<T> zzcoh;
        public final zzle.zza zzcoi;

        public zza(zzle.zzc<T> zzcVar, zzle.zza zzaVar) {
            this.zzcoh = zzcVar;
            this.zzcoi = zzaVar;
        }
    }

    public int getStatus() {
        return this.zzblz;
    }

    public void reject() {
        synchronized (this.zzail) {
            if (this.zzblz != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzblz = -1;
            Iterator it = this.zzcof.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzcoi.run();
            }
            this.zzcof.clear();
        }
    }

    @Override // com.google.android.gms.internal.zzle
    public void zza(zzle.zzc<T> zzcVar, zzle.zza zzaVar) {
        synchronized (this.zzail) {
            if (this.zzblz == 1) {
                zzcVar.zzd(this.zzcog);
            } else if (this.zzblz == -1) {
                zzaVar.run();
            } else if (this.zzblz == 0) {
                this.zzcof.add(new zza(zzcVar, zzaVar));
            }
        }
    }

    @Override // com.google.android.gms.internal.zzle
    public void zzg(T t) {
        synchronized (this.zzail) {
            if (this.zzblz != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzcog = t;
            this.zzblz = 1;
            Iterator it = this.zzcof.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzcoh.zzd(t);
            }
            this.zzcof.clear();
        }
    }
}
