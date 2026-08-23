package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class StringParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StringParcel> CREATOR = new zzo();
    final int mVersionCode;
    String zzbek;

    StringParcel(int i, String str) {
        this.mVersionCode = i;
        this.zzbek = str;
    }

    public StringParcel(String str) {
        this.mVersionCode = 1;
        this.zzbek = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }

    public String zzrf() {
        return this.zzbek;
    }
}
