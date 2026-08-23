package com.unity3d.player;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class WWW extends Thread {

    /* JADX INFO: renamed from: a */
    private int f977a = 0;

    /* JADX INFO: renamed from: b */
    private int f978b;

    /* JADX INFO: renamed from: c */
    private String f979c;

    /* JADX INFO: renamed from: d */
    private byte[] f980d;

    /* JADX INFO: renamed from: e */
    private Map f981e;

    WWW(int i, String str, byte[] bArr, Map map) {
        this.f978b = i;
        this.f979c = str;
        this.f980d = bArr;
        this.f981e = map;
    }

    private static native void doneCallback(int i);

    private static native void errorCallback(int i, String str);

    private static native boolean headerCallback(int i, String str);

    private static native void progressCallback(int i, float f, float f2, double d, int i2);

    private static native boolean readCallback(int i, byte[] bArr, int i2);

    protected boolean headerCallback(String str, String str2) {
        return headerCallback(this.f978b, str + ": " + str2 + "\n\r");
    }

    protected boolean headerCallback(Map map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            for (String str : (List) entry.getValue()) {
                sb.append((String) entry.getKey());
                sb.append(": ");
                sb.append(str);
                sb.append("\r\n");
            }
            if (entry.getKey() == null) {
                for (String str2 : (List) entry.getValue()) {
                    sb.append("Status: ");
                    sb.append(str2);
                    sb.append("\r\n");
                }
            }
        }
        return headerCallback(this.f978b, sb.toString());
    }

    protected void progressCallback(int i, int i2, int i3, int i4, long j, long j2) {
        float f;
        float f2;
        double d;
        if (i4 > 0) {
            f = i3 / i4;
            f2 = 1.0f;
            double dMax = ((double) Math.max(i4 - i3, 0)) / ((1000.0d * ((double) i3)) / Math.max(j - j2, 0.1d));
            if (Double.isInfinite(dMax) || Double.isNaN(dMax)) {
                dMax = 0.0d;
            }
            d = dMax;
        } else {
            if (i2 <= 0) {
                return;
            }
            f = 0.0f;
            f2 = i / i2;
            d = 0.0d;
        }
        progressCallback(this.f978b, f2, f, d, i4);
    }

    protected boolean readCallback(byte[] bArr, int i) {
        return readCallback(this.f978b, bArr, i);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            runSafe();
        } catch (Throwable th) {
            errorCallback(this.f978b, "Error: " + th.toString());
        }
    }

    public void runSafe() {
        String str;
        InputStream inputStream;
        InputStream inputStream2;
        boolean z;
        List<String> list;
        int i = this.f977a + 1;
        this.f977a = i;
        if (i > 5) {
            errorCallback(this.f978b, "Too many redirects");
            return;
        }
        try {
            URL url = new URL(this.f979c);
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            if (url.getProtocol().equalsIgnoreCase("file") && url.getHost() != null && url.getHost().length() != 0) {
                errorCallback(this.f978b, url.getHost() + url.getFile() + " is not an absolute path!");
                return;
            }
            if (this.f981e != null) {
                for (Map.Entry entry : this.f981e.entrySet()) {
                    uRLConnectionOpenConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (this.f980d != null) {
                uRLConnectionOpenConnection.setDoOutput(true);
                try {
                    OutputStream outputStream = uRLConnectionOpenConnection.getOutputStream();
                    int i2 = 0;
                    while (i2 < this.f980d.length) {
                        int iMin = Math.min(1428, this.f980d.length - i2);
                        outputStream.write(this.f980d, i2, iMin);
                        i2 += iMin;
                        progressCallback(i2, this.f980d.length, 0, 0, 0L, 0L);
                    }
                } catch (Exception e) {
                    errorCallback(this.f978b, e.toString());
                    return;
                }
            }
            if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    if (headerFields != null && ((responseCode == 301 || responseCode == 302) && (list = headerFields.get("Location")) != null && !list.isEmpty())) {
                        httpURLConnection.disconnect();
                        this.f979c = list.get(0);
                        run();
                        return;
                    }
                } catch (IOException e2) {
                    errorCallback(this.f978b, e2.toString());
                    return;
                }
            }
            Map<String, List<String>> headerFields2 = uRLConnectionOpenConnection.getHeaderFields();
            boolean zHeaderCallback = headerCallback(headerFields2);
            if ((headerFields2 == null || !headerFields2.containsKey("content-length")) && uRLConnectionOpenConnection.getContentLength() != -1) {
                zHeaderCallback = zHeaderCallback || headerCallback("content-length", String.valueOf(uRLConnectionOpenConnection.getContentLength()));
            }
            if ((headerFields2 == null || !headerFields2.containsKey("content-type")) && uRLConnectionOpenConnection.getContentType() != null) {
                zHeaderCallback = zHeaderCallback || headerCallback("content-type", uRLConnectionOpenConnection.getContentType());
            }
            if (zHeaderCallback) {
                errorCallback(this.f978b, this.f979c + " aborted");
                return;
            }
            int contentLength = uRLConnectionOpenConnection.getContentLength() > 0 ? uRLConnectionOpenConnection.getContentLength() : 0;
            int iMin2 = (url.getProtocol().equalsIgnoreCase("file") || url.getProtocol().equalsIgnoreCase("jar")) ? contentLength == 0 ? 32768 : Math.min(contentLength, 32768) : 1428;
            int i3 = 0;
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                byte[] bArr = new byte[iMin2];
                if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) uRLConnectionOpenConnection;
                    InputStream errorStream = httpURLConnection2.getErrorStream();
                    str = httpURLConnection2.getResponseCode() + ": " + httpURLConnection2.getResponseMessage();
                    inputStream = errorStream;
                } else {
                    str = "";
                    inputStream = null;
                }
                if (inputStream == null) {
                    z = false;
                    inputStream2 = uRLConnectionOpenConnection.getInputStream();
                } else {
                    inputStream2 = inputStream;
                    z = true;
                }
                for (int i4 = 0; i4 != -1; i4 = inputStream2.read(bArr)) {
                    if (readCallback(bArr, i4)) {
                        errorCallback(this.f978b, this.f979c + " aborted");
                        return;
                    }
                    if (!z) {
                        i3 += i4;
                        progressCallback(0, 0, i3, contentLength, System.currentTimeMillis(), jCurrentTimeMillis);
                    }
                }
                if (z) {
                    errorCallback(this.f978b, str);
                }
                progressCallback(0, 0, i3, i3, 0L, 0L);
                doneCallback(this.f978b);
            } catch (Exception e3) {
                errorCallback(this.f978b, e3.toString());
            }
        } catch (MalformedURLException e4) {
            errorCallback(this.f978b, e4.toString());
        } catch (IOException e5) {
            errorCallback(this.f978b, e5.toString());
        }
    }
}
