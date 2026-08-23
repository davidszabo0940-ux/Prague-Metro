package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzm {

    /* JADX INFO: renamed from: yA */
    private static zzm f352yA;

    /* JADX INFO: renamed from: yz */
    private static final Object f353yz = new Object();

    public static zzm zzce(Context context) {
        synchronized (f353yz) {
            if (f352yA == null) {
                f352yA = new zzn(context.getApplicationContext());
            }
        }
        return f352yA;
    }

    public abstract boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean zza(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void zzb(String str, String str2, ServiceConnection serviceConnection, String str3);
}
