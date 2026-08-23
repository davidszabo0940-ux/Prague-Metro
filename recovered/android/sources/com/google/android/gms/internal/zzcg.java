package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzcg implements zzch {
    private final VersionInfoParcel zzalm;
    private final Context zzaqj;
    private final zzfw zzarm;
    private final Object zzail = new Object();
    private final WeakHashMap<zzjy, zzcd> zzark = new WeakHashMap<>();
    private final ArrayList<zzcd> zzarl = new ArrayList<>();

    public zzcg(Context context, VersionInfoParcel versionInfoParcel, zzfw zzfwVar) {
        this.zzaqj = context.getApplicationContext();
        this.zzalm = versionInfoParcel;
        this.zzarm = zzfwVar;
    }

    public zzcd zza(AdSizeParcel adSizeParcel, zzjy zzjyVar) {
        return zza(adSizeParcel, zzjyVar, zzjyVar.zzbtq.getView());
    }

    public zzcd zza(AdSizeParcel adSizeParcel, zzjy zzjyVar, View view) {
        return zza(adSizeParcel, zzjyVar, new zzcd.zzd(view, zzjyVar), (zzfx) null);
    }

    public zzcd zza(AdSizeParcel adSizeParcel, zzjy zzjyVar, View view, zzfx zzfxVar) {
        return zza(adSizeParcel, zzjyVar, new zzcd.zzd(view, zzjyVar), zzfxVar);
    }

    public zzcd zza(AdSizeParcel adSizeParcel, zzjy zzjyVar, com.google.android.gms.ads.internal.formats.zzh zzhVar) {
        return zza(adSizeParcel, zzjyVar, new zzcd.zza(zzhVar), (zzfx) null);
    }

    public zzcd zza(AdSizeParcel adSizeParcel, zzjy zzjyVar, zzck zzckVar, zzfx zzfxVar) {
        zzcd zzciVar;
        synchronized (this.zzail) {
            if (zzh(zzjyVar)) {
                zzciVar = this.zzark.get(zzjyVar);
            } else {
                zzciVar = zzfxVar != null ? new zzci(this.zzaqj, adSizeParcel, zzjyVar, this.zzalm, zzckVar, zzfxVar) : new zzcj(this.zzaqj, adSizeParcel, zzjyVar, this.zzalm, zzckVar, this.zzarm);
                zzciVar.zza(this);
                this.zzark.put(zzjyVar, zzciVar);
                this.zzarl.add(zzciVar);
            }
        }
        return zzciVar;
    }

    @Override // com.google.android.gms.internal.zzch
    public void zza(zzcd zzcdVar) {
        synchronized (this.zzail) {
            if (!zzcdVar.zzha()) {
                this.zzarl.remove(zzcdVar);
                Iterator<Map.Entry<zzjy, zzcd>> it = this.zzark.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue() == zzcdVar) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean zzh(zzjy zzjyVar) {
        boolean z;
        synchronized (this.zzail) {
            zzcd zzcdVar = this.zzark.get(zzjyVar);
            z = zzcdVar != null && zzcdVar.zzha();
        }
        return z;
    }

    public void zzi(zzjy zzjyVar) {
        synchronized (this.zzail) {
            zzcd zzcdVar = this.zzark.get(zzjyVar);
            if (zzcdVar != null) {
                zzcdVar.zzgy();
            }
        }
    }

    public void zzj(zzjy zzjyVar) {
        synchronized (this.zzail) {
            zzcd zzcdVar = this.zzark.get(zzjyVar);
            if (zzcdVar != null) {
                zzcdVar.stop();
            }
        }
    }

    public void zzk(zzjy zzjyVar) {
        synchronized (this.zzail) {
            zzcd zzcdVar = this.zzark.get(zzjyVar);
            if (zzcdVar != null) {
                zzcdVar.pause();
            }
        }
    }

    public void zzl(zzjy zzjyVar) {
        synchronized (this.zzail) {
            zzcd zzcdVar = this.zzark.get(zzjyVar);
            if (zzcdVar != null) {
                zzcdVar.resume();
            }
        }
    }
}
