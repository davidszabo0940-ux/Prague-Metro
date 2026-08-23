package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzab;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzg<T> {

    /* JADX INFO: renamed from: Mb */
    private final String f520Mb;

    /* JADX INFO: renamed from: Mc */
    private T f521Mc;

    public static class zza extends Exception {
        public zza(String str) {
            super(str);
        }

        public zza(String str, Throwable th) {
            super(str, th);
        }
    }

    protected zzg(String str) {
        this.f520Mb = str;
    }

    protected abstract T zzc(IBinder iBinder);

    protected final T zzcr(Context context) throws zza {
        if (this.f521Mc == null) {
            zzab.zzaa(context);
            Context remoteContext = com.google.android.gms.common.zze.getRemoteContext(context);
            if (remoteContext == null) {
                throw new zza("Could not get remote context.");
            }
            try {
                this.f521Mc = zzc((IBinder) remoteContext.getClassLoader().loadClass(this.f520Mb).newInstance());
            } catch (ClassNotFoundException e) {
                throw new zza("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new zza("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new zza("Could not instantiate creator.", e3);
            }
        }
        return this.f521Mc;
    }
}
