package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzir;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzb extends RelativeLayout {
    private static final float[] zzbff = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private final RelativeLayout zzbfg;
    private AnimationDrawable zzbfh;

    public zzb(Context context, zza zzaVar) {
        super(context);
        zzab.zzaa(zzaVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (zzaVar.zzkt()) {
            case 0:
                layoutParams.addRule(10);
                layoutParams.addRule(9);
                break;
            case 1:
            default:
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                break;
            case 2:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            case 3:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzbff, null, null));
        shapeDrawable.getPaint().setColor(zzaVar.getBackgroundColor());
        this.zzbfg = new RelativeLayout(context);
        this.zzbfg.setLayoutParams(layoutParams);
        zzu.zzfs().zza(this.zzbfg, shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzaVar.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzaVar.getText());
            textView.setTextColor(zzaVar.getTextColor());
            textView.setTextSize(zzaVar.getTextSize());
            textView.setPadding(zzm.zziw().zza(context, 4), 0, zzm.zziw().zza(context, 4), 0);
            this.zzbfg.addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<Drawable> listZzkr = zzaVar.zzkr();
        if (listZzkr.size() > 1) {
            this.zzbfh = new AnimationDrawable();
            Iterator<Drawable> it = listZzkr.iterator();
            while (it.hasNext()) {
                this.zzbfh.addFrame(it.next(), zzaVar.zzks());
            }
            zzu.zzfs().zza(imageView, this.zzbfh);
        } else if (listZzkr.size() == 1) {
            imageView.setImageDrawable(listZzkr.get(0));
        }
        this.zzbfg.addView(imageView);
        addView(this.zzbfg);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        if (this.zzbfh != null) {
            this.zzbfh.start();
        }
        super.onAttachedToWindow();
    }

    public ViewGroup zzku() {
        return this.zzbfg;
    }
}
