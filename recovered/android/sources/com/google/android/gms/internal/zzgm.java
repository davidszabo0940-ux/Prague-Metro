package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public final class zzgm extends zzgn.zza {
    private Map<Class<? extends NetworkExtras>, NetworkExtras> zzbpk;

    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> zzgo zzbp(String str) throws RemoteException {
        try {
            Class<?> cls = Class.forName(str, false, zzgm.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                return new zzgz(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.zzbpk.get(mediationAdapter.getAdditionalParametersType()));
            }
            if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzgu((com.google.android.gms.ads.mediation.MediationAdapter) cls.newInstance());
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(new StringBuilder(String.valueOf(str).length() + 64).append("Could not instantiate mediation adapter: ").append(str).append(" (not a valid adapter).").toString());
            throw new RemoteException();
        } catch (Throwable th) {
            return zzbq(str);
        }
    }

    private zzgo zzbq(String str) throws RemoteException {
        try {
            com.google.android.gms.ads.internal.util.client.zzb.zzcw("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new zzgu(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                return new zzgu(new AdUrlAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new zzgu(new CustomEventAdapter());
            }
            if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                com.google.ads.mediation.customevent.CustomEventAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
                return new zzgz(customEventAdapter, (CustomEventExtras) this.zzbpk.get(customEventAdapter.getAdditionalParametersType()));
            }
            throw new RemoteException();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd(new StringBuilder(String.valueOf(str).length() + 43).append("Could not instantiate mediation adapter: ").append(str).append(". ").toString(), th);
        }
    }

    @Override // com.google.android.gms.internal.zzgn
    public zzgo zzbn(String str) throws RemoteException {
        return zzbp(str);
    }

    @Override // com.google.android.gms.internal.zzgn
    public boolean zzbo(String str) throws RemoteException {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzgm.class.getClassLoader()));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzcy(new StringBuilder(String.valueOf(str).length() + 80).append("Could not load custom event implementation class: ").append(str).append(", assuming old implementation.").toString());
            return false;
        }
    }

    public void zzh(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.zzbpk = map;
    }
}
