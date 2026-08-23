package com.unity3d.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: renamed from: com.unity3d.player.w */
/* JADX INFO: loaded from: classes.dex */
public final class SurfaceHolderCallbackC0711w extends FrameLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {

    /* JADX INFO: renamed from: a */
    private static boolean f1076a = false;

    /* JADX INFO: renamed from: b */
    private final UnityPlayer f1077b;

    /* JADX INFO: renamed from: c */
    private final Context f1078c;

    /* JADX INFO: renamed from: d */
    private final SurfaceView f1079d;

    /* JADX INFO: renamed from: e */
    private final SurfaceHolder f1080e;

    /* JADX INFO: renamed from: f */
    private final String f1081f;

    /* JADX INFO: renamed from: g */
    private final int f1082g;

    /* JADX INFO: renamed from: h */
    private final int f1083h;

    /* JADX INFO: renamed from: i */
    private final boolean f1084i;

    /* JADX INFO: renamed from: j */
    private final long f1085j;

    /* JADX INFO: renamed from: k */
    private final long f1086k;

    /* JADX INFO: renamed from: l */
    private final FrameLayout f1087l;

    /* JADX INFO: renamed from: m */
    private final Display f1088m;

    /* JADX INFO: renamed from: n */
    private int f1089n;

    /* JADX INFO: renamed from: o */
    private int f1090o;

    /* JADX INFO: renamed from: p */
    private int f1091p;

    /* JADX INFO: renamed from: q */
    private int f1092q;

    /* JADX INFO: renamed from: r */
    private MediaPlayer f1093r;

    /* JADX INFO: renamed from: s */
    private MediaController f1094s;

    /* JADX INFO: renamed from: t */
    private boolean f1095t;

    /* JADX INFO: renamed from: u */
    private boolean f1096u;

    /* JADX INFO: renamed from: v */
    private int f1097v;

    /* JADX INFO: renamed from: w */
    private boolean f1098w;

    /* JADX INFO: renamed from: x */
    private int f1099x;

    /* JADX INFO: renamed from: y */
    private boolean f1100y;

    protected SurfaceHolderCallbackC0711w(UnityPlayer unityPlayer, Context context, String str, int i, int i2, int i3, boolean z, long j, long j2) {
        super(context);
        this.f1095t = false;
        this.f1096u = false;
        this.f1097v = 0;
        this.f1098w = false;
        this.f1099x = 0;
        this.f1077b = unityPlayer;
        this.f1078c = context;
        this.f1087l = this;
        this.f1079d = new SurfaceView(context);
        this.f1080e = this.f1079d.getHolder();
        this.f1080e.addCallback(this);
        this.f1080e.setType(3);
        this.f1087l.setBackgroundColor(i);
        this.f1087l.addView(this.f1079d);
        this.f1088m = ((WindowManager) this.f1078c.getSystemService("window")).getDefaultDisplay();
        this.f1081f = str;
        this.f1082g = i2;
        this.f1083h = i3;
        this.f1084i = z;
        this.f1085j = j;
        this.f1086k = j2;
        if (f1076a) {
            m238a("fileName: " + this.f1081f);
        }
        if (f1076a) {
            m238a("backgroundColor: " + i);
        }
        if (f1076a) {
            m238a("controlMode: " + this.f1082g);
        }
        if (f1076a) {
            m238a("scalingMode: " + this.f1083h);
        }
        if (f1076a) {
            m238a("isURL: " + this.f1084i);
        }
        if (f1076a) {
            m238a("videoOffset: " + this.f1085j);
        }
        if (f1076a) {
            m238a("videoLength: " + this.f1086k);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f1100y = true;
    }

    /* JADX INFO: renamed from: a */
    private void m237a() {
        doCleanUp();
        try {
            this.f1093r = new MediaPlayer();
            if (this.f1084i) {
                this.f1093r.setDataSource(this.f1078c, Uri.parse(this.f1081f));
            } else if (this.f1086k != 0) {
                FileInputStream fileInputStream = new FileInputStream(this.f1081f);
                this.f1093r.setDataSource(fileInputStream.getFD(), this.f1085j, this.f1086k);
                fileInputStream.close();
            } else {
                try {
                    AssetFileDescriptor assetFileDescriptorOpenFd = getResources().getAssets().openFd(this.f1081f);
                    this.f1093r.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                    assetFileDescriptorOpenFd.close();
                } catch (IOException e) {
                    FileInputStream fileInputStream2 = new FileInputStream(this.f1081f);
                    this.f1093r.setDataSource(fileInputStream2.getFD());
                    fileInputStream2.close();
                }
            }
            this.f1093r.setDisplay(this.f1080e);
            this.f1093r.setScreenOnWhilePlaying(true);
            this.f1093r.setOnBufferingUpdateListener(this);
            this.f1093r.setOnCompletionListener(this);
            this.f1093r.setOnPreparedListener(this);
            this.f1093r.setOnVideoSizeChangedListener(this);
            this.f1093r.setAudioStreamType(3);
            this.f1093r.prepare();
            if (this.f1082g == 0 || this.f1082g == 1) {
                this.f1094s = new MediaController(this.f1078c);
                this.f1094s.setMediaPlayer(this);
                this.f1094s.setAnchorView(this);
                this.f1094s.setEnabled(true);
                this.f1094s.show();
            }
        } catch (Exception e2) {
            if (f1076a) {
                m238a("error: " + e2.getMessage() + e2);
            }
            onDestroy();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m238a(String str) {
        Log.v("Video", "VideoPlayer: " + str);
    }

    /* JADX INFO: renamed from: b */
    private void m239b() {
        if (isPlaying()) {
            return;
        }
        if (f1076a) {
            m238a("startVideoPlayback");
        }
        updateVideoLayout();
        if (this.f1098w) {
            return;
        }
        start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return true;
    }

    protected final void doCleanUp() {
        if (this.f1093r != null) {
            this.f1093r.release();
            this.f1093r = null;
        }
        this.f1091p = 0;
        this.f1092q = 0;
        this.f1096u = false;
        this.f1095t = false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        if (this.f1084i) {
            return this.f1097v;
        }
        return 100;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        if (this.f1093r == null) {
            return 0;
        }
        return this.f1093r.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        if (this.f1093r == null) {
            return 0;
        }
        return this.f1093r.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        boolean z = this.f1096u && this.f1095t;
        if (this.f1093r == null) {
            return !z;
        }
        return this.f1093r.isPlaying() || !z;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (f1076a) {
            m238a("onBufferingUpdate percent:" + i);
        }
        this.f1097v = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (f1076a) {
            m238a("onCompletion called");
        }
        onDestroy();
    }

    public final void onControllerHide() {
    }

    protected final void onDestroy() {
        onPause();
        doCleanUp();
        UnityPlayer.m115a(new Runnable() { // from class: com.unity3d.player.w.1
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceHolderCallbackC0711w.this.f1077b.hideVideoPlayer();
            }
        });
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 && (this.f1082g != 2 || i == 0 || keyEvent.isSystem())) {
            return this.f1094s != null ? this.f1094s.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
        }
        onDestroy();
        return true;
    }

    protected final void onPause() {
        if (f1076a) {
            m238a("onPause called");
        }
        if (!this.f1098w) {
            pause();
            this.f1098w = false;
        }
        if (this.f1093r != null) {
            this.f1099x = this.f1093r.getCurrentPosition();
        }
        this.f1100y = false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (f1076a) {
            m238a("onPrepared called");
        }
        this.f1096u = true;
        if (this.f1096u && this.f1095t) {
            m239b();
        }
    }

    protected final void onResume() {
        if (f1076a) {
            m238a("onResume called");
        }
        if (!this.f1100y && !this.f1098w) {
            start();
        }
        this.f1100y = true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f1082g != 2 || action != 0) {
            return this.f1094s != null ? this.f1094s.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
        }
        onDestroy();
        return true;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (f1076a) {
            m238a("onVideoSizeChanged called " + i + "x" + i2);
        }
        if (i == 0 || i2 == 0) {
            if (f1076a) {
                m238a("invalid video width(" + i + ") or height(" + i2 + ")");
                return;
            }
            return;
        }
        this.f1095t = true;
        this.f1091p = i;
        this.f1092q = i2;
        if (this.f1096u && this.f1095t) {
            m239b();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        if (this.f1093r == null) {
            return;
        }
        this.f1093r.pause();
        this.f1098w = true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i) {
        if (this.f1093r == null) {
            return;
        }
        this.f1093r.seekTo(i);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void start() {
        if (this.f1093r == null) {
            return;
        }
        this.f1093r.start();
        this.f1098w = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (f1076a) {
            m238a("surfaceChanged called " + i + " " + i2 + "x" + i3);
        }
        if (this.f1089n == i2 && this.f1090o == i3) {
            return;
        }
        this.f1089n = i2;
        this.f1090o = i3;
        updateVideoLayout();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (f1076a) {
            m238a("surfaceCreated called");
        }
        m237a();
        seekTo(this.f1099x);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (f1076a) {
            m238a("surfaceDestroyed called");
        }
        doCleanUp();
    }

    protected final void updateVideoLayout() {
        if (f1076a) {
            m238a("updateVideoLayout");
        }
        if (this.f1089n == 0 || this.f1090o == 0) {
            WindowManager windowManager = (WindowManager) this.f1078c.getSystemService("window");
            this.f1089n = windowManager.getDefaultDisplay().getWidth();
            this.f1090o = windowManager.getDefaultDisplay().getHeight();
        }
        int i = this.f1089n;
        int i2 = this.f1090o;
        float f = this.f1091p / this.f1092q;
        float f2 = this.f1089n / this.f1090o;
        if (this.f1083h == 1) {
            if (f2 <= f) {
                i2 = (int) (this.f1089n / f);
            } else {
                i = (int) (this.f1090o * f);
            }
        } else if (this.f1083h == 2) {
            if (f2 >= f) {
                i2 = (int) (this.f1089n / f);
            } else {
                i = (int) (this.f1090o * f);
            }
        } else if (this.f1083h == 0) {
            i = this.f1091p;
            i2 = this.f1092q;
        }
        if (f1076a) {
            m238a("frameWidth = " + i + "; frameHeight = " + i2);
        }
        this.f1087l.updateViewLayout(this.f1079d, new FrameLayout.LayoutParams(i, i2, 17));
    }
}
