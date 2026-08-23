package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
@zzir
public class zzii extends zzih {
    private Object zzbyn;
    private PopupWindow zzbyo;
    private boolean zzbyp;

    zzii(Context context, zzjy.zza zzaVar, zzll zzllVar, zzig.zza zzaVar2) {
        super(context, zzaVar, zzllVar, zzaVar2);
        this.zzbyn = new Object();
        this.zzbyp = false;
    }

    private void zzqf() {
        synchronized (this.zzbyn) {
            this.zzbyp = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzbyo = null;
            }
            if (this.zzbyo != null) {
                if (this.zzbyo.isShowing()) {
                    this.zzbyo.dismiss();
                }
                this.zzbyo = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzic, com.google.android.gms.internal.zzkn
    public void cancel() {
        zzqf();
        super.cancel();
    }

    @Override // com.google.android.gms.internal.zzic
    protected void zzaj(int i) {
        zzqf();
        super.zzaj(i);
    }

    @Override // com.google.android.gms.internal.zzih
    protected void zzqe() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) this.mContext).isDestroyed()) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(this.zzbgj.getView(), -1, -1);
        synchronized (this.zzbyn) {
            if (this.zzbyp) {
                return;
            }
            this.zzbyo = new PopupWindow((View) frameLayout, 1, 1, false);
            this.zzbyo.setOutsideTouchable(true);
            this.zzbyo.setClippingEnabled(false);
            zzkh.zzcw("Displaying the 1x1 popup off the screen.");
            try {
                this.zzbyo.showAtLocation(window.getDecorView(), 0, -1, -1);
            } catch (Exception e) {
                this.zzbyo = null;
            }
        }
    }
}
