package bitter.jnibridge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes.dex */
public class JNIBridge {

    /* JADX INFO: renamed from: bitter.jnibridge.JNIBridge$a */
    private static class C0225a implements InvocationHandler {

        /* JADX INFO: renamed from: a */
        private Object f19a = new Object[0];

        /* JADX INFO: renamed from: b */
        private long f20b;

        public C0225a(long j) {
            this.f20b = j;
        }

        /* JADX INFO: renamed from: a */
        public final void m13a() {
            synchronized (this.f19a) {
                this.f20b = 0L;
            }
        }

        public final void finalize() {
            synchronized (this.f19a) {
                if (this.f20b == 0) {
                    return;
                }
                JNIBridge.delete(this.f20b);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Object objInvoke;
            synchronized (this.f19a) {
                objInvoke = this.f20b == 0 ? null : JNIBridge.invoke(this.f20b, method.getDeclaringClass(), method, objArr);
            }
            return objInvoke;
        }
    }

    static native void delete(long j);

    static void disableInterfaceProxy(Object obj) {
        ((C0225a) Proxy.getInvocationHandler(obj)).m13a();
    }

    static native Object invoke(long j, Class cls, Method method, Object[] objArr);

    static Object newInterfaceProxy(long j, Class[] clsArr) {
        return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), clsArr, new C0225a(j));
    }
}
