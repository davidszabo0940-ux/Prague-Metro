package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzq extends zzb {
    public zzq(Context context, zzd zzdVar, AdSizeParcel adSizeParcel, String str, zzgn zzgnVar, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, zzgnVar, versionInfoParcel, zzdVar);
    }

    private static com.google.android.gms.ads.internal.formats.zzd zza(zzgr zzgrVar) throws RemoteException {
        return new com.google.android.gms.ads.internal.formats.zzd(zzgrVar.getHeadline(), zzgrVar.getImages(), zzgrVar.getBody(), zzgrVar.zzkw() != null ? zzgrVar.zzkw() : null, zzgrVar.getCallToAction(), zzgrVar.getStarRating(), zzgrVar.getStore(), zzgrVar.getPrice(), null, zzgrVar.getExtras());
    }

    private static com.google.android.gms.ads.internal.formats.zze zza(zzgs zzgsVar) throws RemoteException {
        return new com.google.android.gms.ads.internal.formats.zze(zzgsVar.getHeadline(), zzgsVar.getImages(), zzgsVar.getBody(), zzgsVar.zzla() != null ? zzgsVar.zzla() : null, zzgsVar.getCallToAction(), zzgsVar.getAdvertiser(), null, zzgsVar.getExtras());
    }

    private void zza(final com.google.android.gms.ads.internal.formats.zzd zzdVar) {
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzq.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (zzq.this.zzajs.zzapi != null) {
                        zzq.this.zzajs.zzapi.zza(zzdVar);
                    }
                } catch (RemoteException e) {
                    zzkh.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
                }
            }
        });
    }

    private void zza(final com.google.android.gms.ads.internal.formats.zze zzeVar) {
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzq.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (zzq.this.zzajs.zzapj != null) {
                        zzq.this.zzajs.zzapj.zza(zzeVar);
                    }
                } catch (RemoteException e) {
                    zzkh.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
                }
            }
        });
    }

    private void zza(final zzjy zzjyVar, final String str) {
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzq.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zzq.this.zzajs.zzapl.get(str).zza((com.google.android.gms.ads.internal.formats.zzf) zzjyVar.zzciq);
                } catch (RemoteException e) {
                    zzkh.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
                }
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.client.zzu
    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public void zza(SimpleArrayMap<String, zzeh> simpleArrayMap) {
        zzab.zzhj("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.zzajs.zzapl = simpleArrayMap;
    }

    public void zza(com.google.android.gms.ads.internal.formats.zzh zzhVar) {
        if (this.zzajs.zzaoz.zzcii != null) {
            zzu.zzft().zzsv().zza(this.zzajs.zzaoy, this.zzajs.zzaoz, zzhVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void zza(zzdo zzdoVar) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void zza(zzhs zzhsVar) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zza
    public void zza(final zzjy.zza zzaVar, zzdk zzdkVar) {
        if (zzaVar.zzaoy != null) {
            this.zzajs.zzaoy = zzaVar.zzaoy;
        }
        if (zzaVar.errorCode != -2) {
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzq.1
                @Override // java.lang.Runnable
                public void run() {
                    zzq.this.zzb(new zzjy(zzaVar, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        this.zzajs.zzapu = 0;
        this.zzajs.zzaox = zzu.zzfp().zza(this.zzajs.zzagf, this, zzaVar, this.zzajs.zzaot, null, this.zzajz, this, zzdkVar);
        String strValueOf = String.valueOf(this.zzajs.zzaox.getClass().getName());
        zzkh.zzcw(strValueOf.length() != 0 ? "AdRenderer: ".concat(strValueOf) : new String("AdRenderer: "));
    }

    @Override // com.google.android.gms.ads.internal.zzb
    protected boolean zza(AdRequestParcel adRequestParcel, zzjy zzjyVar, boolean z) {
        return this.zzajr.zzfc();
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    protected boolean zza(zzjy zzjyVar, zzjy zzjyVar2) {
        zzb((List<String>) null);
        if (!this.zzajs.zzgp()) {
            throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
        }
        if (zzjyVar2.zzccc) {
            try {
                zzgr zzgrVarZzmq = zzjyVar2.zzbos != null ? zzjyVar2.zzbos.zzmq() : null;
                zzgs zzgsVarZzmr = zzjyVar2.zzbos != null ? zzjyVar2.zzbos.zzmr() : null;
                if (zzgrVarZzmq != null && this.zzajs.zzapi != null) {
                    com.google.android.gms.ads.internal.formats.zzd zzdVarZza = zza(zzgrVarZzmq);
                    zzdVarZza.zzb(new com.google.android.gms.ads.internal.formats.zzg(this.zzajs.zzagf, this, this.zzajs.zzaot, zzgrVarZzmq));
                    zza(zzdVarZza);
                } else {
                    if (zzgsVarZzmr == null || this.zzajs.zzapj == null) {
                        zzkh.zzcy("No matching mapper/listener for retrieved native ad template.");
                        zzh(0);
                        return false;
                    }
                    com.google.android.gms.ads.internal.formats.zze zzeVarZza = zza(zzgsVarZzmr);
                    zzeVarZza.zzb(new com.google.android.gms.ads.internal.formats.zzg(this.zzajs.zzagf, this, this.zzajs.zzaot, zzgsVarZzmr));
                    zza(zzeVarZza);
                }
            } catch (RemoteException e) {
                zzkh.zzd("Failed to get native ad mapper", e);
            }
        } else {
            com.google.android.gms.ads.internal.formats.zzh.zza zzaVar = zzjyVar2.zzciq;
            if ((zzaVar instanceof com.google.android.gms.ads.internal.formats.zze) && this.zzajs.zzapj != null) {
                zza((com.google.android.gms.ads.internal.formats.zze) zzjyVar2.zzciq);
            } else if ((zzaVar instanceof com.google.android.gms.ads.internal.formats.zzd) && this.zzajs.zzapi != null) {
                zza((com.google.android.gms.ads.internal.formats.zzd) zzjyVar2.zzciq);
            } else {
                if (!(zzaVar instanceof com.google.android.gms.ads.internal.formats.zzf) || this.zzajs.zzapl == null || this.zzajs.zzapl.get(((com.google.android.gms.ads.internal.formats.zzf) zzaVar).getCustomTemplateId()) == null) {
                    zzkh.zzcy("No matching listener for retrieved native ad template.");
                    zzh(0);
                    return false;
                }
                zza(zzjyVar2, ((com.google.android.gms.ads.internal.formats.zzf) zzaVar).getCustomTemplateId());
            }
        }
        return super.zza(zzjyVar, zzjyVar2);
    }

    public void zzb(SimpleArrayMap<String, zzeg> simpleArrayMap) {
        zzab.zzhj("setOnCustomClickListener must be called on the main UI thread.");
        this.zzajs.zzapk = simpleArrayMap;
    }

    public void zzb(NativeAdOptionsParcel nativeAdOptionsParcel) {
        zzab.zzhj("setNativeAdOptions must be called on the main UI thread.");
        this.zzajs.zzapm = nativeAdOptionsParcel;
    }

    public void zzb(zzee zzeeVar) {
        zzab.zzhj("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.zzajs.zzapi = zzeeVar;
    }

    public void zzb(zzef zzefVar) {
        zzab.zzhj("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.zzajs.zzapj = zzefVar;
    }

    public void zzb(List<String> list) {
        zzab.zzhj("setNativeTemplates must be called on the main UI thread.");
        this.zzajs.zzapq = list;
    }

    public SimpleArrayMap<String, zzeh> zzfb() {
        zzab.zzhj("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzajs.zzapl;
    }

    public zzeg zzv(String str) {
        zzab.zzhj("getOnCustomClickListener must be called on the main UI thread.");
        return this.zzajs.zzapk.get(str);
    }
}
