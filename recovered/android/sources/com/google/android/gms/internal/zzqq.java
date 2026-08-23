package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(11)
public final class zzqq extends Fragment implements zzqp {

    /* JADX INFO: renamed from: vb */
    private static WeakHashMap<Activity, WeakReference<zzqq>> f764vb = new WeakHashMap<>();

    /* JADX INFO: renamed from: vd */
    private Bundle f766vd;

    /* JADX INFO: renamed from: vc */
    private Map<String, zzqo> f765vc = new ArrayMap();
    private int zzblz = 0;

    private void zzb(final String str, @NonNull final zzqo zzqoVar) {
        if (this.zzblz > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.zzqq.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zzqq.this.zzblz >= 1) {
                        zzqoVar.onCreate(zzqq.this.f766vd != null ? zzqq.this.f766vd.getBundle(str) : null);
                    }
                    if (zzqq.this.zzblz >= 2) {
                        zzqoVar.onStart();
                    }
                    if (zzqq.this.zzblz >= 3) {
                        zzqoVar.onStop();
                    }
                }
            });
        }
    }

    public static zzqq zzt(Activity activity) {
        zzqq zzqqVar;
        WeakReference<zzqq> weakReference = f764vb.get(activity);
        if (weakReference == null || (zzqqVar = weakReference.get()) == null) {
            try {
                zzqqVar = (zzqq) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (zzqqVar == null || zzqqVar.isRemoving()) {
                    zzqqVar = new zzqq();
                    activity.getFragmentManager().beginTransaction().add(zzqqVar, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f764vb.put(activity, new WeakReference<>(zzqqVar));
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
            }
        }
        return zzqqVar;
    }

    @Override // android.app.Fragment
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator<zzqo> it = this.f765vc.values().iterator();
        while (it.hasNext()) {
            it.next().dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator<zzqo> it = this.f765vc.values().iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzblz = 1;
        this.f766vd = bundle;
        for (Map.Entry<String, zzqo> entry : this.f765vc.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, zzqo> entry : this.f765vc.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStop();
        this.zzblz = 2;
        Iterator<zzqo> it = this.f765vc.values().iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.zzblz = 3;
        Iterator<zzqo> it = this.f765vc.values().iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    @Override // com.google.android.gms.internal.zzqp
    public <T extends zzqo> T zza(String str, Class<T> cls) {
        return cls.cast(this.f765vc.get(str));
    }

    @Override // com.google.android.gms.internal.zzqp
    public void zza(String str, @NonNull zzqo zzqoVar) {
        if (this.f765vc.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f765vc.put(str, zzqoVar);
        zzb(str, zzqoVar);
    }

    @Override // com.google.android.gms.internal.zzqp
    public Activity zzaqp() {
        return getActivity();
    }
}
