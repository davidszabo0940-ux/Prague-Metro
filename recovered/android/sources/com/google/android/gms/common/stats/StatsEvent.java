package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class StatsEvent extends AbstractSafeParcelable {
    public abstract int getEventType();

    public abstract long getTimeMillis();

    public String toString() {
        long timeMillis = getTimeMillis();
        String strValueOf = String.valueOf("\t");
        int eventType = getEventType();
        String strValueOf2 = String.valueOf("\t");
        long jZzaup = zzaup();
        String strValueOf3 = String.valueOf(zzaus());
        return new StringBuilder(String.valueOf(strValueOf).length() + 51 + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length()).append(timeMillis).append(strValueOf).append(eventType).append(strValueOf2).append(jZzaup).append(strValueOf3).toString();
    }

    public abstract long zzaup();

    public abstract String zzaus();
}
