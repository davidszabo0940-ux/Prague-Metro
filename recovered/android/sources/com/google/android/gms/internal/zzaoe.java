package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzaoe implements zzanl {
    private final zzans beb;

    public zzaoe(zzans zzansVar) {
        this.beb = zzansVar;
    }

    static zzank<?> zza(zzans zzansVar, zzams zzamsVar, zzaoo<?> zzaooVar, zzanm zzanmVar) {
        Class<?> clsValue = zzanmVar.value();
        if (zzank.class.isAssignableFrom(clsValue)) {
            return (zzank) zzansVar.zzb(zzaoo.zzr(clsValue)).mo15a();
        }
        if (zzanl.class.isAssignableFrom(clsValue)) {
            return ((zzanl) zzansVar.zzb(zzaoo.zzr(clsValue)).mo15a()).zza(zzamsVar, zzaooVar);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    @Override // com.google.android.gms.internal.zzanl
    public <T> zzank<T> zza(zzams zzamsVar, zzaoo<T> zzaooVar) {
        zzanm zzanmVar = (zzanm) zzaooVar.m33s().getAnnotation(zzanm.class);
        if (zzanmVar == null) {
            return null;
        }
        return (zzank<T>) zza(this.beb, zzamsVar, zzaooVar, zzanmVar);
    }
}
