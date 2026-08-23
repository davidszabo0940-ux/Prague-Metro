.class public Lcom/google/android/gms/internal/zzds;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzds$zza;
    }
.end annotation


# static fields
.field private static final zzamp:Ljava/lang/Object;

.field private static zzber:Lcom/google/android/gms/internal/zzds;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final zzaoa:Lcom/google/android/gms/common/util/zze;

.field private final zzbes:Lcom/google/android/gms/internal/zzds$zza;

.field private zzbet:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/zzds;->zzamp:Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Lcom/google/android/gms/common/util/zze;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzds;->mContext:Landroid/content/Context;

    new-instance v0, Lcom/google/android/gms/internal/zzds$zza;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzds;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzds$zza;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzds;->zzbes:Lcom/google/android/gms/internal/zzds$zza;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzds;->zzaoa:Lcom/google/android/gms/common/util/zze;

    sget-wide v0, Lcom/google/android/gms/internal/zzdr;->zzbeq:J

    iput-wide v0, p0, Lcom/google/android/gms/internal/zzds;->zzbet:J

    return-void
.end method

.method public static zza(Landroid/content/Context;Lcom/google/android/gms/common/util/zze;)Lcom/google/android/gms/internal/zzds;
    .locals 2

    sget-object v1, Lcom/google/android/gms/internal/zzds;->zzamp:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/google/android/gms/internal/zzds;->zzber:Lcom/google/android/gms/internal/zzds;

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/android/gms/internal/zzds;

    invoke-direct {v0, p0, p1}, Lcom/google/android/gms/internal/zzds;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/util/zze;)V

    sput-object v0, Lcom/google/android/gms/internal/zzds;->zzber:Lcom/google/android/gms/internal/zzds;

    :cond_0
    sget-object v0, Lcom/google/android/gms/internal/zzds;->zzber:Lcom/google/android/gms/internal/zzds;

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private zza(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    .locals 11

    const/4 v8, 0x0

    const/4 v10, 0x1

    const/4 v9, 0x0

    const-string v3, "package = ?"

    :try_start_0
    const-string v1, "directappinstall"

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v4, "path"

    aput-object v4, v2, v0

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p2, v4, v0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p1

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    if-eqz v0, :cond_2

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_1

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    const-string v1, "path"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {}, Lcom/google/android/gms/internal/zzdt;->zzkq()Lcom/google/android/gms/internal/zzdt;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gms/internal/zzds;->mContext:Landroid/content/Context;

    invoke-virtual {v2, v3, v1}, Lcom/google/android/gms/internal/zzdt;->zzd(Landroid/content/Context;Ljava/lang/String;)V

    :cond_0
    const-string v1, "package = ?"

    new-array v2, v10, [Ljava/lang/String;

    aput-object p2, v2, v9

    const-string v3, "directappinstall"

    invoke-virtual {p1, v3, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    :cond_1
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_2
    iget-object v0, p0, Lcom/google/android/gms/internal/zzds;->zzaoa:Lcom/google/android/gms/common/util/zze;

    invoke-interface {v0}, Lcom/google/android/gms/common/util/zze;->currentTimeMillis()J

    move-result-wide v0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzds;->zzkp()J

    move-result-wide v2

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    const-string v1, "timestamp < ?"

    new-array v2, v10, [Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v9

    const-string v0, "directappinstall"

    invoke-virtual {p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    return-void

    :catch_0
    move-exception v0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, 0x46

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v1, "No package name "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " was recorded. Cleaning up records older than one day."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->zzcw(Ljava/lang/String;)V

    move-object v0, v8

    goto :goto_0
.end method

.method private zzkp()J
    .locals 2

    iget-wide v0, p0, Lcom/google/android/gms/internal/zzds;->zzbet:J

    return-wide v0
.end method


# virtual methods
.method public zza(JLjava/lang/String;Ljava/lang/String;)V
    .locals 7

    iget-object v0, p0, Lcom/google/android/gms/internal/zzds;->zzbes:Lcom/google/android/gms/internal/zzds$zza;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzds$zza;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    invoke-direct {p0, v0, p3}, Lcom/google/android/gms/internal/zzds;->zza(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    const-string v2, "reference"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    const-string v2, "package"

    invoke-virtual {v1, v2, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "tracking_url"

    invoke-virtual {v1, v2, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "timestamp"

    iget-object v3, p0, Lcom/google/android/gms/internal/zzds;->zzaoa:Lcom/google/android/gms/common/util/zze;

    invoke-interface {v3}, Lcom/google/android/gms/common/util/zze;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    const-string v2, "directappinstall"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    iget-object v0, p0, Lcom/google/android/gms/internal/zzds;->zzbes:Lcom/google/android/gms/internal/zzds$zza;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzds$zza;->close()V

    return-void
.end method

.method public zzat(Ljava/lang/String;)Z
    .locals 6

    const/4 v1, 0x1

    const/4 v2, 0x0

    const-string v3, "Deleting entry in direct app install log with file path: "

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_0

    invoke-virtual {v3, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->zzcw(Ljava/lang/String;)V

    const-string v0, "path = ?"

    new-array v3, v1, [Ljava/lang/String;

    aput-object p1, v3, v2

    iget-object v4, p0, Lcom/google/android/gms/internal/zzds;->zzbes:Lcom/google/android/gms/internal/zzds$zza;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/zzds$zza;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v4

    const-string v5, "directappinstall"

    invoke-virtual {v4, v5, v0, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    if-lez v0, :cond_1

    move v0, v1

    :goto_1
    iget-object v1, p0, Lcom/google/android/gms/internal/zzds;->zzbes:Lcom/google/android/gms/internal/zzds$zza;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzds$zza;->close()V

    return v0

    :cond_0
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v3}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    move v0, v2

    goto :goto_1
.end method
