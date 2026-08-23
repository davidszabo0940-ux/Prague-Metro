.class Lcom/google/android/gms/internal/zzfw$1$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzft$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzfw$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzbmd:Lcom/google/android/gms/internal/zzft;

.field final synthetic zzbme:Lcom/google/android/gms/internal/zzfw$1;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfw$1;Lcom/google/android/gms/internal/zzft;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfw$1$1;->zzbme:Lcom/google/android/gms/internal/zzfw$1;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzfw$1$1;->zzbmd:Lcom/google/android/gms/internal/zzft;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zzmb()V
    .locals 4

    sget-object v0, Lcom/google/android/gms/internal/zzkl;->zzclg:Landroid/os/Handler;

    new-instance v1, Lcom/google/android/gms/internal/zzfw$1$1$1;

    invoke-direct {v1, p0}, Lcom/google/android/gms/internal/zzfw$1$1$1;-><init>(Lcom/google/android/gms/internal/zzfw$1$1;)V

    sget v2, Lcom/google/android/gms/internal/zzfw$zza;->zzbml:I

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method
