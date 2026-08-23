package com.google.android.gms.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzaoa {
    /* JADX INFO: renamed from: f */
    public static zzaoa m20f() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            final Method method = cls.getMethod("allocateInstance", Class.class);
            return new zzaoa() { // from class: com.google.android.gms.internal.zzaoa.1
                @Override // com.google.android.gms.internal.zzaoa
                public <T> T zzf(Class<T> cls2) throws Exception {
                    return (T) method.invoke(obj, cls2);
                }
            };
        } catch (Exception e) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod.setAccessible(true);
                final int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod2.setAccessible(true);
                return new zzaoa() { // from class: com.google.android.gms.internal.zzaoa.2
                    @Override // com.google.android.gms.internal.zzaoa
                    public <T> T zzf(Class<T> cls2) throws Exception {
                        return (T) declaredMethod2.invoke(null, cls2, Integer.valueOf(iIntValue));
                    }
                };
            } catch (Exception e2) {
                try {
                    final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new zzaoa() { // from class: com.google.android.gms.internal.zzaoa.3
                        @Override // com.google.android.gms.internal.zzaoa
                        public <T> T zzf(Class<T> cls2) throws Exception {
                            return (T) declaredMethod3.invoke(null, cls2, Object.class);
                        }
                    };
                } catch (Exception e3) {
                    return new zzaoa() { // from class: com.google.android.gms.internal.zzaoa.4
                        @Override // com.google.android.gms.internal.zzaoa
                        public <T> T zzf(Class<T> cls2) {
                            String strValueOf = String.valueOf(cls2);
                            throw new UnsupportedOperationException(new StringBuilder(String.valueOf(strValueOf).length() + 16).append("Cannot allocate ").append(strValueOf).toString());
                        }
                    };
                }
            }
        }
    }

    public abstract <T> T zzf(Class<T> cls) throws Exception;
}
