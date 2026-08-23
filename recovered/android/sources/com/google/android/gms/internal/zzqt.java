package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class zzqt {

    /* JADX INFO: renamed from: mg */
    private final Set<zzqs<?>> f771mg = Collections.newSetFromMap(new WeakHashMap());

    public void release() {
        Iterator<zzqs<?>> it = this.f771mg.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f771mg.clear();
    }

    public <L> zzqs<L> zzb(@NonNull L l, Looper looper) {
        com.google.android.gms.common.internal.zzab.zzb(l, "Listener must not be null");
        com.google.android.gms.common.internal.zzab.zzb(looper, "Looper must not be null");
        zzqs<L> zzqsVar = new zzqs<>(looper, l);
        this.f771mg.add(zzqsVar);
        return zzqsVar;
    }
}
