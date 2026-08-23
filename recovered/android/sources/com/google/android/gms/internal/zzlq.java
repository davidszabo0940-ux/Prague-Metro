package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzlq extends com.google.android.gms.ads.internal.client.zzab.zza {
    private final Object zzail = new Object();
    private boolean zzaio = true;
    private final zzll zzbgj;
    private final float zzcqb;
    private int zzcqc;
    private com.google.android.gms.ads.internal.client.zzac zzcqd;
    private boolean zzcqe;
    private boolean zzcqf;
    private float zzcqg;

    public zzlq(zzll zzllVar, float f) {
        this.zzbgj = zzllVar;
        this.zzcqb = f;
    }

    private void zzc(String str, @Nullable Map<String, String> map) {
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put("action", str);
        com.google.android.gms.ads.internal.zzu.zzfq().runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzlq.1
            @Override // java.lang.Runnable
            public void run() {
                zzlq.this.zzbgj.zza("pubVideoCmd", map2);
            }
        });
    }

    private void zzde(String str) {
        zzc(str, null);
    }

    private void zzi(final int i, final int i2) {
        com.google.android.gms.ads.internal.zzu.zzfq().runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzlq.2
            /* JADX WARN: Code duplicated, block: B:41:0x006e A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:43:0x0079 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:59:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:62:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:66:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            public void run() {
                synchronized (zzlq.this.zzail) {
                    boolean z = i != i2;
                    boolean z2 = !zzlq.this.zzcqe && i2 == 1;
                    boolean z3 = z && i2 == 1;
                    boolean z4 = z && i2 == 2;
                    boolean z5 = z && i2 == 3;
                    zzlq.this.zzcqe = zzlq.this.zzcqe || z2;
                    if (zzlq.this.zzcqd == null) {
                        return;
                    }
                    if (!z2) {
                        if (z3) {
                            if (z4) {
                                if (z5) {
                                    zzlq.this.zzcqd.onVideoEnd();
                                }
                                return;
                            } else {
                                zzlq.this.zzcqd.zzjd();
                                if (z5) {
                                    zzlq.this.zzcqd.onVideoEnd();
                                }
                                return;
                            }
                        }
                        zzlq.this.zzcqd.zzjc();
                        if (z4) {
                            if (z5) {
                                zzlq.this.zzcqd.onVideoEnd();
                            }
                            return;
                        } else {
                            zzlq.this.zzcqd.zzjd();
                            if (z5) {
                                zzlq.this.zzcqd.onVideoEnd();
                            }
                            return;
                        }
                    }
                    try {
                        zzlq.this.zzcqd.zzjb();
                    } catch (RemoteException e) {
                        zzkh.zzd("Unable to call onVideoStart()", e);
                    }
                    if (z3) {
                        if (z4) {
                            if (z5) {
                                zzlq.this.zzcqd.onVideoEnd();
                            }
                            return;
                        } else {
                            zzlq.this.zzcqd.zzjd();
                            if (z5) {
                                zzlq.this.zzcqd.onVideoEnd();
                            }
                            return;
                        }
                    }
                    try {
                        zzlq.this.zzcqd.zzjc();
                    } catch (RemoteException e2) {
                        zzkh.zzd("Unable to call onVideoPlay()", e2);
                    }
                    if (z4) {
                        if (z5) {
                            zzlq.this.zzcqd.onVideoEnd();
                        }
                        return;
                    }
                    try {
                        zzlq.this.zzcqd.zzjd();
                    } catch (RemoteException e3) {
                        zzkh.zzd("Unable to call onVideoPause()", e3);
                    }
                    if (z5) {
                        try {
                            zzlq.this.zzcqd.onVideoEnd();
                        } catch (RemoteException e4) {
                            zzkh.zzd("Unable to call onVideoEnd()", e4);
                        }
                    }
                    return;
                    throw th;
                }
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.client.zzab
    public int getPlaybackState() {
        int i;
        synchronized (this.zzail) {
            i = this.zzcqc;
        }
        return i;
    }

    @Override // com.google.android.gms.ads.internal.client.zzab
    public boolean isMuted() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzcqf;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzab
    public void pause() {
        zzde("pause");
    }

    @Override // com.google.android.gms.ads.internal.client.zzab
    public void play() {
        zzde("play");
    }

    public void zza(float f, int i, boolean z) {
        int i2;
        synchronized (this.zzail) {
            this.zzcqg = f;
            this.zzcqf = z;
            i2 = this.zzcqc;
            this.zzcqc = i;
        }
        zzi(i2, i);
    }

    @Override // com.google.android.gms.ads.internal.client.zzab
    public void zza(com.google.android.gms.ads.internal.client.zzac zzacVar) {
        synchronized (this.zzail) {
            this.zzcqd = zzacVar;
        }
    }

    public void zzam(boolean z) {
        synchronized (this.zzail) {
            this.zzaio = z;
        }
        zzc("initialState", com.google.android.gms.common.util.zzf.zze("muteStart", z ? "1" : "0"));
    }

    @Override // com.google.android.gms.ads.internal.client.zzab
    public float zziz() {
        return this.zzcqb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzab
    public float zzja() {
        float f;
        synchronized (this.zzail) {
            f = this.zzcqg;
        }
        return f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzab
    public void zzm(boolean z) {
        zzde(z ? "mute" : "unmute");
    }
}
