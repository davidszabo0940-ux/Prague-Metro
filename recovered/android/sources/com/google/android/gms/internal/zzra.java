package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzra extends Fragment implements zzqp {

    /* JADX INFO: renamed from: vb */
    private static WeakHashMap<FragmentActivity, WeakReference<zzra>> f776vb = new WeakHashMap<>();

    /* JADX INFO: renamed from: vd */
    private Bundle f778vd;

    /* JADX INFO: renamed from: vc */
    private Map<String, zzqo> f777vc = new ArrayMap();
    private int zzblz = 0;

    public static zzra zza(FragmentActivity fragmentActivity) {
        zzra zzraVar;
        WeakReference<zzra> weakReference = f776vb.get(fragmentActivity);
        if (weakReference == null || (zzraVar = weakReference.get()) == null) {
            try {
                zzraVar = (zzra) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                if (zzraVar == null || zzraVar.isRemoving()) {
                    zzraVar = new zzra();
                    fragmentActivity.getSupportFragmentManager().beginTransaction().add(zzraVar, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f776vb.put(fragmentActivity, new WeakReference<>(zzraVar));
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
            }
        }
        return zzraVar;
    }

    private void zzb(final String str, @NonNull final zzqo zzqoVar) {
        if (this.zzblz > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.zzra.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zzra.this.zzblz >= 1) {
                        zzqoVar.onCreate(zzra.this.f778vd != null ? zzra.this.f778vd.getBundle(str) : null);
                    }
                    if (zzra.this.zzblz >= 2) {
                        zzqoVar.onStart();
                    }
                    if (zzra.this.zzblz >= 3) {
                        zzqoVar.onStop();
                    }
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator<zzqo> it = this.f777vc.values().iterator();
        while (it.hasNext()) {
            it.next().dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator<zzqo> it = this.f777vc.values().iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzblz = 1;
        this.f778vd = bundle;
        for (Map.Entry<String, zzqo> entry : this.f777vc.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, zzqo> entry : this.f777vc.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStop();
        this.zzblz = 2;
        Iterator<zzqo> it = this.f777vc.values().iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.zzblz = 3;
        Iterator<zzqo> it = this.f777vc.values().iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    @Override // com.google.android.gms.internal.zzqp
    public <T extends zzqo> T zza(String str, Class<T> cls) {
        return cls.cast(this.f777vc.get(str));
    }

    @Override // com.google.android.gms.internal.zzqp
    public void zza(String str, @NonNull zzqo zzqoVar) {
        if (this.f777vc.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f777vc.put(str, zzqoVar);
        zzb(str, zzqoVar);
    }

    @Override // com.google.android.gms.internal.zzqp
    /* JADX INFO: renamed from: zzaqr, reason: merged with bridge method [inline-methods] */
    public FragmentActivity zzaqp() {
        return getActivity();
    }
}
