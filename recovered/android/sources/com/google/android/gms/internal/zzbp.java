package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbp implements Callable {
    protected final String TAG = getClass().getSimpleName();
    protected final String className;
    protected final zzax zzaey;
    protected final zzae.zza zzaha;
    protected final String zzahf;
    protected Method zzahh;
    protected final int zzahl;
    protected final int zzahm;

    public zzbp(zzax zzaxVar, String str, String str2, zzae.zza zzaVar, int i, int i2) {
        this.zzaey = zzaxVar;
        this.className = str;
        this.zzahf = str2;
        this.zzaha = zzaVar;
        this.zzahl = i;
        this.zzahm = i2;
    }

    protected abstract void zzcv() throws IllegalAccessException, InvocationTargetException;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: zzcy, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        try {
            long jNanoTime = System.nanoTime();
            this.zzahh = this.zzaey.zzc(this.className, this.zzahf);
            if (this.zzahh != null) {
                zzcv();
                zzam zzamVarZzcl = this.zzaey.zzcl();
                if (zzamVarZzcl != null && this.zzahl != Integer.MIN_VALUE) {
                    zzamVarZzcl.zza(this.zzahm, this.zzahl, (System.nanoTime() - jNanoTime) / 1000);
                }
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return null;
    }
}
