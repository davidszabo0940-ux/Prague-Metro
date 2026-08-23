.class Lcom/google/android/gms/internal/zzjk$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzjk;->zzew()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzalo:Lcom/google/android/gms/ads/internal/client/AdRequestParcel;

.field final synthetic zzchv:Lcom/google/android/gms/internal/zzgo;

.field final synthetic zzchw:Lcom/google/android/gms/internal/zzjk;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzjk;Lcom/google/android/gms/ads/internal/client/AdRequestParcel;Lcom/google/android/gms/internal/zzgo;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzjk$1;->zzchw:Lcom/google/android/gms/internal/zzjk;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzjk$1;->zzalo:Lcom/google/android/gms/ads/internal/client/AdRequestParcel;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzjk$1;->zzchv:Lcom/google/android/gms/internal/zzgo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjk$1;->zzchw:Lcom/google/android/gms/internal/zzjk;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjk$1;->zzalo:Lcom/google/android/gms/ads/internal/client/AdRequestParcel;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzjk$1;->zzchv:Lcom/google/android/gms/internal/zzgo;

    invoke-static {v0, v1, v2}, Lcom/google/android/gms/internal/zzjk;->zza(Lcom/google/android/gms/internal/zzjk;Lcom/google/android/gms/ads/internal/client/AdRequestParcel;Lcom/google/android/gms/internal/zzgo;)V

    return-void
.end method
