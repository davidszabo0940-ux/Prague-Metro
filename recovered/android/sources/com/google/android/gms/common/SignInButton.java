package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0228R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.dynamic.zzg;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;

    /* JADX INFO: renamed from: ro */
    private Scope[] f110ro;

    /* JADX INFO: renamed from: rp */
    private View f111rp;

    /* JADX INFO: renamed from: rq */
    private View.OnClickListener f112rq;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f112rq = null;
        zza(context, attributeSet);
        setStyle(this.mSize, this.mColor, this.f110ro);
    }

    private static Button zza(Context context, int i, int i2, Scope[] scopeArr) {
        zzag zzagVar = new zzag(context);
        zzagVar.zza(context.getResources(), i, i2, scopeArr);
        return zzagVar;
    }

    private void zza(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C0228R.styleable.SignInButton, 0, 0);
        try {
            this.mSize = typedArrayObtainStyledAttributes.getInt(C0228R.styleable.SignInButton_buttonSize, 0);
            this.mColor = typedArrayObtainStyledAttributes.getInt(C0228R.styleable.SignInButton_colorScheme, 2);
            String string = typedArrayObtainStyledAttributes.getString(C0228R.styleable.SignInButton_scopeUris);
            if (string == null) {
                this.f110ro = null;
            } else {
                String[] strArrSplit = string.trim().split("\\s+");
                this.f110ro = new Scope[strArrSplit.length];
                for (int i = 0; i < strArrSplit.length; i++) {
                    this.f110ro[i] = new Scope(strArrSplit[i].toString());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void zzca(Context context) {
        if (this.f111rp != null) {
            removeView(this.f111rp);
        }
        try {
            this.f111rp = zzaf.zzb(context, this.mSize, this.mColor, this.f110ro);
        } catch (zzg.zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.f111rp = zza(context, this.mSize, this.mColor, this.f110ro);
        }
        addView(this.f111rp);
        this.f111rp.setEnabled(isEnabled());
        this.f111rp.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f112rq == null || view != this.f111rp) {
            return;
        }
        this.f112rq.onClick(this);
    }

    public void setColorScheme(int i) {
        setStyle(this.mSize, i, this.f110ro);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f111rp.setEnabled(z);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f112rq = onClickListener;
        if (this.f111rp != null) {
            this.f111rp.setOnClickListener(this);
        }
    }

    public void setScopes(Scope[] scopeArr) {
        setStyle(this.mSize, this.mColor, scopeArr);
    }

    public void setSize(int i) {
        setStyle(i, this.mColor, this.f110ro);
    }

    public void setStyle(int i, int i2) {
        setStyle(i, i2, this.f110ro);
    }

    public void setStyle(int i, int i2, Scope[] scopeArr) {
        this.mSize = i;
        this.mColor = i2;
        this.f110ro = scopeArr;
        zzca(getContext());
    }
}
