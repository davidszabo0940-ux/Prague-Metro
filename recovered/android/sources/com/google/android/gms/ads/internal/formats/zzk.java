package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdw;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzll;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzk extends zzdw.zza implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private FrameLayout zzaiz;
    private zzh zzbft;
    private final FrameLayout zzbgx;
    private zzb zzbgz;
    int zzbhb;
    int zzbhc;
    private final Object zzail = new Object();
    private Map<String, WeakReference<View>> zzbgy = new HashMap();
    boolean zzbha = false;

    public zzk(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzbgx = frameLayout;
        this.zzaiz = frameLayout2;
        zzu.zzgk().zza((View) this.zzbgx, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzu.zzgk().zza((View) this.zzbgx, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzbgx.setOnTouchListener(this);
        this.zzbgx.setOnClickListener(this);
    }

    @Override // com.google.android.gms.internal.zzdw
    public void destroy() {
        synchronized (this.zzail) {
            if (this.zzaiz != null) {
                this.zzaiz.removeAllViews();
            }
            this.zzaiz = null;
            this.zzbgy = null;
            this.zzbgz = null;
            this.zzbft = null;
        }
    }

    int getMeasuredHeight() {
        return this.zzbgx.getMeasuredHeight();
    }

    int getMeasuredWidth() {
        return this.zzbgx.getMeasuredWidth();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        synchronized (this.zzail) {
            if (this.zzbft == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, WeakReference<View>> entry : this.zzbgy.entrySet()) {
                View view2 = entry.getValue().get();
                if (view2 != null) {
                    Point pointZzi = zzi(view2);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("width", zzx(view2.getWidth()));
                        jSONObject2.put("height", zzx(view2.getHeight()));
                        jSONObject2.put("x", zzx(pointZzi.x));
                        jSONObject2.put("y", zzx(pointZzi.y));
                        jSONObject.put(entry.getKey(), jSONObject2);
                    } catch (JSONException e) {
                        String strValueOf = String.valueOf(entry.getKey());
                        zzkh.zzcy(strValueOf.length() != 0 ? "Unable to get view rectangle for view ".concat(strValueOf) : new String("Unable to get view rectangle for view "));
                    }
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("x", zzx(this.zzbhb));
                jSONObject3.put("y", zzx(this.zzbhc));
            } catch (JSONException e2) {
                zzkh.zzcy("Unable to get click location");
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("width", zzx(getMeasuredWidth()));
                jSONObject4.put("height", zzx(getMeasuredHeight()));
            } catch (JSONException e3) {
                zzkh.zzcy("Unable to get native ad view bounding box");
            }
            if (this.zzbgz == null || !this.zzbgz.zzku().equals(view)) {
                this.zzbft.zza(view, this.zzbgy, jSONObject, jSONObject3, jSONObject4);
            } else {
                this.zzbft.zza("1007", jSONObject, jSONObject3, jSONObject4);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        synchronized (this.zzail) {
            if (this.zzbha) {
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                if (measuredWidth != 0 && measuredHeight != 0 && this.zzaiz != null) {
                    this.zzaiz.setLayoutParams(new FrameLayout.LayoutParams(measuredWidth, measuredHeight));
                    this.zzbha = false;
                }
            }
            if (this.zzbft != null) {
                this.zzbft.zzg(this.zzbgx);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        synchronized (this.zzail) {
            if (this.zzbft != null) {
                this.zzbft.zzg(this.zzbgx);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.zzail) {
            if (this.zzbft != null) {
                Point pointZzc = zzc(motionEvent);
                this.zzbhb = pointZzc.x;
                this.zzbhc = pointZzc.y;
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.setLocation(pointZzc.x, pointZzc.y);
                this.zzbft.zzb(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzdw
    public com.google.android.gms.dynamic.zzd zzap(String str) {
        com.google.android.gms.dynamic.zzd zzdVarZzae;
        synchronized (this.zzail) {
            WeakReference<View> weakReference = this.zzbgy.get(str);
            zzdVarZzae = com.google.android.gms.dynamic.zze.zzae(weakReference == null ? null : weakReference.get());
        }
        return zzdVarZzae;
    }

    Point zzc(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.zzbgx.getLocationOnScreen(iArr);
        return new Point((int) (motionEvent.getRawX() - iArr[0]), (int) (motionEvent.getRawY() - iArr[1]));
    }

    zzb zzc(zzi zziVar) {
        return zziVar.zza(this);
    }

    @Override // com.google.android.gms.internal.zzdw
    public void zzc(String str, com.google.android.gms.dynamic.zzd zzdVar) {
        View view = (View) com.google.android.gms.dynamic.zze.zzad(zzdVar);
        synchronized (this.zzail) {
            try {
                if (view == null) {
                    this.zzbgy.remove(str);
                } else {
                    this.zzbgy.put(str, new WeakReference<>(view));
                    view.setOnTouchListener(this);
                    view.setClickable(true);
                    view.setOnClickListener(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzdw
    public void zze(com.google.android.gms.dynamic.zzd zzdVar) {
        synchronized (this.zzail) {
            zzh(null);
            Object objZzad = com.google.android.gms.dynamic.zze.zzad(zzdVar);
            if (!(objZzad instanceof zzi)) {
                zzkh.zzcy("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            if (this.zzaiz != null) {
                this.zzaiz.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
                this.zzbgx.requestLayout();
            }
            this.zzbha = true;
            final zzi zziVar = (zzi) objZzad;
            if (this.zzbft != null && zzdc.zzbcf.get().booleanValue()) {
                this.zzbft.zzb(this.zzbgx, this.zzbgy);
            }
            if ((this.zzbft instanceof zzg) && ((zzg) this.zzbft).zzlb()) {
                ((zzg) this.zzbft).zzc(zziVar);
            } else {
                this.zzbft = zziVar;
                if (zziVar instanceof zzg) {
                    ((zzg) zziVar).zzc(null);
                }
            }
            if (zzdc.zzbcf.get().booleanValue()) {
                this.zzaiz.setClickable(false);
            }
            this.zzaiz.removeAllViews();
            this.zzbgz = zzc(zziVar);
            if (this.zzbgz != null) {
                this.zzbgy.put("1007", new WeakReference<>(this.zzbgz.zzku()));
                this.zzaiz.addView(this.zzbgz);
            }
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.formats.zzk.1
                @Override // java.lang.Runnable
                public void run() {
                    zzll zzllVarZzld = zziVar.zzld();
                    if (zzllVarZzld == null || zzk.this.zzaiz == null) {
                        return;
                    }
                    zzk.this.zzaiz.addView(zzllVarZzld.getView());
                }
            });
            zziVar.zza(this.zzbgx, this.zzbgy, this, this);
            zzh(this.zzbgx);
        }
    }

    void zzh(View view) {
        if (this.zzbft != null) {
            zzh zzhVarZzlc = this.zzbft instanceof zzg ? ((zzg) this.zzbft).zzlc() : this.zzbft;
            if (zzhVarZzlc != null) {
                zzhVarZzlc.zzh(view);
            }
        }
    }

    Point zzi(View view) {
        if (this.zzbgz == null || !this.zzbgz.zzku().equals(view)) {
            Point point = new Point();
            view.getGlobalVisibleRect(new Rect(), point);
            return point;
        }
        Point point2 = new Point();
        this.zzbgx.getGlobalVisibleRect(new Rect(), point2);
        Point point3 = new Point();
        view.getGlobalVisibleRect(new Rect(), point3);
        return new Point(point3.x - point2.x, point3.y - point2.y);
    }

    int zzx(int i) {
        return zzm.zziw().zzb(this.zzbft.getContext(), i);
    }
}
