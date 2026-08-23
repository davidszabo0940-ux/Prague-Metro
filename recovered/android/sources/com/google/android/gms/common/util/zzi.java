package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
public final class zzi {

    /* JADX INFO: renamed from: AL */
    private static Boolean f461AL;

    /* JADX INFO: renamed from: AM */
    private static Boolean f462AM;

    /* JADX INFO: renamed from: AN */
    private static Boolean f463AN;

    /* JADX INFO: renamed from: AO */
    private static Boolean f464AO;

    public static boolean zzb(Resources resources) {
        if (resources == null) {
            return false;
        }
        if (f461AL == null) {
            f461AL = Boolean.valueOf((zzs.zzavj() && ((resources.getConfiguration().screenLayout & 15) > 3)) || zzc(resources));
        }
        return f461AL.booleanValue();
    }

    @TargetApi(13)
    private static boolean zzc(Resources resources) {
        if (f462AM == null) {
            Configuration configuration = resources.getConfiguration();
            f462AM = Boolean.valueOf(zzs.zzavl() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600);
        }
        return f462AM.booleanValue();
    }

    @TargetApi(20)
    public static boolean zzck(Context context) {
        if (f463AN == null) {
            f463AN = Boolean.valueOf(zzs.zzavr() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f463AN.booleanValue();
    }

    @TargetApi(21)
    public static boolean zzcl(Context context) {
        if (f464AO == null) {
            f464AO = Boolean.valueOf(zzs.zzavs() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f464AO.booleanValue();
    }
}
