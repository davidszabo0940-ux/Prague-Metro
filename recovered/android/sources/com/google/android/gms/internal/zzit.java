package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzit extends com.google.android.gms.ads.internal.request.zzk.zza {
    private static final Object zzamp = new Object();
    private static zzit zzceb;
    private final Context mContext;
    private final zzis zzcec;
    private final zzcv zzced;
    private final zzfw zzcee;

    zzit(Context context, zzcv zzcvVar, zzis zzisVar) {
        this.mContext = context;
        this.zzcec = zzisVar;
        this.zzced = zzcvVar;
        this.zzcee = new zzfw(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(9256208, 9256208, true), zzcvVar.zzjv(), new zzkp<zzft>() { // from class: com.google.android.gms.internal.zzit.4
            @Override // com.google.android.gms.internal.zzkp
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zzd(zzft zzftVar) {
                zzftVar.zza("/log", zzer.zzbhz);
            }
        }, new zzfw.zzb());
    }

    private static AdResponseParcel zza(final Context context, final zzfw zzfwVar, zzcv zzcvVar, final zzis zzisVar, final AdRequestInfoParcel adRequestInfoParcel) {
        Bundle bundle;
        zzlc zzlcVarZza;
        String string;
        zzkh.zzcw("Starting ad request from service using: AFMA_getAd");
        zzdc.initialize(context);
        final zzdk zzdkVar = new zzdk(zzdc.zzazc.get().booleanValue(), "load_ad", adRequestInfoParcel.zzaoy.zzaup);
        if (adRequestInfoParcel.versionCode > 10 && adRequestInfoParcel.zzcbn != -1) {
            zzdkVar.zza(zzdkVar.zzc(adRequestInfoParcel.zzcbn), "cts");
        }
        zzdi zzdiVarZzkg = zzdkVar.zzkg();
        final Bundle bundle2 = (adRequestInfoParcel.versionCode < 4 || adRequestInfoParcel.zzcbc == null) ? null : adRequestInfoParcel.zzcbc;
        if (!zzdc.zzazl.get().booleanValue() || zzisVar.zzcea == null) {
            bundle = bundle2;
            zzlcVarZza = null;
        } else {
            if (bundle2 == null && zzdc.zzazm.get().booleanValue()) {
                zzkh.m95v("contentInfo is not present, but we'll still launch the app index task");
                bundle2 = new Bundle();
            }
            if (bundle2 != null) {
                bundle = bundle2;
                zzlcVarZza = zzkk.zza(new Callable<Void>() { // from class: com.google.android.gms.internal.zzit.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: zzcy, reason: merged with bridge method [inline-methods] */
                    public Void call() throws Exception {
                        zzisVar.zzcea.zza(context, adRequestInfoParcel.zzcaw.packageName, bundle2);
                        return null;
                    }
                });
            } else {
                bundle = bundle2;
                zzlcVarZza = null;
            }
        }
        zzla zzlaVar = new zzla(null);
        Bundle bundle3 = adRequestInfoParcel.zzcav.extras;
        zzlc<Location> zzlcVarZza2 = (!adRequestInfoParcel.zzcbu || (bundle3 != null && bundle3.getString("_ad") != null)) ? zzlaVar : zzisVar.zzcdw.zza(adRequestInfoParcel.applicationInfo);
        zziz zzizVarZzy = com.google.android.gms.ads.internal.zzu.zzfw().zzy(context);
        if (zzizVarZzy.zzcgt == -1) {
            zzkh.zzcw("Device is offline.");
            return new AdResponseParcel(2);
        }
        String string2 = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzcbk : UUID.randomUUID().toString();
        final zziv zzivVar = new zziv(string2, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzcav.extras != null && (string = adRequestInfoParcel.zzcav.extras.getString("_ad")) != null) {
            return zziu.zza(context, adRequestInfoParcel, string);
        }
        List<String> listZza = zzisVar.zzcdu.zza(adRequestInfoParcel);
        String strZzf = zzisVar.zzcdx.zzf(adRequestInfoParcel);
        zzjd.zza zzaVarZzz = zzisVar.zzcdy.zzz(context);
        if (zzlcVarZza != null) {
            try {
                zzkh.m95v("Waiting for app index fetching task.");
                zzlcVarZza.get(zzdc.zzazn.get().longValue(), TimeUnit.MILLISECONDS);
                zzkh.m95v("App index fetching task completed.");
            } catch (InterruptedException e) {
                e = e;
                zzkh.zzd("Failed to fetch app index signal", e);
            } catch (ExecutionException e2) {
                e = e2;
                zzkh.zzd("Failed to fetch app index signal", e);
            } catch (TimeoutException e3) {
                zzkh.zzcw("Timed out waiting for app index fetching task");
            }
        }
        String strZzcl = zzisVar.zzcdt.zzcl(adRequestInfoParcel.zzcaw.packageName);
        JSONObject jSONObjectZza = zziu.zza(context, adRequestInfoParcel, zzizVarZzy, zzaVarZzz, zzb(zzlcVarZza2), zzcvVar, strZzf, listZza, bundle, strZzcl);
        if (jSONObjectZza == null) {
            return new AdResponseParcel(0);
        }
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                jSONObjectZza.put("request_id", string2);
            } catch (JSONException e4) {
            }
        }
        try {
            jSONObjectZza.put("prefetch_mode", "url");
        } catch (JSONException e5) {
            zzkh.zzd("Failed putting prefetch parameters to ad request.", e5);
        }
        final String string3 = jSONObjectZza.toString();
        zzdkVar.zza(zzdiVarZzkg, "arc");
        final zzdi zzdiVarZzkg2 = zzdkVar.zzkg();
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzit.2
            @Override // java.lang.Runnable
            public void run() {
                zzfw.zzc zzcVarZzmc = zzfwVar.zzmc();
                zzivVar.zzb(zzcVarZzmc);
                zzdkVar.zza(zzdiVarZzkg2, "rwc");
                final zzdi zzdiVarZzkg3 = zzdkVar.zzkg();
                zzcVarZzmc.zza(new zzle.zzc<zzfx>() { // from class: com.google.android.gms.internal.zzit.2.1
                    @Override // com.google.android.gms.internal.zzle.zzc
                    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
                    public void zzd(zzfx zzfxVar) {
                        zzdkVar.zza(zzdiVarZzkg3, "jsf");
                        zzdkVar.zzkh();
                        zzfxVar.zza("/invalidRequest", zzivVar.zzcet);
                        zzfxVar.zza("/loadAdURL", zzivVar.zzceu);
                        zzfxVar.zza("/loadAd", zzivVar.zzcev);
                        try {
                            zzfxVar.zzj("AFMA_getAd", string3);
                        } catch (Exception e6) {
                            zzkh.zzb("Error requesting an ad url", e6);
                        }
                    }
                }, new zzle.zza() { // from class: com.google.android.gms.internal.zzit.2.2
                    @Override // com.google.android.gms.internal.zzle.zza
                    public void run() {
                    }
                });
            }
        });
        try {
            zziy zziyVar = zzivVar.zzri().get(10L, TimeUnit.SECONDS);
            if (zziyVar == null) {
                return new AdResponseParcel(0);
            }
            if (zziyVar.getErrorCode() != -2) {
                return new AdResponseParcel(zziyVar.getErrorCode());
            }
            if (zzdkVar.zzkj() != null) {
                zzdkVar.zza(zzdkVar.zzkj(), "rur");
            }
            AdResponseParcel adResponseParcelZza = TextUtils.isEmpty(zziyVar.zzrn()) ? null : zziu.zza(context, adRequestInfoParcel, zziyVar.zzrn());
            if (adResponseParcelZza == null && !TextUtils.isEmpty(zziyVar.getUrl())) {
                adResponseParcelZza = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzaou.zzcs, zziyVar.getUrl(), strZzcl, zziyVar, zzdkVar, zzisVar);
            }
            if (adResponseParcelZza == null) {
                adResponseParcelZza = new AdResponseParcel(0);
            }
            zzdkVar.zza(zzdiVarZzkg, "tts");
            adResponseParcelZza.zzccp = zzdkVar.zzki();
            return adResponseParcelZza;
        } catch (Exception e6) {
            return new AdResponseParcel(0);
        } finally {
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzit.3
                @Override // java.lang.Runnable
                public void run() {
                    zzisVar.zzcdv.zza(context, zzivVar, adRequestInfoParcel.zzaou);
                }
            });
        }
    }

    public static AdResponseParcel zza(AdRequestInfoParcel adRequestInfoParcel, Context context, String str, String str2, String str3, zziy zziyVar, zzdk zzdkVar, zzis zzisVar) {
        HttpURLConnection httpURLConnection;
        int responseCode;
        InputStreamReader inputStreamReader;
        BufferedOutputStream bufferedOutputStream;
        zzdi zzdiVarZzkg = zzdkVar != null ? zzdkVar.zzkg() : null;
        try {
            zziw zziwVar = new zziw(adRequestInfoParcel);
            String strValueOf = String.valueOf(str2);
            zzkh.zzcw(strValueOf.length() != 0 ? "AdRequestServiceImpl: Sending request: ".concat(strValueOf) : new String("AdRequestServiceImpl: Sending request: "));
            URL url = new URL(str2);
            long jElapsedRealtime = com.google.android.gms.ads.internal.zzu.zzfu().elapsedRealtime();
            int i = 0;
            URL url2 = url;
            while (true) {
                if (zzisVar != null) {
                    zzisVar.zzcdz.zzrp();
                }
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                try {
                    com.google.android.gms.ads.internal.zzu.zzfq().zza(context, str, false, httpURLConnection);
                    if (!TextUtils.isEmpty(str3) && zziyVar.zzrm()) {
                        httpURLConnection.addRequestProperty("x-afma-drt-cookie", str3);
                    }
                    String str4 = adRequestInfoParcel.zzcbv;
                    if (!TextUtils.isEmpty(str4)) {
                        zzkh.zzcw("Sending webview cookie in ad request header.");
                        httpURLConnection.addRequestProperty("Cookie", str4);
                    }
                    if (zziyVar != null && !TextUtils.isEmpty(zziyVar.zzrl())) {
                        httpURLConnection.setDoOutput(true);
                        byte[] bytes = zziyVar.zzrl().getBytes();
                        httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            try {
                                bufferedOutputStream.write(bytes);
                                com.google.android.gms.common.util.zzo.zzb(bufferedOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                com.google.android.gms.common.util.zzo.zzb(bufferedOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedOutputStream = null;
                        }
                    }
                    responseCode = httpURLConnection.getResponseCode();
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    if (responseCode < 200 || responseCode >= 300) {
                        zza(url2.toString(), headerFields, null, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            break;
                        }
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (TextUtils.isEmpty(headerField)) {
                            zzkh.zzcy("No location header to follow redirect.");
                            AdResponseParcel adResponseParcel = new AdResponseParcel(0);
                            httpURLConnection.disconnect();
                            if (zzisVar != null) {
                                zzisVar.zzcdz.zzrq();
                            }
                            return adResponseParcel;
                        }
                        URL url3 = new URL(headerField);
                        int i2 = i + 1;
                        if (i2 > 5) {
                            zzkh.zzcy("Too many redirects.");
                            AdResponseParcel adResponseParcel2 = new AdResponseParcel(0);
                            httpURLConnection.disconnect();
                            if (zzisVar != null) {
                                zzisVar.zzcdz.zzrq();
                            }
                            return adResponseParcel2;
                        }
                        zziwVar.zzj(headerFields);
                        httpURLConnection.disconnect();
                        if (zzisVar != null) {
                            zzisVar.zzcdz.zzrq();
                        }
                        i = i2;
                        url2 = url3;
                    } else {
                        String string = url2.toString();
                        try {
                            inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                            try {
                                String strZza = com.google.android.gms.ads.internal.zzu.zzfq().zza(inputStreamReader);
                                com.google.android.gms.common.util.zzo.zzb(inputStreamReader);
                                zza(string, headerFields, strZza, responseCode);
                                zziwVar.zzb(string, headerFields, strZza);
                                if (zzdkVar != null) {
                                    zzdkVar.zza(zzdiVarZzkg, "ufe");
                                }
                                AdResponseParcel adResponseParcelZzj = zziwVar.zzj(jElapsedRealtime);
                                httpURLConnection.disconnect();
                                if (zzisVar != null) {
                                    zzisVar.zzcdz.zzrq();
                                }
                                return adResponseParcelZzj;
                            } catch (Throwable th3) {
                                th = th3;
                                com.google.android.gms.common.util.zzo.zzb(inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            inputStreamReader = null;
                        }
                    }
                } catch (Throwable th5) {
                    httpURLConnection.disconnect();
                    if (zzisVar != null) {
                        zzisVar.zzcdz.zzrq();
                    }
                    throw th5;
                }
            }
            zzkh.zzcy(new StringBuilder(46).append("Received error HTTP response code: ").append(responseCode).toString());
            AdResponseParcel adResponseParcel3 = new AdResponseParcel(0);
            httpURLConnection.disconnect();
            if (zzisVar != null) {
                zzisVar.zzcdz.zzrq();
            }
            return adResponseParcel3;
        } catch (IOException e) {
            String strValueOf2 = String.valueOf(e.getMessage());
            zzkh.zzcy(strValueOf2.length() != 0 ? "Error while connecting to ad server: ".concat(strValueOf2) : new String("Error while connecting to ad server: "));
            return new AdResponseParcel(2);
        }
    }

    public static zzit zza(Context context, zzcv zzcvVar, zzis zzisVar) {
        zzit zzitVar;
        synchronized (zzamp) {
            if (zzceb == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzceb = new zzit(context, zzcvVar, zzisVar);
            }
            zzitVar = zzceb;
        }
        return zzitVar;
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzkh.zzaz(2)) {
            zzkh.m95v(new StringBuilder(String.valueOf(str).length() + 39).append("Http Response: {\n  URL:\n    ").append(str).append("\n  Headers:").toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    zzkh.m95v(new StringBuilder(String.valueOf(str3).length() + 5).append("    ").append(str3).append(":").toString());
                    Iterator<String> it = map.get(str3).iterator();
                    while (it.hasNext()) {
                        String strValueOf = String.valueOf(it.next());
                        zzkh.m95v(strValueOf.length() != 0 ? "      ".concat(strValueOf) : new String("      "));
                    }
                }
            }
            zzkh.m95v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    zzkh.m95v(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                zzkh.m95v("    null");
            }
            zzkh.m95v(new StringBuilder(34).append("  Response Code:\n    ").append(i).append("\n}").toString());
        }
    }

    private static Location zzb(zzlc<Location> zzlcVar) {
        try {
            return zzlcVar.get(zzdc.zzbcn.get().longValue(), TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            zzkh.zzd("Exception caught while getting location", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzk
    public void zza(final AdRequestInfoParcel adRequestInfoParcel, final com.google.android.gms.ads.internal.request.zzl zzlVar) {
        com.google.android.gms.ads.internal.zzu.zzft().zzb(this.mContext, adRequestInfoParcel.zzaou);
        zzkk.zza(new Runnable() { // from class: com.google.android.gms.internal.zzit.5
            @Override // java.lang.Runnable
            public void run() {
                AdResponseParcel adResponseParcel;
                try {
                    adResponseParcel = zzit.this.zzd(adRequestInfoParcel);
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.zzu.zzft().zzb((Throwable) e, true);
                    zzkh.zzd("Could not fetch ad response due to an Exception.", e);
                    adResponseParcel = null;
                }
                if (adResponseParcel == null) {
                    adResponseParcel = new AdResponseParcel(0);
                }
                try {
                    zzlVar.zzb(adResponseParcel);
                } catch (RemoteException e2) {
                    zzkh.zzd("Fail to forward ad response.", e2);
                }
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.request.zzk
    public AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) {
        return zza(this.mContext, this.zzcee, this.zzced, this.zzcec, adRequestInfoParcel);
    }
}
