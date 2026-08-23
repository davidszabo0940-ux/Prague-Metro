package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.v */
/* JADX INFO: loaded from: classes.dex */
final class C0710v {

    /* JADX INFO: renamed from: a */
    private static boolean f1071a = false;

    /* JADX INFO: renamed from: b */
    private boolean f1072b;

    /* JADX INFO: renamed from: c */
    private boolean f1073c;

    /* JADX INFO: renamed from: d */
    private boolean f1074d;

    /* JADX INFO: renamed from: e */
    private boolean f1075e;

    C0710v() {
        this.f1072b = !C0705q.f1044h;
        this.f1073c = false;
        this.f1074d = false;
        this.f1075e = true;
    }

    /* JADX INFO: renamed from: a */
    static void m226a() {
        f1071a = true;
    }

    /* JADX INFO: renamed from: b */
    static void m227b() {
        f1071a = false;
    }

    /* JADX INFO: renamed from: c */
    static boolean m228c() {
        return f1071a;
    }

    /* JADX INFO: renamed from: a */
    final void m229a(boolean z) {
        this.f1073c = z;
    }

    /* JADX INFO: renamed from: b */
    final void m230b(boolean z) {
        this.f1075e = z;
    }

    /* JADX INFO: renamed from: c */
    final void m231c(boolean z) {
        this.f1074d = z;
    }

    /* JADX INFO: renamed from: d */
    final void m232d() {
        this.f1072b = true;
    }

    /* JADX INFO: renamed from: e */
    final boolean m233e() {
        return this.f1075e;
    }

    /* JADX INFO: renamed from: f */
    final boolean m234f() {
        return f1071a && this.f1073c && this.f1072b && !this.f1075e && !this.f1074d;
    }

    /* JADX INFO: renamed from: g */
    final boolean m235g() {
        return this.f1074d;
    }

    public final String toString() {
        return super.toString();
    }
}
