.class public Lcom/google/android/gms/internal/zzhi;
.super Lcom/google/android/gms/internal/zzhj;

# interfaces
.implements Lcom/google/android/gms/internal/zzet;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final zzaqk:Landroid/view/WindowManager;

.field private final zzbgj:Lcom/google/android/gms/internal/zzll;

.field private final zzbrg:Lcom/google/android/gms/internal/zzcu;

.field zzbrh:Landroid/util/DisplayMetrics;

.field private zzbri:F

.field zzbrj:I

.field zzbrk:I

.field private zzbrl:I

.field zzbrm:I

.field zzbrn:I

.field zzbro:I

.field zzbrp:I


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzll;Landroid/content/Context;Lcom/google/android/gms/internal/zzcu;)V
    .locals 1

    const/4 v0, -0x1

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzhj;-><init>(Lcom/google/android/gms/internal/zzll;)V

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrj:I

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrk:I

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrm:I

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrn:I

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbro:I

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrp:I

    iput-object p1, p0, Lcom/google/android/gms/internal/zzhi;->zzbgj:Lcom/google/android/gms/internal/zzll;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzhi;->mContext:Landroid/content/Context;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzhi;->zzbrg:Lcom/google/android/gms/internal/zzcu;

    const-string v0, "window"

    invoke-virtual {p2, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    iput-object v0, p0, Lcom/google/android/gms/internal/zzhi;->zzaqk:Landroid/view/WindowManager;

    return-void
.end method

.method private zznb()V
    .locals 2

    new-instance v0, Landroid/util/DisplayMetrics;

    invoke-direct {v0}, Landroid/util/DisplayMetrics;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrh:Landroid/util/DisplayMetrics;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzhi;->zzaqk:Landroid/view/WindowManager;

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbrh:Landroid/util/DisplayMetrics;

    invoke-virtual {v0, v1}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbrh:Landroid/util/DisplayMetrics;

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    iput v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbri:F

    invoke-virtual {v0}, Landroid/view/Display;->getRotation()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrl:I

    return-void
.end method

.method private zzng()V
    .locals 5

    const/4 v0, 0x2

    new-array v0, v0, [I

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v1, v0}, Lcom/google/android/gms/internal/zzll;->getLocationOnScreen([I)V

    invoke-static {}, Lcom/google/android/gms/ads/internal/client/zzm;->zziw()Lcom/google/android/gms/ads/internal/util/client/zza;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzhi;->mContext:Landroid/content/Context;

    const/4 v3, 0x0

    aget v3, v0, v3

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/ads/internal/util/client/zza;->zzb(Landroid/content/Context;I)I

    move-result v1

    invoke-static {}, Lcom/google/android/gms/ads/internal/client/zzm;->zziw()Lcom/google/android/gms/ads/internal/util/client/zza;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gms/internal/zzhi;->mContext:Landroid/content/Context;

    const/4 v4, 0x1

    aget v0, v0, v4

    invoke-virtual {v2, v3, v0}, Lcom/google/android/gms/ads/internal/util/client/zza;->zzb(Landroid/content/Context;I)I

    move-result v0

    invoke-virtual {p0, v1, v0}, Lcom/google/android/gms/internal/zzhi;->zze(II)V

    return-void
.end method

.method private zznj()Lcom/google/android/gms/internal/zzhh;
    .locals 2

    new-instance v0, Lcom/google/android/gms/internal/zzhh$zza;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzhh$zza;-><init>()V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbrg:Lcom/google/android/gms/internal/zzcu;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcu;->zzjp()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzhh$zza;->zzu(Z)Lcom/google/android/gms/internal/zzhh$zza;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbrg:Lcom/google/android/gms/internal/zzcu;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcu;->zzjq()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzhh$zza;->zzt(Z)Lcom/google/android/gms/internal/zzhh$zza;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbrg:Lcom/google/android/gms/internal/zzcu;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcu;->zzju()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzhh$zza;->zzv(Z)Lcom/google/android/gms/internal/zzhh$zza;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbrg:Lcom/google/android/gms/internal/zzcu;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcu;->zzjr()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzhh$zza;->zzw(Z)Lcom/google/android/gms/internal/zzhh$zza;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbrg:Lcom/google/android/gms/internal/zzcu;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzcu;->zzjs()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzhh$zza;->zzx(Z)Lcom/google/android/gms/internal/zzhh$zza;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzhh$zza;->zzna()Lcom/google/android/gms/internal/zzhh;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzll;Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzll;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzhi;->zzne()V

    return-void
.end method

.method public zze(II)V
    .locals 3

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzhi;->mContext:Landroid/content/Context;

    instance-of v0, v0, Landroid/app/Activity;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/google/android/gms/ads/internal/zzu;->zzfq()Lcom/google/android/gms/internal/zzkl;

    move-result-object v2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzhi;->mContext:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzkl;->zzk(Landroid/app/Activity;)[I

    move-result-object v0

    aget v0, v0, v1

    :goto_0
    sub-int v0, p2, v0

    iget v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbro:I

    iget v2, p0, Lcom/google/android/gms/internal/zzhi;->zzbrp:I

    invoke-virtual {p0, p1, v0, v1, v2}, Lcom/google/android/gms/internal/zzhi;->zzc(IIII)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzll;->zzuk()Lcom/google/android/gms/internal/zzlm;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/google/android/gms/internal/zzlm;->zzd(II)V

    return-void

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method zznc()V
    .locals 4

    invoke-static {}, Lcom/google/android/gms/ads/internal/client/zzm;->zziw()Lcom/google/android/gms/ads/internal/util/client/zza;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbrh:Landroid/util/DisplayMetrics;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzhi;->zzbrh:Landroid/util/DisplayMetrics;

    iget v2, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/ads/internal/util/client/zza;->zzb(Landroid/util/DisplayMetrics;I)I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrj:I

    invoke-static {}, Lcom/google/android/gms/ads/internal/client/zzm;->zziw()Lcom/google/android/gms/ads/internal/util/client/zza;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbrh:Landroid/util/DisplayMetrics;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzhi;->zzbrh:Landroid/util/DisplayMetrics;

    iget v2, v2, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/ads/internal/util/client/zza;->zzb(Landroid/util/DisplayMetrics;I)I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrk:I

    iget-object v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzll;->zzuf()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    if-nez v1, :cond_1

    :cond_0
    iget v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrj:I

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrm:I

    iget v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrk:I

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrn:I

    :goto_0
    return-void

    :cond_1
    invoke-static {}, Lcom/google/android/gms/ads/internal/zzu;->zzfq()Lcom/google/android/gms/internal/zzkl;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzkl;->zzh(Landroid/app/Activity;)[I

    move-result-object v0

    invoke-static {}, Lcom/google/android/gms/ads/internal/client/zzm;->zziw()Lcom/google/android/gms/ads/internal/util/client/zza;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzhi;->zzbrh:Landroid/util/DisplayMetrics;

    const/4 v3, 0x0

    aget v3, v0, v3

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/ads/internal/util/client/zza;->zzb(Landroid/util/DisplayMetrics;I)I

    move-result v1

    iput v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbrm:I

    invoke-static {}, Lcom/google/android/gms/ads/internal/client/zzm;->zziw()Lcom/google/android/gms/ads/internal/util/client/zza;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzhi;->zzbrh:Landroid/util/DisplayMetrics;

    const/4 v3, 0x1

    aget v0, v0, v3

    invoke-virtual {v1, v2, v0}, Lcom/google/android/gms/ads/internal/util/client/zza;->zzb(Landroid/util/DisplayMetrics;I)I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrn:I

    goto :goto_0
.end method

.method zznd()V
    .locals 3

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzll;->zzdo()Lcom/google/android/gms/ads/internal/client/AdSizeParcel;

    move-result-object v0

    iget-boolean v0, v0, Lcom/google/android/gms/ads/internal/client/AdSizeParcel;->zzauq:Z

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrj:I

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbro:I

    iget v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrk:I

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrp:I

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v0, v1, v1}, Lcom/google/android/gms/internal/zzll;->measure(II)V

    invoke-static {}, Lcom/google/android/gms/ads/internal/client/zzm;->zziw()Lcom/google/android/gms/ads/internal/util/client/zza;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzhi;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v2}, Lcom/google/android/gms/internal/zzll;->getMeasuredWidth()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/ads/internal/util/client/zza;->zzb(Landroid/content/Context;I)I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbro:I

    invoke-static {}, Lcom/google/android/gms/ads/internal/client/zzm;->zziw()Lcom/google/android/gms/ads/internal/util/client/zza;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzhi;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v2}, Lcom/google/android/gms/internal/zzll;->getMeasuredHeight()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/ads/internal/util/client/zza;->zzb(Landroid/content/Context;I)I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbrp:I

    goto :goto_0
.end method

.method public zzne()V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzhi;->zznb()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzhi;->zznc()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzhi;->zznd()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzhi;->zznh()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzhi;->zzni()V

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzhi;->zzng()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzhi;->zznf()V

    return-void
.end method

.method zznf()V
    .locals 1

    const/4 v0, 0x2

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->zzaz(I)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "Dispatching Ready Event."

    invoke-static {v0}, Lcom/google/android/gms/internal/zzkh;->zzcx(Ljava/lang/String;)V

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzhi;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzll;->zzun()Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;->zzcs:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/zzhi;->zzbv(Ljava/lang/String;)V

    return-void
.end method

.method zznh()V
    .locals 7

    iget v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbrj:I

    iget v2, p0, Lcom/google/android/gms/internal/zzhi;->zzbrk:I

    iget v3, p0, Lcom/google/android/gms/internal/zzhi;->zzbrm:I

    iget v4, p0, Lcom/google/android/gms/internal/zzhi;->zzbrn:I

    iget v5, p0, Lcom/google/android/gms/internal/zzhi;->zzbri:F

    iget v6, p0, Lcom/google/android/gms/internal/zzhi;->zzbrl:I

    move-object v0, p0

    invoke-virtual/range {v0 .. v6}, Lcom/google/android/gms/internal/zzhi;->zza(IIIIFI)V

    return-void
.end method

.method zzni()V
    .locals 3

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzhi;->zznj()Lcom/google/android/gms/internal/zzhh;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzhi;->zzbgj:Lcom/google/android/gms/internal/zzll;

    const-string v2, "onDeviceFeaturesReceived"

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzhh;->toJson()Lorg/json/JSONObject;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/google/android/gms/internal/zzll;->zzb(Ljava/lang/String;Lorg/json/JSONObject;)V

    return-void
.end method
