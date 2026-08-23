package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzey implements zzet {
    final HashMap<String, zzkz<JSONObject>> zzbiw = new HashMap<>();

    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        zzi(map.get("request_id"), map.get("fetched_ad"));
    }

    public Future<JSONObject> zzax(String str) {
        zzkz<JSONObject> zzkzVar = new zzkz<>();
        this.zzbiw.put(str, zzkzVar);
        return zzkzVar;
    }

    public void zzay(String str) {
        zzkz<JSONObject> zzkzVar = this.zzbiw.get(str);
        if (zzkzVar == null) {
            zzkh.m14e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzkzVar.isDone()) {
            zzkzVar.cancel(true);
        }
        this.zzbiw.remove(str);
    }

    public void zzi(String str, String str2) {
        zzkh.zzcw("Received ad from the cache.");
        zzkz<JSONObject> zzkzVar = this.zzbiw.get(str);
        if (zzkzVar == null) {
            zzkh.m14e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            zzkzVar.zzi(new JSONObject(str2));
        } catch (JSONException e) {
            zzkh.zzb("Failed constructing JSON object from value passed from javascript", e);
            zzkzVar.zzi(null);
        } finally {
            this.zzbiw.remove(str);
        }
    }
}
