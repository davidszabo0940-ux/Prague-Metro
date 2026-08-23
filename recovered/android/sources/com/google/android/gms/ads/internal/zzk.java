package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzk extends com.google.android.gms.ads.internal.client.zzs.zza {
    private final Context mContext;
    private final zzd zzajv;
    private final zzgn zzajz;
    private com.google.android.gms.ads.internal.client.zzq zzald;
    private NativeAdOptionsParcel zzali;
    private zzy zzalk;
    private final String zzall;
    private final VersionInfoParcel zzalm;
    private zzee zzalq;
    private zzef zzalr;
    private SimpleArrayMap<String, zzeh> zzalt = new SimpleArrayMap<>();
    private SimpleArrayMap<String, zzeg> zzals = new SimpleArrayMap<>();

    public zzk(Context context, String str, zzgn zzgnVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        this.mContext = context;
        this.zzall = str;
        this.zzajz = zzgnVar;
        this.zzalm = versionInfoParcel;
        this.zzajv = zzdVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.zzali = nativeAdOptionsParcel;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzee zzeeVar) {
        this.zzalq = zzeeVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzef zzefVar) {
        this.zzalr = zzefVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(String str, zzeh zzehVar, zzeg zzegVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.zzalt.put(str, zzehVar);
        this.zzals.put(str, zzegVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zzb(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        this.zzald = zzqVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zzb(zzy zzyVar) {
        this.zzalk = zzyVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public com.google.android.gms.ads.internal.client.zzr zzes() {
        return new zzj(this.mContext, this.zzall, this.zzajz, this.zzalm, this.zzald, this.zzalq, this.zzalr, this.zzalt, this.zzals, this.zzali, this.zzalk, this.zzajv);
    }
}
