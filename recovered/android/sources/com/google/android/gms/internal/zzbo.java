package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class zzbo {
    protected static final String TAG = zzbo.class.getSimpleName();
    private final String className;
    private final zzax zzaey;
    private final String zzahf;
    private List<Class> zzahi;
    private final int zzahg = 2;
    private volatile Method zzahh = null;
    private CountDownLatch zzahj = new CountDownLatch(1);

    public zzbo(zzax zzaxVar, String str, String str2, List<Class> list) {
        this.zzaey = zzaxVar;
        this.className = str;
        this.zzahf = str2;
        this.zzahi = new ArrayList(list);
        this.zzaey.zzce().submit(new Runnable() { // from class: com.google.android.gms.internal.zzbo.1
            @Override // java.lang.Runnable
            public void run() {
                zzbo.this.zzcz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzcz() {
        try {
            Class clsLoadClass = this.zzaey.zzcf().loadClass(zzd(this.zzaey.zzch(), this.className));
            if (clsLoadClass == null) {
                this.zzahj.countDown();
                return;
            }
            this.zzahh = clsLoadClass.getMethod(zzd(this.zzaey.zzch(), this.zzahf), (Class[]) this.zzahi.toArray(new Class[this.zzahi.size()]));
            if (this.zzahh == null) {
                this.zzahj.countDown();
            } else {
                this.zzahj.countDown();
            }
        } catch (zzau.zza e) {
            this.zzahj.countDown();
        } catch (UnsupportedEncodingException e2) {
            this.zzahj.countDown();
        } catch (ClassNotFoundException e3) {
            this.zzahj.countDown();
        } catch (NoSuchMethodException e4) {
            this.zzahj.countDown();
        } catch (NullPointerException e5) {
            this.zzahj.countDown();
        } catch (Throwable th) {
            this.zzahj.countDown();
            throw th;
        }
    }

    private String zzd(byte[] bArr, String str) throws zzau.zza, UnsupportedEncodingException {
        return new String(this.zzaey.zzcg().zzc(bArr, str), "UTF-8");
    }

    public Method zzda() {
        if (this.zzahh != null) {
            return this.zzahh;
        }
        try {
            if (this.zzahj.await(2L, TimeUnit.SECONDS)) {
                return this.zzahh;
            }
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
