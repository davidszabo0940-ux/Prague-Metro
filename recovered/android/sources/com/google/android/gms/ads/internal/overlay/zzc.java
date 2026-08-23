package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.TextureView;
import android.view.View;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
@zzir
public class zzc extends zzi implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzbrv = new HashMap();
    private final zzx zzbrw;
    private final boolean zzbrx;
    private int zzbry;
    private int zzbrz;
    private MediaPlayer zzbsa;
    private Uri zzbsb;
    private int zzbsc;
    private int zzbsd;
    private int zzbse;
    private int zzbsf;
    private int zzbsg;
    private float zzbsh;
    private boolean zzbsi;
    private boolean zzbsj;
    private zzw zzbsk;
    private boolean zzbsl;
    private int zzbsm;
    private zzh zzbsn;

    static {
        zzbrv.put(-1004, "MEDIA_ERROR_IO");
        zzbrv.put(-1007, "MEDIA_ERROR_MALFORMED");
        zzbrv.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        zzbrv.put(-110, "MEDIA_ERROR_TIMED_OUT");
        zzbrv.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzbrv.put(1, "MEDIA_ERROR_UNKNOWN");
        zzbrv.put(1, "MEDIA_INFO_UNKNOWN");
        zzbrv.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzbrv.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        zzbrv.put(701, "MEDIA_INFO_BUFFERING_START");
        zzbrv.put(702, "MEDIA_INFO_BUFFERING_END");
        zzbrv.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzbrv.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzbrv.put(802, "MEDIA_INFO_METADATA_UPDATE");
        zzbrv.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        zzbrv.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzc(Context context, boolean z, boolean z2, zzx zzxVar) {
        super(context);
        this.zzbry = 0;
        this.zzbrz = 0;
        this.zzbsh = 1.0f;
        setSurfaceTextureListener(this);
        this.zzbrw = zzxVar;
        this.zzbsl = z;
        this.zzbrx = z2;
        this.zzbrw.zza((zzi) this);
    }

    private void zzad(int i) {
        if (i == 3) {
            this.zzbrw.zzpk();
        } else if (this.zzbry == 3) {
            this.zzbrw.zzpl();
        }
        this.zzbry = i;
    }

    private void zzae(int i) {
        this.zzbrz = i;
    }

    private void zzb(float f) {
        if (this.zzbsa == null) {
            zzkh.zzcy("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        } else {
            try {
                this.zzbsa.setVolume(f, f);
            } catch (IllegalStateException e) {
            }
        }
    }

    private void zznl() {
        SurfaceTexture surfaceTextureZzoz;
        zzkh.m95v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzbsb == null || surfaceTexture == null) {
            return;
        }
        zzy(false);
        try {
            this.zzbsa = com.google.android.gms.ads.internal.zzu.zzgd().zzox();
            this.zzbsa.setOnBufferingUpdateListener(this);
            this.zzbsa.setOnCompletionListener(this);
            this.zzbsa.setOnErrorListener(this);
            this.zzbsa.setOnInfoListener(this);
            this.zzbsa.setOnPreparedListener(this);
            this.zzbsa.setOnVideoSizeChangedListener(this);
            this.zzbse = 0;
            if (this.zzbsl) {
                this.zzbsk = new zzw(getContext());
                this.zzbsk.zza(surfaceTexture, getWidth(), getHeight());
                this.zzbsk.start();
                surfaceTextureZzoz = this.zzbsk.zzoz();
                if (surfaceTextureZzoz == null) {
                    this.zzbsk.zzoy();
                    this.zzbsk = null;
                    surfaceTextureZzoz = surfaceTexture;
                }
            } else {
                surfaceTextureZzoz = surfaceTexture;
            }
            this.zzbsa.setDataSource(getContext(), this.zzbsb);
            this.zzbsa.setSurface(com.google.android.gms.ads.internal.zzu.zzge().zza(surfaceTextureZzoz));
            this.zzbsa.setAudioStreamType(3);
            this.zzbsa.setScreenOnWhilePlaying(true);
            this.zzbsa.prepareAsync();
            zzad(1);
        } catch (IOException | IllegalArgumentException | IllegalStateException e) {
            String strValueOf = String.valueOf(this.zzbsb);
            zzkh.zzd(new StringBuilder(String.valueOf(strValueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(strValueOf).toString(), e);
            onError(this.zzbsa, 1, 0);
        }
    }

    private void zznm() {
        if (this.zzbrx && zznp() && this.zzbsa.getCurrentPosition() > 0 && this.zzbrz != 3) {
            zzkh.m95v("AdMediaPlayerView nudging MediaPlayer");
            zzb(0.0f);
            this.zzbsa.start();
            int currentPosition = this.zzbsa.getCurrentPosition();
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis();
            while (zznp() && this.zzbsa.getCurrentPosition() == currentPosition && com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis() - jCurrentTimeMillis <= 250) {
            }
            this.zzbsa.pause();
            zznu();
        }
    }

    private void zznn() {
        AudioManager audioManagerZznv = zznv();
        if (audioManagerZznv == null || this.zzbsj) {
            return;
        }
        if (audioManagerZznv.requestAudioFocus(this, 3, 2) == 1) {
            zzns();
        } else {
            zzkh.zzcy("AdMediaPlayerView audio focus request failed");
        }
    }

    private void zzno() {
        zzkh.m95v("AdMediaPlayerView abandon audio focus");
        AudioManager audioManagerZznv = zznv();
        if (audioManagerZznv == null || !this.zzbsj) {
            return;
        }
        if (audioManagerZznv.abandonAudioFocus(this) == 1) {
            this.zzbsj = false;
        } else {
            zzkh.zzcy("AdMediaPlayerView abandon audio focus failed");
        }
    }

    private boolean zznp() {
        return (this.zzbsa == null || this.zzbry == -1 || this.zzbry == 0 || this.zzbry == 1) ? false : true;
    }

    private void zzns() {
        zzkh.m95v("AdMediaPlayerView audio focus gained");
        this.zzbsj = true;
        zznu();
    }

    private void zznt() {
        zzkh.m95v("AdMediaPlayerView audio focus lost");
        this.zzbsj = false;
        zznu();
    }

    private void zznu() {
        if (this.zzbsi || !this.zzbsj) {
            zzb(0.0f);
        } else {
            zzb(this.zzbsh);
        }
    }

    private AudioManager zznv() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    private void zzy(boolean z) {
        zzkh.m95v("AdMediaPlayerView release");
        if (this.zzbsk != null) {
            this.zzbsk.zzoy();
            this.zzbsk = null;
        }
        if (this.zzbsa != null) {
            this.zzbsa.reset();
            this.zzbsa.release();
            this.zzbsa = null;
            zzad(0);
            if (z) {
                this.zzbrz = 0;
                zzae(0);
            }
            zzno();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public int getCurrentPosition() {
        if (zznp()) {
            return this.zzbsa.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public int getDuration() {
        if (zznp()) {
            return this.zzbsa.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public int getVideoHeight() {
        if (this.zzbsa != null) {
            return this.zzbsa.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public int getVideoWidth() {
        if (this.zzbsa != null) {
            return this.zzbsa.getVideoWidth();
        }
        return 0;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        if (i > 0) {
            zzns();
        } else if (i < 0) {
            zznt();
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzbse = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        zzkh.m95v("AdMediaPlayerView completion");
        zzad(5);
        zzae(5);
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.2
            @Override // java.lang.Runnable
            public void run() {
                if (zzc.this.zzbsn != null) {
                    zzc.this.zzbsn.zzon();
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        final String str = zzbrv.get(Integer.valueOf(i));
        final String str2 = zzbrv.get(Integer.valueOf(i2));
        zzkh.zzcy(new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer error: ").append(str).append(":").append(str2).toString());
        zzad(-1);
        zzae(-1);
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.3
            @Override // java.lang.Runnable
            public void run() {
                if (zzc.this.zzbsn != null) {
                    zzc.this.zzbsn.zzl(str, str2);
                }
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzbrv.get(Integer.valueOf(i));
        String str2 = zzbrv.get(Integer.valueOf(i2));
        zzkh.m95v(new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer info: ").append(str).append(":").append(str2).toString());
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.zzbsc, i);
        int defaultSize2 = getDefaultSize(this.zzbsd, i2);
        if (this.zzbsc > 0 && this.zzbsd > 0 && this.zzbsk == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.zzbsc * defaultSize2 < this.zzbsd * size) {
                    defaultSize = (this.zzbsc * defaultSize2) / this.zzbsd;
                } else if (this.zzbsc * defaultSize2 > this.zzbsd * size) {
                    defaultSize2 = (this.zzbsd * size) / this.zzbsc;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i3 = (this.zzbsd * size) / this.zzbsc;
                if (mode2 != Integer.MIN_VALUE || i3 <= defaultSize2) {
                    defaultSize2 = i3;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.zzbsc * defaultSize2) / this.zzbsd;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i4 = this.zzbsc;
                int i5 = this.zzbsd;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                    defaultSize = i4;
                } else {
                    defaultSize = (this.zzbsc * defaultSize2) / this.zzbsd;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (this.zzbsd * size) / this.zzbsc;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (this.zzbsk != null) {
            this.zzbsk.zzg(defaultSize, defaultSize2);
        }
        if (Build.VERSION.SDK_INT == 16) {
            if ((this.zzbsf > 0 && this.zzbsf != defaultSize) || (this.zzbsg > 0 && this.zzbsg != defaultSize2)) {
                zznm();
            }
            this.zzbsf = defaultSize;
            this.zzbsg = defaultSize2;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        zzkh.m95v("AdMediaPlayerView prepared");
        zzad(2);
        this.zzbrw.zzol();
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.1
            @Override // java.lang.Runnable
            public void run() {
                if (zzc.this.zzbsn != null) {
                    zzc.this.zzbsn.zzol();
                }
            }
        });
        this.zzbsc = mediaPlayer.getVideoWidth();
        this.zzbsd = mediaPlayer.getVideoHeight();
        if (this.zzbsm != 0) {
            seekTo(this.zzbsm);
        }
        zznm();
        int i = this.zzbsc;
        zzkh.zzcx(new StringBuilder(62).append("AdMediaPlayerView stream dimensions: ").append(i).append(" x ").append(this.zzbsd).toString());
        if (this.zzbrz == 3) {
            play();
        }
        zznn();
        zznu();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzkh.m95v("AdMediaPlayerView surface created");
        zznl();
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.4
            @Override // java.lang.Runnable
            public void run() {
                if (zzc.this.zzbsn != null) {
                    zzc.this.zzbsn.zzok();
                }
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzkh.m95v("AdMediaPlayerView surface destroyed");
        if (this.zzbsa != null && this.zzbsm == 0) {
            this.zzbsm = this.zzbsa.getCurrentPosition();
        }
        if (this.zzbsk != null) {
            this.zzbsk.zzoy();
        }
        zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.5
            @Override // java.lang.Runnable
            public void run() {
                if (zzc.this.zzbsn != null) {
                    zzc.this.zzbsn.onPaused();
                    zzc.this.zzbsn.zzoo();
                }
            }
        });
        zzy(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzkh.m95v("AdMediaPlayerView surface changed");
        boolean z = this.zzbrz == 3;
        boolean z2 = this.zzbsc == i && this.zzbsd == i2;
        if (this.zzbsa != null && z && z2) {
            if (this.zzbsm != 0) {
                seekTo(this.zzbsm);
            }
            play();
        }
        if (this.zzbsk != null) {
            this.zzbsk.zzg(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzbrw.zzb(this);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        zzkh.m95v(new StringBuilder(57).append("AdMediaPlayerView size changed: ").append(i).append(" x ").append(i2).toString());
        this.zzbsc = mediaPlayer.getVideoWidth();
        this.zzbsd = mediaPlayer.getVideoHeight();
        if (this.zzbsc == 0 || this.zzbsd == 0) {
            return;
        }
        requestLayout();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void pause() {
        zzkh.m95v("AdMediaPlayerView pause");
        if (zznp() && this.zzbsa.isPlaying()) {
            this.zzbsa.pause();
            zzad(4);
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.7
                @Override // java.lang.Runnable
                public void run() {
                    if (zzc.this.zzbsn != null) {
                        zzc.this.zzbsn.onPaused();
                    }
                }
            });
        }
        zzae(4);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void play() {
        zzkh.m95v("AdMediaPlayerView play");
        if (zznp()) {
            this.zzbsa.start();
            zzad(3);
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzc.6
                @Override // java.lang.Runnable
                public void run() {
                    if (zzc.this.zzbsn != null) {
                        zzc.this.zzbsn.zzom();
                    }
                }
            });
        }
        zzae(3);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void seekTo(int i) {
        zzkh.m95v(new StringBuilder(34).append("AdMediaPlayerView seek ").append(i).toString());
        if (!zznp()) {
            this.zzbsm = i;
        } else {
            this.zzbsa.seekTo(i);
            this.zzbsm = 0;
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void setMimeType(String str) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.zzbsb = uri;
        this.zzbsm = 0;
        zznl();
        requestLayout();
        invalidate();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void stop() {
        zzkh.m95v("AdMediaPlayerView stop");
        if (this.zzbsa != null) {
            this.zzbsa.stop();
            this.zzbsa.release();
            this.zzbsa = null;
            zzad(0);
            zzae(0);
            zzno();
        }
        this.zzbrw.onStop();
    }

    @Override // android.view.View
    public String toString() {
        String strValueOf = String.valueOf(getClass().getName());
        String strValueOf2 = String.valueOf(Integer.toHexString(hashCode()));
        return new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length()).append(strValueOf).append("@").append(strValueOf2).toString();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void zza(float f) {
        this.zzbsh = f;
        zznu();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void zza(float f, float f2) {
        if (this.zzbsk != null) {
            this.zzbsk.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void zza(zzh zzhVar) {
        this.zzbsn = zzhVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public String zznk() {
        String strValueOf = String.valueOf(this.zzbsl ? " spherical" : "");
        return strValueOf.length() != 0 ? "MediaPlayer".concat(strValueOf) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void zznq() {
        this.zzbsi = true;
        zznu();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzi
    public void zznr() {
        this.zzbsi = false;
        zznu();
    }
}
