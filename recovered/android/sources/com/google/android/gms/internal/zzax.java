package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class zzax {
    private static final String TAG = zzax.class.getSimpleName();
    protected static final Object zzagr = new Object();
    private static com.google.android.gms.common.zzc zzagt = null;
    protected Context zzagf;
    private ExecutorService zzagg;
    private DexClassLoader zzagh;
    private zzau zzagi;
    private byte[] zzagj;
    private zzam zzago;
    private volatile AdvertisingIdClient zzagk = null;
    private volatile boolean zzafn = false;
    private Future zzagl = null;
    private volatile zzae.zza zzagm = null;
    private Future zzagn = null;
    private GoogleApiClient zzagp = null;
    protected boolean zzagq = false;
    protected boolean zzags = false;
    protected boolean zzagu = false;
    private Map<Pair<String, String>, zzbo> zzagv = new HashMap();

    private zzax(Context context) {
        this.zzagf = context;
    }

    public static zzax zza(Context context, String str, String str2, boolean z) {
        zzax zzaxVar = new zzax(context);
        try {
            if (zzaxVar.zzc(str, str2, z)) {
                return zzaxVar;
            }
            return null;
        } catch (zzaw e) {
        }
    }

    @NonNull
    private File zza(String str, File file, String str2) throws IOException, zzau.zza {
        File file2 = new File(String.format("%s/%s.jar", file, str2));
        if (!file2.exists()) {
            byte[] bArrZzc = this.zzagi.zzc(this.zzagj, str);
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(bArrZzc, 0, bArrZzc.length);
            fileOutputStream.close();
        }
        return file2;
    }

    private void zza(File file) {
        if (file.exists()) {
            file.delete();
        } else {
            Log.d(TAG, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void zza(File file, String str) throws Throwable {
        FileInputStream fileInputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (!file3.exists()) {
            return;
        }
        FileInputStream fileInputStream2 = null;
        long length = file3.length();
        if (length <= 0) {
            return;
        }
        byte[] bArr = new byte[(int) length];
        try {
            fileInputStream = new FileInputStream(file3);
            try {
                if (fileInputStream.read(bArr) <= 0) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    zza(file3);
                    return;
                }
                zzae.zzd zzdVar = new zzae.zzd();
                zzdVar.zzev = Build.VERSION.SDK.getBytes();
                zzdVar.zzeu = str.getBytes();
                byte[] bytes = this.zzagi.zzd(this.zzagj, bArr).getBytes();
                zzdVar.data = bytes;
                zzdVar.zzet = zzak.zzg(bytes);
                file2.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArrZzf = zzapc.zzf(zzdVar);
                fileOutputStream.write(bArrZzf, 0, bArrZzf.length);
                fileOutputStream.close();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                zza(file3);
            } catch (zzau.zza e3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                zza(file3);
            } catch (IOException e5) {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                zza(file3);
            } catch (NoSuchAlgorithmException e6) {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                zza(file3);
            } catch (Throwable th) {
                fileInputStream2 = fileInputStream;
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e7) {
                    }
                }
                zza(file3);
                throw th;
            }
        } catch (zzau.zza e8) {
            fileInputStream = null;
        } catch (IOException e9) {
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e10) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean zzb(File file, String str) {
        boolean z = false;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (file2.exists()) {
            File file3 = new File(String.format("%s/%s.dex", file, str));
            if (!file3.exists()) {
                try {
                    long length = file2.length();
                    if (length <= 0) {
                        zza(file2);
                    } else {
                        byte[] bArr = new byte[(int) length];
                        if (new FileInputStream(file2).read(bArr) <= 0) {
                            Log.d(TAG, "Cannot read the cache data.");
                            zza(file2);
                        } else {
                            zzae.zzd zzdVarZzd = zzae.zzd.zzd(bArr);
                            if (str.equals(new String(zzdVarZzd.zzeu)) && Arrays.equals(zzdVarZzd.zzet, zzak.zzg(zzdVarZzd.data)) && Arrays.equals(zzdVarZzd.zzev, Build.VERSION.SDK.getBytes())) {
                                byte[] bArrZzc = this.zzagi.zzc(this.zzagj, new String(zzdVarZzd.data));
                                file3.createNewFile();
                                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                                fileOutputStream.write(bArrZzc, 0, bArrZzc.length);
                                fileOutputStream.close();
                                z = true;
                            } else {
                                zza(file2);
                            }
                        }
                    }
                } catch (zzau.zza e) {
                } catch (IOException e2) {
                } catch (NoSuchAlgorithmException e3) {
                }
            }
        }
        return z;
    }

    private void zzc(boolean z) {
        this.zzafn = z;
        if (z) {
            this.zzagl = this.zzagg.submit(new Runnable() { // from class: com.google.android.gms.internal.zzax.1
                @Override // java.lang.Runnable
                public void run() {
                    zzax.this.zzco();
                }
            });
        }
    }

    private boolean zzc(String str, String str2, boolean z) throws Throwable {
        this.zzagg = Executors.newCachedThreadPool();
        zzc(z);
        zzcr();
        zzcp();
        this.zzagi = new zzau(null);
        try {
            this.zzagj = this.zzagi.zzl(str);
            boolean zZzm = zzm(str2);
            this.zzago = new zzam(this);
            return zZzm;
        } catch (zzau.zza e) {
            throw new zzaw(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzco() {
        try {
            if (this.zzagk == null) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzagf);
                advertisingIdClient.start();
                this.zzagk = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e) {
            this.zzagk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzcq() {
        if (this.zzags) {
            try {
                this.zzagm = com.google.android.gms.gass.internal.zza.zzf(this.zzagf, this.zzagf.getPackageName(), Integer.toString(this.zzagf.getPackageManager().getPackageInfo(this.zzagf.getPackageName(), 0).versionCode));
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
    }

    private void zzcr() {
        zzagt = com.google.android.gms.common.zzc.zzand();
        this.zzagq = zzagt.zzbn(this.zzagf) > 0;
        this.zzags = zzagt.isGooglePlayServicesAvailable(this.zzagf) == 0;
        if (this.zzagf.getApplicationContext() != null) {
            this.zzagp = new GoogleApiClient.Builder(this.zzagf).addApi(com.google.android.gms.clearcut.zzb.API).build();
        }
        zzdc.initialize(this.zzagf);
    }

    private boolean zzm(String str) throws Throwable {
        try {
            File cacheDir = this.zzagf.getCacheDir();
            if (cacheDir == null && (cacheDir = this.zzagf.getDir("dex", 0)) == null) {
                throw new zzaw();
            }
            File file = cacheDir;
            String strZzay = zzav.zzay();
            File fileZza = zza(str, file, strZzay);
            zzb(file, strZzay);
            try {
                this.zzagh = new DexClassLoader(fileZza.getAbsolutePath(), file.getAbsolutePath(), null, this.zzagf.getClassLoader());
                zza(fileZza);
                zza(file, strZzay);
                String str2 = String.format("%s/%s.dex", file, strZzay);
                return true;
            } finally {
                zza(fileZza);
                zza(file, strZzay);
                zzn(String.format("%s/%s.dex", file, strZzay));
            }
        } catch (zzau.zza e) {
            throw new zzaw(e);
        } catch (FileNotFoundException e2) {
            throw new zzaw(e2);
        } catch (IOException e3) {
            throw new zzaw(e3);
        } catch (NullPointerException e4) {
            throw new zzaw(e4);
        }
    }

    private void zzn(String str) {
        zza(new File(str));
    }

    public Context getContext() {
        return this.zzagf;
    }

    public boolean zza(String str, String str2, List<Class> list) {
        if (this.zzagv.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzagv.put(new Pair<>(str, str2), new zzbo(this, str, str2, list));
        return true;
    }

    public int zzau() {
        zzam zzamVarZzcl = zzcl();
        if (zzamVarZzcl != null) {
            return zzamVarZzcl.zzau();
        }
        return Integer.MIN_VALUE;
    }

    public Method zzc(String str, String str2) {
        zzbo zzboVar = this.zzagv.get(new Pair(str, str2));
        if (zzboVar == null) {
            return null;
        }
        return zzboVar.zzda();
    }

    public ExecutorService zzce() {
        return this.zzagg;
    }

    public DexClassLoader zzcf() {
        return this.zzagh;
    }

    public zzau zzcg() {
        return this.zzagi;
    }

    public byte[] zzch() {
        return this.zzagj;
    }

    public GoogleApiClient zzci() {
        return this.zzagp;
    }

    public boolean zzcj() {
        return this.zzagq;
    }

    public boolean zzck() {
        return this.zzagu;
    }

    public zzam zzcl() {
        return this.zzago;
    }

    public zzae.zza zzcm() {
        return this.zzagm;
    }

    public Future zzcn() {
        return this.zzagn;
    }

    void zzcp() {
        if (zzdc.zzbbs.get().booleanValue()) {
            this.zzagn = this.zzagg.submit(new Runnable() { // from class: com.google.android.gms.internal.zzax.2
                @Override // java.lang.Runnable
                public void run() {
                    zzax.this.zzcq();
                }
            });
        }
    }

    public AdvertisingIdClient zzcs() {
        if (!this.zzafn) {
            return null;
        }
        if (this.zzagk != null) {
            return this.zzagk;
        }
        if (this.zzagl != null) {
            try {
                this.zzagl.get(2000L, TimeUnit.MILLISECONDS);
                this.zzagl = null;
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
            } catch (TimeoutException e3) {
                this.zzagl.cancel(true);
            }
        }
        return this.zzagk;
    }

    public void zzct() {
        synchronized (zzagr) {
            if (this.zzagu) {
                return;
            }
            if (!this.zzags || this.zzagp == null) {
                this.zzagu = false;
            } else {
                this.zzagp.connect();
                this.zzagu = true;
            }
        }
    }

    public void zzcu() {
        synchronized (zzagr) {
            if (this.zzagu && this.zzagp != null) {
                this.zzagp.disconnect();
                this.zzagu = false;
            }
        }
    }
}
