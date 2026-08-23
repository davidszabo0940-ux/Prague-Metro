package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzad {

    public static final class zza extends zzaow<zza> {
        public String zzck = null;
        public Long zzcl = null;
        public String stackTrace = null;
        public String zzcm = null;
        public String zzcn = null;
        public Long zzco = null;
        public Long zzcp = null;
        public String zzcq = null;
        public Long zzcr = null;
        public String zzcs = null;

        public zza() {
            this.bik = -1;
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 10:
                        this.zzck = zzaouVar.readString();
                        break;
                    case 16:
                        this.zzcl = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 26:
                        this.stackTrace = zzaouVar.readString();
                        break;
                    case 34:
                        this.zzcm = zzaouVar.readString();
                        break;
                    case 42:
                        this.zzcn = zzaouVar.readString();
                        break;
                    case 48:
                        this.zzco = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 56:
                        this.zzcp = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 66:
                        this.zzcq = zzaouVar.readString();
                        break;
                    case 72:
                        this.zzcr = Long.valueOf(zzaouVar.m54M());
                        break;
                    case 82:
                        this.zzcs = zzaouVar.readString();
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
        public void zza(zzaov zzaovVar) throws IOException {
            if (this.zzck != null) {
                zzaovVar.zzr(1, this.zzck);
            }
            if (this.zzcl != null) {
                zzaovVar.zzb(2, this.zzcl.longValue());
            }
            if (this.stackTrace != null) {
                zzaovVar.zzr(3, this.stackTrace);
            }
            if (this.zzcm != null) {
                zzaovVar.zzr(4, this.zzcm);
            }
            if (this.zzcn != null) {
                zzaovVar.zzr(5, this.zzcn);
            }
            if (this.zzco != null) {
                zzaovVar.zzb(6, this.zzco.longValue());
            }
            if (this.zzcp != null) {
                zzaovVar.zzb(7, this.zzcp.longValue());
            }
            if (this.zzcq != null) {
                zzaovVar.zzr(8, this.zzcq);
            }
            if (this.zzcr != null) {
                zzaovVar.zzb(9, this.zzcr.longValue());
            }
            if (this.zzcs != null) {
                zzaovVar.zzr(10, this.zzcs);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy();
            if (this.zzck != null) {
                iZzy += zzaov.zzs(1, this.zzck);
            }
            if (this.zzcl != null) {
                iZzy += zzaov.zze(2, this.zzcl.longValue());
            }
            if (this.stackTrace != null) {
                iZzy += zzaov.zzs(3, this.stackTrace);
            }
            if (this.zzcm != null) {
                iZzy += zzaov.zzs(4, this.zzcm);
            }
            if (this.zzcn != null) {
                iZzy += zzaov.zzs(5, this.zzcn);
            }
            if (this.zzco != null) {
                iZzy += zzaov.zze(6, this.zzco.longValue());
            }
            if (this.zzcp != null) {
                iZzy += zzaov.zze(7, this.zzcp.longValue());
            }
            if (this.zzcq != null) {
                iZzy += zzaov.zzs(8, this.zzcq);
            }
            if (this.zzcr != null) {
                iZzy += zzaov.zze(9, this.zzcr.longValue());
            }
            return this.zzcs != null ? iZzy + zzaov.zzs(10, this.zzcs) : iZzy;
        }
    }
}
