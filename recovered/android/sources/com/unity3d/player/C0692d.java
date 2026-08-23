package com.unity3d.player;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.view.View;

/* JADX INFO: renamed from: com.unity3d.player.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0692d implements InterfaceC0694f {

    /* JADX INFO: renamed from: a */
    private static final SurfaceTexture f1003a = new SurfaceTexture(-1);

    /* JADX INFO: renamed from: b */
    private static final int f1004b;

    /* JADX INFO: renamed from: c */
    private volatile boolean f1005c;

    static {
        f1004b = C0705q.f1042f ? 5894 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m171a(final View view, int i) {
        Handler handler = view.getHandler();
        if (handler == null) {
            mo175a(view, this.f1005c);
        } else {
            handler.postDelayed(new Runnable() { // from class: com.unity3d.player.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    C0692d.this.mo175a(view, C0692d.this.f1005c);
                }
            }, 1000L);
        }
    }

    @Override // com.unity3d.player.InterfaceC0694f
    /* JADX INFO: renamed from: a */
    public final void mo174a(final View view) {
        if (C0705q.f1043g) {
            return;
        }
        view.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.unity3d.player.d.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                C0692d.this.m171a(view, 1000);
            }
        });
    }

    @Override // com.unity3d.player.InterfaceC0694f
    /* JADX INFO: renamed from: a */
    public final void mo175a(View view, boolean z) {
        this.f1005c = z;
        view.setSystemUiVisibility(this.f1005c ? view.getSystemUiVisibility() | f1004b : view.getSystemUiVisibility() & (f1004b ^ (-1)));
    }

    @Override // com.unity3d.player.InterfaceC0694f
    /* JADX INFO: renamed from: a */
    public final boolean mo176a(Camera camera) {
        try {
            camera.setPreviewTexture(f1003a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.unity3d.player.InterfaceC0694f
    /* JADX INFO: renamed from: b */
    public final void mo177b(View view) {
        if (!C0705q.f1042f && this.f1005c) {
            mo175a(view, false);
            this.f1005c = true;
        }
        m171a(view, 1000);
    }
}
