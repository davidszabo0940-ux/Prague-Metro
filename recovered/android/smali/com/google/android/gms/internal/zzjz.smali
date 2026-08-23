.class public Lcom/google/android/gms/internal/zzjz;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzjz$zza;
    }
.end annotation


# instance fields
.field private final zzail:Ljava/lang/Object;

.field private final zzanz:Lcom/google/android/gms/internal/zzkb;

.field private zzcfe:Z

.field private final zzciv:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lcom/google/android/gms/internal/zzjz$zza;",
            ">;"
        }
    .end annotation
.end field

.field private final zzciw:Ljava/lang/String;

.field private final zzcix:Ljava/lang/String;

.field private zzciy:J

.field private zzciz:J

.field private zzcja:J

.field private zzcjb:J

.field private zzcjc:J

.field private zzcjd:J


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzkb;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    const-wide/16 v2, -0x1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzail:Ljava/lang/Object;

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzciy:J

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzciz:J

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzjz;->zzcfe:Z

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcja:J

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/google/android/gms/internal/zzjz;->zzcjb:J

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjc:J

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjd:J

    iput-object p1, p0, Lcom/google/android/gms/internal/zzjz;->zzanz:Lcom/google/android/gms/internal/zzkb;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzjz;->zzciw:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzjz;->zzcix:Ljava/lang/String;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzciv:Ljava/util/LinkedList;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    invoke-static {}, Lcom/google/android/gms/ads/internal/zzu;->zzft()Lcom/google/android/gms/internal/zzkb;

    move-result-object v0

    invoke-direct {p0, v0, p1, p2}, Lcom/google/android/gms/internal/zzjz;-><init>(Lcom/google/android/gms/internal/zzkb;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public toBundle()Landroid/os/Bundle;
    .locals 6

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjz;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    const-string v0, "seq_num"

    iget-object v3, p0, Lcom/google/android/gms/internal/zzjz;->zzciw:Ljava/lang/String;

    invoke-virtual {v2, v0, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "slotid"

    iget-object v3, p0, Lcom/google/android/gms/internal/zzjz;->zzcix:Ljava/lang/String;

    invoke-virtual {v2, v0, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "ismediation"

    iget-boolean v3, p0, Lcom/google/android/gms/internal/zzjz;->zzcfe:Z

    invoke-virtual {v2, v0, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v0, "treq"

    iget-wide v4, p0, Lcom/google/android/gms/internal/zzjz;->zzcjc:J

    invoke-virtual {v2, v0, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    const-string v0, "tresponse"

    iget-wide v4, p0, Lcom/google/android/gms/internal/zzjz;->zzcjd:J

    invoke-virtual {v2, v0, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    const-string v0, "timp"

    iget-wide v4, p0, Lcom/google/android/gms/internal/zzjz;->zzciz:J

    invoke-virtual {v2, v0, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    const-string v0, "tload"

    iget-wide v4, p0, Lcom/google/android/gms/internal/zzjz;->zzcja:J

    invoke-virtual {v2, v0, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    const-string v0, "pcc"

    iget-wide v4, p0, Lcom/google/android/gms/internal/zzjz;->zzcjb:J

    invoke-virtual {v2, v0, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    const-string v0, "tfetch"

    iget-wide v4, p0, Lcom/google/android/gms/internal/zzjz;->zzciy:J

    invoke-virtual {v2, v0, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzciv:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzjz$zza;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzjz$zza;->toBundle()Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    const-string v0, "tclick"

    invoke-virtual {v2, v0, v3}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v2
.end method

.method public zzac(Z)V
    .locals 6

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjz;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjd:J

    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcja:J

    if-nez p1, :cond_0

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcja:J

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzciz:J

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzanz:Lcom/google/android/gms/internal/zzkb;

    invoke-virtual {v0, p0}, Lcom/google/android/gms/internal/zzkb;->zza(Lcom/google/android/gms/internal/zzjz;)V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public zzad(Z)V
    .locals 6

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjz;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjd:J

    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    iput-boolean p1, p0, Lcom/google/android/gms/internal/zzjz;->zzcfe:Z

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzanz:Lcom/google/android/gms/internal/zzkb;

    invoke-virtual {v0, p0}, Lcom/google/android/gms/internal/zzkb;->zza(Lcom/google/android/gms/internal/zzjz;)V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public zzl(J)V
    .locals 7

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjz;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iput-wide p1, p0, Lcom/google/android/gms/internal/zzjz;->zzcjd:J

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjd:J

    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzanz:Lcom/google/android/gms/internal/zzkb;

    invoke-virtual {v0, p0}, Lcom/google/android/gms/internal/zzkb;->zza(Lcom/google/android/gms/internal/zzjz;)V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public zzm(J)V
    .locals 7

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjz;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjd:J

    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    iput-wide p1, p0, Lcom/google/android/gms/internal/zzjz;->zzciy:J

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzanz:Lcom/google/android/gms/internal/zzkb;

    invoke-virtual {v0, p0}, Lcom/google/android/gms/internal/zzkb;->zza(Lcom/google/android/gms/internal/zzjz;)V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public zzq(Lcom/google/android/gms/ads/internal/client/AdRequestParcel;)V
    .locals 4

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjz;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjc:J

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzanz:Lcom/google/android/gms/internal/zzkb;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzkb;->zzsl()Lcom/google/android/gms/internal/zzkc;

    move-result-object v0

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjc:J

    invoke-virtual {v0, p1, v2, v3}, Lcom/google/android/gms/internal/zzkc;->zzb(Lcom/google/android/gms/ads/internal/client/AdRequestParcel;J)V

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public zzrz()V
    .locals 6

    const-wide/16 v4, -0x1

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjz;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjd:J

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzciz:J

    cmp-long v0, v2, v4

    if-nez v0, :cond_0

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzciz:J

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzanz:Lcom/google/android/gms/internal/zzkb;

    invoke-virtual {v0, p0}, Lcom/google/android/gms/internal/zzkb;->zza(Lcom/google/android/gms/internal/zzjz;)V

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzanz:Lcom/google/android/gms/internal/zzkb;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzkb;->zzsl()Lcom/google/android/gms/internal/zzkc;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzkc;->zzrz()V

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public zzsa()V
    .locals 6

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjz;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjd:J

    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    new-instance v0, Lcom/google/android/gms/internal/zzjz$zza;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzjz$zza;-><init>()V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzjz$zza;->zzse()V

    iget-object v2, p0, Lcom/google/android/gms/internal/zzjz;->zzciv:Ljava/util/LinkedList;

    invoke-virtual {v2, v0}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjb:J

    const-wide/16 v4, 0x1

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjb:J

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzanz:Lcom/google/android/gms/internal/zzkb;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzkb;->zzsl()Lcom/google/android/gms/internal/zzkc;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzkc;->zzsa()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzanz:Lcom/google/android/gms/internal/zzkb;

    invoke-virtual {v0, p0}, Lcom/google/android/gms/internal/zzkb;->zza(Lcom/google/android/gms/internal/zzjz;)V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public zzsb()V
    .locals 6

    const-wide/16 v4, -0x1

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjz;->zzail:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-wide v2, p0, Lcom/google/android/gms/internal/zzjz;->zzcjd:J

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzciv:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzciv:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->getLast()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzjz$zza;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzjz$zza;->zzsc()J

    move-result-wide v2

    cmp-long v2, v2, v4

    if-nez v2, :cond_0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzjz$zza;->zzsd()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjz;->zzanz:Lcom/google/android/gms/internal/zzkb;

    invoke-virtual {v0, p0}, Lcom/google/android/gms/internal/zzkb;->zza(Lcom/google/android/gms/internal/zzjz;)V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
