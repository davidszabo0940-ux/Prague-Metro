package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzka {
    private final long zzcjg;
    private String zzcjj;
    private String zzcjk;
    private final List<String> zzcjh = new ArrayList();
    private final Map<String, zzb> zzcji = new HashMap();
    private boolean zzcjl = false;

    class zza {
        private final List<String> zzcjm;
        private final Bundle zzcjn;

        public zza(List<String> list, Bundle bundle) {
            this.zzcjm = list;
            this.zzcjn = bundle;
        }
    }

    class zzb {
        final List<zza> zzcjp = new ArrayList();

        zzb() {
        }

        public void zza(zza zzaVar) {
            this.zzcjp.add(zzaVar);
        }
    }

    public zzka(String str, long j) {
        this.zzcjk = str;
        this.zzcjg = j;
        zzcm(str);
    }

    private void zzcm(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("status", -1) != 1) {
                this.zzcjl = false;
                zzkh.zzcy("App settings could not be fetched successfully.");
                return;
            }
            this.zzcjl = true;
            this.zzcjj = jSONObject.optString("app_id");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    zzi(jSONArrayOptJSONArray.getJSONObject(i));
                }
            }
        } catch (JSONException e) {
            zzkh.zzd("Exception occurred while processing app setting json", e);
            com.google.android.gms.ads.internal.zzu.zzft().zzb((Throwable) e, true);
        }
    }

    private void zzi(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObject2;
        JSONArray jSONArrayOptJSONArray2;
        String strOptString = jSONObject.optString("format");
        String strOptString2 = jSONObject.optString("ad_unit_id");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return;
        }
        if ("interstitial".equalsIgnoreCase(strOptString)) {
            this.zzcjh.add(strOptString2);
            return;
        }
        if (!"rewarded".equalsIgnoreCase(strOptString) || (jSONObjectOptJSONObject = jSONObject.optJSONObject("mediation_config")) == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("ad_networks")) == null) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length() && (jSONArrayOptJSONArray2 = (jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i)).optJSONArray("adapters")) != null; i++) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                arrayList.add(jSONArrayOptJSONArray2.getString(i2));
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
            if (jSONObjectOptJSONObject2 == null) {
                return;
            }
            Bundle bundle = new Bundle();
            Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle.putString(next, jSONObjectOptJSONObject2.getString(next));
            }
            zza zzaVar = new zza(arrayList, bundle);
            zzb zzbVar = this.zzcji.containsKey(strOptString2) ? this.zzcji.get(strOptString2) : new zzb();
            zzbVar.zza(zzaVar);
            this.zzcji.put(strOptString2, zzbVar);
        }
    }

    public long zzsf() {
        return this.zzcjg;
    }

    public boolean zzsg() {
        return this.zzcjl;
    }

    public String zzsh() {
        return this.zzcjk;
    }

    public String zzsi() {
        return this.zzcjj;
    }
}
