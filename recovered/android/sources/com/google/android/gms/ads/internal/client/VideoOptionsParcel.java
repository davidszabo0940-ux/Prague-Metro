package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class VideoOptionsParcel extends AbstractSafeParcelable {
    public static final zzaq CREATOR = new zzaq();
    public final int versionCode;
    public final boolean zzaxk;

    public VideoOptionsParcel(int i, boolean z) {
        this.versionCode = i;
        this.zzaxk = z;
    }

    public VideoOptionsParcel(VideoOptions videoOptions) {
        this(1, videoOptions.getStartMuted());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaq.zza(this, parcel, i);
    }
}
