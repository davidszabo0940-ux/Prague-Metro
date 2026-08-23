package com.google.android.gms.ads.internal.reward.client;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zze implements RewardItem {
    private final zza zzcho;

    public zze(zza zzaVar) {
        this.zzcho = zzaVar;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public int getAmount() {
        if (this.zzcho == null) {
            return 0;
        }
        try {
            return this.zzcho.getAmount();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public String getType() {
        if (this.zzcho == null) {
            return null;
        }
        try {
            return this.zzcho.getType();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
