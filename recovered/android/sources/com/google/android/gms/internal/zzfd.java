package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzfd implements zzet {
    private final Map<zzll, Integer> zzbjd = new WeakHashMap();
    private boolean zzbje;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return com.google.android.gms.ads.internal.client.zzm.zziw().zza(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            zzkh.zzcy(new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length()).append("Could not parse ").append(str).append(" in a video GMSG: ").append(str2).toString());
            return i;
        }
    }

    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        int i;
        com.google.android.gms.ads.internal.overlay.zzk zzkVarZzuc;
        String str = map.get("action");
        if (str == null) {
            zzkh.zzcy("Action missing from video GMSG.");
            return;
        }
        if (zzkh.zzaz(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String strValueOf = String.valueOf(jSONObject.toString());
            zzkh.zzcw(new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(strValueOf).length()).append("Video GMSG: ").append(str).append(" ").append(strValueOf).toString());
        }
        if ("background".equals(str)) {
            String str2 = map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzkh.zzcy("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int color = Color.parseColor(str2);
                zzlk zzlkVarZzur = zzllVar.zzur();
                if (zzlkVarZzur == null || (zzkVarZzuc = zzlkVarZzur.zzuc()) == null) {
                    this.zzbjd.put(zzllVar, Integer.valueOf(color));
                } else {
                    zzkVarZzuc.setBackgroundColor(color);
                }
                return;
            } catch (IllegalArgumentException e) {
                zzkh.zzcy("Invalid color parameter in video GMSG.");
                return;
            }
        }
        zzlk zzlkVarZzur2 = zzllVar.zzur();
        if (zzlkVarZzur2 == null) {
            zzkh.zzcy("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean zEquals = "new".equals(str);
        boolean zEquals2 = "position".equals(str);
        if (zEquals || zEquals2) {
            Context context = zzllVar.getContext();
            int iZza = zza(context, map, "x", 0);
            int iZza2 = zza(context, map, "y", 0);
            int iZza3 = zza(context, map, "w", -1);
            int iZza4 = zza(context, map, "h", -1);
            try {
                i = Integer.parseInt(map.get("player"));
            } catch (NumberFormatException e2) {
                i = 0;
            }
            boolean z = Boolean.parseBoolean(map.get("spherical"));
            if (!zEquals || zzlkVarZzur2.zzuc() != null) {
                zzlkVarZzur2.zze(iZza, iZza2, iZza3, iZza4);
                return;
            }
            zzlkVarZzur2.zza(iZza, iZza2, iZza3, iZza4, i, z);
            if (this.zzbjd.containsKey(zzllVar)) {
                zzlkVarZzur2.zzuc().setBackgroundColor(this.zzbjd.get(zzllVar).intValue());
                return;
            }
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzk zzkVarZzuc2 = zzlkVarZzur2.zzuc();
        if (zzkVarZzuc2 == null) {
            com.google.android.gms.ads.internal.overlay.zzk.zzi(zzllVar);
            return;
        }
        if ("click".equals(str)) {
            Context context2 = zzllVar.getContext();
            int iZza5 = zza(context2, map, "x", 0);
            int iZza6 = zza(context2, map, "y", 0);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, iZza5, iZza6, 0);
            zzkVarZzuc2.zzd(motionEventObtain);
            motionEventObtain.recycle();
            return;
        }
        if ("currentTime".equals(str)) {
            String str3 = map.get("time");
            if (str3 == null) {
                zzkh.zzcy("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzkVarZzuc2.seekTo((int) (Float.parseFloat(str3) * 1000.0f));
                return;
            } catch (NumberFormatException e3) {
                String strValueOf2 = String.valueOf(str3);
                zzkh.zzcy(strValueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(strValueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                return;
            }
        }
        if ("hide".equals(str)) {
            zzkVarZzuc2.setVisibility(4);
            return;
        }
        if ("load".equals(str)) {
            zzkVarZzuc2.zzlx();
            return;
        }
        if ("mimetype".equals(str)) {
            zzkVarZzuc2.setMimeType(map.get("mimetype"));
            return;
        }
        if ("muted".equals(str)) {
            if (Boolean.parseBoolean(map.get("muted"))) {
                zzkVarZzuc2.zznq();
                return;
            } else {
                zzkVarZzuc2.zznr();
                return;
            }
        }
        if ("pause".equals(str)) {
            zzkVarZzuc2.pause();
            return;
        }
        if ("play".equals(str)) {
            zzkVarZzuc2.play();
            return;
        }
        if ("show".equals(str)) {
            zzkVarZzuc2.setVisibility(0);
            return;
        }
        if ("src".equals(str)) {
            zzkVarZzuc2.zzbx(map.get("src"));
            return;
        }
        if ("touchMove".equals(str)) {
            Context context3 = zzllVar.getContext();
            zzkVarZzuc2.zza(zza(context3, map, "dx", 0), zza(context3, map, "dy", 0));
            if (this.zzbje) {
                return;
            }
            zzllVar.zzui().zzod();
            this.zzbje = true;
            return;
        }
        if (!"volume".equals(str)) {
            if ("watermark".equals(str)) {
                zzkVarZzuc2.zzop();
                return;
            } else {
                String strValueOf3 = String.valueOf(str);
                zzkh.zzcy(strValueOf3.length() != 0 ? "Unknown video action: ".concat(strValueOf3) : new String("Unknown video action: "));
                return;
            }
        }
        String str4 = map.get("volume");
        if (str4 == null) {
            zzkh.zzcy("Level parameter missing from volume video GMSG.");
            return;
        }
        try {
            zzkVarZzuc2.zza(Float.parseFloat(str4));
        } catch (NumberFormatException e4) {
            String strValueOf4 = String.valueOf(str4);
            zzkh.zzcy(strValueOf4.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(strValueOf4) : new String("Could not parse volume parameter from volume video GMSG: "));
        }
    }
}
