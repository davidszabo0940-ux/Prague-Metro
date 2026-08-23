package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzjp extends zzkg implements zzjo {
    private final Context mContext;
    private final zzjy.zza zzbxv;
    private final zzjj zzcid;
    private final ArrayList<Future> zzcia = new ArrayList<>();
    private final ArrayList<String> zzcib = new ArrayList<>();
    private final HashSet<String> zzcic = new HashSet<>();
    private final Object zzail = new Object();

    public zzjp(Context context, zzjy.zza zzaVar, zzjj zzjjVar) {
        this.mContext = context;
        this.zzbxv = zzaVar;
        this.zzcid = zzjjVar;
    }

    private zzjy zza(int i, @Nullable String str, @Nullable zzgd zzgdVar) {
        return new zzjy(this.zzbxv.zzcit.zzcav, null, this.zzbxv.zzciu.zzbnq, i, this.zzbxv.zzciu.zzbnr, this.zzbxv.zzciu.zzcce, this.zzbxv.zzciu.orientation, this.zzbxv.zzciu.zzbnw, this.zzbxv.zzcit.zzcay, this.zzbxv.zzciu.zzccc, zzgdVar, null, str, this.zzbxv.zzcik, null, this.zzbxv.zzciu.zzccd, this.zzbxv.zzaoy, this.zzbxv.zzciu.zzccb, this.zzbxv.zzcio, this.zzbxv.zzciu.zzccg, this.zzbxv.zzciu.zzcch, this.zzbxv.zzcii, null, this.zzbxv.zzciu.zzccr, this.zzbxv.zzciu.zzccs, this.zzbxv.zzciu.zzcct, this.zzbxv.zzciu.zzccu, this.zzbxv.zzciu.zzccv, null, this.zzbxv.zzciu.zzbnt);
    }

    private zzjy zza(String str, zzgd zzgdVar) {
        return zza(-2, str, zzgdVar);
    }

    private void zzd(String str, String str2, String str3) {
        synchronized (this.zzail) {
            zzjq zzjqVarZzcg = this.zzcid.zzcg(str);
            if (zzjqVarZzcg == null || zzjqVarZzcg.zzrw() == null || zzjqVarZzcg.zzrv() == null) {
                return;
            }
            this.zzcia.add((Future) zza(str, str2, str3, zzjqVarZzcg).zzpz());
            this.zzcib.add(str);
        }
    }

    private zzjy zzru() {
        return zza(3, null, null);
    }

    @Override // com.google.android.gms.internal.zzkg
    public void onStop() {
    }

    protected zzjk zza(String str, String str2, String str3, zzjq zzjqVar) {
        return new zzjk(this.mContext, str, str2, str3, this.zzbxv, zzjqVar, this);
    }

    @Override // com.google.android.gms.internal.zzjo
    public void zza(String str, int i) {
    }

    @Override // com.google.android.gms.internal.zzjo
    public void zzch(String str) {
        synchronized (this.zzail) {
            this.zzcic.add(str);
        }
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zzew() {
        for (zzgd zzgdVar : this.zzbxv.zzcik.zzbno) {
            String str = zzgdVar.zzbng;
            for (String string : zzgdVar.zzbna) {
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(string)) {
                    try {
                        string = new JSONObject(str).getString("class_name");
                    } catch (JSONException e) {
                        zzkh.zzb("Unable to determine custom event class name, skipping...", e);
                    }
                }
                zzd(string, str, zzgdVar.zzbmy);
            }
        }
        for (int i = 0; i < this.zzcia.size(); i++) {
            try {
                this.zzcia.get(i).get();
                synchronized (this.zzail) {
                    if (this.zzcic.contains(this.zzcib.get(i))) {
                        final zzjy zzjyVarZza = zza(this.zzcib.get(i), this.zzbxv.zzcik.zzbno.get(i));
                        com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzjp.1
                            @Override // java.lang.Runnable
                            public void run() {
                                zzjp.this.zzcid.zzb(zzjyVarZza);
                            }
                        });
                        return;
                    }
                }
            } catch (InterruptedException e2) {
            } catch (Exception e3) {
            }
        }
        final zzjy zzjyVarZzru = zzru();
        com.google.android.gms.ads.internal.util.client.zza.zzcnf.post(new Runnable() { // from class: com.google.android.gms.internal.zzjp.2
            @Override // java.lang.Runnable
            public void run() {
                zzjp.this.zzcid.zzb(zzjyVarZzru);
            }
        });
    }
}
