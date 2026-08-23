package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzru;

/* JADX INFO: loaded from: classes.dex */
public class zzz {

    /* JADX INFO: renamed from: yS */
    private static String f373yS;

    /* JADX INFO: renamed from: yT */
    private static int f374yT;
    private static Object zzamp = new Object();
    private static boolean zzbyy;

    public static String zzcf(Context context) {
        zzch(context);
        return f373yS;
    }

    public static int zzcg(Context context) {
        zzch(context);
        return f374yT;
    }

    private static void zzch(Context context) {
        synchronized (zzamp) {
            if (zzbyy) {
                return;
            }
            zzbyy = true;
            try {
                Bundle bundle = zzru.zzcq(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                f373yS = bundle.getString("com.google.app.id");
                f374yT = bundle.getInt("com.google.android.gms.version");
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
