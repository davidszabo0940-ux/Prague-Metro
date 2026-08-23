package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzgx extends zzgs.zza {
    private final NativeContentAdMapper zzbpr;

    public zzgx(NativeContentAdMapper nativeContentAdMapper) {
        this.zzbpr = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.zzgs
    public String getAdvertiser() {
        return this.zzbpr.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.zzgs
    public String getBody() {
        return this.zzbpr.getBody();
    }

    @Override // com.google.android.gms.internal.zzgs
    public String getCallToAction() {
        return this.zzbpr.getCallToAction();
    }

    @Override // com.google.android.gms.internal.zzgs
    public Bundle getExtras() {
        return this.zzbpr.getExtras();
    }

    @Override // com.google.android.gms.internal.zzgs
    public String getHeadline() {
        return this.zzbpr.getHeadline();
    }

    @Override // com.google.android.gms.internal.zzgs
    public List getImages() {
        List<NativeAd.Image> images = this.zzbpr.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new com.google.android.gms.ads.internal.formats.zzc(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.zzgs
    public boolean getOverrideClickHandling() {
        return this.zzbpr.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.zzgs
    public boolean getOverrideImpressionRecording() {
        return this.zzbpr.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.zzgs
    public void recordImpression() {
        this.zzbpr.recordImpression();
    }

    @Override // com.google.android.gms.internal.zzgs
    public void zzk(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzbpr.handleClick((View) com.google.android.gms.dynamic.zze.zzad(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzgs
    public void zzl(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzbpr.trackView((View) com.google.android.gms.dynamic.zze.zzad(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzgs
    public zzdu zzla() {
        NativeAd.Image logo = this.zzbpr.getLogo();
        if (logo != null) {
            return new com.google.android.gms.ads.internal.formats.zzc(logo.getDrawable(), logo.getUri(), logo.getScale());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzgs
    public void zzm(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzbpr.untrackView((View) com.google.android.gms.dynamic.zze.zzad(zzdVar));
    }
}
