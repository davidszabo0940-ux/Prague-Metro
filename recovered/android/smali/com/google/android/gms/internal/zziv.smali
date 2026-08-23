.class public final Lcom/google/android/gms/internal/zziv;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation


# instance fields
.field private final zzail:Ljava/lang/Object;

.field private zzbvu:Ljava/lang/String;

.field private zzceq:Ljava/lang/String;

.field private zzcer:Lcom/google/android/gms/internal/zzkz;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/zzkz",
            "<",
            "Lcom/google/android/gms/internal/zziy;",
            ">;"
        }
    .end annotation
.end field

.field zzces:Lcom/google/android/gms/internal/zzfw$zzc;

.field public final zzcet:Lcom/google/android/gms/internal/zzet;

.field public final zzceu:Lcom/google/android/gms/internal/zzet;

.field public final zzcev:Lcom/google/android/gms/internal/zzet;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zziv;->zzail:Ljava/lang/Object;

    new-instance v0, Lcom/google/android/gms/internal/zzkz;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzkz;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zziv;->zzcer:Lcom/google/android/gms/internal/zzkz;

    new-instance v0, Lcom/google/android/gms/internal/zziv$1;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zziv$1;-><init>(Lcom/google/android/gms/internal/zziv;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zziv;->zzcet:Lcom/google/android/gms/internal/zzet;

    new-instance v0, Lcom/google/android/gms/internal/zziv$2;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zziv$2;-><init>(Lcom/google/android/gms/internal/zziv;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zziv;->zzceu:Lcom/google/android/gms/internal/zzet;

    new-instance v0, Lcom/google/android/gms/internal/zziv$3;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zziv$3;-><init>(Lcom/google/android/gms/internal/zziv;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zziv;->zzcev:Lcom/google/android/gms/internal/zzet;

    iput-object p2, p0, Lcom/google/android/gms/internal/zziv;->zzceq:Ljava/lang/String;

    iput-object p1, p0, Lcom/google/android/gms/internal/zziv;->zzbvu:Ljava/lang/String;

    return-void
.end method

.method static synthetic zza(Lcom/google/android/gms/internal/zziv;)Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zziv;->zzail:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic zzb(Lcom/google/android/gms/internal/zziv;)Lcom/google/android/gms/internal/zzkz;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zziv;->zzcer:Lcom/google/android/gms/internal/zzkz;

    return-object v0
.end method

.method static synthetic zzc(Lcom/google/android/gms/internal/zziv;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zziv;->zzbvu:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic zzd(Lcom/google/android/gms/internal/zziv;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zziv;->zzceq:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public zzb(Lcom/google/android/gms/internal/zzfw$zzc;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zziv;->zzces:Lcom/google/android/gms/internal/zzfw$zzc;

    return-void
.end method

.method public zzrh()Lcom/google/android/gms/internal/zzfw$zzc;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zziv;->zzces:Lcom/google/android/gms/internal/zzfw$zzc;

    return-object v0
.end method

.method public zzri()Ljava/util/concurrent/Future;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/google/android/gms/internal/zziy;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zziv;->zzcer:Lcom/google/android/gms/internal/zzkz;

    return-object v0
.end method

.method public zzrj()V
    .locals 0

    return-void
.end method
