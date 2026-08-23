package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class NativeContentAdMapper extends NativeAdMapper {
    private String zzbfk;
    private List<NativeAd.Image> zzbfl;
    private String zzbfm;
    private String zzbfo;
    private String zzbfv;
    private NativeAd.Image zzcqt;

    public final String getAdvertiser() {
        return this.zzbfv;
    }

    public final String getBody() {
        return this.zzbfm;
    }

    public final String getCallToAction() {
        return this.zzbfo;
    }

    public final String getHeadline() {
        return this.zzbfk;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbfl;
    }

    public final NativeAd.Image getLogo() {
        return this.zzcqt;
    }

    public final void setAdvertiser(String str) {
        this.zzbfv = str;
    }

    public final void setBody(String str) {
        this.zzbfm = str;
    }

    public final void setCallToAction(String str) {
        this.zzbfo = str;
    }

    public final void setHeadline(String str) {
        this.zzbfk = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzbfl = list;
    }

    public final void setLogo(NativeAd.Image image) {
        this.zzcqt = image;
    }
}
