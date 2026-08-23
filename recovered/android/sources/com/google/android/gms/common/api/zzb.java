package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzpo;

/* JADX INFO: loaded from: classes.dex */
public class zzb implements Result {

    /* JADX INFO: renamed from: cc */
    private final Status f161cc;

    /* JADX INFO: renamed from: rw */
    private final ArrayMap<zzpo<?>, ConnectionResult> f162rw;

    public zzb(Status status, ArrayMap<zzpo<?>, ConnectionResult> arrayMap) {
        this.f161cc = status;
        this.f162rw = arrayMap;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f161cc;
    }
}
