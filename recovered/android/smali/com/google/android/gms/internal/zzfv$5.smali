.class Lcom/google/android/gms/internal/zzfv$5;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzfv;->zzbi(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzblm:Ljava/lang/String;

.field final synthetic zzblr:Lcom/google/android/gms/internal/zzfv;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfv;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzfv$5;->zzblr:Lcom/google/android/gms/internal/zzfv;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzfv$5;->zzblm:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfv$5;->zzblr:Lcom/google/android/gms/internal/zzfv;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzfv;->zza(Lcom/google/android/gms/internal/zzfv;)Lcom/google/android/gms/internal/zzll;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfv$5;->zzblm:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/zzll;->loadUrl(Ljava/lang/String;)V

    return-void
.end method
