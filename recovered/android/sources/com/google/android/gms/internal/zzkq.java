package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzkq {
    private final String[] zzclv;
    private final double[] zzclw;
    private final double[] zzclx;
    private final int[] zzcly;
    private int zzclz;

    public static class zza {
        public final int count;
        public final String name;
        public final double zzcma;
        public final double zzcmb;
        public final double zzcmc;

        public zza(String str, double d, double d2, double d3, int i) {
            this.name = str;
            this.zzcmb = d;
            this.zzcma = d2;
            this.zzcmc = d3;
            this.count = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return com.google.android.gms.common.internal.zzaa.equal(this.name, zzaVar.name) && this.zzcma == zzaVar.zzcma && this.zzcmb == zzaVar.zzcmb && this.count == zzaVar.count && Double.compare(this.zzcmc, zzaVar.zzcmc) == 0;
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.zzaa.hashCode(this.name, Double.valueOf(this.zzcma), Double.valueOf(this.zzcmb), Double.valueOf(this.zzcmc), Integer.valueOf(this.count));
        }

        public String toString() {
            return com.google.android.gms.common.internal.zzaa.zzz(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzcmb)).zzg("maxBound", Double.valueOf(this.zzcma)).zzg("percent", Double.valueOf(this.zzcmc)).zzg("count", Integer.valueOf(this.count)).toString();
        }
    }

    public static class zzb {
        private final List<String> zzcmd = new ArrayList();
        private final List<Double> zzcme = new ArrayList();
        private final List<Double> zzcmf = new ArrayList();

        public zzb zza(String str, double d, double d2) {
            int i;
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.zzcmd.size()) {
                    break;
                }
                double dDoubleValue = this.zzcmf.get(i).doubleValue();
                double dDoubleValue2 = this.zzcme.get(i).doubleValue();
                if (d < dDoubleValue || (dDoubleValue == d && d2 < dDoubleValue2)) {
                    break;
                }
                i2 = i + 1;
            }
            this.zzcmd.add(i, str);
            this.zzcmf.add(i, Double.valueOf(d));
            this.zzcme.add(i, Double.valueOf(d2));
            return this;
        }

        public zzkq zztp() {
            return new zzkq(this);
        }
    }

    private zzkq(zzb zzbVar) {
        int size = zzbVar.zzcme.size();
        this.zzclv = (String[]) zzbVar.zzcmd.toArray(new String[size]);
        this.zzclw = zzm(zzbVar.zzcme);
        this.zzclx = zzm(zzbVar.zzcmf);
        this.zzcly = new int[size];
        this.zzclz = 0;
    }

    private double[] zzm(List<Double> list) {
        double[] dArr = new double[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return dArr;
            }
            dArr[i2] = list.get(i2).doubleValue();
            i = i2 + 1;
        }
    }

    public List<zza> getBuckets() {
        ArrayList arrayList = new ArrayList(this.zzclv.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzclv.length) {
                return arrayList;
            }
            arrayList.add(new zza(this.zzclv[i2], this.zzclx[i2], this.zzclw[i2], ((double) this.zzcly[i2]) / ((double) this.zzclz), this.zzcly[i2]));
            i = i2 + 1;
        }
    }

    public void zza(double d) {
        this.zzclz++;
        for (int i = 0; i < this.zzclx.length; i++) {
            if (this.zzclx[i] <= d && d < this.zzclw[i]) {
                int[] iArr = this.zzcly;
                iArr[i] = iArr[i] + 1;
            }
            if (d < this.zzclx[i]) {
                return;
            }
        }
    }
}
