package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzadx {

    public static final class zza extends zzaow<zza> {
        public long aDp;
        public zzah.zzj aDq;
        public zzah.zzf zzwq;

        public zza() {
            zzcgt();
        }

        public static zza zzap(byte[] bArr) throws zzapb {
            return (zza) zzapc.zza(new zza(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.aDp != zzaVar.aDp) {
                return false;
            }
            if (this.zzwq == null) {
                if (zzaVar.zzwq != null) {
                    return false;
                }
            } else if (!this.zzwq.equals(zzaVar.zzwq)) {
                return false;
            }
            if (this.aDq == null) {
                if (zzaVar.aDq != null) {
                    return false;
                }
            } else if (!this.aDq.equals(zzaVar.aDq)) {
                return false;
            }
            if (this.bib == null || this.bib.isEmpty()) {
                return zzaVar.bib == null || zzaVar.bib.isEmpty();
            }
            return this.bib.equals(zzaVar.bib);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.aDq == null ? 0 : this.aDq.hashCode()) + (((this.zzwq == null ? 0 : this.zzwq.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.aDp ^ (this.aDp >>> 32)))) * 31)) * 31)) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                iHashCode = this.bib.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        public void zza(zzaov zzaovVar) throws IOException {
            zzaovVar.zzb(1, this.aDp);
            if (this.zzwq != null) {
                zzaovVar.zza(2, this.zzwq);
            }
            if (this.aDq != null) {
                zzaovVar.zza(3, this.aDq);
            }
            super.zza(zzaovVar);
        }

        @Override // com.google.android.gms.internal.zzapc
        /* JADX INFO: renamed from: zzbt, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzaou zzaouVar) throws IOException {
            while (true) {
                int iM51J = zzaouVar.m51J();
                switch (iM51J) {
                    case 0:
                        break;
                    case 8:
                        this.aDp = zzaouVar.m54M();
                        break;
                    case 18:
                        if (this.zzwq == null) {
                            this.zzwq = new zzah.zzf();
                        }
                        zzaouVar.zza(this.zzwq);
                        break;
                    case 26:
                        if (this.aDq == null) {
                            this.aDq = new zzah.zzj();
                        }
                        zzaouVar.zza(this.aDq);
                        break;
                    default:
                        if (!super.zza(zzaouVar, iM51J)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zza zzcgt() {
            this.aDp = 0L;
            this.zzwq = null;
            this.aDq = null;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzaow, com.google.android.gms.internal.zzapc
        protected int zzy() {
            int iZzy = super.zzy() + zzaov.zze(1, this.aDp);
            if (this.zzwq != null) {
                iZzy += zzaov.zzc(2, this.zzwq);
            }
            return this.aDq != null ? iZzy + zzaov.zzc(3, this.aDq) : iZzy;
        }
    }
}
