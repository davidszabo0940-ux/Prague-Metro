package com.google.android.gms.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;

/* JADX INFO: loaded from: classes.dex */
public class zzqn {

    /* JADX INFO: renamed from: uZ */
    private final Object f762uZ;

    public zzqn(Activity activity) {
        com.google.android.gms.common.internal.zzab.zzb(activity, "Activity must not be null");
        com.google.android.gms.common.internal.zzab.zzb(com.google.android.gms.common.util.zzs.zzavj() || (activity instanceof FragmentActivity), "This Activity is not supported before platform version 11 (3.0 Honeycomb). Please use FragmentActivity instead.");
        this.f762uZ = activity;
    }

    public boolean zzaqm() {
        return this.f762uZ instanceof FragmentActivity;
    }

    public Activity zzaqn() {
        return (Activity) this.f762uZ;
    }

    public FragmentActivity zzaqo() {
        return (FragmentActivity) this.f762uZ;
    }
}
