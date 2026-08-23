package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class zzba extends zzbp {
    private static volatile String zzagy = null;
    private static final Object zzafc = new Object();

    public zzba(zzax zzaxVar, String str, String str2, zzae.zza zzaVar, int i, int i2) {
        super(zzaxVar, str, str2, zzaVar, i, i2);
    }

    @Override // com.google.android.gms.internal.zzbp
    protected void zzcv() throws IllegalAccessException, InvocationTargetException {
        this.zzaha.zzdp = "E";
        if (zzagy == null) {
            synchronized (zzafc) {
                if (zzagy == null) {
                    zzagy = (String) this.zzahh.invoke(null, this.zzaey.getContext());
                }
            }
        }
        synchronized (this.zzaha) {
            this.zzaha.zzdp = zzaj.zza(zzagy.getBytes(), true);
        }
    }
}
