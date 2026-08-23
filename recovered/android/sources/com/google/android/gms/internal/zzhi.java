package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzhi extends zzhj implements zzet {
    private final Context mContext;
    private final WindowManager zzaqk;
    private final zzll zzbgj;
    private final zzcu zzbrg;
    DisplayMetrics zzbrh;
    private float zzbri;
    int zzbrj;
    int zzbrk;
    private int zzbrl;
    int zzbrm;
    int zzbrn;
    int zzbro;
    int zzbrp;

    public zzhi(zzll zzllVar, Context context, zzcu zzcuVar) {
        super(zzllVar);
        this.zzbrj = -1;
        this.zzbrk = -1;
        this.zzbrm = -1;
        this.zzbrn = -1;
        this.zzbro = -1;
        this.zzbrp = -1;
        this.zzbgj = zzllVar;
        this.mContext = context;
        this.zzbrg = zzcuVar;
        this.zzaqk = (WindowManager) context.getSystemService("window");
    }

    private void zznb() {
        this.zzbrh = new DisplayMetrics();
        Display defaultDisplay = this.zzaqk.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzbrh);
        this.zzbri = this.zzbrh.density;
        this.zzbrl = defaultDisplay.getRotation();
    }

    private void zzng() {
        int[] iArr = new int[2];
        this.zzbgj.getLocationOnScreen(iArr);
        zze(com.google.android.gms.ads.internal.client.zzm.zziw().zzb(this.mContext, iArr[0]), com.google.android.gms.ads.internal.client.zzm.zziw().zzb(this.mContext, iArr[1]));
    }

    private zzhh zznj() {
        return new zzhh.zza().zzu(this.zzbrg.zzjp()).zzt(this.zzbrg.zzjq()).zzv(this.zzbrg.zzju()).zzw(this.zzbrg.zzjr()).zzx(this.zzbrg.zzjs()).zzna();
    }

    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        zzne();
    }

    public void zze(int i, int i2) {
        zzc(i, i2 - (this.mContext instanceof Activity ? com.google.android.gms.ads.internal.zzu.zzfq().zzk((Activity) this.mContext)[0] : 0), this.zzbro, this.zzbrp);
        this.zzbgj.zzuk().zzd(i, i2);
    }

    void zznc() {
        this.zzbrj = com.google.android.gms.ads.internal.client.zzm.zziw().zzb(this.zzbrh, this.zzbrh.widthPixels);
        this.zzbrk = com.google.android.gms.ads.internal.client.zzm.zziw().zzb(this.zzbrh, this.zzbrh.heightPixels);
        Activity activityZzuf = this.zzbgj.zzuf();
        if (activityZzuf == null || activityZzuf.getWindow() == null) {
            this.zzbrm = this.zzbrj;
            this.zzbrn = this.zzbrk;
        } else {
            int[] iArrZzh = com.google.android.gms.ads.internal.zzu.zzfq().zzh(activityZzuf);
            this.zzbrm = com.google.android.gms.ads.internal.client.zzm.zziw().zzb(this.zzbrh, iArrZzh[0]);
            this.zzbrn = com.google.android.gms.ads.internal.client.zzm.zziw().zzb(this.zzbrh, iArrZzh[1]);
        }
    }

    void zznd() {
        if (this.zzbgj.zzdo().zzauq) {
            this.zzbro = this.zzbrj;
            this.zzbrp = this.zzbrk;
        } else {
            this.zzbgj.measure(0, 0);
            this.zzbro = com.google.android.gms.ads.internal.client.zzm.zziw().zzb(this.mContext, this.zzbgj.getMeasuredWidth());
            this.zzbrp = com.google.android.gms.ads.internal.client.zzm.zziw().zzb(this.mContext, this.zzbgj.getMeasuredHeight());
        }
    }

    public void zzne() {
        zznb();
        zznc();
        zznd();
        zznh();
        zzni();
        zzng();
        zznf();
    }

    void zznf() {
        if (zzkh.zzaz(2)) {
            zzkh.zzcx("Dispatching Ready Event.");
        }
        zzbv(this.zzbgj.zzun().zzcs);
    }

    void zznh() {
        zza(this.zzbrj, this.zzbrk, this.zzbrm, this.zzbrn, this.zzbri, this.zzbrl);
    }

    void zzni() {
        this.zzbgj.zzb("onDeviceFeaturesReceived", zznj().toJson());
    }
}
