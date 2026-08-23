.class Lcom/google/android/gms/internal/zzim$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzim;->zzf(Lorg/json/JSONObject;)Lcom/google/android/gms/internal/zzim$zza;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzbzo:Lcom/google/android/gms/internal/zzim;

.field final synthetic zzbzq:Lcom/google/android/gms/internal/zzkz;

.field final synthetic zzbzr:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzim;Lcom/google/android/gms/internal/zzkz;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzim$2;->zzbzo:Lcom/google/android/gms/internal/zzim;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzim$2;->zzbzq:Lcom/google/android/gms/internal/zzkz;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzim$2;->zzbzr:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    iget-object v1, p0, Lcom/google/android/gms/internal/zzim$2;->zzbzq:Lcom/google/android/gms/internal/zzkz;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzim$2;->zzbzo:Lcom/google/android/gms/internal/zzim;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzim;->zzb(Lcom/google/android/gms/internal/zzim;)Lcom/google/android/gms/ads/internal/zzq;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/ads/internal/zzq;->zzfb()Landroid/support/v4/util/SimpleArrayMap;

    move-result-object v0

    iget-object v2, p0, Lcom/google/android/gms/internal/zzim$2;->zzbzr:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/support/v4/util/SimpleArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzeh;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzkz;->zzi(Ljava/lang/Object;)V

    return-void
.end method
