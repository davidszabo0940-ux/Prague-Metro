package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzany {
    private static final Map<Class<?>, Class<?>> bfv;
    private static final Map<Class<?>, Class<?>> bfw;

    static {
        HashMap map = new HashMap(16);
        HashMap map2 = new HashMap(16);
        zza(map, map2, Boolean.TYPE, Boolean.class);
        zza(map, map2, Byte.TYPE, Byte.class);
        zza(map, map2, Character.TYPE, Character.class);
        zza(map, map2, Double.TYPE, Double.class);
        zza(map, map2, Float.TYPE, Float.class);
        zza(map, map2, Integer.TYPE, Integer.class);
        zza(map, map2, Long.TYPE, Long.class);
        zza(map, map2, Short.TYPE, Short.class);
        zza(map, map2, Void.TYPE, Void.class);
        bfv = Collections.unmodifiableMap(map);
        bfw = Collections.unmodifiableMap(map2);
    }

    private static void zza(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean zzk(Type type) {
        return bfv.containsKey(type);
    }

    public static <T> Class<T> zzp(Class<T> cls) {
        Class<T> cls2 = (Class) bfv.get(zzanq.zzaa(cls));
        return cls2 == null ? cls : cls2;
    }
}
