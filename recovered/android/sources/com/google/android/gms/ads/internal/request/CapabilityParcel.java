package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class CapabilityParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CapabilityParcel> CREATOR = new zzj();
    public final int versionCode;
    public final boolean zzcda;
    public final boolean zzcdb;
    public final boolean zzcdc;

    CapabilityParcel(int i, boolean z, boolean z2, boolean z3) {
        this.versionCode = i;
        this.zzcda = z;
        this.zzcdb = z2;
        this.zzcdc = z3;
    }

    public CapabilityParcel(boolean z, boolean z2, boolean z3) {
        this(2, z, z2, z3);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("iap_supported", this.zzcda);
        bundle.putBoolean("default_iap_supported", this.zzcdb);
        bundle.putBoolean("app_streaming_supported", this.zzcdc);
        return bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
