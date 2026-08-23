package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzpt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Batch extends zzpt<BatchResult> {

    /* JADX INFO: renamed from: rA */
    private final PendingResult<?>[] f118rA;

    /* JADX INFO: renamed from: rx */
    private int f119rx;

    /* JADX INFO: renamed from: ry */
    private boolean f120ry;

    /* JADX INFO: renamed from: rz */
    private boolean f121rz;
    private final Object zzail;

    public static final class Builder {

        /* JADX INFO: renamed from: hb */
        private GoogleApiClient f123hb;

        /* JADX INFO: renamed from: rC */
        private List<PendingResult<?>> f124rC = new ArrayList();

        public Builder(GoogleApiClient googleApiClient) {
            this.f123hb = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.f124rC.size());
            this.f124rC.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.f124rC, this.f123hb);
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzail = new Object();
        this.f119rx = list.size();
        this.f118rA = new PendingResult[this.f119rx];
        if (list.isEmpty()) {
            zzc(new BatchResult(Status.f151sg, this.f118rA));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            PendingResult<?> pendingResult = list.get(i2);
            this.f118rA[i2] = pendingResult;
            pendingResult.zza(new PendingResult.zza() { // from class: com.google.android.gms.common.api.Batch.1
                @Override // com.google.android.gms.common.api.PendingResult.zza
                public void zzv(Status status) {
                    synchronized (Batch.this.zzail) {
                        if (Batch.this.isCanceled()) {
                            return;
                        }
                        if (status.isCanceled()) {
                            Batch.this.f121rz = true;
                        } else if (!status.isSuccess()) {
                            Batch.this.f120ry = true;
                        }
                        Batch.zzb(Batch.this);
                        if (Batch.this.f119rx == 0) {
                            if (Batch.this.f121rz) {
                                Batch.super.cancel();
                            } else {
                                Batch.this.zzc(new BatchResult(Batch.this.f120ry ? new Status(13) : Status.f151sg, Batch.this.f118rA));
                            }
                        }
                    }
                }
            });
            i = i2 + 1;
        }
    }

    static /* synthetic */ int zzb(Batch batch) {
        int i = batch.f119rx;
        batch.f119rx = i - 1;
        return i;
    }

    @Override // com.google.android.gms.internal.zzpt, com.google.android.gms.common.api.PendingResult
    public void cancel() {
        super.cancel();
        for (PendingResult<?> pendingResult : this.f118rA) {
            pendingResult.cancel();
        }
    }

    @Override // com.google.android.gms.internal.zzpt
    /* JADX INFO: renamed from: createFailedResult, reason: merged with bridge method [inline-methods] */
    public BatchResult zzc(Status status) {
        return new BatchResult(status, this.f118rA);
    }
}
