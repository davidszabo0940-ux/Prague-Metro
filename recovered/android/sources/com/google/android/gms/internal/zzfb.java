package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzfb implements zzet {
    private final Object zzail = new Object();
    private final Map<String, zza> zzbjb = new HashMap();

    public interface zza {
        void zzaz(String str);

        void zzd(JSONObject jSONObject);
    }

    @Override // com.google.android.gms.internal.zzet
    public void zza(zzll zzllVar, Map<String, String> map) {
        String str = map.get("id");
        String str2 = map.get("fail");
        String str3 = map.get("fail_reason");
        String str4 = map.get("result");
        synchronized (this.zzail) {
            zza zzaVarRemove = this.zzbjb.remove(str);
            if (zzaVarRemove == null) {
                String strValueOf = String.valueOf(str);
                zzkh.zzcy(strValueOf.length() != 0 ? "Received result for unexpected method invocation: ".concat(strValueOf) : new String("Received result for unexpected method invocation: "));
            } else if (!TextUtils.isEmpty(str2)) {
                zzaVarRemove.zzaz(str3);
            } else {
                if (str4 == null) {
                    zzaVarRemove.zzaz("No result.");
                    return;
                }
                try {
                    zzaVarRemove.zzd(new JSONObject(str4));
                } catch (JSONException e) {
                    zzaVarRemove.zzaz(e.getMessage());
                }
            }
        }
    }
}
