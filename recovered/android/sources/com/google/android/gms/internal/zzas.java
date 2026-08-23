package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class zzas {
    private static final String[] zzafy = {"/aclk", "/pcs/click"};
    private String zzafu = "googleads.g.doubleclick.net";
    private String zzafv = "/pagead/ads";
    private String zzafw = "ad.doubleclick.net";
    private String[] zzafx = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzan zzafz;

    public zzas(zzan zzanVar) {
        this.zzafz = zzanVar;
    }

    private Uri zza(Uri uri, Context context, String str, boolean z) throws zzat {
        try {
            boolean zZzb = zzb(uri);
            if (zZzb) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzat("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzat("Query parameter already exists: ms");
            }
            String strZzb = z ? this.zzafz.zzb(context, str) : this.zzafz.zzb(context);
            return zZzb ? zzb(uri, "dc_ms", strZzb) : zza(uri, "ms", strZzb);
        } catch (UnsupportedOperationException e) {
            throw new zzat("Provided Uri is not in a valid state");
        }
    }

    private Uri zza(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String string = uri.toString();
        int iIndexOf = string.indexOf("&adurl");
        if (iIndexOf == -1) {
            iIndexOf = string.indexOf("?adurl");
        }
        return iIndexOf != -1 ? Uri.parse(string.substring(0, iIndexOf + 1) + str + "=" + str2 + "&" + string.substring(iIndexOf + 1)) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri zzb(Uri uri, String str, String str2) {
        String string = uri.toString();
        int iIndexOf = string.indexOf(";adurl");
        if (iIndexOf != -1) {
            return Uri.parse(string.substring(0, iIndexOf + 1) + str + "=" + str2 + ";" + string.substring(iIndexOf + 1));
        }
        String encodedPath = uri.getEncodedPath();
        int iIndexOf2 = string.indexOf(encodedPath);
        return Uri.parse(string.substring(0, encodedPath.length() + iIndexOf2) + ";" + str + "=" + str2 + ";" + string.substring(encodedPath.length() + iIndexOf2));
    }

    public Uri zza(Uri uri, Context context) throws zzat {
        return zza(uri, context, null, false);
    }

    public void zza(MotionEvent motionEvent) {
        this.zzafz.zza(motionEvent);
    }

    public boolean zza(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.zzafu) && uri.getPath().equals(this.zzafv);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public zzan zzax() {
        return this.zzafz;
    }

    public Uri zzb(Uri uri, Context context) throws zzat {
        try {
            return zza(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new zzat("Provided Uri is not in a valid state");
        }
    }

    public void zzb(String str, String str2) {
        this.zzafu = str;
        this.zzafv = str2;
    }

    public boolean zzb(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.zzafw);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean zzc(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String str : this.zzafx) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean zzd(Uri uri) {
        if (!zzc(uri)) {
            return false;
        }
        for (String str : zzafy) {
            if (uri.getPath().endsWith(str)) {
                return true;
            }
        }
        return false;
    }

    public void zzk(String str) {
        this.zzafx = str.split(",");
    }
}
