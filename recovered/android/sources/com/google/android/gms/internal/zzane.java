package com.google.android.gms.internal;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzane extends zzamy {
    private static final Class<?>[] beu = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object aQx;

    public zzane(Boolean bool) {
        setValue(bool);
    }

    public zzane(Number number) {
        setValue(number);
    }

    public zzane(String str) {
        setValue(str);
    }

    private static boolean zza(zzane zzaneVar) {
        if (!(zzaneVar.aQx instanceof Number)) {
            return false;
        }
        Number number = (Number) zzaneVar.aQx;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static boolean zzck(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : beu) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzane zzaneVar = (zzane) obj;
        if (this.aQx == null) {
            return zzaneVar.aQx == null;
        }
        if (zza(this) && zza(zzaneVar)) {
            return zzczg().longValue() == zzaneVar.zzczg().longValue();
        }
        if (!(this.aQx instanceof Number) || !(zzaneVar.aQx instanceof Number)) {
            return this.aQx.equals(zzaneVar.aQx);
        }
        double dDoubleValue = zzczg().doubleValue();
        double dDoubleValue2 = zzaneVar.zzczg().doubleValue();
        if (dDoubleValue == dDoubleValue2 || (Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2))) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        if (this.aQx == null) {
            return 31;
        }
        if (zza(this)) {
            long jLongValue = zzczg().longValue();
            return (int) (jLongValue ^ (jLongValue >>> 32));
        }
        if (!(this.aQx instanceof Number)) {
            return this.aQx.hashCode();
        }
        long jDoubleToLongBits = Double.doubleToLongBits(zzczg().doubleValue());
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    void setValue(Object obj) {
        if (obj instanceof Character) {
            this.aQx = String.valueOf(((Character) obj).charValue());
        } else {
            zzanq.zzbn((obj instanceof Number) || zzck(obj));
            this.aQx = obj;
        }
    }

    @Override // com.google.android.gms.internal.zzamy
    public Number zzczg() {
        return this.aQx instanceof String ? new zzanv((String) this.aQx) : (Number) this.aQx;
    }

    @Override // com.google.android.gms.internal.zzamy
    public String zzczh() {
        if (zzczv()) {
            return zzczg().toString();
        }
        return zzczu() ? zzczt().toString() : (String) this.aQx;
    }

    @Override // com.google.android.gms.internal.zzamy
    public double zzczi() {
        return zzczv() ? zzczg().doubleValue() : Double.parseDouble(zzczh());
    }

    @Override // com.google.android.gms.internal.zzamy
    public long zzczj() {
        return zzczv() ? zzczg().longValue() : Long.parseLong(zzczh());
    }

    @Override // com.google.android.gms.internal.zzamy
    public int zzczk() {
        return zzczv() ? zzczg().intValue() : Integer.parseInt(zzczh());
    }

    @Override // com.google.android.gms.internal.zzamy
    public boolean zzczl() {
        return zzczu() ? zzczt().booleanValue() : Boolean.parseBoolean(zzczh());
    }

    @Override // com.google.android.gms.internal.zzamy
    Boolean zzczt() {
        return (Boolean) this.aQx;
    }

    public boolean zzczu() {
        return this.aQx instanceof Boolean;
    }

    public boolean zzczv() {
        return this.aQx instanceof Number;
    }

    public boolean zzczw() {
        return this.aQx instanceof String;
    }
}
