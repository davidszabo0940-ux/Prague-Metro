package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzld {
    private final Object zzcob = new Object();
    private final List<Runnable> zzcoc = new ArrayList();
    private final List<Runnable> zzcod = new ArrayList();
    private boolean zzcoe = false;

    private void zzd(Runnable runnable) {
        zzkk.zza(runnable);
    }

    private void zze(Runnable runnable) {
        com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(runnable);
    }

    public void zzb(Runnable runnable) {
        synchronized (this.zzcob) {
            if (this.zzcoe) {
                zzd(runnable);
            } else {
                this.zzcoc.add(runnable);
            }
        }
    }

    public void zzc(Runnable runnable) {
        synchronized (this.zzcob) {
            if (this.zzcoe) {
                zze(runnable);
            } else {
                this.zzcod.add(runnable);
            }
        }
    }

    public void zzua() {
        synchronized (this.zzcob) {
            if (this.zzcoe) {
                return;
            }
            Iterator<Runnable> it = this.zzcoc.iterator();
            while (it.hasNext()) {
                zzd(it.next());
            }
            Iterator<Runnable> it2 = this.zzcod.iterator();
            while (it2.hasNext()) {
                zze(it2.next());
            }
            this.zzcoc.clear();
            this.zzcod.clear();
            this.zzcoe = true;
        }
    }
}
