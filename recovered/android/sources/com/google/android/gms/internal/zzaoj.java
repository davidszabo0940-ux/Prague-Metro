package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzaoj implements zzanl {
    private final zzans beb;
    private final zzant bek;
    private final zzamr bem;

    public static final class zza<T> extends zzank<T> {
        private final zzanx<T> bfI;
        private final Map<String, zzb> bgb;

        private zza(zzanx<T> zzanxVar, Map<String, zzb> map) {
            this.bfI = zzanxVar;
            this.bgb = map;
        }

        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, T t) throws IOException {
            if (t == null) {
                zzaorVar.mo32r();
                return;
            }
            zzaorVar.mo30p();
            try {
                for (zzb zzbVar : this.bgb.values()) {
                    if (zzbVar.zzcq(t)) {
                        zzaorVar.zzta(zzbVar.name);
                        zzbVar.zza(zzaorVar, t);
                    }
                }
                zzaorVar.mo31q();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }

        @Override // com.google.android.gms.internal.zzank
        public T zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            T tMo15a = this.bfI.mo15a();
            try {
                zzaopVar.beginObject();
                while (zzaopVar.hasNext()) {
                    zzb zzbVar = this.bgb.get(zzaopVar.nextName());
                    if (zzbVar == null || !zzbVar.bgd) {
                        zzaopVar.skipValue();
                    } else {
                        zzbVar.zza(zzaopVar, tMo15a);
                    }
                }
                zzaopVar.endObject();
                return tMo15a;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new zzanh(e2);
            }
        }
    }

    static abstract class zzb {
        final boolean bgc;
        final boolean bgd;
        final String name;

        protected zzb(String str, boolean z, boolean z2) {
            this.name = str;
            this.bgc = z;
            this.bgd = z2;
        }

        abstract void zza(zzaop zzaopVar, Object obj) throws IllegalAccessException, IOException;

        abstract void zza(zzaor zzaorVar, Object obj) throws IllegalAccessException, IOException;

        abstract boolean zzcq(Object obj) throws IllegalAccessException, IOException;
    }

    public zzaoj(zzans zzansVar, zzamr zzamrVar, zzant zzantVar) {
        this.beb = zzansVar;
        this.bem = zzamrVar;
        this.bek = zzantVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zzank<?> zza(zzams zzamsVar, Field field, zzaoo<?> zzaooVar) {
        zzank<?> zzankVarZza;
        zzanm zzanmVar = (zzanm) field.getAnnotation(zzanm.class);
        return (zzanmVar == null || (zzankVarZza = zzaoe.zza(this.beb, zzamsVar, zzaooVar, zzanmVar)) == null) ? zzamsVar.zza(zzaooVar) : zzankVarZza;
    }

    private zzb zza(final zzams zzamsVar, final Field field, String str, final zzaoo<?> zzaooVar, boolean z, boolean z2) {
        final boolean zZzk = zzany.zzk(zzaooVar.m33s());
        return new zzb(str, z, z2) { // from class: com.google.android.gms.internal.zzaoj.1
            final zzank<?> bfV;

            {
                this.bfV = zzaoj.this.zza(zzamsVar, field, (zzaoo<?>) zzaooVar);
            }

            @Override // com.google.android.gms.internal.zzaoj.zzb
            void zza(zzaop zzaopVar, Object obj) throws IllegalAccessException, IOException {
                Object objZzb = this.bfV.zzb(zzaopVar);
                if (objZzb == null && zZzk) {
                    return;
                }
                field.set(obj, objZzb);
            }

            @Override // com.google.android.gms.internal.zzaoj.zzb
            void zza(zzaor zzaorVar, Object obj) throws IllegalAccessException, IOException {
                new zzaom(zzamsVar, this.bfV, zzaooVar.m34t()).zza(zzaorVar, field.get(obj));
            }

            @Override // com.google.android.gms.internal.zzaoj.zzb
            public boolean zzcq(Object obj) throws IllegalAccessException, IOException {
                return this.bgc && field.get(obj) != obj;
            }
        };
    }

    static List<String> zza(zzamr zzamrVar, Field field) {
        zzann zzannVar = (zzann) field.getAnnotation(zzann.class);
        LinkedList linkedList = new LinkedList();
        if (zzannVar == null) {
            linkedList.add(zzamrVar.zzc(field));
        } else {
            linkedList.add(zzannVar.value());
            String[] strArrZzczy = zzannVar.zzczy();
            for (String str : strArrZzczy) {
                linkedList.add(str);
            }
        }
        return linkedList;
    }

    private Map<String, zzb> zza(zzams zzamsVar, zzaoo<?> zzaooVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type typeM34t = zzaooVar.m34t();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean zZza = zza(field, true);
                boolean zZza2 = zza(field, false);
                if (zZza || zZza2) {
                    field.setAccessible(true);
                    Type typeZza = zzanr.zza(zzaooVar.m34t(), cls, field.getGenericType());
                    List<String> listZzd = zzd(field);
                    zzb zzbVar = null;
                    int i = 0;
                    while (i < listZzd.size()) {
                        String str = listZzd.get(i);
                        if (i != 0) {
                            zZza = false;
                        }
                        zzb zzbVar2 = (zzb) linkedHashMap.put(str, zza(zzamsVar, field, str, zzaoo.zzl(typeZza), zZza, zZza2));
                        if (zzbVar != null) {
                            zzbVar2 = zzbVar;
                        }
                        i++;
                        zzbVar = zzbVar2;
                    }
                    if (zzbVar != null) {
                        String strValueOf = String.valueOf(typeM34t);
                        String str2 = zzbVar.name;
                        throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf).length() + 37 + String.valueOf(str2).length()).append(strValueOf).append(" declares multiple JSON fields named ").append(str2).toString());
                    }
                }
            }
            zzaooVar = zzaoo.zzl(zzanr.zza(zzaooVar.m34t(), cls, cls.getGenericSuperclass()));
            cls = zzaooVar.m33s();
        }
        return linkedHashMap;
    }

    static boolean zza(Field field, boolean z, zzant zzantVar) {
        return (zzantVar.zza(field.getType(), z) || zzantVar.zza(field, z)) ? false : true;
    }

    private List<String> zzd(Field field) {
        return zza(this.bem, field);
    }

    @Override // com.google.android.gms.internal.zzanl
    public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
        Class<? super T> clsM33s = zzaooVar.m33s();
        if (Object.class.isAssignableFrom(clsM33s)) {
            return new zza(this.beb.zzb(zzaooVar), zza(zzamsVar, (zzaoo<?>) zzaooVar, (Class<?>) clsM33s));
        }
        return null;
    }

    public boolean zza(Field field, boolean z) {
        return zza(field, z, this.bek);
    }
}
