.class final Lcom/google/android/gms/internal/zzkj$3;
.super Lcom/google/android/gms/internal/zzkj$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/internal/zzkj;->zza(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/concurrent/Future;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzaky:Landroid/content/Context;

.field final synthetic zzckt:Ljava/lang/String;

.field final synthetic zzcku:J


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;J)V
    .locals 1

    iput-object p1, p0, Lcom/google/android/gms/internal/zzkj$3;->zzaky:Landroid/content/Context;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzkj$3;->zzckt:Ljava/lang/String;

    iput-wide p3, p0, Lcom/google/android/gms/internal/zzkj$3;->zzcku:J

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/zzkj$zza;-><init>(Lcom/google/android/gms/internal/zzkj$1;)V

    return-void
.end method


# virtual methods
.method public zzew()V
    .locals 4

    iget-object v0, p0, Lcom/google/android/gms/internal/zzkj$3;->zzaky:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkj;->zzn(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "app_settings_json"

    iget-object v2, p0, Lcom/google/android/gms/internal/zzkj$3;->zzckt:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    const-string v1, "app_settings_last_update_ms"

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzkj$3;->zzcku:J

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    return-void
.end method
