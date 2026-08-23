package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.SimpleArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class zza<E> extends AbstractSet<E> {

    /* JADX INFO: renamed from: AJ */
    private final ArrayMap<E, E> f459AJ;

    public zza() {
        this.f459AJ = new ArrayMap<>();
    }

    public zza(int i) {
        this.f459AJ = new ArrayMap<>(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zza(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        if (this.f459AJ.containsKey(e)) {
            return false;
        }
        this.f459AJ.put(e, e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof zza ? zza((zza) collection) : super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f459AJ.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f459AJ.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.f459AJ.keySet().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (!this.f459AJ.containsKey(obj)) {
            return false;
        }
        this.f459AJ.remove(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f459AJ.size();
    }

    public boolean zza(zza<? extends E> zzaVar) {
        int size = size();
        this.f459AJ.putAll((SimpleArrayMap<? extends E, ? extends E>) zzaVar.f459AJ);
        return size() > size;
    }
}
