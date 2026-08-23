package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzae {

    public static final class zza extends zzaow<zza> {
        public zzb zzdx;
        public zze zzel;
        public String zzct = null;
        public String zzcs = null;
        public Long zzcu = null;
        public Long zzcv = null;
        public Long zzcw = null;
        public Long zzcx = null;
        public Long zzcy = null;
        public Long zzcz = null;
        public Long zzda = null;
        public Long zzdb = null;
        public Long zzdc = null;
        public Long zzdd = null;
        public String zzde = null;
        public Long zzdf = null;
        public Long zzdg = null;
        public Long zzdh = null;
        public Long zzdi = null;
        public Long zzdj = null;
        public Long zzdk = null;
        public Long zzdl = null;
        public Long zzdm = null;
        public Long zzdn = null;
        public String zzdo = null;
        public String zzdp = null;
        public Long zzdq = null;
        public Long zzdr = null;
        public Long zzds = null;
        public String zzdt = null;
        public Long zzdu = null;
        public Long zzdv = null;
        public Long zzdw = null;
        public Long zzdy = null;
        public Long zzdz = null;
        public Long zzea = null;
        public Long zzeb = null;
        public Long zzec = null;
        public Long zzed = null;
        public C0761zza[] zzee = C0761zza.zzz();
        public Long zzef = null;
        public String zzeg = null;
        public Integer zzeh = null;
        public Boolean zzei = null;
        public String zzej = null;
        public Long zzek = null;

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzae$zza$zza, reason: collision with other inner class name */
        public static final class C0761zza extends zzaow<C0761zza> {
            private static volatile C0761zza[] zzem;
            public Long zzdf = null;
            public Long zzdg = null;

            public C0761zza() {
                this.bik = -1;
            }

            public static C0761zza[] zzz() {
                if (zzem == null) {
                    synchronized (zzapa.bij) {
                        if (zzem == null) {
                            zzem = new C0761zza[0];
                        }
                    }
                }
                return zzem;
            }

            @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
            public void zza(zzaov zzaovVar) throws IOException {
                if (this.zzdf != null) {
                    zzaovVar.zzb(1, this.zzdf.longValue());
                }
                if (this.zzdg != null) {
                    zzaovVar.zzb(2, this.zzdg.longValue());
                }
                super.zza(zzaovVar);
            }

            @Override // com.google.android.gms.internal.zzapc
            /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
            public C0761zza zzb(zzaou zzaouVar) throws IOException {
                while (true) {
                    int iM51J = zzaouVar.m51J();
                    switch (iM51J) {
                        case 0:
                            break;
                        case 8:
                            this.zzdf = Long.valueOf(zzaouVar.m54M());
                            break;
                        case 16:
                            this.zzdg = Long.valueOf(zzaouVar.m54M());
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
                if (this.zzdf != null) {
                    iZzy += zzaov.zze(1, this.zzdf.longValue());
                }
                return this.zzdg != null ? iZzy + zzaov.zze(2, this.zzdg.longValue()) : iZzy;
            }
        }

        public zza() {
            this.bik = -1;
        }

        public static zza zzc(byte[] bArr) throws zzapb {
            return (zza) zzapc.zza(new zza(), bArr);
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzct != null) {
                zzaovVar.zzr(1, this.zzct);
            }
            if (this.zzcs != null) {
                zzaovVar.zzr(2, this.zzcs);
            }
            if (this.zzcu != null) {
                zzaovVar.zzb(3, this.zzcu.longValue());
            }
            if (this.zzcv != null) {
                zzaovVar.zzb(4, this.zzcv.longValue());
            }
            if (this.zzcw != null) {
                zzaovVar.zzb(5, this.zzcw.longValue());
            }
            if (this.zzcx != null) {
                zzaovVar.zzb(6, this.zzcx.longValue());
            }
            if (this.zzcy != null) {
                zzaovVar.zzb(7, this.zzcy.longValue());
            }
            if (this.zzcz != null) {
                zzaovVar.zzb(8, this.zzcz.longValue());
            }
            if (this.zzda != null) {
                zzaovVar.zzb(9, this.zzda.longValue());
            }
            if (this.zzdb != null) {
                zzaovVar.zzb(10, this.zzdb.longValue());
            }
            if (this.zzdc != null) {
                zzaovVar.zzb(11, this.zzdc.longValue());
            }
            if (this.zzdd != null) {
                zzaovVar.zzb(12, this.zzdd.longValue());
            }
            if (this.zzde != null) {
                zzaovVar.zzr(13, this.zzde);
            }
            if (this.zzdf != null) {
                zzaovVar.zzb(14, this.zzdf.longValue());
            }
            if (this.zzdg != null) {
                zzaovVar.zzb(15, this.zzdg.longValue());
            }
            if (this.zzdh != null) {
                zzaovVar.zzb(16, this.zzdh.longValue());
            }
            if (this.zzdi != null) {
                zzaovVar.zzb(17, this.zzdi.longValue());
            }
            if (this.zzdj != null) {
                zzaovVar.zzb(18, this.zzdj.longValue());
            }
            if (this.zzdk != null) {
                zzaovVar.zzb(19, this.zzdk.longValue());
            }
            if (this.zzdl != null) {
                zzaovVar.zzb(20, this.zzdl.longValue());
            }
            if (this.zzef != null) {
                zzaovVar.zzb(21, this.zzef.longValue());
            }
            if (this.zzdm != null) {
                zzaovVar.zzb(22, this.zzdm.longValue());
            }
            if (this.zzdn != null) {
                zzaovVar.zzb(23, this.zzdn.longValue());
            }
            if (this.zzeg != null) {
                zzaovVar.zzr(24, this.zzeg);
            }
            if (this.zzek != null) {
                zzaovVar.zzb(25, this.zzek.longValue());
            }
            if (this.zzeh != null) {
                zzaovVar.zzae(26, this.zzeh.intValue());
            }
            if (this.zzdo != null) {
                zzaovVar.zzr(27, this.zzdo);
            }
            if (this.zzei != null) {
                zzaovVar.zzj(28, this.zzei.booleanValue());
            }
            if (this.zzdp != null) {
                zzaovVar.zzr(29, this.zzdp);
            }
            if (this.zzej != null) {
                zzaovVar.zzr(30, this.zzej);
            }
            if (this.zzdq != null) {
                zzaovVar.zzb(31, this.zzdq.longValue());
            }
            if (this.zzdr != null) {
                zzaovVar.zzb(32, this.zzdr.longValue());
            }
            if (this.zzds != null) {
                zzaovVar.zzb(33, this.zzds.longValue());
            }
            if (this.zzdt != null) {
                zzaovVar.zzr(34, this.zzdt);
            }
            if (this.zzdu != null) {
                zzaovVar.zzb(35, this.zzdu.longValue());
            }
            if (this.zzdv != null) {
                zzaovVar.zzb(36, this.zzdv.longValue());
            }
            if (this.zzdw != null) {
                zzaovVar.zzb(37, this.zzdw.longValue());
            }
            if (this.zzdx != null) {
                zzaovVar.zza(38, this.zzdx);
            }
            if (this.zzdy != null) {
                zzaovVar.zzb(39, this.zzdy.longValue());
            }
            if (this.zzdz != null) {
                zzaovVar.zzb(40, this.zzdz.longValue());
            }
            if (this.zzea != null) {
                zzaovVar.zzb(41, this.zzea.longValue());
            }
            if (this.zzeb != null) {
                zzaovVar.zzb(42, this.zzeb.longValue());
            }
            if (this.zzee != null && this.zzee.length > 0) {
                for (int i = 0; i < this.zzee.length; i++) {
                    C0761zza c0761zza = this.zzee[i];
                    if (c0761zza != null) {
                        zzaovVar.zza(43, c0761zza);
                    }
                }
            }
            if (this.zzec != null) {
                zzaovVar.zzb(44, this.zzec.longValue());
            }
            if (this.zzed != null) {
                zzaovVar.zzb(45, this.zzed.longValue());
            }
            if (this.zzel != null) {
                zzaovVar.zza(201, this.zzel);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        this.zzct = zzaouVar.readString();
                        break;
                    case 18:
                        this.zzcs = zzaouVar.readString();
                        break;
                    case 24:
                        this.zzcu = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 32:
                        this.zzcv = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 40:
                        this.zzcw = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 48:
                        this.zzcx = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 56:
                        this.zzcy = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 64:
                        this.zzcz = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 72:
                        this.zzda = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 80:
                        this.zzdb = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 88:
                        this.zzdc = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 96:
                        this.zzdd = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 106:
                        this.zzde = zzaouVar.readString();
                        break;
                    case 112:
                        this.zzdf = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 120:
                        this.zzdg = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 128:
                        this.zzdh = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 136:
                        this.zzdi = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 144:
                        this.zzdj = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 152:
                        this.zzdk = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 160:
                        this.zzdl = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 168:
                        this.zzef = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 176:
                        this.zzdm = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 184:
                        this.zzdn = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 194:
                        this.zzeg = zzaouVar.readString();
                        break;
                    case 200:
                        this.zzek = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 208:
                        int iM55N = zzaouVar.m55N();
                        switch (iM55N) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.zzeh = Integer.valueOf(iM55N);
                                break;
                        }
                        break;
                    case 218:
                        this.zzdo = zzaouVar.readString();
                        break;
                    case 224:
                        this.zzei = Boolean.valueOf(zzaouVar.m57P());
                        break;
                    case 234:
                        this.zzdp = zzaouVar.readString();
                        break;
                    case 242:
                        this.zzej = zzaouVar.readString();
                        break;
                    case 248:
                        this.zzdq = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 256:
                        this.zzdr = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 264:
                        this.zzds = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 274:
                        this.zzdt = zzaouVar.readString();
                        break;
                    case 280:
                        this.zzdu = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 288:
                        this.zzdv = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 296:
                        this.zzdw = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 306:
                        if (this.zzdx == null) {
                            this.zzdx = new zzb();
                        }
                        zzaouVar.zza(this.zzdx);
                        break;
                    case 312:
                        this.zzdy = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 320:
                        this.zzdz = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 328:
                        this.zzea = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 336:
                        this.zzeb = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 346:
                        int iZzc = zzapf.zzc(zzaouVar, 346);
                        int length = this.zzee == null ? 0 : this.zzee.length;
                        C0761zza[] c0761zzaArr = new C0761zza[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzee, 0, c0761zzaArr, 0, length);
                        }
                        while (length < c0761zzaArr.length - 1) {
                            c0761zzaArr[length] = new C0761zza();
                            zzaouVar.zza(c0761zzaArr[length]);
                            zzaouVar.m51J();
                            length++;
                        }
                        c0761zzaArr[length] = new C0761zza();
                        zzaouVar.zza(c0761zzaArr[length]);
                        this.zzee = c0761zzaArr;
                        break;
                    case 352:
                        this.zzec = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 360:
                        this.zzed = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 1610:
                        if (this.zzel == null) {
                            this.zzel = new zze();
                        }
                        zzaouVar.zza(this.zzel);
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
            if (this.zzct != null) {
                iZzy += zzaov.zzs(1, this.zzct);
            }
            if (this.zzcs != null) {
                iZzy += zzaov.zzs(2, this.zzcs);
            }
            if (this.zzcu != null) {
                iZzy += zzaov.zze(3, this.zzcu.longValue());
            }
            if (this.zzcv != null) {
                iZzy += zzaov.zze(4, this.zzcv.longValue());
            }
            if (this.zzcw != null) {
                iZzy += zzaov.zze(5, this.zzcw.longValue());
            }
            if (this.zzcx != null) {
                iZzy += zzaov.zze(6, this.zzcx.longValue());
            }
            if (this.zzcy != null) {
                iZzy += zzaov.zze(7, this.zzcy.longValue());
            }
            if (this.zzcz != null) {
                iZzy += zzaov.zze(8, this.zzcz.longValue());
            }
            if (this.zzda != null) {
                iZzy += zzaov.zze(9, this.zzda.longValue());
            }
            if (this.zzdb != null) {
                iZzy += zzaov.zze(10, this.zzdb.longValue());
            }
            if (this.zzdc != null) {
                iZzy += zzaov.zze(11, this.zzdc.longValue());
            }
            if (this.zzdd != null) {
                iZzy += zzaov.zze(12, this.zzdd.longValue());
            }
            if (this.zzde != null) {
                iZzy += zzaov.zzs(13, this.zzde);
            }
            if (this.zzdf != null) {
                iZzy += zzaov.zze(14, this.zzdf.longValue());
            }
            if (this.zzdg != null) {
                iZzy += zzaov.zze(15, this.zzdg.longValue());
            }
            if (this.zzdh != null) {
                iZzy += zzaov.zze(16, this.zzdh.longValue());
            }
            if (this.zzdi != null) {
                iZzy += zzaov.zze(17, this.zzdi.longValue());
            }
            if (this.zzdj != null) {
                iZzy += zzaov.zze(18, this.zzdj.longValue());
            }
            if (this.zzdk != null) {
                iZzy += zzaov.zze(19, this.zzdk.longValue());
            }
            if (this.zzdl != null) {
                iZzy += zzaov.zze(20, this.zzdl.longValue());
            }
            if (this.zzef != null) {
                iZzy += zzaov.zze(21, this.zzef.longValue());
            }
            if (this.zzdm != null) {
                iZzy += zzaov.zze(22, this.zzdm.longValue());
            }
            if (this.zzdn != null) {
                iZzy += zzaov.zze(23, this.zzdn.longValue());
            }
            if (this.zzeg != null) {
                iZzy += zzaov.zzs(24, this.zzeg);
            }
            if (this.zzek != null) {
                iZzy += zzaov.zze(25, this.zzek.longValue());
            }
            if (this.zzeh != null) {
                iZzy += zzaov.zzag(26, this.zzeh.intValue());
            }
            if (this.zzdo != null) {
                iZzy += zzaov.zzs(27, this.zzdo);
            }
            if (this.zzei != null) {
                iZzy += zzaov.zzk(28, this.zzei.booleanValue());
            }
            if (this.zzdp != null) {
                iZzy += zzaov.zzs(29, this.zzdp);
            }
            if (this.zzej != null) {
                iZzy += zzaov.zzs(30, this.zzej);
            }
            if (this.zzdq != null) {
                iZzy += zzaov.zze(31, this.zzdq.longValue());
            }
            if (this.zzdr != null) {
                iZzy += zzaov.zze(32, this.zzdr.longValue());
            }
            if (this.zzds != null) {
                iZzy += zzaov.zze(33, this.zzds.longValue());
            }
            if (this.zzdt != null) {
                iZzy += zzaov.zzs(34, this.zzdt);
            }
            if (this.zzdu != null) {
                iZzy += zzaov.zze(35, this.zzdu.longValue());
            }
            if (this.zzdv != null) {
                iZzy += zzaov.zze(36, this.zzdv.longValue());
            }
            if (this.zzdw != null) {
                iZzy += zzaov.zze(37, this.zzdw.longValue());
            }
            if (this.zzdx != null) {
                iZzy += zzaov.zzc(38, this.zzdx);
            }
            if (this.zzdy != null) {
                iZzy += zzaov.zze(39, this.zzdy.longValue());
            }
            if (this.zzdz != null) {
                iZzy += zzaov.zze(40, this.zzdz.longValue());
            }
            if (this.zzea != null) {
                iZzy += zzaov.zze(41, this.zzea.longValue());
            }
            if (this.zzeb != null) {
                iZzy += zzaov.zze(42, this.zzeb.longValue());
            }
            if (this.zzee != null && this.zzee.length > 0) {
                int iZzc = iZzy;
                for (int i = 0; i < this.zzee.length; i++) {
                    C0761zza c0761zza = this.zzee[i];
                    if (c0761zza != null) {
                        iZzc += zzaov.zzc(43, c0761zza);
                    }
                }
                iZzy = iZzc;
            }
            if (this.zzec != null) {
                iZzy += zzaov.zze(44, this.zzec.longValue());
            }
            if (this.zzed != null) {
                iZzy += zzaov.zze(45, this.zzed.longValue());
            }
            return this.zzel != null ? iZzy + zzaov.zzc(201, this.zzel) : iZzy;
        }
    }

    public static final class zzb extends zzaow<zzb> {
        public Long zzen = null;
        public Integer zzeo = null;
        public Boolean zzep = null;
        public int[] zzeq = zzapf.bim;

        public zzb() {
            this.bik = -1;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzen != null) {
                zzaovVar.zzb(1, this.zzen.longValue());
            }
            if (this.zzeo != null) {
                zzaovVar.zzae(2, this.zzeo.intValue());
            }
            if (this.zzep != null) {
                zzaovVar.zzj(3, this.zzep.booleanValue());
            }
            if (this.zzeq != null && this.zzeq.length > 0) {
                for (int i = 0; i < this.zzeq.length; i++) {
                    zzaovVar.zzae(4, this.zzeq[i]);
                }
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.zzen = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 16:
                        this.zzeo = Integer.valueOf(zzaouVar.m55N());
                        break;
                    case 24:
                        this.zzep = Boolean.valueOf(zzaouVar.m57P());
                        break;
                    case 32:
                        int iZzc = zzapf.zzc(zzaouVar, 32);
                        int length = this.zzeq == null ? 0 : this.zzeq.length;
                        int[] iArr = new int[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzeq, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzaouVar.m55N();
                            zzaouVar.m51J();
                            length++;
                        }
                        iArr[length] = zzaouVar.m55N();
                        this.zzeq = iArr;
                        break;
                    case 34:
                        int iZzaei = zzaouVar.zzaei(zzaouVar.m60S());
                        int position = zzaouVar.getPosition();
                        int i = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m55N();
                            i++;
                        }
                        zzaouVar.zzaek(position);
                        int length2 = this.zzeq == null ? 0 : this.zzeq.length;
                        int[] iArr2 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzeq, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzaouVar.m55N();
                            length2++;
                        }
                        this.zzeq = iArr2;
                        zzaouVar.zzaej(iZzaei);
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
            if (this.zzen != null) {
                iZzy += zzaov.zze(1, this.zzen.longValue());
            }
            if (this.zzeo != null) {
                iZzy += zzaov.zzag(2, this.zzeo.intValue());
            }
            if (this.zzep != null) {
                iZzy += zzaov.zzk(3, this.zzep.booleanValue());
            }
            if (this.zzeq == null || this.zzeq.length <= 0) {
                return iZzy;
            }
            int iZzaeo = 0;
            for (int i = 0; i < this.zzeq.length; i++) {
                iZzaeo += zzaov.zzaeo(this.zzeq[i]);
            }
            return iZzy + iZzaeo + (this.zzeq.length * 1);
        }
    }

    public static final class zzc extends zzaow<zzc> {
        public byte[] zzer = null;
        public byte[] zzes = null;

        public zzc() {
            this.bik = -1;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzer != null) {
                zzaovVar.zza(1, this.zzer);
            }
            if (this.zzes != null) {
                zzaovVar.zza(2, this.zzes);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        this.zzer = zzaouVar.readBytes();
                        break;
                    case 18:
                        this.zzes = zzaouVar.readBytes();
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
            if (this.zzer != null) {
                iZzy += zzaov.zzb(1, this.zzer);
            }
            return this.zzes != null ? iZzy + zzaov.zzb(2, this.zzes) : iZzy;
        }
    }

    public static final class zzd extends zzaow<zzd> {
        public byte[] data = null;
        public byte[] zzet = null;
        public byte[] zzeu = null;
        public byte[] zzev = null;

        public zzd() {
            this.bik = -1;
        }

        public static zzd zzd(byte[] bArr) throws zzapb {
            return (zzd) zzapc.zza(new zzd(), bArr);
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.data != null) {
                zzaovVar.zza(1, this.data);
            }
            if (this.zzet != null) {
                zzaovVar.zza(2, this.zzet);
            }
            if (this.zzeu != null) {
                zzaovVar.zza(3, this.zzeu);
            }
            if (this.zzev != null) {
                zzaovVar.zza(4, this.zzev);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        this.data = zzaouVar.readBytes();
                        break;
                    case 18:
                        this.zzet = zzaouVar.readBytes();
                        break;
                    case 26:
                        this.zzeu = zzaouVar.readBytes();
                        break;
                    case 34:
                        this.zzev = zzaouVar.readBytes();
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
            if (this.data != null) {
                iZzy += zzaov.zzb(1, this.data);
            }
            if (this.zzet != null) {
                iZzy += zzaov.zzb(2, this.zzet);
            }
            if (this.zzeu != null) {
                iZzy += zzaov.zzb(3, this.zzeu);
            }
            return this.zzev != null ? iZzy + zzaov.zzb(4, this.zzev) : iZzy;
        }
    }

    public static final class zze extends zzaow<zze> {
        public Long zzen = null;
        public String zzew = null;
        public byte[] zzex = null;

        public zze() {
            this.bik = -1;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzen != null) {
                zzaovVar.zzb(1, this.zzen.longValue());
            }
            if (this.zzew != null) {
                zzaovVar.zzr(3, this.zzew);
            }
            if (this.zzex != null) {
                zzaovVar.zza(4, this.zzex);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
        public zze zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.zzen = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 26:
                        this.zzew = zzaouVar.readString();
                        break;
                    case 34:
                        this.zzex = zzaouVar.readBytes();
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
            if (this.zzen != null) {
                iZzy += zzaov.zze(1, this.zzen.longValue());
            }
            if (this.zzew != null) {
                iZzy += zzaov.zzs(3, this.zzew);
            }
            return this.zzex != null ? iZzy + zzaov.zzb(4, this.zzex) : iZzy;
        }
    }

    public static final class zzf extends zzaow<zzf> {
        public byte[][] zzey = zzapf.bis;
        public byte[] zzet = null;
        public Integer zzez = null;
        public Integer zzfa = null;

        public zzf() {
            this.bik = -1;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzey != null && this.zzey.length > 0) {
                for (int i = 0; i < this.zzey.length; i++) {
                    byte[] bArr = this.zzey[i];
                    if (bArr != null) {
                        zzaovVar.zza(1, bArr);
                    }
                }
            }
            if (this.zzet != null) {
                zzaovVar.zza(2, this.zzet);
            }
            if (this.zzez != null) {
                zzaovVar.zzae(3, this.zzez.intValue());
            }
            if (this.zzfa != null) {
                zzaovVar.zzae(4, this.zzfa.intValue());
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
        public zzf zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzapf.zzc(zzaouVar, 10);
                        int length = this.zzey == null ? 0 : this.zzey.length;
                        byte[][] bArr = new byte[iZzc + length][];
                        if (length != 0) {
                            System.arraycopy(this.zzey, 0, bArr, 0, length);
                        }
                        while (length < bArr.length - 1) {
                            bArr[length] = zzaouVar.readBytes();
                            zzaouVar.m51J();
                            length++;
                        }
                        bArr[length] = zzaouVar.readBytes();
                        this.zzey = bArr;
                        break;
                    case 18:
                        this.zzet = zzaouVar.readBytes();
                        break;
                    case 24:
                        int iM55N = zzaouVar.m55N();
                        switch (iM55N) {
                            case 0:
                            case 1:
                                this.zzez = Integer.valueOf(iM55N);
                                break;
                        }
                        break;
                    case 32:
                        int iM55N2 = zzaouVar.m55N();
                        switch (iM55N2) {
                            case 0:
                            case 1:
                                this.zzfa = Integer.valueOf(iM55N2);
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
            int iZzag;
            int iZzy = super.zzy();
            if (this.zzey == null || this.zzey.length <= 0) {
                iZzag = iZzy;
            } else {
                int iZzbc = 0;
                int i = 0;
                for (int i2 = 0; i2 < this.zzey.length; i2++) {
                    byte[] bArr = this.zzey[i2];
                    if (bArr != null) {
                        i++;
                        iZzbc += zzaov.zzbc(bArr);
                    }
                }
                iZzag = iZzy + iZzbc + (i * 1);
            }
            if (this.zzet != null) {
                iZzag += zzaov.zzb(2, this.zzet);
            }
            if (this.zzez != null) {
                iZzag += zzaov.zzag(3, this.zzez.intValue());
            }
            return this.zzfa != null ? iZzag + zzaov.zzag(4, this.zzfa.intValue()) : iZzag;
        }
    }
}
