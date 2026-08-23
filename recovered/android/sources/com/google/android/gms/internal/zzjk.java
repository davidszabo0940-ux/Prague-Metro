package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzjk extends zzkg implements zzjl, zzjo {
    private final Context mContext;
    private final String zzbog;
    private final zzjy.zza zzbxv;
    private final zzjq zzchq;
    private final zzjo zzchr;
    private final String zzchs;
    private final String zzcht;
    private int zzchu = 0;
    private int zzbym = 3;
    private final Object zzail = new Object();

    public zzjk(Context context, String str, String str2, String str3, zzjy.zza zzaVar, zzjq zzjqVar, zzjo zzjoVar) {
        this.mContext = context;
        this.zzbog = str;
        this.zzchs = str2;
        this.zzcht = str3;
        this.zzbxv = zzaVar;
        this.zzchq = zzjqVar;
        this.zzchr = zzjoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(AdRequestParcel adRequestParcel, zzgo zzgoVar) {
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzbog)) {
                zzgoVar.zza(adRequestParcel, this.zzchs, this.zzcht);
            } else {
                zzgoVar.zzc(adRequestParcel, this.zzchs);
            }
        } catch (RemoteException e) {
            zzkh.zzd("Fail to load ad from adapter.", e);
            zza(this.zzbog, 0);
        }
    }

    private void zzk(long j) {
        while (true) {
            synchronized (this.zzail) {
                if (this.zzchu != 0) {
                    return;
                }
                if (!zzf(j)) {
                    return;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzkg
    public void onStop() {
    }

    @Override // com.google.android.gms.internal.zzjo
    public void zza(String str, int i) {
        synchronized (this.zzail) {
            this.zzchu = 2;
            this.zzbym = i;
            this.zzail.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzjl
    public void zzaw(int i) {
        zza(this.zzbog, 0);
    }

    @Override // com.google.android.gms.internal.zzjo
    public void zzch(String str) {
        synchronized (this.zzail) {
            this.zzchu = 1;
            this.zzail.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zzew() {
        if (this.zzchq == null || this.zzchq.zzrw() == null || this.zzchq.zzrv() == null) {
            return;
        }
        final zzjn zzjnVarZzrw = this.zzchq.zzrw();
        zzjnVarZzrw.zza((zzjo) this);
        zzjnVarZzrw.zza((zzjl) this);
        final AdRequestParcel adRequestParcel = this.zzbxv.zzcit.zzcav;
        final zzgo zzgoVarZzrv = this.zzchq.zzrv();
        try {
            if (zzgoVarZzrv.isInitialized()) {
                com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzjk.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zzjk.this.zza(adRequestParcel, zzgoVarZzrv);
                    }
                });
            } else {
                com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzjk.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            zzgoVarZzrv.zza(com.google.android.gms.dynamic.zze.zzae(zzjk.this.mContext), adRequestParcel, (String) null, zzjnVarZzrw, zzjk.this.zzchs);
                        } catch (RemoteException e) {
                            String strValueOf = String.valueOf(zzjk.this.zzbog);
                            zzkh.zzd(strValueOf.length() != 0 ? "Fail to initialize adapter ".concat(strValueOf) : new String("Fail to initialize adapter "), e);
                            zzjk.this.zza(zzjk.this.zzbog, 0);
                        }
                    }
                });
            }
        } catch (RemoteException e) {
            zzkh.zzd("Fail to check if adapter is initialized.", e);
            zza(this.zzbog, 0);
        }
        zzk(com.google.android.gms.ads.internal.zzu.zzfu().elapsedRealtime());
        zzjnVarZzrw.zza((zzjo) null);
        zzjnVarZzrw.zza((zzjl) null);
        if (this.zzchu == 1) {
            this.zzchr.zzch(this.zzbog);
        } else {
            this.zzchr.zza(this.zzbog, this.zzbym);
        }
    }

    protected boolean zzf(long j) {
        long jElapsedRealtime = 20000 - (com.google.android.gms.ads.internal.zzu.zzfu().elapsedRealtime() - j);
        if (jElapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzail.wait(jElapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzjl
    public void zzrt() {
        zza(this.zzbxv.zzcit.zzcav, this.zzchq.zzrv());
    }
}
