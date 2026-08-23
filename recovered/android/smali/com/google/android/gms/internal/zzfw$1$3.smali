.class Lcom/google/android/gms/internal/zzfw$1$3;
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

.field final synthetic zzbmh:Lcom/google/android/gms/internal/zzkw;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfw$1;Lcom/google/android/gms/internal/zzft;Lcom/google/android/gms/internal/zzkw;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfw$1$3;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzfw$1$3;->zzbmd:Lcom/google/android/gms/internal/zzft;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzfw$1$3;->zzbmh:Lcom/google/android/gms/internal/zzkw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzll;Ljava/util/Map;)V
    .locals 4
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

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$3;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzfw;->zzc(Lcom/google/android/gms/internal/zzfw;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    :try_start_0
    const-string v0, "JS Engine is requesting an update"

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->zzcx(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$3;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzfw;->zze(Lcom/google/android/gms/internal/zzfw;)I

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "Starting reload."

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->zzcx(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$3;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    const/4 v2, 0x2

    invoke-static {v0, v2}, Lcom/google/android/gms/internal/zzfw;->zza(Lcom/google/android/gms/internal/zzfw;I)I

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$3;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzfw$1$3;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzfw$1;->zzbma:Lcom/google/android/gms/internal/zzas;

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzfw;->zzb(Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzfw$zzd;

    :cond_0
    iget-object v2, p0, Lcom/google/android/gms/internal/zzfw$1$3;->zzbmd:Lcom/google/android/gms/internal/zzft;

    const-string v3, "/requestReload"

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$3;->zzbmh:Lcom/google/android/gms/internal/zzkw;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzkw;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzet;

    invoke-interface {v2, v3, v0}, Lcom/google/android/gms/internal/zzft;->zzb(Ljava/lang/String;Lcom/google/android/gms/internal/zzet;)V

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
