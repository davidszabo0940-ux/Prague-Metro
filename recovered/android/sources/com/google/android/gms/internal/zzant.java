package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzant implements zzanl, Cloneable {
    public static final zzant beU = new zzant();
    private double beV = -1.0d;
    private int beW = 136;
    private boolean beX = true;
    private List<zzamo> beY = Collections.emptyList();
    private List<zzamo> beZ = Collections.emptyList();

    private boolean zza(zzano zzanoVar) {
        return zzanoVar == null || zzanoVar.zzczz() <= this.beV;
    }

    private boolean zza(zzano zzanoVar, zzanp zzanpVar) {
        return zza(zzanoVar) && zza(zzanpVar);
    }

    private boolean zza(zzanp zzanpVar) {
        return zzanpVar == null || zzanpVar.zzczz() > this.beV;
    }

    private boolean zzm(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean zzn(Class<?> cls) {
        return cls.isMemberClass() && !zzo(cls);
    }

    private boolean zzo(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public zzant clone() {
        try {
            return (zzant) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override // com.google.android.gms.internal.zzanl
    public <T> zzank<T> zza(final zzams zzamsVar, final zzaoo<T> zzaooVar) {
        Class<? super T> clsM33s = zzaooVar.m33s();
        final boolean zZza = zza((Class<?>) clsM33s, true);
        final boolean zZza2 = zza((Class<?>) clsM33s, false);
        if (zZza || zZza2) {
            return new zzank<T>() { // from class: com.google.android.gms.internal.zzant.1
                private zzank<T> bej;

                private zzank<T> zzczx() {
                    zzank<T> zzankVar = this.bej;
                    if (zzankVar != null) {
                        return zzankVar;
                    }
                    zzank<T> zzankVarZza = zzamsVar.zza(zzant.this, zzaooVar);
                    this.bej = zzankVarZza;
                    return zzankVarZza;
                }

                @Override // com.google.android.gms.internal.zzank
                public void zza(zzaor zzaorVar, T t) throws IOException {
                    if (zZza) {
                        zzaorVar.mo32r();
                    } else {
                        zzczx().zza(zzaorVar, t);
                    }
                }

                @Override // com.google.android.gms.internal.zzank
                public T zzb(zzaop zzaopVar) throws IOException {
                    if (!zZza2) {
                        return zzczx().zzb(zzaopVar);
                    }
                    zzaopVar.skipValue();
                    return null;
                }
            };
        }
        return null;
    }

    public zzant zza(zzamo zzamoVar, boolean z, boolean z2) {
        zzant zzantVarClone = clone();
        if (z) {
            zzantVarClone.beY = new ArrayList(this.beY);
            zzantVarClone.beY.add(zzamoVar);
        }
        if (z2) {
            zzantVarClone.beZ = new ArrayList(this.beZ);
            zzantVarClone.beZ.add(zzamoVar);
        }
        return zzantVarClone;
    }

    public boolean zza(Class<?> cls, boolean z) {
        if (this.beV != -1.0d && !zza((zzano) cls.getAnnotation(zzano.class), (zzanp) cls.getAnnotation(zzanp.class))) {
            return true;
        }
        if ((this.beX || !zzn(cls)) && !zzm(cls)) {
            Iterator<zzamo> it = (z ? this.beY : this.beZ).iterator();
            while (it.hasNext()) {
                if (it.next().zzh(cls)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public boolean zza(Field field, boolean z) {
        if ((this.beW & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.beV == -1.0d || zza((zzano) field.getAnnotation(zzano.class), (zzanp) field.getAnnotation(zzanp.class))) && !field.isSynthetic()) {
            if ((this.beX || !zzn(field.getType())) && !zzm(field.getType())) {
                List<zzamo> list = z ? this.beY : this.beZ;
                if (!list.isEmpty()) {
                    zzamp zzampVar = new zzamp(field);
                    Iterator<zzamo> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().zza(zzampVar)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public zzant zze(int... iArr) {
        zzant zzantVarClone = clone();
        zzantVarClone.beW = 0;
        for (int i : iArr) {
            zzantVarClone.beW = i | zzantVarClone.beW;
        }
        return zzantVarClone;
    }
}
