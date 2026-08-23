package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzfv implements zzft {
    private final zzll zzbgj;

    public zzfv(Context context, VersionInfoParcel versionInfoParcel, zzas zzasVar) {
        this.zzbgj = com.google.android.gms.ads.internal.zzu.zzfr().zza(context, new AdSizeParcel(), false, false, zzasVar, versionInfoParcel);
        this.zzbgj.getWebView().setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        if (com.google.android.gms.ads.internal.client.zzm.zziw().zzty()) {
            runnable.run();
        } else {
            zzkl.zzclg.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.zzft
    public void destroy() {
        this.zzbgj.destroy();
    }

    @Override // com.google.android.gms.internal.zzft
    public void zza(com.google.android.gms.ads.internal.client.zza zzaVar, com.google.android.gms.ads.internal.overlay.zzg zzgVar, zzeo zzeoVar, com.google.android.gms.ads.internal.overlay.zzp zzpVar, boolean z, zzev zzevVar, zzex zzexVar, com.google.android.gms.ads.internal.zze zzeVar, zzhk zzhkVar) {
        this.zzbgj.zzuk().zza(zzaVar, zzgVar, zzeoVar, zzpVar, z, zzevVar, zzexVar, new com.google.android.gms.ads.internal.zze(this.zzbgj.getContext(), false), zzhkVar, null);
    }

    @Override // com.google.android.gms.internal.zzft
    public void zza(final zzft.zza zzaVar) {
        this.zzbgj.zzuk().zza(new zzlm.zza() { // from class: com.google.android.gms.internal.zzfv.6
            @Override // com.google.android.gms.internal.zzlm.zza
            public void zza(zzll zzllVar, boolean z) {
                zzaVar.zzmb();
            }
        });
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zza(String str, zzet zzetVar) {
        this.zzbgj.zzuk().zza(str, zzetVar);
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zza(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzfv.1
            @Override // java.lang.Runnable
            public void run() {
                zzfv.this.zzbgj.zza(str, jSONObject);
            }
        });
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zzb(String str, zzet zzetVar) {
        this.zzbgj.zzuk().zzb(str, zzetVar);
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zzb(String str, JSONObject jSONObject) {
        this.zzbgj.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzft
    public void zzbh(String str) {
        final String str2 = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str);
        runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzfv.3
            @Override // java.lang.Runnable
            public void run() {
                zzfv.this.zzbgj.loadData(str2, "text/html", "UTF-8");
            }
        });
    }

    @Override // com.google.android.gms.internal.zzft
    public void zzbi(final String str) {
        runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzfv.5
            @Override // java.lang.Runnable
            public void run() {
                zzfv.this.zzbgj.loadUrl(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.zzft
    public void zzbj(final String str) {
        runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzfv.4
            @Override // java.lang.Runnable
            public void run() {
                zzfv.this.zzbgj.loadData(str, "text/html", "UTF-8");
            }
        });
    }

    @Override // com.google.android.gms.internal.zzfx
    public void zzj(final String str, final String str2) {
        runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzfv.2
            @Override // java.lang.Runnable
            public void run() {
                zzfv.this.zzbgj.zzj(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.zzft
    public zzfy zzma() {
        return new zzfz(this);
    }
}
