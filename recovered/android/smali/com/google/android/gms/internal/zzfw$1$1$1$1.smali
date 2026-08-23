.class Lcom/google/android/gms/internal/zzfw$1$1$1$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzfw$1$1$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzbmg:Lcom/google/android/gms/internal/zzfw$1$1$1;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfw$1$1$1;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfw$1$1$1$1;->zzbmg:Lcom/google/android/gms/internal/zzfw$1$1$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$1$1$1$1;->zzbmg:Lcom/google/android/gms/internal/zzfw$1$1$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1$1$1;->zzbmf:Lcom/google/android/gms/internal/zzfw$1$1;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$1$1;->zzbmd:Lcom/google/android/gms/internal/zzft;

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzft;->destroy()V

    return-void
.end method
