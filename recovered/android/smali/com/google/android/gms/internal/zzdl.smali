.class public final Lcom/google/android/gms/internal/zzdl;
.super Lcom/google/android/gms/internal/zzdn$zza;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation


# instance fields
.field private final zzbei:Lcom/google/android/gms/ads/internal/zzh;

.field private final zzbej:Ljava/lang/String;
    .annotation build Landroid/support/annotation/Nullable;
    .end annotation
.end field

.field private final zzbek:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/ads/internal/zzh;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p2    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzdn$zza;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzdl;->zzbei:Lcom/google/android/gms/ads/internal/zzh;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzdl;->zzbej:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzdl;->zzbek:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getContent()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzdl;->zzbek:Ljava/lang/String;

    return-object v0
.end method

.method public recordClick()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzdl;->zzbei:Lcom/google/android/gms/ads/internal/zzh;

    invoke-interface {v0}, Lcom/google/android/gms/ads/internal/zzh;->zzei()V

    return-void
.end method

.method public recordImpression()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzdl;->zzbei:Lcom/google/android/gms/ads/internal/zzh;

    invoke-interface {v0}, Lcom/google/android/gms/ads/internal/zzh;->zzej()V

    return-void
.end method

.method public zzi(Lcom/google/android/gms/dynamic/zzd;)V
    .locals 2

    if-nez p1, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzdl;->zzbei:Lcom/google/android/gms/ads/internal/zzh;

    invoke-static {p1}, Lcom/google/android/gms/dynamic/zze;->zzad(Lcom/google/android/gms/dynamic/zzd;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-interface {v1, v0}, Lcom/google/android/gms/ads/internal/zzh;->zzc(Landroid/view/View;)V

    goto :goto_0
.end method

.method public zzkk()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzdl;->zzbej:Ljava/lang/String;

    return-object v0
.end method
