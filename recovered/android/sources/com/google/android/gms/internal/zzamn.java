package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
final class zzamn implements zzamx<Date>, zzang<Date> {
    private final DateFormat bdO;
    private final DateFormat bdP;
    private final DateFormat bdQ;

    zzamn() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public zzamn(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    zzamn(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    zzamn(DateFormat dateFormat, DateFormat dateFormat2) {
        this.bdO = dateFormat;
        this.bdP = dateFormat2;
        this.bdQ = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.bdQ.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date zza(zzamy zzamyVar) {
        Date date;
        synchronized (this.bdP) {
            try {
                date = this.bdP.parse(zzamyVar.zzczh());
            } catch (ParseException e) {
                try {
                    date = this.bdO.parse(zzamyVar.zzczh());
                } catch (ParseException e2) {
                    try {
                        date = this.bdQ.parse(zzamyVar.zzczh());
                    } catch (ParseException e3) {
                        throw new zzanh(zzamyVar.zzczh(), e3);
                    }
                }
            }
        }
        return date;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(zzamn.class.getSimpleName());
        sb.append('(').append(this.bdP.getClass().getSimpleName()).append(')');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.zzang
    public zzamy zza(Date date, Type type, zzanf zzanfVar) {
        zzane zzaneVar;
        synchronized (this.bdP) {
            zzaneVar = new zzane(this.bdO.format(date));
        }
        return zzaneVar;
    }

    @Override // com.google.android.gms.internal.zzamx
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public Date zzb(zzamy zzamyVar, Type type, zzamw zzamwVar) throws zzanc {
        if (!(zzamyVar instanceof zzane)) {
            throw new zzanc("The date should be a string value");
        }
        Date dateZza = zza(zzamyVar);
        if (type == Date.class) {
            return dateZza;
        }
        if (type == Timestamp.class) {
            return new Timestamp(dateZza.getTime());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(dateZza.getTime());
        }
        String strValueOf = String.valueOf(getClass());
        String strValueOf2 = String.valueOf(type);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf).length() + 23 + String.valueOf(strValueOf2).length()).append(strValueOf).append(" cannot deserialize to ").append(strValueOf2).toString());
    }
}
