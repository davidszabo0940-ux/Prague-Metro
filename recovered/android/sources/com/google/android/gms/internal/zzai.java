package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzai {

    public static final class zza extends zzaow<zza> {
        private static volatile zza[] zzws;
        public int type;
        public String zzwt;
        public zza[] zzwu;
        public zza[] zzwv;
        public zza[] zzww;
        public String zzwx;
        public String zzwy;
        public long zzwz;
        public boolean zzxa;
        public zza[] zzxb;
        public int[] zzxc;
        public boolean zzxd;

        public zza() {
            zzar();
        }

        public static zza[] zzaq() {
            if (zzws == null) {
                synchronized (zzapa.bij) {
                    if (zzws == null) {
                        zzws = new zza[0];
                    }
                }
            }
            return zzws;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.type != zzaVar.type) {
                return false;
            }
            if (this.zzwt == null) {
                if (zzaVar.zzwt != null) {
                    return false;
                }
            } else if (!this.zzwt.equals(zzaVar.zzwt)) {
                return false;
            }
            if (!zzapa.equals(this.zzwu, zzaVar.zzwu) || !zzapa.equals(this.zzwv, zzaVar.zzwv) || !zzapa.equals(this.zzww, zzaVar.zzww)) {
                return false;
            }
            if (this.zzwx == null) {
                if (zzaVar.zzwx != null) {
                    return false;
                }
            } else if (!this.zzwx.equals(zzaVar.zzwx)) {
                return false;
            }
            if (this.zzwy == null) {
                if (zzaVar.zzwy != null) {
                    return false;
                }
            } else if (!this.zzwy.equals(zzaVar.zzwy)) {
                return false;
            }
            if (this.zzwz != zzaVar.zzwz || this.zzxa != zzaVar.zzxa || !zzapa.equals(this.zzxb, zzaVar.zzxb) || !zzapa.equals(this.zzxc, zzaVar.zzxc) || this.zzxd != zzaVar.zzxd) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzaVar.bib == null || zzaVar.bib.isEmpty();
            }
            return this.bib.equals(zzaVar.bib);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((((((((this.zzxa ? 1231 : 1237) + (((((this.zzwy == null ? 0 : this.zzwy.hashCode()) + (((this.zzwx == null ? 0 : this.zzwx.hashCode()) + (((((((((this.zzwt == null ? 0 : this.zzwt.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31) + zzapa.hashCode(this.zzwu)) * 31) + zzapa.hashCode(this.zzwv)) * 31) + zzapa.hashCode(this.zzww)) * 31)) * 31)) * 31) + ((int) (this.zzwz ^ (this.zzwz >>> 32)))) * 31)) * 31) + zzapa.hashCode(this.zzxb)) * 31) + zzapa.hashCode(this.zzxc)) * 31) + (this.zzxd ? 1231 : 1237)) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                iHashCode = this.bib.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            zzaovVar.zzae(1, this.type);
            if (!this.zzwt.equals("")) {
                zzaovVar.zzr(2, this.zzwt);
            }
            if (this.zzwu != null && this.zzwu.length > 0) {
                for (int i = 0; i < this.zzwu.length; i++) {
                    zza zzaVar = this.zzwu[i];
                    if (zzaVar != null) {
                        zzaovVar.zza(3, zzaVar);
                    }
                }
            }
            if (this.zzwv != null && this.zzwv.length > 0) {
                for (int i2 = 0; i2 < this.zzwv.length; i2++) {
                    zza zzaVar2 = this.zzwv[i2];
                    if (zzaVar2 != null) {
                        zzaovVar.zza(4, zzaVar2);
                    }
                }
            }
            if (this.zzww != null && this.zzww.length > 0) {
                for (int i3 = 0; i3 < this.zzww.length; i3++) {
                    zza zzaVar3 = this.zzww[i3];
                    if (zzaVar3 != null) {
                        zzaovVar.zza(5, zzaVar3);
                    }
                }
            }
            if (!this.zzwx.equals("")) {
                zzaovVar.zzr(6, this.zzwx);
            }
            if (!this.zzwy.equals("")) {
                zzaovVar.zzr(7, this.zzwy);
            }
            if (this.zzwz != 0) {
                zzaovVar.zzb(8, this.zzwz);
            }
            if (this.zzxd) {
                zzaovVar.zzj(9, this.zzxd);
            }
            if (this.zzxc != null && this.zzxc.length > 0) {
                for (int i4 = 0; i4 < this.zzxc.length; i4++) {
                    zzaovVar.zzae(10, this.zzxc[i4]);
                }
            }
            if (this.zzxb != null && this.zzxb.length > 0) {
                for (int i5 = 0; i5 < this.zzxb.length; i5++) {
                    zza zzaVar4 = this.zzxb[i5];
                    if (zzaVar4 != null) {
                        zzaovVar.zza(11, zzaVar4);
                    }
                }
            }
            if (this.zzxa) {
                zzaovVar.zzj(12, this.zzxa);
            }
            super.zza(zzaovVar);
        }

        public zza zzar() {
            this.type = 1;
            this.zzwt = "";
            this.zzwu = zzaq();
            this.zzwv = zzaq();
            this.zzww = zzaq();
            this.zzwx = "";
            this.zzwy = "";
            this.zzwz = 0L;
            this.zzxa = false;
            this.zzxb = zzaq();
            this.zzxc = zzapf.bim;
            this.zzxd = false;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzaou zzaouVar) throws IOException {
            int i;
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        int iM55N = zzaouVar.m55N();
                        switch (iM55N) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = iM55N;
                                break;
                        }
                        break;
                    case 18:
                        this.zzwt = zzaouVar.readString();
                        break;
                    case 26:
                        int iZzc = zzapf.zzc(zzaouVar, 26);
                        int length = this.zzwu == null ? 0 : this.zzwu.length;
                        zza[] zzaVarArr = new zza[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzwu, 0, zzaVarArr, 0, length);
                        }
                        while (length < zzaVarArr.length - 1) {
                            zzaVarArr[length] = new zza();
                            zzaouVar.zza(zzaVarArr[length]);
                            zzaouVar.m51J();
                            length++;
                        }
                        zzaVarArr[length] = new zza();
                        zzaouVar.zza(zzaVarArr[length]);
                        this.zzwu = zzaVarArr;
                        break;
                    case 34:
                        int iZzc2 = zzapf.zzc(zzaouVar, 34);
                        int length2 = this.zzwv == null ? 0 : this.zzwv.length;
                        zza[] zzaVarArr2 = new zza[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzwv, 0, zzaVarArr2, 0, length2);
                        }
                        while (length2 < zzaVarArr2.length - 1) {
                            zzaVarArr2[length2] = new zza();
                            zzaouVar.zza(zzaVarArr2[length2]);
                            zzaouVar.m51J();
                            length2++;
                        }
                        zzaVarArr2[length2] = new zza();
                        zzaouVar.zza(zzaVarArr2[length2]);
                        this.zzwv = zzaVarArr2;
                        break;
                    case 42:
                        int iZzc3 = zzapf.zzc(zzaouVar, 42);
                        int length3 = this.zzww == null ? 0 : this.zzww.length;
                        zza[] zzaVarArr3 = new zza[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzww, 0, zzaVarArr3, 0, length3);
                        }
                        while (length3 < zzaVarArr3.length - 1) {
                            zzaVarArr3[length3] = new zza();
                            zzaouVar.zza(zzaVarArr3[length3]);
                            zzaouVar.m51J();
                            length3++;
                        }
                        zzaVarArr3[length3] = new zza();
                        zzaouVar.zza(zzaVarArr3[length3]);
                        this.zzww = zzaVarArr3;
                        break;
                    case 50:
                        this.zzwx = zzaouVar.readString();
                        break;
                    case 58:
                        this.zzwy = zzaouVar.readString();
                        break;
                    case 64:
                        this.zzwz = zzaouVar.m54M();
                        break;
                    case 72:
                        this.zzxd = zzaouVar.m57P();
                        break;
                    case 80:
                        int iZzc4 = zzapf.zzc(zzaouVar, 80);
                        int[] iArr = new int[iZzc4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < iZzc4) {
                            if (i2 != 0) {
                                zzaouVar.m51J();
                            }
                            int iM55N2 = zzaouVar.m55N();
                            switch (iM55N2) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i = i3 + 1;
                                    iArr[i3] = iM55N2;
                                    break;
                                default:
                                    i = i3;
                                    break;
                            }
                            i2++;
                            i3 = i;
                        }
                        if (i3 != 0) {
                            int length4 = this.zzxc == null ? 0 : this.zzxc.length;
                            if (length4 == 0 && i3 == iZzc4) {
                                this.zzxc = iArr;
                            } else {
                                int[] iArr2 = new int[length4 + i3];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzxc, 0, iArr2, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr2, length4, i3);
                                this.zzxc = iArr2;
                            }
                        }
                        break;
                    case 82:
                        int iZzaei = zzaouVar.zzaei(zzaouVar.m60S());
                        int position = zzaouVar.getPosition();
                        int i4 = 0;
                        while (zzaouVar.m64X() > 0) {
                            switch (zzaouVar.m55N()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i4++;
                                    break;
                            }
                        }
                        if (i4 != 0) {
                            zzaouVar.zzaek(position);
                            int length5 = this.zzxc == null ? 0 : this.zzxc.length;
                            int[] iArr3 = new int[i4 + length5];
                            if (length5 != 0) {
                                System.arraycopy(this.zzxc, 0, iArr3, 0, length5);
                            }
                            while (zzaouVar.m64X() > 0) {
                                int iM55N3 = zzaouVar.m55N();
                                switch (iM55N3) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        iArr3[length5] = iM55N3;
                                        length5++;
                                        break;
                                }
                            }
                            this.zzxc = iArr3;
                        }
                        zzaouVar.zzaej(iZzaei);
                        break;
                    case 90:
                        int iZzc5 = zzapf.zzc(zzaouVar, 90);
                        int length6 = this.zzxb == null ? 0 : this.zzxb.length;
                        zza[] zzaVarArr4 = new zza[iZzc5 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzxb, 0, zzaVarArr4, 0, length6);
                        }
                        while (length6 < zzaVarArr4.length - 1) {
                            zzaVarArr4[length6] = new zza();
                            zzaouVar.zza(zzaVarArr4[length6]);
                            zzaouVar.m51J();
                            length6++;
                        }
                        zzaVarArr4[length6] = new zza();
                        zzaouVar.zza(zzaVarArr4[length6]);
                        this.zzxb = zzaVarArr4;
                        break;
                    case 96:
                        this.zzxa = zzaouVar.m57P();
                        break;
                    default:
                        if (!super.zza(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy() + zzaov.zzag(1, this.type);
            if (!this.zzwt.equals("")) {
                iZzy += zzaov.zzs(2, this.zzwt);
            }
            if (this.zzwu != null && this.zzwu.length > 0) {
                int iZzc = iZzy;
                for (int i = 0; i < this.zzwu.length; i++) {
                    zza zzaVar = this.zzwu[i];
                    if (zzaVar != null) {
                        iZzc += zzaov.zzc(3, zzaVar);
                    }
                }
                iZzy = iZzc;
            }
            if (this.zzwv != null && this.zzwv.length > 0) {
                int iZzc2 = iZzy;
                for (int i2 = 0; i2 < this.zzwv.length; i2++) {
                    zza zzaVar2 = this.zzwv[i2];
                    if (zzaVar2 != null) {
                        iZzc2 += zzaov.zzc(4, zzaVar2);
                    }
                }
                iZzy = iZzc2;
            }
            if (this.zzww != null && this.zzww.length > 0) {
                int iZzc3 = iZzy;
                for (int i3 = 0; i3 < this.zzww.length; i3++) {
                    zza zzaVar3 = this.zzww[i3];
                    if (zzaVar3 != null) {
                        iZzc3 += zzaov.zzc(5, zzaVar3);
                    }
                }
                iZzy = iZzc3;
            }
            if (!this.zzwx.equals("")) {
                iZzy += zzaov.zzs(6, this.zzwx);
            }
            if (!this.zzwy.equals("")) {
                iZzy += zzaov.zzs(7, this.zzwy);
            }
            if (this.zzwz != 0) {
                iZzy += zzaov.zze(8, this.zzwz);
            }
            if (this.zzxd) {
                iZzy += zzaov.zzk(9, this.zzxd);
            }
            if (this.zzxc != null && this.zzxc.length > 0) {
                int iZzaeo = 0;
                for (int i4 = 0; i4 < this.zzxc.length; i4++) {
                    iZzaeo += zzaov.zzaeo(this.zzxc[i4]);
                }
                iZzy = iZzy + iZzaeo + (this.zzxc.length * 1);
            }
            if (this.zzxb != null && this.zzxb.length > 0) {
                for (int i5 = 0; i5 < this.zzxb.length; i5++) {
                    zza zzaVar4 = this.zzxb[i5];
                    if (zzaVar4 != null) {
                        iZzy += zzaov.zzc(11, zzaVar4);
                    }
                }
            }
            return this.zzxa ? iZzy + zzaov.zzk(12, this.zzxa) : iZzy;
        }
    }
}
