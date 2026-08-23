package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zziz {
    public final int zzcbf;
    public final int zzcbg;
    public final float zzcbh;
    public final int zzcgh;
    public final boolean zzcgi;
    public final boolean zzcgj;
    public final String zzcgk;
    public final String zzcgl;
    public final boolean zzcgm;
    public final boolean zzcgn;
    public final boolean zzcgo;
    public final boolean zzcgp;
    public final String zzcgq;
    public final String zzcgr;
    public final int zzcgs;
    public final int zzcgt;
    public final int zzcgu;
    public final int zzcgv;
    public final int zzcgw;
    public final int zzcgx;
    public final double zzcgy;
    public final boolean zzcgz;
    public final boolean zzcha;
    public final int zzchb;
    public final String zzchc;
    public final boolean zzchd;

    public static final class zza {
        private int zzcbf;
        private int zzcbg;
        private float zzcbh;
        private int zzcgh;
        private boolean zzcgi;
        private boolean zzcgj;
        private String zzcgk;
        private String zzcgl;
        private boolean zzcgm;
        private boolean zzcgn;
        private boolean zzcgo;
        private boolean zzcgp;
        private String zzcgq;
        private String zzcgr;
        private int zzcgs;
        private int zzcgt;
        private int zzcgu;
        private int zzcgv;
        private int zzcgw;
        private int zzcgx;
        private double zzcgy;
        private boolean zzcgz;
        private boolean zzcha;
        private int zzchb;
        private String zzchc;
        private boolean zzchd;

        public zza(Context context) {
            DisplayMetrics displayMetrics;
            PackageManager packageManager = context.getPackageManager();
            zzv(context);
            zza(context, packageManager);
            zzw(context);
            Locale locale = Locale.getDefault();
            this.zzcgi = zza(packageManager, "geo:0,0?q=donuts") != null;
            this.zzcgj = zza(packageManager, "http://www.google.com") != null;
            this.zzcgl = locale.getCountry();
            this.zzcgm = com.google.android.gms.ads.internal.client.zzm.zziw().zztx();
            this.zzcgn = com.google.android.gms.common.util.zzi.zzcl(context);
            this.zzcgq = locale.getLanguage();
            this.zzcgr = zza(packageManager);
            Resources resources = context.getResources();
            if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
                return;
            }
            this.zzcbh = displayMetrics.density;
            this.zzcbf = displayMetrics.widthPixels;
            this.zzcbg = displayMetrics.heightPixels;
        }

        public zza(Context context, zziz zzizVar) {
            PackageManager packageManager = context.getPackageManager();
            zzv(context);
            zza(context, packageManager);
            zzw(context);
            zzx(context);
            this.zzcgi = zzizVar.zzcgi;
            this.zzcgj = zzizVar.zzcgj;
            this.zzcgl = zzizVar.zzcgl;
            this.zzcgm = zzizVar.zzcgm;
            this.zzcgn = zzizVar.zzcgn;
            this.zzcgq = zzizVar.zzcgq;
            this.zzcgr = zzizVar.zzcgr;
            this.zzcbh = zzizVar.zzcbh;
            this.zzcbf = zzizVar.zzcbf;
            this.zzcbg = zzizVar.zzcbg;
        }

        private static ResolveInfo zza(PackageManager packageManager, String str) {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        }

        private static String zza(PackageManager packageManager) {
            ActivityInfo activityInfo;
            ResolveInfo resolveInfoZza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
            if (resolveInfoZza == null || (activityInfo = resolveInfoZza.activityInfo) == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                if (packageInfo == null) {
                    return null;
                }
                int i = packageInfo.versionCode;
                String strValueOf = String.valueOf(activityInfo.packageName);
                return new StringBuilder(String.valueOf(strValueOf).length() + 12).append(i).append(".").append(strValueOf).toString();
            } catch (PackageManager.NameNotFoundException e) {
                return null;
            }
        }

        @TargetApi(16)
        private void zza(Context context, PackageManager packageManager) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.zzcgk = telephonyManager.getNetworkOperator();
            this.zzcgu = telephonyManager.getNetworkType();
            this.zzcgv = telephonyManager.getPhoneType();
            this.zzcgt = -2;
            this.zzcha = false;
            this.zzchb = -1;
            if (com.google.android.gms.ads.internal.zzu.zzfq().zza(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.zzcgt = activeNetworkInfo.getType();
                    this.zzchb = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.zzcgt = -1;
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    this.zzcha = connectivityManager.isActiveNetworkMetered();
                }
            }
        }

        private void zzv(Context context) {
            AudioManager audioManagerZzak = com.google.android.gms.ads.internal.zzu.zzfq().zzak(context);
            if (audioManagerZzak != null) {
                try {
                    this.zzcgh = audioManagerZzak.getMode();
                    this.zzcgo = audioManagerZzak.isMusicActive();
                    this.zzcgp = audioManagerZzak.isSpeakerphoneOn();
                    this.zzcgs = audioManagerZzak.getStreamVolume(3);
                    this.zzcgw = audioManagerZzak.getRingerMode();
                    this.zzcgx = audioManagerZzak.getStreamVolume(2);
                    return;
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzu.zzft().zzb(th, true);
                }
            }
            this.zzcgh = -2;
            this.zzcgo = false;
            this.zzcgp = false;
            this.zzcgs = 0;
            this.zzcgw = 0;
            this.zzcgx = 0;
        }

        private void zzw(Context context) {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                this.zzcgy = -1.0d;
                this.zzcgz = false;
            } else {
                int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
                this.zzcgy = intentRegisterReceiver.getIntExtra("level", -1) / intentRegisterReceiver.getIntExtra("scale", -1);
                this.zzcgz = intExtra == 2 || intExtra == 5;
            }
        }

        private void zzx(Context context) {
            this.zzchc = Build.FINGERPRINT;
            this.zzchd = zzdq.zzo(context);
        }

        public zziz zzro() {
            return new zziz(this.zzcgh, this.zzcgi, this.zzcgj, this.zzcgk, this.zzcgl, this.zzcgm, this.zzcgn, this.zzcgo, this.zzcgp, this.zzcgq, this.zzcgr, this.zzcgs, this.zzcgt, this.zzcgu, this.zzcgv, this.zzcgw, this.zzcgx, this.zzcbh, this.zzcbf, this.zzcbg, this.zzcgy, this.zzcgz, this.zzcha, this.zzchb, this.zzchc, this.zzchd);
        }
    }

    zziz(int i, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, double d, boolean z7, boolean z8, int i10, String str5, boolean z9) {
        this.zzcgh = i;
        this.zzcgi = z;
        this.zzcgj = z2;
        this.zzcgk = str;
        this.zzcgl = str2;
        this.zzcgm = z3;
        this.zzcgn = z4;
        this.zzcgo = z5;
        this.zzcgp = z6;
        this.zzcgq = str3;
        this.zzcgr = str4;
        this.zzcgs = i2;
        this.zzcgt = i3;
        this.zzcgu = i4;
        this.zzcgv = i5;
        this.zzcgw = i6;
        this.zzcgx = i7;
        this.zzcbh = f;
        this.zzcbf = i8;
        this.zzcbg = i9;
        this.zzcgy = d;
        this.zzcgz = z7;
        this.zzcha = z8;
        this.zzchb = i10;
        this.zzchc = str5;
        this.zzchd = z9;
    }
}
