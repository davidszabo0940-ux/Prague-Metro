package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzez implements zzet {
    static final Map<String, Integer> zzbiz = com.google.android.gms.common.util.zzf.zza("resize", 1, "playVideo", 2, "storePicture", 3, "createCalendarEvent", 4, "setOrientationProperties", 5, "closeResizedAd", 6);
    private final com.google.android.gms.ads.internal.zze zzbix;
    private final zzhe zzbiy;

    public zzez(com.google.android.gms.ads.internal.zze zzeVar, zzhe zzheVar) {
        this.zzbix = zzeVar;
        this.zzbiy = zzheVar;
    }

    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        int iIntValue = zzbiz.get(map.get("a")).intValue();
        if (iIntValue != 5 && this.zzbix != null && !this.zzbix.zzem()) {
            this.zzbix.zzt(null);
        }
        switch (iIntValue) {
            case 1:
                this.zzbiy.execute(map);
                break;
            case 2:
            default:
                zzkh.zzcx("Unknown MRAID command called.");
                break;
            case 3:
                new zzhg(zzllVar, map).execute();
                break;
            case 4:
                new zzhd(zzllVar, map).execute();
                break;
            case 5:
                new zzhf(zzllVar, map).execute();
                break;
            case 6:
                this.zzbiy.zzs(true);
                break;
        }
    }
}
