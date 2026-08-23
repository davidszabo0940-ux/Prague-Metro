.class public Lcom/google/android/gms/internal/zzek;
.super Lcom/google/android/gms/internal/zzef$zza;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation


# instance fields
.field private final zzbhn:Lcom/google/android/gms/ads/formats/NativeContentAd$OnContentAdLoadedListener;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/ads/formats/NativeContentAd$OnContentAdLoadedListener;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzef$zza;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzek;->zzbhn:Lcom/google/android/gms/ads/formats/NativeContentAd$OnContentAdLoadedListener;

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzea;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzek;->zzbhn:Lcom/google/android/gms/ads/formats/NativeContentAd$OnContentAdLoadedListener;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzek;->zzb(Lcom/google/android/gms/internal/zzea;)Lcom/google/android/gms/internal/zzeb;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/google/android/gms/ads/formats/NativeContentAd$OnContentAdLoadedListener;->onContentAdLoaded(Lcom/google/android/gms/ads/formats/NativeContentAd;)V

    return-void
.end method

.method zzb(Lcom/google/android/gms/internal/zzea;)Lcom/google/android/gms/internal/zzeb;
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/zzeb;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/zzeb;-><init>(Lcom/google/android/gms/internal/zzea;)V

    return-object v0
.end method
