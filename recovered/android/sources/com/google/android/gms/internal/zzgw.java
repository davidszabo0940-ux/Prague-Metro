package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzgw extends zzgr.zza {
    private final NativeAppInstallAdMapper zzbpq;

    public zzgw(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzbpq = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.zzgr
    public String getBody() {
        return this.zzbpq.getBody();
    }

    @Override // com.google.android.gms.internal.zzgr
    public String getCallToAction() {
        return this.zzbpq.getCallToAction();
    }

    @Override // com.google.android.gms.internal.zzgr
    public Bundle getExtras() {
        return this.zzbpq.getExtras();
    }

    @Override // com.google.android.gms.internal.zzgr
    public String getHeadline() {
        return this.zzbpq.getHeadline();
    }

    @Override // com.google.android.gms.internal.zzgr
    public List getImages() {
        List<NativeAd.Image> images = this.zzbpq.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new com.google.android.gms.ads.internal.formats.zzc(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.zzgr
    public boolean getOverrideClickHandling() {
        return this.zzbpq.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.zzgr
    public boolean getOverrideImpressionRecording() {
        return this.zzbpq.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.zzgr
    public String getPrice() {
        return this.zzbpq.getPrice();
    }

    @Override // com.google.android.gms.internal.zzgr
    public double getStarRating() {
        return this.zzbpq.getStarRating();
    }

    @Override // com.google.android.gms.internal.zzgr
    public String getStore() {
        return this.zzbpq.getStore();
    }

    @Override // com.google.android.gms.internal.zzgr
    public void recordImpression() {
        this.zzbpq.recordImpression();
    }

    @Override // com.google.android.gms.internal.zzgr
    public void zzk(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzbpq.handleClick((View) com.google.android.gms.dynamic.zze.zzad(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzgr
    public zzdu zzkw() {
        NativeAd.Image icon = this.zzbpq.getIcon();
        if (icon != null) {
            return new com.google.android.gms.ads.internal.formats.zzc(icon.getDrawable(), icon.getUri(), icon.getScale());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzgr
    public void zzl(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzbpq.trackView((View) com.google.android.gms.dynamic.zze.zzad(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzgr
    public void zzm(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzbpq.untrackView((View) com.google.android.gms.dynamic.zze.zzad(zzdVar));
    }
}
