package com.google.android.gms.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzfn {
    com.google.android.gms.ads.internal.client.zzq zzald;
    com.google.android.gms.ads.internal.client.zzw zzbkl;
    zzhs zzbkm;
    zzdo zzbkn;
    com.google.android.gms.ads.internal.client.zzp zzbko;
    com.google.android.gms.ads.internal.reward.client.zzd zzbkp;

    private class zza extends com.google.android.gms.ads.internal.client.zzq.zza {
        com.google.android.gms.ads.internal.client.zzq zzbkq;

        zza(com.google.android.gms.ads.internal.client.zzq zzqVar) {
            this.zzbkq = zzqVar;
        }

        @Override // com.google.android.gms.ads.internal.client.zzq
        public void onAdClosed() throws RemoteException {
            this.zzbkq.onAdClosed();
            com.google.android.gms.ads.internal.zzu.zzgb().zzlq();
        }

        @Override // com.google.android.gms.ads.internal.client.zzq
        public void onAdFailedToLoad(int i) throws RemoteException {
            this.zzbkq.onAdFailedToLoad(i);
        }

        @Override // com.google.android.gms.ads.internal.client.zzq
        public void onAdLeftApplication() throws RemoteException {
            this.zzbkq.onAdLeftApplication();
        }

        @Override // com.google.android.gms.ads.internal.client.zzq
        public void onAdLoaded() throws RemoteException {
            this.zzbkq.onAdLoaded();
        }

        @Override // com.google.android.gms.ads.internal.client.zzq
        public void onAdOpened() throws RemoteException {
            this.zzbkq.onAdOpened();
        }
    }

    zzfn() {
    }

    void zzc(com.google.android.gms.ads.internal.zzl zzlVar) {
        if (this.zzald != null) {
            zzlVar.zza(new zza(this.zzald));
        }
        if (this.zzbkl != null) {
            zzlVar.zza(this.zzbkl);
        }
        if (this.zzbkm != null) {
            zzlVar.zza(this.zzbkm);
        }
        if (this.zzbkn != null) {
            zzlVar.zza(this.zzbkn);
        }
        if (this.zzbko != null) {
            zzlVar.zza(this.zzbko);
        }
        if (this.zzbkp != null) {
            zzlVar.zza(this.zzbkp);
        }
    }
}
