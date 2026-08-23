package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzey;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkp;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzll;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzn extends zzkg {
    private final Context mContext;
    private final Object zzbxy;
    private final com.google.android.gms.ads.internal.request.zza.InterfaceC0730zza zzcai;
    private final AdRequestInfoParcel.zza zzcaj;
    private zzfw.zzc zzcdo;
    static final long zzcdj = TimeUnit.SECONDS.toMillis(10);
    private static final Object zzamp = new Object();
    static boolean zzcdk = false;
    private static zzfw zzbyz = null;
    private static zzeu zzcdl = null;
    private static zzey zzcdm = null;
    private static zzet zzcdn = null;

    public static class zza implements zzkp<zzft> {
        @Override // com.google.android.gms.internal.zzkp
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzd(zzft zzftVar) {
            zzn.zzc(zzftVar);
        }
    }

    public static class zzb implements zzkp<zzft> {
        @Override // com.google.android.gms.internal.zzkp
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzd(zzft zzftVar) {
            zzn.zzb(zzftVar);
        }
    }

    public static class zzc implements zzet {
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            String str = map.get("request_id");
            String strValueOf = String.valueOf(map.get("errors"));
            zzkh.zzcy(strValueOf.length() != 0 ? "Invalid request: ".concat(strValueOf) : new String("Invalid request: "));
            zzn.zzcdm.zzay(str);
        }
    }

    public zzn(Context context, AdRequestInfoParcel.zza zzaVar, com.google.android.gms.ads.internal.request.zza.InterfaceC0730zza interfaceC0730zza) {
        super(true);
        this.zzbxy = new Object();
        this.zzcai = interfaceC0730zza;
        this.mContext = context;
        this.zzcaj = zzaVar;
        synchronized (zzamp) {
            if (!zzcdk) {
                zzcdm = new zzey();
                zzcdl = new zzeu(context.getApplicationContext(), zzaVar.zzaou);
                zzcdn = new zzc();
                zzbyz = new zzfw(this.mContext.getApplicationContext(), this.zzcaj.zzaou, zzdc.zzaxw.get(), new zzb(), new zza());
                zzcdk = true;
            }
        }
    }

    private JSONObject zza(AdRequestInfoParcel adRequestInfoParcel, String str) {
        JSONObject jSONObjectZza;
        AdvertisingIdClient.Info advertisingIdInfo;
        Bundle bundle = adRequestInfoParcel.zzcav.extras.getBundle("sdk_less_server_data");
        String string = adRequestInfoParcel.zzcav.extras.getString("sdk_less_network_id");
        if (bundle == null || (jSONObjectZza = zziu.zza(this.mContext, adRequestInfoParcel, zzu.zzfw().zzy(this.mContext), null, null, new zzcv(zzdc.zzaxw.get()), null, new ArrayList(), null, null)) == null) {
            return null;
        }
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzkh.zzd("Cannot get advertising id info", e);
            advertisingIdInfo = null;
        }
        HashMap map = new HashMap();
        map.put("request_id", str);
        map.put("network_id", string);
        map.put("request_param", jSONObjectZza);
        map.put("data", bundle);
        if (advertisingIdInfo != null) {
            map.put("adid", advertisingIdInfo.getId());
            map.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 1 : 0));
        }
        try {
            return zzu.zzfq().zzam(map);
        } catch (JSONException e2) {
            return null;
        }
    }

    protected static void zzb(zzft zzftVar) {
        zzftVar.zza("/loadAd", zzcdm);
        zzftVar.zza("/fetchHttpRequest", zzcdl);
        zzftVar.zza("/invalidRequest", zzcdn);
    }

    protected static void zzc(zzft zzftVar) {
        zzftVar.zzb("/loadAd", zzcdm);
        zzftVar.zzb("/fetchHttpRequest", zzcdl);
        zzftVar.zzb("/invalidRequest", zzcdn);
    }

    private AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        final String strZztf = zzu.zzfq().zztf();
        final JSONObject jSONObjectZza = zza(adRequestInfoParcel, strZztf);
        if (jSONObjectZza == null) {
            return new AdResponseParcel(0);
        }
        long jElapsedRealtime = zzu.zzfu().elapsedRealtime();
        Future<JSONObject> futureZzax = zzcdm.zzax(strZztf);
        com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.ads.internal.request.zzn.2
            @Override // java.lang.Runnable
            public void run() {
                zzn.this.zzcdo = zzn.zzbyz.zzmc();
                zzn.this.zzcdo.zza(new zzle.zzc<zzfx>() { // from class: com.google.android.gms.ads.internal.request.zzn.2.1
                    @Override // com.google.android.gms.internal.zzle.zzc
                    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
                    public void zzd(zzfx zzfxVar) {
                        try {
                            zzfxVar.zza("AFMA_getAdapterLessMediationAd", jSONObjectZza);
                        } catch (Exception e) {
                            zzkh.zzb("Error requesting an ad url", e);
                            zzn.zzcdm.zzay(strZztf);
                        }
                    }
                }, new zzle.zza() { // from class: com.google.android.gms.ads.internal.request.zzn.2.2
                    @Override // com.google.android.gms.internal.zzle.zza
                    public void run() {
                        zzn.zzcdm.zzay(strZztf);
                    }
                });
            }
        });
        try {
            JSONObject jSONObject = futureZzax.get(zzcdj - (zzu.zzfu().elapsedRealtime() - jElapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new AdResponseParcel(-1);
            }
            AdResponseParcel adResponseParcelZza = zziu.zza(this.mContext, adRequestInfoParcel, jSONObject.toString());
            return (adResponseParcelZza.errorCode == -3 || !TextUtils.isEmpty(adResponseParcelZza.body)) ? adResponseParcelZza : new AdResponseParcel(3);
        } catch (InterruptedException e) {
            return new AdResponseParcel(-1);
        } catch (CancellationException e2) {
            return new AdResponseParcel(-1);
        } catch (ExecutionException e3) {
            return new AdResponseParcel(0);
        } catch (TimeoutException e4) {
            return new AdResponseParcel(2);
        }
    }

    @Override // com.google.android.gms.internal.zzkg
    public void onStop() {
        synchronized (this.zzbxy) {
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.ads.internal.request.zzn.3
                @Override // java.lang.Runnable
                public void run() {
                    if (zzn.this.zzcdo != null) {
                        zzn.this.zzcdo.release();
                        zzn.this.zzcdo = null;
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zzew() {
        zzkh.zzcw("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.zzcaj, null, -1L);
        AdResponseParcel adResponseParcelZze = zze(adRequestInfoParcel);
        final zzjy.zza zzaVar = new zzjy.zza(adRequestInfoParcel, adResponseParcelZze, null, null, adResponseParcelZze.errorCode, zzu.zzfu().elapsedRealtime(), adResponseParcelZze.zzccg, null);
        com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.ads.internal.request.zzn.1
            @Override // java.lang.Runnable
            public void run() {
                zzn.this.zzcai.zza(zzaVar);
                if (zzn.this.zzcdo != null) {
                    zzn.this.zzcdo.release();
                    zzn.this.zzcdo = null;
                }
            }
        });
    }
}
