package com.google.android.gms.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzams {
    private final ThreadLocal<Map<zzaoo<?>, zza<?>>> bdY;
    private final Map<zzaoo<?>, zzank<?>> bdZ;
    private final List<zzanl> bea;
    private final zzans beb;
    private final boolean bec;
    private final boolean bed;
    private final boolean bee;
    private final boolean bef;
    final zzamw beg;
    final zzanf beh;

    static class zza<T> extends zzank<T> {
        private zzank<T> bej;

        zza() {
        }

        public void zza(zzank<T> zzankVar) {
            if (this.bej != null) {
                throw new AssertionError();
            }
            this.bej = zzankVar;
        }

        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, T t) throws IOException {
            if (this.bej == null) {
                throw new IllegalStateException();
            }
            this.bej.zza(zzaorVar, t);
        }

        @Override // com.google.android.gms.internal.zzank
        public T zzb(zzaop zzaopVar) throws IOException {
            if (this.bej == null) {
                throw new IllegalStateException();
            }
            return this.bej.zzb(zzaopVar);
        }
    }

    public zzams() {
        this(zzant.beU, zzamq.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, zzani.DEFAULT, Collections.emptyList());
    }

    zzams(zzant zzantVar, zzamr zzamrVar, Map<Type, zzamu<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, zzani zzaniVar, List<zzanl> list) {
        this.bdY = new ThreadLocal<>();
        this.bdZ = Collections.synchronizedMap(new HashMap());
        this.beg = new zzamw() { // from class: com.google.android.gms.internal.zzams.1
        };
        this.beh = new zzanf() { // from class: com.google.android.gms.internal.zzams.2
        };
        this.beb = new zzans(map);
        this.bec = z;
        this.bee = z3;
        this.bed = z4;
        this.bef = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzaon.bgX);
        arrayList.add(zzaoi.bfE);
        arrayList.add(zzantVar);
        arrayList.addAll(list);
        arrayList.add(zzaon.bgE);
        arrayList.add(zzaon.bgt);
        arrayList.add(zzaon.bgn);
        arrayList.add(zzaon.bgp);
        arrayList.add(zzaon.bgr);
        arrayList.add(zzaon.zza(Long.TYPE, Long.class, zza(zzaniVar)));
        arrayList.add(zzaon.zza(Double.TYPE, Double.class, zzcx(z6)));
        arrayList.add(zzaon.zza(Float.TYPE, Float.class, zzcy(z6)));
        arrayList.add(zzaon.bgy);
        arrayList.add(zzaon.bgA);
        arrayList.add(zzaon.bgG);
        arrayList.add(zzaon.bgI);
        arrayList.add(zzaon.zza(BigDecimal.class, zzaon.bgC));
        arrayList.add(zzaon.zza(BigInteger.class, zzaon.bgD));
        arrayList.add(zzaon.bgK);
        arrayList.add(zzaon.bgM);
        arrayList.add(zzaon.bgQ);
        arrayList.add(zzaon.bgV);
        arrayList.add(zzaon.bgO);
        arrayList.add(zzaon.bgk);
        arrayList.add(zzaod.bfE);
        arrayList.add(zzaon.bgT);
        arrayList.add(zzaol.bfE);
        arrayList.add(zzaok.bfE);
        arrayList.add(zzaon.bgR);
        arrayList.add(zzaob.bfE);
        arrayList.add(zzaon.bgi);
        arrayList.add(new zzaoc(this.beb));
        arrayList.add(new zzaoh(this.beb, z2));
        arrayList.add(new zzaoe(this.beb));
        arrayList.add(zzaon.bgY);
        arrayList.add(new zzaoj(this.beb, zzamrVar, zzantVar));
        this.bea = Collections.unmodifiableList(arrayList);
    }

    private zzank<Number> zza(zzani zzaniVar) {
        return zzaniVar == zzani.DEFAULT ? zzaon.bgu : new zzank<Number>() { // from class: com.google.android.gms.internal.zzams.5
            @Override // com.google.android.gms.internal.zzank
            public void zza(zzaor zzaorVar, Number number) throws IOException {
                if (number == null) {
                    zzaorVar.mo32r();
                } else {
                    zzaorVar.zztb(number.toString());
                }
            }

            @Override // com.google.android.gms.internal.zzank
            /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
            public Number zzb(zzaop zzaopVar) throws IOException {
                if (zzaopVar.mo24h() != zzaoq.NULL) {
                    return Long.valueOf(zzaopVar.nextLong());
                }
                zzaopVar.nextNull();
                return null;
            }
        };
    }

    private static void zza(Object obj, zzaop zzaopVar) {
        if (obj != null) {
            try {
                if (zzaopVar.mo24h() != zzaoq.END_DOCUMENT) {
                    throw new zzamz("JSON document was not fully consumed.");
                }
            } catch (zzaos e) {
                throw new zzanh(e);
            } catch (IOException e2) {
                throw new zzamz(e2);
            }
        }
    }

    private zzank<Number> zzcx(boolean z) {
        return z ? zzaon.bgw : new zzank<Number>() { // from class: com.google.android.gms.internal.zzams.3
            @Override // com.google.android.gms.internal.zzank
            public void zza(zzaor zzaorVar, Number number) throws IOException {
                if (number == null) {
                    zzaorVar.mo32r();
                    return;
                }
                zzams.this.zzn(number.doubleValue());
                zzaorVar.zza(number);
            }

            @Override // com.google.android.gms.internal.zzank
            /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
            public Double zzb(zzaop zzaopVar) throws IOException {
                if (zzaopVar.mo24h() != zzaoq.NULL) {
                    return Double.valueOf(zzaopVar.nextDouble());
                }
                zzaopVar.nextNull();
                return null;
            }
        };
    }

    private zzank<Number> zzcy(boolean z) {
        return z ? zzaon.bgv : new zzank<Number>() { // from class: com.google.android.gms.internal.zzams.4
            @Override // com.google.android.gms.internal.zzank
            public void zza(zzaor zzaorVar, Number number) throws IOException {
                if (number == null) {
                    zzaorVar.mo32r();
                    return;
                }
                zzams.this.zzn(number.floatValue());
                zzaorVar.zza(number);
            }

            @Override // com.google.android.gms.internal.zzank
            /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
            public Float zzb(zzaop zzaopVar) throws IOException {
                if (zzaopVar.mo24h() != zzaoq.NULL) {
                    return Float.valueOf((float) zzaopVar.nextDouble());
                }
                zzaopVar.nextNull();
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzn(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(new StringBuilder(168).append(d).append(" is not a valid double value as per JSON specification. To override this").append(" behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.").toString());
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.bec + "factories:" + this.bea + ",instanceCreators:" + this.beb + "}";
    }

    public <T> zzank<T> zza(zzanl zzanlVar, zzaoo<T> zzaooVar) {
        boolean z = this.bea.contains(zzanlVar) ? false : true;
        boolean z2 = z;
        for (zzanl zzanlVar2 : this.bea) {
            if (z2) {
                zzank<T> zzankVarZza = zzanlVar2.zza(this, zzaooVar);
                if (zzankVarZza != null) {
                    return zzankVarZza;
                }
            } else if (zzanlVar2 == zzanlVar) {
                z2 = true;
            }
        }
        String strValueOf = String.valueOf(zzaooVar);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf).length() + 22).append("GSON cannot serialize ").append(strValueOf).toString());
    }

    public <T> zzank<T> zza(zzaoo<T> zzaooVar) {
        Map map;
        zzank<T> zzankVarZza = (zzank) this.bdZ.get(zzaooVar);
        if (zzankVarZza == null) {
            Map<zzaoo<?>, zza<?>> map2 = this.bdY.get();
            boolean z = false;
            if (map2 == null) {
                HashMap map3 = new HashMap();
                this.bdY.set(map3);
                map = map3;
                z = true;
            } else {
                map = map2;
            }
            zzankVarZza = (zza) map.get(zzaooVar);
            if (zzankVarZza == null) {
                try {
                    zza zzaVar = new zza();
                    map.put(zzaooVar, zzaVar);
                    Iterator<zzanl> it = this.bea.iterator();
                    while (it.hasNext()) {
                        zzankVarZza = it.next().zza(this, zzaooVar);
                        if (zzankVarZza != null) {
                            zzaVar.zza(zzankVarZza);
                            this.bdZ.put(zzaooVar, zzankVarZza);
                            map.remove(zzaooVar);
                            if (z) {
                                this.bdY.remove();
                            }
                        }
                    }
                    String strValueOf = String.valueOf(zzaooVar);
                    throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf).length() + 19).append("GSON cannot handle ").append(strValueOf).toString());
                } catch (Throwable th) {
                    map.remove(zzaooVar);
                    if (z) {
                        this.bdY.remove();
                    }
                    throw th;
                }
            }
        }
        return zzankVarZza;
    }

    public zzaor zza(Writer writer) throws IOException {
        if (this.bee) {
            writer.write(")]}'\n");
        }
        zzaor zzaorVar = new zzaor(writer);
        if (this.bef) {
            zzaorVar.setIndent("  ");
        }
        zzaorVar.zzdc(this.bec);
        return zzaorVar;
    }

    public <T> T zza(zzamy zzamyVar, Class<T> cls) throws zzanh {
        return (T) zzany.zzp(cls).cast(zza(zzamyVar, (Type) cls));
    }

    public <T> T zza(zzamy zzamyVar, Type type) throws zzanh {
        if (zzamyVar == null) {
            return null;
        }
        return (T) zza(new zzaof(zzamyVar), type);
    }

    public <T> T zza(zzaop zzaopVar, Type type) throws zzanh, zzamz {
        boolean z = true;
        boolean zIsLenient = zzaopVar.isLenient();
        zzaopVar.setLenient(true);
        try {
            try {
                zzaopVar.mo24h();
                z = false;
                T tZzb = zza(zzaoo.zzl(type)).zzb(zzaopVar);
                zzaopVar.setLenient(zIsLenient);
                return tZzb;
            } catch (EOFException e) {
                if (!z) {
                    throw new zzanh(e);
                }
                zzaopVar.setLenient(zIsLenient);
                return null;
            } catch (IOException e2) {
                throw new zzanh(e2);
            } catch (IllegalStateException e3) {
                throw new zzanh(e3);
            }
        } catch (Throwable th) {
            zzaopVar.setLenient(zIsLenient);
            throw th;
        }
    }

    public <T> T zza(Reader reader, Type type) throws zzanh, zzamz {
        zzaop zzaopVar = new zzaop(reader);
        T t = (T) zza(zzaopVar, type);
        zza(t, zzaopVar);
        return t;
    }

    public <T> T zza(String str, Type type) throws zzanh {
        if (str == null) {
            return null;
        }
        return (T) zza(new StringReader(str), type);
    }

    public void zza(zzamy zzamyVar, zzaor zzaorVar) throws zzamz {
        boolean zIsLenient = zzaorVar.isLenient();
        zzaorVar.setLenient(true);
        boolean zM48D = zzaorVar.m48D();
        zzaorVar.zzdb(this.bed);
        boolean zM49E = zzaorVar.m49E();
        zzaorVar.zzdc(this.bec);
        try {
            try {
                zzanz.zzb(zzamyVar, zzaorVar);
                zzaorVar.setLenient(zIsLenient);
                zzaorVar.zzdb(zM48D);
                zzaorVar.zzdc(zM49E);
            } catch (IOException e) {
                throw new zzamz(e);
            }
        } catch (Throwable th) {
            zzaorVar.setLenient(zIsLenient);
            zzaorVar.zzdb(zM48D);
            zzaorVar.zzdc(zM49E);
            throw th;
        }
    }

    public void zza(zzamy zzamyVar, Appendable appendable) throws zzamz {
        try {
            zza(zzamyVar, zza(zzanz.zza(appendable)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(Object obj, Type type, zzaor zzaorVar) throws zzamz {
        zzank zzankVarZza = zza(zzaoo.zzl(type));
        boolean zIsLenient = zzaorVar.isLenient();
        zzaorVar.setLenient(true);
        boolean zM48D = zzaorVar.m48D();
        zzaorVar.zzdb(this.bed);
        boolean zM49E = zzaorVar.m49E();
        zzaorVar.zzdc(this.bec);
        try {
            try {
                zzankVarZza.zza(zzaorVar, obj);
                zzaorVar.setLenient(zIsLenient);
                zzaorVar.zzdb(zM48D);
                zzaorVar.zzdc(zM49E);
            } catch (IOException e) {
                throw new zzamz(e);
            }
        } catch (Throwable th) {
            zzaorVar.setLenient(zIsLenient);
            zzaorVar.zzdb(zM48D);
            zzaorVar.zzdc(zM49E);
            throw th;
        }
    }

    public void zza(Object obj, Type type, Appendable appendable) throws zzamz {
        try {
            zza(obj, type, zza(zzanz.zza(appendable)));
        } catch (IOException e) {
            throw new zzamz(e);
        }
    }

    public String zzb(zzamy zzamyVar) {
        StringWriter stringWriter = new StringWriter();
        zza(zzamyVar, stringWriter);
        return stringWriter.toString();
    }

    public String zzc(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        zza(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String zzcj(Object obj) {
        return obj == null ? zzb(zzana.bes) : zzc(obj, obj.getClass());
    }

    public <T> T zzf(String str, Class<T> cls) throws zzanh {
        return (T) zzany.zzp(cls).cast(zza(str, cls));
    }

    public <T> zzank<T> zzk(Class<T> cls) {
        return zza(zzaoo.zzr(cls));
    }
}
