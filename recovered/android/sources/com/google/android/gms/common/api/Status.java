package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements Result {
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;

    /* JADX INFO: renamed from: ob */
    private final int f158ob;

    /* JADX INFO: renamed from: qS */
    private final String f159qS;

    /* JADX INFO: renamed from: sg */
    public static final Status f151sg = new Status(0);

    /* JADX INFO: renamed from: sh */
    public static final Status f152sh = new Status(14);

    /* JADX INFO: renamed from: si */
    public static final Status f153si = new Status(8);

    /* JADX INFO: renamed from: sj */
    public static final Status f154sj = new Status(15);

    /* JADX INFO: renamed from: sk */
    public static final Status f155sk = new Status(16);

    /* JADX INFO: renamed from: sl */
    public static final Status f156sl = new Status(17);

    /* JADX INFO: renamed from: sm */
    public static final Status f157sm = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new zzf();

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.mVersionCode = i;
        this.f158ob = i2;
        this.f159qS = str;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String zzaoj() {
        return this.f159qS != null ? this.f159qS : CommonStatusCodes.getStatusCodeString(this.f158ob);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.mVersionCode == status.mVersionCode && this.f158ob == status.f158ob && zzaa.equal(this.f159qS, status.f159qS) && zzaa.equal(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.f158ob;
    }

    @Nullable
    public String getStatusMessage() {
        return this.f159qS;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.mVersionCode), Integer.valueOf(this.f158ob), this.f159qS, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.f158ob == 16;
    }

    public boolean isInterrupted() {
        return this.f158ob == 14;
    }

    public boolean isSuccess() {
        return this.f158ob <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzaa.zzz(this).zzg("statusCode", zzaoj()).zzg("resolution", this.mPendingIntent).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    PendingIntent zzaoi() {
        return this.mPendingIntent;
    }
}
