package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.C0228R;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzqk {

    /* JADX INFO: renamed from: uR */
    private static zzqk f754uR;
    private static Object zzamp = new Object();

    /* JADX INFO: renamed from: uS */
    private final String f755uS;

    /* JADX INFO: renamed from: uT */
    private final Status f756uT;

    /* JADX INFO: renamed from: uU */
    private final String f757uU;

    /* JADX INFO: renamed from: uV */
    private final String f758uV;

    /* JADX INFO: renamed from: uW */
    private final String f759uW;

    /* JADX INFO: renamed from: uX */
    private final boolean f760uX;

    /* JADX INFO: renamed from: uY */
    private final boolean f761uY;
    private final String zzcjj;

    zzqk(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C0228R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            this.f761uY = z2 ? false : true;
            z = z2;
        } else {
            this.f761uY = false;
        }
        this.f760uX = z;
        com.google.android.gms.common.internal.zzai zzaiVar = new com.google.android.gms.common.internal.zzai(context);
        this.f757uU = zzaiVar.getString("firebase_database_url");
        this.f759uW = zzaiVar.getString("google_storage_bucket");
        this.f758uV = zzaiVar.getString("gcm_defaultSenderId");
        this.f755uS = zzaiVar.getString("google_api_key");
        String strZzcf = com.google.android.gms.common.internal.zzz.zzcf(context);
        strZzcf = strZzcf == null ? zzaiVar.getString("google_app_id") : strZzcf;
        if (TextUtils.isEmpty(strZzcf)) {
            this.f756uT = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzcjj = null;
        } else {
            this.zzcjj = strZzcf;
            this.f756uT = Status.f151sg;
        }
    }

    zzqk(String str, boolean z) {
        this(str, z, null, null, null);
    }

    zzqk(String str, boolean z, String str2, String str3, String str4) {
        this.zzcjj = str;
        this.f755uS = null;
        this.f756uT = Status.f151sg;
        this.f760uX = z;
        this.f761uY = !z;
        this.f757uU = str2;
        this.f758uV = str4;
        this.f759uW = str3;
    }

    public static String zzaqk() {
        return zzgy("getGoogleAppId").zzcjj;
    }

    public static boolean zzaql() {
        return zzgy("isMeasurementExplicitlyDisabled").f761uY;
    }

    public static Status zzc(Context context, String str, boolean z) {
        Status statusZzgx;
        com.google.android.gms.common.internal.zzab.zzb(context, "Context must not be null.");
        com.google.android.gms.common.internal.zzab.zzh(str, "App ID must be nonempty.");
        synchronized (zzamp) {
            if (f754uR != null) {
                statusZzgx = f754uR.zzgx(str);
            } else {
                f754uR = new zzqk(str, z);
                statusZzgx = f754uR.f756uT;
            }
        }
        return statusZzgx;
    }

    public static Status zzcb(Context context) {
        Status status;
        com.google.android.gms.common.internal.zzab.zzb(context, "Context must not be null.");
        synchronized (zzamp) {
            if (f754uR == null) {
                f754uR = new zzqk(context);
            }
            status = f754uR.f756uT;
        }
        return status;
    }

    private static zzqk zzgy(String str) {
        zzqk zzqkVar;
        synchronized (zzamp) {
            if (f754uR == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            zzqkVar = f754uR;
        }
        return zzqkVar;
    }

    Status zzgx(String str) {
        if (this.zzcjj == null || this.zzcjj.equals(str)) {
            return Status.f151sg;
        }
        String str2 = this.zzcjj;
        return new Status(10, new StringBuilder(String.valueOf(str2).length() + 97).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '").append(str2).append("'.").toString());
    }
}
