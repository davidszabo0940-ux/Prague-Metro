package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface MediationAdapter {

    public static class zza {
        private int zzcqr;

        public zza zzbb(int i) {
            this.zzcqr = i;
            return this;
        }

        public Bundle zzvp() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzcqr);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
