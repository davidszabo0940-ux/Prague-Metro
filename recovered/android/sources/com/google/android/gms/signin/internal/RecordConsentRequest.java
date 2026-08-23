package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class RecordConsentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RecordConsentRequest> CREATOR = new zzf();

    /* JADX INFO: renamed from: aP */
    private final Account f867aP;
    private final Scope[] auu;

    /* JADX INFO: renamed from: dW */
    private final String f868dW;
    final int mVersionCode;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.mVersionCode = i;
        this.f867aP = account;
        this.auu = scopeArr;
        this.f868dW = str;
    }

    public Account getAccount() {
        return this.f867aP;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public String zzafu() {
        return this.f868dW;
    }

    public Scope[] zzbzs() {
        return this.auu;
    }
}
