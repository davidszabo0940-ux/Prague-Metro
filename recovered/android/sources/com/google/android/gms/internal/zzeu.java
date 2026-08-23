package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzir
public class zzeu implements zzet {
    private final Context mContext;
    private final VersionInfoParcel zzalm;

    @zzir
    static class zza {
        private final String mValue;
        private final String zzaxn;

        public zza(String str, String str2) {
            this.zzaxn = str;
            this.mValue = str2;
        }

        public String getKey() {
            return this.zzaxn;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    @zzir
    static class zzb {
        private final String zzbim;
        private final URL zzbin;
        private final ArrayList<zza> zzbio;
        private final String zzbip;

        public zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzbim = str;
            this.zzbin = url;
            if (arrayList == null) {
                this.zzbio = new ArrayList<>();
            } else {
                this.zzbio = arrayList;
            }
            this.zzbip = str2;
        }

        public String zzlg() {
            return this.zzbim;
        }

        public URL zzlh() {
            return this.zzbin;
        }

        public ArrayList<zza> zzli() {
            return this.zzbio;
        }

        public String zzlj() {
            return this.zzbip;
        }
    }

    @zzir
    class zzc {
        private final zzd zzbiq;
        private final boolean zzbir;
        private final String zzbis;

        public zzc(boolean z, zzd zzdVar, String str) {
            this.zzbir = z;
            this.zzbiq = zzdVar;
            this.zzbis = str;
        }

        public String getReason() {
            return this.zzbis;
        }

        public boolean isSuccess() {
            return this.zzbir;
        }

        public zzd zzlk() {
            return this.zzbiq;
        }
    }

    @zzir
    static class zzd {
        private final String zzbfm;
        private final String zzbim;
        private final int zzbit;
        private final List<zza> zzbiu;

        public zzd(String str, int i, List<zza> list, String str2) {
            this.zzbim = str;
            this.zzbit = i;
            if (list == null) {
                this.zzbiu = new ArrayList();
            } else {
                this.zzbiu = list;
            }
            this.zzbfm = str2;
        }

        public String getBody() {
            return this.zzbfm;
        }

        public int getResponseCode() {
            return this.zzbit;
        }

        public String zzlg() {
            return this.zzbim;
        }

        public Iterable<zza> zzll() {
            return this.zzbiu;
        }
    }

    public zzeu(Context context, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzalm = versionInfoParcel;
    }

    protected zzc zza(zzb zzbVar) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) zzbVar.zzlh().openConnection();
            com.google.android.gms.ads.internal.zzu.zzfq().zza(this.mContext, this.zzalm.zzcs, false, httpURLConnection);
            for (zza zzaVar : zzbVar.zzli()) {
                httpURLConnection.addRequestProperty(zzaVar.getKey(), zzaVar.getValue());
            }
            if (!TextUtils.isEmpty(zzbVar.zzlj())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = zzbVar.zzlj().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            ArrayList arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        arrayList.add(new zza(entry.getKey(), it.next()));
                    }
                }
            }
            return new zzc(true, new zzd(zzbVar.zzlg(), httpURLConnection.getResponseCode(), arrayList, com.google.android.gms.ads.internal.zzu.zzfq().zza(new InputStreamReader(httpURLConnection.getInputStream()))), null);
        } catch (Exception e) {
            return new zzc(false, null, e.toString());
        }
    }

    protected JSONObject zza(zzd zzdVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", zzdVar.zzlg());
            if (zzdVar.getBody() != null) {
                jSONObject.put("body", zzdVar.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza zzaVar : zzdVar.zzll()) {
                jSONArray.put(new JSONObject().put("key", zzaVar.getKey()).put("value", zzaVar.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", zzdVar.getResponseCode());
        } catch (JSONException e) {
            zzkh.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.zzet
    public void zza(final zzll zzllVar, final Map<String, String> map) {
        zzkk.zza(new Runnable() { // from class: com.google.android.gms.internal.zzeu.1
            @Override // java.lang.Runnable
            public void run() {
                zzkh.zzcw("Received Http request.");
                final JSONObject jSONObjectZzaw = zzeu.this.zzaw((String) map.get("http_request"));
                if (jSONObjectZzaw == null) {
                    zzkh.m14e("Response should not be null.");
                } else {
                    zzkl.zzclg.post(new Runnable() { // from class: com.google.android.gms.internal.zzeu.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            zzllVar.zzb("fetchHttpRequestCompleted", jSONObjectZzaw);
                            zzkh.zzcw("Dispatched http response.");
                        }
                    });
                }
            }
        });
    }

    public JSONObject zzaw(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            String strOptString = "";
            try {
                strOptString = jSONObject.optString("http_request_id");
                zzc zzcVarZza = zza(zzc(jSONObject));
                if (zzcVarZza.isSuccess()) {
                    jSONObject2.put("response", zza(zzcVarZza.zzlk()));
                    jSONObject2.put("success", true);
                } else {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", strOptString));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", zzcVarZza.getReason());
                }
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", strOptString));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            zzkh.m14e("The request is not a valid JSON.");
            try {
                return new JSONObject().put("success", false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    protected zzb zzc(JSONObject jSONObject) {
        URL url;
        String strOptString = jSONObject.optString("http_request_id");
        String strOptString2 = jSONObject.optString("url");
        String strOptString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(strOptString2);
        } catch (MalformedURLException e) {
            zzkh.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("headers");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(new zza(jSONObjectOptJSONObject.optString("key"), jSONObjectOptJSONObject.optString("value")));
            }
        }
        return new zzb(strOptString, url, arrayList, strOptString3);
    }
}
