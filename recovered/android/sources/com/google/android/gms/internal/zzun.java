package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzun {

    public static final class zza extends zzapc {
        private static volatile zza[] anV;
        public Integer anW;
        public zze[] anX;
        public zzb[] anY;

        public zza() {
            zzbwa();
        }

        public static zza[] zzbvz() {
            if (anV == null) {
                synchronized (zzapa.bij) {
                    if (anV == null) {
                        anV = new zza[0];
                    }
                }
            }
            return anV;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.anW == null) {
                if (zzaVar.anW != null) {
                    return false;
                }
            } else if (!this.anW.equals(zzaVar.anW)) {
                return false;
            }
            return zzapa.equals(this.anX, zzaVar.anX) && zzapa.equals(this.anY, zzaVar.anY);
        }

        public int hashCode() {
            return (((((this.anW == null ? 0 : this.anW.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzapa.hashCode(this.anX)) * 31) + zzapa.hashCode(this.anY);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.anW != null) {
                zzaovVar.zzae(1, this.anW.intValue());
            }
            if (this.anX != null && this.anX.length > 0) {
                for (int i = 0; i < this.anX.length; i++) {
                    zze zzeVar = this.anX[i];
                    if (zzeVar != null) {
                        zzaovVar.zza(2, zzeVar);
                    }
                }
            }
            if (this.anY != null && this.anY.length > 0) {
                for (int i2 = 0; i2 < this.anY.length; i2++) {
                    zzb zzbVar = this.anY[i2];
                    if (zzbVar != null) {
                        zzaovVar.zza(3, zzbVar);
                    }
                }
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbd, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.anW = Integer.valueOf(zzaouVar.m55N());
                        break;
                    case 18:
                        int iZzc = zzapf.zzc(zzaouVar, 18);
                        int length = this.anX == null ? 0 : this.anX.length;
                        zze[] zzeVarArr = new zze[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.anX, 0, zzeVarArr, 0, length);
                        }
                        while (length < zzeVarArr.length - 1) {
                            zzeVarArr[length] = new zze();
                            zzaouVar.zza(zzeVarArr[length]);
                            zzaouVar.m51J();
                            length++;
                        }
                        zzeVarArr[length] = new zze();
                        zzaouVar.zza(zzeVarArr[length]);
                        this.anX = zzeVarArr;
                        break;
                    case 26:
                        int iZzc2 = zzapf.zzc(zzaouVar, 26);
                        int length2 = this.anY == null ? 0 : this.anY.length;
                        zzb[] zzbVarArr = new zzb[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.anY, 0, zzbVarArr, 0, length2);
                        }
                        while (length2 < zzbVarArr.length - 1) {
                            zzbVarArr[length2] = new zzb();
                            zzaouVar.zza(zzbVarArr[length2]);
                            zzaouVar.m51J();
                            length2++;
                        }
                        zzbVarArr[length2] = new zzb();
                        zzaouVar.zza(zzbVarArr[length2]);
                        this.anY = zzbVarArr;
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zza zzbwa() {
            this.anW = null;
            this.anX = zze.zzbwg();
            this.anY = zzb.zzbwb();
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.anW != null) {
                iZzy += zzaov.zzag(1, this.anW.intValue());
            }
            if (this.anX != null && this.anX.length > 0) {
                int iZzc = iZzy;
                for (int i = 0; i < this.anX.length; i++) {
                    zze zzeVar = this.anX[i];
                    if (zzeVar != null) {
                        iZzc += zzaov.zzc(2, zzeVar);
                    }
                }
                iZzy = iZzc;
            }
            if (this.anY != null && this.anY.length > 0) {
                for (int i2 = 0; i2 < this.anY.length; i2++) {
                    zzb zzbVar = this.anY[i2];
                    if (zzbVar != null) {
                        iZzy += zzaov.zzc(3, zzbVar);
                    }
                }
            }
            return iZzy;
        }
    }

    public static final class zzb extends zzapc {
        private static volatile zzb[] anZ;
        public Integer aoa;
        public String aob;
        public zzc[] aoc;
        public Boolean aod;
        public zzd aoe;

        public zzb() {
            zzbwc();
        }

        public static zzb[] zzbwb() {
            if (anZ == null) {
                synchronized (zzapa.bij) {
                    if (anZ == null) {
                        anZ = new zzb[0];
                    }
                }
            }
            return anZ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (this.aoa == null) {
                if (zzbVar.aoa != null) {
                    return false;
                }
            } else if (!this.aoa.equals(zzbVar.aoa)) {
                return false;
            }
            if (this.aob == null) {
                if (zzbVar.aob != null) {
                    return false;
                }
            } else if (!this.aob.equals(zzbVar.aob)) {
                return false;
            }
            if (!zzapa.equals(this.aoc, zzbVar.aoc)) {
                return false;
            }
            if (this.aod == null) {
                if (zzbVar.aod != null) {
                    return false;
                }
            } else if (!this.aod.equals(zzbVar.aod)) {
                return false;
            }
            if (this.aoe == null) {
                return zzbVar.aoe == null;
            }
            return this.aoe.equals(zzbVar.aoe);
        }

        public int hashCode() {
            return (((this.aod == null ? 0 : this.aod.hashCode()) + (((((this.aob == null ? 0 : this.aob.hashCode()) + (((this.aoa == null ? 0 : this.aoa.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + zzapa.hashCode(this.aoc)) * 31)) * 31) + (this.aoe != null ? this.aoe.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.aoa != null) {
                zzaovVar.zzae(1, this.aoa.intValue());
            }
            if (this.aob != null) {
                zzaovVar.zzr(2, this.aob);
            }
            if (this.aoc != null && this.aoc.length > 0) {
                for (int i = 0; i < this.aoc.length; i++) {
                    zzc zzcVar = this.aoc[i];
                    if (zzcVar != null) {
                        zzaovVar.zza(3, zzcVar);
                    }
                }
            }
            if (this.aod != null) {
                zzaovVar.zzj(4, this.aod.booleanValue());
            }
            if (this.aoe != null) {
                zzaovVar.zza(5, this.aoe);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbe, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.aoa = Integer.valueOf(zzaouVar.m55N());
                        break;
                    case 18:
                        this.aob = zzaouVar.readString();
                        break;
                    case 26:
                        int iZzc = zzapf.zzc(zzaouVar, 26);
                        int length = this.aoc == null ? 0 : this.aoc.length;
                        zzc[] zzcVarArr = new zzc[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.aoc, 0, zzcVarArr, 0, length);
                        }
                        while (length < zzcVarArr.length - 1) {
                            zzcVarArr[length] = new zzc();
                            zzaouVar.zza(zzcVarArr[length]);
                            zzaouVar.m51J();
                            length++;
                        }
                        zzcVarArr[length] = new zzc();
                        zzaouVar.zza(zzcVarArr[length]);
                        this.aoc = zzcVarArr;
                        break;
                    case 32:
                        this.aod = Boolean.valueOf(zzaouVar.m57P());
                        break;
                    case 42:
                        if (this.aoe == null) {
                            this.aoe = new zzd();
                        }
                        zzaouVar.zza(this.aoe);
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzb zzbwc() {
            this.aoa = null;
            this.aob = null;
            this.aoc = zzc.zzbwd();
            this.aod = null;
            this.aoe = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.aoa != null) {
                iZzy += zzaov.zzag(1, this.aoa.intValue());
            }
            if (this.aob != null) {
                iZzy += zzaov.zzs(2, this.aob);
            }
            if (this.aoc != null && this.aoc.length > 0) {
                int iZzc = iZzy;
                for (int i = 0; i < this.aoc.length; i++) {
                    zzc zzcVar = this.aoc[i];
                    if (zzcVar != null) {
                        iZzc += zzaov.zzc(3, zzcVar);
                    }
                }
                iZzy = iZzc;
            }
            if (this.aod != null) {
                iZzy += zzaov.zzk(4, this.aod.booleanValue());
            }
            return this.aoe != null ? iZzy + zzaov.zzc(5, this.aoe) : iZzy;
        }
    }

    public static final class zzc extends zzapc {
        private static volatile zzc[] aof;
        public zzf aog;
        public zzd aoh;
        public Boolean aoi;
        public String aoj;

        public zzc() {
            zzbwe();
        }

        public static zzc[] zzbwd() {
            if (aof == null) {
                synchronized (zzapa.bij) {
                    if (aof == null) {
                        aof = new zzc[0];
                    }
                }
            }
            return aof;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            if (this.aog == null) {
                if (zzcVar.aog != null) {
                    return false;
                }
            } else if (!this.aog.equals(zzcVar.aog)) {
                return false;
            }
            if (this.aoh == null) {
                if (zzcVar.aoh != null) {
                    return false;
                }
            } else if (!this.aoh.equals(zzcVar.aoh)) {
                return false;
            }
            if (this.aoi == null) {
                if (zzcVar.aoi != null) {
                    return false;
                }
            } else if (!this.aoi.equals(zzcVar.aoi)) {
                return false;
            }
            if (this.aoj == null) {
                return zzcVar.aoj == null;
            }
            return this.aoj.equals(zzcVar.aoj);
        }

        public int hashCode() {
            return (((this.aoi == null ? 0 : this.aoi.hashCode()) + (((this.aoh == null ? 0 : this.aoh.hashCode()) + (((this.aog == null ? 0 : this.aog.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + (this.aoj != null ? this.aoj.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.aog != null) {
                zzaovVar.zza(1, this.aog);
            }
            if (this.aoh != null) {
                zzaovVar.zza(2, this.aoh);
            }
            if (this.aoi != null) {
                zzaovVar.zzj(3, this.aoi.booleanValue());
            }
            if (this.aoj != null) {
                zzaovVar.zzr(4, this.aoj);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbf, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        if (this.aog == null) {
                            this.aog = new zzf();
                        }
                        zzaouVar.zza(this.aog);
                        break;
                    case 18:
                        if (this.aoh == null) {
                            this.aoh = new zzd();
                        }
                        zzaouVar.zza(this.aoh);
                        break;
                    case 24:
                        this.aoi = Boolean.valueOf(zzaouVar.m57P());
                        break;
                    case 34:
                        this.aoj = zzaouVar.readString();
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzc zzbwe() {
            this.aog = null;
            this.aoh = null;
            this.aoi = null;
            this.aoj = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.aog != null) {
                iZzy += zzaov.zzc(1, this.aog);
            }
            if (this.aoh != null) {
                iZzy += zzaov.zzc(2, this.aoh);
            }
            if (this.aoi != null) {
                iZzy += zzaov.zzk(3, this.aoi.booleanValue());
            }
            return this.aoj != null ? iZzy + zzaov.zzs(4, this.aoj) : iZzy;
        }
    }

    public static final class zzd extends zzapc {
        public Integer aok;
        public Boolean aol;
        public String aom;
        public String aon;
        public String aoo;

        public zzd() {
            zzbwf();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (this.aok == null) {
                if (zzdVar.aok != null) {
                    return false;
                }
            } else if (!this.aok.equals(zzdVar.aok)) {
                return false;
            }
            if (this.aol == null) {
                if (zzdVar.aol != null) {
                    return false;
                }
            } else if (!this.aol.equals(zzdVar.aol)) {
                return false;
            }
            if (this.aom == null) {
                if (zzdVar.aom != null) {
                    return false;
                }
            } else if (!this.aom.equals(zzdVar.aom)) {
                return false;
            }
            if (this.aon == null) {
                if (zzdVar.aon != null) {
                    return false;
                }
            } else if (!this.aon.equals(zzdVar.aon)) {
                return false;
            }
            if (this.aoo == null) {
                return zzdVar.aoo == null;
            }
            return this.aoo.equals(zzdVar.aoo);
        }

        public int hashCode() {
            return (((this.aon == null ? 0 : this.aon.hashCode()) + (((this.aom == null ? 0 : this.aom.hashCode()) + (((this.aol == null ? 0 : this.aol.hashCode()) + (((this.aok == null ? 0 : this.aok.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31) + (this.aoo != null ? this.aoo.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.aok != null) {
                zzaovVar.zzae(1, this.aok.intValue());
            }
            if (this.aol != null) {
                zzaovVar.zzj(2, this.aol.booleanValue());
            }
            if (this.aom != null) {
                zzaovVar.zzr(3, this.aom);
            }
            if (this.aon != null) {
                zzaovVar.zzr(4, this.aon);
            }
            if (this.aoo != null) {
                zzaovVar.zzr(5, this.aoo);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbg, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        int iM55N = zzaouVar.m55N();
                        switch (iM55N) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                this.aok = Integer.valueOf(iM55N);
                                break;
                        }
                        break;
                    case 16:
                        this.aol = Boolean.valueOf(zzaouVar.m57P());
                        break;
                    case 26:
                        this.aom = zzaouVar.readString();
                        break;
                    case 34:
                        this.aon = zzaouVar.readString();
                        break;
                    case 42:
                        this.aoo = zzaouVar.readString();
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzd zzbwf() {
            this.aol = null;
            this.aom = null;
            this.aon = null;
            this.aoo = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.aok != null) {
                iZzy += zzaov.zzag(1, this.aok.intValue());
            }
            if (this.aol != null) {
                iZzy += zzaov.zzk(2, this.aol.booleanValue());
            }
            if (this.aom != null) {
                iZzy += zzaov.zzs(3, this.aom);
            }
            if (this.aon != null) {
                iZzy += zzaov.zzs(4, this.aon);
            }
            return this.aoo != null ? iZzy + zzaov.zzs(5, this.aoo) : iZzy;
        }
    }

    public static final class zze extends zzapc {
        private static volatile zze[] aop;
        public Integer aoa;
        public String aoq;
        public zzc aor;

        public zze() {
            zzbwh();
        }

        public static zze[] zzbwg() {
            if (aop == null) {
                synchronized (zzapa.bij) {
                    if (aop == null) {
                        aop = new zze[0];
                    }
                }
            }
            return aop;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) obj;
            if (this.aoa == null) {
                if (zzeVar.aoa != null) {
                    return false;
                }
            } else if (!this.aoa.equals(zzeVar.aoa)) {
                return false;
            }
            if (this.aoq == null) {
                if (zzeVar.aoq != null) {
                    return false;
                }
            } else if (!this.aoq.equals(zzeVar.aoq)) {
                return false;
            }
            if (this.aor == null) {
                return zzeVar.aor == null;
            }
            return this.aor.equals(zzeVar.aor);
        }

        public int hashCode() {
            return (((this.aoq == null ? 0 : this.aoq.hashCode()) + (((this.aoa == null ? 0 : this.aoa.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + (this.aor != null ? this.aor.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.aoa != null) {
                zzaovVar.zzae(1, this.aoa.intValue());
            }
            if (this.aoq != null) {
                zzaovVar.zzr(2, this.aoq);
            }
            if (this.aor != null) {
                zzaovVar.zza(3, this.aor);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbh, reason: merged with bridge method [inline-methods] */
        public zze zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.aoa = Integer.valueOf(zzaouVar.m55N());
                        break;
                    case 18:
                        this.aoq = zzaouVar.readString();
                        break;
                    case 26:
                        if (this.aor == null) {
                            this.aor = new zzc();
                        }
                        zzaouVar.zza(this.aor);
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zze zzbwh() {
            this.aoa = null;
            this.aoq = null;
            this.aor = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.aoa != null) {
                iZzy += zzaov.zzag(1, this.aoa.intValue());
            }
            if (this.aoq != null) {
                iZzy += zzaov.zzs(2, this.aoq);
            }
            return this.aor != null ? iZzy + zzaov.zzc(3, this.aor) : iZzy;
        }
    }

    public static final class zzf extends zzapc {
        public Integer aos;
        public String aot;
        public Boolean aou;
        public String[] aov;

        public zzf() {
            zzbwi();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzfVar = (zzf) obj;
            if (this.aos == null) {
                if (zzfVar.aos != null) {
                    return false;
                }
            } else if (!this.aos.equals(zzfVar.aos)) {
                return false;
            }
            if (this.aot == null) {
                if (zzfVar.aot != null) {
                    return false;
                }
            } else if (!this.aot.equals(zzfVar.aot)) {
                return false;
            }
            if (this.aou == null) {
                if (zzfVar.aou != null) {
                    return false;
                }
            } else if (!this.aou.equals(zzfVar.aou)) {
                return false;
            }
            return zzapa.equals(this.aov, zzfVar.aov);
        }

        public int hashCode() {
            return (((((this.aot == null ? 0 : this.aot.hashCode()) + (((this.aos == null ? 0 : this.aos.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + (this.aou != null ? this.aou.hashCode() : 0)) * 31) + zzapa.hashCode(this.aov);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.aos != null) {
                zzaovVar.zzae(1, this.aos.intValue());
            }
            if (this.aot != null) {
                zzaovVar.zzr(2, this.aot);
            }
            if (this.aou != null) {
                zzaovVar.zzj(3, this.aou.booleanValue());
            }
            if (this.aov != null && this.aov.length > 0) {
                for (int i = 0; i < this.aov.length; i++) {
                    String str = this.aov[i];
                    if (str != null) {
                        zzaovVar.zzr(4, str);
                    }
                }
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbi, reason: merged with bridge method [inline-methods] */
        public zzf zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        int iM55N = zzaouVar.m55N();
                        switch (iM55N) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.aos = Integer.valueOf(iM55N);
                                break;
                        }
                        break;
                    case 18:
                        this.aot = zzaouVar.readString();
                        break;
                    case 24:
                        this.aou = Boolean.valueOf(zzaouVar.m57P());
                        break;
                    case 34:
                        int iZzc = zzapf.zzc(zzaouVar, 34);
                        int length = this.aov == null ? 0 : this.aov.length;
                        String[] strArr = new String[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.aov, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzaouVar.readString();
                            zzaouVar.m51J();
                            length++;
                        }
                        strArr[length] = zzaouVar.readString();
                        this.aov = strArr;
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzf zzbwi() {
            this.aot = null;
            this.aou = null;
            this.aov = zzapf.bir;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.aos != null) {
                iZzy += zzaov.zzag(1, this.aos.intValue());
            }
            if (this.aot != null) {
                iZzy += zzaov.zzs(2, this.aot);
            }
            if (this.aou != null) {
                iZzy += zzaov.zzk(3, this.aou.booleanValue());
            }
            if (this.aov == null || this.aov.length <= 0) {
                return iZzy;
            }
            int iZztg = 0;
            int i = 0;
            for (int i2 = 0; i2 < this.aov.length; i2++) {
                String str = this.aov[i2];
                if (str != null) {
                    i++;
                    iZztg += zzaov.zztg(str);
                }
            }
            return iZzy + iZztg + (i * 1);
        }
    }
}
