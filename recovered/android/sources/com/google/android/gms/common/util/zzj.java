package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzj {

    /* JADX INFO: renamed from: AQ */
    private static long f466AQ;

    /* JADX INFO: renamed from: AP */
    private static IntentFilter f465AP = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* JADX INFO: renamed from: AR */
    private static float f467AR = Float.NaN;

    @TargetApi(20)
    public static boolean zzb(PowerManager powerManager) {
        return zzs.zzavr() ? powerManager.isInteractive() : powerManager.isScreenOn();
    }

    @TargetApi(20)
    public static int zzcm(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent intentRegisterReceiver = context.getApplicationContext().registerReceiver(null, f465AP);
        boolean z = ((intentRegisterReceiver == null ? 0 : intentRegisterReceiver.getIntExtra("plugged", 0)) & 7) != 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return ((zzb(powerManager) ? 1 : 0) << 1) | (z ? 1 : 0);
    }

    public static synchronized float zzcn(Context context) {
        float f;
        if (SystemClock.elapsedRealtime() - f466AQ >= 60000 || Float.isNaN(f467AR)) {
            Intent intentRegisterReceiver = context.getApplicationContext().registerReceiver(null, f465AP);
            if (intentRegisterReceiver != null) {
                f467AR = intentRegisterReceiver.getIntExtra("level", -1) / intentRegisterReceiver.getIntExtra("scale", -1);
            }
            f466AQ = SystemClock.elapsedRealtime();
            f = f467AR;
        } else {
            f = f467AR;
        }
        return f;
    }
}
