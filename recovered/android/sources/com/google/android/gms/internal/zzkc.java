package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.client.AdRequestParcel;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzkc {
    final String zzcjq;
    long zzckg = -1;
    long zzckh = -1;
    int zzcki = -1;
    private final Object zzail = new Object();
    int zzckj = 0;
    int zzckk = 0;

    public zzkc(String str) {
        this.zzcjq = str;
    }

    public static boolean zzab(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            zzkh.zzcx("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzkh.zzcx("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            zzkh.zzcy("Fail to fetch AdActivity theme");
            zzkh.zzcx("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public void zzb(AdRequestParcel adRequestParcel, long j) {
        synchronized (this.zzail) {
            if (this.zzckh == -1) {
                this.zzckh = j;
                this.zzckg = this.zzckh;
            } else {
                this.zzckg = j;
            }
            if (adRequestParcel.extras == null || adRequestParcel.extras.getInt("gw", 2) != 1) {
                this.zzcki++;
            }
        }
    }

    public Bundle zzf(Context context, String str) {
        Bundle bundle;
        synchronized (this.zzail) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzcjq);
            bundle.putLong("basets", this.zzckh);
            bundle.putLong("currts", this.zzckg);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzcki);
            bundle.putInt("pclick", this.zzckj);
            bundle.putInt("pimp", this.zzckk);
            bundle.putBoolean("support_transparent_background", zzab(context));
        }
        return bundle;
    }

    public void zzrz() {
        synchronized (this.zzail) {
            this.zzckk++;
        }
    }

    public void zzsa() {
        synchronized (this.zzail) {
            this.zzckj++;
        }
    }

    public long zzsy() {
        return this.zzckh;
    }
}
