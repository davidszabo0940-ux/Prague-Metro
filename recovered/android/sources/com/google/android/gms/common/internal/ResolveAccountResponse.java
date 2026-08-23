package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzad();
    final int mVersionCode;

    /* JADX INFO: renamed from: rv */
    private ConnectionResult f253rv;

    /* JADX INFO: renamed from: tB */
    private boolean f254tB;

    /* JADX INFO: renamed from: wY */
    IBinder f255wY;

    /* JADX INFO: renamed from: yX */
    private boolean f256yX;

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.f255wY = iBinder;
        this.f253rv = connectionResult;
        this.f254tB = z;
        this.f256yX = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f253rv.equals(resolveAccountResponse.f253rv) && zzatc().equals(resolveAccountResponse.zzatc());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzad.zza(this, parcel, i);
    }

    public zzq zzatc() {
        return zzq.zza.zzdp(this.f255wY);
    }

    public ConnectionResult zzatd() {
        return this.f253rv;
    }

    public boolean zzate() {
        return this.f254tB;
    }

    public boolean zzatf() {
        return this.f256yX;
    }
}
