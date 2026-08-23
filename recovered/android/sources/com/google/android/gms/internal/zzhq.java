package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzhq implements zzho {
    private final Context mContext;
    final Set<WebView> zzbwl = Collections.synchronizedSet(new HashSet());

    public zzhq(Context context) {
        this.mContext = context;
    }

    @Override // com.google.android.gms.internal.zzho
    public void zza(String str, final String str2, final String str3) {
        zzkh.zzcw("Fetching assets for the given html");
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzhq.1
            @Override // java.lang.Runnable
            public void run() {
                final WebView webViewZzpn = zzhq.this.zzpn();
                webViewZzpn.setWebViewClient(new WebViewClient() { // from class: com.google.android.gms.internal.zzhq.1.1
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str4) {
                        zzkh.zzcw("Loading assets have finished");
                        zzhq.this.zzbwl.remove(webViewZzpn);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str4, String str5) {
                        zzkh.zzcy("Loading assets have failed.");
                        zzhq.this.zzbwl.remove(webViewZzpn);
                    }
                });
                zzhq.this.zzbwl.add(webViewZzpn);
                webViewZzpn.loadDataWithBaseURL(str2, str3, "text/html", "UTF-8", null);
                zzkh.zzcw("Fetching assets finished.");
            }
        });
    }

    public WebView zzpn() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
