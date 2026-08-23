package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public enum zzamq implements zzamr {
    IDENTITY { // from class: com.google.android.gms.internal.zzamq.1
        @Override // com.google.android.gms.internal.zzamr
        public String zzc(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: com.google.android.gms.internal.zzamq.2
        @Override // com.google.android.gms.internal.zzamr
        public String zzc(Field field) {
            return zzamq.zzsv(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.google.android.gms.internal.zzamq.3
        @Override // com.google.android.gms.internal.zzamr
        public String zzc(Field field) {
            return zzamq.zzsv(zzamq.zzbw(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.google.android.gms.internal.zzamq.4
        @Override // com.google.android.gms.internal.zzamr
        public String zzc(Field field) {
            return zzamq.zzbw(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.google.android.gms.internal.zzamq.5
        @Override // com.google.android.gms.internal.zzamr
        public String zzc(Field field) {
            return zzamq.zzbw(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };

    private static String zza(char c, String str, int i) {
        if (i >= str.length()) {
            return String.valueOf(c);
        }
        String strValueOf = String.valueOf(str.substring(i));
        return new StringBuilder(String.valueOf(strValueOf).length() + 1).append(c).append(strValueOf).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzbw(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzsv(String str) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        while (i < str.length() - 1 && !Character.isLetter(cCharAt)) {
            sb.append(cCharAt);
            i++;
            cCharAt = str.charAt(i);
        }
        if (i == str.length()) {
            return sb.toString();
        }
        return !Character.isUpperCase(cCharAt) ? sb.append(zza(Character.toUpperCase(cCharAt), str, i + 1)).toString() : str;
    }
}
