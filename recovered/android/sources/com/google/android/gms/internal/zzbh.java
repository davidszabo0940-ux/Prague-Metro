package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class zzbh extends zzbp {
    public zzbh(zzax zzaxVar, String str, String str2, zzae.zza zzaVar, int i, int i2) {
        super(zzaxVar, str, str2, zzaVar, i, i2);
    }

    private void zzcw() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzaha) {
            this.zzaha.zzeg = (String) this.zzahh.invoke(null, this.zzaey.getContext());
        }
    }

    private void zzcx() {
        AdvertisingIdClient advertisingIdClientZzcs = this.zzaey.zzcs();
        if (advertisingIdClientZzcs == null) {
            zzp("E1");
            return;
        }
        try {
            AdvertisingIdClient.Info info = advertisingIdClientZzcs.getInfo();
            String strZzo = zzay.zzo(info.getId());
            if (strZzo == null) {
                zzp("E");
                return;
            }
            synchronized (this.zzaha) {
                this.zzaha.zzeg = strZzo;
                this.zzaha.zzei = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                this.zzaha.zzeh = 5;
            }
        } catch (IOException e) {
            zzp("E");
        }
    }

    private void zzp(String str) {
    }

    @Override // com.google.android.gms.internal.zzbp
    protected void zzcv() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaey.zzcj()) {
            zzcx();
        } else {
            zzcw();
        }
    }
}
