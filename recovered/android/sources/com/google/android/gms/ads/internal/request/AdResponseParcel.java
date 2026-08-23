package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class AdResponseParcel extends AbstractSafeParcelable {
    public static final zzh CREATOR = new zzh();
    public String body;
    public final int errorCode;
    public final int orientation;
    public final int versionCode;
    public final boolean zzaus;
    public final boolean zzaut;
    public final boolean zzauu;
    public final List<String> zzbnq;
    public final List<String> zzbnr;
    public final List<String> zzbnt;

    @Nullable
    public final boolean zzbnu;
    public final long zzbnw;
    private AdRequestInfoParcel zzbox;
    public final String zzbts;
    public final boolean zzcbd;
    public final boolean zzcbu;

    @Nullable
    public String zzcbv;
    public final long zzccb;
    public final boolean zzccc;
    public final long zzccd;
    public final List<String> zzcce;
    public final String zzccf;
    public final long zzccg;
    public final String zzcch;
    public final boolean zzcci;
    public final String zzccj;
    public final String zzcck;
    public final boolean zzccl;
    public final boolean zzccm;
    public final boolean zzccn;
    public LargeParcelTeleporter zzcco;
    public String zzccp;
    public final String zzccq;

    @Nullable
    public final RewardItemParcel zzccr;

    @Nullable
    public final List<String> zzccs;

    @Nullable
    public final List<String> zzcct;

    @Nullable
    public final boolean zzccu;
    public final AutoClickProtectionConfigurationParcel zzccv;

    @Nullable
    public final String zzccw;

    @Nullable
    public final String zzccx;

    public AdResponseParcel(int i) {
        this(18, null, null, null, i, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, null, false, null);
    }

    public AdResponseParcel(int i, long j) {
        this(18, null, null, null, i, null, -1L, false, -1L, null, j, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, null, false, null);
    }

    AdResponseParcel(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LargeParcelTeleporter largeParcelTeleporter, String str7, String str8, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z10, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z11, String str9, List<String> list6, String str10, boolean z12, String str11) {
        StringParcel stringParcel;
        this.versionCode = i;
        this.zzbts = str;
        this.body = str2;
        this.zzbnq = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzbnr = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzccb = j;
        this.zzccc = z;
        this.zzccd = j2;
        this.zzcce = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzbnw = j3;
        this.orientation = i3;
        this.zzccf = str3;
        this.zzccg = j4;
        this.zzcch = str4;
        this.zzcci = z2;
        this.zzccj = str5;
        this.zzcck = str6;
        this.zzccl = z3;
        this.zzaus = z4;
        this.zzcbd = z5;
        this.zzccm = z6;
        this.zzccn = z7;
        this.zzcco = largeParcelTeleporter;
        this.zzccp = str7;
        this.zzccq = str8;
        if (this.body == null && this.zzcco != null && (stringParcel = (StringParcel) this.zzcco.zza(StringParcel.CREATOR)) != null && !TextUtils.isEmpty(stringParcel.zzrf())) {
            this.body = stringParcel.zzrf();
        }
        this.zzaut = z8;
        this.zzauu = z9;
        this.zzccr = rewardItemParcel;
        this.zzccs = list4;
        this.zzcct = list5;
        this.zzccu = z10;
        this.zzccv = autoClickProtectionConfigurationParcel;
        this.zzcbu = z11;
        this.zzcbv = str9;
        this.zzbnt = list6;
        this.zzccw = str10;
        this.zzbnu = z12;
        this.zzccx = str11;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z9, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z10, String str7, List<String> list6, String str8, boolean z11, String str9) {
        this(18, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, z6, null, null, str6, z7, z8, rewardItemParcel, list4, list5, z9, autoClickProtectionConfigurationParcel, z10, str7, list6, str8, z11, str9);
        this.zzbox = adRequestInfoParcel;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z10, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z11, String str8, List<String> list6, String str9, boolean z12, String str10) {
        this(18, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, null, null, str7, z8, z9, rewardItemParcel, list4, list5, z10, autoClickProtectionConfigurationParcel, z11, str8, list6, str9, z12, str10);
        this.zzbox = adRequestInfoParcel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.zzbox != null && this.zzbox.versionCode >= 9 && !TextUtils.isEmpty(this.body)) {
            this.zzcco = new LargeParcelTeleporter(new StringParcel(this.body));
            this.body = null;
        }
        zzh.zza(this, parcel, i);
    }
}
