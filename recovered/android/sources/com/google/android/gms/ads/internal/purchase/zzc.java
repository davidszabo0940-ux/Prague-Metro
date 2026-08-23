package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzc extends zzkg implements ServiceConnection {
    private Context mContext;
    private final Object zzail;
    private zzhw zzblh;
    private boolean zzbwv;
    private zzb zzbww;
    private zzh zzbwx;
    private List<zzf> zzbwy;
    private zzk zzbwz;

    public zzc(Context context, zzhw zzhwVar, zzk zzkVar) {
        this(context, zzhwVar, zzkVar, new zzb(context), zzh.zzs(context.getApplicationContext()));
    }

    zzc(Context context, zzhw zzhwVar, zzk zzkVar, zzb zzbVar, zzh zzhVar) {
        this.zzail = new Object();
        this.zzbwv = false;
        this.zzbwy = null;
        this.mContext = context;
        this.zzblh = zzhwVar;
        this.zzbwz = zzkVar;
        this.zzbww = zzbVar;
        this.zzbwx = zzhVar;
        this.zzbwy = this.zzbwx.zzg(10L);
    }

    private void zze(long j) {
        do {
            if (!zzf(j)) {
                zzkh.m95v("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.zzbwv);
    }

    private boolean zzf(long j) {
        long jElapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (jElapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzail.wait(jElapsedRealtime);
        } catch (InterruptedException e) {
            zzkh.zzcy("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzail) {
            this.zzbww.zzas(iBinder);
            zzps();
            this.zzbwv = true;
            this.zzail.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        zzkh.zzcx("In-app billing service disconnected.");
        this.zzbww.destroy();
    }

    @Override // com.google.android.gms.internal.zzkg
    public void onStop() {
        synchronized (this.zzail) {
            com.google.android.gms.common.stats.zzb.zzaut().zza(this.mContext, this);
            this.zzbww.destroy();
        }
    }

    protected void zza(final zzf zzfVar, String str, String str2) {
        final Intent intent = new Intent();
        zzu.zzga();
        intent.putExtra("RESPONSE_CODE", 0);
        zzu.zzga();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        zzu.zzga();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.purchase.zzc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (zzc.this.zzbwz.zza(zzfVar.zzbxk, -1, intent)) {
                        zzc.this.zzblh.zza(new zzg(zzc.this.mContext, zzfVar.zzbxl, true, -1, intent, zzfVar));
                    } else {
                        zzc.this.zzblh.zza(new zzg(zzc.this.mContext, zzfVar.zzbxl, false, -1, intent, zzfVar));
                    }
                } catch (RemoteException e) {
                    zzkh.zzcy("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zzew() {
        synchronized (this.zzail) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            com.google.android.gms.common.stats.zzb.zzaut().zza(this.mContext, intent, this, 1);
            zze(SystemClock.elapsedRealtime());
            com.google.android.gms.common.stats.zzb.zzaut().zza(this.mContext, this);
            this.zzbww.destroy();
        }
    }

    protected void zzps() {
        if (this.zzbwy.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        for (zzf zzfVar : this.zzbwy) {
            map.put(zzfVar.zzbxl, zzfVar);
        }
        String str = null;
        while (true) {
            Bundle bundleZzn = this.zzbww.zzn(this.mContext.getPackageName(), str);
            if (bundleZzn == null || zzu.zzga().zze(bundleZzn) != 0) {
                break;
            }
            ArrayList<String> stringArrayList = bundleZzn.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String> stringArrayList2 = bundleZzn.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList3 = bundleZzn.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            String string = bundleZzn.getString("INAPP_CONTINUATION_TOKEN");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= stringArrayList.size()) {
                    break;
                }
                if (map.containsKey(stringArrayList.get(i2))) {
                    String str2 = stringArrayList.get(i2);
                    String str3 = stringArrayList2.get(i2);
                    String str4 = stringArrayList3.get(i2);
                    zzf zzfVar2 = (zzf) map.get(str2);
                    if (zzfVar2.zzbxk.equals(zzu.zzga().zzbz(str3))) {
                        zza(zzfVar2, str3, str4);
                        map.remove(str2);
                    }
                }
                i = i2 + 1;
            }
            if (string == null || map.isEmpty()) {
                break;
            } else {
                str = string;
            }
        }
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            this.zzbwx.zza((zzf) map.get((String) it.next()));
        }
    }
}
