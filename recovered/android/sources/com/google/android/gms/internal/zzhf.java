package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzhf {
    private final zzll zzbgj;
    private final boolean zzbqw;
    private final String zzbqx;

    public zzhf(zzll zzllVar, Map<String, String> map) {
        this.zzbgj = zzllVar;
        this.zzbqx = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzbqw = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzbqw = true;
        }
    }

    public void execute() {
        int iZztm;
        if (this.zzbgj == null) {
            zzkh.zzcy("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.zzbqx)) {
            iZztm = com.google.android.gms.ads.internal.zzu.zzfs().zztl();
        } else if ("landscape".equalsIgnoreCase(this.zzbqx)) {
            iZztm = com.google.android.gms.ads.internal.zzu.zzfs().zztk();
        } else {
            iZztm = this.zzbqw ? -1 : com.google.android.gms.ads.internal.zzu.zzfs().zztm();
        }
        this.zzbgj.setRequestedOrientation(iZztm);
    }
}
