package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
@zzir
class zzfs {
    final String zzall;
    final AdRequestParcel zzana;
    final int zzbkx;

    zzfs(AdRequestParcel adRequestParcel, String str, int i) {
        this.zzana = adRequestParcel;
        this.zzall = str;
        this.zzbkx = i;
    }

    zzfs(zzfq zzfqVar) {
        this(zzfqVar.zzls(), zzfqVar.getAdUnitId(), zzfqVar.getNetworkType());
    }

    zzfs(String str) throws IOException {
        String[] strArrSplit = str.split("\u0000");
        if (strArrSplit.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.zzall = new String(Base64.decode(strArrSplit[0], 0), "UTF-8");
                this.zzbkx = Integer.parseInt(strArrSplit[1]);
                byte[] bArrDecode = Base64.decode(strArrSplit[2], 0);
                parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
                parcelObtain.setDataPosition(0);
                this.zzana = (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(parcelObtain);
                parcelObtain.recycle();
            } catch (IllegalArgumentException e) {
                throw new IOException("Malformed QueueSeed encoding.");
            }
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    String zzlz() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                String strEncodeToString = Base64.encodeToString(this.zzall.getBytes("UTF-8"), 0);
                String string2 = Integer.toString(this.zzbkx);
                this.zzana.writeToParcel(parcelObtain, 0);
                String strEncodeToString2 = Base64.encodeToString(parcelObtain.marshall(), 0);
                string = new StringBuilder(String.valueOf(strEncodeToString).length() + 2 + String.valueOf(string2).length() + String.valueOf(strEncodeToString2).length()).append(strEncodeToString).append("\u0000").append(string2).append("\u0000").append(strEncodeToString2).toString();
                parcelObtain.recycle();
            } catch (UnsupportedEncodingException e) {
                zzkh.m14e("QueueSeed encode failed because UTF-8 is not available.");
                parcelObtain.recycle();
                string = "";
            }
            return string;
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }
}
