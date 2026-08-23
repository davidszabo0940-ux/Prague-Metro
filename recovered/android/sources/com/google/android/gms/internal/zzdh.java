package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzdh {

    @zzir
    public static final zzdh zzbdw = new zzdh() { // from class: com.google.android.gms.internal.zzdh.1
        @Override // com.google.android.gms.internal.zzdh
        public String zzg(@Nullable String str, String str2) {
            return str2;
        }
    };

    @zzir
    public static final zzdh zzbdx = new zzdh() { // from class: com.google.android.gms.internal.zzdh.2
        @Override // com.google.android.gms.internal.zzdh
        public String zzg(@Nullable String str, String str2) {
            return str != null ? str : str2;
        }
    };

    @zzir
    public static final zzdh zzbdy = new zzdh() { // from class: com.google.android.gms.internal.zzdh.3
        @Nullable
        private String zzar(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        @Override // com.google.android.gms.internal.zzdh
        public String zzg(@Nullable String str, String str2) {
            String strZzar = zzar(str);
            String strZzar2 = zzar(str2);
            if (TextUtils.isEmpty(strZzar)) {
                return strZzar2;
            }
            return TextUtils.isEmpty(strZzar2) ? strZzar : new StringBuilder(String.valueOf(strZzar).length() + 1 + String.valueOf(strZzar2).length()).append(strZzar).append(",").append(strZzar2).toString();
        }
    };

    public final void zza(Map<String, String> map, String str, String str2) {
        map.put(str, zzg(map.get(str), str2));
    }

    public abstract String zzg(@Nullable String str, String str2);
}
