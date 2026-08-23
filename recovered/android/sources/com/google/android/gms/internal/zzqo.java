package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class zzqo {

    /* JADX INFO: renamed from: va */
    protected final zzqp f763va;

    protected zzqo(zzqp zzqpVar) {
        this.f763va = zzqpVar;
    }

    protected static zzqp zzc(zzqn zzqnVar) {
        return zzqnVar.zzaqm() ? zzra.zza(zzqnVar.zzaqo()) : zzqq.zzt(zzqnVar.zzaqn());
    }

    protected static zzqp zzs(Activity activity) {
        return zzc(new zzqn(activity));
    }

    @MainThread
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        return this.f763va.zzaqp();
    }

    @MainThread
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @MainThread
    public void onCreate(Bundle bundle) {
    }

    @MainThread
    public void onSaveInstanceState(Bundle bundle) {
    }

    @MainThread
    public void onStart() {
    }

    @MainThread
    public void onStop() {
    }
}
