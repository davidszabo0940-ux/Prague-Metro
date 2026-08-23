package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzll;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzg {
    private Context mContext;
    private final Object zzail = new Object();
    public final zzet zzaks = new zzet() { // from class: com.google.android.gms.ads.internal.zzg.1
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            zzllVar.zzb("/appSettingsFetched", this);
            synchronized (zzg.this.zzail) {
                if (map != null) {
                    if ("true".equalsIgnoreCase(map.get("isSuccessful"))) {
                        zzu.zzft().zze(zzg.this.mContext, map.get("appSettingsJson"));
                    }
                }
            }
        }
    };

    private static boolean zza(@Nullable zzka zzkaVar) {
        if (zzkaVar == null) {
            return true;
        }
        return (((zzu.zzfu().currentTimeMillis() - zzkaVar.zzsf()) > zzdc.zzbct.get().longValue() ? 1 : ((zzu.zzfu().currentTimeMillis() - zzkaVar.zzsf()) == zzdc.zzbct.get().longValue() ? 0 : -1)) > 0) || !zzkaVar.zzsg();
    }

    public void zza(final Context context, VersionInfoParcel versionInfoParcel, final boolean z, @Nullable zzka zzkaVar, final String str, @Nullable final String str2) {
        if (zza(zzkaVar)) {
            if (context == null) {
                zzkh.zzcy("Context not provided to fetch application settings");
                return;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                zzkh.zzcy("App settings could not be fetched. Required parameters missing");
                return;
            }
            this.mContext = context;
            final zzfw zzfwVarZzc = zzu.zzfq().zzc(context, versionInfoParcel);
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzg.2
                @Override // java.lang.Runnable
                public void run() {
                    zzfwVarZzc.zzmc().zza(new zzle.zzc<zzfx>() { // from class: com.google.android.gms.ads.internal.zzg.2.1
                        @Override // com.google.android.gms.internal.zzle.zzc
                        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
                        public void zzd(zzfx zzfxVar) {
                            zzfxVar.zza("/appSettingsFetched", zzg.this.zzaks);
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (!TextUtils.isEmpty(str)) {
                                    jSONObject.put("app_id", str);
                                } else if (!TextUtils.isEmpty(str2)) {
                                    jSONObject.put("ad_unit_id", str2);
                                }
                                jSONObject.put("is_init", z);
                                jSONObject.put("pn", context.getPackageName());
                                zzfxVar.zza("AFMA_fetchAppSettings", jSONObject);
                            } catch (Exception e) {
                                zzfxVar.zzb("/appSettingsFetched", zzg.this.zzaks);
                                zzkh.zzb("Error requesting application settings", e);
                            }
                        }
                    }, new zzle.zzb());
                }
            });
        }
    }
}
