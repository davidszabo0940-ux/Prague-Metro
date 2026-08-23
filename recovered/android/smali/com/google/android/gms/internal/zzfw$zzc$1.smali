.class Lcom/google/android/gms/internal/zzfw$zzc$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzle$zzc;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzfw$zzc;->release()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/internal/zzle$zzc",
        "<",
        "Lcom/google/android/gms/internal/zzfx;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic zzbmo:Lcom/google/android/gms/internal/zzfw$zzc;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfw$zzc;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfw$zzc$1;->zzbmo:Lcom/google/android/gms/internal/zzfw$zzc;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zzb(Lcom/google/android/gms/internal/zzfx;)V
    .locals 1

    const-string v0, "Ending javascript session."

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->v(Ljava/lang/String;)V

    check-cast p1, Lcom/google/android/gms/internal/zzfy;

    invoke-interface {p1}, Lcom/google/android/gms/internal/zzfy;->zzmh()V

    return-void
.end method

.method public synthetic zzd(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lcom/google/android/gms/internal/zzfx;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzfw$zzc$1;->zzb(Lcom/google/android/gms/internal/zzfx;)V

    return-void
.end method
