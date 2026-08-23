package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class zzbg extends zzbp {
    private long startTime;

    public zzbg(zzax zzaxVar, String str, String str2, zzae.zza zzaVar, long j, int i, int i2) {
        super(zzaxVar, str, str2, zzaVar, i, i2);
        this.startTime = j;
    }

    @Override // com.google.android.gms.internal.zzbp
    protected void zzcv() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zzahh.invoke(null, new Object[0])).longValue();
        synchronized (this.zzaha) {
            this.zzaha.zzek = Long.valueOf(jLongValue);
            if (this.startTime != 0) {
                this.zzaha.zzdi = Long.valueOf(jLongValue - this.startTime);
                this.zzaha.zzdn = Long.valueOf(this.startTime);
            }
        }
    }
}
