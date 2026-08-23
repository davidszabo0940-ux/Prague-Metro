package com.unity3d.player;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.NativeActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes.dex */
public class UnityPlayer extends FrameLayout implements C0689a.a {

    /* JADX INFO: renamed from: D */
    private static Lock f882D;
    public static Activity currentActivity = null;

    /* JADX INFO: renamed from: p */
    private static boolean f883p;

    /* JADX INFO: renamed from: A */
    private ProgressBar f884A;

    /* JADX INFO: renamed from: B */
    private Runnable f885B;

    /* JADX INFO: renamed from: C */
    private Runnable f886C;

    /* JADX INFO: renamed from: a */
    C0687b f887a;

    /* JADX INFO: renamed from: b */
    DialogC0707s f888b;

    /* JADX INFO: renamed from: c */
    private boolean f889c;

    /* JADX INFO: renamed from: d */
    private boolean f890d;

    /* JADX INFO: renamed from: e */
    private boolean f891e;

    /* JADX INFO: renamed from: f */
    private final InterfaceC0698j f892f;

    /* JADX INFO: renamed from: g */
    private final C0708t f893g;

    /* JADX INFO: renamed from: h */
    private boolean f894h;

    /* JADX INFO: renamed from: i */
    private C0710v f895i;

    /* JADX INFO: renamed from: j */
    private final ConcurrentLinkedQueue f896j;

    /* JADX INFO: renamed from: k */
    private BroadcastReceiver f897k;

    /* JADX INFO: renamed from: l */
    private boolean f898l;

    /* JADX INFO: renamed from: m */
    private ContextWrapper f899m;

    /* JADX INFO: renamed from: n */
    private SurfaceView f900n;

    /* JADX INFO: renamed from: o */
    private WindowManager f901o;

    /* JADX INFO: renamed from: q */
    private boolean f902q;

    /* JADX INFO: renamed from: r */
    private boolean f903r;

    /* JADX INFO: renamed from: s */
    private int f904s;

    /* JADX INFO: renamed from: t */
    private int f905t;

    /* JADX INFO: renamed from: u */
    private final C0706r f906u;

    /* JADX INFO: renamed from: v */
    private String f907v;

    /* JADX INFO: renamed from: w */
    private NetworkInfo f908w;

    /* JADX INFO: renamed from: x */
    private Bundle f909x;

    /* JADX INFO: renamed from: y */
    private List f910y;

    /* JADX INFO: renamed from: z */
    private SurfaceHolderCallbackC0711w f911z;

    /* JADX INFO: renamed from: com.unity3d.player.UnityPlayer$3 */
    class C06793 extends BroadcastReceiver {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ UnityPlayer f943a;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.f943a.m118b();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.player.UnityPlayer$a */
    enum EnumC0686a {
        PAUSE,
        RESUME,
        QUIT,
        FOCUS_GAINED,
        FOCUS_LOST
    }

    /* JADX INFO: renamed from: com.unity3d.player.UnityPlayer$b */
    private class C0687b extends Thread {

        /* JADX INFO: renamed from: b */
        boolean f968b = false;

        /* JADX INFO: renamed from: a */
        ArrayBlockingQueue f967a = new ArrayBlockingQueue(32);

        C0687b() {
        }

        /* JADX INFO: renamed from: a */
        private void m148a(EnumC0686a enumC0686a) {
            try {
                this.f967a.put(enumC0686a);
            } catch (InterruptedException e) {
                interrupt();
            }
        }

        /* JADX INFO: renamed from: a */
        public final void m149a() {
            m148a(EnumC0686a.QUIT);
        }

        /* JADX INFO: renamed from: a */
        public final void m150a(boolean z) {
            m148a(z ? EnumC0686a.FOCUS_GAINED : EnumC0686a.FOCUS_LOST);
        }

        /* JADX INFO: renamed from: b */
        public final void m151b() {
            m148a(EnumC0686a.RESUME);
        }

        /* JADX INFO: renamed from: c */
        public final void m152c() {
            m148a(EnumC0686a.PAUSE);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            setName("UnityMain");
            while (true) {
                try {
                    EnumC0686a enumC0686a = (EnumC0686a) this.f967a.take();
                    if (enumC0686a == EnumC0686a.QUIT) {
                        return;
                    }
                    if (enumC0686a == EnumC0686a.RESUME) {
                        this.f968b = true;
                    } else if (enumC0686a == EnumC0686a.PAUSE) {
                        this.f968b = false;
                        UnityPlayer.this.executeGLThreadJobs();
                    } else if (enumC0686a == EnumC0686a.FOCUS_LOST && !this.f968b) {
                        UnityPlayer.this.executeGLThreadJobs();
                    }
                    if (this.f968b) {
                        do {
                            UnityPlayer.this.executeGLThreadJobs();
                            if (this.f967a.peek() != null) {
                                break;
                            } else if (!UnityPlayer.this.isFinishing() && !UnityPlayer.this.nativeRender()) {
                                UnityPlayer.this.m118b();
                            }
                        } while (!interrupted());
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.unity3d.player.UnityPlayer$c */
    private abstract class AbstractRunnableC0688c implements Runnable {
        private AbstractRunnableC0688c() {
        }

        /* synthetic */ AbstractRunnableC0688c(UnityPlayer unityPlayer, byte b) {
            this();
        }

        /* JADX INFO: renamed from: a */
        public abstract void mo147a();

        @Override // java.lang.Runnable
        public final void run() {
            if (UnityPlayer.this.isFinishing()) {
                return;
            }
            mo147a();
        }
    }

    static {
        new C0709u().m225a();
        f883p = false;
        f883p = loadLibraryStatic("main");
        f882D = new ReentrantLock();
    }

    public UnityPlayer(ContextWrapper contextWrapper) {
        super(contextWrapper);
        this.f889c = false;
        this.f890d = false;
        this.f891e = true;
        this.f894h = false;
        this.f895i = new C0710v();
        this.f896j = new ConcurrentLinkedQueue();
        this.f897k = null;
        this.f898l = false;
        this.f887a = new C0687b();
        this.f903r = true;
        this.f904s = 0;
        this.f905t = 0;
        this.f907v = null;
        this.f908w = null;
        this.f909x = new Bundle();
        this.f910y = new ArrayList();
        this.f888b = null;
        this.f884A = null;
        this.f885B = new Runnable() { // from class: com.unity3d.player.UnityPlayer.2
            @Override // java.lang.Runnable
            public final void run() {
                int iNativeActivityIndicatorStyle = UnityPlayer.this.nativeActivityIndicatorStyle();
                if (iNativeActivityIndicatorStyle >= 0) {
                    if (UnityPlayer.this.f884A == null) {
                        int[] iArr = {R.attr.progressBarStyleLarge, R.attr.progressBarStyleLargeInverse, R.attr.progressBarStyleSmall, R.attr.progressBarStyleSmallInverse};
                        UnityPlayer.this.f884A = new ProgressBar(UnityPlayer.this.f899m, null, iArr[iNativeActivityIndicatorStyle]);
                        UnityPlayer.this.f884A.setIndeterminate(true);
                        UnityPlayer.this.f884A.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 51));
                        UnityPlayer.this.addView(UnityPlayer.this.f884A);
                    }
                    UnityPlayer.this.f884A.setVisibility(0);
                    UnityPlayer.this.bringChildToFront(UnityPlayer.this.f884A);
                }
            }
        };
        this.f886C = new Runnable() { // from class: com.unity3d.player.UnityPlayer.4
            @Override // java.lang.Runnable
            public final void run() {
                if (UnityPlayer.this.f884A != null) {
                    UnityPlayer.this.f884A.setVisibility(8);
                    UnityPlayer.this.removeView(UnityPlayer.this.f884A);
                    UnityPlayer.this.f884A = null;
                }
            }
        };
        if (contextWrapper instanceof Activity) {
            currentActivity = (Activity) contextWrapper;
        }
        this.f893g = new C0708t(this);
        this.f899m = contextWrapper;
        this.f892f = contextWrapper instanceof Activity ? new C0704p(contextWrapper) : null;
        this.f906u = new C0706r(contextWrapper, this);
        m107a();
        if (C0705q.f1037a) {
            C0705q.f1045i.mo174a(this);
        }
        setFullscreen(true);
        m109a(this.f899m.getApplicationInfo());
        if (!C0710v.m228c()) {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this.f899m).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.unity3d.player.UnityPlayer.1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UnityPlayer.this.m118b();
                }
            }).setMessage("Your hardware does not support this application, sorry!").create();
            alertDialogCreate.setCancelable(false);
            alertDialogCreate.show();
            return;
        }
        initJni(contextWrapper);
        nativeFile(this.f899m.getPackageCodePath());
        m136j();
        this.f900n = new SurfaceView(contextWrapper);
        this.f900n.getHolder().setFormat(2);
        this.f900n.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.unity3d.player.UnityPlayer.13
            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                UnityPlayer.this.m108a(0, surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.m108a(0, surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.m108a(0, (Surface) null);
            }
        });
        this.f900n.setFocusable(true);
        this.f900n.setFocusableInTouchMode(true);
        this.f893g.m223c(this.f900n);
        this.f902q = false;
        m122c();
        nativeInitWWW(WWW.class);
        nativeInitWebRequest(UnityWebRequest.class);
        if (C0705q.f1041e) {
            C0705q.f1048l.mo179a(this, this.f899m);
        }
        if (C0705q.f1044h) {
            if (currentActivity != null) {
                C0705q.f1049m.mo183a(currentActivity, new Runnable() { // from class: com.unity3d.player.UnityPlayer.15
                    @Override // java.lang.Runnable
                    public final void run() {
                        UnityPlayer.this.m146b(new Runnable() { // from class: com.unity3d.player.UnityPlayer.15.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                UnityPlayer.this.f895i.m232d();
                                UnityPlayer.this.m131g();
                            }
                        });
                    }
                });
            } else {
                this.f895i.m232d();
            }
        }
        if (C0705q.f1040d) {
            C0705q.f1047k.mo182a(this);
        }
        this.f901o = (WindowManager) this.f899m.getSystemService("window");
        m138k();
        this.f887a.start();
    }

    public static native void UnitySendMessage(String str, String str2, String str3);

    /* JADX INFO: renamed from: a */
    private static String m106a(String str) {
        byte[] bArrDigest;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(str);
            long length = new File(str).length();
            fileInputStream.skip(length - Math.min(length, 65558L));
            byte[] bArr = new byte[1024];
            for (int i = 0; i != -1; i = fileInputStream.read(bArr)) {
                messageDigest.update(bArr, 0, i);
            }
            bArrDigest = messageDigest.digest();
        } catch (FileNotFoundException e) {
            bArrDigest = null;
        } catch (IOException e2) {
            bArrDigest = null;
        } catch (NoSuchAlgorithmException e3) {
            bArrDigest = null;
        }
        if (bArrDigest == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArrDigest) {
            stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    private void m107a() {
        try {
            File file = new File(this.f899m.getPackageCodePath(), "assets/bin/Data/settings.xml");
            InputStream fileInputStream = file.exists() ? new FileInputStream(file) : this.f899m.getAssets().open("bin/Data/settings.xml");
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
            XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
            xmlPullParserNewPullParser.setInput(fileInputStream, null);
            String str = null;
            String name = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType == 2) {
                    name = xmlPullParserNewPullParser.getName();
                    String attributeValue = str;
                    for (int i = 0; i < xmlPullParserNewPullParser.getAttributeCount(); i++) {
                        if (xmlPullParserNewPullParser.getAttributeName(i).equalsIgnoreCase("name")) {
                            attributeValue = xmlPullParserNewPullParser.getAttributeValue(i);
                        }
                    }
                    str = attributeValue;
                } else if (eventType == 3) {
                    name = null;
                } else if (eventType == 4 && str != null) {
                    if (name.equalsIgnoreCase("integer")) {
                        this.f909x.putInt(str, Integer.parseInt(xmlPullParserNewPullParser.getText()));
                    } else if (name.equalsIgnoreCase("string")) {
                        this.f909x.putString(str, xmlPullParserNewPullParser.getText());
                    } else if (name.equalsIgnoreCase("bool")) {
                        this.f909x.putBoolean(str, Boolean.parseBoolean(xmlPullParserNewPullParser.getText()));
                    } else if (name.equalsIgnoreCase("float")) {
                        this.f909x.putFloat(str, Float.parseFloat(xmlPullParserNewPullParser.getText()));
                    }
                    str = null;
                }
            }
        } catch (Exception e) {
            C0701m.Log(6, "Unable to locate player settings. " + e.getLocalizedMessage());
            m118b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m108a(int i, Surface surface) {
        if (this.f889c) {
            return;
        }
        m120b(0, surface);
    }

    /* JADX INFO: renamed from: a */
    private static void m109a(ApplicationInfo applicationInfo) {
        if (f883p && NativeLoader.load(applicationInfo.nativeLibraryDir)) {
            C0710v.m226a();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m110a(AbstractRunnableC0688c abstractRunnableC0688c) {
        if (isFinishing()) {
            return;
        }
        m123c(abstractRunnableC0688c);
    }

    /* JADX INFO: renamed from: a */
    static void m115a(Runnable runnable) {
        new Thread(runnable).start();
    }

    /* JADX INFO: renamed from: a */
    private static String[] m117a(Context context) {
        String packageName = context.getPackageName();
        Vector vector = new Vector();
        try {
            int i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(Environment.getExternalStorageDirectory().toString() + "/Android/obb/" + packageName);
                if (file.exists()) {
                    if (i > 0) {
                        String str = file + File.separator + "main." + i + "." + packageName + ".obb";
                        if (new File(str).isFile()) {
                            vector.add(str);
                        }
                    }
                    if (i > 0) {
                        String str2 = file + File.separator + "patch." + i + "." + packageName + ".obb";
                        if (new File(str2).isFile()) {
                            vector.add(str2);
                        }
                    }
                }
            }
            String[] strArr = new String[vector.size()];
            vector.toArray(strArr);
            return strArr;
        } catch (PackageManager.NameNotFoundException e) {
            return new String[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m118b() {
        if (!(this.f899m instanceof Activity) || ((Activity) this.f899m).isFinishing()) {
            return;
        }
        ((Activity) this.f899m).finish();
    }

    /* JADX INFO: renamed from: b */
    private boolean m120b(int i, Surface surface) {
        if (!C0710v.m228c()) {
            return false;
        }
        nativeRecreateGfxState(i, surface);
        return true;
    }

    /* JADX INFO: renamed from: c */
    private void m122c() {
        C0703o c0703o = new C0703o((Activity) this.f899m);
        if (this.f899m instanceof NativeActivity) {
            boolean zM193a = c0703o.m193a();
            this.f898l = zM193a;
            nativeForwardEventsToDalvik(zM193a);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m123c(Runnable runnable) {
        if (C0710v.m228c()) {
            if (Thread.currentThread() == this.f887a) {
                runnable.run();
            } else {
                this.f896j.add(runnable);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m124d() {
        Iterator it = this.f910y.iterator();
        while (it.hasNext()) {
            ((C0689a) it.next()).m164c();
        }
    }

    /* JADX INFO: renamed from: e */
    private void m126e() {
        for (C0689a c0689a : this.f910y) {
            try {
                c0689a.m161a(this);
            } catch (Exception e) {
                C0701m.Log(6, "Unable to initialize camera: " + e.getMessage());
                c0689a.m164c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m129f() {
        nativeDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m131g() {
        if (this.f895i.m234f()) {
            if (this.f911z != null) {
                this.f911z.onResume();
                return;
            }
            this.f895i.m231c(true);
            m126e();
            this.f906u.m209e();
            this.f907v = null;
            this.f908w = null;
            if (C0710v.m228c()) {
                m136j();
            }
            m123c(new Runnable() { // from class: com.unity3d.player.UnityPlayer.19
                @Override // java.lang.Runnable
                public final void run() {
                    UnityPlayer.this.nativeResume();
                }
            });
            this.f887a.m151b();
        }
    }

    /* JADX INFO: renamed from: h */
    private static void m132h() {
        if (C0710v.m228c()) {
            lockNativeAccess();
            if (!NativeLoader.unload()) {
                unlockNativeAccess();
                throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
            }
            C0710v.m227b();
            unlockNativeAccess();
        }
    }

    /* JADX INFO: renamed from: i */
    private boolean m134i() {
        return this.f899m.getPackageManager().hasSystemFeature("android.hardware.camera") || this.f899m.getPackageManager().hasSystemFeature("android.hardware.camera.front");
    }

    private final native void initJni(Context context);

    /* JADX INFO: renamed from: j */
    private void m136j() {
        if (this.f909x.getBoolean("useObb")) {
            for (String str : m117a(this.f899m)) {
                String strM106a = m106a(str);
                if (this.f909x.getBoolean(strM106a)) {
                    nativeFile(str);
                }
                this.f909x.remove(strM106a);
            }
        }
    }

    /* JADX INFO: renamed from: j */
    static /* synthetic */ boolean m137j(UnityPlayer unityPlayer) {
        unityPlayer.f902q = true;
        return true;
    }

    /* JADX INFO: renamed from: k */
    private void m138k() {
        if (this.f899m instanceof Activity) {
            ((Activity) this.f899m).getWindow().setFlags(1024, 1024);
        }
    }

    protected static boolean loadLibraryStatic(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Exception e) {
            C0701m.Log(6, "Unknown error " + e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            C0701m.Log(6, "Unable to find " + str);
            return false;
        }
    }

    protected static void lockNativeAccess() {
        f882D.lock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native int nativeActivityIndicatorStyle();

    private final native void nativeDone();

    private final native void nativeFile(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeFocusChanged(boolean z);

    private final native void nativeInitWWW(Class cls);

    private final native void nativeInitWebRequest(Class cls);

    private final native boolean nativeInjectEvent(InputEvent inputEvent);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativePause();

    private final native void nativeRecreateGfxState(int i, Surface surface);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativeRender();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeResume();

    private final native void nativeSetExtras(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputCanceled(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputString(String str);

    private final native void nativeSetTouchDeltaY(float f);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputClosed();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeVideoFrameCallback(int i, byte[] bArr, int i2, int i3);

    protected static void unlockNativeAccess() {
        f882D.unlock();
    }

    protected boolean Location_IsServiceEnabledByUser() {
        return this.f906u.m204a();
    }

    protected void Location_SetDesiredAccuracy(float f) {
        this.f906u.m206b(f);
    }

    protected void Location_SetDistanceFilter(float f) {
        this.f906u.m203a(f);
    }

    protected void Location_StartUpdatingLocation() {
        this.f906u.m205b();
    }

    protected void Location_StopUpdatingLocation() {
        this.f906u.m207c();
    }

    /* JADX INFO: renamed from: b */
    final void m146b(Runnable runnable) {
        if (this.f899m instanceof Activity) {
            ((Activity) this.f899m).runOnUiThread(runnable);
        } else {
            C0701m.Log(5, "Not running Unity from an Activity; ignored...");
        }
    }

    protected void closeCamera(int i) {
        for (C0689a c0689a : this.f910y) {
            if (c0689a.m160a() == i) {
                c0689a.m164c();
                this.f910y.remove(c0689a);
                return;
            }
        }
    }

    public void configurationChanged(Configuration configuration) {
        if (this.f900n instanceof SurfaceView) {
            this.f900n.getHolder().setSizeFromLayout();
        }
        if (this.f911z != null) {
            this.f911z.updateVideoLayout();
        }
    }

    protected void disableLogger() {
        C0701m.f1027a = true;
    }

    public boolean displayChanged(int i, Surface surface) {
        if (i == 0) {
            this.f889c = surface != null;
            m146b(new Runnable() { // from class: com.unity3d.player.UnityPlayer.16
                @Override // java.lang.Runnable
                public final void run() {
                    if (UnityPlayer.this.f889c) {
                        UnityPlayer.this.f893g.m224d(UnityPlayer.this.f900n);
                    } else {
                        UnityPlayer.this.f893g.m223c(UnityPlayer.this.f900n);
                    }
                }
            });
        }
        return m120b(i, surface);
    }

    protected void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.f896j.poll();
            if (runnable == null) {
                return;
            } else {
                runnable.run();
            }
        }
    }

    protected void forwardMotionEventToDalvik(long j, long j2, int i, int i2, int[] iArr, float[] fArr, int i3, float f, float f2, int i4, int i5, int i6, int i7, int i8, long[] jArr, float[] fArr2) {
        this.f892f.mo184a(j, j2, i, i2, iArr, fArr, i3, f, f2, i4, i5, i6, i7, i8, jArr, fArr2);
    }

    protected int getCameraOrientation(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        return cameraInfo.orientation;
    }

    protected int getNumCameras() {
        if (m134i()) {
            return Camera.getNumberOfCameras();
        }
        return 0;
    }

    public Bundle getSettings() {
        return this.f909x;
    }

    protected int getSplashMode() {
        return this.f909x.getInt("splash_mode");
    }

    public View getView() {
        return this;
    }

    protected void hideSoftInput() {
        final Runnable runnable = new Runnable() { // from class: com.unity3d.player.UnityPlayer.7
            @Override // java.lang.Runnable
            public final void run() {
                if (UnityPlayer.this.f888b != null) {
                    UnityPlayer.this.f888b.dismiss();
                    UnityPlayer.this.f888b = null;
                }
            }
        };
        if (C0705q.f1043g) {
            m110a(new AbstractRunnableC0688c() { // from class: com.unity3d.player.UnityPlayer.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(UnityPlayer.this, (byte) 0);
                }

                @Override // com.unity3d.player.UnityPlayer.AbstractRunnableC0688c
                /* JADX INFO: renamed from: a */
                public final void mo147a() {
                    UnityPlayer.this.m146b(runnable);
                }
            });
        } else {
            m146b(runnable);
        }
    }

    protected void hideVideoPlayer() {
        m146b(new Runnable() { // from class: com.unity3d.player.UnityPlayer.14
            @Override // java.lang.Runnable
            public final void run() {
                if (UnityPlayer.this.f911z == null) {
                    return;
                }
                UnityPlayer.this.f893g.m223c(UnityPlayer.this.f900n);
                UnityPlayer.this.removeView(UnityPlayer.this.f911z);
                UnityPlayer.this.f911z = null;
                UnityPlayer.this.resume();
            }
        });
    }

    public void init(int i, boolean z) {
    }

    protected int[] initCamera(int i, int i2, int i3, int i4) {
        C0689a c0689a = new C0689a(i, i2, i3, i4);
        try {
            c0689a.m161a(this);
            this.f910y.add(c0689a);
            Camera.Size sizeM163b = c0689a.m163b();
            return new int[]{sizeM163b.width, sizeM163b.height};
        } catch (Exception e) {
            C0701m.Log(6, "Unable to initialize camera: " + e.getMessage());
            c0689a.m164c();
            return null;
        }
    }

    public boolean injectEvent(InputEvent inputEvent) {
        return nativeInjectEvent(inputEvent);
    }

    protected boolean installPresentationDisplay(int i) {
        if (C0705q.f1041e) {
            return C0705q.f1048l.mo180a(this, this.f899m, i);
        }
        return false;
    }

    protected boolean isCameraFrontFacing(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        return cameraInfo.facing == 1;
    }

    protected boolean isFinishing() {
        if (!this.f902q) {
            boolean z = (this.f899m instanceof Activity) && ((Activity) this.f899m).isFinishing();
            this.f902q = z;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    protected void kill() {
        Process.killProcess(Process.myPid());
    }

    protected boolean loadLibrary(String str) {
        return loadLibraryStatic(str);
    }

    protected final native void nativeAddVSyncTime(long j);

    final native void nativeForwardEventsToDalvik(boolean z);

    protected native void nativeSetLocation(float f, float f2, float f3, float f4, double d, float f5);

    protected native void nativeSetLocationStatus(int i);

    @Override // com.unity3d.player.C0689a.a
    public void onCameraFrame(final C0689a c0689a, final byte[] bArr) {
        final int iM160a = c0689a.m160a();
        final Camera.Size sizeM163b = c0689a.m163b();
        m110a(new AbstractRunnableC0688c() { // from class: com.unity3d.player.UnityPlayer.11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(UnityPlayer.this, (byte) 0);
            }

            @Override // com.unity3d.player.UnityPlayer.AbstractRunnableC0688c
            /* JADX INFO: renamed from: a */
            public final void mo147a() {
                UnityPlayer.this.nativeVideoFrameCallback(iM160a, bArr, sizeM163b.width, sizeM163b.height);
                c0689a.m162a(bArr);
            }
        });
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public void pause() {
        if (this.f911z != null) {
            this.f911z.onPause();
            return;
        }
        reportSoftInputStr(null, 1, true);
        if (this.f895i.m235g()) {
            if (C0710v.m228c()) {
                final Semaphore semaphore = new Semaphore(0);
                if (isFinishing()) {
                    m123c(new Runnable() { // from class: com.unity3d.player.UnityPlayer.17
                        @Override // java.lang.Runnable
                        public final void run() {
                            UnityPlayer.this.m129f();
                            semaphore.release();
                        }
                    });
                } else {
                    m123c(new Runnable() { // from class: com.unity3d.player.UnityPlayer.18
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (!UnityPlayer.this.nativePause()) {
                                semaphore.release();
                                return;
                            }
                            UnityPlayer.m137j(UnityPlayer.this);
                            UnityPlayer.this.m129f();
                            semaphore.release(2);
                        }
                    });
                }
                try {
                    if (!semaphore.tryAcquire(4L, TimeUnit.SECONDS)) {
                        C0701m.Log(5, "Timeout while trying to pause the Unity Engine.");
                    }
                } catch (InterruptedException e) {
                    C0701m.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
                }
                if (semaphore.drainPermits() > 0) {
                    quit();
                }
            }
            this.f895i.m231c(false);
            this.f895i.m230b(true);
            m124d();
            this.f887a.m152c();
            this.f906u.m208d();
        }
    }

    public void quit() {
        this.f902q = true;
        if (!this.f895i.m233e()) {
            pause();
        }
        this.f887a.m149a();
        try {
            this.f887a.join(4000L);
        } catch (InterruptedException e) {
            this.f887a.interrupt();
        }
        if (this.f897k != null) {
            this.f899m.unregisterReceiver(this.f897k);
        }
        this.f897k = null;
        if (C0710v.m228c()) {
            removeAllViews();
        }
        if (C0705q.f1041e) {
            C0705q.f1048l.mo178a(this.f899m);
        }
        if (C0705q.f1040d) {
            C0705q.f1047k.mo181a();
        }
        kill();
        m132h();
    }

    protected void reportSoftInputStr(final String str, final int i, final boolean z) {
        if (i == 1) {
            hideSoftInput();
        }
        m110a(new AbstractRunnableC0688c() { // from class: com.unity3d.player.UnityPlayer.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(UnityPlayer.this, (byte) 0);
            }

            @Override // com.unity3d.player.UnityPlayer.AbstractRunnableC0688c
            /* JADX INFO: renamed from: a */
            public final void mo147a() {
                if (z) {
                    UnityPlayer.this.nativeSetInputCanceled(true);
                } else if (str != null) {
                    UnityPlayer.this.nativeSetInputString(str);
                }
                if (i == 1) {
                    UnityPlayer.this.nativeSoftInputClosed();
                }
            }
        });
    }

    public void resume() {
        if (C0705q.f1037a) {
            C0705q.f1045i.mo177b(this);
        }
        this.f895i.m230b(false);
        m131g();
    }

    protected void setFullscreen(final boolean z) {
        this.f891e = z;
        if (C0705q.f1037a) {
            m146b(new Runnable() { // from class: com.unity3d.player.UnityPlayer.5
                @Override // java.lang.Runnable
                public final void run() {
                    C0705q.f1045i.mo175a(UnityPlayer.this, z);
                }
            });
        }
    }

    protected void setSoftInputStr(final String str) {
        m146b(new Runnable() { // from class: com.unity3d.player.UnityPlayer.9
            @Override // java.lang.Runnable
            public final void run() {
                if (UnityPlayer.this.f888b == null || str == null) {
                    return;
                }
                UnityPlayer.this.f888b.m217a(str);
            }
        });
    }

    protected void showSoftInput(final String str, final int i, final boolean z, final boolean z2, final boolean z3, final boolean z4, final String str2) {
        m146b(new Runnable() { // from class: com.unity3d.player.UnityPlayer.6
            @Override // java.lang.Runnable
            public final void run() {
                UnityPlayer.this.f888b = new DialogC0707s(UnityPlayer.this.f899m, this, str, i, z, z2, z3, str2);
                UnityPlayer.this.f888b.show();
            }
        });
    }

    protected void showVideoPlayer(final String str, final int i, final int i2, final int i3, final boolean z, final int i4, final int i5) {
        m146b(new Runnable() { // from class: com.unity3d.player.UnityPlayer.12
            @Override // java.lang.Runnable
            public final void run() {
                if (UnityPlayer.this.f911z != null) {
                    return;
                }
                UnityPlayer.this.pause();
                UnityPlayer.this.f911z = new SurfaceHolderCallbackC0711w(UnityPlayer.this, UnityPlayer.this.f899m, str, i, i2, i3, z, i4, i5);
                UnityPlayer.this.addView(UnityPlayer.this.f911z);
                UnityPlayer.this.f911z.requestFocus();
                UnityPlayer.this.f893g.m224d(UnityPlayer.this.f900n);
            }
        });
    }

    protected void startActivityIndicator() {
        m146b(this.f885B);
    }

    protected void stopActivityIndicator() {
        m146b(this.f886C);
    }

    public void windowFocusChanged(final boolean z) {
        this.f895i.m229a(z);
        if (z && this.f888b != null) {
            reportSoftInputStr(null, 1, false);
        }
        if (C0705q.f1037a && z) {
            C0705q.f1045i.mo177b(this);
        }
        m123c(new Runnable() { // from class: com.unity3d.player.UnityPlayer.20
            @Override // java.lang.Runnable
            public final void run() {
                UnityPlayer.this.nativeFocusChanged(z);
            }
        });
        this.f887a.m150a(z);
        m131g();
    }
}
