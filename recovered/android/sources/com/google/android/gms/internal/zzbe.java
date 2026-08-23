package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class zzbe extends zzbp {
    public zzbe(zzax zzaxVar, String str, String str2, zzae.zza zzaVar, int i, int i2) {
        super(zzaxVar, str, str2, zzaVar, i, i2);
    }

    @Override // com.google.android.gms.internal.zzbp
    protected void zzcv() throws IllegalAccessException, InvocationTargetException {
        this.zzaha.zzcw = -1L;
        this.zzaha.zzcx = -1L;
        int[] iArr = (int[]) this.zzahh.invoke(null, this.zzaey.getContext());
        synchronized (this.zzaha) {
            this.zzaha.zzcw = Long.valueOf(iArr[0]);
            this.zzaha.zzcx = Long.valueOf(iArr[1]);
        }
    }
}
