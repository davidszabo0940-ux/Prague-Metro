package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzcw implements zzcx {
    @Override // com.google.android.gms.internal.zzcx
    public List<String> zza(AdRequestInfoParcel adRequestInfoParcel) {
        return adRequestInfoParcel.zzcbl == null ? Collections.emptyList() : adRequestInfoParcel.zzcbl;
    }
}
