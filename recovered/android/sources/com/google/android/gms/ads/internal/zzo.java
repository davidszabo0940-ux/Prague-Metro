package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzo extends zzz.zza {
    private static final Object zzamp = new Object();
    private static zzo zzamq;
    private final Context mContext;
    private boolean zzams;
    private VersionInfoParcel zzamu;
    private final Object zzail = new Object();
    private float zzamt = -1.0f;
    private boolean zzamr = false;

    zzo(Context context, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzamu = versionInfoParcel;
    }

    public static zzo zza(Context context, VersionInfoParcel versionInfoParcel) {
        zzo zzoVar;
        synchronized (zzamp) {
            if (zzamq == null) {
                zzamq = new zzo(context.getApplicationContext(), versionInfoParcel);
            }
            zzoVar = zzamq;
        }
        return zzoVar;
    }

    public static zzo zzex() {
        zzo zzoVar;
        synchronized (zzamp) {
            zzoVar = zzamq;
        }
        return zzoVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzz
    public void initialize() {
        synchronized (zzamp) {
            if (this.zzamr) {
                zzkh.zzcy("Mobile ads is initialized already.");
            } else {
                this.zzamr = true;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzz
    public void setAppMuted(boolean z) {
        synchronized (this.zzail) {
            this.zzams = z;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzz
    public void setAppVolume(float f) {
        synchronized (this.zzail) {
            this.zzamt = f;
        }
    }

    public float zzey() {
        float f;
        synchronized (this.zzail) {
            f = this.zzamt;
        }
        return f;
    }

    public boolean zzez() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzamt >= 0.0f;
        }
        return z;
    }

    public boolean zzfa() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzams;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzz
    public void zzu(String str) {
        zzdc.initialize(this.mContext);
        if (TextUtils.isEmpty(str) || !zzdc.zzbcr.get().booleanValue()) {
            return;
        }
        zzu.zzgi().zza(this.mContext, this.zzamu, true, null, str, null);
    }
}
