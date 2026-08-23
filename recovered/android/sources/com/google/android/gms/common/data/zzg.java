package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class zzg<T> extends zzb<T> {

    /* JADX INFO: renamed from: we */
    private T f203we;

    public zzg(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.google.android.gms.common.data.zzb, java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.f195vI).toString());
        }
        this.f195vI++;
        if (this.f195vI == 0) {
            this.f203we = this.f194vH.get(0);
            if (!(this.f203we instanceof zzc)) {
                String strValueOf = String.valueOf(this.f203we.getClass());
                throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 44).append("DataBuffer reference of type ").append(strValueOf).append(" is not movable").toString());
            }
        } else {
            ((zzc) this.f203we).zzfm(this.f195vI);
        }
        return this.f203we;
    }
}
