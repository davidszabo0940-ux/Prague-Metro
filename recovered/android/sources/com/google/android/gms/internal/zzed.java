package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzed implements NativeCustomTemplateAd {
    private final zzec zzbhl;

    public zzed(zzec zzecVar) {
        this.zzbhl = zzecVar;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public List<String> getAvailableAssetNames() {
        try {
            return this.zzbhl.getAvailableAssetNames();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public String getCustomTemplateId() {
        try {
            return this.zzbhl.getCustomTemplateId();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public NativeAd.Image getImage(String str) {
        try {
            zzdu zzduVarZzav = this.zzbhl.zzav(str);
            if (zzduVarZzav != null) {
                return new zzdv(zzduVarZzav);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get image.", e);
        }
        return null;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public CharSequence getText(String str) {
        try {
            return this.zzbhl.zzau(str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get string.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public void performClick(String str) {
        try {
            this.zzbhl.performClick(str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to perform click.", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public void recordImpression() {
        try {
            this.zzbhl.recordImpression();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to record impression.", e);
        }
    }
}
