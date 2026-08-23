package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Api<O extends ApiOptions> {
    private final String mName;

    /* JADX INFO: renamed from: rr */
    private final zza<?, O> f114rr;

    /* JADX INFO: renamed from: rs */
    private final zzh<?, O> f115rs;

    /* JADX INFO: renamed from: rt */
    private final zzf<?> f116rt;

    /* JADX INFO: renamed from: ru */
    private final zzi<?> f117ru;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public static abstract class zza<T extends zze, O> extends zzd<T, O> {
        public abstract T zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzgVar, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);
    }

    public interface zzb {
    }

    public static class zzc<C extends zzb> {
    }

    public static abstract class zzd<T extends zzb, O> {
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public List<Scope> zzq(O o) {
            return Collections.emptyList();
        }
    }

    public interface zze extends zzb {
        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        boolean isConnecting();

        void zza(com.google.android.gms.common.internal.zzd.zzf zzfVar);

        void zza(zzq zzqVar, Set<Scope> set);

        boolean zzafk();

        boolean zzafz();

        Intent zzaga();

        boolean zzanr();

        @Nullable
        IBinder zzans();
    }

    public static final class zzf<C extends zze> extends zzc<C> {
    }

    public interface zzg<T extends IInterface> extends zzb {
        void zza(int i, T t);

        T zzbb(IBinder iBinder);

        String zzra();

        String zzrb();
    }

    public static abstract class zzh<T extends zzg, O> extends zzd<T, O> {
        public abstract int zzant();

        public abstract T zzs(O o);
    }

    public static final class zzi<C extends zzg> extends zzc<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends zze> Api(String str, zza<C, O> zzaVar, zzf<C> zzfVar) {
        zzab.zzb(zzaVar, "Cannot construct an Api with a null ClientBuilder");
        zzab.zzb(zzfVar, "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.f114rr = zzaVar;
        this.f115rs = null;
        this.f116rt = zzfVar;
        this.f117ru = null;
    }

    public String getName() {
        return this.mName;
    }

    public zzd<?, O> zzanm() {
        if (zzanq()) {
            return null;
        }
        return this.f114rr;
    }

    public zza<?, O> zzann() {
        zzab.zza(this.f114rr != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f114rr;
    }

    public zzh<?, O> zzano() {
        zzab.zza(false, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return null;
    }

    public zzc<?> zzanp() {
        if (this.f116rt != null) {
            return this.f116rt;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public boolean zzanq() {
        return false;
    }
}
