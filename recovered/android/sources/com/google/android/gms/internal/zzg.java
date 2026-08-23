package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class zzg extends Thread {
    private final zzb zzi;
    private final zzn zzj;
    private volatile boolean zzk;
    private final BlockingQueue<zzk<?>> zzx;
    private final zzf zzy;

    public zzg(BlockingQueue<zzk<?>> blockingQueue, zzf zzfVar, zzb zzbVar, zzn zznVar) {
        super("VolleyNetworkDispatcher");
        this.zzk = false;
        this.zzx = blockingQueue;
        this.zzy = zzfVar;
        this.zzi = zzbVar;
        this.zzj = zznVar;
    }

    @TargetApi(14)
    private void zzb(zzk<?> zzkVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(zzkVar.zzf());
        }
    }

    private void zzb(zzk<?> zzkVar, zzr zzrVar) {
        this.zzj.zza(zzkVar, zzkVar.zzb(zzrVar));
    }

    public void quit() {
        this.zzk = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                zzk<?> zzkVarTake = this.zzx.take();
                try {
                    zzkVarTake.zzc("network-queue-take");
                    if (zzkVarTake.isCanceled()) {
                        zzkVarTake.zzd("network-discard-cancelled");
                    } else {
                        zzb(zzkVarTake);
                        zzi zziVarZza = this.zzy.zza(zzkVarTake);
                        zzkVarTake.zzc("network-http-complete");
                        if (zziVarZza.zzaa && zzkVarTake.zzv()) {
                            zzkVarTake.zzd("not-modified");
                        } else {
                            zzm<?> zzmVarZza = zzkVarTake.zza(zziVarZza);
                            zzkVarTake.zzc("network-parse-complete");
                            if (zzkVarTake.zzq() && zzmVarZza.zzbf != null) {
                                this.zzi.zza(zzkVarTake.zzg(), zzmVarZza.zzbf);
                                zzkVarTake.zzc("network-cache-written");
                            }
                            zzkVarTake.zzu();
                            this.zzj.zza(zzkVarTake, zzmVarZza);
                        }
                    }
                } catch (zzr e) {
                    e.zza(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    zzb(zzkVarTake, e);
                } catch (Exception e2) {
                    zzs.zza(e2, "Unhandled exception %s", e2.toString());
                    zzr zzrVar = new zzr(e2);
                    zzrVar.zza(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    this.zzj.zza(zzkVarTake, zzrVar);
                }
            } catch (InterruptedException e3) {
                if (this.zzk) {
                    return;
                }
            }
        }
    }
}
