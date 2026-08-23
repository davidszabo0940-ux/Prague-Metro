.class Lcom/google/android/gms/internal/zzfw$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzle$zzc;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzfw;->zzb(Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzfw$zzd;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/internal/zzle$zzc",
        "<",
        "Lcom/google/android/gms/internal/zzft;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic zzbmc:Lcom/google/android/gms/internal/zzfw;

.field final synthetic zzbmj:Lcom/google/android/gms/internal/zzfw$zzd;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfw;Lcom/google/android/gms/internal/zzfw$zzd;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfw$2;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzfw$2;->zzbmj:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzft;)V
    .locals 3

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$2;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzfw;->zzc(Lcom/google/android/gms/internal/zzfw;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$2;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    const/4 v2, 0x0

    invoke-static {v0, v2}, Lcom/google/android/gms/internal/zzfw;->zza(Lcom/google/android/gms/internal/zzfw;I)I

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$2;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzfw;->zzg(Lcom/google/android/gms/internal/zzfw;)Lcom/google/android/gms/internal/zzfw$zzd;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$2;->zzbmj:Lcom/google/android/gms/internal/zzfw$zzd;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzfw$2;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzfw;->zzg(Lcom/google/android/gms/internal/zzfw;)Lcom/google/android/gms/internal/zzfw$zzd;

    move-result-object v2

    if-eq v0, v2, :cond_0

    const-string v0, "New JS engine is loaded, marking previous one as destroyable."

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->v(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$2;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzfw;->zzg(Lcom/google/android/gms/internal/zzfw;)Lcom/google/android/gms/internal/zzfw$zzd;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw$zzd;->zzmf()V

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$2;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzfw$2;->zzbmj:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-static {v0, v2}, Lcom/google/android/gms/internal/zzfw;->zza(Lcom/google/android/gms/internal/zzfw;Lcom/google/android/gms/internal/zzfw$zzd;)Lcom/google/android/gms/internal/zzfw$zzd;

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public synthetic zzd(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lcom/google/android/gms/internal/zzft;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzfw$2;->zza(Lcom/google/android/gms/internal/zzft;)V

    return-void
.end method
