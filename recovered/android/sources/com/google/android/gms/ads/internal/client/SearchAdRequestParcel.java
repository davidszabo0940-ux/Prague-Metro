package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class SearchAdRequestParcel extends AbstractSafeParcelable {
    public static final zzao CREATOR = new zzao();
    public final int backgroundColor;
    public final int versionCode;
    public final int zzawx;
    public final int zzawy;
    public final int zzawz;
    public final int zzaxa;
    public final int zzaxb;
    public final int zzaxc;
    public final int zzaxd;
    public final String zzaxe;
    public final int zzaxf;
    public final String zzaxg;
    public final int zzaxh;
    public final int zzaxi;
    public final String zzaxj;

    SearchAdRequestParcel(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.versionCode = i;
        this.zzawx = i2;
        this.backgroundColor = i3;
        this.zzawy = i4;
        this.zzawz = i5;
        this.zzaxa = i6;
        this.zzaxb = i7;
        this.zzaxc = i8;
        this.zzaxd = i9;
        this.zzaxe = str;
        this.zzaxf = i10;
        this.zzaxg = str2;
        this.zzaxh = i11;
        this.zzaxi = i12;
        this.zzaxj = str3;
    }

    public SearchAdRequestParcel(SearchAdRequest searchAdRequest) {
        this.versionCode = 1;
        this.zzawx = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.zzawy = searchAdRequest.getBackgroundGradientBottom();
        this.zzawz = searchAdRequest.getBackgroundGradientTop();
        this.zzaxa = searchAdRequest.getBorderColor();
        this.zzaxb = searchAdRequest.getBorderThickness();
        this.zzaxc = searchAdRequest.getBorderType();
        this.zzaxd = searchAdRequest.getCallButtonColor();
        this.zzaxe = searchAdRequest.getCustomChannels();
        this.zzaxf = searchAdRequest.getDescriptionTextColor();
        this.zzaxg = searchAdRequest.getFontFace();
        this.zzaxh = searchAdRequest.getHeaderTextColor();
        this.zzaxi = searchAdRequest.getHeaderTextSize();
        this.zzaxj = searchAdRequest.getQuery();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzao.zza(this, parcel, i);
    }
}
