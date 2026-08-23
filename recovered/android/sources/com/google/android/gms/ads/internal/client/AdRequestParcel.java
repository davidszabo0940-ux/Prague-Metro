package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class AdRequestParcel extends AbstractSafeParcelable {
    public static final zzg CREATOR = new zzg();
    public final Bundle extras;
    public final int versionCode;
    public final long zzatk;
    public final int zzatl;
    public final List<String> zzatm;
    public final boolean zzatn;
    public final int zzato;
    public final boolean zzatp;
    public final String zzatq;
    public final SearchAdRequestParcel zzatr;
    public final Location zzats;
    public final String zzatt;
    public final Bundle zzatu;
    public final Bundle zzatv;
    public final List<String> zzatw;
    public final String zzatx;
    public final String zzaty;
    public final boolean zzatz;

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.versionCode = i;
        this.zzatk = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzatl = i2;
        this.zzatm = list;
        this.zzatn = z;
        this.zzato = i3;
        this.zzatp = z2;
        this.zzatq = str;
        this.zzatr = searchAdRequestParcel;
        this.zzats = location;
        this.zzatt = str2;
        this.zzatu = bundle2;
        this.zzatv = bundle3;
        this.zzatw = list2;
        this.zzatx = str3;
        this.zzaty = str4;
        this.zzatz = z3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel) obj;
        return this.versionCode == adRequestParcel.versionCode && this.zzatk == adRequestParcel.zzatk && com.google.android.gms.common.internal.zzaa.equal(this.extras, adRequestParcel.extras) && this.zzatl == adRequestParcel.zzatl && com.google.android.gms.common.internal.zzaa.equal(this.zzatm, adRequestParcel.zzatm) && this.zzatn == adRequestParcel.zzatn && this.zzato == adRequestParcel.zzato && this.zzatp == adRequestParcel.zzatp && com.google.android.gms.common.internal.zzaa.equal(this.zzatq, adRequestParcel.zzatq) && com.google.android.gms.common.internal.zzaa.equal(this.zzatr, adRequestParcel.zzatr) && com.google.android.gms.common.internal.zzaa.equal(this.zzats, adRequestParcel.zzats) && com.google.android.gms.common.internal.zzaa.equal(this.zzatt, adRequestParcel.zzatt) && com.google.android.gms.common.internal.zzaa.equal(this.zzatu, adRequestParcel.zzatu) && com.google.android.gms.common.internal.zzaa.equal(this.zzatv, adRequestParcel.zzatv) && com.google.android.gms.common.internal.zzaa.equal(this.zzatw, adRequestParcel.zzatw) && com.google.android.gms.common.internal.zzaa.equal(this.zzatx, adRequestParcel.zzatx) && com.google.android.gms.common.internal.zzaa.equal(this.zzaty, adRequestParcel.zzaty) && this.zzatz == adRequestParcel.zzatz;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzaa.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzatk), this.extras, Integer.valueOf(this.zzatl), this.zzatm, Boolean.valueOf(this.zzatn), Integer.valueOf(this.zzato), Boolean.valueOf(this.zzatp), this.zzatq, this.zzatr, this.zzats, this.zzatt, this.zzatu, this.zzatv, this.zzatw, this.zzatx, this.zzaty, Boolean.valueOf(this.zzatz));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
