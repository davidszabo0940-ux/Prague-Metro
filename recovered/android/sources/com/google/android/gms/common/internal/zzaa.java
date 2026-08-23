package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaa {

    public static final class zza {

        /* JADX INFO: renamed from: yU */
        private final List<String> f266yU;
        private final Object zzcmy;

        private zza(Object obj) {
            this.zzcmy = zzab.zzaa(obj);
            this.f266yU = new ArrayList();
        }

        public String toString() {
            StringBuilder sbAppend = new StringBuilder(100).append(this.zzcmy.getClass().getSimpleName()).append('{');
            int size = this.f266yU.size();
            for (int i = 0; i < size; i++) {
                sbAppend.append(this.f266yU.get(i));
                if (i < size - 1) {
                    sbAppend.append(", ");
                }
            }
            return sbAppend.append('}').toString();
        }

        public zza zzg(String str, Object obj) {
            List<String> list = this.f266yU;
            String str2 = (String) zzab.zzaa(str);
            String strValueOf = String.valueOf(String.valueOf(obj));
            list.add(new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(strValueOf).length()).append(str2).append("=").append(strValueOf).toString());
            return this;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zza zzz(Object obj) {
        return new zza(obj);
    }
}
