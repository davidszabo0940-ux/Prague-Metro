package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.google.android.gms.internal.zzdw;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzhm;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhy;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzl {
    private final Object zzail = new Object();
    private zzx zzaux;
    private final zze zzauy;
    private final zzd zzauz;
    private final zzai zzava;
    private final zzei zzavb;
    private final com.google.android.gms.ads.internal.reward.client.zzf zzavc;
    private final zzhy zzavd;
    private final zzhl zzave;

    private abstract class zza<T> {
        private zza() {
        }

        @Nullable
        protected abstract T zzb(zzx zzxVar) throws RemoteException;

        @Nullable
        protected abstract T zzin();

        @Nullable
        protected final T zziu() {
            zzx zzxVarZzil = zzl.this.zzil();
            if (zzxVarZzil == null) {
                com.google.android.gms.ads.internal.util.client.zzb.zzcy("ClientApi class cannot be loaded.");
                return null;
            }
            try {
                return zzb(zzxVarZzil);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot invoke local loader using ClientApi class", e);
                return null;
            }
        }
    }

    public zzl(zze zzeVar, zzd zzdVar, zzai zzaiVar, zzei zzeiVar, com.google.android.gms.ads.internal.reward.client.zzf zzfVar, zzhy zzhyVar, zzhl zzhlVar) {
        this.zzauy = zzeVar;
        this.zzauz = zzdVar;
        this.zzava = zzaiVar;
        this.zzavb = zzeiVar;
        this.zzavc = zzfVar;
        this.zzavd = zzhyVar;
        this.zzave = zzhlVar;
    }

    private <T> T zza(Context context, boolean z, zza<T> zzaVar) {
        if (!z && !zzm.zziw().zzar(context)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Google Play Services is not available");
            z = true;
        }
        if (z) {
            T tZziu = zzaVar.zziu();
            return tZziu == null ? zzaVar.zzin() : tZziu;
        }
        T tZzin = zzaVar.zzin();
        return tZzin == null ? zzaVar.zziu() : tZzin;
    }

    private static boolean zza(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            return intent.getBooleanExtra(str, false);
        }
        com.google.android.gms.ads.internal.util.client.zzb.m14e("useClientJar flag not found in activity intent extras.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzc(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzm.zziw().zza(context, (String) null, "gmob-apps", bundle, true);
    }

    @Nullable
    private static zzx zzik() {
        zzx zzxVarAsInterface;
        try {
            Object objNewInstance = zzl.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (objNewInstance instanceof IBinder) {
                zzxVarAsInterface = zzx.zza.asInterface((IBinder) objNewInstance);
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.zzcy("ClientApi class is not an instance of IBinder");
                zzxVarAsInterface = null;
            }
            return zzxVarAsInterface;
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public zzx zzil() {
        zzx zzxVar;
        synchronized (this.zzail) {
            if (this.zzaux == null) {
                this.zzaux = zzik();
            }
            zzxVar = this.zzaux;
        }
        return zzxVar;
    }

    public zzu zza(final Context context, final AdSizeParcel adSizeParcel, final String str) {
        return (zzu) zza(context, false, (zza) new zza<zzu>() { // from class: com.google.android.gms.ads.internal.client.zzl.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public zzu zzb(zzx zzxVar) throws RemoteException {
                return zzxVar.createSearchAdManager(com.google.android.gms.dynamic.zze.zzae(context), adSizeParcel, str, 9256000);
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzim, reason: merged with bridge method [inline-methods] */
            public zzu zzin() {
                zzu zzuVarZza = zzl.this.zzauy.zza(context, adSizeParcel, str, null, 3);
                if (zzuVarZza != null) {
                    return zzuVarZza;
                }
                zzl.this.zzc(context, "search");
                return new zzak();
            }
        });
    }

    public zzu zza(final Context context, final AdSizeParcel adSizeParcel, final String str, final zzgn zzgnVar) {
        return (zzu) zza(context, false, (zza) new zza<zzu>() { // from class: com.google.android.gms.ads.internal.client.zzl.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public zzu zzb(zzx zzxVar) throws RemoteException {
                return zzxVar.createBannerAdManager(com.google.android.gms.dynamic.zze.zzae(context), adSizeParcel, str, zzgnVar, 9256000);
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzim, reason: merged with bridge method [inline-methods] */
            public zzu zzin() {
                zzu zzuVarZza = zzl.this.zzauy.zza(context, adSizeParcel, str, zzgnVar, 1);
                if (zzuVarZza != null) {
                    return zzuVarZza;
                }
                zzl.this.zzc(context, "banner");
                return new zzak();
            }
        });
    }

    public com.google.android.gms.ads.internal.reward.client.zzb zza(final Context context, final zzgn zzgnVar) {
        return (com.google.android.gms.ads.internal.reward.client.zzb) zza(context, false, (zza) new zza<com.google.android.gms.ads.internal.reward.client.zzb>() { // from class: com.google.android.gms.ads.internal.client.zzl.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
            public com.google.android.gms.ads.internal.reward.client.zzb zzb(zzx zzxVar) throws RemoteException {
                return zzxVar.createRewardedVideoAd(com.google.android.gms.dynamic.zze.zzae(context), zzgnVar, 9256000);
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzir, reason: merged with bridge method [inline-methods] */
            public com.google.android.gms.ads.internal.reward.client.zzb zzin() {
                com.google.android.gms.ads.internal.reward.client.zzb zzbVarZzb = zzl.this.zzavc.zzb(context, zzgnVar);
                if (zzbVarZzb != null) {
                    return zzbVarZzb;
                }
                zzl.this.zzc(context, "rewarded_video");
                return new zzan();
            }
        });
    }

    public zzdw zza(final Context context, final FrameLayout frameLayout, final FrameLayout frameLayout2) {
        return (zzdw) zza(context, false, (zza) new zza<zzdw>() { // from class: com.google.android.gms.ads.internal.client.zzl.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
            public zzdw zzb(zzx zzxVar) throws RemoteException {
                return zzxVar.createNativeAdViewDelegate(com.google.android.gms.dynamic.zze.zzae(frameLayout), com.google.android.gms.dynamic.zze.zzae(frameLayout2));
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zziq, reason: merged with bridge method [inline-methods] */
            public zzdw zzin() {
                zzdw zzdwVarZzb = zzl.this.zzavb.zzb(context, frameLayout, frameLayout2);
                if (zzdwVarZzb != null) {
                    return zzdwVarZzb;
                }
                zzl.this.zzc(context, "native_ad_view_delegate");
                return new zzam();
            }
        });
    }

    public zzs zzb(final Context context, final String str, final zzgn zzgnVar) {
        return (zzs) zza(context, false, (zza) new zza<zzs>() { // from class: com.google.android.gms.ads.internal.client.zzl.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
            public zzs zzb(zzx zzxVar) throws RemoteException {
                return zzxVar.createAdLoaderBuilder(com.google.android.gms.dynamic.zze.zzae(context), str, zzgnVar, 9256000);
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzio, reason: merged with bridge method [inline-methods] */
            public zzs zzin() {
                zzs zzsVarZza = zzl.this.zzauz.zza(context, str, zzgnVar);
                if (zzsVarZza != null) {
                    return zzsVarZza;
                }
                zzl.this.zzc(context, "native_ad");
                return new zzaj();
            }
        });
    }

    public zzu zzb(final Context context, final AdSizeParcel adSizeParcel, final String str, final zzgn zzgnVar) {
        return (zzu) zza(context, false, (zza) new zza<zzu>() { // from class: com.google.android.gms.ads.internal.client.zzl.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public zzu zzb(zzx zzxVar) throws RemoteException {
                return zzxVar.createInterstitialAdManager(com.google.android.gms.dynamic.zze.zzae(context), adSizeParcel, str, zzgnVar, 9256000);
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzim, reason: merged with bridge method [inline-methods] */
            public zzu zzin() {
                zzu zzuVarZza = zzl.this.zzauy.zza(context, adSizeParcel, str, zzgnVar, 2);
                if (zzuVarZza != null) {
                    return zzuVarZza;
                }
                zzl.this.zzc(context, "interstitial");
                return new zzak();
            }
        });
    }

    @Nullable
    public zzht zzb(final Activity activity) {
        return (zzht) zza(activity, zza(activity, "com.google.android.gms.ads.internal.purchase.useClientJar"), new zza<zzht>() { // from class: com.google.android.gms.ads.internal.client.zzl.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
            public zzht zzb(zzx zzxVar) throws RemoteException {
                return zzxVar.createInAppPurchaseManager(com.google.android.gms.dynamic.zze.zzae(activity));
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzis, reason: merged with bridge method [inline-methods] */
            public zzht zzin() {
                zzht zzhtVarZzg = zzl.this.zzavd.zzg(activity);
                if (zzhtVarZzg != null) {
                    return zzhtVarZzg;
                }
                zzl.this.zzc(activity, "iap");
                return null;
            }
        });
    }

    @Nullable
    public zzhm zzc(final Activity activity) {
        return (zzhm) zza(activity, zza(activity, "com.google.android.gms.ads.internal.overlay.useClientJar"), new zza<zzhm>() { // from class: com.google.android.gms.ads.internal.client.zzl.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
            public zzhm zzb(zzx zzxVar) throws RemoteException {
                return zzxVar.createAdOverlay(com.google.android.gms.dynamic.zze.zzae(activity));
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzit, reason: merged with bridge method [inline-methods] */
            public zzhm zzin() {
                zzhm zzhmVarZzf = zzl.this.zzave.zzf(activity);
                if (zzhmVarZzf != null) {
                    return zzhmVarZzf;
                }
                zzl.this.zzc(activity, "ad_overlay");
                return null;
            }
        });
    }

    public zzz zzl(final Context context) {
        return (zzz) zza(context, false, (zza) new zza<zzz>() { // from class: com.google.android.gms.ads.internal.client.zzl.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
            public zzz zzb(zzx zzxVar) throws RemoteException {
                return zzxVar.getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.dynamic.zze.zzae(context), 9256000);
            }

            @Override // com.google.android.gms.ads.internal.client.zzl.zza
            /* JADX INFO: renamed from: zzip, reason: merged with bridge method [inline-methods] */
            public zzz zzin() {
                zzz zzzVarZzm = zzl.this.zzava.zzm(context);
                if (zzzVarZzm != null) {
                    return zzzVarZzm;
                }
                zzl.this.zzc(context, "mobile_ads_settings");
                return new zzal();
            }
        });
    }
}
