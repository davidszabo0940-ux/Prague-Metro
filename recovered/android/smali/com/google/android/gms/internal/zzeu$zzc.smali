.class Lcom/google/android/gms/internal/zzeu$zzc;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzeu;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "zzc"
.end annotation


# instance fields
.field final synthetic zzbij:Lcom/google/android/gms/internal/zzeu;

.field private final zzbiq:Lcom/google/android/gms/internal/zzeu$zzd;

.field private final zzbir:Z

.field private final zzbis:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzeu;ZLcom/google/android/gms/internal/zzeu$zzd;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzeu$zzc;->zzbij:Lcom/google/android/gms/internal/zzeu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean p2, p0, Lcom/google/android/gms/internal/zzeu$zzc;->zzbir:Z

    iput-object p3, p0, Lcom/google/android/gms/internal/zzeu$zzc;->zzbiq:Lcom/google/android/gms/internal/zzeu$zzd;

    iput-object p4, p0, Lcom/google/android/gms/internal/zzeu$zzc;->zzbis:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getReason()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzeu$zzc;->zzbis:Ljava/lang/String;

    return-object v0
.end method

.method public isSuccess()Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzeu$zzc;->zzbir:Z

    return v0
.end method

.method public zzlk()Lcom/google/android/gms/internal/zzeu$zzd;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzeu$zzc;->zzbiq:Lcom/google/android/gms/internal/zzeu$zzd;

    return-object v0
.end method
