package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzlk {
    private final Context mContext;
    private final zzll zzbgj;
    private com.google.android.gms.ads.internal.overlay.zzk zzbwj;
    private final ViewGroup zzcom;

    public zzlk(Context context, ViewGroup viewGroup, zzll zzllVar) {
        this(context, viewGroup, zzllVar, null);
    }

    zzlk(Context context, ViewGroup viewGroup, zzll zzllVar, com.google.android.gms.ads.internal.overlay.zzk zzkVar) {
        this.mContext = context;
        this.zzcom = viewGroup;
        this.zzbgj = zzllVar;
        this.zzbwj = zzkVar;
    }

    public void onDestroy() {
        com.google.android.gms.common.internal.zzab.zzhj("onDestroy must be called from the UI thread.");
        if (this.zzbwj != null) {
            this.zzbwj.destroy();
            this.zzcom.removeView(this.zzbwj);
            this.zzbwj = null;
        }
    }

    public void onPause() {
        com.google.android.gms.common.internal.zzab.zzhj("onPause must be called from the UI thread.");
        if (this.zzbwj != null) {
            this.zzbwj.pause();
        }
    }

    public void zza(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (this.zzbwj != null) {
            return;
        }
        zzdg.zza(this.zzbgj.zzut().zzkf(), this.zzbgj.zzus(), "vpr");
        this.zzbwj = new com.google.android.gms.ads.internal.overlay.zzk(this.mContext, this.zzbgj, i5, z, this.zzbgj.zzut().zzkf(), zzdg.zzb(this.zzbgj.zzut().zzkf()));
        this.zzcom.addView(this.zzbwj, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzbwj.zzd(i, i2, i3, i4);
        this.zzbgj.zzuk().zzak(false);
    }

    public void zze(int i, int i2, int i3, int i4) {
        com.google.android.gms.common.internal.zzab.zzhj("The underlay may only be modified from the UI thread.");
        if (this.zzbwj != null) {
            this.zzbwj.zzd(i, i2, i3, i4);
        }
    }

    public com.google.android.gms.ads.internal.overlay.zzk zzuc() {
        com.google.android.gms.common.internal.zzab.zzhj("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzbwj;
    }
}
