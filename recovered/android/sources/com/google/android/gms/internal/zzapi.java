package com.google.android.gms.internal;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class zzapi extends CustomTabsServiceConnection {
    private WeakReference<zzapj> bjc;

    public zzapi(zzapj zzapjVar) {
        this.bjc = new WeakReference<>(zzapjVar);
    }

    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzapj zzapjVar = this.bjc.get();
        if (zzapjVar != null) {
            zzapjVar.zza(customTabsClient);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzapj zzapjVar = this.bjc.get();
        if (zzapjVar != null) {
            zzapjVar.zzkm();
        }
    }
}
