package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ValidateAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzaj();
    final int mVersionCode;

    /* JADX INFO: renamed from: ro */
    private final Scope[] f260ro;

    /* JADX INFO: renamed from: wY */
    final IBinder f261wY;

    /* JADX INFO: renamed from: ze */
    private final int f262ze;

    /* JADX INFO: renamed from: zf */
    private final Bundle f263zf;

    /* JADX INFO: renamed from: zg */
    private final String f264zg;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.mVersionCode = i;
        this.f262ze = i2;
        this.f261wY = iBinder;
        this.f260ro = scopeArr;
        this.f263zf = bundle;
        this.f264zg = str;
    }

    public String getCallingPackage() {
        return this.f264zg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaj.zza(this, parcel, i);
    }

    public Scope[] zzati() {
        return this.f260ro;
    }

    public int zzatk() {
        return this.f262ze;
    }

    public Bundle zzatl() {
        return this.f263zf;
    }
}
