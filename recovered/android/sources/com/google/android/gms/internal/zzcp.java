package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
@zzir
public abstract class zzcp {
    private static MessageDigest zzasx = null;
    protected Object zzail = new Object();

    abstract byte[] zzaa(String str);

    protected MessageDigest zzie() {
        MessageDigest messageDigest;
        synchronized (this.zzail) {
            if (zzasx != null) {
                messageDigest = zzasx;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        zzasx = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = zzasx;
            }
        }
        return messageDigest;
    }
}
