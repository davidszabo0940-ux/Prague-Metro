package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzfg implements Iterable<zzff> {
    private final List<zzff> zzbji = new LinkedList();

    private zzff zzg(zzll zzllVar) {
        for (zzff zzffVar : com.google.android.gms.ads.internal.zzu.zzgj()) {
            if (zzffVar.zzbgj == zzllVar) {
                return zzffVar;
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<zzff> iterator() {
        return this.zzbji.iterator();
    }

    public void zza(zzff zzffVar) {
        this.zzbji.add(zzffVar);
    }

    public void zzb(zzff zzffVar) {
        this.zzbji.remove(zzffVar);
    }

    public boolean zze(zzll zzllVar) {
        zzff zzffVarZzg = zzg(zzllVar);
        if (zzffVarZzg == null) {
            return false;
        }
        zzffVarZzg.zzbjf.abort();
        return true;
    }

    public boolean zzf(zzll zzllVar) {
        return zzg(zzllVar) != null;
    }

    public int zzlm() {
        return this.zzbji.size();
    }
}
