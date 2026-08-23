package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes.dex */
public final class zzby extends zzca.zza {
    private final zzar zzaiq;
    private final zzas zzair;
    private final zzap zzais;
    private boolean zzait = false;

    public zzby(String str, Context context, boolean z) {
        this.zzaiq = zzar.zza(str, context, z);
        this.zzair = new zzas(this.zzaiq);
        this.zzais = z ? null : zzap.zze(context);
    }

    private com.google.android.gms.dynamic.zzd zza(com.google.android.gms.dynamic.zzd zzdVar, com.google.android.gms.dynamic.zzd zzdVar2, boolean z) {
        try {
            Uri uri = (Uri) com.google.android.gms.dynamic.zze.zzad(zzdVar);
            Context context = (Context) com.google.android.gms.dynamic.zze.zzad(zzdVar2);
            return com.google.android.gms.dynamic.zze.zzae(z ? this.zzair.zza(uri, context) : this.zzair.zzb(uri, context));
        } catch (zzat e) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzca
    public com.google.android.gms.dynamic.zzd zza(com.google.android.gms.dynamic.zzd zzdVar, com.google.android.gms.dynamic.zzd zzdVar2) {
        return zza(zzdVar, zzdVar2, true);
    }

    @Override // com.google.android.gms.internal.zzca
    public String zza(com.google.android.gms.dynamic.zzd zzdVar, String str) {
        return this.zzaiq.zzb((Context) com.google.android.gms.dynamic.zze.zzad(zzdVar), str);
    }

    @Override // com.google.android.gms.internal.zzca
    public boolean zza(com.google.android.gms.dynamic.zzd zzdVar) {
        return this.zzair.zza((Uri) com.google.android.gms.dynamic.zze.zzad(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzca
    public com.google.android.gms.dynamic.zzd zzb(com.google.android.gms.dynamic.zzd zzdVar, com.google.android.gms.dynamic.zzd zzdVar2) {
        return zza(zzdVar, zzdVar2, false);
    }

    @Override // com.google.android.gms.internal.zzca
    public void zzb(String str, String str2) {
        this.zzair.zzb(str, str2);
    }

    @Override // com.google.android.gms.internal.zzca
    public boolean zzb(com.google.android.gms.dynamic.zzd zzdVar) {
        return this.zzair.zzc((Uri) com.google.android.gms.dynamic.zze.zzad(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzca
    public boolean zzb(String str, boolean z) {
        if (this.zzais == null) {
            return false;
        }
        this.zzais.zza(new AdvertisingIdClient.Info(str, z));
        this.zzait = true;
        return true;
    }

    @Override // com.google.android.gms.internal.zzca
    public String zzc(com.google.android.gms.dynamic.zzd zzdVar) {
        Context context = (Context) com.google.android.gms.dynamic.zze.zzad(zzdVar);
        String strZzb = this.zzaiq.zzb(context);
        if (this.zzais == null || !this.zzait) {
            return strZzb;
        }
        String strZza = this.zzais.zza(strZzb, this.zzais.zzb(context));
        this.zzait = false;
        return strZza;
    }

    @Override // com.google.android.gms.internal.zzca
    public void zzd(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzair.zza((MotionEvent) com.google.android.gms.dynamic.zze.zzad(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzca
    public String zzdg() {
        return "ms";
    }

    @Override // com.google.android.gms.internal.zzca
    public void zzk(String str) {
        this.zzair.zzk(str);
    }
}
