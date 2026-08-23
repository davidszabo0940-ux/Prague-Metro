package com.google.android.gms.internal;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzkr {
    private static zzl zzcmg;
    private static final Object zzcmh = new Object();
    public static final zza<Void> zzcmi = new zza<Void>() { // from class: com.google.android.gms.internal.zzkr.1
        @Override // com.google.android.gms.internal.zzkr.zza
        /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
        public Void zzh(InputStream inputStream) {
            return null;
        }

        @Override // com.google.android.gms.internal.zzkr.zza
        /* JADX INFO: renamed from: zztq, reason: merged with bridge method [inline-methods] */
        public Void zzqv() {
            return null;
        }
    };

    public interface zza<T> {
        T zzh(InputStream inputStream);

        T zzqv();
    }

    private static class zzb<T> extends zzk<InputStream> {
        private final zzm.zzb<T> zzcg;
        private final zza<T> zzcmn;

        public zzb(String str, final zza<T> zzaVar, final zzm.zzb<T> zzbVar) {
            super(0, str, new zzm.zza() { // from class: com.google.android.gms.internal.zzkr.zzb.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.zzm.zza
                public void zze(zzr zzrVar) {
                    zzbVar.zzb(zzaVar.zzqv());
                }
            });
            this.zzcmn = zzaVar;
            this.zzcg = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzk
        protected zzm<InputStream> zza(zzi zziVar) {
            return zzm.zza(new ByteArrayInputStream(zziVar.data), zzx.zzb(zziVar));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzk
        /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
        public void zza(InputStream inputStream) {
            this.zzcg.zzb(this.zzcmn.zzh(inputStream));
        }
    }

    private class zzc<T> extends zzkz<T> implements zzm.zzb<T> {
        private zzc() {
        }

        @Override // com.google.android.gms.internal.zzm.zzb
        public void zzb(T t) {
            super.zzi(t);
        }
    }

    public zzkr(Context context) {
        zzap(context);
    }

    private static zzl zzap(Context context) {
        zzl zzlVar;
        synchronized (zzcmh) {
            if (zzcmg == null) {
                zzcmg = zzac.zza(context.getApplicationContext());
            }
            zzlVar = zzcmg;
        }
        return zzlVar;
    }

    public zzlc<String> zza(int i, final String str, final Map<String, String> map, final byte[] bArr) {
        final zzc zzcVar = new zzc();
        zzcmg.zze(new zzab(i, str, zzcVar, new zzm.zza() { // from class: com.google.android.gms.internal.zzkr.2
            @Override // com.google.android.gms.internal.zzm.zza
            public void zze(zzr zzrVar) {
                String str2 = str;
                String strValueOf = String.valueOf(zzrVar.toString());
                zzkh.zzcy(new StringBuilder(String.valueOf(str2).length() + 21 + String.valueOf(strValueOf).length()).append("Failed to load URL: ").append(str2).append("\n").append(strValueOf).toString());
                zzcVar.zzb((Object) null);
            }
        }) { // from class: com.google.android.gms.internal.zzkr.3
            @Override // com.google.android.gms.internal.zzk
            public Map<String, String> getHeaders() throws com.google.android.gms.internal.zza {
                return map == null ? super.getHeaders() : map;
            }

            @Override // com.google.android.gms.internal.zzk
            public byte[] zzp() throws com.google.android.gms.internal.zza {
                return bArr == null ? super.zzp() : bArr;
            }
        });
        return zzcVar;
    }

    public <T> zzlc<T> zza(String str, zza<T> zzaVar) {
        zzc zzcVar = new zzc();
        zzcmg.zze(new zzb(str, zzaVar, zzcVar));
        return zzcVar;
    }

    public zzlc<String> zzb(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }
}
