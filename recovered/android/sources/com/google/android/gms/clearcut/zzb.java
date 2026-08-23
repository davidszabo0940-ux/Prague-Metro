package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzapg;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.internal.zzph;
import com.google.android.gms.internal.zzpl;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class zzb {

    /* JADX INFO: renamed from: aQ */
    private final String f78aQ;
    private final Context mContext;

    /* JADX INFO: renamed from: pQ */
    private final int f79pQ;

    /* JADX INFO: renamed from: pR */
    private String f80pR;

    /* JADX INFO: renamed from: pS */
    private int f81pS;

    /* JADX INFO: renamed from: pT */
    private String f82pT;

    /* JADX INFO: renamed from: pU */
    private String f83pU;

    /* JADX INFO: renamed from: pV */
    private final boolean f84pV;

    /* JADX INFO: renamed from: pW */
    private int f85pW;

    /* JADX INFO: renamed from: pX */
    private final com.google.android.gms.clearcut.zzc f86pX;

    /* JADX INFO: renamed from: pY */
    private final com.google.android.gms.clearcut.zza f87pY;

    /* JADX INFO: renamed from: pZ */
    private zzd f88pZ;

    /* JADX INFO: renamed from: qa */
    private final InterfaceC0741zzb f89qa;
    private final zze zzaoa;

    /* JADX INFO: renamed from: bN */
    public static final Api.zzf<zzph> f75bN = new Api.zzf<>();

    /* JADX INFO: renamed from: bO */
    public static final Api.zza<zzph, Api.ApiOptions.NoOptions> f76bO = new Api.zza<zzph, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.clearcut.zzb.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
        public zzph zza(Context context, Looper looper, zzg zzgVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzph(context, looper, zzgVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("ClearcutLogger.API", f76bO, f75bN);

    /* JADX INFO: renamed from: pP */
    public static final com.google.android.gms.clearcut.zzc f77pP = new zzpg();

    public class zza {

        /* JADX INFO: renamed from: pR */
        private String f90pR;

        /* JADX INFO: renamed from: pS */
        private int f91pS;

        /* JADX INFO: renamed from: pT */
        private String f92pT;

        /* JADX INFO: renamed from: pU */
        private String f93pU;

        /* JADX INFO: renamed from: pW */
        private int f94pW;

        /* JADX INFO: renamed from: qb */
        private final zzc f95qb;

        /* JADX INFO: renamed from: qc */
        private ArrayList<Integer> f96qc;

        /* JADX INFO: renamed from: qd */
        private ArrayList<String> f97qd;

        /* JADX INFO: renamed from: qe */
        private ArrayList<Integer> f98qe;

        /* JADX INFO: renamed from: qf */
        private ArrayList<byte[]> f99qf;

        /* JADX INFO: renamed from: qg */
        private boolean f100qg;

        /* JADX INFO: renamed from: qh */
        private final zzapg.zzd f101qh;

        /* JADX INFO: renamed from: qi */
        private boolean f102qi;

        private zza(zzb zzbVar, byte[] bArr) {
            this(bArr, (zzc) null);
        }

        private zza(byte[] bArr, zzc zzcVar) {
            this.f91pS = zzb.this.f81pS;
            this.f90pR = zzb.this.f80pR;
            this.f92pT = zzb.this.f82pT;
            this.f93pU = zzb.this.f83pU;
            this.f94pW = zzb.zze(zzb.this);
            this.f96qc = null;
            this.f97qd = null;
            this.f98qe = null;
            this.f99qf = null;
            this.f100qg = true;
            this.f101qh = new zzapg.zzd();
            this.f102qi = false;
            this.f92pT = zzb.this.f82pT;
            this.f93pU = zzb.this.f83pU;
            this.f101qh.biF = zzb.this.zzaoa.currentTimeMillis();
            this.f101qh.biG = zzb.this.zzaoa.elapsedRealtime();
            this.f101qh.biX = zzb.this.f87pY.zzbk(zzb.this.mContext);
            this.f101qh.biR = zzb.this.f88pZ.zzae(this.f101qh.biF);
            if (bArr != null) {
                this.f101qh.biM = bArr;
            }
            this.f95qb = zzcVar;
        }

        public LogEventParcelable zzamv() {
            return new LogEventParcelable(new PlayLoggerContext(zzb.this.f78aQ, zzb.this.f79pQ, this.f91pS, this.f90pR, this.f92pT, this.f93pU, zzb.this.f84pV, this.f94pW), this.f101qh, this.f95qb, null, zzb.zzb((ArrayList<Integer>) null), zzb.zzc((ArrayList<String>) null), zzb.zzb((ArrayList<Integer>) null), zzb.zzd((ArrayList<byte[]>) null), this.f100qg);
        }

        public PendingResult<Status> zze(GoogleApiClient googleApiClient) {
            if (this.f102qi) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.f102qi = true;
            PlayLoggerContext playLoggerContext = zzamv().f62qk;
            return zzb.this.f89qa.zzg(playLoggerContext.asm, playLoggerContext.asi) ? zzb.this.f86pX.zza(googleApiClient, zzamv()) : PendingResults.immediatePendingResult(Status.f151sg);
        }

        public zza zzew(int i) {
            this.f101qh.biI = i;
            return this;
        }

        public zza zzex(int i) {
            this.f101qh.zzahl = i;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.clearcut.zzb$zzb, reason: collision with other inner class name */
    public interface InterfaceC0741zzb {
        boolean zzg(String str, int i);
    }

    public interface zzc {
        byte[] zzamw();
    }

    public static class zzd {
        public long zzae(long j) {
            return TimeZone.getDefault().getOffset(j) / 1000;
        }
    }

    public zzb(Context context, int i, String str, String str2, String str3, boolean z, com.google.android.gms.clearcut.zzc zzcVar, zze zzeVar, zzd zzdVar, com.google.android.gms.clearcut.zza zzaVar, InterfaceC0741zzb interfaceC0741zzb) {
        this.f81pS = -1;
        this.f85pW = 0;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext == null ? context : applicationContext;
        this.f78aQ = context.getPackageName();
        this.f79pQ = zzbl(context);
        this.f81pS = i;
        this.f80pR = str;
        this.f82pT = str2;
        this.f83pU = str3;
        this.f84pV = z;
        this.f86pX = zzcVar;
        this.zzaoa = zzeVar;
        this.f88pZ = zzdVar == null ? new zzd() : zzdVar;
        this.f87pY = zzaVar;
        this.f85pW = 0;
        this.f89qa = interfaceC0741zzb;
        if (this.f84pV) {
            zzab.zzb(this.f82pT == null, "can't be anonymous with an upload account");
        }
    }

    public zzb(Context context, String str, String str2) {
        this(context, -1, str, str2, null, false, f77pP, zzh.zzavi(), null, com.google.android.gms.clearcut.zza.f74pO, new zzpl(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] zzb(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        Iterator<Integer> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return iArr;
            }
            i = i2 + 1;
            iArr[i2] = it.next().intValue();
        }
    }

    private int zzbl(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] zzc(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[][] zzd(ArrayList<byte[]> arrayList) {
        if (arrayList == null) {
            return null;
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    static /* synthetic */ int zze(zzb zzbVar) {
        return 0;
    }

    public zza zzl(byte[] bArr) {
        return new zza(bArr);
    }
}
