.class public Lcom/google/android/gms/internal/zzfw$zze;
.super Lcom/google/android/gms/internal/zzlf;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzfw;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "zze"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/zzlf",
        "<",
        "Lcom/google/android/gms/internal/zzfx;",
        ">;"
    }
.end annotation


# instance fields
.field private zzbmv:Lcom/google/android/gms/internal/zzfw$zzc;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzfw$zzc;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzlf;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfw$zze;->zzbmv:Lcom/google/android/gms/internal/zzfw$zzc;

    return-void
.end method


# virtual methods
.method public finalize()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$zze;->zzbmv:Lcom/google/android/gms/internal/zzfw$zzc;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw$zzc;->release()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzfw$zze;->zzbmv:Lcom/google/android/gms/internal/zzfw$zzc;

    return-void
.end method

.method public getStatus()I
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$zze;->zzbmv:Lcom/google/android/gms/internal/zzfw$zzc;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw$zzc;->getStatus()I

    move-result v0

    return v0
.end method

.method public reject()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$zze;->zzbmv:Lcom/google/android/gms/internal/zzfw$zzc;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw$zzc;->reject()V

    return-void
.end method

.method public zza(Lcom/google/android/gms/internal/zzle$zzc;Lcom/google/android/gms/internal/zzle$zza;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzle$zzc",
            "<",
            "Lcom/google/android/gms/internal/zzfx;",
            ">;",
            "Lcom/google/android/gms/internal/zzle$zza;",
            ")V"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$zze;->zzbmv:Lcom/google/android/gms/internal/zzfw$zzc;

    invoke-virtual {v0, p1, p2}, Lcom/google/android/gms/internal/zzfw$zzc;->zza(Lcom/google/android/gms/internal/zzle$zzc;Lcom/google/android/gms/internal/zzle$zza;)V

    return-void
.end method

.method public zzf(Lcom/google/android/gms/internal/zzfx;)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$zze;->zzbmv:Lcom/google/android/gms/internal/zzfw$zzc;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzfw$zzc;->zzg(Ljava/lang/Object;)V

    return-void
.end method

.method public synthetic zzg(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lcom/google/android/gms/internal/zzfx;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzfw$zze;->zzf(Lcom/google/android/gms/internal/zzfx;)V

    return-void
.end method
