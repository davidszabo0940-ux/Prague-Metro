package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzhm;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzd extends zzhm.zza implements zzu {
    static final int zzbsr = Color.argb(0, 0, 0, 0);
    private final Activity mActivity;
    zzll zzbgj;
    AdOverlayInfoParcel zzbss;
    zzc zzbst;
    zzo zzbsu;
    FrameLayout zzbsw;
    WebChromeClient.CustomViewCallback zzbsx;
    zzb zzbta;
    private boolean zzbte;
    boolean zzbsv = false;
    boolean zzbsy = false;
    boolean zzbsz = false;
    boolean zzbtb = false;
    int zzbtc = 0;
    private boolean zzbtf = false;
    private boolean zzbtg = true;
    zzl zzbtd = new zzs();

    @zzir
    private static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    @zzir
    static class zzb extends RelativeLayout {
        zzko zzaqd;
        boolean zzbti;

        public zzb(Context context, String str) {
            super(context);
            this.zzaqd = new zzko(context, str);
        }

        void disable() {
            this.zzbti = true;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (this.zzbti) {
                return false;
            }
            this.zzaqd.zze(motionEvent);
            return false;
        }
    }

    @zzir
    public static class zzc {
        public final int index;
        public final Context zzagf;
        public final ViewGroup.LayoutParams zzbtj;
        public final ViewGroup zzbtk;

        public zzc(zzll zzllVar) throws zza {
            this.zzbtj = zzllVar.getLayoutParams();
            ViewParent parent = zzllVar.getParent();
            this.zzagf = zzllVar.zzug();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new zza("Could not get the parent of the WebView for an overlay.");
            }
            this.zzbtk = (ViewGroup) parent;
            this.index = this.zzbtk.indexOfChild(zzllVar.getView());
            this.zzbtk.removeView(zzllVar.getView());
            zzllVar.zzah(true);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.ads.internal.overlay.zzd$zzd, reason: collision with other inner class name */
    @zzir
    private class C0729zzd extends zzkg {
        private C0729zzd() {
        }

        @Override // com.google.android.gms.internal.zzkg
        public void onStop() {
        }

        @Override // com.google.android.gms.internal.zzkg
        public void zzew() {
            Bitmap bitmapZza = com.google.android.gms.ads.internal.zzu.zzgh().zza(Integer.valueOf(zzd.this.zzbss.zzbtz.zzamh));
            if (bitmapZza != null) {
                final Drawable drawableZza = com.google.android.gms.ads.internal.zzu.zzfs().zza(zzd.this.mActivity, bitmapZza, zzd.this.zzbss.zzbtz.zzamf, zzd.this.zzbss.zzbtz.zzamg);
                zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzd.zzd.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zzd.this.mActivity.getWindow().setBackgroundDrawable(drawableZza);
                    }
                });
            }
        }
    }

    public zzd(Activity activity) {
        this.mActivity = activity;
    }

    public void close() {
        this.zzbtc = 2;
        this.mActivity.finish();
    }

    @Override // com.google.android.gms.internal.zzhm
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.zzhm
    public void onBackPressed() {
        this.zzbtc = 0;
    }

    @Override // com.google.android.gms.internal.zzhm
    public void onCreate(Bundle bundle) {
        this.mActivity.requestWindowFeature(1);
        this.zzbsy = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.zzbss = AdOverlayInfoParcel.zzb(this.mActivity.getIntent());
            if (this.zzbss == null) {
                throw new zza("Could not get info for ad overlay.");
            }
            if (this.zzbss.zzaou.zzcnp > 7500000) {
                this.zzbtc = 3;
            }
            if (this.mActivity.getIntent() != null) {
                this.zzbtg = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.zzbss.zzbtz != null) {
                this.zzbsz = this.zzbss.zzbtz.zzamc;
            } else {
                this.zzbsz = false;
            }
            if (zzdc.zzbby.get().booleanValue() && this.zzbsz && this.zzbss.zzbtz.zzamh != -1) {
            }
            if (bundle == null) {
                if (this.zzbss.zzbtp != null && this.zzbtg) {
                    this.zzbss.zzbtp.zzdz();
                }
                if (this.zzbss.zzbtw != 1 && this.zzbss.zzbto != null) {
                    this.zzbss.zzbto.onAdClicked();
                }
            }
            this.zzbta = new zzb(this.mActivity, this.zzbss.zzbty);
            this.zzbta.setId(1000);
            switch (this.zzbss.zzbtw) {
                case 1:
                    zzaa(false);
                    return;
                case 2:
                    this.zzbst = new zzc(this.zzbss.zzbtq);
                    zzaa(false);
                    return;
                case 3:
                    zzaa(true);
                    return;
                case 4:
                    if (this.zzbsy) {
                        this.zzbtc = 3;
                        this.mActivity.finish();
                        return;
                    } else {
                        if (com.google.android.gms.ads.internal.zzu.zzfn().zza(this.mActivity, this.zzbss.zzbtn, this.zzbss.zzbtv)) {
                            return;
                        }
                        this.zzbtc = 3;
                        this.mActivity.finish();
                        return;
                    }
                default:
                    throw new zza("Could not determine ad overlay type.");
            }
        } catch (zza e) {
            zzkh.zzcy(e.getMessage());
            this.zzbtc = 3;
            this.mActivity.finish();
        }
    }

    @Override // com.google.android.gms.internal.zzhm
    public void onDestroy() {
        if (this.zzbgj != null) {
            this.zzbta.removeView(this.zzbgj.getView());
        }
        zzoa();
    }

    @Override // com.google.android.gms.internal.zzhm
    public void onPause() {
        this.zzbtd.pause();
        zznw();
        if (this.zzbss.zzbtp != null) {
            this.zzbss.zzbtp.onPause();
        }
        if (this.zzbgj != null && (!this.mActivity.isFinishing() || this.zzbst == null)) {
            com.google.android.gms.ads.internal.zzu.zzfs().zzj(this.zzbgj);
        }
        zzoa();
    }

    @Override // com.google.android.gms.internal.zzhm
    public void onRestart() {
    }

    @Override // com.google.android.gms.internal.zzhm
    public void onResume() {
        if (this.zzbss != null && this.zzbss.zzbtw == 4) {
            if (this.zzbsy) {
                this.zzbtc = 3;
                this.mActivity.finish();
            } else {
                this.zzbsy = true;
            }
        }
        if (this.zzbss.zzbtp != null) {
            this.zzbss.zzbtp.onResume();
        }
        if (this.zzbgj == null || this.zzbgj.isDestroyed()) {
            zzkh.zzcy("The webview does not exit. Ignoring action.");
        } else {
            com.google.android.gms.ads.internal.zzu.zzfs().zzk(this.zzbgj);
        }
        this.zzbtd.resume();
    }

    @Override // com.google.android.gms.internal.zzhm
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzbsy);
    }

    @Override // com.google.android.gms.internal.zzhm
    public void onStart() {
    }

    @Override // com.google.android.gms.internal.zzhm
    public void onStop() {
        zzoa();
    }

    public void setRequestedOrientation(int i) {
        this.mActivity.setRequestedOrientation(i);
    }

    public void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzbsw = new FrameLayout(this.mActivity);
        this.zzbsw.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzbsw.addView(view, -1, -1);
        this.mActivity.setContentView(this.zzbsw);
        zzdc();
        this.zzbsx = customViewCallback;
        this.zzbsv = true;
    }

    public void zza(boolean z, boolean z2) {
        if (this.zzbsu != null) {
            this.zzbsu.zza(z, z2);
        }
    }

    protected void zzaa(boolean z) throws zza {
        if (!this.zzbte) {
            this.mActivity.requestWindowFeature(1);
        }
        Window window = this.mActivity.getWindow();
        if (window == null) {
            throw new zza("Invalid activity, no window available.");
        }
        if (!this.zzbsz || (this.zzbss.zzbtz != null && this.zzbss.zzbtz.zzamd)) {
            window.setFlags(1024, 1024);
        }
        boolean zZzho = this.zzbss.zzbtq.zzuk().zzho();
        this.zzbtb = false;
        if (zZzho) {
            if (this.zzbss.orientation == com.google.android.gms.ads.internal.zzu.zzfs().zztk()) {
                this.zzbtb = this.mActivity.getResources().getConfiguration().orientation == 1;
            } else if (this.zzbss.orientation == com.google.android.gms.ads.internal.zzu.zzfs().zztl()) {
                this.zzbtb = this.mActivity.getResources().getConfiguration().orientation == 2;
            }
        }
        zzkh.zzcw(new StringBuilder(46).append("Delay onShow to next orientation change: ").append(this.zzbtb).toString());
        setRequestedOrientation(this.zzbss.orientation);
        if (com.google.android.gms.ads.internal.zzu.zzfs().zza(window)) {
            zzkh.zzcw("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.zzbsz) {
            this.zzbta.setBackgroundColor(zzbsr);
        } else {
            this.zzbta.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.mActivity.setContentView(this.zzbta);
        zzdc();
        if (z) {
            this.zzbgj = com.google.android.gms.ads.internal.zzu.zzfr().zza(this.mActivity, this.zzbss.zzbtq.zzdo(), true, zZzho, null, this.zzbss.zzaou, null, null, this.zzbss.zzbtq.zzuh());
            this.zzbgj.zzuk().zza(null, null, this.zzbss.zzbtr, this.zzbss.zzbtv, true, this.zzbss.zzbtx, null, this.zzbss.zzbtq.zzuk().zzuy(), null, null);
            this.zzbgj.zzuk().zza(new zzlm.zza() { // from class: com.google.android.gms.ads.internal.overlay.zzd.1
                @Override // com.google.android.gms.internal.zzlm.zza
                public void zza(zzll zzllVar, boolean z2) {
                    zzllVar.zzoc();
                }
            });
            if (this.zzbss.url != null) {
                this.zzbgj.loadUrl(this.zzbss.url);
            } else {
                if (this.zzbss.zzbtu == null) {
                    throw new zza("No URL or HTML to display in ad overlay.");
                }
                this.zzbgj.loadDataWithBaseURL(this.zzbss.zzbts, this.zzbss.zzbtu, "text/html", "UTF-8", null);
            }
            if (this.zzbss.zzbtq != null) {
                this.zzbss.zzbtq.zzc(this);
            }
        } else {
            this.zzbgj = this.zzbss.zzbtq;
            this.zzbgj.setContext(this.mActivity);
        }
        this.zzbgj.zzb(this);
        ViewParent parent = this.zzbgj.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.zzbgj.getView());
        }
        if (this.zzbsz) {
            this.zzbgj.setBackgroundColor(zzbsr);
        }
        this.zzbta.addView(this.zzbgj.getView(), -1, -1);
        if (!z && !this.zzbtb) {
            zzoc();
        }
        zzz(zZzho);
        if (this.zzbgj.zzul()) {
            zza(zZzho, true);
        }
        com.google.android.gms.ads.internal.zzd zzdVarZzuh = this.zzbgj.zzuh();
        zzm zzmVar = zzdVarZzuh != null ? zzdVarZzuh.zzakl : null;
        if (zzmVar != null) {
            this.zzbtd = zzmVar.zza(this.mActivity, this.zzbgj, this.zzbta);
        } else {
            zzkh.zzcy("Appstreaming controller is null.");
        }
    }

    protected void zzaf(int i) {
        this.zzbgj.zzaf(i);
    }

    @Override // com.google.android.gms.internal.zzhm
    public void zzdc() {
        this.zzbte = true;
    }

    public void zzf(zzll zzllVar, Map<String, String> map) {
        this.zzbtd.zzf(zzllVar, map);
    }

    public void zznw() {
        if (this.zzbss != null && this.zzbsv) {
            setRequestedOrientation(this.zzbss.orientation);
        }
        if (this.zzbsw != null) {
            this.mActivity.setContentView(this.zzbta);
            zzdc();
            this.zzbsw.removeAllViews();
            this.zzbsw = null;
        }
        if (this.zzbsx != null) {
            this.zzbsx.onCustomViewHidden();
            this.zzbsx = null;
        }
        this.zzbsv = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzu
    public void zznx() {
        this.zzbtc = 1;
        this.mActivity.finish();
    }

    @Override // com.google.android.gms.internal.zzhm
    public boolean zzny() {
        boolean z = true;
        this.zzbtc = 0;
        if (this.zzbgj != null) {
            z = this.zzbgj.zzow() && this.zzbtd.zzow();
            if (!z) {
                this.zzbgj.zza("onbackblocked", Collections.emptyMap());
            }
        }
        return z;
    }

    public void zznz() {
        this.zzbta.removeView(this.zzbsu);
        zzz(true);
    }

    protected void zzoa() {
        if (!this.mActivity.isFinishing() || this.zzbtf) {
            return;
        }
        this.zzbtf = true;
        if (this.zzbgj != null) {
            zzaf(this.zzbtc);
            this.zzbta.removeView(this.zzbgj.getView());
            if (this.zzbst != null) {
                this.zzbgj.setContext(this.zzbst.zzagf);
                this.zzbgj.zzah(false);
                this.zzbst.zzbtk.addView(this.zzbgj.getView(), this.zzbst.index, this.zzbst.zzbtj);
                this.zzbst = null;
            } else if (this.mActivity.getApplicationContext() != null) {
                this.zzbgj.setContext(this.mActivity.getApplicationContext());
            }
            this.zzbgj = null;
        }
        if (this.zzbss != null && this.zzbss.zzbtp != null) {
            this.zzbss.zzbtp.zzdy();
        }
        this.zzbtd.destroy();
    }

    public void zzob() {
        if (this.zzbtb) {
            this.zzbtb = false;
            zzoc();
        }
    }

    protected void zzoc() {
        this.zzbgj.zzoc();
    }

    public void zzod() {
        this.zzbta.disable();
    }

    public void zzz(boolean z) {
        this.zzbsu = new zzo(this.mActivity, z ? 50 : 32, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.zzbsu.zza(z, this.zzbss.zzbtt);
        this.zzbta.addView(this.zzbsu, layoutParams);
    }
}
