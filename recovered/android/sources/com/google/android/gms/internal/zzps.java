package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzps extends zzqo implements DialogInterface.OnCancelListener {
    protected boolean mStarted;

    /* JADX INFO: renamed from: rX */
    protected final GoogleApiAvailability f582rX;

    /* JADX INFO: renamed from: sB */
    protected boolean f583sB;

    /* JADX INFO: renamed from: sC */
    private ConnectionResult f584sC;

    /* JADX INFO: renamed from: sD */
    private int f585sD;

    /* JADX INFO: renamed from: sE */
    private final Handler f586sE;

    private class zza implements Runnable {
        private zza() {
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            if (zzps.this.mStarted) {
                if (zzps.this.f584sC.hasResolution()) {
                    zzps.this.f763va.startActivityForResult(GoogleApiActivity.zzb(zzps.this.getActivity(), zzps.this.f584sC.getResolution(), zzps.this.f585sD, false), 1);
                    return;
                }
                if (zzps.this.f582rX.isUserResolvableError(zzps.this.f584sC.getErrorCode())) {
                    zzps.this.f582rX.zza(zzps.this.getActivity(), zzps.this.f763va, zzps.this.f584sC.getErrorCode(), 2, zzps.this);
                } else if (zzps.this.f584sC.getErrorCode() != 18) {
                    zzps.this.zza(zzps.this.f584sC, zzps.this.f585sD);
                } else {
                    final Dialog dialogZza = zzps.this.f582rX.zza(zzps.this.getActivity(), zzps.this);
                    zzps.this.f582rX.zza(zzps.this.getActivity().getApplicationContext(), new zzqj.zza() { // from class: com.google.android.gms.internal.zzps.zza.1
                        @Override // com.google.android.gms.internal.zzqj.zza
                        public void zzaor() {
                            zzps.this.zzaoq();
                            if (dialogZza.isShowing()) {
                                dialogZza.dismiss();
                            }
                        }
                    });
                }
            }
        }
    }

    protected zzps(zzqp zzqpVar) {
        this(zzqpVar, GoogleApiAvailability.getInstance());
    }

    zzps(zzqp zzqpVar, GoogleApiAvailability googleApiAvailability) {
        super(zzqpVar);
        this.f585sD = -1;
        this.f586sE = new Handler(Looper.getMainLooper());
        this.f582rX = googleApiAvailability;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    /* JADX WARN: Code duplicated, block: B:6:0x000c  */
    @Override // com.google.android.gms.internal.zzqo
    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        switch (i) {
            case 1:
                if (i2 != -1) {
                    if (i2 == 0) {
                        this.f584sC = new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null);
                    }
                    z = false;
                }
                if (!z) {
                    zza(this.f584sC, this.f585sD);
                } else {
                    zzaoq();
                }
                break;
            case 2:
                int iIsGooglePlayServicesAvailable = this.f582rX.isGooglePlayServicesAvailable(getActivity());
                z = iIsGooglePlayServicesAvailable == 0;
                if (this.f584sC.getErrorCode() == 18 && iIsGooglePlayServicesAvailable == 18) {
                }
                if (!z) {
                    zza(this.f584sC, this.f585sD);
                } else {
                    zzaoq();
                }
                break;
            default:
                z = false;
                if (!z) {
                    zza(this.f584sC, this.f585sD);
                } else {
                    zzaoq();
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        zza(new ConnectionResult(13, null), this.f585sD);
        zzaoq();
    }

    @Override // com.google.android.gms.internal.zzqo
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f583sB = bundle.getBoolean("resolving_error", false);
            if (this.f583sB) {
                this.f585sD = bundle.getInt("failed_client_id", -1);
                this.f584sC = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    @Override // com.google.android.gms.internal.zzqo
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.f583sB);
        if (this.f583sB) {
            bundle.putInt("failed_client_id", this.f585sD);
            bundle.putInt("failed_status", this.f584sC.getErrorCode());
            bundle.putParcelable("failed_resolution", this.f584sC.getResolution());
        }
    }

    @Override // com.google.android.gms.internal.zzqo
    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    @Override // com.google.android.gms.internal.zzqo
    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    protected abstract void zza(ConnectionResult connectionResult, int i);

    protected abstract void zzaol();

    protected void zzaoq() {
        this.f585sD = -1;
        this.f583sB = false;
        this.f584sC = null;
        zzaol();
    }

    public void zzb(ConnectionResult connectionResult, int i) {
        if (this.f583sB) {
            return;
        }
        this.f583sB = true;
        this.f585sD = i;
        this.f584sC = connectionResult;
        this.f586sE.post(new zza());
    }
}
