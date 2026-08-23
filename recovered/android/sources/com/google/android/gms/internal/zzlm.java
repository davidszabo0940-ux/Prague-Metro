package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzlm extends WebViewClient {
    private static final String[] zzcon = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzcoo = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private final Object zzail;
    private boolean zzari;
    private com.google.android.gms.ads.internal.client.zza zzati;
    protected zzll zzbgj;
    private zzeo zzbhq;
    private zzex zzbiv;
    private com.google.android.gms.ads.internal.zze zzbix;
    private zzhe zzbiy;
    private zzev zzbja;
    private zzhk zzbqr;
    private zza zzbye;
    private final HashMap<String, List<zzet>> zzcop;
    private com.google.android.gms.ads.internal.overlay.zzg zzcoq;
    private zzb zzcor;
    private boolean zzcos;
    private boolean zzcot;
    private com.google.android.gms.ads.internal.overlay.zzp zzcou;
    private final zzhi zzcov;

    @Nullable
    protected zzjs zzcow;
    private boolean zzcox;
    private boolean zzcoy;
    private boolean zzcoz;
    private int zzcpa;

    public interface zza {
        void zza(zzll zzllVar, boolean z);
    }

    public interface zzb {
        void zzen();
    }

    private static class zzc implements com.google.android.gms.ads.internal.overlay.zzg {
        private com.google.android.gms.ads.internal.overlay.zzg zzcoq;
        private zzll zzcpc;

        public zzc(zzll zzllVar, com.google.android.gms.ads.internal.overlay.zzg zzgVar) {
            this.zzcpc = zzllVar;
            this.zzcoq = zzgVar;
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzg
        public void onPause() {
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzg
        public void onResume() {
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzg
        public void zzdy() {
            this.zzcoq.zzdy();
            this.zzcpc.zzud();
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzg
        public void zzdz() {
            this.zzcoq.zzdz();
            this.zzcpc.zzoc();
        }
    }

    private class zzd implements zzet {
        private zzd() {
        }

        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zzlm.this.zzvc();
            } else if (map.keySet().contains("stop")) {
                zzlm.this.zzvd();
            } else if (map.keySet().contains("cancel")) {
                zzlm.this.zzve();
            }
        }
    }

    public zzlm(zzll zzllVar, boolean z) {
        this(zzllVar, z, new zzhi(zzllVar, zzllVar.zzug(), new zzcu(zzllVar.getContext())), null);
    }

    zzlm(zzll zzllVar, boolean z, zzhi zzhiVar, zzhe zzheVar) {
        this.zzcop = new HashMap<>();
        this.zzail = new Object();
        this.zzcos = false;
        this.zzbgj = zzllVar;
        this.zzari = z;
        this.zzcov = zzhiVar;
        this.zzbiy = zzheVar;
    }

    private void zza(Context context, String str, String str2, String str3) {
        if (zzdc.zzbat.get().booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            bundle.putString("host", zzdb(str3));
            com.google.android.gms.ads.internal.zzu.zzfq().zza(context, this.zzbgj.zzun().zzcs, "gmob-apps", bundle, true);
        }
    }

    private String zzdb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri uri = Uri.parse(str);
        return uri.getHost() != null ? uri.getHost() : "";
    }

    private static boolean zzh(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzvc() {
        synchronized (this.zzail) {
            this.zzcot = true;
        }
        this.zzcpa++;
        zzvf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzvd() {
        this.zzcpa--;
        zzvf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzve() {
        this.zzcoz = true;
        zzvf();
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String strValueOf = String.valueOf(str);
        zzkh.m95v(strValueOf.length() != 0 ? "Loading resource: ".concat(strValueOf) : new String("Loading resource: "));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzi(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzail) {
            if (this.zzcox) {
                zzkh.m95v("Blank page loaded, 1...");
                this.zzbgj.zzup();
            } else {
                this.zzcoy = true;
                zzvf();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        zza(this.zzbgj.getContext(), "http_err", (i >= 0 || (-i) + (-1) >= zzcon.length) ? String.valueOf(i) : zzcon[(-i) - 1], str2);
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            zza(this.zzbgj.getContext(), "ssl_err", (primaryError < 0 || primaryError >= zzcoo.length) ? String.valueOf(primaryError) : zzcoo[primaryError], com.google.android.gms.ads.internal.zzu.zzfs().zza(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final void reset() {
        if (this.zzcow != null) {
            this.zzcow.zzry();
            this.zzcow = null;
        }
        synchronized (this.zzail) {
            this.zzcop.clear();
            this.zzati = null;
            this.zzcoq = null;
            this.zzbye = null;
            this.zzbhq = null;
            this.zzcos = false;
            this.zzari = false;
            this.zzcot = false;
            this.zzbja = null;
            this.zzcou = null;
            this.zzcor = null;
            if (this.zzbiy != null) {
                this.zzbiy.zzs(true);
                this.zzbiy = null;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case TransportMediator.KEYCODE_MEDIA_PLAY /* 126 */:
            case TransportMediator.KEYCODE_MEDIA_PAUSE /* 127 */:
            case 128:
            case 129:
            case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
            case 222:
                return true;
            default:
                return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri uri;
        String strValueOf = String.valueOf(str);
        zzkh.m95v(strValueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(strValueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uriZzb = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriZzb.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZzb.getHost())) {
            zzi(uriZzb);
        } else {
            if (this.zzcos && webView == this.zzbgj.getWebView() && zzh(uriZzb)) {
                if (this.zzati != null && zzdc.zzazs.get().booleanValue()) {
                    this.zzati.onAdClicked();
                    if (this.zzcow != null) {
                        this.zzcow.zzcj(str);
                    }
                    this.zzati = null;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (this.zzbgj.getWebView().willNotDraw()) {
                String strValueOf2 = String.valueOf(str);
                zzkh.zzcy(strValueOf2.length() != 0 ? "AdWebView unable to handle URL: ".concat(strValueOf2) : new String("AdWebView unable to handle URL: "));
            } else {
                try {
                    zzas zzasVarZzum = this.zzbgj.zzum();
                    if (zzasVarZzum != null && zzasVarZzum.zzc(uriZzb)) {
                        uriZzb = zzasVarZzum.zzb(uriZzb, this.zzbgj.getContext());
                    }
                    uri = uriZzb;
                } catch (zzat e) {
                    String strValueOf3 = String.valueOf(str);
                    zzkh.zzcy(strValueOf3.length() != 0 ? "Unable to append parameter to URL: ".concat(strValueOf3) : new String("Unable to append parameter to URL: "));
                    uri = uriZzb;
                }
                if (this.zzbix == null || this.zzbix.zzem()) {
                    zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
                } else {
                    this.zzbix.zzt(str);
                }
            }
        }
        return true;
    }

    public void zza(int i, int i2, boolean z) {
        this.zzcov.zze(i, i2);
        if (this.zzbiy != null) {
            this.zzbiy.zza(i, i2, z);
        }
    }

    public void zza(com.google.android.gms.ads.internal.client.zza zzaVar, com.google.android.gms.ads.internal.overlay.zzg zzgVar, zzeo zzeoVar, com.google.android.gms.ads.internal.overlay.zzp zzpVar, boolean z, zzev zzevVar, @Nullable zzex zzexVar, com.google.android.gms.ads.internal.zze zzeVar, zzhk zzhkVar, zzjs zzjsVar) {
        if (zzeVar == null) {
            zzeVar = new com.google.android.gms.ads.internal.zze(this.zzbgj.getContext());
        }
        this.zzbiy = new zzhe(this.zzbgj, zzhkVar);
        this.zzcow = zzjsVar;
        zza("/appEvent", new zzen(zzeoVar));
        zza("/backButton", zzer.zzbib);
        zza("/refresh", zzer.zzbic);
        zza("/canOpenURLs", zzer.zzbhs);
        zza("/canOpenIntents", zzer.zzbht);
        zza("/click", zzer.zzbhu);
        zza("/close", zzer.zzbhv);
        zza("/customClose", zzer.zzbhx);
        zza("/instrument", zzer.zzbig);
        zza("/delayPageLoaded", new zzd());
        zza("/httpTrack", zzer.zzbhy);
        zza("/log", zzer.zzbhz);
        zza("/mraid", new zzez(zzeVar, this.zzbiy));
        zza("/mraidLoaded", this.zzcov);
        zza("/open", new zzfa(zzevVar, zzeVar, this.zzbiy));
        zza("/precache", zzer.zzbif);
        zza("/touch", zzer.zzbia);
        zza("/video", zzer.zzbid);
        zza("/videoMeta", zzer.zzbie);
        zza("/appStreaming", zzer.zzbhw);
        if (zzexVar != null) {
            zza("/setInterstitialProperties", new zzew(zzexVar));
        }
        this.zzati = zzaVar;
        this.zzcoq = zzgVar;
        this.zzbhq = zzeoVar;
        this.zzbja = zzevVar;
        this.zzcou = zzpVar;
        this.zzbix = zzeVar;
        this.zzbqr = zzhkVar;
        this.zzbiv = zzexVar;
        zzak(z);
    }

    public final void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        boolean zZzuo = this.zzbgj.zzuo();
        zza(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, (!zZzuo || this.zzbgj.zzdo().zzauq) ? this.zzati : null, zZzuo ? null : this.zzcoq, this.zzcou, this.zzbgj.zzun()));
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.zzu.zzfo().zza(this.zzbgj.getContext(), adOverlayInfoParcel, this.zzbiy != null ? this.zzbiy.zzmy() : false ? false : true);
        if (this.zzcow != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzbtn != null) {
                str = adOverlayInfoParcel.zzbtn.url;
            }
            this.zzcow.zzcj(str);
        }
    }

    public void zza(zza zzaVar) {
        this.zzbye = zzaVar;
    }

    public void zza(zzb zzbVar) {
        this.zzcor = zzbVar;
    }

    public void zza(String str, zzet zzetVar) {
        synchronized (this.zzail) {
            List<zzet> copyOnWriteArrayList = this.zzcop.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.zzcop.put(str, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(zzetVar);
        }
    }

    public final void zza(boolean z, int i) {
        zza(new AdOverlayInfoParcel((!this.zzbgj.zzuo() || this.zzbgj.zzdo().zzauq) ? this.zzati : null, this.zzcoq, this.zzcou, this.zzbgj, z, i, this.zzbgj.zzun()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zZzuo = this.zzbgj.zzuo();
        zza(new AdOverlayInfoParcel((!zZzuo || this.zzbgj.zzdo().zzauq) ? this.zzati : null, zZzuo ? null : new zzc(this.zzbgj, this.zzcoq), this.zzbhq, this.zzcou, this.zzbgj, z, i, str, this.zzbgj.zzun(), this.zzbja));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zZzuo = this.zzbgj.zzuo();
        zza(new AdOverlayInfoParcel((!zZzuo || this.zzbgj.zzdo().zzauq) ? this.zzati : null, zZzuo ? null : new zzc(this.zzbgj, this.zzcoq), this.zzbhq, this.zzcou, this.zzbgj, z, i, str, str2, this.zzbgj.zzun(), this.zzbja));
    }

    public void zzak(boolean z) {
        this.zzcos = z;
    }

    public void zzb(String str, zzet zzetVar) {
        synchronized (this.zzail) {
            List<zzet> list = this.zzcop.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzetVar);
        }
    }

    public void zzd(int i, int i2) {
        if (this.zzbiy != null) {
            this.zzbiy.zzd(i, i2);
        }
    }

    public boolean zzho() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzari;
        }
        return z;
    }

    public void zzi(Uri uri) {
        String path = uri.getPath();
        List<zzet> list = this.zzcop.get(path);
        if (list == null) {
            String strValueOf = String.valueOf(uri);
            zzkh.m95v(new StringBuilder(String.valueOf(strValueOf).length() + 32).append("No GMSG handler found for GMSG: ").append(strValueOf).toString());
            return;
        }
        Map<String, String> mapZzf = com.google.android.gms.ads.internal.zzu.zzfq().zzf(uri);
        if (zzkh.zzaz(2)) {
            String strValueOf2 = String.valueOf(path);
            zzkh.m95v(strValueOf2.length() != 0 ? "Received GMSG: ".concat(strValueOf2) : new String("Received GMSG: "));
            for (String str : mapZzf.keySet()) {
                String str2 = mapZzf.get(str);
                zzkh.m95v(new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length()).append("  ").append(str).append(": ").append(str2).toString());
            }
        }
        Iterator<zzet> it = list.iterator();
        while (it.hasNext()) {
            it.next().zza(this.zzbgj, mapZzf);
        }
    }

    public void zzm(zzll zzllVar) {
        this.zzbgj = zzllVar;
    }

    public final void zznz() {
        synchronized (this.zzail) {
            this.zzcos = false;
            this.zzari = true;
            com.google.android.gms.ads.internal.zzu.zzfq().runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzlm.2
                @Override // java.lang.Runnable
                public void run() {
                    zzlm.this.zzbgj.zzuv();
                    com.google.android.gms.ads.internal.overlay.zzd zzdVarZzui = zzlm.this.zzbgj.zzui();
                    if (zzdVarZzui != null) {
                        zzdVarZzui.zznz();
                    }
                    if (zzlm.this.zzcor != null) {
                        zzlm.this.zzcor.zzen();
                        zzlm.this.zzcor = null;
                    }
                }
            });
        }
    }

    public com.google.android.gms.ads.internal.zze zzuy() {
        return this.zzbix;
    }

    public boolean zzuz() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzcot;
        }
        return z;
    }

    public void zzva() {
        synchronized (this.zzail) {
            zzkh.m95v("Loading blank page in WebView, 2...");
            this.zzcox = true;
            this.zzbgj.zzcz("about:blank");
        }
    }

    public void zzvb() {
        if (this.zzcow != null) {
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzlm.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zzlm.this.zzcow != null) {
                        zzlm.this.zzcow.zzj(zzlm.this.zzbgj.getView());
                    }
                }
            });
        }
    }

    public final void zzvf() {
        if (this.zzbye != null && ((this.zzcoy && this.zzcpa <= 0) || this.zzcoz)) {
            this.zzbye.zza(this.zzbgj, !this.zzcoz);
            this.zzbye = null;
        }
        this.zzbgj.zzuw();
    }
}
