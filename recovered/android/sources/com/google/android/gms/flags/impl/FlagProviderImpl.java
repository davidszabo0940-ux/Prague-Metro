package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzug;

/* JADX INFO: loaded from: classes.dex */
@DynamiteApi
public class FlagProviderImpl extends zzug.zza {
    private boolean zzamr = false;
    private SharedPreferences zzaxs;

    @Override // com.google.android.gms.internal.zzug
    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.zzamr ? z : zza.C0757zza.zza(this.zzaxs, str, Boolean.valueOf(z)).booleanValue();
    }

    @Override // com.google.android.gms.internal.zzug
    public int getIntFlagValue(String str, int i, int i2) {
        return !this.zzamr ? i : zza.zzb.zza(this.zzaxs, str, Integer.valueOf(i)).intValue();
    }

    @Override // com.google.android.gms.internal.zzug
    public long getLongFlagValue(String str, long j, int i) {
        return !this.zzamr ? j : zza.zzc.zza(this.zzaxs, str, Long.valueOf(j)).longValue();
    }

    @Override // com.google.android.gms.internal.zzug
    public String getStringFlagValue(String str, String str2, int i) {
        return !this.zzamr ? str2 : zza.zzd.zza(this.zzaxs, str, str2);
    }

    @Override // com.google.android.gms.internal.zzug
    public void init(zzd zzdVar) {
        Context context = (Context) zze.zzad(zzdVar);
        if (this.zzamr) {
            return;
        }
        try {
            this.zzaxs = zzb.zzn(context.createPackageContext("com.google.android.gms", 0));
            this.zzamr = true;
        } catch (PackageManager.NameNotFoundException e) {
        }
    }
}
