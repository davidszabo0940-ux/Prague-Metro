package com.google.android.gms.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zziw {
    private String zzbfm;
    private final AdRequestInfoParcel zzbox;
    private List<String> zzbzj;
    private String zzcex;
    private String zzcey;
    private List<String> zzcez;
    private String zzcfa;
    private String zzcfb;
    private List<String> zzcfc;
    private RewardItemParcel zzcfn;
    private List<String> zzcfo;
    private List<String> zzcfp;
    private AutoClickProtectionConfigurationParcel zzcfr;
    private String zzcft;
    private List<String> zzcfu;
    private String zzcfv;
    private boolean zzcfw;
    private String zzcfx;
    private long zzcfd = -1;
    private boolean zzcfe = false;
    private final long zzcff = -1;
    private long zzcfg = -1;
    private int mOrientation = -1;
    private boolean zzcfh = false;
    private boolean zzcfi = false;
    private boolean zzcfj = false;
    private boolean zzcfk = true;
    private String zzcfl = "";
    private boolean zzcfm = false;
    private boolean zzawl = false;
    private boolean zzcfq = false;
    private boolean zzcfs = false;

    public zziw(AdRequestInfoParcel adRequestInfoParcel) {
        this.zzbox = adRequestInfoParcel;
    }

    private void zzaa(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Gws-Query-Id");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzcfl = list.get(0);
    }

    private void zzab(Map<String, List<String>> map) {
        String strZzd = zzd(map, "X-Afma-Fluid");
        if (strZzd == null || !strZzd.equals("height")) {
            return;
        }
        this.zzcfm = true;
    }

    private void zzac(Map<String, List<String>> map) {
        this.zzawl = "native_express".equals(zzd(map, "X-Afma-Ad-Format"));
    }

    private void zzad(Map<String, List<String>> map) {
        this.zzcfn = RewardItemParcel.zzci(zzd(map, "X-Afma-Rewards"));
    }

    private void zzae(Map<String, List<String>> map) {
        if (this.zzcfo != null) {
            return;
        }
        this.zzcfo = zzf(map, "X-Afma-Reward-Video-Start-Urls");
    }

    private void zzaf(Map<String, List<String>> map) {
        if (this.zzcfp != null) {
            return;
        }
        this.zzcfp = zzf(map, "X-Afma-Reward-Video-Complete-Urls");
    }

    private void zzag(Map<String, List<String>> map) {
        this.zzcfq |= zzg(map, "X-Afma-Use-Displayed-Impression");
    }

    private void zzah(Map<String, List<String>> map) {
        this.zzcfs |= zzg(map, "X-Afma-Auto-Collect-Location");
    }

    private void zzai(Map<String, List<String>> map) {
        List<String> listZzf = zzf(map, "X-Afma-Remote-Ping-Urls");
        if (listZzf != null) {
            this.zzcfu = listZzf;
        }
    }

    private void zzaj(Map<String, List<String>> map) {
        String strZzd = zzd(map, "X-Afma-Auto-Protection-Configuration");
        if (strZzd != null && !TextUtils.isEmpty(strZzd)) {
            try {
                this.zzcfr = AutoClickProtectionConfigurationParcel.zzh(new JSONObject(strZzd));
                return;
            } catch (JSONException e) {
                zzkh.zzd("Error parsing configuration JSON", e);
                this.zzcfr = new AutoClickProtectionConfigurationParcel();
                return;
            }
        }
        Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
        builderBuildUpon.appendQueryParameter("id", "gmob-apps-blocked-navigation");
        if (!TextUtils.isEmpty(this.zzcfa)) {
            builderBuildUpon.appendQueryParameter("debugDialog", this.zzcfa);
        }
        boolean zBooleanValue = zzdc.zzaye.get().booleanValue();
        String strValueOf = String.valueOf(builderBuildUpon.toString());
        String strValueOf2 = String.valueOf("navigationURL");
        this.zzcfr = new AutoClickProtectionConfigurationParcel(zBooleanValue, Arrays.asList(new StringBuilder(String.valueOf(strValueOf).length() + 18 + String.valueOf(strValueOf2).length()).append(strValueOf).append("&").append(strValueOf2).append("={NAVIGATION_URL}").toString()));
    }

    private void zzak(Map<String, List<String>> map) {
        this.zzcft = zzd(map, "Set-Cookie");
    }

    private void zzal(Map<String, List<String>> map) {
        this.zzcfv = zzd(map, "X-Afma-Safe-Browsing");
    }

    static String zzd(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    static long zze(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list != null && !list.isEmpty()) {
            String str2 = list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                zzkh.zzcy(new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length()).append("Could not parse float from ").append(str).append(" header: ").append(str2).toString());
            }
        }
        return -1L;
    }

    static List<String> zzf(Map<String, List<String>> map, String str) {
        String str2;
        List<String> list = map.get(str);
        if (list == null || list.isEmpty() || (str2 = list.get(0)) == null) {
            return null;
        }
        return Arrays.asList(str2.trim().split("\\s+"));
    }

    private boolean zzg(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf(list.get(0)).booleanValue()) ? false : true;
    }

    private void zzk(Map<String, List<String>> map) {
        this.zzcex = zzd(map, "X-Afma-Ad-Size");
    }

    private void zzl(Map<String, List<String>> map) {
        this.zzcfx = zzd(map, "X-Afma-Ad-Slot-Size");
    }

    private void zzm(Map<String, List<String>> map) {
        List<String> listZzf = zzf(map, "X-Afma-Click-Tracking-Urls");
        if (listZzf != null) {
            this.zzcez = listZzf;
        }
    }

    private void zzn(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Debug-Dialog");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzcfa = list.get(0);
    }

    private void zzo(Map<String, List<String>> map) {
        List<String> listZzf = zzf(map, "X-Afma-Tracking-Urls");
        if (listZzf != null) {
            this.zzcfc = listZzf;
        }
    }

    private void zzp(Map<String, List<String>> map) {
        long jZze = zze(map, "X-Afma-Interstitial-Timeout");
        if (jZze != -1) {
            this.zzcfd = jZze;
        }
    }

    private void zzq(Map<String, List<String>> map) {
        this.zzcfb = zzd(map, "X-Afma-ActiveView");
    }

    private void zzr(Map<String, List<String>> map) {
        this.zzcfi = "native".equals(zzd(map, "X-Afma-Ad-Format"));
    }

    private void zzs(Map<String, List<String>> map) {
        this.zzcfh |= zzg(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void zzt(Map<String, List<String>> map) {
        this.zzcfe |= zzg(map, "X-Afma-Mediation");
    }

    private void zzu(Map<String, List<String>> map) {
        this.zzcfw |= zzg(map, "X-Afma-Render-In-Browser");
    }

    private void zzv(Map<String, List<String>> map) {
        List<String> listZzf = zzf(map, "X-Afma-Manual-Tracking-Urls");
        if (listZzf != null) {
            this.zzbzj = listZzf;
        }
    }

    private void zzw(Map<String, List<String>> map) {
        long jZze = zze(map, "X-Afma-Refresh-Rate");
        if (jZze != -1) {
            this.zzcfg = jZze;
        }
    }

    private void zzx(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Orientation");
        if (list == null || list.isEmpty()) {
            return;
        }
        String str = list.get(0);
        if ("portrait".equalsIgnoreCase(str)) {
            this.mOrientation = com.google.android.gms.ads.internal.zzu.zzfs().zztl();
        } else if ("landscape".equalsIgnoreCase(str)) {
            this.mOrientation = com.google.android.gms.ads.internal.zzu.zzfs().zztk();
        }
    }

    private void zzy(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Use-HTTPS");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzcfj = Boolean.valueOf(list.get(0)).booleanValue();
    }

    private void zzz(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Content-Url-Opted-Out");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzcfk = Boolean.valueOf(list.get(0)).booleanValue();
    }

    public void zzb(String str, Map<String, List<String>> map, String str2) {
        this.zzcey = str;
        this.zzbfm = str2;
        zzj(map);
    }

    public AdResponseParcel zzj(long j) {
        return new AdResponseParcel(this.zzbox, this.zzcey, this.zzbfm, this.zzcez, this.zzcfc, this.zzcfd, this.zzcfe, -1L, this.zzbzj, this.zzcfg, this.mOrientation, this.zzcex, j, this.zzcfa, this.zzcfb, this.zzcfh, this.zzcfi, this.zzcfj, this.zzcfk, false, this.zzcfl, this.zzcfm, this.zzawl, this.zzcfn, this.zzcfo, this.zzcfp, this.zzcfq, this.zzcfr, this.zzcfs, this.zzcft, this.zzcfu, this.zzcfv, this.zzcfw, this.zzcfx);
    }

    public void zzj(Map<String, List<String>> map) {
        zzk(map);
        zzl(map);
        zzm(map);
        zzn(map);
        zzo(map);
        zzp(map);
        zzt(map);
        zzv(map);
        zzw(map);
        zzx(map);
        zzq(map);
        zzy(map);
        zzs(map);
        zzr(map);
        zzz(map);
        zzaa(map);
        zzab(map);
        zzac(map);
        zzad(map);
        zzae(map);
        zzaf(map);
        zzag(map);
        zzah(map);
        zzak(map);
        zzaj(map);
        zzai(map);
        zzal(map);
        zzu(map);
    }
}
