package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzgl implements zzgc {
    private final Context mContext;
    private final zzdk zzajn;
    private final zzgn zzajz;
    private final boolean zzarj;
    private final boolean zzawl;
    private final zzge zzboi;
    private final AdRequestInfoParcel zzbox;
    private final long zzboy;
    private final long zzboz;
    private zzgh zzbph;
    private final Object zzail = new Object();
    private boolean zzbpb = false;
    private List<zzgi> zzbpd = new ArrayList();

    public zzgl(Context context, AdRequestInfoParcel adRequestInfoParcel, zzgn zzgnVar, zzge zzgeVar, boolean z, boolean z2, long j, long j2, zzdk zzdkVar) {
        this.mContext = context;
        this.zzbox = adRequestInfoParcel;
        this.zzajz = zzgnVar;
        this.zzboi = zzgeVar;
        this.zzarj = z;
        this.zzawl = z2;
        this.zzboy = j;
        this.zzboz = j2;
        this.zzajn = zzdkVar;
    }

    @Override // com.google.android.gms.internal.zzgc
    public void cancel() {
        synchronized (this.zzail) {
            this.zzbpb = true;
            if (this.zzbph != null) {
                this.zzbph.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgc
    public zzgi zzd(List<zzgd> list) {
        zzkh.zzcw("Starting mediation.");
        ArrayList arrayList = new ArrayList();
        zzdi zzdiVarZzkg = this.zzajn.zzkg();
        for (zzgd zzgdVar : list) {
            String strValueOf = String.valueOf(zzgdVar.zzbmz);
            zzkh.zzcx(strValueOf.length() != 0 ? "Trying mediation network: ".concat(strValueOf) : new String("Trying mediation network: "));
            for (String str : zzgdVar.zzbna) {
                zzdi zzdiVarZzkg2 = this.zzajn.zzkg();
                synchronized (this.zzail) {
                    if (this.zzbpb) {
                        return new zzgi(-1);
                    }
                    this.zzbph = new zzgh(this.mContext, str, this.zzajz, this.zzboi, zzgdVar, this.zzbox.zzcav, this.zzbox.zzaoy, this.zzbox.zzaou, this.zzarj, this.zzawl, this.zzbox.zzapm, this.zzbox.zzapq);
                    final zzgi zzgiVarZza = this.zzbph.zza(this.zzboy, this.zzboz);
                    this.zzbpd.add(zzgiVarZza);
                    if (zzgiVarZza.zzboq == 0) {
                        zzkh.zzcw("Adapter succeeded.");
                        this.zzajn.zzh("mediation_network_succeed", str);
                        if (!arrayList.isEmpty()) {
                            this.zzajn.zzh("mediation_networks_fail", TextUtils.join(",", arrayList));
                        }
                        this.zzajn.zza(zzdiVarZzkg2, "mls");
                        this.zzajn.zza(zzdiVarZzkg, "ttm");
                        return zzgiVarZza;
                    }
                    arrayList.add(str);
                    this.zzajn.zza(zzdiVarZzkg2, "mlf");
                    if (zzgiVarZza.zzbos != null) {
                        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzgl.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    zzgiVarZza.zzbos.destroy();
                                } catch (RemoteException e) {
                                    zzkh.zzd("Could not destroy mediation adapter.", e);
                                }
                            }
                        });
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzajn.zzh("mediation_networks_fail", TextUtils.join(",", arrayList));
        }
        return new zzgi(1);
    }

    @Override // com.google.android.gms.internal.zzgc
    public List<zzgi> zzmi() {
        return this.zzbpd;
    }
}
