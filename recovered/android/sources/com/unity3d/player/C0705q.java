package com.unity3d.player;

import android.os.Build;

/* JADX INFO: renamed from: com.unity3d.player.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0705q {

    /* JADX INFO: renamed from: a */
    static final boolean f1037a;

    /* JADX INFO: renamed from: b */
    static final boolean f1038b;

    /* JADX INFO: renamed from: c */
    static final boolean f1039c;

    /* JADX INFO: renamed from: d */
    static final boolean f1040d;

    /* JADX INFO: renamed from: e */
    static final boolean f1041e;

    /* JADX INFO: renamed from: f */
    static final boolean f1042f;

    /* JADX INFO: renamed from: g */
    static final boolean f1043g;

    /* JADX INFO: renamed from: h */
    static final boolean f1044h;

    /* JADX INFO: renamed from: i */
    static final InterfaceC0694f f1045i;

    /* JADX INFO: renamed from: j */
    static final InterfaceC0693e f1046j;

    /* JADX INFO: renamed from: k */
    static final InterfaceC0696h f1047k;

    /* JADX INFO: renamed from: l */
    static final InterfaceC0695g f1048l;

    /* JADX INFO: renamed from: m */
    static final InterfaceC0697i f1049m;

    static {
        f1037a = Build.VERSION.SDK_INT >= 11;
        f1038b = Build.VERSION.SDK_INT >= 12;
        f1039c = Build.VERSION.SDK_INT >= 14;
        f1040d = Build.VERSION.SDK_INT >= 16;
        f1041e = Build.VERSION.SDK_INT >= 17;
        f1042f = Build.VERSION.SDK_INT >= 19;
        f1043g = Build.VERSION.SDK_INT >= 21;
        f1044h = Build.VERSION.SDK_INT >= 23;
        f1045i = f1037a ? new C0692d() : null;
        f1046j = f1038b ? new C0691c() : null;
        f1047k = f1040d ? new C0700l() : null;
        f1048l = f1041e ? new C0699k() : null;
        f1049m = f1044h ? new C0702n() : null;
    }
}
