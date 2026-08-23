package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzkb implements zzkj.zzb {
    private Context mContext;
    private zzcg zzaju;
    private VersionInfoParcel zzalm;
    private String zzbjj;
    private final String zzcjq;
    private final zzkc zzcjr;
    private String zzcjz;
    private final Object zzail = new Object();
    private BigInteger zzcjs = BigInteger.ONE;
    private final HashSet<zzjz> zzcjt = new HashSet<>();
    private final HashMap<String, zzke> zzcju = new HashMap<>();
    private boolean zzcjv = false;
    private boolean zzcfj = true;
    private int zzcjw = 0;
    private boolean zzamr = false;
    private zzde zzcjx = null;
    private boolean zzcfk = true;
    private zzcn zzasi = null;
    private zzco zzcjy = null;
    private zzcm zzasj = null;
    private Boolean zzcka = null;
    private boolean zzckb = false;
    private boolean zzckc = false;
    private boolean zzcfs = false;
    private boolean zzckd = false;
    private String zzcke = "";
    private long zzckf = 0;

    public zzkb(zzkl zzklVar) {
        this.zzcjq = zzklVar.zztg();
        this.zzcjr = new zzkc(this.zzcjq);
    }

    public Resources getResources() {
        if (this.zzalm.zzcnq) {
            return this.mContext.getResources();
        }
        try {
            zzsj zzsjVarZza = zzsj.zza(this.mContext, zzsj.f839Mg, ModuleDescriptor.MODULE_ID);
            if (zzsjVarZza != null) {
                return zzsjVarZza.zzbcw().getResources();
            }
            return null;
        } catch (zzsj.zza e) {
            zzkh.zzd("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public String getSessionId() {
        return this.zzcjq;
    }

    public Bundle zza(Context context, zzkd zzkdVar, String str) {
        Bundle bundle;
        synchronized (this.zzail) {
            bundle = new Bundle();
            bundle.putBundle("app", this.zzcjr.zzf(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.zzcju.keySet()) {
                bundle2.putBundle(str2, this.zzcju.get(str2).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzjz> it = this.zzcjt.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzkdVar.zza(this.zzcjt);
            this.zzcjt.clear();
        }
        return bundle;
    }

    public void zza(zzjz zzjzVar) {
        synchronized (this.zzail) {
            this.zzcjt.add(zzjzVar);
        }
    }

    public void zza(String str, zzke zzkeVar) {
        synchronized (this.zzail) {
            this.zzcju.put(str, zzkeVar);
        }
    }

    public void zza(Thread thread) {
        zziq.zza(this.mContext, thread, this.zzalm);
    }

    public zzco zzaa(Context context) {
        if (!zzdc.zzazf.get().booleanValue() || !com.google.android.gms.common.util.zzs.zzavm() || zzsj()) {
            return null;
        }
        synchronized (this.zzail) {
            if (Looper.getMainLooper() == null || context == null) {
                return null;
            }
            if (this.zzasi == null) {
                Application application = (Application) context.getApplicationContext();
                if (application == null) {
                    application = (Application) context;
                }
                this.zzasi = new zzcn(application, context);
            }
            if (this.zzasj == null) {
                this.zzasj = new zzcm();
            }
            if (this.zzcjy == null) {
                this.zzcjy = new zzco(this.zzasi, this.zzasj, new zziq(this.mContext, this.zzalm, null, null));
            }
            this.zzcjy.zzhz();
            return this.zzcjy;
        }
    }

    public void zzae(boolean z) {
        synchronized (this.zzail) {
            if (this.zzcfk != z) {
                zzkj.zze(this.mContext, z);
            }
            this.zzcfk = z;
            zzco zzcoVarZzaa = zzaa(this.mContext);
            if (zzcoVarZzaa != null && !zzcoVarZzaa.isAlive()) {
                zzkh.zzcx("start fetching content...");
                zzcoVarZzaa.zzhz();
            }
        }
    }

    public void zzaf(boolean z) {
        this.zzckd = z;
    }

    public void zzag(boolean z) {
        synchronized (this.zzail) {
            this.zzckb = z;
        }
    }

    @TargetApi(23)
    public void zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (this.zzail) {
            if (!this.zzamr) {
                this.mContext = context.getApplicationContext();
                this.zzalm = versionInfoParcel;
                zzkj.zza(context, this);
                zzkj.zzb(context, this);
                zzkj.zzc(context, this);
                zzkj.zzd(context, this);
                zzkj.zze(context, this);
                zzkj.zzf(context, this);
                zza(Thread.currentThread());
                this.zzbjj = com.google.android.gms.ads.internal.zzu.zzfq().zzh(context, versionInfoParcel.zzcs);
                if (com.google.android.gms.common.util.zzs.zzavt() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.zzckc = true;
                }
                this.zzaju = new zzcg(context.getApplicationContext(), this.zzalm, com.google.android.gms.ads.internal.zzu.zzfq().zzc(context, versionInfoParcel));
                zzsx();
                com.google.android.gms.ads.internal.zzu.zzga().zzt(this.mContext);
                this.zzamr = true;
            }
        }
    }

    public void zzb(Boolean bool) {
        synchronized (this.zzail) {
            this.zzcka = bool;
        }
    }

    public void zzb(Throwable th, boolean z) {
        new zziq(this.mContext, this.zzalm, null, null).zza(th, z);
    }

    public void zzb(HashSet<zzjz> hashSet) {
        synchronized (this.zzail) {
            this.zzcjt.addAll(hashSet);
        }
    }

    public Future zzc(Context context, boolean z) {
        Future futureZzc;
        synchronized (this.zzail) {
            if (z != this.zzcfj) {
                this.zzcfj = z;
                futureZzc = zzkj.zzc(context, z);
            } else {
                futureZzc = null;
            }
        }
        return futureZzc;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    public Future zzcn(String str) {
        Future futureZzg;
        synchronized (this.zzail) {
            if (str == null) {
                futureZzg = null;
            } else if (str.equals(this.zzcjz)) {
                futureZzg = null;
            } else {
                this.zzcjz = str;
                futureZzg = zzkj.zzg(this.mContext, str);
            }
            throw th;
        }
        return futureZzg;
    }

    public Future zzd(Context context, boolean z) {
        Future futureZzf;
        synchronized (this.zzail) {
            if (z != this.zzcfs) {
                this.zzcfs = z;
                futureZzf = zzkj.zzf(context, z);
            } else {
                futureZzf = null;
            }
        }
        return futureZzf;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    public Future zze(Context context, String str) {
        Future futureZza;
        this.zzckf = com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis();
        synchronized (this.zzail) {
            if (str == null) {
                futureZza = null;
            } else if (str.equals(this.zzcke)) {
                futureZza = null;
            } else {
                this.zzcke = str;
                futureZza = zzkj.zza(context, str, this.zzckf);
            }
            throw th;
        }
        return futureZza;
    }

    @Override // com.google.android.gms.internal.zzkj.zzb
    public void zzg(Bundle bundle) {
        synchronized (this.zzail) {
            this.zzcfj = bundle.containsKey("use_https") ? bundle.getBoolean("use_https") : this.zzcfj;
            this.zzcjw = bundle.containsKey("webview_cache_version") ? bundle.getInt("webview_cache_version") : this.zzcjw;
            if (bundle.containsKey("content_url_opted_out")) {
                zzae(bundle.getBoolean("content_url_opted_out"));
            }
            if (bundle.containsKey("content_url_hashes")) {
                this.zzcjz = bundle.getString("content_url_hashes");
            }
            this.zzcfs = bundle.containsKey("auto_collect_location") ? bundle.getBoolean("auto_collect_location") : this.zzcfs;
            this.zzcke = bundle.containsKey("app_settings_json") ? bundle.getString("app_settings_json") : this.zzcke;
            this.zzckf = bundle.containsKey("app_settings_last_update_ms") ? bundle.getLong("app_settings_last_update_ms") : 0L;
        }
    }

    public boolean zzsj() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzcfk;
        }
        return z;
    }

    public String zzsk() {
        String string;
        synchronized (this.zzail) {
            string = this.zzcjs.toString();
            this.zzcjs = this.zzcjs.add(BigInteger.ONE);
        }
        return string;
    }

    public zzkc zzsl() {
        zzkc zzkcVar;
        synchronized (this.zzail) {
            zzkcVar = this.zzcjr;
        }
        return zzkcVar;
    }

    public zzde zzsm() {
        zzde zzdeVar;
        synchronized (this.zzail) {
            zzdeVar = this.zzcjx;
        }
        return zzdeVar;
    }

    public boolean zzsn() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzcjv;
            this.zzcjv = true;
        }
        return z;
    }

    public boolean zzso() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzcfj || this.zzckc;
        }
        return z;
    }

    public String zzsp() {
        String str;
        synchronized (this.zzail) {
            str = this.zzbjj;
        }
        return str;
    }

    public String zzsq() {
        String str;
        synchronized (this.zzail) {
            str = this.zzcjz;
        }
        return str;
    }

    public Boolean zzsr() {
        Boolean bool;
        synchronized (this.zzail) {
            bool = this.zzcka;
        }
        return bool;
    }

    public boolean zzss() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzcfs;
        }
        return z;
    }

    public boolean zzst() {
        return this.zzckd;
    }

    public zzka zzsu() {
        zzka zzkaVar;
        synchronized (this.zzail) {
            zzkaVar = new zzka(this.zzcke, this.zzckf);
        }
        return zzkaVar;
    }

    public zzcg zzsv() {
        return this.zzaju;
    }

    public boolean zzsw() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzckb;
        }
        return z;
    }

    void zzsx() {
        try {
            this.zzcjx = com.google.android.gms.ads.internal.zzu.zzfv().zza(new zzdd(this.mContext, this.zzalm.zzcs));
        } catch (IllegalArgumentException e) {
            zzkh.zzd("Cannot initialize CSI reporter.", e);
        }
    }
}
