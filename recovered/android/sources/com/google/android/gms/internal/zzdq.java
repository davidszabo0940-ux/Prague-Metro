package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzdq implements zzapj {
    private CustomTabsSession zzbem;
    private CustomTabsClient zzben;
    private CustomTabsServiceConnection zzbeo;
    private zza zzbep;

    public interface zza {
        void zzkn();

        void zzko();
    }

    public static boolean zzo(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (listQueryIntentActivities == null || resolveInfoResolveActivity == null) {
            return false;
        }
        for (int i = 0; i < listQueryIntentActivities.size(); i++) {
            if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i).activityInfo.name)) {
                return resolveInfoResolveActivity.activityInfo.packageName.equals(zzaph.zzeu(context));
            }
        }
        return false;
    }

    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        CustomTabsSession customTabsSessionZzkl;
        if (this.zzben == null || (customTabsSessionZzkl = zzkl()) == null) {
            return false;
        }
        return customTabsSessionZzkl.mayLaunchUrl(uri, bundle, list);
    }

    @Override // com.google.android.gms.internal.zzapj
    public void zza(CustomTabsClient customTabsClient) {
        this.zzben = customTabsClient;
        this.zzben.warmup(0L);
        if (this.zzbep != null) {
            this.zzbep.zzkn();
        }
    }

    public void zza(zza zzaVar) {
        this.zzbep = zzaVar;
    }

    public void zzd(Activity activity) {
        if (this.zzbeo == null) {
            return;
        }
        activity.unbindService(this.zzbeo);
        this.zzben = null;
        this.zzbem = null;
        this.zzbeo = null;
    }

    public void zze(Activity activity) {
        String strZzeu;
        if (this.zzben == null && (strZzeu = zzaph.zzeu(activity)) != null) {
            this.zzbeo = new zzapi(this);
            CustomTabsClient.bindCustomTabsService(activity, strZzeu, this.zzbeo);
        }
    }

    public CustomTabsSession zzkl() {
        if (this.zzben == null) {
            this.zzbem = null;
        } else if (this.zzbem == null) {
            this.zzbem = this.zzben.newSession((CustomTabsCallback) null);
        }
        return this.zzbem;
    }

    @Override // com.google.android.gms.internal.zzapj
    public void zzkm() {
        this.zzben = null;
        this.zzbem = null;
        if (this.zzbep != null) {
            this.zzbep.zzko();
        }
    }
}
