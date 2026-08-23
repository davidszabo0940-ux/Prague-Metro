.class Lcom/google/android/gms/ads/internal/request/zzn$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/ads/internal/request/zzn;->zze(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzcdp:Lcom/google/android/gms/ads/internal/request/zzn;

.field final synthetic zzcdq:Lorg/json/JSONObject;

.field final synthetic zzcdr:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/google/android/gms/ads/internal/request/zzn;Lorg/json/JSONObject;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/ads/internal/request/zzn$2;->zzcdp:Lcom/google/android/gms/ads/internal/request/zzn;

    iput-object p2, p0, Lcom/google/android/gms/ads/internal/request/zzn$2;->zzcdq:Lorg/json/JSONObject;

    iput-object p3, p0, Lcom/google/android/gms/ads/internal/request/zzn$2;->zzcdr:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    iget-object v0, p0, Lcom/google/android/gms/ads/internal/request/zzn$2;->zzcdp:Lcom/google/android/gms/ads/internal/request/zzn;

    invoke-static {}, Lcom/google/android/gms/ads/internal/request/zzn;->zzre()Lcom/google/android/gms/internal/zzfw;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzfw;->zzmc()Lcom/google/android/gms/internal/zzfw$zzc;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/google/android/gms/ads/internal/request/zzn;->zza(Lcom/google/android/gms/ads/internal/request/zzn;Lcom/google/android/gms/internal/zzfw$zzc;)Lcom/google/android/gms/internal/zzfw$zzc;

    iget-object v0, p0, Lcom/google/android/gms/ads/internal/request/zzn$2;->zzcdp:Lcom/google/android/gms/ads/internal/request/zzn;

    invoke-static {v0}, Lcom/google/android/gms/ads/internal/request/zzn;->zzb(Lcom/google/android/gms/ads/internal/request/zzn;)Lcom/google/android/gms/internal/zzfw$zzc;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/ads/internal/request/zzn$2$1;

    invoke-direct {v1, p0}, Lcom/google/android/gms/ads/internal/request/zzn$2$1;-><init>(Lcom/google/android/gms/ads/internal/request/zzn$2;)V

    new-instance v2, Lcom/google/android/gms/ads/internal/request/zzn$2$2;

    invoke-direct {v2, p0}, Lcom/google/android/gms/ads/internal/request/zzn$2$2;-><init>(Lcom/google/android/gms/ads/internal/request/zzn$2;)V

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/zzfw$zzc;->zza(Lcom/google/android/gms/internal/zzle$zzc;Lcom/google/android/gms/internal/zzle$zza;)V

    return-void
.end method
