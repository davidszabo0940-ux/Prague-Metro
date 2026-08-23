package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzkt {
    Map<Integer, Bitmap> zzcmt = new ConcurrentHashMap();
    private AtomicInteger zzcmu = new AtomicInteger(0);

    public Bitmap zza(Integer num) {
        return this.zzcmt.get(num);
    }

    public int zzb(Bitmap bitmap) {
        if (bitmap == null) {
            zzkh.zzcw("Bitmap is null. Skipping putting into the Memory Map.");
            return -1;
        }
        this.zzcmt.put(Integer.valueOf(this.zzcmu.get()), bitmap);
        return this.zzcmu.getAndIncrement();
    }

    public void zzb(Integer num) {
        this.zzcmt.remove(num);
    }
}
