package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class zzaer {
    private static HashMap<String, String> aLZ;
    private static Object aMa;
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri aLW = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern aLX = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern aLY = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static String[] aMb = new String[0];
    private static Context aMc = null;

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        String string = getString(contentResolver, str);
        if (string == null) {
            return j;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            return j;
        }
    }

    public static String getString(ContentResolver contentResolver, String str) {
        return zza(contentResolver, str, null);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004a A[Catch: all -> 0x0074, TRY_LEAVE, TryCatch #2 {all -> 0x0074, blocks: (B:22:0x0044, B:28:0x0057, B:29:0x005d, B:40:0x0073, B:24:0x004a, B:30:0x005e, B:32:0x0062, B:33:0x0067), top: B:48:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzaer.class) {
            zza(contentResolver);
            Object obj = aMa;
            if (aLZ.containsKey(str)) {
                String str3 = aLZ.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            } else {
                for (String str4 : aMb) {
                    if (!str.startsWith(str4)) {
                    }
                }
                Cursor cursorQuery = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(1);
                            synchronized (zzaer.class) {
                                if (obj == aMa) {
                                    aLZ.put(str, string);
                                }
                            }
                            if (string != null) {
                                str2 = string;
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        } else {
                            aLZ.put(str, null);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                } else {
                    aLZ.put(str, null);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        }
        return str2;
    }

    public static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor cursorQuery = contentResolver.query(aLW, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    treeMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            cursorQuery.close();
        }
        return treeMap;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.internal.zzaer$1] */
    private static void zza(final ContentResolver contentResolver) {
        if (aLZ == null) {
            aLZ = new HashMap<>();
            aMa = new Object();
            new Thread("Gservices") { // from class: com.google.android.gms.internal.zzaer.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Looper.prepare();
                    contentResolver.registerContentObserver(zzaer.CONTENT_URI, true, new ContentObserver(new Handler(Looper.myLooper())) { // from class: com.google.android.gms.internal.zzaer.1.1
                        @Override // android.database.ContentObserver
                        public void onChange(boolean z) {
                            synchronized (zzaer.class) {
                                zzaer.aLZ.clear();
                                Object unused = zzaer.aMa = new Object();
                                if (zzaer.aMb.length > 0) {
                                    zzaer.zzb(contentResolver, zzaer.aMb);
                                }
                            }
                        }
                    });
                    Looper.loop();
                }
            }.start();
        }
    }

    public static void zzb(ContentResolver contentResolver, String... strArr) {
        Map<String, String> mapZza = zza(contentResolver, strArr);
        synchronized (zzaer.class) {
            zza(contentResolver);
            aMb = strArr;
            for (Map.Entry<String, String> entry : mapZza.entrySet()) {
                aLZ.put(entry.getKey(), entry.getValue());
            }
        }
    }
}
