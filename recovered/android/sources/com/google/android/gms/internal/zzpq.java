package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzpq extends zzpt<com.google.android.gms.common.api.zzb> {

    /* JADX INFO: renamed from: sx */
    private int f577sx;

    /* JADX INFO: renamed from: sy */
    private boolean f578sy;

    private void zza(ConnectionResult connectionResult) {
        SimpleArrayMap simpleArrayMap = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= simpleArrayMap.size()) {
                return;
            }
            zza((zzpo) simpleArrayMap.keyAt(i2), connectionResult);
            i = i2 + 1;
        }
    }

    public void zza(zzpo<?> zzpoVar, ConnectionResult connectionResult) {
        Object obj = null;
        synchronized (obj) {
            SimpleArrayMap simpleArrayMap = null;
            try {
                simpleArrayMap.put(zzpoVar, connectionResult);
                this.f577sx--;
                if (!connectionResult.isSuccess()) {
                    this.f578sy = true;
                }
                if (this.f577sx == 0) {
                    Status status = this.f578sy ? new Status(13) : Status.f151sg;
                    SimpleArrayMap simpleArrayMap2 = null;
                    zzc(simpleArrayMap2.size() == 1 ? new com.google.android.gms.common.api.zza(status, null) : new com.google.android.gms.common.api.zzb(status, null));
                }
                Object obj2 = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Set<zzpo<?>> zzaon() {
        Map map = null;
        return map.keySet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzpt
    /* JADX INFO: renamed from: zzy, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.common.api.zzb zzc(Status status) {
        Object obj = null;
        synchronized (obj) {
            try {
                zza(new ConnectionResult(8));
                SimpleArrayMap simpleArrayMap = null;
                com.google.android.gms.common.api.zzb zzaVar = simpleArrayMap.size() == 1 ? new com.google.android.gms.common.api.zza(status, null) : new com.google.android.gms.common.api.zzb(status, null);
                Object obj2 = null;
                return zzaVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
