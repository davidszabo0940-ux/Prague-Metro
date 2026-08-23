package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzlo extends FrameLayout implements zzll {
    private final zzll zzcpd;
    private final zzlk zzcpe;

    public zzlo(zzll zzllVar) {
        super(zzllVar.getContext());
        this.zzcpd = zzllVar;
        this.zzcpe = new zzlk(zzllVar.zzug(), this, this);
        zzlm zzlmVarZzuk = this.zzcpd.zzuk();
        if (zzlmVarZzuk != null) {
            zzlmVarZzuk.zzm(this);
        }
        addView(this.zzcpd.getView());
    }

    @Override // com.google.android.gms.internal.zzll
    public void destroy() {
        this.zzcpd.destroy();
    }

    @Override // com.google.android.gms.internal.zzll
    public String getRequestId() {
        return this.zzcpd.getRequestId();
    }

    @Override // com.google.android.gms.internal.zzll
    public int getRequestedOrientation() {
        return this.zzcpd.getRequestedOrientation();
    }

    @Override // com.google.android.gms.internal.zzll
    public View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.zzll
    public WebView getWebView() {
        return this.zzcpd.getWebView();
    }

    @Override // com.google.android.gms.internal.zzll
    public boolean isDestroyed() {
        return this.zzcpd.isDestroyed();
    }

    @Override // com.google.android.gms.internal.zzll
    public void loadData(String str, String str2, String str3) {
        this.zzcpd.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.zzll
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzcpd.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.zzll
    public void loadUrl(String str) {
        this.zzcpd.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.zzll
    public void onPause() {
        this.zzcpe.onPause();
        this.zzcpd.onPause();
    }

    @Override // com.google.android.gms.internal.zzll
    public void onResume() {
        this.zzcpd.onResume();
    }

    @Override // android.view.View, com.google.android.gms.internal.zzll
    public void setBackgroundColor(int i) {
        this.zzcpd.setBackgroundColor(i);
    }

    @Override // com.google.android.gms.internal.zzll
    public void setContext(Context context) {
        this.zzcpd.setContext(context);
    }

    @Override // android.view.View, com.google.android.gms.internal.zzll
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzcpd.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.zzll
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzcpd.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.zzll
    public void setRequestedOrientation(int i) {
        this.zzcpd.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.internal.zzll
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzcpd.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.zzll
    public void setWebViewClient(WebViewClient webViewClient) {
        this.zzcpd.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.zzll
    public void stopLoading() {
        this.zzcpd.stopLoading();
    }

    @Override // com.google.android.gms.internal.zzll
    public void zza(Context context, AdSizeParcel adSizeParcel, zzdk zzdkVar) {
        this.zzcpe.onDestroy();
        this.zzcpd.zza(context, adSizeParcel, zzdkVar);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zza(AdSizeParcel adSizeParcel) {
        this.zzcpd.zza(adSizeParcel);
    }

    @Override // com.google.android.gms.internal.zzce
    public void zza(zzcd zzcdVar, boolean z) {
        this.zzcpd.zza(zzcdVar, z);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zza(zzlq zzlqVar) {
        this.zzcpd.zza(zzlqVar);
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zza(String str, zzet zzetVar) {
        this.zzcpd.zza(str, zzetVar);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zza(String str, Map<String, ?> map) {
        this.zzcpd.zza(str, map);
    }

    @Override // com.google.android.gms.internal.zzll, com.google.android.gms.internal.zzfx
    public void zza(String str, JSONObject jSONObject) {
        this.zzcpd.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzaf(int i) {
        this.zzcpd.zzaf(i);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzah(boolean z) {
        this.zzcpd.zzah(z);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzai(boolean z) {
        this.zzcpd.zzai(z);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzaj(boolean z) {
        this.zzcpd.zzaj(z);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.zzcpd.zzb(zzdVar);
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zzb(String str, zzet zzetVar) {
        this.zzcpd.zzb(str, zzetVar);
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zzb(String str, JSONObject jSONObject) {
        this.zzcpd.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzc(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.zzcpd.zzc(zzdVar);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzcz(String str) {
        this.zzcpd.zzcz(str);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzda(String str) {
        this.zzcpd.zzda(str);
    }

    @Override // com.google.android.gms.internal.zzll
    public AdSizeParcel zzdo() {
        return this.zzcpd.zzdo();
    }

    @Override // com.google.android.gms.ads.internal.zzs
    public void zzeg() {
        this.zzcpd.zzeg();
    }

    @Override // com.google.android.gms.ads.internal.zzs
    public void zzeh() {
        this.zzcpd.zzeh();
    }

    @Override // com.google.android.gms.internal.zzll, com.google.android.gms.internal.zzfx
    public void zzj(String str, String str2) {
        this.zzcpd.zzj(str, str2);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzoc() {
        this.zzcpd.zzoc();
    }

    @Override // com.google.android.gms.internal.zzll
    public boolean zzow() {
        return this.zzcpd.zzow();
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzud() {
        this.zzcpd.zzud();
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzue() {
        this.zzcpd.zzue();
    }

    @Override // com.google.android.gms.internal.zzll
    public Activity zzuf() {
        return this.zzcpd.zzuf();
    }

    @Override // com.google.android.gms.internal.zzll
    public Context zzug() {
        return this.zzcpd.zzug();
    }

    @Override // com.google.android.gms.internal.zzll
    public com.google.android.gms.ads.internal.zzd zzuh() {
        return this.zzcpd.zzuh();
    }

    @Override // com.google.android.gms.internal.zzll
    public com.google.android.gms.ads.internal.overlay.zzd zzui() {
        return this.zzcpd.zzui();
    }

    @Override // com.google.android.gms.internal.zzll
    public com.google.android.gms.ads.internal.overlay.zzd zzuj() {
        return this.zzcpd.zzuj();
    }

    @Override // com.google.android.gms.internal.zzll
    public zzlm zzuk() {
        return this.zzcpd.zzuk();
    }

    @Override // com.google.android.gms.internal.zzll
    public boolean zzul() {
        return this.zzcpd.zzul();
    }

    @Override // com.google.android.gms.internal.zzll
    public zzas zzum() {
        return this.zzcpd.zzum();
    }

    @Override // com.google.android.gms.internal.zzll
    public VersionInfoParcel zzun() {
        return this.zzcpd.zzun();
    }

    @Override // com.google.android.gms.internal.zzll
    public boolean zzuo() {
        return this.zzcpd.zzuo();
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzup() {
        this.zzcpe.onDestroy();
        this.zzcpd.zzup();
    }

    @Override // com.google.android.gms.internal.zzll
    public boolean zzuq() {
        return this.zzcpd.zzuq();
    }

    @Override // com.google.android.gms.internal.zzll
    public zzlk zzur() {
        return this.zzcpe;
    }

    @Override // com.google.android.gms.internal.zzll
    public zzdi zzus() {
        return this.zzcpd.zzus();
    }

    @Override // com.google.android.gms.internal.zzll
    public zzdj zzut() {
        return this.zzcpd.zzut();
    }

    @Override // com.google.android.gms.internal.zzll
    public zzlq zzuu() {
        return this.zzcpd.zzuu();
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzuv() {
        this.zzcpd.zzuv();
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzuw() {
        this.zzcpd.zzuw();
    }

    @Override // com.google.android.gms.internal.zzll
    public View.OnClickListener zzux() {
        return this.zzcpd.zzux();
    }
}
