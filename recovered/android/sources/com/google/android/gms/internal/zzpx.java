package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzpx<L> implements zzqs.zzb<L> {

    /* JADX INFO: renamed from: tk */
    private final DataHolder f622tk;

    protected zzpx(DataHolder dataHolder) {
        this.f622tk = dataHolder;
    }

    protected abstract void zza(L l, DataHolder dataHolder);

    @Override // com.google.android.gms.internal.zzqs.zzb
    public void zzapg() {
        if (this.f622tk != null) {
            this.f622tk.close();
        }
    }

    @Override // com.google.android.gms.internal.zzqs.zzb
    public final void zzu(L l) {
        zza(l, this.f622tk);
    }
}
