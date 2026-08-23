package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class AdRequestInfoParcel extends AbstractSafeParcelable {
    public static final zzf CREATOR = new zzf();
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final String zzaor;
    public final String zzaos;
    public final VersionInfoParcel zzaou;
    public final AdSizeParcel zzaoy;
    public final NativeAdOptionsParcel zzapm;
    public final List<String> zzapq;
    public final boolean zzbnu;
    public final Bundle zzcau;
    public final AdRequestParcel zzcav;
    public final PackageInfo zzcaw;
    public final String zzcax;
    public final String zzcay;
    public final String zzcaz;
    public final Bundle zzcba;
    public final int zzcbb;
    public final Bundle zzcbc;
    public final boolean zzcbd;
    public final Messenger zzcbe;
    public final int zzcbf;
    public final int zzcbg;
    public final float zzcbh;
    public final String zzcbi;
    public final long zzcbj;
    public final String zzcbk;
    public final List<String> zzcbl;
    public final List<String> zzcbm;
    public final long zzcbn;
    public final CapabilityParcel zzcbo;
    public final String zzcbp;
    public final float zzcbq;
    public final int zzcbr;
    public final int zzcbs;
    public final boolean zzcbt;
    public final boolean zzcbu;
    public final String zzcbv;
    public final boolean zzcbw;
    public final String zzcbx;
    public final int zzcby;
    public final Bundle zzcbz;

    @zzir
    public static final class zza {
        public final ApplicationInfo applicationInfo;
        public final String zzaor;
        public final String zzaos;
        public final VersionInfoParcel zzaou;
        public final AdSizeParcel zzaoy;
        public final NativeAdOptionsParcel zzapm;
        public final List<String> zzapq;
        public final boolean zzbnu;

        @Nullable
        public final Bundle zzcau;
        public final AdRequestParcel zzcav;

        @Nullable
        public final PackageInfo zzcaw;
        public final String zzcay;
        public final String zzcaz;
        public final Bundle zzcba;
        public final int zzcbb;
        public final Bundle zzcbc;
        public final boolean zzcbd;
        public final Messenger zzcbe;
        public final int zzcbf;
        public final int zzcbg;
        public final float zzcbh;
        public final String zzcbi;
        public final long zzcbj;
        public final String zzcbk;
        public final List<String> zzcbl;
        public final List<String> zzcbm;
        public final CapabilityParcel zzcbo;
        public final String zzcbp;
        public final float zzcbq;
        public final int zzcbr;
        public final int zzcbs;
        public final boolean zzcbt;
        public final boolean zzcbu;
        public final String zzcbv;
        public final boolean zzcbw;
        public final String zzcbx;
        public final int zzcby;
        public final Bundle zzcbz;

        public zza(@Nullable Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo, String str2, String str3, VersionInfoParcel versionInfoParcel, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i, int i2, float f, String str4, long j, String str5, List<String> list3, String str6, NativeAdOptionsParcel nativeAdOptionsParcel, CapabilityParcel capabilityParcel, String str7, float f2, boolean z2, int i3, int i4, boolean z3, boolean z4, String str8, String str9, boolean z5, int i5, Bundle bundle4) {
            this.zzcau = bundle;
            this.zzcav = adRequestParcel;
            this.zzaoy = adSizeParcel;
            this.zzaos = str;
            this.applicationInfo = applicationInfo;
            this.zzcaw = packageInfo;
            this.zzcay = str2;
            this.zzcaz = str3;
            this.zzaou = versionInfoParcel;
            this.zzcba = bundle2;
            this.zzcbd = z;
            this.zzcbe = messenger;
            this.zzcbf = i;
            this.zzcbg = i2;
            this.zzcbh = f;
            if (list == null || list.size() <= 0) {
                if (adSizeParcel.zzauu) {
                    this.zzcbb = 4;
                } else {
                    this.zzcbb = 0;
                }
                this.zzapq = null;
                this.zzcbm = null;
            } else {
                this.zzcbb = 3;
                this.zzapq = list;
                this.zzcbm = list2;
            }
            this.zzcbc = bundle3;
            this.zzcbi = str4;
            this.zzcbj = j;
            this.zzcbk = str5;
            this.zzcbl = list3;
            this.zzaor = str6;
            this.zzapm = nativeAdOptionsParcel;
            this.zzcbo = capabilityParcel;
            this.zzcbp = str7;
            this.zzcbq = f2;
            this.zzcbw = z2;
            this.zzcbr = i3;
            this.zzcbs = i4;
            this.zzcbt = z3;
            this.zzcbu = z4;
            this.zzcbv = str8;
            this.zzcbx = str9;
            this.zzbnu = z5;
            this.zzcby = i5;
            this.zzcbz = bundle4;
        }
    }

    AdRequestInfoParcel(int i, Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list3, long j2, CapabilityParcel capabilityParcel, String str8, float f2, boolean z2, int i5, int i6, boolean z3, boolean z4, String str9, String str10, boolean z5, int i7, Bundle bundle4) {
        this.versionCode = i;
        this.zzcau = bundle;
        this.zzcav = adRequestParcel;
        this.zzaoy = adSizeParcel;
        this.zzaos = str;
        this.applicationInfo = applicationInfo;
        this.zzcaw = packageInfo;
        this.zzcax = str2;
        this.zzcay = str3;
        this.zzcaz = str4;
        this.zzaou = versionInfoParcel;
        this.zzcba = bundle2;
        this.zzcbb = i2;
        this.zzapq = list;
        this.zzcbm = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzcbc = bundle3;
        this.zzcbd = z;
        this.zzcbe = messenger;
        this.zzcbf = i3;
        this.zzcbg = i4;
        this.zzcbh = f;
        this.zzcbi = str5;
        this.zzcbj = j;
        this.zzcbk = str6;
        this.zzcbl = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzaor = str7;
        this.zzapm = nativeAdOptionsParcel;
        this.zzcbn = j2;
        this.zzcbo = capabilityParcel;
        this.zzcbp = str8;
        this.zzcbq = f2;
        this.zzcbw = z2;
        this.zzcbr = i5;
        this.zzcbs = i6;
        this.zzcbt = z3;
        this.zzcbu = z4;
        this.zzcbv = str9;
        this.zzcbx = str10;
        this.zzbnu = z5;
        this.zzcby = i7;
        this.zzcbz = bundle4;
    }

    public AdRequestInfoParcel(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i2, int i3, float f, String str5, long j, String str6, List<String> list3, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, long j2, CapabilityParcel capabilityParcel, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4) {
        this(18, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i, list, bundle3, z, messenger, i2, i3, f, str5, j, str6, list3, str7, nativeAdOptionsParcel, list2, j2, capabilityParcel, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4);
    }

    public AdRequestInfoParcel(zza zzaVar, String str, long j) {
        this(zzaVar.zzcau, zzaVar.zzcav, zzaVar.zzaoy, zzaVar.zzaos, zzaVar.applicationInfo, zzaVar.zzcaw, str, zzaVar.zzcay, zzaVar.zzcaz, zzaVar.zzaou, zzaVar.zzcba, zzaVar.zzcbb, zzaVar.zzapq, zzaVar.zzcbm, zzaVar.zzcbc, zzaVar.zzcbd, zzaVar.zzcbe, zzaVar.zzcbf, zzaVar.zzcbg, zzaVar.zzcbh, zzaVar.zzcbi, zzaVar.zzcbj, zzaVar.zzcbk, zzaVar.zzcbl, zzaVar.zzaor, zzaVar.zzapm, j, zzaVar.zzcbo, zzaVar.zzcbp, zzaVar.zzcbq, zzaVar.zzcbw, zzaVar.zzcbr, zzaVar.zzcbs, zzaVar.zzcbt, zzaVar.zzcbu, zzaVar.zzcbv, zzaVar.zzcbx, zzaVar.zzbnu, zzaVar.zzcby, zzaVar.zzcbz);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
