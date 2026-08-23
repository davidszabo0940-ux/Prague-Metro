package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzcz {
    private final Collection<zzcy> zzaxp = new ArrayList();
    private final Collection<zzcy<String>> zzaxq = new ArrayList();
    private final Collection<zzcy<String>> zzaxr = new ArrayList();

    public void zza(zzcy zzcyVar) {
        this.zzaxp.add(zzcyVar);
    }

    public void zzb(zzcy<String> zzcyVar) {
        this.zzaxq.add(zzcyVar);
    }

    public void zzc(zzcy<String> zzcyVar) {
        this.zzaxr.add(zzcyVar);
    }

    public List<String> zzjx() {
        ArrayList arrayList = new ArrayList();
        Iterator<zzcy<String>> it = this.zzaxq.iterator();
        while (it.hasNext()) {
            String str = it.next().get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public List<String> zzjy() {
        List<String> listZzjx = zzjx();
        Iterator<zzcy<String>> it = this.zzaxr.iterator();
        while (it.hasNext()) {
            String str = it.next().get();
            if (str != null) {
                listZzjx.add(str);
            }
        }
        return listZzjx;
    }
}
