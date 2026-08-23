package com.google.android.gms.ads.internal.formats;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzir;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzf extends zzec.zza implements zzh.zza {
    private final Object zzail = new Object();
    private final zza zzbfs;
    private zzh zzbft;
    private final String zzbfw;
    private final SimpleArrayMap<String, zzc> zzbfx;
    private final SimpleArrayMap<String, String> zzbfy;

    public zzf(String str, SimpleArrayMap<String, zzc> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, zza zzaVar) {
        this.zzbfw = str;
        this.zzbfx = simpleArrayMap;
        this.zzbfy = simpleArrayMap2;
        this.zzbfs = zzaVar;
    }

    @Override // com.google.android.gms.internal.zzec
    public List<String> getAvailableAssetNames() {
        int i = 0;
        String[] strArr = new String[this.zzbfx.size() + this.zzbfy.size()];
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzbfx.size(); i3++) {
            strArr[i2] = this.zzbfx.keyAt(i3);
            i2++;
        }
        while (i < this.zzbfy.size()) {
            strArr[i2] = this.zzbfy.keyAt(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.zzec, com.google.android.gms.ads.internal.formats.zzh.zza
    public String getCustomTemplateId() {
        return this.zzbfw;
    }

    @Override // com.google.android.gms.internal.zzec
    public void performClick(String str) {
        synchronized (this.zzail) {
            if (this.zzbft == null) {
                com.google.android.gms.ads.internal.util.client.zzb.m14e("Attempt to call performClick before ad initialized.");
            } else {
                this.zzbft.zza(str, null, null, null);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzec
    public void recordImpression() {
        synchronized (this.zzail) {
            if (this.zzbft == null) {
                com.google.android.gms.ads.internal.util.client.zzb.m14e("Attempt to perform recordImpression before ad initialized.");
            } else {
                this.zzbft.recordImpression();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzec
    public String zzau(String str) {
        return this.zzbfy.get(str);
    }

    @Override // com.google.android.gms.internal.zzec
    public zzdu zzav(String str) {
        return this.zzbfx.get(str);
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public void zzb(zzh zzhVar) {
        synchronized (this.zzail) {
            this.zzbft = zzhVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String zzky() {
        return "3";
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public zza zzkz() {
        return this.zzbfs;
    }
}
