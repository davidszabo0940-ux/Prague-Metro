package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.Window;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzes;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzl extends zzc implements zzex, zzfc.zza {
    protected transient boolean zzalu;
    private int zzalv;
    private boolean zzalw;
    private float zzalx;

    @zzir
    private class zza extends zzkg {
        private final int zzaly;

        public zza(int i) {
            this.zzaly = i;
        }

        @Override // com.google.android.gms.internal.zzkg
        public void onStop() {
        }

        @Override // com.google.android.gms.internal.zzkg
        public void zzew() {
            InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(zzl.this.zzajs.zzamc, zzl.this.zzet(), zzl.this.zzalw, zzl.this.zzalx, zzl.this.zzajs.zzamc ? this.zzaly : -1);
            int requestedOrientation = zzl.this.zzajs.zzaoz.zzbtq.getRequestedOrientation();
            final AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzl.this, zzl.this, zzl.this, zzl.this.zzajs.zzaoz.zzbtq, requestedOrientation == -1 ? zzl.this.zzajs.zzaoz.orientation : requestedOrientation, zzl.this.zzajs.zzaou, zzl.this.zzajs.zzaoz.zzcch, interstitialAdParameterParcel);
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzl.zza.1
                @Override // java.lang.Runnable
                public void run() {
                    zzu.zzfo().zza(zzl.this.zzajs.zzagf, adOverlayInfoParcel);
                }
            });
        }
    }

    public zzl(Context context, AdSizeParcel adSizeParcel, String str, zzgn zzgnVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        super(context, adSizeParcel, str, zzgnVar, versionInfoParcel, zzdVar);
        this.zzalv = -1;
        this.zzalu = false;
    }

    private void zzb(Bundle bundle) {
        zzu.zzfq().zzb(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, "gmob-apps", bundle, false);
    }

    private zzjy.zza zzc(zzjy.zza zzaVar) {
        try {
            String string = zziu.zzc(zzaVar.zzciu).toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zzaVar.zzcit.zzaos);
            zzge zzgeVar = new zzge(Collections.singletonList(new zzgd(string, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList())), -1L, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1L, 0, 1, null, 0, -1, -1L, false);
            AdResponseParcel adResponseParcel = zzaVar.zzciu;
            return new zzjy.zza(zzaVar.zzcit, new AdResponseParcel(zzaVar.zzcit, adResponseParcel.zzbts, adResponseParcel.body, adResponseParcel.zzbnq, adResponseParcel.zzbnr, adResponseParcel.zzccb, true, adResponseParcel.zzccd, adResponseParcel.zzcce, adResponseParcel.zzbnw, adResponseParcel.orientation, adResponseParcel.zzccf, adResponseParcel.zzccg, adResponseParcel.zzcch, adResponseParcel.zzcci, adResponseParcel.zzccj, adResponseParcel.zzcck, adResponseParcel.zzccl, adResponseParcel.zzaus, adResponseParcel.zzcbd, adResponseParcel.zzccm, adResponseParcel.zzccn, adResponseParcel.zzccq, adResponseParcel.zzaut, adResponseParcel.zzauu, adResponseParcel.zzccr, adResponseParcel.zzccs, adResponseParcel.zzcct, adResponseParcel.zzccu, adResponseParcel.zzccv, adResponseParcel.zzcbu, adResponseParcel.zzcbv, adResponseParcel.zzbnt, adResponseParcel.zzccw, adResponseParcel.zzbnu, adResponseParcel.zzccx), zzgeVar, zzaVar.zzaoy, zzaVar.errorCode, zzaVar.zzcio, zzaVar.zzcip, zzaVar.zzcii);
        } catch (JSONException e) {
            zzkh.zzb("Unable to generate ad state for an interstitial ad with pooling.", e);
            return zzaVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.client.zzu
    public void showInterstitial() {
        zzab.zzhj("showInterstitial must be called on the main UI thread.");
        if (this.zzajs.zzaoz == null) {
            zzkh.zzcy("The interstitial has not loaded.");
            return;
        }
        if (zzdc.zzbas.get().booleanValue()) {
            String packageName = this.zzajs.zzagf.getApplicationContext() != null ? this.zzajs.zzagf.getApplicationContext().getPackageName() : this.zzajs.zzagf.getPackageName();
            if (!this.zzalu) {
                zzkh.zzcy("It is not recommended to show an interstitial before onAdLoaded completes.");
                Bundle bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_before_load_finish");
                zzb(bundle);
            }
            if (!zzu.zzfq().zzai(this.zzajs.zzagf)) {
                zzkh.zzcy("It is not recommended to show an interstitial when app is not in foreground.");
                Bundle bundle2 = new Bundle();
                bundle2.putString("appid", packageName);
                bundle2.putString("action", "show_interstitial_app_not_in_foreground");
                zzb(bundle2);
            }
        }
        if (this.zzajs.zzgq()) {
            return;
        }
        if (this.zzajs.zzaoz.zzccc && this.zzajs.zzaoz.zzbos != null) {
            try {
                this.zzajs.zzaoz.zzbos.showInterstitial();
                return;
            } catch (RemoteException e) {
                zzkh.zzd("Could not show interstitial.", e);
                zzeu();
                return;
            }
        }
        if (this.zzajs.zzaoz.zzbtq == null) {
            zzkh.zzcy("The interstitial failed to load.");
            return;
        }
        if (this.zzajs.zzaoz.zzbtq.zzuo()) {
            zzkh.zzcy("The interstitial is already showing.");
            return;
        }
        this.zzajs.zzaoz.zzbtq.zzah(true);
        if (this.zzajs.zzaoz.zzcii != null) {
            this.zzaju.zza(this.zzajs.zzaoy, this.zzajs.zzaoz);
        }
        Bitmap bitmapZzaj = this.zzajs.zzamc ? zzu.zzfq().zzaj(this.zzajs.zzagf) : null;
        this.zzalv = zzu.zzgh().zzb(bitmapZzaj);
        if (zzdc.zzbby.get().booleanValue() && bitmapZzaj != null) {
            return;
        }
        InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.zzajs.zzamc, zzet(), false, 0.0f, -1);
        int requestedOrientation = this.zzajs.zzaoz.zzbtq.getRequestedOrientation();
        if (requestedOrientation == -1) {
            requestedOrientation = this.zzajs.zzaoz.orientation;
        }
        zzu.zzfo().zza(this.zzajs.zzagf, new AdOverlayInfoParcel(this, this, this, this.zzajs.zzaoz.zzbtq, requestedOrientation, this.zzajs.zzaou, this.zzajs.zzaoz.zzcch, interstitialAdParameterParcel));
    }

    @Override // com.google.android.gms.ads.internal.zzc
    protected zzll zza(zzjy.zza zzaVar, @Nullable zze zzeVar, @Nullable zzjs zzjsVar) {
        zzll zzllVarZza = zzu.zzfr().zza(this.zzajs.zzagf, this.zzajs.zzaoy, false, false, this.zzajs.zzaot, this.zzajs.zzaou, this.zzajn, this, this.zzajv);
        zzllVarZza.zzuk().zza(this, null, this, this, zzdc.zzazr.get().booleanValue(), this, this, zzeVar, null, zzjsVar);
        zza(zzllVarZza);
        zzllVarZza.zzda(zzaVar.zzcit.zzcbk);
        zzfc.zza(zzllVarZza, this);
        zzes.zzd(zzllVarZza);
        return zzllVarZza;
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza
    public void zza(zzjy.zza zzaVar, zzdk zzdkVar) {
        if (!zzdc.zzbac.get().booleanValue()) {
            super.zza(zzaVar, zzdkVar);
            return;
        }
        if (zzaVar.errorCode != -2) {
            super.zza(zzaVar, zzdkVar);
            return;
        }
        Bundle bundle = zzaVar.zzcit.zzcav.zzatu.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        boolean z = bundle == null || !bundle.containsKey("gw");
        boolean z2 = zzaVar.zzciu.zzccc ? false : true;
        if (z && z2) {
            this.zzajs.zzapa = zzc(zzaVar);
        }
        super.zza(this.zzajs.zzapa, zzdkVar);
    }

    @Override // com.google.android.gms.internal.zzex
    public void zza(boolean z, float f) {
        this.zzalw = z;
        this.zzalx = f;
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(AdRequestParcel adRequestParcel, zzdk zzdkVar) {
        if (this.zzajs.zzaoz == null) {
            return super.zza(adRequestParcel, zzdkVar);
        }
        zzkh.zzcy("An interstitial is already loading. Aborting.");
        return false;
    }

    @Override // com.google.android.gms.ads.internal.zzb
    protected boolean zza(AdRequestParcel adRequestParcel, zzjy zzjyVar, boolean z) {
        if (this.zzajs.zzgp() && zzjyVar.zzbtq != null) {
            zzu.zzfs().zzj(zzjyVar.zzbtq);
        }
        return this.zzajr.zzfc();
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(@Nullable zzjy zzjyVar, zzjy zzjyVar2) {
        if (!super.zza(zzjyVar, zzjyVar2)) {
            return false;
        }
        if (!this.zzajs.zzgp() && this.zzajs.zzapt != null && zzjyVar2.zzcii != null) {
            this.zzaju.zza(this.zzajs.zzaoy, zzjyVar2, this.zzajs.zzapt);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.zzfc.zza
    public void zzb(RewardItemParcel rewardItemParcel) {
        if (this.zzajs.zzaoz != null) {
            if (this.zzajs.zzaoz.zzcct != null) {
                zzu.zzfq().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, this.zzajs.zzaoz.zzcct);
            }
            if (this.zzajs.zzaoz.zzccr != null) {
                rewardItemParcel = this.zzajs.zzaoz.zzccr;
            }
        }
        zza(rewardItemParcel);
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected void zzds() {
        zzeu();
        super.zzds();
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected void zzdv() {
        super.zzdv();
        this.zzalu = true;
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.overlay.zzg
    public void zzdz() {
        zzlm zzlmVarZzuk;
        recordImpression();
        super.zzdz();
        if (this.zzajs.zzaoz == null || this.zzajs.zzaoz.zzbtq == null || (zzlmVarZzuk = this.zzajs.zzaoz.zzbtq.zzuk()) == null) {
            return;
        }
        zzlmVarZzuk.zzvb();
    }

    protected boolean zzet() {
        Window window;
        if (!(this.zzajs.zzagf instanceof Activity) || (window = ((Activity) this.zzajs.zzagf).getWindow()) == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        return (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
    }

    public void zzeu() {
        zzu.zzgh().zzb(Integer.valueOf(this.zzalv));
        if (this.zzajs.zzgp()) {
            this.zzajs.zzgm();
            this.zzajs.zzaoz = null;
            this.zzajs.zzamc = false;
            this.zzalu = false;
        }
    }

    @Override // com.google.android.gms.internal.zzfc.zza
    public void zzev() {
        if (this.zzajs.zzaoz != null && this.zzajs.zzaoz.zzcin != null) {
            zzu.zzfq().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, this.zzajs.zzaoz.zzcin);
        }
        zzdw();
    }

    @Override // com.google.android.gms.internal.zzex
    public void zzg(boolean z) {
        this.zzajs.zzamc = z;
    }
}
