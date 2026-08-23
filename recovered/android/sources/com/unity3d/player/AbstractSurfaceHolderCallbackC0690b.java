package com.unity3d.player;

import android.app.Activity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* JADX INFO: renamed from: com.unity3d.player.b */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractSurfaceHolderCallbackC0690b implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a */
    private final Activity f998a = (Activity) C0708t.f1065a.m220a();

    /* JADX INFO: renamed from: b */
    private final int f999b = 3;

    /* JADX INFO: renamed from: c */
    private SurfaceView f1000c;

    AbstractSurfaceHolderCallbackC0690b(int i) {
    }

    /* JADX INFO: renamed from: a */
    final void m168a() {
        this.f998a.runOnUiThread(new Runnable() { // from class: com.unity3d.player.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (AbstractSurfaceHolderCallbackC0690b.this.f1000c == null) {
                    AbstractSurfaceHolderCallbackC0690b.this.f1000c = new SurfaceView(C0708t.f1065a.m220a());
                    AbstractSurfaceHolderCallbackC0690b.this.f1000c.getHolder().setType(AbstractSurfaceHolderCallbackC0690b.this.f999b);
                    AbstractSurfaceHolderCallbackC0690b.this.f1000c.getHolder().addCallback(AbstractSurfaceHolderCallbackC0690b.this);
                    C0708t.f1065a.m221a(AbstractSurfaceHolderCallbackC0690b.this.f1000c);
                    AbstractSurfaceHolderCallbackC0690b.this.f1000c.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: renamed from: b */
    final void m169b() {
        this.f998a.runOnUiThread(new Runnable() { // from class: com.unity3d.player.b.2
            @Override // java.lang.Runnable
            public final void run() {
                if (AbstractSurfaceHolderCallbackC0690b.this.f1000c != null) {
                    C0708t.f1065a.m222b(AbstractSurfaceHolderCallbackC0690b.this.f1000c);
                }
                AbstractSurfaceHolderCallbackC0690b.this.f1000c = null;
            }
        });
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
