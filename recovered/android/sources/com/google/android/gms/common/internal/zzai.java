package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C0228R;

/* JADX INFO: loaded from: classes.dex */
public class zzai {

    /* JADX INFO: renamed from: zc */
    private final Resources f269zc;

    /* JADX INFO: renamed from: zd */
    private final String f270zd;

    public zzai(Context context) {
        zzab.zzaa(context);
        this.f269zc = context.getResources();
        this.f270zd = this.f269zc.getResourcePackageName(C0228R.string.common_google_play_services_unknown_issue);
    }

    public String getString(String str) {
        int identifier = this.f269zc.getIdentifier(str, "string", this.f270zd);
        if (identifier == 0) {
            return null;
        }
        return this.f269zc.getString(identifier);
    }
}
