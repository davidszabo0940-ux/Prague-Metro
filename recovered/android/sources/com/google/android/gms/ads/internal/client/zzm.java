package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzhy;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzm {
    private static final Object zzamp = new Object();
    private static zzm zzavk;
    private final com.google.android.gms.ads.internal.util.client.zza zzavl = new com.google.android.gms.ads.internal.util.client.zza();
    private final zzl zzavm = new zzl(new zze(), new zzd(), new zzai(), new zzei(), new com.google.android.gms.ads.internal.reward.client.zzf(), new zzhy(), new zzhl());

    static {
        zza(new zzm());
    }

    protected zzm() {
    }

    protected static void zza(zzm zzmVar) {
        synchronized (zzamp) {
            zzavk = zzmVar;
        }
    }

    private static zzm zziv() {
        zzm zzmVar;
        synchronized (zzamp) {
            zzmVar = zzavk;
        }
        return zzmVar;
    }

    public static com.google.android.gms.ads.internal.util.client.zza zziw() {
        return zziv().zzavl;
    }

    public static zzl zzix() {
        return zziv().zzavm;
    }
}
