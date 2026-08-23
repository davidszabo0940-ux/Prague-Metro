package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzbw;
import com.google.android.gms.internal.zzbx;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkk;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzt extends com.google.android.gms.ads.internal.client.zzu.zza {
    private final Context mContext;
    private com.google.android.gms.ads.internal.client.zzq zzald;
    private final VersionInfoParcel zzalm;
    private final AdSizeParcel zzang;
    private final Future<zzbw> zzanh = zzfg();
    private final zzb zzani;
    private WebView zzanj;
    private zzbw zzank;
    private AsyncTask<Void, Void, Void> zzanl;

    private class zza extends AsyncTask<Void, Void, Void> {
        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            try {
                zzt.this.zzank = (zzbw) zzt.this.zzanh.get(zzdc.zzbdb.get().longValue(), TimeUnit.MILLISECONDS);
                return null;
            } catch (InterruptedException e) {
                e = e;
                zzkh.zzd("Failed to load ad data", e);
                return null;
            } catch (ExecutionException e2) {
                e = e2;
                zzkh.zzd("Failed to load ad data", e);
                return null;
            } catch (TimeoutException e3) {
                zzkh.zzcy("Timed out waiting for ad data");
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            String strZzfe = zzt.this.zzfe();
            if (zzt.this.zzanj != null) {
                zzt.this.zzanj.loadUrl(strZzfe);
            }
        }
    }

    private static class zzb {
        private final String zzann;
        private final Map<String, String> zzano = new TreeMap();
        private String zzanp;
        private String zzanq;

        public zzb(String str) {
            this.zzann = str;
        }

        public String getQuery() {
            return this.zzanp;
        }

        public String zzfi() {
            return this.zzanq;
        }

        public String zzfj() {
            return this.zzann;
        }

        public Map<String, String> zzfk() {
            return this.zzano;
        }

        public void zzh(AdRequestParcel adRequestParcel) {
            this.zzanp = adRequestParcel.zzatr.zzaxj;
            Bundle bundle = adRequestParcel.zzatu != null ? adRequestParcel.zzatu.getBundle(AdMobAdapter.class.getName()) : null;
            if (bundle == null) {
                return;
            }
            String str = zzdc.zzbda.get();
            for (String str2 : bundle.keySet()) {
                if (str.equals(str2)) {
                    this.zzanq = bundle.getString(str2);
                } else if (str2.startsWith("csa_")) {
                    this.zzano.put(str2.substring("csa_".length()), bundle.getString(str2));
                }
            }
        }
    }

    public zzt(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzalm = versionInfoParcel;
        this.zzang = adSizeParcel;
        this.zzanj = new WebView(this.mContext);
        this.zzani = new zzb(str);
        zzfd();
    }

    private void zzfd() {
        zzj(0);
        this.zzanj.setVerticalScrollBarEnabled(false);
        this.zzanj.getSettings().setJavaScriptEnabled(true);
        this.zzanj.setWebViewClient(new WebViewClient() { // from class: com.google.android.gms.ads.internal.zzt.1
            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (zzt.this.zzald != null) {
                    try {
                        zzt.this.zzald.onAdFailedToLoad(0);
                    } catch (RemoteException e) {
                        zzkh.zzd("Could not call AdListener.onAdFailedToLoad().", e);
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.startsWith(zzt.this.zzff())) {
                    return false;
                }
                if (str.startsWith(zzdc.zzbcw.get())) {
                    if (zzt.this.zzald != null) {
                        try {
                            zzt.this.zzald.onAdFailedToLoad(3);
                        } catch (RemoteException e) {
                            zzkh.zzd("Could not call AdListener.onAdFailedToLoad().", e);
                        }
                    }
                    zzt.this.zzj(0);
                    return true;
                }
                if (str.startsWith(zzdc.zzbcx.get())) {
                    if (zzt.this.zzald != null) {
                        try {
                            zzt.this.zzald.onAdFailedToLoad(0);
                        } catch (RemoteException e2) {
                            zzkh.zzd("Could not call AdListener.onAdFailedToLoad().", e2);
                        }
                    }
                    zzt.this.zzj(0);
                    return true;
                }
                if (str.startsWith(zzdc.zzbcy.get())) {
                    if (zzt.this.zzald != null) {
                        try {
                            zzt.this.zzald.onAdLoaded();
                        } catch (RemoteException e3) {
                            zzkh.zzd("Could not call AdListener.onAdLoaded().", e3);
                        }
                    }
                    zzt.this.zzj(zzt.this.zzw(str));
                    return true;
                }
                if (str.startsWith("gmsg://")) {
                    return true;
                }
                if (zzt.this.zzald != null) {
                    try {
                        zzt.this.zzald.onAdLeftApplication();
                    } catch (RemoteException e4) {
                        zzkh.zzd("Could not call AdListener.onAdLeftApplication().", e4);
                    }
                }
                zzt.this.zzy(zzt.this.zzx(str));
                return true;
            }
        });
        this.zzanj.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.gms.ads.internal.zzt.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (zzt.this.zzank == null) {
                    return false;
                }
                try {
                    zzt.this.zzank.zza(motionEvent);
                    return false;
                } catch (RemoteException e) {
                    zzkh.zzd("Unable to process ad data", e);
                    return false;
                }
            }
        });
    }

    private Future<zzbw> zzfg() {
        return zzkk.zza(new Callable<zzbw>() { // from class: com.google.android.gms.ads.internal.zzt.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: zzfh, reason: merged with bridge method [inline-methods] */
            public zzbw call() throws Exception {
                return new zzbw(zzt.this.zzalm.zzcs, zzt.this.mContext, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zzx(String str) {
        if (this.zzank == null) {
            return str;
        }
        Uri uriZzd = Uri.parse(str);
        try {
            uriZzd = this.zzank.zzd(uriZzd, this.mContext);
        } catch (RemoteException e) {
            zzkh.zzd("Unable to process ad data", e);
        } catch (zzbx e2) {
            zzkh.zzd("Unable to parse ad click url", e2);
        }
        return uriZzd.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzy(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.mContext.startActivity(intent);
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void destroy() throws RemoteException {
        zzab.zzhj("destroy must be called on the main UI thread.");
        this.zzanl.cancel(true);
        this.zzanh.cancel(true);
        this.zzanj.destroy();
        this.zzanj = null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void pause() throws RemoteException {
        zzab.zzhj("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void resume() throws RemoteException {
        zzab.zzhj("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(AdSizeParcel adSizeParcel) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(VideoOptionsParcel videoOptionsParcel) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzp zzpVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        this.zzald = zzqVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzw zzwVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzy zzyVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzdVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzdo zzdoVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzhs zzhsVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzhw zzhwVar, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException {
        zzab.zzb(this.zzanj, "This Search Ad has already been torn down");
        this.zzani.zzh(adRequestParcel);
        this.zzanl = new zza().execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public com.google.android.gms.dynamic.zzd zzdn() throws RemoteException {
        zzab.zzhj("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.zze.zzae(this.zzanj);
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public AdSizeParcel zzdo() throws RemoteException {
        return this.zzang;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zzdq() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public com.google.android.gms.ads.internal.client.zzab zzdr() {
        return null;
    }

    String zzfe() {
        Uri uriZzc;
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzdc.zzbcz.get());
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zzani.getQuery());
        builder.appendQueryParameter("pubId", this.zzani.zzfj());
        Map<String, String> mapZzfk = this.zzani.zzfk();
        for (String str : mapZzfk.keySet()) {
            builder.appendQueryParameter(str, mapZzfk.get(str));
        }
        Uri uriBuild = builder.build();
        if (this.zzank != null) {
            try {
                uriZzc = this.zzank.zzc(uriBuild, this.mContext);
            } catch (RemoteException | zzbx e) {
                zzkh.zzd("Unable to process ad data", e);
                uriZzc = uriBuild;
            }
        } else {
            uriZzc = uriBuild;
        }
        String strValueOf = String.valueOf(zzff());
        String strValueOf2 = String.valueOf(uriZzc.getEncodedQuery());
        return new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length()).append(strValueOf).append("#").append(strValueOf2).toString();
    }

    String zzff() {
        String strZzfi = this.zzani.zzfi();
        String str = TextUtils.isEmpty(strZzfi) ? "www.google.com" : strZzfi;
        String strValueOf = String.valueOf("https://");
        String str2 = zzdc.zzbcz.get();
        return new StringBuilder(String.valueOf(strValueOf).length() + 0 + String.valueOf(str).length() + String.valueOf(str2).length()).append(strValueOf).append(str).append(str2).toString();
    }

    void zzj(int i) {
        if (this.zzanj == null) {
            return;
        }
        this.zzanj.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    }

    int zzw(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            return com.google.android.gms.ads.internal.client.zzm.zziw().zza(this.mContext, Integer.parseInt(queryParameter));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
