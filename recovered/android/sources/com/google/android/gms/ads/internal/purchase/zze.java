package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzhr;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zze extends zzht.zza implements ServiceConnection {
    private final Activity mActivity;
    private zzb zzbww;
    zzh zzbwx;
    private zzk zzbwz;
    private Context zzbxe;
    private zzhr zzbxf;
    private zzf zzbxg;
    private zzj zzbxh;
    private String zzbxi = null;

    public zze(Activity activity) {
        this.mActivity = activity;
        this.zzbwx = zzh.zzs(this.mActivity.getApplicationContext());
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0037 A[Catch: RemoteException -> 0x003f, all -> 0x004d, Merged into TryCatch #1 {all -> 0x004d, RemoteException -> 0x003f, blocks: (B:5:0x0006, B:7:0x0011, B:9:0x0016, B:12:0x0021, B:15:0x0037, B:18:0x0040), top: B:23:0x0006 }, TRY_ENTER, TRY_LEAVE] */
    @Override // com.google.android.gms.internal.zzht
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001) {
            boolean z = false;
            try {
                int iZzd = zzu.zzga().zzd(intent);
                if (i2 == -1) {
                    zzu.zzga();
                    if (iZzd != 0) {
                        this.zzbwx.zza(this.zzbxg);
                    } else if (this.zzbwz.zza(this.zzbxi, i2, intent)) {
                        z = true;
                    }
                } else {
                    this.zzbwx.zza(this.zzbxg);
                }
                this.zzbxf.recordPlayBillingResolution(iZzd);
                this.mActivity.finish();
                zza(this.zzbxf.getProductId(), z, i2, intent);
            } catch (RemoteException e) {
                zzkh.zzcy("Fail to process purchase result.");
                this.mActivity.finish();
            } finally {
                this.zzbxi = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzht
    public void onCreate() {
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcelZzc = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
        this.zzbxh = gInAppPurchaseManagerInfoParcelZzc.zzbws;
        this.zzbwz = gInAppPurchaseManagerInfoParcelZzc.zzapr;
        this.zzbxf = gInAppPurchaseManagerInfoParcelZzc.zzbwq;
        this.zzbww = new zzb(this.mActivity.getApplicationContext());
        this.zzbxe = gInAppPurchaseManagerInfoParcelZzc.zzbwr;
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            this.mActivity.setRequestedOrientation(zzu.zzfs().zztk());
        } else {
            this.mActivity.setRequestedOrientation(zzu.zzfs().zztl());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        this.mActivity.bindService(intent, this, 1);
    }

    @Override // com.google.android.gms.internal.zzht
    public void onDestroy() {
        this.mActivity.unbindService(this);
        this.zzbww.destroy();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zzbww.zzas(iBinder);
        try {
            this.zzbxi = this.zzbwz.zzpv();
            Bundle bundleZzb = this.zzbww.zzb(this.mActivity.getPackageName(), this.zzbxf.getProductId(), this.zzbxi);
            PendingIntent pendingIntent = (PendingIntent) bundleZzb.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int iZze = zzu.zzga().zze(bundleZzb);
                this.zzbxf.recordPlayBillingResolution(iZze);
                zza(this.zzbxf.getProductId(), false, iZze, null);
                this.mActivity.finish();
            } else {
                this.zzbxg = new zzf(this.zzbxf.getProductId(), this.zzbxi);
                this.zzbwx.zzb(this.zzbxg);
                Integer num = 0;
                Integer num2 = 0;
                Integer num3 = 0;
                this.mActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), num.intValue(), num2.intValue(), num3.intValue());
            }
        } catch (IntentSender.SendIntentException | RemoteException e) {
            zzkh.zzd("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        zzkh.zzcx("In-app billing service disconnected.");
        this.zzbww.destroy();
    }

    protected void zza(String str, boolean z, int i, Intent intent) {
        if (this.zzbxh != null) {
            this.zzbxh.zza(str, z, i, intent, this.zzbxg);
        }
    }
}
