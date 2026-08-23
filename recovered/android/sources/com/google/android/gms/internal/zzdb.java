package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzdb {
    private final Object zzail = new Object();
    private boolean zzamr = false;
    private SharedPreferences zzaxs = null;

    public void initialize(Context context) {
        synchronized (this.zzail) {
            if (this.zzamr) {
                return;
            }
            Context remoteContext = com.google.android.gms.common.zze.getRemoteContext(context);
            if (remoteContext == null) {
                return;
            }
            this.zzaxs = com.google.android.gms.ads.internal.zzu.zzfx().zzn(remoteContext);
            this.zzamr = true;
        }
    }

    public <T> T zzd(final zzcy<T> zzcyVar) {
        synchronized (this.zzail) {
            if (this.zzamr) {
                return (T) zzkx.zzb(new Callable<T>() { // from class: com.google.android.gms.internal.zzdb.1
                    @Override // java.util.concurrent.Callable
                    public T call() {
                        return (T) zzcyVar.zza(zzdb.this.zzaxs);
                    }
                });
            }
            return zzcyVar.zzjw();
        }
    }
}
