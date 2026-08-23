package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class BatchResult implements Result {

    /* JADX INFO: renamed from: cc */
    private final Status f125cc;

    /* JADX INFO: renamed from: rA */
    private final PendingResult<?>[] f126rA;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.f125cc = status;
        this.f126rA = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f125cc;
    }

    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        zzab.zzb(batchResultToken.mId < this.f126rA.length, "The result token does not belong to this batch");
        return (R) this.f126rA[batchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
}
