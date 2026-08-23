package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public class zzac implements Parcelable.Creator<ResolveAccountRequest> {
    static void zza(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int iZzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, resolveAccountRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) resolveAccountRequest.getAccount(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, resolveAccountRequest.getSessionId());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) resolveAccountRequest.zzatb(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, iZzcm);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcg, reason: merged with bridge method [inline-methods] */
    public ResolveAccountRequest createFromParcel(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount;
        int iZzg;
        Account account;
        int iZzg2;
        GoogleSignInAccount googleSignInAccount2 = null;
        int i = 0;
        int iZzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
        Account account2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < iZzcl) {
            int iZzck = com.google.android.gms.common.internal.safeparcel.zza.zzck(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(iZzck)) {
                case 1:
                    GoogleSignInAccount googleSignInAccount3 = googleSignInAccount2;
                    iZzg = i;
                    account = account2;
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    googleSignInAccount = googleSignInAccount3;
                    break;
                case 2:
                    iZzg2 = i2;
                    int i3 = i;
                    account = (Account) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, Account.CREATOR);
                    googleSignInAccount = googleSignInAccount2;
                    iZzg = i3;
                    break;
                case 3:
                    account = account2;
                    iZzg2 = i2;
                    GoogleSignInAccount googleSignInAccount4 = googleSignInAccount2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzck);
                    googleSignInAccount = googleSignInAccount4;
                    break;
                case 4:
                    googleSignInAccount = (GoogleSignInAccount) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzck, GoogleSignInAccount.CREATOR);
                    iZzg = i;
                    account = account2;
                    iZzg2 = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzck);
                    googleSignInAccount = googleSignInAccount2;
                    iZzg = i;
                    account = account2;
                    iZzg2 = i2;
                    break;
            }
            i2 = iZzg2;
            account2 = account;
            i = iZzg;
            googleSignInAccount2 = googleSignInAccount;
        }
        if (parcel.dataPosition() != iZzcl) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0743zza(new StringBuilder(37).append("Overread allowed size end=").append(iZzcl).toString(), parcel);
        }
        return new ResolveAccountRequest(i2, account2, i, googleSignInAccount2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzge, reason: merged with bridge method [inline-methods] */
    public ResolveAccountRequest[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
