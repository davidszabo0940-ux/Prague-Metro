package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class zzc extends Thread {
    private static final boolean DEBUG = zzs.DEBUG;
    private final BlockingQueue<zzk<?>> zzg;
    private final BlockingQueue<zzk<?>> zzh;
    private final zzb zzi;
    private final zzn zzj;
    private volatile boolean zzk;

    public zzc(BlockingQueue<zzk<?>> blockingQueue, BlockingQueue<zzk<?>> blockingQueue2, zzb zzbVar, zzn zznVar) {
        super("VolleyCacheDispatcher");
        this.zzk = false;
        this.zzg = blockingQueue;
        this.zzh = blockingQueue2;
        this.zzi = zzbVar;
        this.zzj = zznVar;
    }

    public void quit() {
        this.zzk = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (DEBUG) {
            zzs.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzi.initialize();
        while (true) {
            try {
                final zzk<?> zzkVarTake = this.zzg.take();
                zzkVarTake.zzc("cache-queue-take");
                if (zzkVarTake.isCanceled()) {
                    zzkVarTake.zzd("cache-discard-canceled");
                } else {
                    zzb.zza zzaVarZza = this.zzi.zza(zzkVarTake.zzg());
                    if (zzaVarZza == null) {
                        zzkVarTake.zzc("cache-miss");
                        this.zzh.put(zzkVarTake);
                    } else if (zzaVarZza.zza()) {
                        zzkVarTake.zzc("cache-hit-expired");
                        zzkVarTake.zza(zzaVarZza);
                        this.zzh.put(zzkVarTake);
                    } else {
                        zzkVarTake.zzc("cache-hit");
                        zzm<?> zzmVarZza = zzkVarTake.zza(new zzi(zzaVarZza.data, zzaVarZza.zzf));
                        zzkVarTake.zzc("cache-hit-parsed");
                        if (zzaVarZza.zzb()) {
                            zzkVarTake.zzc("cache-hit-refresh-needed");
                            zzkVarTake.zza(zzaVarZza);
                            zzmVarZza.zzbh = true;
                            this.zzj.zza(zzkVarTake, zzmVarZza, new Runnable() { // from class: com.google.android.gms.internal.zzc.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        zzc.this.zzh.put(zzkVarTake);
                                    } catch (InterruptedException e) {
                                    }
                                }
                            });
                        } else {
                            this.zzj.zza(zzkVarTake, zzmVarZza);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.zzk) {
                    return;
                }
            }
        }
    }
}
