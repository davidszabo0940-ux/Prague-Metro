package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzhh {
    private final boolean zzbrb;
    private final boolean zzbrc;
    private final boolean zzbrd;
    private final boolean zzbre;
    private final boolean zzbrf;

    public static final class zza {
        private boolean zzbrb;
        private boolean zzbrc;
        private boolean zzbrd;
        private boolean zzbre;
        private boolean zzbrf;

        public zzhh zzna() {
            return new zzhh(this);
        }

        public zza zzt(boolean z) {
            this.zzbrb = z;
            return this;
        }

        public zza zzu(boolean z) {
            this.zzbrc = z;
            return this;
        }

        public zza zzv(boolean z) {
            this.zzbrd = z;
            return this;
        }

        public zza zzw(boolean z) {
            this.zzbre = z;
            return this;
        }

        public zza zzx(boolean z) {
            this.zzbrf = z;
            return this;
        }
    }

    private zzhh(zza zzaVar) {
        this.zzbrb = zzaVar.zzbrb;
        this.zzbrc = zzaVar.zzbrc;
        this.zzbrd = zzaVar.zzbrd;
        this.zzbre = zzaVar.zzbre;
        this.zzbrf = zzaVar.zzbrf;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzbrb).put("tel", this.zzbrc).put("calendar", this.zzbrd).put("storePicture", this.zzbre).put("inlineVideo", this.zzbrf);
        } catch (JSONException e) {
            zzkh.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
