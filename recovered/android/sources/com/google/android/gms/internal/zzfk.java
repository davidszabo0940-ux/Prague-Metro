package com.google.android.gms.internal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzfk extends zzfh {
    private static final Set<String> zzbjt = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzbju = new DecimalFormat("#,###");
    private File zzbjv;
    private boolean zzbjw;

    public zzfk(zzll zzllVar) {
        super(zzllVar);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzkh.zzcy("Context.getCacheDir() returned null");
            return;
        }
        this.zzbjv = new File(cacheDir, "admobVideoStreams");
        if (!this.zzbjv.isDirectory() && !this.zzbjv.mkdirs()) {
            String strValueOf = String.valueOf(this.zzbjv.getAbsolutePath());
            zzkh.zzcy(strValueOf.length() != 0 ? "Could not create preload cache directory at ".concat(strValueOf) : new String("Could not create preload cache directory at "));
            this.zzbjv = null;
        } else {
            if (this.zzbjv.setReadable(true, false) && this.zzbjv.setExecutable(true, false)) {
                return;
            }
            String strValueOf2 = String.valueOf(this.zzbjv.getAbsolutePath());
            zzkh.zzcy(strValueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(strValueOf2) : new String("Could not set cache file permissions at "));
            this.zzbjv = null;
        }
    }

    private File zzb(File file) {
        return new File(this.zzbjv, String.valueOf(file.getName()).concat(".done"));
    }

    private static void zzc(File file) {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfh
    public void abort() {
        this.zzbjw = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.String] */
    @Override // com.google.android.gms.internal.zzfh
    public boolean zzba(String str) {
        String strOpenConnection;
        String absolutePath;
        int responseCode;
        if (this.zzbjv == null) {
            zza(str, null, "noCacheDir", null);
            return false;
        }
        while (zzln() > zzdc.zzayk.get().intValue()) {
            if (!zzlo()) {
                zzkh.zzcy("Unable to expire stream cache");
                zza(str, null, "expireFailed", null);
                return false;
            }
        }
        File file = new File(this.zzbjv, zzbb(str));
        File fileZzb = zzb(file);
        if (file.isFile() && fileZzb.isFile()) {
            int length = (int) file.length();
            String strValueOf = String.valueOf(str);
            zzkh.zzcw(strValueOf.length() != 0 ? "Stream cache hit at ".concat(strValueOf) : new String("Stream cache hit at "));
            zza(str, file.getAbsolutePath(), length);
            return true;
        }
        String strValueOf2 = String.valueOf(this.zzbjv.getAbsolutePath());
        String strValueOf3 = String.valueOf(str);
        String strConcat = strValueOf3.length() != 0 ? strValueOf2.concat(strValueOf3) : new String(strValueOf2);
        synchronized (zzbjt) {
            if (zzbjt.contains(strConcat)) {
                String strValueOf4 = String.valueOf(str);
                zzkh.zzcy(strValueOf4.length() != 0 ? "Stream cache already in progress at ".concat(strValueOf4) : new String("Stream cache already in progress at "));
                zza(str, file.getAbsolutePath(), "inProgress", null);
                return false;
            }
            zzbjt.add(strConcat);
            FileOutputStream fileOutputStream = null;
            try {
                strOpenConnection = new URL(str).openConnection();
                int iIntValue = zzdc.zzayp.get().intValue();
                strOpenConnection.setConnectTimeout(iIntValue);
                strOpenConnection.setReadTimeout(iIntValue);
                if (!(strOpenConnection instanceof HttpURLConnection) || (responseCode = ((HttpURLConnection) strOpenConnection).getResponseCode()) < 400) {
                    int contentLength = strOpenConnection.getContentLength();
                    if (contentLength < 0) {
                        String strValueOf5 = String.valueOf(str);
                        zzkh.zzcy(strValueOf5.length() != 0 ? "Stream cache aborted, missing content-length header at ".concat(strValueOf5) : new String("Stream cache aborted, missing content-length header at "));
                        zza(str, file.getAbsolutePath(), "contentLengthMissing", null);
                        zzbjt.remove(strConcat);
                        return false;
                    }
                    String str2 = zzbju.format(contentLength);
                    int iIntValue2 = zzdc.zzayl.get().intValue();
                    if (contentLength > iIntValue2) {
                        zzkh.zzcy(new StringBuilder(String.valueOf(str2).length() + 33 + String.valueOf(str).length()).append("Content length ").append(str2).append(" exceeds limit at ").append(str).toString());
                        String strValueOf6 = String.valueOf(str2);
                        zza(str, file.getAbsolutePath(), "sizeExceeded", strValueOf6.length() != 0 ? "File too big for full file cache. Size: ".concat(strValueOf6) : new String("File too big for full file cache. Size: "));
                        zzbjt.remove(strConcat);
                        return false;
                    }
                    StringBuilder sbAppend = new StringBuilder(String.valueOf(str2).length() + 20 + String.valueOf(str).length()).append("Caching ").append(str2);
                    absolutePath = " bytes from ";
                    zzkh.zzcw(sbAppend.append(" bytes from ").append(str).toString());
                    ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(strOpenConnection.getInputStream());
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        FileChannel channel = fileOutputStream2.getChannel();
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1048576);
                        com.google.android.gms.common.util.zze zzeVarZzfu = com.google.android.gms.ads.internal.zzu.zzfu();
                        int i = 0;
                        long jCurrentTimeMillis = zzeVarZzfu.currentTimeMillis();
                        zzkv zzkvVar = new zzkv(zzdc.zzayo.get().longValue());
                        long jLongValue = zzdc.zzayn.get().longValue();
                        while (true) {
                            int i2 = readableByteChannelNewChannel.read(byteBufferAllocate);
                            if (i2 < 0) {
                                fileOutputStream2.close();
                                if (zzkh.zzaz(3)) {
                                    String str3 = zzbju.format(i);
                                    zzkh.zzcw(new StringBuilder(String.valueOf(str3).length() + 22 + String.valueOf(str).length()).append("Preloaded ").append(str3).append(" bytes from ").append(str).toString());
                                }
                                file.setReadable(true, false);
                                zzc(fileZzb);
                                zza(str, file.getAbsolutePath(), i);
                                zzbjt.remove(strConcat);
                                return true;
                            }
                            i += i2;
                            try {
                                try {
                                    if (i > iIntValue2) {
                                        String strValueOf7 = String.valueOf(Integer.toString(i));
                                        if (strValueOf7.length() != 0) {
                                            "File too big for full file cache. Size: ".concat(strValueOf7);
                                        } else {
                                            new String("File too big for full file cache. Size: ");
                                        }
                                        throw new IOException("stream cache file size limit exceeded");
                                    }
                                    byteBufferAllocate.flip();
                                    while (channel.write(byteBufferAllocate) > 0) {
                                    }
                                    byteBufferAllocate.clear();
                                    if (zzeVarZzfu.currentTimeMillis() - jCurrentTimeMillis > 1000 * jLongValue) {
                                        String strValueOf8 = String.valueOf(Long.toString(jLongValue));
                                        new StringBuilder(String.valueOf(strValueOf8).length() + 29).append("Timeout exceeded. Limit: ").append(strValueOf8).append(" sec").toString();
                                        throw new IOException("stream cache time limit exceeded");
                                    }
                                    if (this.zzbjw) {
                                        throw new IOException("abort requested");
                                    }
                                    if (zzkvVar.tryAcquire()) {
                                        absolutePath = file.getAbsolutePath();
                                        strOpenConnection = str;
                                        zza(strOpenConnection, absolutePath, i, contentLength, false);
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    strOpenConnection = 0;
                                    fileOutputStream = fileOutputStream2;
                                } catch (RuntimeException e2) {
                                    e = e2;
                                    strOpenConnection = 0;
                                    fileOutputStream = fileOutputStream2;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                fileOutputStream = fileOutputStream2;
                            } catch (RuntimeException e4) {
                                e = e4;
                                fileOutputStream = fileOutputStream2;
                            }
                        }
                    } catch (IOException e5) {
                        e = e5;
                        strOpenConnection = 0;
                        absolutePath = "error";
                        fileOutputStream = fileOutputStream2;
                    } catch (RuntimeException e6) {
                        e = e6;
                        strOpenConnection = 0;
                        absolutePath = "error";
                        fileOutputStream = fileOutputStream2;
                    }
                } else {
                    absolutePath = "badUrl";
                    try {
                        String strValueOf9 = String.valueOf(Integer.toString(responseCode));
                        strOpenConnection = strValueOf9.length() != 0 ? "HTTP request failed. Code: ".concat(strValueOf9) : new String("HTTP request failed. Code: ");
                        try {
                            throw new IOException(new StringBuilder(String.valueOf(str).length() + 32).append("HTTP status code ").append(responseCode).append(" at ").append(str).toString());
                        } catch (IOException e7) {
                            e = e7;
                        } catch (RuntimeException e8) {
                            e = e8;
                        }
                    } catch (IOException e9) {
                        e = e9;
                        strOpenConnection = 0;
                    } catch (RuntimeException e10) {
                        e = e10;
                        strOpenConnection = 0;
                    }
                }
            } catch (IOException e11) {
                e = e11;
                strOpenConnection = 0;
                absolutePath = "error";
            } catch (RuntimeException e12) {
                e = e12;
                strOpenConnection = 0;
                absolutePath = "error";
            }
            if (e instanceof RuntimeException) {
                com.google.android.gms.ads.internal.zzu.zzft().zzb(e, true);
            }
            try {
                fileOutputStream.close();
            } catch (IOException e13) {
            } catch (NullPointerException e14) {
            }
            if (this.zzbjw) {
                zzkh.zzcx(new StringBuilder(String.valueOf(str).length() + 26).append("Preload aborted for URL \"").append(str).append("\"").toString());
            } else {
                zzkh.zzd(new StringBuilder(String.valueOf(str).length() + 25).append("Preload failed for URL \"").append(str).append("\"").toString(), e);
            }
            if (file.exists() && !file.delete()) {
                String strValueOf10 = String.valueOf(file.getAbsolutePath());
                zzkh.zzcy(strValueOf10.length() != 0 ? "Could not delete partial cache file at ".concat(strValueOf10) : new String("Could not delete partial cache file at "));
            }
            zza(str, file.getAbsolutePath(), absolutePath, strOpenConnection);
            zzbjt.remove(strConcat);
            return false;
        }
    }

    public int zzln() {
        int i = 0;
        if (this.zzbjv != null) {
            for (File file : this.zzbjv.listFiles()) {
                if (!file.getName().endsWith(".done")) {
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004c  */
    public boolean zzlo() {
        boolean zDelete;
        long jLastModified;
        File file;
        if (this.zzbjv == null) {
            return false;
        }
        File file2 = null;
        long j = Long.MAX_VALUE;
        File[] fileArrListFiles = this.zzbjv.listFiles();
        int length = fileArrListFiles.length;
        int i = 0;
        while (i < length) {
            File file3 = fileArrListFiles[i];
            if (file3.getName().endsWith(".done")) {
                jLastModified = j;
                file = file2;
            } else {
                jLastModified = file3.lastModified();
                if (jLastModified < j) {
                    file = file3;
                } else {
                    jLastModified = j;
                    file = file2;
                }
            }
            i++;
            file2 = file;
            j = jLastModified;
        }
        if (file2 != null) {
            zDelete = file2.delete();
            File fileZzb = zzb(file2);
            if (fileZzb.isFile()) {
                zDelete &= fileZzb.delete();
            }
        } else {
            zDelete = false;
        }
        return zDelete;
    }
}
