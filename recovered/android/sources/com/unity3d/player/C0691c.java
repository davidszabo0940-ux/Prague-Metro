package com.unity3d.player;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.unity3d.player.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0691c implements InterfaceC0693e {
    @Override // com.unity3d.player.InterfaceC0693e
    /* JADX INFO: renamed from: a */
    public final boolean mo170a(View view, MotionEvent motionEvent) {
        return view.dispatchGenericMotionEvent(motionEvent);
    }
}
