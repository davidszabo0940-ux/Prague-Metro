package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzge {
    public final List<zzgd> zzbno;
    public final long zzbnp;
    public final List<String> zzbnq;
    public final List<String> zzbnr;
    public final List<String> zzbns;
    public final List<String> zzbnt;
    public final boolean zzbnu;
    public final String zzbnv;
    public final long zzbnw;
    public final String zzbnx;
    public final int zzbny;
    public final int zzbnz;
    public final long zzboa;
    public final boolean zzbob;
    public int zzboc;
    public int zzbod;

    public zzge(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (zzkh.zzaz(2)) {
            String strValueOf = String.valueOf(jSONObject.toString(2));
            zzkh.m95v(strValueOf.length() != 0 ? "Mediation Response JSON: ".concat(strValueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zzgd zzgdVar = new zzgd(jSONArray.getJSONObject(i2));
            arrayList.add(zzgdVar);
            if (i < 0 && zza(zzgdVar)) {
                i = i2;
            }
        }
        this.zzboc = i;
        this.zzbod = jSONArray.length();
        this.zzbno = Collections.unmodifiableList(arrayList);
        this.zzbnv = jSONObject.getString("qdata");
        this.zzbnz = jSONObject.optInt("fs_model_type", -1);
        this.zzboa = jSONObject.optLong("timeout_ms", -1L);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("settings");
        if (jSONObjectOptJSONObject == null) {
            this.zzbnp = -1L;
            this.zzbnq = null;
            this.zzbnr = null;
            this.zzbns = null;
            this.zzbnt = null;
            this.zzbnw = -1L;
            this.zzbnx = null;
            this.zzbny = 0;
            this.zzbob = false;
            this.zzbnu = false;
            return;
        }
        this.zzbnp = jSONObjectOptJSONObject.optLong("ad_network_timeout_millis", -1L);
        this.zzbnq = com.google.android.gms.ads.internal.zzu.zzgf().zza(jSONObjectOptJSONObject, "click_urls");
        this.zzbnr = com.google.android.gms.ads.internal.zzu.zzgf().zza(jSONObjectOptJSONObject, "imp_urls");
        this.zzbns = com.google.android.gms.ads.internal.zzu.zzgf().zza(jSONObjectOptJSONObject, "nofill_urls");
        this.zzbnt = com.google.android.gms.ads.internal.zzu.zzgf().zza(jSONObjectOptJSONObject, "remote_ping_urls");
        this.zzbnu = jSONObjectOptJSONObject.optBoolean("render_in_browser", false);
        long jOptLong = jSONObjectOptJSONObject.optLong("refresh", -1L);
        this.zzbnw = jOptLong > 0 ? jOptLong * 1000 : -1L;
        RewardItemParcel rewardItemParcelZza = RewardItemParcel.zza(jSONObjectOptJSONObject.optJSONArray("rewards"));
        if (rewardItemParcelZza == null) {
            this.zzbnx = null;
            this.zzbny = 0;
        } else {
            this.zzbnx = rewardItemParcelZza.type;
            this.zzbny = rewardItemParcelZza.zzcih;
        }
        this.zzbob = jSONObjectOptJSONObject.optBoolean("use_displayed_impression", false);
    }

    public zzge(List<zzgd> list, long j, List<String> list2, List<String> list3, List<String> list4, List<String> list5, boolean z, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3, boolean z2) {
        this.zzbno = list;
        this.zzbnp = j;
        this.zzbnq = list2;
        this.zzbnr = list3;
        this.zzbns = list4;
        this.zzbnt = list5;
        this.zzbnu = z;
        this.zzbnv = str;
        this.zzbnw = j2;
        this.zzboc = i;
        this.zzbod = i2;
        this.zzbnx = str2;
        this.zzbny = i3;
        this.zzbnz = i4;
        this.zzboa = j3;
        this.zzbob = z2;
    }

    private boolean zza(zzgd zzgdVar) {
        Iterator<String> it = zzgdVar.zzbna.iterator();
        while (it.hasNext()) {
            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
