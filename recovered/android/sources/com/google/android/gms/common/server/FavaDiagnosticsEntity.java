package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable {
    public static final zza CREATOR = new zza();
    final int mVersionCode;

    /* JADX INFO: renamed from: zl */
    public final String f375zl;

    /* JADX INFO: renamed from: zm */
    public final int f376zm;

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        this.mVersionCode = i;
        this.f375zl = str;
        this.f376zm = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
