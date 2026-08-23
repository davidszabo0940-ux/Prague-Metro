package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqz;

/* JADX INFO: loaded from: classes.dex */
public final class PendingResults {

    private static final class zza<R extends Result> extends zzpt<R> {

        /* JADX INFO: renamed from: sb */
        private final R f147sb;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.f147sb = r;
        }

        @Override // com.google.android.gms.internal.zzpt
        protected R zzc(Status status) {
            if (status.getStatusCode() != this.f147sb.getStatus().getStatusCode()) {
                throw new UnsupportedOperationException("Creating failed results is not supported");
            }
            return this.f147sb;
        }
    }

    private static final class zzb<R extends Result> extends zzpt<R> {

        /* JADX INFO: renamed from: sc */
        private final R f148sc;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.f148sc = r;
        }

        @Override // com.google.android.gms.internal.zzpt
        protected R zzc(Status status) {
            return this.f148sc;
        }
    }

    private static final class zzc<R extends Result> extends zzpt<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzpt
        protected R zzc(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        zzqz zzqzVar = new zzqz(Looper.getMainLooper());
        zzqzVar.cancel();
        return zzqzVar;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        zzab.zzb(r, "Result must not be null");
        zzab.zzb(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zza zzaVar = new zza(r);
        zzaVar.cancel();
        return zzaVar;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        zzab.zzb(r, "Result must not be null");
        zzc zzcVar = new zzc(null);
        zzcVar.zzc(r);
        return new zzqv(zzcVar);
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        zzab.zzb(status, "Result must not be null");
        zzqz zzqzVar = new zzqz(Looper.getMainLooper());
        zzqzVar.zzc(status);
        return zzqzVar;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzab.zzb(r, "Result must not be null");
        zzab.zzb(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        zzb zzbVar = new zzb(googleApiClient, r);
        zzbVar.zzc(r);
        return zzbVar;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzab.zzb(status, "Result must not be null");
        zzqz zzqzVar = new zzqz(googleApiClient);
        zzqzVar.zzc(status);
        return zzqzVar;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzab.zzb(r, "Result must not be null");
        zzc zzcVar = new zzc(googleApiClient);
        zzcVar.zzc(r);
        return new zzqv(zzcVar);
    }
}
