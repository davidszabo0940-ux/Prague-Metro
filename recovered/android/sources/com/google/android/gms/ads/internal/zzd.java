package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzfj;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzjt;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzd {
    public final zzfj zzakj;
    public final com.google.android.gms.ads.internal.overlay.zzj zzakk;
    public final com.google.android.gms.ads.internal.overlay.zzm zzakl;
    public final zzjt zzakm;

    public zzd(zzfj zzfjVar, com.google.android.gms.ads.internal.overlay.zzj zzjVar, com.google.android.gms.ads.internal.overlay.zzm zzmVar, zzjt zzjtVar) {
        this.zzakj = zzfjVar;
        this.zzakk = zzjVar;
        this.zzakl = zzmVar;
        this.zzakm = zzjtVar;
    }

    public static zzd zzel() {
        return new zzd(new zzep(), new com.google.android.gms.ads.internal.overlay.zzn(), new com.google.android.gms.ads.internal.overlay.zzt(), new zzjr());
    }
}
