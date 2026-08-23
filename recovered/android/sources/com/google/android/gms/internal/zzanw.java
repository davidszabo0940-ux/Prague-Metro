package com.google.android.gms.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzanw<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Comparator<Comparable> bfg;
    Comparator<? super K> aQi;
    zzd<K, V> bfh;
    final zzd<K, V> bfi;
    private zza bfj;
    private zzb bfk;
    int modCount;
    int size;

    class zza extends AbstractSet<Map.Entry<K, V>> {
        zza() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            zzanw.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && zzanw.this.zzc((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new zzc<Map.Entry<K, V>>() { // from class: com.google.android.gms.internal.zzanw.zza.1
                {
                    zzanw zzanwVar = zzanw.this;
                }

                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    return m17c();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            zzd<K, V> zzdVarZzc;
            if (!(obj instanceof Map.Entry) || (zzdVarZzc = zzanw.this.zzc((Map.Entry) obj)) == null) {
                return false;
            }
            zzanw.this.zza((zzd) zzdVarZzc, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return zzanw.this.size;
        }
    }

    final class zzb extends AbstractSet<K> {
        zzb() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            zzanw.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return zzanw.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new zzc<K>() { // from class: com.google.android.gms.internal.zzanw.zzb.1
                {
                    zzanw zzanwVar = zzanw.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return m17c().aQw;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return zzanw.this.zzcp(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return zzanw.this.size;
        }
    }

    private abstract class zzc<T> implements Iterator<T> {
        zzd<K, V> bfo;
        zzd<K, V> bfp;
        int bfq;

        private zzc() {
            this.bfo = zzanw.this.bfi.bfo;
            this.bfp = null;
            this.bfq = zzanw.this.modCount;
        }

        /* JADX INFO: renamed from: c */
        final zzd<K, V> m17c() {
            zzd<K, V> zzdVar = this.bfo;
            if (zzdVar == zzanw.this.bfi) {
                throw new NoSuchElementException();
            }
            if (zzanw.this.modCount != this.bfq) {
                throw new ConcurrentModificationException();
            }
            this.bfo = zzdVar.bfo;
            this.bfp = zzdVar;
            return zzdVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.bfo != zzanw.this.bfi;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.bfp == null) {
                throw new IllegalStateException();
            }
            zzanw.this.zza((zzd) this.bfp, true);
            this.bfp = null;
            this.bfq = zzanw.this.modCount;
        }
    }

    static final class zzd<K, V> implements Map.Entry<K, V> {
        final K aQw;
        V aQx;
        zzd<K, V> bfo;
        zzd<K, V> bfr;
        zzd<K, V> bfs;
        zzd<K, V> bft;
        zzd<K, V> bfu;
        int height;

        zzd() {
            this.aQw = null;
            this.bfu = this;
            this.bfo = this;
        }

        zzd(zzd<K, V> zzdVar, K k, zzd<K, V> zzdVar2, zzd<K, V> zzdVar3) {
            this.bfr = zzdVar;
            this.aQw = k;
            this.height = 1;
            this.bfo = zzdVar2;
            this.bfu = zzdVar3;
            zzdVar3.bfo = this;
            zzdVar2.bfu = this;
        }

        /* JADX INFO: renamed from: d */
        public zzd<K, V> m18d() {
            for (zzd<K, V> zzdVar = this.bfs; zzdVar != null; zzdVar = zzdVar.bfs) {
                this = zzdVar;
            }
            return this;
        }

        /* JADX INFO: renamed from: e */
        public zzd<K, V> m19e() {
            for (zzd<K, V> zzdVar = this.bft; zzdVar != null; zzdVar = zzdVar.bft) {
                this = zzdVar;
            }
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (this.aQw == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.aQw.equals(entry.getKey())) {
                return false;
            }
            if (this.aQx == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.aQx.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.aQw;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.aQx;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (this.aQw == null ? 0 : this.aQw.hashCode()) ^ (this.aQx != null ? this.aQx.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.aQx;
            this.aQx = v;
            return v2;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.aQw);
            String strValueOf2 = String.valueOf(this.aQx);
            return new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length()).append(strValueOf).append("=").append(strValueOf2).toString();
        }
    }

    static {
        $assertionsDisabled = !zzanw.class.desiredAssertionStatus();
        bfg = new Comparator<Comparable>() { // from class: com.google.android.gms.internal.zzanw.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public int compare(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo(comparable2);
            }
        };
    }

    public zzanw() {
        this(bfg);
    }

    public zzanw(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.bfi = new zzd<>();
        this.aQi = comparator == null ? bfg : comparator;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void zza(zzd<K, V> zzdVar) {
        zzd<K, V> zzdVar2 = zzdVar.bfs;
        zzd<K, V> zzdVar3 = zzdVar.bft;
        zzd<K, V> zzdVar4 = zzdVar3.bfs;
        zzd<K, V> zzdVar5 = zzdVar3.bft;
        zzdVar.bft = zzdVar4;
        if (zzdVar4 != null) {
            zzdVar4.bfr = zzdVar;
        }
        zza(zzdVar, zzdVar3);
        zzdVar3.bfs = zzdVar;
        zzdVar.bfr = zzdVar3;
        zzdVar.height = Math.max(zzdVar2 != null ? zzdVar2.height : 0, zzdVar4 != null ? zzdVar4.height : 0) + 1;
        zzdVar3.height = Math.max(zzdVar.height, zzdVar5 != null ? zzdVar5.height : 0) + 1;
    }

    private void zza(zzd<K, V> zzdVar, zzd<K, V> zzdVar2) {
        zzd<K, V> zzdVar3 = zzdVar.bfr;
        zzdVar.bfr = null;
        if (zzdVar2 != null) {
            zzdVar2.bfr = zzdVar3;
        }
        if (zzdVar3 == null) {
            this.bfh = zzdVar2;
            return;
        }
        if (zzdVar3.bfs == zzdVar) {
            zzdVar3.bfs = zzdVar2;
        } else {
            if (!$assertionsDisabled && zzdVar3.bft != zzdVar) {
                throw new AssertionError();
            }
            zzdVar3.bft = zzdVar2;
        }
    }

    private void zzb(zzd<K, V> zzdVar) {
        zzd<K, V> zzdVar2 = zzdVar.bfs;
        zzd<K, V> zzdVar3 = zzdVar.bft;
        zzd<K, V> zzdVar4 = zzdVar2.bfs;
        zzd<K, V> zzdVar5 = zzdVar2.bft;
        zzdVar.bfs = zzdVar5;
        if (zzdVar5 != null) {
            zzdVar5.bfr = zzdVar;
        }
        zza(zzdVar, zzdVar2);
        zzdVar2.bft = zzdVar;
        zzdVar.bfr = zzdVar2;
        zzdVar.height = Math.max(zzdVar3 != null ? zzdVar3.height : 0, zzdVar5 != null ? zzdVar5.height : 0) + 1;
        zzdVar2.height = Math.max(zzdVar.height, zzdVar4 != null ? zzdVar4.height : 0) + 1;
    }

    private void zzb(zzd<K, V> zzdVar, boolean z) {
        while (zzdVar != null) {
            zzd<K, V> zzdVar2 = zzdVar.bfs;
            zzd<K, V> zzdVar3 = zzdVar.bft;
            int i = zzdVar2 != null ? zzdVar2.height : 0;
            int i2 = zzdVar3 != null ? zzdVar3.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                zzd<K, V> zzdVar4 = zzdVar3.bfs;
                zzd<K, V> zzdVar5 = zzdVar3.bft;
                int i4 = (zzdVar4 != null ? zzdVar4.height : 0) - (zzdVar5 != null ? zzdVar5.height : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    zza(zzdVar);
                } else {
                    if (!$assertionsDisabled && i4 != 1) {
                        throw new AssertionError();
                    }
                    zzb(zzdVar3);
                    zza(zzdVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                zzd<K, V> zzdVar6 = zzdVar2.bfs;
                zzd<K, V> zzdVar7 = zzdVar2.bft;
                int i5 = (zzdVar6 != null ? zzdVar6.height : 0) - (zzdVar7 != null ? zzdVar7.height : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    zzb(zzdVar);
                } else {
                    if (!$assertionsDisabled && i5 != -1) {
                        throw new AssertionError();
                    }
                    zza(zzdVar2);
                    zzb(zzdVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                zzdVar.height = i + 1;
                if (z) {
                    return;
                }
            } else {
                if (!$assertionsDisabled && i3 != -1 && i3 != 1) {
                    throw new AssertionError();
                }
                zzdVar.height = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            zzdVar = zzdVar.bfr;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.bfh = null;
        this.size = 0;
        this.modCount++;
        zzd<K, V> zzdVar = this.bfi;
        zzdVar.bfu = zzdVar;
        zzdVar.bfo = zzdVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return zzco(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        zza zzaVar = this.bfj;
        if (zzaVar != null) {
            return zzaVar;
        }
        zza zzaVar2 = new zza();
        this.bfj = zzaVar2;
        return zzaVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        zzd<K, V> zzdVarZzco = zzco(obj);
        if (zzdVarZzco != null) {
            return zzdVarZzco.aQx;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        zzb zzbVar = this.bfk;
        if (zzbVar != null) {
            return zzbVar;
        }
        zzb zzbVar2 = new zzb();
        this.bfk = zzbVar2;
        return zzbVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        zzd<K, V> zzdVarZza = zza((Object) k, true);
        V v2 = zzdVarZza.aQx;
        zzdVarZza.aQx = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzd<K, V> zzdVarZzcp = zzcp(obj);
        if (zzdVarZzcp != null) {
            return zzdVarZzcp.aQx;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    zzd<K, V> zza(K k, boolean z) {
        zzd<K, V> zzdVar;
        int i;
        zzd<K, V> zzdVar2;
        Comparator<? super K> comparator = this.aQi;
        zzd<K, V> zzdVar3 = this.bfh;
        if (zzdVar3 != null) {
            Comparable comparable = comparator == bfg ? (Comparable) k : null;
            while (true) {
                int iCompareTo = comparable != null ? comparable.compareTo(zzdVar3.aQw) : comparator.compare(k, zzdVar3.aQw);
                if (iCompareTo == 0) {
                    return zzdVar3;
                }
                zzd<K, V> zzdVar4 = iCompareTo < 0 ? zzdVar3.bfs : zzdVar3.bft;
                if (zzdVar4 == null) {
                    int i2 = iCompareTo;
                    zzdVar = zzdVar3;
                    i = i2;
                    break;
                }
                zzdVar3 = zzdVar4;
            }
        } else {
            zzdVar = zzdVar3;
            i = 0;
        }
        if (!z) {
            return null;
        }
        zzd<K, V> zzdVar5 = this.bfi;
        if (zzdVar != null) {
            zzdVar2 = new zzd<>(zzdVar, k, zzdVar5, zzdVar5.bfu);
            if (i < 0) {
                zzdVar.bfs = zzdVar2;
            } else {
                zzdVar.bft = zzdVar2;
            }
            zzb(zzdVar, true);
        } else {
            if (comparator == bfg && !(k instanceof Comparable)) {
                throw new ClassCastException(String.valueOf(k.getClass().getName()).concat(" is not Comparable"));
            }
            zzdVar2 = new zzd<>(zzdVar, k, zzdVar5, zzdVar5.bfu);
            this.bfh = zzdVar2;
        }
        this.size++;
        this.modCount++;
        return zzdVar2;
    }

    void zza(zzd<K, V> zzdVar, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            zzdVar.bfu.bfo = zzdVar.bfo;
            zzdVar.bfo.bfu = zzdVar.bfu;
        }
        zzd<K, V> zzdVar2 = zzdVar.bfs;
        zzd<K, V> zzdVar3 = zzdVar.bft;
        zzd<K, V> zzdVar4 = zzdVar.bfr;
        if (zzdVar2 == null || zzdVar3 == null) {
            if (zzdVar2 != null) {
                zza(zzdVar, zzdVar2);
                zzdVar.bfs = null;
            } else if (zzdVar3 != null) {
                zza(zzdVar, zzdVar3);
                zzdVar.bft = null;
            } else {
                zza(zzdVar, (zzd) null);
            }
            zzb(zzdVar4, false);
            this.size--;
            this.modCount++;
            return;
        }
        zzd<K, V> zzdVarM19e = zzdVar2.height > zzdVar3.height ? zzdVar2.m19e() : zzdVar3.m18d();
        zza((zzd) zzdVarM19e, false);
        zzd<K, V> zzdVar5 = zzdVar.bfs;
        if (zzdVar5 != null) {
            i = zzdVar5.height;
            zzdVarM19e.bfs = zzdVar5;
            zzdVar5.bfr = zzdVarM19e;
            zzdVar.bfs = null;
        } else {
            i = 0;
        }
        zzd<K, V> zzdVar6 = zzdVar.bft;
        if (zzdVar6 != null) {
            i2 = zzdVar6.height;
            zzdVarM19e.bft = zzdVar6;
            zzdVar6.bfr = zzdVarM19e;
            zzdVar.bft = null;
        }
        zzdVarM19e.height = Math.max(i, i2) + 1;
        zza(zzdVar, zzdVarM19e);
    }

    zzd<K, V> zzc(Map.Entry<?, ?> entry) {
        zzd<K, V> zzdVarZzco = zzco(entry.getKey());
        if (zzdVarZzco != null && equal(zzdVarZzco.aQx, entry.getValue())) {
            return zzdVarZzco;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    zzd<K, V> zzco(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return zza(obj, false);
        } catch (ClassCastException e) {
            return null;
        }
    }

    zzd<K, V> zzcp(Object obj) {
        zzd<K, V> zzdVarZzco = zzco(obj);
        if (zzdVarZzco != null) {
            zza((zzd) zzdVarZzco, true);
        }
        return zzdVarZzco;
    }
}
