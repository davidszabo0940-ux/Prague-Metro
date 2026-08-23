package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzc {

    /* JADX INFO: renamed from: tk */
    protected final DataHolder f196tk;

    /* JADX INFO: renamed from: vK */
    protected int f197vK;

    /* JADX INFO: renamed from: vL */
    private int f198vL;

    public zzc(DataHolder dataHolder, int i) {
        this.f196tk = (DataHolder) zzab.zzaa(dataHolder);
        zzfm(i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzcVar = (zzc) obj;
        return zzaa.equal(Integer.valueOf(zzcVar.f197vK), Integer.valueOf(this.f197vK)) && zzaa.equal(Integer.valueOf(zzcVar.f198vL), Integer.valueOf(this.f198vL)) && zzcVar.f196tk == this.f196tk;
    }

    protected boolean getBoolean(String str) {
        return this.f196tk.zze(str, this.f197vK, this.f198vL);
    }

    protected byte[] getByteArray(String str) {
        return this.f196tk.zzg(str, this.f197vK, this.f198vL);
    }

    protected float getFloat(String str) {
        return this.f196tk.zzf(str, this.f197vK, this.f198vL);
    }

    protected int getInteger(String str) {
        return this.f196tk.zzc(str, this.f197vK, this.f198vL);
    }

    protected long getLong(String str) {
        return this.f196tk.zzb(str, this.f197vK, this.f198vL);
    }

    protected String getString(String str) {
        return this.f196tk.zzd(str, this.f197vK, this.f198vL);
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.f197vK), Integer.valueOf(this.f198vL), this.f196tk);
    }

    public boolean isDataValid() {
        return !this.f196tk.isClosed();
    }

    protected void zza(String str, CharArrayBuffer charArrayBuffer) {
        this.f196tk.zza(str, this.f197vK, this.f198vL, charArrayBuffer);
    }

    protected int zzarb() {
        return this.f197vK;
    }

    protected void zzfm(int i) {
        zzab.zzbm(i >= 0 && i < this.f196tk.getCount());
        this.f197vK = i;
        this.f198vL = this.f196tk.zzfo(this.f197vK);
    }

    public boolean zzhf(String str) {
        return this.f196tk.zzhf(str);
    }

    protected Uri zzhg(String str) {
        return this.f196tk.zzh(str, this.f197vK, this.f198vL);
    }

    protected boolean zzhh(String str) {
        return this.f196tk.zzi(str, this.f197vK, this.f198vL);
    }
}
