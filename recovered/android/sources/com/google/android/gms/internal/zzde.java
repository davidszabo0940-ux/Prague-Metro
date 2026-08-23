package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzde {
    final Context mContext;
    final String zzarh;
    String zzbdn;
    BlockingQueue<zzdk> zzbdp;
    ExecutorService zzbdq;
    LinkedHashMap<String, String> zzbdr = new LinkedHashMap<>();
    Map<String, zzdh> zzbds = new HashMap();
    private AtomicBoolean zzbdt = new AtomicBoolean(false);
    private File zzbdu;

    public zzde(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzarh = str;
        this.zzbdn = str2;
        this.zzbdt.set(zzdc.zzaze.get().booleanValue());
        if (this.zzbdt.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzbdu = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.zzbdr.put(entry.getKey(), entry.getValue());
        }
        this.zzbdp = new ArrayBlockingQueue(30);
        this.zzbdq = Executors.newSingleThreadExecutor();
        this.zzbdq.execute(new Runnable() { // from class: com.google.android.gms.internal.zzde.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                zzde.this.zzkc();
            }
        });
        this.zzbds.put("action", zzdh.zzbdx);
        this.zzbds.put("ad_format", zzdh.zzbdx);
        this.zzbds.put("e", zzdh.zzbdy);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    private void zzc(File file, String str) throws Throwable {
        ?? r1;
        FileOutputStream fileOutputStream;
        if (file == null) {
            zzkh.zzcy("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
            return;
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.write(10);
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e) {
                            zzkh.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e);
                            r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt.";
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    zzkh.zzd("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e3) {
                            zzkh.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e3);
                            r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt.";
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e4) {
                        zzkh.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    private void zzc(Map<String, String> map, String str) throws Throwable {
        String strZza = zza(this.zzbdn, map, str);
        if (this.zzbdt.get()) {
            zzc(this.zzbdu, strZza);
        } else {
            com.google.android.gms.ads.internal.zzu.zzfq().zzc(this.mContext, this.zzarh, strZza);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzkc() throws Throwable {
        while (true) {
            try {
                zzdk zzdkVarTake = this.zzbdp.take();
                String strZzki = zzdkVarTake.zzki();
                if (!TextUtils.isEmpty(strZzki)) {
                    zzc(zza(this.zzbdr, zzdkVarTake.zzm()), strZzki);
                }
            } catch (InterruptedException e) {
                zzkh.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    String zza(String str, Map<String, String> map, @NonNull String str2) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        StringBuilder sb = new StringBuilder(builderBuildUpon.build().toString());
        sb.append("&").append("it").append("=").append(str2);
        return sb.toString();
    }

    Map<String, String> zza(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            linkedHashMap.put(key, zzaq(key).zzg((String) linkedHashMap.get(key), value));
        }
        return linkedHashMap;
    }

    public boolean zza(zzdk zzdkVar) {
        return this.zzbdp.offer(zzdkVar);
    }

    public zzdh zzaq(String str) {
        zzdh zzdhVar = this.zzbds.get(str);
        return zzdhVar != null ? zzdhVar : zzdh.zzbdw;
    }

    public void zzc(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzbdr.put("e", TextUtils.join(",", list));
    }
}
