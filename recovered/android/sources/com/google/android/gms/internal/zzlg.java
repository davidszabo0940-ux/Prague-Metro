package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzlg {
    public void zza(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        new zzlh(view, onGlobalLayoutListener).zzub();
    }

    public void zza(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        new zzli(view, onScrollChangedListener).zzub();
    }
}
