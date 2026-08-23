package com.unity3d.player;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class ReflectionHelper {
    protected static final boolean LOGV = false;
    protected static boolean LOG = false;

    /* JADX INFO: renamed from: a */
    private static C0665a[] f874a = new C0665a[4096];

    /* JADX INFO: renamed from: com.unity3d.player.ReflectionHelper$a */
    private static class C0665a {

        /* JADX INFO: renamed from: a */
        public volatile Member f877a;

        /* JADX INFO: renamed from: b */
        private final Class f878b;

        /* JADX INFO: renamed from: c */
        private final String f879c;

        /* JADX INFO: renamed from: d */
        private final String f880d;

        /* JADX INFO: renamed from: e */
        private final int f881e;

        C0665a(Class cls, String str, String str2) {
            this.f878b = cls;
            this.f879c = str;
            this.f880d = str2;
            this.f881e = ((((this.f878b.hashCode() + 527) * 31) + this.f879c.hashCode()) * 31) + this.f880d.hashCode();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0665a)) {
                return false;
            }
            C0665a c0665a = (C0665a) obj;
            return this.f881e == c0665a.f881e && this.f880d.equals(c0665a.f880d) && this.f879c.equals(c0665a.f879c) && this.f878b.equals(c0665a.f878b);
        }

        public final int hashCode() {
            return this.f881e;
        }
    }

    ReflectionHelper() {
    }

    /* JADX INFO: renamed from: a */
    private static float m96a(Class cls, Class cls2) {
        if (cls.equals(cls2)) {
            return 1.0f;
        }
        if (!cls.isPrimitive() && !cls2.isPrimitive()) {
            try {
                if (cls.asSubclass(cls2) != null) {
                    return 0.5f;
                }
            } catch (ClassCastException e) {
            }
            try {
                if (cls2.asSubclass(cls) != null) {
                    return 0.1f;
                }
            } catch (ClassCastException e2) {
            }
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: a */
    private static float m97a(Class cls, Class[] clsArr, Class[] clsArr2) {
        int i = 0;
        if (clsArr2.length == 0) {
            return 0.1f;
        }
        if ((clsArr == null ? 0 : clsArr.length) + 1 != clsArr2.length) {
            return 0.0f;
        }
        float fM96a = 1.0f;
        if (clsArr != null) {
            int length = clsArr.length;
            int i2 = 0;
            while (i < length) {
                fM96a *= m96a(clsArr[i], clsArr2[i2]);
                i++;
                i2++;
            }
        }
        return fM96a * m96a(cls, clsArr2[clsArr2.length - 1]);
    }

    /* JADX INFO: renamed from: a */
    private static Class m98a(String str, int[] iArr) {
        while (iArr[0] < str.length()) {
            int i = iArr[0];
            iArr[0] = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != '(' && cCharAt != ')') {
                if (cCharAt != 'L') {
                    if (cCharAt != 'Z') {
                        if (cCharAt != 'I') {
                            if (cCharAt != 'F') {
                                if (cCharAt != 'V') {
                                    if (cCharAt != 'B') {
                                        if (cCharAt != 'S') {
                                            if (cCharAt != 'J') {
                                                if (cCharAt != 'D') {
                                                    if (cCharAt != '[') {
                                                        C0701m.Log(5, "! parseType; " + cCharAt + " is not known!");
                                                        break;
                                                    }
                                                    return Array.newInstance((Class<?>) m98a(str, iArr), 0).getClass();
                                                }
                                                return Double.TYPE;
                                            }
                                            return Long.TYPE;
                                        }
                                        return Short.TYPE;
                                    }
                                    return Byte.TYPE;
                                }
                                return Void.TYPE;
                            }
                            return Float.TYPE;
                        }
                        return Integer.TYPE;
                    }
                    return Boolean.TYPE;
                }
                int iIndexOf = str.indexOf(59, iArr[0]);
                if (iIndexOf == -1) {
                    break;
                }
                String strSubstring = str.substring(iArr[0], iIndexOf);
                iArr[0] = iIndexOf + 1;
                try {
                    return Class.forName(strSubstring.replace('/', '.'));
                } catch (ClassNotFoundException e) {
                    break;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static void m101a(C0665a c0665a, Member member) {
        c0665a.f877a = member;
        f874a[c0665a.hashCode() & (f874a.length - 1)] = c0665a;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m102a(C0665a c0665a) {
        C0665a c0665a2 = f874a[c0665a.hashCode() & (f874a.length - 1)];
        if (!c0665a.equals(c0665a2)) {
            return false;
        }
        c0665a.f877a = c0665a2.f877a;
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static Class[] m103a(String str) {
        Class clsM98a;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length() && (clsM98a = m98a(str, iArr)) != null) {
            arrayList.add(clsM98a);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            clsArr[i] = (Class) it.next();
            i++;
        }
        return clsArr;
    }

    protected static Constructor getConstructorID(Class cls, String str) {
        Constructor<?> constructor;
        Constructor<?> constructor2;
        Constructor<?> constructor3;
        Constructor<?> constructor4 = null;
        C0665a c0665a = new C0665a(cls, "", str);
        if (m102a(c0665a)) {
            constructor2 = (Constructor) c0665a.f877a;
        } else {
            Class[] clsArrM103a = m103a(str);
            float f = 0.0f;
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    constructor = constructor4;
                    break;
                }
                constructor = constructors[i];
                float fM97a = m97a(Void.TYPE, constructor.getParameterTypes(), clsArrM103a);
                if (fM97a <= f) {
                    fM97a = f;
                    constructor3 = constructor4;
                } else {
                    if (fM97a == 1.0f) {
                        break;
                    }
                    constructor3 = constructor;
                }
                i++;
                constructor4 = constructor3;
                f = fM97a;
            }
            m101a(c0665a, constructor);
            constructor2 = constructor;
        }
        if (constructor2 == null) {
            throw new NoSuchMethodError("<init>" + str + " in class " + cls.getName());
        }
        return constructor2;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ac  */
    protected static Field getFieldID(Class cls, String str, String str2, boolean z) {
        Field field;
        float fM97a;
        Field field2;
        C0665a c0665a = new C0665a(cls, str, str2);
        if (m102a(c0665a)) {
            field = (Field) c0665a.f877a;
        } else {
            Class[] clsArrM103a = m103a(str2);
            field = null;
            float f = 0.0f;
            while (cls != null) {
                Field[] declaredFields = cls.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                Field field3 = field;
                while (true) {
                    if (i >= length) {
                        field = field3;
                        break;
                    }
                    Field field4 = declaredFields[i];
                    if (z == Modifier.isStatic(field4.getModifiers()) && field4.getName().compareTo(str) == 0) {
                        fM97a = m97a(field4.getType(), (Class[]) null, clsArrM103a);
                        if (fM97a <= f) {
                            fM97a = f;
                            field2 = field3;
                        } else {
                            if (fM97a == 1.0f) {
                                f = fM97a;
                                field = field4;
                                break;
                            }
                            field2 = field4;
                        }
                    } else {
                        fM97a = f;
                        field2 = field3;
                    }
                    i++;
                    field3 = field2;
                    f = fM97a;
                }
                if (f == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            m101a(c0665a, field);
        }
        if (field != null) {
            return field;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "non-static" : "static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls.getName();
        throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00af  */
    protected static Method getMethodID(Class cls, String str, String str2, boolean z) {
        Method method;
        float fM97a;
        Method method2;
        C0665a c0665a = new C0665a(cls, str, str2);
        if (m102a(c0665a)) {
            method = (Method) c0665a.f877a;
        } else {
            Class[] clsArrM103a = m103a(str2);
            method = null;
            float f = 0.0f;
            while (cls != null) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i = 0;
                Method method3 = method;
                while (true) {
                    if (i >= length) {
                        method = method3;
                        break;
                    }
                    Method method4 = declaredMethods[i];
                    if (z == Modifier.isStatic(method4.getModifiers()) && method4.getName().compareTo(str) == 0) {
                        fM97a = m97a(method4.getReturnType(), method4.getParameterTypes(), clsArrM103a);
                        if (fM97a <= f) {
                            fM97a = f;
                            method2 = method3;
                        } else {
                            if (fM97a == 1.0f) {
                                f = fM97a;
                                method = method4;
                                break;
                            }
                            method2 = method4;
                        }
                    } else {
                        fM97a = f;
                        method2 = method3;
                    }
                    i++;
                    method3 = method2;
                    f = fM97a;
                }
                if (f == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            m101a(c0665a, method);
        }
        if (method != null) {
            return method;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "non-static" : "static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls.getName();
        throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyFinalize(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native Object nativeProxyInvoke(int i, String str, Object[] objArr);

    protected static Object newProxyInstance(int i, Class cls) {
        return newProxyInstance(i, new Class[]{cls});
    }

    protected static Object newProxyInstance(final int i, final Class[] clsArr) {
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new InvocationHandler() { // from class: com.unity3d.player.ReflectionHelper.1
            protected final void finalize() throws Throwable {
                try {
                    ReflectionHelper.nativeProxyFinalize(i);
                } finally {
                    super.finalize();
                }
            }

            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return ReflectionHelper.nativeProxyInvoke(i, method.getName(), objArr);
            }
        });
    }
}
