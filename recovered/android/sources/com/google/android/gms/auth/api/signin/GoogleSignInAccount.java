package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zza();

    /* JADX INFO: renamed from: dF */
    public static zze f25dF = zzh.zzavi();

    /* JADX INFO: renamed from: dO */
    private static Comparator<Scope> f26dO = new Comparator<Scope>() { // from class: com.google.android.gms.auth.api.signin.GoogleSignInAccount.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public int compare(Scope scope, Scope scope2) {
            return scope.zzaoh().compareTo(scope2.zzaoh());
        }
    };

    /* JADX INFO: renamed from: cx */
    List<Scope> f27cx;

    /* JADX INFO: renamed from: dG */
    private String f28dG;

    /* JADX INFO: renamed from: dH */
    private String f29dH;

    /* JADX INFO: renamed from: dI */
    private Uri f30dI;

    /* JADX INFO: renamed from: dJ */
    private String f31dJ;

    /* JADX INFO: renamed from: dK */
    private long f32dK;

    /* JADX INFO: renamed from: dL */
    private String f33dL;

    /* JADX INFO: renamed from: dM */
    private String f34dM;

    /* JADX INFO: renamed from: dN */
    private String f35dN;

    /* JADX INFO: renamed from: dd */
    private String f36dd;
    final int versionCode;
    private String zzbgk;

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.versionCode = i;
        this.zzbgk = str;
        this.f36dd = str2;
        this.f28dG = str3;
        this.f29dH = str4;
        this.f30dI = uri;
        this.f31dJ = str5;
        this.f32dK = j;
        this.f33dL = str6;
        this.f27cx = list;
        this.f34dM = str7;
        this.f35dN = str8;
    }

    public static GoogleSignInAccount zza(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l, @NonNull String str7, @NonNull Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(f25dF.currentTimeMillis() / 1000);
        }
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), zzab.zzhs(str7), new ArrayList((Collection) zzab.zzaa(set)), str5, str6);
    }

    private JSONObject zzafp() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.f32dK);
            jSONObject.put("obfuscatedIdentifier", zzafm());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f27cx, f26dO);
            Iterator<Scope> it = this.f27cx.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().zzaoh());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public static GoogleSignInAccount zzfp(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl", null);
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return zza(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), uri, Long.valueOf(j), jSONObject.getString("obfuscatedIdentifier"), hashSet).zzfq(jSONObject.optString("serverAuthCode", null));
    }

    public boolean equals(Object obj) {
        if (obj instanceof GoogleSignInAccount) {
            return ((GoogleSignInAccount) obj).zzafn().equals(zzafn());
        }
        return false;
    }

    @Nullable
    public String getDisplayName() {
        return this.f29dH;
    }

    @Nullable
    public String getEmail() {
        return this.f28dG;
    }

    @Nullable
    public String getFamilyName() {
        return this.f35dN;
    }

    @Nullable
    public String getGivenName() {
        return this.f34dM;
    }

    @NonNull
    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.f27cx);
    }

    @Nullable
    public String getId() {
        return this.zzbgk;
    }

    @Nullable
    public String getIdToken() {
        return this.f36dd;
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.f30dI;
    }

    @Nullable
    public String getServerAuthCode() {
        return this.f31dJ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public boolean zza() {
        return f25dF.currentTimeMillis() / 1000 >= this.f32dK - 300;
    }

    public long zzafl() {
        return this.f32dK;
    }

    @NonNull
    public String zzafm() {
        return this.f33dL;
    }

    public String zzafn() {
        return zzafp().toString();
    }

    public String zzafo() {
        JSONObject jSONObjectZzafp = zzafp();
        jSONObjectZzafp.remove("serverAuthCode");
        return jSONObjectZzafp.toString();
    }

    public GoogleSignInAccount zzfq(String str) {
        this.f31dJ = str;
        return this;
    }
}
