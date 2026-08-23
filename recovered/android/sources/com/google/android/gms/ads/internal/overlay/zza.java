package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zza {
    public boolean zza(Context context, Intent intent, zzp zzpVar) {
        try {
            String strValueOf = String.valueOf(intent.toURI());
            zzkh.m95v(strValueOf.length() != 0 ? "Launching an intent: ".concat(strValueOf) : new String("Launching an intent: "));
            com.google.android.gms.ads.internal.zzu.zzfq().zzb(context, intent);
            if (zzpVar != null) {
                zzpVar.zzdp();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzkh.zzcy(e.getMessage());
            return false;
        }
    }

    public boolean zza(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, zzp zzpVar) {
        int i;
        if (adLauncherIntentInfoParcel == null) {
            zzkh.zzcy("No intent data for launcher overlay.");
            return false;
        }
        if (adLauncherIntentInfoParcel.intent != null) {
            return zza(context, adLauncherIntentInfoParcel.intent, zzpVar);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(adLauncherIntentInfoParcel.url)) {
            zzkh.zzcy("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(adLauncherIntentInfoParcel.mimeType)) {
            intent.setData(Uri.parse(adLauncherIntentInfoParcel.url));
        } else {
            intent.setDataAndType(Uri.parse(adLauncherIntentInfoParcel.url), adLauncherIntentInfoParcel.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.packageName)) {
            intent.setPackage(adLauncherIntentInfoParcel.packageName);
        }
        if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.zzbrs)) {
            String[] strArrSplit = adLauncherIntentInfoParcel.zzbrs.split("/", 2);
            if (strArrSplit.length < 2) {
                String strValueOf = String.valueOf(adLauncherIntentInfoParcel.zzbrs);
                zzkh.zzcy(strValueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(strValueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent.setClassName(strArrSplit[0], strArrSplit[1]);
        }
        String str = adLauncherIntentInfoParcel.zzbrt;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                zzkh.zzcy("Could not parse intent flags.");
                i = 0;
            }
            intent.addFlags(i);
        }
        return zza(context, intent, zzpVar);
    }
}
