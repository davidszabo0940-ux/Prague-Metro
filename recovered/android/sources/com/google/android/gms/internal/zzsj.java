package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class zzsj {

    /* JADX INFO: renamed from: Me */
    private static zzsk f837Me;

    /* JADX INFO: renamed from: Mf */
    private static final zzb.zza f838Mf = new zzb.zza() { // from class: com.google.android.gms.internal.zzsj.1
        @Override // com.google.android.gms.internal.zzsj.zzb.zza
        public int zzd(Context context, String str, boolean z) {
            return zzsj.zzd(context, str, z);
        }

        @Override // com.google.android.gms.internal.zzsj.zzb.zza
        public int zzt(Context context, String str) {
            return zzsj.zzt(context, str);
        }
    };

    /* JADX INFO: renamed from: Mg */
    public static final zzb f839Mg = new zzb() { // from class: com.google.android.gms.internal.zzsj.2
        @Override // com.google.android.gms.internal.zzsj.zzb
        public zzb.C0801zzb zza(Context context, String str, zzb.zza zzaVar) {
            zzb.C0801zzb c0801zzb = new zzb.C0801zzb();
            c0801zzb.f847Mo = zzaVar.zzd(context, str, true);
            if (c0801zzb.f847Mo != 0) {
                c0801zzb.f848Mp = 1;
            } else {
                c0801zzb.f846Mn = zzaVar.zzt(context, str);
                if (c0801zzb.f846Mn != 0) {
                    c0801zzb.f848Mp = -1;
                }
            }
            return c0801zzb;
        }
    };

    /* JADX INFO: renamed from: Mh */
    public static final zzb f840Mh = new zzb() { // from class: com.google.android.gms.internal.zzsj.3
        @Override // com.google.android.gms.internal.zzsj.zzb
        public zzb.C0801zzb zza(Context context, String str, zzb.zza zzaVar) {
            zzb.C0801zzb c0801zzb = new zzb.C0801zzb();
            c0801zzb.f846Mn = zzaVar.zzt(context, str);
            if (c0801zzb.f846Mn != 0) {
                c0801zzb.f848Mp = -1;
            } else {
                c0801zzb.f847Mo = zzaVar.zzd(context, str, true);
                if (c0801zzb.f847Mo != 0) {
                    c0801zzb.f848Mp = 1;
                }
            }
            return c0801zzb;
        }
    };

    /* JADX INFO: renamed from: Mi */
    public static final zzb f841Mi = new zzb() { // from class: com.google.android.gms.internal.zzsj.4
        @Override // com.google.android.gms.internal.zzsj.zzb
        public zzb.C0801zzb zza(Context context, String str, zzb.zza zzaVar) {
            zzb.C0801zzb c0801zzb = new zzb.C0801zzb();
            c0801zzb.f846Mn = zzaVar.zzt(context, str);
            c0801zzb.f847Mo = zzaVar.zzd(context, str, true);
            if (c0801zzb.f846Mn == 0 && c0801zzb.f847Mo == 0) {
                c0801zzb.f848Mp = 0;
            } else if (c0801zzb.f846Mn >= c0801zzb.f847Mo) {
                c0801zzb.f848Mp = -1;
            } else {
                c0801zzb.f848Mp = 1;
            }
            return c0801zzb;
        }
    };

    /* JADX INFO: renamed from: Mj */
    public static final zzb f842Mj = new zzb() { // from class: com.google.android.gms.internal.zzsj.5
        @Override // com.google.android.gms.internal.zzsj.zzb
        public zzb.C0801zzb zza(Context context, String str, zzb.zza zzaVar) {
            zzb.C0801zzb c0801zzb = new zzb.C0801zzb();
            c0801zzb.f846Mn = zzaVar.zzt(context, str);
            c0801zzb.f847Mo = zzaVar.zzd(context, str, true);
            if (c0801zzb.f846Mn == 0 && c0801zzb.f847Mo == 0) {
                c0801zzb.f848Mp = 0;
            } else if (c0801zzb.f847Mo >= c0801zzb.f846Mn) {
                c0801zzb.f848Mp = 1;
            } else {
                c0801zzb.f848Mp = -1;
            }
            return c0801zzb;
        }
    };

    /* JADX INFO: renamed from: Mk */
    public static final zzb f843Mk = new zzb() { // from class: com.google.android.gms.internal.zzsj.6
        @Override // com.google.android.gms.internal.zzsj.zzb
        public zzb.C0801zzb zza(Context context, String str, zzb.zza zzaVar) {
            zzb.C0801zzb c0801zzb = new zzb.C0801zzb();
            c0801zzb.f846Mn = zzaVar.zzt(context, str);
            if (c0801zzb.f846Mn != 0) {
                c0801zzb.f847Mo = zzaVar.zzd(context, str, false);
            } else {
                c0801zzb.f847Mo = zzaVar.zzd(context, str, true);
            }
            if (c0801zzb.f846Mn == 0 && c0801zzb.f847Mo == 0) {
                c0801zzb.f848Mp = 0;
            } else if (c0801zzb.f847Mo >= c0801zzb.f846Mn) {
                c0801zzb.f848Mp = 1;
            } else {
                c0801zzb.f848Mp = -1;
            }
            return c0801zzb;
        }
    };

    /* JADX INFO: renamed from: Ml */
    private final Context f844Ml;

    public static class zza extends Exception {
        private zza(String str) {
            super(str);
        }

        private zza(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface zzb {

        public interface zza {
            int zzd(Context context, String str, boolean z);

            int zzt(Context context, String str);
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzsj$zzb$zzb, reason: collision with other inner class name */
        public static class C0801zzb {

            /* JADX INFO: renamed from: Mn */
            public int f846Mn = 0;

            /* JADX INFO: renamed from: Mo */
            public int f847Mo = 0;

            /* JADX INFO: renamed from: Mp */
            public int f848Mp = 0;
        }

        C0801zzb zza(Context context, String str, zza zzaVar);
    }

    private zzsj(Context context) {
        this.f844Ml = (Context) com.google.android.gms.common.internal.zzab.zzaa(context);
    }

    public static zzsj zza(Context context, zzb zzbVar, String str) throws zza {
        zzb.C0801zzb c0801zzbZza = zzbVar.zza(context, str, f838Mf);
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(c0801zzbZza.f846Mn).append(" and remote module ").append(str).append(":").append(c0801zzbZza.f847Mo).toString());
        if (c0801zzbZza.f848Mp == 0 || ((c0801zzbZza.f848Mp == -1 && c0801zzbZza.f846Mn == 0) || (c0801zzbZza.f848Mp == 1 && c0801zzbZza.f847Mo == 0))) {
            throw new zza(new StringBuilder(91).append("No acceptable module found. Local version is ").append(c0801zzbZza.f846Mn).append(" and remote version is ").append(c0801zzbZza.f847Mo).append(".").toString());
        }
        if (c0801zzbZza.f848Mp == -1) {
            return zzv(context, str);
        }
        if (c0801zzbZza.f848Mp != 1) {
            throw new zza(new StringBuilder(47).append("VersionPolicy returned invalid code:").append(c0801zzbZza.f848Mp).toString());
        }
        try {
            return zza(context, str, c0801zzbZza.f847Mo);
        } catch (zza e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", strValueOf.length() != 0 ? "Failed to load remote module: ".concat(strValueOf) : new String("Failed to load remote module: "));
            if (c0801zzbZza.f846Mn != 0) {
                final int i = c0801zzbZza.f846Mn;
                if (zzbVar.zza(context, str, new zzb.zza() { // from class: com.google.android.gms.internal.zzsj.7
                    @Override // com.google.android.gms.internal.zzsj.zzb.zza
                    public int zzd(Context context2, String str2, boolean z) {
                        return 0;
                    }

                    @Override // com.google.android.gms.internal.zzsj.zzb.zza
                    public int zzt(Context context2, String str2) {
                        return i;
                    }
                }).f848Mp == -1) {
                    return zzv(context, str);
                }
            }
            throw new zza("Remote load failed. No local fallback found.", e);
        }
    }

    private static zzsj zza(Context context, String str, int i) throws zza {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        zzsk zzskVarZzcs = zzcs(context);
        if (zzskVarZzcs == null) {
            throw new zza("Failed to create IDynamiteLoader.");
        }
        try {
            com.google.android.gms.dynamic.zzd zzdVarZza = zzskVarZzcs.zza(com.google.android.gms.dynamic.zze.zzae(context), str, i);
            if (com.google.android.gms.dynamic.zze.zzad(zzdVarZza) == null) {
                throw new zza("Failed to load remote module.");
            }
            return new zzsj((Context) com.google.android.gms.dynamic.zze.zzad(zzdVarZza));
        } catch (RemoteException e) {
            throw new zza("Failed to load remote module.", e);
        }
    }

    private static zzsk zzcs(Context context) {
        synchronized (zzsj.class) {
            if (f837Me != null) {
                return f837Me;
            }
            if (com.google.android.gms.common.zzc.zzand().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            }
            try {
                zzsk zzskVarZzfd = zzsk.zza.zzfd((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                if (zzskVarZzfd != null) {
                    f837Me = zzskVarZzfd;
                    return zzskVarZzfd;
                }
            } catch (Exception e) {
                String strValueOf = String.valueOf(e.getMessage());
                Log.e("DynamiteModule", strValueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(strValueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    public static int zzd(Context context, String str, boolean z) {
        zzsk zzskVarZzcs = zzcs(context);
        if (zzskVarZzcs == null) {
            return 0;
        }
        try {
            return zzskVarZzcs.zza(com.google.android.gms.dynamic.zze.zzae(context), str, z);
        } catch (RemoteException e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", strValueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    public static int zzt(Context context, String str) {
        int i;
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            String strValueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            String strValueOf2 = String.valueOf("ModuleDescriptor");
            Class<?> clsLoadClass = classLoader.loadClass(new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(str).length() + String.valueOf(strValueOf2).length()).append(strValueOf).append(str).append(".").append(strValueOf2).toString());
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                i = declaredField2.getInt(null);
            } else {
                String strValueOf3 = String.valueOf(declaredField.get(null));
                Log.e("DynamiteModule", new StringBuilder(String.valueOf(strValueOf3).length() + 51 + String.valueOf(str).length()).append("Module descriptor id '").append(strValueOf3).append("' didn't match expected id '").append(str).append("'").toString());
                i = 0;
            }
            return i;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            String strValueOf4 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", strValueOf4.length() != 0 ? "Failed to load module descriptor class: ".concat(strValueOf4) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int zzu(Context context, String str) {
        return zzd(context, str, false);
    }

    private static zzsj zzv(Context context, String str) {
        String strValueOf = String.valueOf(str);
        Log.i("DynamiteModule", strValueOf.length() != 0 ? "Selected local version of ".concat(strValueOf) : new String("Selected local version of "));
        return new zzsj(context.getApplicationContext());
    }

    public Context zzbcw() {
        return this.f844Ml;
    }

    public IBinder zziv(String str) throws zza {
        try {
            return (IBinder) this.f844Ml.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String strValueOf = String.valueOf(str);
            throw new zza(strValueOf.length() != 0 ? "Failed to instantiate module class: ".concat(strValueOf) : new String("Failed to instantiate module class: "), e);
        }
    }
}
