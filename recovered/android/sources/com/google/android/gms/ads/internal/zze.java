package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkh;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zze {
    private final Context mContext;
    private final AutoClickProtectionConfigurationParcel zzakn;
    private boolean zzako;

    public zze(Context context) {
        this(context, false);
    }

    public zze(Context context, zzjy.zza zzaVar) {
        this.mContext = context;
        if (zzaVar == null || zzaVar.zzciu.zzccv == null) {
            this.zzakn = new AutoClickProtectionConfigurationParcel();
        } else {
            this.zzakn = zzaVar.zzciu.zzccv;
        }
    }

    public zze(Context context, boolean z) {
        this.mContext = context;
        this.zzakn = new AutoClickProtectionConfigurationParcel(z);
    }

    public void recordClick() {
        this.zzako = true;
    }

    public boolean zzem() {
        return !this.zzakn.zzccy || this.zzako;
    }

    public void zzt(String str) {
        if (str == null) {
            str = "";
        }
        zzkh.zzcx("Action was blocked because no touch was detected.");
        if (!this.zzakn.zzccy || this.zzakn.zzccz == null) {
            return;
        }
        for (String str2 : this.zzakn.zzccz) {
            if (!TextUtils.isEmpty(str2)) {
                zzu.zzfq().zzc(this.mContext, "", str2.replace("{NAVIGATION_URL}", Uri.encode(str)));
            }
        }
    }
}
