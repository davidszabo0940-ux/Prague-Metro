package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzk {
    private final String zzawj;

    public zzk(String str) {
        this.zzawj = str;
    }

    public boolean zza(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String strZze = zzu.zzga().zze(intent);
        String strZzf = zzu.zzga().zzf(intent);
        if (strZze == null || strZzf == null) {
            return false;
        }
        if (!str.equals(zzu.zzga().zzbz(strZze))) {
            zzkh.zzcy("Developer payload not match.");
            return false;
        }
        if (this.zzawj == null || zzl.zzc(this.zzawj, strZze, strZzf)) {
            return true;
        }
        zzkh.zzcy("Fail to verify signature.");
        return false;
    }

    public String zzpv() {
        return zzu.zzfq().zztg();
    }
}
