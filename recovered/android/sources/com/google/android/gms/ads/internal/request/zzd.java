package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzle;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzd implements zzc.zza, zzkn<Void> {
    private final Object zzail = new Object();
    private final zzle<AdRequestInfoParcel> zzcan;
    private final zzc.zza zzcao;

    @zzir
    public static final class zza extends zzd {
        private final Context mContext;

        public zza(Context context, zzle<AdRequestInfoParcel> zzleVar, zzc.zza zzaVar) {
            super(zzleVar, zzaVar);
            this.mContext = context;
        }

        @Override // com.google.android.gms.ads.internal.request.zzd, com.google.android.gms.internal.zzkn
        public /* synthetic */ Void zzpz() {
            return super.zzpz();
        }

        @Override // com.google.android.gms.ads.internal.request.zzd
        public void zzqx() {
        }

        @Override // com.google.android.gms.ads.internal.request.zzd
        public zzk zzqy() {
            return zzit.zza(this.mContext, new zzcv(zzdc.zzaxw.get()), zzis.zzrg());
        }
    }

    @zzir
    public static class zzb extends zzd implements com.google.android.gms.common.internal.zzd.zzb, com.google.android.gms.common.internal.zzd.zzc {
        private Context mContext;
        private final Object zzail;
        private VersionInfoParcel zzalm;
        private zzle<AdRequestInfoParcel> zzcan;
        private final zzc.zza zzcao;
        protected zze zzcar;
        private boolean zzcas;

        public zzb(Context context, VersionInfoParcel versionInfoParcel, zzle<AdRequestInfoParcel> zzleVar, zzc.zza zzaVar) {
            Looper mainLooper;
            super(zzleVar, zzaVar);
            this.zzail = new Object();
            this.mContext = context;
            this.zzalm = versionInfoParcel;
            this.zzcan = zzleVar;
            this.zzcao = zzaVar;
            if (zzdc.zzayw.get().booleanValue()) {
                this.zzcas = true;
                mainLooper = zzu.zzgc().zztr();
            } else {
                mainLooper = context.getMainLooper();
            }
            this.zzcar = new zze(context, mainLooper, this, this, this.zzalm.zzcnp);
            connect();
        }

        protected void connect() {
            this.zzcar.zzart();
        }

        @Override // com.google.android.gms.common.internal.zzd.zzb
        public void onConnected(Bundle bundle) {
        }

        @Override // com.google.android.gms.common.internal.zzd.zzc
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzkh.zzcw("Cannot connect to remote service, fallback to local instance.");
            zzqz().zzpz();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            zzu.zzfq().zzb(this.mContext, this.zzalm.zzcs, "gmob-apps", bundle, true);
        }

        @Override // com.google.android.gms.common.internal.zzd.zzb
        public void onConnectionSuspended(int i) {
            zzkh.zzcw("Disconnected from remote ad request service.");
        }

        @Override // com.google.android.gms.ads.internal.request.zzd, com.google.android.gms.internal.zzkn
        public /* synthetic */ Void zzpz() {
            return super.zzpz();
        }

        @Override // com.google.android.gms.ads.internal.request.zzd
        public void zzqx() {
            synchronized (this.zzail) {
                if (this.zzcar.isConnected() || this.zzcar.isConnecting()) {
                    this.zzcar.disconnect();
                }
                Binder.flushPendingCommands();
                if (this.zzcas) {
                    zzu.zzgc().zzts();
                    this.zzcas = false;
                }
            }
        }

        @Override // com.google.android.gms.ads.internal.request.zzd
        public zzk zzqy() {
            zzk zzkVarZzrc;
            synchronized (this.zzail) {
                try {
                    zzkVarZzrc = this.zzcar.zzrc();
                } catch (DeadObjectException | IllegalStateException e) {
                    zzkVarZzrc = null;
                }
            }
            return zzkVarZzrc;
        }

        zzkn zzqz() {
            return new zza(this.mContext, this.zzcan, this.zzcao);
        }
    }

    public zzd(zzle<AdRequestInfoParcel> zzleVar, zzc.zza zzaVar) {
        this.zzcan = zzleVar;
        this.zzcao = zzaVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public void cancel() {
        zzqx();
    }

    boolean zza(zzk zzkVar, AdRequestInfoParcel adRequestInfoParcel) {
        try {
            zzkVar.zza(adRequestInfoParcel, new zzg(this));
            return true;
        } catch (RemoteException e) {
            zzkh.zzd("Could not fetch ad response from ad request service.", e);
            zzu.zzft().zzb((Throwable) e, true);
            this.zzcao.zzb(new AdResponseParcel(0));
            return false;
        } catch (NullPointerException e2) {
            zzkh.zzd("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzu.zzft().zzb((Throwable) e2, true);
            this.zzcao.zzb(new AdResponseParcel(0));
            return false;
        } catch (SecurityException e3) {
            zzkh.zzd("Could not fetch ad response from ad request service due to an Exception.", e3);
            zzu.zzft().zzb((Throwable) e3, true);
            this.zzcao.zzb(new AdResponseParcel(0));
            return false;
        } catch (Throwable th) {
            zzkh.zzd("Could not fetch ad response from ad request service due to an Exception.", th);
            zzu.zzft().zzb(th, true);
            this.zzcao.zzb(new AdResponseParcel(0));
            return false;
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzc.zza
    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.zzail) {
            this.zzcao.zzb(adResponseParcel);
            zzqx();
        }
    }

    @Override // com.google.android.gms.internal.zzkn
    /* JADX INFO: renamed from: zzpw, reason: merged with bridge method [inline-methods] */
    public Void zzpz() {
        final zzk zzkVarZzqy = zzqy();
        if (zzkVarZzqy == null) {
            this.zzcao.zzb(new AdResponseParcel(0));
            zzqx();
        } else {
            this.zzcan.zza(new zzle.zzc<AdRequestInfoParcel>() { // from class: com.google.android.gms.ads.internal.request.zzd.1
                @Override // com.google.android.gms.internal.zzle.zzc
                /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
                public void zzd(AdRequestInfoParcel adRequestInfoParcel) {
                    if (zzd.this.zza(zzkVarZzqy, adRequestInfoParcel)) {
                        return;
                    }
                    zzd.this.zzqx();
                }
            }, new zzle.zza() { // from class: com.google.android.gms.ads.internal.request.zzd.2
                @Override // com.google.android.gms.internal.zzle.zza
                public void run() {
                    zzd.this.zzqx();
                }
            });
        }
        return null;
    }

    public abstract void zzqx();

    public abstract zzk zzqy();
}
