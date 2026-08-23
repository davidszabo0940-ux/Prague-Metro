package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzhe extends zzhj {
    static final Set<String> zzbqi = com.google.android.gms.common.util.zzf.zzc("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private int zzaie;
    private int zzaif;
    private final Object zzail;
    private AdSizeParcel zzang;
    private final zzll zzbgj;
    private final Activity zzbpy;
    private String zzbqj;
    private boolean zzbqk;
    private int zzbql;
    private int zzbqm;
    private int zzbqn;
    private int zzbqo;
    private ImageView zzbqp;
    private LinearLayout zzbqq;
    private zzhk zzbqr;
    private PopupWindow zzbqs;
    private RelativeLayout zzbqt;
    private ViewGroup zzbqu;

    public zzhe(zzll zzllVar, zzhk zzhkVar) {
        super(zzllVar, "resize");
        this.zzbqj = "top-right";
        this.zzbqk = true;
        this.zzbql = 0;
        this.zzbqm = 0;
        this.zzaif = -1;
        this.zzbqn = 0;
        this.zzbqo = 0;
        this.zzaie = -1;
        this.zzail = new Object();
        this.zzbgj = zzllVar;
        this.zzbpy = zzllVar.zzuf();
        this.zzbqr = zzhkVar;
    }

    private void zzi(Map<String, String> map) {
        if (!TextUtils.isEmpty(map.get("width"))) {
            this.zzaie = com.google.android.gms.ads.internal.zzu.zzfq().zzcq(map.get("width"));
        }
        if (!TextUtils.isEmpty(map.get("height"))) {
            this.zzaif = com.google.android.gms.ads.internal.zzu.zzfq().zzcq(map.get("height"));
        }
        if (!TextUtils.isEmpty(map.get("offsetX"))) {
            this.zzbqn = com.google.android.gms.ads.internal.zzu.zzfq().zzcq(map.get("offsetX"));
        }
        if (!TextUtils.isEmpty(map.get("offsetY"))) {
            this.zzbqo = com.google.android.gms.ads.internal.zzu.zzfq().zzcq(map.get("offsetY"));
        }
        if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
            this.zzbqk = Boolean.parseBoolean(map.get("allowOffscreen"));
        }
        String str = map.get("customClosePosition");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzbqj = str;
    }

    private int[] zzmx() {
        if (!zzmz()) {
            return null;
        }
        if (this.zzbqk) {
            return new int[]{this.zzbql + this.zzbqn, this.zzbqm + this.zzbqo};
        }
        int[] iArrZzi = com.google.android.gms.ads.internal.zzu.zzfq().zzi(this.zzbpy);
        int[] iArrZzk = com.google.android.gms.ads.internal.zzu.zzfq().zzk(this.zzbpy);
        int i = iArrZzi[0];
        int i2 = this.zzbql + this.zzbqn;
        int i3 = this.zzbqm + this.zzbqo;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.zzaie + i2 > i) {
            i2 = i - this.zzaie;
        }
        if (i3 < iArrZzk[0]) {
            i3 = iArrZzk[0];
        } else if (this.zzaif + i3 > iArrZzk[1]) {
            i3 = iArrZzk[1] - this.zzaif;
        }
        return new int[]{i2, i3};
    }

    public void execute(Map<String, String> map) {
        synchronized (this.zzail) {
            if (this.zzbpy == null) {
                zzbu("Not an activity context. Cannot resize.");
                return;
            }
            if (this.zzbgj.zzdo() == null) {
                zzbu("Webview is not yet available, size is not set.");
                return;
            }
            if (this.zzbgj.zzdo().zzauq) {
                zzbu("Is interstitial. Cannot resize an interstitial.");
                return;
            }
            if (this.zzbgj.zzuo()) {
                zzbu("Cannot resize an expanded banner.");
                return;
            }
            zzi(map);
            if (!zzmw()) {
                zzbu("Invalid width and height options. Cannot resize.");
                return;
            }
            Window window = this.zzbpy.getWindow();
            if (window == null || window.getDecorView() == null) {
                zzbu("Activity context is not ready, cannot get window or decor view.");
                return;
            }
            int[] iArrZzmx = zzmx();
            if (iArrZzmx == null) {
                zzbu("Resize location out of screen or close button is not visible.");
                return;
            }
            int iZza = com.google.android.gms.ads.internal.client.zzm.zziw().zza(this.zzbpy, this.zzaie);
            int iZza2 = com.google.android.gms.ads.internal.client.zzm.zziw().zza(this.zzbpy, this.zzaif);
            ViewParent parent = this.zzbgj.getView().getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                zzbu("Webview is detached, probably in the middle of a resize or expand.");
                return;
            }
            ((ViewGroup) parent).removeView(this.zzbgj.getView());
            if (this.zzbqs == null) {
                this.zzbqu = (ViewGroup) parent;
                Bitmap bitmapZzk = com.google.android.gms.ads.internal.zzu.zzfq().zzk(this.zzbgj.getView());
                this.zzbqp = new ImageView(this.zzbpy);
                this.zzbqp.setImageBitmap(bitmapZzk);
                this.zzang = this.zzbgj.zzdo();
                this.zzbqu.addView(this.zzbqp);
            } else {
                this.zzbqs.dismiss();
            }
            this.zzbqt = new RelativeLayout(this.zzbpy);
            this.zzbqt.setBackgroundColor(0);
            this.zzbqt.setLayoutParams(new ViewGroup.LayoutParams(iZza, iZza2));
            this.zzbqs = com.google.android.gms.ads.internal.zzu.zzfq().zza((View) this.zzbqt, iZza, iZza2, false);
            this.zzbqs.setOutsideTouchable(true);
            this.zzbqs.setTouchable(true);
            this.zzbqs.setClippingEnabled(!this.zzbqk);
            this.zzbqt.addView(this.zzbgj.getView(), -1, -1);
            this.zzbqq = new LinearLayout(this.zzbpy);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.google.android.gms.ads.internal.client.zzm.zziw().zza(this.zzbpy, 50), com.google.android.gms.ads.internal.client.zzm.zziw().zza(this.zzbpy, 50));
            switch (this.zzbqj) {
                case "top-left":
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    break;
                case "top-center":
                    layoutParams.addRule(10);
                    layoutParams.addRule(14);
                    break;
                case "center":
                    layoutParams.addRule(13);
                    break;
                case "bottom-left":
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    break;
                case "bottom-center":
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                    break;
                case "bottom-right":
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    break;
                default:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    break;
            }
            this.zzbqq.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.internal.zzhe.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    zzhe.this.zzs(true);
                }
            });
            this.zzbqq.setContentDescription("Close button");
            this.zzbqt.addView(this.zzbqq, layoutParams);
            try {
                this.zzbqs.showAtLocation(window.getDecorView(), 0, com.google.android.gms.ads.internal.client.zzm.zziw().zza(this.zzbpy, iArrZzmx[0]), com.google.android.gms.ads.internal.client.zzm.zziw().zza(this.zzbpy, iArrZzmx[1]));
                zzb(iArrZzmx[0], iArrZzmx[1]);
                this.zzbgj.zza(new AdSizeParcel(this.zzbpy, new AdSize(this.zzaie, this.zzaif)));
                zzc(iArrZzmx[0], iArrZzmx[1]);
                zzbw("resized");
            } catch (RuntimeException e) {
                String strValueOf = String.valueOf(e.getMessage());
                zzbu(strValueOf.length() != 0 ? "Cannot show popup window: ".concat(strValueOf) : new String("Cannot show popup window: "));
                this.zzbqt.removeView(this.zzbgj.getView());
                if (this.zzbqu != null) {
                    this.zzbqu.removeView(this.zzbqp);
                    this.zzbqu.addView(this.zzbgj.getView());
                    this.zzbgj.zza(this.zzang);
                }
            }
        }
    }

    public void zza(int i, int i2, boolean z) {
        synchronized (this.zzail) {
            this.zzbql = i;
            this.zzbqm = i2;
            if (this.zzbqs != null && z) {
                int[] iArrZzmx = zzmx();
                if (iArrZzmx != null) {
                    this.zzbqs.update(com.google.android.gms.ads.internal.client.zzm.zziw().zza(this.zzbpy, iArrZzmx[0]), com.google.android.gms.ads.internal.client.zzm.zziw().zza(this.zzbpy, iArrZzmx[1]), this.zzbqs.getWidth(), this.zzbqs.getHeight());
                    zzc(iArrZzmx[0], iArrZzmx[1]);
                } else {
                    zzs(true);
                }
            }
        }
    }

    void zzb(int i, int i2) {
        if (this.zzbqr != null) {
            this.zzbqr.zza(i, i2, this.zzaie, this.zzaif);
        }
    }

    void zzc(int i, int i2) {
        zzb(i, i2 - com.google.android.gms.ads.internal.zzu.zzfq().zzk(this.zzbpy)[0], this.zzaie, this.zzaif);
    }

    public void zzd(int i, int i2) {
        this.zzbql = i;
        this.zzbqm = i2;
    }

    boolean zzmw() {
        return this.zzaie > -1 && this.zzaif > -1;
    }

    public boolean zzmy() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzbqs != null;
        }
        return z;
    }

    boolean zzmz() {
        int i;
        int i2;
        int[] iArrZzi = com.google.android.gms.ads.internal.zzu.zzfq().zzi(this.zzbpy);
        int[] iArrZzk = com.google.android.gms.ads.internal.zzu.zzfq().zzk(this.zzbpy);
        int i3 = iArrZzi[0];
        int i4 = iArrZzi[1];
        if (this.zzaie < 50 || this.zzaie > i3) {
            zzkh.zzcy("Width is too small or too large.");
            return false;
        }
        if (this.zzaif < 50 || this.zzaif > i4) {
            zzkh.zzcy("Height is too small or too large.");
            return false;
        }
        if (this.zzaif == i4 && this.zzaie == i3) {
            zzkh.zzcy("Cannot resize to a full-screen ad.");
            return false;
        }
        if (this.zzbqk) {
            switch (this.zzbqj) {
                case "top-left":
                    i = this.zzbqn + this.zzbql;
                    i2 = this.zzbqm + this.zzbqo;
                    break;
                case "top-center":
                    i = ((this.zzbql + this.zzbqn) + (this.zzaie / 2)) - 25;
                    i2 = this.zzbqm + this.zzbqo;
                    break;
                case "center":
                    i = ((this.zzbql + this.zzbqn) + (this.zzaie / 2)) - 25;
                    i2 = ((this.zzbqm + this.zzbqo) + (this.zzaif / 2)) - 25;
                    break;
                case "bottom-left":
                    i = this.zzbqn + this.zzbql;
                    i2 = ((this.zzbqm + this.zzbqo) + this.zzaif) - 50;
                    break;
                case "bottom-center":
                    i = ((this.zzbql + this.zzbqn) + (this.zzaie / 2)) - 25;
                    i2 = ((this.zzbqm + this.zzbqo) + this.zzaif) - 50;
                    break;
                case "bottom-right":
                    i = ((this.zzbql + this.zzbqn) + this.zzaie) - 50;
                    i2 = ((this.zzbqm + this.zzbqo) + this.zzaif) - 50;
                    break;
                default:
                    i = ((this.zzbql + this.zzbqn) + this.zzaie) - 50;
                    i2 = this.zzbqm + this.zzbqo;
                    break;
            }
            if (i < 0 || i + 50 > i3 || i2 < iArrZzk[0] || i2 + 50 > iArrZzk[1]) {
                return false;
            }
        }
        return true;
    }

    public void zzs(boolean z) {
        synchronized (this.zzail) {
            if (this.zzbqs != null) {
                this.zzbqs.dismiss();
                this.zzbqt.removeView(this.zzbgj.getView());
                if (this.zzbqu != null) {
                    this.zzbqu.removeView(this.zzbqp);
                    this.zzbqu.addView(this.zzbgj.getView());
                    this.zzbgj.zza(this.zzang);
                }
                if (z) {
                    zzbw("default");
                    if (this.zzbqr != null) {
                        this.zzbqr.zzek();
                    }
                }
                this.zzbqs = null;
                this.zzbqt = null;
                this.zzbqu = null;
                this.zzbqq = null;
            }
        }
    }
}
