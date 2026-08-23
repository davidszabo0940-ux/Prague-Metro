package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzir;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzad {
    public static final String DEVICE_ID_EMULATOR = zzm.zziw().zzcv("emulator");
    private final boolean zzakp;
    private final int zzaub;
    private final int zzaue;
    private final String zzauf;
    private final String zzauh;
    private final Bundle zzauj;
    private final String zzaul;
    private final boolean zzaun;
    private final Bundle zzavq;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzavr;
    private final SearchAdRequest zzavs;
    private final Set<String> zzavt;
    private final Set<String> zzavu;
    private final Date zzfp;
    private final Set<String> zzfr;
    private final Location zzft;

    public static final class zza {
        private String zzauf;
        private String zzauh;
        private String zzaul;
        private boolean zzaun;
        private Date zzfp;
        private Location zzft;
        private final HashSet<String> zzavv = new HashSet<>();
        private final Bundle zzavq = new Bundle();
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzavw = new HashMap<>();
        private final HashSet<String> zzavx = new HashSet<>();
        private final Bundle zzauj = new Bundle();
        private final HashSet<String> zzavy = new HashSet<>();
        private int zzaub = -1;
        private boolean zzakp = false;
        private int zzaue = -1;

        public void setManualImpressionsEnabled(boolean z) {
            this.zzakp = z;
        }

        @Deprecated
        public void zza(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.zzavw.put((Class<? extends NetworkExtras>) networkExtras.getClass(), networkExtras);
            }
        }

        public void zza(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzavq.putBundle(cls.getName(), bundle);
        }

        public void zza(Date date) {
            this.zzfp = date;
        }

        public void zzaf(String str) {
            this.zzavv.add(str);
        }

        public void zzag(String str) {
            this.zzavx.add(str);
        }

        public void zzah(String str) {
            this.zzavx.remove(str);
        }

        public void zzai(String str) {
            this.zzauh = str;
        }

        public void zzaj(String str) {
            this.zzauf = str;
        }

        public void zzak(String str) {
            this.zzaul = str;
        }

        public void zzal(String str) {
            this.zzavy.add(str);
        }

        public void zzb(Location location) {
            this.zzft = location;
        }

        public void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.zzavq.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.zzavq.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.zzavq.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public void zzf(String str, String str2) {
            this.zzauj.putString(str, str2);
        }

        public void zzn(boolean z) {
            this.zzaue = z ? 1 : 0;
        }

        public void zzo(boolean z) {
            this.zzaun = z;
        }

        public void zzt(int i) {
            this.zzaub = i;
        }
    }

    public zzad(zza zzaVar) {
        this(zzaVar, null);
    }

    public zzad(zza zzaVar, SearchAdRequest searchAdRequest) {
        this.zzfp = zzaVar.zzfp;
        this.zzauh = zzaVar.zzauh;
        this.zzaub = zzaVar.zzaub;
        this.zzfr = Collections.unmodifiableSet(zzaVar.zzavv);
        this.zzft = zzaVar.zzft;
        this.zzakp = zzaVar.zzakp;
        this.zzavq = zzaVar.zzavq;
        this.zzavr = Collections.unmodifiableMap(zzaVar.zzavw);
        this.zzauf = zzaVar.zzauf;
        this.zzaul = zzaVar.zzaul;
        this.zzavs = searchAdRequest;
        this.zzaue = zzaVar.zzaue;
        this.zzavt = Collections.unmodifiableSet(zzaVar.zzavx);
        this.zzauj = zzaVar.zzauj;
        this.zzavu = Collections.unmodifiableSet(zzaVar.zzavy);
        this.zzaun = zzaVar.zzaun;
    }

    public Date getBirthday() {
        return this.zzfp;
    }

    public String getContentUrl() {
        return this.zzauh;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzavq.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public Bundle getCustomTargeting() {
        return this.zzauj;
    }

    public int getGender() {
        return this.zzaub;
    }

    public Set<String> getKeywords() {
        return this.zzfr;
    }

    public Location getLocation() {
        return this.zzft;
    }

    public boolean getManualImpressionsEnabled() {
        return this.zzakp;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zzavr.get(cls);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> cls) {
        return this.zzavq.getBundle(cls.getName());
    }

    public String getPublisherProvidedId() {
        return this.zzauf;
    }

    public boolean isDesignedForFamilies() {
        return this.zzaun;
    }

    public boolean isTestDevice(Context context) {
        return this.zzavt.contains(zzm.zziw().zzaq(context));
    }

    public String zzje() {
        return this.zzaul;
    }

    public SearchAdRequest zzjf() {
        return this.zzavs;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> zzjg() {
        return this.zzavr;
    }

    public Bundle zzjh() {
        return this.zzavq;
    }

    public int zzji() {
        return this.zzaue;
    }

    public Set<String> zzjj() {
        return this.zzavu;
    }
}
