package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzg();

    /* JADX INFO: renamed from: AA */
    private final String f414AA;

    /* JADX INFO: renamed from: AB */
    private final int f415AB;

    /* JADX INFO: renamed from: AC */
    private final List<String> f416AC;

    /* JADX INFO: renamed from: AD */
    private final String f417AD;

    /* JADX INFO: renamed from: AE */
    private int f418AE;

    /* JADX INFO: renamed from: AF */
    private final String f419AF;

    /* JADX INFO: renamed from: AG */
    private final float f420AG;

    /* JADX INFO: renamed from: Ay */
    private final String f421Ay;

    /* JADX INFO: renamed from: Az */
    private final String f422Az;
    private final long mTimeout;
    final int mVersionCode;

    /* JADX INFO: renamed from: zM */
    private final long f423zM;

    /* JADX INFO: renamed from: zN */
    private int f424zN;

    /* JADX INFO: renamed from: zU */
    private final long f425zU;

    /* JADX INFO: renamed from: zW */
    private long f426zW;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.mVersionCode = i;
        this.f423zM = j;
        this.f424zN = i2;
        this.f421Ay = str;
        this.f422Az = str3;
        this.f414AA = str5;
        this.f415AB = i3;
        this.f426zW = -1L;
        this.f416AC = list;
        this.f417AD = str2;
        this.f425zU = j2;
        this.f418AE = i4;
        this.f419AF = str4;
        this.f420AG = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public int getEventType() {
        return this.f424zN;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public long getTimeMillis() {
        return this.f423zM;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public String zzauo() {
        return this.f417AD;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public long zzaup() {
        return this.f426zW;
    }

    public long zzaur() {
        return this.f425zU;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public String zzaus() {
        String strValueOf = String.valueOf("\t");
        String strValueOf2 = String.valueOf(zzauv());
        String strValueOf3 = String.valueOf("\t");
        int iZzauy = zzauy();
        String strValueOf4 = String.valueOf("\t");
        String strJoin = zzauz() == null ? "" : TextUtils.join(",", zzauz());
        String strValueOf5 = String.valueOf("\t");
        int iZzava = zzava();
        String strValueOf6 = String.valueOf("\t");
        String strZzauw = zzauw() == null ? "" : zzauw();
        String strValueOf7 = String.valueOf("\t");
        String strZzavb = zzavb() == null ? "" : zzavb();
        String strValueOf8 = String.valueOf("\t");
        float fZzavc = zzavc();
        String strValueOf9 = String.valueOf("\t");
        String strZzaux = zzaux() == null ? "" : zzaux();
        return new StringBuilder(String.valueOf(strValueOf).length() + 37 + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length() + String.valueOf(strValueOf4).length() + String.valueOf(strJoin).length() + String.valueOf(strValueOf5).length() + String.valueOf(strValueOf6).length() + String.valueOf(strZzauw).length() + String.valueOf(strValueOf7).length() + String.valueOf(strZzavb).length() + String.valueOf(strValueOf8).length() + String.valueOf(strValueOf9).length() + String.valueOf(strZzaux).length()).append(strValueOf).append(strValueOf2).append(strValueOf3).append(iZzauy).append(strValueOf4).append(strJoin).append(strValueOf5).append(iZzava).append(strValueOf6).append(strZzauw).append(strValueOf7).append(strZzavb).append(strValueOf8).append(fZzavc).append(strValueOf9).append(strZzaux).toString();
    }

    public String zzauv() {
        return this.f421Ay;
    }

    public String zzauw() {
        return this.f422Az;
    }

    public String zzaux() {
        return this.f414AA;
    }

    public int zzauy() {
        return this.f415AB;
    }

    public List<String> zzauz() {
        return this.f416AC;
    }

    public int zzava() {
        return this.f418AE;
    }

    public String zzavb() {
        return this.f419AF;
    }

    public float zzavc() {
        return this.f420AG;
    }

    public long zzavd() {
        return this.mTimeout;
    }
}
