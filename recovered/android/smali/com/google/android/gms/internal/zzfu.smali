.class public Lcom/google/android/gms/internal/zzfu;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzfu$zza;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private zza(Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Lcom/google/android/gms/internal/zzfu$zza;Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzft;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;",
            "Lcom/google/android/gms/internal/zzfu$zza",
            "<",
            "Lcom/google/android/gms/internal/zzft;",
            ">;",
            "Lcom/google/android/gms/internal/zzas;",
            ")",
            "Lcom/google/android/gms/internal/zzft;"
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/internal/zzfv;

    invoke-direct {v0, p1, p2, p4}, Lcom/google/android/gms/internal/zzfv;-><init>(Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Lcom/google/android/gms/internal/zzas;)V

    iput-object v0, p3, Lcom/google/android/gms/internal/zzfu$zza;->zzblo:Ljava/lang/Object;

    new-instance v1, Lcom/google/android/gms/internal/zzfu$2;

    invoke-direct {v1, p0, p3}, Lcom/google/android/gms/internal/zzfu$2;-><init>(Lcom/google/android/gms/internal/zzfu;Lcom/google/android/gms/internal/zzfu$zza;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/zzft;->zza(Lcom/google/android/gms/internal/zzft$zza;)V

    return-object v0
.end method

.method static synthetic zza(Lcom/google/android/gms/internal/zzfu;Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Lcom/google/android/gms/internal/zzfu$zza;Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzft;
    .locals 1

    invoke-direct {p0, p1, p2, p3, p4}, Lcom/google/android/gms/internal/zzfu;->zza(Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Lcom/google/android/gms/internal/zzfu$zza;Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzft;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public zza(Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Ljava/lang/String;Lcom/google/android/gms/internal/zzas;)Ljava/util/concurrent/Future;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/internal/zzas;",
            ")",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/google/android/gms/internal/zzft;",
            ">;"
        }
    .end annotation

    new-instance v4, Lcom/google/android/gms/internal/zzfu$zza;

    const/4 v0, 0x0

    invoke-direct {v4, v0}, Lcom/google/android/gms/internal/zzfu$zza;-><init>(Lcom/google/android/gms/internal/zzfu$1;)V

    sget-object v7, Lcom/google/android/gms/internal/zzkl;->zzclg:Landroid/os/Handler;

    new-instance v0, Lcom/google/android/gms/internal/zzfu$1;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v5, p4

    move-object v6, p3

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gms/internal/zzfu$1;-><init>(Lcom/google/android/gms/internal/zzfu;Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Lcom/google/android/gms/internal/zzfu$zza;Lcom/google/android/gms/internal/zzas;Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-object v4
.end method
