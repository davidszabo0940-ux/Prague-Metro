package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public interface zzapg {

    public static final class zza extends zzaow<zza> implements Cloneable {
        public String[] biu;
        public String[] biv;
        public int[] biw;
        public long[] bix;
        public long[] biy;

        public zza() {
            m82ap();
        }

        @Override // com.google.android.gms.internal.zzaow
        /* JADX INFO: renamed from: ac */
        public /* synthetic */ zzaow clone() throws CloneNotSupportedException {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: ad */
        public /* synthetic */ zzapc clone() throws CloneNotSupportedException {
            return (zza) clone();
        }

        /* JADX INFO: renamed from: ap */
        public zza m82ap() {
            this.biu = zzapf.bir;
            this.biv = zzapf.bir;
            this.biw = zzapf.bim;
            this.bix = zzapf.bin;
            this.biy = zzapf.bin;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: aq, reason: merged with bridge method [inline-methods] */
        public zza clone() {
            try {
                zza zzaVar = (zza) super.clone();
                if (this.biu != null && this.biu.length > 0) {
                    zzaVar.biu = (String[]) this.biu.clone();
                }
                if (this.biv != null && this.biv.length > 0) {
                    zzaVar.biv = (String[]) this.biv.clone();
                }
                if (this.biw != null && this.biw.length > 0) {
                    zzaVar.biw = (int[]) this.biw.clone();
                }
                if (this.bix != null && this.bix.length > 0) {
                    zzaVar.bix = (long[]) this.bix.clone();
                }
                if (this.biy != null && this.biy.length > 0) {
                    zzaVar.biy = (long[]) this.biy.clone();
                }
                return zzaVar;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (!zzapa.equals(this.biu, zzaVar.biu) || !zzapa.equals(this.biv, zzaVar.biv) || !zzapa.equals(this.biw, zzaVar.biw) || !zzapa.equals(this.bix, zzaVar.bix) || !zzapa.equals(this.biy, zzaVar.biy)) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzaVar.bib == null || zzaVar.bib.isEmpty();
            }
            return this.bib.equals(zzaVar.bib);
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.biu)) * 31) + zzapa.hashCode(this.biv)) * 31) + zzapa.hashCode(this.biw)) * 31) + zzapa.hashCode(this.bix)) * 31) + zzapa.hashCode(this.biy)) * 31);
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.biu != null && this.biu.length > 0) {
                for (int i = 0; i < this.biu.length; i++) {
                    String str = this.biu[i];
                    if (str != null) {
                        zzaovVar.zzr(1, str);
                    }
                }
            }
            if (this.biv != null && this.biv.length > 0) {
                for (int i2 = 0; i2 < this.biv.length; i2++) {
                    String str2 = this.biv[i2];
                    if (str2 != null) {
                        zzaovVar.zzr(2, str2);
                    }
                }
            }
            if (this.biw != null && this.biw.length > 0) {
                for (int i3 = 0; i3 < this.biw.length; i3++) {
                    zzaovVar.zzae(3, this.biw[i3]);
                }
            }
            if (this.bix != null && this.bix.length > 0) {
                for (int i4 = 0; i4 < this.bix.length; i4++) {
                    zzaovVar.zzb(4, this.bix[i4]);
                }
            }
            if (this.biy != null && this.biy.length > 0) {
                for (int i5 = 0; i5 < this.biy.length; i5++) {
                    zzaovVar.zzb(5, this.biy[i5]);
                }
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzcg, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzapf.zzc(zzaouVar, 10);
                        int length = this.biu == null ? 0 : this.biu.length;
                        String[] strArr = new String[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.biu, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzaouVar.readString();
                            zzaouVar.m51J();
                            length++;
                        }
                        strArr[length] = zzaouVar.readString();
                        this.biu = strArr;
                        break;
                    case 18:
                        int iZzc2 = zzapf.zzc(zzaouVar, 18);
                        int length2 = this.biv == null ? 0 : this.biv.length;
                        String[] strArr2 = new String[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.biv, 0, strArr2, 0, length2);
                        }
                        while (length2 < strArr2.length - 1) {
                            strArr2[length2] = zzaouVar.readString();
                            zzaouVar.m51J();
                            length2++;
                        }
                        strArr2[length2] = zzaouVar.readString();
                        this.biv = strArr2;
                        break;
                    case 24:
                        int iZzc3 = zzapf.zzc(zzaouVar, 24);
                        int length3 = this.biw == null ? 0 : this.biw.length;
                        int[] iArr = new int[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.biw, 0, iArr, 0, length3);
                        }
                        while (length3 < iArr.length - 1) {
                            iArr[length3] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length3++;
                        }
                        iArr[length3] = zzaouVar.m55N();
                        this.biw = iArr;
                        break;
                    case 26:
                        int iZzaei = zzaouVar.zzaei(zzaouVar.m60S());
                        int position = zzaouVar.getPosition();
                        int i = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i++;
                        }
                        zzaouVar.zzaek(position);
                        int length4 = this.biw == null ? 0 : this.biw.length;
                        int[] iArr2 = new int[i + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.biw, 0, iArr2, 0, length4);
                        }
                        while (length4 < iArr2.length) {
                            iArr2[length4] = zzaouVar.m55N();
                            length4++;
                        }
                        this.biw = iArr2;
                        zzaouVar.zzaej(iZzaei);
                        break;
                    case 32:
                        int iZzc4 = zzapf.zzc(zzaouVar, 32);
                        int length5 = this.bix == null ? 0 : this.bix.length;
                        long[] jArr = new long[iZzc4 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.bix, 0, jArr, 0, length5);
                        }
                        while (length5 < jArr.length - 1) {
                            jArr[length5] = zzaouVar.m54M();
                            zzaouVar.m51J();
                            length5++;
                        }
                        jArr[length5] = zzaouVar.m54M();
                        this.bix = jArr;
                        break;
                    case 34:
                        int iZzaei2 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position2 = zzaouVar.getPosition();
                        int i2 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m54M();
                            i2++;
                        }
                        zzaouVar.zzaek(position2);
                        int length6 = this.bix == null ? 0 : this.bix.length;
                        long[] jArr2 = new long[i2 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.bix, 0, jArr2, 0, length6);
                        }
                        while (length6 < jArr2.length) {
                            jArr2[length6] = zzaouVar.m54M();
                            length6++;
                        }
                        this.bix = jArr2;
                        zzaouVar.zzaej(iZzaei2);
                        break;
                    case 40:
                        int iZzc5 = zzapf.zzc(zzaouVar, 40);
                        int length7 = this.biy == null ? 0 : this.biy.length;
                        long[] jArr3 = new long[iZzc5 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.biy, 0, jArr3, 0, length7);
                        }
                        while (length7 < jArr3.length - 1) {
                            jArr3[length7] = zzaouVar.m54M();
                            zzaouVar.m51J();
                            length7++;
                        }
                        jArr3[length7] = zzaouVar.m54M();
                        this.biy = jArr3;
                        break;
                    case 42:
                        int iZzaei3 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position3 = zzaouVar.getPosition();
                        int i3 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m54M();
                            i3++;
                        }
                        zzaouVar.zzaek(position3);
                        int length8 = this.biy == null ? 0 : this.biy.length;
                        long[] jArr4 = new long[i3 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.biy, 0, jArr4, 0, length8);
                        }
                        while (length8 < jArr4.length) {
                            jArr4[length8] = zzaouVar.m54M();
                            length8++;
                        }
                        this.biy = jArr4;
                        zzaouVar.zzaej(iZzaei3);
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
            int length;
            int iZzy = super.zzy();
            if (this.biu == null || this.biu.length <= 0) {
                length = iZzy;
            } else {
                int iZztg = 0;
                int i = 0;
                for (int i2 = 0; i2 < this.biu.length; i2++) {
                    String str = this.biu[i2];
                    if (str != null) {
                        i++;
                        iZztg += zzaov.zztg(str);
                    }
                }
                length = iZzy + iZztg + (i * 1);
            }
            if (this.biv != null && this.biv.length > 0) {
                int iZztg2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < this.biv.length; i4++) {
                    String str2 = this.biv[i4];
                    if (str2 != null) {
                        i3++;
                        iZztg2 += zzaov.zztg(str2);
                    }
                }
                length = length + iZztg2 + (i3 * 1);
            }
            if (this.biw != null && this.biw.length > 0) {
                int iZzaeo = 0;
                for (int i5 = 0; i5 < this.biw.length; i5++) {
                    iZzaeo += zzaov.zzaeo(this.biw[i5]);
                }
                length = length + iZzaeo + (this.biw.length * 1);
            }
            if (this.bix != null && this.bix.length > 0) {
                int iZzcw = 0;
                for (int i6 = 0; i6 < this.bix.length; i6++) {
                    iZzcw += zzaov.zzcw(this.bix[i6]);
                }
                length = length + iZzcw + (this.bix.length * 1);
            }
            if (this.biy == null || this.biy.length <= 0) {
                return length;
            }
            int iZzcw2 = 0;
            for (int i7 = 0; i7 < this.biy.length; i7++) {
                iZzcw2 += zzaov.zzcw(this.biy[i7]);
            }
            return length + iZzcw2 + (this.biy.length * 1);
        }
    }

    public static final class zzb extends zzaow<zzb> implements Cloneable {
        public String biA;
        public int biz;
        public String version;

        public zzb() {
            m84ar();
        }

        @Override // com.google.android.gms.internal.zzaow
        /* JADX INFO: renamed from: ac */
        public /* synthetic */ zzaow clone() throws CloneNotSupportedException {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: ad */
        public /* synthetic */ zzapc clone() throws CloneNotSupportedException {
            return (zzb) clone();
        }

        /* JADX INFO: renamed from: ar */
        public zzb m84ar() {
            this.biz = 0;
            this.biA = "";
            this.version = "";
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: as, reason: merged with bridge method [inline-methods] */
        public zzb clone() {
            try {
                return (zzb) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (this.biz != zzbVar.biz) {
                return false;
            }
            if (this.biA == null) {
                if (zzbVar.biA != null) {
                    return false;
                }
            } else if (!this.biA.equals(zzbVar.biA)) {
                return false;
            }
            if (this.version == null) {
                if (zzbVar.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzbVar.version)) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzbVar.bib == null || zzbVar.bib.isEmpty();
            }
            return this.bib.equals(zzbVar.bib);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.version == null ? 0 : this.version.hashCode()) + (((this.biA == null ? 0 : this.biA.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.biz) * 31)) * 31)) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                iHashCode = this.bib.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.biz != 0) {
                zzaovVar.zzae(1, this.biz);
            }
            if (!this.biA.equals("")) {
                zzaovVar.zzr(2, this.biA);
            }
            if (!this.version.equals("")) {
                zzaovVar.zzr(3, this.version);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzch, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.biz = zzaouVar.m55N();
                        break;
                    case 18:
                        this.biA = zzaouVar.readString();
                        break;
                    case 26:
                        this.version = zzaouVar.readString();
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
            int iZzy = super.zzy();
            if (this.biz != 0) {
                iZzy += zzaov.zzag(1, this.biz);
            }
            if (!this.biA.equals("")) {
                iZzy += zzaov.zzs(2, this.biA);
            }
            return !this.version.equals("") ? iZzy + zzaov.zzs(3, this.version) : iZzy;
        }
    }

    public static final class zzc extends zzaow<zzc> implements Cloneable {
        public byte[] biB;
        public String biC;
        public byte[][] biD;
        public boolean biE;

        public zzc() {
            m86at();
        }

        @Override // com.google.android.gms.internal.zzaow
        /* JADX INFO: renamed from: ac */
        public /* synthetic */ zzaow clone() throws CloneNotSupportedException {
            return (zzc) clone();
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: ad */
        public /* synthetic */ zzapc clone() throws CloneNotSupportedException {
            return (zzc) clone();
        }

        /* JADX INFO: renamed from: at */
        public zzc m86at() {
            this.biB = zzapf.bit;
            this.biC = "";
            this.biD = zzapf.bis;
            this.biE = false;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: au, reason: merged with bridge method [inline-methods] */
        public zzc clone() {
            try {
                zzc zzcVar = (zzc) super.clone();
                if (this.biD != null && this.biD.length > 0) {
                    zzcVar.biD = (byte[][]) this.biD.clone();
                }
                return zzcVar;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            if (!Arrays.equals(this.biB, zzcVar.biB)) {
                return false;
            }
            if (this.biC == null) {
                if (zzcVar.biC != null) {
                    return false;
                }
            } else if (!this.biC.equals(zzcVar.biC)) {
                return false;
            }
            if (!zzapa.zza(this.biD, zzcVar.biD) || this.biE != zzcVar.biE) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzcVar.bib == null || zzcVar.bib.isEmpty();
            }
            return this.bib.equals(zzcVar.bib);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.biE ? 1231 : 1237) + (((((this.biC == null ? 0 : this.biC.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.biB)) * 31)) * 31) + zzapa.zzb(this.biD)) * 31)) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                iHashCode = this.bib.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (!Arrays.equals(this.biB, zzapf.bit)) {
                zzaovVar.zza(1, this.biB);
            }
            if (this.biD != null && this.biD.length > 0) {
                for (int i = 0; i < this.biD.length; i++) {
                    byte[] bArr = this.biD[i];
                    if (bArr != null) {
                        zzaovVar.zza(2, bArr);
                    }
                }
            }
            if (this.biE) {
                zzaovVar.zzj(3, this.biE);
            }
            if (!this.biC.equals("")) {
                zzaovVar.zzr(4, this.biC);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzci, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        this.biB = zzaouVar.readBytes();
                        break;
                    case 18:
                        int iZzc = zzapf.zzc(zzaouVar, 18);
                        int length = this.biD == null ? 0 : this.biD.length;
                        byte[][] bArr = new byte[iZzc + length][];
                        if (length != 0) {
                            System.arraycopy(this.biD, 0, bArr, 0, length);
                        }
                        while (length < bArr.length - 1) {
                            bArr[length] = zzaouVar.readBytes();
                            zzaouVar.m51J();
                            length++;
                        }
                        bArr[length] = zzaouVar.readBytes();
                        this.biD = bArr;
                        break;
                    case 24:
                        this.biE = zzaouVar.m57P();
                        break;
                    case 34:
                        this.biC = zzaouVar.readString();
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
            int iZzy = super.zzy();
            if (!Arrays.equals(this.biB, zzapf.bit)) {
                iZzy += zzaov.zzb(1, this.biB);
            }
            if (this.biD != null && this.biD.length > 0) {
                int iZzbc = 0;
                int i = 0;
                for (int i2 = 0; i2 < this.biD.length; i2++) {
                    byte[] bArr = this.biD[i2];
                    if (bArr != null) {
                        i++;
                        iZzbc += zzaov.zzbc(bArr);
                    }
                }
                iZzy = iZzy + iZzbc + (i * 1);
            }
            if (this.biE) {
                iZzy += zzaov.zzk(3, this.biE);
            }
            return !this.biC.equals("") ? iZzy + zzaov.zzs(4, this.biC) : iZzy;
        }
    }

    public static final class zzd extends zzaow<zzd> implements Cloneable {
        public boolean aTD;
        public long biF;
        public long biG;
        public long biH;
        public int biI;
        public zze[] biJ;
        public byte[] biK;
        public zzb biL;
        public byte[] biM;
        public String biN;
        public String biO;
        public zza biP;
        public String biQ;
        public long biR;
        public zzc biS;
        public byte[] biT;
        public String biU;
        public int biV;
        public int[] biW;
        public long biX;
        public zzf biY;
        public String tag;
        public int zzahl;

        public zzd() {
            m88av();
        }

        @Override // com.google.android.gms.internal.zzaow
        /* JADX INFO: renamed from: ac */
        public /* synthetic */ zzaow clone() throws CloneNotSupportedException {
            return (zzd) clone();
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: ad */
        public /* synthetic */ zzapc clone() throws CloneNotSupportedException {
            return (zzd) clone();
        }

        /* JADX INFO: renamed from: av */
        public zzd m88av() {
            this.biF = 0L;
            this.biG = 0L;
            this.biH = 0L;
            this.tag = "";
            this.biI = 0;
            this.zzahl = 0;
            this.aTD = false;
            this.biJ = zze.m90ax();
            this.biK = zzapf.bit;
            this.biL = null;
            this.biM = zzapf.bit;
            this.biN = "";
            this.biO = "";
            this.biP = null;
            this.biQ = "";
            this.biR = 180000L;
            this.biS = null;
            this.biT = zzapf.bit;
            this.biU = "";
            this.biV = 0;
            this.biW = zzapf.bim;
            this.biX = 0L;
            this.biY = null;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: aw, reason: merged with bridge method [inline-methods] */
        public zzd clone() {
            try {
                zzd zzdVar = (zzd) super.clone();
                if (this.biJ != null && this.biJ.length > 0) {
                    zzdVar.biJ = new zze[this.biJ.length];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.biJ.length) {
                            break;
                        }
                        if (this.biJ[i2] != null) {
                            zzdVar.biJ[i2] = (zze) this.biJ[i2].clone();
                        }
                        i = i2 + 1;
                    }
                }
                if (this.biL != null) {
                    zzdVar.biL = (zzb) this.biL.clone();
                }
                if (this.biP != null) {
                    zzdVar.biP = (zza) this.biP.clone();
                }
                if (this.biS != null) {
                    zzdVar.biS = (zzc) this.biS.clone();
                }
                if (this.biW != null && this.biW.length > 0) {
                    zzdVar.biW = (int[]) this.biW.clone();
                }
                if (this.biY != null) {
                    zzdVar.biY = (zzf) this.biY.clone();
                }
                return zzdVar;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (this.biF != zzdVar.biF || this.biG != zzdVar.biG || this.biH != zzdVar.biH) {
                return false;
            }
            if (this.tag == null) {
                if (zzdVar.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(zzdVar.tag)) {
                return false;
            }
            if (this.biI != zzdVar.biI || this.zzahl != zzdVar.zzahl || this.aTD != zzdVar.aTD || !zzapa.equals(this.biJ, zzdVar.biJ) || !Arrays.equals(this.biK, zzdVar.biK)) {
                return false;
            }
            if (this.biL == null) {
                if (zzdVar.biL != null) {
                    return false;
                }
            } else if (!this.biL.equals(zzdVar.biL)) {
                return false;
            }
            if (!Arrays.equals(this.biM, zzdVar.biM)) {
                return false;
            }
            if (this.biN == null) {
                if (zzdVar.biN != null) {
                    return false;
                }
            } else if (!this.biN.equals(zzdVar.biN)) {
                return false;
            }
            if (this.biO == null) {
                if (zzdVar.biO != null) {
                    return false;
                }
            } else if (!this.biO.equals(zzdVar.biO)) {
                return false;
            }
            if (this.biP == null) {
                if (zzdVar.biP != null) {
                    return false;
                }
            } else if (!this.biP.equals(zzdVar.biP)) {
                return false;
            }
            if (this.biQ == null) {
                if (zzdVar.biQ != null) {
                    return false;
                }
            } else if (!this.biQ.equals(zzdVar.biQ)) {
                return false;
            }
            if (this.biR != zzdVar.biR) {
                return false;
            }
            if (this.biS == null) {
                if (zzdVar.biS != null) {
                    return false;
                }
            } else if (!this.biS.equals(zzdVar.biS)) {
                return false;
            }
            if (!Arrays.equals(this.biT, zzdVar.biT)) {
                return false;
            }
            if (this.biU == null) {
                if (zzdVar.biU != null) {
                    return false;
                }
            } else if (!this.biU.equals(zzdVar.biU)) {
                return false;
            }
            if (this.biV != zzdVar.biV || !zzapa.equals(this.biW, zzdVar.biW) || this.biX != zzdVar.biX) {
                return false;
            }
            if (this.biY == null) {
                if (zzdVar.biY != null) {
                    return false;
                }
            } else if (!this.biY.equals(zzdVar.biY)) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzdVar.bib == null || zzdVar.bib.isEmpty();
            }
            return this.bib.equals(zzdVar.bib);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.biY == null ? 0 : this.biY.hashCode()) + (((((((((this.biU == null ? 0 : this.biU.hashCode()) + (((((this.biS == null ? 0 : this.biS.hashCode()) + (((((this.biQ == null ? 0 : this.biQ.hashCode()) + (((this.biP == null ? 0 : this.biP.hashCode()) + (((this.biO == null ? 0 : this.biO.hashCode()) + (((this.biN == null ? 0 : this.biN.hashCode()) + (((((this.biL == null ? 0 : this.biL.hashCode()) + (((((((this.aTD ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.biF ^ (this.biF >>> 32)))) * 31) + ((int) (this.biG ^ (this.biG >>> 32)))) * 31) + ((int) (this.biH ^ (this.biH >>> 32)))) * 31)) * 31) + this.biI) * 31) + this.zzahl) * 31)) * 31) + zzapa.hashCode(this.biJ)) * 31) + Arrays.hashCode(this.biK)) * 31)) * 31) + Arrays.hashCode(this.biM)) * 31)) * 31)) * 31)) * 31)) * 31) + ((int) (this.biR ^ (this.biR >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.biT)) * 31)) * 31) + this.biV) * 31) + zzapa.hashCode(this.biW)) * 31) + ((int) (this.biX ^ (this.biX >>> 32)))) * 31)) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                iHashCode = this.bib.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.biF != 0) {
                zzaovVar.zzb(1, this.biF);
            }
            if (!this.tag.equals("")) {
                zzaovVar.zzr(2, this.tag);
            }
            if (this.biJ != null && this.biJ.length > 0) {
                for (int i = 0; i < this.biJ.length; i++) {
                    zze zzeVar = this.biJ[i];
                    if (zzeVar != null) {
                        zzaovVar.zza(3, zzeVar);
                    }
                }
            }
            if (!Arrays.equals(this.biK, zzapf.bit)) {
                zzaovVar.zza(4, this.biK);
            }
            if (!Arrays.equals(this.biM, zzapf.bit)) {
                zzaovVar.zza(6, this.biM);
            }
            if (this.biP != null) {
                zzaovVar.zza(7, this.biP);
            }
            if (!this.biN.equals("")) {
                zzaovVar.zzr(8, this.biN);
            }
            if (this.biL != null) {
                zzaovVar.zza(9, this.biL);
            }
            if (this.aTD) {
                zzaovVar.zzj(10, this.aTD);
            }
            if (this.biI != 0) {
                zzaovVar.zzae(11, this.biI);
            }
            if (this.zzahl != 0) {
                zzaovVar.zzae(12, this.zzahl);
            }
            if (!this.biO.equals("")) {
                zzaovVar.zzr(13, this.biO);
            }
            if (!this.biQ.equals("")) {
                zzaovVar.zzr(14, this.biQ);
            }
            if (this.biR != 180000) {
                zzaovVar.zzd(15, this.biR);
            }
            if (this.biS != null) {
                zzaovVar.zza(16, this.biS);
            }
            if (this.biG != 0) {
                zzaovVar.zzb(17, this.biG);
            }
            if (!Arrays.equals(this.biT, zzapf.bit)) {
                zzaovVar.zza(18, this.biT);
            }
            if (this.biV != 0) {
                zzaovVar.zzae(19, this.biV);
            }
            if (this.biW != null && this.biW.length > 0) {
                for (int i2 = 0; i2 < this.biW.length; i2++) {
                    zzaovVar.zzae(20, this.biW[i2]);
                }
            }
            if (this.biH != 0) {
                zzaovVar.zzb(21, this.biH);
            }
            if (this.biX != 0) {
                zzaovVar.zzb(22, this.biX);
            }
            if (this.biY != null) {
                zzaovVar.zza(23, this.biY);
            }
            if (!this.biU.equals("")) {
                zzaovVar.zzr(24, this.biU);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzcj, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.biF = zzaouVar.m54M();
                        break;
                    case 18:
                        this.tag = zzaouVar.readString();
                        break;
                    case 26:
                        int iZzc = zzapf.zzc(zzaouVar, 26);
                        int length = this.biJ == null ? 0 : this.biJ.length;
                        zze[] zzeVarArr = new zze[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.biJ, 0, zzeVarArr, 0, length);
                        }
                        while (length < zzeVarArr.length - 1) {
                            zzeVarArr[length] = new zze();
                            zzaouVar.zza(zzeVarArr[length]);
                            zzaouVar.m51J();
                            length++;
                        }
                        zzeVarArr[length] = new zze();
                        zzaouVar.zza(zzeVarArr[length]);
                        this.biJ = zzeVarArr;
                        break;
                    case 34:
                        this.biK = zzaouVar.readBytes();
                        break;
                    case 50:
                        this.biM = zzaouVar.readBytes();
                        break;
                    case 58:
                        if (this.biP == null) {
                            this.biP = new zza();
                        }
                        zzaouVar.zza(this.biP);
                        break;
                    case 66:
                        this.biN = zzaouVar.readString();
                        break;
                    case 74:
                        if (this.biL == null) {
                            this.biL = new zzb();
                        }
                        zzaouVar.zza(this.biL);
                        break;
                    case 80:
                        this.aTD = zzaouVar.m57P();
                        break;
                    case 88:
                        this.biI = zzaouVar.m55N();
                        break;
                    case 96:
                        this.zzahl = zzaouVar.m55N();
                        break;
                    case 106:
                        this.biO = zzaouVar.readString();
                        break;
                    case 114:
                        this.biQ = zzaouVar.readString();
                        break;
                    case 120:
                        this.biR = zzaouVar.m59R();
                        break;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        if (this.biS == null) {
                            this.biS = new zzc();
                        }
                        zzaouVar.zza(this.biS);
                        break;
                    case 136:
                        this.biG = zzaouVar.m54M();
                        break;
                    case 146:
                        this.biT = zzaouVar.readBytes();
                        break;
                    case 152:
                        int iM55N = zzaouVar.m55N();
                        switch (iM55N) {
                            case 0:
                            case 1:
                            case 2:
                                this.biV = iM55N;
                                break;
                        }
                        break;
                    case 160:
                        int iZzc2 = zzapf.zzc(zzaouVar, 160);
                        int length2 = this.biW == null ? 0 : this.biW.length;
                        int[] iArr = new int[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.biW, 0, iArr, 0, length2);
                        }
                        while (length2 < iArr.length - 1) {
                            iArr[length2] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length2++;
                        }
                        iArr[length2] = zzaouVar.m55N();
                        this.biW = iArr;
                        break;
                    case 162:
                        int iZzaei = zzaouVar.zzaei(zzaouVar.m60S());
                        int position = zzaouVar.getPosition();
                        int i = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i++;
                        }
                        zzaouVar.zzaek(position);
                        int length3 = this.biW == null ? 0 : this.biW.length;
                        int[] iArr2 = new int[i + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.biW, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = zzaouVar.m55N();
                            length3++;
                        }
                        this.biW = iArr2;
                        zzaouVar.zzaej(iZzaei);
                        break;
                    case 168:
                        this.biH = zzaouVar.m54M();
                        break;
                    case 176:
                        this.biX = zzaouVar.m54M();
                        break;
                    case 186:
                        if (this.biY == null) {
                            this.biY = new zzf();
                        }
                        zzaouVar.zza(this.biY);
                        break;
                    case 194:
                        this.biU = zzaouVar.readString();
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
            int iZzy = super.zzy();
            if (this.biF != 0) {
                iZzy += zzaov.zze(1, this.biF);
            }
            if (!this.tag.equals("")) {
                iZzy += zzaov.zzs(2, this.tag);
            }
            if (this.biJ != null && this.biJ.length > 0) {
                int iZzc = iZzy;
                for (int i = 0; i < this.biJ.length; i++) {
                    zze zzeVar = this.biJ[i];
                    if (zzeVar != null) {
                        iZzc += zzaov.zzc(3, zzeVar);
                    }
                }
                iZzy = iZzc;
            }
            if (!Arrays.equals(this.biK, zzapf.bit)) {
                iZzy += zzaov.zzb(4, this.biK);
            }
            if (!Arrays.equals(this.biM, zzapf.bit)) {
                iZzy += zzaov.zzb(6, this.biM);
            }
            if (this.biP != null) {
                iZzy += zzaov.zzc(7, this.biP);
            }
            if (!this.biN.equals("")) {
                iZzy += zzaov.zzs(8, this.biN);
            }
            if (this.biL != null) {
                iZzy += zzaov.zzc(9, this.biL);
            }
            if (this.aTD) {
                iZzy += zzaov.zzk(10, this.aTD);
            }
            if (this.biI != 0) {
                iZzy += zzaov.zzag(11, this.biI);
            }
            if (this.zzahl != 0) {
                iZzy += zzaov.zzag(12, this.zzahl);
            }
            if (!this.biO.equals("")) {
                iZzy += zzaov.zzs(13, this.biO);
            }
            if (!this.biQ.equals("")) {
                iZzy += zzaov.zzs(14, this.biQ);
            }
            if (this.biR != 180000) {
                iZzy += zzaov.zzg(15, this.biR);
            }
            if (this.biS != null) {
                iZzy += zzaov.zzc(16, this.biS);
            }
            if (this.biG != 0) {
                iZzy += zzaov.zze(17, this.biG);
            }
            if (!Arrays.equals(this.biT, zzapf.bit)) {
                iZzy += zzaov.zzb(18, this.biT);
            }
            if (this.biV != 0) {
                iZzy += zzaov.zzag(19, this.biV);
            }
            if (this.biW != null && this.biW.length > 0) {
                int iZzaeo = 0;
                for (int i2 = 0; i2 < this.biW.length; i2++) {
                    iZzaeo += zzaov.zzaeo(this.biW[i2]);
                }
                iZzy = iZzy + iZzaeo + (this.biW.length * 2);
            }
            if (this.biH != 0) {
                iZzy += zzaov.zze(21, this.biH);
            }
            if (this.biX != 0) {
                iZzy += zzaov.zze(22, this.biX);
            }
            if (this.biY != null) {
                iZzy += zzaov.zzc(23, this.biY);
            }
            return !this.biU.equals("") ? iZzy + zzaov.zzs(24, this.biU) : iZzy;
        }
    }

    public static final class zze extends zzaow<zze> implements Cloneable {
        private static volatile zze[] biZ;
        public String value;
        public String zzcb;

        public zze() {
            m91ay();
        }

        /* JADX INFO: renamed from: ax */
        public static zze[] m90ax() {
            if (biZ == null) {
                synchronized (zzapa.bij) {
                    if (biZ == null) {
                        biZ = new zze[0];
                    }
                }
            }
            return biZ;
        }

        @Override // com.google.android.gms.internal.zzaow
        /* JADX INFO: renamed from: ac */
        public /* synthetic */ zzaow clone() throws CloneNotSupportedException {
            return (zze) clone();
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: ad */
        public /* synthetic */ zzapc clone() throws CloneNotSupportedException {
            return (zze) clone();
        }

        /* JADX INFO: renamed from: ay */
        public zze m91ay() {
            this.zzcb = "";
            this.value = "";
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: az, reason: merged with bridge method [inline-methods] */
        public zze clone() {
            try {
                return (zze) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) obj;
            if (this.zzcb == null) {
                if (zzeVar.zzcb != null) {
                    return false;
                }
            } else if (!this.zzcb.equals(zzeVar.zzcb)) {
                return false;
            }
            if (this.value == null) {
                if (zzeVar.value != null) {
                    return false;
                }
            } else if (!this.value.equals(zzeVar.value)) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzeVar.bib == null || zzeVar.bib.isEmpty();
            }
            return this.bib.equals(zzeVar.bib);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.value == null ? 0 : this.value.hashCode()) + (((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                iHashCode = this.bib.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (!this.zzcb.equals("")) {
                zzaovVar.zzr(1, this.zzcb);
            }
            if (!this.value.equals("")) {
                zzaovVar.zzr(2, this.value);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzck, reason: merged with bridge method [inline-methods] */
        public zze zzb(zzaou zzaouVar) throws IOException {
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
                        if (!super.zza(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (!this.zzcb.equals("")) {
                iZzy += zzaov.zzs(1, this.zzcb);
            }
            return !this.value.equals("") ? iZzy + zzaov.zzs(2, this.value) : iZzy;
        }
    }

    public static final class zzf extends zzaow<zzf> implements Cloneable {
        public int bja;

        public zzf() {
            m93aA();
        }

        /* JADX INFO: renamed from: aA */
        public zzf m93aA() {
            this.bja = -1;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: aB, reason: merged with bridge method [inline-methods] */
        public zzf clone() {
            try {
                return (zzf) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.android.gms.internal.zzaow
        /* JADX INFO: renamed from: ac */
        public /* synthetic */ zzaow clone() throws CloneNotSupportedException {
            return (zzf) clone();
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: ad */
        public /* synthetic */ zzapc clone() throws CloneNotSupportedException {
            return (zzf) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzfVar = (zzf) obj;
            if (this.bja != zzfVar.bja) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzfVar.bib == null || zzfVar.bib.isEmpty();
            }
            return this.bib.equals(zzfVar.bib);
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.bja) * 31);
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.bja != -1) {
                zzaovVar.zzae(1, this.bja);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzcl, reason: merged with bridge method [inline-methods] */
        public zzf zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        int iM55N = zzaouVar.m55N();
                        switch (iM55N) {
                            case -1:
                            case 0:
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
                                this.bja = iM55N;
                                break;
                        }
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
            int iZzy = super.zzy();
            return this.bja != -1 ? iZzy + zzaov.zzag(1, this.bja) : iZzy;
        }
    }
}
