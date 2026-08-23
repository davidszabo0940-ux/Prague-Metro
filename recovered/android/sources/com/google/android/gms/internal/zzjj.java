package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzjj extends com.google.android.gms.ads.internal.zzb implements zzjm {
    private static final zzgm zzchk = new zzgm();
    private final Map<String, zzjq> zzchl;
    private boolean zzchm;

    public zzjj(Context context, com.google.android.gms.ads.internal.zzd zzdVar, AdSizeParcel adSizeParcel, zzgn zzgnVar, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, null, zzgnVar, versionInfoParcel, zzdVar);
        this.zzchl = new HashMap();
    }

    private zzjy.zza zze(zzjy.zza zzaVar) {
        zzkh.m95v("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String string = zziu.zzc(zzaVar.zzciu).toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zzaVar.zzcit.zzaos);
            return new zzjy.zza(zzaVar.zzcit, zzaVar.zzciu, new zzge(Arrays.asList(new zzgd(string, null, Arrays.asList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList())), -1L, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1L, 0, 1, null, 0, -1, -1L, false), zzaVar.zzaoy, zzaVar.errorCode, zzaVar.zzcio, zzaVar.zzcip, zzaVar.zzcii);
        } catch (JSONException e) {
            zzkh.zzb("Unable to generate ad state for non-mediated rewarded video.", e);
            return zzf(zzaVar);
        }
    }

    private zzjy.zza zzf(zzjy.zza zzaVar) {
        return new zzjy.zza(zzaVar.zzcit, zzaVar.zzciu, null, zzaVar.zzaoy, 0, zzaVar.zzcio, zzaVar.zzcip, zzaVar.zzcii);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void destroy() {
        com.google.android.gms.common.internal.zzab.zzhj("destroy must be called on the main UI thread.");
        for (String str : this.zzchl.keySet()) {
            try {
                zzjq zzjqVar = this.zzchl.get(str);
                if (zzjqVar != null && zzjqVar.zzrv() != null) {
                    zzjqVar.zzrv().destroy();
                }
            } catch (RemoteException e) {
                String strValueOf = String.valueOf(str);
                zzkh.zzcy(strValueOf.length() != 0 ? "Fail to destroy adapter: ".concat(strValueOf) : new String("Fail to destroy adapter: "));
            }
        }
    }

    public boolean isLoaded() {
        com.google.android.gms.common.internal.zzab.zzhj("isLoaded must be called on the main UI thread.");
        return this.zzajs.zzaow == null && this.zzajs.zzaox == null && this.zzajs.zzaoz != null && !this.zzchm;
    }

    public void onContextChanged(@NonNull Context context) {
        Iterator<zzjq> it = this.zzchl.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().zzrv().zzj(com.google.android.gms.dynamic.zze.zzae(context));
            } catch (RemoteException e) {
                zzkh.zzb("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzjm
    public void onRewardedVideoAdClosed() {
        zzds();
    }

    @Override // com.google.android.gms.internal.zzjm
    public void onRewardedVideoAdLeftApplication() {
        zzdt();
    }

    @Override // com.google.android.gms.internal.zzjm
    public void onRewardedVideoAdOpened() {
        zza(this.zzajs.zzaoz, false);
        zzdu();
    }

    @Override // com.google.android.gms.internal.zzjm
    public void onRewardedVideoStarted() {
        if (this.zzajs.zzaoz != null && this.zzajs.zzaoz.zzbor != null) {
            com.google.android.gms.ads.internal.zzu.zzgf().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, this.zzajs.zzaoz, this.zzajs.zzaos, false, this.zzajs.zzaoz.zzbor.zzbnh);
        }
        zzdw();
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void pause() {
        com.google.android.gms.common.internal.zzab.zzhj("pause must be called on the main UI thread.");
        for (String str : this.zzchl.keySet()) {
            try {
                zzjq zzjqVar = this.zzchl.get(str);
                if (zzjqVar != null && zzjqVar.zzrv() != null) {
                    zzjqVar.zzrv().pause();
                }
            } catch (RemoteException e) {
                String strValueOf = String.valueOf(str);
                zzkh.zzcy(strValueOf.length() != 0 ? "Fail to pause adapter: ".concat(strValueOf) : new String("Fail to pause adapter: "));
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void resume() {
        com.google.android.gms.common.internal.zzab.zzhj("resume must be called on the main UI thread.");
        for (String str : this.zzchl.keySet()) {
            try {
                zzjq zzjqVar = this.zzchl.get(str);
                if (zzjqVar != null && zzjqVar.zzrv() != null) {
                    zzjqVar.zzrv().resume();
                }
            } catch (RemoteException e) {
                String strValueOf = String.valueOf(str);
                zzkh.zzcy(strValueOf.length() != 0 ? "Fail to resume adapter: ".concat(strValueOf) : new String("Fail to resume adapter: "));
            }
        }
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        com.google.android.gms.common.internal.zzab.zzhj("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(rewardedVideoAdRequestParcel.zzaos)) {
            zzkh.zzcy("Invalid ad unit id. Aborting.");
            return;
        }
        this.zzchm = false;
        this.zzajs.zzaos = rewardedVideoAdRequestParcel.zzaos;
        super.zzb(rewardedVideoAdRequestParcel.zzcav);
    }

    @Override // com.google.android.gms.ads.internal.zza
    public void zza(final zzjy.zza zzaVar, zzdk zzdkVar) {
        if (zzaVar.errorCode != -2) {
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzjj.1
                @Override // java.lang.Runnable
                public void run() {
                    zzjj.this.zzb(new zzjy(zzaVar, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        this.zzajs.zzapa = zzaVar;
        if (zzaVar.zzcik == null) {
            this.zzajs.zzapa = zze(zzaVar);
        }
        this.zzajs.zzapu = 0;
        this.zzajs.zzaox = com.google.android.gms.ads.internal.zzu.zzfp().zza(this.zzajs.zzagf, this.zzajs.zzapa, this);
    }

    @Override // com.google.android.gms.ads.internal.zzb
    protected boolean zza(AdRequestParcel adRequestParcel, zzjy zzjyVar, boolean z) {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(zzjy zzjyVar, zzjy zzjyVar2) {
        return true;
    }

    @Override // com.google.android.gms.internal.zzjm
    public void zzc(@Nullable RewardItemParcel rewardItemParcel) {
        if (this.zzajs.zzaoz != null && this.zzajs.zzaoz.zzbor != null) {
            com.google.android.gms.ads.internal.zzu.zzgf().zza(this.zzajs.zzagf, this.zzajs.zzaou.zzcs, this.zzajs.zzaoz, this.zzajs.zzaos, false, this.zzajs.zzaoz.zzbor.zzbni);
        }
        if (this.zzajs.zzaoz != null && this.zzajs.zzaoz.zzcik != null && !TextUtils.isEmpty(this.zzajs.zzaoz.zzcik.zzbnx)) {
            rewardItemParcel = new RewardItemParcel(this.zzajs.zzaoz.zzcik.zzbnx, this.zzajs.zzaoz.zzcik.zzbny);
        }
        zza(rewardItemParcel);
    }

    @Nullable
    public zzjq zzcg(String str) {
        Exception exc;
        zzjq zzjqVar;
        zzjq zzjqVar2 = this.zzchl.get(str);
        if (zzjqVar2 != null) {
            return zzjqVar2;
        }
        try {
            zzjqVar = new zzjq(("com.google.ads.mediation.admob.AdMobAdapter".equals(str) ? zzchk : this.zzajz).zzbn(str), this);
            try {
                this.zzchl.put(str, zzjqVar);
                return zzjqVar;
            } catch (Exception e) {
                exc = e;
                String strValueOf = String.valueOf(str);
                zzkh.zzd(strValueOf.length() != 0 ? "Fail to instantiate adapter ".concat(strValueOf) : new String("Fail to instantiate adapter "), exc);
                return zzjqVar;
            }
        } catch (Exception e2) {
            exc = e2;
            zzjqVar = zzjqVar2;
        }
    }

    public void zzrr() {
        com.google.android.gms.common.internal.zzab.zzhj("showAd must be called on the main UI thread.");
        if (!isLoaded()) {
            zzkh.zzcy("The reward video has not loaded.");
            return;
        }
        this.zzchm = true;
        zzjq zzjqVarZzcg = zzcg(this.zzajs.zzaoz.zzbot);
        if (zzjqVarZzcg == null || zzjqVarZzcg.zzrv() == null) {
            return;
        }
        try {
            zzjqVarZzcg.zzrv().showVideo();
        } catch (RemoteException e) {
            zzkh.zzd("Could not call showVideo.", e);
        }
    }

    @Override // com.google.android.gms.internal.zzjm
    public void zzrs() {
        onAdClicked();
    }
}
