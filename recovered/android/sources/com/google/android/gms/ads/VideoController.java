package com.google.android.gms.ads;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzap;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class VideoController {
    private final Object zzail = new Object();

    @Nullable
    private zzab zzaim;

    @Nullable
    private VideoLifecycleCallbacks zzain;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }
    }

    @Nullable
    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zzail) {
            videoLifecycleCallbacks = this.zzain;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzaim != null;
        }
        return z;
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        com.google.android.gms.common.internal.zzab.zzb(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.zzail) {
            this.zzain = videoLifecycleCallbacks;
            if (this.zzaim == null) {
                return;
            }
            try {
                this.zzaim.zza(new zzap(videoLifecycleCallbacks));
            } catch (RemoteException e) {
                zzb.zzb("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public void zza(zzab zzabVar) {
        synchronized (this.zzail) {
            this.zzaim = zzabVar;
            if (this.zzain != null) {
                setVideoLifecycleCallbacks(this.zzain);
            }
        }
    }
}
