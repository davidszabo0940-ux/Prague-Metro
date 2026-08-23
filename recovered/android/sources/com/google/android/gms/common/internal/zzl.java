package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzl implements Handler.Callback {
    private final Handler mHandler;

    /* JADX INFO: renamed from: ys */
    private final zza f345ys;

    /* JADX INFO: renamed from: yt */
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> f346yt = new ArrayList<>();

    /* JADX INFO: renamed from: yu */
    final ArrayList<GoogleApiClient.ConnectionCallbacks> f347yu = new ArrayList<>();

    /* JADX INFO: renamed from: yv */
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> f348yv = new ArrayList<>();

    /* JADX INFO: renamed from: yw */
    private volatile boolean f349yw = false;

    /* JADX INFO: renamed from: yx */
    private final AtomicInteger f350yx = new AtomicInteger(0);

    /* JADX INFO: renamed from: yy */
    private boolean f351yy = false;
    private final Object zzail = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzamc();
    }

    public zzl(Looper looper, zza zzaVar) {
        this.f345ys = zzaVar;
        this.mHandler = new Handler(looper, this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            Log.wtf("GmsClientEvents", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
            return false;
        }
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
        synchronized (this.zzail) {
            if (this.f349yw && this.f345ys.isConnected() && this.f346yt.contains(connectionCallbacks)) {
                connectionCallbacks.onConnected(this.f345ys.zzamc());
            }
        }
        return true;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean zContains;
        zzab.zzaa(connectionCallbacks);
        synchronized (this.zzail) {
            zContains = this.f346yt.contains(connectionCallbacks);
        }
        return zContains;
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean zContains;
        zzab.zzaa(onConnectionFailedListener);
        synchronized (this.zzail) {
            zContains = this.f348yv.contains(onConnectionFailedListener);
        }
        return zContains;
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzab.zzaa(connectionCallbacks);
        synchronized (this.zzail) {
            if (this.f346yt.contains(connectionCallbacks)) {
                String strValueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(strValueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(strValueOf).append(" is already registered").toString());
            } else {
                this.f346yt.add(connectionCallbacks);
            }
        }
        if (this.f345ys.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks));
        }
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzab.zzaa(onConnectionFailedListener);
        synchronized (this.zzail) {
            if (this.f348yv.contains(onConnectionFailedListener)) {
                String strValueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(strValueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(strValueOf).append(" is already registered").toString());
            } else {
                this.f348yv.add(onConnectionFailedListener);
            }
        }
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzab.zzaa(connectionCallbacks);
        synchronized (this.zzail) {
            if (!this.f346yt.remove(connectionCallbacks)) {
                String strValueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(strValueOf).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(strValueOf).append(" not found").toString());
            } else if (this.f351yy) {
                this.f347yu.add(connectionCallbacks);
            }
        }
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzab.zzaa(onConnectionFailedListener);
        synchronized (this.zzail) {
            if (!this.f348yv.remove(onConnectionFailedListener)) {
                String strValueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(strValueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(strValueOf).append(" not found").toString());
            }
        }
    }

    public void zzass() {
        this.f349yw = false;
        this.f350yx.incrementAndGet();
    }

    public void zzast() {
        this.f349yw = true;
    }

    public void zzgb(int i) {
        zzab.zza(Looper.myLooper() == this.mHandler.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzail) {
            this.f351yy = true;
            ArrayList<GoogleApiClient.ConnectionCallbacks> arrayList = new ArrayList(this.f346yt);
            int i2 = this.f350yx.get();
            for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : arrayList) {
                if (!this.f349yw || this.f350yx.get() != i2) {
                    break;
                } else if (this.f346yt.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.f347yu.clear();
            this.f351yy = false;
        }
    }

    public void zzm(ConnectionResult connectionResult) {
        zzab.zza(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionFailure must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzail) {
            ArrayList<GoogleApiClient.OnConnectionFailedListener> arrayList = new ArrayList(this.f348yv);
            int i = this.f350yx.get();
            for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : arrayList) {
                if (!this.f349yw || this.f350yx.get() != i) {
                    return;
                }
                if (this.f348yv.contains(onConnectionFailedListener)) {
                    onConnectionFailedListener.onConnectionFailed(connectionResult);
                }
            }
        }
    }

    public void zzo(Bundle bundle) {
        zzab.zza(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zzail) {
            zzab.zzbm(!this.f351yy);
            this.mHandler.removeMessages(1);
            this.f351yy = true;
            zzab.zzbm(this.f347yu.size() == 0);
            ArrayList<GoogleApiClient.ConnectionCallbacks> arrayList = new ArrayList(this.f346yt);
            int i = this.f350yx.get();
            for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : arrayList) {
                if (!this.f349yw || !this.f345ys.isConnected() || this.f350yx.get() != i) {
                    break;
                } else if (!this.f347yu.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.f347yu.clear();
            this.f351yy = false;
        }
    }
}
