.class public final Lcom/google/android/gms/internal/zzgi;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzgi$zza;
    }
.end annotation


# instance fields
.field public final zzboq:I

.field public final zzbor:Lcom/google/android/gms/internal/zzgd;

.field public final zzbos:Lcom/google/android/gms/internal/zzgo;

.field public final zzbot:Ljava/lang/String;

.field public final zzbou:Lcom/google/android/gms/internal/zzgg;

.field public final zzbov:Lcom/google/android/gms/internal/zzgq;

.field public final zzbow:J


# direct methods
.method public constructor <init>(I)V
    .locals 10

    const/4 v2, 0x0

    const-wide/16 v8, 0x0

    move-object v1, p0

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    move v6, p1

    move-object v7, v2

    invoke-direct/range {v1 .. v9}, Lcom/google/android/gms/internal/zzgi;-><init>(Lcom/google/android/gms/internal/zzgd;Lcom/google/android/gms/internal/zzgo;Ljava/lang/String;Lcom/google/android/gms/internal/zzgg;ILcom/google/android/gms/internal/zzgq;J)V

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/internal/zzgd;Lcom/google/android/gms/internal/zzgo;Ljava/lang/String;Lcom/google/android/gms/internal/zzgg;ILcom/google/android/gms/internal/zzgq;J)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzgi;->zzbor:Lcom/google/android/gms/internal/zzgd;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzgi;->zzbos:Lcom/google/android/gms/internal/zzgo;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzgi;->zzbot:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/android/gms/internal/zzgi;->zzbou:Lcom/google/android/gms/internal/zzgg;

    iput p5, p0, Lcom/google/android/gms/internal/zzgi;->zzboq:I

    iput-object p6, p0, Lcom/google/android/gms/internal/zzgi;->zzbov:Lcom/google/android/gms/internal/zzgq;

    iput-wide p7, p0, Lcom/google/android/gms/internal/zzgi;->zzbow:J

    return-void
.end method
