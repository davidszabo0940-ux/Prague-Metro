package com.unity3d.player;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* JADX INFO: renamed from: com.unity3d.player.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0703o {

    /* JADX INFO: renamed from: a */
    private final Bundle f1032a;

    public C0703o(Activity activity) {
        Bundle bundle = Bundle.EMPTY;
        PackageManager packageManager = activity.getPackageManager();
        ComponentName componentName = activity.getComponentName();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            if (activityInfo != null && activityInfo.metaData != null) {
                bundle = activityInfo.metaData;
            }
        } catch (PackageManager.NameNotFoundException e) {
            C0701m.Log(6, "Unable to retreive meta data for activity '" + componentName + "'");
        }
        this.f1032a = new Bundle(bundle);
    }

    /* JADX INFO: renamed from: a */
    private static String m192a(String str) {
        return String.format("%s.%s", "unityplayer", str);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m193a() {
        return this.f1032a.getBoolean(m192a("ForwardNativeEventsToDalvik"));
    }
}
