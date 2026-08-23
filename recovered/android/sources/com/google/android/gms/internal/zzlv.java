package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzlv extends WebViewClient {
    private final zzll zzbgj;
    private final zzid zzbyk;
    private final String zzcqp;
    private boolean zzcqq = false;

    public zzlv(zzid zzidVar, zzll zzllVar, String str) {
        this.zzcqp = zzdg(str);
        this.zzbgj = zzllVar;
        this.zzbyk = zzidVar;
    }

    private String zzdg(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.endsWith("/") ? str.substring(0, str.length() - 1) : str;
        } catch (IndexOutOfBoundsException e) {
            zzkh.m14e(e.getMessage());
            return str;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        String strValueOf = String.valueOf(str);
        zzkh.zzcw(strValueOf.length() != 0 ? "JavascriptAdWebViewClient::onLoadResource: ".concat(strValueOf) : new String("JavascriptAdWebViewClient::onLoadResource: "));
        if (zzdf(str)) {
            return;
        }
        this.zzbgj.zzuk().onLoadResource(this.zzbgj.getWebView(), str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        String strValueOf = String.valueOf(str);
        zzkh.zzcw(strValueOf.length() != 0 ? "JavascriptAdWebViewClient::onPageFinished: ".concat(strValueOf) : new String("JavascriptAdWebViewClient::onPageFinished: "));
        if (this.zzcqq) {
            return;
        }
        this.zzbyk.zzqa();
        this.zzcqq = true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String strValueOf = String.valueOf(str);
        zzkh.zzcw(strValueOf.length() != 0 ? "JavascriptAdWebViewClient::shouldOverrideUrlLoading: ".concat(strValueOf) : new String("JavascriptAdWebViewClient::shouldOverrideUrlLoading: "));
        if (!zzdf(str)) {
            return this.zzbgj.zzuk().shouldOverrideUrlLoading(this.zzbgj.getWebView(), str);
        }
        zzkh.zzcw("shouldOverrideUrlLoading: received passback url");
        return true;
    }

    protected boolean zzdf(String str) {
        boolean z = false;
        String strZzdg = zzdg(str);
        if (!TextUtils.isEmpty(strZzdg)) {
            try {
                URI uri = new URI(strZzdg);
                if ("passback".equals(uri.getScheme())) {
                    zzkh.zzcw("Passback received");
                    this.zzbyk.zzqb();
                    z = true;
                } else if (!TextUtils.isEmpty(this.zzcqp)) {
                    URI uri2 = new URI(this.zzcqp);
                    String host = uri2.getHost();
                    String host2 = uri.getHost();
                    String path = uri2.getPath();
                    String path2 = uri.getPath();
                    if (com.google.android.gms.common.internal.zzaa.equal(host, host2) && com.google.android.gms.common.internal.zzaa.equal(path, path2)) {
                        zzkh.zzcw("Passback received");
                        this.zzbyk.zzqb();
                        z = true;
                    }
                }
            } catch (URISyntaxException e) {
                zzkh.m14e(e.getMessage());
            }
        }
        return z;
    }
}
