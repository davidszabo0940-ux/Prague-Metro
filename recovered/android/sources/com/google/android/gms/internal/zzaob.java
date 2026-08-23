package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzaob<E> extends zzank<Object> {
    public static final zzanl bfE = new zzanl() { // from class: com.google.android.gms.internal.zzaob.1
        @Override // com.google.android.gms.internal.zzanl
        public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
            Type typeM34t = zzaooVar.m34t();
            if (!(typeM34t instanceof GenericArrayType) && (!(typeM34t instanceof Class) || !((Class) typeM34t).isArray())) {
                return null;
            }
            Type typeZzh = zzanr.zzh(typeM34t);
            return new zzaob(zzamsVar, zzamsVar.zza(zzaoo.zzl(typeZzh)), zzanr.zzf(typeZzh));
        }
    };
    private final Class<E> bfF;
    private final zzank<E> bfG;

    public zzaob(zzams zzamsVar, zzank<E> zzankVar, Class<E> cls) {
        this.bfG = new zzaom(zzamsVar, zzankVar, cls);
        this.bfF = cls;
    }

    @Override // com.google.android.gms.internal.zzank
    public void zza(zzaor zzaorVar, Object obj) throws IOException {
        if (obj == null) {
            zzaorVar.mo32r();
            return;
        }
        zzaorVar.mo28n();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.bfG.zza(zzaorVar, (E) Array.get(obj, i));
        }
        zzaorVar.mo29o();
    }

    @Override // com.google.android.gms.internal.zzank
    public Object zzb(zzaop zzaopVar) throws IOException {
        if (zzaopVar.mo24h() == zzaoq.NULL) {
            zzaopVar.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        zzaopVar.beginArray();
        while (zzaopVar.hasNext()) {
            arrayList.add(this.bfG.zzb(zzaopVar));
        }
        zzaopVar.endArray();
        Object objNewInstance = Array.newInstance((Class<?>) this.bfF, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }
}
