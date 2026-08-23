package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzkj {

    private static abstract class zza extends zzkg {
        private zza() {
        }

        @Override // com.google.android.gms.internal.zzkg
        public void onStop() {
        }
    }

    public interface zzb {
        void zzg(Bundle bundle);
    }

    public static Future zza(final Context context, final zzb zzbVar) {
        return (Future) new zza() { // from class: com.google.android.gms.internal.zzkj.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzkg
            public void zzew() {
                SharedPreferences sharedPreferencesZzn = zzkj.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("use_https", sharedPreferencesZzn.getBoolean("use_https", true));
                if (zzbVar != null) {
                    zzbVar.zzg(bundle);
                }
            }
        }.zzpz();
    }

    public static Future zza(final Context context, final String str, final long j) {
        return (Future) new zza() { // from class: com.google.android.gms.internal.zzkj.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzkg
            public void zzew() {
                SharedPreferences.Editor editorEdit = zzkj.zzn(context).edit();
                editorEdit.putString("app_settings_json", str);
                editorEdit.putLong("app_settings_last_update_ms", j);
                editorEdit.apply();
            }
        }.zzpz();
    }

    public static Future zzb(final Context context, final zzb zzbVar) {
        return (Future) new zza() { // from class: com.google.android.gms.internal.zzkj.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzkg
            public void zzew() {
                SharedPreferences sharedPreferencesZzn = zzkj.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putInt("webview_cache_version", sharedPreferencesZzn.getInt("webview_cache_version", 0));
                if (zzbVar != null) {
                    zzbVar.zzg(bundle);
                }
            }
        }.zzpz();
    }

    public static Future zzc(final Context context, final zzb zzbVar) {
        return (Future) new zza() { // from class: com.google.android.gms.internal.zzkj.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzkg
            public void zzew() {
                SharedPreferences sharedPreferencesZzn = zzkj.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", sharedPreferencesZzn.getBoolean("content_url_opted_out", true));
                if (zzbVar != null) {
                    zzbVar.zzg(bundle);
                }
            }
        }.zzpz();
    }

    public static Future zzc(final Context context, final boolean z) {
        return (Future) new zza() { // from class: com.google.android.gms.internal.zzkj.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzkg
            public void zzew() {
                SharedPreferences.Editor editorEdit = zzkj.zzn(context).edit();
                editorEdit.putBoolean("use_https", z);
                editorEdit.apply();
            }
        }.zzpz();
    }

    public static Future zzd(final Context context, final zzb zzbVar) {
        return (Future) new zza() { // from class: com.google.android.gms.internal.zzkj.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzkg
            public void zzew() {
                SharedPreferences sharedPreferencesZzn = zzkj.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putString("content_url_hashes", sharedPreferencesZzn.getString("content_url_hashes", ""));
                if (zzbVar != null) {
                    zzbVar.zzg(bundle);
                }
            }
        }.zzpz();
    }

    public static Future zze(final Context context, final zzb zzbVar) {
        return (Future) new zza() { // from class: com.google.android.gms.internal.zzkj.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzkg
            public void zzew() {
                SharedPreferences sharedPreferencesZzn = zzkj.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("auto_collect_location", sharedPreferencesZzn.getBoolean("auto_collect_location", false));
                if (zzbVar != null) {
                    zzbVar.zzg(bundle);
                }
            }
        }.zzpz();
    }

    public static Future zze(final Context context, final boolean z) {
        return (Future) new zza() { // from class: com.google.android.gms.internal.zzkj.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzkg
            public void zzew() {
                SharedPreferences.Editor editorEdit = zzkj.zzn(context).edit();
                editorEdit.putBoolean("content_url_opted_out", z);
                editorEdit.apply();
            }
        }.zzpz();
    }

    public static Future zzf(final Context context, final zzb zzbVar) {
        return (Future) new zza() { // from class: com.google.android.gms.internal.zzkj.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzkg
            public void zzew() {
                SharedPreferences sharedPreferencesZzn = zzkj.zzn(context);
                Bundle bundle = new Bundle();
                bundle.putString("app_settings_json", sharedPreferencesZzn.getString("app_settings_json", ""));
                bundle.putLong("app_settings_last_update_ms", sharedPreferencesZzn.getLong("app_settings_last_update_ms", 0L));
                if (zzbVar != null) {
                    zzbVar.zzg(bundle);
                }
            }
        }.zzpz();
    }

    public static Future zzf(final Context context, final boolean z) {
        return (Future) new zza() { // from class: com.google.android.gms.internal.zzkj.11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzkg
            public void zzew() {
                SharedPreferences.Editor editorEdit = zzkj.zzn(context).edit();
                editorEdit.putBoolean("auto_collect_location", z);
                editorEdit.apply();
            }
        }.zzpz();
    }

    public static Future zzg(final Context context, final String str) {
        return (Future) new zza() { // from class: com.google.android.gms.internal.zzkj.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.google.android.gms.internal.zzkg
            public void zzew() {
                SharedPreferences.Editor editorEdit = zzkj.zzn(context).edit();
                editorEdit.putString("content_url_hashes", str);
                editorEdit.apply();
            }
        }.zzpz();
    }

    public static SharedPreferences zzn(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
