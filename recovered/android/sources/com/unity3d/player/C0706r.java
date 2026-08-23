package com.unity3d.player;

import android.content.Context;
import android.hardware.GeomagneticField;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.unity3d.player.r */
/* JADX INFO: loaded from: classes.dex */
final class C0706r implements LocationListener {

    /* JADX INFO: renamed from: a */
    private final Context f1050a;

    /* JADX INFO: renamed from: b */
    private final UnityPlayer f1051b;

    /* JADX INFO: renamed from: c */
    private Location f1052c;

    /* JADX INFO: renamed from: d */
    private float f1053d = 0.0f;

    /* JADX INFO: renamed from: e */
    private boolean f1054e = false;

    /* JADX INFO: renamed from: f */
    private int f1055f = 0;

    /* JADX INFO: renamed from: g */
    private boolean f1056g = false;

    /* JADX INFO: renamed from: h */
    private int f1057h = 0;

    protected C0706r(Context context, UnityPlayer unityPlayer) {
        this.f1050a = context;
        this.f1051b = unityPlayer;
    }

    /* JADX INFO: renamed from: a */
    private void m199a(int i) {
        this.f1057h = i;
        this.f1051b.nativeSetLocationStatus(i);
    }

    /* JADX INFO: renamed from: a */
    private void m200a(Location location) {
        if (location != null && m201a(location, this.f1052c)) {
            this.f1052c = location;
            this.f1051b.nativeSetLocation((float) location.getLatitude(), (float) location.getLongitude(), (float) location.getAltitude(), location.getAccuracy(), location.getTime() / 1000.0d, new GeomagneticField((float) this.f1052c.getLatitude(), (float) this.f1052c.getLongitude(), (float) this.f1052c.getAltitude(), this.f1052c.getTime()).getDeclination());
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m201a(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = (accuracy > 200) | (location.getAccuracy() == 0.0f);
        boolean zM202a = m202a(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && zM202a;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m202a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    /* JADX INFO: renamed from: a */
    public final void m203a(float f) {
        this.f1053d = f;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m204a() {
        return !((LocationManager) this.f1050a.getSystemService("location")).getProviders(new Criteria(), true).isEmpty();
    }

    /* JADX INFO: renamed from: b */
    public final void m205b() {
        LocationProvider locationProvider;
        this.f1056g = false;
        if (this.f1054e) {
            C0701m.Log(5, "Location_StartUpdatingLocation already started!");
            return;
        }
        if (!m204a()) {
            m199a(3);
            return;
        }
        LocationManager locationManager = (LocationManager) this.f1050a.getSystemService("location");
        m199a(1);
        List<String> providers = locationManager.getProviders(true);
        if (providers.isEmpty()) {
            m199a(3);
            return;
        }
        if (this.f1055f != 2) {
            locationProvider = null;
            break;
        }
        Iterator<String> it = providers.iterator();
        while (true) {
            if (!it.hasNext()) {
                locationProvider = null;
                break;
            }
            LocationProvider provider = locationManager.getProvider(it.next());
            if (provider.getAccuracy() == 2) {
                locationProvider = provider;
                break;
            }
        }
        for (String str : providers) {
            if (locationProvider == null || locationManager.getProvider(str).getAccuracy() != 1) {
                m200a(locationManager.getLastKnownLocation(str));
                locationManager.requestLocationUpdates(str, 0L, this.f1053d, this, this.f1050a.getMainLooper());
                this.f1054e = true;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m206b(float f) {
        if (f < 100.0f) {
            this.f1055f = 1;
        } else if (f < 500.0f) {
            this.f1055f = 1;
        } else {
            this.f1055f = 2;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m207c() {
        ((LocationManager) this.f1050a.getSystemService("location")).removeUpdates(this);
        this.f1054e = false;
        this.f1052c = null;
        m199a(0);
    }

    /* JADX INFO: renamed from: d */
    public final void m208d() {
        if (this.f1057h == 1 || this.f1057h == 2) {
            this.f1056g = true;
            m207c();
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m209e() {
        if (this.f1056g) {
            m205b();
        }
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        m199a(2);
        m200a(location);
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        this.f1052c = null;
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
