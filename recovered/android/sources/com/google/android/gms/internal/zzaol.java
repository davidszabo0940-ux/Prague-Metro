package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class zzaol extends zzank<Time> {
    public static final zzanl bfE = new zzanl() { // from class: com.google.android.gms.internal.zzaol.1
        @Override // com.google.android.gms.internal.zzanl
        public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
            if (zzaooVar.m33s() == Time.class) {
                return new zzaol();
            }
            return null;
        }
    };
    private final DateFormat bge = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.google.android.gms.internal.zzank
    public synchronized void zza(zzaor zzaorVar, Time time) throws IOException {
        zzaorVar.zztb(time == null ? null : this.bge.format((Date) time));
    }

    @Override // com.google.android.gms.internal.zzank
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public synchronized Time zzb(zzaop zzaopVar) throws IOException {
        Time time;
        if (zzaopVar.mo24h() == zzaoq.NULL) {
            zzaopVar.nextNull();
            time = null;
        } else {
            try {
                time = new Time(this.bge.parse(zzaopVar.nextString()).getTime());
            } catch (ParseException e) {
                throw new zzanh(e);
            }
        }
        return time;
    }
}
