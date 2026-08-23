package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzfu {

    private static class zza<JavascriptEngine> extends zzkz<JavascriptEngine> {
        JavascriptEngine zzblo;

        private zza() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [JavascriptEngine, com.google.android.gms.internal.zzft, com.google.android.gms.internal.zzfv] */
    public zzft zza(Context context, VersionInfoParcel versionInfoParcel, final zza<zzft> zzaVar, zzas zzasVar) {
        ?? zzfvVar = new zzfv(context, versionInfoParcel, zzasVar);
        zzaVar.zzblo = zzfvVar;
        zzfvVar.zza(new zzft.zza() { // from class: com.google.android.gms.internal.zzfu.2
            @Override // com.google.android.gms.internal.zzft.zza
            public void zzmb() {
                zzaVar.zzi((zzft) zzaVar.zzblo);
            }
        });
        return zzfvVar;
    }

    public Future<zzft> zza(final Context context, final VersionInfoParcel versionInfoParcel, final String str, final zzas zzasVar) {
        final zza zzaVar = new zza();
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzfu.1
            @Override // java.lang.Runnable
            public void run() {
                zzfu.this.zza(context, versionInfoParcel, (zza<zzft>) zzaVar, zzasVar).zzbi(str);
            }
        });
        return zzaVar;
    }
}
