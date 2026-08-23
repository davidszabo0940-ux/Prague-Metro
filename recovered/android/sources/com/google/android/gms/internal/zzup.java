package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzup {

    public static final class zza extends zzapc {
        private static volatile zza[] aoF;
        public Integer anW;
        public zzf aoG;
        public zzf aoH;
        public Boolean aoI;

        public zza() {
            zzbwp();
        }

        public static zza[] zzbwo() {
            if (aoF == null) {
                synchronized (zzapa.bij) {
                    if (aoF == null) {
                        aoF = new zza[0];
                    }
                }
            }
            return aoF;
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
            if (this.aoG == null) {
                if (zzaVar.aoG != null) {
                    return false;
                }
            } else if (!this.aoG.equals(zzaVar.aoG)) {
                return false;
            }
            if (this.aoH == null) {
                if (zzaVar.aoH != null) {
                    return false;
                }
            } else if (!this.aoH.equals(zzaVar.aoH)) {
                return false;
            }
            if (this.aoI == null) {
                return zzaVar.aoI == null;
            }
            return this.aoI.equals(zzaVar.aoI);
        }

        public int hashCode() {
            return (((this.aoH == null ? 0 : this.aoH.hashCode()) + (((this.aoG == null ? 0 : this.aoG.hashCode()) + (((this.anW == null ? 0 : this.anW.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + (this.aoI != null ? this.aoI.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.anW != null) {
                zzaovVar.zzae(1, this.anW.intValue());
            }
            if (this.aoG != null) {
                zzaovVar.zza(2, this.aoG);
            }
            if (this.aoH != null) {
                zzaovVar.zza(3, this.aoH);
            }
            if (this.aoI != null) {
                zzaovVar.zzj(4, this.aoI.booleanValue());
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbm, reason: merged with bridge method [inline-methods] */
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
                        if (this.aoG == null) {
                            this.aoG = new zzf();
                        }
                        zzaouVar.zza(this.aoG);
                        break;
                    case 26:
                        if (this.aoH == null) {
                            this.aoH = new zzf();
                        }
                        zzaouVar.zza(this.aoH);
                        break;
                    case 32:
                        this.aoI = Boolean.valueOf(zzaouVar.m57P());
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zza zzbwp() {
            this.anW = null;
            this.aoG = null;
            this.aoH = null;
            this.aoI = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.anW != null) {
                iZzy += zzaov.zzag(1, this.anW.intValue());
            }
            if (this.aoG != null) {
                iZzy += zzaov.zzc(2, this.aoG);
            }
            if (this.aoH != null) {
                iZzy += zzaov.zzc(3, this.aoH);
            }
            return this.aoI != null ? iZzy + zzaov.zzk(4, this.aoI.booleanValue()) : iZzy;
        }
    }

    public static final class zzb extends zzapc {
        private static volatile zzb[] aoJ;
        public zzc[] aoK;
        public Long aoL;
        public Long aoM;
        public Integer count;
        public String name;

        public zzb() {
            zzbwr();
        }

        public static zzb[] zzbwq() {
            if (aoJ == null) {
                synchronized (zzapa.bij) {
                    if (aoJ == null) {
                        aoJ = new zzb[0];
                    }
                }
            }
            return aoJ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (!zzapa.equals(this.aoK, zzbVar.aoK)) {
                return false;
            }
            if (this.name == null) {
                if (zzbVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzbVar.name)) {
                return false;
            }
            if (this.aoL == null) {
                if (zzbVar.aoL != null) {
                    return false;
                }
            } else if (!this.aoL.equals(zzbVar.aoL)) {
                return false;
            }
            if (this.aoM == null) {
                if (zzbVar.aoM != null) {
                    return false;
                }
            } else if (!this.aoM.equals(zzbVar.aoM)) {
                return false;
            }
            if (this.count == null) {
                return zzbVar.count == null;
            }
            return this.count.equals(zzbVar.count);
        }

        public int hashCode() {
            return (((this.aoM == null ? 0 : this.aoM.hashCode()) + (((this.aoL == null ? 0 : this.aoL.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.aoK)) * 31)) * 31)) * 31)) * 31) + (this.count != null ? this.count.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.aoK != null && this.aoK.length > 0) {
                for (int i = 0; i < this.aoK.length; i++) {
                    zzc zzcVar = this.aoK[i];
                    if (zzcVar != null) {
                        zzaovVar.zza(1, zzcVar);
                    }
                }
            }
            if (this.name != null) {
                zzaovVar.zzr(2, this.name);
            }
            if (this.aoL != null) {
                zzaovVar.zzb(3, this.aoL.longValue());
            }
            if (this.aoM != null) {
                zzaovVar.zzb(4, this.aoM.longValue());
            }
            if (this.count != null) {
                zzaovVar.zzae(5, this.count.intValue());
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbn, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzapf.zzc(zzaouVar, 10);
                        int length = this.aoK == null ? 0 : this.aoK.length;
                        zzc[] zzcVarArr = new zzc[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.aoK, 0, zzcVarArr, 0, length);
                        }
                        while (length < zzcVarArr.length - 1) {
                            zzcVarArr[length] = new zzc();
                            zzaouVar.zza(zzcVarArr[length]);
                            zzaouVar.m51J();
                            length++;
                        }
                        zzcVarArr[length] = new zzc();
                        zzaouVar.zza(zzcVarArr[length]);
                        this.aoK = zzcVarArr;
                        break;
                    case 18:
                        this.name = zzaouVar.readString();
                        break;
                    case 24:
                        this.aoL = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 32:
                        this.aoM = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 40:
                        this.count = Integer.valueOf(zzaouVar.m55N());
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzb zzbwr() {
            this.aoK = zzc.zzbws();
            this.name = null;
            this.aoL = null;
            this.aoM = null;
            this.count = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.aoK != null && this.aoK.length > 0) {
                for (int i = 0; i < this.aoK.length; i++) {
                    zzc zzcVar = this.aoK[i];
                    if (zzcVar != null) {
                        iZzy += zzaov.zzc(1, zzcVar);
                    }
                }
            }
            if (this.name != null) {
                iZzy += zzaov.zzs(2, this.name);
            }
            if (this.aoL != null) {
                iZzy += zzaov.zze(3, this.aoL.longValue());
            }
            if (this.aoM != null) {
                iZzy += zzaov.zze(4, this.aoM.longValue());
            }
            return this.count != null ? iZzy + zzaov.zzag(5, this.count.intValue()) : iZzy;
        }
    }

    public static final class zzc extends zzapc {
        private static volatile zzc[] aoN;
        public Float anS;
        public Double anT;
        public Long aoO;
        public String name;

        /* JADX INFO: renamed from: zr */
        public String f853zr;

        public zzc() {
            zzbwt();
        }

        public static zzc[] zzbws() {
            if (aoN == null) {
                synchronized (zzapa.bij) {
                    if (aoN == null) {
                        aoN = new zzc[0];
                    }
                }
            }
            return aoN;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            if (this.name == null) {
                if (zzcVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzcVar.name)) {
                return false;
            }
            if (this.f853zr == null) {
                if (zzcVar.f853zr != null) {
                    return false;
                }
            } else if (!this.f853zr.equals(zzcVar.f853zr)) {
                return false;
            }
            if (this.aoO == null) {
                if (zzcVar.aoO != null) {
                    return false;
                }
            } else if (!this.aoO.equals(zzcVar.aoO)) {
                return false;
            }
            if (this.anS == null) {
                if (zzcVar.anS != null) {
                    return false;
                }
            } else if (!this.anS.equals(zzcVar.anS)) {
                return false;
            }
            if (this.anT == null) {
                return zzcVar.anT == null;
            }
            return this.anT.equals(zzcVar.anT);
        }

        public int hashCode() {
            return (((this.anS == null ? 0 : this.anS.hashCode()) + (((this.aoO == null ? 0 : this.aoO.hashCode()) + (((this.f853zr == null ? 0 : this.f853zr.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31) + (this.anT != null ? this.anT.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.name != null) {
                zzaovVar.zzr(1, this.name);
            }
            if (this.f853zr != null) {
                zzaovVar.zzr(2, this.f853zr);
            }
            if (this.aoO != null) {
                zzaovVar.zzb(3, this.aoO.longValue());
            }
            if (this.anS != null) {
                zzaovVar.zzc(4, this.anS.floatValue());
            }
            if (this.anT != null) {
                zzaovVar.zza(5, this.anT.doubleValue());
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbo, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzaouVar.readString();
                        break;
                    case 18:
                        this.f853zr = zzaouVar.readString();
                        break;
                    case 24:
                        this.aoO = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 37:
                        this.anS = Float.valueOf(zzaouVar.readFloat());
                        break;
                    case 41:
                        this.anT = Double.valueOf(zzaouVar.readDouble());
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzc zzbwt() {
            this.name = null;
            this.f853zr = null;
            this.aoO = null;
            this.anS = null;
            this.anT = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.name != null) {
                iZzy += zzaov.zzs(1, this.name);
            }
            if (this.f853zr != null) {
                iZzy += zzaov.zzs(2, this.f853zr);
            }
            if (this.aoO != null) {
                iZzy += zzaov.zze(3, this.aoO.longValue());
            }
            if (this.anS != null) {
                iZzy += zzaov.zzd(4, this.anS.floatValue());
            }
            return this.anT != null ? iZzy + zzaov.zzb(5, this.anT.doubleValue()) : iZzy;
        }
    }

    public static final class zzd extends zzapc {
        public zze[] aoP;

        public zzd() {
            zzbwu();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof zzd) && zzapa.equals(this.aoP, ((zzd) obj).aoP);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.aoP);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.aoP != null && this.aoP.length > 0) {
                for (int i = 0; i < this.aoP.length; i++) {
                    zze zzeVar = this.aoP[i];
                    if (zzeVar != null) {
                        zzaovVar.zza(1, zzeVar);
                    }
                }
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbp, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzapf.zzc(zzaouVar, 10);
                        int length = this.aoP == null ? 0 : this.aoP.length;
                        zze[] zzeVarArr = new zze[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.aoP, 0, zzeVarArr, 0, length);
                        }
                        while (length < zzeVarArr.length - 1) {
                            zzeVarArr[length] = new zze();
                            zzaouVar.zza(zzeVarArr[length]);
                            zzaouVar.m51J();
                            length++;
                        }
                        zzeVarArr[length] = new zze();
                        zzaouVar.zza(zzeVarArr[length]);
                        this.aoP = zzeVarArr;
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzd zzbwu() {
            this.aoP = zze.zzbwv();
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.aoP != null && this.aoP.length > 0) {
                for (int i = 0; i < this.aoP.length; i++) {
                    zze zzeVar = this.aoP[i];
                    if (zzeVar != null) {
                        iZzy += zzaov.zzc(1, zzeVar);
                    }
                }
            }
            return iZzy;
        }
    }

    public static final class zze extends zzapc {
        private static volatile zze[] aoQ;
        public String abU;
        public String ajA;
        public String ajD;
        public String ajH;
        public String ajz;
        public Integer aoR;
        public zzb[] aoS;
        public zzg[] aoT;
        public Long aoU;
        public Long aoV;
        public Long aoW;
        public Long aoX;
        public Long aoY;
        public String aoZ;
        public String apa;
        public String apb;
        public Integer apc;
        public Long apd;
        public Long ape;
        public String apf;
        public Boolean apg;
        public String aph;
        public Long api;
        public Integer apj;
        public Boolean apk;
        public zza[] apl;
        public Integer apm;
        public Integer apn;
        public Integer apo;
        public String app;
        public String zzck;
        public String zzct;

        public zze() {
            zzbww();
        }

        public static zze[] zzbwv() {
            if (aoQ == null) {
                synchronized (zzapa.bij) {
                    if (aoQ == null) {
                        aoQ = new zze[0];
                    }
                }
            }
            return aoQ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) obj;
            if (this.aoR == null) {
                if (zzeVar.aoR != null) {
                    return false;
                }
            } else if (!this.aoR.equals(zzeVar.aoR)) {
                return false;
            }
            if (zzapa.equals(this.aoS, zzeVar.aoS) && zzapa.equals(this.aoT, zzeVar.aoT)) {
                if (this.aoU == null) {
                    if (zzeVar.aoU != null) {
                        return false;
                    }
                } else if (!this.aoU.equals(zzeVar.aoU)) {
                    return false;
                }
                if (this.aoV == null) {
                    if (zzeVar.aoV != null) {
                        return false;
                    }
                } else if (!this.aoV.equals(zzeVar.aoV)) {
                    return false;
                }
                if (this.aoW == null) {
                    if (zzeVar.aoW != null) {
                        return false;
                    }
                } else if (!this.aoW.equals(zzeVar.aoW)) {
                    return false;
                }
                if (this.aoX == null) {
                    if (zzeVar.aoX != null) {
                        return false;
                    }
                } else if (!this.aoX.equals(zzeVar.aoX)) {
                    return false;
                }
                if (this.aoY == null) {
                    if (zzeVar.aoY != null) {
                        return false;
                    }
                } else if (!this.aoY.equals(zzeVar.aoY)) {
                    return false;
                }
                if (this.aoZ == null) {
                    if (zzeVar.aoZ != null) {
                        return false;
                    }
                } else if (!this.aoZ.equals(zzeVar.aoZ)) {
                    return false;
                }
                if (this.zzct == null) {
                    if (zzeVar.zzct != null) {
                        return false;
                    }
                } else if (!this.zzct.equals(zzeVar.zzct)) {
                    return false;
                }
                if (this.apa == null) {
                    if (zzeVar.apa != null) {
                        return false;
                    }
                } else if (!this.apa.equals(zzeVar.apa)) {
                    return false;
                }
                if (this.apb == null) {
                    if (zzeVar.apb != null) {
                        return false;
                    }
                } else if (!this.apb.equals(zzeVar.apb)) {
                    return false;
                }
                if (this.apc == null) {
                    if (zzeVar.apc != null) {
                        return false;
                    }
                } else if (!this.apc.equals(zzeVar.apc)) {
                    return false;
                }
                if (this.ajA == null) {
                    if (zzeVar.ajA != null) {
                        return false;
                    }
                } else if (!this.ajA.equals(zzeVar.ajA)) {
                    return false;
                }
                if (this.zzck == null) {
                    if (zzeVar.zzck != null) {
                        return false;
                    }
                } else if (!this.zzck.equals(zzeVar.zzck)) {
                    return false;
                }
                if (this.abU == null) {
                    if (zzeVar.abU != null) {
                        return false;
                    }
                } else if (!this.abU.equals(zzeVar.abU)) {
                    return false;
                }
                if (this.apd == null) {
                    if (zzeVar.apd != null) {
                        return false;
                    }
                } else if (!this.apd.equals(zzeVar.apd)) {
                    return false;
                }
                if (this.ape == null) {
                    if (zzeVar.ape != null) {
                        return false;
                    }
                } else if (!this.ape.equals(zzeVar.ape)) {
                    return false;
                }
                if (this.apf == null) {
                    if (zzeVar.apf != null) {
                        return false;
                    }
                } else if (!this.apf.equals(zzeVar.apf)) {
                    return false;
                }
                if (this.apg == null) {
                    if (zzeVar.apg != null) {
                        return false;
                    }
                } else if (!this.apg.equals(zzeVar.apg)) {
                    return false;
                }
                if (this.aph == null) {
                    if (zzeVar.aph != null) {
                        return false;
                    }
                } else if (!this.aph.equals(zzeVar.aph)) {
                    return false;
                }
                if (this.api == null) {
                    if (zzeVar.api != null) {
                        return false;
                    }
                } else if (!this.api.equals(zzeVar.api)) {
                    return false;
                }
                if (this.apj == null) {
                    if (zzeVar.apj != null) {
                        return false;
                    }
                } else if (!this.apj.equals(zzeVar.apj)) {
                    return false;
                }
                if (this.ajD == null) {
                    if (zzeVar.ajD != null) {
                        return false;
                    }
                } else if (!this.ajD.equals(zzeVar.ajD)) {
                    return false;
                }
                if (this.ajz == null) {
                    if (zzeVar.ajz != null) {
                        return false;
                    }
                } else if (!this.ajz.equals(zzeVar.ajz)) {
                    return false;
                }
                if (this.apk == null) {
                    if (zzeVar.apk != null) {
                        return false;
                    }
                } else if (!this.apk.equals(zzeVar.apk)) {
                    return false;
                }
                if (!zzapa.equals(this.apl, zzeVar.apl)) {
                    return false;
                }
                if (this.ajH == null) {
                    if (zzeVar.ajH != null) {
                        return false;
                    }
                } else if (!this.ajH.equals(zzeVar.ajH)) {
                    return false;
                }
                if (this.apm == null) {
                    if (zzeVar.apm != null) {
                        return false;
                    }
                } else if (!this.apm.equals(zzeVar.apm)) {
                    return false;
                }
                if (this.apn == null) {
                    if (zzeVar.apn != null) {
                        return false;
                    }
                } else if (!this.apn.equals(zzeVar.apn)) {
                    return false;
                }
                if (this.apo == null) {
                    if (zzeVar.apo != null) {
                        return false;
                    }
                } else if (!this.apo.equals(zzeVar.apo)) {
                    return false;
                }
                if (this.app == null) {
                    return zzeVar.app == null;
                }
                return this.app.equals(zzeVar.app);
            }
            return false;
        }

        public int hashCode() {
            return (((this.apo == null ? 0 : this.apo.hashCode()) + (((this.apn == null ? 0 : this.apn.hashCode()) + (((this.apm == null ? 0 : this.apm.hashCode()) + (((this.ajH == null ? 0 : this.ajH.hashCode()) + (((((this.apk == null ? 0 : this.apk.hashCode()) + (((this.ajz == null ? 0 : this.ajz.hashCode()) + (((this.ajD == null ? 0 : this.ajD.hashCode()) + (((this.apj == null ? 0 : this.apj.hashCode()) + (((this.api == null ? 0 : this.api.hashCode()) + (((this.aph == null ? 0 : this.aph.hashCode()) + (((this.apg == null ? 0 : this.apg.hashCode()) + (((this.apf == null ? 0 : this.apf.hashCode()) + (((this.ape == null ? 0 : this.ape.hashCode()) + (((this.apd == null ? 0 : this.apd.hashCode()) + (((this.abU == null ? 0 : this.abU.hashCode()) + (((this.zzck == null ? 0 : this.zzck.hashCode()) + (((this.ajA == null ? 0 : this.ajA.hashCode()) + (((this.apc == null ? 0 : this.apc.hashCode()) + (((this.apb == null ? 0 : this.apb.hashCode()) + (((this.apa == null ? 0 : this.apa.hashCode()) + (((this.zzct == null ? 0 : this.zzct.hashCode()) + (((this.aoZ == null ? 0 : this.aoZ.hashCode()) + (((this.aoY == null ? 0 : this.aoY.hashCode()) + (((this.aoX == null ? 0 : this.aoX.hashCode()) + (((this.aoW == null ? 0 : this.aoW.hashCode()) + (((this.aoV == null ? 0 : this.aoV.hashCode()) + (((this.aoU == null ? 0 : this.aoU.hashCode()) + (((((((this.aoR == null ? 0 : this.aoR.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzapa.hashCode(this.aoS)) * 31) + zzapa.hashCode(this.aoT)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + zzapa.hashCode(this.apl)) * 31)) * 31)) * 31)) * 31)) * 31) + (this.app != null ? this.app.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.aoR != null) {
                zzaovVar.zzae(1, this.aoR.intValue());
            }
            if (this.aoS != null && this.aoS.length > 0) {
                for (int i = 0; i < this.aoS.length; i++) {
                    zzb zzbVar = this.aoS[i];
                    if (zzbVar != null) {
                        zzaovVar.zza(2, zzbVar);
                    }
                }
            }
            if (this.aoT != null && this.aoT.length > 0) {
                for (int i2 = 0; i2 < this.aoT.length; i2++) {
                    zzg zzgVar = this.aoT[i2];
                    if (zzgVar != null) {
                        zzaovVar.zza(3, zzgVar);
                    }
                }
            }
            if (this.aoU != null) {
                zzaovVar.zzb(4, this.aoU.longValue());
            }
            if (this.aoV != null) {
                zzaovVar.zzb(5, this.aoV.longValue());
            }
            if (this.aoW != null) {
                zzaovVar.zzb(6, this.aoW.longValue());
            }
            if (this.aoY != null) {
                zzaovVar.zzb(7, this.aoY.longValue());
            }
            if (this.aoZ != null) {
                zzaovVar.zzr(8, this.aoZ);
            }
            if (this.zzct != null) {
                zzaovVar.zzr(9, this.zzct);
            }
            if (this.apa != null) {
                zzaovVar.zzr(10, this.apa);
            }
            if (this.apb != null) {
                zzaovVar.zzr(11, this.apb);
            }
            if (this.apc != null) {
                zzaovVar.zzae(12, this.apc.intValue());
            }
            if (this.ajA != null) {
                zzaovVar.zzr(13, this.ajA);
            }
            if (this.zzck != null) {
                zzaovVar.zzr(14, this.zzck);
            }
            if (this.abU != null) {
                zzaovVar.zzr(16, this.abU);
            }
            if (this.apd != null) {
                zzaovVar.zzb(17, this.apd.longValue());
            }
            if (this.ape != null) {
                zzaovVar.zzb(18, this.ape.longValue());
            }
            if (this.apf != null) {
                zzaovVar.zzr(19, this.apf);
            }
            if (this.apg != null) {
                zzaovVar.zzj(20, this.apg.booleanValue());
            }
            if (this.aph != null) {
                zzaovVar.zzr(21, this.aph);
            }
            if (this.api != null) {
                zzaovVar.zzb(22, this.api.longValue());
            }
            if (this.apj != null) {
                zzaovVar.zzae(23, this.apj.intValue());
            }
            if (this.ajD != null) {
                zzaovVar.zzr(24, this.ajD);
            }
            if (this.ajz != null) {
                zzaovVar.zzr(25, this.ajz);
            }
            if (this.aoX != null) {
                zzaovVar.zzb(26, this.aoX.longValue());
            }
            if (this.apk != null) {
                zzaovVar.zzj(28, this.apk.booleanValue());
            }
            if (this.apl != null && this.apl.length > 0) {
                for (int i3 = 0; i3 < this.apl.length; i3++) {
                    zza zzaVar = this.apl[i3];
                    if (zzaVar != null) {
                        zzaovVar.zza(29, zzaVar);
                    }
                }
            }
            if (this.ajH != null) {
                zzaovVar.zzr(30, this.ajH);
            }
            if (this.apm != null) {
                zzaovVar.zzae(31, this.apm.intValue());
            }
            if (this.apn != null) {
                zzaovVar.zzae(32, this.apn.intValue());
            }
            if (this.apo != null) {
                zzaovVar.zzae(33, this.apo.intValue());
            }
            if (this.app != null) {
                zzaovVar.zzr(34, this.app);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbq, reason: merged with bridge method [inline-methods] */
        public zze zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.aoR = Integer.valueOf(zzaouVar.m55N());
                        break;
                    case 18:
                        int iZzc = zzapf.zzc(zzaouVar, 18);
                        int length = this.aoS == null ? 0 : this.aoS.length;
                        zzb[] zzbVarArr = new zzb[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.aoS, 0, zzbVarArr, 0, length);
                        }
                        while (length < zzbVarArr.length - 1) {
                            zzbVarArr[length] = new zzb();
                            zzaouVar.zza(zzbVarArr[length]);
                            zzaouVar.m51J();
                            length++;
                        }
                        zzbVarArr[length] = new zzb();
                        zzaouVar.zza(zzbVarArr[length]);
                        this.aoS = zzbVarArr;
                        break;
                    case 26:
                        int iZzc2 = zzapf.zzc(zzaouVar, 26);
                        int length2 = this.aoT == null ? 0 : this.aoT.length;
                        zzg[] zzgVarArr = new zzg[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.aoT, 0, zzgVarArr, 0, length2);
                        }
                        while (length2 < zzgVarArr.length - 1) {
                            zzgVarArr[length2] = new zzg();
                            zzaouVar.zza(zzgVarArr[length2]);
                            zzaouVar.m51J();
                            length2++;
                        }
                        zzgVarArr[length2] = new zzg();
                        zzaouVar.zza(zzgVarArr[length2]);
                        this.aoT = zzgVarArr;
                        break;
                    case 32:
                        this.aoU = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 40:
                        this.aoV = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 48:
                        this.aoW = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 56:
                        this.aoY = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 66:
                        this.aoZ = zzaouVar.readString();
                        break;
                    case 74:
                        this.zzct = zzaouVar.readString();
                        break;
                    case 82:
                        this.apa = zzaouVar.readString();
                        break;
                    case 90:
                        this.apb = zzaouVar.readString();
                        break;
                    case 96:
                        this.apc = Integer.valueOf(zzaouVar.m55N());
                        break;
                    case 106:
                        this.ajA = zzaouVar.readString();
                        break;
                    case 114:
                        this.zzck = zzaouVar.readString();
                        break;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        this.abU = zzaouVar.readString();
                        break;
                    case 136:
                        this.apd = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 144:
                        this.ape = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 154:
                        this.apf = zzaouVar.readString();
                        break;
                    case 160:
                        this.apg = Boolean.valueOf(zzaouVar.m57P());
                        break;
                    case 170:
                        this.aph = zzaouVar.readString();
                        break;
                    case 176:
                        this.api = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 184:
                        this.apj = Integer.valueOf(zzaouVar.m55N());
                        break;
                    case 194:
                        this.ajD = zzaouVar.readString();
                        break;
                    case 202:
                        this.ajz = zzaouVar.readString();
                        break;
                    case 208:
                        this.aoX = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 224:
                        this.apk = Boolean.valueOf(zzaouVar.m57P());
                        break;
                    case 234:
                        int iZzc3 = zzapf.zzc(zzaouVar, 234);
                        int length3 = this.apl == null ? 0 : this.apl.length;
                        zza[] zzaVarArr = new zza[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.apl, 0, zzaVarArr, 0, length3);
                        }
                        while (length3 < zzaVarArr.length - 1) {
                            zzaVarArr[length3] = new zza();
                            zzaouVar.zza(zzaVarArr[length3]);
                            zzaouVar.m51J();
                            length3++;
                        }
                        zzaVarArr[length3] = new zza();
                        zzaouVar.zza(zzaVarArr[length3]);
                        this.apl = zzaVarArr;
                        break;
                    case 242:
                        this.ajH = zzaouVar.readString();
                        break;
                    case 248:
                        this.apm = Integer.valueOf(zzaouVar.m55N());
                        break;
                    case 256:
                        this.apn = Integer.valueOf(zzaouVar.m55N());
                        break;
                    case 264:
                        this.apo = Integer.valueOf(zzaouVar.m55N());
                        break;
                    case 274:
                        this.app = zzaouVar.readString();
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zze zzbww() {
            this.aoR = null;
            this.aoS = zzb.zzbwq();
            this.aoT = zzg.zzbwy();
            this.aoU = null;
            this.aoV = null;
            this.aoW = null;
            this.aoX = null;
            this.aoY = null;
            this.aoZ = null;
            this.zzct = null;
            this.apa = null;
            this.apb = null;
            this.apc = null;
            this.ajA = null;
            this.zzck = null;
            this.abU = null;
            this.apd = null;
            this.ape = null;
            this.apf = null;
            this.apg = null;
            this.aph = null;
            this.api = null;
            this.apj = null;
            this.ajD = null;
            this.ajz = null;
            this.apk = null;
            this.apl = zza.zzbwo();
            this.ajH = null;
            this.apm = null;
            this.apn = null;
            this.apo = null;
            this.app = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.aoR != null) {
                iZzy += zzaov.zzag(1, this.aoR.intValue());
            }
            if (this.aoS != null && this.aoS.length > 0) {
                int iZzc = iZzy;
                for (int i = 0; i < this.aoS.length; i++) {
                    zzb zzbVar = this.aoS[i];
                    if (zzbVar != null) {
                        iZzc += zzaov.zzc(2, zzbVar);
                    }
                }
                iZzy = iZzc;
            }
            if (this.aoT != null && this.aoT.length > 0) {
                int iZzc2 = iZzy;
                for (int i2 = 0; i2 < this.aoT.length; i2++) {
                    zzg zzgVar = this.aoT[i2];
                    if (zzgVar != null) {
                        iZzc2 += zzaov.zzc(3, zzgVar);
                    }
                }
                iZzy = iZzc2;
            }
            if (this.aoU != null) {
                iZzy += zzaov.zze(4, this.aoU.longValue());
            }
            if (this.aoV != null) {
                iZzy += zzaov.zze(5, this.aoV.longValue());
            }
            if (this.aoW != null) {
                iZzy += zzaov.zze(6, this.aoW.longValue());
            }
            if (this.aoY != null) {
                iZzy += zzaov.zze(7, this.aoY.longValue());
            }
            if (this.aoZ != null) {
                iZzy += zzaov.zzs(8, this.aoZ);
            }
            if (this.zzct != null) {
                iZzy += zzaov.zzs(9, this.zzct);
            }
            if (this.apa != null) {
                iZzy += zzaov.zzs(10, this.apa);
            }
            if (this.apb != null) {
                iZzy += zzaov.zzs(11, this.apb);
            }
            if (this.apc != null) {
                iZzy += zzaov.zzag(12, this.apc.intValue());
            }
            if (this.ajA != null) {
                iZzy += zzaov.zzs(13, this.ajA);
            }
            if (this.zzck != null) {
                iZzy += zzaov.zzs(14, this.zzck);
            }
            if (this.abU != null) {
                iZzy += zzaov.zzs(16, this.abU);
            }
            if (this.apd != null) {
                iZzy += zzaov.zze(17, this.apd.longValue());
            }
            if (this.ape != null) {
                iZzy += zzaov.zze(18, this.ape.longValue());
            }
            if (this.apf != null) {
                iZzy += zzaov.zzs(19, this.apf);
            }
            if (this.apg != null) {
                iZzy += zzaov.zzk(20, this.apg.booleanValue());
            }
            if (this.aph != null) {
                iZzy += zzaov.zzs(21, this.aph);
            }
            if (this.api != null) {
                iZzy += zzaov.zze(22, this.api.longValue());
            }
            if (this.apj != null) {
                iZzy += zzaov.zzag(23, this.apj.intValue());
            }
            if (this.ajD != null) {
                iZzy += zzaov.zzs(24, this.ajD);
            }
            if (this.ajz != null) {
                iZzy += zzaov.zzs(25, this.ajz);
            }
            if (this.aoX != null) {
                iZzy += zzaov.zze(26, this.aoX.longValue());
            }
            if (this.apk != null) {
                iZzy += zzaov.zzk(28, this.apk.booleanValue());
            }
            if (this.apl != null && this.apl.length > 0) {
                for (int i3 = 0; i3 < this.apl.length; i3++) {
                    zza zzaVar = this.apl[i3];
                    if (zzaVar != null) {
                        iZzy += zzaov.zzc(29, zzaVar);
                    }
                }
            }
            if (this.ajH != null) {
                iZzy += zzaov.zzs(30, this.ajH);
            }
            if (this.apm != null) {
                iZzy += zzaov.zzag(31, this.apm.intValue());
            }
            if (this.apn != null) {
                iZzy += zzaov.zzag(32, this.apn.intValue());
            }
            if (this.apo != null) {
                iZzy += zzaov.zzag(33, this.apo.intValue());
            }
            return this.app != null ? iZzy + zzaov.zzs(34, this.app) : iZzy;
        }
    }

    public static final class zzf extends zzapc {
        public long[] apq;
        public long[] apr;

        public zzf() {
            zzbwx();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzfVar = (zzf) obj;
            return zzapa.equals(this.apq, zzfVar.apq) && zzapa.equals(this.apr, zzfVar.apr);
        }

        public int hashCode() {
            return ((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.apq)) * 31) + zzapa.hashCode(this.apr);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.apq != null && this.apq.length > 0) {
                for (int i = 0; i < this.apq.length; i++) {
                    zzaovVar.zza(1, this.apq[i]);
                }
            }
            if (this.apr != null && this.apr.length > 0) {
                for (int i2 = 0; i2 < this.apr.length; i2++) {
                    zzaovVar.zza(2, this.apr[i2]);
                }
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbr, reason: merged with bridge method [inline-methods] */
        public zzf zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        int iZzc = zzapf.zzc(zzaouVar, 8);
                        int length = this.apq == null ? 0 : this.apq.length;
                        long[] jArr = new long[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.apq, 0, jArr, 0, length);
                        }
                        while (length < jArr.length - 1) {
                            jArr[length] = zzaouVar.m53L();
                            zzaouVar.m51J();
                            length++;
                        }
                        jArr[length] = zzaouVar.m53L();
                        this.apq = jArr;
                        break;
                    case 10:
                        int iZzaei = zzaouVar.zzaei(zzaouVar.m60S());
                        int position = zzaouVar.getPosition();
                        int i = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m53L();
                            i++;
                        }
                        zzaouVar.zzaek(position);
                        int length2 = this.apq == null ? 0 : this.apq.length;
                        long[] jArr2 = new long[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.apq, 0, jArr2, 0, length2);
                        }
                        while (length2 < jArr2.length) {
                            jArr2[length2] = zzaouVar.m53L();
                            length2++;
                        }
                        this.apq = jArr2;
                        zzaouVar.zzaej(iZzaei);
                        break;
                    case 16:
                        int iZzc2 = zzapf.zzc(zzaouVar, 16);
                        int length3 = this.apr == null ? 0 : this.apr.length;
                        long[] jArr3 = new long[iZzc2 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.apr, 0, jArr3, 0, length3);
                        }
                        while (length3 < jArr3.length - 1) {
                            jArr3[length3] = zzaouVar.m53L();
                            zzaouVar.m51J();
                            length3++;
                        }
                        jArr3[length3] = zzaouVar.m53L();
                        this.apr = jArr3;
                        break;
                    case 18:
                        int iZzaei2 = zzaouVar.zzaei(zzaouVar.m60S());
                        int position2 = zzaouVar.getPosition();
                        int i2 = 0;
                        while (zzaouVar.m64X() > 0) {
                            zzaouVar.m53L();
                            i2++;
                        }
                        zzaouVar.zzaek(position2);
                        int length4 = this.apr == null ? 0 : this.apr.length;
                        long[] jArr4 = new long[i2 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.apr, 0, jArr4, 0, length4);
                        }
                        while (length4 < jArr4.length) {
                            jArr4[length4] = zzaouVar.m53L();
                            length4++;
                        }
                        this.apr = jArr4;
                        zzaouVar.zzaej(iZzaei2);
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzf zzbwx() {
            this.apq = zzapf.bin;
            this.apr = zzapf.bin;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int length;
            int iZzy = super.zzy();
            if (this.apq == null || this.apq.length <= 0) {
                length = iZzy;
            } else {
                int iZzcv = 0;
                for (int i = 0; i < this.apq.length; i++) {
                    iZzcv += zzaov.zzcv(this.apq[i]);
                }
                length = iZzy + iZzcv + (this.apq.length * 1);
            }
            if (this.apr == null || this.apr.length <= 0) {
                return length;
            }
            int iZzcv2 = 0;
            for (int i2 = 0; i2 < this.apr.length; i2++) {
                iZzcv2 += zzaov.zzcv(this.apr[i2]);
            }
            return length + iZzcv2 + (this.apr.length * 1);
        }
    }

    public static final class zzg extends zzapc {
        private static volatile zzg[] aps;
        public Float anS;
        public Double anT;
        public Long aoO;
        public Long apt;
        public String name;

        /* JADX INFO: renamed from: zr */
        public String f854zr;

        public zzg() {
            zzbwz();
        }

        public static zzg[] zzbwy() {
            if (aps == null) {
                synchronized (zzapa.bij) {
                    if (aps == null) {
                        aps = new zzg[0];
                    }
                }
            }
            return aps;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzgVar = (zzg) obj;
            if (this.apt == null) {
                if (zzgVar.apt != null) {
                    return false;
                }
            } else if (!this.apt.equals(zzgVar.apt)) {
                return false;
            }
            if (this.name == null) {
                if (zzgVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzgVar.name)) {
                return false;
            }
            if (this.f854zr == null) {
                if (zzgVar.f854zr != null) {
                    return false;
                }
            } else if (!this.f854zr.equals(zzgVar.f854zr)) {
                return false;
            }
            if (this.aoO == null) {
                if (zzgVar.aoO != null) {
                    return false;
                }
            } else if (!this.aoO.equals(zzgVar.aoO)) {
                return false;
            }
            if (this.anS == null) {
                if (zzgVar.anS != null) {
                    return false;
                }
            } else if (!this.anS.equals(zzgVar.anS)) {
                return false;
            }
            if (this.anT == null) {
                return zzgVar.anT == null;
            }
            return this.anT.equals(zzgVar.anT);
        }

        public int hashCode() {
            return (((this.anS == null ? 0 : this.anS.hashCode()) + (((this.aoO == null ? 0 : this.aoO.hashCode()) + (((this.f854zr == null ? 0 : this.f854zr.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.apt == null ? 0 : this.apt.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (this.anT != null ? this.anT.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.apt != null) {
                zzaovVar.zzb(1, this.apt.longValue());
            }
            if (this.name != null) {
                zzaovVar.zzr(2, this.name);
            }
            if (this.f854zr != null) {
                zzaovVar.zzr(3, this.f854zr);
            }
            if (this.aoO != null) {
                zzaovVar.zzb(4, this.aoO.longValue());
            }
            if (this.anS != null) {
                zzaovVar.zzc(5, this.anS.floatValue());
            }
            if (this.anT != null) {
                zzaovVar.zza(6, this.anT.doubleValue());
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbs, reason: merged with bridge method [inline-methods] */
        public zzg zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.apt = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 18:
                        this.name = zzaouVar.readString();
                        break;
                    case 26:
                        this.f854zr = zzaouVar.readString();
                        break;
                    case 32:
                        this.aoO = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 45:
                        this.anS = Float.valueOf(zzaouVar.readFloat());
                        break;
                    case 49:
                        this.anT = Double.valueOf(zzaouVar.readDouble());
                        break;
                    default:
                        if (!zzapf.zzb(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzg zzbwz() {
            this.apt = null;
            this.name = null;
            this.f854zr = null;
            this.aoO = null;
            this.anS = null;
            this.anT = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.apt != null) {
                iZzy += zzaov.zze(1, this.apt.longValue());
            }
            if (this.name != null) {
                iZzy += zzaov.zzs(2, this.name);
            }
            if (this.f854zr != null) {
                iZzy += zzaov.zzs(3, this.f854zr);
            }
            if (this.aoO != null) {
                iZzy += zzaov.zze(4, this.aoO.longValue());
            }
            if (this.anS != null) {
                iZzy += zzaov.zzd(5, this.anS.floatValue());
            }
            return this.anT != null ? iZzy + zzaov.zzb(6, this.anT.doubleValue()) : iZzy;
        }
    }
}
