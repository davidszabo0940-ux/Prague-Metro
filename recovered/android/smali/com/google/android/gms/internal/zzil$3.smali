.class Lcom/google/android/gms/internal/zzil$3;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzkp;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzil;->zzqj()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/internal/zzkp",
        "<",
        "Lcom/google/android/gms/internal/zzft;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic zzbzf:Lcom/google/android/gms/internal/zzil;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzil;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzil$3;->zzbzf:Lcom/google/android/gms/internal/zzil;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzft;)V
    .locals 10

    const/4 v6, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzil$3;->zzbzf:Lcom/google/android/gms/internal/zzil;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzil;->zza(Lcom/google/android/gms/internal/zzil;)Lcom/google/android/gms/ads/internal/zzq;

    move-result-object v1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzil$3;->zzbzf:Lcom/google/android/gms/internal/zzil;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzil;->zza(Lcom/google/android/gms/internal/zzil;)Lcom/google/android/gms/ads/internal/zzq;

    move-result-object v2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzil$3;->zzbzf:Lcom/google/android/gms/internal/zzil;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzil;->zza(Lcom/google/android/gms/internal/zzil;)Lcom/google/android/gms/ads/internal/zzq;

    move-result-object v3

    iget-object v0, p0, Lcom/google/android/gms/internal/zzil$3;->zzbzf:Lcom/google/android/gms/internal/zzil;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzil;->zza(Lcom/google/android/gms/internal/zzil;)Lcom/google/android/gms/ads/internal/zzq;

    move-result-object v4

    const/4 v5, 0x0

    move-object v0, p1

    move-object v7, v6

    move-object v8, v6

    move-object v9, v6

    invoke-interface/range {v0 .. v9}, Lcom/google/android/gms/internal/zzft;->zza(Lcom/google/android/gms/ads/internal/client/zza;Lcom/google/android/gms/ads/internal/overlay/zzg;Lcom/google/android/gms/internal/zzeo;Lcom/google/android/gms/ads/internal/overlay/zzp;ZLcom/google/android/gms/internal/zzev;Lcom/google/android/gms/internal/zzex;Lcom/google/android/gms/ads/internal/zze;Lcom/google/android/gms/internal/zzhk;)V

    return-void
.end method

.method public synthetic zzd(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lcom/google/android/gms/internal/zzft;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzil$3;->zza(Lcom/google/android/gms/internal/zzft;)V

    return-void
.end method
