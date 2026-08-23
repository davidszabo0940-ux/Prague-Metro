package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzd<T extends IInterface> {

    /* JADX INFO: renamed from: xt */
    public static final String[] f271xt = {"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;

    /* JADX INFO: renamed from: tp */
    private final com.google.android.gms.common.zzc f272tp;

    /* JADX INFO: renamed from: xb */
    private int f273xb;

    /* JADX INFO: renamed from: xc */
    private long f274xc;

    /* JADX INFO: renamed from: xd */
    private long f275xd;

    /* JADX INFO: renamed from: xe */
    private int f276xe;

    /* JADX INFO: renamed from: xf */
    private long f277xf;

    /* JADX INFO: renamed from: xg */
    private final zzm f278xg;

    /* JADX INFO: renamed from: xh */
    private final Object f279xh;

    /* JADX INFO: renamed from: xi */
    private zzu f280xi;

    /* JADX INFO: renamed from: xj */
    private zzf f281xj;

    /* JADX INFO: renamed from: xk */
    private T f282xk;

    /* JADX INFO: renamed from: xl */
    private final ArrayList<zze<?>> f283xl;

    /* JADX INFO: renamed from: xm */
    private zzh f284xm;

    /* JADX INFO: renamed from: xn */
    private int f285xn;

    /* JADX INFO: renamed from: xo */
    private final zzb f286xo;

    /* JADX INFO: renamed from: xp */
    private final zzc f287xp;

    /* JADX INFO: renamed from: xq */
    private final int f288xq;

    /* JADX INFO: renamed from: xr */
    private final String f289xr;

    /* JADX INFO: renamed from: xs */
    protected AtomicInteger f290xs;
    private final Looper zzahv;
    private final Object zzail;

    private abstract class zza extends zze<Boolean> {
        public final int statusCode;

        /* JADX INFO: renamed from: xu */
        public final Bundle f291xu;

        @BinderThread
        protected zza(int i, Bundle bundle) {
            super(true);
            this.statusCode = i;
            this.f291xu = bundle;
        }

        protected abstract boolean zzarz();

        @Override // com.google.android.gms.common.internal.zzd.zze
        protected void zzasa() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.zzd.zze
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public void zzx(Boolean bool) {
            if (bool == null) {
                zzd.this.zzb(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (zzarz()) {
                        return;
                    }
                    zzd.this.zzb(1, null);
                    zzl(new ConnectionResult(8, null));
                    return;
                case 10:
                    zzd.this.zzb(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    zzd.this.zzb(1, null);
                    zzl(new ConnectionResult(this.statusCode, this.f291xu != null ? (PendingIntent) this.f291xu.getParcelable("pendingIntent") : null));
                    return;
            }
        }

        protected abstract void zzl(ConnectionResult connectionResult);
    }

    public interface zzb {
        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface zzc {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.zzd$zzd, reason: collision with other inner class name */
    final class HandlerC0744zzd extends Handler {
        public HandlerC0744zzd(Looper looper) {
            super(looper);
        }

        private void zza(Message message) {
            zze zzeVar = (zze) message.obj;
            zzeVar.zzasa();
            zzeVar.unregister();
        }

        private boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (zzd.this.f290xs.get() != message.arg1) {
                if (zzb(message)) {
                    zza(message);
                    return;
                }
                return;
            }
            if ((message.what == 1 || message.what == 5) && !zzd.this.isConnecting()) {
                zza(message);
                return;
            }
            if (message.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, message.obj instanceof PendingIntent ? (PendingIntent) message.obj : null);
                zzd.this.f281xj.zzh(connectionResult);
                zzd.this.onConnectionFailed(connectionResult);
                return;
            }
            if (message.what == 4) {
                zzd.this.zzb(4, null);
                if (zzd.this.f286xo != null) {
                    zzd.this.f286xo.onConnectionSuspended(message.arg2);
                }
                zzd.this.onConnectionSuspended(message.arg2);
                zzd.this.zza(4, 1, (IInterface) null);
                return;
            }
            if (message.what == 2 && !zzd.this.isConnected()) {
                zza(message);
            } else if (zzb(message)) {
                ((zze) message.obj).zzasb();
            } else {
                Log.wtf("GmsClient", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
            }
        }
    }

    protected abstract class zze<TListener> {
        private TListener mListener;

        /* JADX INFO: renamed from: xw */
        private boolean f295xw = false;

        public zze(TListener tlistener) {
            this.mListener = tlistener;
        }

        public void unregister() {
            zzasc();
            synchronized (zzd.this.f283xl) {
                zzd.this.f283xl.remove(this);
            }
        }

        protected abstract void zzasa();

        public void zzasb() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.f295xw) {
                    String strValueOf = String.valueOf(this);
                    Log.w("GmsClient", new StringBuilder(String.valueOf(strValueOf).length() + 47).append("Callback proxy ").append(strValueOf).append(" being reused. This is not safe.").toString());
                }
            }
            if (tlistener != null) {
                try {
                    zzx(tlistener);
                } catch (RuntimeException e) {
                    zzasa();
                    throw e;
                }
            } else {
                zzasa();
            }
            synchronized (this) {
                this.f295xw = true;
            }
            unregister();
        }

        public void zzasc() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        protected abstract void zzx(TListener tlistener);
    }

    public interface zzf {
        void zzh(@NonNull ConnectionResult connectionResult);
    }

    public static final class zzg extends zzt.zza {

        /* JADX INFO: renamed from: xx */
        private zzd f296xx;

        /* JADX INFO: renamed from: xy */
        private final int f297xy;

        public zzg(@NonNull zzd zzdVar, int i) {
            this.f296xx = zzdVar;
            this.f297xy = i;
        }

        private void zzasd() {
            this.f296xx = null;
        }

        @Override // com.google.android.gms.common.internal.zzt
        @BinderThread
        public void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            zzab.zzb(this.f296xx, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f296xx.zza(i, iBinder, bundle, this.f297xy);
            zzasd();
        }

        @Override // com.google.android.gms.common.internal.zzt
        @BinderThread
        public void zzb(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }
    }

    public final class zzh implements ServiceConnection {

        /* JADX INFO: renamed from: xy */
        private final int f299xy;

        public zzh(int i) {
            this.f299xy = i;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzab.zzb(iBinder, "Expecting a valid IBinder");
            synchronized (zzd.this.f279xh) {
                zzd.this.f280xi = zzu.zza.zzdt(iBinder);
            }
            zzd.this.zza(0, (Bundle) null, this.f299xy);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (zzd.this.f279xh) {
                zzd.this.f280xi = null;
            }
            zzd.this.mHandler.sendMessage(zzd.this.mHandler.obtainMessage(4, this.f299xy, 1));
        }
    }

    protected class zzi implements zzf {
        public zzi() {
        }

        @Override // com.google.android.gms.common.internal.zzd.zzf
        public void zzh(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                zzd.this.zza((zzq) null, zzd.this.zzary());
            } else if (zzd.this.f287xp != null) {
                zzd.this.f287xp.onConnectionFailed(connectionResult);
            }
        }
    }

    protected final class zzj extends zza {

        /* JADX INFO: renamed from: xz */
        public final IBinder f302xz;

        @BinderThread
        public zzj(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.f302xz = iBinder;
        }

        @Override // com.google.android.gms.common.internal.zzd.zza
        protected boolean zzarz() {
            try {
                String interfaceDescriptor = this.f302xz.getInterfaceDescriptor();
                if (!zzd.this.zzrb().equals(interfaceDescriptor)) {
                    String strValueOf = String.valueOf(zzd.this.zzrb());
                    Log.e("GmsClient", new StringBuilder(String.valueOf(strValueOf).length() + 34 + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(strValueOf).append(" vs. ").append(interfaceDescriptor).toString());
                    return false;
                }
                IInterface iInterfaceZzbb = zzd.this.zzbb(this.f302xz);
                if (iInterfaceZzbb == null || !zzd.this.zza(2, 3, iInterfaceZzbb)) {
                    return false;
                }
                Bundle bundleZzamc = zzd.this.zzamc();
                if (zzd.this.f286xo != null) {
                    zzd.this.f286xo.onConnected(bundleZzamc);
                }
                return true;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }

        @Override // com.google.android.gms.common.internal.zzd.zza
        protected void zzl(ConnectionResult connectionResult) {
            if (zzd.this.f287xp != null) {
                zzd.this.f287xp.onConnectionFailed(connectionResult);
            }
            zzd.this.onConnectionFailed(connectionResult);
        }
    }

    protected final class zzk extends zza {
        @BinderThread
        public zzk(int i, @Nullable Bundle bundle) {
            super(i, bundle);
        }

        @Override // com.google.android.gms.common.internal.zzd.zza
        protected boolean zzarz() {
            zzd.this.f281xj.zzh(ConnectionResult.f104qR);
            return true;
        }

        @Override // com.google.android.gms.common.internal.zzd.zza
        protected void zzl(ConnectionResult connectionResult) {
            zzd.this.f281xj.zzh(connectionResult);
            zzd.this.onConnectionFailed(connectionResult);
        }
    }

    protected zzd(Context context, Looper looper, int i, zzb zzbVar, zzc zzcVar, String str) {
        this(context, looper, zzm.zzce(context), com.google.android.gms.common.zzc.zzand(), i, (zzb) zzab.zzaa(zzbVar), (zzc) zzab.zzaa(zzcVar), str);
    }

    protected zzd(Context context, Looper looper, zzm zzmVar, com.google.android.gms.common.zzc zzcVar, int i, zzb zzbVar, zzc zzcVar2, String str) {
        this.zzail = new Object();
        this.f279xh = new Object();
        this.f283xl = new ArrayList<>();
        this.f285xn = 1;
        this.f290xs = new AtomicInteger(0);
        this.mContext = (Context) zzab.zzb(context, "Context must not be null");
        this.zzahv = (Looper) zzab.zzb(looper, "Looper must not be null");
        this.f278xg = (zzm) zzab.zzb(zzmVar, "Supervisor must not be null");
        this.f272tp = (com.google.android.gms.common.zzc) zzab.zzb(zzcVar, "API availability must not be null");
        this.mHandler = new HandlerC0744zzd(looper);
        this.f288xq = i;
        this.f286xo = zzbVar;
        this.f287xp = zzcVar2;
        this.f289xr = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.zzail) {
            if (this.f285xn != i) {
                z = false;
            } else {
                zzb(i2, t);
                z = true;
            }
        }
        return z;
    }

    private void zzarr() {
        if (this.f284xm != null) {
            String strValueOf = String.valueOf(zzra());
            String strValueOf2 = String.valueOf(zzarp());
            Log.e("GmsClient", new StringBuilder(String.valueOf(strValueOf).length() + 70 + String.valueOf(strValueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(strValueOf).append(" on ").append(strValueOf2).toString());
            this.f278xg.zzb(zzra(), zzarp(), this.f284xm, zzarq());
            this.f290xs.incrementAndGet();
        }
        this.f284xm = new zzh(this.f290xs.get());
        if (this.f278xg.zza(zzra(), zzarp(), this.f284xm, zzarq())) {
            return;
        }
        String strValueOf3 = String.valueOf(zzra());
        String strValueOf4 = String.valueOf(zzarp());
        Log.e("GmsClient", new StringBuilder(String.valueOf(strValueOf3).length() + 34 + String.valueOf(strValueOf4).length()).append("unable to connect to service: ").append(strValueOf3).append(" on ").append(strValueOf4).toString());
        zza(16, (Bundle) null, this.f290xs.get());
    }

    private void zzars() {
        if (this.f284xm != null) {
            this.f278xg.zzb(zzra(), zzarp(), this.f284xm, zzarq());
            this.f284xm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(int i, T t) {
        zzab.zzbn((i == 3) == (t != null));
        synchronized (this.zzail) {
            this.f285xn = i;
            this.f282xk = t;
            zzc(i, t);
            switch (i) {
                case 1:
                    zzars();
                    break;
                case 2:
                    zzarr();
                    break;
                case 3:
                    zza(t);
                    break;
            }
        }
    }

    public void disconnect() {
        this.f290xs.incrementAndGet();
        synchronized (this.f283xl) {
            int size = this.f283xl.size();
            for (int i = 0; i < size; i++) {
                this.f283xl.get(i).zzasc();
            }
            this.f283xl.clear();
        }
        synchronized (this.f279xh) {
            this.f280xi = null;
        }
        zzb(1, null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        synchronized (this.zzail) {
            i = this.f285xn;
            t = this.f282xk;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.println("null");
        } else {
            printWriter.append((CharSequence) zzrb()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f275xd > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.f275xd;
            String strValueOf = String.valueOf(simpleDateFormat.format(new Date(this.f275xd)));
            printWriterAppend.println(new StringBuilder(String.valueOf(strValueOf).length() + 21).append(j).append(" ").append(strValueOf).toString());
        }
        if (this.f274xc > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            switch (this.f273xb) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append((CharSequence) String.valueOf(this.f273xb));
                    break;
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.f274xc;
            String strValueOf2 = String.valueOf(simpleDateFormat.format(new Date(this.f274xc)));
            printWriterAppend2.println(new StringBuilder(String.valueOf(strValueOf2).length() + 21).append(j2).append(" ").append(strValueOf2).toString());
        }
        if (this.f277xf > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.f276xe));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j3 = this.f277xf;
            String strValueOf3 = String.valueOf(simpleDateFormat.format(new Date(this.f277xf)));
            printWriterAppend3.println(new StringBuilder(String.valueOf(strValueOf3).length() + 21).append(j3).append(" ").append(strValueOf3).toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzahv;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzail) {
            z = this.f285xn == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzail) {
            z = this.f285xn == 2;
        }
        return z;
    }

    @CallSuper
    protected void onConnectionFailed(ConnectionResult connectionResult) {
        this.f276xe = connectionResult.getErrorCode();
        this.f277xf = System.currentTimeMillis();
    }

    @CallSuper
    protected void onConnectionSuspended(int i) {
        this.f273xb = i;
        this.f274xc = System.currentTimeMillis();
    }

    protected void zza(int i, @Nullable Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i2, -1, new zzk(i, bundle)));
    }

    @BinderThread
    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzj(i, iBinder, bundle)));
    }

    @CallSuper
    protected void zza(@NonNull T t) {
        this.f275xd = System.currentTimeMillis();
    }

    public void zza(@NonNull zzf zzfVar) {
        this.f281xj = (zzf) zzab.zzb(zzfVar, "Connection progress callbacks cannot be null.");
        zzb(2, null);
    }

    public void zza(zzf zzfVar, ConnectionResult connectionResult) {
        this.f281xj = (zzf) zzab.zzb(zzfVar, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.f290xs.get(), connectionResult.getErrorCode(), connectionResult.getResolution()));
    }

    @WorkerThread
    public void zza(zzq zzqVar, Set<Scope> set) {
        try {
            GetServiceRequest getServiceRequestZzn = new GetServiceRequest(this.f288xq).zzhm(this.mContext.getPackageName()).zzn(zzaeu());
            if (set != null) {
                getServiceRequestZzn.zzf(set);
            }
            if (zzafk()) {
                getServiceRequestZzn.zzd(zzaru()).zzb(zzqVar);
            } else if (zzarx()) {
                getServiceRequestZzn.zzd(getAccount());
            }
            synchronized (this.f279xh) {
                try {
                    if (this.f280xi != null) {
                        this.f280xi.zza(new zzg(this, this.f290xs.get()), getServiceRequestZzn);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzfy(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    protected Bundle zzaeu() {
        return new Bundle();
    }

    public boolean zzafk() {
        return false;
    }

    public boolean zzafz() {
        return false;
    }

    public Intent zzaga() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public Bundle zzamc() {
        return null;
    }

    public boolean zzanr() {
        return true;
    }

    @Nullable
    public IBinder zzans() {
        IBinder iBinderAsBinder;
        synchronized (this.f279xh) {
            iBinderAsBinder = this.f280xi == null ? null : this.f280xi.asBinder();
        }
        return iBinderAsBinder;
    }

    protected String zzarp() {
        return "com.google.android.gms";
    }

    @Nullable
    protected final String zzarq() {
        return this.f289xr == null ? this.mContext.getClass().getName() : this.f289xr;
    }

    public void zzart() {
        int iIsGooglePlayServicesAvailable = this.f272tp.isGooglePlayServicesAvailable(this.mContext);
        if (iIsGooglePlayServicesAvailable == 0) {
            zza(new zzi());
            return;
        }
        zzb(1, null);
        this.f281xj = new zzi();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.f290xs.get(), iIsGooglePlayServicesAvailable));
    }

    public final Account zzaru() {
        return getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
    }

    protected final void zzarv() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzarw() throws DeadObjectException {
        T t;
        synchronized (this.zzail) {
            if (this.f285xn == 4) {
                throw new DeadObjectException();
            }
            zzarv();
            zzab.zza(this.f282xk != null, "Client is connected but service is null");
            t = this.f282xk;
        }
        return t;
    }

    public boolean zzarx() {
        return false;
    }

    protected Set<Scope> zzary() {
        return Collections.EMPTY_SET;
    }

    @Nullable
    protected abstract T zzbb(IBinder iBinder);

    void zzc(int i, T t) {
    }

    public void zzfy(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.f290xs.get(), i));
    }

    @NonNull
    protected abstract String zzra();

    @NonNull
    protected abstract String zzrb();
}
