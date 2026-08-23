package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzhv;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzg extends zzhv.zza implements ServiceConnection {
    private Context mContext;
    private int mResultCode;
    zzb zzbww;
    private String zzbxc;
    private zzf zzbxg;
    private boolean zzbxm;
    private Intent zzbxn;

    public zzg(Context context, String str, boolean z, int i, Intent intent, zzf zzfVar) {
        this.zzbxm = false;
        this.zzbxc = str;
        this.mResultCode = i;
        this.zzbxn = intent;
        this.zzbxm = z;
        this.mContext = context;
        this.zzbxg = zzfVar;
    }

    @Override // com.google.android.gms.internal.zzhv
    public void finishPurchase() {
        int iZzd = zzu.zzga().zzd(this.zzbxn);
        if (this.mResultCode == -1 && iZzd == 0) {
            this.zzbww = new zzb(this.mContext);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            com.google.android.gms.common.stats.zzb.zzaut().zza(this.mContext, intent, this, 1);
        }
    }

    @Override // com.google.android.gms.internal.zzhv
    public String getProductId() {
        return this.zzbxc;
    }

    @Override // com.google.android.gms.internal.zzhv
    public Intent getPurchaseData() {
        return this.zzbxn;
    }

    @Override // com.google.android.gms.internal.zzhv
    public int getResultCode() {
        return this.mResultCode;
    }

    @Override // com.google.android.gms.internal.zzhv
    public boolean isVerified() {
        return this.zzbxm;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzkh.zzcx("In-app billing service connected.");
        this.zzbww.zzas(iBinder);
        String strZzca = zzu.zzga().zzca(zzu.zzga().zze(this.zzbxn));
        if (strZzca == null) {
            return;
        }
        if (this.zzbww.zzm(this.mContext.getPackageName(), strZzca) == 0) {
            zzh.zzs(this.mContext).zza(this.zzbxg);
        }
        com.google.android.gms.common.stats.zzb.zzaut().zza(this.mContext, this);
        this.zzbww.destroy();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        zzkh.zzcx("In-app billing service disconnected.");
        this.zzbww.destroy();
    }
}
