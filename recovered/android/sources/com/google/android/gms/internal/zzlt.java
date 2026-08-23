package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(11)
@zzir
public class zzlt extends zzlm {
    public zzlt(zzll zzllVar, boolean z) {
        super(zzllVar, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        String str2;
        if (this.zzcow != null) {
            this.zzcow.zzck(str);
        }
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (!(webView instanceof zzll)) {
                zzkh.zzcy("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, str);
            }
            zzll zzllVar = (zzll) webView;
            zzllVar.zzuk().zznz();
            if (zzllVar.zzdo().zzauq) {
                str2 = zzdc.zzazb.get();
            } else {
                str2 = zzllVar.zzuo() ? zzdc.zzaza.get() : zzdc.zzayz.get();
            }
            zzkh.m95v(new StringBuilder(String.valueOf(str2).length() + 24).append("shouldInterceptRequest(").append(str2).append(")").toString());
            return zzd(zzllVar.getContext(), this.zzbgj.zzun().zzcs, str2);
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            String strValueOf = String.valueOf(e.getMessage());
            zzkh.zzcy(strValueOf.length() != 0 ? "Could not fetch MRAID JS. ".concat(strValueOf) : new String("Could not fetch MRAID JS. "));
            return super.shouldInterceptRequest(webView, str);
        }
    }

    protected WebResourceResponse zzd(Context context, String str, String str2) throws ExecutionException, InterruptedException, TimeoutException, IOException {
        HashMap map = new HashMap();
        map.put("User-Agent", com.google.android.gms.ads.internal.zzu.zzfq().zzh(context, str));
        map.put("Cache-Control", "max-stale=3600");
        String str3 = new zzkr(context).zzb(str2, map).get(60L, TimeUnit.SECONDS);
        if (str3 == null) {
            return null;
        }
        return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }
}
