package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class FastJsonResponse {

    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final com.google.android.gms.common.server.response.zza CREATOR = new com.google.android.gms.common.server.response.zza();
        private final int mVersionCode;

        /* JADX INFO: renamed from: zA */
        protected final String f383zA;

        /* JADX INFO: renamed from: zB */
        private FieldMappingDictionary f384zB;

        /* JADX INFO: renamed from: zC */
        private zza<I, O> f385zC;

        /* JADX INFO: renamed from: zt */
        protected final int f386zt;

        /* JADX INFO: renamed from: zu */
        protected final boolean f387zu;

        /* JADX INFO: renamed from: zv */
        protected final int f388zv;

        /* JADX INFO: renamed from: zw */
        protected final boolean f389zw;

        /* JADX INFO: renamed from: zx */
        protected final String f390zx;

        /* JADX INFO: renamed from: zy */
        protected final int f391zy;

        /* JADX INFO: renamed from: zz */
        protected final Class<? extends FastJsonResponse> f392zz;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.mVersionCode = i;
            this.f386zt = i2;
            this.f387zu = z;
            this.f388zv = i3;
            this.f389zw = z2;
            this.f390zx = str;
            this.f391zy = i4;
            if (str2 == null) {
                this.f392zz = null;
                this.f383zA = null;
            } else {
                this.f392zz = SafeParcelResponse.class;
                this.f383zA = str2;
            }
            if (converterWrapper == null) {
                this.f385zC = null;
            } else {
                this.f385zC = (zza<I, O>) converterWrapper.zzatn();
            }
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, zza<I, O> zzaVar) {
            this.mVersionCode = 1;
            this.f386zt = i;
            this.f387zu = z;
            this.f388zv = i2;
            this.f389zw = z2;
            this.f390zx = str;
            this.f391zy = i3;
            this.f392zz = cls;
            if (cls == null) {
                this.f383zA = null;
            } else {
                this.f383zA = cls.getCanonicalName();
            }
            this.f385zC = zzaVar;
        }

        public static Field zza(String str, int i, zza<?, ?> zzaVar, boolean z) {
            return new Field(zzaVar.zzatp(), z, zzaVar.zzatq(), false, str, i, null, zzaVar);
        }

        public static <T extends FastJsonResponse> Field<T, T> zza(String str, int i, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i, cls, null);
        }

        public static Field<Integer, Integer> zzj(String str, int i) {
            return new Field<>(0, false, 0, false, str, i, null, null);
        }

        public static Field<Boolean, Boolean> zzk(String str, int i) {
            return new Field<>(6, false, 6, false, str, i, null, null);
        }

        public static Field<String, String> zzl(String str, int i) {
            return new Field<>(7, false, 7, false, str, i, null, null);
        }

        public I convertBack(O o) {
            return this.f385zC.convertBack(o);
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=").append(this.mVersionCode).append('\n');
            sb.append("                 typeIn=").append(this.f386zt).append('\n');
            sb.append("            typeInArray=").append(this.f387zu).append('\n');
            sb.append("                typeOut=").append(this.f388zv).append('\n');
            sb.append("           typeOutArray=").append(this.f389zw).append('\n');
            sb.append("        outputFieldName=").append(this.f390zx).append('\n');
            sb.append("      safeParcelFieldId=").append(this.f391zy).append('\n');
            sb.append("       concreteTypeName=").append(zzatz()).append('\n');
            if (zzaty() != null) {
                sb.append("     concreteType.class=").append(zzaty().getCanonicalName()).append('\n');
            }
            sb.append("          converterName=").append(this.f385zC == null ? "null" : this.f385zC.getClass().getCanonicalName()).append('\n');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            com.google.android.gms.common.server.response.zza zzaVar = CREATOR;
            com.google.android.gms.common.server.response.zza.zza(this, parcel, i);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            this.f384zB = fieldMappingDictionary;
        }

        public int zzatp() {
            return this.f386zt;
        }

        public int zzatq() {
            return this.f388zv;
        }

        public boolean zzatu() {
            return this.f387zu;
        }

        public boolean zzatv() {
            return this.f389zw;
        }

        public String zzatw() {
            return this.f390zx;
        }

        public int zzatx() {
            return this.f391zy;
        }

        public Class<? extends FastJsonResponse> zzaty() {
            return this.f392zz;
        }

        String zzatz() {
            if (this.f383zA == null) {
                return null;
            }
            return this.f383zA;
        }

        public boolean zzaua() {
            return this.f385zC != null;
        }

        ConverterWrapper zzaub() {
            if (this.f385zC == null) {
                return null;
            }
            return ConverterWrapper.zza(this.f385zC);
        }

        public Map<String, Field<?, ?>> zzauc() {
            zzab.zzaa(this.f383zA);
            zzab.zzaa(this.f384zB);
            return this.f384zB.zzhx(this.f383zA);
        }
    }

    public interface zza<I, O> {
        I convertBack(O o);

        int zzatp();

        int zzatq();
    }

    private void zza(StringBuilder sb, Field field, Object obj) {
        if (field.zzatp() == 11) {
            sb.append(field.zzaty().cast(obj).toString());
        } else {
            if (field.zzatp() != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(zzp.zzib((String) obj));
            sb.append("\"");
        }
    }

    private void zza(StringBuilder sb, Field field, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(sb, field, obj);
            }
        }
        sb.append("]");
    }

    public String toString() {
        Map<String, Field<?, ?>> mapZzatr = zzatr();
        StringBuilder sb = new StringBuilder(100);
        for (String str : mapZzatr.keySet()) {
            Field<?, ?> field = mapZzatr.get(str);
            if (zza(field)) {
                Object objZza = zza(field, zzb(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(str).append("\":");
                if (objZza != null) {
                    switch (field.zzatq()) {
                        case 8:
                            sb.append("\"").append(com.google.android.gms.common.util.zzc.zzp((byte[]) objZza)).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(com.google.android.gms.common.util.zzc.zzq((byte[]) objZza)).append("\"");
                            break;
                        case 10:
                            zzq.zza(sb, (HashMap) objZza);
                            break;
                        default:
                            if (field.zzatu()) {
                                zza(sb, (Field) field, (ArrayList<Object>) objZza);
                            } else {
                                zza(sb, field, objZza);
                            }
                            break;
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <O, I> I zza(Field<I, O> field, Object obj) {
        return ((Field) field).f385zC != null ? field.convertBack(obj) : obj;
    }

    protected boolean zza(Field field) {
        if (field.zzatq() == 11) {
            return field.zzatv() ? zzhw(field.zzatw()) : zzhv(field.zzatw());
        }
        return zzhu(field.zzatw());
    }

    public abstract Map<String, Field<?, ?>> zzatr();

    public HashMap<String, Object> zzats() {
        return null;
    }

    public HashMap<String, Object> zzatt() {
        return null;
    }

    protected Object zzb(Field field) {
        String strZzatw = field.zzatw();
        if (field.zzaty() == null) {
            return zzht(field.zzatw());
        }
        zzab.zza(zzht(field.zzatw()) == null, "Concrete field shouldn't be value object: %s", field.zzatw());
        HashMap<String, Object> mapZzatt = field.zzatv() ? zzatt() : zzats();
        if (mapZzatt != null) {
            return mapZzatt.get(strZzatw);
        }
        try {
            char upperCase = Character.toUpperCase(strZzatw.charAt(0));
            String strValueOf = String.valueOf(strZzatw.substring(1));
            return getClass().getMethod(new StringBuilder(String.valueOf(strValueOf).length() + 4).append("get").append(upperCase).append(strValueOf).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Object zzht(String str);

    protected abstract boolean zzhu(String str);

    protected boolean zzhv(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean zzhw(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }
}
