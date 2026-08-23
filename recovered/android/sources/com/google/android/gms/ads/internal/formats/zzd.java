package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzir;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzd extends zzdy.zza implements zzh.zza {
    private Bundle mExtras;
    private Object zzail = new Object();
    private String zzbfk;
    private List<zzc> zzbfl;
    private String zzbfm;
    private zzdu zzbfn;
    private String zzbfo;
    private double zzbfp;
    private String zzbfq;
    private String zzbfr;

    @Nullable
    private zza zzbfs;
    private zzh zzbft;

    public zzd(String str, List list, String str2, zzdu zzduVar, String str3, double d, String str4, String str5, @Nullable zza zzaVar, Bundle bundle) {
        this.zzbfk = str;
        this.zzbfl = list;
        this.zzbfm = str2;
        this.zzbfn = zzduVar;
        this.zzbfo = str3;
        this.zzbfp = d;
        this.zzbfq = str4;
        this.zzbfr = str5;
        this.zzbfs = zzaVar;
        this.mExtras = bundle;
    }

    @Override // com.google.android.gms.internal.zzdy
    public void destroy() {
        this.zzbfk = null;
        this.zzbfl = null;
        this.zzbfm = null;
        this.zzbfn = null;
        this.zzbfo = null;
        this.zzbfp = 0.0d;
        this.zzbfq = null;
        this.zzbfr = null;
        this.zzbfs = null;
        this.mExtras = null;
        this.zzail = null;
        this.zzbft = null;
    }

    @Override // com.google.android.gms.internal.zzdy
    public String getBody() {
        return this.zzbfm;
    }

    @Override // com.google.android.gms.internal.zzdy
    public String getCallToAction() {
        return this.zzbfo;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String getCustomTemplateId() {
        return "";
    }

    @Override // com.google.android.gms.internal.zzdy
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.internal.zzdy
    public String getHeadline() {
        return this.zzbfk;
    }

    @Override // com.google.android.gms.internal.zzdy
    public List getImages() {
        return this.zzbfl;
    }

    @Override // com.google.android.gms.internal.zzdy
    public String getPrice() {
        return this.zzbfr;
    }

    @Override // com.google.android.gms.internal.zzdy
    public double getStarRating() {
        return this.zzbfp;
    }

    @Override // com.google.android.gms.internal.zzdy
    public String getStore() {
        return this.zzbfq;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public void zzb(zzh zzhVar) {
        synchronized (this.zzail) {
            this.zzbft = zzhVar;
        }
    }

    @Override // com.google.android.gms.internal.zzdy
    public zzdu zzkw() {
        return this.zzbfn;
    }

    @Override // com.google.android.gms.internal.zzdy
    public com.google.android.gms.dynamic.zzd zzkx() {
        return com.google.android.gms.dynamic.zze.zzae(this.zzbft);
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String zzky() {
        return "2";
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public zza zzkz() {
        return this.zzbfs;
    }
}
