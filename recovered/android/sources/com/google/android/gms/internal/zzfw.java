package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzfw {
    private final Context mContext;
    private final Object zzail;
    private final VersionInfoParcel zzalm;
    private final String zzblv;
    private zzkp<zzft> zzblw;
    private zzkp<zzft> zzblx;
    private zzd zzbly;
    private int zzblz;

    /* JADX INFO: renamed from: com.google.android.gms.internal.zzfw$1 */
    class RunnableC04831 implements Runnable {
        final /* synthetic */ zzas zzbma;
        final /* synthetic */ zzd zzbmb;

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzfw$1$1, reason: invalid class name */
        class AnonymousClass1 implements zzft.zza {
            final /* synthetic */ zzft zzbmd;

            AnonymousClass1(zzft zzftVar) {
                this.zzbmd = zzftVar;
            }

            @Override // com.google.android.gms.internal.zzft.zza
            public void zzmb() {
                zzkl.zzclg.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.zzfw.1.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (zzfw.this.zzail) {
                            if (RunnableC04831.this.zzbmb.getStatus() == -1 || RunnableC04831.this.zzbmb.getStatus() == 1) {
                                return;
                            }
                            RunnableC04831.this.zzbmb.reject();
                            com.google.android.gms.ads.internal.zzu.zzfq().runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzfw.1.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass1.this.zzbmd.destroy();
                                }
                            });
                            zzkh.m95v("Could not receive loaded message in a timely manner. Rejecting.");
                        }
                    }
                }, zza.zzbml);
            }
        }

        RunnableC04831(zzas zzasVar, zzd zzdVar) {
            this.zzbma = zzasVar;
            this.zzbmb = zzdVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            final zzft zzftVarZza = zzfw.this.zza(zzfw.this.mContext, zzfw.this.zzalm, this.zzbma);
            zzftVarZza.zza(new AnonymousClass1(zzftVarZza));
            zzftVarZza.zza("/jsLoaded", new zzet() { // from class: com.google.android.gms.internal.zzfw.1.2
                @Override // com.google.android.gms.internal.zzet
                public void zza(zzll zzllVar, Map<String, String> map) {
                    synchronized (zzfw.this.zzail) {
                        if (RunnableC04831.this.zzbmb.getStatus() == -1 || RunnableC04831.this.zzbmb.getStatus() == 1) {
                            return;
                        }
                        zzfw.this.zzblz = 0;
                        zzfw.this.zzblw.zzd(zzftVarZza);
                        RunnableC04831.this.zzbmb.zzg(zzftVarZza);
                        zzfw.this.zzbly = RunnableC04831.this.zzbmb;
                        zzkh.m95v("Successfully loaded JS Engine.");
                    }
                }
            });
            final zzkw zzkwVar = new zzkw();
            zzet zzetVar = new zzet() { // from class: com.google.android.gms.internal.zzfw.1.3
                @Override // com.google.android.gms.internal.zzet
                public void zza(zzll zzllVar, Map<String, String> map) {
                    synchronized (zzfw.this.zzail) {
                        zzkh.zzcx("JS Engine is requesting an update");
                        if (zzfw.this.zzblz == 0) {
                            zzkh.zzcx("Starting reload.");
                            zzfw.this.zzblz = 2;
                            zzfw.this.zzb(RunnableC04831.this.zzbma);
                        }
                        zzftVarZza.zzb("/requestReload", (zzet) zzkwVar.get());
                    }
                }
            };
            zzkwVar.set(zzetVar);
            zzftVarZza.zza("/requestReload", zzetVar);
            if (zzfw.this.zzblv.endsWith(".js")) {
                zzftVarZza.zzbh(zzfw.this.zzblv);
            } else if (zzfw.this.zzblv.startsWith("<html>")) {
                zzftVarZza.zzbj(zzfw.this.zzblv);
            } else {
                zzftVarZza.zzbi(zzfw.this.zzblv);
            }
            zzkl.zzclg.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.zzfw.1.4
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzfw.this.zzail) {
                        if (RunnableC04831.this.zzbmb.getStatus() == -1 || RunnableC04831.this.zzbmb.getStatus() == 1) {
                            return;
                        }
                        RunnableC04831.this.zzbmb.reject();
                        com.google.android.gms.ads.internal.zzu.zzfq().runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzfw.1.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                zzftVarZza.destroy();
                            }
                        });
                        zzkh.m95v("Could not receive loaded message in a timely manner. Rejecting.");
                    }
                }
            }, zza.zzbmk);
        }
    }

    static class zza {
        static int zzbmk = 60000;
        static int zzbml = 10000;
    }

    public static class zzb<T> implements zzkp<T> {
        @Override // com.google.android.gms.internal.zzkp
        public void zzd(T t) {
        }
    }

    public static class zzc extends zzlf<zzfx> {
        private final Object zzail = new Object();
        private final zzd zzbmm;
        private boolean zzbmn;

        public zzc(zzd zzdVar) {
            this.zzbmm = zzdVar;
        }

        public void release() {
            synchronized (this.zzail) {
                if (this.zzbmn) {
                    return;
                }
                this.zzbmn = true;
                zza(new zzle.zzc<zzfx>() { // from class: com.google.android.gms.internal.zzfw.zzc.1
                    @Override // com.google.android.gms.internal.zzle.zzc
                    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
                    public void zzd(zzfx zzfxVar) {
                        zzkh.m95v("Ending javascript session.");
                        ((zzfy) zzfxVar).zzmh();
                    }
                }, new zzle.zzb());
                zza(new zzle.zzc<zzfx>() { // from class: com.google.android.gms.internal.zzfw.zzc.2
                    @Override // com.google.android.gms.internal.zzle.zzc
                    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
                    public void zzd(zzfx zzfxVar) {
                        zzkh.m95v("Releasing engine reference.");
                        zzc.this.zzbmm.zzme();
                    }
                }, new zzle.zza() { // from class: com.google.android.gms.internal.zzfw.zzc.3
                    @Override // com.google.android.gms.internal.zzle.zza
                    public void run() {
                        zzc.this.zzbmm.zzme();
                    }
                });
            }
        }
    }

    public static class zzd extends zzlf<zzft> {
        private zzkp<zzft> zzblx;
        private final Object zzail = new Object();
        private boolean zzbmp = false;
        private int zzbmq = 0;

        public zzd(zzkp<zzft> zzkpVar) {
            this.zzblx = zzkpVar;
        }

        public zzc zzmd() {
            final zzc zzcVar = new zzc(this);
            synchronized (this.zzail) {
                zza(new zzle.zzc<zzft>() { // from class: com.google.android.gms.internal.zzfw.zzd.1
                    @Override // com.google.android.gms.internal.zzle.zzc
                    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                    public void zzd(zzft zzftVar) {
                        zzkh.m95v("Getting a new session for JS Engine.");
                        zzcVar.zzg(zzftVar.zzma());
                    }
                }, new zzle.zza() { // from class: com.google.android.gms.internal.zzfw.zzd.2
                    @Override // com.google.android.gms.internal.zzle.zza
                    public void run() {
                        zzkh.m95v("Rejecting reference for JS Engine.");
                        zzcVar.reject();
                    }
                });
                com.google.android.gms.common.internal.zzab.zzbm(this.zzbmq >= 0);
                this.zzbmq++;
            }
            return zzcVar;
        }

        protected void zzme() {
            synchronized (this.zzail) {
                com.google.android.gms.common.internal.zzab.zzbm(this.zzbmq >= 1);
                zzkh.m95v("Releasing 1 reference for JS Engine");
                this.zzbmq--;
                zzmg();
            }
        }

        public void zzmf() {
            synchronized (this.zzail) {
                com.google.android.gms.common.internal.zzab.zzbm(this.zzbmq >= 0);
                zzkh.m95v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzbmp = true;
                zzmg();
            }
        }

        protected void zzmg() {
            synchronized (this.zzail) {
                com.google.android.gms.common.internal.zzab.zzbm(this.zzbmq >= 0);
                if (this.zzbmp && this.zzbmq == 0) {
                    zzkh.m95v("No reference is left (including root). Cleaning up engine.");
                    zza(new zzle.zzc<zzft>() { // from class: com.google.android.gms.internal.zzfw.zzd.3
                        @Override // com.google.android.gms.internal.zzle.zzc
                        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                        public void zzd(final zzft zzftVar) {
                            com.google.android.gms.ads.internal.zzu.zzfq().runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzfw.zzd.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    zzd.this.zzblx.zzd(zzftVar);
                                    zzftVar.destroy();
                                }
                            });
                        }
                    }, new zzle.zzb());
                } else {
                    zzkh.m95v("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    public static class zze extends zzlf<zzfx> {
        private zzc zzbmv;

        public zze(zzc zzcVar) {
            this.zzbmv = zzcVar;
        }

        public void finalize() {
            this.zzbmv.release();
            this.zzbmv = null;
        }

        @Override // com.google.android.gms.internal.zzlf
        public int getStatus() {
            return this.zzbmv.getStatus();
        }

        @Override // com.google.android.gms.internal.zzlf
        public void reject() {
            this.zzbmv.reject();
        }

        @Override // com.google.android.gms.internal.zzlf, com.google.android.gms.internal.zzle
        public void zza(zzle.zzc<zzfx> zzcVar, zzle.zza zzaVar) {
            this.zzbmv.zza(zzcVar, zzaVar);
        }

        @Override // com.google.android.gms.internal.zzlf, com.google.android.gms.internal.zzle
        /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public void zzg(zzfx zzfxVar) {
            this.zzbmv.zzg(zzfxVar);
        }
    }

    public zzfw(Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zzail = new Object();
        this.zzblz = 1;
        this.zzblv = str;
        this.mContext = context.getApplicationContext();
        this.zzalm = versionInfoParcel;
        this.zzblw = new zzb();
        this.zzblx = new zzb();
    }

    public zzfw(Context context, VersionInfoParcel versionInfoParcel, String str, zzkp<zzft> zzkpVar, zzkp<zzft> zzkpVar2) {
        this(context, versionInfoParcel, str);
        this.zzblw = zzkpVar;
        this.zzblx = zzkpVar2;
    }

    private zzd zza(zzas zzasVar) {
        zzd zzdVar = new zzd(this.zzblx);
        com.google.android.gms.ads.internal.zzu.zzfq().runOnUiThread(new RunnableC04831(zzasVar, zzdVar));
        return zzdVar;
    }

    protected zzft zza(Context context, VersionInfoParcel versionInfoParcel, zzas zzasVar) {
        return new zzfv(context, versionInfoParcel, zzasVar);
    }

    protected zzd zzb(zzas zzasVar) {
        final zzd zzdVarZza = zza(zzasVar);
        zzdVarZza.zza(new zzle.zzc<zzft>() { // from class: com.google.android.gms.internal.zzfw.2
            @Override // com.google.android.gms.internal.zzle.zzc
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zzd(zzft zzftVar) {
                synchronized (zzfw.this.zzail) {
                    zzfw.this.zzblz = 0;
                    if (zzfw.this.zzbly != null && zzdVarZza != zzfw.this.zzbly) {
                        zzkh.m95v("New JS engine is loaded, marking previous one as destroyable.");
                        zzfw.this.zzbly.zzmf();
                    }
                    zzfw.this.zzbly = zzdVarZza;
                }
            }
        }, new zzle.zza() { // from class: com.google.android.gms.internal.zzfw.3
            @Override // com.google.android.gms.internal.zzle.zza
            public void run() {
                synchronized (zzfw.this.zzail) {
                    zzfw.this.zzblz = 1;
                    zzkh.m95v("Failed loading new engine. Marking new engine destroyable.");
                    zzdVarZza.zzmf();
                }
            }
        });
        return zzdVarZza;
    }

    public zzc zzc(zzas zzasVar) {
        zzc zzcVarZzmd;
        synchronized (this.zzail) {
            if (this.zzbly == null || this.zzbly.getStatus() == -1) {
                this.zzblz = 2;
                this.zzbly = zzb(zzasVar);
                zzcVarZzmd = this.zzbly.zzmd();
            } else if (this.zzblz == 0) {
                zzcVarZzmd = this.zzbly.zzmd();
            } else if (this.zzblz == 1) {
                this.zzblz = 2;
                zzb(zzasVar);
                zzcVarZzmd = this.zzbly.zzmd();
            } else {
                zzcVarZzmd = this.zzblz == 2 ? this.zzbly.zzmd() : this.zzbly.zzmd();
            }
        }
        return zzcVarZzmd;
    }

    public zzc zzmc() {
        return zzc((zzas) null);
    }
}
