package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class zzpp extends zzps {

    /* JADX INFO: renamed from: ss */
    private final SparseArray<zza> f572ss;

    private class zza implements GoogleApiClient.OnConnectionFailedListener {

        /* JADX INFO: renamed from: st */
        public final int f573st;

        /* JADX INFO: renamed from: su */
        public final GoogleApiClient f574su;

        /* JADX INFO: renamed from: sv */
        public final GoogleApiClient.OnConnectionFailedListener f575sv;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.f573st = i;
            this.f574su = googleApiClient;
            this.f575sv = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append((CharSequence) str).append("GoogleApiClient #").print(this.f573st);
            printWriter.println(":");
            this.f574su.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            String strValueOf = String.valueOf(connectionResult);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(strValueOf).length() + 27).append("beginFailureResolution for ").append(strValueOf).toString());
            zzpp.this.zzb(connectionResult, this.f573st);
        }

        public void zzaom() {
            this.f574su.unregisterConnectionFailedListener(this);
            this.f574su.disconnect();
        }
    }

    private zzpp(zzqp zzqpVar) {
        super(zzqpVar);
        this.f572ss = new SparseArray<>();
        this.f763va.zza("AutoManageHelper", this);
    }

    public static zzpp zza(zzqn zzqnVar) {
        zzqp zzqpVarZzc = zzc(zzqnVar);
        zzpp zzppVar = (zzpp) zzqpVarZzc.zza("AutoManageHelper", zzpp.class);
        return zzppVar != null ? zzppVar : new zzpp(zzqpVarZzc);
    }

    @Override // com.google.android.gms.internal.zzqo
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f572ss.size()) {
                return;
            }
            this.f572ss.valueAt(i2).dump(str, fileDescriptor, printWriter, strArr);
            i = i2 + 1;
        }
    }

    @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzqo
    public void onStart() {
        super.onStart();
        boolean z = this.mStarted;
        String strValueOf = String.valueOf(this.f572ss);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(strValueOf).length() + 14).append("onStart ").append(z).append(" ").append(strValueOf).toString());
        if (this.f583sB) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f572ss.size()) {
                return;
            }
            this.f572ss.valueAt(i2).f574su.connect();
            i = i2 + 1;
        }
    }

    @Override // com.google.android.gms.internal.zzps, com.google.android.gms.internal.zzqo
    public void onStop() {
        super.onStop();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f572ss.size()) {
                return;
            }
            this.f572ss.valueAt(i2).f574su.disconnect();
            i = i2 + 1;
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        com.google.android.gms.common.internal.zzab.zzb(googleApiClient, "GoogleApiClient instance cannot be null");
        com.google.android.gms.common.internal.zzab.zza(this.f572ss.indexOfKey(i) < 0, new StringBuilder(54).append("Already managing a GoogleApiClient with id ").append(i).toString());
        Log.d("AutoManageHelper", new StringBuilder(54).append("starting AutoManage for client ").append(i).append(" ").append(this.mStarted).append(" ").append(this.f583sB).toString());
        this.f572ss.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (!this.mStarted || this.f583sB) {
            return;
        }
        String strValueOf = String.valueOf(googleApiClient);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(strValueOf).length() + 11).append("connecting ").append(strValueOf).toString());
        googleApiClient.connect();
    }

    @Override // com.google.android.gms.internal.zzps
    protected void zza(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zza zzaVar = this.f572ss.get(i);
        if (zzaVar != null) {
            zzff(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zzaVar.f575sv;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzps
    protected void zzaol() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f572ss.size()) {
                return;
            }
            this.f572ss.valueAt(i2).f574su.connect();
            i = i2 + 1;
        }
    }

    public void zzff(int i) {
        zza zzaVar = this.f572ss.get(i);
        this.f572ss.remove(i);
        if (zzaVar != null) {
            zzaVar.zzaom();
        }
    }
}
