package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public interface zzll extends com.google.android.gms.ads.internal.zzs, zzce, zzfx {
    void destroy();

    Context getContext();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    String getRequestId();

    int getRequestedOrientation();

    View getView();

    WebView getWebView();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setContext(Context context);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    void zza(Context context, AdSizeParcel adSizeParcel, zzdk zzdkVar);

    void zza(AdSizeParcel adSizeParcel);

    void zza(zzlq zzlqVar);

    void zza(String str, Map<String, ?> map);

    @Override // com.google.android.gms.internal.zzfx
    void zza(String str, JSONObject jSONObject);

    void zzaf(int i);

    void zzah(boolean z);

    void zzai(boolean z);

    void zzaj(boolean z);

    void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar);

    void zzc(com.google.android.gms.ads.internal.overlay.zzd zzdVar);

    void zzcz(String str);

    void zzda(String str);

    AdSizeParcel zzdo();

    @Override // com.google.android.gms.internal.zzfx
    void zzj(String str, String str2);

    void zzoc();

    boolean zzow();

    void zzud();

    void zzue();

    Activity zzuf();

    Context zzug();

    com.google.android.gms.ads.internal.zzd zzuh();

    com.google.android.gms.ads.internal.overlay.zzd zzui();

    com.google.android.gms.ads.internal.overlay.zzd zzuj();

    zzlm zzuk();

    boolean zzul();

    zzas zzum();

    VersionInfoParcel zzun();

    boolean zzuo();

    void zzup();

    boolean zzuq();

    @Nullable
    zzlk zzur();

    @Nullable
    zzdi zzus();

    zzdj zzut();

    @Nullable
    zzlq zzuu();

    void zzuv();

    void zzuw();

    View.OnClickListener zzux();
}
