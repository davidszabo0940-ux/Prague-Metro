package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzeq implements zzet {
    private void zzb(zzll zzllVar, Map<String, String> map) {
        String str = map.get("label");
        String str2 = map.get("start_label");
        String str3 = map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            zzkh.zzcy("No label given for CSI tick.");
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            zzkh.zzcy("No timestamp given for CSI tick.");
            return;
        }
        try {
            long jZzd = zzd(Long.parseLong(str3));
            if (TextUtils.isEmpty(str2)) {
                str2 = "native:view_load";
            }
            zzllVar.zzut().zza(str, str2, jZzd);
        } catch (NumberFormatException e) {
            zzkh.zzd("Malformed timestamp for CSI tick.", e);
        }
    }

    private void zzc(zzll zzllVar, Map<String, String> map) {
        String str = map.get("value");
        if (TextUtils.isEmpty(str)) {
            zzkh.zzcy("No value given for CSI experiment.");
            return;
        }
        zzdk zzdkVarZzkf = zzllVar.zzut().zzkf();
        if (zzdkVarZzkf == null) {
            zzkh.zzcy("No ticker for WebView, dropping experiment ID.");
        } else {
            zzdkVarZzkf.zzh("e", str);
        }
    }

    private long zzd(long j) {
        return (j - com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis()) + com.google.android.gms.ads.internal.zzu.zzfu().elapsedRealtime();
    }

    private void zzd(zzll zzllVar, Map<String, String> map) {
        String str = map.get("name");
        String str2 = map.get("value");
        if (TextUtils.isEmpty(str2)) {
            zzkh.zzcy("No value given for CSI extra.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            zzkh.zzcy("No name given for CSI extra.");
            return;
        }
        zzdk zzdkVarZzkf = zzllVar.zzut().zzkf();
        if (zzdkVarZzkf == null) {
            zzkh.zzcy("No ticker for WebView, dropping extra parameter.");
        } else {
            zzdkVarZzkf.zzh(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        String str = map.get("action");
        if ("tick".equals(str)) {
            zzb(zzllVar, map);
        } else if ("experiment".equals(str)) {
            zzc(zzllVar, map);
        } else if ("extra".equals(str)) {
            zzd(zzllVar, map);
        }
    }
}
