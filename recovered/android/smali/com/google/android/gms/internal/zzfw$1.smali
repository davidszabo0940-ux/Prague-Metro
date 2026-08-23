.class Lcom/google/android/gms/internal/zzfw$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzfw;->zza(Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzfw$zzd;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzbma:Lcom/google/android/gms/internal/zzas;

.field final synthetic zzbmb:Lcom/google/android/gms/internal/zzfw$zzd;

.field final synthetic zzbmc:Lcom/google/android/gms/internal/zzfw;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfw;Lcom/google/android/gms/internal/zzas;Lcom/google/android/gms/internal/zzfw$zzd;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzfw$1;->zzbma:Lcom/google/android/gms/internal/zzas;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzfw$1;->zzbmb:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzfw;->zza(Lcom/google/android/gms/internal/zzfw;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzfw;->zzb(Lcom/google/android/gms/internal/zzfw;)Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gms/internal/zzfw$1;->zzbma:Lcom/google/android/gms/internal/zzas;

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/android/gms/internal/zzfw;->zza(Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzft;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/zzfw$1$1;

    invoke-direct {v1, p0, v0}, Lcom/google/android/gms/internal/zzfw$1$1;-><init>(Lcom/google/android/gms/internal/zzfw$1;Lcom/google/android/gms/internal/zzft;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/zzft;->zza(Lcom/google/android/gms/internal/zzft$zza;)V

    const-string v1, "/jsLoaded"

    new-instance v2, Lcom/google/android/gms/internal/zzfw$1$2;

    invoke-direct {v2, p0, v0}, Lcom/google/android/gms/internal/zzfw$1$2;-><init>(Lcom/google/android/gms/internal/zzfw$1;Lcom/google/android/gms/internal/zzft;)V

    invoke-interface {v0, v1, v2}, Lcom/google/android/gms/internal/zzft;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/zzet;)V

    new-instance v1, Lcom/google/android/gms/internal/zzkw;

    invoke-direct {v1}, Lcom/google/android/gms/internal/zzkw;-><init>()V

    new-instance v2, Lcom/google/android/gms/internal/zzfw$1$3;

    invoke-direct {v2, p0, v0, v1}, Lcom/google/android/gms/internal/zzfw$1$3;-><init>(Lcom/google/android/gms/internal/zzfw$1;Lcom/google/android/gms/internal/zzft;Lcom/google/android/gms/internal/zzkw;)V

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/zzkw;->set(Ljava/lang/Object;)V

    const-string v1, "/requestReload"

    invoke-interface {v0, v1, v2}, Lcom/google/android/gms/internal/zzft;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/zzet;)V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzfw;->zzf(Lcom/google/android/gms/internal/zzfw;)Ljava/lang/String;

    move-result-object v1

    const-string v2, ".js"

    invoke-virtual {v1, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzfw;->zzf(Lcom/google/android/gms/internal/zzfw;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/zzft;->zzbh(Ljava/lang/String;)V

    :goto_0
    sget-object v1, Lcom/google/android/gms/internal/zzkl;->zzclg:Landroid/os/Handler;

    new-instance v2, Lcom/google/android/gms/internal/zzfw$1$4;

    invoke-direct {v2, p0, v0}, Lcom/google/android/gms/internal/zzfw$1$4;-><init>(Lcom/google/android/gms/internal/zzfw$1;Lcom/google/android/gms/internal/zzft;)V

    sget v0, Lcom/google/android/gms/internal/zzfw$zza;->zzbmk:I

    int-to-long v4, v0

    invoke-virtual {v1, v2, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void

    :cond_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzfw;->zzf(Lcom/google/android/gms/internal/zzfw;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "<html>"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzfw;->zzf(Lcom/google/android/gms/internal/zzfw;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/zzft;->zzbj(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    iget-object v1, p0, Lcom/google/android/gms/internal/zzfw$1;->zzbmc:Lcom/google/android/gms/internal/zzfw;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzfw;->zzf(Lcom/google/android/gms/internal/zzfw;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/zzft;->zzbi(Ljava/lang/String;)V

    goto :goto_0
.end method
