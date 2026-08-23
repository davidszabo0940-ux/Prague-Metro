package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzgh implements zzgi.zza {
    private final Context mContext;
    private final zzgn zzajz;
    private final NativeAdOptionsParcel zzali;
    private final List<String> zzalj;
    private final VersionInfoParcel zzalm;
    private AdRequestParcel zzana;
    private final AdSizeParcel zzang;
    private final boolean zzarj;
    private final boolean zzawl;
    private final String zzbog;
    private final long zzboh;
    private final zzge zzboi;
    private final zzgd zzboj;
    private zzgo zzbok;
    private zzgq zzbom;
    private final Object zzail = new Object();
    private int zzbol = -2;

    public zzgh(Context context, String str, zzgn zzgnVar, zzge zzgeVar, zzgd zzgdVar, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, VersionInfoParcel versionInfoParcel, boolean z, boolean z2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
        this.mContext = context;
        this.zzajz = zzgnVar;
        this.zzboj = zzgdVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.zzbog = zzmj();
        } else {
            this.zzbog = str;
        }
        this.zzboi = zzgeVar;
        this.zzboh = zzgeVar.zzbnp != -1 ? zzgeVar.zzbnp : 10000L;
        this.zzana = adRequestParcel;
        this.zzang = adSizeParcel;
        this.zzalm = versionInfoParcel;
        this.zzarj = z;
        this.zzawl = z2;
        this.zzali = nativeAdOptionsParcel;
        this.zzalj = list;
    }

    private long zza(long j, long j2, long j3, long j4) {
        while (this.zzbol == -2) {
            zzb(j, j2, j3, j4);
        }
        return com.google.android.gms.ads.internal.zzu.zzfu().elapsedRealtime() - j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(zzgg zzggVar) {
        if ("com.google.ads.mediation.AdUrlAdapter".equals(this.zzbog)) {
            if (this.zzana.zzatu == null) {
                this.zzana = new com.google.android.gms.ads.internal.client.zzf(this.zzana).zzc(new Bundle()).zzig();
            }
            Bundle bundle = this.zzana.zzatu.getBundle(this.zzbog);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("sdk_less_network_id", this.zzboj.zzbmz);
            this.zzana.zzatu.putBundle(this.zzbog, bundle);
        }
        String strZzbk = zzbk(this.zzboj.zzbng);
        try {
            if (this.zzalm.zzcnp < 4100000) {
                if (this.zzang.zzauq) {
                    this.zzbok.zza(com.google.android.gms.dynamic.zze.zzae(this.mContext), this.zzana, strZzbk, zzggVar);
                } else {
                    this.zzbok.zza(com.google.android.gms.dynamic.zze.zzae(this.mContext), this.zzang, this.zzana, strZzbk, zzggVar);
                }
            } else if (this.zzarj) {
                this.zzbok.zza(com.google.android.gms.dynamic.zze.zzae(this.mContext), this.zzana, strZzbk, this.zzboj.zzbmy, zzggVar, this.zzali, this.zzalj);
            } else if (this.zzang.zzauq) {
                this.zzbok.zza(com.google.android.gms.dynamic.zze.zzae(this.mContext), this.zzana, strZzbk, this.zzboj.zzbmy, zzggVar);
            } else if (!this.zzawl || this.zzboj.zzbnj == null) {
                this.zzbok.zza(com.google.android.gms.dynamic.zze.zzae(this.mContext), this.zzang, this.zzana, strZzbk, this.zzboj.zzbmy, zzggVar);
            } else {
                this.zzbok.zza(com.google.android.gms.dynamic.zze.zzae(this.mContext), this.zzana, strZzbk, this.zzboj.zzbmy, zzggVar, new NativeAdOptionsParcel(zzbl(this.zzboj.zzbnn)), this.zzboj.zzbnm);
            }
        } catch (RemoteException e) {
            zzkh.zzd("Could not request ad from mediation adapter.", e);
            zzy(5);
        }
    }

    private static zzgq zzaa(final int i) {
        return new zzgq.zza() { // from class: com.google.android.gms.internal.zzgh.2
            @Override // com.google.android.gms.internal.zzgq
            public int zzmo() throws RemoteException {
                return i;
            }
        };
    }

    private void zzb(long j, long j2, long j3, long j4) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (jElapsedRealtime - j);
        long j6 = j4 - (jElapsedRealtime - j3);
        if (j5 <= 0 || j6 <= 0) {
            zzkh.zzcx("Timed out waiting for adapter.");
            this.zzbol = 3;
        } else {
            try {
                this.zzail.wait(Math.min(j5, j6));
            } catch (InterruptedException e) {
                this.zzbol = -1;
            }
        }
    }

    private String zzbk(String str) {
        if (str == null || !zzmm() || zzz(2)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.remove("cpm_floor_cents");
            return jSONObject.toString();
        } catch (JSONException e) {
            zzkh.zzcy("Could not remove field. Returning the original value");
            return str;
        }
    }

    private static NativeAdOptions zzbl(String str) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (str == null) {
            return builder.build();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.setRequestMultipleImages(jSONObject.optBoolean("multiple_images", false));
            builder.setReturnUrlsForImageAssets(jSONObject.optBoolean("only_urls", false));
            builder.setImageOrientation(zzbm(jSONObject.optString("native_image_orientation", "any")));
        } catch (JSONException e) {
            zzkh.zzd("Exception occurred when creating native ad options", e);
        }
        return builder.build();
    }

    private static int zzbm(String str) {
        if ("landscape".equals(str)) {
            return 2;
        }
        return "portrait".equals(str) ? 1 : 0;
    }

    private String zzmj() {
        try {
            return (TextUtils.isEmpty(this.zzboj.zzbnc) || !this.zzajz.zzbo(this.zzboj.zzbnc)) ? "com.google.ads.mediation.customevent.CustomEventAdapter" : "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        } catch (RemoteException e) {
            zzkh.zzcy("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private zzgq zzmk() {
        if (this.zzbol != 0 || !zzmm()) {
            return null;
        }
        try {
            if (zzz(4) && this.zzbom != null && this.zzbom.zzmo() != 0) {
                return this.zzbom;
            }
        } catch (RemoteException e) {
            zzkh.zzcy("Could not get cpm value from MediationResponseMetadata");
        }
        return zzaa(zzmn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zzgo zzml() {
        String strValueOf = String.valueOf(this.zzbog);
        zzkh.zzcx(strValueOf.length() != 0 ? "Instantiating mediation adapter: ".concat(strValueOf) : new String("Instantiating mediation adapter: "));
        if (!this.zzarj) {
            if (zzdc.zzbbc.get().booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzbog)) {
                return zza(new AdMobAdapter());
            }
            if (zzdc.zzbbd.get().booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.zzbog)) {
                return zza(new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.zzbog)) {
                return new zzgu(new zzhc());
            }
        }
        try {
            return this.zzajz.zzbn(this.zzbog);
        } catch (RemoteException e) {
            String strValueOf2 = String.valueOf(this.zzbog);
            zzkh.zza(strValueOf2.length() != 0 ? "Could not instantiate mediation adapter: ".concat(strValueOf2) : new String("Could not instantiate mediation adapter: "), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzmm() {
        return this.zzboi.zzbnz != -1;
    }

    private int zzmn() {
        if (this.zzboj.zzbng == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.zzboj.zzbng);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzbog)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int iOptInt = zzz(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return iOptInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : iOptInt;
        } catch (JSONException e) {
            zzkh.zzcy("Could not convert to json. Returning 0");
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzz(int i) {
        Bundle interstitialAdapterInfo;
        try {
            if (this.zzarj) {
                interstitialAdapterInfo = this.zzbok.zzmt();
            } else {
                interstitialAdapterInfo = this.zzang.zzauq ? this.zzbok.getInterstitialAdapterInfo() : this.zzbok.zzms();
            }
            if (interstitialAdapterInfo != null) {
                return (interstitialAdapterInfo.getInt("capabilities", 0) & i) == i;
            }
            return false;
        } catch (RemoteException e) {
            zzkh.zzcy("Could not get adapter info. Returning false");
            return false;
        }
    }

    public void cancel() {
        synchronized (this.zzail) {
            try {
                if (this.zzbok != null) {
                    this.zzbok.destroy();
                }
            } catch (RemoteException e) {
                zzkh.zzd("Could not destroy mediation adapter.", e);
            }
            this.zzbol = -1;
            this.zzail.notify();
        }
    }

    public zzgi zza(long j, long j2) {
        zzgi zzgiVar;
        synchronized (this.zzail) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            final zzgg zzggVar = new zzgg();
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzgh.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzgh.this.zzail) {
                        if (zzgh.this.zzbol != -2) {
                            return;
                        }
                        zzgh.this.zzbok = zzgh.this.zzml();
                        if (zzgh.this.zzbok == null) {
                            zzgh.this.zzy(4);
                            return;
                        }
                        if (!zzgh.this.zzmm() || zzgh.this.zzz(1)) {
                            zzggVar.zza(zzgh.this);
                            zzgh.this.zza(zzggVar);
                        } else {
                            String str = zzgh.this.zzbog;
                            zzkh.zzcy(new StringBuilder(String.valueOf(str).length() + 56).append("Ignoring adapter ").append(str).append(" as delayed impression is not supported").toString());
                            zzgh.this.zzy(2);
                        }
                    }
                }
            });
            zzgiVar = new zzgi(this.zzboj, this.zzbok, this.zzbog, zzggVar, this.zzbol, zzmk(), zza(jElapsedRealtime, this.zzboh, j, j2));
        }
        return zzgiVar;
    }

    protected zzgo zza(MediationAdapter mediationAdapter) {
        return new zzgu(mediationAdapter);
    }

    @Override // com.google.android.gms.internal.zzgi.zza
    public void zza(int i, zzgq zzgqVar) {
        synchronized (this.zzail) {
            this.zzbol = i;
            this.zzbom = zzgqVar;
            this.zzail.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzgi.zza
    public void zzy(int i) {
        synchronized (this.zzail) {
            this.zzbol = i;
            this.zzail.notify();
        }
    }
}
