package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class VersionInfoParcel extends AbstractSafeParcelable {
    public static final zzd CREATOR = new zzd();
    public final int versionCode;
    public int zzcno;
    public int zzcnp;
    public boolean zzcnq;
    public String zzcs;

    /* JADX WARN: Illegal instructions before constructor call */
    public VersionInfoParcel(int i, int i2, boolean z) {
        String strValueOf = String.valueOf("afma-sdk-a-v");
        String str = z ? "0" : "1";
        this(1, new StringBuilder(String.valueOf(strValueOf).length() + 24 + String.valueOf(str).length()).append(strValueOf).append(i).append(".").append(i2).append(".").append(str).toString(), i, i2, z);
    }

    VersionInfoParcel(int i, String str, int i2, int i3, boolean z) {
        this.versionCode = i;
        this.zzcs = str;
        this.zzcno = i2;
        this.zzcnp = i3;
        this.zzcnq = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
