package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzo extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzbuk;
    private final zzu zzbul;

    public zzo(Context context, int i, zzu zzuVar) {
        super(context);
        this.zzbul = zzuVar;
        setOnClickListener(this);
        this.zzbuk = new ImageButton(context);
        this.zzbuk.setImageResource(R.drawable.btn_dialog);
        this.zzbuk.setBackgroundColor(0);
        this.zzbuk.setOnClickListener(this);
        this.zzbuk.setPadding(0, 0, 0, 0);
        this.zzbuk.setContentDescription("Interstitial close button");
        int iZza = com.google.android.gms.ads.internal.client.zzm.zziw().zza(context, i);
        addView(this.zzbuk, new FrameLayout.LayoutParams(iZza, iZza, 17));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.zzbul != null) {
            this.zzbul.zznx();
        }
    }

    public void zza(boolean z, boolean z2) {
        if (!z2) {
            this.zzbuk.setVisibility(0);
        } else if (z) {
            this.zzbuk.setVisibility(4);
        } else {
            this.zzbuk.setVisibility(8);
        }
    }
}
