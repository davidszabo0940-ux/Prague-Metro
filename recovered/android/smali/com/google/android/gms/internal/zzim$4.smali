.class Lcom/google/android/gms/internal/zzim$4;
.super Lcom/google/android/gms/internal/zzil$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzim;->zza(Lcom/google/android/gms/ads/internal/formats/zzh$zza;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzbzo:Lcom/google/android/gms/internal/zzim;

.field final synthetic zzbzt:Lcom/google/android/gms/internal/zzet;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzim;Lcom/google/android/gms/internal/zzet;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzim$4;->zzbzo:Lcom/google/android/gms/internal/zzim;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzim$4;->zzbzt:Lcom/google/android/gms/internal/zzet;

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzil$zza;-><init>()V

    return-void
.end method


# virtual methods
.method public zze(Lcom/google/android/gms/internal/zzfx;)V
    .locals 2

    const-string v0, "/nativeAdCustomClick"

    iget-object v1, p0, Lcom/google/android/gms/internal/zzim$4;->zzbzt:Lcom/google/android/gms/internal/zzet;

    invoke-interface {p1, v0, v1}, Lcom/google/android/gms/internal/zzfx;->zza(Ljava/lang/String;Lcom/google/android/gms/internal/zzet;)V

    return-void
.end method
