package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public final class zzaok extends zzank<Date> {
    public static final zzanl bfE = new zzanl() { // from class: com.google.android.gms.internal.zzaok.1
        @Override // com.google.android.gms.internal.zzanl
        public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
            if (zzaooVar.m33s() == Date.class) {
                return new zzaok();
            }
            return null;
        }
    };
    private final DateFormat bge = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.google.android.gms.internal.zzank
    public synchronized void zza(zzaor zzaorVar, Date date) throws IOException {
        zzaorVar.zztb(date == null ? null : this.bge.format((java.util.Date) date));
    }

    @Override // com.google.android.gms.internal.zzank
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public synchronized Date zzb(zzaop zzaopVar) throws IOException {
        Date date;
        if (zzaopVar.mo24h() == zzaoq.NULL) {
            zzaopVar.nextNull();
            date = null;
        } else {
            try {
                date = new Date(this.bge.parse(zzaopVar.nextString()).getTime());
            } catch (ParseException e) {
                throw new zzanh(e);
            }
        }
        return date;
    }
}
