package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0228R;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public final class zzag extends Button {
    public zzag(Context context) {
        this(context, null);
    }

    public zzag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyle);
    }

    private void zza(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private void zza(Resources resources, int i, int i2, boolean z) {
        setBackgroundDrawable(resources.getDrawable(z ? zzd(i, zzg(i2, C0228R.drawable.common_plus_signin_btn_icon_dark, C0228R.drawable.common_plus_signin_btn_icon_light, C0228R.drawable.common_plus_signin_btn_icon_dark), zzg(i2, C0228R.drawable.common_plus_signin_btn_text_dark, C0228R.drawable.common_plus_signin_btn_text_light, C0228R.drawable.common_plus_signin_btn_text_dark)) : zzd(i, zzg(i2, C0228R.drawable.common_google_signin_btn_icon_dark, C0228R.drawable.common_google_signin_btn_icon_light, C0228R.drawable.common_google_signin_btn_icon_light), zzg(i2, C0228R.drawable.common_google_signin_btn_text_dark, C0228R.drawable.common_google_signin_btn_text_light, C0228R.drawable.common_google_signin_btn_text_light))));
    }

    private boolean zza(Scope[] scopeArr) {
        if (scopeArr == null) {
            return false;
        }
        for (Scope scope : scopeArr) {
            String strZzaoh = scope.zzaoh();
            int i = ((!strZzaoh.contains("/plus.") || strZzaoh.equals(Scopes.PLUS_ME)) && !strZzaoh.equals(Scopes.GAMES)) ? i + 1 : 0;
            return true;
        }
        return false;
    }

    private void zzb(Resources resources, int i, int i2, boolean z) {
        setTextColor((ColorStateList) zzab.zzaa(resources.getColorStateList(z ? zzg(i2, C0228R.color.common_plus_signin_btn_text_dark, C0228R.color.common_plus_signin_btn_text_light, C0228R.color.common_plus_signin_btn_text_dark) : zzg(i2, C0228R.color.common_google_signin_btn_text_dark, C0228R.color.common_google_signin_btn_text_light, C0228R.color.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                setText(resources.getString(C0228R.string.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(C0228R.string.common_signin_button_text_long));
                break;
            case 2:
                setText((CharSequence) null);
                break;
            default:
                throw new IllegalStateException(new StringBuilder(32).append("Unknown button size: ").append(i).toString());
        }
        setTransformationMethod(null);
    }

    private int zzd(int i, int i2, int i3) {
        switch (i) {
            case 0:
            case 1:
                return i3;
            case 2:
                return i2;
            default:
                throw new IllegalStateException(new StringBuilder(32).append("Unknown button size: ").append(i).toString());
        }
    }

    private int zzg(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case 2:
                return i4;
            default:
                throw new IllegalStateException(new StringBuilder(33).append("Unknown color scheme: ").append(i).toString());
        }
    }

    public void zza(Resources resources, int i, int i2, Scope[] scopeArr) {
        boolean zZza = zza(scopeArr);
        zza(resources);
        zza(resources, i, i2, zZza);
        zzb(resources, i, i2, zZza);
    }
}
