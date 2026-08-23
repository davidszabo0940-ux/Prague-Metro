package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzhp extends Handler {
    private final zzho zzbwk;

    public zzhp(Context context) {
        this(new zzhq(context.getApplicationContext() != null ? context.getApplicationContext() : context));
    }

    public zzhp(zzho zzhoVar) {
        this.zzbwk = zzhoVar;
    }

    private void zze(JSONObject jSONObject) {
        try {
            this.zzbwk.zza(jSONObject.getString("request_id"), jSONObject.getString("base_url"), jSONObject.getString("html"));
        } catch (Exception e) {
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject(data.getString("data"));
            if ("fetch_html".equals(jSONObject.getString("message_name"))) {
                zze(jSONObject);
            }
        } catch (Exception e) {
        }
    }
}
