package com.google.android.gms.ads.internal;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzkv;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzll;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzv implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    public final Context zzagf;
    boolean zzamc;
    final String zzaor;
    public String zzaos;
    final zzas zzaot;
    public final VersionInfoParcel zzaou;
    zza zzaov;

    @Nullable
    public zzkg zzaow;

    @Nullable
    public zzkn zzaox;
    public AdSizeParcel zzaoy;
    public zzjy zzaoz;
    public zzjy.zza zzapa;
    public zzjz zzapb;
    com.google.android.gms.ads.internal.client.zzp zzapc;
    com.google.android.gms.ads.internal.client.zzq zzapd;
    zzw zzape;
    zzy zzapf;
    zzhs zzapg;
    zzhw zzaph;
    zzee zzapi;
    zzef zzapj;
    SimpleArrayMap<String, zzeg> zzapk;
    SimpleArrayMap<String, zzeh> zzapl;
    NativeAdOptionsParcel zzapm;

    @Nullable
    VideoOptionsParcel zzapn;

    @Nullable
    zzdo zzapo;

    @Nullable
    com.google.android.gms.ads.internal.reward.client.zzd zzapp;
    List<String> zzapq;
    com.google.android.gms.ads.internal.purchase.zzk zzapr;
    public zzke zzaps;
    View zzapt;
    public int zzapu;
    boolean zzapv;
    private HashSet<zzjz> zzapw;
    private int zzapx;
    private int zzapy;
    private zzkv zzapz;
    private boolean zzaqa;
    private boolean zzaqb;
    private boolean zzaqc;

    public static class zza extends ViewSwitcher {
        private final zzko zzaqd;
        private final zzky zzaqe;

        public zza(Context context, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
            super(context);
            this.zzaqd = new zzko(context);
            if (context instanceof Activity) {
                this.zzaqe = new zzky((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
            } else {
                this.zzaqe = new zzky(null, this, onGlobalLayoutListener, onScrollChangedListener);
            }
            this.zzaqe.zztt();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.zzaqe != null) {
                this.zzaqe.onAttachedToWindow();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.zzaqe != null) {
                this.zzaqe.onDetachedFromWindow();
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.zzaqd.zze(motionEvent);
            return false;
        }

        @Override // android.widget.ViewAnimator, android.view.ViewGroup
        public void removeAllViews() {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= getChildCount()) {
                    break;
                }
                KeyEvent.Callback childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof zzll)) {
                    arrayList.add((zzll) childAt);
                }
                i = i2 + 1;
            }
            super.removeAllViews();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((zzll) it.next()).destroy();
            }
        }

        public void zzgr() {
            zzkh.m95v("Disable position monitoring on adFrame.");
            if (this.zzaqe != null) {
                this.zzaqe.zztu();
            }
        }

        public zzko zzgv() {
            return this.zzaqd;
        }
    }

    public zzv(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this(context, adSizeParcel, str, versionInfoParcel, null);
    }

    zzv(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel, zzas zzasVar) {
        this.zzaps = null;
        this.zzapt = null;
        this.zzapu = 0;
        this.zzapv = false;
        this.zzamc = false;
        this.zzapw = null;
        this.zzapx = -1;
        this.zzapy = -1;
        this.zzaqa = true;
        this.zzaqb = true;
        this.zzaqc = false;
        zzdc.initialize(context);
        if (zzu.zzft().zzsm() != null) {
            List<String> listZzjy = zzdc.zzjy();
            if (versionInfoParcel.zzcno != 0) {
                listZzjy.add(Integer.toString(versionInfoParcel.zzcno));
            }
            zzu.zzft().zzsm().zzc(listZzjy);
        }
        this.zzaor = UUID.randomUUID().toString();
        if (adSizeParcel.zzauq || adSizeParcel.zzaus) {
            this.zzaov = null;
        } else {
            this.zzaov = new zza(context, this, this);
            this.zzaov.setMinimumWidth(adSizeParcel.widthPixels);
            this.zzaov.setMinimumHeight(adSizeParcel.heightPixels);
            this.zzaov.setVisibility(4);
        }
        this.zzaoy = adSizeParcel;
        this.zzaos = str;
        this.zzagf = context;
        this.zzaou = versionInfoParcel;
        this.zzaot = zzasVar == null ? new zzas(new zzi(this)) : zzasVar;
        this.zzapz = new zzkv(200L);
        this.zzapl = new SimpleArrayMap<>();
    }

    private void zzgs() {
        View viewFindViewById = this.zzaov.getRootView().findViewById(R.id.content);
        if (viewFindViewById == null) {
            return;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        this.zzaov.getGlobalVisibleRect(rect);
        viewFindViewById.getGlobalVisibleRect(rect2);
        if (rect.top != rect2.top) {
            this.zzaqa = false;
        }
        if (rect.bottom != rect2.bottom) {
            this.zzaqb = false;
        }
    }

    private void zzh(boolean z) {
        if (this.zzaov == null || this.zzaoz == null || this.zzaoz.zzbtq == null) {
            return;
        }
        if (!z || this.zzapz.tryAcquire()) {
            if (this.zzaoz.zzbtq.zzuk().zzho()) {
                int[] iArr = new int[2];
                this.zzaov.getLocationOnScreen(iArr);
                int iZzb = com.google.android.gms.ads.internal.client.zzm.zziw().zzb(this.zzagf, iArr[0]);
                int iZzb2 = com.google.android.gms.ads.internal.client.zzm.zziw().zzb(this.zzagf, iArr[1]);
                if (iZzb != this.zzapx || iZzb2 != this.zzapy) {
                    this.zzapx = iZzb;
                    this.zzapy = iZzb2;
                    this.zzaoz.zzbtq.zzuk().zza(this.zzapx, this.zzapy, z ? false : true);
                }
            }
            zzgs();
        }
    }

    public void destroy() {
        zzgr();
        this.zzapd = null;
        this.zzape = null;
        this.zzaph = null;
        this.zzapg = null;
        this.zzapo = null;
        this.zzapf = null;
        zzi(false);
        if (this.zzaov != null) {
            this.zzaov.removeAllViews();
        }
        zzgm();
        zzgo();
        this.zzaoz = null;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        zzh(false);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        zzh(true);
        this.zzaqc = true;
    }

    public void zza(HashSet<zzjz> hashSet) {
        this.zzapw = hashSet;
    }

    public HashSet<zzjz> zzgl() {
        return this.zzapw;
    }

    public void zzgm() {
        if (this.zzaoz == null || this.zzaoz.zzbtq == null) {
            return;
        }
        this.zzaoz.zzbtq.destroy();
    }

    public void zzgn() {
        if (this.zzaoz == null || this.zzaoz.zzbtq == null) {
            return;
        }
        this.zzaoz.zzbtq.stopLoading();
    }

    public void zzgo() {
        if (this.zzaoz == null || this.zzaoz.zzbos == null) {
            return;
        }
        try {
            this.zzaoz.zzbos.destroy();
        } catch (RemoteException e) {
            zzkh.zzcy("Could not destroy mediation adapter.");
        }
    }

    public boolean zzgp() {
        return this.zzapu == 0;
    }

    public boolean zzgq() {
        return this.zzapu == 1;
    }

    public void zzgr() {
        if (this.zzaov != null) {
            this.zzaov.zzgr();
        }
    }

    public String zzgt() {
        if (this.zzaqa && this.zzaqb) {
            return "";
        }
        if (this.zzaqa) {
            return this.zzaqc ? "top-scrollable" : "top-locked";
        }
        if (this.zzaqb) {
            return this.zzaqc ? "bottom-scrollable" : "bottom-locked";
        }
        return "";
    }

    public void zzgu() {
        this.zzapb.zzl(this.zzaoz.zzcio);
        this.zzapb.zzm(this.zzaoz.zzcip);
        this.zzapb.zzac(this.zzaoy.zzauq);
        this.zzapb.zzad(this.zzaoz.zzccc);
    }

    public void zzi(boolean z) {
        if (this.zzapu == 0) {
            zzgn();
        }
        if (this.zzaow != null) {
            this.zzaow.cancel();
        }
        if (this.zzaox != null) {
            this.zzaox.cancel();
        }
        if (z) {
            this.zzaoz = null;
        }
    }
}
