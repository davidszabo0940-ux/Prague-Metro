package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class zza extends zzq.zza {

    /* JADX INFO: renamed from: wX */
    int f265wX;

    public static Account zza(zzq zzqVar) {
        Account account = null;
        if (zzqVar != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = zzqVar.getAccount();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return account;
    }

    public boolean equals(Object obj) {
        Account account = null;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zza)) {
            return false;
        }
        return account.equals(null);
    }

    @Override // com.google.android.gms.common.internal.zzq
    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.f265wX) {
            if (!com.google.android.gms.common.zze.zze(null, callingUid)) {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
            this.f265wX = callingUid;
        }
        return null;
    }
}
