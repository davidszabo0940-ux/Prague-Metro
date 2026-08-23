package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzj extends com.google.android.gms.ads.internal.client.zzr.zza {
    private final Context mContext;
    private final zzd zzajv;
    private final zzgn zzajz;
    private final com.google.android.gms.ads.internal.client.zzq zzald;
    private final zzee zzale;
    private final zzef zzalf;
    private final SimpleArrayMap<String, zzeh> zzalg;
    private final SimpleArrayMap<String, zzeg> zzalh;
    private final NativeAdOptionsParcel zzali;
    private final zzy zzalk;
    private final String zzall;
    private final VersionInfoParcel zzalm;
    private WeakReference<zzq> zzaln;
    private final Object zzail = new Object();
    private final List<String> zzalj = zzeq();

    zzj(Context context, String str, zzgn zzgnVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.client.zzq zzqVar, zzee zzeeVar, zzef zzefVar, SimpleArrayMap<String, zzeh> simpleArrayMap, SimpleArrayMap<String, zzeg> simpleArrayMap2, NativeAdOptionsParcel nativeAdOptionsParcel, zzy zzyVar, zzd zzdVar) {
        this.mContext = context;
        this.zzall = str;
        this.zzajz = zzgnVar;
        this.zzalm = versionInfoParcel;
        this.zzald = zzqVar;
        this.zzalf = zzefVar;
        this.zzale = zzeeVar;
        this.zzalg = simpleArrayMap;
        this.zzalh = simpleArrayMap2;
        this.zzali = nativeAdOptionsParcel;
        this.zzalk = zzyVar;
        this.zzajv = zzdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> zzeq() {
        ArrayList arrayList = new ArrayList();
        if (this.zzalf != null) {
            arrayList.add("1");
        }
        if (this.zzale != null) {
            arrayList.add("2");
        }
        if (this.zzalg.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public String getMediationAdapterClassName() {
        synchronized (this.zzail) {
            if (this.zzaln == null) {
                return null;
            }
            zzq zzqVar = this.zzaln.get();
            return zzqVar != null ? zzqVar.getMediationAdapterClassName() : null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public boolean isLoading() {
        synchronized (this.zzail) {
            if (this.zzaln == null) {
                return false;
            }
            zzq zzqVar = this.zzaln.get();
            return zzqVar != null ? zzqVar.isLoading() : false;
        }
    }

    protected void runOnUiThread(Runnable runnable) {
        zzkl.zzclg.post(runnable);
    }

    protected zzq zzer() {
        return new zzq(this.mContext, this.zzajv, AdSizeParcel.zzk(this.mContext), this.zzall, this.zzajz, this.zzalm);
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void zzf(final AdRequestParcel adRequestParcel) {
        runOnUiThread(new Runnable() { // from class: com.google.android.gms.ads.internal.zzj.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (zzj.this.zzail) {
                    zzq zzqVarZzer = zzj.this.zzer();
                    zzj.this.zzaln = new WeakReference(zzqVarZzer);
                    zzqVarZzer.zzb(zzj.this.zzale);
                    zzqVarZzer.zzb(zzj.this.zzalf);
                    zzqVarZzer.zza(zzj.this.zzalg);
                    zzqVarZzer.zza(zzj.this.zzald);
                    zzqVarZzer.zzb(zzj.this.zzalh);
                    zzqVarZzer.zzb(zzj.this.zzeq());
                    zzqVarZzer.zzb(zzj.this.zzali);
                    zzqVarZzer.zza(zzj.this.zzalk);
                    zzqVarZzer.zzb(adRequestParcel);
                }
            }
        });
    }
}
