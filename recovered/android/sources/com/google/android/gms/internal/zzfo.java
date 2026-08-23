package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzfo {
    private final Map<zzfp, zzfq> zzbks = new HashMap();
    private final LinkedList<zzfp> zzbkt = new LinkedList<>();
    private zzfl zzbku;

    private static void zza(String str, zzfp zzfpVar) {
        if (zzkh.zzaz(2)) {
            zzkh.m95v(String.format(str, zzfpVar));
        }
    }

    private String[] zzbf(String str) {
        try {
            String[] strArrSplit = str.split("\u0000");
            for (int i = 0; i < strArrSplit.length; i++) {
                strArrSplit[i] = new String(Base64.decode(strArrSplit[i], 0), "UTF-8");
            }
            return strArrSplit;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    private boolean zzbg(String str) {
        try {
            return Pattern.matches(zzdc.zzbaj.get(), str);
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzu.zzft().zzb((Throwable) e, true);
            return false;
        }
    }

    private static void zzc(Bundle bundle, String str) {
        String[] strArrSplit = str.split("/", 2);
        if (strArrSplit.length == 0) {
            return;
        }
        String str2 = strArrSplit[0];
        if (strArrSplit.length == 1) {
            bundle.remove(str2);
            return;
        }
        Bundle bundle2 = bundle.getBundle(str2);
        if (bundle2 != null) {
            zzc(bundle2, strArrSplit[1]);
        }
    }

    @Nullable
    static Bundle zzi(AdRequestParcel adRequestParcel) {
        Bundle bundle = adRequestParcel.zzatu;
        if (bundle == null) {
            return null;
        }
        return bundle.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
    }

    static AdRequestParcel zzj(AdRequestParcel adRequestParcel) {
        Parcel parcelObtain = Parcel.obtain();
        adRequestParcel.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        AdRequestParcel adRequestParcel2 = (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        Bundle bundleZzi = zzi(adRequestParcel2);
        if (bundleZzi == null) {
            bundleZzi = new Bundle();
            adRequestParcel2.zzatu.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundleZzi);
        }
        bundleZzi.putBoolean("_skipMediation", true);
        return adRequestParcel2;
    }

    static boolean zzk(AdRequestParcel adRequestParcel) {
        Bundle bundle;
        Bundle bundle2 = adRequestParcel.zzatu;
        return (bundle2 == null || (bundle = bundle2.getBundle("com.google.ads.mediation.admob.AdMobAdapter")) == null || !bundle.containsKey("_skipMediation")) ? false : true;
    }

    private static AdRequestParcel zzl(AdRequestParcel adRequestParcel) {
        Parcel parcelObtain = Parcel.obtain();
        adRequestParcel.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        AdRequestParcel adRequestParcel2 = (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        for (String str : zzdc.zzbaf.get().split(",")) {
            zzc(adRequestParcel2.zzatu, str);
        }
        return adRequestParcel2;
    }

    private String zzlr() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<zzfp> it = this.zzbkt.iterator();
            while (it.hasNext()) {
                sb.append(Base64.encodeToString(it.next().toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    sb.append("\u0000");
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    void flush() {
        while (this.zzbkt.size() > 0) {
            zzfp zzfpVarRemove = this.zzbkt.remove();
            zzfq zzfqVar = this.zzbks.get(zzfpVarRemove);
            zza("Flushing interstitial queue for %s.", zzfpVarRemove);
            while (zzfqVar.size() > 0) {
                zzfqVar.zzm(null).zzbkz.zzeu();
            }
            this.zzbks.remove(zzfpVarRemove);
        }
    }

    void restore() {
        if (this.zzbku == null) {
            return;
        }
        SharedPreferences sharedPreferences = this.zzbku.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
        flush();
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            try {
                if (!entry.getKey().equals("PoolKeys")) {
                    zzfs zzfsVar = new zzfs((String) entry.getValue());
                    zzfp zzfpVar = new zzfp(zzfsVar.zzana, zzfsVar.zzall, zzfsVar.zzbkx);
                    if (!this.zzbks.containsKey(zzfpVar)) {
                        this.zzbks.put(zzfpVar, new zzfq(zzfsVar.zzana, zzfsVar.zzall, zzfsVar.zzbkx));
                        map.put(zzfpVar.toString(), zzfpVar);
                        zza("Restored interstitial queue for %s.", zzfpVar);
                    }
                }
            } catch (IOException | ClassCastException e) {
                zzkh.zzd("Malformed preferences value for InterstitialAdPool.", e);
            }
        }
        for (String str : zzbf(sharedPreferences.getString("PoolKeys", ""))) {
            zzfp zzfpVar2 = (zzfp) map.get(str);
            if (this.zzbks.containsKey(zzfpVar2)) {
                this.zzbkt.add(zzfpVar2);
            }
        }
    }

    void save() {
        if (this.zzbku == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.zzbku.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
        editorEdit.clear();
        for (Map.Entry<zzfp, zzfq> entry : this.zzbks.entrySet()) {
            zzfp key = entry.getKey();
            zzfq value = entry.getValue();
            if (value.zzlw()) {
                editorEdit.putString(key.toString(), new zzfs(value).zzlz());
                zza("Saved interstitial queue for %s.", key);
            }
        }
        editorEdit.putString("PoolKeys", zzlr());
        editorEdit.apply();
    }

    zzfq.zza zza(AdRequestParcel adRequestParcel, String str) {
        zzfq zzfqVar;
        if (zzbg(str)) {
            return null;
        }
        int i = new zziz.zza(this.zzbku.getApplicationContext()).zzro().zzcgt;
        AdRequestParcel adRequestParcelZzl = zzl(adRequestParcel);
        zzfp zzfpVar = new zzfp(adRequestParcelZzl, str, i);
        zzfq zzfqVar2 = this.zzbks.get(zzfpVar);
        if (zzfqVar2 == null) {
            zza("Interstitial pool created at %s.", zzfpVar);
            zzfq zzfqVar3 = new zzfq(adRequestParcelZzl, str, i);
            this.zzbks.put(zzfpVar, zzfqVar3);
            zzfqVar = zzfqVar3;
        } else {
            zzfqVar = zzfqVar2;
        }
        this.zzbkt.remove(zzfpVar);
        this.zzbkt.add(zzfpVar);
        zzfqVar.zzlv();
        while (this.zzbkt.size() > zzdc.zzbag.get().intValue()) {
            zzfp zzfpVarRemove = this.zzbkt.remove();
            zzfq zzfqVar4 = this.zzbks.get(zzfpVarRemove);
            zza("Evicting interstitial queue for %s.", zzfpVarRemove);
            while (zzfqVar4.size() > 0) {
                zzfqVar4.zzm(null).zzbkz.zzeu();
            }
            this.zzbks.remove(zzfpVarRemove);
        }
        while (zzfqVar.size() > 0) {
            zzfq.zza zzaVarZzm = zzfqVar.zzm(adRequestParcelZzl);
            if (!zzaVarZzm.zzbld || com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis() - zzaVarZzm.zzblc <= 1000 * ((long) zzdc.zzbai.get().intValue())) {
                String str2 = zzaVarZzm.zzbla != null ? " (inline) " : " ";
                zza(new StringBuilder(String.valueOf(str2).length() + 34).append("Pooled interstitial").append(str2).append("returned at %s.").toString(), zzfpVar);
                return zzaVarZzm;
            }
            zza("Expired interstitial at %s.", zzfpVar);
        }
        return null;
    }

    void zza(zzfl zzflVar) {
        if (this.zzbku == null) {
            this.zzbku = zzflVar.zzlp();
            restore();
        }
    }

    void zzb(AdRequestParcel adRequestParcel, String str) {
        if (this.zzbku == null) {
            return;
        }
        int i = new zziz.zza(this.zzbku.getApplicationContext()).zzro().zzcgt;
        AdRequestParcel adRequestParcelZzl = zzl(adRequestParcel);
        zzfp zzfpVar = new zzfp(adRequestParcelZzl, str, i);
        zzfq zzfqVar = this.zzbks.get(zzfpVar);
        if (zzfqVar == null) {
            zza("Interstitial pool created at %s.", zzfpVar);
            zzfqVar = new zzfq(adRequestParcelZzl, str, i);
            this.zzbks.put(zzfpVar, zzfqVar);
        }
        zzfqVar.zza(this.zzbku, adRequestParcel);
        zzfqVar.zzlv();
        zza("Inline entry added to the queue at %s.", zzfpVar);
    }

    void zzlq() {
        int size;
        int iZzlt;
        if (this.zzbku == null) {
            return;
        }
        for (Map.Entry<zzfp, zzfq> entry : this.zzbks.entrySet()) {
            zzfp key = entry.getKey();
            zzfq value = entry.getValue();
            if (zzkh.zzaz(2) && (iZzlt = value.zzlt()) < (size = value.size())) {
                zzkh.m95v(String.format("Loading %s/%s pooled interstitials for %s.", Integer.valueOf(size - iZzlt), Integer.valueOf(size), key));
            }
            value.zzlu();
            while (value.size() < zzdc.zzbah.get().intValue()) {
                zza("Pooling and loading one new interstitial for %s.", key);
                value.zzb(this.zzbku);
            }
        }
        save();
    }
}
