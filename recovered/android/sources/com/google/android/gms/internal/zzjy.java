package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzjy {
    public final int errorCode;
    public final int orientation;
    public final List<String> zzbnq;
    public final List<String> zzbnr;

    @Nullable
    public final List<String> zzbnt;
    public final long zzbnw;

    @Nullable
    public final zzgd zzbor;

    @Nullable
    public final zzgo zzbos;

    @Nullable
    public final String zzbot;

    @Nullable
    public final zzgg zzbou;

    @Nullable
    public final zzll zzbtq;
    public final AdRequestParcel zzcav;
    public final String zzcay;
    public final long zzccb;
    public final boolean zzccc;
    public final long zzccd;
    public final List<String> zzcce;
    public final String zzcch;

    @Nullable
    public final RewardItemParcel zzccr;

    @Nullable
    public final List<String> zzcct;
    public final boolean zzccu;
    public final AutoClickProtectionConfigurationParcel zzccv;
    public final JSONObject zzcii;
    public boolean zzcij;
    public final zzge zzcik;

    @Nullable
    public final String zzcil;
    public final AdSizeParcel zzcim;

    @Nullable
    public final List<String> zzcin;
    public final long zzcio;
    public final long zzcip;

    @Nullable
    public final com.google.android.gms.ads.internal.formats.zzh.zza zzciq;
    public boolean zzcir;
    public boolean zzcis;

    @zzir
    public static final class zza {
        public final int errorCode;
        public final AdSizeParcel zzaoy;
        public final JSONObject zzcii;
        public final zzge zzcik;
        public final long zzcio;
        public final long zzcip;
        public final AdRequestInfoParcel zzcit;
        public final AdResponseParcel zzciu;

        public zza(AdRequestInfoParcel adRequestInfoParcel, AdResponseParcel adResponseParcel, zzge zzgeVar, AdSizeParcel adSizeParcel, int i, long j, long j2, JSONObject jSONObject) {
            this.zzcit = adRequestInfoParcel;
            this.zzciu = adResponseParcel;
            this.zzcik = zzgeVar;
            this.zzaoy = adSizeParcel;
            this.errorCode = i;
            this.zzcio = j;
            this.zzcip = j2;
            this.zzcii = jSONObject;
        }
    }

    public zzjy(AdRequestParcel adRequestParcel, @Nullable zzll zzllVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, @Nullable zzgd zzgdVar, @Nullable zzgo zzgoVar, @Nullable String str2, zzge zzgeVar, @Nullable zzgg zzggVar, long j2, AdSizeParcel adSizeParcel, long j3, long j4, long j5, String str3, JSONObject jSONObject, @Nullable com.google.android.gms.ads.internal.formats.zzh.zza zzaVar, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z2, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, @Nullable String str4, List<String> list6) {
        this.zzcir = false;
        this.zzcis = false;
        this.zzcav = adRequestParcel;
        this.zzbtq = zzllVar;
        this.zzbnq = zzl(list);
        this.errorCode = i;
        this.zzbnr = zzl(list2);
        this.zzcce = zzl(list3);
        this.orientation = i2;
        this.zzbnw = j;
        this.zzcay = str;
        this.zzccc = z;
        this.zzbor = zzgdVar;
        this.zzbos = zzgoVar;
        this.zzbot = str2;
        this.zzcik = zzgeVar;
        this.zzbou = zzggVar;
        this.zzccd = j2;
        this.zzcim = adSizeParcel;
        this.zzccb = j3;
        this.zzcio = j4;
        this.zzcip = j5;
        this.zzcch = str3;
        this.zzcii = jSONObject;
        this.zzciq = zzaVar;
        this.zzccr = rewardItemParcel;
        this.zzcin = zzl(list4);
        this.zzcct = zzl(list5);
        this.zzccu = z2;
        this.zzccv = autoClickProtectionConfigurationParcel;
        this.zzcil = str4;
        this.zzbnt = zzl(list6);
    }

    public zzjy(zza zzaVar, @Nullable zzll zzllVar, @Nullable zzgd zzgdVar, @Nullable zzgo zzgoVar, @Nullable String str, @Nullable zzgg zzggVar, @Nullable com.google.android.gms.ads.internal.formats.zzh.zza zzaVar2, @Nullable String str2) {
        this(zzaVar.zzcit.zzcav, zzllVar, zzaVar.zzciu.zzbnq, zzaVar.errorCode, zzaVar.zzciu.zzbnr, zzaVar.zzciu.zzcce, zzaVar.zzciu.orientation, zzaVar.zzciu.zzbnw, zzaVar.zzcit.zzcay, zzaVar.zzciu.zzccc, zzgdVar, zzgoVar, str, zzaVar.zzcik, zzggVar, zzaVar.zzciu.zzccd, zzaVar.zzaoy, zzaVar.zzciu.zzccb, zzaVar.zzcio, zzaVar.zzcip, zzaVar.zzciu.zzcch, zzaVar.zzcii, zzaVar2, zzaVar.zzciu.zzccr, zzaVar.zzciu.zzccs, zzaVar.zzciu.zzccs, zzaVar.zzciu.zzccu, zzaVar.zzciu.zzccv, str2, zzaVar.zzciu.zzbnt);
    }

    @Nullable
    private static <T> List<T> zzl(@Nullable List<T> list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public boolean zzho() {
        if (this.zzbtq == null || this.zzbtq.zzuk() == null) {
            return false;
        }
        return this.zzbtq.zzuk().zzho();
    }
}
