package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes.dex */
final class zzaom<T> extends zzank<T> {
    private final zzank<T> bej;
    private final zzams bgf;
    private final Type bgg;

    zzaom(zzams zzamsVar, zzank<T> zzankVar, Type type) {
        this.bgf = zzamsVar;
        this.bej = zzankVar;
        this.bgg = type;
    }

    private Type zzb(Type type, Object obj) {
        if (obj != null) {
            return (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type;
        }
        return type;
    }

    @Override // com.google.android.gms.internal.zzank
    public void zza(zzaor zzaorVar, T t) throws IOException {
        zzank<T> zzankVarZza = this.bej;
        Type typeZzb = zzb(this.bgg, t);
        if (typeZzb != this.bgg) {
            zzankVarZza = this.bgf.zza(zzaoo.zzl(typeZzb));
            if ((zzankVarZza instanceof zzaoj.zza) && !(this.bej instanceof zzaoj.zza)) {
                zzankVarZza = this.bej;
            }
        }
        zzankVarZza.zza(zzaorVar, t);
    }

    @Override // com.google.android.gms.internal.zzank
    public T zzb(zzaop zzaopVar) throws IOException {
        return this.bej.zzb(zzaopVar);
    }
}
