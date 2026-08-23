package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzpy implements Releasable, Result {

    /* JADX INFO: renamed from: cc */
    protected final Status f623cc;

    /* JADX INFO: renamed from: tk */
    protected final DataHolder f624tk;

    protected zzpy(DataHolder dataHolder, Status status) {
        this.f623cc = status;
        this.f624tk = dataHolder;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f623cc;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
        if (this.f624tk != null) {
            this.f624tk.close();
        }
    }
}
