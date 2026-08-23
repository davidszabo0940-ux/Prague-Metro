package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class zzb<T> implements Iterator<T> {

    /* JADX INFO: renamed from: vH */
    protected final DataBuffer<T> f194vH;

    /* JADX INFO: renamed from: vI */
    protected int f195vI = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.f194vH = (DataBuffer) zzab.zzaa(dataBuffer);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f195vI < this.f194vH.getCount() + (-1);
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.f195vI).toString());
        }
        DataBuffer<T> dataBuffer = this.f194vH;
        int i = this.f195vI + 1;
        this.f195vI = i;
        return dataBuffer.get(i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
