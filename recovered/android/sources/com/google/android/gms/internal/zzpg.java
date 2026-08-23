package com.google.android.gms.internal;

import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class zzpg implements com.google.android.gms.clearcut.zzc {

    /* JADX INFO: renamed from: qv */
    private static ScheduledExecutorService f539qv;

    /* JADX INFO: renamed from: hb */
    private GoogleApiClient f542hb;

    /* JADX INFO: renamed from: qA */
    private long f543qA;

    /* JADX INFO: renamed from: qB */
    private final long f544qB;

    /* JADX INFO: renamed from: qC */
    private ScheduledFuture<?> f545qC;

    /* JADX INFO: renamed from: qD */
    private final Runnable f546qD;

    /* JADX INFO: renamed from: qy */
    private final zza f547qy;

    /* JADX INFO: renamed from: qz */
    private final Object f548qz;
    private final com.google.android.gms.common.util.zze zzaoa;

    /* JADX INFO: renamed from: qu */
    private static final Object f538qu = new Object();

    /* JADX INFO: renamed from: qw */
    private static final zze f540qw = new zze();

    /* JADX INFO: renamed from: qx */
    private static final long f541qx = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);

    public interface zza {
    }

    public static class zzb implements zza {
    }

    static abstract class zzc<R extends Result> extends zzpr.zza<R, zzph> {
        public zzc(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.clearcut.zzb.API, googleApiClient);
        }
    }

    static final class zzd extends zzc<Status> {

        /* JADX INFO: renamed from: qI */
        private final LogEventParcelable f557qI;

        zzd(LogEventParcelable logEventParcelable, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.f557qI = logEventParcelable;
        }

        public boolean equals(Object obj) {
            if (obj instanceof zzd) {
                return this.f557qI.equals(((zzd) obj).f557qI);
            }
            return false;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f557qI);
            return new StringBuilder(String.valueOf(strValueOf).length() + 12).append("MethodImpl(").append(strValueOf).append(")").toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzpr.zza
        public void zza(zzph zzphVar) throws RemoteException {
            zzpj.zza zzaVar = new zzpj.zza() { // from class: com.google.android.gms.internal.zzpg.zzd.1
                @Override // com.google.android.gms.internal.zzpj
                public void zzw(Status status) {
                    zzd.this.zzc(status);
                }
            };
            try {
                zzpg.zza(this.f557qI);
                zzphVar.zza(zzaVar, this.f557qI);
            } catch (RuntimeException e) {
                Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e);
                zzz(new Status(10, "MessageProducer"));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzpt
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    private static final class zze {
        private int mSize;

        private zze() {
            this.mSize = 0;
        }

        public synchronized void zzamz() {
            this.mSize++;
        }

        public synchronized void zzana() {
            if (this.mSize == 0) {
                throw new RuntimeException("too many decrements");
            }
            this.mSize--;
            if (this.mSize == 0) {
                notifyAll();
            }
        }
    }

    public zzpg() {
        this(new com.google.android.gms.common.util.zzh(), f541qx, new zzb());
    }

    public zzpg(com.google.android.gms.common.util.zze zzeVar, long j, zza zzaVar) {
        this.f548qz = new Object();
        this.f543qA = 0L;
        this.f545qC = null;
        this.f542hb = null;
        this.f546qD = new Runnable() { // from class: com.google.android.gms.internal.zzpg.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (zzpg.this.f548qz) {
                    if (zzpg.zzb(zzpg.this) <= zzpg.this.zzaoa.elapsedRealtime() && zzpg.this.f542hb != null) {
                        Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                        zzpg.this.f542hb.disconnect();
                        zzpg.this.f542hb = null;
                    }
                }
            }
        };
        this.zzaoa = zzeVar;
        this.f544qB = j;
        this.f547qy = zzaVar;
    }

    private PendingResult<Status> zza(final GoogleApiClient googleApiClient, final zzc<Status> zzcVar) {
        zzamx().execute(new Runnable() { // from class: com.google.android.gms.internal.zzpg.3
            @Override // java.lang.Runnable
            public void run() {
                googleApiClient.zzc(zzcVar);
            }
        });
        return zzcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(LogEventParcelable logEventParcelable) {
        if (logEventParcelable.f70qs != null && logEventParcelable.f69qr.biM.length == 0) {
            logEventParcelable.f69qr.biM = logEventParcelable.f70qs.zzamw();
        }
        if (logEventParcelable.f71qt != null && logEventParcelable.f69qr.biT.length == 0) {
            logEventParcelable.f69qr.biT = logEventParcelable.f71qt.zzamw();
        }
        logEventParcelable.f63ql = zzapc.zzf(logEventParcelable.f69qr);
    }

    private ScheduledExecutorService zzamx() {
        synchronized (f538qu) {
            if (f539qv == null) {
                f539qv = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.google.android.gms.internal.zzpg.2
                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(final Runnable runnable) {
                        return new Thread(new Runnable() { // from class: com.google.android.gms.internal.zzpg.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Process.setThreadPriority(10);
                                runnable.run();
                            }
                        }, "ClearcutLoggerApiImpl");
                    }
                });
            }
        }
        return f539qv;
    }

    static /* synthetic */ long zzb(zzpg zzpgVar) {
        return 0L;
    }

    private zzd zzb(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        f540qw.zzamz();
        zzd zzdVar = new zzd(logEventParcelable, googleApiClient);
        zzdVar.zza(new PendingResult.zza() { // from class: com.google.android.gms.internal.zzpg.4
            @Override // com.google.android.gms.common.api.PendingResult.zza
            public void zzv(Status status) {
                zzpg.f540qw.zzana();
            }
        });
        return zzdVar;
    }

    @Override // com.google.android.gms.clearcut.zzc
    public PendingResult<Status> zza(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        return zza(googleApiClient, zzb(googleApiClient, logEventParcelable));
    }
}
