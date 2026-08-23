package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zzac();

    /* JADX INFO: renamed from: aP */
    private final Account f250aP;
    final int mVersionCode;

    /* JADX INFO: renamed from: yV */
    private final int f251yV;

    /* JADX INFO: renamed from: yW */
    private final GoogleSignInAccount f252yW;

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.mVersionCode = i;
        this.f250aP = account;
        this.f251yV = i2;
        this.f252yW = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account getAccount() {
        return this.f250aP;
    }

    public int getSessionId() {
        return this.f251yV;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzac.zza(this, parcel, i);
    }

    @Nullable
    public GoogleSignInAccount zzatb() {
        return this.f252yW;
    }
}
