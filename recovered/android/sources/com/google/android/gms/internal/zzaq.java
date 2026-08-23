package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzaq extends zzao {
    private static Method zzafo;
    protected boolean zzafn;
    protected String zzafp;
    protected boolean zzafr;
    protected boolean zzafs;
    private static final String TAG = zzaq.class.getSimpleName();
    private static long startTime = 0;
    static boolean zzafq = false;
    protected static volatile zzax zzaey = null;
    protected static final Object zzaft = new Object();

    protected zzaq(Context context, String str) {
        super(context);
        this.zzafn = false;
        this.zzafr = false;
        this.zzafs = false;
        this.zzafp = str;
        this.zzafn = false;
    }

    protected zzaq(Context context, String str, boolean z) {
        super(context);
        this.zzafn = false;
        this.zzafr = false;
        this.zzafs = false;
        this.zzafp = str;
        this.zzafn = z;
    }

    static List<Long> zza(zzax zzaxVar, MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zzaw {
        zzafo = zzaxVar.zzc(zzav.zzcc(), zzav.zzcd());
        if (zzafo == null || motionEvent == null) {
            throw new zzaw();
        }
        try {
            return (ArrayList) zzafo.invoke(null, motionEvent, displayMetrics);
        } catch (IllegalAccessException e) {
            throw new zzaw(e);
        } catch (InvocationTargetException e2) {
            throw new zzaw(e2);
        }
    }

    protected static synchronized void zza(Context context, boolean z) {
        if (!zzafq) {
            startTime = Calendar.getInstance().getTime().getTime() / 1000;
            zzaey = zzb(context, z);
            zzafq = true;
        }
    }

    private static void zza(zzax zzaxVar) {
        List<Class> listSingletonList = Collections.singletonList(Context.class);
        zzaxVar.zza(zzav.zzbo(), zzav.zzbp(), listSingletonList);
        zzaxVar.zza(zzav.zzbm(), zzav.zzbn(), listSingletonList);
        zzaxVar.zza(zzav.zzby(), zzav.zzbz(), listSingletonList);
        zzaxVar.zza(zzav.zzbw(), zzav.zzbx(), listSingletonList);
        zzaxVar.zza(zzav.zzbg(), zzav.zzbh(), listSingletonList);
        zzaxVar.zza(zzav.zzbe(), zzav.zzbf(), listSingletonList);
        zzaxVar.zza(zzav.zzbc(), zzav.zzbd(), listSingletonList);
        zzaxVar.zza(zzav.zzbs(), zzav.zzbt(), listSingletonList);
        zzaxVar.zza(zzav.zzba(), zzav.zzbb(), listSingletonList);
        zzaxVar.zza(zzav.zzcc(), zzav.zzcd(), Arrays.asList(MotionEvent.class, DisplayMetrics.class));
        zzaxVar.zza(zzav.zzbk(), zzav.zzbl(), Collections.emptyList());
        zzaxVar.zza(zzav.zzca(), zzav.zzcb(), Collections.emptyList());
        zzaxVar.zza(zzav.zzbu(), zzav.zzbv(), Collections.emptyList());
        zzaxVar.zza(zzav.zzbi(), zzav.zzbj(), Collections.emptyList());
        zzaxVar.zza(zzav.zzbq(), zzav.zzbr(), Collections.emptyList());
    }

    protected static zzax zzb(Context context, boolean z) {
        if (zzaey == null) {
            synchronized (zzaft) {
                if (zzaey == null) {
                    zzax zzaxVarZza = zzax.zza(context, zzav.getKey(), zzav.zzaz(), z);
                    zza(zzaxVarZza);
                    zzaey = zzaxVarZza;
                }
            }
        }
        return zzaey;
    }

    protected void zza(zzax zzaxVar, zzae.zza zzaVar) {
        if (zzaxVar.zzce() == null) {
            return;
        }
        zza(zzb(zzaxVar, zzaVar));
    }

    protected void zza(List<Callable<Void>> list) {
        ExecutorService executorServiceZzce;
        if (zzaey == null || (executorServiceZzce = zzaey.zzce()) == null || list.isEmpty()) {
            return;
        }
        try {
            executorServiceZzce.invokeAll(list, zzdc.zzbbh.get().longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Log.d(TAG, String.format("class methods got exception: %s", zzay.zza(e)));
        }
    }

    protected List<Callable<Void>> zzb(zzax zzaxVar, zzae.zza zzaVar) {
        int iZzau = zzaxVar.zzau();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzbb(zzaxVar, zzav.zzbo(), zzav.zzbp(), zzaVar, iZzau, 27));
        arrayList.add(new zzbg(zzaxVar, zzav.zzbk(), zzav.zzbl(), zzaVar, startTime, iZzau, 25));
        arrayList.add(new zzbl(zzaxVar, zzav.zzbu(), zzav.zzbv(), zzaVar, iZzau, 1));
        arrayList.add(new zzbm(zzaxVar, zzav.zzbw(), zzav.zzbx(), zzaVar, iZzau, 31));
        arrayList.add(new zzbn(zzaxVar, zzav.zzca(), zzav.zzcb(), zzaVar, iZzau, 33));
        arrayList.add(new zzba(zzaxVar, zzav.zzby(), zzav.zzbz(), zzaVar, iZzau, 29));
        arrayList.add(new zzbe(zzaxVar, zzav.zzbg(), zzav.zzbh(), zzaVar, iZzau, 5));
        arrayList.add(new zzbk(zzaxVar, zzav.zzbs(), zzav.zzbt(), zzaVar, iZzau, 12));
        arrayList.add(new zzaz(zzaxVar, zzav.zzba(), zzav.zzbb(), zzaVar, iZzau, 3));
        arrayList.add(new zzbd(zzaxVar, zzav.zzbe(), zzav.zzbf(), zzaVar, iZzau, 34));
        arrayList.add(new zzbc(zzaxVar, zzav.zzbc(), zzav.zzbd(), zzaVar, iZzau, 35));
        if (zzdc.zzbbl.get().booleanValue()) {
            arrayList.add(new zzbf(zzaxVar, zzav.zzbi(), zzav.zzbj(), zzaVar, iZzau, 44));
        }
        if (zzdc.zzbbo.get().booleanValue()) {
            arrayList.add(new zzbj(zzaxVar, zzav.zzbq(), zzav.zzbr(), zzaVar, iZzau, 22));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.zzao
    protected zzae.zza zzc(Context context) {
        zzae.zza zzaVar = new zzae.zza();
        if (!TextUtils.isEmpty(this.zzafp)) {
            zzaVar.zzcs = this.zzafp;
        }
        zzax zzaxVarZzb = zzb(context, this.zzafn);
        zzaxVarZzb.zzct();
        zza(zzaxVarZzb, zzaVar);
        zzaxVarZzb.zzcu();
        return zzaVar;
    }

    protected List<Callable<Void>> zzc(zzax zzaxVar, zzae.zza zzaVar) {
        ArrayList arrayList = new ArrayList();
        if (zzaxVar.zzce() == null) {
            return arrayList;
        }
        int iZzau = zzaxVar.zzau();
        arrayList.add(new zzbi(zzaxVar, zzaVar));
        arrayList.add(new zzbl(zzaxVar, zzav.zzbu(), zzav.zzbv(), zzaVar, iZzau, 1));
        arrayList.add(new zzbg(zzaxVar, zzav.zzbk(), zzav.zzbl(), zzaVar, startTime, iZzau, 25));
        if (zzdc.zzbbm.get().booleanValue()) {
            arrayList.add(new zzbf(zzaxVar, zzav.zzbi(), zzav.zzbj(), zzaVar, iZzau, 44));
        }
        arrayList.add(new zzaz(zzaxVar, zzav.zzba(), zzav.zzbb(), zzaVar, iZzau, 3));
        if (zzdc.zzbbp.get().booleanValue()) {
            arrayList.add(new zzbj(zzaxVar, zzav.zzbq(), zzav.zzbr(), zzaVar, iZzau, 22));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.zzao
    protected zzae.zza zzd(Context context) {
        zzae.zza zzaVar = new zzae.zza();
        if (!TextUtils.isEmpty(this.zzafp)) {
            zzaVar.zzcs = this.zzafp;
        }
        zzax zzaxVarZzb = zzb(context, this.zzafn);
        zzaxVarZzb.zzct();
        zzd(zzaxVarZzb, zzaVar);
        zzaxVarZzb.zzcu();
        return zzaVar;
    }

    protected void zzd(zzax zzaxVar, zzae.zza zzaVar) {
        try {
            List<Long> listZza = zza(zzaxVar, this.zzafd, this.zzafl);
            zzaVar.zzdf = listZza.get(0);
            zzaVar.zzdg = listZza.get(1);
            if (listZza.get(2).longValue() >= 0) {
                zzaVar.zzdh = listZza.get(2);
            }
            zzaVar.zzdv = listZza.get(3);
            zzaVar.zzdw = listZza.get(4);
        } catch (zzaw e) {
        }
        if (this.zzaff > 0) {
            zzaVar.zzea = Long.valueOf(this.zzaff);
        }
        if (this.zzafg > 0) {
            zzaVar.zzdz = Long.valueOf(this.zzafg);
        }
        if (this.zzafh > 0) {
            zzaVar.zzdy = Long.valueOf(this.zzafh);
        }
        if (this.zzafi > 0) {
            zzaVar.zzeb = Long.valueOf(this.zzafi);
        }
        if (this.zzafj > 0) {
            zzaVar.zzed = Long.valueOf(this.zzafj);
        }
        try {
            int size = this.zzafe.size() - 1;
            if (size > 0) {
                zzaVar.zzee = new zzae.zza.C0761zza[size];
                for (int i = 0; i < size; i++) {
                    List<Long> listZza2 = zza(zzaxVar, this.zzafe.get(i), this.zzafl);
                    zzae.zza.C0761zza c0761zza = new zzae.zza.C0761zza();
                    c0761zza.zzdf = listZza2.get(0);
                    c0761zza.zzdg = listZza2.get(1);
                    zzaVar.zzee[i] = c0761zza;
                }
            }
        } catch (zzaw e2) {
            zzaVar.zzee = null;
        }
        zza(zzc(zzaxVar, zzaVar));
    }
}
