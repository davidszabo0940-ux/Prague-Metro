.class public Lcom/google/android/gms/internal/zzfw;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzfw$zza;,
        Lcom/google/android/gms/internal/zzfw$zze;,
        Lcom/google/android/gms/internal/zzfw$zzc;,
        Lcom/google/android/gms/internal/zzfw$zzd;,
        Lcom/google/android/gms/internal/zzfw$zzb;
    }
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final zzail:Ljava/lang/Object;

.field private final zzalm:Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;

.field private final zzblv:Ljava/lang/String;

.field private zzblw:Lcom/google/android/gms/internal/zzkp;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzkp",
            "<",
            "Lcom/google/android/gms/internal/zzft;",
            ">;"
        }
    .end annotation
.end field

.field private zzblx:Lcom/google/android/gms/internal/zzkp;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzkp",
            "<",
            "Lcom/google/android/gms/internal/zzft;",
            ">;"
        }
    .end annotation
.end field

.field private zzbly:Lcom/google/android/gms/internal/zzfw$zzd;

.field private zzblz:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Ljava/lang/String;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzail:Ljava/lang/Object;

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/zzfw;->zzblz:I

    iput-object p3, p0, Lcom/google/android/gms/internal/zzfw;->zzblv:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzfw;->mContext:Landroid/content/Context;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzfw;->zzalm:Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;

    new-instance v0, Lcom/google/android/gms/internal/zzfw$zzb;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzfw$zzb;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzblw:Lcom/google/android/gms/internal/zzkp;

    new-instance v0, Lcom/google/android/gms/internal/zzfw$zzb;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzfw$zzb;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzblx:Lcom/google/android/gms/internal/zzkp;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Ljava/lang/String;Lcom/google/android/gms/internal/zzkp;Lcom/google/android/gms/internal/zzkp;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/internal/zzkp",
            "<",
            "Lcom/google/android/gms/internal/zzft;",
            ">;",
            "Lcom/google/android/gms/internal/zzkp",
            "<",
            "Lcom/google/android/gms/internal/zzft;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gms/internal/zzfw;-><init>(Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Ljava/lang/String;)V

    iput-object p4, p0, Lcom/google/android/gms/internal/zzfw;->zzblw:Lcom/google/android/gms/internal/zzkp;

    iput-object p5, p0, Lcom/google/android/gms/internal/zzfw;->zzblx:Lcom/google/android/gms/internal/zzkp;

    return-void
.end method

.method static synthetic zza(Lcom/google/android/gms/internal/zzfw;I)I
    .locals 0

    iput p1, p0, Lcom/google/android/gms/internal/zzfw;->zzblz:I

    return p1
.end method

.method static synthetic zza(Lcom/google/android/gms/internal/zzfw;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method private zza(Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzfw$zzd;
    .locals 3

    new-instance v0, Lcom/google/android/gms/internal/zzfw$zzd;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfw;->zzblx:Lcom/google/android/gms/internal/zzkp;

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzfw$zzd;-><init>(Lcom/google/android/gms/internal/zzkp;)V

    invoke-static {}, Lcom/google/android/gms/ads/internal/zzu;->zzfq()Lcom/google/android/gms/internal/zzkl;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/internal/zzfw$1;

    invoke-direct {v2, p0, p1, v0}, Lcom/google/android/gms/internal/zzfw$1;-><init>(Lcom/google/android/gms/internal/zzfw;Lcom/google/android/gms/internal/zzas;Lcom/google/android/gms/internal/zzfw$zzd;)V

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzkl;->runOnUiThread(Ljava/lang/Runnable;)V

    return-object v0
.end method

.method static synthetic zza(Lcom/google/android/gms/internal/zzfw;Lcom/google/android/gms/internal/zzfw$zzd;)Lcom/google/android/gms/internal/zzfw$zzd;
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfw;->zzbly:Lcom/google/android/gms/internal/zzfw$zzd;

    return-object p1
.end method

.method static synthetic zzb(Lcom/google/android/gms/internal/zzfw;)Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzalm:Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;

    return-object v0
.end method

.method static synthetic zzc(Lcom/google/android/gms/internal/zzfw;)Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzail:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic zzd(Lcom/google/android/gms/internal/zzfw;)Lcom/google/android/gms/internal/zzkp;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzblw:Lcom/google/android/gms/internal/zzkp;

    return-object v0
.end method

.method static synthetic zze(Lcom/google/android/gms/internal/zzfw;)I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/zzfw;->zzblz:I

    return v0
.end method

.method static synthetic zzf(Lcom/google/android/gms/internal/zzfw;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzblv:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic zzg(Lcom/google/android/gms/internal/zzfw;)Lcom/google/android/gms/internal/zzfw$zzd;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzbly:Lcom/google/android/gms/internal/zzfw$zzd;

    return-object v0
.end method


# virtual methods
.method protected zza(Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzft;
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/zzfv;

    invoke-direct {v0, p1, p2, p3}, Lcom/google/android/gms/internal/zzfv;-><init>(Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Lcom/google/android/gms/internal/zzas;)V

    return-object v0
.end method

.method protected zzb(Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzfw$zzd;
    .locals 3

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzfw;->zza(Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzfw$zzd;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/zzfw$2;

    invoke-direct {v1, p0, v0}, Lcom/google/android/gms/internal/zzfw$2;-><init>(Lcom/google/android/gms/internal/zzfw;Lcom/google/android/gms/internal/zzfw$zzd;)V

    new-instance v2, Lcom/google/android/gms/internal/zzfw$3;

    invoke-direct {v2, p0, v0}, Lcom/google/android/gms/internal/zzfw$3;-><init>(Lcom/google/android/gms/internal/zzfw;Lcom/google/android/gms/internal/zzfw$zzd;)V

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzfw$zzd;->zza(Lcom/google/android/gms/internal/zzle$zzc;Lcom/google/android/gms/internal/zzle$zza;)V

    return-object v0
.end method

.method public zzc(Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzfw$zzc;
    .locals 4

    const/4 v3, 0x2

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfw;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzbly:Lcom/google/android/gms/internal/zzfw$zzd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzbly:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw$zzd;->getStatus()I

    move-result v0

    const/4 v2, -0x1

    if-ne v0, v2, :cond_1

    :cond_0
    const/4 v0, 0x2

    iput v0, p0, Lcom/google/android/gms/internal/zzfw;->zzblz:I

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzfw;->zzb(Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzfw$zzd;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzbly:Lcom/google/android/gms/internal/zzfw$zzd;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzbly:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw$zzd;->zzmd()Lcom/google/android/gms/internal/zzfw$zzc;

    move-result-object v0

    monitor-exit v1

    :goto_0
    return-object v0

    :cond_1
    iget v0, p0, Lcom/google/android/gms/internal/zzfw;->zzblz:I

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzbly:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw$zzd;->zzmd()Lcom/google/android/gms/internal/zzfw$zzc;

    move-result-object v0

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_2
    :try_start_1
    iget v0, p0, Lcom/google/android/gms/internal/zzfw;->zzblz:I

    const/4 v2, 0x1

    if-ne v0, v2, :cond_3

    const/4 v0, 0x2

    iput v0, p0, Lcom/google/android/gms/internal/zzfw;->zzblz:I

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzfw;->zzb(Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzfw$zzd;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzbly:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw$zzd;->zzmd()Lcom/google/android/gms/internal/zzfw$zzc;

    move-result-object v0

    monitor-exit v1

    goto :goto_0

    :cond_3
    iget v0, p0, Lcom/google/android/gms/internal/zzfw;->zzblz:I

    if-ne v0, v3, :cond_4

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzbly:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw$zzd;->zzmd()Lcom/google/android/gms/internal/zzfw$zzc;

    move-result-object v0

    monitor-exit v1

    goto :goto_0

    :cond_4
    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw;->zzbly:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw$zzd;->zzmd()Lcom/google/android/gms/internal/zzfw$zzc;

    move-result-object v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public zzmc()Lcom/google/android/gms/internal/zzfw$zzc;
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/zzfw;->zzc(Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzfw$zzc;

    move-result-object v0

    return-object v0
.end method
