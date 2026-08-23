package com.google.android.gms.internal;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzanb extends zzamy {
    private final zzanw<String, zzamy> bet = new zzanw<>();

    public Set<Map.Entry<String, zzamy>> entrySet() {
        return this.bet.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzanb) && ((zzanb) obj).bet.equals(this.bet));
    }

    public boolean has(String str) {
        return this.bet.containsKey(str);
    }

    public int hashCode() {
        return this.bet.hashCode();
    }

    public void zza(String str, zzamy zzamyVar) {
        if (zzamyVar == null) {
            zzamyVar = zzana.bes;
        }
        this.bet.put(str, zzamyVar);
    }

    public zzamy zzsx(String str) {
        return this.bet.get(str);
    }
}
