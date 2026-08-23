package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzll;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzk extends FrameLayout implements zzh {
    private final zzll zzbgj;
    private String zzbjg;
    private final FrameLayout zzbua;
    private final zzy zzbub;

    @Nullable
    private zzi zzbuc;
    private boolean zzbud;
    private boolean zzbue;
    private TextView zzbuf;
    private long zzbug;
    private long zzbuh;
    private String zzbui;

    public zzk(Context context, zzll zzllVar, int i, boolean z, zzdk zzdkVar, zzdi zzdiVar) {
        super(context);
        this.zzbgj = zzllVar;
        this.zzbua = new FrameLayout(context);
        addView(this.zzbua, new FrameLayout.LayoutParams(-1, -1));
        com.google.android.gms.common.internal.zzb.zzw(zzllVar.zzuh());
        this.zzbuc = zzllVar.zzuh().zzakk.zza(context, zzllVar, i, z, zzdkVar, zzdiVar);
        if (this.zzbuc != null) {
            this.zzbua.addView(this.zzbuc, new FrameLayout.LayoutParams(-1, -1, 17));
        }
        this.zzbuf = new TextView(context);
        this.zzbuf.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        zzor();
        this.zzbub = new zzy(this);
        this.zzbub.zzpm();
        if (this.zzbuc != null) {
            this.zzbuc.zza(this);
        }
        if (this.zzbuc == null) {
            zzl("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(String str, String... strArr) {
        HashMap map = new HashMap();
        map.put("event", str);
        int length = strArr.length;
        int i = 0;
        String str2 = null;
        while (i < length) {
            String str3 = strArr[i];
            if (str2 != null) {
                map.put(str2, str3);
                str3 = null;
            }
            i++;
            str2 = str3;
        }
        this.zzbgj.zza("onVideoEvent", map);
    }

    public static void zzi(zzll zzllVar) {
        HashMap map = new HashMap();
        map.put("event", "no_video_view");
        zzllVar.zza("onVideoEvent", map);
    }

    private void zzor() {
        if (zzot()) {
            return;
        }
        this.zzbua.addView(this.zzbuf, new FrameLayout.LayoutParams(-1, -1));
        this.zzbua.bringChildToFront(this.zzbuf);
    }

    private void zzos() {
        if (zzot()) {
            this.zzbua.removeView(this.zzbuf);
        }
    }

    private boolean zzot() {
        return this.zzbuf.getParent() != null;
    }

    private void zzou() {
        if (this.zzbgj.zzuf() == null || this.zzbud) {
            return;
        }
        this.zzbue = (this.zzbgj.zzuf().getWindow().getAttributes().flags & 128) != 0;
        if (this.zzbue) {
            return;
        }
        this.zzbgj.zzuf().getWindow().addFlags(128);
        this.zzbud = true;
    }

    private void zzov() {
        if (this.zzbgj.zzuf() == null || !this.zzbud || this.zzbue) {
            return;
        }
        this.zzbgj.zzuf().getWindow().clearFlags(128);
        this.zzbud = false;
    }

    public void destroy() {
        this.zzbub.cancel();
        if (this.zzbuc != null) {
            this.zzbuc.stop();
        }
        zzov();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void onPaused() {
        zza("pause", new String[0]);
        zzov();
    }

    public void pause() {
        if (this.zzbuc == null) {
            return;
        }
        this.zzbuc.pause();
    }

    public void play() {
        if (this.zzbuc == null) {
            return;
        }
        this.zzbuc.play();
    }

    public void seekTo(int i) {
        if (this.zzbuc == null) {
            return;
        }
        this.zzbuc.seekTo(i);
    }

    public void setMimeType(String str) {
        this.zzbui = str;
    }

    public void zza(float f) {
        if (this.zzbuc == null) {
            return;
        }
        this.zzbuc.zza(f);
    }

    public void zza(float f, float f2) {
        if (this.zzbuc != null) {
            this.zzbuc.zza(f, f2);
        }
    }

    public void zzbx(String str) {
        this.zzbjg = str;
    }

    public void zzd(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3 + 2, i4 + 2);
        layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
        this.zzbua.setLayoutParams(layoutParams);
        requestLayout();
    }

    public void zzd(MotionEvent motionEvent) {
        if (this.zzbuc == null) {
            return;
        }
        this.zzbuc.dispatchTouchEvent(motionEvent);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void zzl(String str, String str2) {
        zza("error", "what", str, "extra", str2);
    }

    public void zzlx() {
        if (this.zzbuc == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzbjg)) {
            zza("no_src", new String[0]);
        } else {
            this.zzbuc.setMimeType(this.zzbui);
            this.zzbuc.setVideoPath(this.zzbjg);
        }
    }

    public void zznq() {
        if (this.zzbuc == null) {
            return;
        }
        this.zzbuc.zznq();
    }

    public void zznr() {
        if (this.zzbuc == null) {
            return;
        }
        this.zzbuc.zznr();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void zzok() {
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzk.1
            @Override // java.lang.Runnable
            public void run() {
                zzk.this.zza("surfaceCreated", new String[0]);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void zzol() {
        if (this.zzbuc != null && this.zzbuh == 0) {
            zza("canplaythrough", "duration", String.valueOf(this.zzbuc.getDuration() / 1000.0f), "videoWidth", String.valueOf(this.zzbuc.getVideoWidth()), "videoHeight", String.valueOf(this.zzbuc.getVideoHeight()));
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void zzom() {
        zzou();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void zzon() {
        zza("ended", new String[0]);
        zzov();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void zzoo() {
        zzor();
        this.zzbuh = this.zzbug;
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzk.2
            @Override // java.lang.Runnable
            public void run() {
                zzk.this.zza("surfaceDestroyed", new String[0]);
            }
        });
    }

    public void zzop() {
        if (this.zzbuc == null) {
            return;
        }
        TextView textView = new TextView(this.zzbuc.getContext());
        String strValueOf = String.valueOf(this.zzbuc.zznk());
        textView.setText(strValueOf.length() != 0 ? "AdMob - ".concat(strValueOf) : new String("AdMob - "));
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
        this.zzbua.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzbua.bringChildToFront(textView);
    }

    void zzoq() {
        if (this.zzbuc == null) {
            return;
        }
        long currentPosition = this.zzbuc.getCurrentPosition();
        if (this.zzbug == currentPosition || currentPosition <= 0) {
            return;
        }
        zzos();
        zza("timeupdate", "time", String.valueOf(currentPosition / 1000.0f));
        this.zzbug = currentPosition;
    }
}
