package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzapg;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class LogEventParcelable extends AbstractSafeParcelable {
    public static final zzd CREATOR = new zzd();

    /* JADX INFO: renamed from: qk */
    public PlayLoggerContext f62qk;

    /* JADX INFO: renamed from: ql */
    public byte[] f63ql;

    /* JADX INFO: renamed from: qm */
    public int[] f64qm;

    /* JADX INFO: renamed from: qn */
    public String[] f65qn;

    /* JADX INFO: renamed from: qo */
    public int[] f66qo;

    /* JADX INFO: renamed from: qp */
    public byte[][] f67qp;

    /* JADX INFO: renamed from: qq */
    public boolean f68qq;

    /* JADX INFO: renamed from: qr */
    public final zzapg.zzd f69qr;

    /* JADX INFO: renamed from: qs */
    public final zzb.zzc f70qs;

    /* JADX INFO: renamed from: qt */
    public final zzb.zzc f71qt;
    public final int versionCode;

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z) {
        this.versionCode = i;
        this.f62qk = playLoggerContext;
        this.f63ql = bArr;
        this.f64qm = iArr;
        this.f65qn = strArr;
        this.f69qr = null;
        this.f70qs = null;
        this.f71qt = null;
        this.f66qo = iArr2;
        this.f67qp = bArr2;
        this.f68qq = z;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zzapg.zzd zzdVar, zzb.zzc zzcVar, zzb.zzc zzcVar2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, boolean z) {
        this.versionCode = 1;
        this.f62qk = playLoggerContext;
        this.f69qr = zzdVar;
        this.f70qs = zzcVar;
        this.f71qt = zzcVar2;
        this.f64qm = iArr;
        this.f65qn = strArr;
        this.f66qo = iArr2;
        this.f67qp = bArr;
        this.f68qq = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) obj;
        return this.versionCode == logEventParcelable.versionCode && zzaa.equal(this.f62qk, logEventParcelable.f62qk) && Arrays.equals(this.f63ql, logEventParcelable.f63ql) && Arrays.equals(this.f64qm, logEventParcelable.f64qm) && Arrays.equals(this.f65qn, logEventParcelable.f65qn) && zzaa.equal(this.f69qr, logEventParcelable.f69qr) && zzaa.equal(this.f70qs, logEventParcelable.f70qs) && zzaa.equal(this.f71qt, logEventParcelable.f71qt) && Arrays.equals(this.f66qo, logEventParcelable.f66qo) && Arrays.deepEquals(this.f67qp, logEventParcelable.f67qp) && this.f68qq == logEventParcelable.f68qq;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.versionCode), this.f62qk, this.f63ql, this.f64qm, this.f65qn, this.f69qr, this.f70qs, this.f71qt, this.f66qo, this.f67qp, Boolean.valueOf(this.f68qq));
    }

    public String toString() {
        return "LogEventParcelable[" + this.versionCode + ", " + this.f62qk + ", LogEventBytes: " + (this.f63ql == null ? null : new String(this.f63ql)) + ", TestCodes: " + Arrays.toString(this.f64qm) + ", MendelPackages: " + Arrays.toString(this.f65qn) + ", LogEvent: " + this.f69qr + ", ExtensionProducer: " + this.f70qs + ", VeProducer: " + this.f71qt + ", ExperimentIDs: " + Arrays.toString(this.f66qo) + ", ExperimentTokens: " + Arrays.toString(this.f67qp) + ", AddPhenotypeExperimentTokens: " + this.f68qq + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
