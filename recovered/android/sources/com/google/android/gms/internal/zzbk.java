package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class zzbk extends zzbp {
    private long zzahc;

    public zzbk(zzax zzaxVar, String str, String str2, zzae.zza zzaVar, int i, int i2) {
        super(zzaxVar, str, str2, zzaVar, i, i2);
        this.zzahc = -1L;
    }

    @Override // com.google.android.gms.internal.zzbp
    protected void zzcv() throws IllegalAccessException, InvocationTargetException {
        this.zzaha.zzdd = -1L;
        if (this.zzahc == -1) {
            this.zzahc = ((Integer) this.zzahh.invoke(null, this.zzaey.getContext())).intValue();
        }
        synchronized (this.zzaha) {
            this.zzaha.zzdd = Long.valueOf(this.zzahc);
        }
    }
}
