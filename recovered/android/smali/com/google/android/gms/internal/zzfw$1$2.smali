.class Lcom/google/android/gms/internal/zzfw$1$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzet;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzfw$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzbmd:Lcom/google/android/gms/internal/zzft;

.field final synthetic zzbme:Lcom/google/android/gms/internal/zzfw$1;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfw$1;Lcom/google/android/gms/internal/zzft;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfw$1$2;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzfw$1$2;->zzbmd:Lcom/google/android/gms/internal/zzft;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzll;Ljava/util/Map;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzll;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$2;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzfw;->zzc(Lcom/google/android/gms/internal/zzfw;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$2;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1;->zzbmb:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw$zzd;->getStatus()I

    move-result v0

    const/4 v2, -0x1

    if-eq v0, v2, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$2;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1;->zzbmb:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw$zzd;->getStatus()I

    move-result v0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_1

    :cond_0
    monitor-exit v1

    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$2;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    const/4 v2, 0x0

    invoke-static {v0, v2}, Lcom/google/android/gms/internal/zzfw;->zza(Lcom/google/android/gms/internal/zzfw;I)I

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$2;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzfw;->zzd(Lcom/google/android/gms/internal/zzfw;)Lcom/google/android/gms/internal/zzkp;

    move-result-object v0

    iget-object v2, p0, Lcom/google/android/gms/internal/zzfw$1$2;->zzbmd:Lcom/google/android/gms/internal/zzft;

    invoke-interface {v0, v2}, Lcom/google/android/gms/internal/zzkp;->zzd(Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$2;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1;->zzbmb:Lcom/google/android/gms/internal/zzfw$zzd;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzfw$1$2;->zzbmd:Lcom/google/android/gms/internal/zzft;

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzfw$zzd;->zzg(Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$2;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzfw$1$2;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzfw$1;->zzbmb:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-static {v0, v2}, Lcom/google/android/gms/internal/zzfw;->zza(Lcom/google/android/gms/internal/zzfw;Lcom/google/android/gms/internal/zzfw$zzd;)Lcom/google/android/gms/internal/zzfw$zzd;

    const-string v0, "Successfully loaded JS Engine."

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->v(Ljava/lang/String;)V

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
