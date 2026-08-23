package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class NativeAppInstallAdMapper extends NativeAdMapper {
    private String zzbfk;
    private List<NativeAd.Image> zzbfl;
    private String zzbfm;
    private String zzbfo;
    private double zzbfp;
    private String zzbfq;
    private String zzbfr;
    private NativeAd.Image zzcqs;

    public final String getBody() {
        return this.zzbfm;
    }

    public final String getCallToAction() {
        return this.zzbfo;
    }

    public final String getHeadline() {
        return this.zzbfk;
    }

    public final NativeAd.Image getIcon() {
        return this.zzcqs;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbfl;
    }

    public final String getPrice() {
        return this.zzbfr;
    }

    public final double getStarRating() {
        return this.zzbfp;
    }

    public final String getStore() {
        return this.zzbfq;
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

    public final void setIcon(NativeAd.Image image) {
        this.zzcqs = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzbfl = list;
    }

    public final void setPrice(String str) {
        this.zzbfr = str;
    }

    public final void setStarRating(double d) {
        this.zzbfp = d;
    }

    public final void setStore(String str) {
        this.zzbfq = str;
    }
}
