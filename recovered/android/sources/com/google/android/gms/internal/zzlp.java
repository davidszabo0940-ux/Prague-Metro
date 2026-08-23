package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzlp extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzll {
    private final Object zzail;
    private final com.google.android.gms.ads.internal.zzd zzajv;
    private final VersionInfoParcel zzalm;
    private AdSizeParcel zzang;
    private zzky zzaqe;
    private final WindowManager zzaqk;
    private final zzas zzbgh;
    private int zzbrj;
    private int zzbrk;
    private int zzbrm;
    private int zzbrn;
    private String zzbvu;
    private Boolean zzcka;
    private final zza zzcpf;
    private final com.google.android.gms.ads.internal.zzs zzcpg;
    private zzlm zzcph;
    private com.google.android.gms.ads.internal.overlay.zzd zzcpi;
    private boolean zzcpj;
    private boolean zzcpk;
    private boolean zzcpl;
    private boolean zzcpm;
    private int zzcpn;
    private boolean zzcpo;
    boolean zzcpp;
    private zzlq zzcpq;
    private boolean zzcpr;
    private zzdi zzcps;
    private zzdi zzcpt;
    private zzdi zzcpu;
    private zzdj zzcpv;
    private WeakReference<View.OnClickListener> zzcpw;
    private com.google.android.gms.ads.internal.overlay.zzd zzcpx;
    private Map<String, zzfh> zzcpy;

    @zzir
    public static class zza extends MutableContextWrapper {
        private Context zzaqj;
        private Activity zzcmz;
        private Context zzcqa;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return this.zzcqa.getSystemService(str);
        }

        @Override // android.content.MutableContextWrapper
        public void setBaseContext(Context context) {
            this.zzaqj = context.getApplicationContext();
            this.zzcmz = context instanceof Activity ? (Activity) context : null;
            this.zzcqa = context;
            super.setBaseContext(this.zzaqj);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public void startActivity(Intent intent) {
            if (this.zzcmz != null) {
                this.zzcmz.startActivity(intent);
            } else {
                intent.setFlags(268435456);
                this.zzaqj.startActivity(intent);
            }
        }

        public Activity zzuf() {
            return this.zzcmz;
        }

        public Context zzug() {
            return this.zzcqa;
        }
    }

    protected zzlp(zza zzaVar, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzas zzasVar, VersionInfoParcel versionInfoParcel, zzdk zzdkVar, com.google.android.gms.ads.internal.zzs zzsVar, com.google.android.gms.ads.internal.zzd zzdVar) {
        super(zzaVar);
        this.zzail = new Object();
        this.zzcpo = true;
        this.zzcpp = false;
        this.zzbvu = "";
        this.zzbrk = -1;
        this.zzbrj = -1;
        this.zzbrm = -1;
        this.zzbrn = -1;
        this.zzcpf = zzaVar;
        this.zzang = adSizeParcel;
        this.zzcpl = z;
        this.zzcpn = -1;
        this.zzbgh = zzasVar;
        this.zzalm = versionInfoParcel;
        this.zzcpg = zzsVar;
        this.zzajv = zzdVar;
        this.zzaqk = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        com.google.android.gms.ads.internal.zzu.zzfq().zza(zzaVar, versionInfoParcel.zzcs, settings);
        com.google.android.gms.ads.internal.zzu.zzfs().zza(getContext(), settings);
        setDownloadListener(this);
        zzvj();
        if (com.google.android.gms.common.util.zzs.zzavo()) {
            addJavascriptInterface(new zzlr(this), "googleAdsJsInterface");
        }
        if (com.google.android.gms.common.util.zzs.zzavj()) {
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        this.zzaqe = new zzky(this.zzcpf.zzuf(), this, this, null);
        zzd(zzdkVar);
    }

    private void zzal(boolean z) {
        HashMap map = new HashMap();
        map.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", map);
    }

    static zzlp zzb(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzas zzasVar, VersionInfoParcel versionInfoParcel, zzdk zzdkVar, com.google.android.gms.ads.internal.zzs zzsVar, com.google.android.gms.ads.internal.zzd zzdVar) {
        return new zzlp(new zza(context), adSizeParcel, z, z2, zzasVar, versionInfoParcel, zzdkVar, zzsVar, zzdVar);
    }

    private void zzd(zzdk zzdkVar) {
        zzvn();
        this.zzcpv = new zzdj(new zzdk(true, "make_wv", this.zzang.zzaup));
        this.zzcpv.zzkf().zzc(zzdkVar);
        this.zzcpt = zzdg.zzb(this.zzcpv.zzkf());
        this.zzcpv.zza("native:view_create", this.zzcpt);
        this.zzcpu = null;
        this.zzcps = null;
    }

    private void zzvh() {
        synchronized (this.zzail) {
            this.zzcka = com.google.android.gms.ads.internal.zzu.zzft().zzsr();
            if (this.zzcka == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    zzb((Boolean) true);
                } catch (IllegalStateException e) {
                    zzb((Boolean) false);
                }
            }
        }
    }

    private void zzvi() {
        zzdg.zza(this.zzcpv.zzkf(), this.zzcpt, "aeh2");
    }

    private void zzvj() {
        synchronized (this.zzail) {
            if (this.zzcpl || this.zzang.zzauq) {
                if (Build.VERSION.SDK_INT < 14) {
                    zzkh.zzcw("Disabling hardware acceleration on an overlay.");
                    zzvk();
                } else {
                    zzkh.zzcw("Enabling hardware acceleration on an overlay.");
                    zzvl();
                }
            } else if (Build.VERSION.SDK_INT < 18) {
                zzkh.zzcw("Disabling hardware acceleration on an AdView.");
                zzvk();
            } else {
                zzkh.zzcw("Enabling hardware acceleration on an AdView.");
                zzvl();
            }
        }
    }

    private void zzvk() {
        synchronized (this.zzail) {
            if (!this.zzcpm) {
                com.google.android.gms.ads.internal.zzu.zzfs().zzp(this);
            }
            this.zzcpm = true;
        }
    }

    private void zzvl() {
        synchronized (this.zzail) {
            if (this.zzcpm) {
                com.google.android.gms.ads.internal.zzu.zzfs().zzo(this);
            }
            this.zzcpm = false;
        }
    }

    private void zzvm() {
        synchronized (this.zzail) {
            this.zzcpy = null;
        }
    }

    private void zzvn() {
        zzdk zzdkVarZzkf;
        if (this.zzcpv == null || (zzdkVarZzkf = this.zzcpv.zzkf()) == null || com.google.android.gms.ads.internal.zzu.zzft().zzsm() == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzu.zzft().zzsm().zza(zzdkVarZzkf);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzll
    public void destroy() {
        synchronized (this.zzail) {
            zzvn();
            this.zzaqe.zztu();
            if (this.zzcpi != null) {
                this.zzcpi.close();
                this.zzcpi.onDestroy();
                this.zzcpi = null;
            }
            this.zzcph.reset();
            if (this.zzcpk) {
                return;
            }
            com.google.android.gms.ads.internal.zzu.zzgj().zze(this);
            zzvm();
            this.zzcpk = true;
            zzkh.m95v("Initiating WebView self destruct sequence in 3...");
            this.zzcph.zzva();
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zzail) {
            if (!isDestroyed()) {
                super.evaluateJavascript(str, valueCallback);
                return;
            }
            zzkh.zzcy("The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        }
    }

    protected void finalize() throws Throwable {
        synchronized (this.zzail) {
            if (!this.zzcpk) {
                this.zzcph.reset();
                com.google.android.gms.ads.internal.zzu.zzgj().zze(this);
                zzvm();
            }
        }
        super.finalize();
    }

    @Override // com.google.android.gms.internal.zzll
    public String getRequestId() {
        String str;
        synchronized (this.zzail) {
            str = this.zzbvu;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.zzll
    public int getRequestedOrientation() {
        int i;
        synchronized (this.zzail) {
            i = this.zzcpn;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.zzll
    public View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.zzll
    public WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.zzll
    public boolean isDestroyed() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzcpk;
        }
        return z;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzll
    public void loadData(String str, String str2, String str3) {
        synchronized (this.zzail) {
            if (isDestroyed()) {
                zzkh.zzcy("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzll
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.zzail) {
            if (isDestroyed()) {
                zzkh.zzcy("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzll
    public void loadUrl(String str) {
        synchronized (this.zzail) {
            if (isDestroyed()) {
                zzkh.zzcy("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    String strValueOf = String.valueOf(th);
                    zzkh.zzcy(new StringBuilder(String.valueOf(strValueOf).length() + 24).append("Could not call loadUrl. ").append(strValueOf).toString());
                }
            }
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        synchronized (this.zzail) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.zzaqe.onAttachedToWindow();
            }
            zzal(this.zzcpr);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        synchronized (this.zzail) {
            if (!isDestroyed()) {
                this.zzaqe.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
        }
        zzal(false);
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            com.google.android.gms.ads.internal.zzu.zzfq().zzb(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzkh.zzcw(new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length()).append("Couldn't find an Activity to view url/mimetype: ").append(str).append(" / ").append(str4).toString());
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean zZzvg = zzvg();
        com.google.android.gms.ads.internal.overlay.zzd zzdVarZzui = zzui();
        if (zzdVarZzui == null || !zZzvg) {
            return;
        }
        zzdVarZzui.zzob();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        synchronized (this.zzail) {
            if (isDestroyed()) {
                setMeasuredDimension(0, 0);
                return;
            }
            if (isInEditMode() || this.zzcpl || this.zzang.zzaus || this.zzang.zzaut) {
                super.onMeasure(i, i2);
                return;
            }
            if (this.zzang.zzauq) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.zzaqk.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
                return;
            }
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            int i4 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = size2;
            }
            if (this.zzang.widthPixels > i4 || this.zzang.heightPixels > i3) {
                float f = this.zzcpf.getResources().getDisplayMetrics().density;
                int i5 = (int) (size / f);
                zzkh.zzcy(new StringBuilder(103).append("Not enough space to show ad. Needs ").append((int) (this.zzang.widthPixels / f)).append("x").append((int) (this.zzang.heightPixels / f)).append(" dp, but only has ").append(i5).append("x").append((int) (size2 / f)).append(" dp.").toString());
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
            } else {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                setMeasuredDimension(this.zzang.widthPixels, this.zzang.heightPixels);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzll
    public void onPause() {
        if (isDestroyed()) {
            return;
        }
        try {
            if (com.google.android.gms.common.util.zzs.zzavj()) {
                super.onPause();
            }
        } catch (Exception e) {
            zzkh.zzb("Could not pause webview.", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzll
    public void onResume() {
        if (isDestroyed()) {
            return;
        }
        try {
            if (com.google.android.gms.common.util.zzs.zzavj()) {
                super.onResume();
            }
        } catch (Exception e) {
            zzkh.zzb("Could not resume webview.", e);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzbgh != null) {
            this.zzbgh.zza(motionEvent);
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.google.android.gms.internal.zzll
    public void setContext(Context context) {
        this.zzcpf.setBaseContext(context);
        this.zzaqe.zzl(this.zzcpf.zzuf());
    }

    @Override // android.view.View, com.google.android.gms.internal.zzll
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzcpw = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.zzll
    public void setRequestedOrientation(int i) {
        synchronized (this.zzail) {
            this.zzcpn = i;
            if (this.zzcpi != null) {
                this.zzcpi.setRequestedOrientation(this.zzcpn);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzll
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzlm) {
            this.zzcph = (zzlm) webViewClient;
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzll
    public void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzkh.zzb("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.zzll
    public void zza(Context context, AdSizeParcel adSizeParcel, zzdk zzdkVar) {
        synchronized (this.zzail) {
            this.zzaqe.zztu();
            setContext(context);
            this.zzcpi = null;
            this.zzang = adSizeParcel;
            this.zzcpl = false;
            this.zzcpj = false;
            this.zzbvu = "";
            this.zzcpn = -1;
            com.google.android.gms.ads.internal.zzu.zzfs().zzk(this);
            loadUrl("about:blank");
            this.zzcph.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.zzcpo = true;
            this.zzcpp = false;
            this.zzcpq = null;
            zzd(zzdkVar);
            this.zzcpr = false;
            com.google.android.gms.ads.internal.zzu.zzgj().zze(this);
            zzvm();
        }
    }

    @Override // com.google.android.gms.internal.zzll
    public void zza(AdSizeParcel adSizeParcel) {
        synchronized (this.zzail) {
            this.zzang = adSizeParcel;
            requestLayout();
        }
    }

    @Override // com.google.android.gms.internal.zzce
    public void zza(zzcd zzcdVar, boolean z) {
        synchronized (this.zzail) {
            this.zzcpr = z;
        }
        zzal(z);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zza(zzlq zzlqVar) {
        synchronized (this.zzail) {
            if (this.zzcpq != null) {
                zzkh.m14e("Attempt to create multiple AdWebViewVideoControllers.");
            } else {
                this.zzcpq = zzlqVar;
            }
        }
    }

    @TargetApi(19)
    protected void zza(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zzail) {
            if (isDestroyed()) {
                zzkh.zzcy("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zza(String str, zzet zzetVar) {
        if (this.zzcph != null) {
            this.zzcph.zza(str, zzetVar);
        }
    }

    @Override // com.google.android.gms.internal.zzll
    public void zza(String str, Map<String, ?> map) {
        try {
            zzb(str, com.google.android.gms.ads.internal.zzu.zzfq().zzam(map));
        } catch (JSONException e) {
            zzkh.zzcy("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.zzll, com.google.android.gms.internal.zzfx
    public void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzj(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzaf(int i) {
        zzvi();
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i));
        map.put("version", this.zzalm.zzcs);
        zza("onhide", map);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzah(boolean z) {
        synchronized (this.zzail) {
            this.zzcpl = z;
            zzvj();
        }
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzai(boolean z) {
        synchronized (this.zzail) {
            if (this.zzcpi != null) {
                this.zzcpi.zza(this.zzcph.zzho(), z);
            } else {
                this.zzcpj = z;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzaj(boolean z) {
        synchronized (this.zzail) {
            this.zzcpo = z;
        }
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        synchronized (this.zzail) {
            this.zzcpi = zzdVar;
        }
    }

    void zzb(Boolean bool) {
        synchronized (this.zzail) {
            this.zzcka = bool;
        }
        com.google.android.gms.ads.internal.zzu.zzft().zzb(bool);
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zzb(String str, zzet zzetVar) {
        if (this.zzcph != null) {
            this.zzcph.zzb(str, zzetVar);
        }
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("AFMA_ReceiveMessage('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(string);
        sb.append(");");
        String strValueOf = String.valueOf(sb.toString());
        zzkh.m95v(strValueOf.length() != 0 ? "Dispatching AFMA event: ".concat(strValueOf) : new String("Dispatching AFMA event: "));
        zzdd(sb.toString());
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzc(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        synchronized (this.zzail) {
            this.zzcpx = zzdVar;
        }
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzcz(String str) {
        synchronized (this.zzail) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                String strValueOf = String.valueOf(th);
                zzkh.zzcy(new StringBuilder(String.valueOf(strValueOf).length() + 24).append("Could not call loadUrl. ").append(strValueOf).toString());
            }
        }
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzda(String str) {
        synchronized (this.zzail) {
            if (str == null) {
                str = "";
            }
            this.zzbvu = str;
        }
    }

    protected void zzdc(String str) {
        synchronized (this.zzail) {
            if (isDestroyed()) {
                zzkh.zzcy("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    protected void zzdd(String str) {
        if (!com.google.android.gms.common.util.zzs.zzavq()) {
            String strValueOf = String.valueOf(str);
            zzdc(strValueOf.length() != 0 ? "javascript:".concat(strValueOf) : new String("javascript:"));
            return;
        }
        if (zzsr() == null) {
            zzvh();
        }
        if (zzsr().booleanValue()) {
            zza(str, (ValueCallback<String>) null);
        } else {
            String strValueOf2 = String.valueOf(str);
            zzdc(strValueOf2.length() != 0 ? "javascript:".concat(strValueOf2) : new String("javascript:"));
        }
    }

    @Override // com.google.android.gms.internal.zzll
    public AdSizeParcel zzdo() {
        AdSizeParcel adSizeParcel;
        synchronized (this.zzail) {
            adSizeParcel = this.zzang;
        }
        return adSizeParcel;
    }

    @Override // com.google.android.gms.ads.internal.zzs
    public void zzeg() {
        synchronized (this.zzail) {
            this.zzcpp = true;
            if (this.zzcpg != null) {
                this.zzcpg.zzeg();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzs
    public void zzeh() {
        synchronized (this.zzail) {
            this.zzcpp = false;
            if (this.zzcpg != null) {
                this.zzcpg.zzeh();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzll, com.google.android.gms.internal.zzfx
    public void zzj(String str, String str2) {
        zzdd(new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length()).append(str).append("(").append(str2).append(");").toString());
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzoc() {
        if (this.zzcps == null) {
            zzdg.zza(this.zzcpv.zzkf(), this.zzcpu, "aes");
            this.zzcps = zzdg.zzb(this.zzcpv.zzkf());
            this.zzcpv.zza("native:view_show", this.zzcps);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.zzalm.zzcs);
        zza("onshow", map);
    }

    @Override // com.google.android.gms.internal.zzll
    public boolean zzow() {
        boolean z;
        synchronized (this.zzail) {
            zzdg.zza(this.zzcpv.zzkf(), this.zzcpt, "aebb2");
            z = this.zzcpo;
        }
        return z;
    }

    Boolean zzsr() {
        Boolean bool;
        synchronized (this.zzail) {
            bool = this.zzcka;
        }
        return bool;
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzud() {
        zzvi();
        HashMap map = new HashMap(1);
        map.put("version", this.zzalm.zzcs);
        zza("onhide", map);
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzue() {
        HashMap map = new HashMap(3);
        map.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzu.zzfq().zzfa()));
        map.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzu.zzfq().zzey()));
        map.put("device_volume", String.valueOf(com.google.android.gms.ads.internal.zzu.zzfq().zzal(getContext())));
        zza("volume", map);
    }

    @Override // com.google.android.gms.internal.zzll
    public Activity zzuf() {
        return this.zzcpf.zzuf();
    }

    @Override // com.google.android.gms.internal.zzll
    public Context zzug() {
        return this.zzcpf.zzug();
    }

    @Override // com.google.android.gms.internal.zzll
    public com.google.android.gms.ads.internal.zzd zzuh() {
        return this.zzajv;
    }

    @Override // com.google.android.gms.internal.zzll
    public com.google.android.gms.ads.internal.overlay.zzd zzui() {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar;
        synchronized (this.zzail) {
            zzdVar = this.zzcpi;
        }
        return zzdVar;
    }

    @Override // com.google.android.gms.internal.zzll
    public com.google.android.gms.ads.internal.overlay.zzd zzuj() {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar;
        synchronized (this.zzail) {
            zzdVar = this.zzcpx;
        }
        return zzdVar;
    }

    @Override // com.google.android.gms.internal.zzll
    public zzlm zzuk() {
        return this.zzcph;
    }

    @Override // com.google.android.gms.internal.zzll
    public boolean zzul() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzcpj;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzll
    public zzas zzum() {
        return this.zzbgh;
    }

    @Override // com.google.android.gms.internal.zzll
    public VersionInfoParcel zzun() {
        return this.zzalm;
    }

    @Override // com.google.android.gms.internal.zzll
    public boolean zzuo() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzcpl;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzup() {
        synchronized (this.zzail) {
            zzkh.m95v("Destroying WebView!");
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzlp.1
                @Override // java.lang.Runnable
                public void run() {
                    zzlp.super.destroy();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.zzll
    public boolean zzuq() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzcpp;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzll
    public zzlk zzur() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzll
    public zzdi zzus() {
        return this.zzcpu;
    }

    @Override // com.google.android.gms.internal.zzll
    public zzdj zzut() {
        return this.zzcpv;
    }

    @Override // com.google.android.gms.internal.zzll
    public zzlq zzuu() {
        zzlq zzlqVar;
        synchronized (this.zzail) {
            zzlqVar = this.zzcpq;
        }
        return zzlqVar;
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzuv() {
        this.zzaqe.zztt();
    }

    @Override // com.google.android.gms.internal.zzll
    public void zzuw() {
        if (this.zzcpu == null) {
            this.zzcpu = zzdg.zzb(this.zzcpv.zzkf());
            this.zzcpv.zza("native:view_load", this.zzcpu);
        }
    }

    @Override // com.google.android.gms.internal.zzll
    public View.OnClickListener zzux() {
        return this.zzcpw.get();
    }

    public boolean zzvg() {
        int iZzb;
        int iZzb2;
        if (!zzuk().zzho()) {
            return false;
        }
        DisplayMetrics displayMetricsZza = com.google.android.gms.ads.internal.zzu.zzfq().zza(this.zzaqk);
        int iZzb3 = com.google.android.gms.ads.internal.client.zzm.zziw().zzb(displayMetricsZza, displayMetricsZza.widthPixels);
        int iZzb4 = com.google.android.gms.ads.internal.client.zzm.zziw().zzb(displayMetricsZza, displayMetricsZza.heightPixels);
        Activity activityZzuf = zzuf();
        if (activityZzuf == null || activityZzuf.getWindow() == null) {
            iZzb = iZzb4;
            iZzb2 = iZzb3;
        } else {
            int[] iArrZzh = com.google.android.gms.ads.internal.zzu.zzfq().zzh(activityZzuf);
            iZzb2 = com.google.android.gms.ads.internal.client.zzm.zziw().zzb(displayMetricsZza, iArrZzh[0]);
            iZzb = com.google.android.gms.ads.internal.client.zzm.zziw().zzb(displayMetricsZza, iArrZzh[1]);
        }
        if (this.zzbrj == iZzb3 && this.zzbrk == iZzb4 && this.zzbrm == iZzb2 && this.zzbrn == iZzb) {
            return false;
        }
        boolean z = (this.zzbrj == iZzb3 && this.zzbrk == iZzb4) ? false : true;
        this.zzbrj = iZzb3;
        this.zzbrk = iZzb4;
        this.zzbrm = iZzb2;
        this.zzbrn = iZzb;
        new zzhj(this).zza(iZzb3, iZzb4, iZzb2, iZzb, displayMetricsZza.density, this.zzaqk.getDefaultDisplay().getRotation());
        return z;
    }
}
