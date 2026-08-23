package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzapb;
import com.google.android.gms.internal.zzapc;

/* JADX INFO: loaded from: classes.dex */
public final class GassResponseParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GassResponseParcel> CREATOR = new zzd();
    private zzae.zza aaw = null;
    private byte[] aax;
    public final int versionCode;

    GassResponseParcel(int i, byte[] bArr) {
        this.versionCode = i;
        this.aax = bArr;
        zzawr();
    }

    private void zzawp() {
        if (!zzawq()) {
            try {
                this.aaw = zzae.zza.zzc(this.aax);
                this.aax = null;
            } catch (zzapb e) {
                throw new IllegalStateException(e);
            }
        }
        zzawr();
    }

    private boolean zzawq() {
        return this.aaw != null;
    }

    private void zzawr() {
        if (this.aaw != null || this.aax == null) {
            if (this.aaw == null || this.aax != null) {
                if (this.aaw != null && this.aax != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (this.aaw != null || this.aax != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public byte[] zzblz() {
        return this.aax != null ? this.aax : zzapc.zzf(this.aaw);
    }

    public zzae.zza zzbma() {
        zzawp();
        return this.aaw;
    }
}
