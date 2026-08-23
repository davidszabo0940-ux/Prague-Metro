package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class zzpr {

    public static abstract class zza<R extends Result, A extends Api.zzb> extends zzpt<R> implements zzb<R> {

        /* JADX INFO: renamed from: pD */
        private final Api<?> f579pD;

        /* JADX INFO: renamed from: sA */
        private AtomicReference<zzrd.zzb> f580sA;

        /* JADX INFO: renamed from: sz */
        private final Api.zzc<A> f581sz;

        @Deprecated
        protected zza(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) com.google.android.gms.common.internal.zzab.zzb(googleApiClient, "GoogleApiClient must not be null"));
            this.f580sA = new AtomicReference<>();
            this.f581sz = (Api.zzc) com.google.android.gms.common.internal.zzab.zzaa(zzcVar);
            this.f579pD = null;
        }

        protected zza(Api<?> api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) com.google.android.gms.common.internal.zzab.zzb(googleApiClient, "GoogleApiClient must not be null"));
            this.f580sA = new AtomicReference<>();
            this.f581sz = (Api.zzc<A>) api.zzanp();
            this.f579pD = api;
        }

        private void zza(RemoteException remoteException) {
            zzz(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        @Override // com.google.android.gms.internal.zzpr.zzb
        public /* synthetic */ void setResult(Object obj) {
            super.zzc((Result) obj);
        }

        protected abstract void zza(A a) throws RemoteException;

        public void zza(zzrd.zzb zzbVar) {
            this.f580sA.set(zzbVar);
        }

        public final Api.zzc<A> zzanp() {
            return this.f581sz;
        }

        public final Api<?> zzanw() {
            return this.f579pD;
        }

        public void zzaoo() {
            setResultCallback(null);
        }

        @Override // com.google.android.gms.internal.zzpt
        protected void zzaop() {
            zzrd.zzb andSet = this.f580sA.getAndSet(null);
            if (andSet != null) {
                andSet.zzh(this);
            }
        }

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza(a);
            } catch (DeadObjectException e) {
                zza(e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        protected void zzb(R r) {
        }

        @Override // com.google.android.gms.internal.zzpr.zzb
        public final void zzz(Status status) {
            com.google.android.gms.common.internal.zzab.zzb(!status.isSuccess(), "Failed result must not be success");
            R rZzc = zzc(status);
            zzc(rZzc);
            zzb(rZzc);
        }
    }

    public interface zzb<R> {
        void setResult(R r);

        void zzz(Status status);
    }
}
