.class Lcom/google/android/gms/internal/zzjp$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzjp;->zzew()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzakq:Lcom/google/android/gms/internal/zzjy;

.field final synthetic zzcie:Lcom/google/android/gms/internal/zzjp;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzjp;Lcom/google/android/gms/internal/zzjy;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzjp$1;->zzcie:Lcom/google/android/gms/internal/zzjp;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzjp$1;->zzakq:Lcom/google/android/gms/internal/zzjy;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjp$1;->zzcie:Lcom/google/android/gms/internal/zzjp;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzjp;->zza(Lcom/google/android/gms/internal/zzjp;)Lcom/google/android/gms/internal/zzjj;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjp$1;->zzakq:Lcom/google/android/gms/internal/zzjy;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzjj;->zzb(Lcom/google/android/gms/internal/zzjy;)V

    return-void
.end method
