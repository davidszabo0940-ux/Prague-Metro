package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzvy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzg {

    /* JADX INFO: renamed from: aP */
    private final Account f327aP;

    /* JADX INFO: renamed from: cb */
    private final String f328cb;

    /* JADX INFO: renamed from: rN */
    private final Set<Scope> f329rN;

    /* JADX INFO: renamed from: rP */
    private final int f330rP;

    /* JADX INFO: renamed from: rQ */
    private final View f331rQ;

    /* JADX INFO: renamed from: rR */
    private final String f332rR;

    /* JADX INFO: renamed from: xY */
    private final Set<Scope> f333xY;

    /* JADX INFO: renamed from: xZ */
    private final Map<Api<?>, zza> f334xZ;

    /* JADX INFO: renamed from: ya */
    private final zzvy f335ya;

    /* JADX INFO: renamed from: yb */
    private Integer f336yb;

    public static final class zza {

        /* JADX INFO: renamed from: dY */
        public final Set<Scope> f337dY;

        /* JADX INFO: renamed from: yc */
        public final boolean f338yc;

        public zza(Set<Scope> set, boolean z) {
            zzab.zzaa(set);
            this.f337dY = Collections.unmodifiableSet(set);
            this.f338yc = z;
        }
    }

    public zzg(Account account, Set<Scope> set, Map<Api<?>, zza> map, int i, View view, String str, String str2, zzvy zzvyVar) {
        this.f327aP = account;
        this.f329rN = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f334xZ = map == null ? Collections.EMPTY_MAP : map;
        this.f331rQ = view;
        this.f330rP = i;
        this.f328cb = str;
        this.f332rR = str2;
        this.f335ya = zzvyVar;
        HashSet hashSet = new HashSet(this.f329rN);
        Iterator<zza> it = this.f334xZ.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().f337dY);
        }
        this.f333xY = Collections.unmodifiableSet(hashSet);
    }

    public static zzg zzcd(Context context) {
        return new GoogleApiClient.Builder(context).zzaoe();
    }

    public Account getAccount() {
        return this.f327aP;
    }

    @Deprecated
    public String getAccountName() {
        if (this.f327aP != null) {
            return this.f327aP.name;
        }
        return null;
    }

    public Account zzaru() {
        return this.f327aP != null ? this.f327aP : new Account("<<default account>>", "com.google");
    }

    public int zzase() {
        return this.f330rP;
    }

    public Set<Scope> zzasf() {
        return this.f329rN;
    }

    public Set<Scope> zzasg() {
        return this.f333xY;
    }

    public Map<Api<?>, zza> zzash() {
        return this.f334xZ;
    }

    public String zzasi() {
        return this.f328cb;
    }

    public String zzasj() {
        return this.f332rR;
    }

    public View zzask() {
        return this.f331rQ;
    }

    public zzvy zzasl() {
        return this.f335ya;
    }

    public Integer zzasm() {
        return this.f336yb;
    }

    public Set<Scope> zzb(Api<?> api) {
        zza zzaVar = this.f334xZ.get(api);
        if (zzaVar == null || zzaVar.f337dY.isEmpty()) {
            return this.f329rN;
        }
        HashSet hashSet = new HashSet(this.f329rN);
        hashSet.addAll(zzaVar.f337dY);
        return hashSet;
    }

    public void zzc(Integer num) {
        this.f336yb = num;
    }
}
