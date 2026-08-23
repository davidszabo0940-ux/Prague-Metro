package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zziy {
    private String zzae;
    private final String zzbvu;
    private int zzbym;
    private final List<String> zzcfy;
    private final List<String> zzcfz;
    private final String zzcga;
    private final String zzcgb;
    private final String zzcgc;
    private final String zzcgd;
    private final boolean zzcge;
    private final boolean zzcgf;
    private final String zzcgg;

    public zziy(int i, Map<String, String> map) {
        this.zzae = map.get("url");
        this.zzcgb = map.get("base_uri");
        this.zzcgc = map.get("post_parameters");
        this.zzcge = parseBoolean(map.get("drt_include"));
        this.zzcgf = parseBoolean(map.get("pan_include"));
        this.zzcga = map.get("activation_overlay_url");
        this.zzcfz = zzcf(map.get("check_packages"));
        this.zzbvu = map.get("request_id");
        this.zzcgd = map.get("type");
        this.zzcfy = zzcf(map.get("errors"));
        this.zzbym = i;
        this.zzcgg = map.get("fetched_ad");
    }

    private static boolean parseBoolean(String str) {
        return str != null && (str.equals("1") || str.equals("true"));
    }

    private List<String> zzcf(String str) {
        if (str == null) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    public int getErrorCode() {
        return this.zzbym;
    }

    public String getRequestId() {
        return this.zzbvu;
    }

    public String getType() {
        return this.zzcgd;
    }

    public String getUrl() {
        return this.zzae;
    }

    public void setUrl(String str) {
        this.zzae = str;
    }

    public List<String> zzrk() {
        return this.zzcfy;
    }

    public String zzrl() {
        return this.zzcgc;
    }

    public boolean zzrm() {
        return this.zzcge;
    }

    public String zzrn() {
        return this.zzcgg;
    }
}
