package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzuh {

    /* JADX INFO: renamed from: Qr */
    private static zzuh f850Qr;

    /* JADX INFO: renamed from: Qs */
    private final zzue f851Qs = new zzue();

    /* JADX INFO: renamed from: Qt */
    private final zzuf f852Qt = new zzuf();

    static {
        zza(new zzuh());
    }

    private zzuh() {
    }

    protected static void zza(zzuh zzuhVar) {
        synchronized (zzuh.class) {
            f850Qr = zzuhVar;
        }
    }

    private static zzuh zzbfq() {
        zzuh zzuhVar;
        synchronized (zzuh.class) {
            zzuhVar = f850Qr;
        }
        return zzuhVar;
    }

    public static zzue zzbfr() {
        return zzbfq().f851Qs;
    }

    public static zzuf zzbfs() {
        return zzbfq().f852Qt;
    }
}
