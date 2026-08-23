.class Lcom/google/android/gms/internal/zzka$zza;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzka;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "zza"
.end annotation


# instance fields
.field private final zzcjm:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final zzcjn:Landroid/os/Bundle;

.field final synthetic zzcjo:Lcom/google/android/gms/internal/zzka;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzka;Ljava/util/List;Landroid/os/Bundle;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    iput-object p1, p0, Lcom/google/android/gms/internal/zzka$zza;->zzcjo:Lcom/google/android/gms/internal/zzka;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Lcom/google/android/gms/internal/zzka$zza;->zzcjm:Ljava/util/List;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzka$zza;->zzcjn:Landroid/os/Bundle;

    return-void
.end method
