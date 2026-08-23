package com.google.android.gms.ads.internal.util.client;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.internal.zzir;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzc implements zza.InterfaceC0740zza {

    @Nullable
    private final String zzbjj;

    public zzc() {
        this(null);
    }

    public zzc(@Nullable String str) {
        this.zzbjj = str;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zza.InterfaceC0740zza
    @WorkerThread
    public void zzcs(String str) {
        try {
            String strValueOf = String.valueOf(str);
            zzb.zzcw(strValueOf.length() != 0 ? "Pinging URL: ".concat(strValueOf) : new String("Pinging URL: "));
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                zzm.zziw().zza(true, httpURLConnection, this.zzbjj);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    zzb.zzcy(new StringBuilder(String.valueOf(str).length() + 65).append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(str).toString());
                }
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            String strValueOf2 = String.valueOf(e.getMessage());
            zzb.zzcy(new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(strValueOf2).length()).append("Error while pinging URL: ").append(str).append(". ").append(strValueOf2).toString());
        } catch (IndexOutOfBoundsException e2) {
            String strValueOf3 = String.valueOf(e2.getMessage());
            zzb.zzcy(new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(strValueOf3).length()).append("Error while parsing ping URL: ").append(str).append(". ").append(strValueOf3).toString());
        } catch (RuntimeException e3) {
            String strValueOf4 = String.valueOf(e3.getMessage());
            zzb.zzcy(new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(strValueOf4).length()).append("Error while pinging URL: ").append(str).append(". ").append(strValueOf4).toString());
        }
    }
}
