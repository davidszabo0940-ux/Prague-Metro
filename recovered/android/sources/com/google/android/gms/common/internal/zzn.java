package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzn extends zzm implements Handler.Callback {
    private final Handler mHandler;

    /* JADX INFO: renamed from: yB */
    private final HashMap<zza, zzb> f354yB = new HashMap<>();

    /* JADX INFO: renamed from: yC */
    private final com.google.android.gms.common.stats.zzb f355yC = com.google.android.gms.common.stats.zzb.zzaut();

    /* JADX INFO: renamed from: yD */
    private final long f356yD = 5000;
    private final Context zzaqj;

    private static final class zza {

        /* JADX INFO: renamed from: yE */
        private final String f357yE;

        /* JADX INFO: renamed from: yF */
        private final ComponentName f358yF;
        private final String zzcvf;

        public zza(ComponentName componentName) {
            this.zzcvf = null;
            this.f357yE = null;
            this.f358yF = (ComponentName) zzab.zzaa(componentName);
        }

        public zza(String str, String str2) {
            this.zzcvf = zzab.zzhs(str);
            this.f357yE = zzab.zzhs(str2);
            this.f358yF = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return zzaa.equal(this.zzcvf, zzaVar.zzcvf) && zzaa.equal(this.f358yF, zzaVar.f358yF);
        }

        public int hashCode() {
            return zzaa.hashCode(this.zzcvf, this.f358yF);
        }

        public String toString() {
            return this.zzcvf == null ? this.f358yF.flattenToString() : this.zzcvf;
        }

        public Intent zzasu() {
            return this.zzcvf != null ? new Intent(this.zzcvf).setPackage(this.f357yE) : new Intent().setComponent(this.f358yF);
        }
    }

    private final class zzb {

        /* JADX INFO: renamed from: xA */
        private IBinder f359xA;

        /* JADX INFO: renamed from: yF */
        private ComponentName f360yF;

        /* JADX INFO: renamed from: yI */
        private boolean f363yI;

        /* JADX INFO: renamed from: yJ */
        private final zza f364yJ;

        /* JADX INFO: renamed from: yG */
        private final zza f361yG = new zza();

        /* JADX INFO: renamed from: yH */
        private final Set<ServiceConnection> f362yH = new HashSet();
        private int mState = 2;

        public class zza implements ServiceConnection {
            public zza() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (zzn.this.f354yB) {
                    zzb.this.f359xA = iBinder;
                    zzb.this.f360yF = componentName;
                    Iterator it = zzb.this.f362yH.iterator();
                    while (it.hasNext()) {
                        ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                    }
                    zzb.this.mState = 1;
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (zzn.this.f354yB) {
                    zzb.this.f359xA = null;
                    zzb.this.f360yF = componentName;
                    Iterator it = zzb.this.f362yH.iterator();
                    while (it.hasNext()) {
                        ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                    }
                    zzb.this.mState = 2;
                }
            }
        }

        public zzb(zza zzaVar) {
            this.f364yJ = zzaVar;
        }

        public IBinder getBinder() {
            return this.f359xA;
        }

        public ComponentName getComponentName() {
            return this.f360yF;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.f363yI;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            zzn.this.f355yC.zza(zzn.this.zzaqj, serviceConnection, str, this.f364yJ.zzasu());
            this.f362yH.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.f362yH.contains(serviceConnection);
        }

        public boolean zzasv() {
            return this.f362yH.isEmpty();
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            zzn.this.f355yC.zzb(zzn.this.zzaqj, serviceConnection);
            this.f362yH.remove(serviceConnection);
        }

        @TargetApi(14)
        public void zzhn(String str) {
            this.mState = 3;
            this.f363yI = zzn.this.f355yC.zza(zzn.this.zzaqj, str, this.f364yJ.zzasu(), this.f361yG, 129);
            if (this.f363yI) {
                return;
            }
            this.mState = 2;
            try {
                zzn.this.f355yC.zza(zzn.this.zzaqj, this.f361yG);
            } catch (IllegalArgumentException e) {
            }
        }

        public void zzho(String str) {
            zzn.this.f355yC.zza(zzn.this.zzaqj, this.f361yG);
            this.f363yI = false;
            this.mState = 2;
        }
    }

    zzn(Context context) {
        this.zzaqj = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
    }

    private boolean zza(zza zzaVar, ServiceConnection serviceConnection, String str) {
        boolean zIsBound;
        zzab.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f354yB) {
            zzb zzbVar = this.f354yB.get(zzaVar);
            if (zzbVar != null) {
                this.mHandler.removeMessages(0, zzbVar);
                if (!zzbVar.zza(serviceConnection)) {
                    zzbVar.zza(serviceConnection, str);
                    switch (zzbVar.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzbVar.getComponentName(), zzbVar.getBinder());
                            break;
                        case 2:
                            zzbVar.zzhn(str);
                            break;
                    }
                } else {
                    String strValueOf = String.valueOf(zzaVar);
                    throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(strValueOf).toString());
                }
            } else {
                zzbVar = new zzb(zzaVar);
                zzbVar.zza(serviceConnection, str);
                zzbVar.zzhn(str);
                this.f354yB.put(zzaVar, zzbVar);
            }
            zIsBound = zzbVar.isBound();
        }
        return zIsBound;
    }

    private void zzb(zza zzaVar, ServiceConnection serviceConnection, String str) {
        zzab.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f354yB) {
            zzb zzbVar = this.f354yB.get(zzaVar);
            if (zzbVar == null) {
                String strValueOf = String.valueOf(zzaVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 50).append("Nonexistent connection status for service config: ").append(strValueOf).toString());
            }
            if (!zzbVar.zza(serviceConnection)) {
                String strValueOf2 = String.valueOf(zzaVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf2).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(strValueOf2).toString());
            }
            zzbVar.zzb(serviceConnection, str);
            if (zzbVar.zzasv()) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzbVar), this.f356yD);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                zzb zzbVar = (zzb) message.obj;
                synchronized (this.f354yB) {
                    if (zzbVar.zzasv()) {
                        if (zzbVar.isBound()) {
                            zzbVar.zzho("GmsClientSupervisor");
                        }
                        this.f354yB.remove(zzbVar.f364yJ);
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.gms.common.internal.zzm
    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    @Override // com.google.android.gms.common.internal.zzm
    public boolean zza(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return zza(new zza(str, str2), serviceConnection, str3);
    }

    @Override // com.google.android.gms.common.internal.zzm
    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    @Override // com.google.android.gms.common.internal.zzm
    public void zzb(String str, String str2, ServiceConnection serviceConnection, String str3) {
        zzb(new zza(str, str2), serviceConnection, str3);
    }
}
