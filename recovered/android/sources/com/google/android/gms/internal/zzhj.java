package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzhj {
    private final zzll zzbgj;
    private final String zzbrq;

    public zzhj(zzll zzllVar) {
        this(zzllVar, "");
    }

    public zzhj(zzll zzllVar, String str) {
        this.zzbgj = zzllVar;
        this.zzbrq = str;
    }

    public void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzbgj.zzb("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e) {
            zzkh.zzb("Error occured while obtaining screen information.", e);
        }
    }

    public void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzbgj.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzkh.zzb("Error occured while dispatching size change.", e);
        }
    }

    public void zzbu(String str) {
        try {
            this.zzbgj.zzb("onError", new JSONObject().put("message", str).put("action", this.zzbrq));
        } catch (JSONException e) {
            zzkh.zzb("Error occurred while dispatching error event.", e);
        }
    }

    public void zzbv(String str) {
        try {
            this.zzbgj.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzkh.zzb("Error occured while dispatching ready Event.", e);
        }
    }

    public void zzbw(String str) {
        try {
            this.zzbgj.zzb("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzkh.zzb("Error occured while dispatching state change.", e);
        }
    }

    public void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzbgj.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzkh.zzb("Error occured while dispatching default position.", e);
        }
    }
}
