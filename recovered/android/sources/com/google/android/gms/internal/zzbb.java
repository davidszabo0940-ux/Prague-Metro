package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class zzbb extends zzbp {
    private static volatile String zzagz = null;
    private static final Object zzafc = new Object();

    public zzbb(zzax zzaxVar, String str, String str2, zzae.zza zzaVar, int i, int i2) {
        super(zzaxVar, str, str2, zzaVar, i, i2);
    }

    @Override // com.google.android.gms.internal.zzbp
    protected void zzcv() throws IllegalAccessException, InvocationTargetException {
        this.zzaha.zzdo = "E";
        if (zzagz == null) {
            synchronized (zzafc) {
                if (zzagz == null) {
                    zzagz = zzaj.zza(((ByteBuffer) this.zzahh.invoke(null, this.zzaey.getContext())).array(), true);
                }
            }
        }
        synchronized (this.zzaha) {
            this.zzaha.zzdo = zzagz;
        }
    }
}
