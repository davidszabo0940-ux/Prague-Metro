package com.unity3d.player;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.unity3d.player.a */
/* JADX INFO: loaded from: classes.dex */
final class C0689a {

    /* JADX INFO: renamed from: a */
    Camera f982a;

    /* JADX INFO: renamed from: b */
    Camera.Parameters f983b;

    /* JADX INFO: renamed from: c */
    Camera.Size f984c;

    /* JADX INFO: renamed from: d */
    int f985d;

    /* JADX INFO: renamed from: e */
    int[] f986e;

    /* JADX INFO: renamed from: f */
    AbstractSurfaceHolderCallbackC0690b f987f;

    /* JADX INFO: renamed from: g */
    private final Object[] f988g = new Object[0];

    /* JADX INFO: renamed from: h */
    private final int f989h;

    /* JADX INFO: renamed from: i */
    private final int f990i;

    /* JADX INFO: renamed from: j */
    private final int f991j;

    /* JADX INFO: renamed from: k */
    private final int f992k;

    /* JADX INFO: renamed from: com.unity3d.player.a$a */
    interface a {
        void onCameraFrame(C0689a c0689a, byte[] bArr);
    }

    public C0689a(int i, int i2, int i3, int i4) {
        this.f989h = i;
        this.f990i = m153a(i2, 640);
        this.f991j = m153a(i3, 480);
        this.f992k = m153a(i4, 24);
    }

    /* JADX INFO: renamed from: a */
    private static final int m153a(int i, int i2) {
        return i != 0 ? i : i2;
    }

    /* JADX INFO: renamed from: a */
    private static void m154a(Camera.Parameters parameters) {
        if (parameters.getSupportedColorEffects() != null) {
            parameters.setColorEffect("none");
        }
        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
    }

    /* JADX INFO: renamed from: b */
    private void m156b(final a aVar) {
        synchronized (this.f988g) {
            this.f982a = Camera.open(this.f989h);
            this.f983b = this.f982a.getParameters();
            this.f984c = m159f();
            this.f986e = m158e();
            this.f985d = m157d();
            m154a(this.f983b);
            this.f983b.setPreviewSize(this.f984c.width, this.f984c.height);
            this.f983b.setPreviewFpsRange(this.f986e[0], this.f986e[1]);
            this.f982a.setParameters(this.f983b);
            Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.unity3d.player.a.1

                /* JADX INFO: renamed from: a */
                long f993a = 0;

                @Override // android.hardware.Camera.PreviewCallback
                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    if (C0689a.this.f982a != camera) {
                        return;
                    }
                    aVar.onCameraFrame(C0689a.this, bArr);
                }
            };
            int i = (((this.f984c.width * this.f984c.height) * this.f985d) / 8) + 4096;
            this.f982a.addCallbackBuffer(new byte[i]);
            this.f982a.addCallbackBuffer(new byte[i]);
            this.f982a.setPreviewCallbackWithBuffer(previewCallback);
        }
    }

    /* JADX INFO: renamed from: d */
    private final int m157d() {
        this.f983b.setPreviewFormat(17);
        return ImageFormat.getBitsPerPixel(17);
    }

    /* JADX INFO: renamed from: e */
    private final int[] m158e() {
        int[] iArr;
        double d;
        double d2 = this.f992k * 1000;
        List<int[]> supportedPreviewFpsRange = this.f983b.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange == null) {
            supportedPreviewFpsRange = new ArrayList<>();
        }
        int[] iArr2 = {this.f992k * 1000, this.f992k * 1000};
        double d3 = Double.MAX_VALUE;
        for (int[] iArr3 : supportedPreviewFpsRange) {
            double dAbs = Math.abs(Math.log(d2 / ((double) iArr3[0]))) + Math.abs(Math.log(d2 / ((double) iArr3[1])));
            if (dAbs < d3) {
                iArr = iArr3;
                d = dAbs;
            } else {
                double d4 = d3;
                iArr = iArr2;
                d = d4;
            }
            iArr2 = iArr;
            d3 = d;
        }
        return iArr2;
    }

    /* JADX INFO: renamed from: f */
    private final Camera.Size m159f() {
        Camera.Size size;
        double d;
        double d2 = this.f990i;
        double d3 = this.f991j;
        Camera.Size size2 = null;
        double d4 = Double.MAX_VALUE;
        for (Camera.Size size3 : this.f983b.getSupportedPreviewSizes()) {
            double dAbs = Math.abs(Math.log(d2 / ((double) size3.width))) + Math.abs(Math.log(d3 / ((double) size3.height)));
            if (dAbs < d4) {
                size = size3;
                d = dAbs;
            } else {
                size = size2;
                d = d4;
            }
            d4 = d;
            size2 = size;
        }
        return size2;
    }

    /* JADX INFO: renamed from: a */
    public final int m160a() {
        return this.f989h;
    }

    /* JADX INFO: renamed from: a */
    public final void m161a(a aVar) {
        synchronized (this.f988g) {
            if (this.f982a == null) {
                m156b(aVar);
            }
            if (C0705q.f1037a && C0705q.f1045i.mo176a(this.f982a)) {
                this.f982a.startPreview();
                return;
            }
            if (this.f987f == null) {
                this.f987f = new AbstractSurfaceHolderCallbackC0690b() { // from class: com.unity3d.player.a.2

                    /* JADX INFO: renamed from: a */
                    Camera f996a;

                    {
                        this.f996a = C0689a.this.f982a;
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                        synchronized (C0689a.this.f988g) {
                            if (C0689a.this.f982a != this.f996a) {
                                return;
                            }
                            try {
                                C0689a.this.f982a.setPreviewDisplay(surfaceHolder);
                                C0689a.this.f982a.startPreview();
                            } catch (Exception e) {
                                C0701m.Log(6, "Unable to initialize webcam data stream: " + e.getMessage());
                            }
                        }
                    }

                    @Override // com.unity3d.player.AbstractSurfaceHolderCallbackC0690b, android.view.SurfaceHolder.Callback
                    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                        synchronized (C0689a.this.f988g) {
                            if (C0689a.this.f982a != this.f996a) {
                                return;
                            }
                            C0689a.this.f982a.stopPreview();
                        }
                    }
                };
                this.f987f.m168a();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m162a(byte[] bArr) {
        synchronized (this.f988g) {
            if (this.f982a != null) {
                this.f982a.addCallbackBuffer(bArr);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final Camera.Size m163b() {
        return this.f984c;
    }

    /* JADX INFO: renamed from: c */
    public final void m164c() {
        synchronized (this.f988g) {
            if (this.f982a != null) {
                this.f982a.setPreviewCallbackWithBuffer(null);
                this.f982a.stopPreview();
                this.f982a.release();
                this.f982a = null;
            }
            if (this.f987f != null) {
                this.f987f.m169b();
                this.f987f = null;
            }
        }
    }
}
