package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzll;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzb extends zza implements com.google.android.gms.ads.internal.overlay.zzg, com.google.android.gms.ads.internal.purchase.zzj, zzs, zzev, zzgf {
    private final Messenger mMessenger;
    protected final zzgn zzajz;
    protected transient boolean zzaka;

    public zzb(Context context, AdSizeParcel adSizeParcel, String str, zzgn zzgnVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        this(new zzv(context, adSizeParcel, str, versionInfoParcel), zzgnVar, null, zzdVar);
    }

    protected zzb(zzv zzvVar, zzgn zzgnVar, @Nullable zzr zzrVar, zzd zzdVar) {
        super(zzvVar, zzrVar, zzdVar);
        this.zzajz = zzgnVar;
        this.mMessenger = new Messenger(new zzhp(this.zzajs.zzagf));
        this.zzaka = false;
    }

    private AdRequestInfoParcel.zza zza(AdRequestParcel adRequestParcel, Bundle bundle, zzka zzkaVar) {
        PackageInfo packageInfo;
        ArrayList arrayList;
        int i;
        ApplicationInfo applicationInfo = this.zzajs.zzagf.getApplicationInfo();
        try {
            packageInfo = this.zzajs.zzagf.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            while (true) {
                int i2 = i;
                if (i2 >= this.zzajs.zzapl.size()) {
                    break;
                }
                arrayList.add(this.zzajs.zzapl.keyAt(i2));
                i = i2 + 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzajs.zzagf.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (this.zzajs.zzaov != null && this.zzajs.zzaov.getParent() != null) {
            int[] iArr = new int[2];
            this.zzajs.zzaov.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            int width = this.zzajs.zzaov.getWidth();
            int height = this.zzajs.zzaov.getHeight();
            int i5 = 0;
            if (this.zzajs.zzaov.isShown() && i3 + width > 0 && i4 + height > 0 && i3 <= displayMetrics.widthPixels && i4 <= displayMetrics.heightPixels) {
                i5 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i3);
            bundle2.putInt("y", i4);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i5);
        }
        String strZzsk = zzu.zzft().zzsk();
        this.zzajs.zzapb = new zzjz(strZzsk, this.zzajs.zzaos);
        this.zzajs.zzapb.zzq(adRequestParcel);
        String strZza = zzu.zzfq().zza(this.zzajs.zzagf, this.zzajs.zzaov, this.zzajs.zzaoy);
        long value = 0;
        if (this.zzajs.zzapf != null) {
            try {
                value = this.zzajs.zzapf.getValue();
            } catch (RemoteException e2) {
                zzkh.zzcy("Cannot get correlation id, default to 0.");
            }
        }
        String string = UUID.randomUUID().toString();
        Bundle bundleZza = zzu.zzft().zza(this.zzajs.zzagf, this, strZzsk);
        arrayList = new ArrayList();
        i = 0;
        boolean z = this.zzajs.zzapg != null;
        boolean z2 = this.zzajs.zzaph != null && zzu.zzft().zzsw();
        boolean zZzr = this.zzajv.zzakl.zzr(this.zzajs.zzagf);
        String cookie = "";
        if (zzdc.zzbdl.get().booleanValue()) {
            zzkh.zzcw("Getting webview cookie from CookieManager.");
            CookieManager cookieManagerZzao = zzu.zzfs().zzao(this.zzajs.zzagf);
            if (cookieManagerZzao != null) {
                cookie = cookieManagerZzao.getCookie("googleads.g.doubleclick.net");
            }
        }
        return new AdRequestInfoParcel.zza(bundle2, adRequestParcel, this.zzajs.zzaoy, this.zzajs.zzaos, applicationInfo, packageInfo, strZzsk, zzu.zzft().getSessionId(), this.zzajs.zzaou, bundleZza, this.zzajs.zzapq, arrayList, bundle, zzu.zzft().zzso(), this.mMessenger, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, strZza, value, string, zzdc.zzjx(), this.zzajs.zzaor, this.zzajs.zzapm, new CapabilityParcel(z, z2, zZzr), this.zzajs.zzgt(), zzu.zzfq().zzey(), zzu.zzfq().zzfa(), zzu.zzfq().zzam(this.zzajs.zzagf), zzu.zzfq().zzn(this.zzajs.zzaov), this.zzajs.zzagf instanceof Activity, zzu.zzft().zzss(), cookie, zzkaVar != null ? zzkaVar.zzsh() : null, zzu.zzft().zzst(), zzu.zzgj().zzlm(), zzu.zzfq().zztj());
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public String getMediationAdapterClassName() {
        if (this.zzajs.zzaoz == null) {
            return null;
        }
        return this.zzajs.zzaoz.zzbot;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zza
    public void onAdClicked() {
        if (this.zzajs.zzaoz == null) {
            zzkh.zzcy("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (this.zzajs.zzaoz.zzcik != null && this.zzajs.zzaoz.zzcik.zzbnq != null) {
            zzu.zzgf().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, this.zzajs.zzaoz, this.zzajs.zzaos, false, this.zzajs.zzaoz.zzcik.zzbnq);
        }
        if (this.zzajs.zzaoz.zzbor != null && this.zzajs.zzaoz.zzbor.zzbnd != null) {
            zzu.zzgf().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, this.zzajs.zzaoz, this.zzajs.zzaos, false, this.zzajs.zzaoz.zzbor.zzbnd);
        }
        super.onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzg
    public void onPause() {
        this.zzaju.zzk(this.zzajs.zzaoz);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzg
    public void onResume() {
        this.zzaju.zzl(this.zzajs.zzaoz);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void pause() {
        zzab.zzhj("pause must be called on the main UI thread.");
        if (this.zzajs.zzaoz != null && this.zzajs.zzaoz.zzbtq != null && this.zzajs.zzgp()) {
            zzu.zzfs().zzj(this.zzajs.zzaoz.zzbtq);
        }
        if (this.zzajs.zzaoz != null && this.zzajs.zzaoz.zzbos != null) {
            try {
                this.zzajs.zzaoz.zzbos.pause();
            } catch (RemoteException e) {
                zzkh.zzcy("Could not pause mediation adapter.");
            }
        }
        this.zzaju.zzk(this.zzajs.zzaoz);
        this.zzajr.pause();
    }

    public void recordImpression() {
        zza(this.zzajs.zzaoz, false);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void resume() {
        zzab.zzhj("resume must be called on the main UI thread.");
        zzll zzllVar = null;
        if (this.zzajs.zzaoz != null && this.zzajs.zzaoz.zzbtq != null) {
            zzllVar = this.zzajs.zzaoz.zzbtq;
        }
        if (zzllVar != null && this.zzajs.zzgp()) {
            zzu.zzfs().zzk(this.zzajs.zzaoz.zzbtq);
        }
        if (this.zzajs.zzaoz != null && this.zzajs.zzaoz.zzbos != null) {
            try {
                this.zzajs.zzaoz.zzbos.resume();
            } catch (RemoteException e) {
                zzkh.zzcy("Could not resume mediation adapter.");
            }
        }
        if (zzllVar == null || !zzllVar.zzuq()) {
            this.zzajr.resume();
        }
        this.zzaju.zzl(this.zzajs.zzaoz);
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void zza(zzhs zzhsVar) {
        zzab.zzhj("setInAppPurchaseListener must be called on the main UI thread.");
        this.zzajs.zzapg = zzhsVar;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void zza(zzhw zzhwVar, @Nullable String str) {
        zzab.zzhj("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.zzajs.zzapr = new com.google.android.gms.ads.internal.purchase.zzk(str);
        this.zzajs.zzaph = zzhwVar;
        if (zzu.zzft().zzsn() || zzhwVar == null) {
            return;
        }
    }

    protected void zza(@Nullable zzjy zzjyVar, boolean z) {
        if (zzjyVar == null) {
            zzkh.zzcy("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.zzc(zzjyVar);
        if (zzjyVar.zzcik != null && zzjyVar.zzcik.zzbnr != null) {
            zzu.zzgf().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, zzjyVar, this.zzajs.zzaos, z, zzjyVar.zzcik.zzbnr);
        }
        if (zzjyVar.zzbor == null || zzjyVar.zzbor.zzbne == null) {
            return;
        }
        zzu.zzgf().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, zzjyVar, this.zzajs.zzaos, z, zzjyVar.zzbor.zzbne);
    }

    @Override // com.google.android.gms.internal.zzev
    public void zza(String str, ArrayList<String> arrayList) {
        com.google.android.gms.ads.internal.purchase.zzd zzdVar = new com.google.android.gms.ads.internal.purchase.zzd(str, arrayList, this.zzajs.zzagf, this.zzajs.zzaou.zzcs);
        if (this.zzajs.zzapg != null) {
            try {
                this.zzajs.zzapg.zza(zzdVar);
                return;
            } catch (RemoteException e) {
                zzkh.zzcy("Could not start In-App purchase.");
                return;
            }
        }
        zzkh.zzcy("InAppPurchaseListener is not set. Try to launch default purchase flow.");
        if (!com.google.android.gms.ads.internal.client.zzm.zziw().zzar(this.zzajs.zzagf)) {
            zzkh.zzcy("Google Play Service unavailable, cannot launch default purchase flow.");
            return;
        }
        if (this.zzajs.zzaph == null) {
            zzkh.zzcy("PlayStorePurchaseListener is not set.");
            return;
        }
        if (this.zzajs.zzapr == null) {
            zzkh.zzcy("PlayStorePurchaseVerifier is not initialized.");
            return;
        }
        if (this.zzajs.zzapv) {
            zzkh.zzcy("An in-app purchase request is already in progress, abort");
            return;
        }
        this.zzajs.zzapv = true;
        try {
            if (this.zzajs.zzaph.isValidPurchase(str)) {
                zzu.zzga().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcnq, new GInAppPurchaseManagerInfoParcel(this.zzajs.zzagf, this.zzajs.zzapr, zzdVar, this));
            } else {
                this.zzajs.zzapv = false;
            }
        } catch (RemoteException e2) {
            zzkh.zzcy("Could not start In-App purchase.");
            this.zzajs.zzapv = false;
        }
    }

    @Override // com.google.android.gms.ads.internal.purchase.zzj
    public void zza(String str, boolean z, int i, final Intent intent, com.google.android.gms.ads.internal.purchase.zzf zzfVar) {
        try {
            if (this.zzajs.zzaph != null) {
                this.zzajs.zzaph.zza(new com.google.android.gms.ads.internal.purchase.zzg(this.zzajs.zzagf, str, z, i, intent, zzfVar));
            }
        } catch (RemoteException e) {
            zzkh.zzcy("Fail to invoke PlayStorePurchaseListener.");
        }
        zzkl.zzclg.postDelayed(new Runnable() { // from class: com.google.android.gms.ads.internal.zzb.1
            @Override // java.lang.Runnable
            public void run() {
                int iZzd = zzu.zzga().zzd(intent);
                zzu.zzga();
                if (iZzd == 0 && zzb.this.zzajs.zzaoz != null && zzb.this.zzajs.zzaoz.zzbtq != null && zzb.this.zzajs.zzaoz.zzbtq.zzui() != null) {
                    zzb.this.zzajs.zzaoz.zzbtq.zzui().close();
                }
                zzb.this.zzajs.zzapv = false;
            }
        }, 500L);
    }

    @Override // com.google.android.gms.ads.internal.zza
    public boolean zza(AdRequestParcel adRequestParcel, zzdk zzdkVar) {
        zzka zzkaVarZzsu;
        if (!zzdx()) {
            return false;
        }
        Bundle bundleZza = zza(zzu.zzft().zzaa(this.zzajs.zzagf));
        this.zzajr.cancel();
        this.zzajs.zzapu = 0;
        if (zzdc.zzbcr.get().booleanValue()) {
            zzkaVarZzsu = zzu.zzft().zzsu();
            zzu.zzgi().zza(this.zzajs.zzagf, this.zzajs.zzaou, false, zzkaVarZzsu, zzkaVarZzsu != null ? zzkaVarZzsu.zzsi() : null, this.zzajs.zzaos);
        } else {
            zzkaVarZzsu = null;
        }
        AdRequestInfoParcel.zza zzaVarZza = zza(adRequestParcel, bundleZza, zzkaVarZzsu);
        zzdkVar.zzh("seq_num", zzaVarZza.zzcay);
        zzdkVar.zzh("request_id", zzaVarZza.zzcbk);
        zzdkVar.zzh("session_id", zzaVarZza.zzcaz);
        if (zzaVarZza.zzcaw != null) {
            zzdkVar.zzh("app_version", String.valueOf(zzaVarZza.zzcaw.versionCode));
        }
        this.zzajs.zzaow = zzu.zzfm().zza(this.zzajs.zzagf, zzaVarZza, this.zzajs.zzaot, this);
        return true;
    }

    protected boolean zza(AdRequestParcel adRequestParcel, zzjy zzjyVar, boolean z) {
        if (!z && this.zzajs.zzgp()) {
            if (zzjyVar.zzbnw > 0) {
                this.zzajr.zza(adRequestParcel, zzjyVar.zzbnw);
            } else if (zzjyVar.zzcik != null && zzjyVar.zzcik.zzbnw > 0) {
                this.zzajr.zza(adRequestParcel, zzjyVar.zzcik.zzbnw);
            } else if (!zzjyVar.zzccc && zzjyVar.errorCode == 2) {
                this.zzajr.zzg(adRequestParcel);
            }
        }
        return this.zzajr.zzfc();
    }

    @Override // com.google.android.gms.ads.internal.zza
    boolean zza(zzjy zzjyVar) {
        AdRequestParcel adRequestParcel;
        boolean z = false;
        if (this.zzajt != null) {
            adRequestParcel = this.zzajt;
            this.zzajt = null;
        } else {
            adRequestParcel = zzjyVar.zzcav;
            if (adRequestParcel.extras != null) {
                z = adRequestParcel.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(adRequestParcel, zzjyVar, z);
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected boolean zza(@Nullable zzjy zzjyVar, zzjy zzjyVar2) {
        int i;
        int i2 = 0;
        if (zzjyVar != null && zzjyVar.zzbou != null) {
            zzjyVar.zzbou.zza((zzgf) null);
        }
        if (zzjyVar2.zzbou != null) {
            zzjyVar2.zzbou.zza(this);
        }
        if (zzjyVar2.zzcik != null) {
            i = zzjyVar2.zzcik.zzboc;
            i2 = zzjyVar2.zzcik.zzbod;
        } else {
            i = 0;
        }
        this.zzajs.zzaps.zzh(i, i2);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzig.zza
    public void zzb(zzjy zzjyVar) {
        super.zzb(zzjyVar);
        if (zzjyVar.zzbor != null) {
            zzkh.zzcw("Pinging network fill URLs.");
            zzu.zzgf().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, zzjyVar, this.zzajs.zzaos, false, zzjyVar.zzbor.zzbnf);
            if (zzjyVar.zzcik.zzbnt != null && zzjyVar.zzcik.zzbnt.size() > 0) {
                zzkh.zzcw("Pinging urls remotely");
                zzu.zzfq().zza(this.zzajs.zzagf, zzjyVar.zzcik.zzbnt);
            }
        }
        if (zzjyVar.errorCode != 3 || zzjyVar.zzcik == null || zzjyVar.zzcik.zzbns == null) {
            return;
        }
        zzkh.zzcw("Pinging no fill URLs.");
        zzu.zzgf().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, zzjyVar, this.zzajs.zzaos, false, zzjyVar.zzcik.zzbns);
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected boolean zzc(AdRequestParcel adRequestParcel) {
        return super.zzc(adRequestParcel) && !this.zzaka;
    }

    protected boolean zzdx() {
        return zzu.zzfq().zza(this.zzajs.zzagf.getPackageManager(), this.zzajs.zzagf.getPackageName(), "android.permission.INTERNET") && zzu.zzfq().zzac(this.zzajs.zzagf);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzg
    public void zzdy() {
        this.zzaju.zzi(this.zzajs.zzaoz);
        this.zzaka = false;
        zzds();
        this.zzajs.zzapb.zzsb();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzg
    public void zzdz() {
        this.zzaka = true;
        zzdu();
    }

    @Override // com.google.android.gms.internal.zzgf
    public void zzea() {
        onAdClicked();
    }

    @Override // com.google.android.gms.internal.zzgf
    public void zzeb() {
        zzdy();
    }

    @Override // com.google.android.gms.internal.zzgf
    public void zzec() {
        zzdp();
    }

    @Override // com.google.android.gms.internal.zzgf
    public void zzed() {
        zzdz();
    }

    @Override // com.google.android.gms.internal.zzgf
    public void zzee() {
        if (this.zzajs.zzaoz != null) {
            String str = this.zzajs.zzaoz.zzbot;
            zzkh.zzcy(new StringBuilder(String.valueOf(str).length() + 74).append("Mediation adapter ").append(str).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        zza(this.zzajs.zzaoz, true);
        zzdv();
    }

    @Override // com.google.android.gms.internal.zzgf
    public void zzef() {
        recordImpression();
    }

    @Override // com.google.android.gms.ads.internal.zzs
    public void zzeg() {
        zzu.zzfq().runOnUiThread(new Runnable() { // from class: com.google.android.gms.ads.internal.zzb.2
            @Override // java.lang.Runnable
            public void run() {
                zzb.this.zzajr.pause();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.zzs
    public void zzeh() {
        zzu.zzfq().runOnUiThread(new Runnable() { // from class: com.google.android.gms.ads.internal.zzb.3
            @Override // java.lang.Runnable
            public void run() {
                zzb.this.zzajr.resume();
            }
        });
    }
}
