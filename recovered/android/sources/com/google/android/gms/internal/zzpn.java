package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzpn {

    /* JADX INFO: renamed from: it */
    public final int f564it;

    /* JADX INFO: renamed from: sn */
    public final int f565sn;

    public static final class zza extends zzpn {

        /* JADX INFO: renamed from: so */
        public final zzpr.zza<? extends Result, Api.zzb> f566so;

        public zza(int i, int i2, zzpr.zza<? extends Result, Api.zzb> zzaVar) {
            super(i, i2);
            this.f566so = zzaVar;
        }

        @Override // com.google.android.gms.internal.zzpn
        public boolean cancel() {
            return this.f566so.zzaos();
        }

        @Override // com.google.android.gms.internal.zzpn
        public void zza(SparseArray<zzrd> sparseArray) {
            zzrd zzrdVar = sparseArray.get(this.f565sn);
            if (zzrdVar != null) {
                zzrdVar.zzg(this.f566so);
            }
        }

        @Override // com.google.android.gms.internal.zzpn
        public void zzb(Api.zzb zzbVar) throws DeadObjectException {
            this.f566so.zzb(zzbVar);
        }

        @Override // com.google.android.gms.internal.zzpn
        public void zzx(@NonNull Status status) {
            this.f566so.zzz(status);
        }
    }

    public static final class zzb<TResult> extends zzpn {

        /* JADX INFO: renamed from: sr */
        private static final Status f567sr = new Status(8, "Connection to Google Play services was lost while executing the API call.");

        /* JADX INFO: renamed from: sp */
        private final zzrb<Api.zzb, TResult> f568sp;

        /* JADX INFO: renamed from: sq */
        private final TaskCompletionSource<TResult> f569sq;

        public zzb(int i, int i2, zzrb<Api.zzb, TResult> zzrbVar, TaskCompletionSource<TResult> taskCompletionSource) {
            super(i, i2);
            this.f569sq = taskCompletionSource;
            this.f568sp = zzrbVar;
        }

        @Override // com.google.android.gms.internal.zzpn
        public void zzb(Api.zzb zzbVar) throws DeadObjectException {
            try {
                this.f568sp.zza(zzbVar, this.f569sq);
            } catch (DeadObjectException e) {
                zzx(f567sr);
                throw e;
            } catch (RemoteException e2) {
                zzx(f567sr);
            }
        }

        @Override // com.google.android.gms.internal.zzpn
        public void zzx(@NonNull Status status) {
            if (status.getStatusCode() == 8) {
                this.f569sq.setException(new FirebaseException(status.getStatusMessage()));
            } else {
                this.f569sq.setException(new FirebaseApiNotAvailableException(status.getStatusMessage()));
            }
        }
    }

    public zzpn(int i, int i2) {
        this.f565sn = i;
        this.f564it = i2;
    }

    public boolean cancel() {
        return true;
    }

    public void zza(SparseArray<zzrd> sparseArray) {
    }

    public abstract void zzb(Api.zzb zzbVar) throws DeadObjectException;

    public abstract void zzx(@NonNull Status status);
}
