package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new zzae();
    final int mVersionCode;

    /* JADX INFO: renamed from: ro */
    private final Scope[] f257ro;

    /* JADX INFO: renamed from: yY */
    private final int f258yY;

    /* JADX INFO: renamed from: yZ */
    private final int f259yZ;

    SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.mVersionCode = i;
        this.f258yY = i2;
        this.f259yZ = i3;
        this.f257ro = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, scopeArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }

    public int zzatg() {
        return this.f258yY;
    }

    public int zzath() {
        return this.f259yZ;
    }

    public Scope[] zzati() {
        return this.f257ro;
    }
}
