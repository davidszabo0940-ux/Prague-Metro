package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.media.TransportMediator;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzv implements SensorEventListener {
    private final SensorManager zzbum;
    private final Display zzbuo;
    private float[] zzbur;
    private Handler zzbus;
    private zza zzbut;
    private final float[] zzbup = new float[9];
    private final float[] zzbuq = new float[9];
    private final Object zzbun = new Object();

    interface zza {
        void zzob();
    }

    zzv(Context context) {
        this.zzbum = (SensorManager) context.getSystemService("sensor");
        this.zzbuo = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private void zzf(int i, int i2) {
        float f = this.zzbuq[i];
        this.zzbuq[i] = this.zzbuq[i2];
        this.zzbuq[i2] = f;
    }

    int getRotation() {
        return this.zzbuo.getRotation();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        zza(sensorEvent.values);
    }

    void start() {
        if (this.zzbus != null) {
            return;
        }
        Sensor defaultSensor = this.zzbum.getDefaultSensor(11);
        if (defaultSensor == null) {
            zzkh.m14e("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        this.zzbus = new Handler(handlerThread.getLooper());
        if (this.zzbum.registerListener(this, defaultSensor, 0, this.zzbus)) {
            return;
        }
        zzkh.m14e("SensorManager.registerListener failed.");
        stop();
    }

    void stop() {
        if (this.zzbus == null) {
            return;
        }
        this.zzbum.unregisterListener(this);
        this.zzbus.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzv.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.myLooper().quit();
            }
        });
        this.zzbus = null;
    }

    void zza(zza zzaVar) {
        this.zzbut = zzaVar;
    }

    void zza(float[] fArr) {
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.zzbun) {
            if (this.zzbur == null) {
                this.zzbur = new float[9];
            }
        }
        SensorManager.getRotationMatrixFromVector(this.zzbup, fArr);
        switch (getRotation()) {
            case 1:
                SensorManager.remapCoordinateSystem(this.zzbup, 2, 129, this.zzbuq);
                break;
            case 2:
                SensorManager.remapCoordinateSystem(this.zzbup, 129, TransportMediator.KEYCODE_MEDIA_RECORD, this.zzbuq);
                break;
            case 3:
                SensorManager.remapCoordinateSystem(this.zzbup, TransportMediator.KEYCODE_MEDIA_RECORD, 1, this.zzbuq);
                break;
            default:
                System.arraycopy(this.zzbup, 0, this.zzbuq, 0, 9);
                break;
        }
        zzf(1, 3);
        zzf(2, 6);
        zzf(5, 7);
        synchronized (this.zzbun) {
            System.arraycopy(this.zzbuq, 0, this.zzbur, 0, 9);
        }
        if (this.zzbut != null) {
            this.zzbut.zzob();
        }
    }

    boolean zzb(float[] fArr) {
        boolean z = false;
        synchronized (this.zzbun) {
            if (this.zzbur != null) {
                System.arraycopy(this.zzbur, 0, fArr, 0, this.zzbur.length);
                z = true;
            }
        }
        return z;
    }
}
