.class Lcom/google/android/gms/internal/zzkr$zzc;
.super Lcom/google/android/gms/internal/zzkz;

# interfaces
.implements Lcom/google/android/gms/internal/zzm$zzb;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzkr;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "zzc"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/google/android/gms/internal/zzkz",
        "<TT;>;",
        "Lcom/google/android/gms/internal/zzm$zzb",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final synthetic zzcmk:Lcom/google/android/gms/internal/zzkr;


# direct methods
.method private constructor <init>(Lcom/google/android/gms/internal/zzkr;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzkr$zzc;->zzcmk:Lcom/google/android/gms/internal/zzkr;

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzkz;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gms/internal/zzkr;Lcom/google/android/gms/internal/zzkr$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzkr$zzc;-><init>(Lcom/google/android/gms/internal/zzkr;)V

    return-void
.end method


# virtual methods
.method public zzb(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    invoke-super {p0, p1}, Lcom/google/android/gms/internal/zzkz;->zzi(Ljava/lang/Object;)V

    return-void
.end method
