package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: ye */
    private static final Object f238ye = new Object();

    /* JADX INFO: renamed from: yf */
    private static ClassLoader f239yf = null;

    /* JADX INFO: renamed from: yg */
    private static Integer f240yg = null;

    /* JADX INFO: renamed from: yh */
    private boolean f241yh = false;

    protected static ClassLoader zzaso() {
        synchronized (f238ye) {
        }
        return null;
    }

    protected static Integer zzasp() {
        synchronized (f238ye) {
        }
        return null;
    }

    private static boolean zzd(Class<?> cls) {
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (IllegalAccessException e) {
            return false;
        } catch (NoSuchFieldException e2) {
            return false;
        }
    }

    protected static boolean zzhl(String str) {
        ClassLoader classLoaderZzaso = zzaso();
        if (classLoaderZzaso == null) {
            return true;
        }
        try {
            return zzd(classLoaderZzaso.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean zzasq() {
        return false;
    }
}
