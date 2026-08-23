.class public final Lcom/google/android/gms/internal/zzhx;
.super Lcom/google/android/gms/internal/zzhs$zza;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation


# instance fields
.field private final zzawf:Lcom/google/android/gms/ads/purchase/InAppPurchaseListener;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/ads/purchase/InAppPurchaseListener;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzhs$zza;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzhx;->zzawf:Lcom/google/android/gms/ads/purchase/InAppPurchaseListener;

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzhr;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzhx;->zzawf:Lcom/google/android/gms/ads/purchase/InAppPurchaseListener;

    new-instance v1, Lcom/google/android/gms/internal/zzia;

    invoke-direct {v1, p1}, Lcom/google/android/gms/internal/zzia;-><init>(Lcom/google/android/gms/internal/zzhr;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/ads/purchase/InAppPurchaseListener;->onInAppPurchaseRequested(Lcom/google/android/gms/ads/purchase/InAppPurchase;)V

    return-void
.end method
