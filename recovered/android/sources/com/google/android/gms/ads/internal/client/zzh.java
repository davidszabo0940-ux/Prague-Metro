package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzir;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzh {
    public static final zzh zzauo = new zzh();

    protected zzh() {
    }

    public static zzh zzih() {
        return zzauo;
    }

    public AdRequestParcel zza(Context context, zzad zzadVar) {
        Date birthday = zzadVar.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1L;
        String contentUrl = zzadVar.getContentUrl();
        int gender = zzadVar.getGender();
        Set<String> keywords = zzadVar.getKeywords();
        List listUnmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean zIsTestDevice = zzadVar.isTestDevice(context);
        int iZzji = zzadVar.zzji();
        Location location = zzadVar.getLocation();
        Bundle networkExtrasBundle = zzadVar.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzadVar.getManualImpressionsEnabled();
        String publisherProvidedId = zzadVar.getPublisherProvidedId();
        SearchAdRequest searchAdRequestZzjf = zzadVar.zzjf();
        SearchAdRequestParcel searchAdRequestParcel = searchAdRequestZzjf != null ? new SearchAdRequestParcel(searchAdRequestZzjf) : null;
        String strZza = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            strZza = zzm.zziw().zza(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        return new AdRequestParcel(7, time, networkExtrasBundle, gender, listUnmodifiableList, zIsTestDevice, iZzji, manualImpressionsEnabled, publisherProvidedId, searchAdRequestParcel, location, contentUrl, zzadVar.zzjh(), zzadVar.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzadVar.zzjj())), zzadVar.zzje(), strZza, zzadVar.isDesignedForFamilies());
    }

    public RewardedVideoAdRequestParcel zza(Context context, zzad zzadVar, String str) {
        return new RewardedVideoAdRequestParcel(zza(context, zzadVar), str);
    }
}
