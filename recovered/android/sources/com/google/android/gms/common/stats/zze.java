package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class zze {

    /* JADX INFO: renamed from: Av */
    private final long f454Av;

    /* JADX INFO: renamed from: Aw */
    private final int f455Aw;

    /* JADX INFO: renamed from: Ax */
    private final SimpleArrayMap<String, Long> f456Ax;

    public zze() {
        this.f454Av = 60000L;
        this.f455Aw = 10;
        this.f456Ax = new SimpleArrayMap<>(10);
    }

    public zze(int i, long j) {
        this.f454Av = j;
        this.f455Aw = i;
        this.f456Ax = new SimpleArrayMap<>();
    }

    private void zze(long j, long j2) {
        for (int size = this.f456Ax.size() - 1; size >= 0; size--) {
            if (j2 - this.f456Ax.valueAt(size).longValue() > j) {
                this.f456Ax.removeAt(size);
            }
        }
    }

    public Long zzhy(String str) {
        Long lPut;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f454Av;
        synchronized (this) {
            while (this.f456Ax.size() >= this.f455Aw) {
                zze(j, jElapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", new StringBuilder(94).append("The max capacity ").append(this.f455Aw).append(" is not enough. Current durationThreshold is: ").append(j).toString());
            }
            lPut = this.f456Ax.put(str, Long.valueOf(jElapsedRealtime));
        }
        return lPut;
    }

    public boolean zzhz(String str) {
        boolean z;
        synchronized (this) {
            z = this.f456Ax.remove(str) != null;
        }
        return z;
    }
}
