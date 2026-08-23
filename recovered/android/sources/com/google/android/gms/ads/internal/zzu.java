package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzfg;
import com.google.android.gms.internal.zzfo;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzln;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzu {
    private static final Object zzamp = new Object();
    private static zzu zzanr;
    private final com.google.android.gms.ads.internal.request.zza zzans = new com.google.android.gms.ads.internal.request.zza();
    private final com.google.android.gms.ads.internal.overlay.zza zzant = new com.google.android.gms.ads.internal.overlay.zza();
    private final com.google.android.gms.ads.internal.overlay.zze zzanu = new com.google.android.gms.ads.internal.overlay.zze();
    private final zzig zzanv = new zzig();
    private final zzkl zzanw = new zzkl();
    private final zzln zzanx = new zzln();
    private final zzkm zzany = zzkm.zzay(Build.VERSION.SDK_INT);
    private final zzkb zzanz = new zzkb(this.zzanw);
    private final com.google.android.gms.common.util.zze zzaoa = new com.google.android.gms.common.util.zzh();
    private final zzdf zzaob = new zzdf();
    private final zzja zzaoc = new zzja();
    private final zzda zzaod = new zzda();
    private final zzcz zzaoe = new zzcz();
    private final zzdb zzaof = new zzdb();
    private final com.google.android.gms.ads.internal.purchase.zzi zzaog = new com.google.android.gms.ads.internal.purchase.zzi();
    private final zzfo zzaoh = new zzfo();
    private final zzks zzaoi = new zzks();
    private final com.google.android.gms.ads.internal.overlay.zzq zzaoj = new com.google.android.gms.ads.internal.overlay.zzq();
    private final com.google.android.gms.ads.internal.overlay.zzr zzaok = new com.google.android.gms.ads.internal.overlay.zzr();
    private final zzgj zzaol = new zzgj();
    private final zzkt zzaom = new zzkt();
    private final zzg zzaon = new zzg();
    private final zzp zzaoo = new zzp();
    private final zzfg zzaop = new zzfg();
    private final zzlg zzaoq = new zzlg();

    static {
        zza(new zzu());
    }

    protected zzu() {
    }

    protected static void zza(zzu zzuVar) {
        synchronized (zzamp) {
            zzanr = zzuVar;
        }
    }

    private static zzu zzfl() {
        zzu zzuVar;
        synchronized (zzamp) {
            zzuVar = zzanr;
        }
        return zzuVar;
    }

    public static com.google.android.gms.ads.internal.request.zza zzfm() {
        return zzfl().zzans;
    }

    public static com.google.android.gms.ads.internal.overlay.zza zzfn() {
        return zzfl().zzant;
    }

    public static com.google.android.gms.ads.internal.overlay.zze zzfo() {
        return zzfl().zzanu;
    }

    public static zzig zzfp() {
        return zzfl().zzanv;
    }

    public static zzkl zzfq() {
        return zzfl().zzanw;
    }

    public static zzln zzfr() {
        return zzfl().zzanx;
    }

    public static zzkm zzfs() {
        return zzfl().zzany;
    }

    public static zzkb zzft() {
        return zzfl().zzanz;
    }

    public static com.google.android.gms.common.util.zze zzfu() {
        return zzfl().zzaoa;
    }

    public static zzdf zzfv() {
        return zzfl().zzaob;
    }

    public static zzja zzfw() {
        return zzfl().zzaoc;
    }

    public static zzda zzfx() {
        return zzfl().zzaod;
    }

    public static zzcz zzfy() {
        return zzfl().zzaoe;
    }

    public static zzdb zzfz() {
        return zzfl().zzaof;
    }

    public static com.google.android.gms.ads.internal.purchase.zzi zzga() {
        return zzfl().zzaog;
    }

    public static zzfo zzgb() {
        return zzfl().zzaoh;
    }

    public static zzks zzgc() {
        return zzfl().zzaoi;
    }

    public static com.google.android.gms.ads.internal.overlay.zzq zzgd() {
        return zzfl().zzaoj;
    }

    public static com.google.android.gms.ads.internal.overlay.zzr zzge() {
        return zzfl().zzaok;
    }

    public static zzgj zzgf() {
        return zzfl().zzaol;
    }

    public static zzp zzgg() {
        return zzfl().zzaoo;
    }

    public static zzkt zzgh() {
        return zzfl().zzaom;
    }

    public static zzg zzgi() {
        return zzfl().zzaon;
    }

    public static zzfg zzgj() {
        return zzfl().zzaop;
    }

    public static zzlg zzgk() {
        return zzfl().zzaoq;
    }
}
