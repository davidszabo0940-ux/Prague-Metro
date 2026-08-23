package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: org.fmod.a */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0712a implements Runnable {

    /* JADX INFO: renamed from: a */
    private final FMODAudioDevice f1113a;

    /* JADX INFO: renamed from: b */
    private final ByteBuffer f1114b;

    /* JADX INFO: renamed from: c */
    private final int f1115c;

    /* JADX INFO: renamed from: d */
    private final int f1116d;

    /* JADX INFO: renamed from: e */
    private final int f1117e = 2;

    /* JADX INFO: renamed from: f */
    private volatile Thread f1118f;

    /* JADX INFO: renamed from: g */
    private volatile boolean f1119g;

    /* JADX INFO: renamed from: h */
    private AudioRecord f1120h;

    /* JADX INFO: renamed from: i */
    private boolean f1121i;

    RunnableC0712a(FMODAudioDevice fMODAudioDevice, int i, int i2) {
        this.f1113a = fMODAudioDevice;
        this.f1115c = i;
        this.f1116d = i2;
        this.f1114b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i, i2, 2));
    }

    /* JADX INFO: renamed from: d */
    private void m240d() {
        if (this.f1120h != null) {
            if (this.f1120h.getState() == 1) {
                this.f1120h.stop();
            }
            this.f1120h.release();
            this.f1120h = null;
        }
        this.f1114b.position(0);
        this.f1121i = false;
    }

    /* JADX INFO: renamed from: a */
    public final int m241a() {
        return this.f1114b.capacity();
    }

    /* JADX INFO: renamed from: b */
    public final void m242b() {
        if (this.f1118f != null) {
            m243c();
        }
        this.f1119g = true;
        this.f1118f = new Thread(this);
        this.f1118f.start();
    }

    /* JADX INFO: renamed from: c */
    public final void m243c() {
        while (this.f1118f != null) {
            this.f1119g = false;
            try {
                this.f1118f.join();
                this.f1118f = null;
            } catch (InterruptedException e) {
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 3;
        while (this.f1119g) {
            if (this.f1121i || i <= 0) {
                i = i;
            } else {
                m240d();
                this.f1120h = new AudioRecord(1, this.f1115c, this.f1116d, this.f1117e, this.f1114b.capacity());
                this.f1121i = this.f1120h.getState() == 1;
                if (this.f1121i) {
                    this.f1114b.position(0);
                    this.f1120h.startRecording();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioRecord failed to initialize (status " + this.f1120h.getState() + ")");
                    i--;
                    m240d();
                    i = i;
                }
            }
            if (this.f1121i && this.f1120h.getRecordingState() == 3) {
                this.f1113a.fmodProcessMicData(this.f1114b, this.f1120h.read(this.f1114b, this.f1114b.capacity()));
                this.f1114b.position(0);
            }
        }
        m240d();
    }
}
