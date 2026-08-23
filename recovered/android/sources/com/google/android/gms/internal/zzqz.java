package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class zzqz extends zzpt<Status> {
    @Deprecated
    public zzqz(Looper looper) {
        super(looper);
    }

    public zzqz(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzpt
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public Status zzc(Status status) {
        return status;
    }
}
