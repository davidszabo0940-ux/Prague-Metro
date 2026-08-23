package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzcc;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class AdvertisingIdClient {
    private final Context mContext;
    com.google.android.gms.common.zza zzajb;
    zzcc zzajc;
    boolean zzajd;
    Object zzaje;
    zza zzajf;
    final long zzajg;

    public static final class Info {
        private final String zzajl;
        private final boolean zzajm;

        public Info(String str, boolean z) {
            this.zzajl = str;
            this.zzajm = z;
        }

        public String getId() {
            return this.zzajl;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzajm;
        }

        public String toString() {
            String str = this.zzajl;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.zzajm).toString();
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzajh;
        private long zzaji;
        CountDownLatch zzajj = new CountDownLatch(1);
        boolean zzajk = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzajh = new WeakReference<>(advertisingIdClient);
            this.zzaji = j;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = this.zzajh.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzajk = true;
            }
        }

        public void cancel() {
            this.zzajj.countDown();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (this.zzajj.await(this.zzaji, TimeUnit.MILLISECONDS)) {
                    return;
                }
                disconnect();
            } catch (InterruptedException e) {
                disconnect();
            }
        }

        public boolean zzdk() {
            return this.zzajk;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000L);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.zzaje = new Object();
        zzab.zzaa(context);
        this.mContext = context;
        this.zzajd = false;
        this.zzajg = j;
    }

    public static Info getAdvertisingIdInfo(Context context) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L);
        try {
            advertisingIdClient.zze(false);
            return advertisingIdClient.getInfo();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    static zzcc zza(Context context, com.google.android.gms.common.zza zzaVar) throws IOException {
        try {
            return zzcc.zza.zzf(zzaVar.zza(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private void zzdj() {
        synchronized (this.zzaje) {
            if (this.zzajf != null) {
                this.zzajf.cancel();
                try {
                    this.zzajf.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzajg > 0) {
                this.zzajf = new zza(this, this.zzajg);
            }
        }
    }

    static com.google.android.gms.common.zza zzh(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, IOException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (zzc.zzand().isGooglePlayServicesAvailable(context)) {
                case 0:
                case 2:
                    com.google.android.gms.common.zza zzaVar = new com.google.android.gms.common.zza();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (zzb.zzaut().zza(context, intent, zzaVar, 1)) {
                            return zzaVar;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        throw new IOException(th);
                    }
                case 1:
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    public void finish() {
        zzab.zzhk("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null || this.zzajb == null) {
                return;
            }
            try {
                if (this.zzajd) {
                    zzb.zzaut().zza(this.mContext, this.zzajb);
                }
            } catch (IllegalArgumentException e) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", e);
            }
            this.zzajd = false;
            this.zzajc = null;
            this.zzajb = null;
        }
    }

    public Info getInfo() throws IOException {
        Info info;
        zzab.zzhk("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzajd) {
                zzab.zzaa(this.zzajb);
                zzab.zzaa(this.zzajc);
                info = new Info(this.zzajc.getId(), this.zzajc.zzf(true));
            } else {
                synchronized (this.zzaje) {
                    if (this.zzajf == null || !this.zzajf.zzdk()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zze(false);
                    if (!this.zzajd) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                    zzab.zzaa(this.zzajb);
                    zzab.zzaa(this.zzajc);
                    try {
                        info = new Info(this.zzajc.getId(), this.zzajc.zzf(true));
                    } catch (RemoteException e) {
                        Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                        throw new IOException("Remote exception");
                    }
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            throw th;
        }
        zzdj();
        return info;
    }

    public void start() throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        zze(true);
    }

    protected void zze(boolean z) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        zzab.zzhk("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzajd) {
                finish();
            }
            this.zzajb = zzh(this.mContext);
            this.zzajc = zza(this.mContext, this.zzajb);
            this.zzajd = true;
            if (z) {
                zzdj();
            }
        }
    }
}
