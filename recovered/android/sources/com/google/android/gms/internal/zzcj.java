package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzcj extends zzcd {
    private zzfw.zzc zzaro;
    private boolean zzarp;

    public zzcj(Context context, AdSizeParcel adSizeParcel, zzjy zzjyVar, VersionInfoParcel versionInfoParcel, zzck zzckVar, zzfw zzfwVar) {
        super(context, adSizeParcel, zzjyVar, versionInfoParcel, zzckVar);
        this.zzaro = zzfwVar.zzmc();
        try {
            final JSONObject jSONObjectZzd = zzd(zzckVar.zzhj().zzhh());
            this.zzaro.zza(new zzle.zzc<zzfx>() { // from class: com.google.android.gms.internal.zzcj.1
                @Override // com.google.android.gms.internal.zzle.zzc
                /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
                public void zzd(zzfx zzfxVar) {
                    zzcj.this.zza(jSONObjectZzd);
                }
            }, new zzle.zza() { // from class: com.google.android.gms.internal.zzcj.2
                @Override // com.google.android.gms.internal.zzle.zza
                public void run() {
                }
            });
        } catch (RuntimeException e) {
            zzkh.zzb("Failure while processing active view data.", e);
        } catch (JSONException e2) {
        }
        this.zzaro.zza(new zzle.zzc<zzfx>() { // from class: com.google.android.gms.internal.zzcj.3
            @Override // com.google.android.gms.internal.zzle.zzc
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public void zzd(zzfx zzfxVar) {
                zzcj.this.zzarp = true;
                zzcj.this.zzc(zzfxVar);
                zzcj.this.zzgw();
                zzcj.this.zzk(3);
            }
        }, new zzle.zza() { // from class: com.google.android.gms.internal.zzcj.4
            @Override // com.google.android.gms.internal.zzle.zza
            public void run() {
                zzcj.this.destroy();
            }
        });
        String strValueOf = String.valueOf(this.zzaqi.zzhn());
        zzkh.zzcw(strValueOf.length() != 0 ? "Tracking ad unit: ".concat(strValueOf) : new String("Tracking ad unit: "));
    }

    @Override // com.google.android.gms.internal.zzcd
    protected void destroy() {
        synchronized (this.zzail) {
            super.destroy();
            this.zzaro.zza(new zzle.zzc<zzfx>() { // from class: com.google.android.gms.internal.zzcj.6
                @Override // com.google.android.gms.internal.zzle.zzc
                /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
                public void zzd(zzfx zzfxVar) {
                    zzcj.this.zzd(zzfxVar);
                }
            }, new zzle.zzb());
            this.zzaro.release();
        }
    }

    @Override // com.google.android.gms.internal.zzcd
    protected void zzb(final JSONObject jSONObject) {
        this.zzaro.zza(new zzle.zzc<zzfx>() { // from class: com.google.android.gms.internal.zzcj.5
            @Override // com.google.android.gms.internal.zzle.zzc
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public void zzd(zzfx zzfxVar) {
                zzfxVar.zza("AFMA_updateActiveView", jSONObject);
            }
        }, new zzle.zzb());
    }

    @Override // com.google.android.gms.internal.zzcd
    protected boolean zzhe() {
        return this.zzarp;
    }
}
