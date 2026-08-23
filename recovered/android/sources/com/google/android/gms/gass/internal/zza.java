package com.google.android.gms.gass.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzae;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class zza {

    /* JADX INFO: renamed from: com.google.android.gms.gass.internal.zza$zza, reason: collision with other inner class name */
    private static class C0758zza implements com.google.android.gms.common.internal.zzd.zzb, com.google.android.gms.common.internal.zzd.zzc {
        protected final zzb aar;
        private final String aas;
        private final LinkedBlockingQueue<zzae.zza> aat;
        private final HandlerThread aau = new HandlerThread("GassClient");
        private final String packageName;

        public C0758zza(Context context, String str, String str2) {
            this.packageName = str;
            this.aas = str2;
            this.aau.start();
            this.aar = new zzb(context, this.aau.getLooper(), this, this);
            this.aat = new LinkedBlockingQueue<>();
            connect();
        }

        protected void connect() {
            this.aar.zzart();
        }

        @Override // com.google.android.gms.common.internal.zzd.zzb
        public void onConnected(Bundle bundle) {
            zze zzeVarZzbly = zzbly();
            if (zzeVarZzbly != null) {
                try {
                    this.aat.put(zzeVarZzbly.zza(new GassRequestParcel(this.packageName, this.aas)).zzbma());
                    zzqx();
                    this.aau.quit();
                } catch (Throwable th) {
                    zzqx();
                    this.aau.quit();
                    throw th;
                }
            }
        }

        @Override // com.google.android.gms.common.internal.zzd.zzc
        public void onConnectionFailed(ConnectionResult connectionResult) {
        }

        @Override // com.google.android.gms.common.internal.zzd.zzb
        public void onConnectionSuspended(int i) {
        }

        protected zze zzbly() {
            try {
                return this.aar.zzarw();
            } catch (DeadObjectException e) {
                return null;
            }
        }

        public zzae.zza zzcm() {
            return zzse(2000);
        }

        public void zzqx() {
            if (this.aar != null) {
                this.aar.disconnect();
            }
        }

        public zzae.zza zzse(int i) {
            zzae.zza zzaVarPoll;
            try {
                zzaVarPoll = this.aat.poll(i, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                zzaVarPoll = null;
            }
            return zzaVarPoll == null ? new zzae.zza() : zzaVarPoll;
        }
    }

    public static zzae.zza zzf(Context context, String str, String str2) {
        return new C0758zza(context, str, str2).zzcm();
    }
}
