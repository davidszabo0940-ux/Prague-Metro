package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzuo {

    public static final class zza extends zzapc {
        private static volatile zza[] aow;
        public Boolean aox;
        public Boolean aoy;
        public String name;

        public zza() {
            zzbwk();
        }

        public static zza[] zzbwj() {
            if (aow == null) {
                synchronized (zzapa.bij) {
                    if (aow == null) {
                        aow = new zza[0];
                    }
                }
            }
            return aow;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.name == null) {
                if (zzaVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzaVar.name)) {
                return false;
            }
            if (this.aox == null) {
                if (zzaVar.aox != null) {
                    return false;
                }
            } else if (!this.aox.equals(zzaVar.aox)) {
                return false;
            }
            if (this.aoy == null) {
                return zzaVar.aoy == null;
            }
            return this.aoy.equals(zzaVar.aoy);
        }

        public int hashCode() {
            return (((this.aox == null ? 0 : this.aox.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + (this.aoy != null ? this.aoy.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.name != null) {
                zzaovVar.zzr(1, this.name);
            }
            if (this.aox != null) {
                zzaovVar.zzj(2, this.aox.booleanValue());
            }
            if (this.aoy != null) {
                zzaovVar.zzj(3, this.aoy.booleanValue());
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbj, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzaouVar.readString();
                        break;
                    case 16:
                        this.aox = Boolean.valueOf(zzaouVar.m57P());
                        break;
                    case 24:
                        this.aoy = Boolean.valueOf(zzaouVar.m57P());
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zza zzbwk() {
            this.name = null;
            this.aox = null;
            this.aoy = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.name != null) {
                iZzy += zzaov.zzs(1, this.name);
            }
            if (this.aox != null) {
                iZzy += zzaov.zzk(2, this.aox.booleanValue());
            }
            return this.aoy != null ? iZzy + zzaov.zzk(3, this.aoy.booleanValue()) : iZzy;
        }
    }

    public static final class zzb extends zzapc {
        public String ajz;
        public Integer aoA;
        public zzc[] aoB;
        public zza[] aoC;
        public zzun.zza[] aoD;
        public Long aoz;

        public zzb() {
            zzbwl();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (this.aoz == null) {
                if (zzbVar.aoz != null) {
                    return false;
                }
            } else if (!this.aoz.equals(zzbVar.aoz)) {
                return false;
            }
            if (this.ajz == null) {
                if (zzbVar.ajz != null) {
                    return false;
                }
            } else if (!this.ajz.equals(zzbVar.ajz)) {
                return false;
            }
            if (this.aoA == null) {
                if (zzbVar.aoA != null) {
                    return false;
                }
            } else if (!this.aoA.equals(zzbVar.aoA)) {
                return false;
            }
            return zzapa.equals(this.aoB, zzbVar.aoB) && zzapa.equals(this.aoC, zzbVar.aoC) && zzapa.equals(this.aoD, zzbVar.aoD);
        }

        public int hashCode() {
            return (((((((((this.ajz == null ? 0 : this.ajz.hashCode()) + (((this.aoz == null ? 0 : this.aoz.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + (this.aoA != null ? this.aoA.hashCode() : 0)) * 31) + zzapa.hashCode(this.aoB)) * 31) + zzapa.hashCode(this.aoC)) * 31) + zzapa.hashCode(this.aoD);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.aoz != null) {
                zzaovVar.zzb(1, this.aoz.longValue());
            }
            if (this.ajz != null) {
                zzaovVar.zzr(2, this.ajz);
            }
            if (this.aoA != null) {
                zzaovVar.zzae(3, this.aoA.intValue());
            }
            if (this.aoB != null && this.aoB.length > 0) {
                for (int i = 0; i < this.aoB.length; i++) {
                    zzc zzcVar = this.aoB[i];
                    if (zzcVar != null) {
                        zzaovVar.zza(4, zzcVar);
                    }
                }
            }
            if (this.aoC != null && this.aoC.length > 0) {
                for (int i2 = 0; i2 < this.aoC.length; i2++) {
                    zza zzaVar = this.aoC[i2];
                    if (zzaVar != null) {
                        zzaovVar.zza(5, zzaVar);
                    }
                }
            }
            if (this.aoD != null && this.aoD.length > 0) {
                for (int i3 = 0; i3 < this.aoD.length; i3++) {
                    zzun.zza zzaVar2 = this.aoD[i3];
                    if (zzaVar2 != null) {
                        zzaovVar.zza(6, zzaVar2);
                    }
                }
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbk, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.aoz = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 18:
                        this.ajz = zzaouVar.readString();
                        break;
                    case 24:
                        this.aoA = Integer.valueOf(zzaouVar.m55N());
                        break;
                    case 34:
                        int iZzc = zzapf.zzc(zzaouVar, 34);
                        int length = this.aoB == null ? 0 : this.aoB.length;
                        zzc[] zzcVarArr = new zzc[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.aoB, 0, zzcVarArr, 0, length);
                        }
                        while (length < zzcVarArr.length - 1) {
                            zzcVarArr[length] = new zzc();
                            zzaouVar.zza(zzcVarArr[length]);
                            zzaouVar.m51J();
                            length++;
                        }
                        zzcVarArr[length] = new zzc();
                        zzaouVar.zza(zzcVarArr[length]);
                        this.aoB = zzcVarArr;
                        break;
                    case 42:
                        int iZzc2 = zzapf.zzc(zzaouVar, 42);
                        int length2 = this.aoC == null ? 0 : this.aoC.length;
                        zza[] zzaVarArr = new zza[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.aoC, 0, zzaVarArr, 0, length2);
                        }
                        while (length2 < zzaVarArr.length - 1) {
                            zzaVarArr[length2] = new zza();
                            zzaouVar.zza(zzaVarArr[length2]);
                            zzaouVar.m51J();
                            length2++;
                        }
                        zzaVarArr[length2] = new zza();
                        zzaouVar.zza(zzaVarArr[length2]);
                        this.aoC = zzaVarArr;
                        break;
                    case 50:
                        int iZzc3 = zzapf.zzc(zzaouVar, 50);
                        int length3 = this.aoD == null ? 0 : this.aoD.length;
                        zzun.zza[] zzaVarArr2 = new zzun.zza[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.aoD, 0, zzaVarArr2, 0, length3);
                        }
                        while (length3 < zzaVarArr2.length - 1) {
                            zzaVarArr2[length3] = new zzun.zza();
                            zzaouVar.zza(zzaVarArr2[length3]);
                            zzaouVar.m51J();
                            length3++;
                        }
                        zzaVarArr2[length3] = new zzun.zza();
                        zzaouVar.zza(zzaVarArr2[length3]);
                        this.aoD = zzaVarArr2;
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzb zzbwl() {
            this.aoz = null;
            this.ajz = null;
            this.aoA = null;
            this.aoB = zzc.zzbwm();
            this.aoC = zza.zzbwj();
            this.aoD = zzun.zza.zzbvz();
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.aoz != null) {
                iZzy += zzaov.zze(1, this.aoz.longValue());
            }
            if (this.ajz != null) {
                iZzy += zzaov.zzs(2, this.ajz);
            }
            if (this.aoA != null) {
                iZzy += zzaov.zzag(3, this.aoA.intValue());
            }
            if (this.aoB != null && this.aoB.length > 0) {
                int iZzc = iZzy;
                for (int i = 0; i < this.aoB.length; i++) {
                    zzc zzcVar = this.aoB[i];
                    if (zzcVar != null) {
                        iZzc += zzaov.zzc(4, zzcVar);
                    }
                }
                iZzy = iZzc;
            }
            if (this.aoC != null && this.aoC.length > 0) {
                int iZzc2 = iZzy;
                for (int i2 = 0; i2 < this.aoC.length; i2++) {
                    zza zzaVar = this.aoC[i2];
                    if (zzaVar != null) {
                        iZzc2 += zzaov.zzc(5, zzaVar);
                    }
                }
                iZzy = iZzc2;
            }
            if (this.aoD != null && this.aoD.length > 0) {
                for (int i3 = 0; i3 < this.aoD.length; i3++) {
                    zzun.zza zzaVar2 = this.aoD[i3];
                    if (zzaVar2 != null) {
                        iZzy += zzaov.zzc(6, zzaVar2);
                    }
                }
            }
            return iZzy;
        }
    }

    public static final class zzc extends zzapc {
        private static volatile zzc[] aoE;
        public String value;
        public String zzcb;

        public zzc() {
            zzbwn();
        }

        public static zzc[] zzbwm() {
            if (aoE == null) {
                synchronized (zzapa.bij) {
                    if (aoE == null) {
                        aoE = new zzc[0];
                    }
                }
            }
            return aoE;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            if (this.zzcb == null) {
                if (zzcVar.zzcb != null) {
                    return false;
                }
            } else if (!this.zzcb.equals(zzcVar.zzcb)) {
                return false;
            }
            if (this.value == null) {
                return zzcVar.value == null;
            }
            return this.value.equals(zzcVar.value);
        }

        public int hashCode() {
            return (((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + (this.value != null ? this.value.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzcb != null) {
                zzaovVar.zzr(1, this.zzcb);
            }
            if (this.value != null) {
                zzaovVar.zzr(2, this.value);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbl, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        this.zzcb = zzaouVar.readString();
                        break;
                    case 18:
                        this.value = zzaouVar.readString();
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzc zzbwn() {
            this.zzcb = null;
            this.value = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.zzcb != null) {
                iZzy += zzaov.zzs(1, this.zzcb);
            }
            return this.value != null ? iZzy + zzaov.zzs(2, this.value) : iZzy;
        }
    }
}
