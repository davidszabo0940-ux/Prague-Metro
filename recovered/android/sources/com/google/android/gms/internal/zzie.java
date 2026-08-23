package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzie extends zzic {
    private zzid zzbyk;

    zzie(Context context, zzjy.zza zzaVar, zzll zzllVar, zzig.zza zzaVar2) {
        super(context, zzaVar, zzllVar, zzaVar2);
    }

    @Override // com.google.android.gms.internal.zzic
    protected void zzpx() {
        int i;
        int i2;
        AdSizeParcel adSizeParcelZzdo = this.zzbgj.zzdo();
        if (adSizeParcelZzdo.zzauq) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        } else {
            i = adSizeParcelZzdo.widthPixels;
            i2 = adSizeParcelZzdo.heightPixels;
        }
        this.zzbyk = new zzid(this, this.zzbgj, i, i2);
        this.zzbgj.zzuk().zza(this);
        this.zzbyk.zza(this.zzbxw);
    }

    @Override // com.google.android.gms.internal.zzic
    protected int zzpy() {
        if (!this.zzbyk.zzqc()) {
            return !this.zzbyk.zzqd() ? 2 : -2;
        }
        zzkh.zzcw("Ad-Network indicated no fill with passback URL.");
        return 3;
    }
}
