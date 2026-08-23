package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;

/* JADX INFO: loaded from: classes.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private final int zzaie;
    private final int zzaif;
    private final String zzaig;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");

    /* JADX WARN: Illegal instructions before constructor call */
    public AdSize(int i, int i2) {
        String strValueOf = i == -1 ? "FULL" : String.valueOf(i);
        String strValueOf2 = i2 == -2 ? "AUTO" : String.valueOf(i2);
        String strValueOf3 = String.valueOf("_as");
        this(i, i2, new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length()).append(strValueOf).append("x").append(strValueOf2).append(strValueOf3).toString());
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException(new StringBuilder(37).append("Invalid width for AdSize: ").append(i).toString());
        }
        if (i2 < 0 && i2 != -2 && i2 != -4) {
            throw new IllegalArgumentException(new StringBuilder(38).append("Invalid height for AdSize: ").append(i2).toString());
        }
        this.zzaie = i;
        this.zzaif = i2;
        this.zzaig = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.zzaie == adSize.zzaie && this.zzaif == adSize.zzaif && this.zzaig.equals(adSize.zzaig);
    }

    public int getHeight() {
        return this.zzaif;
    }

    public int getHeightInPixels(Context context) {
        switch (this.zzaif) {
            case -4:
            case -3:
                return -1;
            case -2:
                return AdSizeParcel.zzb(context.getResources().getDisplayMetrics());
            default:
                return zzm.zziw().zza(context, this.zzaif);
        }
    }

    public int getWidth() {
        return this.zzaie;
    }

    public int getWidthInPixels(Context context) {
        switch (this.zzaie) {
            case -4:
            case -3:
                return -1;
            case -2:
            default:
                return zzm.zziw().zza(context, this.zzaie);
            case -1:
                return AdSizeParcel.zza(context.getResources().getDisplayMetrics());
        }
    }

    public int hashCode() {
        return this.zzaig.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzaif == -2;
    }

    public boolean isFluid() {
        return this.zzaie == -3 && this.zzaif == -4;
    }

    public boolean isFullWidth() {
        return this.zzaie == -1;
    }

    public String toString() {
        return this.zzaig;
    }
}
