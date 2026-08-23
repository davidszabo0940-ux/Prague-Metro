package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzir;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzf {
    private Bundle mExtras;
    private boolean zzakp;
    private long zzaua;
    private int zzaub;
    private List<String> zzauc;
    private boolean zzaud;
    private int zzaue;
    private String zzauf;
    private SearchAdRequestParcel zzaug;
    private String zzauh;
    private Bundle zzaui;
    private Bundle zzauj;
    private List<String> zzauk;
    private String zzaul;
    private String zzaum;
    private boolean zzaun;
    private Location zzft;

    public zzf() {
        this.zzaua = -1L;
        this.mExtras = new Bundle();
        this.zzaub = -1;
        this.zzauc = new ArrayList();
        this.zzaud = false;
        this.zzaue = -1;
        this.zzakp = false;
        this.zzauf = null;
        this.zzaug = null;
        this.zzft = null;
        this.zzauh = null;
        this.zzaui = new Bundle();
        this.zzauj = new Bundle();
        this.zzauk = new ArrayList();
        this.zzaul = null;
        this.zzaum = null;
        this.zzaun = false;
    }

    public zzf(AdRequestParcel adRequestParcel) {
        this.zzaua = adRequestParcel.zzatk;
        this.mExtras = adRequestParcel.extras;
        this.zzaub = adRequestParcel.zzatl;
        this.zzauc = adRequestParcel.zzatm;
        this.zzaud = adRequestParcel.zzatn;
        this.zzaue = adRequestParcel.zzato;
        this.zzakp = adRequestParcel.zzatp;
        this.zzauf = adRequestParcel.zzatq;
        this.zzaug = adRequestParcel.zzatr;
        this.zzft = adRequestParcel.zzats;
        this.zzauh = adRequestParcel.zzatt;
        this.zzaui = adRequestParcel.zzatu;
        this.zzauj = adRequestParcel.zzatv;
        this.zzauk = adRequestParcel.zzatw;
        this.zzaul = adRequestParcel.zzatx;
        this.zzaum = adRequestParcel.zzaty;
    }

    public zzf zza(@Nullable Location location) {
        this.zzft = location;
        return this;
    }

    public zzf zzc(Bundle bundle) {
        this.zzaui = bundle;
        return this;
    }

    public AdRequestParcel zzig() {
        return new AdRequestParcel(7, this.zzaua, this.mExtras, this.zzaub, this.zzauc, this.zzaud, this.zzaue, this.zzakp, this.zzauf, this.zzaug, this.zzft, this.zzauh, this.zzaui, this.zzauj, this.zzauk, this.zzaul, this.zzaum, false);
    }
}
