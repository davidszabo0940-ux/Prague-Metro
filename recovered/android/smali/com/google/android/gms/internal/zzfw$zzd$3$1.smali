.class Lcom/google/android/gms/internal/zzfw$zzd$3$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzfw$zzd$3;->zza(Lcom/google/android/gms/internal/zzft;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzbmt:Lcom/google/android/gms/internal/zzft;

.field final synthetic zzbmu:Lcom/google/android/gms/internal/zzfw$zzd$3;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfw$zzd$3;Lcom/google/android/gms/internal/zzft;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfw$zzd$3$1;->zzbmu:Lcom/google/android/gms/internal/zzfw$zzd$3;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzfw$zzd$3$1;->zzbmt:Lcom/google/android/gms/internal/zzft;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$zzd$3$1;->zzbmu:Lcom/google/android/gms/internal/zzfw$zzd$3;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzfw$zzd$3;->zzbms:Lcom/google/android/gms/internal/zzfw$zzd;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzfw$zzd;->zza(Lcom/google/android/gms/internal/zzfw$zzd;)Lcom/google/android/gms/internal/zzkp;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfw$zzd$3$1;->zzbmt:Lcom/google/android/gms/internal/zzft;

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/zzkp;->zzd(Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$zzd$3$1;->zzbmt:Lcom/google/android/gms/internal/zzft;

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzft;->destroy()V

    return-void
.end method
