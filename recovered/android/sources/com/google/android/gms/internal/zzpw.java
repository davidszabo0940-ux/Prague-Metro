package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class zzpw extends zzps {
    @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzqo
    public void onStop() {
        zzqh zzqhVar = null;
        com.google.android.gms.common.util.zza zzaVar = null;
        super.onStop();
        Iterator it = ((com.google.android.gms.common.util.zza) null).iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.zzc) it.next()).release();
        }
        zzaVar.clear();
        zzqhVar.zza(this);
    }

    @Override // com.google.android.gms.internal.zzps
    protected void zza(ConnectionResult connectionResult, int i) {
        zzqh zzqhVar = null;
        zzqhVar.zza(connectionResult, i);
    }

    @Override // com.google.android.gms.internal.zzps
    protected void zzaol() {
        zzqh zzqhVar = null;
        zzqhVar.zzaol();
    }
}
