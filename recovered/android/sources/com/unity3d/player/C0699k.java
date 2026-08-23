package com.unity3d.player;

import android.app.Presentation;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* JADX INFO: renamed from: com.unity3d.player.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0699k implements InterfaceC0695g {

    /* JADX INFO: renamed from: a */
    private Object f1010a = new Object[0];

    /* JADX INFO: renamed from: b */
    private Presentation f1011b;

    /* JADX INFO: renamed from: c */
    private DisplayManager.DisplayListener f1012c;

    /* JADX INFO: renamed from: com.unity3d.player.k$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Context f1015a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Display f1016b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ UnityPlayer f1017c;

        AnonymousClass2(Context context, Display display, UnityPlayer unityPlayer) {
            this.f1015a = context;
            this.f1016b = display;
            this.f1017c = unityPlayer;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (C0699k.this.f1010a) {
                if (C0699k.this.f1011b != null) {
                    C0699k.this.f1011b.dismiss();
                }
                C0699k.this.f1011b = new Presentation(this.f1015a, this.f1016b) { // from class: com.unity3d.player.k.2.1
                    @Override // android.app.Dialog
                    protected final void onCreate(Bundle bundle) {
                        SurfaceView surfaceView = new SurfaceView(AnonymousClass2.this.f1015a);
                        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.unity3d.player.k.2.1.1
                            @Override // android.view.SurfaceHolder.Callback
                            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                                AnonymousClass2.this.f1017c.displayChanged(1, surfaceHolder.getSurface());
                            }

                            @Override // android.view.SurfaceHolder.Callback
                            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                                AnonymousClass2.this.f1017c.displayChanged(1, surfaceHolder.getSurface());
                            }

                            @Override // android.view.SurfaceHolder.Callback
                            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                                AnonymousClass2.this.f1017c.displayChanged(1, null);
                            }
                        });
                        setContentView(surfaceView);
                    }

                    @Override // android.app.Presentation
                    public final void onDisplayRemoved() {
                        dismiss();
                        synchronized (C0699k.this.f1010a) {
                            C0699k.this.f1011b = null;
                        }
                    }
                };
                C0699k.this.f1011b.show();
            }
        }
    }

    @Override // com.unity3d.player.InterfaceC0695g
    /* JADX INFO: renamed from: a */
    public final void mo178a(Context context) {
        DisplayManager displayManager;
        if (this.f1012c == null || (displayManager = (DisplayManager) context.getSystemService("display")) == null) {
            return;
        }
        displayManager.unregisterDisplayListener(this.f1012c);
    }

    @Override // com.unity3d.player.InterfaceC0695g
    /* JADX INFO: renamed from: a */
    public final void mo179a(final UnityPlayer unityPlayer, Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return;
        }
        displayManager.registerDisplayListener(new DisplayManager.DisplayListener() { // from class: com.unity3d.player.k.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public final void onDisplayAdded(int i) {
                unityPlayer.displayChanged(-1, null);
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public final void onDisplayChanged(int i) {
                unityPlayer.displayChanged(-1, null);
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public final void onDisplayRemoved(int i) {
                unityPlayer.displayChanged(-1, null);
            }
        }, null);
    }

    @Override // com.unity3d.player.InterfaceC0695g
    /* JADX INFO: renamed from: a */
    public final boolean mo180a(UnityPlayer unityPlayer, Context context, int i) {
        Display display;
        synchronized (this.f1010a) {
            if (this.f1011b != null && this.f1011b.isShowing() && (display = this.f1011b.getDisplay()) != null && display.getDisplayId() == i) {
                return true;
            }
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager == null) {
                return false;
            }
            Display display2 = displayManager.getDisplay(i);
            if (display2 == null) {
                return false;
            }
            unityPlayer.m146b(new AnonymousClass2(context, display2, unityPlayer));
            return true;
        }
    }
}
