package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.EnvironmentCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;

/* JADX INFO: loaded from: classes.dex */
public class PlaceReport extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zzj();
    private final String aeL;
    private final String mTag;
    final int mVersionCode;
    private final String zzcus;

    PlaceReport(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.aeL = str;
        this.mTag = str2;
        this.zzcus = str3;
    }

    public static PlaceReport create(String str, String str2) {
        return zzk(str, str2, EnvironmentCompat.MEDIA_UNKNOWN);
    }

    public static PlaceReport zzk(String str, String str2, String str3) {
        zzab.zzaa(str);
        zzab.zzhs(str2);
        zzab.zzhs(str3);
        zzab.zzb(zzkq(str3), "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    private static boolean zzkq(String str) {
        switch (str) {
            case "unknown":
            case "userReported":
            case "inferredGeofencing":
            case "inferredRadioSignals":
            case "inferredReverseGeocoding":
            case "inferredSnappedToRoad":
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzaa.equal(this.aeL, placeReport.aeL) && zzaa.equal(this.mTag, placeReport.mTag) && zzaa.equal(this.zzcus, placeReport.zzcus);
    }

    public String getPlaceId() {
        return this.aeL;
    }

    public String getSource() {
        return this.zzcus;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzaa.hashCode(this.aeL, this.mTag, this.zzcus);
    }

    public String toString() {
        zzaa.zza zzaVarZzz = zzaa.zzz(this);
        zzaVarZzz.zzg("placeId", this.aeL);
        zzaVarZzz.zzg("tag", this.mTag);
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(this.zzcus)) {
            zzaVarZzz.zzg("source", this.zzcus);
        }
        return zzaVarZzz.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
