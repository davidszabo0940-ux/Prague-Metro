package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class zzue {
    private final Collection<zzud> zzaxp = new ArrayList();
    private final Collection<zzud.zzd> zzaxq = new ArrayList();
    private final Collection<zzud.zzd> zzaxr = new ArrayList();

    public static void initialize(Context context) {
        zzuh.zzbfs().initialize(context);
    }

    public void zza(zzud zzudVar) {
        this.zzaxp.add(zzudVar);
    }
}
