package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzim implements Callable<zzjy> {
    private static final long zzbyx = TimeUnit.SECONDS.toMillis(60);
    private final Context mContext;
    private final Object zzail = new Object();
    private final zzil zzbgf;
    private final zzas zzbgh;
    private final zzjy.zza zzbxv;
    private int zzbym;
    private final zzkr zzbzg;
    private final com.google.android.gms.ads.internal.zzq zzbzh;
    private boolean zzbzi;
    private List<String> zzbzj;
    private JSONObject zzbzk;

    public interface zza<T extends com.google.android.gms.ads.internal.formats.zzh.zza> {
        T zza(zzim zzimVar, JSONObject jSONObject) throws ExecutionException, JSONException, InterruptedException;
    }

    class zzb {
        public zzet zzcad;

        zzb() {
        }
    }

    public zzim(Context context, com.google.android.gms.ads.internal.zzq zzqVar, zzkr zzkrVar, zzas zzasVar, zzjy.zza zzaVar) {
        this.mContext = context;
        this.zzbzh = zzqVar;
        this.zzbzg = zzkrVar;
        this.zzbxv = zzaVar;
        this.zzbgh = zzasVar;
        this.zzbgf = zza(context, zzaVar, zzqVar, zzasVar);
        this.zzbgf.zzqh();
        this.zzbzi = false;
        this.zzbym = -2;
        this.zzbzj = null;
    }

    private com.google.android.gms.ads.internal.formats.zzh.zza zza(zza zzaVar, JSONObject jSONObject, String str) throws ExecutionException, JSONException, InterruptedException {
        if (zzqt()) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("tracking_urls_and_actions");
        String[] strArrZzc = zzc(jSONObject2, "impression_tracking_urls");
        this.zzbzj = strArrZzc == null ? null : Arrays.asList(strArrZzc);
        this.zzbzk = jSONObject2.optJSONObject("active_view");
        com.google.android.gms.ads.internal.formats.zzh.zza zzaVarZza = zzaVar.zza(this, jSONObject);
        if (zzaVarZza == null) {
            zzkh.m14e("Failed to retrieve ad assets.");
            return null;
        }
        zzaVarZza.zzb(new com.google.android.gms.ads.internal.formats.zzi(this.mContext, this.zzbzh, this.zzbgf, this.zzbgh, jSONObject, zzaVarZza, this.zzbxv.zzcit.zzaou, str));
        return zzaVarZza;
    }

    private zzlc<com.google.android.gms.ads.internal.formats.zzc> zza(JSONObject jSONObject, final boolean z, boolean z2) throws JSONException {
        final String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        final double dOptDouble = jSONObject.optDouble("scale", 1.0d);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? new zzla(new com.google.android.gms.ads.internal.formats.zzc(null, Uri.parse(string), dOptDouble)) : this.zzbzg.zza(string, new zzkr.zza<com.google.android.gms.ads.internal.formats.zzc>() { // from class: com.google.android.gms.internal.zzim.6
                @Override // com.google.android.gms.internal.zzkr.zza
                /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
                public com.google.android.gms.ads.internal.formats.zzc zzh(InputStream inputStream) {
                    byte[] bArrZzk;
                    try {
                        bArrZzk = com.google.android.gms.common.util.zzo.zzk(inputStream);
                    } catch (IOException e) {
                        bArrZzk = null;
                    }
                    if (bArrZzk == null) {
                        zzim.this.zza(2, z);
                        return null;
                    }
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrZzk, 0, bArrZzk.length);
                    if (bitmapDecodeByteArray == null) {
                        zzim.this.zza(2, z);
                        return null;
                    }
                    bitmapDecodeByteArray.setDensity((int) (160.0d * dOptDouble));
                    return new com.google.android.gms.ads.internal.formats.zzc(new BitmapDrawable(Resources.getSystem(), bitmapDecodeByteArray), Uri.parse(string), dOptDouble);
                }

                @Override // com.google.android.gms.internal.zzkr.zza
                /* JADX INFO: renamed from: zzqu, reason: merged with bridge method [inline-methods] */
                public com.google.android.gms.ads.internal.formats.zzc zzqv() {
                    zzim.this.zza(2, z);
                    return null;
                }
            });
        }
        zza(0, z);
        return new zzla(null);
    }

    private void zza(com.google.android.gms.ads.internal.formats.zzh.zza zzaVar) {
        if (zzaVar instanceof com.google.android.gms.ads.internal.formats.zzf) {
            final com.google.android.gms.ads.internal.formats.zzf zzfVar = (com.google.android.gms.ads.internal.formats.zzf) zzaVar;
            zzb zzbVar = new zzb();
            final zzet zzetVar = new zzet() { // from class: com.google.android.gms.internal.zzim.3
                @Override // com.google.android.gms.internal.zzet
                public void zza(zzll zzllVar, Map<String, String> map) {
                    zzim.this.zzb(zzfVar, map.get("asset"));
                }
            };
            zzbVar.zzcad = zzetVar;
            this.zzbgf.zza(new zzil.zza() { // from class: com.google.android.gms.internal.zzim.4
                @Override // com.google.android.gms.internal.zzil.zza
                public void zze(zzfx zzfxVar) {
                    zzfxVar.zza("/nativeAdCustomClick", zzetVar);
                }
            });
        }
    }

    private zzjy zzb(com.google.android.gms.ads.internal.formats.zzh.zza zzaVar) {
        int i;
        synchronized (this.zzail) {
            i = this.zzbym;
            if (zzaVar == null && this.zzbym == -2) {
                i = 0;
            }
        }
        return new zzjy(this.zzbxv.zzcit.zzcav, null, this.zzbxv.zzciu.zzbnq, i, this.zzbxv.zzciu.zzbnr, this.zzbzj, this.zzbxv.zzciu.orientation, this.zzbxv.zzciu.zzbnw, this.zzbxv.zzcit.zzcay, false, null, null, null, null, null, 0L, this.zzbxv.zzaoy, this.zzbxv.zzciu.zzccb, this.zzbxv.zzcio, this.zzbxv.zzcip, this.zzbxv.zzciu.zzcch, this.zzbzk, i != -2 ? null : zzaVar, null, null, null, this.zzbxv.zzciu.zzccu, this.zzbxv.zzciu.zzccv, null, this.zzbxv.zzciu.zzbnt);
    }

    private Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(zzec zzecVar, String str) {
        try {
            zzeg zzegVarZzv = this.zzbzh.zzv(zzecVar.getCustomTemplateId());
            if (zzegVarZzv != null) {
                zzegVarZzv.zza(zzecVar, str);
            }
        } catch (RemoteException e) {
            zzkh.zzd(new StringBuilder(String.valueOf(str).length() + 40).append("Failed to call onCustomClick for asset ").append(str).append(".").toString(), e);
        }
    }

    private String[] zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        String[] strArr = new String[jSONArrayOptJSONArray.length()];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            strArr[i] = jSONArrayOptJSONArray.getString(i);
        }
        return strArr;
    }

    private JSONObject zzcc(final String str) throws ExecutionException, JSONException, InterruptedException, TimeoutException {
        if (zzqt()) {
            return null;
        }
        final zzkz zzkzVar = new zzkz();
        final zzb zzbVar = new zzb();
        this.zzbgf.zza(new zzil.zza() { // from class: com.google.android.gms.internal.zzim.1
            @Override // com.google.android.gms.internal.zzil.zza
            public void zze(final zzfx zzfxVar) {
                zzet zzetVar = new zzet() { // from class: com.google.android.gms.internal.zzim.1.1
                    @Override // com.google.android.gms.internal.zzet
                    public void zza(zzll zzllVar, Map<String, String> map) {
                        zzfxVar.zzb("/nativeAdPreProcess", zzbVar.zzcad);
                        try {
                            String str2 = map.get("success");
                            if (!TextUtils.isEmpty(str2)) {
                                zzkzVar.zzi(new JSONObject(str2).getJSONArray("ads").getJSONObject(0));
                                return;
                            }
                        } catch (JSONException e) {
                            zzkh.zzb("Malformed native JSON response.", e);
                        }
                        zzim.this.zzan(0);
                        com.google.android.gms.common.internal.zzab.zza(zzim.this.zzqt(), "Unable to set the ad state error!");
                        zzkzVar.zzi(null);
                    }
                };
                zzbVar.zzcad = zzetVar;
                zzfxVar.zza("/nativeAdPreProcess", zzetVar);
                try {
                    JSONObject jSONObject = new JSONObject(zzim.this.zzbxv.zzciu.body);
                    jSONObject.put("ads_id", str);
                    zzfxVar.zza("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
                } catch (JSONException e) {
                    zzkh.zzd("Exception occurred while invoking javascript", e);
                    zzkzVar.zzi(null);
                }
            }

            @Override // com.google.android.gms.internal.zzil.zza
            public void zzqr() {
                zzkzVar.zzi(null);
            }
        });
        return (JSONObject) zzkzVar.get(zzbyx, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<Drawable> zzh(List<com.google.android.gms.ads.internal.formats.zzc> list) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        Iterator<com.google.android.gms.ads.internal.formats.zzc> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((Drawable) com.google.android.gms.dynamic.zze.zzad(it.next().zzkv()));
        }
        return arrayList;
    }

    zzil zza(Context context, zzjy.zza zzaVar, com.google.android.gms.ads.internal.zzq zzqVar, zzas zzasVar) {
        return new zzil(context, zzaVar, zzqVar, zzasVar);
    }

    public zzlc<com.google.android.gms.ads.internal.formats.zzc> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public List<zzlc<com.google.android.gms.ads.internal.formats.zzc>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            zza(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<com.google.android.gms.ads.internal.formats.zzc> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean zOptBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, zOptBoolean, z);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzan(i);
        }
    }

    public void zzan(int i) {
        synchronized (this.zzail) {
            this.zzbzi = true;
            this.zzbym = i;
        }
    }

    protected zza zzf(JSONObject jSONObject) throws ExecutionException, JSONException, InterruptedException, TimeoutException {
        if (zzqt()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.zzbxv.zzcit.zzapm != null ? this.zzbxv.zzcit.zzapm.zzbgt : false;
        boolean z2 = this.zzbxv.zzcit.zzapm != null ? this.zzbxv.zzcit.zzapm.zzbgv : false;
        if ("2".equals(string)) {
            return new zzin(z, z2);
        }
        if ("1".equals(string)) {
            return new zzio(z, z2);
        }
        if ("3".equals(string)) {
            final String string2 = jSONObject.getString("custom_template_id");
            final zzkz zzkzVar = new zzkz();
            zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzim.2
                @Override // java.lang.Runnable
                public void run() {
                    zzkzVar.zzi(zzim.this.zzbzh.zzfb().get(string2));
                }
            });
            if (zzkzVar.get(zzbyx, TimeUnit.MILLISECONDS) != null) {
                return new zzip(z);
            }
            String strValueOf = String.valueOf(jSONObject.getString("custom_template_id"));
            zzkh.m14e(strValueOf.length() != 0 ? "No handler for custom template: ".concat(strValueOf) : new String("No handler for custom template: "));
        } else {
            zzan(0);
        }
        return null;
    }

    public zzlc<com.google.android.gms.ads.internal.formats.zza> zzg(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution");
        if (jSONObjectOptJSONObject == null) {
            return new zzla(null);
        }
        final String strOptString = jSONObjectOptJSONObject.optString("text");
        final int iOptInt = jSONObjectOptJSONObject.optInt("text_size", -1);
        final Integer numZzb = zzb(jSONObjectOptJSONObject, "text_color");
        final Integer numZzb2 = zzb(jSONObjectOptJSONObject, "bg_color");
        final int iOptInt2 = jSONObjectOptJSONObject.optInt("animation_ms", 1000);
        final int iOptInt3 = jSONObjectOptJSONObject.optInt("presentation_ms", 4000);
        final int i = (this.zzbxv.zzcit.zzapm == null || this.zzbxv.zzcit.zzapm.versionCode < 2) ? 1 : this.zzbxv.zzcit.zzapm.zzbgw;
        List<zzlc<com.google.android.gms.ads.internal.formats.zzc>> arrayList = new ArrayList<>();
        if (jSONObjectOptJSONObject.optJSONArray("images") != null) {
            arrayList = zza(jSONObjectOptJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(jSONObjectOptJSONObject, "image", false, false));
        }
        return zzlb.zza(zzlb.zzn(arrayList), new zzlb.zza<List<com.google.android.gms.ads.internal.formats.zzc>, com.google.android.gms.ads.internal.formats.zza>() { // from class: com.google.android.gms.internal.zzim.5
            /* JADX WARN: Code duplicated, block: B:6:0x0009  */
            @Override // com.google.android.gms.internal.zzlb.zza
            /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
            public com.google.android.gms.ads.internal.formats.zza zzh(List<com.google.android.gms.ads.internal.formats.zzc> list) {
                com.google.android.gms.ads.internal.formats.zza zzaVar;
                if (list != null) {
                    try {
                        if (list.isEmpty()) {
                            zzaVar = null;
                        } else {
                            zzaVar = new com.google.android.gms.ads.internal.formats.zza(strOptString, zzim.zzh(list), numZzb2, numZzb, iOptInt > 0 ? Integer.valueOf(iOptInt) : null, iOptInt3 + iOptInt2, i);
                        }
                    } catch (RemoteException e) {
                        zzkh.zzb("Could not get attribution icon", e);
                        return null;
                    }
                } else {
                    zzaVar = null;
                }
                return zzaVar;
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:8:0x002b  */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: zzqs, reason: merged with bridge method [inline-methods] */
    public zzjy call() {
        try {
            this.zzbgf.zzqi();
            String string = UUID.randomUUID().toString();
            JSONObject jSONObjectZzcc = zzcc(string);
            com.google.android.gms.ads.internal.formats.zzh.zza zzaVarZza = zza(zzf(jSONObjectZzcc), jSONObjectZzcc, string);
            zza(zzaVarZza);
            return zzb(zzaVarZza);
        } catch (InterruptedException e) {
            if (!this.zzbzi) {
                zzan(0);
            }
            return zzb((com.google.android.gms.ads.internal.formats.zzh.zza) null);
        } catch (CancellationException e2) {
            if (!this.zzbzi) {
                zzan(0);
            }
            return zzb((com.google.android.gms.ads.internal.formats.zzh.zza) null);
        } catch (ExecutionException e3) {
            if (!this.zzbzi) {
                zzan(0);
            }
            return zzb((com.google.android.gms.ads.internal.formats.zzh.zza) null);
        } catch (TimeoutException e4) {
            zzkh.zzd("Timeout when loading native ad.", e4);
            if (!this.zzbzi) {
                zzan(0);
            }
            return zzb((com.google.android.gms.ads.internal.formats.zzh.zza) null);
        } catch (JSONException e5) {
            zzkh.zzd("Malformed native JSON response.", e5);
            if (!this.zzbzi) {
                zzan(0);
            }
            return zzb((com.google.android.gms.ads.internal.formats.zzh.zza) null);
        }
    }

    public boolean zzqt() {
        boolean z;
        synchronized (this.zzail) {
            z = this.zzbzi;
        }
        return z;
    }
}
