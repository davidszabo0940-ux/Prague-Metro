package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzah {

    public static final class zza extends zzaow<zza> {
        public int level;
        public int zzum;
        public int zzun;

        public zza() {
            zzab();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.level != zzaVar.level || this.zzum != zzaVar.zzum || this.zzun != zzaVar.zzun) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzaVar.bib == null || zzaVar.bib.isEmpty();
            }
            return this.bib.equals(zzaVar.bib);
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zzum) * 31) + this.zzun) * 31);
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.level != 1) {
                zzaovVar.zzae(1, this.level);
            }
            if (this.zzum != 0) {
                zzaovVar.zzae(2, this.zzum);
            }
            if (this.zzun != 0) {
                zzaovVar.zzae(3, this.zzun);
            }
            super.zza(zzaovVar);
        }

        public zza zzab() {
            this.level = 1;
            this.zzum = 0;
            this.zzun = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzaou zzaouVar) throws IOException {
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
                                this.level = iM55N;
                                break;
                        }
                        break;
                    case 16:
                        this.zzum = zzaouVar.m55N();
                        break;
                    case 24:
                        this.zzun = zzaouVar.m55N();
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
            if (this.level != 1) {
                iZzy += zzaov.zzag(1, this.level);
            }
            if (this.zzum != 0) {
                iZzy += zzaov.zzag(2, this.zzum);
            }
            return this.zzun != 0 ? iZzy + zzaov.zzag(3, this.zzun) : iZzy;
        }
    }

    public static final class zzb extends zzaow<zzb> {
        private static volatile zzb[] zzuo;
        public int name;
        public int[] zzup;
        public int zzuq;
        public boolean zzur;
        public boolean zzus;

        public zzb() {
            zzad();
        }

        public static zzb[] zzac() {
            if (zzuo == null) {
                synchronized (zzapa.bij) {
                    if (zzuo == null) {
                        zzuo = new zzb[0];
                    }
                }
            }
            return zzuo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (!zzapa.equals(this.zzup, zzbVar.zzup) || this.zzuq != zzbVar.zzuq || this.name != zzbVar.name || this.zzur != zzbVar.zzur || this.zzus != zzbVar.zzus) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzbVar.bib == null || zzbVar.bib.isEmpty();
            }
            return this.bib.equals(zzbVar.bib);
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + (((((this.zzur ? 1231 : 1237) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzup)) * 31) + this.zzuq) * 31) + this.name) * 31)) * 31) + (this.zzus ? 1231 : 1237)) * 31);
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzus) {
                zzaovVar.zzj(1, this.zzus);
            }
            zzaovVar.zzae(2, this.zzuq);
            if (this.zzup != null && this.zzup.length > 0) {
                for (int i = 0; i < this.zzup.length; i++) {
                    zzaovVar.zzae(3, this.zzup[i]);
                }
            }
            if (this.name != 0) {
                zzaovVar.zzae(4, this.name);
            }
            if (this.zzur) {
                zzaovVar.zzj(6, this.zzur);
            }
            super.zza(zzaovVar);
        }

        public zzb zzad() {
            this.zzup = zzapf.bim;
            this.zzuq = 0;
            this.name = 0;
            this.zzur = false;
            this.zzus = false;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.zzus = zzaouVar.m57P();
                        break;
                    case 16:
                        this.zzuq = zzaouVar.m55N();
                        break;
                    case 24:
                        int iZzc = zzapf.zzc(zzaouVar, 24);
                        int length = this.zzup == null ? 0 : this.zzup.length;
                        int[] iArr = new int[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzup, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length++;
                        }
                        iArr[length] = zzaouVar.m55N();
                        this.zzup = iArr;
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
                        int length2 = this.zzup == null ? 0 : this.zzup.length;
                        int[] iArr2 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzup, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzaouVar.m55N();
                            length2++;
                        }
                        this.zzup = iArr2;
                        zzaouVar.zzaej(iZzaei);
                        break;
                    case 32:
                        this.name = zzaouVar.m55N();
                        break;
                    case 48:
                        this.zzur = zzaouVar.m57P();
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
            int iZzag;
            int iZzaeo = 0;
            int iZzy = super.zzy();
            if (this.zzus) {
                iZzy += zzaov.zzk(1, this.zzus);
            }
            int iZzag2 = zzaov.zzag(2, this.zzuq) + iZzy;
            if (this.zzup == null || this.zzup.length <= 0) {
                iZzag = iZzag2;
            } else {
                for (int i = 0; i < this.zzup.length; i++) {
                    iZzaeo += zzaov.zzaeo(this.zzup[i]);
                }
                iZzag = iZzag2 + iZzaeo + (this.zzup.length * 1);
            }
            if (this.name != 0) {
                iZzag += zzaov.zzag(4, this.name);
            }
            return this.zzur ? iZzag + zzaov.zzk(6, this.zzur) : iZzag;
        }
    }

    public static final class zzc extends zzaow<zzc> {
        private static volatile zzc[] zzut;
        public String zzcb;
        public long zzuu;
        public long zzuv;
        public boolean zzuw;
        public long zzux;

        public zzc() {
            zzaf();
        }

        public static zzc[] zzae() {
            if (zzut == null) {
                synchronized (zzapa.bij) {
                    if (zzut == null) {
                        zzut = new zzc[0];
                    }
                }
            }
            return zzut;
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
            if (this.zzuu != zzcVar.zzuu || this.zzuv != zzcVar.zzuv || this.zzuw != zzcVar.zzuw || this.zzux != zzcVar.zzux) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzcVar.bib == null || zzcVar.bib.isEmpty();
            }
            return this.bib.equals(zzcVar.bib);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((((this.zzuw ? 1231 : 1237) + (((((((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + ((int) (this.zzuu ^ (this.zzuu >>> 32)))) * 31) + ((int) (this.zzuv ^ (this.zzuv >>> 32)))) * 31)) * 31) + ((int) (this.zzux ^ (this.zzux >>> 32)))) * 31;
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
            if (this.zzuu != 0) {
                zzaovVar.zzb(2, this.zzuu);
            }
            if (this.zzuv != 2147483647L) {
                zzaovVar.zzb(3, this.zzuv);
            }
            if (this.zzuw) {
                zzaovVar.zzj(4, this.zzuw);
            }
            if (this.zzux != 0) {
                zzaovVar.zzb(5, this.zzux);
            }
            super.zza(zzaovVar);
        }

        public zzc zzaf() {
            this.zzcb = "";
            this.zzuu = 0L;
            this.zzuv = 2147483647L;
            this.zzuw = false;
            this.zzux = 0L;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        this.zzcb = zzaouVar.readString();
                        break;
                    case 16:
                        this.zzuu = zzaouVar.m54M();
                        break;
                    case 24:
                        this.zzuv = zzaouVar.m54M();
                        break;
                    case 32:
                        this.zzuw = zzaouVar.m57P();
                        break;
                    case 40:
                        this.zzux = zzaouVar.m54M();
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
            if (this.zzuu != 0) {
                iZzy += zzaov.zze(2, this.zzuu);
            }
            if (this.zzuv != 2147483647L) {
                iZzy += zzaov.zze(3, this.zzuv);
            }
            if (this.zzuw) {
                iZzy += zzaov.zzk(4, this.zzuw);
            }
            return this.zzux != 0 ? iZzy + zzaov.zze(5, this.zzux) : iZzy;
        }
    }

    public static final class zzd extends zzaow<zzd> {
        public zzai.zza[] zzuy;
        public zzai.zza[] zzuz;
        public zzc[] zzva;

        public zzd() {
            zzag();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (!zzapa.equals(this.zzuy, zzdVar.zzuy) || !zzapa.equals(this.zzuz, zzdVar.zzuz) || !zzapa.equals(this.zzva, zzdVar.zzva)) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzdVar.bib == null || zzdVar.bib.isEmpty();
            }
            return this.bib.equals(zzdVar.bib);
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzuy)) * 31) + zzapa.hashCode(this.zzuz)) * 31) + zzapa.hashCode(this.zzva)) * 31);
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzuy != null && this.zzuy.length > 0) {
                for (int i = 0; i < this.zzuy.length; i++) {
                    zzai.zza zzaVar = this.zzuy[i];
                    if (zzaVar != null) {
                        zzaovVar.zza(1, zzaVar);
                    }
                }
            }
            if (this.zzuz != null && this.zzuz.length > 0) {
                for (int i2 = 0; i2 < this.zzuz.length; i2++) {
                    zzai.zza zzaVar2 = this.zzuz[i2];
                    if (zzaVar2 != null) {
                        zzaovVar.zza(2, zzaVar2);
                    }
                }
            }
            if (this.zzva != null && this.zzva.length > 0) {
                for (int i3 = 0; i3 < this.zzva.length; i3++) {
                    zzc zzcVar = this.zzva[i3];
                    if (zzcVar != null) {
                        zzaovVar.zza(3, zzcVar);
                    }
                }
            }
            super.zza(zzaovVar);
        }

        public zzd zzag() {
            this.zzuy = zzai.zza.zzaq();
            this.zzuz = zzai.zza.zzaq();
            this.zzva = zzc.zzae();
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzapf.zzc(zzaouVar, 10);
                        int length = this.zzuy == null ? 0 : this.zzuy.length;
                        zzai.zza[] zzaVarArr = new zzai.zza[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzuy, 0, zzaVarArr, 0, length);
                        }
                        while (length < zzaVarArr.length - 1) {
                            zzaVarArr[length] = new zzai.zza();
                            zzaouVar.zza(zzaVarArr[length]);
                            zzaouVar.m51J();
                            length++;
                        }
                        zzaVarArr[length] = new zzai.zza();
                        zzaouVar.zza(zzaVarArr[length]);
                        this.zzuy = zzaVarArr;
                        break;
                    case 18:
                        int iZzc2 = zzapf.zzc(zzaouVar, 18);
                        int length2 = this.zzuz == null ? 0 : this.zzuz.length;
                        zzai.zza[] zzaVarArr2 = new zzai.zza[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzuz, 0, zzaVarArr2, 0, length2);
                        }
                        while (length2 < zzaVarArr2.length - 1) {
                            zzaVarArr2[length2] = new zzai.zza();
                            zzaouVar.zza(zzaVarArr2[length2]);
                            zzaouVar.m51J();
                            length2++;
                        }
                        zzaVarArr2[length2] = new zzai.zza();
                        zzaouVar.zza(zzaVarArr2[length2]);
                        this.zzuz = zzaVarArr2;
                        break;
                    case 26:
                        int iZzc3 = zzapf.zzc(zzaouVar, 26);
                        int length3 = this.zzva == null ? 0 : this.zzva.length;
                        zzc[] zzcVarArr = new zzc[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzva, 0, zzcVarArr, 0, length3);
                        }
                        while (length3 < zzcVarArr.length - 1) {
                            zzcVarArr[length3] = new zzc();
                            zzaouVar.zza(zzcVarArr[length3]);
                            zzaouVar.m51J();
                            length3++;
                        }
                        zzcVarArr[length3] = new zzc();
                        zzaouVar.zza(zzcVarArr[length3]);
                        this.zzva = zzcVarArr;
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
            if (this.zzuy != null && this.zzuy.length > 0) {
                int iZzc = iZzy;
                for (int i = 0; i < this.zzuy.length; i++) {
                    zzai.zza zzaVar = this.zzuy[i];
                    if (zzaVar != null) {
                        iZzc += zzaov.zzc(1, zzaVar);
                    }
                }
                iZzy = iZzc;
            }
            if (this.zzuz != null && this.zzuz.length > 0) {
                int iZzc2 = iZzy;
                for (int i2 = 0; i2 < this.zzuz.length; i2++) {
                    zzai.zza zzaVar2 = this.zzuz[i2];
                    if (zzaVar2 != null) {
                        iZzc2 += zzaov.zzc(2, zzaVar2);
                    }
                }
                iZzy = iZzc2;
            }
            if (this.zzva != null && this.zzva.length > 0) {
                for (int i3 = 0; i3 < this.zzva.length; i3++) {
                    zzc zzcVar = this.zzva[i3];
                    if (zzcVar != null) {
                        iZzy += zzaov.zzc(3, zzcVar);
                    }
                }
            }
            return iZzy;
        }
    }

    public static final class zze extends zzaow<zze> {
        private static volatile zze[] zzvb;
        public int key;
        public int value;

        public zze() {
            zzai();
        }

        public static zze[] zzah() {
            if (zzvb == null) {
                synchronized (zzapa.bij) {
                    if (zzvb == null) {
                        zzvb = new zze[0];
                    }
                }
            }
            return zzvb;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) obj;
            if (this.key != zzeVar.key || this.value != zzeVar.value) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzeVar.bib == null || zzeVar.bib.isEmpty();
            }
            return this.bib.equals(zzeVar.bib);
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31);
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            zzaovVar.zzae(1, this.key);
            zzaovVar.zzae(2, this.value);
            super.zza(zzaovVar);
        }

        public zze zzai() {
            this.key = 0;
            this.value = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
        public zze zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.key = zzaouVar.m55N();
                        break;
                    case 16:
                        this.value = zzaouVar.m55N();
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
            return super.zzy() + zzaov.zzag(1, this.key) + zzaov.zzag(2, this.value);
        }
    }

    public static final class zzf extends zzaow<zzf> {
        public String version;
        public String[] zzvc;
        public String[] zzvd;
        public zzai.zza[] zzve;
        public zze[] zzvf;
        public zzb[] zzvg;
        public zzb[] zzvh;
        public zzb[] zzvi;
        public zzg[] zzvj;
        public String zzvk;
        public String zzvl;
        public String zzvm;
        public zza zzvn;
        public float zzvo;
        public boolean zzvp;
        public String[] zzvq;
        public int zzvr;

        public zzf() {
            zzaj();
        }

        public static zzf zze(byte[] bArr) throws zzapb {
            return (zzf) zzapc.zza(new zzf(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzfVar = (zzf) obj;
            if (!zzapa.equals(this.zzvc, zzfVar.zzvc) || !zzapa.equals(this.zzvd, zzfVar.zzvd) || !zzapa.equals(this.zzve, zzfVar.zzve) || !zzapa.equals(this.zzvf, zzfVar.zzvf) || !zzapa.equals(this.zzvg, zzfVar.zzvg) || !zzapa.equals(this.zzvh, zzfVar.zzvh) || !zzapa.equals(this.zzvi, zzfVar.zzvi) || !zzapa.equals(this.zzvj, zzfVar.zzvj)) {
                return false;
            }
            if (this.zzvk == null) {
                if (zzfVar.zzvk != null) {
                    return false;
                }
            } else if (!this.zzvk.equals(zzfVar.zzvk)) {
                return false;
            }
            if (this.zzvl == null) {
                if (zzfVar.zzvl != null) {
                    return false;
                }
            } else if (!this.zzvl.equals(zzfVar.zzvl)) {
                return false;
            }
            if (this.zzvm == null) {
                if (zzfVar.zzvm != null) {
                    return false;
                }
            } else if (!this.zzvm.equals(zzfVar.zzvm)) {
                return false;
            }
            if (this.version == null) {
                if (zzfVar.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzfVar.version)) {
                return false;
            }
            if (this.zzvn == null) {
                if (zzfVar.zzvn != null) {
                    return false;
                }
            } else if (!this.zzvn.equals(zzfVar.zzvn)) {
                return false;
            }
            if (Float.floatToIntBits(this.zzvo) != Float.floatToIntBits(zzfVar.zzvo) || this.zzvp != zzfVar.zzvp || !zzapa.equals(this.zzvq, zzfVar.zzvq) || this.zzvr != zzfVar.zzvr) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzfVar.bib == null || zzfVar.bib.isEmpty();
            }
            return this.bib.equals(zzfVar.bib);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((((((this.zzvp ? 1231 : 1237) + (((((this.zzvn == null ? 0 : this.zzvn.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zzvm == null ? 0 : this.zzvm.hashCode()) + (((this.zzvl == null ? 0 : this.zzvl.hashCode()) + (((this.zzvk == null ? 0 : this.zzvk.hashCode()) + ((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzvc)) * 31) + zzapa.hashCode(this.zzvd)) * 31) + zzapa.hashCode(this.zzve)) * 31) + zzapa.hashCode(this.zzvf)) * 31) + zzapa.hashCode(this.zzvg)) * 31) + zzapa.hashCode(this.zzvh)) * 31) + zzapa.hashCode(this.zzvi)) * 31) + zzapa.hashCode(this.zzvj)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.zzvo)) * 31)) * 31) + zzapa.hashCode(this.zzvq)) * 31) + this.zzvr) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                iHashCode = this.bib.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzvd != null && this.zzvd.length > 0) {
                for (int i = 0; i < this.zzvd.length; i++) {
                    String str = this.zzvd[i];
                    if (str != null) {
                        zzaovVar.zzr(1, str);
                    }
                }
            }
            if (this.zzve != null && this.zzve.length > 0) {
                for (int i2 = 0; i2 < this.zzve.length; i2++) {
                    zzai.zza zzaVar = this.zzve[i2];
                    if (zzaVar != null) {
                        zzaovVar.zza(2, zzaVar);
                    }
                }
            }
            if (this.zzvf != null && this.zzvf.length > 0) {
                for (int i3 = 0; i3 < this.zzvf.length; i3++) {
                    zze zzeVar = this.zzvf[i3];
                    if (zzeVar != null) {
                        zzaovVar.zza(3, zzeVar);
                    }
                }
            }
            if (this.zzvg != null && this.zzvg.length > 0) {
                for (int i4 = 0; i4 < this.zzvg.length; i4++) {
                    zzb zzbVar = this.zzvg[i4];
                    if (zzbVar != null) {
                        zzaovVar.zza(4, zzbVar);
                    }
                }
            }
            if (this.zzvh != null && this.zzvh.length > 0) {
                for (int i5 = 0; i5 < this.zzvh.length; i5++) {
                    zzb zzbVar2 = this.zzvh[i5];
                    if (zzbVar2 != null) {
                        zzaovVar.zza(5, zzbVar2);
                    }
                }
            }
            if (this.zzvi != null && this.zzvi.length > 0) {
                for (int i6 = 0; i6 < this.zzvi.length; i6++) {
                    zzb zzbVar3 = this.zzvi[i6];
                    if (zzbVar3 != null) {
                        zzaovVar.zza(6, zzbVar3);
                    }
                }
            }
            if (this.zzvj != null && this.zzvj.length > 0) {
                for (int i7 = 0; i7 < this.zzvj.length; i7++) {
                    zzg zzgVar = this.zzvj[i7];
                    if (zzgVar != null) {
                        zzaovVar.zza(7, zzgVar);
                    }
                }
            }
            if (!this.zzvk.equals("")) {
                zzaovVar.zzr(9, this.zzvk);
            }
            if (!this.zzvl.equals("")) {
                zzaovVar.zzr(10, this.zzvl);
            }
            if (!this.zzvm.equals("0")) {
                zzaovVar.zzr(12, this.zzvm);
            }
            if (!this.version.equals("")) {
                zzaovVar.zzr(13, this.version);
            }
            if (this.zzvn != null) {
                zzaovVar.zza(14, this.zzvn);
            }
            if (Float.floatToIntBits(this.zzvo) != Float.floatToIntBits(0.0f)) {
                zzaovVar.zzc(15, this.zzvo);
            }
            if (this.zzvq != null && this.zzvq.length > 0) {
                for (int i8 = 0; i8 < this.zzvq.length; i8++) {
                    String str2 = this.zzvq[i8];
                    if (str2 != null) {
                        zzaovVar.zzr(16, str2);
                    }
                }
            }
            if (this.zzvr != 0) {
                zzaovVar.zzae(17, this.zzvr);
            }
            if (this.zzvp) {
                zzaovVar.zzj(18, this.zzvp);
            }
            if (this.zzvc != null && this.zzvc.length > 0) {
                for (int i9 = 0; i9 < this.zzvc.length; i9++) {
                    String str3 = this.zzvc[i9];
                    if (str3 != null) {
                        zzaovVar.zzr(19, str3);
                    }
                }
            }
            super.zza(zzaovVar);
        }

        public zzf zzaj() {
            this.zzvc = zzapf.bir;
            this.zzvd = zzapf.bir;
            this.zzve = zzai.zza.zzaq();
            this.zzvf = zze.zzah();
            this.zzvg = zzb.zzac();
            this.zzvh = zzb.zzac();
            this.zzvi = zzb.zzac();
            this.zzvj = zzg.zzak();
            this.zzvk = "";
            this.zzvl = "";
            this.zzvm = "0";
            this.version = "";
            this.zzvn = null;
            this.zzvo = 0.0f;
            this.zzvp = false;
            this.zzvq = zzapf.bir;
            this.zzvr = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzo, reason: merged with bridge method [inline-methods] */
        public zzf zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzapf.zzc(zzaouVar, 10);
                        int length = this.zzvd == null ? 0 : this.zzvd.length;
                        String[] strArr = new String[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzvd, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzaouVar.readString();
                            zzaouVar.m51J();
                            length++;
                        }
                        strArr[length] = zzaouVar.readString();
                        this.zzvd = strArr;
                        break;
                    case 18:
                        int iZzc2 = zzapf.zzc(zzaouVar, 18);
                        int length2 = this.zzve == null ? 0 : this.zzve.length;
                        zzai.zza[] zzaVarArr = new zzai.zza[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzve, 0, zzaVarArr, 0, length2);
                        }
                        while (length2 < zzaVarArr.length - 1) {
                            zzaVarArr[length2] = new zzai.zza();
                            zzaouVar.zza(zzaVarArr[length2]);
                            zzaouVar.m51J();
                            length2++;
                        }
                        zzaVarArr[length2] = new zzai.zza();
                        zzaouVar.zza(zzaVarArr[length2]);
                        this.zzve = zzaVarArr;
                        break;
                    case 26:
                        int iZzc3 = zzapf.zzc(zzaouVar, 26);
                        int length3 = this.zzvf == null ? 0 : this.zzvf.length;
                        zze[] zzeVarArr = new zze[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzvf, 0, zzeVarArr, 0, length3);
                        }
                        while (length3 < zzeVarArr.length - 1) {
                            zzeVarArr[length3] = new zze();
                            zzaouVar.zza(zzeVarArr[length3]);
                            zzaouVar.m51J();
                            length3++;
                        }
                        zzeVarArr[length3] = new zze();
                        zzaouVar.zza(zzeVarArr[length3]);
                        this.zzvf = zzeVarArr;
                        break;
                    case 34:
                        int iZzc4 = zzapf.zzc(zzaouVar, 34);
                        int length4 = this.zzvg == null ? 0 : this.zzvg.length;
                        zzb[] zzbVarArr = new zzb[iZzc4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zzvg, 0, zzbVarArr, 0, length4);
                        }
                        while (length4 < zzbVarArr.length - 1) {
                            zzbVarArr[length4] = new zzb();
                            zzaouVar.zza(zzbVarArr[length4]);
                            zzaouVar.m51J();
                            length4++;
                        }
                        zzbVarArr[length4] = new zzb();
                        zzaouVar.zza(zzbVarArr[length4]);
                        this.zzvg = zzbVarArr;
                        break;
                    case 42:
                        int iZzc5 = zzapf.zzc(zzaouVar, 42);
                        int length5 = this.zzvh == null ? 0 : this.zzvh.length;
                        zzb[] zzbVarArr2 = new zzb[iZzc5 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zzvh, 0, zzbVarArr2, 0, length5);
                        }
                        while (length5 < zzbVarArr2.length - 1) {
                            zzbVarArr2[length5] = new zzb();
                            zzaouVar.zza(zzbVarArr2[length5]);
                            zzaouVar.m51J();
                            length5++;
                        }
                        zzbVarArr2[length5] = new zzb();
                        zzaouVar.zza(zzbVarArr2[length5]);
                        this.zzvh = zzbVarArr2;
                        break;
                    case 50:
                        int iZzc6 = zzapf.zzc(zzaouVar, 50);
                        int length6 = this.zzvi == null ? 0 : this.zzvi.length;
                        zzb[] zzbVarArr3 = new zzb[iZzc6 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzvi, 0, zzbVarArr3, 0, length6);
                        }
                        while (length6 < zzbVarArr3.length - 1) {
                            zzbVarArr3[length6] = new zzb();
                            zzaouVar.zza(zzbVarArr3[length6]);
                            zzaouVar.m51J();
                            length6++;
                        }
                        zzbVarArr3[length6] = new zzb();
                        zzaouVar.zza(zzbVarArr3[length6]);
                        this.zzvi = zzbVarArr3;
                        break;
                    case 58:
                        int iZzc7 = zzapf.zzc(zzaouVar, 58);
                        int length7 = this.zzvj == null ? 0 : this.zzvj.length;
                        zzg[] zzgVarArr = new zzg[iZzc7 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zzvj, 0, zzgVarArr, 0, length7);
                        }
                        while (length7 < zzgVarArr.length - 1) {
                            zzgVarArr[length7] = new zzg();
                            zzaouVar.zza(zzgVarArr[length7]);
                            zzaouVar.m51J();
                            length7++;
                        }
                        zzgVarArr[length7] = new zzg();
                        zzaouVar.zza(zzgVarArr[length7]);
                        this.zzvj = zzgVarArr;
                        break;
                    case 74:
                        this.zzvk = zzaouVar.readString();
                        break;
                    case 82:
                        this.zzvl = zzaouVar.readString();
                        break;
                    case 98:
                        this.zzvm = zzaouVar.readString();
                        break;
                    case 106:
                        this.version = zzaouVar.readString();
                        break;
                    case 114:
                        if (this.zzvn == null) {
                            this.zzvn = new zza();
                        }
                        zzaouVar.zza(this.zzvn);
                        break;
                    case 125:
                        this.zzvo = zzaouVar.readFloat();
                        break;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        int iZzc8 = zzapf.zzc(zzaouVar, TransportMediator.KEYCODE_MEDIA_RECORD);
                        int length8 = this.zzvq == null ? 0 : this.zzvq.length;
                        String[] strArr2 = new String[iZzc8 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zzvq, 0, strArr2, 0, length8);
                        }
                        while (length8 < strArr2.length - 1) {
                            strArr2[length8] = zzaouVar.readString();
                            zzaouVar.m51J();
                            length8++;
                        }
                        strArr2[length8] = zzaouVar.readString();
                        this.zzvq = strArr2;
                        break;
                    case 136:
                        this.zzvr = zzaouVar.m55N();
                        break;
                    case 144:
                        this.zzvp = zzaouVar.m57P();
                        break;
                    case 154:
                        int iZzc9 = zzapf.zzc(zzaouVar, 154);
                        int length9 = this.zzvc == null ? 0 : this.zzvc.length;
                        String[] strArr3 = new String[iZzc9 + length9];
                        if (length9 != 0) {
                            System.arraycopy(this.zzvc, 0, strArr3, 0, length9);
                        }
                        while (length9 < strArr3.length - 1) {
                            strArr3[length9] = zzaouVar.readString();
                            zzaouVar.m51J();
                            length9++;
                        }
                        strArr3[length9] = zzaouVar.readString();
                        this.zzvc = strArr3;
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
            int iZzk;
            int iZzy = super.zzy();
            if (this.zzvd == null || this.zzvd.length <= 0) {
                iZzk = iZzy;
            } else {
                int iZztg = 0;
                int i = 0;
                for (int i2 = 0; i2 < this.zzvd.length; i2++) {
                    String str = this.zzvd[i2];
                    if (str != null) {
                        i++;
                        iZztg += zzaov.zztg(str);
                    }
                }
                iZzk = iZzy + iZztg + (i * 1);
            }
            if (this.zzve != null && this.zzve.length > 0) {
                int iZzc = iZzk;
                for (int i3 = 0; i3 < this.zzve.length; i3++) {
                    zzai.zza zzaVar = this.zzve[i3];
                    if (zzaVar != null) {
                        iZzc += zzaov.zzc(2, zzaVar);
                    }
                }
                iZzk = iZzc;
            }
            if (this.zzvf != null && this.zzvf.length > 0) {
                int iZzc2 = iZzk;
                for (int i4 = 0; i4 < this.zzvf.length; i4++) {
                    zze zzeVar = this.zzvf[i4];
                    if (zzeVar != null) {
                        iZzc2 += zzaov.zzc(3, zzeVar);
                    }
                }
                iZzk = iZzc2;
            }
            if (this.zzvg != null && this.zzvg.length > 0) {
                int iZzc3 = iZzk;
                for (int i5 = 0; i5 < this.zzvg.length; i5++) {
                    zzb zzbVar = this.zzvg[i5];
                    if (zzbVar != null) {
                        iZzc3 += zzaov.zzc(4, zzbVar);
                    }
                }
                iZzk = iZzc3;
            }
            if (this.zzvh != null && this.zzvh.length > 0) {
                int iZzc4 = iZzk;
                for (int i6 = 0; i6 < this.zzvh.length; i6++) {
                    zzb zzbVar2 = this.zzvh[i6];
                    if (zzbVar2 != null) {
                        iZzc4 += zzaov.zzc(5, zzbVar2);
                    }
                }
                iZzk = iZzc4;
            }
            if (this.zzvi != null && this.zzvi.length > 0) {
                int iZzc5 = iZzk;
                for (int i7 = 0; i7 < this.zzvi.length; i7++) {
                    zzb zzbVar3 = this.zzvi[i7];
                    if (zzbVar3 != null) {
                        iZzc5 += zzaov.zzc(6, zzbVar3);
                    }
                }
                iZzk = iZzc5;
            }
            if (this.zzvj != null && this.zzvj.length > 0) {
                int iZzc6 = iZzk;
                for (int i8 = 0; i8 < this.zzvj.length; i8++) {
                    zzg zzgVar = this.zzvj[i8];
                    if (zzgVar != null) {
                        iZzc6 += zzaov.zzc(7, zzgVar);
                    }
                }
                iZzk = iZzc6;
            }
            if (!this.zzvk.equals("")) {
                iZzk += zzaov.zzs(9, this.zzvk);
            }
            if (!this.zzvl.equals("")) {
                iZzk += zzaov.zzs(10, this.zzvl);
            }
            if (!this.zzvm.equals("0")) {
                iZzk += zzaov.zzs(12, this.zzvm);
            }
            if (!this.version.equals("")) {
                iZzk += zzaov.zzs(13, this.version);
            }
            if (this.zzvn != null) {
                iZzk += zzaov.zzc(14, this.zzvn);
            }
            if (Float.floatToIntBits(this.zzvo) != Float.floatToIntBits(0.0f)) {
                iZzk += zzaov.zzd(15, this.zzvo);
            }
            if (this.zzvq != null && this.zzvq.length > 0) {
                int iZztg2 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < this.zzvq.length; i10++) {
                    String str2 = this.zzvq[i10];
                    if (str2 != null) {
                        i9++;
                        iZztg2 += zzaov.zztg(str2);
                    }
                }
                iZzk = iZzk + iZztg2 + (i9 * 2);
            }
            if (this.zzvr != 0) {
                iZzk += zzaov.zzag(17, this.zzvr);
            }
            if (this.zzvp) {
                iZzk += zzaov.zzk(18, this.zzvp);
            }
            if (this.zzvc == null || this.zzvc.length <= 0) {
                return iZzk;
            }
            int iZztg3 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < this.zzvc.length; i12++) {
                String str3 = this.zzvc[i12];
                if (str3 != null) {
                    i11++;
                    iZztg3 += zzaov.zztg(str3);
                }
            }
            return iZzk + iZztg3 + (i11 * 2);
        }
    }

    public static final class zzg extends zzaow<zzg> {
        private static volatile zzg[] zzvs;
        public int[] zzvt;
        public int[] zzvu;
        public int[] zzvv;
        public int[] zzvw;
        public int[] zzvx;
        public int[] zzvy;
        public int[] zzvz;
        public int[] zzwa;
        public int[] zzwb;
        public int[] zzwc;

        public zzg() {
            zzal();
        }

        public static zzg[] zzak() {
            if (zzvs == null) {
                synchronized (zzapa.bij) {
                    if (zzvs == null) {
                        zzvs = new zzg[0];
                    }
                }
            }
            return zzvs;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzgVar = (zzg) obj;
            if (!zzapa.equals(this.zzvt, zzgVar.zzvt) || !zzapa.equals(this.zzvu, zzgVar.zzvu) || !zzapa.equals(this.zzvv, zzgVar.zzvv) || !zzapa.equals(this.zzvw, zzgVar.zzvw) || !zzapa.equals(this.zzvx, zzgVar.zzvx) || !zzapa.equals(this.zzvy, zzgVar.zzvy) || !zzapa.equals(this.zzvz, zzgVar.zzvz) || !zzapa.equals(this.zzwa, zzgVar.zzwa) || !zzapa.equals(this.zzwb, zzgVar.zzwb) || !zzapa.equals(this.zzwc, zzgVar.zzwc)) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzgVar.bib == null || zzgVar.bib.isEmpty();
            }
            return this.bib.equals(zzgVar.bib);
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzvt)) * 31) + zzapa.hashCode(this.zzvu)) * 31) + zzapa.hashCode(this.zzvv)) * 31) + zzapa.hashCode(this.zzvw)) * 31) + zzapa.hashCode(this.zzvx)) * 31) + zzapa.hashCode(this.zzvy)) * 31) + zzapa.hashCode(this.zzvz)) * 31) + zzapa.hashCode(this.zzwa)) * 31) + zzapa.hashCode(this.zzwb)) * 31) + zzapa.hashCode(this.zzwc)) * 31);
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzvt != null && this.zzvt.length > 0) {
                for (int i = 0; i < this.zzvt.length; i++) {
                    zzaovVar.zzae(1, this.zzvt[i]);
                }
            }
            if (this.zzvu != null && this.zzvu.length > 0) {
                for (int i2 = 0; i2 < this.zzvu.length; i2++) {
                    zzaovVar.zzae(2, this.zzvu[i2]);
                }
            }
            if (this.zzvv != null && this.zzvv.length > 0) {
                for (int i3 = 0; i3 < this.zzvv.length; i3++) {
                    zzaovVar.zzae(3, this.zzvv[i3]);
                }
            }
            if (this.zzvw != null && this.zzvw.length > 0) {
                for (int i4 = 0; i4 < this.zzvw.length; i4++) {
                    zzaovVar.zzae(4, this.zzvw[i4]);
                }
            }
            if (this.zzvx != null && this.zzvx.length > 0) {
                for (int i5 = 0; i5 < this.zzvx.length; i5++) {
                    zzaovVar.zzae(5, this.zzvx[i5]);
                }
            }
            if (this.zzvy != null && this.zzvy.length > 0) {
                for (int i6 = 0; i6 < this.zzvy.length; i6++) {
                    zzaovVar.zzae(6, this.zzvy[i6]);
                }
            }
            if (this.zzvz != null && this.zzvz.length > 0) {
                for (int i7 = 0; i7 < this.zzvz.length; i7++) {
                    zzaovVar.zzae(7, this.zzvz[i7]);
                }
            }
            if (this.zzwa != null && this.zzwa.length > 0) {
                for (int i8 = 0; i8 < this.zzwa.length; i8++) {
                    zzaovVar.zzae(8, this.zzwa[i8]);
                }
            }
            if (this.zzwb != null && this.zzwb.length > 0) {
                for (int i9 = 0; i9 < this.zzwb.length; i9++) {
                    zzaovVar.zzae(9, this.zzwb[i9]);
                }
            }
            if (this.zzwc != null && this.zzwc.length > 0) {
                for (int i10 = 0; i10 < this.zzwc.length; i10++) {
                    zzaovVar.zzae(10, this.zzwc[i10]);
                }
            }
            super.zza(zzaovVar);
        }

        public zzg zzal() {
            this.zzvt = zzapf.bim;
            this.zzvu = zzapf.bim;
            this.zzvv = zzapf.bim;
            this.zzvw = zzapf.bim;
            this.zzvx = zzapf.bim;
            this.zzvy = zzapf.bim;
            this.zzvz = zzapf.bim;
            this.zzwa = zzapf.bim;
            this.zzwb = zzapf.bim;
            this.zzwc = zzapf.bim;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
        public zzg zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        int iZzc = zzapf.zzc(zzaouVar, 8);
                        int length = this.zzvt == null ? 0 : this.zzvt.length;
                        int[] iArr = new int[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzvt, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length++;
                        }
                        iArr[length] = zzaouVar.m55N();
                        this.zzvt = iArr;
                        break;
                    case 10:
                        int iZzaei = zzaouVar.zzaei(zzaouVar.m60S());
                        int position = zzaouVar.getPosition();
                        int i = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i++;
                        }
                        zzaouVar.zzaek(position);
                        int length2 = this.zzvt == null ? 0 : this.zzvt.length;
                        int[] iArr2 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzvt, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzaouVar.m55N();
                            length2++;
                        }
                        this.zzvt = iArr2;
                        zzaouVar.zzaej(iZzaei);
                        break;
                    case 16:
                        int iZzc2 = zzapf.zzc(zzaouVar, 16);
                        int length3 = this.zzvu == null ? 0 : this.zzvu.length;
                        int[] iArr3 = new int[iZzc2 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzvu, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length3++;
                        }
                        iArr3[length3] = zzaouVar.m55N();
                        this.zzvu = iArr3;
                        break;
                    case 18:
                        int iZzaei2 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position2 = zzaouVar.getPosition();
                        int i2 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i2++;
                        }
                        zzaouVar.zzaek(position2);
                        int length4 = this.zzvu == null ? 0 : this.zzvu.length;
                        int[] iArr4 = new int[i2 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zzvu, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzaouVar.m55N();
                            length4++;
                        }
                        this.zzvu = iArr4;
                        zzaouVar.zzaej(iZzaei2);
                        break;
                    case 24:
                        int iZzc3 = zzapf.zzc(zzaouVar, 24);
                        int length5 = this.zzvv == null ? 0 : this.zzvv.length;
                        int[] iArr5 = new int[iZzc3 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zzvv, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length5++;
                        }
                        iArr5[length5] = zzaouVar.m55N();
                        this.zzvv = iArr5;
                        break;
                    case 26:
                        int iZzaei3 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position3 = zzaouVar.getPosition();
                        int i3 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i3++;
                        }
                        zzaouVar.zzaek(position3);
                        int length6 = this.zzvv == null ? 0 : this.zzvv.length;
                        int[] iArr6 = new int[i3 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzvv, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzaouVar.m55N();
                            length6++;
                        }
                        this.zzvv = iArr6;
                        zzaouVar.zzaej(iZzaei3);
                        break;
                    case 32:
                        int iZzc4 = zzapf.zzc(zzaouVar, 32);
                        int length7 = this.zzvw == null ? 0 : this.zzvw.length;
                        int[] iArr7 = new int[iZzc4 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zzvw, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length7++;
                        }
                        iArr7[length7] = zzaouVar.m55N();
                        this.zzvw = iArr7;
                        break;
                    case 34:
                        int iZzaei4 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position4 = zzaouVar.getPosition();
                        int i4 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i4++;
                        }
                        zzaouVar.zzaek(position4);
                        int length8 = this.zzvw == null ? 0 : this.zzvw.length;
                        int[] iArr8 = new int[i4 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zzvw, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzaouVar.m55N();
                            length8++;
                        }
                        this.zzvw = iArr8;
                        zzaouVar.zzaej(iZzaei4);
                        break;
                    case 40:
                        int iZzc5 = zzapf.zzc(zzaouVar, 40);
                        int length9 = this.zzvx == null ? 0 : this.zzvx.length;
                        int[] iArr9 = new int[iZzc5 + length9];
                        if (length9 != 0) {
                            System.arraycopy(this.zzvx, 0, iArr9, 0, length9);
                        }
                        while (length9 < iArr9.length - 1) {
                            iArr9[length9] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length9++;
                        }
                        iArr9[length9] = zzaouVar.m55N();
                        this.zzvx = iArr9;
                        break;
                    case 42:
                        int iZzaei5 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position5 = zzaouVar.getPosition();
                        int i5 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i5++;
                        }
                        zzaouVar.zzaek(position5);
                        int length10 = this.zzvx == null ? 0 : this.zzvx.length;
                        int[] iArr10 = new int[i5 + length10];
                        if (length10 != 0) {
                            System.arraycopy(this.zzvx, 0, iArr10, 0, length10);
                        }
                        while (length10 < iArr10.length) {
                            iArr10[length10] = zzaouVar.m55N();
                            length10++;
                        }
                        this.zzvx = iArr10;
                        zzaouVar.zzaej(iZzaei5);
                        break;
                    case 48:
                        int iZzc6 = zzapf.zzc(zzaouVar, 48);
                        int length11 = this.zzvy == null ? 0 : this.zzvy.length;
                        int[] iArr11 = new int[iZzc6 + length11];
                        if (length11 != 0) {
                            System.arraycopy(this.zzvy, 0, iArr11, 0, length11);
                        }
                        while (length11 < iArr11.length - 1) {
                            iArr11[length11] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length11++;
                        }
                        iArr11[length11] = zzaouVar.m55N();
                        this.zzvy = iArr11;
                        break;
                    case 50:
                        int iZzaei6 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position6 = zzaouVar.getPosition();
                        int i6 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i6++;
                        }
                        zzaouVar.zzaek(position6);
                        int length12 = this.zzvy == null ? 0 : this.zzvy.length;
                        int[] iArr12 = new int[i6 + length12];
                        if (length12 != 0) {
                            System.arraycopy(this.zzvy, 0, iArr12, 0, length12);
                        }
                        while (length12 < iArr12.length) {
                            iArr12[length12] = zzaouVar.m55N();
                            length12++;
                        }
                        this.zzvy = iArr12;
                        zzaouVar.zzaej(iZzaei6);
                        break;
                    case 56:
                        int iZzc7 = zzapf.zzc(zzaouVar, 56);
                        int length13 = this.zzvz == null ? 0 : this.zzvz.length;
                        int[] iArr13 = new int[iZzc7 + length13];
                        if (length13 != 0) {
                            System.arraycopy(this.zzvz, 0, iArr13, 0, length13);
                        }
                        while (length13 < iArr13.length - 1) {
                            iArr13[length13] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length13++;
                        }
                        iArr13[length13] = zzaouVar.m55N();
                        this.zzvz = iArr13;
                        break;
                    case 58:
                        int iZzaei7 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position7 = zzaouVar.getPosition();
                        int i7 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i7++;
                        }
                        zzaouVar.zzaek(position7);
                        int length14 = this.zzvz == null ? 0 : this.zzvz.length;
                        int[] iArr14 = new int[i7 + length14];
                        if (length14 != 0) {
                            System.arraycopy(this.zzvz, 0, iArr14, 0, length14);
                        }
                        while (length14 < iArr14.length) {
                            iArr14[length14] = zzaouVar.m55N();
                            length14++;
                        }
                        this.zzvz = iArr14;
                        zzaouVar.zzaej(iZzaei7);
                        break;
                    case 64:
                        int iZzc8 = zzapf.zzc(zzaouVar, 64);
                        int length15 = this.zzwa == null ? 0 : this.zzwa.length;
                        int[] iArr15 = new int[iZzc8 + length15];
                        if (length15 != 0) {
                            System.arraycopy(this.zzwa, 0, iArr15, 0, length15);
                        }
                        while (length15 < iArr15.length - 1) {
                            iArr15[length15] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length15++;
                        }
                        iArr15[length15] = zzaouVar.m55N();
                        this.zzwa = iArr15;
                        break;
                    case 66:
                        int iZzaei8 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position8 = zzaouVar.getPosition();
                        int i8 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i8++;
                        }
                        zzaouVar.zzaek(position8);
                        int length16 = this.zzwa == null ? 0 : this.zzwa.length;
                        int[] iArr16 = new int[i8 + length16];
                        if (length16 != 0) {
                            System.arraycopy(this.zzwa, 0, iArr16, 0, length16);
                        }
                        while (length16 < iArr16.length) {
                            iArr16[length16] = zzaouVar.m55N();
                            length16++;
                        }
                        this.zzwa = iArr16;
                        zzaouVar.zzaej(iZzaei8);
                        break;
                    case 72:
                        int iZzc9 = zzapf.zzc(zzaouVar, 72);
                        int length17 = this.zzwb == null ? 0 : this.zzwb.length;
                        int[] iArr17 = new int[iZzc9 + length17];
                        if (length17 != 0) {
                            System.arraycopy(this.zzwb, 0, iArr17, 0, length17);
                        }
                        while (length17 < iArr17.length - 1) {
                            iArr17[length17] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length17++;
                        }
                        iArr17[length17] = zzaouVar.m55N();
                        this.zzwb = iArr17;
                        break;
                    case 74:
                        int iZzaei9 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position9 = zzaouVar.getPosition();
                        int i9 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i9++;
                        }
                        zzaouVar.zzaek(position9);
                        int length18 = this.zzwb == null ? 0 : this.zzwb.length;
                        int[] iArr18 = new int[i9 + length18];
                        if (length18 != 0) {
                            System.arraycopy(this.zzwb, 0, iArr18, 0, length18);
                        }
                        while (length18 < iArr18.length) {
                            iArr18[length18] = zzaouVar.m55N();
                            length18++;
                        }
                        this.zzwb = iArr18;
                        zzaouVar.zzaej(iZzaei9);
                        break;
                    case 80:
                        int iZzc10 = zzapf.zzc(zzaouVar, 80);
                        int length19 = this.zzwc == null ? 0 : this.zzwc.length;
                        int[] iArr19 = new int[iZzc10 + length19];
                        if (length19 != 0) {
                            System.arraycopy(this.zzwc, 0, iArr19, 0, length19);
                        }
                        while (length19 < iArr19.length - 1) {
                            iArr19[length19] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length19++;
                        }
                        iArr19[length19] = zzaouVar.m55N();
                        this.zzwc = iArr19;
                        break;
                    case 82:
                        int iZzaei10 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position10 = zzaouVar.getPosition();
                        int i10 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i10++;
                        }
                        zzaouVar.zzaek(position10);
                        int length20 = this.zzwc == null ? 0 : this.zzwc.length;
                        int[] iArr20 = new int[i10 + length20];
                        if (length20 != 0) {
                            System.arraycopy(this.zzwc, 0, iArr20, 0, length20);
                        }
                        while (length20 < iArr20.length) {
                            iArr20[length20] = zzaouVar.m55N();
                            length20++;
                        }
                        this.zzwc = iArr20;
                        zzaouVar.zzaej(iZzaei10);
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
            if (this.zzvt == null || this.zzvt.length <= 0) {
                length = iZzy;
            } else {
                int iZzaeo = 0;
                for (int i = 0; i < this.zzvt.length; i++) {
                    iZzaeo += zzaov.zzaeo(this.zzvt[i]);
                }
                length = iZzy + iZzaeo + (this.zzvt.length * 1);
            }
            if (this.zzvu != null && this.zzvu.length > 0) {
                int iZzaeo2 = 0;
                for (int i2 = 0; i2 < this.zzvu.length; i2++) {
                    iZzaeo2 += zzaov.zzaeo(this.zzvu[i2]);
                }
                length = length + iZzaeo2 + (this.zzvu.length * 1);
            }
            if (this.zzvv != null && this.zzvv.length > 0) {
                int iZzaeo3 = 0;
                for (int i3 = 0; i3 < this.zzvv.length; i3++) {
                    iZzaeo3 += zzaov.zzaeo(this.zzvv[i3]);
                }
                length = length + iZzaeo3 + (this.zzvv.length * 1);
            }
            if (this.zzvw != null && this.zzvw.length > 0) {
                int iZzaeo4 = 0;
                for (int i4 = 0; i4 < this.zzvw.length; i4++) {
                    iZzaeo4 += zzaov.zzaeo(this.zzvw[i4]);
                }
                length = length + iZzaeo4 + (this.zzvw.length * 1);
            }
            if (this.zzvx != null && this.zzvx.length > 0) {
                int iZzaeo5 = 0;
                for (int i5 = 0; i5 < this.zzvx.length; i5++) {
                    iZzaeo5 += zzaov.zzaeo(this.zzvx[i5]);
                }
                length = length + iZzaeo5 + (this.zzvx.length * 1);
            }
            if (this.zzvy != null && this.zzvy.length > 0) {
                int iZzaeo6 = 0;
                for (int i6 = 0; i6 < this.zzvy.length; i6++) {
                    iZzaeo6 += zzaov.zzaeo(this.zzvy[i6]);
                }
                length = length + iZzaeo6 + (this.zzvy.length * 1);
            }
            if (this.zzvz != null && this.zzvz.length > 0) {
                int iZzaeo7 = 0;
                for (int i7 = 0; i7 < this.zzvz.length; i7++) {
                    iZzaeo7 += zzaov.zzaeo(this.zzvz[i7]);
                }
                length = length + iZzaeo7 + (this.zzvz.length * 1);
            }
            if (this.zzwa != null && this.zzwa.length > 0) {
                int iZzaeo8 = 0;
                for (int i8 = 0; i8 < this.zzwa.length; i8++) {
                    iZzaeo8 += zzaov.zzaeo(this.zzwa[i8]);
                }
                length = length + iZzaeo8 + (this.zzwa.length * 1);
            }
            if (this.zzwb != null && this.zzwb.length > 0) {
                int iZzaeo9 = 0;
                for (int i9 = 0; i9 < this.zzwb.length; i9++) {
                    iZzaeo9 += zzaov.zzaeo(this.zzwb[i9]);
                }
                length = length + iZzaeo9 + (this.zzwb.length * 1);
            }
            if (this.zzwc == null || this.zzwc.length <= 0) {
                return length;
            }
            int iZzaeo10 = 0;
            for (int i10 = 0; i10 < this.zzwc.length; i10++) {
                iZzaeo10 += zzaov.zzaeo(this.zzwc[i10]);
            }
            return length + iZzaeo10 + (this.zzwc.length * 1);
        }
    }

    public static final class zzh extends zzaow<zzh> {
        public static final zzaox<zzai.zza, zzh> zzwd = zzaox.zza(11, zzh.class, 810);
        private static final zzh[] zzwe = new zzh[0];
        public int[] zzwf;
        public int[] zzwg;
        public int[] zzwh;
        public int zzwi;
        public int[] zzwj;
        public int zzwk;
        public int zzwl;

        public zzh() {
            zzam();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzh)) {
                return false;
            }
            zzh zzhVar = (zzh) obj;
            if (!zzapa.equals(this.zzwf, zzhVar.zzwf) || !zzapa.equals(this.zzwg, zzhVar.zzwg) || !zzapa.equals(this.zzwh, zzhVar.zzwh) || this.zzwi != zzhVar.zzwi || !zzapa.equals(this.zzwj, zzhVar.zzwj) || this.zzwk != zzhVar.zzwk || this.zzwl != zzhVar.zzwl) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzhVar.bib == null || zzhVar.bib.isEmpty();
            }
            return this.bib.equals(zzhVar.bib);
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzwf)) * 31) + zzapa.hashCode(this.zzwg)) * 31) + zzapa.hashCode(this.zzwh)) * 31) + this.zzwi) * 31) + zzapa.hashCode(this.zzwj)) * 31) + this.zzwk) * 31) + this.zzwl) * 31);
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzwf != null && this.zzwf.length > 0) {
                for (int i = 0; i < this.zzwf.length; i++) {
                    zzaovVar.zzae(1, this.zzwf[i]);
                }
            }
            if (this.zzwg != null && this.zzwg.length > 0) {
                for (int i2 = 0; i2 < this.zzwg.length; i2++) {
                    zzaovVar.zzae(2, this.zzwg[i2]);
                }
            }
            if (this.zzwh != null && this.zzwh.length > 0) {
                for (int i3 = 0; i3 < this.zzwh.length; i3++) {
                    zzaovVar.zzae(3, this.zzwh[i3]);
                }
            }
            if (this.zzwi != 0) {
                zzaovVar.zzae(4, this.zzwi);
            }
            if (this.zzwj != null && this.zzwj.length > 0) {
                for (int i4 = 0; i4 < this.zzwj.length; i4++) {
                    zzaovVar.zzae(5, this.zzwj[i4]);
                }
            }
            if (this.zzwk != 0) {
                zzaovVar.zzae(6, this.zzwk);
            }
            if (this.zzwl != 0) {
                zzaovVar.zzae(7, this.zzwl);
            }
            super.zza(zzaovVar);
        }

        public zzh zzam() {
            this.zzwf = zzapf.bim;
            this.zzwg = zzapf.bim;
            this.zzwh = zzapf.bim;
            this.zzwi = 0;
            this.zzwj = zzapf.bim;
            this.zzwk = 0;
            this.zzwl = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public zzh zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        int iZzc = zzapf.zzc(zzaouVar, 8);
                        int length = this.zzwf == null ? 0 : this.zzwf.length;
                        int[] iArr = new int[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzwf, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length++;
                        }
                        iArr[length] = zzaouVar.m55N();
                        this.zzwf = iArr;
                        break;
                    case 10:
                        int iZzaei = zzaouVar.zzaei(zzaouVar.m60S());
                        int position = zzaouVar.getPosition();
                        int i = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i++;
                        }
                        zzaouVar.zzaek(position);
                        int length2 = this.zzwf == null ? 0 : this.zzwf.length;
                        int[] iArr2 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzwf, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzaouVar.m55N();
                            length2++;
                        }
                        this.zzwf = iArr2;
                        zzaouVar.zzaej(iZzaei);
                        break;
                    case 16:
                        int iZzc2 = zzapf.zzc(zzaouVar, 16);
                        int length3 = this.zzwg == null ? 0 : this.zzwg.length;
                        int[] iArr3 = new int[iZzc2 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzwg, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length3++;
                        }
                        iArr3[length3] = zzaouVar.m55N();
                        this.zzwg = iArr3;
                        break;
                    case 18:
                        int iZzaei2 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position2 = zzaouVar.getPosition();
                        int i2 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i2++;
                        }
                        zzaouVar.zzaek(position2);
                        int length4 = this.zzwg == null ? 0 : this.zzwg.length;
                        int[] iArr4 = new int[i2 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zzwg, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzaouVar.m55N();
                            length4++;
                        }
                        this.zzwg = iArr4;
                        zzaouVar.zzaej(iZzaei2);
                        break;
                    case 24:
                        int iZzc3 = zzapf.zzc(zzaouVar, 24);
                        int length5 = this.zzwh == null ? 0 : this.zzwh.length;
                        int[] iArr5 = new int[iZzc3 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zzwh, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length5++;
                        }
                        iArr5[length5] = zzaouVar.m55N();
                        this.zzwh = iArr5;
                        break;
                    case 26:
                        int iZzaei3 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position3 = zzaouVar.getPosition();
                        int i3 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i3++;
                        }
                        zzaouVar.zzaek(position3);
                        int length6 = this.zzwh == null ? 0 : this.zzwh.length;
                        int[] iArr6 = new int[i3 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzwh, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzaouVar.m55N();
                            length6++;
                        }
                        this.zzwh = iArr6;
                        zzaouVar.zzaej(iZzaei3);
                        break;
                    case 32:
                        this.zzwi = zzaouVar.m55N();
                        break;
                    case 40:
                        int iZzc4 = zzapf.zzc(zzaouVar, 40);
                        int length7 = this.zzwj == null ? 0 : this.zzwj.length;
                        int[] iArr7 = new int[iZzc4 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zzwj, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length7++;
                        }
                        iArr7[length7] = zzaouVar.m55N();
                        this.zzwj = iArr7;
                        break;
                    case 42:
                        int iZzaei4 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position4 = zzaouVar.getPosition();
                        int i4 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i4++;
                        }
                        zzaouVar.zzaek(position4);
                        int length8 = this.zzwj == null ? 0 : this.zzwj.length;
                        int[] iArr8 = new int[i4 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zzwj, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzaouVar.m55N();
                            length8++;
                        }
                        this.zzwj = iArr8;
                        zzaouVar.zzaej(iZzaei4);
                        break;
                    case 48:
                        this.zzwk = zzaouVar.m55N();
                        break;
                    case 56:
                        this.zzwl = zzaouVar.m55N();
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
            int iZzag;
            int iZzy = super.zzy();
            if (this.zzwf == null || this.zzwf.length <= 0) {
                iZzag = iZzy;
            } else {
                int iZzaeo = 0;
                for (int i = 0; i < this.zzwf.length; i++) {
                    iZzaeo += zzaov.zzaeo(this.zzwf[i]);
                }
                iZzag = iZzy + iZzaeo + (this.zzwf.length * 1);
            }
            if (this.zzwg != null && this.zzwg.length > 0) {
                int iZzaeo2 = 0;
                for (int i2 = 0; i2 < this.zzwg.length; i2++) {
                    iZzaeo2 += zzaov.zzaeo(this.zzwg[i2]);
                }
                iZzag = iZzag + iZzaeo2 + (this.zzwg.length * 1);
            }
            if (this.zzwh != null && this.zzwh.length > 0) {
                int iZzaeo3 = 0;
                for (int i3 = 0; i3 < this.zzwh.length; i3++) {
                    iZzaeo3 += zzaov.zzaeo(this.zzwh[i3]);
                }
                iZzag = iZzag + iZzaeo3 + (this.zzwh.length * 1);
            }
            if (this.zzwi != 0) {
                iZzag += zzaov.zzag(4, this.zzwi);
            }
            if (this.zzwj != null && this.zzwj.length > 0) {
                int iZzaeo4 = 0;
                for (int i4 = 0; i4 < this.zzwj.length; i4++) {
                    iZzaeo4 += zzaov.zzaeo(this.zzwj[i4]);
                }
                iZzag = iZzag + iZzaeo4 + (this.zzwj.length * 1);
            }
            if (this.zzwk != 0) {
                iZzag += zzaov.zzag(6, this.zzwk);
            }
            return this.zzwl != 0 ? iZzag + zzaov.zzag(7, this.zzwl) : iZzag;
        }
    }

    public static final class zzi extends zzaow<zzi> {
        private static volatile zzi[] zzwm;
        public String name;
        public zzai.zza zzwn;
        public zzd zzwo;

        public zzi() {
            zzao();
        }

        public static zzi[] zzan() {
            if (zzwm == null) {
                synchronized (zzapa.bij) {
                    if (zzwm == null) {
                        zzwm = new zzi[0];
                    }
                }
            }
            return zzwm;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzi)) {
                return false;
            }
            zzi zziVar = (zzi) obj;
            if (this.name == null) {
                if (zziVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zziVar.name)) {
                return false;
            }
            if (this.zzwn == null) {
                if (zziVar.zzwn != null) {
                    return false;
                }
            } else if (!this.zzwn.equals(zziVar.zzwn)) {
                return false;
            }
            if (this.zzwo == null) {
                if (zziVar.zzwo != null) {
                    return false;
                }
            } else if (!this.zzwo.equals(zziVar.zzwo)) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zziVar.bib == null || zziVar.bib.isEmpty();
            }
            return this.bib.equals(zziVar.bib);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.zzwo == null ? 0 : this.zzwo.hashCode()) + (((this.zzwn == null ? 0 : this.zzwn.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                iHashCode = this.bib.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (!this.name.equals("")) {
                zzaovVar.zzr(1, this.name);
            }
            if (this.zzwn != null) {
                zzaovVar.zza(2, this.zzwn);
            }
            if (this.zzwo != null) {
                zzaovVar.zza(3, this.zzwo);
            }
            super.zza(zzaovVar);
        }

        public zzi zzao() {
            this.name = "";
            this.zzwn = null;
            this.zzwo = null;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public zzi zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzaouVar.readString();
                        break;
                    case 18:
                        if (this.zzwn == null) {
                            this.zzwn = new zzai.zza();
                        }
                        zzaouVar.zza(this.zzwn);
                        break;
                    case 26:
                        if (this.zzwo == null) {
                            this.zzwo = new zzd();
                        }
                        zzaouVar.zza(this.zzwo);
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
            if (!this.name.equals("")) {
                iZzy += zzaov.zzs(1, this.name);
            }
            if (this.zzwn != null) {
                iZzy += zzaov.zzc(2, this.zzwn);
            }
            return this.zzwo != null ? iZzy + zzaov.zzc(3, this.zzwo) : iZzy;
        }
    }

    public static final class zzj extends zzaow<zzj> {
        public zzi[] zzwp;
        public zzf zzwq;
        public String zzwr;

        public zzj() {
            zzap();
        }

        public static zzj zzf(byte[] bArr) throws zzapb {
            return (zzj) zzapc.zza(new zzj(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzj)) {
                return false;
            }
            zzj zzjVar = (zzj) obj;
            if (!zzapa.equals(this.zzwp, zzjVar.zzwp)) {
                return false;
            }
            if (this.zzwq == null) {
                if (zzjVar.zzwq != null) {
                    return false;
                }
            } else if (!this.zzwq.equals(zzjVar.zzwq)) {
                return false;
            }
            if (this.zzwr == null) {
                if (zzjVar.zzwr != null) {
                    return false;
                }
            } else if (!this.zzwr.equals(zzjVar.zzwr)) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzjVar.bib == null || zzjVar.bib.isEmpty();
            }
            return this.bib.equals(zzjVar.bib);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.zzwr == null ? 0 : this.zzwr.hashCode()) + (((this.zzwq == null ? 0 : this.zzwq.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzwp)) * 31)) * 31)) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                iHashCode = this.bib.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzwp != null && this.zzwp.length > 0) {
                for (int i = 0; i < this.zzwp.length; i++) {
                    zzi zziVar = this.zzwp[i];
                    if (zziVar != null) {
                        zzaovVar.zza(1, zziVar);
                    }
                }
            }
            if (this.zzwq != null) {
                zzaovVar.zza(2, this.zzwq);
            }
            if (!this.zzwr.equals("")) {
                zzaovVar.zzr(3, this.zzwr);
            }
            super.zza(zzaovVar);
        }

        public zzj zzap() {
            this.zzwp = zzi.zzan();
            this.zzwq = null;
            this.zzwr = "";
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public zzj zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzapf.zzc(zzaouVar, 10);
                        int length = this.zzwp == null ? 0 : this.zzwp.length;
                        zzi[] zziVarArr = new zzi[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzwp, 0, zziVarArr, 0, length);
                        }
                        while (length < zziVarArr.length - 1) {
                            zziVarArr[length] = new zzi();
                            zzaouVar.zza(zziVarArr[length]);
                            zzaouVar.m51J();
                            length++;
                        }
                        zziVarArr[length] = new zzi();
                        zzaouVar.zza(zziVarArr[length]);
                        this.zzwp = zziVarArr;
                        break;
                    case 18:
                        if (this.zzwq == null) {
                            this.zzwq = new zzf();
                        }
                        zzaouVar.zza(this.zzwq);
                        break;
                    case 26:
                        this.zzwr = zzaouVar.readString();
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
            if (this.zzwp != null && this.zzwp.length > 0) {
                for (int i = 0; i < this.zzwp.length; i++) {
                    zzi zziVar = this.zzwp[i];
                    if (zziVar != null) {
                        iZzy += zzaov.zzc(1, zziVar);
                    }
                }
            }
            if (this.zzwq != null) {
                iZzy += zzaov.zzc(2, this.zzwq);
            }
            return !this.zzwr.equals("") ? iZzy + zzaov.zzs(3, this.zzwr) : iZzy;
        }
    }
}
