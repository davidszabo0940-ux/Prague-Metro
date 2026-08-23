package com.google.unity.ads;

import android.util.Log;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

/* JADX INFO: loaded from: classes.dex */
public class PluginUtils {
    public static final String LOGTAG = "AdsUnity";

    public static String getErrorReason(int errorCode) {
        switch (errorCode) {
            case 0:
                return "Internal error";
            case 1:
                return "Invalid request";
            case 2:
                return "Network Error";
            case 3:
                return "No fill";
            default:
                Log.w(LOGTAG, String.format("Unexpected error code: %s", Integer.valueOf(errorCode)));
                return "";
        }
    }

    public static boolean isResultSuccess(InAppPurchaseResult result) {
        return result.getResultCode() == -1;
    }
}
