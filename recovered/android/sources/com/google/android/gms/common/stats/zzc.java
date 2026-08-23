package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzre;

/* JADX INFO: loaded from: classes.dex */
public final class zzc {

    /* JADX INFO: renamed from: Af */
    public static zzre<Integer> f436Af = zzre.zza("gms:common:stats:max_num_of_events", (Integer) 100);

    /* JADX INFO: renamed from: Ag */
    public static zzre<Integer> f437Ag = zzre.zza("gms:common:stats:max_chunk_size", (Integer) 100);

    public static final class zza {

        /* JADX INFO: renamed from: Ah */
        public static zzre<Integer> f438Ah = zzre.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));

        /* JADX INFO: renamed from: Ai */
        public static zzre<String> f439Ai = zzre.zzab("gms:common:stats:connections:ignored_calling_processes", "");

        /* JADX INFO: renamed from: Aj */
        public static zzre<String> f440Aj = zzre.zzab("gms:common:stats:connections:ignored_calling_services", "");

        /* JADX INFO: renamed from: Ak */
        public static zzre<String> f441Ak = zzre.zzab("gms:common:stats:connections:ignored_target_processes", "");

        /* JADX INFO: renamed from: Al */
        public static zzre<String> f442Al = zzre.zzab("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");

        /* JADX INFO: renamed from: Am */
        public static zzre<Long> f443Am = zzre.zza("gms:common:stats:connections:time_out_duration", (Long) 600000L);
    }

    public static final class zzb {

        /* JADX INFO: renamed from: Ah */
        public static zzre<Integer> f444Ah = zzre.zza("gms:common:stats:wakeLocks:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));

        /* JADX INFO: renamed from: Am */
        public static zzre<Long> f445Am = zzre.zza("gms:common:stats:wakelocks:time_out_duration", (Long) 600000L);
    }
}
