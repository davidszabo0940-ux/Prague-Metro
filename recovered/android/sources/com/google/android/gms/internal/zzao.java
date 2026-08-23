package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzao implements zzan {
    protected MotionEvent zzafd;
    protected LinkedList<MotionEvent> zzafe = new LinkedList<>();
    protected long zzaff = 0;
    protected long zzafg = 0;
    protected long zzafh = 0;
    protected long zzafi = 0;
    protected long zzafj = 0;
    private boolean zzafk = false;
    protected DisplayMetrics zzafl;

    protected zzao(Context context) {
        zzak.zzas();
        try {
            this.zzafl = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.zzafl = new DisplayMetrics();
            this.zzafl.density = 1.0f;
        }
    }

    private String zza(Context context, String str, boolean z) {
        zzae.zza zzaVarZzc;
        try {
            if (z) {
                zzaVarZzc = zzd(context);
                this.zzafk = true;
            } else {
                zzaVarZzc = zzc(context);
            }
            if (zzaVarZzc == null || zzaVarZzc.m81ao() == 0) {
                return Integer.toString(5);
            }
            return zzak.zza(zzaVarZzc, str, zzb(z) ? false : true);
        } catch (UnsupportedEncodingException e) {
            return Integer.toString(7);
        } catch (NoSuchAlgorithmException e2) {
            return Integer.toString(7);
        } catch (Throwable th) {
            return Integer.toString(3);
        }
    }

    private void zzaw() {
        if (zzdc.zzbbr.get().booleanValue()) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int i = 0;
            for (int length = stackTrace.length - 1; length >= 0; length--) {
                i++;
                if (stackTrace[length].toString().startsWith("com.google.android.ads.") || stackTrace[length].toString().startsWith("com.google.android.gms.")) {
                    break;
                }
            }
            this.zzafj = i;
        }
    }

    private static boolean zzb(boolean z) {
        if (zzdc.zzbbj.get().booleanValue()) {
            return zzdc.zzbbs.get().booleanValue() && z;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.zzan
    public void zza(int i, int i2, int i3) {
        if (this.zzafd != null) {
            this.zzafd.recycle();
        }
        this.zzafd = MotionEvent.obtain(0L, i3, 1, i * this.zzafl.density, i2 * this.zzafl.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    @Override // com.google.android.gms.internal.zzan
    public void zza(MotionEvent motionEvent) {
        if (this.zzafk) {
            this.zzafi = 0L;
            this.zzafh = 0L;
            this.zzafg = 0L;
            this.zzaff = 0L;
            this.zzafj = 0L;
            Iterator<MotionEvent> it = this.zzafe.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.zzafe.clear();
            this.zzafd = null;
            this.zzafk = false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.zzaff++;
                break;
            case 1:
                this.zzafd = MotionEvent.obtain(motionEvent);
                this.zzafe.add(this.zzafd);
                if (this.zzafe.size() > 6) {
                    this.zzafe.remove().recycle();
                }
                this.zzafh++;
                zzaw();
                break;
            case 2:
                this.zzafg += (long) (motionEvent.getHistorySize() + 1);
                break;
            case 3:
                this.zzafi++;
                break;
        }
    }

    @Override // com.google.android.gms.internal.zzan
    public String zzb(Context context) {
        return zza(context, (String) null, false);
    }

    @Override // com.google.android.gms.internal.zzan
    public String zzb(Context context, String str) {
        return zza(context, str, true);
    }

    protected abstract zzae.zza zzc(Context context);

    protected abstract zzae.zza zzd(Context context);
}
