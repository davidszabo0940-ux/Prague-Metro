package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class FMODAudioDevice implements Runnable {

    /* JADX INFO: renamed from: h */
    private static int f1102h = 0;

    /* JADX INFO: renamed from: i */
    private static int f1103i = 1;

    /* JADX INFO: renamed from: j */
    private static int f1104j = 2;

    /* JADX INFO: renamed from: k */
    private static int f1105k = 3;

    /* JADX INFO: renamed from: a */
    private volatile Thread f1106a = null;

    /* JADX INFO: renamed from: b */
    private volatile boolean f1107b = false;

    /* JADX INFO: renamed from: c */
    private AudioTrack f1108c = null;

    /* JADX INFO: renamed from: d */
    private boolean f1109d = false;

    /* JADX INFO: renamed from: e */
    private ByteBuffer f1110e = null;

    /* JADX INFO: renamed from: f */
    private byte[] f1111f = null;

    /* JADX INFO: renamed from: g */
    private volatile RunnableC0712a f1112g;

    private native int fmodGetInfo(int i);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        if (this.f1108c != null) {
            if (this.f1108c.getState() == 1) {
                this.f1108c.stop();
            }
            this.f1108c.release();
            this.f1108c = null;
        }
        this.f1110e = null;
        this.f1111f = null;
        this.f1109d = false;
    }

    public synchronized void close() {
        stop();
    }

    native int fmodProcessMicData(ByteBuffer byteBuffer, int i);

    public boolean isRunning() {
        return this.f1106a != null && this.f1106a.isAlive();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 3;
        while (this.f1107b) {
            if (this.f1109d || i <= 0) {
                i = i;
            } else {
                releaseAudioTrack();
                int iFmodGetInfo = fmodGetInfo(f1102h);
                int iRound = Math.round(AudioTrack.getMinBufferSize(iFmodGetInfo, 3, 2) * 1.1f) & (-4);
                int iFmodGetInfo2 = fmodGetInfo(f1103i);
                int iFmodGetInfo3 = fmodGetInfo(f1104j);
                if (iFmodGetInfo2 * iFmodGetInfo3 * 4 > iRound) {
                    iRound = iFmodGetInfo3 * iFmodGetInfo2 * 4;
                }
                this.f1108c = new AudioTrack(3, iFmodGetInfo, 3, 2, iRound, 1);
                this.f1109d = this.f1108c.getState() == 1;
                if (this.f1109d) {
                    this.f1110e = ByteBuffer.allocateDirect(iFmodGetInfo2 * 2 * 2);
                    this.f1111f = new byte[this.f1110e.capacity()];
                    this.f1108c.play();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.f1108c.getState() + ")");
                    releaseAudioTrack();
                    i--;
                }
            }
            if (this.f1109d) {
                if (fmodGetInfo(f1105k) == 1) {
                    fmodProcess(this.f1110e);
                    this.f1110e.get(this.f1111f, 0, this.f1110e.capacity());
                    this.f1108c.write(this.f1111f, 0, this.f1110e.capacity());
                    this.f1110e.position(0);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.f1106a != null) {
            stop();
        }
        this.f1106a = new Thread(this, "FMODAudioDevice");
        this.f1106a.setPriority(10);
        this.f1107b = true;
        this.f1106a.start();
        if (this.f1112g != null) {
            this.f1112g.m242b();
        }
    }

    public synchronized int startAudioRecord(int i, int i2, int i3) {
        if (this.f1112g == null) {
            this.f1112g = new RunnableC0712a(this, i, i2);
            this.f1112g.m242b();
        }
        return this.f1112g.m241a();
    }

    public synchronized void stop() {
        while (this.f1106a != null) {
            this.f1107b = false;
            try {
                this.f1106a.join();
                this.f1106a = null;
            } catch (InterruptedException e) {
            }
        }
        if (this.f1112g != null) {
            this.f1112g.m243c();
        }
    }

    public synchronized void stopAudioRecord() {
        if (this.f1112g != null) {
            this.f1112g.m243c();
            this.f1112g = null;
        }
    }
}
