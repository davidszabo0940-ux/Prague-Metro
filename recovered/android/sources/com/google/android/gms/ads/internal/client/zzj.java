package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzj extends zzw.zza {
    private final AppEventListener zzauv;

    public zzj(AppEventListener appEventListener) {
        this.zzauv = appEventListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzw
    public void onAppEvent(String str, String str2) {
        this.zzauv.onAppEvent(str, str2);
    }
}
