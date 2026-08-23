package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzlf;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzb extends zzkg implements zzc.zza {
    private final Context mContext;
    private final zzas zzbgh;
    zzge zzboi;
    private AdRequestInfoParcel zzbox;
    AdResponseParcel zzbxw;
    private Runnable zzbxx;
    private final Object zzbxy = new Object();
    private final com.google.android.gms.ads.internal.request.zza.InterfaceC0730zza zzcai;
    private final AdRequestInfoParcel.zza zzcaj;
    zzkn zzcak;

    @zzir
    static final class zza extends Exception {
        private final int zzbym;

        public zza(String str, int i) {
            super(str);
            this.zzbym = i;
        }

        public int getErrorCode() {
            return this.zzbym;
        }
    }

    public zzb(Context context, AdRequestInfoParcel.zza zzaVar, zzas zzasVar, com.google.android.gms.ads.internal.request.zza.InterfaceC0730zza interfaceC0730zza) {
        this.zzcai = interfaceC0730zza;
        this.mContext = context;
        this.zzcaj = zzaVar;
        this.zzbgh = zzasVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzd(int i, String str) {
        if (i == 3 || i == -1) {
            zzkh.zzcx(str);
        } else {
            zzkh.zzcy(str);
        }
        if (this.zzbxw == null) {
            this.zzbxw = new AdResponseParcel(i);
        } else {
            this.zzbxw = new AdResponseParcel(i, this.zzbxw.zzbnw);
        }
        this.zzcai.zza(new zzjy.zza(this.zzbox != null ? this.zzbox : new AdRequestInfoParcel(this.zzcaj, null, -1L), this.zzbxw, this.zzboi, null, i, -1L, this.zzbxw.zzccg, null));
    }

    @Override // com.google.android.gms.internal.zzkg
    public void onStop() {
        synchronized (this.zzbxy) {
            if (this.zzcak != null) {
                this.zzcak.cancel();
            }
        }
    }

    zzkn zza(VersionInfoParcel versionInfoParcel, zzle<AdRequestInfoParcel> zzleVar) {
        return zzc.zza(this.mContext, versionInfoParcel, zzleVar, this);
    }

    protected AdSizeParcel zzb(AdRequestInfoParcel adRequestInfoParcel) throws zza {
        if (this.zzbxw.zzccf == null) {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] strArrSplit = this.zzbxw.zzccf.split("x");
        if (strArrSplit.length != 2) {
            String strValueOf = String.valueOf(this.zzbxw.zzccf);
            throw new zza(strValueOf.length() != 0 ? "Invalid ad size format from the ad response: ".concat(strValueOf) : new String("Invalid ad size format from the ad response: "), 0);
        }
        try {
            int i = Integer.parseInt(strArrSplit[0]);
            int i2 = Integer.parseInt(strArrSplit[1]);
            for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzaoy.zzaur) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i3 = adSizeParcel.width == -1 ? (int) (adSizeParcel.widthPixels / f) : adSizeParcel.width;
                int i4 = adSizeParcel.height == -2 ? (int) (adSizeParcel.heightPixels / f) : adSizeParcel.height;
                if (i == i3 && i2 == i4) {
                    return new AdSizeParcel(adSizeParcel, adRequestInfoParcel.zzaoy.zzaur);
                }
            }
            String strValueOf2 = String.valueOf(this.zzbxw.zzccf);
            throw new zza(strValueOf2.length() != 0 ? "The ad size from the ad response was not one of the requested sizes: ".concat(strValueOf2) : new String("The ad size from the ad response was not one of the requested sizes: "), 0);
        } catch (NumberFormatException e) {
            String strValueOf3 = String.valueOf(this.zzbxw.zzccf);
            throw new zza(strValueOf3.length() != 0 ? "Invalid ad size number from the ad response: ".concat(strValueOf3) : new String("Invalid ad size number from the ad response: "), 0);
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzc.zza
    public void zzb(@NonNull AdResponseParcel adResponseParcel) {
        JSONObject jSONObject;
        zzkh.zzcw("Received ad response.");
        this.zzbxw = adResponseParcel;
        long jElapsedRealtime = zzu.zzfu().elapsedRealtime();
        synchronized (this.zzbxy) {
            this.zzcak = null;
        }
        zzu.zzft().zzd(this.mContext, this.zzbxw.zzcbu);
        try {
            if (this.zzbxw.errorCode != -2 && this.zzbxw.errorCode != -3) {
                throw new zza(new StringBuilder(66).append("There was a problem getting an ad response. ErrorCode: ").append(this.zzbxw.errorCode).toString(), this.zzbxw.errorCode);
            }
            zzqw();
            AdSizeParcel adSizeParcelZzb = this.zzbox.zzaoy.zzaur != null ? zzb(this.zzbox) : null;
            zzu.zzft().zzae(this.zzbxw.zzccm);
            if (TextUtils.isEmpty(this.zzbxw.zzcck)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject(this.zzbxw.zzcck);
                } catch (Exception e) {
                    zzkh.zzb("Error parsing the JSON for Active View.", e);
                    jSONObject = null;
                }
            }
            this.zzcai.zza(new zzjy.zza(this.zzbox, this.zzbxw, this.zzboi, adSizeParcelZzb, -2, jElapsedRealtime, this.zzbxw.zzccg, jSONObject));
            zzkl.zzclg.removeCallbacks(this.zzbxx);
        } catch (zza e2) {
            zzd(e2.getErrorCode(), e2.getMessage());
            zzkl.zzclg.removeCallbacks(this.zzbxx);
        }
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zzew() {
        zzkh.zzcw("AdLoaderBackgroundTask started.");
        this.zzbxx = new Runnable() { // from class: com.google.android.gms.ads.internal.request.zzb.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (zzb.this.zzbxy) {
                    if (zzb.this.zzcak == null) {
                        return;
                    }
                    zzb.this.onStop();
                    zzb.this.zzd(2, "Timed out waiting for ad response.");
                }
            }
        };
        zzkl.zzclg.postDelayed(this.zzbxx, zzdc.zzbbe.get().longValue());
        final zzlf zzlfVar = new zzlf();
        long jElapsedRealtime = zzu.zzfu().elapsedRealtime();
        zzkk.zza(new Runnable() { // from class: com.google.android.gms.ads.internal.request.zzb.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (zzb.this.zzbxy) {
                    zzb.this.zzcak = zzb.this.zza(zzb.this.zzcaj.zzaou, zzlfVar);
                    if (zzb.this.zzcak == null) {
                        zzb.this.zzd(0, "Could not start the ad request service.");
                        zzkl.zzclg.removeCallbacks(zzb.this.zzbxx);
                    }
                }
            }
        });
        this.zzbox = new AdRequestInfoParcel(this.zzcaj, this.zzbgh.zzax().zzb(this.mContext), jElapsedRealtime);
        zzlfVar.zzg(this.zzbox);
    }

    protected void zzqw() throws zza {
        if (this.zzbxw.errorCode == -3) {
            return;
        }
        if (TextUtils.isEmpty(this.zzbxw.body)) {
            throw new zza("No fill from ad server.", 3);
        }
        zzu.zzft().zzc(this.mContext, this.zzbxw.zzcbd);
        if (this.zzbxw.zzccc) {
            try {
                this.zzboi = new zzge(this.zzbxw.body);
                zzu.zzft().zzaf(this.zzboi.zzbnu);
            } catch (JSONException e) {
                zzkh.zzb("Could not parse mediation config.", e);
                String strValueOf = String.valueOf(this.zzbxw.body);
                throw new zza(strValueOf.length() != 0 ? "Could not parse mediation config: ".concat(strValueOf) : new String("Could not parse mediation config: "), 0);
            }
        } else {
            zzu.zzft().zzaf(this.zzbxw.zzbnu);
        }
        if (TextUtils.isEmpty(this.zzbxw.zzcbv) || !zzdc.zzbdl.get().booleanValue()) {
            return;
        }
        zzkh.zzcw("Received cookie from server. Setting webview cookie in CookieManager.");
        CookieManager cookieManagerZzao = zzu.zzfs().zzao(this.mContext);
        if (cookieManagerZzao != null) {
            cookieManagerZzao.setCookie("googleads.g.doubleclick.net", this.zzbxw.zzcbv);
        }
    }
}
