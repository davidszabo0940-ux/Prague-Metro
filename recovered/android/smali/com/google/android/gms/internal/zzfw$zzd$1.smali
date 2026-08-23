.class Lcom/google/android/gms/internal/zzfw$zzd$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzle$zzc;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzfw$zzd;->zzmd()Lcom/google/android/gms/internal/zzfw$zzc;
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
        "Lcom/google/android/gms/internal/zzft;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic zzbmr:Lcom/google/android/gms/internal/zzfw$zzc;

.field final synthetic zzbms:Lcom/google/android/gms/internal/zzfw$zzd;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfw$zzd;Lcom/google/android/gms/internal/zzfw$zzc;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfw$zzd$1;->zzbms:Lcom/google/android/gms/internal/zzfw$zzd;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzfw$zzd$1;->zzbmr:Lcom/google/android/gms/internal/zzfw$zzc;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzft;)V
    .locals 2

    const-string v0, "Getting a new session for JS Engine."

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->v(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfw$zzd$1;->zzbmr:Lcom/google/android/gms/internal/zzfw$zzc;

    invoke-interface {p1}, Lcom/google/android/gms/internal/zzft;->zzma()Lcom/google/android/gms/internal/zzfy;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzfw$zzc;->zzg(Ljava/lang/Object;)V

    return-void
.end method

.method public synthetic zzd(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lcom/google/android/gms/internal/zzft;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzfw$zzd$1;->zza(Lcom/google/android/gms/internal/zzft;)V

    return-void
.end method
