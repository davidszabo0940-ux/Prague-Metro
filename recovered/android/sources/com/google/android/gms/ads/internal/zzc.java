package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzhk;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzll;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzc extends zzb implements zzh, zzhk {
    public zzc(Context context, AdSizeParcel adSizeParcel, String str, zzgn zzgnVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        super(context, adSizeParcel, str, zzgnVar, versionInfoParcel, zzdVar);
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
    protected zzll zza(zzjy.zza zzaVar, @Nullable zze zzeVar, @Nullable zzjs zzjsVar) {
        zzll zzllVarZza = null;
        View nextView = this.zzajs.zzaov.getNextView();
        if (nextView instanceof zzll) {
            zzllVarZza = (zzll) nextView;
            if (zzdc.zzazx.get().booleanValue()) {
                zzkh.zzcw("Reusing webview...");
                zzllVarZza.zza(this.zzajs.zzagf, this.zzajs.zzaoy, this.zzajn);
            } else {
                zzllVarZza.destroy();
                zzllVarZza = null;
            }
        }
        if (zzllVarZza == null) {
            if (nextView != 0) {
                this.zzajs.zzaov.removeView(nextView);
            }
            zzllVarZza = zzu.zzfr().zza(this.zzajs.zzagf, this.zzajs.zzaoy, false, false, this.zzajs.zzaot, this.zzajs.zzaou, this.zzajn, this, this.zzajv);
            if (this.zzajs.zzaoy.zzaur == null) {
                zzb(zzllVarZza.getView());
            }
        }
        zzll zzllVar = zzllVarZza;
        zzllVar.zzuk().zza(this, this, this, this, false, this, null, zzeVar, this, zzjsVar);
        zza(zzllVar);
        zzllVar.zzda(zzaVar.zzcit.zzcbk);
        return zzllVar;
    }

    @Override // com.google.android.gms.internal.zzhk
    public void zza(int i, int i2, int i3, int i4) {
        zzdu();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void zza(zzdo zzdoVar) {
        zzab.zzhj("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzajs.zzapo = zzdoVar;
    }

    protected void zza(zzfx zzfxVar) {
        zzfxVar.zza("/trackActiveViewUnit", new zzet() { // from class: com.google.android.gms.ads.internal.zzc.1
            @Override // com.google.android.gms.internal.zzet
            public void zza(zzll zzllVar, Map<String, String> map) {
                if (zzc.this.zzajs.zzaoz != null) {
                    zzc.this.zzaju.zza(zzc.this.zzajs.zzaoy, zzc.this.zzajs.zzaoz, zzllVar.getView(), zzllVar);
                } else {
                    zzkh.zzcy("Request to enable ActiveView before adState is available.");
                }
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected void zza(final zzjy.zza zzaVar, final zzdk zzdkVar) {
        if (zzaVar.errorCode != -2) {
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzc.2
                @Override // java.lang.Runnable
                public void run() {
                    zzc.this.zzb(new zzjy(zzaVar, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        if (zzaVar.zzaoy != null) {
            this.zzajs.zzaoy = zzaVar.zzaoy;
        }
        if (!zzaVar.zzciu.zzccc || zzaVar.zzciu.zzauu) {
            final zzjs zzjsVarZza = zzdc.zzbdd.get().booleanValue() ? this.zzajv.zzakm.zza(this.zzajs.zzagf, zzaVar.zzciu) : null;
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzc.3
                @Override // java.lang.Runnable
                public void run() {
                    if (zzaVar.zzciu.zzccl && zzc.this.zzajs.zzapo != null) {
                        zzdl zzdlVar = new zzdl(zzc.this, zzaVar.zzciu.zzbts != null ? zzu.zzfq().zzcp(zzaVar.zzciu.zzbts) : null, zzaVar.zzciu.body);
                        zzc.this.zzajs.zzapu = 1;
                        try {
                            zzc.this.zzajq = false;
                            zzc.this.zzajs.zzapo.zza(zzdlVar);
                            return;
                        } catch (RemoteException e) {
                            zzkh.zzd("Could not call the onCustomRenderedAdLoadedListener.", e);
                            zzc.this.zzajq = true;
                        }
                    }
                    final zze zzeVar = new zze(zzc.this.zzajs.zzagf, zzaVar);
                    zzll zzllVarZza = zzc.this.zza(zzaVar, zzeVar, zzjsVarZza);
                    zzllVarZza.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.gms.ads.internal.zzc.3.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            zzeVar.recordClick();
                            return false;
                        }
                    });
                    zzllVarZza.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.ads.internal.zzc.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            zzeVar.recordClick();
                        }
                    });
                    zzc.this.zzajs.zzapu = 0;
                    zzc.this.zzajs.zzaox = zzu.zzfp().zza(zzc.this.zzajs.zzagf, zzc.this, zzaVar, zzc.this.zzajs.zzaot, zzllVarZza, zzc.this.zzajz, zzc.this, zzdkVar);
                }
            });
        } else {
            this.zzajs.zzapu = 0;
            this.zzajs.zzaox = zzu.zzfp().zza(this.zzajs.zzagf, this, zzaVar, this.zzajs.zzaot, null, this.zzajz, this, zzdkVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    protected boolean zza(@Nullable zzjy zzjyVar, zzjy zzjyVar2) {
        if (this.zzajs.zzgp() && this.zzajs.zzaov != null) {
            this.zzajs.zzaov.zzgv().zzct(zzjyVar2.zzcch);
        }
        return super.zza(zzjyVar, zzjyVar2);
    }

    @Override // com.google.android.gms.ads.internal.zzh
    public void zzc(View view) {
        this.zzajs.zzapt = view;
        zzb(new zzjy(this.zzajs.zzapa, null, null, null, null, null, null, null));
    }

    @Override // com.google.android.gms.ads.internal.zzh
    public void zzei() {
        onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzh
    public void zzej() {
        recordImpression();
        zzdq();
    }

    @Override // com.google.android.gms.internal.zzhk
    public void zzek() {
        zzds();
    }
}
