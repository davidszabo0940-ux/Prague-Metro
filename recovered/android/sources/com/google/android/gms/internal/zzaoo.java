package com.google.android.gms.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class zzaoo<T> {
    final Type bgg;
    final Class<? super T> bhk;
    final int bhl;

    protected zzaoo() {
        this.bgg = zzq(getClass());
        this.bhk = (Class<? super T>) zzanr.zzf(this.bgg);
        this.bhl = this.bgg.hashCode();
    }

    zzaoo(Type type) {
        this.bgg = zzanr.zze((Type) zzanq.zzaa(type));
        this.bhk = (Class<? super T>) zzanr.zzf(this.bgg);
        this.bhl = this.bgg.hashCode();
    }

    public static zzaoo<?> zzl(Type type) {
        return new zzaoo<>(type);
    }

    static Type zzq(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return zzanr.zze(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public static <T> zzaoo<T> zzr(Class<T> cls) {
        return new zzaoo<>(cls);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzaoo) && zzanr.zza(this.bgg, ((zzaoo) obj).bgg);
    }

    public final int hashCode() {
        return this.bhl;
    }

    /* JADX INFO: renamed from: s */
    public final Class<? super T> m33s() {
        return this.bhk;
    }

    /* JADX INFO: renamed from: t */
    public final Type m34t() {
        return this.bgg;
    }

    public final String toString() {
        return zzanr.zzg(this.bgg);
    }
}
