package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zze extends com.google.android.gms.common.internal.zzd<zzk> {
    final int zzcat;

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzd.zzb zzbVar, com.google.android.gms.common.internal.zzd.zzc zzcVar, int i) {
        super(context, looper, 8, zzbVar, zzcVar, null);
        this.zzcat = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: zzba, reason: merged with bridge method [inline-methods] */
    public zzk zzbb(IBinder iBinder) {
        return zzk.zza.zzbc(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected String zzra() {
        return "com.google.android.gms.ads.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected String zzrb() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public zzk zzrc() throws DeadObjectException {
        return (zzk) super.zzarw();
    }
}
