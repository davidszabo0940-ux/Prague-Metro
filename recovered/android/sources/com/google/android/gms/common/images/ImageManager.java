package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzrh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class ImageManager {

    /* JADX INFO: renamed from: wf */
    private static final Object f204wf = new Object();

    /* JADX INFO: renamed from: wg */
    private static HashSet<Uri> f205wg = new HashSet<>();

    /* JADX INFO: renamed from: wh */
    private static ImageManager f206wh;

    /* JADX INFO: renamed from: wi */
    private static ImageManager f207wi;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: wj */
    private final ExecutorService f208wj = Executors.newFixedThreadPool(4);

    /* JADX INFO: renamed from: wk */
    private final zzb f209wk;

    /* JADX INFO: renamed from: wl */
    private final zzrh f210wl;

    /* JADX INFO: renamed from: wm */
    private final Map<com.google.android.gms.common.images.zza, ImageReceiver> f211wm;

    /* JADX INFO: renamed from: wn */
    private final Map<Uri, ImageReceiver> f212wn;

    /* JADX INFO: renamed from: wo */
    private final Map<Uri, Long> f213wo;

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;

        /* JADX INFO: renamed from: wp */
        private final ArrayList<com.google.android.gms.common.images.zza> f214wp;

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.f214wp = new ArrayList<>();
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.f208wj.execute(ImageManager.this.new zzc(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzarl() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }

        public void zzb(com.google.android.gms.common.images.zza zzaVar) {
            com.google.android.gms.common.internal.zzb.zzhj("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f214wp.add(zzaVar);
        }

        public void zzc(com.google.android.gms.common.images.zza zzaVar) {
            com.google.android.gms.common.internal.zzb.zzhj("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f214wp.remove(zzaVar);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    @TargetApi(11)
    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private static final class zzb extends LruCache<com.google.android.gms.common.images.zza.C0742zza, Bitmap> {
        public zzb(Context context) {
            super(zzcc(context));
        }

        @TargetApi(11)
        private static int zzcc(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((((context.getApplicationInfo().flags & 1048576) != 0) && zzs.zzavj()) ? zza.zza(activityManager) : activityManager.getMemoryClass()) * 1048576 * 0.33f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.util.LruCache
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public int sizeOf(com.google.android.gms.common.images.zza.C0742zza c0742zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.util.LruCache
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z, com.google.android.gms.common.images.zza.C0742zza c0742zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c0742zza, bitmap, bitmap2);
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;

        /* JADX INFO: renamed from: wr */
        private final ParcelFileDescriptor f217wr;

        public zzc(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.f217wr = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.common.internal.zzb.zzhk("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmapDecodeFileDescriptor = null;
            if (this.f217wr != null) {
                try {
                    bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(this.f217wr.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String strValueOf = String.valueOf(this.mUri);
                    Log.e("ImageManager", new StringBuilder(String.valueOf(strValueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(strValueOf).toString(), e);
                    z = true;
                }
                try {
                    this.f217wr.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(ImageManager.this.new zzf(this.mUri, bitmapDecodeFileDescriptor, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                String strValueOf2 = String.valueOf(this.mUri);
                Log.w("ImageManager", new StringBuilder(String.valueOf(strValueOf2).length() + 32).append("Latch interrupted while posting ").append(strValueOf2).toString());
            }
        }
    }

    private final class zzd implements Runnable {

        /* JADX INFO: renamed from: ws */
        private final com.google.android.gms.common.images.zza f219ws;

        public zzd(com.google.android.gms.common.images.zza zzaVar) {
            this.f219ws = zzaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.common.internal.zzb.zzhj("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f211wm.get(this.f219ws);
            if (imageReceiver != null) {
                ImageManager.this.f211wm.remove(this.f219ws);
                imageReceiver.zzc(this.f219ws);
            }
            com.google.android.gms.common.images.zza.C0742zza c0742zza = this.f219ws.f225wu;
            if (c0742zza.uri == null) {
                this.f219ws.zza(ImageManager.this.mContext, ImageManager.this.f210wl, true);
                return;
            }
            Bitmap bitmapZza = ImageManager.this.zza(c0742zza);
            if (bitmapZza != null) {
                this.f219ws.zza(ImageManager.this.mContext, bitmapZza, true);
                return;
            }
            Long l = (Long) ImageManager.this.f213wo.get(c0742zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.f219ws.zza(ImageManager.this.mContext, ImageManager.this.f210wl, true);
                    return;
                }
                ImageManager.this.f213wo.remove(c0742zza.uri);
            }
            this.f219ws.zza(ImageManager.this.mContext, ImageManager.this.f210wl);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.f212wn.get(c0742zza.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = ImageManager.this.new ImageReceiver(c0742zza.uri);
                ImageManager.this.f212wn.put(c0742zza.uri, imageReceiver2);
            }
            imageReceiver2.zzb(this.f219ws);
            if (!(this.f219ws instanceof com.google.android.gms.common.images.zza.zzc)) {
                ImageManager.this.f211wm.put(this.f219ws, imageReceiver2);
            }
            synchronized (ImageManager.f204wf) {
                if (!ImageManager.f205wg.contains(c0742zza.uri)) {
                    ImageManager.f205wg.add(c0742zza.uri);
                    imageReceiver2.zzarl();
                }
            }
        }
    }

    @TargetApi(14)
    private static final class zze implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: wk */
        private final zzb f220wk;

        public zze(zzb zzbVar) {
            this.f220wk = zzbVar;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            this.f220wk.evictAll();
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            if (i >= 60) {
                this.f220wk.evictAll();
            } else if (i >= 20) {
                this.f220wk.trimToSize(this.f220wk.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;

        /* JADX INFO: renamed from: wt */
        private boolean f222wt;
        private final CountDownLatch zzalc;

        public zzf(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.f222wt = z;
            this.zzalc = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList arrayList = imageReceiver.f214wp;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.google.android.gms.common.images.zza zzaVar = (com.google.android.gms.common.images.zza) arrayList.get(i);
                if (z) {
                    zzaVar.zza(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    ImageManager.this.f213wo.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zzaVar.zza(ImageManager.this.mContext, ImageManager.this.f210wl, false);
                }
                if (!(zzaVar instanceof com.google.android.gms.common.images.zza.zzc)) {
                    ImageManager.this.f211wm.remove(zzaVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.common.internal.zzb.zzhj("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.f209wk != null) {
                if (this.f222wt) {
                    ImageManager.this.f209wk.evictAll();
                    System.gc();
                    this.f222wt = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                }
                if (z) {
                    ImageManager.this.f209wk.put(new com.google.android.gms.common.images.zza.C0742zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f212wn.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzalc.countDown();
            synchronized (ImageManager.f204wf) {
                ImageManager.f205wg.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        if (z) {
            this.f209wk = new zzb(this.mContext);
            if (zzs.zzavm()) {
                zzarj();
            }
        } else {
            this.f209wk = null;
        }
        this.f210wl = new zzrh();
        this.f211wm = new HashMap();
        this.f212wn = new HashMap();
        this.f213wo = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzg(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap zza(com.google.android.gms.common.images.zza.C0742zza c0742zza) {
        if (this.f209wk == null) {
            return null;
        }
        return this.f209wk.get(c0742zza);
    }

    @TargetApi(14)
    private void zzarj() {
        this.mContext.registerComponentCallbacks(new zze(this.f209wk));
    }

    public static ImageManager zzg(Context context, boolean z) {
        if (z) {
            if (f207wi == null) {
                f207wi = new ImageManager(context, true);
            }
            return f207wi;
        }
        if (f206wh == null) {
            f206wh = new ImageManager(context, false);
        }
        return f206wh;
    }

    public void loadImage(ImageView imageView, int i) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        com.google.android.gms.common.images.zza.zzb zzbVar = new com.google.android.gms.common.images.zza.zzb(imageView, uri);
        zzbVar.zzfu(i);
        zza(zzbVar);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        com.google.android.gms.common.images.zza.zzc zzcVar = new com.google.android.gms.common.images.zza.zzc(onImageLoadedListener, uri);
        zzcVar.zzfu(i);
        zza(zzcVar);
    }

    public void zza(com.google.android.gms.common.images.zza zzaVar) {
        com.google.android.gms.common.internal.zzb.zzhj("ImageManager.loadImage() must be called in the main thread");
        new zzd(zzaVar).run();
    }
}
