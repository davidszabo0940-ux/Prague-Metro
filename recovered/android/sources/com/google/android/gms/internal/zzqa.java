package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class zzqa implements zzqe {

    /* JADX INFO: renamed from: tm */
    private final zzqf f626tm;

    /* JADX INFO: renamed from: tn */
    private boolean f627tn = false;

    public zzqa(zzqf zzqfVar) {
        this.f626tm = zzqfVar;
    }

    private <A extends Api.zzb> void zzf(zzpr.zza<? extends Result, A> zzaVar) throws DeadObjectException {
        this.f626tm.f704sX.f689ue.zzg(zzaVar);
        Api.zze zzeVarZzb = this.f626tm.f704sX.zzb((Api.zzc<?>) zzaVar.zzanp());
        if (!zzeVarZzb.isConnected() && this.f626tm.f712un.containsKey(zzaVar.zzanp())) {
            zzaVar.zzz(new Status(17));
            return;
        }
        boolean z = zzeVarZzb instanceof com.google.android.gms.common.internal.zzah;
        Object objZzatj = zzeVarZzb;
        if (z) {
            objZzatj = ((com.google.android.gms.common.internal.zzah) zzeVarZzb).zzatj();
        }
        zzaVar.zzb(objZzatj);
    }

    @Override // com.google.android.gms.internal.zzqe
    public void begin() {
    }

    @Override // com.google.android.gms.internal.zzqe
    public void connect() {
        if (this.f627tn) {
            this.f627tn = false;
            this.f626tm.zza(new zzqf.zza(this) { // from class: com.google.android.gms.internal.zzqa.2
                @Override // com.google.android.gms.internal.zzqf.zza
                public void zzapi() {
                    zzqa.this.f626tm.f716ur.zzm(null);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.zzqe
    public boolean disconnect() {
        if (this.f627tn) {
            return false;
        }
        if (!this.f626tm.f704sX.zzapu()) {
            this.f626tm.zzi(null);
            return true;
        }
        this.f627tn = true;
        Iterator<zzrc> it = this.f626tm.f704sX.f688ud.iterator();
        while (it.hasNext()) {
            it.next().zzaqt();
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzqe
    public void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.zzqe
    public void onConnectionSuspended(int i) {
        this.f626tm.zzi(null);
        this.f626tm.f716ur.zzc(i, this.f627tn);
    }

    @Override // com.google.android.gms.internal.zzqe
    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    void zzaph() {
        if (this.f627tn) {
            this.f627tn = false;
            this.f626tm.f704sX.f689ue.release();
            disconnect();
        }
    }

    @Override // com.google.android.gms.internal.zzqe
    public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(T t) {
        return (T) zzd(t);
    }

    @Override // com.google.android.gms.internal.zzqe
    public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(T t) {
        try {
            zzf(t);
        } catch (DeadObjectException e) {
            this.f626tm.zza(new zzqf.zza(this) { // from class: com.google.android.gms.internal.zzqa.1
                @Override // com.google.android.gms.internal.zzqf.zza
                public void zzapi() {
                    zzqa.this.onConnectionSuspended(1);
                }
            });
        }
        return t;
    }
}
