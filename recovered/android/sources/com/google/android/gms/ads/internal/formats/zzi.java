package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzi implements zzh {
    private final Context mContext;
    private final VersionInfoParcel zzalm;
    private final zzq zzbgb;
    private final JSONObject zzbge;
    private final zzil zzbgf;
    private final zzh.zza zzbgg;
    private final zzas zzbgh;
    private boolean zzbgi;
    private zzll zzbgj;
    private String zzbgk;
    private String zzbgl;
    private final Object zzail = new Object();
    private WeakReference<View> zzbgm = null;

    /* JADX INFO: renamed from: com.google.android.gms.ads.internal.formats.zzi$3 */
    class C02513 extends zzil.zza {
        C02513() {
        }

        @Override // com.google.android.gms.internal.zzil.zza
        public void zze(final zzfx zzfxVar) {
            zzfxVar.zza("/loadHtml", new zzet() { // from class: com.google.android.gms.ads.internal.formats.zzi.3.1
                @Override // com.google.android.gms.internal.zzet
                public void zza(zzll zzllVar, final Map<String, String> map) {
                    zzi.this.zzbgj.zzuk().zza(new zzlm.zza() { // from class: com.google.android.gms.ads.internal.formats.zzi.3.1.1
                        @Override // com.google.android.gms.internal.zzlm.zza
                        public void zza(zzll zzllVar2, boolean z) {
                            zzi.this.zzbgk = (String) map.get("id");
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("messageType", "htmlLoaded");
                                jSONObject.put("id", zzi.this.zzbgk);
                                zzfxVar.zzb("sendMessageToNativeJs", jSONObject);
                            } catch (JSONException e) {
                                zzkh.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                            }
                        }
                    });
                    String str = map.get("overlayHtml");
                    String str2 = map.get("baseUrl");
                    if (TextUtils.isEmpty(str2)) {
                        zzi.this.zzbgj.loadData(str, "text/html", "UTF-8");
                    } else {
                        zzi.this.zzbgj.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                    }
                }
            });
            zzfxVar.zza("/showOverlay", new zzet() { // from class: com.google.android.gms.ads.internal.formats.zzi.3.2
                @Override // com.google.android.gms.internal.zzet
                public void zza(zzll zzllVar, Map<String, String> map) {
                    zzi.this.zzbgj.getView().setVisibility(0);
                }
            });
            zzfxVar.zza("/hideOverlay", new zzet() { // from class: com.google.android.gms.ads.internal.formats.zzi.3.3
                @Override // com.google.android.gms.internal.zzet
                public void zza(zzll zzllVar, Map<String, String> map) {
                    zzi.this.zzbgj.getView().setVisibility(8);
                }
            });
            zzi.this.zzbgj.zzuk().zza("/hideOverlay", new zzet() { // from class: com.google.android.gms.ads.internal.formats.zzi.3.4
                @Override // com.google.android.gms.internal.zzet
                public void zza(zzll zzllVar, Map<String, String> map) {
                    zzi.this.zzbgj.getView().setVisibility(8);
                }
            });
            zzi.this.zzbgj.zzuk().zza("/sendMessageToSdk", new zzet() { // from class: com.google.android.gms.ads.internal.formats.zzi.3.5
                @Override // com.google.android.gms.internal.zzet
                public void zza(zzll zzllVar, Map<String, String> map) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        for (String str : map.keySet()) {
                            jSONObject.put(str, map.get(str));
                        }
                        jSONObject.put("id", zzi.this.zzbgk);
                        zzfxVar.zzb("sendMessageToNativeJs", jSONObject);
                    } catch (JSONException e) {
                        zzkh.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                    }
                }
            });
        }
    }

    public zzi(Context context, zzq zzqVar, zzil zzilVar, zzas zzasVar, JSONObject jSONObject, zzh.zza zzaVar, VersionInfoParcel versionInfoParcel, String str) {
        this.mContext = context;
        this.zzbgb = zzqVar;
        this.zzbgf = zzilVar;
        this.zzbgh = zzasVar;
        this.zzbge = jSONObject;
        this.zzbgg = zzaVar;
        this.zzalm = versionInfoParcel;
        this.zzbgl = str;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void recordImpression() {
        zzab.zzhj("recordImpression must be called on the main UI thread.");
        zzq(true);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzbge);
            jSONObject.put("ads_id", this.zzbgl);
            this.zzbgf.zza(new zzil.zza() { // from class: com.google.android.gms.ads.internal.formats.zzi.2
                @Override // com.google.android.gms.internal.zzil.zza
                public void zze(zzfx zzfxVar) {
                    zzfxVar.zza("google.afma.nativeAds.handleImpressionPing", jSONObject);
                }
            });
        } catch (JSONException e) {
            zzkh.zzb("Unable to create impression JSON.", e);
        }
        this.zzbgb.zza(this);
    }

    public zzb zza(View.OnClickListener onClickListener) {
        zza zzaVarZzkz = this.zzbgg.zzkz();
        if (zzaVarZzkz == null) {
            return null;
        }
        zzb zzbVar = new zzb(this.mContext, zzaVarZzkz);
        zzbVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        zzbVar.zzku().setOnClickListener(onClickListener);
        zzbVar.zzku().setContentDescription("Ad attribution icon");
        return zzbVar;
    }

    public void zza(View view, Map<String, WeakReference<View>> map, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        if (zzdc.zzbcg.get().booleanValue()) {
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                View view2 = it.next().getValue().get();
                if (view2 != null) {
                    view2.setOnTouchListener(onTouchListener);
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzab.zzhj("performClick must be called on the main UI thread.");
        for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
            if (view.equals(entry.getValue().get())) {
                zza(entry.getKey(), jSONObject, jSONObject2, jSONObject3);
                return;
            }
        }
        if ("2".equals(this.zzbgg.zzky())) {
            zza("2099", jSONObject, jSONObject2, jSONObject3);
        } else if ("1".equals(this.zzbgg.zzky())) {
            zza("1099", jSONObject, jSONObject2, jSONObject3);
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void zza(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzab.zzhj("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("asset", str);
            jSONObject4.put("template", this.zzbgg.zzky());
            final JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("ad", this.zzbge);
            jSONObject5.put("click", jSONObject4);
            jSONObject5.put("has_custom_click_handler", this.zzbgb.zzv(this.zzbgg.getCustomTemplateId()) != null);
            if (jSONObject != null) {
                jSONObject5.put("view_rectangles", jSONObject);
            }
            if (jSONObject2 != null) {
                jSONObject5.put("click_point", jSONObject2);
            }
            if (jSONObject3 != null) {
                jSONObject5.put("native_view_rectangle", jSONObject3);
            }
            jSONObject5.put("ads_id", this.zzbgl);
            this.zzbgf.zza(new zzil.zza() { // from class: com.google.android.gms.ads.internal.formats.zzi.1
                @Override // com.google.android.gms.internal.zzil.zza
                public void zze(zzfx zzfxVar) {
                    zzfxVar.zza("google.afma.nativeAds.handleClickGmsg", jSONObject5);
                }
            });
        } catch (JSONException e) {
            zzkh.zzb("Unable to create click JSON.", e);
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void zzb(MotionEvent motionEvent) {
        this.zzbgh.zza(motionEvent);
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void zzb(View view, Map<String, WeakReference<View>> map) {
        view.setOnTouchListener(null);
        view.setClickable(false);
        view.setOnClickListener(null);
        Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            View view2 = it.next().getValue().get();
            if (view2 != null) {
                view2.setOnTouchListener(null);
                view2.setClickable(false);
                view2.setOnClickListener(null);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void zzg(View view) {
        synchronized (this.zzail) {
            if (this.zzbgi) {
                return;
            }
            if (view.isShown()) {
                if (view.getGlobalVisibleRect(new Rect(), null)) {
                    recordImpression();
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void zzh(View view) {
        this.zzbgm = new WeakReference<>(view);
    }

    public zzll zzld() {
        this.zzbgj = zzlf();
        this.zzbgj.getView().setVisibility(8);
        this.zzbgf.zza(new C02513());
        return this.zzbgj;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public View zzle() {
        if (this.zzbgm != null) {
            return this.zzbgm.get();
        }
        return null;
    }

    zzll zzlf() {
        return zzu.zzfr().zza(this.mContext, AdSizeParcel.zzk(this.mContext), false, false, this.zzbgh, this.zzalm);
    }

    protected void zzq(boolean z) {
        this.zzbgi = z;
    }
}
