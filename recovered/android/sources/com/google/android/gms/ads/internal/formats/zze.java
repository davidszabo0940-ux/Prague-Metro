package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzea;
import com.google.android.gms.internal.zzir;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zze extends zzea.zza implements zzh.zza {
    private Bundle mExtras;
    private Object zzail = new Object();
    private String zzbfk;
    private List<zzc> zzbfl;
    private String zzbfm;
    private String zzbfo;

    @Nullable
    private zza zzbfs;
    private zzh zzbft;
    private zzdu zzbfu;
    private String zzbfv;

    public zze(String str, List list, String str2, zzdu zzduVar, String str3, String str4, @Nullable zza zzaVar, Bundle bundle) {
        this.zzbfk = str;
        this.zzbfl = list;
        this.zzbfm = str2;
        this.zzbfu = zzduVar;
        this.zzbfo = str3;
        this.zzbfv = str4;
        this.zzbfs = zzaVar;
        this.mExtras = bundle;
    }

    @Override // com.google.android.gms.internal.zzea
    public void destroy() {
        this.zzbfk = null;
        this.zzbfl = null;
        this.zzbfm = null;
        this.zzbfu = null;
        this.zzbfo = null;
        this.zzbfv = null;
        this.zzbfs = null;
        this.mExtras = null;
        this.zzail = null;
        this.zzbft = null;
    }

    @Override // com.google.android.gms.internal.zzea
    public String getAdvertiser() {
        return this.zzbfv;
    }

    @Override // com.google.android.gms.internal.zzea
    public String getBody() {
        return this.zzbfm;
    }

    @Override // com.google.android.gms.internal.zzea
    public String getCallToAction() {
        return this.zzbfo;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String getCustomTemplateId() {
        return "";
    }

    @Override // com.google.android.gms.internal.zzea
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.internal.zzea
    public String getHeadline() {
        return this.zzbfk;
    }

    @Override // com.google.android.gms.internal.zzea
    public List getImages() {
        return this.zzbfl;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public void zzb(zzh zzhVar) {
        synchronized (this.zzail) {
            this.zzbft = zzhVar;
        }
    }

    @Override // com.google.android.gms.internal.zzea
    public com.google.android.gms.dynamic.zzd zzkx() {
        return com.google.android.gms.dynamic.zze.zzae(this.zzbft);
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String zzky() {
        return "1";
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public zza zzkz() {
        return this.zzbfs;
    }

    @Override // com.google.android.gms.internal.zzea
    public zzdu zzla() {
        return this.zzbfu;
    }
}
