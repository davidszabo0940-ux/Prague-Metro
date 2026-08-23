.class Lcom/google/android/gms/internal/zzlm$zzc;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/ads/internal/overlay/zzg;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzlm;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "zzc"
.end annotation


# instance fields
.field private zzcoq:Lcom/google/android/gms/ads/internal/overlay/zzg;

.field private zzcpc:Lcom/google/android/gms/internal/zzll;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzll;Lcom/google/android/gms/ads/internal/overlay/zzg;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzlm$zzc;->zzcpc:Lcom/google/android/gms/internal/zzll;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzlm$zzc;->zzcoq:Lcom/google/android/gms/ads/internal/overlay/zzg;

    return-void
.end method


# virtual methods
.method public onPause()V
    .locals 0

    return-void
.end method

.method public onResume()V
    .locals 0

    return-void
.end method

.method public zzdy()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlm$zzc;->zzcoq:Lcom/google/android/gms/ads/internal/overlay/zzg;

    invoke-interface {v0}, Lcom/google/android/gms/ads/internal/overlay/zzg;->zzdy()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlm$zzc;->zzcpc:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzll;->zzud()V

    return-void
.end method

.method public zzdz()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlm$zzc;->zzcoq:Lcom/google/android/gms/ads/internal/overlay/zzg;

    invoke-interface {v0}, Lcom/google/android/gms/ads/internal/overlay/zzg;->zzdz()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlm$zzc;->zzcpc:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzll;->zzoc()V

    return-void
.end method
