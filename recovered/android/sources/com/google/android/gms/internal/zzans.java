package com.google.android.gms.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzans {
    private final Map<Type, zzamu<?>> ben;

    public zzans(Map<Type, zzamu<?>> map) {
        this.ben = map;
    }

    private <T> zzanx<T> zzc(final Type type, Class<? super T> cls) {
        if (!Collection.class.isAssignableFrom(cls)) {
            if (!Map.class.isAssignableFrom(cls)) {
                return null;
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new zzanx<T>() { // from class: com.google.android.gms.internal.zzans.12
                    @Override // com.google.android.gms.internal.zzanx
                    /* JADX INFO: renamed from: a */
                    public T mo15a() {
                        return (T) new TreeMap();
                    }
                };
            }
            return (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(zzaoo.zzl(((ParameterizedType) type).getActualTypeArguments()[0]).m33s())) ? new zzanx<T>() { // from class: com.google.android.gms.internal.zzans.3
                @Override // com.google.android.gms.internal.zzanx
                /* JADX INFO: renamed from: a */
                public T mo15a() {
                    return (T) new zzanw();
                }
            } : new zzanx<T>() { // from class: com.google.android.gms.internal.zzans.2
                @Override // com.google.android.gms.internal.zzanx
                /* JADX INFO: renamed from: a */
                public T mo15a() {
                    return (T) new LinkedHashMap();
                }
            };
        }
        if (SortedSet.class.isAssignableFrom(cls)) {
            return new zzanx<T>() { // from class: com.google.android.gms.internal.zzans.7
                @Override // com.google.android.gms.internal.zzanx
                /* JADX INFO: renamed from: a */
                public T mo15a() {
                    return (T) new TreeSet();
                }
            };
        }
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new zzanx<T>() { // from class: com.google.android.gms.internal.zzans.8
                @Override // com.google.android.gms.internal.zzanx
                /* JADX INFO: renamed from: a */
                public T mo15a() {
                    if (!(type instanceof ParameterizedType)) {
                        String strValueOf = String.valueOf(type.toString());
                        throw new zzamz(strValueOf.length() != 0 ? "Invalid EnumSet type: ".concat(strValueOf) : new String("Invalid EnumSet type: "));
                    }
                    Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (type2 instanceof Class) {
                        return (T) EnumSet.noneOf((Class) type2);
                    }
                    String strValueOf2 = String.valueOf(type.toString());
                    throw new zzamz(strValueOf2.length() != 0 ? "Invalid EnumSet type: ".concat(strValueOf2) : new String("Invalid EnumSet type: "));
                }
            };
        }
        if (Set.class.isAssignableFrom(cls)) {
            return new zzanx<T>() { // from class: com.google.android.gms.internal.zzans.9
                @Override // com.google.android.gms.internal.zzanx
                /* JADX INFO: renamed from: a */
                public T mo15a() {
                    return (T) new LinkedHashSet();
                }
            };
        }
        return Queue.class.isAssignableFrom(cls) ? new zzanx<T>() { // from class: com.google.android.gms.internal.zzans.10
            @Override // com.google.android.gms.internal.zzanx
            /* JADX INFO: renamed from: a */
            public T mo15a() {
                return (T) new LinkedList();
            }
        } : new zzanx<T>() { // from class: com.google.android.gms.internal.zzans.11
            @Override // com.google.android.gms.internal.zzanx
            /* JADX INFO: renamed from: a */
            public T mo15a() {
                return (T) new ArrayList();
            }
        };
    }

    private <T> zzanx<T> zzd(final Type type, final Class<? super T> cls) {
        return new zzanx<T>() { // from class: com.google.android.gms.internal.zzans.4
            private final zzaoa beQ = zzaoa.m20f();

            @Override // com.google.android.gms.internal.zzanx
            /* JADX INFO: renamed from: a */
            public T mo15a() {
                try {
                    return (T) this.beQ.zzf(cls);
                } catch (Exception e) {
                    String strValueOf = String.valueOf(type);
                    throw new RuntimeException(new StringBuilder(String.valueOf(strValueOf).length() + 116).append("Unable to invoke no-args constructor for ").append(strValueOf).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), e);
                }
            }
        };
    }

    private <T> zzanx<T> zzl(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new zzanx<T>() { // from class: com.google.android.gms.internal.zzans.6
                @Override // com.google.android.gms.internal.zzanx
                /* JADX INFO: renamed from: a */
                public T mo15a() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        String strValueOf = String.valueOf(declaredConstructor);
                        throw new RuntimeException(new StringBuilder(String.valueOf(strValueOf).length() + 30).append("Failed to invoke ").append(strValueOf).append(" with no args").toString(), e2);
                    } catch (InvocationTargetException e3) {
                        String strValueOf2 = String.valueOf(declaredConstructor);
                        throw new RuntimeException(new StringBuilder(String.valueOf(strValueOf2).length() + 30).append("Failed to invoke ").append(strValueOf2).append(" with no args").toString(), e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public String toString() {
        return this.ben.toString();
    }

    public <T> zzanx<T> zzb(zzaoo<T> zzaooVar) {
        final Type typeM34t = zzaooVar.m34t();
        Class<? super T> clsM33s = zzaooVar.m33s();
        final zzamu<?> zzamuVar = this.ben.get(typeM34t);
        if (zzamuVar != null) {
            return new zzanx<T>() { // from class: com.google.android.gms.internal.zzans.1
                @Override // com.google.android.gms.internal.zzanx
                /* JADX INFO: renamed from: a */
                public T mo15a() {
                    return (T) zzamuVar.zza(typeM34t);
                }
            };
        }
        final zzamu<?> zzamuVar2 = this.ben.get(clsM33s);
        if (zzamuVar2 != null) {
            return new zzanx<T>() { // from class: com.google.android.gms.internal.zzans.5
                @Override // com.google.android.gms.internal.zzanx
                /* JADX INFO: renamed from: a */
                public T mo15a() {
                    return (T) zzamuVar2.zza(typeM34t);
                }
            };
        }
        zzanx<T> zzanxVarZzl = zzl(clsM33s);
        if (zzanxVarZzl != null) {
            return zzanxVarZzl;
        }
        zzanx<T> zzanxVarZzc = zzc(typeM34t, clsM33s);
        return zzanxVarZzc == null ? zzd(typeM34t, clsM33s) : zzanxVarZzc;
    }
}
