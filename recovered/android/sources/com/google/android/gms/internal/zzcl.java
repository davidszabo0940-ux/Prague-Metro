package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzcl {
    private final int zzart;
    private final int zzaru;
    private final int zzarv;
    private final zzcq zzarw;
    private int zzasc;
    private final Object zzail = new Object();
    private ArrayList<String> zzarx = new ArrayList<>();
    private ArrayList<String> zzary = new ArrayList<>();
    private int zzarz = 0;
    private int zzasa = 0;
    private int zzasb = 0;
    private String zzasd = "";
    private String zzase = "";

    public zzcl(int i, int i2, int i3, int i4) {
        this.zzart = i;
        this.zzaru = i2;
        this.zzarv = i3;
        this.zzarw = new zzcq(i4);
    }

    private String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String string = stringBuffer.toString();
        return string.length() >= i ? string.substring(0, i) : string;
    }

    private void zzf(String str, boolean z) {
        if (str == null || str.length() < this.zzarv) {
            return;
        }
        synchronized (this.zzail) {
            this.zzarx.add(str);
            this.zzarz += str.length();
            if (z) {
                this.zzary.add(str);
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzcl)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzcl zzclVar = (zzcl) obj;
        return zzclVar.zzhr() != null && zzclVar.zzhr().equals(zzhr());
    }

    public int getScore() {
        return this.zzasc;
    }

    public int hashCode() {
        return zzhr().hashCode();
    }

    public String toString() {
        int i = this.zzasa;
        int i2 = this.zzasc;
        int i3 = this.zzarz;
        String strValueOf = String.valueOf(zza(this.zzarx, 100));
        String strValueOf2 = String.valueOf(zza(this.zzary, 100));
        String str = this.zzasd;
        String str2 = this.zzase;
        return new StringBuilder(String.valueOf(strValueOf).length() + 133 + String.valueOf(strValueOf2).length() + String.valueOf(str).length() + String.valueOf(str2).length()).append("ActivityContent fetchId: ").append(i).append(" score:").append(i2).append(" total_length:").append(i3).append("\n text: ").append(strValueOf).append("\n viewableText").append(strValueOf2).append("\n signture: ").append(str).append("\n viewableSignture: ").append(str2).toString();
    }

    int zza(int i, int i2) {
        return (this.zzart * i) + (this.zzaru * i2);
    }

    public void zzd(String str, boolean z) {
        zzf(str, z);
        synchronized (this.zzail) {
            if (this.zzasb < 0) {
                zzkh.zzcw("ActivityContent: negative number of WebViews.");
            }
            zzhw();
        }
    }

    public void zze(String str, boolean z) {
        zzf(str, z);
    }

    public boolean zzhq() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzasb == 0;
        }
        return z;
    }

    public String zzhr() {
        return this.zzasd;
    }

    public String zzhs() {
        return this.zzase;
    }

    public void zzht() {
        synchronized (this.zzail) {
            this.zzasc -= 100;
        }
    }

    public void zzhu() {
        synchronized (this.zzail) {
            this.zzasb--;
        }
    }

    public void zzhv() {
        synchronized (this.zzail) {
            this.zzasb++;
        }
    }

    public void zzhw() {
        synchronized (this.zzail) {
            int iZza = zza(this.zzarz, this.zzasa);
            if (iZza > this.zzasc) {
                this.zzasc = iZza;
                this.zzasd = this.zzarw.zza(this.zzarx);
                this.zzase = this.zzarw.zza(this.zzary);
            }
        }
    }

    int zzhx() {
        return this.zzarz;
    }

    public void zzl(int i) {
        this.zzasa = i;
    }
}
