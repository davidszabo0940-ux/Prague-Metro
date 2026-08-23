package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzlb {

    public interface zza<D, R> {
        R zzh(D d);
    }

    public static <A, B> zzlc<B> zza(final zzlc<A> zzlcVar, final zza<A, B> zzaVar) {
        final zzkz zzkzVar = new zzkz();
        zzlcVar.zzb(new Runnable() { // from class: com.google.android.gms.internal.zzlb.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zzkzVar.zzi(zzaVar.zzh(zzlcVar.get()));
                } catch (InterruptedException | CancellationException | ExecutionException e) {
                    zzkzVar.cancel(true);
                }
            }
        });
        return zzkzVar;
    }

    public static <V> zzlc<List<V>> zzn(final List<zzlc<V>> list) {
        final zzkz zzkzVar = new zzkz();
        final int size = list.size();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<zzlc<V>> it = list.iterator();
        while (it.hasNext()) {
            it.next().zzb(new Runnable() { // from class: com.google.android.gms.internal.zzlb.2
                @Override // java.lang.Runnable
                public void run() {
                    if (atomicInteger.incrementAndGet() >= size) {
                        try {
                            zzkzVar.zzi(zzlb.zzo(list));
                        } catch (InterruptedException | ExecutionException e) {
                            zzkh.zzd("Unable to convert list of futures to a future of list", e);
                        }
                    }
                }
            });
        }
        return zzkzVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <V> List<V> zzo(List<zzlc<V>> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        Iterator<zzlc<V>> it = list.iterator();
        while (it.hasNext()) {
            V v = it.next().get();
            if (v != null) {
                arrayList.add(v);
            }
        }
        return arrayList;
    }
}
