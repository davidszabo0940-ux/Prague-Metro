package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzcq {
    private final int zzasz;
    private final zzcp zzatb = new zzcs();
    private final int zzasy = 6;
    private final int zzata = 0;

    static class zza {
        ByteArrayOutputStream zzatd = new ByteArrayOutputStream(4096);
        Base64OutputStream zzate = new Base64OutputStream(this.zzatd, 10);

        /* JADX WARN: Multi-variable type inference failed */
        public String toString() {
            String string;
            try {
                this.zzate.close();
            } catch (IOException e) {
                zzkh.zzb("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.zzatd.close();
                string = this.zzatd.toString();
            } catch (IOException e2) {
                zzkh.zzb("HashManager: Unable to convert to Base64.", e2);
                string = "";
            } finally {
                this.zzatd = null;
                this.zzate = null;
            }
            return string;
        }

        public void write(byte[] bArr) throws IOException {
            this.zzate.write(bArr);
        }
    }

    public zzcq(int i) {
        this.zzasz = i;
    }

    public String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        return zzab(stringBuffer.toString());
    }

    String zzab(String str) {
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 0) {
            return "";
        }
        zza zzaVarZzif = zzif();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzasz, new Comparator<zzct.zza>() { // from class: com.google.android.gms.internal.zzcq.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public int compare(zzct.zza zzaVar, zzct.zza zzaVar2) {
                int i = zzaVar.zzath - zzaVar2.zzath;
                return i != 0 ? i : (int) (zzaVar.value - zzaVar2.value);
            }
        });
        for (String str2 : strArrSplit) {
            String[] strArrZzad = zzcr.zzad(str2);
            if (strArrZzad.length != 0) {
                zzct.zza(strArrZzad, this.zzasz, this.zzasy, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzaVarZzif.write(this.zzatb.zzaa(((zzct.zza) it.next()).zzatg));
            } catch (IOException e) {
                zzkh.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzaVarZzif.toString();
    }

    zza zzif() {
        return new zza();
    }
}
