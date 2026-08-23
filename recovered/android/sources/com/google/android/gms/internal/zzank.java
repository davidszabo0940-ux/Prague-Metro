package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzank<T> {
    public abstract void zza(zzaor zzaorVar, T t) throws IOException;

    public abstract T zzb(zzaop zzaopVar) throws IOException;

    public final zzamy zzcl(T t) {
        try {
            zzaog zzaogVar = new zzaog();
            zza(zzaogVar, t);
            return zzaogVar.m27l();
        } catch (IOException e) {
            throw new zzamz(e);
        }
    }
}
