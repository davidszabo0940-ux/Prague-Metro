package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaow;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzaox<M extends zzaow<M>, T> {
    protected final Class<T> bau;
    protected final boolean bic;
    public final int tag;
    protected final int type;

    private zzaox(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.bau = cls;
        this.tag = i2;
        this.bic = z;
    }

    public static <M extends zzaow<M>, T extends zzapc> zzaox<M, T> zza(int i, Class<T> cls, long j) {
        return new zzaox<>(i, cls, (int) j, false);
    }

    private T zzaw(List<zzape> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzape zzapeVar = list.get(i);
            if (zzapeVar.bil.length != 0) {
                zza(zzapeVar, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T tCast = this.bau.cast(Array.newInstance(this.bau.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(tCast, i2, arrayList.get(i2));
        }
        return tCast;
    }

    private T zzax(List<zzape> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.bau.cast(zzcf(zzaou.zzaz(list.get(list.size() - 1).bil)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaox)) {
            return false;
        }
        zzaox zzaoxVar = (zzaox) obj;
        return this.type == zzaoxVar.type && this.bau == zzaoxVar.bau && this.tag == zzaoxVar.tag && this.bic == zzaoxVar.bic;
    }

    public int hashCode() {
        return (this.bic ? 1 : 0) + ((((((this.type + 1147) * 31) + this.bau.hashCode()) * 31) + this.tag) * 31);
    }

    protected void zza(zzape zzapeVar, List<Object> list) {
        list.add(zzcf(zzaou.zzaz(zzapeVar.bil)));
    }

    void zza(Object obj, zzaov zzaovVar) throws IOException {
        if (this.bic) {
            zzc(obj, zzaovVar);
        } else {
            zzb(obj, zzaovVar);
        }
    }

    final T zzav(List<zzape> list) {
        if (list == null) {
            return null;
        }
        return this.bic ? zzaw(list) : zzax(list);
    }

    protected void zzb(Object obj, zzaov zzaovVar) {
        try {
            zzaovVar.zzaes(this.tag);
            switch (this.type) {
                case 10:
                    int iZzafa = zzapf.zzafa(this.tag);
                    zzaovVar.zzb((zzapc) obj);
                    zzaovVar.zzai(iZzafa, 4);
                    return;
                case 11:
                    zzaovVar.zzc((zzapc) obj);
                    return;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    protected void zzc(Object obj, zzaov zzaovVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, zzaovVar);
            }
        }
    }

    protected Object zzcf(zzaou zzaouVar) {
        Class componentType = this.bic ? this.bau.getComponentType() : this.bau;
        try {
            switch (this.type) {
                case 10:
                    zzapc zzapcVar = (zzapc) componentType.newInstance();
                    zzaouVar.zza(zzapcVar, zzapf.zzafa(this.tag));
                    return zzapcVar;
                case 11:
                    zzapc zzapcVar2 = (zzapc) componentType.newInstance();
                    zzaouVar.zza(zzapcVar2);
                    return zzapcVar2;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading extension field", e);
        } catch (IllegalAccessException e2) {
            String strValueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf).length() + 33).append("Error creating instance of class ").append(strValueOf).toString(), e2);
        } catch (InstantiationException e3) {
            String strValueOf2 = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf2).length() + 33).append("Error creating instance of class ").append(strValueOf2).toString(), e3);
        }
    }

    int zzcr(Object obj) {
        return this.bic ? zzcs(obj) : zzct(obj);
    }

    protected int zzcs(Object obj) {
        int iZzct = 0;
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            if (Array.get(obj, i) != null) {
                iZzct += zzct(Array.get(obj, i));
            }
        }
        return iZzct;
    }

    protected int zzct(Object obj) {
        int iZzafa = zzapf.zzafa(this.tag);
        switch (this.type) {
            case 10:
                return zzaov.zzb(iZzafa, (zzapc) obj);
            case 11:
                return zzaov.zzc(iZzafa, (zzapc) obj);
            default:
                throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
        }
    }
}
