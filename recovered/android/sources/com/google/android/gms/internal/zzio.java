package com.google.android.gms.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzio implements zzim.zza<com.google.android.gms.ads.internal.formats.zze> {
    private final boolean zzcae;
    private final boolean zzcaf;

    public zzio(boolean z, boolean z2) {
        this.zzcae = z;
        this.zzcaf = z2;
    }

    @Override // com.google.android.gms.internal.zzim.zza
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zze zza(zzim zzimVar, JSONObject jSONObject) throws ExecutionException, JSONException, InterruptedException {
        List<zzlc<com.google.android.gms.ads.internal.formats.zzc>> listZza = zzimVar.zza(jSONObject, "images", true, this.zzcae, this.zzcaf);
        zzlc<com.google.android.gms.ads.internal.formats.zzc> zzlcVarZza = zzimVar.zza(jSONObject, "secondary_image", false, this.zzcae);
        zzlc<com.google.android.gms.ads.internal.formats.zza> zzlcVarZzg = zzimVar.zzg(jSONObject);
        ArrayList arrayList = new ArrayList();
        Iterator<zzlc<com.google.android.gms.ads.internal.formats.zzc>> it = listZza.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        return new com.google.android.gms.ads.internal.formats.zze(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), zzlcVarZza.get(), jSONObject.getString("call_to_action"), jSONObject.getString("advertiser"), zzlcVarZzg.get(), new Bundle());
    }
}
