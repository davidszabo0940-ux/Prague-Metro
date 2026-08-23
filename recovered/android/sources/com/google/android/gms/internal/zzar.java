package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class zzar extends zzaq {
    private static final String TAG = zzar.class.getSimpleName();

    protected zzar(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzar zza(String str, Context context, boolean z) {
        zza(context, z);
        return new zzar(context, str, z);
    }

    @Override // com.google.android.gms.internal.zzaq
    protected List<Callable<Void>> zzb(zzax zzaxVar, zzae.zza zzaVar) {
        if (zzaxVar.zzce() == null || !this.zzafn) {
            return super.zzb(zzaxVar, zzaVar);
        }
        int iZzau = zzaxVar.zzau();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzb(zzaxVar, zzaVar));
        arrayList.add(new zzbh(zzaxVar, zzav.zzbm(), zzav.zzbn(), zzaVar, iZzau, 24));
        return arrayList;
    }
}
