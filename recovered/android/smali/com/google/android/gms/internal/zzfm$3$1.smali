.class Lcom/google/android/gms/internal/zzfm$3$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzfm$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzfm$3;->zza(Lcom/google/android/gms/internal/zzhr;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzbkc:Lcom/google/android/gms/internal/zzhr;

.field final synthetic zzbkd:Lcom/google/android/gms/internal/zzfm$3;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfm$3;Lcom/google/android/gms/internal/zzhr;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfm$3$1;->zzbkd:Lcom/google/android/gms/internal/zzfm$3;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzfm$3$1;->zzbkc:Lcom/google/android/gms/internal/zzhr;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zzb(Lcom/google/android/gms/internal/zzfn;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    iget-object v0, p1, Lcom/google/android/gms/internal/zzfn;->zzbkm:Lcom/google/android/gms/internal/zzhs;

    if-eqz v0, :cond_0

    iget-object v0, p1, Lcom/google/android/gms/internal/zzfn;->zzbkm:Lcom/google/android/gms/internal/zzhs;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfm$3$1;->zzbkc:Lcom/google/android/gms/internal/zzhr;

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/zzhs;->zza(Lcom/google/android/gms/internal/zzhr;)V

    :cond_0
    return-void
.end method
