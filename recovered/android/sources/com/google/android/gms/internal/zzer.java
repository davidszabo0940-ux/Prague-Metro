package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzer {
    public static final zzet zzbhr = new zzet() { // from class: com.google.android.gms.internal.zzer.1
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
        }
    };
    public static final zzet zzbhs = new zzet() { // from class: com.google.android.gms.internal.zzer.5
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            String str = map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzkh.zzcy("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] strArrSplit = str.split(",");
            HashMap map2 = new HashMap();
            PackageManager packageManager = zzllVar.getContext().getPackageManager();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(";", 2);
                map2.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(strArrSplit2.length > 1 ? strArrSplit2[1].trim() : "android.intent.action.VIEW", Uri.parse(strArrSplit2[0].trim())), 65536) != null));
            }
            zzllVar.zza("openableURLs", map2);
        }
    };
    public static final zzet zzbht = new zzet() { // from class: com.google.android.gms.internal.zzer.6
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            PackageManager packageManager = zzllVar.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject(map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String strOptString = jSONObject2.optString("id");
                            String strOptString2 = jSONObject2.optString("u");
                            String strOptString3 = jSONObject2.optString("i");
                            String strOptString4 = jSONObject2.optString("m");
                            String strOptString5 = jSONObject2.optString("p");
                            String strOptString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(strOptString2)) {
                                intent.setData(Uri.parse(strOptString2));
                            }
                            if (!TextUtils.isEmpty(strOptString3)) {
                                intent.setAction(strOptString3);
                            }
                            if (!TextUtils.isEmpty(strOptString4)) {
                                intent.setType(strOptString4);
                            }
                            if (!TextUtils.isEmpty(strOptString5)) {
                                intent.setPackage(strOptString5);
                            }
                            if (!TextUtils.isEmpty(strOptString6)) {
                                String[] strArrSplit = strOptString6.split("/", 2);
                                if (strArrSplit.length == 2) {
                                    intent.setComponent(new ComponentName(strArrSplit[0], strArrSplit[1]));
                                }
                            }
                            try {
                                jSONObject.put(strOptString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (JSONException e) {
                                zzkh.zzb("Error constructing openable urls response.", e);
                            }
                        } catch (JSONException e2) {
                            zzkh.zzb("Error parsing the intent data.", e2);
                        }
                    }
                    zzllVar.zzb("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    zzllVar.zzb("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                zzllVar.zzb("openableIntents", new JSONObject());
            }
        }
    };
    public static final zzet zzbhu = new zzet() { // from class: com.google.android.gms.internal.zzer.7
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            Uri uriZzb;
            String str = map.get("u");
            if (str == null) {
                zzkh.zzcy("URL missing from click GMSG.");
                return;
            }
            Uri uri = Uri.parse(str);
            try {
                zzas zzasVarZzum = zzllVar.zzum();
                uriZzb = (zzasVarZzum == null || !zzasVarZzum.zzc(uri)) ? uri : zzasVarZzum.zzb(uri, zzllVar.getContext());
            } catch (zzat e) {
                String strValueOf = String.valueOf(str);
                zzkh.zzcy(strValueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(strValueOf) : new String("Unable to append parameter to URL: "));
            }
        }
    };
    public static final zzet zzbhv = new zzet() { // from class: com.google.android.gms.internal.zzer.8
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            com.google.android.gms.ads.internal.overlay.zzd zzdVarZzui = zzllVar.zzui();
            if (zzdVarZzui != null) {
                zzdVarZzui.close();
                return;
            }
            com.google.android.gms.ads.internal.overlay.zzd zzdVarZzuj = zzllVar.zzuj();
            if (zzdVarZzuj != null) {
                zzdVarZzuj.close();
            } else {
                zzkh.zzcy("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    };
    public static final zzet zzbhw = new zzet() { // from class: com.google.android.gms.internal.zzer.9
        private void zzc(zzll zzllVar) {
            com.google.android.gms.ads.internal.overlay.zzm zzmVar;
            zzkh.zzcx("Received support message, responding.");
            boolean zZzr = false;
            com.google.android.gms.ads.internal.zzd zzdVarZzuh = zzllVar.zzuh();
            if (zzdVarZzuh != null && (zzmVar = zzdVarZzuh.zzakl) != null) {
                zZzr = zzmVar.zzr(zzllVar.getContext());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "checkSupport");
                jSONObject.put("supports", zZzr);
                zzllVar.zzb("appStreaming", jSONObject);
            } catch (Throwable th) {
            }
        }

        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            if ("checkSupport".equals(map.get("action"))) {
                zzc(zzllVar);
                return;
            }
            com.google.android.gms.ads.internal.overlay.zzd zzdVarZzui = zzllVar.zzui();
            if (zzdVarZzui != null) {
                zzdVarZzui.zzf(zzllVar, map);
            }
        }
    };
    public static final zzet zzbhx = new zzet() { // from class: com.google.android.gms.internal.zzer.10
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            zzllVar.zzai("1".equals(map.get("custom_close")));
        }
    };
    public static final zzet zzbhy = new zzet() { // from class: com.google.android.gms.internal.zzer.11
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            String str = map.get("u");
            if (str == null) {
                zzkh.zzcy("URL missing from httpTrack GMSG.");
            }
        }
    };
    public static final zzet zzbhz = new zzet() { // from class: com.google.android.gms.internal.zzer.12
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            String strValueOf = String.valueOf(map.get("string"));
            zzkh.zzcx(strValueOf.length() != 0 ? "Received log message: ".concat(strValueOf) : new String("Received log message: "));
        }
    };
    public static final zzet zzbia = new zzet() { // from class: com.google.android.gms.internal.zzer.2
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            String str = map.get("tx");
            String str2 = map.get("ty");
            String str3 = map.get("td");
            try {
                int i = Integer.parseInt(str);
                int i2 = Integer.parseInt(str2);
                int i3 = Integer.parseInt(str3);
                zzas zzasVarZzum = zzllVar.zzum();
                if (zzasVarZzum != null) {
                    zzasVarZzum.zzax().zza(i, i2, i3);
                }
            } catch (NumberFormatException e) {
                zzkh.zzcy("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzet zzbib = new zzet() { // from class: com.google.android.gms.internal.zzer.3
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            if (zzdc.zzbay.get().booleanValue()) {
                zzllVar.zzaj(!Boolean.parseBoolean(map.get("disabled")));
            }
        }
    };
    public static final zzet zzbic = new zzet() { // from class: com.google.android.gms.internal.zzer.4
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            String str = map.get("action");
            if ("pause".equals(str)) {
                zzllVar.zzeg();
            } else if ("resume".equals(str)) {
                zzllVar.zzeh();
            }
        }
    };
    public static final zzet zzbid = new zzfd();
    public static final zzet zzbie = new zzfe();
    public static final zzet zzbif = new zzfi();
    public static final zzet zzbig = new zzeq();
    public static final zzfb zzbih = new zzfb();
}
