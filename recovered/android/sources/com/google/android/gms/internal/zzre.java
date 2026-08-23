package com.google.android.gms.internal;

import android.os.Binder;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzre<T> {

    /* JADX INFO: renamed from: vD */
    private T f804vD = null;
    protected final String zzaxn;
    protected final T zzaxo;
    private static final Object zzamp = new Object();

    /* JADX INFO: renamed from: vA */
    private static zza f801vA = null;

    /* JADX INFO: renamed from: vB */
    private static int f802vB = 0;

    /* JADX INFO: renamed from: vC */
    private static String f803vC = "com.google.android.providers.gsf.permission.READ_GSERVICES";

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    protected zzre(String str, T t) {
        this.zzaxn = str;
        this.zzaxo = t;
    }

    public static zzre<Float> zza(String str, Float f) {
        return new zzre<Float>(str, f) { // from class: com.google.android.gms.internal.zzre.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzre
            /* JADX INFO: renamed from: zzhd, reason: merged with bridge method [inline-methods] */
            public Float zzgz(String str2) {
                return zzre.zzaqx().zzb(this.zzaxn, (Float) this.zzaxo);
            }
        };
    }

    public static zzre<Integer> zza(String str, Integer num) {
        return new zzre<Integer>(str, num) { // from class: com.google.android.gms.internal.zzre.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzre
            /* JADX INFO: renamed from: zzhc, reason: merged with bridge method [inline-methods] */
            public Integer zzgz(String str2) {
                return zzre.zzaqx().zzb(this.zzaxn, (Integer) this.zzaxo);
            }
        };
    }

    public static zzre<Long> zza(String str, Long l) {
        return new zzre<Long>(str, l) { // from class: com.google.android.gms.internal.zzre.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzre
            /* JADX INFO: renamed from: zzhb, reason: merged with bridge method [inline-methods] */
            public Long zzgz(String str2) {
                return zzre.zzaqx().getLong(this.zzaxn, (Long) this.zzaxo);
            }
        };
    }

    public static zzre<String> zzab(String str, String str2) {
        return new zzre<String>(str, str2) { // from class: com.google.android.gms.internal.zzre.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzre
            /* JADX INFO: renamed from: zzhe, reason: merged with bridge method [inline-methods] */
            public String zzgz(String str3) {
                return zzre.zzaqx().getString(this.zzaxn, (String) this.zzaxo);
            }
        };
    }

    static /* synthetic */ zza zzaqx() {
        return null;
    }

    public static zzre<Boolean> zzm(String str, boolean z) {
        return new zzre<Boolean>(str, Boolean.valueOf(z)) { // from class: com.google.android.gms.internal.zzre.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzre
            /* JADX INFO: renamed from: zzha, reason: merged with bridge method [inline-methods] */
            public Boolean zzgz(String str2) {
                return zzre.zzaqx().zza(this.zzaxn, (Boolean) this.zzaxo);
            }
        };
    }

    public final T get() {
        try {
            return zzgz(this.zzaxn);
        } catch (SecurityException e) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzgz(this.zzaxn);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    protected abstract T zzgz(String str);
}
