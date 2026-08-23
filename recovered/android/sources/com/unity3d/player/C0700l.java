package com.unity3d.player;

import android.view.Choreographer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: com.unity3d.player.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0700l implements InterfaceC0696h {

    /* JADX INFO: renamed from: c */
    private Choreographer.FrameCallback f1023c;

    /* JADX INFO: renamed from: a */
    private Choreographer f1021a = null;

    /* JADX INFO: renamed from: b */
    private long f1022b = 0;

    /* JADX INFO: renamed from: d */
    private Lock f1024d = new ReentrantLock();

    @Override // com.unity3d.player.InterfaceC0696h
    /* JADX INFO: renamed from: a */
    public final void mo181a() {
        this.f1024d.lock();
        if (this.f1021a != null) {
            this.f1021a.removeFrameCallback(this.f1023c);
        }
        this.f1021a = null;
        this.f1024d.unlock();
    }

    @Override // com.unity3d.player.InterfaceC0696h
    /* JADX INFO: renamed from: a */
    public final void mo182a(final UnityPlayer unityPlayer) {
        this.f1024d.lock();
        if (this.f1021a == null) {
            this.f1021a = Choreographer.getInstance();
            if (this.f1021a != null) {
                C0701m.Log(4, "Choreographer available: Enabling VSYNC timing");
                this.f1023c = new Choreographer.FrameCallback() { // from class: com.unity3d.player.l.1
                    @Override // android.view.Choreographer.FrameCallback
                    public final void doFrame(long j) {
                        UnityPlayer.lockNativeAccess();
                        if (C0710v.m228c()) {
                            unityPlayer.nativeAddVSyncTime(j);
                        }
                        UnityPlayer.unlockNativeAccess();
                        C0700l.this.f1024d.lock();
                        if (C0700l.this.f1021a != null) {
                            C0700l.this.f1021a.postFrameCallback(C0700l.this.f1023c);
                        }
                        C0700l.this.f1024d.unlock();
                    }
                };
                this.f1021a.postFrameCallback(this.f1023c);
            }
        }
        this.f1024d.unlock();
    }
}
