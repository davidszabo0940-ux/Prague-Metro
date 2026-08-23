package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new zze();

    /* JADX INFO: renamed from: vW */
    private static final zza f178vW = new zza(new String[0], null) { // from class: com.google.android.gms.common.data.DataHolder.1
        @Override // com.google.android.gms.common.data.DataHolder.zza
        public zza zza(ContentValues contentValues) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

        @Override // com.google.android.gms.common.data.DataHolder.zza
        public zza zza(HashMap<String, Object> map) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }
    };
    boolean mClosed;
    private final int mVersionCode;

    /* JADX INFO: renamed from: ob */
    private final int f179ob;

    /* JADX INFO: renamed from: vO */
    private final String[] f180vO;

    /* JADX INFO: renamed from: vP */
    Bundle f181vP;

    /* JADX INFO: renamed from: vQ */
    private final CursorWindow[] f182vQ;

    /* JADX INFO: renamed from: vR */
    private final Bundle f183vR;

    /* JADX INFO: renamed from: vS */
    int[] f184vS;

    /* JADX INFO: renamed from: vT */
    int f185vT;

    /* JADX INFO: renamed from: vU */
    private Object f186vU;

    /* JADX INFO: renamed from: vV */
    private boolean f187vV;

    public static class zza {

        /* JADX INFO: renamed from: vO */
        private final String[] f188vO;

        /* JADX INFO: renamed from: vX */
        private final ArrayList<HashMap<String, Object>> f189vX;

        /* JADX INFO: renamed from: vY */
        private final String f190vY;

        /* JADX INFO: renamed from: vZ */
        private final HashMap<Object, Integer> f191vZ;

        /* JADX INFO: renamed from: wa */
        private boolean f192wa;

        /* JADX INFO: renamed from: wb */
        private String f193wb;

        private zza(String[] strArr, String str) {
            this.f188vO = (String[]) zzab.zzaa(strArr);
            this.f189vX = new ArrayList<>();
            this.f190vY = str;
            this.f191vZ = new HashMap<>();
            this.f192wa = false;
            this.f193wb = null;
        }

        private int zzb(HashMap<String, Object> map) {
            Object obj;
            if (this.f190vY != null && (obj = map.get(this.f190vY)) != null) {
                Integer num = this.f191vZ.get(obj);
                if (num != null) {
                    return num.intValue();
                }
                this.f191vZ.put(obj, Integer.valueOf(this.f189vX.size()));
                return -1;
            }
            return -1;
        }

        public zza zza(ContentValues contentValues) {
            com.google.android.gms.common.internal.zzb.zzw(contentValues);
            HashMap<String, Object> map = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            return zza(map);
        }

        public zza zza(HashMap<String, Object> map) {
            com.google.android.gms.common.internal.zzb.zzw(map);
            int iZzb = zzb(map);
            if (iZzb == -1) {
                this.f189vX.add(map);
            } else {
                this.f189vX.remove(iZzb);
                this.f189vX.add(iZzb, map);
            }
            this.f192wa = false;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DataHolder zzfq(int i) {
            return new DataHolder(this, i, (Bundle) null);
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.f187vV = true;
        this.mVersionCode = i;
        this.f180vO = strArr;
        this.f182vQ = cursorWindowArr;
        this.f179ob = i2;
        this.f183vR = bundle;
    }

    private DataHolder(zza zzaVar, int i, Bundle bundle) {
        this(zzaVar.f188vO, zza(zzaVar, -1), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.f187vV = true;
        this.mVersionCode = 1;
        this.f180vO = (String[]) zzab.zzaa(strArr);
        this.f182vQ = (CursorWindow[]) zzab.zzaa(cursorWindowArr);
        this.f179ob = i;
        this.f183vR = bundle;
        zzard();
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(f178vW, i, bundle);
    }

    private static CursorWindow[] zza(zza zzaVar, int i) {
        int i2;
        boolean z;
        CursorWindow cursorWindow;
        if (zzaVar.f188vO.length == 0) {
            return new CursorWindow[0];
        }
        List listSubList = (i < 0 || i >= zzaVar.f189vX.size()) ? zzaVar.f189vX : zzaVar.f189vX.subList(0, i);
        int size = listSubList.size();
        CursorWindow cursorWindow2 = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow2);
        cursorWindow2.setNumColumns(zzaVar.f188vO.length);
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", new StringBuilder(72).append("Allocating additional cursor window for large data set (row ").append(i3).append(")").toString());
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(zzaVar.f188vO.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) listSubList.get(i3);
                boolean zPutDouble = true;
                for (int i4 = 0; i4 < zzaVar.f188vO.length && zPutDouble; i4++) {
                    String str = zzaVar.f188vO[i4];
                    Object obj = map.get(str);
                    if (obj == null) {
                        zPutDouble = cursorWindow2.putNull(i3, i4);
                    } else if (obj instanceof String) {
                        zPutDouble = cursorWindow2.putString((String) obj, i3, i4);
                    } else if (obj instanceof Long) {
                        zPutDouble = cursorWindow2.putLong(((Long) obj).longValue(), i3, i4);
                    } else if (obj instanceof Integer) {
                        zPutDouble = cursorWindow2.putLong(((Integer) obj).intValue(), i3, i4);
                    } else if (obj instanceof Boolean) {
                        zPutDouble = cursorWindow2.putLong(((Boolean) obj).booleanValue() ? 1L : 0L, i3, i4);
                    } else if (obj instanceof byte[]) {
                        zPutDouble = cursorWindow2.putBlob((byte[]) obj, i3, i4);
                    } else if (obj instanceof Double) {
                        zPutDouble = cursorWindow2.putDouble(((Double) obj).doubleValue(), i3, i4);
                    } else {
                        if (!(obj instanceof Float)) {
                            String strValueOf = String.valueOf(obj);
                            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(strValueOf).length()).append("Unsupported object for column ").append(str).append(": ").append(strValueOf).toString());
                        }
                        zPutDouble = cursorWindow2.putDouble(((Float) obj).floatValue(), i3, i4);
                    }
                }
                if (zPutDouble) {
                    i2 = i3;
                    z = false;
                    cursorWindow = cursorWindow2;
                } else {
                    if (z2) {
                        throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                    }
                    Log.d("DataHolder", new StringBuilder(74).append("Couldn't populate window data for row ").append(i3).append(" - allocating new window.").toString());
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(zzaVar.f188vO.length);
                    arrayList.add(cursorWindow3);
                    i2 = i3 - 1;
                    cursorWindow = cursorWindow3;
                    z = true;
                }
                z2 = z;
                cursorWindow2 = cursorWindow;
                i3 = i2 + 1;
            } catch (RuntimeException e) {
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((CursorWindow) arrayList.get(i5)).close();
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zza zzb(String[] strArr) {
        return new zza(strArr, null);
    }

    public static DataHolder zzfp(int i) {
        return zza(i, (Bundle) null);
    }

    private void zzh(String str, int i) {
        if (this.f181vP == null || !this.f181vP.containsKey(str)) {
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "No such column: ".concat(strValueOf) : new String("No such column: "));
        }
        if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= this.f185vT) {
            throw new CursorIndexOutOfBoundsException(i, this.f185vT);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (int i = 0; i < this.f182vQ.length; i++) {
                    this.f182vQ[i].close();
                }
            }
        }
    }

    protected void finalize() throws Throwable {
        String string;
        try {
            if (this.f187vV && this.f182vQ.length > 0 && !isClosed()) {
                if (this.f186vU == null) {
                    String strValueOf = String.valueOf(toString());
                    string = strValueOf.length() != 0 ? "internal object: ".concat(strValueOf) : new String("internal object: ");
                } else {
                    string = this.f186vU.toString();
                }
                Log.e("DataBuffer", new StringBuilder(String.valueOf(string).length() + 161).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (").append(string).append(")").toString());
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public int getCount() {
        return this.f185vT;
    }

    public int getStatusCode() {
        return this.f179ob;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzh(str, i);
        this.f182vQ[i2].copyStringToBuffer(i, this.f181vP.getInt(str), charArrayBuffer);
    }

    public Bundle zzaqy() {
        return this.f183vR;
    }

    public void zzard() {
        this.f181vP = new Bundle();
        for (int i = 0; i < this.f180vO.length; i++) {
            this.f181vP.putInt(this.f180vO[i], i);
        }
        this.f184vS = new int[this.f182vQ.length];
        int numRows = 0;
        for (int i2 = 0; i2 < this.f182vQ.length; i2++) {
            this.f184vS[i2] = numRows;
            numRows += this.f182vQ[i2].getNumRows() - (numRows - this.f182vQ[i2].getStartPosition());
        }
        this.f185vT = numRows;
    }

    String[] zzare() {
        return this.f180vO;
    }

    CursorWindow[] zzarf() {
        return this.f182vQ;
    }

    public long zzb(String str, int i, int i2) {
        zzh(str, i);
        return this.f182vQ[i2].getLong(i, this.f181vP.getInt(str));
    }

    public int zzc(String str, int i, int i2) {
        zzh(str, i);
        return this.f182vQ[i2].getInt(i, this.f181vP.getInt(str));
    }

    public String zzd(String str, int i, int i2) {
        zzh(str, i);
        return this.f182vQ[i2].getString(i, this.f181vP.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        zzh(str, i);
        return Long.valueOf(this.f182vQ[i2].getLong(i, this.f181vP.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        zzh(str, i);
        return this.f182vQ[i2].getFloat(i, this.f181vP.getInt(str));
    }

    public int zzfo(int i) {
        int i2 = 0;
        zzab.zzbm(i >= 0 && i < this.f185vT);
        while (i2 < this.f184vS.length) {
            if (i < this.f184vS[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.f184vS.length ? i2 - 1 : i2;
    }

    public byte[] zzg(String str, int i, int i2) {
        zzh(str, i);
        return this.f182vQ[i2].getBlob(i, this.f181vP.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String strZzd = zzd(str, i, i2);
        if (strZzd == null) {
            return null;
        }
        return Uri.parse(strZzd);
    }

    public boolean zzhf(String str) {
        return this.f181vP.containsKey(str);
    }

    public boolean zzi(String str, int i, int i2) {
        zzh(str, i);
        return this.f182vQ[i2].isNull(i, this.f181vP.getInt(str));
    }

    public void zzv(Object obj) {
        this.f186vU = obj;
    }
}
