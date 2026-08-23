package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class LargeParcelTeleporter extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LargeParcelTeleporter> CREATOR = new zzm();
    final int mVersionCode;
    ParcelFileDescriptor zzcdd;
    private Parcelable zzcde;
    private boolean zzcdf;

    LargeParcelTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.mVersionCode = i;
        this.zzcdd = parcelFileDescriptor;
        this.zzcde = null;
        this.zzcdf = true;
    }

    public LargeParcelTeleporter(SafeParcelable safeParcelable) {
        this.mVersionCode = 1;
        this.zzcdd = null;
        this.zzcde = safeParcelable;
        this.zzcdf = false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.zzcdd == null) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                this.zzcde.writeToParcel(parcelObtain, 0);
                byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                this.zzcdd = zzi(bArrMarshall);
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        zzm.zza(this, parcel, i);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0052 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        if (this.zzcdf) {
            if (this.zzcdd == null) {
                zzkh.m14e("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzcdd));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                com.google.android.gms.common.util.zzo.zzb(dataInputStream);
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.unmarshall(bArr, 0, bArr.length);
                    parcelObtain.setDataPosition(0);
                    this.zzcde = creator.createFromParcel(parcelObtain);
                    parcelObtain.recycle();
                    this.zzcdf = false;
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    throw th;
                }
            } catch (IOException e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            }
        }
        return (T) this.zzcde;
    }

    protected <T> ParcelFileDescriptor zzi(final byte[] bArr) {
        final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
            try {
                new Thread(new Runnable() { // from class: com.google.android.gms.ads.internal.request.LargeParcelTeleporter.1
                    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
                    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        DataOutputStream dataOutputStream;
                        try {
                            try {
                                dataOutputStream = new DataOutputStream(autoCloseOutputStream);
                                try {
                                    dataOutputStream.writeInt(bArr.length);
                                    dataOutputStream.write(bArr);
                                    com.google.android.gms.common.util.zzo.zzb(dataOutputStream);
                                } catch (IOException e) {
                                    e = e;
                                    zzkh.zzb("Error transporting the ad response", e);
                                    zzu.zzft().zzb((Throwable) e, true);
                                    if (dataOutputStream == null) {
                                        com.google.android.gms.common.util.zzo.zzb(autoCloseOutputStream);
                                    } else {
                                        com.google.android.gms.common.util.zzo.zzb(dataOutputStream);
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (dataOutputStream == null) {
                                    com.google.android.gms.common.util.zzo.zzb(autoCloseOutputStream);
                                } else {
                                    com.google.android.gms.common.util.zzo.zzb(dataOutputStream);
                                }
                                throw th;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            dataOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream = null;
                            if (dataOutputStream == null) {
                                com.google.android.gms.common.util.zzo.zzb(autoCloseOutputStream);
                            } else {
                                com.google.android.gms.common.util.zzo.zzb(dataOutputStream);
                            }
                            throw th;
                        }
                    }
                }).start();
                return parcelFileDescriptorArrCreatePipe[0];
            } catch (IOException e) {
                e = e;
                zzkh.zzb("Error transporting the ad response", e);
                zzu.zzft().zzb((Throwable) e, true);
                com.google.android.gms.common.util.zzo.zzb(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
        }
    }
}
