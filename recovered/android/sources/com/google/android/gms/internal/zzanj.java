package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzanj<T> extends zzank<T> {
    private final zzams beA;
    private final zzaoo<T> beB;
    private final zzanl beC;
    private zzank<T> bej;
    private final zzang<T> bey;
    private final zzamx<T> bez;

    private static class zza implements zzanl {
        private final zzaoo<?> beD;
        private final boolean beE;
        private final Class<?> beF;
        private final zzang<?> bey;
        private final zzamx<?> bez;

        private zza(Object obj, zzaoo<?> zzaooVar, boolean z, Class<?> cls) {
            this.bey = obj instanceof zzang ? (zzang) obj : null;
            this.bez = obj instanceof zzamx ? (zzamx) obj : null;
            zzanq.zzbn((this.bey == null && this.bez == null) ? false : true);
            this.beD = zzaooVar;
            this.beE = z;
            this.beF = cls;
        }

        @Override // com.google.android.gms.internal.zzanl
        public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
            boolean zIsAssignableFrom;
            if (this.beD != null) {
                zIsAssignableFrom = this.beD.equals(zzaooVar) || (this.beE && this.beD.m34t() == zzaooVar.m33s());
            } else {
                zIsAssignableFrom = this.beF.isAssignableFrom(zzaooVar.m33s());
            }
            if (zIsAssignableFrom) {
                return new zzanj(this.bey, this.bez, zzamsVar, zzaooVar, this);
            }
            return null;
        }
    }

    private zzanj(zzang<T> zzangVar, zzamx<T> zzamxVar, zzams zzamsVar, zzaoo<T> zzaooVar, zzanl zzanlVar) {
        this.bey = zzangVar;
        this.bez = zzamxVar;
        this.beA = zzamsVar;
        this.beB = zzaooVar;
        this.beC = zzanlVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzanl zza(zzaoo<?> zzaooVar, Object obj) {
        return new zza(obj, zzaooVar, false, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzanl zzb(zzaoo<?> zzaooVar, Object obj) {
        return new zza(obj, zzaooVar, zzaooVar.m34t() == zzaooVar.m33s(), null);
    }

    private zzank<T> zzczx() {
        zzank<T> zzankVar = this.bej;
        if (zzankVar != null) {
            return zzankVar;
        }
        zzank<T> zzankVarZza = this.beA.zza(this.beC, this.beB);
        this.bej = zzankVarZza;
        return zzankVarZza;
    }

    @Override // com.google.android.gms.internal.zzank
    public void zza(zzaor zzaorVar, T t) throws IOException {
        if (this.bey == null) {
            zzczx().zza(zzaorVar, t);
        } else if (t == null) {
            zzaorVar.mo32r();
        } else {
            zzanz.zzb(this.bey.zza(t, this.beB.m34t(), this.beA.beh), zzaorVar);
        }
    }

    @Override // com.google.android.gms.internal.zzank
    public T zzb(zzaop zzaopVar) throws IOException {
        if (this.bez == null) {
            return zzczx().zzb(zzaopVar);
        }
        zzamy zzamyVarZzh = zzanz.zzh(zzaopVar);
        if (zzamyVarZzh.zzczp()) {
            return null;
        }
        try {
            return this.bez.zzb(zzamyVarZzh, this.beB.m34t(), this.beA.beg);
        } catch (zzanc e) {
            throw e;
        } catch (Exception e2) {
            throw new zzanc(e2);
        }
    }
}
