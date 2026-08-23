package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzkf {
    private static final Object zzamp = new Object();
    private static String zzckn;

    public static String zza(Context context, String str, String str2) {
        String str3;
        synchronized (zzamp) {
            if (zzckn == null && !TextUtils.isEmpty(str)) {
                zzb(context, str, str2);
            }
            str3 = zzckn;
        }
        return str3;
    }

    private static void zzb(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class<?> cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] strArrSplit = str.split(",");
            BigInteger bit = bigInteger;
            for (int i = 0; i < strArrSplit.length; i++) {
                if (com.google.android.gms.ads.internal.zzu.zzfq().zza(classLoader, cls, strArrSplit[i])) {
                    bit = bit.setBit(i);
                }
            }
            zzckn = String.format(Locale.US, "%X", bit);
        } catch (Throwable th) {
            zzckn = "err";
        }
    }

    public static String zzsz() {
        String str;
        synchronized (zzamp) {
            str = zzckn;
        }
        return str;
    }
}
