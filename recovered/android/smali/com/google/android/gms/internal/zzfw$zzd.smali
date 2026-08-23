.class public Lcom/google/android/gms/internal/zzfw$zzd;
.super Lcom/google/android/gms/internal/zzlf;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzfw;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "zzd"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/zzlf",
        "<",
        "Lcom/google/android/gms/internal/zzft;",
        ">;"
    }
.end annotation


# instance fields
.field private final zzail:Ljava/lang/Object;

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

.field private zzbmp:Z

.field private zzbmq:I


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzkp;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzkp",
            "<",
            "Lcom/google/android/gms/internal/zzft;",
            ">;)V"
        }
    .end annotation

    const/4 v1, 0x0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzlf;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzail:Ljava/lang/Object;

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzblx:Lcom/google/android/gms/internal/zzkp;

    iput-boolean v1, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmp:Z

    iput v1, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmq:I

    return-void
.end method

.method static synthetic zza(Lcom/google/android/gms/internal/zzfw$zzd;)Lcom/google/android/gms/internal/zzkp;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzblx:Lcom/google/android/gms/internal/zzkp;

    return-object v0
.end method


# virtual methods
.method public zzmd()Lcom/google/android/gms/internal/zzfw$zzc;
    .locals 4

    new-instance v1, Lcom/google/android/gms/internal/zzfw$zzc;

    invoke-direct {v1, p0}, Lcom/google/android/gms/internal/zzfw$zzc;-><init>(Lcom/google/android/gms/internal/zzfw$zzd;)V

    iget-object v2, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzail:Ljava/lang/Object;

    monitor-enter v2

    :try_start_0
    new-instance v0, Lcom/google/android/gms/internal/zzfw$zzd$1;

    invoke-direct {v0, p0, v1}, Lcom/google/android/gms/internal/zzfw$zzd$1;-><init>(Lcom/google/android/gms/internal/zzfw$zzd;Lcom/google/android/gms/internal/zzfw$zzc;)V

    new-instance v3, Lcom/google/android/gms/internal/zzfw$zzd$2;

    invoke-direct {v3, p0, v1}, Lcom/google/android/gms/internal/zzfw$zzd$2;-><init>(Lcom/google/android/gms/internal/zzfw$zzd;Lcom/google/android/gms/internal/zzfw$zzc;)V

    invoke-virtual {p0, v0, v3}, Lcom/google/android/gms/internal/zzfw$zzd;->zza(Lcom/google/android/gms/internal/zzle$zzc;Lcom/google/android/gms/internal/zzle$zza;)V

    iget v0, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmq:I

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzab;->zzbm(Z)V

    iget v0, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmq:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmq:I

    monitor-exit v2

    return-object v1

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected zzme()V
    .locals 3

    const/4 v0, 0x1

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget v2, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmq:I

    if-lt v2, v0, :cond_0

    :goto_0
    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzab;->zzbm(Z)V

    const-string v0, "Releasing 1 reference for JS Engine"

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->v(Ljava/lang/String;)V

    iget v0, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmq:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmq:I

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzfw$zzd;->zzmg()V

    monitor-exit v1

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public zzmf()V
    .locals 3

    const/4 v0, 0x1

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget v2, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmq:I

    if-ltz v2, :cond_0

    :goto_0
    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzab;->zzbm(Z)V

    const-string v0, "Releasing root reference. JS Engine will be destroyed once other references are released."

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->v(Ljava/lang/String;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmp:Z

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzfw$zzd;->zzmg()V

    monitor-exit v1

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected zzmg()V
    .locals 3

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget v0, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmq:I

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzab;->zzbm(Z)V

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmp:Z

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/google/android/gms/internal/zzfw$zzd;->zzbmq:I

    if-nez v0, :cond_1

    const-string v0, "No reference is left (including root). Cleaning up engine."

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->v(Ljava/lang/String;)V

    new-instance v0, Lcom/google/android/gms/internal/zzfw$zzd$3;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzfw$zzd$3;-><init>(Lcom/google/android/gms/internal/zzfw$zzd;)V

    new-instance v2, Lcom/google/android/gms/internal/zzle$zzb;

    invoke-direct {v2}, Lcom/google/android/gms/internal/zzle$zzb;-><init>()V

    invoke-virtual {p0, v0, v2}, Lcom/google/android/gms/internal/zzfw$zzd;->zza(Lcom/google/android/gms/internal/zzle$zzc;Lcom/google/android/gms/internal/zzle$zza;)V

    :goto_1
    monitor-exit v1

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    const-string v0, "There are still references to the engine. Not destroying."

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->v(Ljava/lang/String;)V

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
