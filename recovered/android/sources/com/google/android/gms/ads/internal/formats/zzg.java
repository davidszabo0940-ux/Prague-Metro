package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzg extends zzi {
    private Object zzail;
    private zzgr zzbfz;
    private zzgs zzbga;
    private final zzq zzbgb;
    private zzh zzbgc;
    private boolean zzbgd;

    private zzg(Context context, zzq zzqVar, zzas zzasVar) {
        super(context, zzqVar, null, zzasVar, null, null, null, null);
        this.zzbgd = false;
        this.zzail = new Object();
        this.zzbgb = zzqVar;
    }

    public zzg(Context context, zzq zzqVar, zzas zzasVar, zzgr zzgrVar) {
        this(context, zzqVar, zzasVar);
        this.zzbfz = zzgrVar;
    }

    public zzg(Context context, zzq zzqVar, zzas zzasVar, zzgs zzgsVar) {
        this(context, zzqVar, zzasVar);
        this.zzbga = zzgsVar;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzi, com.google.android.gms.ads.internal.formats.zzh
    public void recordImpression() {
        zzab.zzhj("recordImpression must be called on the main UI thread.");
        synchronized (this.zzail) {
            zzq(true);
            if (this.zzbgc != null) {
                this.zzbgc.recordImpression();
                this.zzbgb.recordImpression();
            } else {
                try {
                    if (this.zzbfz != null && !this.zzbfz.getOverrideImpressionRecording()) {
                        this.zzbfz.recordImpression();
                        this.zzbgb.recordImpression();
                    } else if (this.zzbga != null && !this.zzbga.getOverrideImpressionRecording()) {
                        this.zzbga.recordImpression();
                        this.zzbgb.recordImpression();
                    }
                } catch (RemoteException e) {
                    zzkh.zzd("Failed to call recordImpression", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzi
    public zzb zza(View.OnClickListener onClickListener) {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzi
    public void zza(View view, Map<String, WeakReference<View>> map, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        synchronized (this.zzail) {
            this.zzbgd = true;
            try {
                if (this.zzbfz != null) {
                    this.zzbfz.zzl(com.google.android.gms.dynamic.zze.zzae(view));
                } else if (this.zzbga != null) {
                    this.zzbga.zzl(com.google.android.gms.dynamic.zze.zzae(view));
                }
            } catch (RemoteException e) {
                zzkh.zzd("Failed to call prepareAd", e);
            }
            this.zzbgd = false;
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzi, com.google.android.gms.ads.internal.formats.zzh
    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzab.zzhj("performClick must be called on the main UI thread.");
        synchronized (this.zzail) {
            if (this.zzbgc != null) {
                this.zzbgc.zza(view, map, jSONObject, jSONObject2, jSONObject3);
                this.zzbgb.onAdClicked();
            } else {
                try {
                    if (this.zzbfz != null && !this.zzbfz.getOverrideClickHandling()) {
                        this.zzbfz.zzk(com.google.android.gms.dynamic.zze.zzae(view));
                        this.zzbgb.onAdClicked();
                    }
                    if (this.zzbga != null && !this.zzbga.getOverrideClickHandling()) {
                        this.zzbga.zzk(com.google.android.gms.dynamic.zze.zzae(view));
                        this.zzbgb.onAdClicked();
                    }
                } catch (RemoteException e) {
                    zzkh.zzd("Failed to call performClick", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzi, com.google.android.gms.ads.internal.formats.zzh
    public void zzb(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.zzail) {
            try {
                if (this.zzbfz != null) {
                    this.zzbfz.zzm(com.google.android.gms.dynamic.zze.zzae(view));
                } else if (this.zzbga != null) {
                    this.zzbga.zzm(com.google.android.gms.dynamic.zze.zzae(view));
                }
            } catch (RemoteException e) {
                zzkh.zzd("Failed to call untrackView", e);
            }
        }
    }

    public void zzc(zzh zzhVar) {
        synchronized (this.zzail) {
            this.zzbgc = zzhVar;
        }
    }

    public boolean zzlb() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzbgd;
        }
        return z;
    }

    public zzh zzlc() {
        zzh zzhVar;
        synchronized (this.zzail) {
            zzhVar = this.zzbgc;
        }
        return zzhVar;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzi
    public zzll zzld() {
        return null;
    }
}
