.class public Lcom/google/android/gms/internal/zzjq;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation


# instance fields
.field private final zzbok:Lcom/google/android/gms/internal/zzgo;

.field private final zzcif:Lcom/google/android/gms/internal/zzjn;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzgo;Lcom/google/android/gms/internal/zzjm;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzjq;->zzbok:Lcom/google/android/gms/internal/zzgo;

    new-instance v0, Lcom/google/android/gms/internal/zzjn;

    invoke-direct {v0, p2}, Lcom/google/android/gms/internal/zzjn;-><init>(Lcom/google/android/gms/internal/zzjm;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzjq;->zzcif:Lcom/google/android/gms/internal/zzjn;

    return-void
.end method


# virtual methods
.method public zzrv()Lcom/google/android/gms/internal/zzgo;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjq;->zzbok:Lcom/google/android/gms/internal/zzgo;

    return-object v0
.end method

.method public zzrw()Lcom/google/android/gms/internal/zzjn;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjq;->zzcif:Lcom/google/android/gms/internal/zzjn;

    return-object v0
.end method
