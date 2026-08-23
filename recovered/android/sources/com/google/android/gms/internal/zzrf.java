package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzrf extends Drawable implements Drawable.Callback {
    private int mFrom;

    /* JADX INFO: renamed from: wE */
    private int f805wE;

    /* JADX INFO: renamed from: wF */
    private int f806wF;

    /* JADX INFO: renamed from: wG */
    private int f807wG;

    /* JADX INFO: renamed from: wH */
    private int f808wH;

    /* JADX INFO: renamed from: wI */
    private int f809wI;

    /* JADX INFO: renamed from: wJ */
    private boolean f810wJ;

    /* JADX INFO: renamed from: wK */
    private zzb f811wK;

    /* JADX INFO: renamed from: wL */
    private Drawable f812wL;

    /* JADX INFO: renamed from: wM */
    private Drawable f813wM;

    /* JADX INFO: renamed from: wN */
    private boolean f814wN;

    /* JADX INFO: renamed from: wO */
    private boolean f815wO;

    /* JADX INFO: renamed from: wP */
    private boolean f816wP;

    /* JADX INFO: renamed from: wQ */
    private int f817wQ;

    /* JADX INFO: renamed from: wy */
    private boolean f818wy;
    private long zzczk;

    private static final class zza extends Drawable {

        /* JADX INFO: renamed from: wR */
        private static final zza f819wR = new zza();

        /* JADX INFO: renamed from: wS */
        private static final C0797zza f820wS = new C0797zza();

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzrf$zza$zza, reason: collision with other inner class name */
        private static final class C0797zza extends Drawable.ConstantState {
            private C0797zza() {
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public int getChangingConfigurations() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public Drawable newDrawable() {
                return zza.f819wR;
            }
        }

        private zza() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable.ConstantState getConstantState() {
            return f820wS;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    static final class zzb extends Drawable.ConstantState {

        /* JADX INFO: renamed from: wT */
        int f821wT;

        /* JADX INFO: renamed from: wU */
        int f822wU;

        zzb(zzb zzbVar) {
            if (zzbVar != null) {
                this.f821wT = zzbVar.f821wT;
                this.f822wU = zzbVar.f822wU;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f821wT;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new zzrf(this);
        }
    }

    public zzrf(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zza.f819wR : drawable;
        this.f812wL = drawable;
        drawable.setCallback(this);
        this.f811wK.f822wU |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? zza.f819wR : drawable2;
        this.f813wM = drawable2;
        drawable2.setCallback(this);
        this.f811wK.f822wU |= drawable2.getChangingConfigurations();
    }

    zzrf(zzb zzbVar) {
        this.f805wE = 0;
        this.f807wG = 255;
        this.f809wI = 0;
        this.f818wy = true;
        this.f811wK = new zzb(zzbVar);
    }

    public boolean canConstantState() {
        if (!this.f814wN) {
            this.f815wO = (this.f812wL.getConstantState() == null || this.f813wM.getConstantState() == null) ? false : true;
            this.f814wN = true;
        }
        return this.f815wO;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        boolean z2 = false;
        switch (this.f805wE) {
            case 1:
                this.zzczk = SystemClock.uptimeMillis();
                this.f805wE = 2;
                break;
            case 2:
                if (this.zzczk >= 0) {
                    float fUptimeMillis = (SystemClock.uptimeMillis() - this.zzczk) / this.f808wH;
                    z = fUptimeMillis >= 1.0f;
                    if (z) {
                        this.f805wE = 0;
                    }
                    this.f809wI = (int) ((Math.min(fUptimeMillis, 1.0f) * (this.f806wF + 0)) + 0.0f);
                    break;
                }
            default:
                z2 = z;
                break;
        }
        int i = this.f809wI;
        boolean z3 = this.f818wy;
        Drawable drawable = this.f812wL;
        Drawable drawable2 = this.f813wM;
        if (z2) {
            if (!z3 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.f807wG) {
                drawable2.setAlpha(this.f807wG);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.f807wG - i);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.f807wG);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f807wG);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f811wK.f821wT | this.f811wK.f822wU;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.f811wK.f821wT = getChangingConfigurations();
        return this.f811wK;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f812wL.getIntrinsicHeight(), this.f813wM.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f812wL.getIntrinsicWidth(), this.f813wM.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (!this.f816wP) {
            this.f817wQ = Drawable.resolveOpacity(this.f812wL.getOpacity(), this.f813wM.getOpacity());
            this.f816wP = true;
        }
        return this.f817wQ;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    @TargetApi(11)
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback;
        if (!com.google.android.gms.common.util.zzs.zzavj() || (callback = getCallback()) == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f810wJ && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.f812wL.mutate();
            this.f813wM.mutate();
            this.f810wJ = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f812wL.setBounds(rect);
        this.f813wM.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    @TargetApi(11)
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback;
        if (!com.google.android.gms.common.util.zzs.zzavj() || (callback = getCallback()) == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f809wI == this.f807wG) {
            this.f809wI = i;
        }
        this.f807wG = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f812wL.setColorFilter(colorFilter);
        this.f813wM.setColorFilter(colorFilter);
    }

    public void startTransition(int i) {
        this.mFrom = 0;
        this.f806wF = this.f807wG;
        this.f809wI = 0;
        this.f808wH = i;
        this.f805wE = 1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    @TargetApi(11)
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback;
        if (!com.google.android.gms.common.util.zzs.zzavj() || (callback = getCallback()) == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public Drawable zzarm() {
        return this.f813wM;
    }
}
