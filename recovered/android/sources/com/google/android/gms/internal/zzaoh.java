package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzaoh implements zzanl {
    private final zzans beb;
    private final boolean bfQ;

    private final class zza<K, V> extends zzank<Map<K, V>> {
        private final zzanx<? extends Map<K, V>> bfI;
        private final zzank<K> bfR;
        private final zzank<V> bfS;

        public zza(zzams zzamsVar, Type type, zzank<K> zzankVar, Type type2, zzank<V> zzankVar2, zzanx<? extends Map<K, V>> zzanxVar) {
            this.bfR = new zzaom(zzamsVar, zzankVar, type);
            this.bfS = new zzaom(zzamsVar, zzankVar2, type2);
            this.bfI = zzanxVar;
        }

        private String zze(zzamy zzamyVar) {
            if (!zzamyVar.zzczo()) {
                if (zzamyVar.zzczp()) {
                    return "null";
                }
                throw new AssertionError();
            }
            zzane zzaneVarZzczs = zzamyVar.zzczs();
            if (zzaneVarZzczs.zzczv()) {
                return String.valueOf(zzaneVarZzczs.zzczg());
            }
            if (zzaneVarZzczs.zzczu()) {
                return Boolean.toString(zzaneVarZzczs.zzczl());
            }
            if (zzaneVarZzczs.zzczw()) {
                return zzaneVarZzczs.zzczh();
            }
            throw new AssertionError();
        }

        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                zzaorVar.mo32r();
                return;
            }
            if (!zzaoh.this.bfQ) {
                zzaorVar.mo30p();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    zzaorVar.zzta(String.valueOf(entry.getKey()));
                    this.bfS.zza(zzaorVar, entry.getValue());
                }
                zzaorVar.mo31q();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                zzamy zzamyVarZzcl = this.bfR.zzcl(entry2.getKey());
                arrayList.add(zzamyVarZzcl);
                arrayList2.add(entry2.getValue());
                z = (zzamyVarZzcl.zzczm() || zzamyVarZzcl.zzczn()) | z;
            }
            if (!z) {
                zzaorVar.mo30p();
                while (i < arrayList.size()) {
                    zzaorVar.zzta(zze((zzamy) arrayList.get(i)));
                    this.bfS.zza(zzaorVar, (V) arrayList2.get(i));
                    i++;
                }
                zzaorVar.mo31q();
                return;
            }
            zzaorVar.mo28n();
            while (i < arrayList.size()) {
                zzaorVar.mo28n();
                zzanz.zzb((zzamy) arrayList.get(i), zzaorVar);
                this.bfS.zza(zzaorVar, (V) arrayList2.get(i));
                zzaorVar.mo29o();
                i++;
            }
            zzaorVar.mo29o();
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
        public Map<K, V> zzb(zzaop zzaopVar) throws IOException {
            zzaoq zzaoqVarMo24h = zzaopVar.mo24h();
            if (zzaoqVarMo24h == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            Map<K, V> mapMo15a = this.bfI.mo15a();
            if (zzaoqVarMo24h != zzaoq.BEGIN_ARRAY) {
                zzaopVar.beginObject();
                while (zzaopVar.hasNext()) {
                    zzanu.bff.zzi(zzaopVar);
                    K kZzb = this.bfR.zzb(zzaopVar);
                    if (mapMo15a.put(kZzb, this.bfS.zzb(zzaopVar)) != null) {
                        String strValueOf = String.valueOf(kZzb);
                        throw new zzanh(new StringBuilder(String.valueOf(strValueOf).length() + 15).append("duplicate key: ").append(strValueOf).toString());
                    }
                }
                zzaopVar.endObject();
                return mapMo15a;
            }
            zzaopVar.beginArray();
            while (zzaopVar.hasNext()) {
                zzaopVar.beginArray();
                K kZzb2 = this.bfR.zzb(zzaopVar);
                if (mapMo15a.put(kZzb2, this.bfS.zzb(zzaopVar)) != null) {
                    String strValueOf2 = String.valueOf(kZzb2);
                    throw new zzanh(new StringBuilder(String.valueOf(strValueOf2).length() + 15).append("duplicate key: ").append(strValueOf2).toString());
                }
                zzaopVar.endArray();
            }
            zzaopVar.endArray();
            return mapMo15a;
        }
    }

    public zzaoh(zzans zzansVar, boolean z) {
        this.beb = zzansVar;
        this.bfQ = z;
    }

    private zzank<?> zza(zzams zzamsVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? zzaon.bgm : zzamsVar.zza(zzaoo.zzl(type));
    }

    @Override // com.google.android.gms.internal.zzanl
    public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
        Type typeM34t = zzaooVar.m34t();
        if (!Map.class.isAssignableFrom(zzaooVar.m33s())) {
            return null;
        }
        Type[] typeArrZzb = zzanr.zzb(typeM34t, zzanr.zzf(typeM34t));
        return new zza(zzamsVar, typeArrZzb[0], zza(zzamsVar, typeArrZzb[0]), typeArrZzb[1], zzamsVar.zza(zzaoo.zzl(typeArrZzb[1])), this.beb.zzb(zzaooVar));
    }
}
