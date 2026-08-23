package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzgd {
    public final String zzbmy;
    public final String zzbmz;
    public final List<String> zzbna;
    public final String zzbnb;
    public final String zzbnc;
    public final List<String> zzbnd;
    public final List<String> zzbne;
    public final List<String> zzbnf;
    public final String zzbng;
    public final List<String> zzbnh;
    public final List<String> zzbni;
    public final String zzbnj;
    public final String zzbnk;
    public final String zzbnl;
    public final List<String> zzbnm;
    public final String zzbnn;

    public zzgd(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, String str5, String str6, List<String> list4, List<String> list5, String str7, String str8, String str9, List<String> list6, String str10, List<String> list7) {
        this.zzbmy = str;
        this.zzbmz = str2;
        this.zzbna = list;
        this.zzbnb = str3;
        this.zzbnc = str4;
        this.zzbnd = list2;
        this.zzbne = list3;
        this.zzbng = str5;
        this.zzbnh = list4;
        this.zzbni = list5;
        this.zzbnj = str7;
        this.zzbnk = str8;
        this.zzbnl = str9;
        this.zzbnm = list6;
        this.zzbnn = str10;
        this.zzbnf = list7;
    }

    public zzgd(JSONObject jSONObject) throws JSONException {
        this.zzbmz = jSONObject.getString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzbna = Collections.unmodifiableList(arrayList);
        this.zzbnb = jSONObject.optString("allocation_id", null);
        this.zzbnd = com.google.android.gms.ads.internal.zzu.zzgf().zza(jSONObject, "clickurl");
        this.zzbne = com.google.android.gms.ads.internal.zzu.zzgf().zza(jSONObject, "imp_urls");
        this.zzbnf = com.google.android.gms.ads.internal.zzu.zzgf().zza(jSONObject, "fill_urls");
        this.zzbnh = com.google.android.gms.ads.internal.zzu.zzgf().zza(jSONObject, "video_start_urls");
        this.zzbni = com.google.android.gms.ads.internal.zzu.zzgf().zza(jSONObject, "video_complete_urls");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ad");
        this.zzbmy = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : null;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
        this.zzbng = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.toString() : null;
        this.zzbnc = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("class_name") : null;
        this.zzbnj = jSONObject.optString("html_template", null);
        this.zzbnk = jSONObject.optString("ad_base_url", null);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzbnl = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.toString() : null;
        this.zzbnm = com.google.android.gms.ads.internal.zzu.zzgf().zza(jSONObject, "template_ids");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzbnn = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.toString() : null;
    }
}
