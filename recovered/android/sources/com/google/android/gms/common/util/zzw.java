package com.google.android.gms.common.util;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class zzw {

    /* JADX INFO: renamed from: AZ */
    private static final Pattern f475AZ = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean zzic(String str) {
        return str == null || com.google.android.gms.common.internal.zzf.f305xC.zzb(str);
    }
}
