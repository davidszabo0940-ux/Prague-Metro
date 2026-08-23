package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzko {
    private final Context mContext;
    private int mState;
    private final float zzbri;
    private String zzclp;
    private float zzclq;
    private float zzclr;
    private float zzcls;

    public zzko(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zzbri = context.getResources().getDisplayMetrics().density;
    }

    public zzko(Context context, String str) {
        this(context);
        this.zzclp = str;
    }

    private void showDialog() {
        if (!(this.mContext instanceof Activity)) {
            zzkh.zzcx("Can not create dialog without Activity Context");
            return;
        }
        final String strZzcu = zzcu(this.zzclp);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(strZzcu);
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.zzko.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.google.android.gms.ads.internal.zzu.zzfq().zzb(zzko.this.mContext, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", strZzcu), "Share via"));
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.zzko.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    static String zzcu(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri uriBuild = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder sb = new StringBuilder();
        Map<String, String> mapZzf = com.google.android.gms.ads.internal.zzu.zzfq().zzf(uriBuild);
        for (String str2 : mapZzf.keySet()) {
            sb.append(str2).append(" = ").append(mapZzf.get(str2)).append("\n\n");
        }
        String strTrim = sb.toString().trim();
        return TextUtils.isEmpty(strTrim) ? "No debug information" : strTrim;
    }

    void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzclq = f;
            this.zzclr = f2;
            this.zzcls = f2;
            return;
        }
        if (this.mState != -1) {
            if (i != 2) {
                if (i == 1 && this.mState == 4) {
                    showDialog();
                    return;
                }
                return;
            }
            if (f2 > this.zzclr) {
                this.zzclr = f2;
            } else if (f2 < this.zzcls) {
                this.zzcls = f2;
            }
            if (this.zzclr - this.zzcls > 30.0f * this.zzbri) {
                this.mState = -1;
                return;
            }
            if (this.mState == 0 || this.mState == 2) {
                if (f - this.zzclq >= 50.0f * this.zzbri) {
                    this.zzclq = f;
                    this.mState++;
                }
            } else if ((this.mState == 1 || this.mState == 3) && f - this.zzclq <= (-50.0f) * this.zzbri) {
                this.zzclq = f;
                this.mState++;
            }
            if (this.mState == 1 || this.mState == 3) {
                if (f > this.zzclq) {
                    this.zzclq = f;
                }
            } else {
                if (this.mState != 2 || f >= this.zzclq) {
                    return;
                }
                this.zzclq = f;
            }
        }
    }

    public void zzct(String str) {
        this.zzclp = str;
    }

    public void zze(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
