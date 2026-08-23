package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzj();
    final int version;

    /* JADX INFO: renamed from: yi */
    final int f242yi;

    /* JADX INFO: renamed from: yj */
    int f243yj;

    /* JADX INFO: renamed from: yk */
    String f244yk;

    /* JADX INFO: renamed from: yl */
    IBinder f245yl;

    /* JADX INFO: renamed from: ym */
    Scope[] f246ym;

    /* JADX INFO: renamed from: yn */
    Bundle f247yn;

    /* JADX INFO: renamed from: yo */
    Account f248yo;

    /* JADX INFO: renamed from: yp */
    long f249yp;

    public GetServiceRequest(int i) {
        this.version = 3;
        this.f243yj = com.google.android.gms.common.zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.f242yi = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, long j) {
        this.version = i;
        this.f242yi = i2;
        this.f243yj = i3;
        this.f244yk = str;
        if (i < 2) {
            this.f248yo = zzdo(iBinder);
        } else {
            this.f245yl = iBinder;
            this.f248yo = account;
        }
        this.f246ym = scopeArr;
        this.f247yn = bundle;
        this.f249yp = j;
    }

    private Account zzdo(IBinder iBinder) {
        if (iBinder != null) {
            return zza.zza(zzq.zza.zzdp(iBinder));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public GetServiceRequest zzb(zzq zzqVar) {
        if (zzqVar != null) {
            this.f245yl = zzqVar.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzd(Account account) {
        this.f248yo = account;
        return this;
    }

    public GetServiceRequest zzf(Collection<Scope> collection) {
        this.f246ym = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzhm(String str) {
        this.f244yk = str;
        return this;
    }

    public GetServiceRequest zzn(Bundle bundle) {
        this.f247yn = bundle;
        return this;
    }
}
