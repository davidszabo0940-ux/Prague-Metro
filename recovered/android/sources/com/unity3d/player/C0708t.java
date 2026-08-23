package com.unity3d.player;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: com.unity3d.player.t */
/* JADX INFO: loaded from: classes.dex */
final class C0708t {

    /* JADX INFO: renamed from: a */
    public static C0708t f1065a;

    /* JADX INFO: renamed from: b */
    private final ViewGroup f1066b;

    /* JADX INFO: renamed from: c */
    private Set f1067c = new HashSet();

    /* JADX INFO: renamed from: d */
    private View f1068d;

    /* JADX INFO: renamed from: e */
    private View f1069e;

    C0708t(ViewGroup viewGroup) {
        this.f1066b = viewGroup;
        f1065a = this;
    }

    /* JADX INFO: renamed from: e */
    private void m218e(View view) {
        this.f1066b.addView(view, this.f1066b.getChildCount());
    }

    /* JADX INFO: renamed from: f */
    private void m219f(View view) {
        this.f1066b.removeView(view);
        this.f1066b.requestLayout();
    }

    /* JADX INFO: renamed from: a */
    public final Context m220a() {
        return this.f1066b.getContext();
    }

    /* JADX INFO: renamed from: a */
    public final void m221a(View view) {
        this.f1067c.add(view);
        if (this.f1068d != null) {
            m218e(view);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m222b(View view) {
        this.f1067c.remove(view);
        if (this.f1068d != null) {
            m219f(view);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m223c(View view) {
        if (this.f1068d != view) {
            this.f1068d = view;
            this.f1066b.addView(view);
            Iterator it = this.f1067c.iterator();
            while (it.hasNext()) {
                m218e((View) it.next());
            }
            if (this.f1069e != null) {
                this.f1069e.setVisibility(4);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m224d(View view) {
        if (this.f1068d == view) {
            Iterator it = this.f1067c.iterator();
            while (it.hasNext()) {
                m219f((View) it.next());
            }
            this.f1066b.removeView(view);
            this.f1068d = null;
            if (this.f1069e != null) {
                this.f1069e.setVisibility(0);
            }
        }
    }
}
