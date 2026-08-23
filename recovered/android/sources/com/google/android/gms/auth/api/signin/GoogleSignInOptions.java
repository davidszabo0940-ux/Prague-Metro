package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional {

    /* JADX INFO: renamed from: aP */
    private Account f41aP;

    /* JADX INFO: renamed from: dS */
    private final ArrayList<Scope> f42dS;

    /* JADX INFO: renamed from: dT */
    private boolean f43dT;

    /* JADX INFO: renamed from: dU */
    private final boolean f44dU;

    /* JADX INFO: renamed from: dV */
    private final boolean f45dV;

    /* JADX INFO: renamed from: dW */
    private String f46dW;

    /* JADX INFO: renamed from: dX */
    private String f47dX;
    final int versionCode;

    /* JADX INFO: renamed from: dP */
    public static final Scope f38dP = new Scope(Scopes.PROFILE);

    /* JADX INFO: renamed from: dQ */
    public static final Scope f39dQ = new Scope("email");

    /* JADX INFO: renamed from: dR */
    public static final Scope f40dR = new Scope("openid");
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzb();

    /* JADX INFO: renamed from: dO */
    private static Comparator<Scope> f37dO = new Comparator<Scope>() { // from class: com.google.android.gms.auth.api.signin.GoogleSignInOptions.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public int compare(Scope scope, Scope scope2) {
            return scope.zzaoh().compareTo(scope2.zzaoh());
        }
    };

    public static final class Builder {

        /* JADX INFO: renamed from: aP */
        private Account f48aP;

        /* JADX INFO: renamed from: dT */
        private boolean f49dT;

        /* JADX INFO: renamed from: dU */
        private boolean f50dU;

        /* JADX INFO: renamed from: dV */
        private boolean f51dV;

        /* JADX INFO: renamed from: dW */
        private String f52dW;

        /* JADX INFO: renamed from: dX */
        private String f53dX;

        /* JADX INFO: renamed from: dY */
        private Set<Scope> f54dY;

        public Builder() {
            this.f54dY = new HashSet();
        }

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            this.f54dY = new HashSet();
            zzab.zzaa(googleSignInOptions);
            this.f54dY = new HashSet(googleSignInOptions.f42dS);
            this.f50dU = googleSignInOptions.f44dU;
            this.f51dV = googleSignInOptions.f45dV;
            this.f49dT = googleSignInOptions.f43dT;
            this.f52dW = googleSignInOptions.f46dW;
            this.f48aP = googleSignInOptions.f41aP;
            this.f53dX = googleSignInOptions.f47dX;
        }

        private String zzfs(String str) {
            zzab.zzhs(str);
            zzab.zzb(this.f52dW == null || this.f52dW.equals(str), "two different server client ids provided");
            return str;
        }

        public GoogleSignInOptions build() {
            if (this.f49dT && (this.f48aP == null || !this.f54dY.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(this.f54dY, this.f48aP, this.f49dT, this.f50dU, this.f51dV, this.f52dW, this.f53dX);
        }

        public Builder requestEmail() {
            this.f54dY.add(GoogleSignInOptions.f39dQ);
            return this;
        }

        public Builder requestId() {
            this.f54dY.add(GoogleSignInOptions.f40dR);
            return this;
        }

        public Builder requestIdToken(String str) {
            this.f49dT = true;
            this.f52dW = zzfs(str);
            return this;
        }

        public Builder requestProfile() {
            this.f54dY.add(GoogleSignInOptions.f38dP);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.f54dY.add(scope);
            this.f54dY.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public Builder requestServerAuthCode(String str, boolean z) {
            this.f50dU = true;
            this.f52dW = zzfs(str);
            this.f51dV = z;
            return this;
        }

        public Builder setAccountName(String str) {
            this.f48aP = new Account(zzab.zzhs(str), "com.google");
            return this;
        }

        public Builder setHostedDomain(String str) {
            this.f53dX = zzab.zzhs(str);
            return this;
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.versionCode = i;
        this.f42dS = arrayList;
        this.f41aP = account;
        this.f43dT = z;
        this.f44dU = z2;
        this.f45dV = z3;
        this.f46dW = str;
        this.f47dX = str2;
    }

    private GoogleSignInOptions(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this(2, (ArrayList<Scope>) new ArrayList(set), account, z, z2, z3, str, str2);
    }

    private JSONObject zzafp() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f42dS, f37dO);
            Iterator<Scope> it = this.f42dS.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().zzaoh());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.f41aP != null) {
                jSONObject.put("accountName", this.f41aP.name);
            }
            jSONObject.put("idTokenRequested", this.f43dT);
            jSONObject.put("forceCodeForRefreshToken", this.f45dV);
            jSONObject.put("serverAuthRequested", this.f44dU);
            if (!TextUtils.isEmpty(this.f46dW)) {
                jSONObject.put("serverClientId", this.f46dW);
            }
            if (!TextUtils.isEmpty(this.f47dX)) {
                jSONObject.put("hostedDomain", this.f47dX);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public static GoogleSignInOptions zzfr(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(hashSet, !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f42dS.size() != googleSignInOptions.zzafq().size() || !this.f42dS.containsAll(googleSignInOptions.zzafq())) {
                return false;
            }
            if (this.f41aP == null) {
                if (googleSignInOptions.getAccount() != null) {
                    return false;
                }
            } else if (!this.f41aP.equals(googleSignInOptions.getAccount())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f46dW)) {
                if (!TextUtils.isEmpty(googleSignInOptions.zzafu())) {
                    return false;
                }
            } else if (!this.f46dW.equals(googleSignInOptions.zzafu())) {
                return false;
            }
            return this.f45dV == googleSignInOptions.zzaft() && this.f43dT == googleSignInOptions.zzafr() && this.f44dU == googleSignInOptions.zzafs();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public Account getAccount() {
        return this.f41aP;
    }

    public Scope[] getScopeArray() {
        return (Scope[]) this.f42dS.toArray(new Scope[this.f42dS.size()]);
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        Iterator<Scope> it = this.f42dS.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().zzaoh());
        }
        Collections.sort(arrayList);
        return new zze().zzr(arrayList).zzr(this.f41aP).zzr(this.f46dW).zzba(this.f45dV).zzba(this.f43dT).zzba(this.f44dU).zzagc();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzafn() {
        return zzafp().toString();
    }

    public ArrayList<Scope> zzafq() {
        return new ArrayList<>(this.f42dS);
    }

    public boolean zzafr() {
        return this.f43dT;
    }

    public boolean zzafs() {
        return this.f44dU;
    }

    public boolean zzaft() {
        return this.f45dV;
    }

    public String zzafu() {
        return this.f46dW;
    }

    public String zzafv() {
        return this.f47dX;
    }
}
