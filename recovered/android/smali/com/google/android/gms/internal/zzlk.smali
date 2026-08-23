.class public Lcom/google/android/gms/internal/zzlk;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzir;
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final zzbgj:Lcom/google/android/gms/internal/zzll;

.field private zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

.field private final zzcom:Landroid/view/ViewGroup;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/google/android/gms/internal/zzll;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/google/android/gms/internal/zzlk;-><init>(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/google/android/gms/internal/zzll;Lcom/google/android/gms/ads/internal/overlay/zzk;)V

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/google/android/gms/internal/zzll;Lcom/google/android/gms/ads/internal/overlay/zzk;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzlk;->mContext:Landroid/content/Context;

    iput-object p2, p0, Lcom/google/android/gms/internal/zzlk;->zzcom:Landroid/view/ViewGroup;

    iput-object p3, p0, Lcom/google/android/gms/internal/zzlk;->zzbgj:Lcom/google/android/gms/internal/zzll;

    iput-object p4, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    return-void
.end method


# virtual methods
.method public onDestroy()V
    .locals 2

    const-string v0, "onDestroy must be called from the UI thread."

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzab;->zzhj(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    invoke-virtual {v0}, Lcom/google/android/gms/ads/internal/overlay/zzk;->destroy()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzcom:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 1

    const-string v0, "onPause must be called from the UI thread."

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzab;->zzhj(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    invoke-virtual {v0}, Lcom/google/android/gms/ads/internal/overlay/zzk;->pause()V

    :cond_0
    return-void
.end method

.method public zza(IIIIIZ)V
    .locals 9

    const/4 v8, -0x1

    const/4 v7, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzll;->zzut()Lcom/google/android/gms/internal/zzdj;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzdj;->zzkf()Lcom/google/android/gms/internal/zzdk;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzlk;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v1}, Lcom/google/android/gms/internal/zzll;->zzus()Lcom/google/android/gms/internal/zzdi;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "vpr"

    aput-object v3, v2, v7

    invoke-static {v0, v1, v2}, Lcom/google/android/gms/internal/zzdg;->zza(Lcom/google/android/gms/internal/zzdk;Lcom/google/android/gms/internal/zzdi;[Ljava/lang/String;)Z

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzll;->zzut()Lcom/google/android/gms/internal/zzdj;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzdj;->zzkf()Lcom/google/android/gms/internal/zzdk;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/zzdg;->zzb(Lcom/google/android/gms/internal/zzdk;)Lcom/google/android/gms/internal/zzdi;

    move-result-object v6

    new-instance v0, Lcom/google/android/gms/ads/internal/overlay/zzk;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzlk;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/google/android/gms/internal/zzlk;->zzbgj:Lcom/google/android/gms/internal/zzll;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzlk;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v3}, Lcom/google/android/gms/internal/zzll;->zzut()Lcom/google/android/gms/internal/zzdj;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzdj;->zzkf()Lcom/google/android/gms/internal/zzdk;

    move-result-object v5

    move v3, p5

    move v4, p6

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gms/ads/internal/overlay/zzk;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/zzll;IZLcom/google/android/gms/internal/zzdk;Lcom/google/android/gms/internal/zzdi;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzcom:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    new-instance v2, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v2, v8, v8}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1, v7, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/google/android/gms/ads/internal/overlay/zzk;->zzd(IIII)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbgj:Lcom/google/android/gms/internal/zzll;

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzll;->zzuk()Lcom/google/android/gms/internal/zzlm;

    move-result-object v0

    invoke-virtual {v0, v7}, Lcom/google/android/gms/internal/zzlm;->zzak(Z)V

    goto :goto_0
.end method

.method public zze(IIII)V
    .locals 1

    const-string v0, "The underlay may only be modified from the UI thread."

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzab;->zzhj(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/google/android/gms/ads/internal/overlay/zzk;->zzd(IIII)V

    :cond_0
    return-void
.end method

.method public zzuc()Lcom/google/android/gms/ads/internal/overlay/zzk;
    .locals 1

    const-string v0, "getAdVideoUnderlay must be called from the UI thread."

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzab;->zzhj(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzlk;->zzbwj:Lcom/google/android/gms/ads/internal/overlay/zzk;

    return-object v0
.end method
