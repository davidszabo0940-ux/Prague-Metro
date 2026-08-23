package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzui;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class zzb {

    /* JADX INFO: renamed from: QA */
    private static SharedPreferences f535QA = null;

    public static SharedPreferences zzn(final Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f535QA == null) {
                f535QA = (SharedPreferences) zzui.zzb(new Callable<SharedPreferences>() { // from class: com.google.android.gms.flags.impl.zzb.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: zzbfv, reason: merged with bridge method [inline-methods] */
                    public SharedPreferences call() {
                        return context.getSharedPreferences("google_sdk_flags", 1);
                    }
                });
            }
            sharedPreferences = f535QA;
        }
        return sharedPreferences;
    }
}
