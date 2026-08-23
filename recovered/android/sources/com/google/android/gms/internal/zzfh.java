package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzfh implements Releasable {
    protected Context mContext;
    protected String zzbjj;
    protected WeakReference<zzll> zzbjk;

    public zzfh(zzll zzllVar) {
        this.mContext = zzllVar.getContext();
        this.zzbjj = com.google.android.gms.ads.internal.zzu.zzfq().zzh(this.mContext, zzllVar.zzun().zzcs);
        this.zzbjk = new WeakReference<>(zzllVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(String str, Map<String, String> map) {
        zzll zzllVar = this.zzbjk.get();
        if (zzllVar != null) {
            zzllVar.zza(str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zzbc(String str) {
        switch (str) {
            case "error":
            case "playerFailed":
            case "inProgress":
            case "contentLengthMissing":
                return "internal";
            case "noCacheDir":
            case "expireFailed":
                return "io";
            case "badUrl":
            case "downloadTimeout":
                return "network";
            case "sizeExceeded":
            case "externalAbort":
                return "policy";
            default:
                return "internal";
        }
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    protected void zza(final String str, final String str2, final int i) {
        com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzfh.2
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("event", "precacheComplete");
                map.put("src", str);
                map.put("cachedSrc", str2);
                map.put("totalBytes", Integer.toString(i));
                zzfh.this.zza("onPrecacheEvent", map);
            }
        });
    }

    protected void zza(final String str, final String str2, final int i, final int i2, final boolean z) {
        com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzfh.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("event", "precacheProgress");
                map.put("src", str);
                map.put("cachedSrc", str2);
                map.put("bytesLoaded", Integer.toString(i));
                map.put("totalBytes", Integer.toString(i2));
                map.put("cacheReady", z ? "1" : "0");
                zzfh.this.zza("onPrecacheEvent", map);
            }
        });
    }

    protected void zza(final String str, final String str2, final String str3, final String str4) {
        com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzfh.3
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("event", "precacheCanceled");
                map.put("src", str);
                if (!TextUtils.isEmpty(str2)) {
                    map.put("cachedSrc", str2);
                }
                map.put("type", zzfh.this.zzbc(str3));
                map.put("reason", str3);
                if (!TextUtils.isEmpty(str4)) {
                    map.put("message", str4);
                }
                zzfh.this.zza("onPrecacheEvent", map);
            }
        });
    }

    public abstract boolean zzba(String str);

    protected String zzbb(String str) {
        return com.google.android.gms.ads.internal.client.zzm.zziw().zzcv(str);
    }
}
