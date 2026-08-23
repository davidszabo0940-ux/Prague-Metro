package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zzc();
    final int mVersionCode;

    /* JADX INFO: renamed from: ro */
    final Scope[] f233ro;

    /* JADX INFO: renamed from: wY */
    final IBinder f234wY;

    /* JADX INFO: renamed from: wZ */
    Integer f235wZ;

    /* JADX INFO: renamed from: xa */
    Integer f236xa;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.mVersionCode = i;
        this.f234wY = iBinder;
        this.f233ro = scopeArr;
        this.f235wZ = num;
        this.f236xa = num2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
