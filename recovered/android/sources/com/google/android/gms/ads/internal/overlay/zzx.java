package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkq;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzx {
    private final Context mContext;
    private final VersionInfoParcel zzamu;
    private final String zzbvu;

    @Nullable
    private final zzdi zzbvv;

    @Nullable
    private final zzdk zzbvw;
    private final long[] zzbvy;
    private final String[] zzbvz;

    @Nullable
    private zzdi zzbwa;

    @Nullable
    private zzdi zzbwb;

    @Nullable
    private zzdi zzbwc;

    @Nullable
    private zzdi zzbwd;
    private boolean zzbwe;
    private zzi zzbwf;
    private boolean zzbwg;
    private boolean zzbwh;
    private final zzkq zzbvx = new zzkq.zzb().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zztp();
    private long zzbwi = -1;

    public zzx(Context context, VersionInfoParcel versionInfoParcel, String str, @Nullable zzdk zzdkVar, @Nullable zzdi zzdiVar) {
        this.mContext = context;
        this.zzamu = versionInfoParcel;
        this.zzbvu = str;
        this.zzbvw = zzdkVar;
        this.zzbvv = zzdiVar;
        String str2 = zzdc.zzayr.get();
        if (str2 == null) {
            this.zzbvz = new String[0];
            this.zzbvy = new long[0];
            return;
        }
        String[] strArrSplit = TextUtils.split(str2, ",");
        this.zzbvz = new String[strArrSplit.length];
        this.zzbvy = new long[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                this.zzbvy[i] = Long.parseLong(strArrSplit[i]);
            } catch (NumberFormatException e) {
                zzkh.zzd("Unable to parse frame hash target time number.", e);
                this.zzbvy[i] = -1;
            }
        }
    }

    private void zzc(zzi zziVar) {
        long jLongValue = zzdc.zzays.get().longValue();
        long currentPosition = zziVar.getCurrentPosition();
        for (int i = 0; i < this.zzbvz.length; i++) {
            if (this.zzbvz[i] == null && jLongValue > Math.abs(currentPosition - this.zzbvy[i])) {
                this.zzbvz[i] = zza((TextureView) zziVar);
                return;
            }
        }
    }

    private void zzpj() {
        if (this.zzbwc != null && this.zzbwd == null) {
            zzdg.zza(this.zzbvw, this.zzbwc, "vff");
            zzdg.zza(this.zzbvw, this.zzbvv, "vtt");
            this.zzbwd = zzdg.zzb(this.zzbvw);
        }
        long jNanoTime = com.google.android.gms.ads.internal.zzu.zzfu().nanoTime();
        if (this.zzbwe && this.zzbwh && this.zzbwi != -1) {
            this.zzbvx.zza(TimeUnit.SECONDS.toNanos(1L) / (jNanoTime - this.zzbwi));
        }
        this.zzbwh = this.zzbwe;
        this.zzbwi = jNanoTime;
    }

    public void onStop() {
        if (!zzdc.zzayq.get().booleanValue() || this.zzbwg) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString("request", this.zzbvu);
        bundle.putString("player", this.zzbwf.zznk());
        for (zzkq.zza zzaVar : this.zzbvx.getBuckets()) {
            String strValueOf = String.valueOf("fps_c_");
            String strValueOf2 = String.valueOf(zzaVar.name);
            bundle.putString(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf), Integer.toString(zzaVar.count));
            String strValueOf3 = String.valueOf("fps_p_");
            String strValueOf4 = String.valueOf(zzaVar.name);
            bundle.putString(strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3), Double.toString(zzaVar.zzcmc));
        }
        for (int i = 0; i < this.zzbvy.length; i++) {
            String str = this.zzbvz[i];
            if (str != null) {
                String strValueOf5 = String.valueOf("fh_");
                String strValueOf6 = String.valueOf(Long.valueOf(this.zzbvy[i]));
                bundle.putString(new StringBuilder(String.valueOf(strValueOf5).length() + 0 + String.valueOf(strValueOf6).length()).append(strValueOf5).append(strValueOf6).toString(), str);
            }
        }
        com.google.android.gms.ads.internal.zzu.zzfq().zza(this.mContext, this.zzamu.zzcs, "gmob-apps", bundle, true);
        this.zzbwg = true;
    }

    String zza(TextureView textureView) {
        long j;
        Bitmap bitmap = textureView.getBitmap(8, 8);
        long j2 = 0;
        long j3 = 63;
        int i = 0;
        while (i < 8) {
            int i2 = 0;
            long j4 = j2;
            while (true) {
                j = j3;
                int i3 = i2;
                if (i3 < 8) {
                    int pixel = bitmap.getPixel(i3, i);
                    j4 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > 128 ? 1L : 0L) << ((int) j);
                    i2 = i3 + 1;
                    j3 = j - 1;
                }
            }
            i++;
            j3 = j;
            j2 = j4;
        }
        return String.format("%016X", Long.valueOf(j2));
    }

    public void zza(zzi zziVar) {
        zzdg.zza(this.zzbvw, this.zzbvv, "vpc");
        this.zzbwa = zzdg.zzb(this.zzbvw);
        if (this.zzbvw != null) {
            this.zzbvw.zzh("vpn", zziVar.zznk());
        }
        this.zzbwf = zziVar;
    }

    public void zzb(zzi zziVar) {
        zzpj();
        zzc(zziVar);
    }

    public void zzol() {
        if (this.zzbwa == null || this.zzbwb != null) {
            return;
        }
        zzdg.zza(this.zzbvw, this.zzbwa, "vfr");
        this.zzbwb = zzdg.zzb(this.zzbvw);
    }

    public void zzpk() {
        this.zzbwe = true;
        if (this.zzbwb == null || this.zzbwc != null) {
            return;
        }
        zzdg.zza(this.zzbvw, this.zzbwb, "vfp");
        this.zzbwc = zzdg.zzb(this.zzbvw);
    }

    public void zzpl() {
        this.zzbwe = false;
    }
}
