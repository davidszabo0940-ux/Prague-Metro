.class Lcom/google/android/gms/internal/zzfq$zza;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/zzfq;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "zza"
.end annotation


# instance fields
.field zzbkz:Lcom/google/android/gms/ads/internal/zzl;

.field zzbla:Lcom/google/android/gms/ads/internal/client/AdRequestParcel;

.field zzblb:Lcom/google/android/gms/internal/zzfm;

.field zzblc:J

.field zzbld:Z

.field zzble:Z

.field final synthetic zzblf:Lcom/google/android/gms/internal/zzfq;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfq;Lcom/google/android/gms/internal/zzfl;)V
    .locals 2

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzblf:Lcom/google/android/gms/internal/zzfq;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/google/android/gms/internal/zzfq;->zza(Lcom/google/android/gms/internal/zzfq;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/google/android/gms/internal/zzfl;->zzbe(Ljava/lang/String;)Lcom/google/android/gms/ads/internal/zzl;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzbkz:Lcom/google/android/gms/ads/internal/zzl;

    new-instance v0, Lcom/google/android/gms/internal/zzfm;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzfm;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzblb:Lcom/google/android/gms/internal/zzfm;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzblb:Lcom/google/android/gms/internal/zzfm;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzbkz:Lcom/google/android/gms/ads/internal/zzl;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzfm;->zzc(Lcom/google/android/gms/ads/internal/zzl;)V

    return-void
.end method

.method constructor <init>(Lcom/google/android/gms/internal/zzfq;Lcom/google/android/gms/internal/zzfl;Lcom/google/android/gms/ads/internal/client/AdRequestParcel;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/zzfq$zza;-><init>(Lcom/google/android/gms/internal/zzfq;Lcom/google/android/gms/internal/zzfl;)V

    iput-object p3, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzbla:Lcom/google/android/gms/ads/internal/client/AdRequestParcel;

    return-void
.end method


# virtual methods
.method zzlx()V
    .locals 2

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzbld:Z

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzbla:Lcom/google/android/gms/ads/internal/client/AdRequestParcel;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzbla:Lcom/google/android/gms/ads/internal/client/AdRequestParcel;

    :goto_1
    invoke-static {v0}, Lcom/google/android/gms/internal/zzfo;->zzj(Lcom/google/android/gms/ads/internal/client/AdRequestParcel;)Lcom/google/android/gms/ads/internal/client/AdRequestParcel;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzbkz:Lcom/google/android/gms/ads/internal/zzl;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/ads/internal/zzl;->zzb(Lcom/google/android/gms/ads/internal/client/AdRequestParcel;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzble:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzbld:Z

    invoke-static {}, Lcom/google/android/gms/ads/internal/zzu;->zzfu()Lcom/google/android/gms/common/util/zze;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/android/gms/common/util/zze;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzblc:J

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzfq$zza;->zzblf:Lcom/google/android/gms/internal/zzfq;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzfq;->zzb(Lcom/google/android/gms/internal/zzfq;)Lcom/google/android/gms/ads/internal/client/AdRequestParcel;

    move-result-object v0

    goto :goto_1
.end method
