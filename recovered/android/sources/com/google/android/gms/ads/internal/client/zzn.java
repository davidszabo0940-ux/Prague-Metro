package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.zzir;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzn extends zzy.zza {
    private Object zzail = new Object();
    private final Random zzavn = new Random();
    private long zzavo;

    public zzn() {
        zziy();
    }

    @Override // com.google.android.gms.ads.internal.client.zzy
    public long getValue() {
        return this.zzavo;
    }

    public void zziy() {
        synchronized (this.zzail) {
            int i = 3;
            long jNextInt = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                jNextInt = ((long) this.zzavn.nextInt()) + 2147483648L;
                if (jNextInt != this.zzavo && jNextInt != 0) {
                    break;
                }
            }
            this.zzavo = jNextInt;
        }
    }
}
