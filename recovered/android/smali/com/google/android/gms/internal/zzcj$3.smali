.class Lcom/google/android/gms/internal/zzcj$3;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzle$zzc;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzcj;-><init>(Landroid/content/Context;Lcom/google/android/gms/ads/internal/client/AdSizeParcel;Lcom/google/android/gms/internal/zzjy;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Lcom/google/android/gms/internal/zzck;Lcom/google/android/gms/internal/zzfw;)V
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
.field final synthetic zzarr:Lcom/google/android/gms/internal/zzcj;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzcj;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzcj$3;->zzarr:Lcom/google/android/gms/internal/zzcj;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zzb(Lcom/google/android/gms/internal/zzfx;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcj$3;->zzarr:Lcom/google/android/gms/internal/zzcj;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzcj;->zza(Lcom/google/android/gms/internal/zzcj;Z)Z

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcj$3;->zzarr:Lcom/google/android/gms/internal/zzcj;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzcj;->zzc(Lcom/google/android/gms/internal/zzfx;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcj$3;->zzarr:Lcom/google/android/gms/internal/zzcj;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzcj;->zzgw()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzcj$3;->zzarr:Lcom/google/android/gms/internal/zzcj;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzcj;->zzk(I)V

    return-void
.end method

.method public synthetic zzd(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lcom/google/android/gms/internal/zzfx;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzcj$3;->zzb(Lcom/google/android/gms/internal/zzfx;)V

    return-void
.end method
