package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzci extends zzcd {
    private final zzfx zzarn;

    public zzci(Context context, AdSizeParcel adSizeParcel, zzjy zzjyVar, VersionInfoParcel versionInfoParcel, zzck zzckVar, zzfx zzfxVar) {
        super(context, adSizeParcel, zzjyVar, versionInfoParcel, zzckVar);
        this.zzarn = zzfxVar;
        zzc(this.zzarn);
        zzgw();
        zzk(3);
        String strValueOf = String.valueOf(this.zzaqi.zzhn());
        zzkh.zzcw(strValueOf.length() != 0 ? "Tracking ad unit: ".concat(strValueOf) : new String("Tracking ad unit: "));
    }

    @Override // com.google.android.gms.internal.zzcd
    protected void destroy() {
        synchronized (this.zzail) {
            super.destroy();
            zzd(this.zzarn);
        }
    }

    @Override // com.google.android.gms.internal.zzcd
    protected void zzb(JSONObject jSONObject) {
        this.zzarn.zza("AFMA_updateActiveView", jSONObject);
    }

    @Override // com.google.android.gms.internal.zzcd
    public void zzgy() {
        destroy();
    }

    @Override // com.google.android.gms.internal.zzcd
    protected boolean zzhe() {
        return true;
    }
}
