package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class zzap extends zzaq {
    private static final String TAG = zzap.class.getSimpleName();
    private AdvertisingIdClient.Info zzafm;

    protected zzap(Context context) {
        super(context, "");
    }

    public static zzap zze(Context context) {
        zza(context, true);
        return new zzap(context);
    }

    public String zza(String str, String str2) {
        return zzak.zza(str, str2, true);
    }

    public void zza(AdvertisingIdClient.Info info) {
        this.zzafm = info;
    }

    @Override // com.google.android.gms.internal.zzaq
    protected void zza(zzax zzaxVar, zzae.zza zzaVar) {
        if (!zzaxVar.zzcj()) {
            zza(zzb(zzaxVar, zzaVar));
            return;
        }
        if (this.zzafm != null) {
            String id = this.zzafm.getId();
            if (!TextUtils.isEmpty(id)) {
                zzaVar.zzeg = zzay.zzo(id);
                zzaVar.zzeh = 5;
                zzaVar.zzei = Boolean.valueOf(this.zzafm.isLimitAdTrackingEnabled());
            }
            this.zzafm = null;
        }
    }

    @Override // com.google.android.gms.internal.zzaq
    protected List<Callable<Void>> zzb(zzax zzaxVar, zzae.zza zzaVar) {
        ArrayList arrayList = new ArrayList();
        if (zzaxVar.zzce() == null) {
            return arrayList;
        }
        arrayList.add(new zzbh(zzaxVar, zzav.zzbm(), zzav.zzbn(), zzaVar, zzaxVar.zzau(), 24));
        return arrayList;
    }

    @Override // com.google.android.gms.internal.zzaq, com.google.android.gms.internal.zzao
    protected zzae.zza zzd(Context context) {
        return null;
    }
}
