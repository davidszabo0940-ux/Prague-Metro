package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzes;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlq;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzf extends zzc implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private boolean zzakp;

    public class zza {
        public zza() {
        }

        public void onClick() {
            zzf.this.onAdClicked();
        }
    }

    public zzf(Context context, AdSizeParcel adSizeParcel, String str, zzgn zzgnVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        super(context, adSizeParcel, str, zzgnVar, versionInfoParcel, zzdVar);
    }

    private AdSizeParcel zzb(zzjy.zza zzaVar) {
        AdSize adSizeZzij;
        if (zzaVar.zzciu.zzaut) {
            return this.zzajs.zzaoy;
        }
        String str = zzaVar.zzciu.zzccf;
        if (str != null) {
            String[] strArrSplit = str.split("[xX]");
            strArrSplit[0] = strArrSplit[0].trim();
            strArrSplit[1] = strArrSplit[1].trim();
            adSizeZzij = new AdSize(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
        } else {
            adSizeZzij = this.zzajs.zzaoy.zzij();
        }
        return new AdSizeParcel(this.zzajs.zzagf, adSizeZzij);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean zzb(@Nullable zzjy zzjyVar, zzjy zzjyVar2) {
        if (zzjyVar2.zzccc) {
            View viewZzf = zzn.zzf(zzjyVar2);
            if (viewZzf == null) {
                zzkh.zzcy("Could not get mediation view");
                return false;
            }
            View nextView = this.zzajs.zzaov.getNextView();
            if (nextView != 0) {
                if (nextView instanceof zzll) {
                    ((zzll) nextView).destroy();
                }
                this.zzajs.zzaov.removeView(nextView);
            }
            if (!zzn.zzg(zzjyVar2)) {
                try {
                    zzb(viewZzf);
                } catch (Throwable th) {
                    zzkh.zzd("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            }
        } else if (zzjyVar2.zzcim != null && zzjyVar2.zzbtq != null) {
            zzjyVar2.zzbtq.zza(zzjyVar2.zzcim);
            this.zzajs.zzaov.removeAllViews();
            this.zzajs.zzaov.setMinimumWidth(zzjyVar2.zzcim.widthPixels);
            this.zzajs.zzaov.setMinimumHeight(zzjyVar2.zzcim.heightPixels);
            zzb(zzjyVar2.zzbtq.getView());
        }
        if (this.zzajs.zzaov.getChildCount() > 1) {
            this.zzajs.zzaov.showNext();
        }
        if (zzjyVar != null) {
            View nextView2 = this.zzajs.zzaov.getNextView();
            if (nextView2 instanceof zzll) {
                ((zzll) nextView2).zza(this.zzajs.zzagf, this.zzajs.zzaoy, this.zzajn);
            } else if (nextView2 != 0) {
                this.zzajs.zzaov.removeView(nextView2);
            }
            this.zzajs.zzgo();
        }
        this.zzajs.zzaov.setVisibility(0);
        return true;
    }

    private void zzd(final zzjy zzjyVar) {
        if (!this.zzajs.zzgp()) {
            if (this.zzajs.zzapt == null || zzjyVar.zzcii == null) {
                return;
            }
            this.zzaju.zza(this.zzajs.zzaoy, zzjyVar, this.zzajs.zzapt);
            return;
        }
        if (zzjyVar.zzbtq != null) {
            if (zzjyVar.zzcii != null) {
                this.zzaju.zza(this.zzajs.zzaoy, zzjyVar);
            }
            if (zzjyVar.zzho()) {
                this.zzaju.zza(this.zzajs.zzaoy, zzjyVar).zza(zzjyVar.zzbtq);
            } else {
                zzjyVar.zzbtq.zzuk().zza(new zzlm.zzb() { // from class: com.google.android.gms.ads.internal.zzf.1
                    @Override // com.google.android.gms.internal.zzlm.zzb
                    public void zzen() {
                        zzf.this.zzaju.zza(zzf.this.zzajs.zzaoy, zzjyVar).zza(zzjyVar.zzbtq);
                    }
                });
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        zze(this.zzajs.zzaoz);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        zze(this.zzajs.zzaoz);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void setManualImpressionsEnabled(boolean z) {
        zzab.zzhj("setManualImpressionsEnabled must be called from the main thread.");
        this.zzakp = z;
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.client.zzu
    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzc
    protected zzll zza(zzjy.zza zzaVar, @Nullable zze zzeVar, @Nullable zzjs zzjsVar) {
        if (this.zzajs.zzaoy.zzaut) {
            this.zzajs.zzaoy = zzb(zzaVar);
        }
        zzll zzllVarZza = super.zza(zzaVar, zzeVar, zzjsVar);
        zzes.zzd(zzllVarZza);
        return zzllVarZza;
    }

    @Override // com.google.android.gms.ads.internal.zzb
    protected void zza(@Nullable zzjy zzjyVar, boolean z) {
        super.zza(zzjyVar, z);
        if (zzn.zzg(zzjyVar)) {
            zzn.zza(zzjyVar, new zza());
        }
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(@Nullable zzjy zzjyVar, zzjy zzjyVar2) {
        if (!super.zza(zzjyVar, zzjyVar2)) {
            return false;
        }
        if (this.zzajs.zzgp() && !zzb(zzjyVar, zzjyVar2)) {
            zzh(0);
            return false;
        }
        if (zzjyVar2.zzccu) {
            zze(zzjyVar2);
            zzu.zzgk().zza((View) this.zzajs.zzaov, (ViewTreeObserver.OnGlobalLayoutListener) this);
            zzu.zzgk().zza((View) this.zzajs.zzaov, (ViewTreeObserver.OnScrollChangedListener) this);
        } else if (!this.zzajs.zzgq() || zzdc.zzbcc.get().booleanValue()) {
            zza(zzjyVar2, false);
        }
        zzlq zzlqVarZzuu = null;
        if (zzjyVar2.zzbtq != null) {
            zzlqVarZzuu = zzjyVar2.zzbtq.zzuu();
            zzlm zzlmVarZzuk = zzjyVar2.zzbtq.zzuk();
            if (zzlmVarZzuk != null) {
                zzlmVarZzuk.zzvb();
            }
        }
        if (this.zzajs.zzapn != null && zzlqVarZzuu != null) {
            zzlqVarZzuu.zzam(this.zzajs.zzapn.zzaxk);
        }
        zzd(zzjyVar2);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public boolean zzb(AdRequestParcel adRequestParcel) {
        return super.zzb(zze(adRequestParcel));
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    @Nullable
    public com.google.android.gms.ads.internal.client.zzab zzdr() {
        zzab.zzhj("getVideoController must be called from the main thread.");
        if (this.zzajs.zzaoz == null || this.zzajs.zzaoz.zzbtq == null) {
            return null;
        }
        return this.zzajs.zzaoz.zzbtq.zzuu();
    }

    @Override // com.google.android.gms.ads.internal.zzb
    protected boolean zzdx() {
        boolean z = true;
        if (!zzu.zzfq().zza(this.zzajs.zzagf.getPackageManager(), this.zzajs.zzagf.getPackageName(), "android.permission.INTERNET")) {
            com.google.android.gms.ads.internal.client.zzm.zziw().zza(this.zzajs.zzaov, this.zzajs.zzaoy, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzu.zzfq().zzac(this.zzajs.zzagf)) {
            com.google.android.gms.ads.internal.client.zzm.zziw().zza(this.zzajs.zzaov, this.zzajs.zzaoy, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.zzajs.zzaov != null) {
            this.zzajs.zzaov.setVisibility(0);
        }
        return z;
    }

    AdRequestParcel zze(AdRequestParcel adRequestParcel) {
        if (adRequestParcel.zzatp == this.zzakp) {
            return adRequestParcel;
        }
        return new AdRequestParcel(adRequestParcel.versionCode, adRequestParcel.zzatk, adRequestParcel.extras, adRequestParcel.zzatl, adRequestParcel.zzatm, adRequestParcel.zzatn, adRequestParcel.zzato, adRequestParcel.zzatp || this.zzakp, adRequestParcel.zzatq, adRequestParcel.zzatr, adRequestParcel.zzats, adRequestParcel.zzatt, adRequestParcel.zzatu, adRequestParcel.zzatv, adRequestParcel.zzatw, adRequestParcel.zzatx, adRequestParcel.zzaty, adRequestParcel.zzatz);
    }

    void zze(@Nullable zzjy zzjyVar) {
        if (zzjyVar == null || zzjyVar.zzcij || this.zzajs.zzaov == null || !zzu.zzfq().zza(this.zzajs.zzaov, this.zzajs.zzagf) || !this.zzajs.zzaov.getGlobalVisibleRect(new Rect(), null)) {
            return;
        }
        zza(zzjyVar, false);
        zzjyVar.zzcij = true;
    }
}
