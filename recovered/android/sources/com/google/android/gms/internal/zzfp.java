package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzfp {
    private final Object[] mParams;

    zzfp(AdRequestParcel adRequestParcel, String str, int i) {
        this.mParams = zza(adRequestParcel, str, i);
    }

    private static Object[] zza(AdRequestParcel adRequestParcel, String str, int i) {
        HashSet hashSet = new HashSet(Arrays.asList(zzdc.zzbae.get().split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(adRequestParcel.zzatk));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zzd(adRequestParcel.extras));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(adRequestParcel.zzatl));
        }
        if (hashSet.contains("keywords")) {
            if (adRequestParcel.zzatm != null) {
                arrayList.add(adRequestParcel.zzatm.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(adRequestParcel.zzatn));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(adRequestParcel.zzato));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(adRequestParcel.zzatp));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(adRequestParcel.zzatq);
        }
        if (hashSet.contains("location")) {
            if (adRequestParcel.zzats != null) {
                arrayList.add(adRequestParcel.zzats.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(adRequestParcel.zzatt);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zzd(adRequestParcel.zzatu));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zzd(adRequestParcel.zzatv));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (adRequestParcel.zzatw != null) {
                arrayList.add(adRequestParcel.zzatw.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(adRequestParcel.zzatx);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(adRequestParcel.zzaty);
        }
        return arrayList.toArray();
    }

    private static String zzd(Bundle bundle) {
        String strZzd;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(new ArrayList(bundle.keySet()));
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            Object obj = bundle.get(it.next());
            if (obj == null) {
                strZzd = "null";
            } else {
                strZzd = obj instanceof Bundle ? zzd((Bundle) obj) : obj.toString();
            }
            sb.append(strZzd);
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof zzfp) {
            return Arrays.equals(this.mParams, ((zzfp) obj).mParams);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mParams);
    }

    public String toString() {
        String strValueOf = String.valueOf(Arrays.toString(this.mParams));
        return new StringBuilder(String.valueOf(strValueOf).length() + 24).append("[InterstitialAdPoolKey ").append(strValueOf).append("]").toString();
    }
}
