package com.unity3d.player;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
class UnityWebRequest implements Runnable {

    /* JADX INFO: renamed from: e */
    private static final String[] f971e = {"TLSv1.2", "TLSv1.1"};

    /* JADX INFO: renamed from: f */
    private static volatile SSLSocketFactory f972f;

    /* JADX INFO: renamed from: a */
    private long f973a;

    /* JADX INFO: renamed from: b */
    private String f974b;

    /* JADX INFO: renamed from: c */
    private String f975c;

    /* JADX INFO: renamed from: d */
    private Map f976d;

    UnityWebRequest(long j, String str, Map map, String str2) {
        this.f973a = j;
        this.f974b = str2;
        this.f975c = str;
        this.f976d = map;
    }

    private static native void contentLengthCallback(long j, int i);

    private static native boolean downloadCallback(long j, ByteBuffer byteBuffer, int i);

    private static native void errorCallback(long j, int i, String str);

    private static SSLSocketFactory getSSLSocketFactory() {
        if (C0705q.f1043g) {
            return null;
        }
        if (f972f != null) {
            return f972f;
        }
        synchronized (f971e) {
            for (String str : f971e) {
                try {
                    SSLContext sSLContext = SSLContext.getInstance(str);
                    sSLContext.init(null, null, null);
                    SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                    f972f = socketFactory;
                    return socketFactory;
                } catch (Exception e) {
                    C0701m.Log(5, "UnityWebRequest: No support for " + str + " (" + e.getMessage() + ")");
                }
            }
            return null;
        }
    }

    private static native void headerCallback(long j, String str, String str2);

    private static native void responseCodeCallback(long j, int i);

    private static native int uploadCallback(long j, ByteBuffer byteBuffer);

    protected void badProtocolCallback(String str) {
        errorCallback(this.f973a, 4, str);
    }

    protected void contentLengthCallback(int i) {
        contentLengthCallback(this.f973a, i);
    }

    protected boolean downloadCallback(ByteBuffer byteBuffer, int i) {
        return downloadCallback(this.f973a, byteBuffer, i);
    }

    protected void errorCallback(String str) {
        errorCallback(this.f973a, 2, str);
    }

    protected void headerCallback(String str, String str2) {
        headerCallback(this.f973a, str, str2);
    }

    protected void headerCallback(Map map) {
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                str = "Status";
            }
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                headerCallback(str, (String) it.next());
            }
        }
    }

    protected void malformattedUrlCallback(String str) {
        errorCallback(this.f973a, 5, str);
    }

    protected void responseCodeCallback(int i) {
        responseCodeCallback(this.f973a, i);
    }

    @Override // java.lang.Runnable
    public void run() {
        InputStream inputStream;
        SSLSocketFactory sSLSocketFactory;
        try {
            URL url = new URL(this.f974b);
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            if ((uRLConnectionOpenConnection instanceof HttpsURLConnection) && (sSLSocketFactory = getSSLSocketFactory()) != null) {
                ((HttpsURLConnection) uRLConnectionOpenConnection).setSSLSocketFactory(sSLSocketFactory);
            }
            if (url.getProtocol().equalsIgnoreCase("file") && !url.getHost().isEmpty()) {
                malformattedUrlCallback("file:// must use an absolute path");
                return;
            }
            if (uRLConnectionOpenConnection instanceof JarURLConnection) {
                badProtocolCallback("A URL Connection to a Java ARchive (JAR) file or an entry in a JAR file is not supported");
                return;
            }
            if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    httpURLConnection.setRequestMethod(this.f975c);
                    httpURLConnection.setInstanceFollowRedirects(false);
                } catch (ProtocolException e) {
                    badProtocolCallback(e.toString());
                    return;
                }
            }
            if (this.f976d != null) {
                for (Map.Entry entry : this.f976d.entrySet()) {
                    uRLConnectionOpenConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            int iUploadCallback = uploadCallback(null);
            if (iUploadCallback > 0) {
                uRLConnectionOpenConnection.setDoOutput(true);
                try {
                    ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(Math.min(iUploadCallback, 1428));
                    OutputStream outputStream = uRLConnectionOpenConnection.getOutputStream();
                    int iUploadCallback2 = uploadCallback(byteBufferAllocateDirect);
                    while (iUploadCallback2 > 0) {
                        outputStream.write(byteBufferAllocateDirect.array(), byteBufferAllocateDirect.arrayOffset(), iUploadCallback2);
                        iUploadCallback2 = uploadCallback(byteBufferAllocateDirect);
                    }
                } catch (Exception e2) {
                    errorCallback(e2.toString());
                    return;
                }
            }
            if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                try {
                    responseCodeCallback(((HttpURLConnection) uRLConnectionOpenConnection).getResponseCode());
                } catch (UnknownHostException e3) {
                    unknownHostCallback(e3.toString());
                } catch (IOException e4) {
                    errorCallback(e4.toString());
                    return;
                }
            }
            Map<String, List<String>> headerFields = uRLConnectionOpenConnection.getHeaderFields();
            headerCallback(headerFields);
            if ((headerFields == null || !headerFields.containsKey("content-length")) && uRLConnectionOpenConnection.getContentLength() != -1) {
                headerCallback("content-length", String.valueOf(uRLConnectionOpenConnection.getContentLength()));
            }
            if ((headerFields == null || !headerFields.containsKey("content-type")) && uRLConnectionOpenConnection.getContentType() != null) {
                headerCallback("content-type", uRLConnectionOpenConnection.getContentType());
            }
            int contentLength = uRLConnectionOpenConnection.getContentLength();
            if (contentLength > 0) {
                contentLengthCallback(contentLength);
            }
            int iMin = url.getProtocol().equalsIgnoreCase("file") ? contentLength == 0 ? 32768 : Math.min(contentLength, 32768) : 1428;
            try {
                if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) uRLConnectionOpenConnection;
                    responseCodeCallback(httpURLConnection2.getResponseCode());
                    inputStream = httpURLConnection2.getErrorStream();
                } else {
                    inputStream = null;
                }
                if (inputStream == null) {
                    inputStream = uRLConnectionOpenConnection.getInputStream();
                }
                ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(inputStream);
                ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(iMin);
                for (int i = readableByteChannelNewChannel.read(byteBufferAllocateDirect2); i != -1 && downloadCallback(byteBufferAllocateDirect2, i); i = readableByteChannelNewChannel.read(byteBufferAllocateDirect2)) {
                    byteBufferAllocateDirect2.clear();
                }
                readableByteChannelNewChannel.close();
            } catch (UnknownHostException e5) {
                unknownHostCallback(e5.toString());
            } catch (SSLHandshakeException e6) {
                sslCannotConnectCallback(e6.toString());
            } catch (Exception e7) {
                errorCallback(e7.toString());
            }
        } catch (MalformedURLException e8) {
            malformattedUrlCallback(e8.toString());
        } catch (IOException e9) {
            errorCallback(e9.toString());
        }
    }

    protected void sslCannotConnectCallback(String str) {
        errorCallback(this.f973a, 16, str);
    }

    protected void unknownHostCallback(String str) {
        errorCallback(this.f973a, 7, str);
    }

    protected int uploadCallback(ByteBuffer byteBuffer) {
        return uploadCallback(this.f973a, byteBuffer);
    }
}
