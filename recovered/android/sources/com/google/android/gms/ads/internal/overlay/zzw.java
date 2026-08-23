package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
@zzir
public class zzw extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzv.zza {
    private static final float[] zzbuv = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private int zzaie;
    private int zzaif;
    private final float[] zzbur;
    private final zzv zzbuw;
    private final float[] zzbux;
    private final float[] zzbuy;
    private final float[] zzbuz;
    private final float[] zzbva;
    private final float[] zzbvb;
    private final float[] zzbvc;
    private float zzbvd;
    private float zzbve;
    private float zzbvf;
    private SurfaceTexture zzbvg;
    private SurfaceTexture zzbvh;
    private int zzbvi;
    private int zzbvj;
    private int zzbvk;
    private FloatBuffer zzbvl;
    private final CountDownLatch zzbvm;
    private final Object zzbvn;
    private EGL10 zzbvo;
    private EGLDisplay zzbvp;
    private EGLContext zzbvq;
    private EGLSurface zzbvr;
    private volatile boolean zzbvs;
    private volatile boolean zzbvt;

    zzw(Context context) {
        super("SphericalVideoProcessor");
        this.zzbvl = ByteBuffer.allocateDirect(zzbuv.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzbvl.put(zzbuv).position(0);
        this.zzbur = new float[9];
        this.zzbux = new float[9];
        this.zzbuy = new float[9];
        this.zzbuz = new float[9];
        this.zzbva = new float[9];
        this.zzbvb = new float[9];
        this.zzbvc = new float[9];
        this.zzbvd = Float.NaN;
        this.zzbuw = new zzv(context);
        this.zzbuw.zza(this);
        this.zzbvm = new CountDownLatch(1);
        this.zzbvn = new Object();
    }

    private void zza(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = (float) Math.cos(f);
        fArr[5] = (float) (-Math.sin(f));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(f);
        fArr[8] = (float) Math.cos(f);
    }

    private void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private float[] zza(float[] fArr, float[] fArr2) {
        return new float[]{(fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]), (fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[5] * fArr2[2]), (fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1]) + (fArr[8] * fArr2[2])};
    }

    private void zzb(float[] fArr, float f) {
        fArr[0] = (float) Math.cos(f);
        fArr[1] = (float) (-Math.sin(f));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(f);
        fArr[4] = (float) Math.cos(f);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private void zzby(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            Log.e("SphericalVideoRenderer", new StringBuilder(String.valueOf(str).length() + 21).append(str).append(": glError ").append(iGlGetError).toString());
        }
    }

    private float zzc(float[] fArr) {
        float[] fArrZza = zza(fArr, new float[]{0.0f, 1.0f, 0.0f});
        return ((float) Math.atan2(fArrZza[1], fArrZza[0])) - 1.5707964f;
    }

    private int zzc(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        zzby("createShader");
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            zzby("shaderSource");
            GLES20.glCompileShader(iGlCreateShader);
            zzby("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            zzby("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", new StringBuilder(37).append("Could not compile shader ").append(i).append(":").toString());
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(iGlCreateShader));
                GLES20.glDeleteShader(iGlCreateShader);
                zzby("deleteShader");
                return 0;
            }
        }
        return iGlCreateShader;
    }

    private void zzpb() {
        GLES20.glViewport(0, 0, this.zzaie, this.zzaif);
        zzby("viewport");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.zzbvi, "uFOVx");
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.zzbvi, "uFOVy");
        if (this.zzaie > this.zzaif) {
            GLES20.glUniform1f(iGlGetUniformLocation, 0.87266463f);
            GLES20.glUniform1f(iGlGetUniformLocation2, (this.zzaif * 0.87266463f) / this.zzaie);
        } else {
            GLES20.glUniform1f(iGlGetUniformLocation, (this.zzaie * 0.87266463f) / this.zzaif);
            GLES20.glUniform1f(iGlGetUniformLocation2, 0.87266463f);
        }
    }

    private int zzpd() {
        int iZzc;
        int iZzc2 = zzc(35633, zzpg());
        if (iZzc2 == 0 || (iZzc = zzc(35632, zzph())) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        zzby("createProgram");
        if (iGlCreateProgram != 0) {
            GLES20.glAttachShader(iGlCreateProgram, iZzc2);
            zzby("attachShader");
            GLES20.glAttachShader(iGlCreateProgram, iZzc);
            zzby("attachShader");
            GLES20.glLinkProgram(iGlCreateProgram);
            zzby("linkProgram");
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            zzby("getProgramiv");
            if (iArr[0] != 1) {
                Log.e("SphericalVideoRenderer", "Could not link program: ");
                Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(iGlCreateProgram));
                GLES20.glDeleteProgram(iGlCreateProgram);
                zzby("deleteProgram");
                return 0;
            }
            GLES20.glValidateProgram(iGlCreateProgram);
            zzby("validateProgram");
        }
        return iGlCreateProgram;
    }

    @Nullable
    private EGLConfig zzpf() {
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (this.zzbvo.eglChooseConfig(this.zzbvp, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) && iArr[0] > 0) {
            return eGLConfigArr[0];
        }
        return null;
    }

    private String zzpg() {
        zzcy<String> zzcyVar = zzdc.zzbak;
        return !zzcyVar.get().equals(zzcyVar.zzjw()) ? zzcyVar.get() : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}";
    }

    private String zzph() {
        zzcy<String> zzcyVar = zzdc.zzbal;
        return !zzcyVar.get().equals(zzcyVar.zzjw()) ? zzcyVar.get() : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}";
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzbvk++;
        synchronized (this.zzbvn) {
            this.zzbvn.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.zzbvh == null) {
            zzkh.m14e("SphericalVideoProcessor started with no output texture.");
            this.zzbvm.countDown();
            return;
        }
        boolean zZzpe = zzpe();
        int iZzpc = zzpc();
        boolean z = this.zzbvi != 0;
        if (!zZzpe || !z) {
            String strValueOf = String.valueOf(GLUtils.getEGLErrorString(this.zzbvo.eglGetError()));
            String strConcat = strValueOf.length() != 0 ? "EGL initialization failed: ".concat(strValueOf) : new String("EGL initialization failed: ");
            zzkh.m14e(strConcat);
            com.google.android.gms.ads.internal.zzu.zzft().zzb(new Throwable(strConcat), true);
            zzpi();
            this.zzbvm.countDown();
            return;
        }
        this.zzbvg = new SurfaceTexture(iZzpc);
        this.zzbvg.setOnFrameAvailableListener(this);
        this.zzbvm.countDown();
        this.zzbuw.start();
        try {
            try {
                this.zzbvs = true;
                while (!this.zzbvt) {
                    zzpa();
                    if (this.zzbvs) {
                        zzpb();
                        this.zzbvs = false;
                    }
                    try {
                        synchronized (this.zzbvn) {
                            try {
                                if (!this.zzbvt && !this.zzbvs && this.zzbvk == 0) {
                                    this.zzbvn.wait();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (InterruptedException e) {
                    }
                }
                this.zzbuw.stop();
                this.zzbvg.setOnFrameAvailableListener(null);
                this.zzbvg = null;
                zzpi();
            } catch (Throwable th2) {
                this.zzbuw.stop();
                this.zzbvg.setOnFrameAvailableListener(null);
                this.zzbvg = null;
                zzpi();
                throw th2;
            }
        } catch (IllegalStateException e2) {
            zzkh.zzcy("SphericalVideoProcessor halted unexpectedly.");
            this.zzbuw.stop();
            this.zzbvg.setOnFrameAvailableListener(null);
            this.zzbvg = null;
            zzpi();
        } catch (Throwable th3) {
            zzkh.zzb("SphericalVideoProcessor died.", th3);
            com.google.android.gms.ads.internal.zzu.zzft().zzb(th3, true);
            this.zzbuw.stop();
            this.zzbvg.setOnFrameAvailableListener(null);
            this.zzbvg = null;
            zzpi();
        }
    }

    void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zzaie = i;
        this.zzaif = i2;
        this.zzbvh = surfaceTexture;
    }

    void zzb(float f, float f2) {
        float f3;
        float f4;
        if (this.zzaie > this.zzaif) {
            f3 = (1.7453293f * f) / this.zzaie;
            f4 = (1.7453293f * f2) / this.zzaie;
        } else {
            f3 = (1.7453293f * f) / this.zzaif;
            f4 = (1.7453293f * f2) / this.zzaif;
        }
        this.zzbve -= f3;
        this.zzbvf -= f4;
        if (this.zzbvf < -1.5707964f) {
            this.zzbvf = -1.5707964f;
        }
        if (this.zzbvf > 1.5707964f) {
            this.zzbvf = 1.5707964f;
        }
    }

    void zzg(int i, int i2) {
        synchronized (this.zzbvn) {
            this.zzaie = i;
            this.zzaif = i2;
            this.zzbvs = true;
            this.zzbvn.notifyAll();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzv.zza
    public void zzob() {
        synchronized (this.zzbvn) {
            this.zzbvn.notifyAll();
        }
    }

    void zzoy() {
        synchronized (this.zzbvn) {
            this.zzbvt = true;
            this.zzbvh = null;
            this.zzbvn.notifyAll();
        }
    }

    public SurfaceTexture zzoz() {
        if (this.zzbvh == null) {
            return null;
        }
        try {
            this.zzbvm.await();
        } catch (InterruptedException e) {
        }
        return this.zzbvg;
    }

    void zzpa() {
        while (this.zzbvk > 0) {
            this.zzbvg.updateTexImage();
            this.zzbvk--;
        }
        if (this.zzbuw.zzb(this.zzbur)) {
            if (Float.isNaN(this.zzbvd)) {
                this.zzbvd = -zzc(this.zzbur);
            }
            zzb(this.zzbvb, this.zzbvd + this.zzbve);
        } else {
            zza(this.zzbur, -1.5707964f);
            zzb(this.zzbvb, this.zzbve);
        }
        zza(this.zzbux, 1.5707964f);
        zza(this.zzbuy, this.zzbvb, this.zzbux);
        zza(this.zzbuz, this.zzbur, this.zzbuy);
        zza(this.zzbva, this.zzbvf);
        zza(this.zzbvc, this.zzbva, this.zzbuz);
        GLES20.glUniformMatrix3fv(this.zzbvj, 1, false, this.zzbvc, 0);
        GLES20.glDrawArrays(5, 0, 4);
        zzby("drawArrays");
        GLES20.glFinish();
        this.zzbvo.eglSwapBuffers(this.zzbvp, this.zzbvr);
    }

    int zzpc() {
        this.zzbvi = zzpd();
        GLES20.glUseProgram(this.zzbvi);
        zzby("useProgram");
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.zzbvi, "aPosition");
        GLES20.glVertexAttribPointer(iGlGetAttribLocation, 3, 5126, false, 12, (Buffer) this.zzbvl);
        zzby("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
        zzby("enableVertexAttribArray");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        zzby("genTextures");
        int i = iArr[0];
        GLES20.glBindTexture(36197, i);
        zzby("bindTextures");
        GLES20.glTexParameteri(36197, 10240, 9729);
        zzby("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        zzby("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        zzby("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        zzby("texParameteri");
        this.zzbvj = GLES20.glGetUniformLocation(this.zzbvi, "uVMat");
        GLES20.glUniformMatrix3fv(this.zzbvj, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        return i;
    }

    boolean zzpe() {
        EGLConfig eGLConfigZzpf;
        this.zzbvo = (EGL10) EGLContext.getEGL();
        this.zzbvp = this.zzbvo.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.zzbvp == EGL10.EGL_NO_DISPLAY) {
            return false;
        }
        if (this.zzbvo.eglInitialize(this.zzbvp, new int[2]) && (eGLConfigZzpf = zzpf()) != null) {
            this.zzbvq = this.zzbvo.eglCreateContext(this.zzbvp, eGLConfigZzpf, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            if (this.zzbvq == null || this.zzbvq == EGL10.EGL_NO_CONTEXT) {
                return false;
            }
            this.zzbvr = this.zzbvo.eglCreateWindowSurface(this.zzbvp, eGLConfigZzpf, this.zzbvh, null);
            if (this.zzbvr == null || this.zzbvr == EGL10.EGL_NO_SURFACE) {
                return false;
            }
            return this.zzbvo.eglMakeCurrent(this.zzbvp, this.zzbvr, this.zzbvr, this.zzbvq);
        }
        return false;
    }

    boolean zzpi() {
        boolean zEglDestroyContext = false;
        if (this.zzbvr != null && this.zzbvr != EGL10.EGL_NO_SURFACE) {
            zEglDestroyContext = this.zzbvo.eglMakeCurrent(this.zzbvp, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | false | this.zzbvo.eglDestroySurface(this.zzbvp, this.zzbvr);
            this.zzbvr = null;
        }
        if (this.zzbvq != null) {
            zEglDestroyContext |= this.zzbvo.eglDestroyContext(this.zzbvp, this.zzbvq);
            this.zzbvq = null;
        }
        if (this.zzbvp == null) {
            return zEglDestroyContext;
        }
        boolean zEglTerminate = zEglDestroyContext | this.zzbvo.eglTerminate(this.zzbvp);
        this.zzbvp = null;
        return zEglTerminate;
    }
}
