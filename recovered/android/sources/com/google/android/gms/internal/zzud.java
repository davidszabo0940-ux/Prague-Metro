package com.google.android.gms.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzud<T> {
    private final int zzaxm;
    private final String zzaxn;
    private final T zzaxo;

    public static class zza extends zzud<Boolean> {
        public zza(int i, String str, Boolean bool) {
            super(i, str, bool);
        }

        @Override // com.google.android.gms.internal.zzud
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Boolean zza(zzug zzugVar) {
            try {
                return Boolean.valueOf(zzugVar.getBooleanFlagValue(getKey(), zzjw().booleanValue(), getSource()));
            } catch (RemoteException e) {
                return zzjw();
            }
        }
    }

    public static class zzb extends zzud<Integer> {
        public zzb(int i, String str, Integer num) {
            super(i, str, num);
        }

        @Override // com.google.android.gms.internal.zzud
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public Integer zza(zzug zzugVar) {
            try {
                return Integer.valueOf(zzugVar.getIntFlagValue(getKey(), zzjw().intValue(), getSource()));
            } catch (RemoteException e) {
                return zzjw();
            }
        }
    }

    public static class zzc extends zzud<Long> {
        public zzc(int i, String str, Long l) {
            super(i, str, l);
        }

        @Override // com.google.android.gms.internal.zzud
        /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public Long zza(zzug zzugVar) {
            try {
                return Long.valueOf(zzugVar.getLongFlagValue(getKey(), zzjw().longValue(), getSource()));
            } catch (RemoteException e) {
                return zzjw();
            }
        }
    }

    public static class zzd extends zzud<String> {
        public zzd(int i, String str, String str2) {
            super(i, str, str2);
        }

        @Override // com.google.android.gms.internal.zzud
        /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
        public String zza(zzug zzugVar) {
            try {
                return zzugVar.getStringFlagValue(getKey(), zzjw(), getSource());
            } catch (RemoteException e) {
                return zzjw();
            }
        }
    }

    private zzud(int i, String str, T t) {
        this.zzaxm = i;
        this.zzaxn = str;
        this.zzaxo = t;
        zzuh.zzbfr().zza(this);
    }

    public static zza zzb(int i, String str, Boolean bool) {
        return new zza(i, str, bool);
    }

    public static zzb zzb(int i, String str, int i2) {
        return new zzb(i, str, Integer.valueOf(i2));
    }

    public static zzc zzb(int i, String str, long j) {
        return new zzc(i, str, Long.valueOf(j));
    }

    public static zzd zzc(int i, String str, String str2) {
        return new zzd(i, str, str2);
    }

    public T get() {
        return (T) zzuh.zzbfs().zzb(this);
    }

    public String getKey() {
        return this.zzaxn;
    }

    public int getSource() {
        return this.zzaxm;
    }

    protected abstract T zza(zzug zzugVar);

    public T zzjw() {
        return this.zzaxo;
    }
}
