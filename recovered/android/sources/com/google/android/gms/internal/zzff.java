package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzff extends zzkg {
    final zzll zzbgj;
    final zzfh zzbjf;
    private final String zzbjg;

    zzff(zzll zzllVar, zzfh zzfhVar, String str) {
        this.zzbgj = zzllVar;
        this.zzbjf = zzfhVar;
        this.zzbjg = str;
        com.google.android.gms.ads.internal.zzu.zzgj().zza(this);
    }

    @Override // com.google.android.gms.internal.zzkg
    public void onStop() {
        this.zzbjf.abort();
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zzew() {
        try {
            this.zzbjf.zzba(this.zzbjg);
        } finally {
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzff.1
                @Override // java.lang.Runnable
                public void run() {
                    com.google.android.gms.ads.internal.zzu.zzgj().zzb(zzff.this);
                }
            });
        }
    }
}
