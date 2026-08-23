package com.google.android.gms.common.data;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzf<T> extends AbstractDataBuffer<T> {

    /* JADX INFO: renamed from: wc */
    private boolean f201wc;

    /* JADX INFO: renamed from: wd */
    private ArrayList<Integer> f202wd;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
        this.f201wc = false;
    }

    private void zzarh() {
        synchronized (this) {
            if (!this.f201wc) {
                int count = this.f172tk.getCount();
                this.f202wd = new ArrayList<>();
                if (count > 0) {
                    this.f202wd.add(0);
                    String strZzarg = zzarg();
                    String strZzd = this.f172tk.zzd(strZzarg, 0, this.f172tk.zzfo(0));
                    int i = 1;
                    while (i < count) {
                        int iZzfo = this.f172tk.zzfo(i);
                        String strZzd2 = this.f172tk.zzd(strZzarg, i, iZzfo);
                        if (strZzd2 == null) {
                            throw new NullPointerException(new StringBuilder(String.valueOf(strZzarg).length() + 78).append("Missing value for markerColumn: ").append(strZzarg).append(", at row: ").append(i).append(", for window: ").append(iZzfo).toString());
                        }
                        if (strZzd2.equals(strZzd)) {
                            strZzd2 = strZzd;
                        } else {
                            this.f202wd.add(Integer.valueOf(i));
                        }
                        i++;
                        strZzd = strZzd2;
                    }
                }
                this.f201wc = true;
            }
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final T get(int i) {
        zzarh();
        return zzl(zzfs(i), zzft(i));
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        zzarh();
        return this.f202wd.size();
    }

    protected abstract String zzarg();

    protected String zzari() {
        return null;
    }

    int zzfs(int i) {
        if (i < 0 || i >= this.f202wd.size()) {
            throw new IllegalArgumentException(new StringBuilder(53).append("Position ").append(i).append(" is out of bounds for this buffer").toString());
        }
        return this.f202wd.get(i).intValue();
    }

    protected int zzft(int i) {
        if (i < 0 || i == this.f202wd.size()) {
            return 0;
        }
        int count = i == this.f202wd.size() + (-1) ? this.f172tk.getCount() - this.f202wd.get(i).intValue() : this.f202wd.get(i + 1).intValue() - this.f202wd.get(i).intValue();
        if (count != 1) {
            return count;
        }
        int iZzfs = zzfs(i);
        int iZzfo = this.f172tk.zzfo(iZzfs);
        String strZzari = zzari();
        if (strZzari == null || this.f172tk.zzd(strZzari, iZzfs, iZzfo) != null) {
            return count;
        }
        return 0;
    }

    protected abstract T zzl(int i, int i2);
}
