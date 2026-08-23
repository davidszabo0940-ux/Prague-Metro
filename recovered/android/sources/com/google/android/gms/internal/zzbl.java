package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class zzbl extends zzbp {
    private static volatile String zzct = null;
    private static final Object zzafc = new Object();

    public zzbl(zzax zzaxVar, String str, String str2, zzae.zza zzaVar, int i, int i2) {
        super(zzaxVar, str, str2, zzaVar, i, i2);
    }

    @Override // com.google.android.gms.internal.zzbp
    protected void zzcv() throws IllegalAccessException, InvocationTargetException {
        this.zzaha.zzct = "E";
        if (zzct == null) {
            synchronized (zzafc) {
                if (zzct == null) {
                    zzct = (String) this.zzahh.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaha) {
            this.zzaha.zzct = zzct;
        }
    }
}
