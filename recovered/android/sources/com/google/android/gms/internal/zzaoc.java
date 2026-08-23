package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzaoc implements zzanl {
    private final zzans beb;

    private static final class zza<E> extends zzank<Collection<E>> {
        private final zzank<E> bfH;
        private final zzanx<? extends Collection<E>> bfI;

        public zza(zzams zzamsVar, Type type, zzank<E> zzankVar, zzanx<? extends Collection<E>> zzanxVar) {
            this.bfH = new zzaom(zzamsVar, zzankVar, type);
            this.bfI = zzanxVar;
        }

        @Override // com.google.android.gms.internal.zzank
        public void zza(zzaor zzaorVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                zzaorVar.mo32r();
                return;
            }
            zzaorVar.mo28n();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.bfH.zza(zzaorVar, it.next());
            }
            zzaorVar.mo29o();
        }

        @Override // com.google.android.gms.internal.zzank
        /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
        public Collection<E> zzb(zzaop zzaopVar) throws IOException {
            if (zzaopVar.mo24h() == zzaoq.NULL) {
                zzaopVar.nextNull();
                return null;
            }
            Collection<E> collectionMo15a = this.bfI.mo15a();
            zzaopVar.beginArray();
            while (zzaopVar.hasNext()) {
                collectionMo15a.add(this.bfH.zzb(zzaopVar));
            }
            zzaopVar.endArray();
            return collectionMo15a;
        }
    }

    public zzaoc(zzans zzansVar) {
        this.beb = zzansVar;
    }

    @Override // com.google.android.gms.internal.zzanl
    public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
        Type typeM34t = zzaooVar.m34t();
        Class<? super T> clsM33s = zzaooVar.m33s();
        if (!Collection.class.isAssignableFrom(clsM33s)) {
            return null;
        }
        Type typeZza = zzanr.zza(typeM34t, (Class<?>) clsM33s);
        return new zza(zzamsVar, typeZza, zzamsVar.zza(zzaoo.zzl(typeZza)), this.beb.zzb(zzaooVar));
    }
}
