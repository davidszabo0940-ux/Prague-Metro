package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: loaded from: classes.dex */
public class zzt implements zzf {
    protected static final boolean DEBUG = zzs.DEBUG;
    private static int zzbn = 3000;
    private static int zzbo = 4096;
    protected final zzy zzbp;
    protected final zzu zzbq;

    public zzt(zzy zzyVar) {
        this(zzyVar, new zzu(zzbo));
    }

    public zzt(zzy zzyVar, zzu zzuVar) {
        this.zzbp = zzyVar;
        this.zzbq = zzuVar;
    }

    protected static Map<String, String> zza(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private void zza(long j, zzk<?> zzkVar, byte[] bArr, StatusLine statusLine) {
        if (DEBUG || j > zzbn) {
            Object[] objArr = new Object[5];
            objArr[0] = zzkVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(zzkVar.zzt().zzd());
            zzs.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void zza(String str, zzk<?> zzkVar, zzr zzrVar) throws zzr {
        zzo zzoVarZzt = zzkVar.zzt();
        int iZzs = zzkVar.zzs();
        try {
            zzoVarZzt.zza(zzrVar);
            zzkVar.zzc(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iZzs)));
        } catch (zzr e) {
            zzkVar.zzc(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(iZzs)));
            throw e;
        }
    }

    private void zza(Map<String, String> map, zzb.zza zzaVar) {
        if (zzaVar == null) {
            return;
        }
        if (zzaVar.zza != null) {
            map.put("If-None-Match", zzaVar.zza);
        }
        if (zzaVar.zzc > 0) {
            map.put("If-Modified-Since", DateUtils.formatDate(new Date(zzaVar.zzc)));
        }
    }

    private byte[] zza(HttpEntity httpEntity) throws IOException, zzp {
        zzaa zzaaVar = new zzaa(this.zzbq, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new zzp();
            }
            byte[] bArrZzb = this.zzbq.zzb(1024);
            while (true) {
                int i = content.read(bArrZzb);
                if (i == -1) {
                    break;
                }
                zzaaVar.write(bArrZzb, 0, i);
            }
            byte[] byteArray = zzaaVar.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                zzs.zza("Error occured when calling consumingContent", new Object[0]);
            }
            this.zzbq.zza(bArrZzb);
            zzaaVar.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                zzs.zza("Error occured when calling consumingContent", new Object[0]);
            }
            this.zzbq.zza(null);
            zzaaVar.close();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.zzf
    public zzi zza(zzk<?> zzkVar) throws zzr {
        byte[] bArr;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            HttpResponse httpResponse = null;
            Map<String, String> mapEmptyMap = Collections.emptyMap();
            try {
                try {
                    HashMap map = new HashMap();
                    zza(map, zzkVar.zzh());
                    HttpResponse httpResponseZza = this.zzbp.zza(zzkVar, map);
                    try {
                        StatusLine statusLine = httpResponseZza.getStatusLine();
                        int statusCode = statusLine.getStatusCode();
                        mapEmptyMap = zza(httpResponseZza.getAllHeaders());
                        if (statusCode == 304) {
                            zzb.zza zzaVarZzh = zzkVar.zzh();
                            if (zzaVarZzh == null) {
                                return new zzi(304, null, mapEmptyMap, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            }
                            zzaVarZzh.zzf.putAll(mapEmptyMap);
                            return new zzi(304, zzaVarZzh.data, zzaVarZzh.zzf, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                        }
                        byte[] bArrZza = httpResponseZza.getEntity() != null ? zza(httpResponseZza.getEntity()) : new byte[0];
                        try {
                            zza(SystemClock.elapsedRealtime() - jElapsedRealtime, zzkVar, bArrZza, statusLine);
                            if (statusCode < 200 || statusCode > 299) {
                                throw new IOException();
                            }
                            return new zzi(statusCode, bArrZza, mapEmptyMap, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                        } catch (IOException e) {
                            e = e;
                            bArr = bArrZza;
                            httpResponse = httpResponseZza;
                            if (httpResponse == null) {
                                throw new zzj(e);
                            }
                            int statusCode2 = httpResponse.getStatusLine().getStatusCode();
                            zzs.zzc("Unexpected response code %d for %s", Integer.valueOf(statusCode2), zzkVar.getUrl());
                            if (bArr == null) {
                                throw new zzh((zzi) null);
                            }
                            zzi zziVar = new zzi(statusCode2, bArr, mapEmptyMap, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            if (statusCode2 != 401 && statusCode2 != 403) {
                                throw new zzp(zziVar);
                            }
                            zza("auth", zzkVar, new zza(zziVar));
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bArr = null;
                        httpResponse = httpResponseZza;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bArr = null;
                }
            } catch (MalformedURLException e4) {
                String strValueOf = String.valueOf(zzkVar.getUrl());
                throw new RuntimeException(strValueOf.length() != 0 ? "Bad URL ".concat(strValueOf) : new String("Bad URL "), e4);
            } catch (SocketTimeoutException e5) {
                zza("socket", zzkVar, new zzq());
            } catch (ConnectTimeoutException e6) {
                zza("connection", zzkVar, new zzq());
            }
        }
    }
}
