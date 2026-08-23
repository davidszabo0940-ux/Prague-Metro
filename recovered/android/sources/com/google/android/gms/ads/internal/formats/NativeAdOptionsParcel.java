package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class NativeAdOptionsParcel extends AbstractSafeParcelable {
    public static final zzj CREATOR = new zzj();
    public final int versionCode;
    public final boolean zzbgt;
    public final int zzbgu;
    public final boolean zzbgv;
    public final int zzbgw;

    public NativeAdOptionsParcel(int i, boolean z, int i2, boolean z2, int i3) {
        this.versionCode = i;
        this.zzbgt = z;
        this.zzbgu = i2;
        this.zzbgv = z2;
        this.zzbgw = i3;
    }

    public NativeAdOptionsParcel(NativeAdOptions nativeAdOptions) {
        this(2, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
