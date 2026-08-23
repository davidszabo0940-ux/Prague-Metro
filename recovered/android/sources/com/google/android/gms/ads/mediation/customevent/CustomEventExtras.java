package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> zzcqz = new HashMap<>();

    public Object getExtra(String str) {
        return this.zzcqz.get(str);
    }

    public void setExtra(String str, Object obj) {
        this.zzcqz.put(str, obj);
    }
}
