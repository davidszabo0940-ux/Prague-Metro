.class public Lcom/google/android/gms/internal/zzjk;
.super Lcom/google/android/gms/internal/zzkg;

# interfaces
.implements Lcom/google/android/gms/internal/zzjl;
.implements Lcom/google/android/gms/internal/zzjo;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final zzail:Ljava/lang/Object;

.field private final zzbog:Ljava/lang/String;

.field private final zzbxv:Lcom/google/android/gms/internal/zzjy$zza;

.field private zzbym:I

.field private final zzchq:Lcom/google/android/gms/internal/zzjq;

.field private final zzchr:Lcom/google/android/gms/internal/zzjo;

.field private final zzchs:Ljava/lang/String;

.field private final zzcht:Ljava/lang/String;

.field private zzchu:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/zzjy$zza;Lcom/google/android/gms/internal/zzjq;Lcom/google/android/gms/internal/zzjo;)V
    .locals 1

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzkg;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchu:I

    const/4 v0, 0x3

    iput v0, p0, Lcom/google/android/gms/internal/zzjk;->zzbym:I

    iput-object p1, p0, Lcom/google/android/gms/internal/zzjk;->mContext:Landroid/content/Context;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzjk;->zzbog:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzjk;->zzchs:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/android/gms/internal/zzjk;->zzcht:Ljava/lang/String;

    iput-object p5, p0, Lcom/google/android/gms/internal/zzjk;->zzbxv:Lcom/google/android/gms/internal/zzjy$zza;

    iput-object p6, p0, Lcom/google/android/gms/internal/zzjk;->zzchq:Lcom/google/android/gms/internal/zzjq;

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzail:Ljava/lang/Object;

    iput-object p7, p0, Lcom/google/android/gms/internal/zzjk;->zzchr:Lcom/google/android/gms/internal/zzjo;

    return-void
.end method

.method static synthetic zza(Lcom/google/android/gms/internal/zzjk;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method private zza(Lcom/google/android/gms/ads/internal/client/AdRequestParcel;Lcom/google/android/gms/internal/zzgo;)V
    .locals 2

    :try_start_0
    const-string v0, "com.google.ads.mediation.admob.AdMobAdapter"

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjk;->zzbog:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchs:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjk;->zzcht:Ljava/lang/String;

    invoke-interface {p2, p1, v0, v1}, Lcom/google/android/gms/internal/zzgo;->zza(Lcom/google/android/gms/ads/internal/client/AdRequestParcel;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchs:Ljava/lang/String;

    invoke-interface {p2, p1, v0}, Lcom/google/android/gms/internal/zzgo;->zzc(Lcom/google/android/gms/ads/internal/client/AdRequestParcel;Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "Fail to load ad from adapter."

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/zzkh;->zzd(Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzbog:Ljava/lang/String;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/google/android/gms/internal/zzjk;->zza(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method static synthetic zza(Lcom/google/android/gms/internal/zzjk;Lcom/google/android/gms/ads/internal/client/AdRequestParcel;Lcom/google/android/gms/internal/zzgo;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/zzjk;->zza(Lcom/google/android/gms/ads/internal/client/AdRequestParcel;Lcom/google/android/gms/internal/zzgo;)V

    return-void
.end method

.method static synthetic zzb(Lcom/google/android/gms/internal/zzjk;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchs:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic zzc(Lcom/google/android/gms/internal/zzjk;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzbog:Ljava/lang/String;

    return-object v0
.end method

.method private zzk(J)V
    .locals 3

    :goto_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzjk;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchu:I

    if-eqz v0, :cond_0

    monitor-exit v1

    :goto_1
    return-void

    :cond_0
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gms/internal/zzjk;->zzf(J)Z

    move-result v0

    if-nez v0, :cond_1

    monitor-exit v1

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method


# virtual methods
.method public onStop()V
    .locals 0

    return-void
.end method

.method public zza(Ljava/lang/String;I)V
    .locals 2

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjk;->zzail:Ljava/lang/Object;

    monitor-enter v1

    const/4 v0, 0x2

    :try_start_0
    iput v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchu:I

    iput p2, p0, Lcom/google/android/gms/internal/zzjk;->zzbym:I

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzail:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public zzaw(I)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzbog:Ljava/lang/String;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/google/android/gms/internal/zzjk;->zza(Ljava/lang/String;I)V

    return-void
.end method

.method public zzch(Ljava/lang/String;)V
    .locals 2

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjk;->zzail:Ljava/lang/Object;

    monitor-enter v1

    const/4 v0, 0x1

    :try_start_0
    iput v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchu:I

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzail:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public zzew()V
    .locals 6

    const/4 v5, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchq:Lcom/google/android/gms/internal/zzjq;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchq:Lcom/google/android/gms/internal/zzjq;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzjq;->zzrw()Lcom/google/android/gms/internal/zzjn;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchq:Lcom/google/android/gms/internal/zzjq;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzjq;->zzrv()Lcom/google/android/gms/internal/zzgo;

    move-result-object v0

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchq:Lcom/google/android/gms/internal/zzjq;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzjq;->zzrw()Lcom/google/android/gms/internal/zzjn;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/google/android/gms/internal/zzjn;->zza(Lcom/google/android/gms/internal/zzjo;)V

    invoke-virtual {v1, p0}, Lcom/google/android/gms/internal/zzjn;->zza(Lcom/google/android/gms/internal/zzjl;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzbxv:Lcom/google/android/gms/internal/zzjy$zza;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzjy$zza;->zzcit:Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;

    iget-object v0, v0, Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;->zzcav:Lcom/google/android/gms/ads/internal/client/AdRequestParcel;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzjk;->zzchq:Lcom/google/android/gms/internal/zzjq;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzjq;->zzrv()Lcom/google/android/gms/internal/zzgo;

    move-result-object v2

    :try_start_0
    invoke-interface {v2}, Lcom/google/android/gms/internal/zzgo;->isInitialized()Z

    move-result v3

    if-eqz v3, :cond_2

    sget-object v3, Lcom/google/android/gms/ads/internal/util/client/zza;->zzcnf:Landroid/os/Handler;

    new-instance v4, Lcom/google/android/gms/internal/zzjk$1;

    invoke-direct {v4, p0, v0, v2}, Lcom/google/android/gms/internal/zzjk$1;-><init>(Lcom/google/android/gms/internal/zzjk;Lcom/google/android/gms/ads/internal/client/AdRequestParcel;Lcom/google/android/gms/internal/zzgo;)V

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_1
    invoke-static {}, Lcom/google/android/gms/ads/internal/zzu;->zzfu()Lcom/google/android/gms/common/util/zze;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/android/gms/common/util/zze;->elapsedRealtime()J

    move-result-wide v2

    invoke-direct {p0, v2, v3}, Lcom/google/android/gms/internal/zzjk;->zzk(J)V

    invoke-virtual {v1, v5}, Lcom/google/android/gms/internal/zzjn;->zza(Lcom/google/android/gms/internal/zzjo;)V

    invoke-virtual {v1, v5}, Lcom/google/android/gms/internal/zzjn;->zza(Lcom/google/android/gms/internal/zzjl;)V

    iget v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchu:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_3

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchr:Lcom/google/android/gms/internal/zzjo;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjk;->zzbog:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/zzjo;->zzch(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    :try_start_1
    sget-object v3, Lcom/google/android/gms/ads/internal/util/client/zza;->zzcnf:Landroid/os/Handler;

    new-instance v4, Lcom/google/android/gms/internal/zzjk$2;

    invoke-direct {v4, p0, v2, v0, v1}, Lcom/google/android/gms/internal/zzjk$2;-><init>(Lcom/google/android/gms/internal/zzjk;Lcom/google/android/gms/internal/zzgo;Lcom/google/android/gms/ads/internal/client/AdRequestParcel;Lcom/google/android/gms/internal/zzjn;)V

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    const-string v2, "Fail to check if adapter is initialized."

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/zzkh;->zzd(Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzbog:Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v2}, Lcom/google/android/gms/internal/zzjk;->zza(Ljava/lang/String;I)V

    goto :goto_1

    :cond_3
    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzchr:Lcom/google/android/gms/internal/zzjo;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjk;->zzbog:Ljava/lang/String;

    iget v2, p0, Lcom/google/android/gms/internal/zzjk;->zzbym:I

    invoke-interface {v0, v1, v2}, Lcom/google/android/gms/internal/zzjo;->zza(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method protected zzf(J)Z
    .locals 7

    const/4 v0, 0x0

    const-wide/16 v2, 0x4e20

    invoke-static {}, Lcom/google/android/gms/ads/internal/zzu;->zzfu()Lcom/google/android/gms/common/util/zze;

    move-result-object v1

    invoke-interface {v1}, Lcom/google/android/gms/common/util/zze;->elapsedRealtime()J

    move-result-wide v4

    sub-long/2addr v4, p1

    sub-long/2addr v2, v4

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-gtz v1, :cond_0

    :goto_0
    return v0

    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzjk;->zzail:Ljava/lang/Object;

    invoke-virtual {v1, v2, v3}, Ljava/lang/Object;->wait(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public zzrt()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk;->zzbxv:Lcom/google/android/gms/internal/zzjy$zza;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzjy$zza;->zzcit:Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;

    iget-object v0, v0, Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;->zzcav:Lcom/google/android/gms/ads/internal/client/AdRequestParcel;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjk;->zzchq:Lcom/google/android/gms/internal/zzjq;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzjq;->zzrv()Lcom/google/android/gms/internal/zzgo;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/google/android/gms/internal/zzjk;->zza(Lcom/google/android/gms/ads/internal/client/AdRequestParcel;Lcom/google/android/gms/internal/zzgo;)V

    return-void
.end method
