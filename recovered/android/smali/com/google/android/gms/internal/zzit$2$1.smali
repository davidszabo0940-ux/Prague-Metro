.class Lcom/google/android/gms/internal/zzit$2$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzle$zzc;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzit$2;->run()V
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
        "Lcom/google/android/gms/internal/zzfx;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic zzcel:Lcom/google/android/gms/internal/zzdi;

.field final synthetic zzcem:Lcom/google/android/gms/internal/zzit$2;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzit$2;Lcom/google/android/gms/internal/zzdi;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzit$2$1;->zzcem:Lcom/google/android/gms/internal/zzit$2;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzit$2$1;->zzcel:Lcom/google/android/gms/internal/zzdi;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zzb(Lcom/google/android/gms/internal/zzfx;)V
    .locals 5

    iget-object v0, p0, Lcom/google/android/gms/internal/zzit$2$1;->zzcem:Lcom/google/android/gms/internal/zzit$2;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzit$2;->zzakg:Lcom/google/android/gms/internal/zzdk;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzit$2$1;->zzcel:Lcom/google/android/gms/internal/zzdi;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "jsf"

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzdk;->zza(Lcom/google/android/gms/internal/zzdi;[Ljava/lang/String;)Z

    iget-object v0, p0, Lcom/google/android/gms/internal/zzit$2$1;->zzcem:Lcom/google/android/gms/internal/zzit$2;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzit$2;->zzakg:Lcom/google/android/gms/internal/zzdk;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzdk;->zzkh()V

    const-string v0, "/invalidRequest"

    iget-object v1, p0, Lcom/google/android/gms/internal/zzit$2$1;->zzcem:Lcom/google/android/gms/internal/zzit$2;

    iget-object v1, v1, Lcom/google/android/gms/internal/zzit$2;->zzcei:Lcom/google/android/gms/internal/zziv;

    iget-object v1, v1, Lcom/google/android/gms/internal/zziv;->zzcet:Lcom/google/android/gms/internal/zzet;

    invoke-interface {p1, v0, v1}, Lcom/google/android/gms/internal/zzfx;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/zzet;)V

    const-string v0, "/loadAdURL"

    iget-object v1, p0, Lcom/google/android/gms/internal/zzit$2$1;->zzcem:Lcom/google/android/gms/internal/zzit$2;

    iget-object v1, v1, Lcom/google/android/gms/internal/zzit$2;->zzcei:Lcom/google/android/gms/internal/zziv;

    iget-object v1, v1, Lcom/google/android/gms/internal/zziv;->zzceu:Lcom/google/android/gms/internal/zzet;

    invoke-interface {p1, v0, v1}, Lcom/google/android/gms/internal/zzfx;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/zzet;)V

    const-string v0, "/loadAd"

    iget-object v1, p0, Lcom/google/android/gms/internal/zzit$2$1;->zzcem:Lcom/google/android/gms/internal/zzit$2;

    iget-object v1, v1, Lcom/google/android/gms/internal/zzit$2;->zzcei:Lcom/google/android/gms/internal/zziv;

    iget-object v1, v1, Lcom/google/android/gms/internal/zziv;->zzcev:Lcom/google/android/gms/internal/zzet;

    invoke-interface {p1, v0, v1}, Lcom/google/android/gms/internal/zzfx;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/zzet;)V

    :try_start_0
    const-string v0, "AFMA_getAd"

    iget-object v1, p0, Lcom/google/android/gms/internal/zzit$2$1;->zzcem:Lcom/google/android/gms/internal/zzit$2;

    iget-object v1, v1, Lcom/google/android/gms/internal/zzit$2;->zzcek:Ljava/lang/String;

    invoke-interface {p1, v0, v1}, Lcom/google/android/gms/internal/zzfx;->zzj(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Error requesting an ad url"

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/zzkh;->zzb(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public synthetic zzd(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lcom/google/android/gms/internal/zzfx;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzit$2$1;->zzb(Lcom/google/android/gms/internal/zzfx;)V

    return-void
.end method
