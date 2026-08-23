package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzcf {
    private final String zzare;
    private final JSONObject zzarf;
    private final String zzarg;
    private final String zzarh;
    private final boolean zzari;
    private final boolean zzarj;

    public zzcf(String str, VersionInfoParcel versionInfoParcel, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.zzarh = versionInfoParcel.zzcs;
        this.zzarf = jSONObject;
        this.zzarg = str;
        this.zzare = str2;
        this.zzari = z;
        this.zzarj = z2;
    }

    public String zzhk() {
        return this.zzare;
    }

    public String zzhl() {
        return this.zzarh;
    }

    public JSONObject zzhm() {
        return this.zzarf;
    }

    public String zzhn() {
        return this.zzarg;
    }

    public boolean zzho() {
        return this.zzari;
    }

    public boolean zzhp() {
        return this.zzarj;
    }
}
