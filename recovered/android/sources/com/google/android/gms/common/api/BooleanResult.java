package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzab;

/* JADX INFO: loaded from: classes.dex */
public class BooleanResult implements Result {

    /* JADX INFO: renamed from: cc */
    private final Status f127cc;

    /* JADX INFO: renamed from: rD */
    private final boolean f128rD;

    public BooleanResult(Status status, boolean z) {
        this.f127cc = (Status) zzab.zzb(status, "Status must not be null");
        this.f128rD = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.f127cc.equals(booleanResult.f127cc) && this.f128rD == booleanResult.f128rD;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f127cc;
    }

    public boolean getValue() {
        return this.f128rD;
    }

    public final int hashCode() {
        return (this.f128rD ? 1 : 0) + ((this.f127cc.hashCode() + 527) * 31);
    }
}
