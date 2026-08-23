package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zziu {
    private static final SimpleDateFormat zzcep = new SimpleDateFormat("yyyyMMdd", Locale.US);

    /* JADX WARN: Code duplicated, block: B:68:0x0252 A[PHI: r18
  0x0252: PHI (r18v3 int) = (r18v2 int), (r18v5 int) binds: [B:46:0x0111, B:51:0x0122] A[DONT_GENERATE, DONT_INLINE]] */
    public static AdResponseParcel zza(Context context, AdRequestInfoParcel adRequestInfoParcel, String str) {
        String str2;
        long j;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("ad_base_url", null);
            String strOptString2 = jSONObject.optString("ad_url", null);
            String strOptString3 = jSONObject.optString("ad_size", null);
            String strOptString4 = jSONObject.optString("ad_slot_size", strOptString3);
            boolean z = (adRequestInfoParcel == null || adRequestInfoParcel.zzcbb == 0) ? false : true;
            String strOptString5 = jSONObject.optString("ad_json", null);
            if (strOptString5 == null) {
                strOptString5 = jSONObject.optString("ad_html", null);
            }
            if (strOptString5 == null) {
                strOptString5 = jSONObject.optString("body", null);
            }
            long j2 = -1;
            String strOptString6 = jSONObject.optString("debug_dialog", null);
            long j3 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1L;
            String strOptString7 = jSONObject.optString("orientation", null);
            int iZztk = -1;
            if ("portrait".equals(strOptString7)) {
                iZztk = com.google.android.gms.ads.internal.zzu.zzfs().zztl();
            } else if ("landscape".equals(strOptString7)) {
                iZztk = com.google.android.gms.ads.internal.zzu.zzfs().zztk();
            }
            AdResponseParcel adResponseParcelZza = null;
            if (!TextUtils.isEmpty(strOptString5) || TextUtils.isEmpty(strOptString2)) {
                str2 = strOptString5;
            } else {
                adResponseParcelZza = zzit.zza(adRequestInfoParcel, context, adRequestInfoParcel.zzaou.zzcs, strOptString2, null, null, null, null);
                strOptString = adResponseParcelZza.zzbts;
                str2 = adResponseParcelZza.body;
                j2 = adResponseParcelZza.zzccg;
            }
            if (str2 == null) {
                return new AdResponseParcel(0);
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("click_urls");
            List<String> listZza = adResponseParcelZza == null ? null : adResponseParcelZza.zzbnq;
            if (jSONArrayOptJSONArray != null) {
                listZza = zza(jSONArrayOptJSONArray, listZza);
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("impression_urls");
            List<String> listZza2 = adResponseParcelZza == null ? null : adResponseParcelZza.zzbnr;
            if (jSONArrayOptJSONArray2 != null) {
                listZza2 = zza(jSONArrayOptJSONArray2, listZza2);
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("manual_impression_urls");
            List<String> listZza3 = adResponseParcelZza == null ? null : adResponseParcelZza.zzcce;
            if (jSONArrayOptJSONArray3 != null) {
                listZza3 = zza(jSONArrayOptJSONArray3, listZza3);
            }
            if (adResponseParcelZza == null) {
                j = j3;
            } else {
                if (adResponseParcelZza.orientation != -1) {
                    iZztk = adResponseParcelZza.orientation;
                }
                if (adResponseParcelZza.zzccb > 0) {
                    j = adResponseParcelZza.zzccb;
                } else {
                    j = j3;
                }
            }
            String strOptString8 = jSONObject.optString("active_view");
            boolean zOptBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            String strOptString9 = zOptBoolean ? jSONObject.optString("ad_passback_url", null) : null;
            boolean zOptBoolean2 = jSONObject.optBoolean("mediation", false);
            boolean zOptBoolean3 = jSONObject.optBoolean("custom_render_allowed", false);
            boolean zOptBoolean4 = jSONObject.optBoolean("content_url_opted_out", true);
            boolean zOptBoolean5 = jSONObject.optBoolean("prefetch", false);
            return new AdResponseParcel(adRequestInfoParcel, strOptString, str2, listZza, listZza2, j, zOptBoolean2, jSONObject.optLong("mediation_config_cache_time_milliseconds", -1L), listZza3, jSONObject.optLong("refresh_interval_milliseconds", -1L), iZztk, strOptString3, j2, strOptString6, zOptBoolean, strOptString9, strOptString8, zOptBoolean3, z, adRequestInfoParcel.zzcbd, zOptBoolean4, zOptBoolean5, jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), RewardItemParcel.zza(jSONObject.optJSONArray("rewards")), zza(jSONObject.optJSONArray("video_start_urls"), (List<String>) null), zza(jSONObject.optJSONArray("video_complete_urls"), (List<String>) null), jSONObject.optBoolean("use_displayed_impression", false), AutoClickProtectionConfigurationParcel.zzh(jSONObject.optJSONObject("auto_protection_configuration")), adRequestInfoParcel.zzcbu, jSONObject.optString("set_cookie", ""), zza(jSONObject.optJSONArray("remote_ping_urls"), (List<String>) null), jSONObject.optString("safe_browsing"), jSONObject.optBoolean("render_in_browser", adRequestInfoParcel.zzbnu), strOptString4);
        } catch (JSONException e) {
            String strValueOf = String.valueOf(e.getMessage());
            zzkh.zzcy(strValueOf.length() != 0 ? "Could not parse the inline ad response: ".concat(strValueOf) : new String("Could not parse the inline ad response: "));
            return new AdResponseParcel(0);
        }
    }

    @Nullable
    private static List<String> zza(@Nullable JSONArray jSONArray, @Nullable List<String> list) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList<>();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    @Nullable
    public static JSONObject zza(Context context, AdRequestInfoParcel adRequestInfoParcel, zziz zzizVar, zzjd.zza zzaVar, Location location, zzcv zzcvVar, String str, List<String> list, Bundle bundle, String str2) {
        try {
            HashMap map = new HashMap();
            if (list.size() > 0) {
                map.put("eid", TextUtils.join(",", list));
            }
            if (adRequestInfoParcel.zzcau != null) {
                map.put("ad_pos", adRequestInfoParcel.zzcau);
            }
            zza((HashMap<String, Object>) map, adRequestInfoParcel.zzcav);
            map.put("format", adRequestInfoParcel.zzaoy.zzaup);
            if (adRequestInfoParcel.zzaoy.width == -1) {
                map.put("smart_w", "full");
            }
            if (adRequestInfoParcel.zzaoy.height == -2) {
                map.put("smart_h", "auto");
            }
            if (adRequestInfoParcel.zzaoy.zzaut) {
                map.put("fluid", "height");
            }
            if (adRequestInfoParcel.zzaoy.zzaur != null) {
                StringBuilder sb = new StringBuilder();
                for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzaoy.zzaur) {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append(adSizeParcel.width == -1 ? (int) (adSizeParcel.widthPixels / zzizVar.zzcbh) : adSizeParcel.width);
                    sb.append("x");
                    sb.append(adSizeParcel.height == -2 ? (int) (adSizeParcel.heightPixels / zzizVar.zzcbh) : adSizeParcel.height);
                }
                map.put("sz", sb);
            }
            if (adRequestInfoParcel.zzcbb != 0) {
                map.put("native_version", Integer.valueOf(adRequestInfoParcel.zzcbb));
                if (!adRequestInfoParcel.zzaoy.zzauu) {
                    map.put("native_templates", adRequestInfoParcel.zzapq);
                    map.put("native_image_orientation", zzc(adRequestInfoParcel.zzapm));
                    if (!adRequestInfoParcel.zzcbm.isEmpty()) {
                        map.put("native_custom_templates", adRequestInfoParcel.zzcbm);
                    }
                }
            }
            map.put("slotname", adRequestInfoParcel.zzaos);
            map.put("pn", adRequestInfoParcel.applicationInfo.packageName);
            if (adRequestInfoParcel.zzcaw != null) {
                map.put("vc", Integer.valueOf(adRequestInfoParcel.zzcaw.versionCode));
            }
            map.put("ms", str);
            map.put("seq_num", adRequestInfoParcel.zzcay);
            map.put("session_id", adRequestInfoParcel.zzcaz);
            map.put("js", adRequestInfoParcel.zzaou.zzcs);
            zza(map, zzizVar, zzaVar, adRequestInfoParcel.zzcbz);
            zza((HashMap<String, Object>) map, str2);
            map.put("platform", Build.MANUFACTURER);
            map.put("submodel", Build.MODEL);
            if (location != null) {
                zza((HashMap<String, Object>) map, location);
            } else if (adRequestInfoParcel.zzcav.versionCode >= 2 && adRequestInfoParcel.zzcav.zzats != null) {
                zza((HashMap<String, Object>) map, adRequestInfoParcel.zzcav.zzats);
            }
            if (adRequestInfoParcel.versionCode >= 2) {
                map.put("quality_signals", adRequestInfoParcel.zzcba);
            }
            if (adRequestInfoParcel.versionCode >= 4 && adRequestInfoParcel.zzcbd) {
                map.put("forceHttps", Boolean.valueOf(adRequestInfoParcel.zzcbd));
            }
            if (bundle != null) {
                map.put("content_info", bundle);
            }
            if (adRequestInfoParcel.versionCode >= 5) {
                map.put("u_sd", Float.valueOf(adRequestInfoParcel.zzcbh));
                map.put("sh", Integer.valueOf(adRequestInfoParcel.zzcbg));
                map.put("sw", Integer.valueOf(adRequestInfoParcel.zzcbf));
            } else {
                map.put("u_sd", Float.valueOf(zzizVar.zzcbh));
                map.put("sh", Integer.valueOf(zzizVar.zzcbg));
                map.put("sw", Integer.valueOf(zzizVar.zzcbf));
            }
            if (adRequestInfoParcel.versionCode >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.zzcbi)) {
                    try {
                        map.put("view_hierarchy", new JSONObject(adRequestInfoParcel.zzcbi));
                    } catch (JSONException e) {
                        zzkh.zzd("Problem serializing view hierarchy to JSON", e);
                    }
                }
                map.put("correlation_id", Long.valueOf(adRequestInfoParcel.zzcbj));
            }
            if (adRequestInfoParcel.versionCode >= 7) {
                map.put("request_id", adRequestInfoParcel.zzcbk);
            }
            if (adRequestInfoParcel.versionCode >= 11 && adRequestInfoParcel.zzcbo != null) {
                map.put("capability", adRequestInfoParcel.zzcbo.toBundle());
            }
            if (adRequestInfoParcel.versionCode >= 12 && !TextUtils.isEmpty(adRequestInfoParcel.zzcbp)) {
                map.put("anchor", adRequestInfoParcel.zzcbp);
            }
            if (adRequestInfoParcel.versionCode >= 13) {
                map.put("android_app_volume", Float.valueOf(adRequestInfoParcel.zzcbq));
            }
            if (adRequestInfoParcel.versionCode >= 18) {
                map.put("android_app_muted", Boolean.valueOf(adRequestInfoParcel.zzcbw));
            }
            if (adRequestInfoParcel.versionCode >= 14 && adRequestInfoParcel.zzcbr > 0) {
                map.put("target_api", Integer.valueOf(adRequestInfoParcel.zzcbr));
            }
            if (adRequestInfoParcel.versionCode >= 15) {
                map.put("scroll_index", Integer.valueOf(adRequestInfoParcel.zzcbs == -1 ? -1 : adRequestInfoParcel.zzcbs));
            }
            if (adRequestInfoParcel.versionCode >= 16) {
                map.put("_activity_context", Boolean.valueOf(adRequestInfoParcel.zzcbt));
            }
            if (adRequestInfoParcel.versionCode >= 18) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.zzcbx)) {
                    try {
                        map.put("app_settings", new JSONObject(adRequestInfoParcel.zzcbx));
                    } catch (JSONException e2) {
                        zzkh.zzd("Problem creating json from app settings", e2);
                    }
                }
                map.put("render_in_browser", Boolean.valueOf(adRequestInfoParcel.zzbnu));
            }
            if (adRequestInfoParcel.versionCode >= 18) {
                map.put("android_num_video_cache_tasks", Integer.valueOf(adRequestInfoParcel.zzcby));
            }
            if (zzkh.zzaz(2)) {
                String strValueOf = String.valueOf(com.google.android.gms.ads.internal.zzu.zzfq().zzam(map).toString(2));
                zzkh.m95v(strValueOf.length() != 0 ? "Ad Request JSON: ".concat(strValueOf) : new String("Ad Request JSON: "));
            }
            return com.google.android.gms.ads.internal.zzu.zzfq().zzam(map);
        } catch (JSONException e3) {
            String strValueOf2 = String.valueOf(e3.getMessage());
            zzkh.zzcy(strValueOf2.length() != 0 ? "Problem serializing ad request to JSON: ".concat(strValueOf2) : new String("Problem serializing ad request to JSON: "));
            return null;
        }
    }

    private static void zza(HashMap<String, Object> map, Location location) {
        HashMap map2 = new HashMap();
        Float fValueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long lValueOf = Long.valueOf(location.getTime() * 1000);
        Long lValueOf2 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long lValueOf3 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        map2.put("radius", fValueOf);
        map2.put("lat", lValueOf2);
        map2.put("long", lValueOf3);
        map2.put("time", lValueOf);
        map.put("uule", map2);
    }

    private static void zza(HashMap<String, Object> map, AdRequestParcel adRequestParcel) {
        String strZzsz = zzkf.zzsz();
        if (strZzsz != null) {
            map.put("abf", strZzsz);
        }
        if (adRequestParcel.zzatk != -1) {
            map.put("cust_age", zzcep.format(new Date(adRequestParcel.zzatk)));
        }
        if (adRequestParcel.extras != null) {
            map.put("extras", adRequestParcel.extras);
        }
        if (adRequestParcel.zzatl != -1) {
            map.put("cust_gender", Integer.valueOf(adRequestParcel.zzatl));
        }
        if (adRequestParcel.zzatm != null) {
            map.put("kw", adRequestParcel.zzatm);
        }
        if (adRequestParcel.zzato != -1) {
            map.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel.zzato));
        }
        if (adRequestParcel.zzatn) {
            map.put("adtest", "on");
        }
        if (adRequestParcel.versionCode >= 2) {
            if (adRequestParcel.zzatp) {
                map.put("d_imp_hdr", 1);
            }
            if (!TextUtils.isEmpty(adRequestParcel.zzatq)) {
                map.put("ppid", adRequestParcel.zzatq);
            }
            if (adRequestParcel.zzatr != null) {
                zza(map, adRequestParcel.zzatr);
            }
        }
        if (adRequestParcel.versionCode >= 3 && adRequestParcel.zzatt != null) {
            map.put("url", adRequestParcel.zzatt);
        }
        if (adRequestParcel.versionCode >= 5) {
            if (adRequestParcel.zzatv != null) {
                map.put("custom_targeting", adRequestParcel.zzatv);
            }
            if (adRequestParcel.zzatw != null) {
                map.put("category_exclusions", adRequestParcel.zzatw);
            }
            if (adRequestParcel.zzatx != null) {
                map.put("request_agent", adRequestParcel.zzatx);
            }
        }
        if (adRequestParcel.versionCode >= 6 && adRequestParcel.zzaty != null) {
            map.put("request_pkg", adRequestParcel.zzaty);
        }
        if (adRequestParcel.versionCode >= 7) {
            map.put("is_designed_for_families", Boolean.valueOf(adRequestParcel.zzatz));
        }
    }

    private static void zza(HashMap<String, Object> map, SearchAdRequestParcel searchAdRequestParcel) {
        String str;
        String str2 = null;
        if (Color.alpha(searchAdRequestParcel.zzawx) != 0) {
            map.put("acolor", zzau(searchAdRequestParcel.zzawx));
        }
        if (Color.alpha(searchAdRequestParcel.backgroundColor) != 0) {
            map.put("bgcolor", zzau(searchAdRequestParcel.backgroundColor));
        }
        if (Color.alpha(searchAdRequestParcel.zzawy) != 0 && Color.alpha(searchAdRequestParcel.zzawz) != 0) {
            map.put("gradientto", zzau(searchAdRequestParcel.zzawy));
            map.put("gradientfrom", zzau(searchAdRequestParcel.zzawz));
        }
        if (Color.alpha(searchAdRequestParcel.zzaxa) != 0) {
            map.put("bcolor", zzau(searchAdRequestParcel.zzaxa));
        }
        map.put("bthick", Integer.toString(searchAdRequestParcel.zzaxb));
        switch (searchAdRequestParcel.zzaxc) {
            case 0:
                str = "none";
                break;
            case 1:
                str = "dashed";
                break;
            case 2:
                str = "dotted";
                break;
            case 3:
                str = "solid";
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            map.put("btype", str);
        }
        switch (searchAdRequestParcel.zzaxd) {
            case 0:
                str2 = "light";
                break;
            case 1:
                str2 = "medium";
                break;
            case 2:
                str2 = "dark";
                break;
        }
        if (str2 != null) {
            map.put("callbuttoncolor", str2);
        }
        if (searchAdRequestParcel.zzaxe != null) {
            map.put("channel", searchAdRequestParcel.zzaxe);
        }
        if (Color.alpha(searchAdRequestParcel.zzaxf) != 0) {
            map.put("dcolor", zzau(searchAdRequestParcel.zzaxf));
        }
        if (searchAdRequestParcel.zzaxg != null) {
            map.put("font", searchAdRequestParcel.zzaxg);
        }
        if (Color.alpha(searchAdRequestParcel.zzaxh) != 0) {
            map.put("hcolor", zzau(searchAdRequestParcel.zzaxh));
        }
        map.put("headersize", Integer.toString(searchAdRequestParcel.zzaxi));
        if (searchAdRequestParcel.zzaxj != null) {
            map.put("q", searchAdRequestParcel.zzaxj);
        }
    }

    private static void zza(HashMap<String, Object> map, zziz zzizVar, zzjd.zza zzaVar, Bundle bundle) {
        map.put("am", Integer.valueOf(zzizVar.zzcgh));
        map.put("cog", zzab(zzizVar.zzcgi));
        map.put("coh", zzab(zzizVar.zzcgj));
        if (!TextUtils.isEmpty(zzizVar.zzcgk)) {
            map.put("carrier", zzizVar.zzcgk);
        }
        map.put("gl", zzizVar.zzcgl);
        if (zzizVar.zzcgm) {
            map.put("simulator", 1);
        }
        if (zzizVar.zzcgn) {
            map.put("is_sidewinder", 1);
        }
        map.put("ma", zzab(zzizVar.zzcgo));
        map.put("sp", zzab(zzizVar.zzcgp));
        map.put("hl", zzizVar.zzcgq);
        if (!TextUtils.isEmpty(zzizVar.zzcgr)) {
            map.put("mv", zzizVar.zzcgr);
        }
        map.put("muv", Integer.valueOf(zzizVar.zzcgs));
        if (zzizVar.zzcgt != -2) {
            map.put("cnt", Integer.valueOf(zzizVar.zzcgt));
        }
        map.put("gnt", Integer.valueOf(zzizVar.zzcgu));
        map.put("pt", Integer.valueOf(zzizVar.zzcgv));
        map.put("rm", Integer.valueOf(zzizVar.zzcgw));
        map.put("riv", Integer.valueOf(zzizVar.zzcgx));
        Bundle bundle2 = new Bundle();
        bundle2.putString("build", zzizVar.zzchc);
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("is_charging", zzizVar.zzcgz);
        bundle3.putDouble("battery_level", zzizVar.zzcgy);
        bundle2.putBundle("battery", bundle3);
        Bundle bundle4 = new Bundle();
        bundle4.putInt("active_network_state", zzizVar.zzchb);
        bundle4.putBoolean("active_network_metered", zzizVar.zzcha);
        if (zzaVar != null) {
            Bundle bundle5 = new Bundle();
            bundle5.putInt("predicted_latency_micros", 0);
            bundle5.putLong("predicted_down_throughput_bps", 0L);
            bundle5.putLong("predicted_up_throughput_bps", 0L);
            bundle4.putBundle("predictions", bundle5);
        }
        bundle2.putBundle("network", bundle4);
        Bundle bundle6 = new Bundle();
        bundle6.putBoolean("is_browser_custom_tabs_capable", zzizVar.zzchd);
        bundle2.putBundle("browser", bundle6);
        if (bundle != null) {
            bundle2.putBundle("android_mem_info", zzf(bundle));
        }
        map.put("device", bundle2);
    }

    private static void zza(HashMap<String, Object> map, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("doritos", str);
        map.put("pii", bundle);
    }

    private static Integer zzab(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String zzau(int i) {
        return String.format(Locale.US, "#%06x", Integer.valueOf(16777215 & i));
    }

    private static String zzc(NativeAdOptionsParcel nativeAdOptionsParcel) {
        switch (nativeAdOptionsParcel != null ? nativeAdOptionsParcel.zzbgu : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    public static JSONObject zzc(AdResponseParcel adResponseParcel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (adResponseParcel.zzbts != null) {
            jSONObject.put("ad_base_url", adResponseParcel.zzbts);
        }
        if (adResponseParcel.zzccf != null) {
            jSONObject.put("ad_size", adResponseParcel.zzccf);
        }
        jSONObject.put("native", adResponseParcel.zzaus);
        if (adResponseParcel.zzaus) {
            jSONObject.put("ad_json", adResponseParcel.body);
        } else {
            jSONObject.put("ad_html", adResponseParcel.body);
        }
        if (adResponseParcel.zzcch != null) {
            jSONObject.put("debug_dialog", adResponseParcel.zzcch);
        }
        if (adResponseParcel.zzccb != -1) {
            jSONObject.put("interstitial_timeout", adResponseParcel.zzccb / 1000.0d);
        }
        if (adResponseParcel.orientation == com.google.android.gms.ads.internal.zzu.zzfs().zztl()) {
            jSONObject.put("orientation", "portrait");
        } else if (adResponseParcel.orientation == com.google.android.gms.ads.internal.zzu.zzfs().zztk()) {
            jSONObject.put("orientation", "landscape");
        }
        if (adResponseParcel.zzbnq != null) {
            jSONObject.put("click_urls", zzk(adResponseParcel.zzbnq));
        }
        if (adResponseParcel.zzbnr != null) {
            jSONObject.put("impression_urls", zzk(adResponseParcel.zzbnr));
        }
        if (adResponseParcel.zzcce != null) {
            jSONObject.put("manual_impression_urls", zzk(adResponseParcel.zzcce));
        }
        if (adResponseParcel.zzcck != null) {
            jSONObject.put("active_view", adResponseParcel.zzcck);
        }
        jSONObject.put("ad_is_javascript", adResponseParcel.zzcci);
        if (adResponseParcel.zzccj != null) {
            jSONObject.put("ad_passback_url", adResponseParcel.zzccj);
        }
        jSONObject.put("mediation", adResponseParcel.zzccc);
        jSONObject.put("custom_render_allowed", adResponseParcel.zzccl);
        jSONObject.put("content_url_opted_out", adResponseParcel.zzccm);
        jSONObject.put("prefetch", adResponseParcel.zzccn);
        if (adResponseParcel.zzbnw != -1) {
            jSONObject.put("refresh_interval_milliseconds", adResponseParcel.zzbnw);
        }
        if (adResponseParcel.zzccd != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", adResponseParcel.zzccd);
        }
        if (!TextUtils.isEmpty(adResponseParcel.zzccq)) {
            jSONObject.put("gws_query_id", adResponseParcel.zzccq);
        }
        jSONObject.put("fluid", adResponseParcel.zzaut ? "height" : "");
        jSONObject.put("native_express", adResponseParcel.zzauu);
        if (adResponseParcel.zzccs != null) {
            jSONObject.put("video_start_urls", zzk(adResponseParcel.zzccs));
        }
        if (adResponseParcel.zzcct != null) {
            jSONObject.put("video_complete_urls", zzk(adResponseParcel.zzcct));
        }
        if (adResponseParcel.zzccr != null) {
            jSONObject.put("rewards", adResponseParcel.zzccr.zzrx());
        }
        jSONObject.put("use_displayed_impression", adResponseParcel.zzccu);
        jSONObject.put("auto_protection_configuration", adResponseParcel.zzccv);
        jSONObject.put("render_in_browser", adResponseParcel.zzbnu);
        return jSONObject;
    }

    private static Bundle zzf(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("runtime_free", Long.toString(bundle.getLong("runtime_free_memory", -1L)));
        bundle2.putString("runtime_max", Long.toString(bundle.getLong("runtime_max_memory", -1L)));
        bundle2.putString("runtime_total", Long.toString(bundle.getLong("runtime_total_memory", -1L)));
        Debug.MemoryInfo memoryInfo = (Debug.MemoryInfo) bundle.getParcelable("debug_memory_info");
        if (memoryInfo != null) {
            bundle2.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
            bundle2.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
            bundle2.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
            bundle2.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
            bundle2.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
            bundle2.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
            bundle2.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
            bundle2.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
            bundle2.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
        }
        return bundle2;
    }

    @Nullable
    static JSONArray zzk(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }
}
