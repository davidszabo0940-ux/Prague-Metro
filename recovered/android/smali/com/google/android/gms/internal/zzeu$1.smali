.class Lcom/google/android/gms/internal/zzeu$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzeu;->zza(Lcom/google/android/gms/internal/zzll;Ljava/util/Map;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzbgr:Ljava/util/Map;

.field final synthetic zzbii:Lcom/google/android/gms/internal/zzll;

.field final synthetic zzbij:Lcom/google/android/gms/internal/zzeu;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzeu;Ljava/util/Map;Lcom/google/android/gms/internal/zzll;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzeu$1;->zzbij:Lcom/google/android/gms/internal/zzeu;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzeu$1;->zzbgr:Ljava/util/Map;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzeu$1;->zzbii:Lcom/google/android/gms/internal/zzll;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    const-string v0, "Received Http request."

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->zzcw(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzeu$1;->zzbgr:Ljava/util/Map;

    const-string v1, "http_request"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzeu$1;->zzbij:Lcom/google/android/gms/internal/zzeu;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzeu;->zzaw(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, "Response should not be null."

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->e(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    sget-object v1, Lcom/google/android/gms/internal/zzkl;->zzclg:Landroid/os/Handler;

    new-instance v2, Lcom/google/android/gms/internal/zzeu$1$1;

    invoke-direct {v2, p0, v0}, Lcom/google/android/gms/internal/zzeu$1$1;-><init>(Lcom/google/android/gms/internal/zzeu$1;Lorg/json/JSONObject;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method
