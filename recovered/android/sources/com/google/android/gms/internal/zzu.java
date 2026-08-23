package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzu {
    protected static final Comparator<byte[]> zzbv = new Comparator<byte[]>() { // from class: com.google.android.gms.internal.zzu.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private List<byte[]> zzbr = new LinkedList();
    private List<byte[]> zzbs = new ArrayList(64);
    private int zzbt = 0;
    private final int zzbu;

    public zzu(int i) {
        this.zzbu = i;
    }

    private synchronized void zzx() {
        while (this.zzbt > this.zzbu) {
            byte[] bArrRemove = this.zzbr.remove(0);
            this.zzbs.remove(bArrRemove);
            this.zzbt -= bArrRemove.length;
        }
    }

    public synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.zzbu) {
                this.zzbr.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.zzbs, bArr, zzbv);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.zzbs.add(iBinarySearch, bArr);
                this.zzbt += bArr.length;
                zzx();
            }
        }
    }

    public synchronized byte[] zzb(int i) {
        byte[] bArr;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.zzbs.size()) {
                bArr = new byte[i];
                break;
            }
            bArr = this.zzbs.get(i3);
            if (bArr.length >= i) {
                this.zzbt -= bArr.length;
                this.zzbs.remove(i3);
                this.zzbr.remove(bArr);
                break;
            }
            i2 = i3 + 1;
        }
        return bArr;
    }
}
