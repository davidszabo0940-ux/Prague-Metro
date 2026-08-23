package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzfq {
    private final String zzall;
    private final LinkedList<zza> zzbkv;
    private AdRequestParcel zzbkw;
    private final int zzbkx;
    private boolean zzbky;

    class zza {
        com.google.android.gms.ads.internal.zzl zzbkz;
        AdRequestParcel zzbla;
        zzfm zzblb;
        long zzblc;
        boolean zzbld;
        boolean zzble;

        zza(zzfl zzflVar) {
            this.zzbkz = zzflVar.zzbe(zzfq.this.zzall);
            this.zzblb = new zzfm();
            this.zzblb.zzc(this.zzbkz);
        }

        zza(zzfq zzfqVar, zzfl zzflVar, AdRequestParcel adRequestParcel) {
            this(zzflVar);
            this.zzbla = adRequestParcel;
        }

        void zzlx() {
            if (this.zzbld) {
                return;
            }
            this.zzble = this.zzbkz.zzb(zzfo.zzj(this.zzbla != null ? this.zzbla : zzfq.this.zzbkw));
            this.zzbld = true;
            this.zzblc = com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis();
        }
    }

    zzfq(AdRequestParcel adRequestParcel, String str, int i) {
        com.google.android.gms.common.internal.zzab.zzaa(adRequestParcel);
        com.google.android.gms.common.internal.zzab.zzaa(str);
        this.zzbkv = new LinkedList<>();
        this.zzbkw = adRequestParcel;
        this.zzall = str;
        this.zzbkx = i;
    }

    String getAdUnitId() {
        return this.zzall;
    }

    int getNetworkType() {
        return this.zzbkx;
    }

    int size() {
        return this.zzbkv.size();
    }

    void zza(zzfl zzflVar, AdRequestParcel adRequestParcel) {
        this.zzbkv.add(new zza(this, zzflVar, adRequestParcel));
    }

    void zzb(zzfl zzflVar) {
        zza zzaVar = new zza(zzflVar);
        this.zzbkv.add(zzaVar);
        zzaVar.zzlx();
    }

    AdRequestParcel zzls() {
        return this.zzbkw;
    }

    int zzlt() {
        int i = 0;
        Iterator<zza> it = this.zzbkv.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().zzbld ? i2 + 1 : i2;
        }
    }

    void zzlu() {
        Iterator<zza> it = this.zzbkv.iterator();
        while (it.hasNext()) {
            it.next().zzlx();
        }
    }

    void zzlv() {
        this.zzbky = true;
    }

    boolean zzlw() {
        return this.zzbky;
    }

    zza zzm(AdRequestParcel adRequestParcel) {
        if (adRequestParcel != null) {
            this.zzbkw = adRequestParcel;
        }
        return this.zzbkv.remove();
    }
}
