package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzaoi extends zzank<Object> {
    public static final zzanl bfE = new zzanl() { // from class: com.google.android.gms.internal.zzaoi.1
        @Override // com.google.android.gms.internal.zzanl
        public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
            if (zzaooVar.m33s() == Object.class) {
                return new zzaoi(zzamsVar);
            }
            return null;
        }
    };
    private final zzams beA;

    private zzaoi(zzams zzamsVar) {
        this.beA = zzamsVar;
    }

    @Override // com.google.android.gms.internal.zzank
    public void zza(zzaor zzaorVar, Object obj) throws IOException {
        if (obj == null) {
            zzaorVar.mo32r();
            return;
        }
        zzank zzankVarZzk = this.beA.zzk(obj.getClass());
        if (!(zzankVarZzk instanceof zzaoi)) {
            zzankVarZzk.zza(zzaorVar, obj);
        } else {
            zzaorVar.mo30p();
            zzaorVar.mo31q();
        }
    }

    @Override // com.google.android.gms.internal.zzank
    public Object zzb(zzaop zzaopVar) throws IOException {
        switch (zzaopVar.mo24h()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                zzaopVar.beginArray();
                while (zzaopVar.hasNext()) {
                    arrayList.add(zzb(zzaopVar));
                }
                zzaopVar.endArray();
                return arrayList;
            case BEGIN_OBJECT:
                zzanw zzanwVar = new zzanw();
                zzaopVar.beginObject();
                while (zzaopVar.hasNext()) {
                    zzanwVar.put(zzaopVar.nextName(), zzb(zzaopVar));
                }
                zzaopVar.endObject();
                return zzanwVar;
            case STRING:
                return zzaopVar.nextString();
            case NUMBER:
                return Double.valueOf(zzaopVar.nextDouble());
            case BOOLEAN:
                return Boolean.valueOf(zzaopVar.nextBoolean());
            case NULL:
                zzaopVar.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
