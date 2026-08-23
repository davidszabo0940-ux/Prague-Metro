package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.zza<String, Integer> {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;

    /* JADX INFO: renamed from: zo */
    private final HashMap<String, Integer> f378zo;

    /* JADX INFO: renamed from: zp */
    private final SparseArray<String> f379zp;

    /* JADX INFO: renamed from: zq */
    private final ArrayList<Entry> f380zq;

    public static final class Entry extends AbstractSafeParcelable {
        public static final zzc CREATOR = new zzc();
        final int versionCode;

        /* JADX INFO: renamed from: zr */
        final String f381zr;

        /* JADX INFO: renamed from: zs */
        final int f382zs;

        Entry(int i, String str, int i2) {
            this.versionCode = i;
            this.f381zr = str;
            this.f382zs = i2;
        }

        Entry(String str, int i) {
            this.versionCode = 1;
            this.f381zr = str;
            this.f382zs = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzc zzcVar = CREATOR;
            zzc.zza(this, parcel, i);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.f378zo = new HashMap<>();
        this.f379zp = new SparseArray<>();
        this.f380zq = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.mVersionCode = i;
        this.f378zo = new HashMap<>();
        this.f379zp = new SparseArray<>();
        this.f380zq = null;
        zzh(arrayList);
    }

    private void zzh(ArrayList<Entry> arrayList) {
        for (Entry entry : arrayList) {
            zzi(entry.f381zr, entry.f382zs);
        }
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, parcel, i);
    }

    ArrayList<Entry> zzato() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String str : this.f378zo.keySet()) {
            arrayList.add(new Entry(str, this.f378zo.get(str).intValue()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public int zzatp() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public int zzatq() {
        return 0;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public String convertBack(Integer num) {
        String str = this.f379zp.get(num.intValue());
        return (str == null && this.f378zo.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public StringToIntConverter zzi(String str, int i) {
        this.f378zo.put(str, Integer.valueOf(i));
        this.f379zp.put(i, str);
        return this;
    }
}
