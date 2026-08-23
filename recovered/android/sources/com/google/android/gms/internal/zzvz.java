package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class zzvz {

    /* JADX INFO: renamed from: AA */
    private final String f864AA;

    /* JADX INFO: renamed from: Ay */
    private final String f865Ay;
    private WorkSource acv;
    private final PowerManager.WakeLock auA;
    private final int auB;
    private final String auC;
    private boolean auD;
    private int auE;
    private int auF;
    private final Context mContext;
    private static String TAG = "WakeLock";
    private static String auz = "*gcore*:";
    private static boolean DEBUG = false;

    public zzvz(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzvz(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, str2, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzvz(Context context, int i, String str, String str2, String str3, String str4) {
        this.auD = true;
        com.google.android.gms.common.internal.zzab.zzh(str, "Wake lock name can NOT be empty");
        this.auB = i;
        this.auC = str2;
        this.f864AA = str4;
        this.mContext = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f865Ay = str;
        } else {
            String strValueOf = String.valueOf(auz);
            String strValueOf2 = String.valueOf(str);
            this.f865Ay = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
        }
        this.auA = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (com.google.android.gms.common.util.zzz.zzco(this.mContext)) {
            this.acv = com.google.android.gms.common.util.zzz.zzr(context, com.google.android.gms.common.util.zzw.zzic(str3) ? context.getPackageName() : str3);
            zzc(this.acv);
        }
    }

    private void zzd(WorkSource workSource) {
        try {
            this.auA.setWorkSource(workSource);
        } catch (IllegalArgumentException e) {
            Log.wtf(TAG, e.toString());
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001f A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:13:0x001f, B:14:0x0042, B:9:0x0017, B:11:0x001b), top: B:19:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0017 A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:13:0x001f, B:14:0x0042, B:9:0x0017, B:11:0x001b), top: B:19:0x0009 }] */
    private void zzk(String str, long j) {
        boolean zZznj = zznj(str);
        String strZzp = zzp(str, zZznj);
        synchronized (this) {
            if (this.auD) {
                int i = this.auE;
                this.auE = i + 1;
                if (i == 0 || zZznj) {
                    com.google.android.gms.common.stats.zzh.zzave().zza(this.mContext, com.google.android.gms.common.stats.zzf.zza(this.auA, strZzp), 7, this.f865Ay, strZzp, this.f864AA, this.auB, com.google.android.gms.common.util.zzz.zzb(this.acv), j);
                    this.auF++;
                } else if (!this.auD && this.auF == 0) {
                    com.google.android.gms.common.stats.zzh.zzave().zza(this.mContext, com.google.android.gms.common.stats.zzf.zza(this.auA, strZzp), 7, this.f865Ay, strZzp, this.f864AA, this.auB, com.google.android.gms.common.util.zzz.zzb(this.acv), j);
                    this.auF++;
                }
            } else if (!this.auD) {
                com.google.android.gms.common.stats.zzh.zzave().zza(this.mContext, com.google.android.gms.common.stats.zzf.zza(this.auA, strZzp), 7, this.f865Ay, strZzp, this.f864AA, this.auB, com.google.android.gms.common.util.zzz.zzb(this.acv), j);
                this.auF++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0020 A[Catch: all -> 0x0045, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:13:0x0020, B:14:0x0043, B:9:0x0017, B:11:0x001b), top: B:19:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0017 A[Catch: all -> 0x0045, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:13:0x0020, B:14:0x0043, B:9:0x0017, B:11:0x001b), top: B:19:0x0009 }] */
    private void zzni(String str) {
        boolean zZznj = zznj(str);
        String strZzp = zzp(str, zZznj);
        synchronized (this) {
            if (this.auD) {
                int i = this.auE - 1;
                this.auE = i;
                if (i == 0 || zZznj) {
                    com.google.android.gms.common.stats.zzh.zzave().zza(this.mContext, com.google.android.gms.common.stats.zzf.zza(this.auA, strZzp), 8, this.f865Ay, strZzp, this.f864AA, this.auB, com.google.android.gms.common.util.zzz.zzb(this.acv));
                    this.auF--;
                } else if (!this.auD && this.auF == 1) {
                    com.google.android.gms.common.stats.zzh.zzave().zza(this.mContext, com.google.android.gms.common.stats.zzf.zza(this.auA, strZzp), 8, this.f865Ay, strZzp, this.f864AA, this.auB, com.google.android.gms.common.util.zzz.zzb(this.acv));
                    this.auF--;
                }
            } else if (!this.auD) {
                com.google.android.gms.common.stats.zzh.zzave().zza(this.mContext, com.google.android.gms.common.stats.zzf.zza(this.auA, strZzp), 8, this.f865Ay, strZzp, this.f864AA, this.auB, com.google.android.gms.common.util.zzz.zzb(this.acv));
                this.auF--;
            }
        }
    }

    private boolean zznj(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.auC)) ? false : true;
    }

    private String zzp(String str, boolean z) {
        return (this.auD && z) ? str : this.auC;
    }

    public void acquire(long j) {
        if (!com.google.android.gms.common.util.zzs.zzavm() && this.auD) {
            String str = TAG;
            String strValueOf = String.valueOf(this.f865Ay);
            Log.wtf(str, strValueOf.length() != 0 ? "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ".concat(strValueOf) : new String("Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: "));
        }
        zzk(null, j);
        this.auA.acquire(j);
    }

    public boolean isHeld() {
        return this.auA.isHeld();
    }

    public void release() {
        zzni(null);
        this.auA.release();
    }

    public void setReferenceCounted(boolean z) {
        this.auA.setReferenceCounted(z);
        this.auD = z;
    }

    public void zzc(WorkSource workSource) {
        if (workSource == null || !com.google.android.gms.common.util.zzz.zzco(this.mContext)) {
            return;
        }
        if (this.acv != null) {
            this.acv.add(workSource);
        } else {
            this.acv = workSource;
        }
        zzd(this.acv);
    }
}
