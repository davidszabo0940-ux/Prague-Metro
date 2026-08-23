package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzbm extends zzbp {
    private List<Long> zzahd;

    public zzbm(zzax zzaxVar, String str, String str2, zzae.zza zzaVar, int i, int i2) {
        super(zzaxVar, str, str2, zzaVar, i, i2);
        this.zzahd = null;
    }

    @Override // com.google.android.gms.internal.zzbp
    protected void zzcv() throws IllegalAccessException, InvocationTargetException {
        this.zzaha.zzdq = -1L;
        this.zzaha.zzdr = -1L;
        if (this.zzahd == null) {
            this.zzahd = (List) this.zzahh.invoke(null, this.zzaey.getContext());
        }
        if (this.zzahd == null || this.zzahd.size() != 2) {
            return;
        }
        synchronized (this.zzaha) {
            this.zzaha.zzdq = Long.valueOf(this.zzahd.get(0).longValue());
            this.zzaha.zzdr = Long.valueOf(this.zzahd.get(1).longValue());
        }
    }
}
