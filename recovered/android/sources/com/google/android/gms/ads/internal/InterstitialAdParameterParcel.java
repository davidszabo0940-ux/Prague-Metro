package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class InterstitialAdParameterParcel extends AbstractSafeParcelable {
    public static final zzm CREATOR = new zzm();
    public final int versionCode;
    public final boolean zzamc;
    public final boolean zzamd;
    public final String zzame;
    public final boolean zzamf;
    public final float zzamg;
    public final int zzamh;

    InterstitialAdParameterParcel(int i, boolean z, boolean z2, String str, boolean z3, float f, int i2) {
        this.versionCode = i;
        this.zzamc = z;
        this.zzamd = z2;
        this.zzame = str;
        this.zzamf = z3;
        this.zzamg = f;
        this.zzamh = i2;
    }

    public InterstitialAdParameterParcel(boolean z, boolean z2, boolean z3, float f, int i) {
        this(3, z, z2, null, z3, f, i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
