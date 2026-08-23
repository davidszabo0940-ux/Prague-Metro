package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzgi;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzn {
    private static com.google.android.gms.ads.internal.formats.zzd zza(zzgr zzgrVar) throws RemoteException {
        return new com.google.android.gms.ads.internal.formats.zzd(zzgrVar.getHeadline(), zzgrVar.getImages(), zzgrVar.getBody(), zzgrVar.zzkw(), zzgrVar.getCallToAction(), zzgrVar.getStarRating(), zzgrVar.getStore(), zzgrVar.getPrice(), null, zzgrVar.getExtras());
    }

    private static com.google.android.gms.ads.internal.formats.zze zza(zzgs zzgsVar) throws RemoteException {
        return new com.google.android.gms.ads.internal.formats.zze(zzgsVar.getHeadline(), zzgsVar.getImages(), zzgsVar.getBody(), zzgsVar.zzla(), zzgsVar.getCallToAction(), zzgsVar.getAdvertiser(), null, zzgsVar.getExtras());
    }

    static zzet zza(@Nullable final zzgr zzgrVar, @Nullable final zzgs zzgsVar, final zzf.zza zzaVar) {
        return new zzet() { // from class: com.google.android.gms.ads.internal.zzn.5
            @Override // com.google.android.gms.internal.zzet
            public void zza(zzll zzllVar, Map<String, String> map) {
                View view = zzllVar.getView();
                if (view == null) {
                    return;
                }
                try {
                    if (zzgrVar != null) {
                        if (zzgrVar.getOverrideClickHandling()) {
                            zzn.zza(zzllVar);
                        } else {
                            zzgrVar.zzk(com.google.android.gms.dynamic.zze.zzae(view));
                            zzaVar.onClick();
                        }
                    } else if (zzgsVar != null) {
                        if (zzgsVar.getOverrideClickHandling()) {
                            zzn.zza(zzllVar);
                        } else {
                            zzgsVar.zzk(com.google.android.gms.dynamic.zze.zzae(view));
                            zzaVar.onClick();
                        }
                    }
                } catch (RemoteException e) {
                    zzkh.zzd("Unable to call handleClick on mapper", e);
                }
            }
        };
    }

    static zzet zza(final CountDownLatch countDownLatch) {
        return new zzet() { // from class: com.google.android.gms.ads.internal.zzn.3
            @Override // com.google.android.gms.internal.zzet
            public void zza(zzll zzllVar, Map<String, String> map) {
                countDownLatch.countDown();
                View view = zzllVar.getView();
                if (view == null) {
                    return;
                }
                view.setVisibility(0);
            }
        };
    }

    private static String zza(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzkh.zzcy("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String strValueOf = String.valueOf("data:image/png;base64,");
        String strValueOf2 = String.valueOf(strEncodeToString);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    static String zza(zzdu zzduVar) {
        if (zzduVar == null) {
            zzkh.zzcy("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri uri = zzduVar.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException e) {
            zzkh.zzcy("Unable to get image uri. Trying data uri next");
        }
        return zzb(zzduVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject zza(Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (bundle.containsKey(next)) {
                if ("image".equals(jSONObject2.getString(next))) {
                    Object obj = bundle.get(next);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(next, zza((Bitmap) obj));
                    } else {
                        zzkh.zzcy("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(next) instanceof Bitmap) {
                    zzkh.zzcy("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(next, String.valueOf(bundle.get(next)));
                }
            }
        }
        return jSONObject;
    }

    public static void zza(@Nullable zzjy zzjyVar, zzf.zza zzaVar) {
        if (zzjyVar == null || !zzg(zzjyVar)) {
            return;
        }
        zzll zzllVar = zzjyVar.zzbtq;
        View view = zzllVar != null ? zzllVar.getView() : null;
        if (view == null) {
            zzkh.zzcy("AdWebView is null");
            return;
        }
        try {
            List<String> list = zzjyVar.zzbor != null ? zzjyVar.zzbor.zzbnm : null;
            if (list == null || list.isEmpty()) {
                zzkh.zzcy("No template ids present in mediation response");
                return;
            }
            zzgr zzgrVarZzmq = zzjyVar.zzbos != null ? zzjyVar.zzbos.zzmq() : null;
            zzgs zzgsVarZzmr = zzjyVar.zzbos != null ? zzjyVar.zzbos.zzmr() : null;
            if (list.contains("2") && zzgrVarZzmq != null) {
                zzgrVarZzmq.zzl(com.google.android.gms.dynamic.zze.zzae(view));
                if (!zzgrVarZzmq.getOverrideImpressionRecording()) {
                    zzgrVarZzmq.recordImpression();
                }
                zzllVar.zzuk().zza("/nativeExpressViewClicked", zza(zzgrVarZzmq, (zzgs) null, zzaVar));
                return;
            }
            if (!list.contains("1") || zzgsVarZzmr == null) {
                zzkh.zzcy("No matching template id and mapper");
                return;
            }
            zzgsVarZzmr.zzl(com.google.android.gms.dynamic.zze.zzae(view));
            if (!zzgsVarZzmr.getOverrideImpressionRecording()) {
                zzgsVarZzmr.recordImpression();
            }
            zzllVar.zzuk().zza("/nativeExpressViewClicked", zza((zzgr) null, zzgsVarZzmr, zzaVar));
        } catch (RemoteException e) {
            zzkh.zzd("Error occurred while recording impression and registering for clicks", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzll zzllVar) {
        View.OnClickListener onClickListenerZzux = zzllVar.zzux();
        if (onClickListenerZzux != null) {
            onClickListenerZzux.onClick(zzllVar.getView());
        }
    }

    private static void zza(final zzll zzllVar, final com.google.android.gms.ads.internal.formats.zzd zzdVar, final String str) {
        zzllVar.zzuk().zza(new zzlm.zza() { // from class: com.google.android.gms.ads.internal.zzn.1
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.android.gms.internal.zzlm.zza
            public void zza(zzll zzllVar2, boolean z) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("headline", zzdVar.getHeadline());
                    jSONObject.put("body", zzdVar.getBody());
                    jSONObject.put("call_to_action", zzdVar.getCallToAction());
                    jSONObject.put("price", zzdVar.getPrice());
                    jSONObject.put("star_rating", String.valueOf(zzdVar.getStarRating()));
                    jSONObject.put("store", zzdVar.getStore());
                    jSONObject.put("icon", zzn.zza(zzdVar.zzkw()));
                    JSONArray jSONArray = new JSONArray();
                    List images = zzdVar.getImages();
                    if (images != null) {
                        Iterator it = images.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(zzn.zza(zzn.zze(it.next())));
                        }
                    }
                    jSONObject.put("images", jSONArray);
                    jSONObject.put("extras", zzn.zza(zzdVar.getExtras(), str));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("assets", jSONObject);
                    jSONObject2.put("template_id", "2");
                    zzllVar.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
                } catch (JSONException e) {
                    zzkh.zzd("Exception occurred when loading assets", e);
                }
            }
        });
    }

    private static void zza(final zzll zzllVar, final com.google.android.gms.ads.internal.formats.zze zzeVar, final String str) {
        zzllVar.zzuk().zza(new zzlm.zza() { // from class: com.google.android.gms.ads.internal.zzn.2
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.android.gms.internal.zzlm.zza
            public void zza(zzll zzllVar2, boolean z) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("headline", zzeVar.getHeadline());
                    jSONObject.put("body", zzeVar.getBody());
                    jSONObject.put("call_to_action", zzeVar.getCallToAction());
                    jSONObject.put("advertiser", zzeVar.getAdvertiser());
                    jSONObject.put("logo", zzn.zza(zzeVar.zzla()));
                    JSONArray jSONArray = new JSONArray();
                    List images = zzeVar.getImages();
                    if (images != null) {
                        Iterator it = images.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(zzn.zza(zzn.zze(it.next())));
                        }
                    }
                    jSONObject.put("images", jSONArray);
                    jSONObject.put("extras", zzn.zza(zzeVar.getExtras(), str));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("assets", jSONObject);
                    jSONObject2.put("template_id", "1");
                    zzllVar.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
                } catch (JSONException e) {
                    zzkh.zzd("Exception occurred when loading assets", e);
                }
            }
        });
    }

    private static void zza(zzll zzllVar, CountDownLatch countDownLatch) {
        zzllVar.zzuk().zza("/nativeExpressAssetsLoaded", zza(countDownLatch));
        zzllVar.zzuk().zza("/nativeExpressAssetsLoadingFailed", zzb(countDownLatch));
    }

    public static boolean zza(zzll zzllVar, zzgi zzgiVar, CountDownLatch countDownLatch) {
        boolean zZzb = false;
        try {
            zZzb = zzb(zzllVar, zzgiVar, countDownLatch);
        } catch (RemoteException e) {
            zzkh.zzd("Unable to invoke load assets", e);
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!zZzb) {
            countDownLatch.countDown();
        }
        return zZzb;
    }

    static zzet zzb(final CountDownLatch countDownLatch) {
        return new zzet() { // from class: com.google.android.gms.ads.internal.zzn.4
            @Override // com.google.android.gms.internal.zzet
            public void zza(zzll zzllVar, Map<String, String> map) {
                zzkh.zzcy("Adapter returned an ad, but assets substitution failed");
                countDownLatch.countDown();
                zzllVar.destroy();
            }
        };
    }

    private static String zzb(zzdu zzduVar) {
        String strZza;
        try {
            com.google.android.gms.dynamic.zzd zzdVarZzkv = zzduVar.zzkv();
            if (zzdVarZzkv == null) {
                zzkh.zzcy("Drawable is null. Returning empty string");
                strZza = "";
            } else {
                Drawable drawable = (Drawable) com.google.android.gms.dynamic.zze.zzad(zzdVarZzkv);
                if (drawable instanceof BitmapDrawable) {
                    strZza = zza(((BitmapDrawable) drawable).getBitmap());
                } else {
                    zzkh.zzcy("Drawable is not an instance of BitmapDrawable. Returning empty string");
                    strZza = "";
                }
            }
            return strZza;
        } catch (RemoteException e) {
            zzkh.zzcy("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    private static boolean zzb(zzll zzllVar, zzgi zzgiVar, CountDownLatch countDownLatch) throws RemoteException {
        View view = zzllVar.getView();
        if (view == null) {
            zzkh.zzcy("AdWebView is null");
            return false;
        }
        view.setVisibility(4);
        List<String> list = zzgiVar.zzbor.zzbnm;
        if (list == null || list.isEmpty()) {
            zzkh.zzcy("No template ids present in mediation response");
            return false;
        }
        zza(zzllVar, countDownLatch);
        zzgr zzgrVarZzmq = zzgiVar.zzbos.zzmq();
        zzgs zzgsVarZzmr = zzgiVar.zzbos.zzmr();
        if (list.contains("2") && zzgrVarZzmq != null) {
            zza(zzllVar, zza(zzgrVarZzmq), zzgiVar.zzbor.zzbnl);
        } else {
            if (!list.contains("1") || zzgsVarZzmr == null) {
                zzkh.zzcy("No matching template id and mapper");
                return false;
            }
            zza(zzllVar, zza(zzgsVarZzmr), zzgiVar.zzbor.zzbnl);
        }
        String str = zzgiVar.zzbor.zzbnj;
        String str2 = zzgiVar.zzbor.zzbnk;
        if (str2 != null) {
            zzllVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        } else {
            zzllVar.loadData(str, "text/html", "UTF-8");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static zzdu zze(Object obj) {
        if (obj instanceof IBinder) {
            return zzdu.zza.zzy((IBinder) obj);
        }
        return null;
    }

    @Nullable
    public static View zzf(@Nullable zzjy zzjyVar) {
        if (zzjyVar == null) {
            zzkh.m14e("AdState is null");
            return null;
        }
        if (zzg(zzjyVar) && zzjyVar.zzbtq != null) {
            return zzjyVar.zzbtq.getView();
        }
        try {
            com.google.android.gms.dynamic.zzd view = zzjyVar.zzbos != null ? zzjyVar.zzbos.getView() : null;
            if (view != null) {
                return (View) com.google.android.gms.dynamic.zze.zzad(view);
            }
            zzkh.zzcy("View in mediation adapter is null.");
            return null;
        } catch (RemoteException e) {
            zzkh.zzd("Could not get View from mediation adapter.", e);
            return null;
        }
    }

    public static boolean zzg(@Nullable zzjy zzjyVar) {
        return (zzjyVar == null || !zzjyVar.zzccc || zzjyVar.zzbor == null || zzjyVar.zzbor.zzbnj == null) ? false : true;
    }
}
