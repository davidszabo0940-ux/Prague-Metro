package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;

/* JADX INFO: loaded from: classes.dex */
public class zzaj extends zzs.zza {
    private zzq zzald;

    private class zza extends zzr.zza {
        private zza() {
        }

        @Override // com.google.android.gms.ads.internal.client.zzr
        public String getMediationAdapterClassName() throws RemoteException {
            return null;
        }

        @Override // com.google.android.gms.ads.internal.client.zzr
        public boolean isLoading() throws RemoteException {
            return false;
        }

        @Override // com.google.android.gms.ads.internal.client.zzr
        public void zzf(AdRequestParcel adRequestParcel) throws RemoteException {
            com.google.android.gms.ads.internal.util.client.zzb.m14e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
            com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzaj.zza.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zzaj.this.zzald != null) {
                        try {
                            zzaj.this.zzald.onAdFailedToLoad(1);
                        } catch (RemoteException e) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not notify onAdFailedToLoad event.", e);
                        }
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzee zzeeVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzef zzefVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(String str, zzeh zzehVar, zzeg zzegVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zzb(zzq zzqVar) throws RemoteException {
        this.zzald = zzqVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zzb(zzy zzyVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public zzr zzes() throws RemoteException {
        return new zza();
    }
}
