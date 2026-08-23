package com.unity3d.player;

import android.app.Activity;
import android.content.ContextWrapper;
import android.view.MotionEvent;
import android.view.View;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: renamed from: com.unity3d.player.p */
/* JADX INFO: loaded from: classes.dex */
public final class C0704p implements InterfaceC0698j {

    /* JADX INFO: renamed from: b */
    private final Activity f1034b;

    /* JADX INFO: renamed from: a */
    private final Queue f1033a = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c */
    private Runnable f1035c = new Runnable() { // from class: com.unity3d.player.p.1
        /* JADX INFO: renamed from: a */
        private static void m198a(View view, MotionEvent motionEvent) {
            if (C0705q.f1038b) {
                C0705q.f1046j.mo170a(view, motionEvent);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (true) {
                MotionEvent motionEvent = (MotionEvent) C0704p.this.f1033a.poll();
                if (motionEvent == null) {
                    return;
                }
                View decorView = C0704p.this.f1034b.getWindow().getDecorView();
                int source = motionEvent.getSource();
                if ((source & 2) != 0) {
                    switch (motionEvent.getAction() & 255) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            decorView.dispatchTouchEvent(motionEvent);
                            break;
                        default:
                            m198a(decorView, motionEvent);
                            break;
                    }
                } else if ((source & 4) != 0) {
                    decorView.dispatchTrackballEvent(motionEvent);
                } else {
                    m198a(decorView, motionEvent);
                }
            }
        }
    };

    public C0704p(ContextWrapper contextWrapper) {
        this.f1034b = (Activity) contextWrapper;
    }

    /* JADX INFO: renamed from: a */
    private static int m194a(MotionEvent.PointerCoords[] pointerCoordsArr, float[] fArr, int i) {
        for (int i2 = 0; i2 < pointerCoordsArr.length; i2++) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoordsArr[i2] = pointerCoords;
            int i3 = i + 1;
            pointerCoords.orientation = fArr[i];
            int i4 = i3 + 1;
            pointerCoords.pressure = fArr[i3];
            int i5 = i4 + 1;
            pointerCoords.size = fArr[i4];
            int i6 = i5 + 1;
            pointerCoords.toolMajor = fArr[i5];
            int i7 = i6 + 1;
            pointerCoords.toolMinor = fArr[i6];
            int i8 = i7 + 1;
            pointerCoords.touchMajor = fArr[i7];
            int i9 = i8 + 1;
            pointerCoords.touchMinor = fArr[i8];
            int i10 = i9 + 1;
            pointerCoords.x = fArr[i9];
            i = i10 + 1;
            pointerCoords.y = fArr[i10];
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    private static MotionEvent.PointerCoords[] m196a(int i, float[] fArr) {
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[i];
        m194a(pointerCoordsArr, fArr, 0);
        return pointerCoordsArr;
    }

    @Override // com.unity3d.player.InterfaceC0698j
    /* JADX INFO: renamed from: a */
    public final void mo184a(long j, long j2, int i, int i2, int[] iArr, float[] fArr, int i3, float f, float f2, int i4, int i5, int i6, int i7, int i8, long[] jArr, float[] fArr2) {
        if (this.f1034b != null) {
            MotionEvent motionEventObtain = MotionEvent.obtain(j, j2, i, i2, iArr, m196a(i2, fArr), i3, f, f2, i4, i5, i6, i7);
            int iM194a = 0;
            for (int i9 = 0; i9 < i8; i9++) {
                MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[i2];
                iM194a = m194a(pointerCoordsArr, fArr2, iM194a);
                motionEventObtain.addBatch(jArr[i9], pointerCoordsArr, i3);
            }
            this.f1033a.add(motionEventObtain);
            this.f1034b.runOnUiThread(this.f1035c);
        }
    }
}
