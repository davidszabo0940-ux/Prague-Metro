package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzj;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzh {

    /* JADX INFO: renamed from: AI */
    private static Boolean f458AI;
    private static String TAG = "WakeLockTracker";

    /* JADX INFO: renamed from: AH */
    private static zzh f457AH = new zzh();

    public static zzh zzave() {
        return f457AH;
    }

    private static boolean zzci(Context context) {
        if (f458AI == null) {
            f458AI = Boolean.valueOf(zzcj(context));
        }
        return f458AI.booleanValue();
    }

    private static boolean zzcj(Context context) {
        try {
            if (com.google.android.gms.common.util.zzd.zzabc()) {
                return zzc.zzb.f444Ah.get().intValue() != zzd.LOG_LEVEL_OFF;
            }
            return false;
        } catch (SecurityException e) {
            return false;
        }
    }

    public void zza(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        zza(context, str, i, str2, str3, str4, i2, list, 0L);
    }

    public void zza(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        if (zzci(context)) {
            if (TextUtils.isEmpty(str)) {
                String str5 = TAG;
                String strValueOf = String.valueOf(str);
                Log.e(str5, strValueOf.length() != 0 ? "missing wakeLock key. ".concat(strValueOf) : new String("missing wakeLock key. "));
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                try {
                    context.startService(new Intent().setComponent(zzd.f446An).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(jCurrentTimeMillis, i, str2, i2, zzf.zzx(list), str, SystemClock.elapsedRealtime(), zzj.zzcm(context), str3, zzf.zzia(context.getPackageName()), zzj.zzcn(context), j, str4)));
                } catch (Exception e) {
                    Log.wtf(TAG, e);
                }
            }
        }
    }
}
