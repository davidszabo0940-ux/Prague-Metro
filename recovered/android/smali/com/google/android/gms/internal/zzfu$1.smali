.class Lcom/google/android/gms/internal/zzfu$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzfu;->zza(Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Ljava/lang/String;Lcom/google/android/gms/internal/zzas;)Ljava/util/concurrent/Future;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzaky:Landroid/content/Context;

.field final synthetic zzblj:Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;

.field final synthetic zzblk:Lcom/google/android/gms/internal/zzfu$zza;

.field final synthetic zzbll:Lcom/google/android/gms/internal/zzas;

.field final synthetic zzblm:Ljava/lang/String;

.field final synthetic zzbln:Lcom/google/android/gms/internal/zzfu;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfu;Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Lcom/google/android/gms/internal/zzfu$zza;Lcom/google/android/gms/internal/zzas;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfu$1;->zzbln:Lcom/google/android/gms/internal/zzfu;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzfu$1;->zzaky:Landroid/content/Context;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzfu$1;->zzblj:Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;

    iput-object p4, p0, Lcom/google/android/gms/internal/zzfu$1;->zzblk:Lcom/google/android/gms/internal/zzfu$zza;

    iput-object p5, p0, Lcom/google/android/gms/internal/zzfu$1;->zzbll:Lcom/google/android/gms/internal/zzas;

    iput-object p6, p0, Lcom/google/android/gms/internal/zzfu$1;->zzblm:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfu$1;->zzbln:Lcom/google/android/gms/internal/zzfu;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfu$1;->zzaky:Landroid/content/Context;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzfu$1;->zzblj:Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzfu$1;->zzblk:Lcom/google/android/gms/internal/zzfu$zza;

    iget-object v4, p0, Lcom/google/android/gms/internal/zzfu$1;->zzbll:Lcom/google/android/gms/internal/zzas;

    invoke-static {v0, v1, v2, v3, v4}, Lcom/google/android/gms/internal/zzfu;->zza(Lcom/google/android/gms/internal/zzfu;Landroid/content/Context;Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;Lcom/google/android/gms/internal/zzfu$zza;Lcom/google/android/gms/internal/zzas;)Lcom/google/android/gms/internal/zzft;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfu$1;->zzblm:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/zzft;->zzbi(Ljava/lang/String;)V

    return-void
.end method
