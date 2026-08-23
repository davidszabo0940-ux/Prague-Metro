package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zziv {
    private String zzbvu;
    private String zzceq;
    zzfw.zzc zzces;
    private final Object zzail = new Object();
    private zzkz<zziy> zzcer = new zzkz<>();
    public final zzet zzcet = new zzet() { // from class: com.google.android.gms.internal.zziv.1
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            synchronized (zziv.this.zzail) {
                if (zziv.this.zzcer.isDone()) {
                    return;
                }
                if (zziv.this.zzbvu.equals(map.get("request_id"))) {
                    zziy zziyVar = new zziy(1, map);
                    String strValueOf = String.valueOf(zziyVar.getType());
                    String strValueOf2 = String.valueOf(zziyVar.zzrk());
                    zzkh.zzcy(new StringBuilder(String.valueOf(strValueOf).length() + 24 + String.valueOf(strValueOf2).length()).append("Invalid ").append(strValueOf).append(" request error: ").append(strValueOf2).toString());
                    zziv.this.zzcer.zzi(zziyVar);
                }
            }
        }
    };
    public final zzet zzceu = new zzet() { // from class: com.google.android.gms.internal.zziv.2
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            synchronized (zziv.this.zzail) {
                if (zziv.this.zzcer.isDone()) {
                    return;
                }
                zziy zziyVar = new zziy(-2, map);
                if (zziv.this.zzbvu.equals(zziyVar.getRequestId())) {
                    String url = zziyVar.getUrl();
                    if (url == null) {
                        zzkh.zzcy("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (url.contains("%40mediation_adapters%40")) {
                        String strReplaceAll = url.replaceAll("%40mediation_adapters%40", zzkf.zza(zzllVar.getContext(), map.get("check_adapters"), zziv.this.zzceq));
                        zziyVar.setUrl(strReplaceAll);
                        String strValueOf = String.valueOf(strReplaceAll);
                        zzkh.m95v(strValueOf.length() != 0 ? "Ad request URL modified to ".concat(strValueOf) : new String("Ad request URL modified to "));
                    }
                    zziv.this.zzcer.zzi(zziyVar);
                }
            }
        }
    };
    public final zzet zzcev = new zzet() { // from class: com.google.android.gms.internal.zziv.3
        @Override // com.google.android.gms.internal.zzet
        public void zza(zzll zzllVar, Map<String, String> map) {
            synchronized (zziv.this.zzail) {
                if (zziv.this.zzcer.isDone()) {
                    return;
                }
                zziy zziyVar = new zziy(-2, map);
                if (zziv.this.zzbvu.equals(zziyVar.getRequestId())) {
                    zziyVar.zzrn();
                    zziv.this.zzcer.zzi(zziyVar);
                }
            }
        }
    };

    public zziv(String str, String str2) {
        this.zzceq = str2;
        this.zzbvu = str;
    }

    public void zzb(zzfw.zzc zzcVar) {
        this.zzces = zzcVar;
    }

    public zzfw.zzc zzrh() {
        return this.zzces;
    }

    public Future<zziy> zzri() {
        return this.zzcer;
    }

    public void zzrj() {
    }
}
