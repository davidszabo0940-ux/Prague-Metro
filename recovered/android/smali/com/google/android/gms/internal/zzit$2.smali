.class final Lcom/google/android/gms/internal/zzit$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzit;->zza(Landroid/content/Context;Lcom/google/android/gms/internal/zzfw;Lcom/google/android/gms/internal/zzcv;Lcom/google/android/gms/internal/zzis;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzakg:Lcom/google/android/gms/internal/zzdk;

.field final synthetic zzaku:Lcom/google/android/gms/internal/zzfw;

.field final synthetic zzcei:Lcom/google/android/gms/internal/zziv;

.field final synthetic zzcej:Lcom/google/android/gms/internal/zzdi;

.field final synthetic zzcek:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzfw;Lcom/google/android/gms/internal/zziv;Lcom/google/android/gms/internal/zzdk;Lcom/google/android/gms/internal/zzdi;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzit$2;->zzaku:Lcom/google/android/gms/internal/zzfw;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzit$2;->zzcei:Lcom/google/android/gms/internal/zziv;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzit$2;->zzakg:Lcom/google/android/gms/internal/zzdk;

    iput-object p4, p0, Lcom/google/android/gms/internal/zzit$2;->zzcej:Lcom/google/android/gms/internal/zzdi;

    iput-object p5, p0, Lcom/google/android/gms/internal/zzit$2;->zzcek:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    iget-object v0, p0, Lcom/google/android/gms/internal/zzit$2;->zzaku:Lcom/google/android/gms/internal/zzfw;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzfw;->zzmc()Lcom/google/android/gms/internal/zzfw$zzc;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzit$2;->zzcei:Lcom/google/android/gms/internal/zziv;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zziv;->zzb(Lcom/google/android/gms/internal/zzfw$zzc;)V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzit$2;->zzakg:Lcom/google/android/gms/internal/zzdk;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzit$2;->zzcej:Lcom/google/android/gms/internal/zzdi;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "rwc"

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/zzdk;->zza(Lcom/google/android/gms/internal/zzdi;[Ljava/lang/String;)Z

    iget-object v1, p0, Lcom/google/android/gms/internal/zzit$2;->zzakg:Lcom/google/android/gms/internal/zzdk;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzdk;->zzkg()Lcom/google/android/gms/internal/zzdi;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/internal/zzit$2$1;

    invoke-direct {v2, p0, v1}, Lcom/google/android/gms/internal/zzit$2$1;-><init>(Lcom/google/android/gms/internal/zzit$2;Lcom/google/android/gms/internal/zzdi;)V

    new-instance v1, Lcom/google/android/gms/internal/zzit$2$2;

    invoke-direct {v1, p0}, Lcom/google/android/gms/internal/zzit$2$2;-><init>(Lcom/google/android/gms/internal/zzit$2;)V

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/internal/zzfw$zzc;->zza(Lcom/google/android/gms/internal/zzle$zzc;Lcom/google/android/gms/internal/zzle$zza;)V

    return-void
.end method
