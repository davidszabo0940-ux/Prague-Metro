package com.google.android.gms.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzdf {
    public zzde zza(zzdd zzddVar) {
        if (zzddVar == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        }
        if (!zzddVar.zzjz()) {
            zzkh.m95v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        }
        if (zzddVar.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzddVar.zzhl())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        return new zzde(zzddVar.getContext(), zzddVar.zzhl(), zzddVar.zzka(), zzddVar.zzkb());
    }
}
