package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.util.zzt;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzb {

    /* JADX INFO: renamed from: Ad */
    private static Integer f427Ad;

    /* JADX INFO: renamed from: yz */
    private static final Object f428yz = new Object();

    /* JADX INFO: renamed from: zX */
    private static zzb f429zX;

    /* JADX INFO: renamed from: Aa */
    private final List<String> f430Aa;

    /* JADX INFO: renamed from: Ab */
    private final List<String> f431Ab;

    /* JADX INFO: renamed from: Ac */
    private zze f432Ac;

    /* JADX INFO: renamed from: Ae */
    private zze f433Ae;

    /* JADX INFO: renamed from: zY */
    private final List<String> f434zY;

    /* JADX INFO: renamed from: zZ */
    private final List<String> f435zZ;

    private zzb() {
        if (getLogLevel() == zzd.LOG_LEVEL_OFF) {
            this.f434zY = Collections.EMPTY_LIST;
            this.f435zZ = Collections.EMPTY_LIST;
            this.f430Aa = Collections.EMPTY_LIST;
            this.f431Ab = Collections.EMPTY_LIST;
            return;
        }
        String str = zzc.zza.f439Ai.get();
        this.f434zY = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        String str2 = zzc.zza.f440Aj.get();
        this.f435zZ = str2 == null ? Collections.EMPTY_LIST : Arrays.asList(str2.split(","));
        String str3 = zzc.zza.f441Ak.get();
        this.f430Aa = str3 == null ? Collections.EMPTY_LIST : Arrays.asList(str3.split(","));
        String str4 = zzc.zza.f442Al.get();
        this.f431Ab = str4 == null ? Collections.EMPTY_LIST : Arrays.asList(str4.split(","));
        this.f432Ac = new zze(1024, zzc.zza.f443Am.get().longValue());
        this.f433Ae = new zze(1024, zzc.zza.f443Am.get().longValue());
    }

    private static int getLogLevel() {
        if (f427Ad == null) {
            try {
                f427Ad = Integer.valueOf(com.google.android.gms.common.util.zzd.zzabc() ? zzc.zza.f438Ah.get().intValue() : zzd.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                f427Ad = Integer.valueOf(zzd.LOG_LEVEL_OFF);
            }
        }
        return f427Ad.intValue();
    }

    private static String zza(StackTraceElement[] stackTraceElementArr, int i) {
        if (i + 4 >= stackTraceElementArr.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = stackTraceElementArr[i + 4];
        String strValueOf = String.valueOf(stackTraceElement.getClassName());
        String strValueOf2 = String.valueOf(stackTraceElement.getMethodName());
        return new StringBuilder(String.valueOf(strValueOf).length() + 13 + String.valueOf(strValueOf2).length()).append(strValueOf).append(".").append(strValueOf2).append(":").append(stackTraceElement.getLineNumber()).toString();
    }

    private void zza(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzm = null;
        if ((getLogLevel() & zzd.f450Ar) != 0 && i != 13) {
            strZzm = zzm(3, 5);
        }
        long nativeHeapAllocatedSize = (getLogLevel() & zzd.f452At) != 0 ? Debug.getNativeHeapAllocatedSize() : 0L;
        context.startService(new Intent().setComponent(zzd.f446An).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", (i == 1 || i == 4 || i == 14) ? new ConnectionEvent(jCurrentTimeMillis, i, null, null, null, null, strZzm, str, SystemClock.elapsedRealtime(), nativeHeapAllocatedSize) : new ConnectionEvent(jCurrentTimeMillis, i, str2, str3, str4, str5, strZzm, str, SystemClock.elapsedRealtime(), nativeHeapAllocatedSize)));
    }

    private void zza(Context context, String str, String str2, Intent intent, int i) {
        String str3;
        String str4;
        String strZzavu = null;
        if (!zzauu() || this.f432Ac == null) {
            return;
        }
        if (i != 4 && i != 1) {
            ServiceInfo serviceInfoZzd = zzd(context, intent);
            if (serviceInfoZzd == null) {
                Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", str2, intent.toUri(0)));
                return;
            }
            str4 = serviceInfoZzd.processName;
            str3 = serviceInfoZzd.name;
            strZzavu = zzt.zzavu();
            if (!zzb(strZzavu, str2, str4, str3)) {
                return;
            } else {
                this.f432Ac.zzhy(str);
            }
        } else {
            if (!this.f432Ac.zzhz(str)) {
                return;
            }
            str3 = null;
            str4 = null;
        }
        zza(context, str, i, strZzavu, str2, str4, str3);
    }

    public static zzb zzaut() {
        synchronized (f428yz) {
            if (f429zX == null) {
                f429zX = new zzb();
            }
        }
        return f429zX;
    }

    private boolean zzauu() {
        return false;
    }

    private String zzb(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private boolean zzb(String str, String str2, String str3, String str4) {
        return (this.f434zY.contains(str) || this.f435zZ.contains(str2) || this.f430Aa.contains(str3) || this.f431Ab.contains(str4) || (str3.equals(str) && (getLogLevel() & zzd.f451As) != 0)) ? false : true;
    }

    private boolean zzc(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            return false;
        }
        return com.google.android.gms.common.util.zzd.zzq(context, component.getPackageName());
    }

    private static ServiceInfo zzd(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (listQueryIntentServices == null || listQueryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", intent.toUri(0), zzm(3, 20)));
            return null;
        }
        if (listQueryIntentServices.size() <= 1) {
            return listQueryIntentServices.get(0).serviceInfo;
        }
        Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", intent.toUri(0), zzm(3, 20)));
        Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
        while (it.hasNext()) {
            Log.w("ConnectionTracker", it.next().serviceInfo.name);
        }
        return null;
    }

    private static String zzm(int i, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            stringBuffer.append(zza(stackTrace, i)).append(" ");
            i++;
        }
        return stringBuffer.toString();
    }

    @SuppressLint({"UntrackedBindService"})
    public void zza(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        zza(context, zzb(serviceConnection), (String) null, (Intent) null, 1);
    }

    public void zza(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        zza(context, zzb(serviceConnection), str, intent, 3);
    }

    public boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (zzc(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean zBindService = context.bindService(intent, serviceConnection, i);
        if (zBindService) {
            zza(context, zzb(serviceConnection), str, intent, 2);
        }
        return zBindService;
    }

    public void zzb(Context context, ServiceConnection serviceConnection) {
        zza(context, zzb(serviceConnection), (String) null, (Intent) null, 4);
    }
}
