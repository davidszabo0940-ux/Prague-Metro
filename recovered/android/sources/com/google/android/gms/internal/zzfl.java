package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzfl {
    private Context mContext;
    private final com.google.android.gms.ads.internal.zzd zzajv;
    private final zzgn zzajz;
    private final VersionInfoParcel zzalm;

    zzfl(Context context, zzgn zzgnVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zzd zzdVar) {
        this.mContext = context;
        this.zzajz = zzgnVar;
        this.zzalm = versionInfoParcel;
        this.zzajv = zzdVar;
    }

    public Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    public com.google.android.gms.ads.internal.zzl zzbd(String str) {
        return new com.google.android.gms.ads.internal.zzl(this.mContext, new AdSizeParcel(), str, this.zzajz, this.zzalm, this.zzajv);
    }

    public com.google.android.gms.ads.internal.zzl zzbe(String str) {
        return new com.google.android.gms.ads.internal.zzl(this.mContext.getApplicationContext(), new AdSizeParcel(), str, this.zzajz, this.zzalm, this.zzajv);
    }

    public zzfl zzlp() {
        return new zzfl(getApplicationContext(), this.zzajz, this.zzalm, this.zzajv);
    }
}
