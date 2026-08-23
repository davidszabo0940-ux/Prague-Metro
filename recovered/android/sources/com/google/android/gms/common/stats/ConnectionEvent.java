package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectionEvent extends StatsEvent {
    public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();
    final int mVersionCode;

    /* JADX INFO: renamed from: zM */
    private final long f403zM;

    /* JADX INFO: renamed from: zN */
    private int f404zN;

    /* JADX INFO: renamed from: zO */
    private final String f405zO;

    /* JADX INFO: renamed from: zP */
    private final String f406zP;

    /* JADX INFO: renamed from: zQ */
    private final String f407zQ;

    /* JADX INFO: renamed from: zR */
    private final String f408zR;

    /* JADX INFO: renamed from: zS */
    private final String f409zS;

    /* JADX INFO: renamed from: zT */
    private final String f410zT;

    /* JADX INFO: renamed from: zU */
    private final long f411zU;

    /* JADX INFO: renamed from: zV */
    private final long f412zV;

    /* JADX INFO: renamed from: zW */
    private long f413zW;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.mVersionCode = i;
        this.f403zM = j;
        this.f404zN = i2;
        this.f405zO = str;
        this.f406zP = str2;
        this.f407zQ = str3;
        this.f408zR = str4;
        this.f413zW = -1L;
        this.f409zS = str5;
        this.f410zT = str6;
        this.f411zU = j2;
        this.f412zV = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public int getEventType() {
        return this.f404zN;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public long getTimeMillis() {
        return this.f403zM;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzauj() {
        return this.f405zO;
    }

    public String zzauk() {
        return this.f406zP;
    }

    public String zzaul() {
        return this.f407zQ;
    }

    public String zzaum() {
        return this.f408zR;
    }

    public String zzaun() {
        return this.f409zS;
    }

    public String zzauo() {
        return this.f410zT;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public long zzaup() {
        return this.f413zW;
    }

    public long zzauq() {
        return this.f412zV;
    }

    public long zzaur() {
        return this.f411zU;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public String zzaus() {
        String strValueOf = String.valueOf("\t");
        String strValueOf2 = String.valueOf(zzauj());
        String strValueOf3 = String.valueOf(zzauk());
        String strValueOf4 = String.valueOf("\t");
        String strValueOf5 = String.valueOf(zzaul());
        String strValueOf6 = String.valueOf(zzaum());
        String strValueOf7 = String.valueOf("\t");
        String str = this.f409zS == null ? "" : this.f409zS;
        String strValueOf8 = String.valueOf("\t");
        return new StringBuilder(String.valueOf(strValueOf).length() + 22 + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length() + String.valueOf(strValueOf4).length() + String.valueOf(strValueOf5).length() + String.valueOf(strValueOf6).length() + String.valueOf(strValueOf7).length() + String.valueOf(str).length() + String.valueOf(strValueOf8).length()).append(strValueOf).append(strValueOf2).append("/").append(strValueOf3).append(strValueOf4).append(strValueOf5).append("/").append(strValueOf6).append(strValueOf7).append(str).append(strValueOf8).append(zzauq()).toString();
    }
}
