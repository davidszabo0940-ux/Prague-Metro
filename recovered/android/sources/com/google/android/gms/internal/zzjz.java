package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzjz {
    private final Object zzail;
    private final zzkb zzanz;
    private boolean zzcfe;
    private final LinkedList<zza> zzciv;
    private final String zzciw;
    private final String zzcix;
    private long zzciy;
    private long zzciz;
    private long zzcja;
    private long zzcjb;
    private long zzcjc;
    private long zzcjd;

    @zzir
    private static final class zza {
        private long zzcje = -1;
        private long zzcjf = -1;

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.zzcje);
            bundle.putLong("tclose", this.zzcjf);
            return bundle;
        }

        public long zzsc() {
            return this.zzcjf;
        }

        public void zzsd() {
            this.zzcjf = SystemClock.elapsedRealtime();
        }

        public void zzse() {
            this.zzcje = SystemClock.elapsedRealtime();
        }
    }

    public zzjz(zzkb zzkbVar, String str, String str2) {
        this.zzail = new Object();
        this.zzciy = -1L;
        this.zzciz = -1L;
        this.zzcfe = false;
        this.zzcja = -1L;
        this.zzcjb = 0L;
        this.zzcjc = -1L;
        this.zzcjd = -1L;
        this.zzanz = zzkbVar;
        this.zzciw = str;
        this.zzcix = str2;
        this.zzciv = new LinkedList<>();
    }

    public zzjz(String str, String str2) {
        this(com.google.android.gms.ads.internal.zzu.zzft(), str, str2);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.zzail) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzciw);
            bundle.putString("slotid", this.zzcix);
            bundle.putBoolean("ismediation", this.zzcfe);
            bundle.putLong("treq", this.zzcjc);
            bundle.putLong("tresponse", this.zzcjd);
            bundle.putLong("timp", this.zzciz);
            bundle.putLong("tload", this.zzcja);
            bundle.putLong("pcc", this.zzcjb);
            bundle.putLong("tfetch", this.zzciy);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zza> it = this.zzciv.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public void zzac(boolean z) {
        synchronized (this.zzail) {
            if (this.zzcjd != -1) {
                this.zzcja = SystemClock.elapsedRealtime();
                if (!z) {
                    this.zzciz = this.zzcja;
                    this.zzanz.zza(this);
                }
            }
        }
    }

    public void zzad(boolean z) {
        synchronized (this.zzail) {
            if (this.zzcjd != -1) {
                this.zzcfe = z;
                this.zzanz.zza(this);
            }
        }
    }

    public void zzl(long j) {
        synchronized (this.zzail) {
            this.zzcjd = j;
            if (this.zzcjd != -1) {
                this.zzanz.zza(this);
            }
        }
    }

    public void zzm(long j) {
        synchronized (this.zzail) {
            if (this.zzcjd != -1) {
                this.zzciy = j;
                this.zzanz.zza(this);
            }
        }
    }

    public void zzq(AdRequestParcel adRequestParcel) {
        synchronized (this.zzail) {
            this.zzcjc = SystemClock.elapsedRealtime();
            this.zzanz.zzsl().zzb(adRequestParcel, this.zzcjc);
        }
    }

    public void zzrz() {
        synchronized (this.zzail) {
            if (this.zzcjd != -1 && this.zzciz == -1) {
                this.zzciz = SystemClock.elapsedRealtime();
                this.zzanz.zza(this);
            }
            this.zzanz.zzsl().zzrz();
        }
    }

    public void zzsa() {
        synchronized (this.zzail) {
            if (this.zzcjd != -1) {
                zza zzaVar = new zza();
                zzaVar.zzse();
                this.zzciv.add(zzaVar);
                this.zzcjb++;
                this.zzanz.zzsl().zzsa();
                this.zzanz.zza(this);
            }
        }
    }

    public void zzsb() {
        synchronized (this.zzail) {
            if (this.zzcjd != -1 && !this.zzciv.isEmpty()) {
                zza last = this.zzciv.getLast();
                if (last.zzsc() == -1) {
                    last.zzsd();
                    this.zzanz.zza(this);
                }
            }
        }
    }
}
