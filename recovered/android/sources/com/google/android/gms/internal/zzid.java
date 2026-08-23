package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzid implements Runnable {
    private final int zzaie;
    private final int zzaif;
    protected final zzll zzbgj;
    private final Handler zzbyb;
    private final long zzbyc;
    private long zzbyd;
    private zzlm.zza zzbye;
    protected boolean zzbyf;
    protected boolean zzbyg;

    protected final class zza extends AsyncTask<Void, Void, Boolean> {
        private final WebView zzbyh;
        private Bitmap zzbyi;

        public zza(WebView webView) {
            this.zzbyh = webView;
        }

        @Override // android.os.AsyncTask
        protected synchronized void onPreExecute() {
            this.zzbyi = Bitmap.createBitmap(zzid.this.zzaie, zzid.this.zzaif, Bitmap.Config.ARGB_8888);
            this.zzbyh.setVisibility(0);
            this.zzbyh.measure(View.MeasureSpec.makeMeasureSpec(zzid.this.zzaie, 0), View.MeasureSpec.makeMeasureSpec(zzid.this.zzaif, 0));
            this.zzbyh.layout(0, 0, zzid.this.zzaie, zzid.this.zzaif);
            this.zzbyh.draw(new Canvas(this.zzbyi));
            this.zzbyh.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            zzid.zzc(zzid.this);
            if (bool.booleanValue() || zzid.this.zzqc() || zzid.this.zzbyd <= 0) {
                zzid.this.zzbyg = bool.booleanValue();
                zzid.this.zzbye.zza(zzid.this.zzbgj, true);
            } else if (zzid.this.zzbyd > 0) {
                if (zzkh.zzaz(2)) {
                    zzkh.zzcw("Ad not detected, scheduling another run.");
                }
                zzid.this.zzbyb.postDelayed(zzid.this, zzid.this.zzbyc);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public synchronized Boolean doInBackground(Void... voidArr) {
            boolean zValueOf;
            int width = this.zzbyi.getWidth();
            int height = this.zzbyi.getHeight();
            if (width == 0 || height == 0) {
                zValueOf = false;
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.zzbyi.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                zValueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return zValueOf;
        }
    }

    public zzid(zzlm.zza zzaVar, zzll zzllVar, int i, int i2) {
        this(zzaVar, zzllVar, i, i2, 200L, 50L);
    }

    public zzid(zzlm.zza zzaVar, zzll zzllVar, int i, int i2, long j, long j2) {
        this.zzbyc = j;
        this.zzbyd = j2;
        this.zzbyb = new Handler(Looper.getMainLooper());
        this.zzbgj = zzllVar;
        this.zzbye = zzaVar;
        this.zzbyf = false;
        this.zzbyg = false;
        this.zzaif = i2;
        this.zzaie = i;
    }

    static /* synthetic */ long zzc(zzid zzidVar) {
        long j = zzidVar.zzbyd - 1;
        zzidVar.zzbyd = j;
        return j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.zzbgj == null || zzqc()) {
            this.zzbye.zza(this.zzbgj, true);
        } else {
            new zza(this.zzbgj.getWebView()).execute(new Void[0]);
        }
    }

    public void zza(AdResponseParcel adResponseParcel) {
        zza(adResponseParcel, new zzlv(this, this.zzbgj, adResponseParcel.zzccj));
    }

    public void zza(AdResponseParcel adResponseParcel, zzlv zzlvVar) {
        this.zzbgj.setWebViewClient(zzlvVar);
        this.zzbgj.loadDataWithBaseURL(TextUtils.isEmpty(adResponseParcel.zzbts) ? null : com.google.android.gms.ads.internal.zzu.zzfq().zzcp(adResponseParcel.zzbts), adResponseParcel.body, "text/html", "UTF-8", null);
    }

    public void zzqa() {
        this.zzbyb.postDelayed(this, this.zzbyc);
    }

    public synchronized void zzqb() {
        this.zzbyf = true;
    }

    public synchronized boolean zzqc() {
        return this.zzbyf;
    }

    public boolean zzqd() {
        return this.zzbyg;
    }
}
