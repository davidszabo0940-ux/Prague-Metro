package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzcd implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final WeakReference<zzjy> zzaqf;
    private final zzck zzaqh;
    protected final zzcf zzaqi;
    private final Context zzaqj;
    private final WindowManager zzaqk;
    private final PowerManager zzaql;
    private final KeyguardManager zzaqm;
    private zzch zzaqn;
    private boolean zzaqo;
    private boolean zzaqr;
    BroadcastReceiver zzaqt;
    protected final Object zzail = new Object();
    private boolean zzanc = false;
    private boolean zzaqp = false;
    private final HashSet<zzce> zzaqu = new HashSet<>();
    private final zzet zzaqv = new zzet() { // from class: com.google.android.gms.internal.zzcd.2
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            if (zzcd.this.zzb(map)) {
                zzcd.this.zza(zzllVar.getView(), map);
            }
        }
    };
    private final zzet zzaqw = new zzet() { // from class: com.google.android.gms.internal.zzcd.3
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            if (zzcd.this.zzb(map)) {
                String strValueOf = String.valueOf(zzcd.this.zzaqi.zzhn());
                zzkh.zzcw(strValueOf.length() != 0 ? "Received request to untrack: ".concat(strValueOf) : new String("Received request to untrack: "));
                zzcd.this.destroy();
            }
        }
    };
    private final zzet zzaqx = new zzet() { // from class: com.google.android.gms.internal.zzcd.4
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            if (zzcd.this.zzb(map) && map.containsKey("isVisible")) {
                zzcd.this.zzj(Boolean.valueOf("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"))).booleanValue());
            }
        }
    };
    private WeakReference<ViewTreeObserver> zzaqg = new WeakReference<>(null);
    private boolean zzaqq = true;
    private boolean zzaqs = false;
    private zzkv zzapz = new zzkv(200);

    public static class zza implements zzck {
        private WeakReference<com.google.android.gms.ads.internal.formats.zzh> zzaqz;

        public zza(com.google.android.gms.ads.internal.formats.zzh zzhVar) {
            this.zzaqz = new WeakReference<>(zzhVar);
        }

        @Override // com.google.android.gms.internal.zzck
        public View zzhh() {
            com.google.android.gms.ads.internal.formats.zzh zzhVar = this.zzaqz.get();
            if (zzhVar != null) {
                return zzhVar.zzle();
            }
            return null;
        }

        @Override // com.google.android.gms.internal.zzck
        public boolean zzhi() {
            return this.zzaqz.get() == null;
        }

        @Override // com.google.android.gms.internal.zzck
        public zzck zzhj() {
            return new zzb(this.zzaqz.get());
        }
    }

    public static class zzb implements zzck {
        private com.google.android.gms.ads.internal.formats.zzh zzara;

        public zzb(com.google.android.gms.ads.internal.formats.zzh zzhVar) {
            this.zzara = zzhVar;
        }

        @Override // com.google.android.gms.internal.zzck
        public View zzhh() {
            return this.zzara.zzle();
        }

        @Override // com.google.android.gms.internal.zzck
        public boolean zzhi() {
            return this.zzara == null;
        }

        @Override // com.google.android.gms.internal.zzck
        public zzck zzhj() {
            return this;
        }
    }

    public static class zzc implements zzck {
        private final View mView;
        private final zzjy zzarb;

        public zzc(View view, zzjy zzjyVar) {
            this.mView = view;
            this.zzarb = zzjyVar;
        }

        @Override // com.google.android.gms.internal.zzck
        public View zzhh() {
            return this.mView;
        }

        @Override // com.google.android.gms.internal.zzck
        public boolean zzhi() {
            return this.zzarb == null || this.mView == null;
        }

        @Override // com.google.android.gms.internal.zzck
        public zzck zzhj() {
            return this;
        }
    }

    public static class zzd implements zzck {
        private final WeakReference<View> zzarc;
        private final WeakReference<zzjy> zzard;

        public zzd(View view, zzjy zzjyVar) {
            this.zzarc = new WeakReference<>(view);
            this.zzard = new WeakReference<>(zzjyVar);
        }

        @Override // com.google.android.gms.internal.zzck
        public View zzhh() {
            return this.zzarc.get();
        }

        @Override // com.google.android.gms.internal.zzck
        public boolean zzhi() {
            return this.zzarc.get() == null || this.zzard.get() == null;
        }

        @Override // com.google.android.gms.internal.zzck
        public zzck zzhj() {
            return new zzc(this.zzarc.get(), this.zzard.get());
        }
    }

    public zzcd(Context context, AdSizeParcel adSizeParcel, zzjy zzjyVar, VersionInfoParcel versionInfoParcel, zzck zzckVar) {
        this.zzaqf = new WeakReference<>(zzjyVar);
        this.zzaqh = zzckVar;
        this.zzaqi = new zzcf(UUID.randomUUID().toString(), versionInfoParcel, adSizeParcel.zzaup, zzjyVar.zzcii, zzjyVar.zzho(), adSizeParcel.zzaus);
        this.zzaqk = (WindowManager) context.getSystemService("window");
        this.zzaql = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.zzaqm = (KeyguardManager) context.getSystemService("keyguard");
        this.zzaqj = context;
    }

    protected void destroy() {
        synchronized (this.zzail) {
            zzhc();
            zzgx();
            this.zzaqq = false;
            zzgz();
        }
    }

    boolean isScreenOn() {
        return this.zzaql.isScreenOn();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        zzk(2);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        zzk(1);
    }

    public void pause() {
        synchronized (this.zzail) {
            this.zzanc = true;
            zzk(3);
        }
    }

    public void resume() {
        synchronized (this.zzail) {
            this.zzanc = false;
            zzk(3);
        }
    }

    public void stop() {
        synchronized (this.zzail) {
            this.zzaqp = true;
            zzk(3);
        }
    }

    protected int zza(int i, DisplayMetrics displayMetrics) {
        return (int) (i / displayMetrics.density);
    }

    protected void zza(View view, Map<String, String> map) {
        zzk(3);
    }

    public void zza(zzce zzceVar) {
        this.zzaqu.add(zzceVar);
    }

    public void zza(zzch zzchVar) {
        synchronized (this.zzail) {
            this.zzaqn = zzchVar;
        }
    }

    protected void zza(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            zzb(jSONObject2);
        } catch (Throwable th) {
            zzkh.zzb("Skipping active view message.", th);
        }
    }

    protected abstract void zzb(JSONObject jSONObject);

    protected boolean zzb(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzaqi.zzhn());
    }

    protected void zzc(zzfx zzfxVar) {
        zzfxVar.zza("/updateActiveView", this.zzaqv);
        zzfxVar.zza("/untrackActiveViewUnit", this.zzaqw);
        zzfxVar.zza("/visibilityChanged", this.zzaqx);
    }

    protected JSONObject zzd(View view) throws JSONException {
        if (view == null) {
            return zzhf();
        }
        boolean zIsAttachedToWindow = com.google.android.gms.ads.internal.zzu.zzfs().isAttachedToWindow(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Exception e) {
            zzkh.zzb("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.zzaqk.getDefaultDisplay().getWidth();
        rect2.bottom = this.zzaqk.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        JSONObject jSONObjectZzhd = zzhd();
        jSONObjectZzhd.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", zIsAttachedToWindow).put("viewBox", new JSONObject().put("top", zza(rect2.top, displayMetrics)).put("bottom", zza(rect2.bottom, displayMetrics)).put("left", zza(rect2.left, displayMetrics)).put("right", zza(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", zza(rect.top, displayMetrics)).put("bottom", zza(rect.bottom, displayMetrics)).put("left", zza(rect.left, displayMetrics)).put("right", zza(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", zza(rect3.top, displayMetrics)).put("bottom", zza(rect3.bottom, displayMetrics)).put("left", zza(rect3.left, displayMetrics)).put("right", zza(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", zza(rect4.top, displayMetrics)).put("bottom", zza(rect4.bottom, displayMetrics)).put("left", zza(rect4.left, displayMetrics)).put("right", zza(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", zza(rect5.top, displayMetrics)).put("bottom", zza(rect5.bottom, displayMetrics)).put("left", zza(rect5.left, displayMetrics)).put("right", zza(rect5.right, displayMetrics))).put("screenDensity", displayMetrics.density).put("isVisible", com.google.android.gms.ads.internal.zzu.zzfq().zza(view, this.zzaql, this.zzaqm));
        return jSONObjectZzhd;
    }

    protected void zzd(zzfx zzfxVar) {
        zzfxVar.zzb("/visibilityChanged", this.zzaqx);
        zzfxVar.zzb("/untrackActiveViewUnit", this.zzaqw);
        zzfxVar.zzb("/updateActiveView", this.zzaqv);
    }

    protected void zzgw() {
        synchronized (this.zzail) {
            if (this.zzaqt != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.zzaqt = new BroadcastReceiver() { // from class: com.google.android.gms.internal.zzcd.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    zzcd.this.zzk(3);
                }
            };
            this.zzaqj.registerReceiver(this.zzaqt, intentFilter);
        }
    }

    protected void zzgx() {
        synchronized (this.zzail) {
            if (this.zzaqt != null) {
                try {
                    this.zzaqj.unregisterReceiver(this.zzaqt);
                } catch (IllegalStateException e) {
                    zzkh.zzb("Failed trying to unregister the receiver", e);
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzu.zzft().zzb((Throwable) e2, true);
                }
                this.zzaqt = null;
            }
        }
    }

    public void zzgy() {
        synchronized (this.zzail) {
            if (this.zzaqq) {
                this.zzaqr = true;
                try {
                    zza(zzhg());
                } catch (RuntimeException e) {
                    zzkh.zzb("Failure while processing active view data.", e);
                } catch (JSONException e2) {
                    zzkh.zzb("JSON failure while processing active view data.", e2);
                }
                String strValueOf = String.valueOf(this.zzaqi.zzhn());
                zzkh.zzcw(strValueOf.length() != 0 ? "Untracking ad unit: ".concat(strValueOf) : new String("Untracking ad unit: "));
            }
        }
    }

    protected void zzgz() {
        if (this.zzaqn != null) {
            this.zzaqn.zza(this);
        }
    }

    public boolean zzha() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzaqq;
        }
        return z;
    }

    protected void zzhb() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        View viewZzhh = this.zzaqh.zzhj().zzhh();
        if (viewZzhh == null || (viewTreeObserver2 = viewZzhh.getViewTreeObserver()) == (viewTreeObserver = this.zzaqg.get())) {
            return;
        }
        zzhc();
        if (!this.zzaqo || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
            this.zzaqo = true;
            viewTreeObserver2.addOnScrollChangedListener(this);
            viewTreeObserver2.addOnGlobalLayoutListener(this);
        }
        this.zzaqg = new WeakReference<>(viewTreeObserver2);
    }

    protected void zzhc() {
        ViewTreeObserver viewTreeObserver = this.zzaqg.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this);
        viewTreeObserver.removeGlobalOnLayoutListener(this);
    }

    protected JSONObject zzhd() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.zzaqi.zzhl()).put("activeViewJSON", this.zzaqi.zzhm()).put("timestamp", com.google.android.gms.ads.internal.zzu.zzfu().elapsedRealtime()).put("adFormat", this.zzaqi.zzhk()).put("hashCode", this.zzaqi.zzhn()).put("isMraid", this.zzaqi.zzho()).put("isStopped", this.zzaqp).put("isPaused", this.zzanc).put("isScreenOn", isScreenOn()).put("isNative", this.zzaqi.zzhp());
        return jSONObject;
    }

    protected abstract boolean zzhe();

    protected JSONObject zzhf() throws JSONException {
        return zzhd().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
    }

    protected JSONObject zzhg() throws JSONException {
        JSONObject jSONObjectZzhd = zzhd();
        jSONObjectZzhd.put("doneReasonCode", "u");
        return jSONObjectZzhd;
    }

    protected void zzj(boolean z) {
        Iterator<zzce> it = this.zzaqu.iterator();
        while (it.hasNext()) {
            it.next().zza(this, z);
        }
    }

    protected void zzk(int i) {
        synchronized (this.zzail) {
            if (zzhe() && this.zzaqq) {
                View viewZzhh = this.zzaqh.zzhh();
                boolean z = viewZzhh != null && com.google.android.gms.ads.internal.zzu.zzfq().zza(viewZzhh, this.zzaql, this.zzaqm) && viewZzhh.getGlobalVisibleRect(new Rect(), null);
                this.zzaqs = z;
                if (this.zzaqh.zzhi()) {
                    zzgy();
                    return;
                }
                if ((i == 1) && !this.zzapz.tryAcquire() && z == this.zzaqs) {
                    return;
                }
                if (z || this.zzaqs || i != 1) {
                    try {
                        zza(zzd(viewZzhh));
                    } catch (RuntimeException | JSONException e) {
                        zzkh.zza("Active view update failed.", e);
                    }
                    zzhb();
                    zzgz();
                }
            }
        }
    }
}
