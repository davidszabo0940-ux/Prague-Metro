package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class zzrd {

    /* JADX INFO: renamed from: vt */
    private static final zzpr.zza<?, ?>[] f793vt = new zzpr.zza[0];

    /* JADX INFO: renamed from: tY */
    private final Map<Api.zzc<?>, Api.zze> f794tY;

    /* JADX INFO: renamed from: vu */
    final Set<zzpr.zza<?, ?>> f795vu;

    /* JADX INFO: renamed from: vv */
    private final zzb f796vv;

    private static class zza implements IBinder.DeathRecipient, zzb {

        /* JADX INFO: renamed from: vx */
        private final WeakReference<zzpr.zza<?, ?>> f798vx;

        /* JADX INFO: renamed from: vy */
        private final WeakReference<com.google.android.gms.common.api.zzd> f799vy;

        /* JADX INFO: renamed from: vz */
        private final WeakReference<IBinder> f800vz;

        private zza(zzpr.zza<?, ?> zzaVar, com.google.android.gms.common.api.zzd zzdVar, IBinder iBinder) {
            this.f799vy = new WeakReference<>(zzdVar);
            this.f798vx = new WeakReference<>(zzaVar);
            this.f800vz = new WeakReference<>(iBinder);
        }

        private void zzaqd() {
            zzpr.zza<?, ?> zzaVar = this.f798vx.get();
            com.google.android.gms.common.api.zzd zzdVar = this.f799vy.get();
            if (zzdVar != null && zzaVar != null) {
                zzdVar.remove(zzaVar.zzaog().intValue());
            }
            IBinder iBinder = this.f800vz.get();
            if (this.f800vz != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            zzaqd();
        }

        @Override // com.google.android.gms.internal.zzrd.zzb
        public void zzh(zzpr.zza<?, ?> zzaVar) {
            zzaqd();
        }
    }

    interface zzb {
        void zzh(zzpr.zza<?, ?> zzaVar);
    }

    public zzrd(Api.zzc<?> zzcVar, Api.zze zzeVar) {
        this.f795vu = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f796vv = new zzb() { // from class: com.google.android.gms.internal.zzrd.1
            @Override // com.google.android.gms.internal.zzrd.zzb
            public void zzh(zzpr.zza<?, ?> zzaVar) {
                zzrd.this.f795vu.remove(zzaVar);
                if (zzaVar.zzaog() == null || zzrd.zza(zzrd.this) == null) {
                    return;
                }
                zzrd.zza(zzrd.this).remove(zzaVar.zzaog().intValue());
            }
        };
        this.f794tY = new ArrayMap();
        this.f794tY.put(zzcVar, zzeVar);
    }

    public zzrd(Map<Api.zzc<?>, Api.zze> map) {
        this.f795vu = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f796vv = new zzb() { // from class: com.google.android.gms.internal.zzrd.1
            @Override // com.google.android.gms.internal.zzrd.zzb
            public void zzh(zzpr.zza<?, ?> zzaVar) {
                zzrd.this.f795vu.remove(zzaVar);
                if (zzaVar.zzaog() == null || zzrd.zza(zzrd.this) == null) {
                    return;
                }
                zzrd.zza(zzrd.this).remove(zzaVar.zzaog().intValue());
            }
        };
        this.f794tY = map;
    }

    static /* synthetic */ com.google.android.gms.common.api.zzd zza(zzrd zzrdVar) {
        return null;
    }

    private static void zza(zzpr.zza<?, ?> zzaVar, com.google.android.gms.common.api.zzd zzdVar, IBinder iBinder) {
        if (zzaVar.isReady()) {
            zzaVar.zza(new zza(zzaVar, zzdVar, iBinder));
            return;
        }
        if (iBinder == null || !iBinder.isBinderAlive()) {
            zzaVar.zza((zzb) null);
            zzaVar.cancel();
            zzdVar.remove(zzaVar.zzaog().intValue());
        } else {
            zza zzaVar2 = new zza(zzaVar, zzdVar, iBinder);
            zzaVar.zza(zzaVar2);
            try {
                iBinder.linkToDeath(zzaVar2, 0);
            } catch (RemoteException e) {
                zzaVar.cancel();
                zzdVar.remove(zzaVar.zzaog().intValue());
            }
        }
    }

    public void dump(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f795vu.size());
    }

    public void release() {
        for (zzpr.zza zzaVar : (zzpr.zza[]) this.f795vu.toArray(f793vt)) {
            zzaVar.zza((zzb) null);
            if (zzaVar.zzaog() != null) {
                zzaVar.zzaoo();
                zza(zzaVar, null, this.f794tY.get(zzaVar.zzanp()).zzans());
                this.f795vu.remove(zzaVar);
            } else if (zzaVar.zzaos()) {
                this.f795vu.remove(zzaVar);
            }
        }
    }

    public void zzaqv() {
        for (zzpr.zza zzaVar : (zzpr.zza[]) this.f795vu.toArray(f793vt)) {
            zzaVar.zzaa(new Status(8, "The connection to Google Play services was lost"));
        }
    }

    public boolean zzaqw() {
        for (zzpr.zza zzaVar : (zzpr.zza[]) this.f795vu.toArray(f793vt)) {
            if (!zzaVar.isReady()) {
                return true;
            }
        }
        return false;
    }

    <A extends Api.zzb> void zzg(zzpr.zza<? extends Result, A> zzaVar) {
        this.f795vu.add(zzaVar);
        zzaVar.zza(this.f796vv);
    }
}
